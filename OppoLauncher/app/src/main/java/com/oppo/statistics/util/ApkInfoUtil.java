package com.oppo.statistics.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class ApkInfoUtil
{
  public static int getAppCode(Context paramContext)
  {
    int i = 0;
    String str = getPackageName(paramContext);
    try
    {
      int j = paramContext.getPackageManager().getApplicationInfo(str, 128).metaData.getInt("AppCode");
      if (j == 0)
      {
        i = j;
        LogUtil.e("NearMeStatistics", "AppCode not set. please read the document of NearMeStatistics SDK.");
      }
      return j;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return i;
  }

  public static String getAppName(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.loadLabel(localPackageManager).toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return "0";
  }

  public static String getPackageName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return "0";
  }

  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return 0;
  }

  public static int getVersionCode(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return 0;
  }

  public static String getVersionName(Context paramContext)
  {
    String str = "0";
    Object localObject = str;
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      paramContext = str;
      if (localPackageInfo != null)
      {
        paramContext = str;
        localObject = str;
        if (localPackageInfo.versionName != null)
        {
          localObject = str;
          paramContext = localPackageInfo.versionName;
          localObject = paramContext;
          LogUtil.i("versionName=" + paramContext);
        }
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
    return localObject;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.util.ApkInfoUtil
 * JD-Core Version:    0.6.2
 */