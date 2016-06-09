package cmcm.com.myapplication.com.holaverse.ad.google.nativead;

import java.util.List;

public abstract interface NativeCustomTemplateAdAdapter
{
  public abstract List<String> getAvailableAssetNames();

  public abstract String getCustomTemplateId();

  public abstract GGNativeAdAdapter.Image getImage(String paramString);

  public abstract CharSequence getText(String paramString);

  public abstract void performClick(String paramString);

  public abstract void recordImpression();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.ad.google.nativead.NativeCustomTemplateAdAdapter
 * JD-Core Version:    0.6.2
 */