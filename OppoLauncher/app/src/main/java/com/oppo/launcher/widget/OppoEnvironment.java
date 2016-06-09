package com.oppo.launcher.widget;

import android.content.Context;
import android.util.Log;
import com.oppo.launcher.LauncherUtil;
import com.oppo.launcher.settings.FeatureOption;
import com.oppo.os.OppoUsbEnvironment;

public class OppoEnvironment
{
  private static final boolean DEBUG = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  private static final String TAG = "Launcher.OppoEnvironment";

  public static String getExternalSdState(Context paramContext)
  {
    return OppoUsbEnvironment.getExternalSdState(paramContext.getApplicationContext());
  }

  public static String getInternalSdState(Context paramContext)
  {
    return OppoUsbEnvironment.getInternalSdState(paramContext.getApplicationContext());
  }

  public static boolean getSDCardInsideFlagFromFeature()
  {
    return (FeatureOption.APP2SD_DISABLED) || (!FeatureOption.IS_SUPPORT_SINGLE_PARTITION);
  }

  public static boolean isExternalSDRemoved(Context paramContext)
  {
    if ((OppoUsbEnvironment.isExternalSDRemoved(paramContext.getApplicationContext())) || ("bad_removal".equals(getExternalSdState(paramContext))));
    for (boolean bool = true; ; bool = false)
    {
      if (DEBUG)
        Log.i("Launcher.OppoEnvironment", "isExternalSDRemoved, return = " + bool);
      return bool;
    }
  }

  public static boolean isSDCardInside(Context paramContext)
  {
    boolean bool;
    if (OppoUsbEnvironment.getInternalSdDirectory(paramContext.getApplicationContext()) != null)
      if (OppoUsbEnvironment.getExternalSdDirectory(paramContext.getApplicationContext()) == null)
        bool = true;
    while (true)
    {
      if (DEBUG)
        Log.i("Launcher.OppoEnvironment", "isSDCardInside == return = " + bool);
      if ((!bool) && (!getSDCardInsideFlagFromFeature()))
        break;
      return true;
      bool = false;
      continue;
      bool = false;
    }
    return false;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.widget.OppoEnvironment
 * JD-Core Version:    0.6.2
 */