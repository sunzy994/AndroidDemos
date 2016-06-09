package cmcm.com.myapplication;

import android.content.Context;
import android.content.IntentFilter;

public class qv
{
  private static qw a = new qw(null);

  public static void a(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    paramContext.registerReceiver(a, localIntentFilter);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qv
 * JD-Core Version:    0.6.2
 */