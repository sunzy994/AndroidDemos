package cmcm.com.myapplication;

import android.content.Context;
import com.lazyswipe.SwipeApplication;
import java.util.List;

public abstract class aao
{
  protected static final String a = "Swipe." + aao.class.getSimpleName();
  protected List<yw> b;

  public static final int b(Context paramContext)
  {
    if (ahy.d(paramContext))
      return 13;
    return 9;
  }

  public abstract String a(Context paramContext);

  public yw a(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0) || (paramInt >= this.b.size()))
      return null;
    return (yw)this.b.get(paramInt);
  }

  public abstract void a(SwipeApplication paramSwipeApplication);

  public void a(SwipeApplication paramSwipeApplication, boolean paramBoolean)
  {
    if (paramBoolean)
      g();
    a(paramSwipeApplication);
  }

  public void a(List<yw> paramList, int paramInt1, int paramInt2, xy paramxy)
  {
    if (paramList == null)
      return;
    this.b.clear();
    this.b.addAll(paramList);
  }

  protected void a(yw paramyw)
  {
  }

  public boolean a(Context paramContext, yb paramyb)
  {
    paramyb = paramyb.getCurrentTab().b();
    if (b().equals(paramyb))
      return false;
    vy.a(paramContext, "B08", String.valueOf(c()));
    try
    {
      vs.g(paramContext, b());
      return true;
    }
    catch (Exception paramContext)
    {
      while (true)
        asq.b(paramContext, 5, a, "onEnter");
    }
  }

  public int b(yw paramyw)
  {
    if (this.b != null)
      return this.b.indexOf(paramyw);
    return -1;
  }

  public abstract String b();

  public boolean b_()
  {
    return this.b == null;
  }

  public int c()
  {
    return 0;
  }

  public int c(yw paramyw)
  {
    int i = b(paramyw);
    if (i < 0)
      return i;
    a(paramyw);
    this.b.remove(i);
    return i;
  }

  public List<yw> c(Context paramContext)
  {
    paramContext = (SwipeApplication)paramContext.getApplicationContext();
    if (this.b == null)
    {
      auu.a("Started loading icons for tab " + toString());
      a(paramContext);
      auu.a("Finished loading icons");
    }
    return this.b;
  }

  public boolean d()
  {
    return true;
  }

  public boolean e()
  {
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof aao)))
      return false;
    paramObject = (aao)paramObject;
    return b().equals(paramObject.b());
  }

  public void g()
  {
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
  }

  public boolean h()
  {
    return false;
  }

  public int hashCode()
  {
    return b().hashCode();
  }

  public int i()
  {
    if (this.b == null)
      return 0;
    return this.b.size();
  }

  public String toString()
  {
    return b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aao
 * JD-Core Version:    0.6.2
 */