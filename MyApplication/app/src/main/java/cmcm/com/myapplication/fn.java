package cmcm.com.myapplication;

import android.view.View;
import java.lang.reflect.Field;

class fn
{
  private static Field a;
  private static boolean b;
  private static Field c;
  private static boolean d;

  static boolean a(View paramView)
  {
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }

  static int b(View paramView)
  {
    if (!b);
    try
    {
      a = View.class.getDeclaredField("mMinWidth");
      a.setAccessible(true);
      label23: b = true;
      if (a != null)
        try
        {
          int i = ((Integer)a.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView)
        {
        }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }

  static int c(View paramView)
  {
    if (!d);
    try
    {
      c = View.class.getDeclaredField("mMinHeight");
      c.setAccessible(true);
      label23: d = true;
      if (c != null)
        try
        {
          int i = ((Integer)c.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView)
        {
        }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     fn
 * JD-Core Version:    0.6.2
 */