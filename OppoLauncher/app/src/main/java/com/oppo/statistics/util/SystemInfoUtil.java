package com.oppo.statistics.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.color.os.ColorBuild;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"DefaultLocale"})
public class SystemInfoUtil
{
  private static final Pattern MTK_PATTERN = Pattern.compile("^[MT]{2}[a-zA-Z0-9]{0,10}$");
  private static int STATISTICS_PLATFORM_MTK = 0;
  private static int STATISTICS_PLATFORM_QUALCOMM = 0;
  public static final String SYSTEM_NAME = "Android";

  public static String getHardware()
  {
    if (!isEmpty(Build.HARDWARE))
      return Build.HARDWARE.toUpperCase();
    LogUtil.w("NearMeStatistics", "No HARDWARE INFO.");
    return "0";
  }

  public static String getImei(Context paramContext)
  {
    Object localObject1 = "0";
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      Object localObject2 = paramContext;
      localObject1 = paramContext;
      if (isEmpty(paramContext))
      {
        localObject1 = paramContext;
        LogUtil.w("NearMeStatistics", "No IMEI.");
        localObject2 = "0";
      }
      return localObject2;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", "Failed to take mac as IMEI.");
    }
    return localObject1;
  }

  public static String getLocalPhoneNO(Context paramContext)
  {
    String str = "0";
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      paramContext = str;
      if (!isEmpty(localTelephonyManager.getLine1Number()))
        paramContext = localTelephonyManager.getLine1Number();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return "0";
  }

  public static String getMacAddress(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (!isEmpty(paramContext.getMacAddress()))
        return paramContext.getMacAddress();
      LogUtil.w("NearMeStatistics", "NO MAC ADDRESS.");
      return "0";
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return "0";
  }

  public static String getMobile(Context paramContext)
  {
    String str = "0";
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    paramContext = str;
    if (localTelephonyManager.hasIccCard())
    {
      str = localTelephonyManager.getLine1Number();
      if (!TextUtils.isEmpty(str))
      {
        paramContext = str;
        if (!str.equals("null"));
      }
      else
      {
        paramContext = "0";
      }
    }
    return paramContext;
  }

  public static String getModel()
  {
    if (!isEmpty(Build.MODEL))
      return Build.MODEL.toUpperCase();
    LogUtil.w("NearMeStatistics", "No MODEL.");
    return "0";
  }

  public static String getOperator(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return "";
  }

  public static int getOperatorId(Context paramContext)
  {
    paramContext = getOperator(paramContext).toLowerCase();
    int i = 99;
    if ((paramContext.equals("中国移动")) || (paramContext.equals("china mobile")) || (paramContext.equals("chinamobile")))
      i = 0;
    do
    {
      return i;
      if ((paramContext.equals("中国联通")) || (paramContext.equals("china unicom")) || (paramContext.equals("chinaunicom")))
        return 1;
    }
    while ((!paramContext.equals("中国电信")) && (!paramContext.equals("china net")) && (!paramContext.equals("chinanet")));
    return 2;
  }

  public static int getPlatForm()
  {
    if (getHardware().equals("QCOM"))
      return STATISTICS_PLATFORM_QUALCOMM;
    if (MTK_PATTERN.matcher(getHardware()).find())
      return STATISTICS_PLATFORM_MTK;
    return 0;
  }

  public static String getRomVersion()
  {
    return "" + ColorBuild.getColorOSVERSION();
  }

  public static int getSDKVersion()
  {
    return VERSION.SDK_INT;
  }

  private static boolean isEmpty(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || ("null".equals(paramString));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.util.SystemInfoUtil
 * JD-Core Version:    0.6.2
 */