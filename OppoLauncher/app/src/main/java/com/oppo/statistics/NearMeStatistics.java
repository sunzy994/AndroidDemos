package com.oppo.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.statistics.agent.CommonAgent;
import com.oppo.statistics.agent.DebugAgent;
import com.oppo.statistics.agent.OnEventAgent;
import com.oppo.statistics.agent.PageVisitAgent;
import com.oppo.statistics.agent.SpecialAppStartAgent;
import com.oppo.statistics.storage.PreferenceHandler;
import com.oppo.statistics.util.LogUtil;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NearMeStatistics
{
  private static final Pattern EVENTID_PATTERN = Pattern.compile("^[a-zA-Z0-9\\_\\-]{1,64}$");
  private static PageVisitAgent sPageVisitAgent = new PageVisitAgent();
  private static ExecutorService sSingleThreadExecutor = Executors.newSingleThreadExecutor();

  private static boolean formatCheck(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null)
    {
      LogUtil.e("NearMeStatistics", "EventID is null!");
      return false;
    }
    if (!EVENTID_PATTERN.matcher(paramString1).find())
    {
      LogUtil.e("NearMeStatistics", "EventID format error!");
      return false;
    }
    if (paramString2 == null)
    {
      LogUtil.e("NearMeStatistics", "EventTag format error!");
      return false;
    }
    if ((paramInt > 10000) || (paramInt < 1))
    {
      LogUtil.e("NearMeStatistics", "EventCount format error!");
      return false;
    }
    return true;
  }

  public static void onCommon(Context paramContext, final String paramString, final Map<String, String> paramMap)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onCommon logTag is " + paramString + ",logmap:" + paramMap);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            CommonAgent.recordCommon(this.val$context, paramString, paramMap);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onCommon(Context paramContext, final String paramString, final Map<String, String> paramMap, final boolean paramBoolean)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onCommon logTag is " + paramString + ",logmap:" + paramMap + ",uploadNow:" + paramBoolean);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            CommonAgent.recordCommon(this.val$context, paramString, paramMap, paramBoolean);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onDebug(Context paramContext, final boolean paramBoolean)
  {
    try
    {
      LogUtil.setDebugs(paramBoolean);
      LogUtil.d("NearMeStatistics", "packageName:" + paramContext.getPackageName() + ",isDebug:" + paramBoolean + ",isDebugMode:" + LogUtil.isDebugMode);
      if (LogUtil.isDebugMode)
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            DebugAgent.setDebug(this.val$context, paramBoolean);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onDebug(boolean paramBoolean)
  {
    try
    {
      LogUtil.setDebugs(paramBoolean);
      LogUtil.d("NearMeStatistics", "onDebug (no context) sdk and dcs isDebug:" + paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("NearMeStatistics", localException);
    }
  }

  public static void onDynamicEvent(Context paramContext, final int paramInt1, final int paramInt2, final Map<String, String> paramMap1, final Map<String, String> paramMap2)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onDynamicEvent uploadMode:" + paramInt1 + ",statId:" + paramInt2);
      paramContext = new Runnable()
      {
        public void run()
        {
          OnEventAgent.onDynamicEvent(this.val$context, paramInt1, paramInt2, paramMap1, paramMap2);
        }
      };
      sSingleThreadExecutor.execute(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onError(Context paramContext)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onError...");
      new StatisticsExceptionHandler(paramContext).setStatisticsExceptionHandler();
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEvent(Context paramContext, final String paramString)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEvent eventID:" + paramString);
      if (formatCheck(paramString, "", 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEvent(this.val$context, paramString, "", 1, 0L);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEvent(Context paramContext, final String paramString, final int paramInt)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEvent eventID:" + paramString + ",eventCount:" + paramInt);
      if (formatCheck(paramString, "", paramInt))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEvent(this.val$context, paramString, "", paramInt, 0L);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEvent(Context paramContext, final String paramString1, final String paramString2)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEvent eventID:" + paramString1 + ",eventTag:" + paramString2);
      if (formatCheck(paramString1, paramString2, 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEvent(this.val$context, paramString1, paramString2, 1, 0L);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEvent(Context paramContext, final String paramString1, final String paramString2, final int paramInt)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEvent eventID:" + paramString1 + ",eventCount:" + paramInt + ",eventTag:" + paramString2);
      if (formatCheck(paramString1, paramString2, paramInt))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEvent(this.val$context, paramString1, paramString2, paramInt, 0L);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEvent(Context paramContext, final String paramString1, final String paramString2, final int paramInt, final long paramLong)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEvent eventID:" + paramString1 + ",eventTag:" + paramString2 + ",eventCount:" + paramInt + ",duration:" + paramLong);
      if (formatCheck(paramString1, paramString2, paramInt))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEvent(this.val$context, paramString1, paramString2, paramInt, paramLong);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEventEnd(Context paramContext, final String paramString)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEventEnd eventID:" + paramString);
      if (formatCheck(paramString, "", 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEventEnd(this.val$context, paramString, "");
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEventEnd(Context paramContext, final String paramString1, final String paramString2)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEventEnd eventID:" + paramString1 + ",eventTag:" + paramString2);
      if (formatCheck(paramString1, paramString2, 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEventEnd(this.val$context, paramString1, paramString2);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEventStart(Context paramContext, final String paramString)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEventStart eventID:" + paramString);
      if (formatCheck(paramString, "", 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEventStart(this.val$context, paramString, "");
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onEventStart(Context paramContext, final String paramString1, final String paramString2)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onEventStart eventID:" + paramString1 + ",eventTag:" + paramString2);
      if (formatCheck(paramString1, paramString2, 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onEventStart(this.val$context, paramString1, paramString2);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onKVEvent(Context paramContext, final String paramString, final Map<String, String> paramMap)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onKVEvent eventID:" + paramString + ",eventMap:" + paramMap);
      if (formatCheck(paramString, "", 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onKVEvent(this.val$context, paramString, paramMap, 0L);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onKVEvent(Context paramContext, final String paramString, final Map<String, String> paramMap, final long paramLong)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onKVEvent eventID:" + paramString + ",eventMap:" + paramMap + ",duration:" + paramLong);
      if (formatCheck(paramString, "", 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onKVEvent(this.val$context, paramString, paramMap, paramLong);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onKVEventEnd(Context paramContext, final String paramString)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onKVEventEnd eventID:" + paramString);
      if (formatCheck(paramString, "", 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onKVEventEnd(this.val$context, paramString, "");
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onKVEventEnd(Context paramContext, final String paramString1, final String paramString2)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onKVEventEnd eventID:" + paramString1 + ",eventTag:" + paramString2);
      if (formatCheck(paramString1, paramString2, 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onKVEventEnd(this.val$context, paramString1, paramString2);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onKVEventStart(Context paramContext, final String paramString, final Map<String, String> paramMap)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onKVEventStart eventID:" + paramString + ",eventMap:" + paramMap);
      if (formatCheck(paramString, "", 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onKVEventStart(this.val$context, paramString, paramMap, "");
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onKVEventStart(Context paramContext, final String paramString1, final Map<String, String> paramMap, final String paramString2)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onKVEventStart eventID:" + paramString1 + ",eventTag:" + paramString2 + ",eventMap:" + paramMap);
      if (formatCheck(paramString1, paramString2, 1))
      {
        paramContext = new Runnable()
        {
          public void run()
          {
            OnEventAgent.onKVEventStart(this.val$context, paramString1, paramMap, paramString2);
          }
        };
        sSingleThreadExecutor.execute(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onPause(Context paramContext)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onPause...");
      sPageVisitAgent.onPause(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onResume(Context paramContext)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onResume...");
      sPageVisitAgent.onResume(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void onSpecialAppStart(Context paramContext, int paramInt)
  {
    LogUtil.d("NearMeStatistics", "onSpecialAppStart appCode:" + paramInt);
    SpecialAppStartAgent.onSpecialAppStart(paramContext, paramInt);
  }

  public static void onStaticEvent(Context paramContext, final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final String paramString3, final Map<String, String> paramMap)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onStaticEvent uploadMode:" + paramInt1 + ",statId:" + paramInt2 + ",setId:" + paramString1 + ",setValue:" + paramString2 + ",remark:" + paramString3);
      paramContext = new Runnable()
      {
        public void run()
        {
          OnEventAgent.onStaticEvent(this.val$context, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramMap);
        }
      };
      sSingleThreadExecutor.execute(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  @Deprecated
  public static void onUserAction(final Context paramContext, int paramInt)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onUserAction actionCode:" + paramInt);
      paramContext = new Runnable()
      {
        public void run()
        {
          String str = String.valueOf(this.val$actionCode);
          if (NearMeStatistics.formatCheck(str, "", 1))
            OnEventAgent.onEvent(paramContext, str, "", 1, 0L);
        }
      };
      sSingleThreadExecutor.execute(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  @Deprecated
  public static void onUserAction(final Context paramContext, int paramInt1, final int paramInt2)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "onUserAction actionCode:" + paramInt1 + ",actionMount:" + paramInt2);
      paramContext = new Runnable()
      {
        public void run()
        {
          String str = String.valueOf(this.val$actionCode);
          int i = paramInt2;
          if (NearMeStatistics.formatCheck(str, "", i))
            OnEventAgent.onEvent(paramContext, str, "", i, 0L);
        }
      };
      sSingleThreadExecutor.execute(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void removeSsoID(Context paramContext)
  {
    try
    {
      LogUtil.d("NearMeStatistics", "removeSsoID");
      PreferenceHandler.setSsoID(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void setSessionTimeOut(Context paramContext, int paramInt)
  {
    LogUtil.d("NearMeStatistics", "setSession timeout is " + paramInt);
    if (paramInt > 0);
    try
    {
      PreferenceHandler.setSessionTimeout(paramContext, paramInt);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void setSsoID(Context paramContext, String paramString)
  {
    LogUtil.d("NearMeStatistics", "setSsoid ssoid is " + paramString);
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.equals("null"));
    }
    else
    {
      str = "0";
    }
    try
    {
      PreferenceHandler.setSsoID(paramContext, str);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.NearMeStatistics
 * JD-Core Version:    0.6.2
 */