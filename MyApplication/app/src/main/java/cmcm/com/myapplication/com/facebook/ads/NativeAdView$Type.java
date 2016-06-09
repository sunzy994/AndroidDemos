package cmcm.com.myapplication.com.facebook.ads;

public enum NativeAdView$Type
{
  private final int a;
  private final int b;

  private NativeAdView$Type(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public int getHeight()
  {
    return this.b;
  }

  public int getValue()
  {
    switch (this.b)
    {
    default:
      return -1;
    case 100:
      return 1;
    case 120:
      return 2;
    case 300:
      return 3;
    case 400:
    }
    return 4;
  }

  public int getWidth()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAdView.Type
 * JD-Core Version:    0.6.2
 */