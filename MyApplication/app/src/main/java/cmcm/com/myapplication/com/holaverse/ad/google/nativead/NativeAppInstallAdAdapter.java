package cmcm.com.myapplication.com.holaverse.ad.google.nativead;

import android.view.ViewGroup;
import java.util.List;

public abstract interface NativeAppInstallAdAdapter
{
  public abstract ViewGroup getAdView();

  public abstract CharSequence getBody();

  public abstract CharSequence getCallToAction();

  public abstract CharSequence getHeadline();

  public abstract GGNativeAdAdapter.Image getIcon();

  public abstract List<GGNativeAdAdapter.Image> getImages();

  public abstract CharSequence getPrice();

  public abstract Double getStarRating();

  public abstract CharSequence getStore();

  public abstract void registerView(GGNativeAdAdapter.AdViewElements paramAdViewElements);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.ad.google.nativead.NativeAppInstallAdAdapter
 * JD-Core Version:    0.6.2
 */