package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.lazyswipe.SwipeApplication;
import java.io.File;

public class abo extends aqv
{
  private static int b = -1;
  private static long c = -1L;

  public abo()
  {
    this.a = "gg-native-dynamicloading-sdk.jar";
  }

  private void i(Context paramContext)
  {
    if (b < 0)
      b = paramContext.getResources().getInteger(2131361794);
    try
    {
      b = SwipeApplication.c().getPackageManager().getApplicationInfo("com.lazyswipe", 128).metaData.getInt("com.google.android.gms.version");
      return;
    }
    catch (Exception paramContext)
    {
      asp.b("Swipe.GgNativeAdSdk", "Could not fetch GMS version", paramContext);
    }
  }

  public boolean a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if ((!e(paramContext).exists()) && (l - c > 600000L));
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
        c = l;
      return bool;
    }
  }

  public String b(Context paramContext)
  {
    i(paramContext);
    return "ggna" + b;
  }

  public String c(Context paramContext)
  {
    return "http://d.holalauncher.com/sdk/" + b(paramContext) + "-" + a() + ".json";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abo
 * JD-Core Version:    0.6.2
 */