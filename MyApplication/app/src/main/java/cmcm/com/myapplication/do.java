package cmcm.com.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class do
{
  public static Object a(dp paramdp)
  {
    return new View.AccessibilityDelegate()
    {
      public boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return do.this.a(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramAnonymousView)
      {
        return (AccessibilityNodeProvider)do.this.a(paramAnonymousView);
      }

      public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        do.this.b(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        do.this.a(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      }

      public void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        do.this.c(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return do.this.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
      }

      public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return do.this.a(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
      }

      public void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
      {
        do.this.a(paramAnonymousView, paramAnonymousInt);
      }

      public void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        do.this.d(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
    };
  }

  public static Object a(Object paramObject, View paramView)
  {
    return ((View.AccessibilityDelegate)paramObject).getAccessibilityNodeProvider(paramView);
  }

  public static boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
  {
    return ((View.AccessibilityDelegate)paramObject).performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     do
 * JD-Core Version:    0.6.2
 */