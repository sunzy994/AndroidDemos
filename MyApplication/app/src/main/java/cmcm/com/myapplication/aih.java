package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import java.util.Arrays;

public class aih
{
  public static final Rect a = new Rect();
  private static boolean b = false;
  private static final int[] c = new int[16];
  private static int d = 2;
  private static int e = 10;
  private static float f = 1.0F;

  private static float a(int[] paramArrayOfInt)
  {
    float f2;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      f2 = -1.0F;
      return f2;
    }
    float f3 = b(paramArrayOfInt);
    int j = paramArrayOfInt.length;
    float f1 = 0.0F;
    int i = 0;
    while (true)
    {
      f2 = f1;
      if (i >= j)
        break;
      int k = paramArrayOfInt[i];
      f2 = k;
      float f4 = k;
      i += 1;
      f1 = (f4 - f3) * (f2 - f3) + f1;
    }
  }

  private static void a(Context paramContext)
  {
    d = (int)(2.0F * paramContext.getResources().getDisplayMetrics().density / 1.5F + 0.5F);
    e = (int)(15.0F * paramContext.getResources().getDisplayMetrics().density * (1.0D - Math.sqrt(2.0D) / 2.0D) + 0.5D);
    f = paramContext.getResources().getDisplayMetrics().density * 1.25F;
    b = true;
  }

  public static boolean a(Context paramContext, Bitmap paramBitmap)
  {
    return a(paramContext, paramBitmap, 0, 0, 0, 0);
  }

  public static boolean a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!b)
      a(paramContext);
    if (paramBitmap == null)
      return false;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramContext = new int[i * j];
    paramBitmap.getPixels(paramContext, 0, i, 0, 0, i, j);
    try
    {
      boolean bool = a(paramContext, i, j, paramInt1, paramInt2, paramInt3, paramInt4);
      return bool;
    }
    catch (Exception paramContext)
    {
      a.set(0, 0, i, j);
    }
    return false;
  }

  private static boolean a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Arrays.fill(c, 0);
    int n = paramInt4 * paramInt1;
    int i1 = (paramInt2 - paramInt4 - paramInt6) / 4 * paramInt1;
    int i2 = paramInt1 / 2;
    int i = 0;
    int m;
    int k;
    while (i < 3)
    {
      m = 0;
      j = 0;
      while (true)
      {
        k = m;
        if (j < i2)
        {
          if ((paramArrayOfInt[((i + 1) * i1 + n + j + paramInt3)] & 0xFF000000) >>> 24 > 250)
          {
            c[i] = (j + paramInt3);
            k = 1;
          }
        }
        else
        {
          if (k != 0)
            break;
          return false;
        }
        j += 1;
      }
      i += 1;
    }
    if (a(new int[] { c[0], c[1], c[2] }) > f)
      return false;
    i = 0;
    while (i < 3)
    {
      m = 0;
      j = 0;
      while (true)
      {
        k = m;
        if (j < i2)
        {
          if ((paramArrayOfInt[((i + 1) * i1 + n + paramInt1 - j - 1 - paramInt5)] & 0xFF000000) >>> 24 > 250)
          {
            c[(i + 3)] = (j + paramInt5);
            k = 1;
          }
        }
        else
        {
          if (k != 0)
            break;
          return false;
        }
        j += 1;
      }
      i += 1;
    }
    if (a(new int[] { c[3], c[4], c[5] }) > f)
      return false;
    i = 0;
    while (i < 3)
    {
      j = c[i];
      while (j < paramInt1 - c[(i + 3)])
      {
        if (paramArrayOfInt[((i + 1) * i1 + n + j)] >>> 24 == 0)
          return false;
        j += 1;
      }
      i += 1;
    }
    n = (paramInt1 - paramInt3 - paramInt5) / 4;
    i1 = paramInt2 / 2;
    i = 0;
    while (i < 3)
    {
      m = 0;
      j = 0;
      while (true)
      {
        k = m;
        if (j < i1)
        {
          if ((paramArrayOfInt[((i + 1) * n + paramInt3 + (j + paramInt4) * paramInt1)] & 0xFF000000) >>> 24 > 250)
          {
            c[(i + 6)] = (j + paramInt4);
            k = 1;
          }
        }
        else
        {
          if (k != 0)
            break;
          return false;
        }
        j += 1;
      }
      i += 1;
    }
    if (a(new int[] { c[6], c[7], c[8] }) > f)
      return false;
    i = 0;
    while (i < 3)
    {
      m = 0;
      j = 0;
      while (true)
      {
        k = m;
        if (j < i1)
        {
          if ((paramArrayOfInt[((i + 1) * n + paramInt3 + (paramInt2 - paramInt6 - j - 1) * paramInt1)] & 0xFF000000) >>> 24 > 250)
          {
            c[(i + 9)] = (j + paramInt6);
            k = 1;
          }
        }
        else
        {
          if (k != 0)
            break;
          return false;
        }
        j += 1;
      }
      i += 1;
    }
    if (a(new int[] { c[9], c[10], c[11] }) > f)
      return false;
    i = 0;
    while (i < 3)
    {
      j = c[(i + 6)];
      while (j < paramInt2 - c[(i + 9)])
      {
        if (paramArrayOfInt[((i + 1) * n + paramInt3 + j * paramInt1)] >>> 24 == 0)
          return false;
        j += 1;
      }
      i += 1;
    }
    a.left = ((int)(b(new int[] { c[0], c[1], c[2] }) + 0.5F));
    a.right = ((int)(paramInt1 - b(new int[] { c[3], c[4], c[5] })));
    a.top = ((int)(b(new int[] { c[6], c[7], c[8] }) + 0.5F));
    a.bottom = ((int)(paramInt1 - b(new int[] { c[9], c[10], c[11] })));
    float f1 = a.width();
    float f2 = a.height();
    if ((f1 == 0.0F) || (f2 == 0.0F))
      return false;
    if (f1 > f2);
    for (f1 /= f2; f1 > 1.05F; f1 = f2 / f1)
      return false;
    int j = Math.min(paramInt1, paramInt2);
    f1 = paramInt1 * 1.0F / j;
    f2 = paramInt2 * 1.0F / j;
    i = 0;
    if (i < j)
    {
      if ((paramArrayOfInt[(((int)(i * f2) + paramInt4) * paramInt1 + ((int)(i * f1) + paramInt3))] & 0xFF000000) >>> 24 > 250)
        c[12] = i;
    }
    else
    {
      i = 0;
      label1074: if (i < j)
      {
        if ((paramArrayOfInt[(((int)(paramInt2 - i * f2) - 1 - paramInt6) * paramInt1 + ((int)(paramInt1 - i * f1) - 1 - paramInt5))] & 0xFF000000) >>> 24 <= 250)
          break label1392;
        c[13] = i;
      }
      i = 0;
      label1139: if (i < j)
      {
        if ((paramArrayOfInt[(((int)(i * f2) + paramInt4) * paramInt1 + ((int)(paramInt1 - i * f1) - 1 - paramInt5))] & 0xFF000000) >>> 24 <= 250)
          break label1401;
        c[14] = i;
      }
      paramInt4 = 0;
    }
    while (true)
    {
      if (paramInt4 < j)
      {
        if ((paramArrayOfInt[(((int)(paramInt2 - paramInt4 * f2) - 1 - paramInt6) * paramInt1 + ((int)(paramInt4 * f1) + paramInt3))] & 0xFF000000) >>> 24 > 250)
          c[15] = paramInt4;
      }
      else
      {
        if ((a(new int[] { c[12], c[13], c[14], c[15] }) <= d * d) || ((c[12] <= e * 0.8F) && (c[13] <= e * 0.8F) && (c[14] <= e * 0.8F) && (c[15] <= e * 0.8F)))
          break label1419;
        return false;
        i += 1;
        break;
        label1392: i += 1;
        break label1074;
        label1401: i += 1;
        break label1139;
      }
      paramInt4 += 1;
    }
    label1419: if (c[0] - paramInt3 > c[12])
      return false;
    return c[12] - c[0] + paramInt3 <= e;
  }

  private static float b(int[] paramArrayOfInt)
  {
    float f1 = 0.0F;
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      f1 += paramArrayOfInt[i];
      i += 1;
    }
    return f1 / paramArrayOfInt.length;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aih
 * JD-Core Version:    0.6.2
 */