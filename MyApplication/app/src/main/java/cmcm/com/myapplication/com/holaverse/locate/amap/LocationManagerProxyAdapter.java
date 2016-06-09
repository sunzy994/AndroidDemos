package cmcm.com.myapplication.com.holaverse.locate.amap;

import android.app.PendingIntent;
import android.content.Context;

public abstract interface LocationManagerProxyAdapter
{
  public static final int PROVIDER_AMAP = 3;
  public static final int PROVIDER_GPS = 1;
  public static final int PROVIDER_NETWORK = 2;

  public abstract void destroy();

  public abstract void init(Context paramContext);

  public abstract void removeUpdates(PendingIntent paramPendingIntent);

  public abstract void removeUpdates(AMapLocationListenerAdapter paramAMapLocationListenerAdapter);

  public abstract void requestLocationData(int paramInt, long paramLong, float paramFloat, AMapLocationListenerAdapter paramAMapLocationListenerAdapter);

  public abstract void requestLocationUpdates(int paramInt, long paramLong, float paramFloat, PendingIntent paramPendingIntent);

  public abstract void setGpsEnable(boolean paramBoolean);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.locate.amap.LocationManagerProxyAdapter
 * JD-Core Version:    0.6.2
 */