package cmcm.com.myapplication;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;

public final class ame
  implements SharedPreferences.Editor
{
  private final Map<String, String> b = new HashMap();
  private boolean c = false;

  public ame(amd paramamd)
  {
  }

  private amf a()
  {
    return b(false);
  }

  private amf b(boolean paramBoolean)
  {
    amf localamf = new amf(null);
    Iterator localIterator;
    String str2;
    while (true)
    {
      synchronized (this.a)
      {
        if (this.a.e > 0)
          this.a.c = new HashMap(this.a.c);
        Object localObject1;
        if (!paramBoolean)
        {
          localamf.d = this.b;
          localObject1 = this.a;
          ((amd)localObject1).e += 1;
        }
        if (this.a.h.size() > 0)
        {
          i = 1;
          if (i != 0)
          {
            localamf.b = new ArrayList();
            localamf.c = new HashSet(this.a.h.keySet());
          }
          try
          {
            if (this.c)
            {
              if (!this.a.c.isEmpty())
              {
                localamf.a = true;
                this.a.c.clear();
              }
              this.c = false;
            }
            localIterator = this.b.entrySet().iterator();
            if (!localIterator.hasNext())
              break label426;
            localObject1 = (Entry)localIterator.next();
            str2 = (String)((Entry)localObject1).getKey();
            localObject1 = (String)((Entry)localObject1).getValue();
            if (localObject1 != null)
              break;
            if (this.a.c.containsKey(str2))
              break label283;
            localIterator.remove();
            continue;
          }
          finally
          {
          }
        }
      }
      int i = 0;
      continue;
      label283: this.a.c.remove(str2);
      label298: localamf.a = true;
      if (i != 0)
        localamf.b.add(str2);
    }
    String str1;
    if (this.a.b())
      str1 = localObject3.substring(0, localObject3.length() - 1);
    while (true)
    {
      if (this.a.c.containsKey(str2))
      {
        String str3 = (String)this.a.c.get(str2);
        if ((str3 != null) && (str3.equals(str1)))
        {
          localIterator.remove();
          break;
        }
      }
      this.a.c.put(str2, str1);
      break label298;
      label426: return localamf;
    }
  }

  void a(final amf paramamf)
  {
    if ((paramamf.c == null) || (paramamf.b == null) || (paramamf.b.size() == 0));
    while (true)
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
        break;
      int i = paramamf.b.size() - 1;
      while (i >= 0)
      {
        String str = (String)paramamf.b.get(i);
        Iterator localIterator = paramamf.c.iterator();
        while (localIterator.hasNext())
        {
          SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next();
          if (localOnSharedPreferenceChangeListener != null)
            localOnSharedPreferenceChangeListener.onSharedPreferenceChanged(this.a, str);
        }
        i -= 1;
      }
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        ame.this.a(paramamf);
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    final amf localamf = b(paramBoolean);
    if (!paramBoolean)
    {
      Object localObject = new Runnable()
      {
        public void run()
        {
          try
          {
            localamf.e.await();
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
          }
        }
      };
      amc.a((Runnable)localObject);
      localObject = new Runnable()
      {
        public void run()
        {
          this.a.run();
          amc.b(this.a);
        }
      };
      this.a.a(localamf, (Runnable)localObject);
    }
    a(localamf);
  }

  public void apply()
  {
    a(false);
  }

  public SharedPreferences.Editor clear()
  {
    try
    {
      this.c = true;
      return this;
    }
    finally
    {
    }
  }

  public boolean commit()
  {
    amf localamf = a();
    this.a.a(localamf, null);
    try
    {
      localamf.e.await();
      a(localamf);
      return localamf.f;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    return false;
  }

  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      String str2 = Boolean.toString(paramBoolean);
      String str1 = str2;
      if (this.a.b())
        str1 = str2 + 1;
      this.b.put(paramString, str1);
      return this;
    }
    finally
    {
    }
    throw paramString;
  }

  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    try
    {
      String str2 = Float.toString(paramFloat);
      String str1 = str2;
      if (this.a.b())
        str1 = str2 + 4;
      this.b.put(paramString, str1);
      return this;
    }
    finally
    {
    }
    throw paramString;
  }

  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    try
    {
      String str2 = Integer.toString(paramInt);
      String str1 = str2;
      if (this.a.b())
        str1 = str2 + 2;
      this.b.put(paramString, str1);
      return this;
    }
    finally
    {
    }
    throw paramString;
  }

  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    try
    {
      String str2 = Long.toString(paramLong);
      String str1 = str2;
      if (this.a.b())
        str1 = str2 + 3;
      this.b.put(paramString, str1);
      return this;
    }
    finally
    {
    }
    throw paramString;
  }

  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    if (paramString2 != null);
    for (String str = paramString2; ; str = null)
      try
      {
        if (this.a.b())
          str = paramString2 + 0;
        this.b.put(paramString1, str);
        return this;
      }
      finally
      {
      }
  }

  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    if (paramSet != null);
    try
    {
      if (paramSet.size() <= 0)
        this.b.put(paramString, null);
      while (true)
      {
        return this;
        String str = TextUtils.join(",", paramSet);
        paramSet = str;
        if (this.a.b())
          paramSet = str + 5;
        this.b.put(paramString, paramSet);
      }
    }
    finally
    {
    }
    throw paramString;
  }

  public SharedPreferences.Editor remove(String paramString)
  {
    try
    {
      this.b.put(paramString, null);
      return this;
    }
    finally
    {
    }
    throw paramString;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ame
 * JD-Core Version:    0.6.2
 */