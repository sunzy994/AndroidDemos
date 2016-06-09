package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import java.lang.reflect.Method;

public class anw extends ans
{
  private Method a;
  private Method b;

  public anw(Context paramContext)
  {
    this(paramContext, null);
  }

  public anw(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
    try
    {
      this.a = WifiManager.class.getDeclaredMethod("setWifiApEnabled", new Class[] { WifiConfiguration.class, Boolean.TYPE });
      this.a.setAccessible(true);
      this.b = WifiManager.class.getDeclaredMethod("getWifiApState", new Class[0]);
      this.b.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException paramContext)
    {
    }
  }

  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 4;
    case 11:
      return 0;
    case 13:
      return 1;
    case 10:
      return 3;
    case 12:
    }
    return 2;
  }

  public int a(Context paramContext)
  {
    if (this.b != null)
      try
      {
        int i = b(((Integer)this.b.invoke(paramContext.getSystemService("wifi"), new Object[0])).intValue());
        return i;
      }
      catch (Exception paramContext)
      {
      }
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837847;
  }

  public String a()
  {
    return "android.net.wifi.WIFI_AP_STATE_CHANGED";
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    if (!"android.net.wifi.WIFI_AP_STATE_CHANGED".equals(paramIntent.getAction()))
      return;
    a(paramContext, b(paramIntent.getIntExtra("wifi_state", -1)));
  }

  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (this.a != null)
    {
      final WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (paramBoolean);
      try
      {
        if (localWifiManager.isWifiEnabled())
          new AsyncTask()
          {
            protected Void a(Void[] paramAnonymousArrayOfVoid)
            {
              try
              {
                localWifiManager.setWifiEnabled(false);
                anw.a(anw.this).invoke(localWifiManager, new Object[] { null, Boolean.valueOf(true) });
                return null;
              }
              catch (Throwable paramAnonymousArrayOfVoid)
              {
              }
              return null;
            }
          }
          .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        while (true)
        {
          return super.a(paramContext, paramBoolean);
          this.a.invoke(localWifiManager, new Object[] { null, Boolean.valueOf(paramBoolean) });
        }
      }
      catch (Exception localException)
      {
        asp.a("Swipe.Tile", "Could not toggle wifi ap", localException);
      }
    }
    k(paramContext);
    return true;
  }

  public Intent b(Context paramContext)
  {
    return a("com.android.settings", "com.android.settings.TetherSettings");
  }

  public String b()
  {
    return "Wi-Fi AP";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_wifi_ap";
  }

  public int c()
  {
    return 12;
  }

  public int d()
  {
    return 2131231136;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anw
 * JD-Core Version:    0.6.2
 */