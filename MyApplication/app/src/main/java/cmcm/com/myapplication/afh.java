package cmcm.com.myapplication;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class afh
  implements LocationListener
{
  private final afo b;
  private final Context c;
  private final afi d;

  public afh(afg paramafg, afi paramafi, Context paramContext, afo paramafo)
  {
    this.d = paramafi;
    this.b = paramafo;
    this.c = paramContext;
  }

  public void onLocationChanged(Location paramLocation)
  {
    this.d.a();
    afg.a(this.a);
    if (this.a.d())
    {
      this.a.c();
      if (this.b != null)
        this.b.a(1, paramLocation.getLatitude(), paramLocation.getLongitude(), null);
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
 * Qualified Name:     afh
 * JD-Core Version:    0.6.2
 */