package cmcm.com.myapplication;

import android.util.Log;

public final class mv
{
  private static boolean a = false;

  public static void a(String paramString1, String paramString2)
  {
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
  }

  public static boolean a()
  {
    return false;
  }

  public static void b(String paramString1, String paramString2)
  {
  }

  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e("DX-Toolbox", e(paramString1, paramString2), paramThrowable);
  }

  public static void c(String paramString1, String paramString2)
  {
  }

  public static void d(String paramString1, String paramString2)
  {
    Log.e("DX-Toolbox", e(paramString1, paramString2));
  }

  private static String e(String paramString1, String paramString2)
  {
    return "{" + Thread.currentThread().getName() + "}[" + paramString1 + "] " + paramString2;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mv
 * JD-Core Version:    0.6.2
 */