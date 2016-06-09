package cmcm.com.myapplication;

import android.view.View;

class fs
{
  public static void a(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }

  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }

  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }

  public static boolean a(View paramView)
  {
    return paramView.hasTransientState();
  }

  public static void b(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }

  public static int c(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }

  public static int d(View paramView)
  {
    return paramView.getMinimumWidth();
  }

  public static int e(View paramView)
  {
    return paramView.getMinimumHeight();
  }

  public static boolean f(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     fs
 * JD-Core Version:    0.6.2
 */