package cmcm.com.myapplication;

import android.content.ContextWrapper;
import java.io.File;

public class py
{
  private static ClassLoader a;
  private static String b;

  public static ClassLoader a(ContextWrapper paramContextWrapper)
  {
    if (b == null)
      b = oy.b(paramContextWrapper, "fb.jar").getAbsolutePath();
    if (a == null);
    try
    {
      a = ox.a(paramContextWrapper, b);
      ox.a(paramContextWrapper, a);
      return a;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        qq.a(paramContextWrapper, "NvLoader.get", localThrowable);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     py
 * JD-Core Version:    0.6.2
 */