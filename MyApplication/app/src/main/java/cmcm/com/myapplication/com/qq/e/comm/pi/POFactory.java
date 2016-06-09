package cmcm.com.myapplication.com.qq.e.comm.pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.qq.e.ads.banner.ADSize;
import com.qq.e.comm.adevent.ADListener;

public abstract interface POFactory
{
  public abstract GWI createGridAppWallView(Activity paramActivity, String paramString1, String paramString2);

  public abstract SVSD getAPKDownloadServiceDelegate(Service paramService);

  public abstract ACTD getActivityDelegate(String paramString, Activity paramActivity);

  public abstract AWI getAppWallView(Context paramContext, String paramString1, String paramString2);

  public abstract BVI getBannerView(Activity paramActivity, ADSize paramADSize, String paramString1, String paramString2);

  public abstract IADI getIADView(Activity paramActivity, String paramString1, String paramString2);

  public abstract NADI getNativeADDelegate(Context paramContext, String paramString1, String paramString2, ADListener paramADListener);

  public abstract SPVI getSplashAdView(Context paramContext, String paramString1, String paramString2);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.pi.POFactory
 * JD-Core Version:    0.6.2
 */