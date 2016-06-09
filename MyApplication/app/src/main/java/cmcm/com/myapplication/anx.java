package cmcm.com.myapplication;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class anx extends ans
{
  private String a;
  private final BroadcastReceiver b = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      anx.a(anx.this, null);
      try
      {
        paramAnonymousContext = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
        if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected()))
        {
          paramAnonymousContext = (WifiInfo)paramAnonymousIntent.getParcelableExtra("wifiInfo");
          if (paramAnonymousContext != null)
            anx.a(anx.this, paramAnonymousContext.getSSID());
        }
        label56: anx.this.h.sendEmptyMessage(101);
        return;
      }
      catch (Throwable paramAnonymousContext)
      {
        break label56;
      }
    }
  };

  public anx(Context paramContext)
  {
    this(paramContext, null);
  }

  public anx(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 4;
    case 1:
      return 0;
    case 3:
      return 1;
    case 0:
      return 3;
    case 2:
    }
    return 2;
  }

  public int a(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext != null)
      try
      {
        int i = b(paramContext.getWifiState());
        if (1 == i)
          arj.a(new any(this));
        return i;
      }
      catch (Exception paramContext)
      {
        return 4;
      }
    return 4;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837846;
  }

  public String a()
  {
    return "android.net.wifi.WIFI_STATE_CHANGED";
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    if (!a().equals(paramIntent.getAction()))
      return;
    a(paramContext, b(paramIntent.getIntExtra("wifi_state", -1)));
  }

  public boolean a(Context paramContext, final boolean paramBoolean)
  {
    final WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    if (localWifiManager != null)
      new AsyncTask()
      {
        protected Void a(Void[] paramAnonymousArrayOfVoid)
        {
          try
          {
            localWifiManager.setWifiEnabled(paramBoolean);
            label12: return null;
          }
          catch (Throwable paramAnonymousArrayOfVoid)
          {
            break label12;
          }
        }
      }
      .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    while (true)
    {
      return super.a(paramContext, paramBoolean);
      Log.e("Swipe.Tile", "No wifi manager found");
    }
  }

  public Intent b(Context paramContext)
  {
    Object localObject;
    if ((aqs.m()) && (aqs.B()))
      localObject = null;
    Intent localIntent;
    do
    {
      return localObject;
      localIntent = new Intent("android.settings.WIFI_SETTINGS");
      localObject = localIntent;
    }
    while (asq.a(paramContext, localIntent));
    return localIntent.setAction("android.settings.WIRELESS_SETTINGS");
  }

  public String b()
  {
    return "Wi-Fi";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_wifi";
  }

  public int c()
  {
    return 13;
  }

  protected TextView c(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return a(2131230971, new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            anx.this.i.dismiss();
            if (((zf)anx.this.f).e(anx.this.e))
              yb.e(true);
            return;
          }
          catch (Throwable paramAnonymousView)
          {
          }
        }
      });
    case 0:
    }
    return a(2131230970, new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          yb.getInstance().getItemLayer().d(null);
          anx.this.i.dismiss();
          return;
        }
        catch (Throwable paramAnonymousView)
        {
        }
      }
    });
  }

  public int d()
  {
    return 2131231135;
  }

  public String g()
  {
    if (!TextUtils.isEmpty(this.a))
      return this.a;
    return super.g();
  }

  public void u_()
  {
    super.u_();
    try
    {
      this.e.registerReceiver(this.b, new IntentFilter("android.net.wifi.STATE_CHANGE"));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void v_()
  {
    super.v_();
    try
    {
      this.e.unregisterReceiver(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public boolean w()
  {
    return !TextUtils.isEmpty(this.a);
  }

  protected int z()
  {
    return 2;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anx
 * JD-Core Version:    0.6.2
 */