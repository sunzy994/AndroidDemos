package cmcm.com.myapplication;

import android.view.View;
import java.util.WeakHashMap;

class gu
  implements hc
{
  WeakHashMap<View, Runnable> a = null;

  private void a(View paramView)
  {
    if (this.a != null)
    {
      Runnable localRunnable = (Runnable)this.a.get(paramView);
      if (localRunnable != null)
        paramView.removeCallbacks(localRunnable);
    }
  }

  private void c(gt paramgt, View paramView)
  {
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof hf));
    for (localObject = (hf)localObject; ; localObject = null)
    {
      Runnable localRunnable = gt.a(paramgt);
      paramgt = gt.b(paramgt);
      if (localRunnable != null)
        localRunnable.run();
      if (localObject != null)
      {
        ((hf)localObject).a(paramView);
        ((hf)localObject).b(paramView);
      }
      if (paramgt != null)
        paramgt.run();
      if (this.a != null)
        this.a.remove(paramView);
      return;
    }
  }

  private void d(gt paramgt, View paramView)
  {
    if (this.a != null);
    for (Runnable localRunnable = (Runnable)this.a.get(paramView); ; localRunnable = null)
    {
      Object localObject = localRunnable;
      if (localRunnable == null)
      {
        localObject = new gv(this, paramgt, paramView, null);
        if (this.a == null)
          this.a = new WeakHashMap();
        this.a.put(paramView, localObject);
      }
      paramView.removeCallbacks((Runnable)localObject);
      paramView.post((Runnable)localObject);
      return;
    }
  }

  public void a(gt paramgt, View paramView)
  {
    d(paramgt, paramView);
  }

  public void a(gt paramgt, View paramView, float paramFloat)
  {
    d(paramgt, paramView);
  }

  public void a(gt paramgt, View paramView, long paramLong)
  {
  }

  public void a(gt paramgt, View paramView, hf paramhf)
  {
    paramView.setTag(2113929216, paramhf);
  }

  public void b(gt paramgt, View paramView)
  {
    a(paramView);
    c(paramgt, paramView);
  }

  public void b(gt paramgt, View paramView, float paramFloat)
  {
    d(paramgt, paramView);
  }

  public void c(gt paramgt, View paramView, float paramFloat)
  {
    d(paramgt, paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     gu
 * JD-Core Version:    0.6.2
 */