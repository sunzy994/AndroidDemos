package cmcm.com.myapplication.com.facebook.ads;

public abstract interface AdListener
{
  public abstract void onAdClicked(Ad paramAd);

  public abstract void onAdLoaded(Ad paramAd);

  public abstract void onError(Ad paramAd, AdError paramAdError);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.AdListener
 * JD-Core Version:    0.6.2
 */