package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.util.Log;
import com.lazyswipe.ui.TutorialService;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@TargetApi(21)
public class wu
{
  private static final String a = "Swipe." + wu.class.getSimpleName();
  private static final String[] b = { "android.permission.PACKAGE_USAGE_STATS" };
  private static Field c;

  static
  {
    try
    {
      c = UsageStats.class.getDeclaredField("mLaunchCount");
      c.setAccessible(true);
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      asp.a(a, "Failed to reflect the mLaunchCount field: ", localNoClassDefFoundError);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label57: break label57;
    }
  }

  public static int a(Context paramContext)
  {
    TutorialService.b(paramContext);
    Intent localIntent = asq.f("android.settings.USAGE_ACCESS_SETTINGS");
    localIntent.addFlags(67108864);
    if (asq.d(paramContext, localIntent))
      return 0;
    if (asq.k(paramContext, "android.settings.SECURITY_SETTINGS"))
      return 1;
    if (asq.n(paramContext))
      return 2;
    return -1;
  }

  static long a(UsageStats paramUsageStats)
  {
    try
    {
      paramUsageStats = c.get(paramUsageStats);
      if ((paramUsageStats instanceof Integer))
        return ((Integer)paramUsageStats).intValue();
      if ((paramUsageStats instanceof Long))
      {
        long l = ((Long)paramUsageStats).longValue();
        return l;
      }
    }
    catch (Throwable paramUsageStats)
    {
    }
    return 0L;
  }

  private static Map<String, UsageStats> a(Context paramContext, long paramLong, int paramInt)
  {
    Map localMap = ((UsageStatsManager)paramContext.getSystemService("usagestats")).queryAndAggregateUsageStats(paramLong, System.currentTimeMillis());
    if ((localMap != null) && (localMap.size() > 0))
    {
      if (paramInt == 1);
      for (paramContext = new wv(); ; paramContext = new ww())
      {
        paramContext = new TreeMap(new wx(localMap, paramContext));
        paramContext.putAll(localMap);
        return paramContext;
      }
    }
    return Collections.EMPTY_MAP;
  }

  public static boolean b(Context paramContext)
  {
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    while (true)
    {
      try
      {
        int i = localAppOpsManager.checkOp("android:get_usage_stats", Binder.getCallingUid(), "com.lazyswipe");
        if (i == 0)
          return true;
        if (3 == i)
        {
          paramContext = paramContext.getPackageManager().getPackagesHoldingPermissions(b, 0);
          if (paramContext != null)
          {
            i = paramContext.size();
            break label135;
            if (j >= i)
              break label133;
            boolean bool = "com.lazyswipe".equals(((PackageInfo)paramContext.get(j)).packageName);
            if (bool)
              return true;
          }
          else
          {
            i = 0;
            break label135;
          }
          j += 1;
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        Log.w(a, "Failed to check if we were granted the usage access permission: " + paramContext.getMessage());
      }
      label133: return false;
      label135: int j = 0;
    }
  }

  public static String c(Context paramContext)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).add(13, -5);
    ((Calendar)localObject).add(12, -2);
    Map localMap = a(paramContext, ((Calendar)localObject).getTimeInMillis(), 1);
    if (localMap.size() > 0)
    {
      localObject = (String)((TreeMap)localMap).firstKey();
      UsageStats localUsageStats = (UsageStats)localMap.remove(localObject);
      paramContext = (Context)localObject;
      if (((String)localObject).equals("com.google.android.googlequicksearchbox"))
      {
        paramContext = (Context)localObject;
        if (localUsageStats != null)
        {
          paramContext = (Context)localObject;
          if (!((String)localObject).equals(localUsageStats.getPackageName()))
          {
            paramContext = (Context)localObject;
            if (localMap.size() > 0)
              paramContext = (String)((TreeMap)localMap).firstKey();
          }
        }
      }
      localMap.clear();
      return paramContext;
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wu
 * JD-Core Version:    0.6.2
 */