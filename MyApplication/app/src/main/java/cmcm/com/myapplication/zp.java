package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.Arrays;

public class zp
{
  private static final int[] a = new int[256];
  private static final int[] b = new int[256];
  private static final int[] c = new int[256];
  private static final float[] d = new float[3];
  private static final float[] e = new float[3];

  private static int a(int paramInt)
  {
    return Math.round((paramInt + 0.01F) / 51.0F) * 51;
  }

  public static int a(Context paramContext, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      j = -1;
      return j;
    }
    int i8 = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    paramContext = new int[i8 * i];
    paramBitmap.getPixels(paramContext, 0, i8, 0, 0, i8, i);
    int i9 = (int)(i8 * 0.16F);
    int i10 = (int)(i * 0.16F);
    int i11 = (int)(i8 * 0.84F);
    int i12 = (int)(i * 0.84F);
    int n = 0;
    Arrays.fill(a, 0);
    Arrays.fill(b, 0);
    Arrays.fill(c, 0);
    int i13 = paramContext.length;
    int j = 0;
    int k = 0;
    int i4 = 0;
    int i1 = 0;
    int m = 0;
    i = 0;
    int i2 = 0;
    label127: int i14;
    int i3;
    int i5;
    int i6;
    label185: int i7;
    if (i4 < i13)
    {
      i14 = paramContext[i4];
      i3 = i2 % i8;
      i5 = i2 / i8;
      if ((i5 < i10) || (i5 > i12) || (i3 < i9) || (i3 > i11))
      {
        i6 = 1;
        i7 = i2 + 1;
        if (i6 == 0)
          break label260;
        i5 = n + 1;
        i3 = i1;
        i2 = i5;
        if (n % 2 == 0)
          break label295;
        n = m;
        m = i;
        i = n;
        n = i5;
      }
    }
    while (true)
    {
      i4 += 1;
      i2 = m;
      m = i;
      i = i2;
      i2 = i7;
      break label127;
      i6 = 0;
      break label185;
      label260: i3 = i1 + 1;
      if (i1 % 32 != 0)
      {
        i1 = i3;
        i2 = i;
        i = m;
        m = i2;
      }
      else
      {
        i2 = n;
        label295: if (i14 >>> 24 > 0)
        {
          i1 = Color.red(i14);
          n = Color.green(i14);
          i5 = Color.blue(i14);
          a[i1] += 1;
          b[n] += 1;
          c[i5] += 1;
          if ((!a(i1, n, i5)) || (i6 != 0))
          {
            m += i5;
            k += i1;
            i5 = i + 1;
            j += n;
            i1 = i3;
            n = i2;
            i = m;
            m = i5;
            continue;
            if (i == 0)
            {
              k = 0;
              if (i != 0)
                break label519;
              j = 0;
              label438: if (i != 0)
                break label526;
              m = 0;
            }
            while (true)
            {
              k = Color.rgb(k, j, m);
              m = (int)(i * 0.08F);
              i = a(a, m);
              j = a(b, m);
              m = a(c, m);
              if ((i != -1) && (j != -1) && (m != -1))
                break label535;
              return k;
              k /= i;
              break;
              j /= i;
              break label438;
              m /= i;
            }
            j = Color.rgb(i, j, m);
            Color.colorToHSV(j, d);
            i = (int)d[0];
            Color.colorToHSV(k, e);
            if (Math.abs(i - (int)e[0]) < 5);
            for (i = 1; i == 0; i = 0)
              return k;
            break;
          }
        }
        label519: label526: label535: i5 = i;
        i1 = i3;
        n = i2;
        i = m;
        m = i5;
      }
    }
  }

  private static int a(int[] paramArrayOfInt, int paramInt)
  {
    int n = 0;
    int i = 0;
    int k = -1;
    int j = -1;
    while (i < paramArrayOfInt.length)
    {
      int m = k;
      if (paramArrayOfInt[i] > k)
      {
        m = paramArrayOfInt[i];
        j = i;
      }
      i += 1;
      k = m;
    }
    i = n;
    if (j != -1)
    {
      i = n;
      if (k >= paramInt)
        i = 1;
    }
    if (i != 0)
      return j;
    return -1;
  }

  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = a(paramInt1);
    paramInt2 = a(paramInt2);
    paramInt3 = a(paramInt3);
    return (paramInt1 == paramInt2) && (paramInt1 == paramInt3);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zp
 * JD-Core Version:    0.6.2
 */