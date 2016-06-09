package cmcm.com.myapplication.com.facebook.ads;

public enum AdSize
{
  private final int a;
  private final int b;

  private AdSize(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  private static boolean a(AdSize paramAdSize, int paramInt1, int paramInt2)
  {
    return (paramAdSize != null) && (paramAdSize.a == paramInt1) && (paramAdSize.b == paramInt2);
  }

  public static AdSize fromWidthAndHeight(int paramInt1, int paramInt2)
  {
    AdSize[] arrayOfAdSize = (AdSize[])AdSize.class.getEnumConstants();
    int j = arrayOfAdSize.length;
    int i = 0;
    while (i < j)
    {
      AdSize localAdSize = arrayOfAdSize[i];
      if (a(localAdSize, paramInt1, paramInt2))
        return localAdSize;
      i += 1;
    }
    return null;
  }

  public int getHeight()
  {
    return this.b;
  }

  public int getWidth()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.AdSize
 * JD-Core Version:    0.6.2
 */