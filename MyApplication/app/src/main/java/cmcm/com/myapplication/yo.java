package cmcm.com.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import com.lazyswipe.SwipeApplication;

public class yo extends Drawable
{
  private static final String a = "Swipe." + yo.class.getSimpleName();
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private final Paint b = new Paint(7);
  private final Paint c = new Paint(7);
  private final Paint d = new Paint(7);
  private final Paint e = new Paint();
  private final Paint f = new Paint(7);
  private final Paint g = new Paint(7);
  private final Paint h = new Paint(7);
  private final Paint i = new Paint();
  private final int j;
  private final int k;
  private final int l;
  private int[] m;
  private float[] n;
  private int[] o;
  private float[] p;
  private int[] q;
  private float[] r;
  private final int s;
  private final int t;
  private final boolean u;
  private final int v;
  private PorterDuffXfermode w;
  private final String x;
  private final String y;
  private final boolean z;

  public yo(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString1, String paramString2, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    this.x = paramString1;
    this.y = paramString2;
    paramString1 = SwipeApplication.c().getResources();
    this.s = paramString1.getDimensionPixelSize(2131296340);
    this.t = paramString1.getDimensionPixelSize(2131296339);
    this.v = (this.s + paramInt2);
    this.u = paramBoolean1;
    this.z = paramBoolean2;
    a(paramArrayOfInt, paramArrayOfFloat);
    a(paramInt4, paramInt5);
    a(paramInt6);
    try
    {
      this.w = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
      return;
    }
    catch (Throwable paramString1)
    {
    }
  }

