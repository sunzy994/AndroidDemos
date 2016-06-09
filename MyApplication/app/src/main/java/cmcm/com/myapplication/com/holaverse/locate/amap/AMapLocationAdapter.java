package cmcm.com.myapplication.com.holaverse.locate.amap;

import android.os.Bundle;

public abstract interface AMapLocationAdapter
{
  public abstract float getAccuracy();

  public abstract String getAdCode();

  public abstract String getAddress();

  public abstract double getAltitude();

  public abstract float getBearing();

  public abstract String getCity();

  public abstract String getCityCode();

  public abstract String getCountry();

  public abstract String getDistrict();

  public abstract Bundle getExtras();

  public abstract String getFloor();

  public abstract double getLatitude();

  public abstract double getLongitude();

  public abstract String getPoiId();

  public abstract String getPoiName();

  public abstract int getProvider();

  public abstract String getProvince();

  public abstract String getRoad();

  public abstract float getSpeed();

  public abstract String getStreet();

  public abstract long getTime();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.locate.amap.AMapLocationAdapter
 * JD-Core Version:    0.6.2
 */