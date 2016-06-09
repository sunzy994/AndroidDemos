package cmcm.com.myapplication;

import java.util.Random;

public final class ari
{
  private static final Random a = new Random();

  public static float a(float paramFloat)
  {
    return 0.01745329F * paramFloat;
  }

  public static float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2)
      return paramFloat1;
    return paramFloat2;
  }

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2)
      return paramFloat2;
    if (paramFloat1 > paramFloat3)
      return paramFloat3;
    return paramFloat1;
  }

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat1 != paramFloat3)
      paramFloat1 = paramFloat2 + (paramFloat5 - paramFloat1) * (paramFloat4 - paramFloat2) / (paramFloat3 - paramFloat1);
    do
    {
      return paramFloat1;
      paramFloat1 = paramFloat2;
    }
    while (paramFloat2 == paramFloat4);
    throw new IllegalArgumentException("x0 == x1, y0 != y1");
  }

  public static int a(int paramInt)
  {
    return (int)(a.nextFloat() * paramInt);
  }

  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      return paramInt1;
    return paramInt2;
  }

  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2)
      return paramInt2;
    if (paramInt1 > paramInt3)
      return paramInt3;
    return paramInt1;
  }

  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 < paramLong2)
      return paramLong2;
    if (paramLong1 > paramLong3)
      return paramLong3;
    return paramLong1;
  }

  public static float b(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2)
      return paramFloat1;
    return paramFloat2;
  }

  public static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f;
    if (paramFloat1 < paramFloat2)
    {
      f = paramFloat3;
      if (paramFloat1 < paramFloat3)
        f = paramFloat1;
    }
    do
    {
      return f;
      f = paramFloat3;
    }
    while (paramFloat2 >= paramFloat3);
    return paramFloat2;
  }

  public static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
      return paramInt1;
    return paramInt2;
  }

  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt1 < paramInt2)
    {
      i = paramInt3;
      if (paramInt1 < paramInt3)
        i = paramInt1;
    }
    do
    {
      return i;
      i = paramInt3;
    }
    while (paramInt2 >= paramInt3);
    return paramInt2;
  }

  public static float c(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= paramFloat2)
      return paramFloat1;
    return paramFloat1 + a.nextFloat() * (paramFloat2 - paramFloat1);
  }

  public static int c(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2)
      return paramInt1;
    return (int)(a.nextFloat() * (paramInt2 - paramInt1) + paramInt1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ari
 * JD-Core Version:    0.6.2
 */