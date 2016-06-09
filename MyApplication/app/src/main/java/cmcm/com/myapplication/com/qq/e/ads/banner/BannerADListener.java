package cmcm.com.myapplication.com.qq.e.ads.banner;

public abstract interface BannerADListener
{
  public abstract void onADClicked();

  public abstract void onADCloseOverlay();

  public abstract void onADClosed();

  public abstract void onADExposure();

  public abstract void onADLeftApplication();

  public abstract void onADOpenOverlay();

  public abstract void onADReceiv();

  public abstract void onNoAD(int paramInt);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.banner.BannerADListener
 * JD-Core Version:    0.6.2
 */