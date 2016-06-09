package cmcm.com.myapplication;

import android.view.View;

class fg extends fe
{
  public void a(View paramView, Runnable paramRunnable)
  {
    fs.a(paramView, paramRunnable);
  }

  public void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    fs.a(paramView, paramRunnable, paramLong);
  }

  public void c(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 4)
      i = 2;
    fs.a(paramView, i);
  }

  public boolean c(View paramView)
  {
    return fs.a(paramView);
  }

  public void d(View paramView)
  {
    fs.b(paramView);
  }

  public int e(View paramView)
  {
    return fs.c(paramView);
  }

  public boolean i(View paramView)
  {
    return fs.f(paramView);
  }

  public int m(View paramView)
  {
    return fs.d(paramView);
  }

  public int n(View paramView)
  {
    return fs.e(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     fg
 * JD-Core Version:    0.6.2
 */