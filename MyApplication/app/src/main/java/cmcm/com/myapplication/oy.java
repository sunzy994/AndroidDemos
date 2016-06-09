package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;

public class oy
{
  public static String a = null;
  public static String b = null;
  public static String c = null;
  public static String d = null;

  public static File a(Context paramContext, String paramString)
  {
    return new File(paramContext.getFilesDir(), paramString);
  }

  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    return new File(paramContext.createPackageContext(paramString1, 2).getFilesDir(), paramString2);
  }

  public static File b(Context paramContext, String paramString)
  {
    return a(paramContext, "hola_loader/" + paramString);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     oy
 * JD-Core Version:    0.6.2
 */