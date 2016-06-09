package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class aru
{
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext).getInt(paramString, paramInt);
  }

  public static long a(Context paramContext, String paramString, long paramLong)
  {
    return a(paramContext).getLong(paramString, paramLong);
  }

  public static SharedPreferences a(Context paramContext)
  {
    return amd.a(paramContext, "pop_time_preference");
  }

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).getString(paramString1, paramString2);
  }

  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean(paramString, paramBoolean).apply();
  }

  public static void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext).edit().putInt(paramString, paramInt).apply();
  }

  public static void b(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext).edit().putLong(paramString, paramLong).apply();
  }

  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext).edit().putString(paramString1, paramString2).apply();
  }

  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(paramContext).getBoolean(paramString, paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aru
 * JD-Core Version:    0.6.2
 */