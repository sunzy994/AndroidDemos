package cmcm.com.myapplication;

import android.util.Log;

public class bah
{
  private static int a = 0;

  public static void a(String paramString1, String paramString2)
  {
    if (a > 1)
      return;
    Log.d(paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (a > 0)
      return;
    String str = paramString2;
    if (paramArrayOfObject.length > 0)
      str = String.format(paramString2, paramArrayOfObject);
    Log.v(paramString1, str);
  }

  public static void b(String paramString1, String paramString2)
  {
    if (a > 2)
      return;
    Log.i(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (a > 1)
      return;
    String str = paramString2;
    if (paramArrayOfObject.length > 0)
      str = String.format(paramString2, paramArrayOfObject);
    Log.d(paramString1, str);
  }

  public static void c(String paramString1, String paramString2)
  {
    if (a > 4)
      return;
    Log.e(paramString1, paramString2);
  }

  public static void c(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (a > 2)
      return;
    String str = paramString2;
    if (paramArrayOfObject.length > 0)
      str = String.format(paramString2, paramArrayOfObject);
    Log.i(paramString1, str);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bah
 * JD-Core Version:    0.6.2
 */