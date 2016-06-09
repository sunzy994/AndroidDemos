package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherCondition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class akf extends aju
  implements Callback
{
  private static final String b = "Swipe." + akf.class.getSimpleName();
  final RemoteCallbackList<ajq> a = new RemoteCallbackList();
  private final Context c;
  private boolean d;
  private afm e;
  private Runnable f;
  private Handler g;
  private BroadcastReceiver h;
  private boolean i;
  private aka j;

  public akf(Service paramService)
  {
    this.c = paramService;
  }

  private void a(final long paramLong)
  {
    int m;
    int k;
    if (!arl.i(this.c))
    {
      m = this.a.beginBroadcast();
      k = 0;
    }
    while (true)
    {
      if (k < m);
      try
      {
        ((ajq)this.a.getBroadcastItem(k)).a(null, 2);
        label48: k += 1;
        continue;
        this.a.finishBroadcast();
        while (true)
        {
          return;
          if (Looper.myLooper() == null)
          {
            Log.w(b, "Looper is null when init async task. create new looper");
            Looper.prepare();
          }
          Object localObject = new ArrayList(1);
          City localCity = akd.a(this.c);
          if (localCity != null)
            ((List)localObject).add(localCity);
          if (((List)localObject).size() > 0)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              localCity = (City)((Iterator)localObject).next();
              akb local4 = new akb()
              {
                public void a(aks paramAnonymousaks, boolean paramAnonymousBoolean1, int paramAnonymousInt, boolean paramAnonymousBoolean2)
                {
                  try
                  {
                    akd.b(akf.d(akf.this), paramLong);
                    new akh(akf.d(akf.this), this.b, false, this.c).a();
                    return;
                  }
                  catch (Exception paramAnonymousaks)
                  {
                    Log.w(akf.n(), "Unexpected exception", paramAnonymousaks);
                  }
                }

                public void a(boolean paramAnonymousBoolean)
                {
                }
              };
              try
              {
                new aka(this.c, localCity, false, local4).a();
              }
              catch (Exception localException)
              {
                Log.w(b, "Unexpected exception", localException);
              }
            }
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        break label48;
      }
    }
  }

  private boolean a(Date paramDate, long paramLong1, long paramLong2)
  {
    return (paramDate == null) || (paramLong1 - paramDate.getTime() > paramLong2);
  }

  private void b(ajq paramajq)
  {
    try
    {
      if (k())
      {
        paramajq.a();
        return;
      }
      Object localObject = a();
      if (localObject != null)
      {
        paramajq.a((City)localObject, 0);
        localObject = a(((City)localObject).b());
        if (localObject != null)
        {
          paramajq.a((WeatherCondition)localObject, 0);
          return;
        }
        paramajq.a(null, 1);
        return;
      }
      paramajq.a(null, 1);
      return;
    }
    catch (Throwable paramajq)
    {
    }
  }

  private PendingIntent o()
  {
    Intent localIntent = new Intent("com.lazyswipe.WEATHER.ALARM_REFRESH");
    return PendingIntent.getBroadcast(this.c, 0, localIntent, 0);
  }

  private void p()
  {
    ((AlarmManager)this.c.getSystemService("alarm")).cancel(o());
  }

  private boolean q()
  {
    boolean bool = false;
    if (!arl.h(this.c))
      return false;
    PendingIntent localPendingIntent = o();
    AlarmManager localAlarmManager = (AlarmManager)this.c.getSystemService("alarm");
    long l1 = System.currentTimeMillis();
    Date localDate = akd.b(this.c);
    if (u())
    {
      l1 += 21600000L;
      this.g.sendEmptyMessage(9);
      bool = true;
    }
    while (true)
    {
      localAlarmManager.cancel(localPendingIntent);
      localAlarmManager.set(1, l1, localPendingIntent);
      return bool;
      long l2 = localDate.getTime() + 21600000L;
      if (v())
      {
        this.g.sendEmptyMessage(8);
        l1 = Math.min(l2, l1 + 7200000L);
        bool = true;
      }
      else
      {
        l1 = Math.min(l2, akd.c(this.c).getTime() + 7200000L);
      }
    }
  }

  private void r()
  {
    this.h = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ("com.lazyswipe.WEATHER.ALARM_REFRESH".equals(paramAnonymousContext))
          if (!akf.a(akf.this));
        while (true)
        {
          return;
          akf.b(akf.this);
          return;
          if (("android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousContext)) && (!akf.a(akf.this)))
            try
            {
              paramAnonymousContext = (NetworkInfo)paramAnonymousIntent.getParcelableExtra("networkInfo");
              if (paramAnonymousContext.isConnectedOrConnecting())
              {
                if (paramAnonymousContext.isConnected())
                  akf.b(akf.this);
              }
              else
              {
                akf.c(akf.this);
                return;
              }
            }
            catch (Exception paramAnonymousContext)
            {
            }
        }
      }
    };
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("com.lazyswipe.WEATHER.ALARM_REFRESH");
    try
    {
      this.c.registerReceiver(this.h, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void s()
  {
    try
    {
      this.c.unregisterReceiver(this.h);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void t()
  {
    final City localCity = akd.a(this.c);
    if (localCity == null)
      return;
    akb local2 = new akb()
    {
      public void a(aks paramAnonymousaks, boolean paramAnonymousBoolean1, int paramAnonymousInt, boolean paramAnonymousBoolean2)
      {
        if ((paramAnonymousaks != null) && (localCity.equals(akd.a(akf.d(akf.this)))))
        {
          akd.b(akf.d(akf.this), System.currentTimeMillis());
          akf.this.b(localCity);
        }
      }

      public void a(boolean paramAnonymousBoolean)
      {
      }
    };
    if (this.j != null)
      this.j.cancel(false);
    this.j = new aka(this.c, localCity, false, local2);
    this.j.a();
  }

  private boolean u()
  {
    return a(akd.b(this.c), System.currentTimeMillis(), 21600000L);
  }

  private boolean v()
  {
    return a(akd.c(this.c), System.currentTimeMillis(), 7200000L);
  }

  public int a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("extra.START_LOCATING", false)))
      k();
    return -1;
  }

  public City a()
  {
    return akd.a(this.c);
  }

  public WeatherCondition a(String paramString)
  {
    return akd.b(this.c, new City(null, null, paramString));
  }

  public List<City> a(City paramCity)
  {
    a(paramCity, true);
    return f();
  }

  public void a(int paramInt)
  {
  }

  public void a(ajq paramajq)
  {
    if (paramajq != null)
      this.a.unregister(paramajq);
  }

  @TargetApi(17)
  public void a(ajq paramajq, boolean paramBoolean)
  {
    if (paramajq != null)
    {
      if (paramBoolean)
        b(paramajq);
      this.a.register(paramajq);
    }
  }

  void a(final City paramCity, final boolean paramBoolean)
  {
    if (paramCity == null)
      return;
    int m = this.a.beginBroadcast();
    int k = 0;
    while (true)
    {
      if (k < m);
      try
      {
        ((ajq)this.a.getBroadcastItem(k)).a(paramCity, 0);
        label43: k += 1;
        continue;
        this.a.finishBroadcast();
        akd.d(this.c, paramCity);
        paramCity = new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              Process.setThreadPriority(19);
              label5: Object localObject = akd.a(akf.d(akf.this));
              if ((paramBoolean) && ((localObject == null) || (!((City)localObject).equals(paramCity))))
                akd.a(akf.d(akf.this), 0L);
              while (true)
              {
                if (paramBoolean)
                  akd.a(akf.d(akf.this), paramCity);
                akf.b(akf.this);
                return;
                localObject = akd.b(akf.d(akf.this), paramCity);
                if ((localObject == null) || (((WeatherCondition)localObject).c() == null) || (((WeatherCondition)localObject).c().a(false) == null))
                  akd.a(akf.d(akf.this), 0L);
              }
            }
            catch (Exception localException)
            {
              break label5;
            }
          }
        });
        paramCity.setPriority(1);
        paramCity.start();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        break label43;
      }
    }
  }

  // ERROR //
  boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 178	akf:d	Z
    //   9: istore 7
    //   11: iload 7
    //   13: ifeq +10 -> 23
    //   16: iload 6
    //   18: istore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: iload_1
    //   24: ifne +23 -> 47
    //   27: aload_0
    //   28: getfield 76	akf:c	Landroid/content/Context;
    //   31: invokestatic 375	akd:f	(Landroid/content/Context;)Z
    //   34: ifne +120 -> 154
    //   37: aload_0
    //   38: getfield 76	akf:c	Landroid/content/Context;
    //   41: invokestatic 129	akd:a	(Landroid/content/Context;)Lcom/lazyswipe/features/weather/bean/City;
    //   44: ifnonnull +110 -> 154
    //   47: aload_0
    //   48: getfield 76	akf:c	Landroid/content/Context;
    //   51: invokestatic 86	arl:i	(Landroid/content/Context;)Z
    //   54: ifeq +108 -> 162
    //   57: getstatic 66	akf:b	Ljava/lang/String;
    //   60: astore_3
    //   61: iload_1
    //   62: ifeq +62 -> 124
    //   65: ldc_w 377
    //   68: astore_2
    //   69: aload_3
    //   70: aload_2
    //   71: invokestatic 382	asp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: iconst_1
    //   76: putfield 178	akf:d	Z
    //   79: aload_0
    //   80: getfield 74	akf:a	Landroid/os/RemoteCallbackList;
    //   83: invokevirtual 90	android/os/RemoteCallbackList:beginBroadcast	()I
    //   86: istore 5
    //   88: iconst_0
    //   89: istore 4
    //   91: iload 4
    //   93: iload 5
    //   95: if_icmpge +36 -> 131
    //   98: aload_0
    //   99: getfield 74	akf:a	Landroid/os/RemoteCallbackList;
    //   102: iload 4
    //   104: invokevirtual 94	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   107: checkcast 96	ajq
    //   110: invokeinterface 192 1 0
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: istore 4
    //   121: goto -30 -> 91
    //   124: ldc_w 384
    //   127: astore_2
    //   128: goto -59 -> 69
    //   131: aload_0
    //   132: getfield 74	akf:a	Landroid/os/RemoteCallbackList;
    //   135: invokevirtual 102	android/os/RemoteCallbackList:finishBroadcast	()V
    //   138: aload_0
    //   139: getfield 217	akf:g	Landroid/os/Handler;
    //   142: new 18	akf$6
    //   145: dup
    //   146: aload_0
    //   147: invokespecial 385	akf$6:<init>	(Lakf;)V
    //   150: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   153: pop
    //   154: aload_0
    //   155: getfield 178	akf:d	Z
    //   158: istore_1
    //   159: goto -140 -> 19
    //   162: aload_0
    //   163: iconst_2
    //   164: invokevirtual 391	akf:b	(I)V
    //   167: goto -13 -> 154
    //   170: astore_2
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_2
    //   174: athrow
    //   175: astore_2
    //   176: goto -61 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   5	11	170	finally
    //   27	47	170	finally
    //   47	61	170	finally
    //   69	88	170	finally
    //   98	115	170	finally
    //   131	154	170	finally
    //   154	159	170	finally
    //   162	167	170	finally
    //   98	115	175	android/os/RemoteException
  }

  public void b()
  {
    Object localObject = akd.a(this.c);
    if (localObject == null)
      return;
    localObject = akd.b(this.c, (City)localObject);
    if ((localObject == null) || (((WeatherCondition)localObject).c() == null) || (((WeatherCondition)localObject).c().a(false) == null))
      akd.a(this.c, 0L);
    a(System.currentTimeMillis());
  }

  void b(int paramInt)
  {
    int m = this.a.beginBroadcast();
    int k = 0;
    while (true)
    {
      if (k < m);
      try
      {
        ((ajq)this.a.getBroadcastItem(k)).a(null, paramInt);
        label35: k += 1;
        continue;
        this.a.finishBroadcast();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        break label35;
      }
    }
  }

  void b(City paramCity)
  {
    paramCity = akd.b(this.c, paramCity);
    int m = this.a.beginBroadcast();
    int k = 0;
    while (true)
    {
      if (k < m);
      try
      {
        ((ajq)this.a.getBroadcastItem(k)).a(paramCity, 0);
        label44: k += 1;
        continue;
        this.a.finishBroadcast();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        break label44;
      }
    }
  }

  public boolean c()
  {
    if (j())
      return false;
    a(true);
    return true;
  }

  public void d()
  {
    m();
  }

  public boolean e()
  {
    return j();
  }

  public List<City> f()
  {
    return akd.e(this.c);
  }

  public void g()
  {
    akd.d(this.c);
  }

  public void h()
  {
    this.g = new Handler(this);
    r();
    q();
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 8:
    case 9:
    }
    while (true)
    {
      return true;
      t();
      continue;
      a(System.currentTimeMillis());
    }
  }

  public void i()
  {
    if (this.d)
      m();
    s();
    p();
    this.a.kill();
  }

  boolean j()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean k()
  {
    try
    {
      boolean bool = a(false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void l()
  {
    akd.g(this.c);
    afn local7 = new afn()
    {
      public void a(int paramAnonymousInt)
      {
        asp.b(akf.n(), "Could not locate city; error: " + paramAnonymousInt);
        akf.a(akf.this, false);
        akf.this.b(paramAnonymousInt);
        akf.this.m();
        akf.f(akf.this).removeCallbacks(akf.e(akf.this));
      }

      public void a(City paramAnonymousCity)
      {
        if (paramAnonymousCity != null);
        try
        {
          asp.a(akf.n(), "City located: " + paramAnonymousCity.a());
          akf.this.a(paramAnonymousCity, true);
          while (true)
          {
            akf.this.m();
            return;
            asp.b(akf.n(), "City NOT located");
            akf.this.b(1);
          }
        }
        finally
        {
        }
        throw paramAnonymousCity;
      }
    };
    this.e = new afm(this.c);
    this.e.a(local7);
    this.f = new Runnable()
    {
      public void run()
      {
        akf.this.b(3);
        akf.this.m();
      }
    };
    this.g.postDelayed(this.f, 30000L);
  }

  void m()
  {
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
    if (this.f != null)
    {
      this.g.removeCallbacks(this.f);
      this.f = null;
    }
    this.d = false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akf
 * JD-Core Version:    0.6.2
 */