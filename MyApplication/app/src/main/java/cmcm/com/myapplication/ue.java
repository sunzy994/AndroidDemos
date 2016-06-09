package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.holaverse.charging.model.Battery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

public class ue
{
  private static Battery c;
  private static long e;
  private Context a;
  private up b;
  private int d;
  private Timer f;
  private ug g;
  private List<uj> h = new ArrayList();
  private uf i = new uf(this);

  private void a(long paramLong)
  {
    this.b.a("modelSlowStartTime", Long.valueOf(paramLong));
  }

  public static Battery b(Context paramContext)
  {
    uo.a("getBatteryStatus batteyAcitivyt");
    return b(paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
  }

  private static Battery b(Intent paramIntent)
  {
    if (paramIntent == null)
      return null;
    Battery localBattery = new Battery();
    int j = paramIntent.getIntExtra("plugged", -1);
    int k = paramIntent.getIntExtra("level", -1);
    int m = paramIntent.getIntExtra("scale", -1);
    localBattery.c = j;
    localBattery.a = k;
    localBattery.b = m;
    b(localBattery);
    c = localBattery;
    return localBattery;
  }

  private static void b(Battery paramBattery)
  {
    if (paramBattery.b != 100)
    {
      paramBattery.a = Math.round(100.0F * paramBattery.a / paramBattery.b);
      paramBattery.b = 100;
    }
    long l2 = 0L;
    long l1 = l2;
    switch (paramBattery.c)
    {
    default:
      l1 = l2;
    case 3:
    case 1:
    case 2:
    case 4:
    }
    while (!paramBattery.a())
    {
      paramBattery.f = -1;
      return;
      l1 = 78000L;
      continue;
      l1 = 90000L;
      continue;
      l1 = 120000L;
    }
    if (paramBattery.a <= 10)
    {
      paramBattery.f = 0;
      paramBattery.e = (l1 * (paramBattery.b - paramBattery.a));
      return;
    }
    if (paramBattery.a < 100)
    {
      paramBattery.f = 1;
      paramBattery.e = (l1 * (paramBattery.b - paramBattery.a));
      return;
    }
    if (System.currentTimeMillis() - e < 600000L)
    {
      paramBattery.f = 2;
      paramBattery.e = (600000L - (System.currentTimeMillis() - e));
      return;
    }
    paramBattery.f = 3;
  }

  private void c(Battery paramBattery)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
      ((uj)localIterator.next()).a(paramBattery);
  }

  private void g()
  {
    e = ((Long)this.b.b("modelSlowStartTime", Long.valueOf(0L))).longValue();
    uo.a("readChargingSlowTime " + e);
  }

  public Battery a()
  {
    return c;
  }

  public void a(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      if (this.g != null)
      {
        this.g.cancel();
        this.g = null;
      }
      if (this.d != 2)
        break label145;
      if (e <= 0L)
      {
        e = System.currentTimeMillis();
        a(e);
      }
      if (this.f == null)
        this.f = new Timer();
      if (this.g != null)
      {
        this.g.cancel();
        this.g = null;
      }
      this.g = new ug(this);
      this.f.schedule(this.g, 0L, 60000L);
    }
    while (true)
    {
      c.f = this.d;
      c(c);
      return;
      label145: if (this.d != 3)
      {
        e = 0L;
        a(e);
      }
    }
  }

  public void a(Context paramContext)
  {
    uo.a("onCreate");
    this.a = paramContext;
    this.b = up.a(paramContext, "BATTERY_LOG");
    g();
    this.i.a(paramContext);
  }

  public void a(Battery paramBattery)
  {
    if (paramBattery != null)
    {
      uo.a("onBatteryChanged BatteryActivity");
      a(paramBattery.f);
      c(paramBattery);
    }
  }

  public void a(uj paramuj)
  {
    if (paramuj == null)
      uo.a("addOnBatteryChangedListener null");
    do
    {
      return;
      this.h.add(paramuj);
      if (c == null)
        c = b(this.a);
    }
    while (c == null);
    paramuj.a(c);
  }

  public void b()
  {
    if (this.g != null)
      this.g.cancel();
    if (this.f != null)
      this.f.cancel();
    this.i.c();
    uo.a("onDestroy");
  }

  public void b(uj paramuj)
  {
    this.h.remove(paramuj);
  }

  public void c()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
      ((uj)localIterator.next()).a();
  }

  public void d()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
      ((uj)localIterator.next()).b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ue
 * JD-Core Version:    0.6.2
 */