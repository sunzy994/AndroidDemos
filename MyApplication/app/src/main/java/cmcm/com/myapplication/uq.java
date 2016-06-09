package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.provider.Telephony.Sms;

public final class uq
{
  public static Intent a(Context paramContext)
  {
    paramContext = b(paramContext);
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

  public static String b(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
        return Telephony.Sms.getDefaultSmsPackage(paramContext);
      if (c(paramContext))
        return "com.google.android.talk";
    }
    catch (Throwable paramContext)
    {
    }
    return null;
  }

  public static boolean c(Context paramContext)
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

  public static void d(Context paramContext)
  {
    Intent localIntent = a(paramContext);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uq
 * JD-Core Version:    0.6.2
 */