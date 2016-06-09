package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class qd
{
  private static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.holaverse.game.sdk", 0);
  }

  public static String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).getString(paramString1, paramString2);
  }

  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).edit().putString(paramString1, paramString2).commit();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qd
 * JD-Core Version:    0.6.2
 */