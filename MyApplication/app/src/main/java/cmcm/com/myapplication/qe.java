package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;

public class qe
{
  private static String a;
  private static Object b;

  public static Object a(Context paramContext, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    a(paramContext);
    return ox.a(b, paramString, paramArrayOfObject, paramArrayOfClass);
  }

  public static void a(Context paramContext)
  {
    if (a == null)
      a = oy.a(paramContext, "analytics.jar").getAbsolutePath();
    if (b == null)
    {
      paramContext = ox.a(paramContext, a);
      b = ox.a(ox.a(paramContext, "com.statistics.channel.ChannelProvider"), new Object[0]);
      paramContext = ox.a(ox.a(paramContext, "com.statistics.channel.ChannelS"), "getInstance", new Object[0]);
      boolean bool = qj.a;
      Class localClass = Boolean.TYPE;
      ox.a(paramContext, "setDebug", new Object[] { Boolean.valueOf(bool) }, new Class[] { localClass });
    }
  }

  public static void b(Context paramContext)
  {
    a(paramContext, "onDestroy", new Object[0], new Class[0]);
    b = null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qe
 * JD-Core Version:    0.6.2
 */