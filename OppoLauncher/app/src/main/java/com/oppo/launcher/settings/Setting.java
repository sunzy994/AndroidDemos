package com.oppo.launcher.settings;

public class Setting
{
  public static final String CUBE_EFFECT_CLASS_NAME = "com.oppo.launcher.effect.agent.CubeEffectAgent";
  private static final boolean DEBUG = false;
  public static final String DESK_EFFECT_KEY = "desk_effect";
  public static final String LAUNCHERSETTING_PREFERENCE_NAME = "com.oppo.launcher_preferences";
  public static final String SLANT_EFFECT_CLASS_NAME = "com.oppo.launcher.effect.agent.SlantEffectAgent";
  private static final String TAG = "Setting";
  public static final int WORKSPACE_SCROLL_SEEK_BAR = 102;
  private static String mWorkspaceDefaultEffectClassName = "";
  private static String mWorkspaceEffectClassName = "";

  public static String getWorkSpaceEffectClassName()
  {
    return mWorkspaceEffectClassName;
  }

  public static String getWorkspaceDefaultEffectClassName()
  {
    return mWorkspaceDefaultEffectClassName;
  }

  public static boolean isCurrentEffectNeedResetParam()
  {
    return mWorkspaceEffectClassName.equals("com.oppo.launcher.effect.agent.CubeEffectAgent");
  }

  public static boolean isWorkspaceNeedAnimateToNormal()
  {
    return mWorkspaceEffectClassName.equals("com.oppo.launcher.effect.agent.SlantEffectAgent");
  }

  public static void setWorkspaceDefaultEffectClassName(String paramString)
  {
    mWorkspaceDefaultEffectClassName = paramString;
  }

  public static void setWorkspaceEffectClassName(String paramString)
  {
    mWorkspaceEffectClassName = paramString;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.settings.Setting
 * JD-Core Version:    0.6.2
 */