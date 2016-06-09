package cmcm.com.myapplication.com.holaverse.ad.google.nativead;

import android.content.Context;
import android.view.View;

public abstract interface GGNativeAdAdapter
{
  public static final int ORIENTATION_ANY = 0;
  public static final int ORIENTATION_LANDSCAPE = 2;
  public static final int ORIENTATION_PORTRAIT = 1;

  public abstract void init(Context paramContext, String paramString);

  public abstract boolean isAdView(View paramView);

  public abstract void loadAd();

  public abstract void setAdListener(AdListenerAdapter paramAdListenerAdapter);

  public abstract void setAppInstallAdEnable(NativeAppInstallAdAdapter.OnAppInstallAdLoadedListenerAdapter paramOnAppInstallAdLoadedListenerAdapter);

  public abstract void setContentAdEnable(NativeContentAdAdapter.OnContentAdLoadedListenerAdapter paramOnContentAdLoadedListenerAdapter);

  public abstract void setCustomTemplateAd(String paramString, NativeCustomTemplateAdAdapter.OnCustomTemplateAdLoadedListenerAdapter paramOnCustomTemplateAdLoadedListenerAdapter, NativeCustomTemplateAdAdapter.OnCustomClickListenerAdapter paramOnCustomClickListenerAdapter);

  public abstract void setImageOrientation(int paramInt);

  public abstract void setRequestMultipleImage(boolean paramBoolean);

  public abstract void setReturnUrlsForImageAssets(boolean paramBoolean);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.ad.google.nativead.GGNativeAdAdapter
 * JD-Core Version:    0.6.2
 */