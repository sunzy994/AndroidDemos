package cmcm.com.myapplication;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class fr
{
  public static void a(View paramView, Object paramObject)
  {
    paramView.setAccessibilityDelegate((AccessibilityDelegate)paramObject);
  }

  public static boolean a(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }

  public static boolean b(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     fr
 * JD-Core Version:    0.6.2
 */