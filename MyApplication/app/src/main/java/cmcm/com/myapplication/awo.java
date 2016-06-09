package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class awo
{
  private final Context a;
  private final Resources b;
  private final ArrayList<awr> c;
  private final ArrayList<awr> d;
  private boolean e;
  private final ArrayList<awr> f;
  private final ArrayList<awr> g;
  private boolean h;
  private int i = 0;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private final CopyOnWriteArrayList<WeakReference<awu>> m = new CopyOnWriteArrayList();

  public awo(Context paramContext)
  {
    this.a = paramContext;
    this.b = paramContext.getResources();
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.e = true;
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = true;
  }

  private awp b(int paramInt, CharSequence paramCharSequence)
  {
    paramCharSequence = new awr(this, paramInt, paramCharSequence, this.i);
    this.c.add(paramCharSequence);
    b(true);
    return paramCharSequence;
  }

  private void c(boolean paramBoolean)
  {
    if (this.m.isEmpty())
      return;
    e();
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      awu localawu = (awu)localWeakReference.get();
      if (localawu == null)
        this.m.remove(localWeakReference);
      else
        localawu.a(paramBoolean);
    }
    f();
  }

  public awp a(int paramInt)
  {
    return (awp)this.c.get(paramInt);
  }

  public awp a(int paramInt, CharSequence paramCharSequence)
  {
    return b(paramInt, paramCharSequence);
  }

  public void a()
  {
    this.c.clear();
    b(true);
  }

  public void a(awu paramawu)
  {
    this.m.add(new WeakReference(paramawu));
    paramawu.a(this.a, this);
    this.h = true;
  }

  final void a(boolean paramBoolean)
  {
    if (this.l)
      return;
    this.l = true;
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      awu localawu = (awu)localWeakReference.get();
      if (localawu == null)
        this.m.remove(localWeakReference);
      else
        localawu.a(this, paramBoolean);
    }
    this.l = false;
  }

  public boolean a(awp paramawp, int paramInt)
  {
    paramawp = (awr)paramawp;
    if ((paramawp == null) || (!paramawp.d()))
      return false;
    return paramawp.c();
  }

  public int b()
  {
    return this.c.size();
  }

  public void b(boolean paramBoolean)
  {
    if (!this.j)
    {
      if (paramBoolean)
      {
        this.e = true;
        this.h = true;
      }
      c(paramBoolean);
      return;
    }
    this.k = true;
  }

  public Context c()
  {
    return this.a;
  }

  public void d()
  {
    a(true);
  }

  public void e()
  {
    if (!this.j)
    {
      this.j = true;
      this.k = false;
    }
  }

  public void f()
  {
    this.j = false;
    if (this.k)
    {
      this.k = false;
      b(true);
    }
  }

  public ArrayList<awr> g()
  {
    if (!this.e)
      return this.d;
    this.d.clear();
    int i1 = this.c.size();
    int n = 0;
    while (n < i1)
    {
      awr localawr = (awr)this.c.get(n);
      if (localawr.i())
        this.d.add(localawr);
      n += 1;
    }
    this.e = false;
    this.h = true;
    return this.d;
  }

  public void h()
  {
    if (!this.h)
      return;
    Object localObject1 = this.m.iterator();
    int n = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      awu localawu = (awu)((WeakReference)localObject2).get();
      if (localawu == null)
        this.m.remove(localObject2);
      while (true)
      {
        break;
        n = localawu.d() | n;
      }
    }
    if (n != 0)
    {
      this.f.clear();
      this.g.clear();
      localObject1 = g();
      int i2 = ((ArrayList)localObject1).size();
      n = 0;
      if (n < i2)
      {
        localObject2 = (awr)((ArrayList)localObject1).get(n);
        if (((awr)localObject2).j())
          this.f.add(localObject2);
        while (true)
        {
          int i1;
          n += 1;
          break;
          this.g.add(localObject2);
        }
      }
    }
    else
    {
      this.f.clear();
      this.g.clear();
      this.g.addAll(g());
    }
    this.h = false;
  }

  public ArrayList<awr> i()
  {
    h();
    return this.g;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awo
 * JD-Core Version:    0.6.2
 */