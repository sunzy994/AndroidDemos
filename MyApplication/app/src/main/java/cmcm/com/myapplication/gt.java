package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;

public class gt
{
  static final hc a = new gu();
  private WeakReference<View> b;
  private Runnable c = null;
  private Runnable d = null;
  private int e = -1;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new hb();
      return;
    }
    if (i >= 19)
    {
      a = new ha();
      return;
    }
    if (i >= 18)
    {
      a = new gy();
      return;
    }
    if (i >= 16)
    {
      a = new gz();
      return;
    }
    if (i >= 14)
    {
      a = new gw();
      return;
    }
  }

  gt(View paramView)
  {
    this.b = new WeakReference(paramView);
  }

  public gt a(float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null)
      a.a(this, localView, paramFloat);
    return this;
  }

  public gt a(long paramLong)
  {
    View localView = (View)this.b.get();
    if (localView != null)
      a.a(this, localView, paramLong);
    return this;
  }

  public gt a(hf paramhf)
  {
    View localView = (View)this.b.get();
    if (localView != null)
      a.a(this, localView, paramhf);
    return this;
  }

  public void a()
  {
    View localView = (View)this.b.get();
    if (localView != null)
      a.a(this, localView);
  }

  public gt b(float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null)
      a.b(this, localView, paramFloat);
    return this;
  }

  public void b()
  {
    View localView = (View)this.b.get();
    if (localView != null)
      a.b(this, localView);
  }

  public gt c(float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null)
      a.c(this, localView, paramFloat);
    return this;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     gt
 * JD-Core Version:    0.6.2
 */