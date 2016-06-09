package cmcm.com.myapplication;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.holaverse.locate.amap.AMapLocationAdapter;
import com.holaverse.locate.amap.AMapLocationListenerAdapter;
import com.holaverse.locate.amap.LocationManagerProxyAdapter;
import com.lazyswipe.features.weather.bean.City;
import java.util.Iterator;
import java.util.List;

public class afe
  implements AMapLocationListenerAdapter
{
  ajy a;
  afo b;
  private boolean c = false;
  private LocationManagerProxyAdapter d = null;

  public afe(Context paramContext, LocationManagerProxyAdapter paramLocationManagerProxyAdapter)
  {
    this.d = paramLocationManagerProxyAdapter;
  }

  private City a(ajy paramajy, String paramString1, String paramString2)
  {
    paramajy = paramajy.a(paramString1, "");
    if (paramajy != null)
    {
      paramajy = paramajy.iterator();
      while (paramajy.hasNext())
      {
        City localCity = (City)paramajy.next();
        if (((localCity.a().startsWith(paramString1)) || (paramString1.startsWith(localCity.a()))) && ((localCity.c().startsWith(paramString2)) || (paramString2.startsWith(localCity.c()))))
          return localCity;
      }
    }
    return null;
  }

  private City a(AMapLocationAdapter paramAMapLocationAdapter, ajy paramajy)
  {
    Object localObject1;
    if (paramAMapLocationAdapter == null)
      localObject1 = null;
    while (true)
    {
      return localObject1;
      try
      {
        if (!b())
          return null;
        localaff = new aff(paramAMapLocationAdapter.getCountry(), paramAMapLocationAdapter.getProvince(), paramAMapLocationAdapter.getCity(), paramAMapLocationAdapter.getDistrict());
        if ((0 == 0) && (!TextUtils.isEmpty(localaff.d())))
        {
          i = localaff.d().length();
          if (i > 2)
          {
            paramAMapLocationAdapter = a(paramajy, localaff.d().substring(0, i - 1), localaff.b());
            localObject1 = paramAMapLocationAdapter;
            if (paramAMapLocationAdapter == null)
            {
              localObject1 = paramAMapLocationAdapter;
              localObject2 = paramAMapLocationAdapter;
            }
          }
        }
      }
      catch (Exception paramajy)
      {
        while (true)
        {
          try
          {
            int i;
            if (!TextUtils.isEmpty(localaff.c()))
            {
              localObject2 = paramAMapLocationAdapter;
              i = localaff.c().length();
              if (i > 2)
              {
                localObject2 = paramAMapLocationAdapter;
                localObject1 = a(paramajy, localaff.c().substring(0, i - 1), localaff.b());
              }
            }
            else
            {
              if (localObject1 != null)
                continue;
              localObject2 = localObject1;
              if (TextUtils.isEmpty(localaff.b()))
                continue;
              localObject2 = localObject1;
              paramAMapLocationAdapter = a(paramajy, localaff.b(), localaff.a());
              localObject1 = paramAMapLocationAdapter;
              if (paramAMapLocationAdapter == null)
                localObject1 = paramAMapLocationAdapter;
            }
          }
          catch (Exception paramajy)
          {
            try
            {
              aff localaff;
              if (!TextUtils.isEmpty(localaff.a()))
                localObject1 = a(paramajy, localaff.a(), localaff.a());
              if (b())
                break;
              return null;
              paramAMapLocationAdapter = a(paramajy, localaff.d(), localaff.b());
              continue;
              Object localObject2 = paramAMapLocationAdapter;
              localObject1 = a(paramajy, localaff.c(), localaff.b());
              continue;
              paramajy = paramajy;
              paramAMapLocationAdapter = null;
              Log.w("Swipe.AMapLocation", "Exception", paramajy);
              localObject1 = paramAMapLocationAdapter;
              continue;
              paramajy = paramajy;
              paramAMapLocationAdapter = (AMapLocationAdapter)localObject2;
              continue;
            }
            catch (Exception paramajy)
            {
              continue;
            }
            paramAMapLocationAdapter = (AMapLocationAdapter)localObject1;
            continue;
          }
          paramAMapLocationAdapter = null;
        }
      }
    }
  }

  private void c()
  {
  }

  private void d()
  {
    this.c = true;
  }

  private void e()
  {
    this.c = false;
  }

  public void a()
  {
    c();
    if (this.d != null)
    {
      this.d.removeUpdates(this);
      this.d.destroy();
    }
    this.d = null;
    e();
  }

  public void a(ajy paramajy, afo paramafo)
  {
    this.a = paramajy;
    this.b = paramafo;
    this.d.setGpsEnable(false);
    d();
    try
    {
      this.d.requestLocationData(3, 5000L, 10.0F, this);
      return;
    }
    catch (Exception paramajy)
    {
      e();
      vv.a().a("B14", "result", 2);
      this.b.a(2, 8);
    }
  }

  public boolean b()
  {
    return this.c;
  }

  public void onLocationChanged(Location paramLocation)
  {
  }

  public void onLocationChanged(AMapLocationAdapter paramAMapLocationAdapter)
  {
    if (!b());
    do
    {
      City localCity;
      do
      {
        do
        {
          do
          {
            return;
            if (paramAMapLocationAdapter != null)
            {
              double d1 = paramAMapLocationAdapter.getLatitude();
              double d2 = paramAMapLocationAdapter.getLongitude();
              if ((Math.abs(Double.valueOf(d1).doubleValue()) < 1.E-05D) || (Math.abs(Double.valueOf(d2).doubleValue()) < 1.E-05D))
              {
                asp.b("Swipe.AMapLocation", "Locating failed due to zero latitude/longitude");
                vv.a().a("B14", "result", 2);
                this.b.a(2, 8);
                return;
              }
            }
          }
          while (paramAMapLocationAdapter == null);
          if ((TextUtils.isEmpty(paramAMapLocationAdapter.getCity())) || (this.a == null))
            break;
          localCity = null;
          if (b())
            localCity = a(paramAMapLocationAdapter, this.a);
        }
        while (!b());
        e();
      }
      while (this.b == null);
      if (localCity == null)
      {
        vv.a().a("B14", "result", 2);
        this.b.a(2, 7);
        return;
      }
      vv.a().a("B14", "result", 1);
      this.b.a(2, localCity);
      return;
      e();
    }
    while (this.b == null);
    vv.a().a("B14", "result", 2);
    this.b.a(2, 0);
  }

  public void onProviderDisabled(int paramInt)
  {
  }

  public void onProviderEnabled(int paramInt)
  {
  }

  public void onStatusChanged(int paramInt1, int paramInt2, Bundle paramBundle)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afe
 * JD-Core Version:    0.6.2
 */