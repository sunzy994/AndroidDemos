package cmcm.com.myapplication;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.lazyswipe.notification.SwipeAccessibilityService;
import com.lazyswipe.ui.DialogActivity;

public class amp extends ans
{
  public amp(Context paramContext)
  {
    this(paramContext, null);
  }

  public amp(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  public static boolean a(AccessibilityService paramAccessibilityService, Context paramContext, Handler paramHandler)
  {
    return a(paramAccessibilityService, paramContext, paramHandler, false);
  }

  @TargetApi(16)
  private static boolean a(AccessibilityService paramAccessibilityService, Context paramContext, Handler paramHandler, boolean paramBoolean)
  {
    if (paramAccessibilityService != null)
      if (!paramBoolean)
      {
        paramAccessibilityService = new Runnable()
        {
          public void run()
          {
            amp.this.performGlobalAction(1);
          }
        };
        if (paramHandler == null)
          break label32;
        paramHandler.postDelayed(paramAccessibilityService, 10L);
      }
    label32: 
    do
    {
      return true;
      paramAccessibilityService.run();
      return true;
      if (!vs.v(paramContext))
        break;
    }
    while (paramBoolean);
    paramAccessibilityService = new Runnable()
    {
      public void run()
      {
        ase.d();
      }
    };
    if (paramHandler != null)
    {
      paramHandler.postDelayed(paramAccessibilityService, 10L);
      return true;
    }
    paramAccessibilityService.run();
    return true;
    return false;
  }

  public int a(Context paramContext)
  {
    if ((vs.v(paramContext)) || (SwipeAccessibilityService.a(paramContext)))
      return 1;
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837812;
  }

  public boolean a_(Context paramContext)
  {
    return false;
  }

  public String b()
  {
    return "Back";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_back";
  }

  public int c()
  {
    return 22;
  }

  public int d()
  {
    return 2131231112;
  }

  public boolean f()
  {
    return false;
  }

  public boolean h()
  {
    return false;
  }

  public boolean i()
  {
    if (!a(SwipeAccessibilityService.a(), this.e, this.h, true))
      if (Build.VERSION.SDK_INT >= 16)
        DialogActivity.b(this.e);
    yb localyb;
    do
    {
      return true;
      localyb = yb.getInstance();
    }
    while (localyb == null);
    localyb.a();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amp
 * JD-Core Version:    0.6.2
 */