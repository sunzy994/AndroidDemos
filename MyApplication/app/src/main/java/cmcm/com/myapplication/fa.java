package cmcm.com.myapplication;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

class fa
  implements fm
{
  WeakHashMap<View, gt> a = null;

  private boolean a(et paramet, int paramInt)
  {
    boolean bool = true;
    int i = paramet.b();
    int j = paramet.a() - paramet.c();
    if (j == 0)
      bool = false;
    do
    {
      do
      {
        return bool;
        if (paramInt >= 0)
          break;
      }
      while (i > 0);
      return false;
    }
    while (i < j - 1);
    return false;
  }

  private boolean b(et paramet, int paramInt)
  {
    boolean bool = true;
    int i = paramet.e();
    int j = paramet.d() - paramet.f();
    if (j == 0)
      bool = false;
    do
    {
      do
      {
        return bool;
        if (paramInt >= 0)
          break;
      }
      while (i > 0);
      return false;
    }
    while (i < j - 1);
    return false;
  }

  public int a(View paramView)
  {
    return 2;
  }

  long a()
  {
    return 10L;
  }

  public void a(View paramView, float paramFloat)
  {
  }

  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void a(View paramView, int paramInt, Paint paramPaint)
  {
  }

  public void a(View paramView, dh paramdh)
  {
  }

  public void a(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, a());
  }

  public void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postDelayed(paramRunnable, a() + paramLong);
  }

  public void a(View paramView, boolean paramBoolean)
  {
  }

  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
  }

  public boolean a(View paramView, int paramInt)
  {
    return ((paramView instanceof et)) && (a((et)paramView, paramInt));
  }

  public void b(View paramView, float paramFloat)
  {
  }

  public boolean b(View paramView)
  {
    return false;
  }

  public boolean b(View paramView, int paramInt)
  {
    return ((paramView instanceof et)) && (b((et)paramView, paramInt));
  }

  public void c(View paramView, float paramFloat)
  {
  }

  public void c(View paramView, int paramInt)
  {
  }

  public boolean c(View paramView)
  {
    return false;
  }

  public void d(View paramView)
  {
    paramView.invalidate();
  }

  public void d(View paramView, float paramFloat)
  {
  }

  public int e(View paramView)
  {
    return 0;
  }

  public void e(View paramView, float paramFloat)
  {
  }

  public float f(View paramView)
  {
    return 1.0F;
  }

  public void f(View paramView, float paramFloat)
  {
  }

  public int g(View paramView)
  {
    return 0;
  }

  public int h(View paramView)
  {
    return 0;
  }

  public boolean i(View paramView)
  {
    return true;
  }

  public float j(View paramView)
  {
    return 0.0F;
  }

  public float k(View paramView)
  {
    return 0.0F;
  }

  public float l(View paramView)
  {
    return 0.0F;
  }

  public int m(View paramView)
  {
    return fn.b(paramView);
  }

  public int n(View paramView)
  {
    return fn.c(paramView);
  }

  public gt o(View paramView)
  {
    return new gt(paramView);
  }

  public boolean p(View paramView)
  {
    if ((paramView instanceof eo))
      return ((eo)paramView).isNestedScrollingEnabled();
    return false;
  }

  public void q(View paramView)
  {
    if ((paramView instanceof eo))
      ((eo)paramView).stopNestedScroll();
  }

  public boolean r(View paramView)
  {
    return fn.a(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     fa
 * JD-Core Version:    0.6.2
 */