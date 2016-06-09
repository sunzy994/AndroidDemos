package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.provider.Telephony.Sms;
import android.telephony.TelephonyManager;
import android.util.Log;

public final class asl
{
  @TargetApi(17)
  public static boolean a(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    if (Build.VERSION.SDK_INT >= 17)
      if (Settings.Global.getInt(paramContext, "airplane_mode_on", 0) == 0);
    while (Settings.System.getInt(paramContext, "airplane_mode_on", 0) != 0)
    {
      return true;
      return false;
    }
    return false;
  }

  public static boolean a(Context paramContext, String paramString)
  {
    paramString = new Intent("android.intent.action.SENDTO").setData(Uri.parse("smsto:" + paramString)).setFlags(268435456);
    String str = g(paramContext);
    if (asq.c(paramContext, str))
      paramString.setPackage(str);
    try
    {
      paramContext.startActivity(paramString);
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.w("Swipe.Telephony", "No activity found to handle intent " + paramString);
    }
    return false;
  }

  public static String b(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }

  public static void b(Context paramContext, String paramString)
  {
    asq.d(paramContext, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
  }

  public static String c(Context paramContext)
  {
    while (true)
    {
      String str;
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        localObject = paramContext.getSimSerialNumber();
        str = paramContext.getSubscriberId();
        paramContext = (Context)localObject;
        if (localObject == null)
        {
          paramContext = "";
          break label81;
          localObject = paramContext + "_" + (String)localObject;
          paramContext = (Context)localObject;
          if (((String)localObject).length() > 61)
            paramContext = ((String)localObject).substring(0, 61);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        return "";
      }
      label81: Object localObject = str;
      if (str == null)
        localObject = "";
    }
  }

  public static void c(Context paramContext, String paramString)
  {
    if (!asq.d(paramContext, new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString))))
      b(paramContext, paramString);
  }

  public static Intent d(Context paramContext)
  {
    paramContext = e(paramContext);
    Intent localIntent = new Intent("android.intent.action.MAIN");
    if (paramContext != null)
      localIntent.setPackage(paramContext);
    while (true)
    {
      localIntent.setFlags(268435456);
      return localIntent;
      localIntent.setType("vnd.android-dir/mms-sms");
    }
  }

  public static String e(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
        return Telephony.Sms.getDefaultSmsPackage(paramContext);
      if (f(paramContext))
        return "com.google.android.talk";
    }
    catch (Throwable paramContext)
    {
    }
    return null;
  }

  public static boolean f(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName("com.google.android.talk", "com.google.android.apps.babel.sms.SmsReceiver"));
      return 1 == i;
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  public static String g(Context paramContext)
  {
    String str = e(paramContext);
    paramContext = str;
    if (str == null)
      paramContext = "com.android.mms";
    return paramContext;
  }

  public static void h(Context paramContext)
  {
    Intent localIntent = d(paramContext);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      Log.w("Swipe.Telephony", "Failed to launch SMS: " + paramContext.getMessage());
    }
  }

  public static String i(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asl
 * JD-Core Version:    0.6.2
 */