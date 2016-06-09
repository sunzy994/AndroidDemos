package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class qy
{
  private static final String a = "GameSDK." + qy.class.getSimpleName();

  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("game_prefs", 0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qy
 * JD-Core Version:    0.6.2
 */