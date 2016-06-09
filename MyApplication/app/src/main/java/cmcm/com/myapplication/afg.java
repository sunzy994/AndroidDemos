package cmcm.com.myapplication;

import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import java.util.List;

public class afg
{
  private final LocationManager a;
  private List<LocationListener> b;
  private boolean c;
  private afi d;

  private void e()
  {
    try
    {
      if (this.b == null)
        return;
      int j = this.b.size();
      int i = 0;
      while (true)
        if (i < j)
          try
          {
            LocationListener localLocationListener = (LocationListener)this.b.remove(0);
            this.a.removeUpdates(localLocationListener);
            i += 1;
          }
          catch (Exception localException)
          {
            while (true)
              Log.w("Swipe.AndroidLocation", "android mLocationManager.removeUpdates " + localException);
          }
    }
    finally
    {
    }
    this.b = null;
  }

  public void a()
  {
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
  }

  public void b()
  {
    a();
    c();
    e();
  }

  public void c()
  {
    try
    {
      this.c = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean d()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afg
 * JD-Core Version:    0.6.2
 */