package cmcm.com.myapplication;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class hx
{
  public static Object a(hy paramhy)
  {
    return new AccessibilityNodeProvider()
    {
      public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)hx.this.a(paramAnonymousInt);
      }

      public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
      {
        return hx.this.a(paramAnonymousString, paramAnonymousInt);
      }

      public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return hx.this.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    };
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     hx
 * JD-Core Version:    0.6.2
 */