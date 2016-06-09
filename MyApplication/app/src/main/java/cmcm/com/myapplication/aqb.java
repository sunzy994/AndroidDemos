package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
import java.util.Collection;
import java.util.Iterator;

@TargetApi(16)
public class aqb
{
  public static final aqd a = new aqd()
  {
  };
  public static final aqd b = new aqd()
  {
  };
  private static final aqd c = new aqd()
  {
  };
  private static final aqc d = new aqc(4096);
  private static final aqc e = new aqc(8192);

  public static void a(Collection<AccessibilityNodeInfo> paramCollection, boolean paramBoolean)
  {
    if (paramCollection == null);
    do
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        AccessibilityNodeInfo localAccessibilityNodeInfo = (AccessibilityNodeInfo)localIterator.next();
        if (localAccessibilityNodeInfo != null)
          localAccessibilityNodeInfo.recycle();
      }
    }
    while (!paramBoolean);
    paramCollection.clear();
  }

  public static void a(AccessibilityNodeInfo[] paramArrayOfAccessibilityNodeInfo)
  {
    if (paramArrayOfAccessibilityNodeInfo == null);
    while (true)
    {
      return;
      int j = paramArrayOfAccessibilityNodeInfo.length;
      int i = 0;
      while (i < j)
      {
        AccessibilityNodeInfo localAccessibilityNodeInfo = paramArrayOfAccessibilityNodeInfo[i];
        if (localAccessibilityNodeInfo != null)
          localAccessibilityNodeInfo.recycle();
        i += 1;
      }
    }
  }

  public static boolean a(Context paramContext, AccessibilityNodeInfo paramAccessibilityNodeInfo, Class<?> paramClass)
  {
    if ((paramAccessibilityNodeInfo == null) || (paramClass == null));
    do
    {
      return false;
      paramContext = aql.a().a(paramContext, paramAccessibilityNodeInfo.getClassName(), paramAccessibilityNodeInfo.getPackageName());
    }
    while ((paramContext == null) || (!paramClass.isAssignableFrom(paramContext)));
    return true;
  }

  public static boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    paramAccessibilityNodeInfo = paramAccessibilityNodeInfo.getClassName().toString();
    return (paramAccessibilityNodeInfo.equals(ListView.class.getName())) || (paramAccessibilityNodeInfo.equals(GridView.class.getName())) || (paramAccessibilityNodeInfo.equals(WebView.class.getName())) || (paramAccessibilityNodeInfo.equals(ScrollView.class.getName()));
  }

  public static boolean b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    paramAccessibilityNodeInfo = paramAccessibilityNodeInfo.getClassName().toString();
    return (paramAccessibilityNodeInfo.equals(ViewPager.class.getName())) || (paramAccessibilityNodeInfo.equals(WebView.class.getName())) || (paramAccessibilityNodeInfo.equals(Gallery.class.getName()));
  }

  public static void c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    try
    {
      paramAccessibilityNodeInfo.recycle();
      return;
    }
    catch (Exception paramAccessibilityNodeInfo)
    {
      asq.b(paramAccessibilityNodeInfo);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqb
 * JD-Core Version:    0.6.2
 */