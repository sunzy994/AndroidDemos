package cmcm.com.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class di extends dl
{
  public Object a()
  {
    return dm.a();
  }

  public Object a(final dh paramdh)
  {
    return dm.a(new dn() {
      public void a(View paramAnonymousView, int paramAnonymousInt) {
        paramdh.a(paramAnonymousView, paramAnonymousInt);
      }

      public void a(View paramAnonymousView, Object paramAnonymousObject) {
        paramdh.a(paramAnonymousView, new hg(paramAnonymousObject));
      }

      public boolean a(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent) {
        return paramdh.b(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public boolean a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent) {
        return paramdh.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public void b(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent) {
        paramdh.d(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public void c(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent) {
        paramdh.c(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public void d(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent) {
        paramdh.a(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
    });
  }

  public void a(Object paramObject, View paramView, int paramInt)
  {
    dm.a(paramObject, paramView, paramInt);
  }

  public void a(Object paramObject, View paramView, hg paramhg)
  {
    dm.a(paramObject, paramView, paramhg.a());
  }

  public boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return dm.a(paramObject, paramView, paramAccessibilityEvent);
  }

  public boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return dm.a(paramObject, paramViewGroup, paramView, paramAccessibilityEvent);
  }

  public void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    dm.b(paramObject, paramView, paramAccessibilityEvent);
  }

  public void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    dm.c(paramObject, paramView, paramAccessibilityEvent);
  }

  public void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    dm.d(paramObject, paramView, paramAccessibilityEvent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     di
 * JD-Core Version:    0.6.2
 */