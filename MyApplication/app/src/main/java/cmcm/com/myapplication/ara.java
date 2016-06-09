package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ara
{
  private static final String a = "Swipe." + ara.class.getSimpleName();
  private static boolean b = false;
  private static boolean c = false;
  private static int d;
  private static boolean e = false;
  private static Field f = null;
  private static boolean g = false;
  private static Class<?> h = null;
  private static boolean i = false;
  private static Method j = null;
  private static boolean k = false;
  private static Method l = null;

  private static boolean a()
  {
    if (!b)
      b = true;
    try
    {
      d = WindowManager.LayoutParams.class.getField("FLAG_HARDWARE_ACCELERATED").getInt(null);
      c = true;
      return c;
    }
    catch (Exception localException)
    {
      while (true)
        Log.e(a, "exception", localException);
    }
  }

  public static boolean a(PopupWindow paramPopupWindow)
  {
    if (paramPopupWindow == null)
      return false;
    if (!a())
      return false;
    if (!e)
    {
      e = true;
      f = arp.c(PopupWindow.class, "mPopupView");
    }
    if (f == null)
      return false;
    paramPopupWindow = arp.a(paramPopupWindow, f);
    if ((paramPopupWindow == null) || (!(paramPopupWindow instanceof View)))
      return false;
    Object localObject = (View)paramPopupWindow;
    paramPopupWindow = ((View)localObject).getParent();
    while ((paramPopupWindow != null) && (paramPopupWindow.getParent() != null));
    if (!g)
    {
      g = true;
      h = arp.a(null, "android.view.ViewRootImpl");
    }
    if (h == null)
      return false;
    if (!h.equals(paramPopupWindow.getClass()))
      return false;
    Context localContext = ((View)localObject).getContext();
    if (localContext == null)
      return false;
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject == null) || (!(localObject instanceof WindowManager.LayoutParams)))
      return false;
    localObject = (WindowManager.LayoutParams)localObject;
    if ((((WindowManager.LayoutParams)localObject).flags & d) != 0)
      return true;
    ((WindowManager.LayoutParams)localObject).flags |= d;
    if (!i)
    {
      i = true;
      j = arp.b(h, "enableHardwareAcceleration", new Class[]{WindowManager.LayoutParams.class});
    }
    if (j != null)
    {
      arp.a(paramPopupWindow, j, new Object[]{localObject});
      return true;
    }
    if (!k)
    {
      k = true;
      l = arp.b(h, "enableHardwareAcceleration", new Class[]{Context.class, WindowManager.LayoutParams.class});
    }
    if (l != null)
    {
      arp.a(paramPopupWindow, l, new Object[]{localContext, localObject});
      return true;
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ara
 * JD-Core Version:    0.6.2
 */