package cmcm.com.myapplication;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class afi extends Thread
{
  private Looper b;
  private final afo c;
  private final Context d;

  public void a()
  {
    if (this.b == null)
      return;
    this.b.quit();
  }

  public void run()
  {
    Looper.prepare();
    this.b = Looper.myLooper();
    synchronized (this.a)
    {
      if (afg.b(this.a) == null)
        afg.a(this.a, new ArrayList());
      Object localObject1 = afg.c(this.a).getProviders(true);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          afh localafh = new afh(this.a, this, this.d, this.c);
          afg.b(this.a).add(localafh);
          afg.c(this.a).requestLocationUpdates(str, 0L, 0.0F, localafh);
        }
      }
    }
    Looper.loop();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afi
 * JD-Core Version:    0.6.2
 */