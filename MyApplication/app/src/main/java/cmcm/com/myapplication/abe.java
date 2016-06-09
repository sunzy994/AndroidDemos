package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;

public class abe
{
  private static final String a = "Swipe." + abe.class.getSimpleName();
  private static boolean b;
  private static int c;

  public static void a()
  {
    b = true;
    c = 3;
  }

  public static void a(Context paramContext, ComponentName paramComponentName)
  {
    if (!b);
    while (true)
    {
      return;
      if (c > 0)
      {
        c -= 1;
        try
        {
          if (b(paramContext, paramComponentName))
          {
            SwipeService.a(paramContext, SwipeService.a(paramContext, vs.B(paramContext), aap.b(SwipeApplication.c()).b()).getExtras());
            b();
            return;
          }
        }
        catch (Exception paramContext)
        {
          b();
        }
      }
    }
  }

  public static void b()
  {
    b = false;
    c = 0;
  }

  private static boolean b(Context paramContext, ComponentName paramComponentName)
  {
    if (paramComponentName == null);
    Intent localIntent;
    do
    {
      do
      {
        do
        {
          return false;
          paramComponentName = paramComponentName.getPackageName();
        }
        while ((asq.a(paramContext, new Intent("android.intent.action.CHOOSER"), paramComponentName)) || ("android".equals(paramComponentName)) || ("com.huawei.android.internal.app".equals(paramComponentName)));
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse("http://www.lazyswipe.com"));
      }
      while (asq.a(paramContext, localIntent, paramComponentName));
      localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("market://details?id=com.lazyswipe"));
    }
    while (asq.a(paramContext, localIntent, paramComponentName));
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abe
 * JD-Core Version:    0.6.2
 */