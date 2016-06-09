package cmcm.com.myapplication.com.holaverse.locate.amap;

import android.location.Location;
import android.os.Bundle;

public abstract interface AMapLocationListenerAdapter
{
  public abstract void onLocationChanged(Location paramLocation);

  public abstract void onLocationChanged(AMapLocationAdapter paramAMapLocationAdapter);

  public abstract void onProviderDisabled(int paramInt);

  public abstract void onProviderEnabled(int paramInt);

  public abstract void onStatusChanged(int paramInt1, int paramInt2, Bundle paramBundle);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.locate.amap.AMapLocationListenerAdapter
 * JD-Core Version:    0.6.2
 */