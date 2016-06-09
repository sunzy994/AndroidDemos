package cmcm.com.myapplication;

import android.accessibilityservice.AccessibilityService;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import java.util.Iterator;
import java.util.List;

public class aci
{
  public static int a(AccessibilityEvent paramAccessibilityEvent, String paramString)
  {
    if (Build.VERSION.SDK_INT < 14);
    while (paramAccessibilityEvent.getSource() == null)
      return -2;
    paramAccessibilityEvent = paramAccessibilityEvent.getSource().findAccessibilityNodeInfosByText(paramString);
    if ((paramAccessibilityEvent == null) || (paramAccessibilityEvent.size() == 0))
      return -4;
    return a(paramAccessibilityEvent);
  }

  private static int a(List<AccessibilityNodeInfo> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = (AccessibilityNodeInfo)paramList.next();
      if (localAccessibilityNodeInfo.getClassName().equals(Button.class.getName()))
      {
        if (!localAccessibilityNodeInfo.isEnabled())
        {
          i = 1;
        }
        else
        {
          boolean bool = localAccessibilityNodeInfo.performAction(16);
          localAccessibilityNodeInfo.recycle();
          if (bool)
            return 0;
          return 1;
        }
      }
      else
        return -4;
    }
    if (i != 0)
      return -5;
    return -1;
  }

  public static boolean a(AccessibilityService paramAccessibilityService)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramAccessibilityService.performGlobalAction(1);
    return false;
  }

  public static int b(AccessibilityEvent paramAccessibilityEvent, String paramString)
  {
    if (Build.VERSION.SDK_INT < 18);
    while (paramAccessibilityEvent.getSource() == null)
      return -2;
    try
    {
      paramAccessibilityEvent = paramAccessibilityEvent.getSource().findAccessibilityNodeInfosByViewId(paramString);
      if ((paramAccessibilityEvent != null) && (paramAccessibilityEvent.size() != 0))
      {
        int i = a(paramAccessibilityEvent);
        return i;
      }
    }
    catch (Exception paramAccessibilityEvent)
    {
      return -4;
    }
    return -4;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aci
 * JD-Core Version:    0.6.2
 */