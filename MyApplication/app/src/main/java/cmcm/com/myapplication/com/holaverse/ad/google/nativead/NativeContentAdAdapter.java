package cmcm.com.myapplication.com.holaverse.ad.google.nativead;

import android.view.ViewGroup;
import java.util.List;

public abstract interface NativeContentAdAdapter
{
  public abstract ViewGroup getAdView();

  public abstract CharSequence getAdvertiser();

  public abstract CharSequence getBody();

  public abstract CharSequence getCallToAction();

  public abstract CharSequence getHeadline();

  public abstract List<GGNativeAdAdapter.Image> getImages();

  public abstract GGNativeAdAdapter.Image getLogo();

  public abstract void registerView(GGNativeAdAdapter.AdViewElements paramAdViewElements);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.ad.google.nativead.NativeContentAdAdapter
 * JD-Core Version:    0.6.2
 */