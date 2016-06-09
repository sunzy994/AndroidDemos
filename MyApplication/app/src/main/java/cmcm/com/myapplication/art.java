package cmcm.com.myapplication;

import android.os.Environment;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class art
{
  private static final Set<String> a = new HashSet();
  private static final Set<String> b = new HashSet();

  static
  {
    a.add("mounted");
    a.add("mounted_ro");
    b.add("mounted");
  }

  public static String a()
  {
    try
    {
      String str = Environment.getExternalStorageState();
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static boolean a(String paramString)
  {
    return paramString.startsWith(Environment.getExternalStorageDirectory().getPath());
  }

  public static boolean b()
  {
    return "mounted".equals(a());
  }

  public static boolean c()
  {
    return a.contains(a());
  }

  public static boolean d()
  {
    return b.contains(a());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     art
 * JD-Core Version:    0.6.2
 */