package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class aba extends ars
  implements abr
{
  private static final String f = "Swipe." + aba.class.getSimpleName();
  private static final int[] g = new int[abd.e];
  private static final Runnable p = new Runnable()
  {
    public void run()
    {
      abd.a(true);
    }
  };
  protected final Context a;
  protected final int b;
  protected WeakReference<abp> c;
  protected WeakReference<abr> d;
  private final Set<Integer> h = new HashSet(2);
  private int i;
  private final int j;
  private abt k;
  private final Set<abt> l = Collections.synchronizedSet(new LinkedHashSet(1));
  private volatile boolean m;
  private final long n;
  private volatile boolean o;

  static
  {
    Arrays.fill(g, 5);
  }

  public aba(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, null);
  }

  public aba(Context paramContext, int paramInt1, int paramInt2, abp paramabp)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramInt1;
    this.j = paramInt2;
    long l1;
    if ((1 == paramInt1) || (7 == paramInt1))
    {
      l1 = 15000L;
      this.n = l1;
      if (paramabp == null)
        break label98;
    }
    label98: for (paramContext = new WeakReference(paramabp); ; paramContext = null)
    {
      this.c = paramContext;
      return;
      l1 = 0L;
      break;
    }
  }

  public aba(Context paramContext, int paramInt, abp paramabp)
  {
    this(paramContext, paramInt, -1, null);
  }

  private abq a(boolean paramBoolean, abp paramabp)
  {
    a(paramabp);
    return b(paramBoolean);
  }

  private abq b(boolean paramBoolean)
  {
    return a(paramBoolean, true);
  }

  private String r()
  {
    switch (this.i)
    {
    default:
      return null;
    case 2:
      return abd.b(this.b);
    case 1:
    }
    return abd.c(this.b);
  }

  public abq a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.o = false;
    this.m = false;
    this.e.removeCallbacks(p);
    this.e.postDelayed(p, 60000L);
    if ((this.k != null) && (paramBoolean2))
    {
      this.k.b();
      this.k.m();
      this.k = null;
    }
    if (paramBoolean1)
    {
      this.h.clear();
      this.i = -1;
      m();
    }
    if (o())
    {
      this.k = b(true, false);
      if (this.k != null)
        return this.k;
      if (c() != null)
        return this.k;
      synchronized (this.l)
      {
        Iterator localIterator = this.l.iterator();
        while (localIterator.hasNext())
        {
          abt localabt = (abt)localIterator.next();
          if (localabt != null)
            this.h.add(Integer.valueOf(localabt.a()));
        }
      }
      if (a(true) != null)
        return this.k;
    }
    a(null, false, -3, "Ad is null");
    return this.k;
  }

  protected abt a(boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) || (this.l.size() < 1))
    {
      if (-1 != this.i)
        this.h.add(Integer.valueOf(this.i));
      this.i = abd.a(this.b, this.h);
      if (this.j != -1)
        this.i = this.j;
      String str = r();
      paramBoolean = bool;
      if (1 != this.i)
        if (!j())
          break label154;
      label154: for (paramBoolean = bool; ; paramBoolean = false)
      {
        this.k = new abt(this.b, this).a(this.a, this.i, str, paramBoolean);
        if (this.k == null)
          break;
        this.l.add(this.k);
        return this.k;
      }
    }
    return null;
  }

  public void a(long paramLong)
  {
    if (this.k != null)
      this.k.a(paramLong);
  }

  public void a(abp paramabp)
  {
    if (this.c != null)
      this.c.clear();
    if (paramabp != null)
    {
      this.c = new WeakReference(paramabp);
      return;
    }
    this.c = null;
  }

  public void a(abq paramabq)
  {
    if ((paramabq == this.k) && (this.d != null) && (this.d.get() != null));
    try
    {
      ((abr)this.d.get()).a(paramabq);
      label41: if ((paramabq == this.k) && (this.c != null) && (this.c.get() != null));
      try
      {
        ((abp)this.c.get()).a(paramabq);
        return;
      }
      catch (Throwable paramabq)
      {
      }
    }
    catch (Throwable localThrowable)
    {
      break label41;
    }
  }

  public void a(abq paramabq, boolean paramBoolean)
  {
    if ((paramabq != this.k) || (this.m) || (this.o));
    while (true)
    {
      return;
      if ((paramBoolean) && (!j()))
        continue;
      q();
      if ((this.d != null) && (this.d.get() != null));
      try
      {
        ((abr)this.d.get()).a(paramabq, paramBoolean);
        label72: if ((this.c != null) && (this.c.get() != null))
          try
          {
            boolean bool = ((abp)this.c.get()).i_();
            View localView = ((abp)this.c.get()).b(paramabq);
            if (localView != null)
            {
              if (1 == paramabq.a())
                localView.setTag(((abp)this.c.get()).getAdViewHolder());
              if (1 == this.b)
                ((aei)((abp)this.c.get()).getAdViewHolder()).e(paramabq);
              this.k.a(localView, bool);
              ((abp)this.c.get()).getAdViewHolder().a(paramabq);
              if ((!bool) && (2 != this.b))
                this.l.remove(paramabq);
              ((abp)this.c.get()).c(paramabq);
            }
            ((abp)this.c.get()).a(paramabq, paramBoolean);
            return;
          }
          catch (Throwable localThrowable)
          {
            try
            {
              ((abp)this.c.get()).a(paramabq, paramBoolean, -4, "Bind failure");
              return;
            }
            catch (Throwable paramabq)
            {
              return;
            }
          }
        if (!paramBoolean)
          continue;
        a((abt)paramabq);
        return;
      }
      catch (Exception localException)
      {
        break label72;
      }
    }
  }

  public void a(abq paramabq, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramabq != null) && (-1 != paramInt))
      this.l.remove(paramabq);
    if ((this.k != paramabq) || (this.o));
    while (true)
    {
      return;
      if ((this.m) || (n() >= g[this.b]))
      {
        q();
        if (this.m)
          this.o = true;
        if ((this.d == null) || (this.d.get() == null));
      }
      try
      {
        ((abr)this.d.get()).a(paramabq, paramBoolean, paramInt, paramString);
        label111: if ((this.c == null) || (this.c.get() == null))
          continue;
        try
        {
          ((abp)this.c.get()).a(paramabq, paramBoolean, paramInt, paramString);
          return;
        }
        catch (Throwable paramabq)
        {
          return;
        }
        b(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label111;
      }
    }
  }

  public void a(abr paramabr)
  {
    if (this.d != null)
      this.d.clear();
    if (paramabr != null)
    {
      this.d = new WeakReference(paramabr);
      return;
    }
    this.d = null;
  }

  protected void a(abt paramabt)
  {
    paramabt.q();
  }

  public boolean a()
  {
    boolean bool = false;
    if (b(false, false) != null)
      bool = true;
    return bool;
  }

  public abq b()
  {
    return a(true, true);
  }

  public abq b(abp paramabp)
  {
    return a(true, paramabp);
  }

  protected abt b(boolean paramBoolean1, boolean paramBoolean2)
  {
    while (true)
    {
      abt localabt;
      synchronized (this.l)
      {
        if (this.l.size() <= 0)
          break;
        Iterator localIterator = this.l.iterator();
        if (!localIterator.hasNext())
          break;
        localabt = (abt)localIterator.next();
        if (localabt.t())
          localIterator.remove();
      }
      if ((localabt.u()) && (!paramBoolean2))
      {
        localObject.remove();
      }
      else if (localabt.v())
      {
        if (14 == this.b)
        {
          long l1 = aat.b();
          if ((l1 <= 0L) || (System.currentTimeMillis() - localabt.o() > l1))
            localObject.remove();
        }
        else
        {
          localObject.remove();
        }
      }
      else
      {
        if (localabt.s())
        {
          if (paramBoolean1)
          {
            this.k = localabt;
            a(localabt, false);
          }
          return localabt;
        }
        if (localabt.r())
        {
          if (paramBoolean1)
          {
            this.k = localabt;
            a(localabt, true);
          }
          return localabt;
        }
      }
    }
    return null;
  }

  protected abt c()
  {
    return a(false);
  }

  public void d()
  {
    if (this.k != null)
      this.k.n();
  }

  public void e()
  {
    if (this.k != null)
      this.k.b();
  }

  public void f()
  {
    q();
    this.o = true;
    if (this.k != null)
    {
      this.k.b();
      this.k.m();
    }
    if ((this.c != null) && (this.c.get() != null));
    try
    {
      ((abp)this.c.get()).getAdViewHolder().a();
      label65: a(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label65;
    }
  }

  protected long g()
  {
    return this.n;
  }

  public void h()
  {
    this.m = true;
    a(this.k, false, -1, "Timeout");
  }

  protected int i()
  {
    return g[this.b];
  }

  protected boolean j()
  {
    return (2 == this.b) || (this.b == 0) || (8 == this.b) || (11 == this.b) || (14 == this.b);
  }

  public int k()
  {
    return this.b;
  }

  public abt l()
  {
    return b(false, false);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aba
 * JD-Core Version:    0.6.2
 */