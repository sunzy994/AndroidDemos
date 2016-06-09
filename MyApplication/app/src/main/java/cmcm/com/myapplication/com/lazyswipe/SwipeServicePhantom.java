package cmcm.com.myapplication.com.lazyswipe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import aqs;
import asp;
import asq;

public final class SwipeServicePhantom extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    if ((paramIntent != null) && ("com.lazyswipe.action.FLUSH_TRACE".equals(paramIntent.getAction())))
    {
      asp.c();
      stopSelf();
      return 2;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("isDaemon", false)));
    while (true)
      if (paramInt1 != 0)
      {
        if ((aqs.p()) && (!aqs.b(this)))
        {
          if ("com.lazyswipe".equals(asq.a(this)))
            break;
          System.exit(99);
          return 2;
          paramInt1 = 0;
          continue;
        }
        if (SwipeService.i() == null)
          SwipeService.c(this);
      }
    while (true)
    {
      stopSelf();
      return 2;
      try
      {
        startForeground(1, SwipeService.g(this));
        try
        {
          label107: stopForeground(true);
        }
        catch (Exception paramIntent)
        {
        }
      }
      catch (Exception paramIntent)
      {
        break label107;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.SwipeServicePhantom
 * JD-Core Version:    0.6.2
 */