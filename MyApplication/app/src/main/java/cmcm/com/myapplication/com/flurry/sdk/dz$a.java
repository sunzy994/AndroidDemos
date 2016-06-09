package cmcm.com.myapplication.com.flurry.sdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class dz$a
  implements LocationListener
{
  public dz$a(dz paramdz)
  {
  }

  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
      dz.a(this.a, paramLocation);
    el.a(4, dz.h(), "Location received");
    if (dz.a(this.a) >= 3)
    {
      el.a(4, dz.h(), "Max location reports reached, stopping");
      dz.b(this.a);
    }
  }

  public void onProviderDisabled(String paramString)
  {
  }

  public void onProviderEnabled(String paramString)
  {
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dz.a
 * JD-Core Version:    0.6.2
 */