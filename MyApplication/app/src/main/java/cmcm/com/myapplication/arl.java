package cmcm.com.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

public final class arl
{
  public static char a()
  {
    return 'z';
  }

  public static String a(Context paramContext)
  {
    paramContext = d(paramContext);
    if (paramContext != null)
      return paramContext.getTypeName();
    return null;
  }

  public static String a(Context paramContext, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramString;
    case 2:
      return "2G";
    case 3:
      return "3G";
    case 4:
      return "4G";
    case 1:
      return "WIFI";
    case 0:
    }
    return "NA";
  }

  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (d(paramNetworkInfo)) && (paramNetworkInfo.getType() == 0);
  }

  public static String b(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager) asq.r(paramContext, "connectivity")).getActiveNetworkInfo();
    int k;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()) && (1 == localNetworkInfo.getType()))
    {
      paramContext = ((WifiManager) asq.r(paramContext, "wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getSSID();
        k = paramContext.length();
        if ((k > 0) && (!"<unknown ssid>".equals(paramContext)))
          if (paramContext.charAt(0) != '"')
            break label141;
      }
    }
    label141: for (int i = 1; ; i = 0)
    {
      if (paramContext.charAt(k - 1) == '"');
      for (int j = k - 1; ; j = k)
      {
        if ((i != 0) || (j != k))
          paramContext = paramContext.substring(i, j);
        while (true)
        {
          if (!TextUtils.isEmpty(paramContext))
            return paramContext;
          return null;
        }
      }
    }
  }

  public static boolean b(NetworkInfo paramNetworkInfo)
  {
    return (d(paramNetworkInfo)) && (1 == paramNetworkInfo.getType());
  }

  public static String c(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }

  public static boolean c(NetworkInfo paramNetworkInfo)
  {
    return (e(paramNetworkInfo)) && (1 == paramNetworkInfo.getType());
  }

  public static NetworkInfo d(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }

  public static boolean d(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnected());
  }

  public static boolean e(Context paramContext)
  {
    return a(d(paramContext));
  }

  public static boolean e(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnectedOrConnecting());
  }

  public static boolean f(Context paramContext)
  {
    return b(d(paramContext));
  }

  public static boolean g(Context paramContext)
  {
    return c(d(paramContext));
  }

  public static boolean h(Context paramContext)
  {
    return d(d(paramContext));
  }

  public static boolean i(Context paramContext)
  {
    return e(d(paramContext));
  }

  public static int j(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(1);
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting()))
      return 1;
    paramContext = paramContext.getNetworkInfo(0);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnectedOrConnecting()));
    switch (paramContext.getSubtype())
    {
    case 15:
    case 16:
    default:
      return 0;
    case 1:
    case 2:
    case 4:
    case 7:
    case 11:
      return 2;
    case 3:
    case 5:
    case 6:
    case 8:
    case 9:
    case 10:
    case 12:
    case 14:
    case 17:
    case 18:
      return 3;
    case 13:
    }
    return 4;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arl
 * JD-Core Version:    0.6.2
 */