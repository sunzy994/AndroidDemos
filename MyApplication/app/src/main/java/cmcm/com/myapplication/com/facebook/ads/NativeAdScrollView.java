package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class NativeAdScrollView extends LinearLayout
{
  public static final int DEFAULT_INSET = 20;
  public static final int DEFAULT_MAX_ADS = 10;
  private final Context a;
  private final NativeAdsManager b;
  private final NativeAdScrollView.AdViewProvider c;
  private final NativeAdView.Type d;
  private final int e;
  private final NativeAdScrollView.b f;
  private final NativeAdViewAttributes g;

  public NativeAdScrollView(Context paramContext, NativeAdsManager paramNativeAdsManager, NativeAdScrollView.AdViewProvider paramAdViewProvider)
  {
    this(paramContext, paramNativeAdsManager, paramAdViewProvider, null, null, 10);
  }

  public NativeAdScrollView(Context paramContext, NativeAdsManager paramNativeAdsManager, NativeAdScrollView.AdViewProvider paramAdViewProvider, int paramInt)
  {
    this(paramContext, paramNativeAdsManager, paramAdViewProvider, null, null, paramInt);
  }

  private NativeAdScrollView(Context paramContext, NativeAdsManager paramNativeAdsManager, NativeAdScrollView.AdViewProvider paramAdViewProvider, NativeAdView.Type paramType, NativeAdViewAttributes paramNativeAdViewAttributes, int paramInt)
  {
    super(paramContext);
    if (!paramNativeAdsManager.isLoaded())
      throw new IllegalStateException("NativeAdsManager not loaded");
    if ((paramType == null) && (paramAdViewProvider == null))
      throw new IllegalArgumentException("Must provide one of AdLayoutProperties or a CustomAdView");
    this.a = paramContext;
    this.b = paramNativeAdsManager;
    this.g = paramNativeAdViewAttributes;
    this.c = paramAdViewProvider;
    this.d = paramType;
    this.e = paramInt;
    paramNativeAdsManager = new NativeAdScrollView.a(this);
    this.f = new NativeAdScrollView.b(this, paramContext);
    this.f.setAdapter(paramNativeAdsManager);
    setInset(20);
    paramNativeAdsManager.a();
    addView(this.f);
  }

  public NativeAdScrollView(Context paramContext, NativeAdsManager paramNativeAdsManager, NativeAdView.Type paramType)
  {
    this(paramContext, paramNativeAdsManager, null, paramType, new NativeAdViewAttributes(), 10);
  }

  public NativeAdScrollView(Context paramContext, NativeAdsManager paramNativeAdsManager, NativeAdView.Type paramType, NativeAdViewAttributes paramNativeAdViewAttributes)
  {
    this(paramContext, paramNativeAdsManager, null, paramType, paramNativeAdViewAttributes, 10);
  }

  public NativeAdScrollView(Context paramContext, NativeAdsManager paramNativeAdsManager, NativeAdView.Type paramType, NativeAdViewAttributes paramNativeAdViewAttributes, int paramInt)
  {
    this(paramContext, paramNativeAdsManager, null, paramType, paramNativeAdViewAttributes, paramInt);
  }

  public void setInset(int paramInt)
  {
    if (paramInt > 0)
    {
      DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
      int i = Math.round(paramInt * localDisplayMetrics.density);
      this.f.setPadding(i, 0, i, 0);
      NativeAdScrollView.b localb = this.f;
      float f1 = paramInt / 2;
      localb.setPageMargin(Math.round(localDisplayMetrics.density * f1));
      this.f.setClipToPadding(false);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAdScrollView
 * JD-Core Version:    0.6.2
 */