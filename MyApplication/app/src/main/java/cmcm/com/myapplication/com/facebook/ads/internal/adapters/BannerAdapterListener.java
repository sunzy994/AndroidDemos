package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.view.View;
import com.facebook.ads.AdError;

public abstract interface BannerAdapterListener
{
  public abstract void onBannerAdClicked(BannerAdapter paramBannerAdapter);

  public abstract void onBannerAdExpanded(BannerAdapter paramBannerAdapter);

  public abstract void onBannerAdLoaded(BannerAdapter paramBannerAdapter, View paramView);

  public abstract void onBannerAdMinimized(BannerAdapter paramBannerAdapter);

  public abstract void onBannerError(BannerAdapter paramBannerAdapter, AdError paramAdError);

  public abstract void onBannerLoggingImpression(BannerAdapter paramBannerAdapter);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.BannerAdapterListener
 * JD-Core Version:    0.6.2
 */