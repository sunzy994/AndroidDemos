package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public abstract class amd
  implements SharedPreferences
{
  protected static final Map<String, amd> a = new HashMap(1);
  protected static final Object b = new Object();
  private static final String i = "Swipe." + amd.class.getSimpleName();
  private static final Object k = new Object();
  Map<String, String> c = new HashMap(0);
  protected boolean d;
  int e = 0;
  protected final String f;
  protected final Context g;
  protected final WeakHashMap<OnSharedPreferenceChangeListener, Object> h = new WeakHashMap();
  private final Object j = new Object();

  protected amd(Context paramContext, String paramString)
  {
    this.g = paramContext.getApplicationContext();
    this.f = paramString;
    this.d = false;
    a();
    f();
  }

  public static amd a(Context paramContext)
  {
    return a(paramContext, asq.s());
  }

  public static amd a(Context paramContext, String paramString)
  {
    synchronized (b)
    {
      amd localamd = (amd)a.get(paramString);
      Object localObject1 = localamd;
      if (localamd == null)
      {
        localObject1 = new amb(paramContext, paramString);
        a.put(paramString, localObject1);
      }
      return localObject1;
    }
  }

  private void a(amf paramamf)
  {
    if (!paramamf.a)
    {
      paramamf.a(true);
      return;
    }
    paramamf.a(a(paramamf.d));
  }

  public static void a(String paramString)
  {
    synchronized (b)
    {
      paramString = (amd)a.remove(paramString);
      if (paramString != null)
        paramString.d();
      return;
    }
  }

  protected void a()
  {
  }

  void a(final amf paramamf, final Runnable paramRunnable)
  {
    int n = 1;
    paramamf = new Runnable()
    {
      public void run()
      {
        synchronized (amd.a(amd.this))
        {
          amd.a(amd.this, paramamf);
        }
        synchronized (amd.this)
        {
          amd localamd = amd.this;
          localamd.e -= 1;
          if (paramRunnable != null)
            paramRunnable.run();
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
    };
    int m;
    if (paramRunnable == null)
      m = 1;
    while (m != 0)
      try
      {
        if (this.e == 1);
        for (m = n; ; m = 0)
        {
          if (m == 0)
            break label65;
          paramamf.run();
          return;
          m = 0;
          break;
        }
      }
      finally
      {
      }
    label65: amc.a().execute(paramamf);
  }

  abstract boolean a(Map<String, String> paramMap);

  boolean b()
  {
    return false;
  }

  abstract void c();

  public boolean contains(String paramString)
  {
    try
    {
      e();
      boolean bool = this.c.containsKey(paramString);
      return bool;
    }
    finally
    {
    }
    throw paramString;
  }

  protected void d()
  {
  }

  protected void e()
  {
    while (!this.d)
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
      }
  }

  public Editor edit()
  {
    try
    {
      e();
      return new ame(this);
    }
    finally
    {
    }
  }

  void f()
  {
    try
    {
      this.d = false;
      new Thread("Settings-load")
      {
        public void run()
        {
          synchronized (amd.this)
          {
            if (amd.this.d)
              return;
          }
          try
          {
            amd.this.c();
            amd.this.d = true;
            amd.this.notifyAll();
            return;
            localObject = finally;
            throw localObject;
          }
          catch (Throwable localThrowable)
          {
            while (true)
              Log.w(amd.g(), "[" + amd.this.f + "] " + "Could not load preferences " + amd.this.f, localThrowable);
          }
        }
      }
      .start();
      return;
    }
    finally
    {
    }
  }

  public Map<String, ?> getAll()
  {
    try
    {
      e();
      HashMap localHashMap = new HashMap(this.c);
      return localHashMap;
    }
    finally
    {
    }
  }

  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      e();
      paramString = (String)this.c.get(paramString);
      boolean bool = paramBoolean;
      if (paramString != null);
      try
      {
        bool = Boolean.parseBoolean(paramString);
        return bool;
      }
      catch (Throwable paramString)
      {
        return paramBoolean;
      }
    }
    finally
    {
    }
    throw paramString;
  }

  public float getFloat(String paramString, float paramFloat)
  {
    try
    {
      e();
      paramFloat = asi.a((String) this.c.get(paramString), paramFloat);
      return paramFloat;
    }
    finally
    {
    }
    throw paramString;
  }

  public int getInt(String paramString, int paramInt)
  {
    try
    {
      e();
      paramInt = asi.a((String) this.c.get(paramString), paramInt);
      return paramInt;
    }
    finally
    {
    }
    throw paramString;
  }

  public long getLong(String paramString, long paramLong)
  {
    try
    {
      e();
      paramLong = asi.a((String) this.c.get(paramString), paramLong);
      return paramLong;
    }
    finally
    {
    }
    throw paramString;
  }

  public String getString(String paramString1, String paramString2)
  {
    while (true)
    {
      try
      {
        e();
        paramString1 = (String)this.c.get(paramString1);
        if (paramString1 != null)
          return paramString1;
      }
      finally
      {
      }
      paramString1 = paramString2;
    }
  }

  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    try
    {
      e();
      paramString = (String)this.c.get(paramString);
      if (paramString == null)
        return paramSet;
      paramString = TextUtils.split(paramString, ",");
      if ((paramString == null) || (paramString.length <= 0))
      {
        paramString = new HashSet(0);
        return paramString;
      }
    }
    finally
    {
    }
    paramString = new HashSet(Arrays.asList(paramString));
    return paramString;
  }

  public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      this.h.put(paramOnSharedPreferenceChangeListener, k);
      return;
    }
    finally
    {
    }
    throw paramOnSharedPreferenceChangeListener;
  }

  public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      this.h.remove(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally
    {
    }
    throw paramOnSharedPreferenceChangeListener;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amd
 * JD-Core Version:    0.6.2
 */