  private void a()
  {
    if (!ahu.a(this.u, this.x, this.y))
      return;
    Bitmap localBitmap = Bitmap.createBitmap(this.v, this.v, Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    int i1;
    int i3;
    Object localObject;
    if (this.u)
    {
      i1 = 0;
      i3 = this.v;
      if (this.A)
      {
        localObject = new SweepGradient(i1, i3, this.m, this.n);
        this.f.setShader((Shader)localObject);
      }
      if (this.B)
        if (!this.u)
          break label278;
    }
    label278: for (int i2 = asq.a(-3.0F); ; i2 = 0)
    {
      localObject = new RadialGradient(i2 + i1, i3, this.v, this.o, this.p, TileMode.CLAMP);
      this.g.setStyle(Style.FILL);
      this.g.setShader((Shader)localObject);
      if (this.C)
      {
        localObject = new RadialGradient(i1, i3, this.j, this.q, this.r, TileMode.CLAMP);
        this.h.setStyle(Style.FILL);
        this.h.setShader((Shader)localObject);
      }
      a(localCanvas, i1, i3, 1.0F, this.f, this.g, this.h, this.i);
      ahu.a(localBitmap, this.u, this.x, this.y);
      return;
      i1 = this.v;
      break;
    }
  }

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.C = false;
      return;
    }
    this.C = true;
    this.q = new int[] { 0, 0, paramInt };
    this.r = new float[] { 0.0F, (this.j - this.s + this.l) / (this.j + this.l), 1.0F };
  }

  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.B = false;
      return;
    }
    this.B = true;
    this.o = new int[] { 0, 0, paramInt1, paramInt2, Color.argb(29, Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2)), 0, 0 };
    this.p = new float[] { 0.0F, (this.k - this.t) / this.v, (this.k - 1) / this.v, this.k / this.v, (float)(this.k / this.v + 0.99D) / 2.0F, 0.99F, 1.0F };
  }

  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, Paint paramPaint4)
  {
    DrawFilter localDrawFilter = paramCanvas.getDrawFilter();
    paramCanvas.setDrawFilter(atw.a);
    if (this.A)
      paramCanvas.drawCircle(paramInt1, paramInt2, this.k * paramFloat, paramPaint1);
    if (this.B)
      paramCanvas.drawCircle(paramInt1, paramInt2, this.v * paramFloat, paramPaint2);
    paramPaint4.setXfermode(this.w);
    paramCanvas.drawCircle(paramInt1, paramInt2, this.j * paramFloat, paramPaint4);
    paramPaint4.setXfermode(null);
    if (this.C)
      paramCanvas.drawCircle(paramInt1, paramInt2, this.j * paramFloat, paramPaint3);
    paramCanvas.setDrawFilter(localDrawFilter);
  }

  private void a(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i1 = 0;
    if ((paramArrayOfInt == null) || (paramArrayOfFloat == null))
    {
      this.A = false;
      return;
    }
    if (paramArrayOfInt.length != paramArrayOfFloat.length)
    {
      this.A = false;
      throw new IllegalArgumentException("SectorGradientDrawable init failed");
    }
    this.A = true;
    int i2 = paramArrayOfFloat.length;
    if (this.u)
    {
      this.n = new float[i2 + 3];
      this.m = new int[i2 + 3];
      this.n[0] = 0.0F;
      this.m[0] = paramArrayOfInt[(i2 - 1)];
      this.n[1] = 0.7499F;
      this.m[1] = paramArrayOfInt[0];
      while (i1 < i2)
      {
        this.n[(i1 + 2)] = (paramArrayOfFloat[i1] * 0.2475F + 0.75F);
        this.m[(i1 + 2)] = paramArrayOfInt[i1];
        i1 += 1;
      }
      this.n[(this.n.length - 1)] = 1.0F;
      this.m[(this.n.length - 1)] = paramArrayOfInt[(i2 - 1)];
      return;
    }
    this.n = new float[i2 + 4];
    this.m = new int[i2 + 4];
    this.n[0] = 0.0F;
    this.m[0] = paramArrayOfInt[(i2 - 1)];
    this.n[1] = 0.499F;
    this.m[1] = paramArrayOfInt[(i2 - 1)];
    i1 = 0;
    while (i1 < i2)
    {
      this.n[(i2 - i1 - 1 + 2)] = (0.75F - paramArrayOfFloat[i1] * 0.2475F);
      this.m[(i2 - i1 - 1 + 2)] = paramArrayOfInt[i1];
      i1 += 1;
    }
    this.n[(i2 + 2)] = 0.7501F;
    this.m[(i2 + 2)] = paramArrayOfInt[0];
    this.n[(i2 + 3)] = 1.0F;
    this.m[(i2 + 3)] = paramArrayOfInt[0];
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.k <= 0)
      return;
    Rect localRect = getBounds();
    float f1 = Math.min(localRect.width(), localRect.height()) * 1.0F / getIntrinsicWidth();
    int i2 = (int)(this.l * f1);
    if (this.u);
    for (int i1 = localRect.left + i2; ; i1 = localRect.right - i2)
    {
      int i3 = localRect.bottom;
      paramCanvas.saveLayer(localRect.left, localRect.top, localRect.right, localRect.bottom, null, 31);
      a(paramCanvas, i1, i3 - i2, f1, this.b, this.c, this.d, this.e);
      paramCanvas.restore();
      if (this.D)
        break;
      this.D = true;
      arj.a(new Runnable()
      {
        public void run()
        {
          yo.a(yo.this);
        }
      });
      return;
    }
  }

  public int getIntrinsicHeight()
  {
    return this.v + this.l;
  }

  public int getIntrinsicWidth()
  {
    return this.v + this.l;
  }

  public int getOpacity()
  {
    return -3;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    float f1 = Math.min(paramRect.width(), paramRect.height()) / getIntrinsicWidth();
    int i2 = (int)(this.l * f1);
    int i1;
    int i3;
    if (this.u)
    {
      i1 = paramRect.left + i2;
      i3 = paramRect.bottom - i2;
      if (this.A)
      {
        paramRect = new SweepGradient(i1, i3, this.m, this.n);
        this.b.setShader(paramRect);
      }
      if (this.B)
        if ((!this.z) || (!this.u))
          break label240;
    }
    label240: for (i2 = asq.a(-3.0F); ; i2 = 0)
    {
      paramRect = new RadialGradient(i2 + i1, i3, this.v * f1, this.o, this.p, TileMode.CLAMP);
      this.c.setStyle(Style.FILL);
      this.c.setShader(paramRect);
      if (this.C)
      {
        paramRect = new RadialGradient(i1, i3, this.j * f1, this.q, this.r, TileMode.CLAMP);
        this.d.setStyle(Style.FILL);
        this.d.setShader(paramRect);
      }
      return;
      i1 = paramRect.right - i2;
      break;
    }
  }

  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yo
 * JD-Core Version:    0.6.2
 */