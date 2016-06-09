package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.view.b;

public class NativeAdView
{
  public static View render(Context paramContext, NativeAd paramNativeAd, NativeAdView.Type paramType)
  {
    return render(paramContext, paramNativeAd, paramType, null);
  }

  public static View render(Context paramContext, NativeAd paramNativeAd, NativeAdView.Type paramType, NativeAdViewAttributes paramNativeAdViewAttributes)
  {
    NativeAdViewAttributes localNativeAdViewAttributes;
    if (paramNativeAd.isNativeConfigEnabled())
      localNativeAdViewAttributes = paramNativeAd.getAdViewAttributes();
    while (true)
    {
      paramNativeAd.a(paramType);
      return new b(paramContext, paramNativeAd, paramType, localNativeAdViewAttributes);
      localNativeAdViewAttributes = paramNativeAdViewAttributes;
      if (paramNativeAdViewAttributes == null)
        localNativeAdViewAttributes = new NativeAdViewAttributes();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAdView
 * JD-Core Version:    0.6.2
 */