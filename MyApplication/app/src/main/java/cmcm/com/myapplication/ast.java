package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class ast
{
  public static LayoutParams a(Context paramContext)
  {
    paramContext = a(paramContext, true);
    paramContext.width = aqs.ac();
    paramContext.height = aqs.ad();
    paramContext.x = 0;
    paramContext.y = 0;
    return paramContext;
  }

  public static LayoutParams a(Context paramContext, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = new LayoutParams();
    localLayoutParams.format = 1;
    localLayoutParams.flags = 65792;
    if (!paramBoolean)
    {
      localLayoutParams.flags |= 8;
      localLayoutParams.flags |= 32;
    }
    localLayoutParams.type = vs.n(paramContext);
    localLayoutParams.gravity = (vj.a | 0x30);
    return localLayoutParams;
  }

  public static boolean a(Context paramContext, View paramView)
  {
    try
    {
      ((WindowManager)paramContext.getSystemService("window")).removeView(paramView);
      return true;
    }
    catch (Exception paramContext)
    {
      asp.b("Swipe.WindowManagerUtils", "failed to detach from window, mostly because it is already detached", paramContext);
    }
    return false;
  }

  public static boolean a(Context paramContext, View paramView, LayoutParams paramLayoutParams)
  {
    try
    {
      ((WindowManager)paramContext.getSystemService("window")).addView(paramView, paramLayoutParams);
      return true;
    }
    catch (Exception paramContext)
    {
      asp.b("Swipe.WindowManagerUtils", "failed to attach to window, mostly because it is already attached", paramContext);
    }
    return false;
  }

  public static boolean b(Context paramContext, View paramView, LayoutParams paramLayoutParams)
  {
    try
    {
      ((WindowManager)paramContext.getSystemService("window")).updateViewLayout(paramView, paramLayoutParams);
      return true;
    }
    catch (Exception paramContext)
    {
      asp.b("Swipe.WindowManagerUtils", "failed to update window, mostly because it is not attached", paramContext);
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ast
 * JD-Core Version:    0.6.2
 */