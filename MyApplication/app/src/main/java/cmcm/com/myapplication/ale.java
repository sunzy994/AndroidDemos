package cmcm.com.myapplication;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ale
{
  private static final Interpolator k = new AccelerateDecelerateInterpolator();
  protected long a = 0L;
  protected int b = 300;
  protected Interpolator c;
  protected boolean d;
  protected ArrayList<alf> e;
  private int f = 0;
  private int g = 0;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;

  public ale a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }

  public ale a(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }

  protected void a()
  {
    if (this.e != null)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
        ((alf)localIterator.next()).a(this);
    }
  }

  protected void b()
  {
    if (this.e != null)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
        ((alf)localIterator.next()).d(this);
    }
  }

  protected abstract float c();

  public void e()
  {
    if (this.d)
      return;
    this.d = true;
    a();
  }

  public void f()
  {
    if (this.d)
    {
      this.d = false;
      g();
    }
  }

  protected void g()
  {
    if (this.e != null)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
        ((alf)localIterator.next()).c(this);
    }
  }

  protected void h()
  {
    if (this.e != null)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
        ((alf)localIterator.next()).b(this);
    }
  }

  public boolean i()
  {
    return this.d;
  }

  public float j()
  {
    float f2 = c();
    if (f2 < 0.0F)
      return 0.0F;
    int m;
    float f1;
    if (f2 >= 1.0F)
    {
      m = 1;
      f1 = f2;
      if (f2 > 1.0F)
        f1 = 1.0F;
      if (!this.i)
        break label166;
      f1 = 1.0F - f1;
    }
    label143: label166: 
    while (true)
    {
      boolean bool;
      if (m != 0)
      {
        if (this.f == this.g)
        {
          this.d = false;
          h();
          return 1.0F;
          m = 0;
          break;
        }
        if (this.f > 0)
          this.g += 1;
        if (this.h)
        {
          if (this.i)
            break label143;
          bool = true;
          this.i = bool;
        }
        b();
      }
      if (this.c == null)
        if (this.j)
          f1 = k.getInterpolation(f1);
      while (true)
      {
        return f1;
        bool = false;
        break;
        continue;
        f1 = this.c.getInterpolation(f1);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ale
 * JD-Core Version:    0.6.2
 */