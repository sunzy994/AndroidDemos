package com.oppo.statistics.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.oppo.statistics.util.ApkInfoUtil;

public class PreferenceHandler
{
  public static final String ACTIVITY_END_TIME = "activity.end.time";
  public static final String ACTIVITY_START_TIME = "activity.start.time";
  public static final String CURRENT_ACTIVITY = "current.activity";
  public static final String EVENT_START = "event.start";
  public static final String KVEVENT_START = "kv.start";
  public static final String PAGEVISIT_DURATION = "pagevisit.duration";
  public static final String PAGEVISIT_ROUTES = "pagevisit.routes";
  public static final String PAGEVISIT_START_TIME = "pagevisit.start.time";
  public static final String SESSION_TIMEOUT = "session.timeout";
  public static final int SESSION_TIMEOUT_DEFAULT = 30;
  public static final String SSOID = "ssoid";

  public static long getActivityEndTime(Context paramContext)
  {
    long l = -1L;
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
      l = paramContext.getLong("activity.end.time", -1L);
    return l;
  }

  public static long getActivityStartTime(Context paramContext)
  {
    long l = -1L;
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
      l = paramContext.getLong("activity.start.time", -1L);
    return l;
  }

  public static String getCurrentActivity(Context paramContext)
  {
    String str = "";
    SharedPreferences localSharedPreferences = getFunctionPref(paramContext);
    paramContext = str;
    if (localSharedPreferences != null)
      paramContext = localSharedPreferences.getString("current.activity", "");
    return paramContext;
  }

  public static long getEventStart(Context paramContext, String paramString1, String paramString2)
  {
    long l = 0L;
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
      l = paramContext.getLong("event.start" + paramString1 + "_" + paramString2, 0L);
    return l;
  }

  public static SharedPreferences getFunctionPref(Context paramContext)
  {
    SharedPreferences localSharedPreferences = null;
    if (paramContext != null)
      localSharedPreferences = paramContext.getSharedPreferences("nearme_func_" + ApkInfoUtil.getPackageName(paramContext), 0);
    return localSharedPreferences;
  }

  public static String getKVEventStart(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    SharedPreferences localSharedPreferences = getFunctionPref(paramContext);
    paramContext = str;
    if (localSharedPreferences != null)
      paramContext = localSharedPreferences.getString("kv.start" + paramString1 + "_" + paramString2, "");
    return paramContext;
  }

  public static int getPageVisitDuration(Context paramContext)
  {
    int i = -1;
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
      i = paramContext.getInt("pagevisit.duration", 0);
    return i;
  }

  public static String getPageVisitRoutes(Context paramContext)
  {
    String str = "";
    SharedPreferences localSharedPreferences = getFunctionPref(paramContext);
    paramContext = str;
    if (localSharedPreferences != null)
      paramContext = localSharedPreferences.getString("pagevisit.routes", "");
    return paramContext;
  }

  public static long getPageVisitStartTime(Context paramContext)
  {
    long l = 0L;
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
      l = paramContext.getLong("pagevisit.start.time", 0L);
    return l;
  }

  public static int getSessionTimeout(Context paramContext)
  {
    int i = 30;
    paramContext = getSettingPref(paramContext);
    if (paramContext != null)
      i = paramContext.getInt("session.timeout", 30);
    return i;
  }

  public static SharedPreferences getSettingPref(Context paramContext)
  {
    SharedPreferences localSharedPreferences = null;
    if (paramContext != null)
      localSharedPreferences = paramContext.getSharedPreferences("nearme_setting_" + ApkInfoUtil.getPackageName(paramContext), 0);
    return localSharedPreferences;
  }

  public static String getSsoID(Context paramContext)
  {
    String str = "0";
    SharedPreferences localSharedPreferences = getSettingPref(paramContext);
    paramContext = str;
    if (localSharedPreferences != null)
      paramContext = localSharedPreferences.getString("ssoid", "0");
    return paramContext;
  }

  public static void setActivityEndTime(Context paramContext, long paramLong)
  {
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putLong("activity.end.time", paramLong);
      paramContext.commit();
    }
  }

  public static void setActivityStartTime(Context paramContext, long paramLong)
  {
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putLong("activity.start.time", paramLong);
      paramContext.commit();
    }
  }

  public static void setCurrentActivity(Context paramContext, String paramString)
  {
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putString("current.activity", paramString);
      paramContext.commit();
    }
  }

  public static void setEventStart(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putLong("event.start" + paramString1 + "_" + paramString2, paramLong);
      paramContext.commit();
    }
  }

  public static void setKVEventStart(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putString("kv.start" + paramString1 + "_" + paramString3, paramString2);
      paramContext.commit();
    }
  }

  public static void setPageVisitDuration(Context paramContext, int paramInt)
  {
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putInt("pagevisit.duration", paramInt);
      paramContext.commit();
    }
  }

  public static void setPageVisitRoutes(Context paramContext, String paramString)
  {
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putString("pagevisit.routes", paramString);
      paramContext.commit();
    }
  }

  public static void setPageVisitStartTime(Context paramContext, long paramLong)
  {
    paramContext = getFunctionPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putLong("pagevisit.start.time", paramLong);
      paramContext.commit();
    }
  }

  public static void setSessionTimeout(Context paramContext, int paramInt)
  {
    paramContext = getSettingPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putInt("session.timeout", paramInt);
      paramContext.commit();
    }
  }

  public static void setSsoID(Context paramContext)
  {
    paramContext = getSettingPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putString("ssoid", "0");
      paramContext.commit();
    }
  }

  public static void setSsoID(Context paramContext, String paramString)
  {
    paramContext = getSettingPref(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putString("ssoid", paramString);
      paramContext.commit();
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.storage.PreferenceHandler
 * JD-Core Version:    0.6.2
 */