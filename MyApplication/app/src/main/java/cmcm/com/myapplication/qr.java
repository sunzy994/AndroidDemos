package cmcm.com.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class qr
{
  public static NetworkInfo a(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }

  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (b(paramNetworkInfo)) && (1 == paramNetworkInfo.getType());
  }

  public static boolean b(Context paramContext)
  {
    return a(a(paramContext));
  }

  public static boolean b(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnected());
  }

  public static boolean c(Context paramContext)
  {
    return b(a(paramContext));
  }

  public static boolean c(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnectedOrConnecting());
  }

  public static boolean d(Context paramContext)
  {
    return c(a(paramContext));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qr
 * JD-Core Version:    0.6.2
 */