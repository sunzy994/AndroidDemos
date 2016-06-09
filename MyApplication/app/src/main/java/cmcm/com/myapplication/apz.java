package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.lazyswipe.SwipeApplication;

public class apz
  implements ServiceConnection
{
  private Context a;
  private apw b;
  private final aqa c;
  private final apt d = new apu()
  {
    public void a(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      apz.this.a(paramAnonymousInt1, paramAnonymousInt2);
    }
  };

  private apz(Context paramContext, aqa paramaqa)
  {
    this.a = paramContext;
    this.c = paramaqa;
    paramContext.bindService(new Intent("com.lazyswipe.unlocker.action.CHECK_LICENSE").setPackage("com.lazyswipe.pro2"), this, 1);
  }

  private static apz a(Context paramContext, aqa paramaqa)
  {
    if (a(paramContext, "com.lazyswipe.pro2"))
      return new apz(paramContext, paramaqa);
    return null;
  }

  public static void a(Context paramContext)
  {
    vg.k = false;
    if (!vg.k)
      a(false);
    while (a(paramContext, new aqa()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt1 == 0);
        for (boolean bool = true; ; bool = false)
        {
          apz.a(bool);
          ci.a(apz.this).a(new Intent("com.lazyswipe.unlocker.action.LICENSING_CHANGED"));
          apz.b(apz.this);
          return;
        }
      }
    }) != null)
      return;
    a(false);
  }

  public static void a(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    try
    {
      ci.a(paramContext).a(paramBroadcastReceiver, new IntentFilter("com.lazyswipe.unlocker.action.LICENSING_CHANGED"));
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }

  public static void a(boolean paramBoolean)
  {
    amk.d(SwipeApplication.c(), paramBoolean);
  }

  private static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkSignatures("com.lazyswipe", paramString) == 0;
  }

  public static void b(Context paramContext)
  {
    ci.a(paramContext).a(new Intent("com.lazyswipe.unlocker.action.LICENSING_CHANGED"));
  }

  public static void b(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    try
    {
      ci.a(paramContext).a(paramBroadcastReceiver);
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }

  public static boolean b()
  {
    return amk.d(SwipeApplication.c());
  }

  public static void c(Context paramContext)
  {
    a(false);
    if ((aap.b(paramContext) instanceof aaj))
      aap.a(paramContext, 1);
    vs.b(paramContext, "pref_lucky_leap_never_show", false);
  }

  public void a()
  {
    if (this.b != null);
    try
    {
      this.b.b(this.d);
      try
      {
        label20: this.a.unbindService(this);
        label28: this.a = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        break label28;
      }
    }
    catch (RemoteException localRemoteException)
    {
      break label20;
    }
  }

  void a(int paramInt1, int paramInt2)
  {
    if (this.c != null);
    try
    {
      this.c.a(paramInt1, paramInt2);
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Log.d("Swipe.MyLicenseChecker", "Error when handling license check result", localThrowable);
    }
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.b = apx.a(paramIBinder);
    try
    {
      this.b.a(this.d);
      if (this.b == null);
    }
    catch (Throwable paramComponentName)
    {
      try
      {
        this.b.a();
        return;
        paramComponentName = paramComponentName;
        this.b = null;
      }
      catch (Throwable paramComponentName)
      {
        Log.w("Swipe.MyLicenseChecker", "Couldn't check license", paramComponentName);
        a(2, -2);
        return;
      }
    }
    a(2, -1);
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.b = null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apz
 * JD-Core Version:    0.6.2
 */