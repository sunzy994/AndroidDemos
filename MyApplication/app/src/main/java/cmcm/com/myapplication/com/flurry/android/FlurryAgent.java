package cmcm.com.myapplication.com.flurry.android;

import android.content.Context;
import android.location.Criteria;
import android.os.Build.VERSION;
import com.flurry.sdk.cx;
import com.flurry.sdk.dl;
import com.flurry.sdk.dn;
import com.flurry.sdk.dp;
import com.flurry.sdk.dq;
import com.flurry.sdk.dz;
import com.flurry.sdk.el;
import com.flurry.sdk.fb;
import java.util.Date;
import java.util.Map;

public final class FlurryAgent
{
  private static final String a = FlurryAgent.class.getSimpleName();

  public static void addOrigin(String paramString1, String paramString2)
  {
    addOrigin(paramString1, paramString2, null);
  }

  public static void addOrigin(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
      throw new IllegalArgumentException("originName not specified");
    if ((paramString2 == null) || (paramString2.length() == 0))
      throw new IllegalArgumentException("originVersion not specified");
    try
    {
      cx.a().a(paramString1, paramString2, paramMap);
      return;
    }
    catch (Throwable paramString1)
    {
      el.a(a, "", paramString1);
    }
  }

  public static void clearLocation()
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    dz.a().e();
  }

  public static void endTimedEvent(String paramString)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String eventId passed to endTimedEvent was null.");
      return;
    }
    try
    {
      cx.a().b(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      el.a(a, "Failed to signify the end of event: " + paramString, localThrowable);
    }
  }

  public static void endTimedEvent(String paramString, Map<String, String> paramMap)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String eventId passed to endTimedEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      el.b(a, "String eventId passed to endTimedEvent was null.");
      return;
    }
    try
    {
      cx.a().b(paramString, paramMap);
      return;
    }
    catch (Throwable paramMap)
    {
      el.a(a, "Failed to signify the end of event: " + paramString, paramMap);
    }
  }

  public static int getAgentVersion()
  {
    return dn.a().b();
  }

  public static String getReleaseVersion()
  {
    return dn.a().g();
  }

  public static boolean getUseHttps()
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return false;
    }
    return ((Boolean)dp.a().a("UseHttps")).booleanValue();
  }

  public static void logEvent(String paramString)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String eventId passed to logEvent was null.");
      return;
    }
    try
    {
      cx.a().a(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      el.a(a, "Failed to log event: " + paramString, localThrowable);
    }
  }

  public static void logEvent(String paramString, Map<String, String> paramMap)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String eventId passed to logEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      el.b(a, "String parameters passed to logEvent was null.");
      return;
    }
    try
    {
      cx.a().a(paramString, paramMap);
      return;
    }
    catch (Throwable paramMap)
    {
      el.a(a, "Failed to log event: " + paramString, paramMap);
    }
  }

  public static void logEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String eventId passed to logEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      el.b(a, "String parameters passed to logEvent was null.");
      return;
    }
    try
    {
      cx.a().a(paramString, paramMap, paramBoolean);
      return;
    }
    catch (Throwable paramMap)
    {
      el.a(a, "Failed to log event: " + paramString, paramMap);
    }
  }

  public static void logEvent(String paramString, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String eventId passed to logEvent was null.");
      return;
    }
    try
    {
      cx.a().a(paramString, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      el.a(a, "Failed to log event: " + paramString, localThrowable);
    }
  }

  public static void onEndSession(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramContext == null)
      throw new NullPointerException("Null context");
    try
    {
      dl.a().a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      el.a(a, "", paramContext);
    }
  }

  @Deprecated
  public static void onError(String paramString1, String paramString2, String paramString3)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString1 == null)
    {
      el.b(a, "String errorId passed to onError was null.");
      return;
    }
    if (paramString2 == null)
    {
      el.b(a, "String message passed to onError was null.");
      return;
    }
    if (paramString3 == null)
    {
      el.b(a, "String errorClass passed to onError was null.");
      return;
    }
    try
    {
      cx.a().a(paramString1, paramString2, paramString3);
      return;
    }
    catch (Throwable paramString1)
    {
      el.a(a, "", paramString1);
    }
  }

  public static void onError(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString1 == null)
    {
      el.b(a, "String errorId passed to onError was null.");
      return;
    }
    if (paramString2 == null)
    {
      el.b(a, "String message passed to onError was null.");
      return;
    }
    if (paramThrowable == null)
    {
      el.b(a, "Throwable passed to onError was null.");
      return;
    }
    try
    {
      cx.a().a(paramString1, paramString2, paramThrowable);
      return;
    }
    catch (Throwable paramString1)
    {
      el.a(a, "", paramString1);
    }
  }

  @Deprecated
  public static void onEvent(String paramString)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String eventId passed to onEvent was null.");
      return;
    }
    try
    {
      cx.a().c(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      el.a(a, "", paramString);
    }
  }

  @Deprecated
  public static void onEvent(String paramString, Map<String, String> paramMap)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String eventId passed to onEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      el.b(a, "Parameters Map passed to onEvent was null.");
      return;
    }
    try
    {
      cx.a().c(paramString, paramMap);
      return;
    }
    catch (Throwable paramString)
    {
      el.a(a, "", paramString);
    }
  }

  public static void onPageView()
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    try
    {
      cx.a().c();
      return;
    }
    catch (Throwable localThrowable)
    {
      el.a(a, "", localThrowable);
    }
  }

  public static void onStartSession(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramContext == null)
      throw new NullPointerException("Null context");
    if ((paramString == null) || (paramString.length() == 0))
      throw new IllegalArgumentException("Api key not specified");
    try
    {
      dl.a().a(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      el.a(a, "", paramContext);
    }
  }

  public static void setAge(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 10)
      el.b(a, "Device SDK Version older than 10");
    while ((paramInt <= 0) || (paramInt >= 110))
      return;
    long l = new Date(new Date(System.currentTimeMillis() - paramInt * 31449600000L).getYear(), 1, 1).getTime();
    dp.a().a("Age", Long.valueOf(l));
  }

  public static void setCaptureUncaughtExceptions(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    dp.a().a("CaptureUncaughtExceptions", Boolean.valueOf(paramBoolean));
  }

  public static void setContinueSessionMillis(long paramLong)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramLong < 5000L)
    {
      el.b(a, "Invalid time set for session resumption: " + paramLong);
      return;
    }
    dp.a().a("ContinueSessionMillis", Long.valueOf(paramLong));
  }

  public static void setGender(byte paramByte)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    switch (paramByte)
    {
    default:
      dp.a().a("Gender", Byte.valueOf((byte)-1));
      return;
    case 0:
    case 1:
    }
    dp.a().a("Gender", Byte.valueOf(paramByte));
  }

  public static void setLocation(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    dz.a().a(paramFloat1, paramFloat2);
  }

  public static void setLocationCriteria(Criteria paramCriteria)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    dp.a().a("LocationCriteria", paramCriteria);
  }

  public static void setLogEnabled(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramBoolean)
    {
      el.b();
      return;
    }
    el.a();
  }

  public static void setLogEvents(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    dp.a().a("LogEvents", Boolean.valueOf(paramBoolean));
  }

  public static void setLogLevel(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    el.a(paramInt);
  }

  public static void setReportLocation(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    dp.a().a("ReportLocation", Boolean.valueOf(paramBoolean));
  }

  public static void setReportUrl(String paramString)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    dp.a().a("ReportUrl", paramString);
  }

  public static void setUseHttps(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    dp.a().a("UseHttps", Boolean.valueOf(paramBoolean));
  }

  public static void setUserId(String paramString)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String userId passed to setUserId was null.");
      return;
    }
    dp.a().a("UserId", fb.a(paramString));
  }

  public static void setVersionName(String paramString)
  {
    if (Build.VERSION.SDK_INT < 10)
    {
      el.b(a, "Device SDK Version older than 10");
      return;
    }
    if (paramString == null)
    {
      el.b(a, "String versionName passed to setVersionName was null.");
      return;
    }
    dp.a().a("VersionName", paramString);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.android.FlurryAgent
 * JD-Core Version:    0.6.2
 */