package cmcm.com.myapplication;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.format.Time;
import android.util.Log;
import com.lazyswipe.SettingsService;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherCondition;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class ake
  implements ServiceConnection, Callback
{
  private static final String a = "Swipe." + ake.class.getSimpleName();
  private static final Object h = new Object();
  protected final Handler b;
  protected boolean c = true;
  protected boolean d;
  private ajt e;
  private final Context f;
  private BroadcastReceiver g;
  private final WeakHashMap<ajw, Object> i = new WeakHashMap();
  private City j;
  private WeatherCondition k;
  private boolean l;
  private boolean m;
  private Dialog n;
  private final ajq o = new ajr()
  {
    public void a()
    {
      ake.this.b.removeMessages(1);
      ake.this.b.sendEmptyMessage(1);
    }

    public void a(City paramAnonymousCity, int paramAnonymousInt)
    {
      ake.this.b.removeMessages(2);
      ake.this.b.obtainMessage(2, paramAnonymousInt, 0, paramAnonymousCity).sendToTarget();
    }

    public void a(WeatherCondition paramAnonymousWeatherCondition, int paramAnonymousInt)
    {
      ake.this.b.removeMessages(3);
      ake.this.b.obtainMessage(3, paramAnonymousInt, 0, paramAnonymousWeatherCondition).sendToTarget();
    }
  };

  public ake(Context paramContext)
  {
    this.f = paramContext.getApplicationContext();
    this.b = new Handler(Looper.getMainLooper(), this);
  }

  public ake(Context paramContext, ajw paramajw)
  {
    this(paramContext);
    this.i.put(paramajw, h);
  }

  private void a()
  {
    this.g = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        ake.this.a(paramAnonymousContext, paramAnonymousIntent);
      }
    };
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
    try
    {
      this.f.registerReceiver(this.g, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private boolean a(Time paramTime)
  {
    if (akc.b(paramTime.hour) != this.l);
    for (boolean bool = true; ; bool = false)
    {
      this.l = bool;
      return bool;
    }
  }

  private void b()
  {
    try
    {
      this.f.unregisterReceiver(this.g);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private Time o()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime;
  }

  private void p()
  {
    this.m = false;
    if ((this.n != null) && (this.n.isShowing()))
      this.n.dismiss();
  }

  public WeatherCondition a(String paramString)
  {
    if ((this.k != null) && (this.k.a().b().equals(paramString)))
      return this.k;
    if (this.e != null)
      try
      {
        paramString = this.e.a(paramString);
        return paramString;
      }
      catch (RemoteException paramString)
      {
      }
    return null;
  }

  public List<City> a(City paramCity)
  {
    if (this.e != null)
      try
      {
        paramCity = this.e.a(paramCity);
        return paramCity;
      }
      catch (RemoteException paramCity)
      {
      }
    return null;
  }

  protected void a(ajw paramajw, WeatherCondition paramWeatherCondition, int paramInt)
  {
    if (paramWeatherCondition == null);
    try
    {
      paramajw.a(null, null);
      return;
      paramajw.a(paramWeatherCondition.e(), paramWeatherCondition.a(this.f, false));
      return;
    }
    catch (Throwable paramajw)
    {
    }
  }

  void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.TIME_TICK".equals(paramContext))
    {
      this.b.removeMessages(4);
      this.b.sendEmptyMessage(4);
    }
    while ((!"android.intent.action.DATE_CHANGED".equals(paramContext)) && (!"android.intent.action.TIME_SET".equals(paramContext)) && (!"android.intent.action.TIMEZONE_CHANGED".equals(paramContext)))
      return;
    this.b.removeMessages(4);
    this.b.removeMessages(3);
    this.b.sendEmptyMessage(4);
    this.b.obtainMessage(3, -1, 0, this.k).sendToTarget();
  }

  protected void a(City paramCity, int paramInt)
  {
    p();
    if ((this.m) && (!this.d))
      if (paramCity == null)
        break label89;
    label89: for (Object localObject = this.f.getString(2131230813); ; localObject = this.f.getString(2131230812))
    {
      aso.a(this.f, (String) localObject);
      localObject = this.i.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajw localajw = (ajw)((Iterator)localObject).next();
        try
        {
          localajw.a(paramCity);
        }
        catch (Throwable localThrowable)
        {
        }
      }
    }
  }

  protected void a(WeatherCondition paramWeatherCondition, int paramInt)
  {
    Iterator localIterator = this.i.keySet().iterator();
    while (localIterator.hasNext())
      a((ajw)localIterator.next(), paramWeatherCondition, paramInt);
  }

  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public void c()
  {
    a();
    Intent localIntent = new Intent(this.f, SettingsService.class);
    localIntent.setAction("action.START_WEATHER_SERVICE");
    this.f.bindService(localIntent, this, 1);
  }

  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void d()
  {
    b();
    if (this.e != null);
    try
    {
      this.e.a(this.o);
      label24: this.f.unbindService(this);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label24;
    }
  }

  protected void e()
  {
    Time localTime = o();
    Iterator localIterator = this.i.keySet().iterator();
    while (localIterator.hasNext())
    {
      ajw localajw = (ajw)localIterator.next();
      try
      {
        localajw.a(localTime);
        if (a(localTime))
          a(localajw, this.k, -1);
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  public boolean f()
  {
    return this.e != null;
  }

  public City g()
  {
    if (this.j != null)
      return this.j;
    if (this.e != null)
      try
      {
        City localCity = this.e.a();
        return localCity;
      }
      catch (RemoteException localRemoteException)
      {
      }
    return null;
  }

  public void h()
  {
    if (this.e != null);
    try
    {
      if (!this.e.c())
        m();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default:
      return false;
    case 1:
      m();
      return true;
    case 2:
      localObject = (City)paramMessage.obj;
      if (localObject != null)
      {
        a((City)localObject, paramMessage.arg1);
        if (!((City)localObject).equals(this.j))
        {
          if (this.j != null)
          {
            this.k = null;
            a(null, -1);
          }
          this.j = ((City)localObject);
        }
      }
      while (true)
      {
        return true;
        if (this.j == null)
          a(null, paramMessage.arg1);
      }
    case 3:
      localObject = (WeatherCondition)paramMessage.obj;
      if (localObject != null)
      {
        this.k = ((WeatherCondition)localObject);
        a(this.k, paramMessage.arg1);
      }
      return true;
    case 4:
    }
    e();
    return true;
  }

  public void i()
  {
    if (this.e != null);
    try
    {
      this.e.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public List<City> j()
  {
    if (this.e != null)
      try
      {
        List localList = this.e.f();
        return localList;
      }
      catch (RemoteException localRemoteException)
      {
      }
    return null;
  }

  public void k()
  {
    if (this.e != null);
    try
    {
      this.e.g();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public void l()
  {
    if (this.e != null);
    try
    {
      this.e.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  protected void m()
  {
    this.m = true;
    if (this.d)
    {
      if (this.n == null)
        n();
      if (!this.n.isShowing())
        this.n.show();
    }
    if (this.j == null)
    {
      Iterator localIterator = this.i.keySet().iterator();
      while (localIterator.hasNext())
      {
        ajw localajw = (ajw)localIterator.next();
        try
        {
          localajw.a(null);
        }
        catch (Throwable localThrowable)
        {
        }
      }
    }
  }

  protected void n()
  {
    this.n = new avz(this.f, 2131427344).g(2131230811).a();
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.e = aju.a(paramIBinder);
      this.e.a(this.o, this.c);
      if (this.e != null)
      {
        paramComponentName = this.i.keySet().iterator();
        while (paramComponentName.hasNext())
        {
          paramIBinder = (ajw)paramComponentName.next();
          try
          {
            paramIBinder.a();
          }
          catch (Throwable paramIBinder)
          {
          }
        }
      }
    }
    catch (Throwable paramComponentName)
    {
      while (true)
      {
        Log.w(a, "Could not register weather callback", paramComponentName);
        this.e = null;
      }
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.e = null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ake
 * JD-Core Version:    0.6.2
 */