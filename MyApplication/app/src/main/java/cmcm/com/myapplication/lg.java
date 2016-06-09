package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class lg
  implements Callback, le
{
  private static final String a = lg.class.getSimpleName();
  private Context b;
  private int c;
  private Handler d;
  private np e;
  private ConcurrentHashMap f = new ConcurrentHashMap();
  private String[] g;
  private List h;
  private long i;
  private HandlerThread j;
  private volatile boolean k;

  public lg(Context paramContext, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.c = paramInt1;
    this.g = na.f(this.b, this.c);
    paramContext = mr.a(this.b, this.c, paramInt2, this.g, this.f);
    if (paramContext != null)
    {
      this.g = paramContext.a();
      this.i = paramContext.b();
    }
    this.j = new HandlerThread("adRequest", 10);
    this.j.start();
    this.d = new Handler(this.j.getLooper(), this);
  }

  private void a(String paramString)
  {
    int n = this.h.indexOf(paramString);
    int m = this.h.size();
    if (n == m - 1);
    while (true)
    {
      return;
      m -= 1;
      while (m > n)
      {
        if (m - 1 >= 0)
        {
          paramString = (String)this.h.get(m);
          String str = (String)this.h.get(m - 1);
          ((lh)this.f.get(paramString)).c = ((lh)this.f.get(str)).c;
          mv.c(a, "channel :" + paramString + ", used --> channel :" + str);
        }
        m -= 1;
      }
    }
  }

  private long b(String paramString)
  {
    int n = this.h.indexOf(paramString);
    int m = 0;
    long l2;
    for (long l1 = 0L; m < n; l1 = l2 + l1)
    {
      l2 = ((lh)this.f.get(this.h.get(m))).c;
      m += 1;
    }
    return l1;
  }

  private void c()
  {
    String[] arrayOfString = this.g;
    int n = arrayOfString.length;
    int m = 0;
    while (m < n)
    {
      String str = arrayOfString[m];
      if (c(str))
        ((lh)this.f.get(str)).a = false;
      m += 1;
    }
  }

  private boolean c(String paramString)
  {
    return (this.f.containsKey(paramString)) && (this.f.get(paramString) != null);
  }

  public void a()
  {
    if (!np.b(this.b))
      this.e.a(lb.a);
    label281: label294: label298: 
    while (true)
    {
      return;
      this.k = false;
      this.h = Collections.synchronizedList(new ArrayList(this.g.length));
      int n;
      int i1;
      lh locallh;
      int i3;
      synchronized (this.h)
      {
        n = this.g.length;
        m = 0;
        while (m < n)
        {
          this.h.add(this.g[m]);
          m += 1;
        }
        ??? = this.g;
        int i2 = ???.length;
        i1 = 0;
        n = 0;
        if (i1 >= i2)
          break label294;
        String str = ???[i1];
        m = n;
        if (!c(str))
          break label281;
        locallh = (lh)this.f.get(str);
        i3 = locallh.c();
        if ((n == 0) && ("facebook".equals(str)) && (i3 == 0) && (!locallh.a))
        {
          this.d.sendEmptyMessage(100);
          return;
        }
      }
      n += 1;
      int m = n;
      if (i3 > 0)
      {
        li localli = locallh.b();
        m = n;
        if (this.e != null)
        {
          m = n;
          if (localli != null)
          {
            this.e.a(new nq(localli));
            mv.c(a, "onAdLoaded in load method");
          }
        }
      }
      for (m = 1; ; m = 0)
      {
        if (m != 0)
          break label298;
        c();
        this.d.sendEmptyMessage(100);
        return;
        i1 += 1;
        n = m;
        break;
      }
    }
  }

  public final void a(np paramnp)
  {
    this.e = paramnp;
    paramnp = this.g;
    int n = paramnp.length;
    int m = 0;
    while (m < n)
    {
      String str = paramnp[m];
      if (c(str))
        ((lh)this.f.get(str)).a(this.e);
      m += 1;
    }
  }

  public void b()
  {
    this.k = true;
  }

  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default:
    case 100:
    }
    long l1;
    int m;
    do
    {
      return false;
      this.d.removeMessages(100);
      mv.c(a, "scanResult");
      l1 = SystemClock.elapsedRealtime();
      m = 0;
    }
    while ((m != 0) || (this.k));
    label114: label502: label505: label509: 
    while (true)
    {
      Object localObject2;
      long l2;
      int n;
      synchronized (this.h)
      {
        Iterator localIterator = this.h.iterator();
        if (!localIterator.hasNext())
          break label502;
        localObject2 = (String)localIterator.next();
        if (this.k)
        {
          mv.c(a, "Current action has been canceled~");
          break;
        }
        SystemClock.sleep(10L);
        l2 = SystemClock.elapsedRealtime() - l1;
        if (l2 > this.i)
        {
          n = 1;
          m = n;
          if (this.e == null)
            continue;
          this.e.a(lb.f);
          m = n;
        }
      }
      if ((this.f.containsKey(localObject2)) || (this.f.get(localObject2) != null))
      {
        lh locallh = (lh)this.f.get(localObject2);
        mv.c(a, "----------------------------" + (String) localObject2);
        if (!locallh.a)
          if (locallh.c() > 0)
          {
            long l3 = b((String)localObject2);
            mv.c(a, "channel:" + (String) localObject2 + "-->[" + l3 + "," + this.i + "]");
            if ((l2 <= l3) || (l2 >= this.i))
              break label505;
          }
        for (n = 1; ; n = 0)
        {
          if (n == 0)
            break label509;
          localObject2 = locallh.b();
          if ((this.e == null) || (localObject2 == null))
            break;
          this.e.a(new nq((li)localObject2));
          mv.c(a, "onAdLoaded in load method");
          m = 1;
          break label114;
          if (locallh.b)
            break;
          locallh.a();
          mv.c(a, (String) localObject2 + " is refreshing...");
          break;
          if (this.f.keySet().size() <= 1)
          {
            m = 1;
            this.e.a(lb.b);
            break label114;
          }
          a((String)localObject2);
          localObject1.remove();
          mv.c(a, "channel:" + (String) localObject2 + " is error and removed");
          break;
          break label114;
        }
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lg
 * JD-Core Version:    0.6.2
 */