package cmcm.com.myapplication;

class cr
{
  static final int[] a = new int[0];
  static final long[] b = new long[0];
  static final Object[] c = new Object[0];

  public static int a(int paramInt)
  {
    return c(paramInt * 4) / 4;
  }

  static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1 - 1;
    paramInt1 = i;
    i = j;
    while (paramInt1 <= i)
    {
      j = paramInt1 + i >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2)
        paramInt1 = j + 1;
      else if (k > paramInt2)
        i = j - 1;
      else
        return j;
    }
    return paramInt1 ^ 0xFFFFFFFF;
  }

  static int a(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = 0;
    int j = paramInt - 1;
    paramInt = i;
    i = j;
    while (paramInt <= i)
    {
      j = paramInt + i >>> 1;
      long l = paramArrayOfLong[j];
      if (l < paramLong)
        paramInt = j + 1;
      else if (l > paramLong)
        i = j - 1;
      else
        return j;
    }
    return paramInt ^ 0xFFFFFFFF;
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static int b(int paramInt)
  {
    return c(paramInt * 8) / 8;
  }

  public static int c(int paramInt)
  {
    int i = 4;
    while (true)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12)
          j = (1 << i) - 12;
      }
      else
        return j;
      i += 1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cr
 * JD-Core Version:    0.6.2
 */