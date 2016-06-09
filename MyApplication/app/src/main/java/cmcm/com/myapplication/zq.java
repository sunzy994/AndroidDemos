package cmcm.com.myapplication;

public class zq
{
  public final float a;
  public final float b;

  public zq(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }

  public zq(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public static zq[] a(int paramInt1, int paramInt2)
  {
    zq[] arrayOfzq = com.lazyswipe.fan.hetero.iwatch.WatchFanItem.k[paramInt2];
    if (paramInt1 == 1)
      return arrayOfzq;
    if (paramInt1 == 0);
    for (paramInt1 = -90; ; paramInt1 = 90)
      return a(arrayOfzq, paramInt1);
  }

  public static zq[] a(zq[] paramArrayOfzq, int paramInt)
  {
    zq[] arrayOfzq = new zq[paramArrayOfzq.length];
    int i = 0;
    while (i < paramArrayOfzq.length)
    {
      arrayOfzq[i] = paramArrayOfzq[i].a(paramInt);
      i += 1;
    }
    i = 0;
    paramInt = 0;
    while (true)
    {
      if ((i >= arrayOfzq.length) || (arrayOfzq[i].a == 0.0F))
      {
        paramArrayOfzq = new zq[paramArrayOfzq.length];
        int j = 0;
        i = paramInt;
        paramInt = j;
        while (i < arrayOfzq.length - 1)
        {
          paramArrayOfzq[paramInt] = arrayOfzq[i];
          paramInt += 1;
          i += 1;
        }
      }
      paramInt += 1;
      i += 1;
    }
    i = 0;
    while (paramInt < arrayOfzq.length - 1)
    {
      paramArrayOfzq[paramInt] = arrayOfzq[i];
      i += 1;
      paramInt += 1;
    }
    if (arrayOfzq.length > 0)
      paramArrayOfzq[(arrayOfzq.length - 1)] = new zq(270.0F, paramArrayOfzq[0].b);
    return paramArrayOfzq;
  }

  public zq a(int paramInt)
  {
    return new zq(ahy.b(this.a + paramInt), this.b);
  }

  public String toString()
  {
    return "(" + this.a + " - " + this.b + ")";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zq
 * JD-Core Version:    0.6.2
 */