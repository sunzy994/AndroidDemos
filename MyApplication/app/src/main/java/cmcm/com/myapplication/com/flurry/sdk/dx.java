package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public final class dx
{
  private static final String a = dx.class.getSimpleName();

  public static PackageInfo a(Context paramContext)
  {
    PackageInfo localPackageInfo = null;
    if (paramContext != null);
    try
    {
      localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 20815);
      return localPackageInfo;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      el.a(a, "Cannot find package info for package: " + paramContext.getPackageName());
    }
    return null;
  }

  public static ApplicationInfo b(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = null;
    if (paramContext != null);
    try
    {
      localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      return localApplicationInfo;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      el.a(a, "Cannot find application info for package: " + paramContext.getPackageName());
    }
    return null;
  }

  public static String c(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.packageName != null))
      return paramContext.packageName;
    return "";
  }

  public static Bundle d(Context paramContext)
  {
    paramContext = b(paramContext);
    if ((paramContext != null) && (paramContext.metaData != null))
      return paramContext.metaData;
    return Bundle.EMPTY;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dx
 * JD-Core Version:    0.6.2
 */