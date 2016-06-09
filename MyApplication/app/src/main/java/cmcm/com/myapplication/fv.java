package cmcm.com.myapplication;

import android.view.View;

class fv
{
  public static void a(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }

  public static boolean a(View paramView)
  {
    return paramView.isNestedScrollingEnabled();
  }

  public static void b(View paramView)
  {
    paramView.stopNestedScroll();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     fv
 * JD-Core Version:    0.6.2
 */