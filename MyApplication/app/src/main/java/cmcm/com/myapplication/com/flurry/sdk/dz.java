package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;

public class dz
  implements dq.a, ey.a
{
  private static final String c = dz.class.getSimpleName();
  private static dz q;
  boolean a = false;
  boolean b;
  private final int d = 3;
  private final long e = 10000L;
  private final long f = 90000L;
  private final long g = 0L;
  private long h = 0L;
  private LocationManager i;
  private Criteria j;
  private Location k;
  private dz.a l = new dz.a(this);
  private String m;
  private int n = 0;
  private int o = 0;
  private volatile Location p;

  private dz()
  {
    dq localdq = dp.a();
    this.j = ((Criteria)localdq.a("LocationCriteria"));
    localdq.a("LocationCriteria", this);
    el.a(4, c, "initSettings, LocationCriteria = " + this.j);
    this.b = ((Boolean)localdq.a("ReportLocation")).booleanValue();
    localdq.a("ReportLocation", this);
    el.a(4, c, "initSettings, ReportLocation = " + this.b);
  }

  public static dz a()
  {
    try
    {
      if (q == null)
        q = new dz();
      dz localdz = q;
      return localdz;
    }
    finally
    {
    }
  }

  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.i.requestLocationUpdates(paramString, 10000L, 0.0F, this.l, Looper.getMainLooper());
  }

  private Location b(String paramString)
  {
    Location localLocation = null;
    if (!TextUtils.isEmpty(paramString))
      localLocation = this.i.getLastKnownLocation(paramString);
    return localLocation;
  }

  private void i()
  {
    this.i.removeUpdates(this.l);
    this.a = false;
    this.o = 0;
    this.h = 0L;
    m();
    el.a(4, c, "LocationProvider stopped");
  }

  private void j()
  {
    if (!this.b);
    do
    {
      do
        return;
      while (this.p != null);
      localObject = do.a().b();
    }
    while ((((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) && (((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0));
    i();
    Object localObject = k();
    a((String)localObject);
    this.k = b((String)localObject);
    this.h = (System.currentTimeMillis() + 90000L);
    l();
    this.a = true;
    el.a(4, c, "LocationProvider started");
  }

  private String k()
  {
    Criteria localCriteria = this.j;
    Object localObject = localCriteria;
    if (localCriteria == null)
      localObject = new Criteria();
    if (TextUtils.isEmpty(this.m));
    for (localObject = this.i.getBestProvider((Criteria)localObject, true); ; localObject = this.m)
    {
      el.a(4, c, "provider = " + (String)localObject);
      return localObject;
    }
  }

  private void l()
  {
    el.a(4, c, "Register location timer");
    ex.a().a(this);
  }

  private void m()
  {
    el.a(4, c, "Unregister location timer");
    ex.a().b(this);
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.p = new Location("Explicit");
    this.p.setLatitude(paramFloat1);
    this.p.setLongitude(paramFloat2);
  }

  public void a(ey paramey)
  {
    if ((this.h > 0L) && (this.h < System.currentTimeMillis()))
    {
      el.a(4, c, "No location received in 90 seconds , stopping LocationManager");
      i();
    }
  }

  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("LocationCriteria"))
    {
      this.j = ((Criteria)paramObject);
      el.a(4, c, "onSettingUpdate, LocationCriteria = " + this.j);
      if (this.a)
        j();
    }
    do
    {
      return;
      if (!paramString.equals("ReportLocation"))
        break label140;
      this.b = ((Boolean)paramObject).booleanValue();
      el.a(4, c, "onSettingUpdate, ReportLocation = " + this.b);
      if (!this.b)
        break;
    }
    while ((this.a) || (this.n <= 0));
    j();
    return;
    i();
    return;
    label140: el.a(6, c, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
  }

  public void b()
  {
    try
    {
      LocationManager localLocationManager = this.i;
      if (localLocationManager != null);
      while (true)
      {
        return;
        this.i = ((LocationManager)do.a().b().getSystemService("location"));
      }
    }
    finally
    {
    }
  }

  public void c()
  {
    try
    {
      el.a(4, c, "Location provider subscribed");
      this.n += 1;
      if ((!this.a) && (this.o < 3))
        j();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d()
  {
    try
    {
      el.a(4, c, "Location provider unsubscribed");
      if (this.n <= 0)
        el.a(6, c, "Error! Unsubscribed too many times!");
      while (true)
      {
        return;
        this.n -= 1;
        if (this.n == 0)
          i();
      }
    }
    finally
    {
    }
  }

  public void e()
  {
    this.p = null;
  }

  public Location f()
  {
    Location localLocation = null;
    if (this.p != null)
      return this.p;
    if (this.b)
    {
      localLocation = b(k());
      if (localLocation != null)
        this.k = localLocation;
      localLocation = this.k;
    }
    el.a(4, c, "getLocation() = " + localLocation);
    return localLocation;
  }

  public void g()
  {
    this.n = 0;
    i();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dz
 * JD-Core Version:    0.6.2
 */