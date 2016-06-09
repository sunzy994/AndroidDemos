package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import java.util.Calendar;

public class aou
{
  static final float[] a = { 0.0F, 0.25F, 0.5F, 0.75F, 1.0F };
  static final float[] b = { 0.0F, 0.33F, 0.67F, 1.0F };
  static int[] c = { -16310738, -15587000, -14928800, -14336394, -13678452 };
  static int[] d = { -16310738, -15979974, -15583673, -14009024, -12303048 };
  static int[] e = { -16247476, -13232018, -12243304, -13997106, -16736562 };
  static int[] f = { -12251058, -13418396, -14261645, -15623796, -13120627 };
  static int[] g = { -16759449, -16754317, -16744052, -12860513, -10953835 };
  static int[] h = { -16758166, -14975073, -8534600, -2039913 };
  static int[] i = { -15371116, -14578773, -13323567, -7219738, -3216140 };
  static int[] j = { -16758166, -14975073, -8534600, -2039913 };
  static int[] k = { -16767649, -16755864, -16741518, -9461902, -18061 };
  static int[] l = { -14809503, -12243581, -8695667, -5021375, -1988788 };
  static int[] m = { -13092470, -10269288, -7380570, -4623957, -1736015 };
  static int[] n = { -16310738, -15914437, -15583673, -16170922, -16758171 };

  public static Drawable a()
  {
    return a(-1, -1);
  }

  public static Drawable a(int paramInt)
  {
    return a(-1, paramInt);
  }

  public static Drawable a(final int paramInt1, float paramFloat, int paramInt2)
  {
    ShaderFactory local1 = new ShaderFactory()
    {
      public Shader resize(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int[] arrayOfInt1 = aou.c();
        paramAnonymousInt2 = arrayOfInt1.length;
        float[] arrayOfFloat1;
        float[] arrayOfFloat2;
        int[] arrayOfInt2;
        label87: int i;
        float f2;
        float f1;
        if (paramAnonymousInt2 == 5)
        {
          arrayOfFloat1 = aou.a;
          arrayOfFloat2 = new float[paramAnonymousInt2 + 3];
          arrayOfInt2 = new int[paramAnonymousInt2 + 3];
          arrayOfFloat2[0] = 0.0F;
          arrayOfInt2[0] = 0;
          arrayOfFloat2[1] = ((int)(this.a * 0.6F));
          arrayOfInt2[1] = 0;
          arrayOfFloat2[2] = (this.a - 0.1F);
          arrayOfInt2[2] = asq.a(arrayOfInt1[0], 51);
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 >= paramAnonymousInt2)
            break label178;
          i = arrayOfInt1[paramAnonymousInt1];
          f2 = arrayOfFloat1[paramAnonymousInt1];
          if (paramAnonymousInt1 != 0)
            break label162;
          f1 = 0.2F;
        }
        while (true)
        {
          arrayOfInt2[(paramAnonymousInt1 + 3)] = asq.a(i, (int) (f1 * 255.0F));
          arrayOfFloat2[(paramAnonymousInt1 + 3)] = (this.a + f2 * (1.0F - this.a));
          paramAnonymousInt1 += 1;
          break label87;
          arrayOfFloat1 = aou.b;
          break;
          label162: if (paramAnonymousInt1 == 1)
            f1 = 0.85F;
          else
            f1 = 1.0F;
        }
        label178: return new LinearGradient(0.0F, 0.0F, 0.0F, paramInt1, arrayOfInt2, arrayOfFloat2, TileMode.CLAMP);
      }
    };
    ShapeDrawable local2 = new ShapeDrawable()
    {
      public void draw(Canvas paramAnonymousCanvas)
      {
        paramAnonymousCanvas.drawColor(this.a);
        super.draw(paramAnonymousCanvas);
      }
    };
    local2.setShaderFactory(local1);
    local2.setShape(new RectShape());
    return local2;
  }

  public static Drawable a(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0);
    for (int[] arrayOfInt = b(paramInt2); ; arrayOfInt = c())
      return a(paramInt1, arrayOfInt);
  }

  public static Drawable a(int paramInt, int[] paramArrayOfInt)
  {
    paramArrayOfInt = new GradientDrawable(Orientation.TOP_BOTTOM, paramArrayOfInt);
    if (paramInt >= 0)
      paramArrayOfInt.setAlpha(paramInt);
    return paramArrayOfInt;
  }

  public static Drawable a(int[] paramArrayOfInt)
  {
    return a(-1, paramArrayOfInt);
  }

  public static int b()
  {
    return c()[0];
  }

  static int[] b(int paramInt)
  {
    if (paramInt < 3)
      return c;
    if (paramInt < 6)
      return d;
    if (paramInt < 7)
      return e;
    if (paramInt < 8)
      return f;
    if (paramInt < 9)
      return g;
    if (paramInt < 12)
      return h;
    if (paramInt < 15)
      return i;
    if (paramInt < 18)
      return j;
    if (paramInt < 19)
      return k;
    if (paramInt < 20)
      return l;
    if (paramInt < 21)
      return m;
    return n;
  }

  static int[] c()
  {
    return b(Calendar.getInstance().get(11));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aou
 * JD-Core Version:    0.6.2
 */