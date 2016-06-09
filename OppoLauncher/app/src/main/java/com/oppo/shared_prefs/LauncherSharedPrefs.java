package com.oppo.shared_prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class LauncherSharedPrefs
{
  public static final String LAUNCHER_SHARED_PREFS = "com.oppo.launcher_unique_shared_prefs";

  public static SharedPreferences getLauncherPrefs(Context paramContext)
  {
    return getLauncherPrefs(paramContext, 0);
  }

  public static SharedPreferences getLauncherPrefs(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("com.oppo.launcher_unique_shared_prefs", paramInt);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.shared_prefs.LauncherSharedPrefs
 * JD-Core Version:    0.6.2
 */