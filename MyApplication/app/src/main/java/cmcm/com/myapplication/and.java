package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

class and
  implements Runnable
{
  private final WeakReference<anc> a;

  and(anc paramanc)
  {
    this.a = new WeakReference(paramanc);
  }

  public void run()
  {
    if (this.a.get() == null);
    while (true)
    {
      return;
      PackageManager localPackageManager = ((anc)this.a.get()).a.getPackageManager();
      int i;
      if (localPackageManager.checkPermission("android.permission.MODIFY_PHONE_STATE", "com.lazyswipe") != 0)
      {
        ase.a("pm grant com.lazyswipe android.permission.MODIFY_PHONE_STATE", true, false);
        if (localPackageManager.checkPermission("android.permission.MODIFY_PHONE_STATE", "com.lazyswipe") != 0)
        {
          asp.b("Swipe.MobileDataManager", "Unfortunately we have NO permission to enable mobile data!");
          i = 0;
        }
      }
      while (i != 0)
      {
        try
        {
          anc.a((anc)this.a.get(), TelephonyManager.class.getDeclaredMethod("setDataEnabled", new Class[] { Boolean.TYPE }));
          anc.a((anc)this.a.get()).setAccessible(true);
          return;
        }
        catch (Throwable localThrowable)
        {
          return;
        }
        i = 1;
        continue;
        i = 1;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     and
 * JD-Core Version:    0.6.2
 */