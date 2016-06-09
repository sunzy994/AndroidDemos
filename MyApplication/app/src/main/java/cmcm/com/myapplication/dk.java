package cmcm.com.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class dk extends di
{
  public hs a(Object paramObject, View paramView)
  {
    paramObject = do.a(paramObject, paramView);
    if (paramObject != null)
      return new hs(paramObject);
    return null;
  }

  public Object a(final dh paramdh)
  {
    return do.a(new dp()
    {
      public Object a(View paramAnonymousView)
      {
        paramAnonymousView = paramdh.a(paramAnonymousView);
        if (paramAnonymousView != null)
          return paramAnonymousView.a();
        return null;
      }

      public void a(View paramAnonymousView, int paramAnonymousInt)
      {
        paramdh.a(paramAnonymousView, paramAnonymousInt);
      }

      public void a(View paramAnonymousView, Object paramAnonymousObject)
      {
        paramdh.a(paramAnonymousView, new hg(paramAnonymousObject));
      }

      public boolean a(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return paramdh.a(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
      }

      public boolean a(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return paramdh.b(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public boolean a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return paramdh.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public void b(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        paramdh.d(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public void c(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        paramdh.c(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public void d(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        paramdh.a(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
    });
  }

  public boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
  {
    return do.a(paramObject, paramView, paramInt, paramBundle);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dk
 * JD-Core Version:    0.6.2
 */