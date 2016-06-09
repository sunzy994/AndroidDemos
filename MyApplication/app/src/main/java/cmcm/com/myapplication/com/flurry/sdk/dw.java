package cmcm.com.myapplication.com.flurry.sdk;

import android.os.Looper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;

public class dw
{
  private static final String a = dw.class.getSimpleName();

  public static AdvertisingIdClient.Info a()
  {
    try
    {
      if (Looper.getMainLooper().getThread() == Thread.currentThread())
        throw new IllegalStateException("Must be called from a background thread!");
    }
    finally
    {
    }
    boolean bool = b();
    if (!bool);
    for (AdvertisingIdClient.Info localInfo = null; ; localInfo = c())
      return localInfo;
  }

  public static boolean b()
  {
    try
    {
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(do.a().b());
      if (i == 0)
        return true;
      el.d(a, "Google Play Services not available - connection result: " + i);
      return false;
    }
    catch (Exception localException)
    {
      el.d(a, "Google Play Services not available - " + localException);
    }
    return false;
  }

  private static AdvertisingIdClient.Info c()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(do.a().b());
      return localInfo;
    }
    catch (IOException localIOException)
    {
      el.a(6, a, "Exception in readAdvertisingInfo():" + localIOException);
      return null;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      el.a(6, a, "Exception in readAdvertisingInfo():" + localGooglePlayServicesNotAvailableException);
      return null;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      el.a(6, a, "Exception in readAdvertisingInfo():" + localGooglePlayServicesRepairableException);
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dw
 * JD-Core Version:    0.6.2
 */