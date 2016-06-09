package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import com.lazyswipe.ui.DialogActivity;

public class ann extends ans
{
  public ann(Context paramContext)
  {
    this(paramContext, null);
  }

  public ann(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  public int a(Context paramContext)
  {
    if ((vs.v(paramContext)) || (asq.i(paramContext)) || (asq.c(this.e, "com.hola.screenlock", "com.hola.screenlock.DeviceAdminReceiver")))
      return 1;
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837842;
  }

  public Intent b(Context paramContext)
  {
    Object localObject = a("com.android.settings", "com.android.settings.Settings$DeviceAdminSettingsActivity");
    if (asq.a(paramContext, (Intent) localObject));
    Intent localIntent;
    do
    {
      return localObject;
      localIntent = new Intent("android.settings.SECURITY_SETTINGS");
      localObject = localIntent;
    }
    while (asq.a(paramContext, localIntent));
    return null;
  }

  public String b()
  {
    return "Sleep";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_sleep";
  }

  public int c()
  {
    return 15;
  }

  public int d()
  {
    return 2131231131;
  }

  public boolean e()
  {
    return false;
  }

  public boolean h()
  {
    return false;
  }

  public boolean i()
  {
    if (vs.v(this.e))
      arj.a(new Runnable() {
        public void run() {
          ase.b();
        }
      });
    while (true)
    {
      return true;
      boolean bool1 = asq.h(this.e);
      boolean bool2 = asq.c(this.e, "com.hola.screenlock");
      if ((!bool2) && (!bool1))
        DialogActivity.c(this.e);
      else if (((bool1) && (!asq.i(this.e))) || ((bool2) && (!asq.c(this.e, "com.hola.screenlock", "com.hola.screenlock.DeviceAdminReceiver"))))
        DialogActivity.d(this.e);
      else if (bool1)
        asq.g(this.e);
      else
        asq.d(this.e, new Intent("com.hola.screenlock.action.main").setPackage("com.hola.screenlock").addFlags(32));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ann
 * JD-Core Version:    0.6.2
 */