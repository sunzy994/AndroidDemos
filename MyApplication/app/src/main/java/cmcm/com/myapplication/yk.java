package cmcm.com.myapplication;

public final class yk
{
  public static double a = 5.0D;
  public static double b = f + a;
  private static int c = -1;
  private static int d = -1;
  private static int e = -1;
  private static double f = 90.0D;
  private static double g = Math.toRadians(f);
  private static double h = Math.toRadians(a);
  private static double i = Math.toRadians(b);

  public static double a(int paramInt1, int paramInt2)
  {
    return i / (paramInt2 * 2) * ((paramInt2 - paramInt1) * 2 - 1) - h / 2.0D;
  }

  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    paramInt5 = yb.getInstance().getCenterOffset();
    if (paramBoolean)
      paramInt1 -= paramInt5;
    double d1;
    double d2;
    while (true)
    {
      paramInt2 = paramInt7 - paramInt2 - paramInt5;
      d1 = Math.toDegrees(Math.atan2(paramInt2, paramInt1));
      d2 = Math.hypot(paramInt1, paramInt2);
      if (d2 >= d - paramInt4 / 2)
        break;
      paramInt2 = -1;
      return paramInt2;
      paramInt1 = paramInt6 - paramInt1 - paramInt5;
    }
    if (d2 > c + paramInt4 / 2)
      return -1;
    if ((d2 > d - paramInt4 / 2) && (d2 < d + paramInt4 / 2))
    {
      paramInt1 = 1;
      label122: if (paramInt1 == 0)
        break label166;
      if (paramInt3 >= 4)
        break label161;
    }
    while (true)
    {
      paramInt3 = paramInt3 - (int)(d1 / (b / paramInt3)) - 1;
      paramInt2 = paramInt3;
      if (paramInt1 != 0)
        break;
      return paramInt3 + 4;
      paramInt1 = 0;
      break label122;
      label161: paramInt3 = 4;
      continue;
      label166: paramInt3 -= 4;
    }
  }

  private static yl a(int paramInt, double paramDouble, boolean paramBoolean)
  {
    int k = (int)(paramInt * Math.cos(paramDouble));
    if (paramBoolean);
    for (int j = 1; ; j = -1)
      return new yl(j * k, (int)(paramInt * Math.sin(paramDouble) - e * Math.sin(paramDouble)));
  }

  public static yl a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return a(paramInt3, a(paramInt1, paramInt2), paramBoolean);
  }

  public static yl a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < 4)
    {
      if (paramInt2 < 4)
        return a(paramInt1, paramInt2, d, paramBoolean);
      return b(paramInt1, paramBoolean);
    }
    return a(paramInt1 - 4, paramInt2 - 4, c, paramBoolean);
  }

  public static yl a(int paramInt, boolean paramBoolean)
  {
    int j = (int)((Math.sqrt(2.0D) - 1.0D) * paramInt);
    if (paramBoolean);
    for (paramInt = j; ; paramInt = -j)
      return new yl(paramInt, j);
  }

  public static void a(float paramFloat)
  {
    d = (int)(d * paramFloat);
    c = (int)(c * paramFloat);
  }

  public static void a(int paramInt)
  {
    a = paramInt;
    b = f + a;
    g = Math.toRadians(f);
    h = Math.toRadians(a);
    i = Math.toRadians(b);
  }

  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    d = paramInt1;
    c = paramInt2;
    e = paramInt3;
    f = 90.0D;
    if (yb.y());
    for (double d1 = -4.0D; ; d1 = 5.0D)
    {
      a = d1;
      b = f + a;
      g = Math.toRadians(f);
      h = Math.toRadians(a);
      i = Math.toRadians(b);
      return;
    }
  }

  private static double b(int paramInt)
  {
    return a(paramInt, 4);
  }

  private static yl b(int paramInt, boolean paramBoolean)
  {
    double d1 = b(paramInt);
    return a(d, d1, paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yk
 * JD-Core Version:    0.6.2
 */