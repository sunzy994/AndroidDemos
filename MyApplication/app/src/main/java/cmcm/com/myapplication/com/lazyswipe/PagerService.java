package cmcm.com.myapplication.com.lazyswipe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.hola.alliance.AppInfo;
import og;
import vs;
import yb;

public class PagerService extends Service
{
  private static final String a = "Swipe." + PagerService.class.getSimpleName();

  private void a()
  {
    SwipeService.a(this);
  }

  private void a(Intent paramIntent)
  {
    paramIntent = og.a(paramIntent);
    if (paramIntent != null)
    {
      SwipeService.a(this);
      if (!"com.hola.launcher".equals(paramIntent.a));
    }
    stopSelf();
  }

  private void b(Intent paramIntent)
  {
    if (!vs.H(this))
    {
      stopSelf();
      return;
    }
    if (yb.o())
    {
      stopSelf();
      return;
    }
    if (paramIntent.hasExtra("com.lazyswipe.extra.IS_LEFT"));
    for (boolean bool = paramIntent.getBooleanExtra("com.lazyswipe.extra.IS_LEFT", false); ; bool = vs.B(this))
    {
      SwipeService.a(this, SwipeService.a(this, bool).getExtras());
      stopSelf();
      return;
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null);
    while (true)
    {
      return 2;
      String str = paramIntent.getAction();
      if ("com.lazyswipe.action.AllianceService".equals(str))
        a(paramIntent);
      while (paramIntent.getBooleanExtra("isDaemon", false))
      {
        a();
        return 2;
        if ("com.lazyswipe.action.openFan".equals(str))
          b(paramIntent);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.PagerService
 * JD-Core Version:    0.6.2
 */