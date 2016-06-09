package cmcm.com.myapplication;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.tile.booster.ui.BoostingCircular;

public class aoe
{
  static int a = 0;
  private static final String b = "Swipe." + aoe.class.getSimpleName();
  private static boolean c = false;
  private static int d = -1;

  public static void a()
  {
    a += 1;
  }

  public static void a(Context paramContext, long paramLong)
  {
    if ((paramContext == null) || (yb.getInstance() == null));
    while (c)
      return;
    yb localyb = yb.getInstance();
    c = true;
    a = 0;
    BoostingCircular.a(paramContext, localyb.getItemLayer(), localyb, true, paramLong);
    BoostingCircular.a(paramContext, localyb.getTabSector(), localyb, false, paramLong);
    aog.a(paramContext, localyb, 0, paramLong);
    aog.a(paramContext, localyb, 1, paramLong);
  }

  public static void a(View paramView, long paramLong)
  {
    a -= 1;
    if (a <= 0)
    {
      a = 0;
      c = false;
      aoc.a(paramLong);
    }
  }

  public static boolean b()
  {
    return c;
  }

  public static void c()
  {
    c = false;
    a = 0;
  }

  public static int d()
  {
    int j = 0;
    if (d == -1)
    {
      if (((Build.VERSION.SDK_INT >= 16) && (!aqs.l())) || ((ahx.b(SwipeApplication.c()) instanceof ahr)))
        break label51;
      i = 1;
      if (i == 0)
        break label56;
    }
    label51: label56: for (int i = j; ; i = 2)
    {
      d = i;
      return d;
      i = 0;
      break;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aoe
 * JD-Core Version:    0.6.2
 */