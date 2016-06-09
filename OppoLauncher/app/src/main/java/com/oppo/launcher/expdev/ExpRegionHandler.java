package com.oppo.launcher.expdev;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.util.DisplayMetrics;
import android.util.Log;
import com.oppo.launcher.Utilities;
import com.oppo.launcher.screenGrid.ScreenGridUtils;
import com.oppo.launcher.settings.FeatureOption;

public class ExpRegionHandler
{
  public static final String CLASS_GOOLE_MAPS_DRIVEABOUT = "com.google.android.maps.driveabout.app.DestinationActivity";
  private static final float DENSITY_1080 = 3.0F;
  private static final float DENSITY_480 = 1.5F;
  private static final float DENSITY_720 = 2.0F;
  private static final long MEMORY_SIZE_1G = 1073741824L;
  private static final int MEMORY_SIZE_512M = 536870912;
  private static final String TAG = "ExpRegionHandler";

  private static int getResIdByName(Context paramContext, String paramString)
  {
    Log.v("ExpRegionHandler", "getResIdByName --- name = " + paramString);
    return paramContext.getResources().getIdentifier(paramString, "xml", paramContext.getPackageName());
  }

  public static int getWorkspaceXml(Context paramContext)
  {
    Object localObject2 = (ActivityManager)paramContext.getSystemService("activity");
    Object localObject1 = new MemoryInfo();
    ((ActivityManager)localObject2).getMemoryInfo((MemoryInfo)localObject1);
    String str1 = "";
    label143: label169: float f;
    if (((MemoryInfo)localObject1).totalMem <= 536870912L)
    {
      str1 = "_512m";
      FeatureOption.initFeatureForLoadXml(paramContext.getPackageManager());
      int k = ScreenGridUtils.getScreenYGridNum();
      localObject1 = SystemProperties.get("persist.sys.oppo.region", "null");
      String str2 = "_" + Utilities.getBuildModel().toLowerCase();
      int j = paramContext.getResources().getIdentifier("default_workspace_" + ((String)localObject1).toLowerCase(), "xml", paramContext.getPackageName());
      i = j;
      if (j == 0)
      {
        if (k != 5)
          break label385;
        localObject2 = "default_workspace";
        if (!FeatureOption.IS_CMCC_TEST_VERSION)
          break label391;
        localObject1 = (String)localObject2 + "_cmcc_test";
        localObject2 = "";
        f = paramContext.getResources().getDisplayMetrics().density;
        if (f != 1.5F)
          break label480;
        localObject2 = "_480";
        label193: j = getResIdByName(paramContext, (String)localObject1 + str2 + str1);
        i = j;
        if (j == 0)
          i = getResIdByName(paramContext, (String)localObject1 + (String)localObject2 + str1);
        j = i;
        if (i == 0)
          j = getResIdByName(paramContext, (String)localObject1 + str1);
        i = j;
        if (j == 0)
          i = getResIdByName(paramContext, (String)localObject1 + str2);
        j = i;
        if (i == 0)
          j = getResIdByName(paramContext, (String)localObject1);
        i = j;
        if (j == 0)
          if (k != 5)
            break label505;
      }
    }
    label385: label391: label480: label505: for (int i = 2131034112; ; i = 2131034113)
    {
      return i;
      if (((MemoryInfo)localObject1).totalMem > 1073741824L)
        break;
      str1 = "_1g";
      break;
      localObject2 = "default_workspace_4x4";
      break label143;
      if (FeatureOption.IS_CMCC_MP_VERSION)
      {
        localObject1 = (String)localObject2 + "_cmcc_mp";
        break label169;
      }
      if (FeatureOption.IS_CU_VERSION)
      {
        localObject1 = (String)localObject2 + "_cu";
        break label169;
      }
      localObject1 = localObject2;
      if (!FeatureOption.IS_CT_VERSION)
        break label169;
      localObject1 = (String)localObject2 + "_ct";
      break label169;
      if (f == 2.0F)
      {
        localObject2 = "_720";
        break label193;
      }
      if (f != 3.0F)
        break label193;
      localObject2 = "_1080";
      break label193;
    }
  }

  public static boolean isExportRegion()
  {
    return !"CN".equalsIgnoreCase(SystemProperties.get("persist.sys.oppo.region", "CN"));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.expdev.ExpRegionHandler
 * JD-Core Version:    0.6.2
 */