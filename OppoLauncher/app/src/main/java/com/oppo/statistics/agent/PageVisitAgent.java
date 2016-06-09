package com.oppo.statistics.agent;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.statistics.data.PageVisitBean;
import com.oppo.statistics.record.RecordHandler;
import com.oppo.statistics.storage.PreferenceHandler;
import com.oppo.statistics.util.LogUtil;
import com.oppo.statistics.util.TimeInfoUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;

public class PageVisitAgent
{
  private static final int PAUSE = 1;
  private static final int RESUME = 0;
  private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

  private static String getClassName(Context paramContext)
  {
    String str = "";
    if (paramContext != null)
      str = paramContext.getClass().getSimpleName();
    return str;
  }

  private static void recordPageVisit(Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    paramString2 = new PageVisitBean();
    paramString2.setActivities(paramString1);
    paramString2.setDuration(paramLong);
    paramString2.setTime(TimeInfoUtil.getFormatTime());
    RecordHandler.addTask(paramContext, paramString2);
  }

  private static void recordPause(Context paramContext, String paramString, long paramLong)
  {
    long l = PreferenceHandler.getActivityStartTime(paramContext);
    Object localObject = PreferenceHandler.getCurrentActivity(paramContext);
    int i = (int)((paramLong - l) / 1000L);
    if ((paramString.equals(localObject)) && (i >= 0) && (-1L != l));
    try
    {
      localObject = PreferenceHandler.getPageVisitRoutes(paramContext);
      int j = PreferenceHandler.getPageVisitDuration(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject));
      for (localObject = new JSONArray((String)localObject); ; localObject = new JSONArray())
      {
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(paramString);
        localJSONArray.put(i);
        ((JSONArray)localObject).put(localJSONArray);
        PreferenceHandler.setPageVisitDuration(paramContext, j + i);
        PreferenceHandler.setPageVisitRoutes(paramContext, ((JSONArray)localObject).toString());
        PreferenceHandler.setActivityEndTime(paramContext, paramLong);
        return;
      }
    }
    catch (JSONException paramString)
    {
      while (true)
        LogUtil.e("NearMeStatistics", paramString);
    }
  }

  private static void recordResume(Context paramContext, String paramString, long paramLong)
  {
    long l1 = PreferenceHandler.getActivityEndTime(paramContext);
    long l2 = PreferenceHandler.getActivityStartTime(paramContext);
    long l3 = PreferenceHandler.getSessionTimeout(paramContext) * 1000L;
    if ((paramLong - l2 >= l3) && ((-1L == l1) || (l1 >= paramLong) || (paramLong - l1 >= l3)))
    {
      AppStartAgent.recordAppStart(paramContext);
      PreferenceHandler.setPageVisitStartTime(paramContext, System.currentTimeMillis());
      String str = PreferenceHandler.getPageVisitRoutes(paramContext);
      int i = PreferenceHandler.getPageVisitDuration(paramContext);
      if (!TextUtils.isEmpty(str))
        recordPageVisit(paramContext, str, i, "page");
      PreferenceHandler.setPageVisitDuration(paramContext, 0);
      PreferenceHandler.setPageVisitRoutes(paramContext, "");
    }
    PreferenceHandler.setActivityStartTime(paramContext, paramLong);
    PreferenceHandler.setCurrentActivity(paramContext, paramString);
  }

  public void onPause(Context paramContext)
  {
    if (paramContext != null)
    {
      long l = System.currentTimeMillis();
      String str = getClassName(paramContext);
      LogUtil.i("NearMeStatistics", "onPause: " + str);
      paramContext = new HandlePageVisitRunnable(paramContext, str, l, 1);
      this.mExecutorService.execute(paramContext);
      return;
    }
    LogUtil.e("NearMeStatistics", "onPause() called without context.");
  }

  public void onResume(Context paramContext)
  {
    if (paramContext != null)
    {
      long l = System.currentTimeMillis();
      String str = getClassName(paramContext);
      LogUtil.i("NearMeStatistics", "onResume: " + str);
      paramContext = new HandlePageVisitRunnable(paramContext, str, l, 0);
      this.mExecutorService.execute(paramContext);
      return;
    }
    LogUtil.e("NearMeStatistics", "onPause() called without context.");
  }

  private final class HandlePageVisitRunnable
    implements Runnable
  {
    private String mClassName;
    private Context mContext;
    private long mCurrentTimeMills;
    private int mType;

    public HandlePageVisitRunnable(Context paramString, String paramLong, long arg4, int arg6)
    {
      this.mContext = paramString;
      this.mClassName = paramLong;
      this.mCurrentTimeMills = ???;
      int i;
      this.mType = i;
    }

    public void run()
    {
      switch (this.mType)
      {
      default:
        return;
      case 1:
        PageVisitAgent.recordPause(this.mContext, this.mClassName, this.mCurrentTimeMills);
        return;
      case 0:
      }
      PageVisitAgent.recordResume(this.mContext, this.mClassName, this.mCurrentTimeMills);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.agent.PageVisitAgent
 * JD-Core Version:    0.6.2
 */