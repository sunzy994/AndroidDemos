package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class amk
{
  private static aml a;

  public static void a(Context paramContext, boolean paramBoolean)
  {
    e(paramContext);
    a.edit().putBoolean("isBoostRunnerEnabled", paramBoolean).apply();
  }

  public static boolean a(Context paramContext)
  {
    e(paramContext);
    return a.getBoolean("isBoostRunnerEnabled", false);
  }

  public static void b(Context paramContext, boolean paramBoolean)
  {
    e(paramContext);
    b(paramContext);
    a.edit().putBoolean("isTutorialMode", paramBoolean).commit();
  }

  public static boolean b(Context paramContext)
  {
    e(paramContext);
    return a.getBoolean("isTutorialMode", false);
  }

  public static void c(Context paramContext, boolean paramBoolean)
  {
    e(paramContext);
    a.edit().putBoolean("isHintMode", paramBoolean).apply();
  }

  public static boolean c(Context paramContext)
  {
    e(paramContext);
    return a.getBoolean("isHintMode", false);
  }

  public static void d(Context paramContext, boolean paramBoolean)
  {
    e(paramContext);
    a.edit().putBoolean("isL", paramBoolean).apply();
  }

  public static boolean d(Context paramContext)
  {
    e(paramContext);
    return a.getBoolean("isL", false);
  }

  private static void e(Context paramContext)
  {
    try
    {
      if (a == null)
        a = new aml(paramContext);
      return;
    }
    finally
    {
    }
    throw paramContext;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amk
 * JD-Core Version:    0.6.2
 */