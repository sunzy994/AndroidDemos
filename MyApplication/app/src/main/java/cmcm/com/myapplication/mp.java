package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class mp
{
  private static final boolean a = mv.a();

  public static String a()
  {
    try
    {
      String str = Build.MANUFACTURER;
      return str;
    }
    catch (Exception localException)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get the hw info.", localException);
    }
    return "";
  }

  public static String a(Context paramContext)
  {
    return paramContext.getApplicationContext().getPackageName();
  }

  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, paramString2, new IvParameterSpec(paramString1.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }

  public static String b()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Exception localException)
    {
      if (a)
        Log.e("BaseInfoHelper", "failed to get the model info.", localException);
    }
    return "";
  }

  public static String b(Context paramContext)
  {
    try
    {
      paramContext = k(paramContext);
      if (paramContext != null)
      {
        int i = paramContext.heightPixels;
        return String.valueOf(i);
      }
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get height info!", paramContext);
    }
    return "";
  }

  public static String c()
  {
    try
    {
      int i = VERSION.SDK_INT;
      return String.valueOf(i);
    }
    catch (Exception localException)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get the androidVersion info.", localException);
    }
    return "";
  }

  public static String c(Context paramContext)
  {
    try
    {
      paramContext = k(paramContext);
      if (paramContext != null)
      {
        int i = paramContext.widthPixels;
        return String.valueOf(i);
      }
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get width info!", paramContext);
    }
    return "";
  }

  public static String d(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get PkgVersionName!", paramContext);
    }
    return "";
  }

  public static int e(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      if (paramContext != null)
      {
        int i = paramContext.versionCode;
        return i;
      }
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get PkgVersionCode!", paramContext);
    }
    return -1;
  }

  public static String f(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get the hw info.", paramContext);
    }
    return "";
  }

  public static String g(Context paramContext)
  {
    try
    {
      paramContext = k(paramContext);
      if (paramContext != null)
      {
        paramContext = Integer.toString(paramContext.densityDpi);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get the dpi info.", paramContext);
    }
    return "";
  }

  public static String h(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "failed to getLocale Info!", paramContext);
    }
    return "";
  }

  public static String i(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        String str = localNetworkInfo.getTypeName();
        paramContext = str;
        if ("mobile".equals(str.toLowerCase()))
          paramContext = localNetworkInfo.getSubtypeName();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to get the netWorkType info.", paramContext);
    }
    return "none";
  }

  public static int j(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation == 1)
      return 1;
    return 3;
  }

  private static DisplayMetrics k(Context paramContext)
  {
    try
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Exception paramContext)
    {
      if (a)
        Log.e("BaseInfoHelper", "Failed to getMetrics!", paramContext);
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mp
 * JD-Core Version:    0.6.2
 */