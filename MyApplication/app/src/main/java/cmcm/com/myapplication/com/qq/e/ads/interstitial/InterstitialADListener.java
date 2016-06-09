package cmcm.com.myapplication.com.qq.e.ads.interstitial;

public abstract interface InterstitialADListener
{
  public abstract void onADClicked();

  public abstract void onADClosed();

  public abstract void onADExposure();

  public abstract void onADLeftApplication();

  public abstract void onADOpened();

  public abstract void onADReceive();

  public abstract void onNoAD(int paramInt);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.interstitial.InterstitialADListener
 * JD-Core Version:    0.6.2
 */