package cmcm.com.myapplication.com.facebook.ads;

public abstract interface InterstitialAdListener extends AdListener
{
  public abstract void onInterstitialDismissed(Ad paramAd);

  public abstract void onInterstitialDisplayed(Ad paramAd);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.InterstitialAdListener
 * JD-Core Version:    0.6.2
 */