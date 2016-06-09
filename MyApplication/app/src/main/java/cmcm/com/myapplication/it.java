package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

class it
{
  private final RectF a = new RectF();
  private final Paint b = new Paint();
  private final Paint c = new Paint();
  private final Drawable.Callback d;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 5.0F;
  private float i = 2.5F;
  private int[] j;
  private int k;
  private float l;
  private float m;
  private float n;
  private boolean o;
  private Path p;
  private float q;
  private double r;
  private int s;
  private int t;
  private int u;
  private final Paint v = new Paint(1);
  private int w;
  private int x;

  public it(Drawable.Callback paramCallback)
  {
    this.d = paramCallback;
    this.b.setStrokeCap(Cap.SQUARE);
    this.b.setAntiAlias(true);
    this.b.setStyle(Style.STROKE);
    this.c.setStyle(Style.FILL);
    this.c.setAntiAlias(true);
  }

  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Rect paramRect)
  {
    if (this.o)
    {
      if (this.p != null)
        break label213;
      this.p = new Path();
      this.p.setFillType(FillType.EVEN_ODD);
    }
    while (true)
    {
      float f1 = (int)this.i / 2;
      float f2 = this.q;
      float f3 = (float)(this.r * Math.cos(0.0D) + paramRect.exactCenterX());
      float f4 = (float)(this.r * Math.sin(0.0D) + paramRect.exactCenterY());
      this.p.moveTo(0.0F, 0.0F);
      this.p.lineTo(this.s * this.q, 0.0F);
      this.p.lineTo(this.s * this.q / 2.0F, this.t * this.q);
      this.p.offset(f3 - f1 * f2, f4);
      this.p.close();
      this.c.setColor(this.x);
      paramCanvas.rotate(paramFloat1 + paramFloat2 - 5.0F, paramRect.exactCenterX(), paramRect.exactCenterY());
      paramCanvas.drawPath(this.p, this.c);
      return;
      label213: this.p.reset();
    }
  }

  private int n()
  {
    return (this.k + 1) % this.j.length;
  }

  private void o()
  {
    this.d.invalidateDrawable(null);
  }

  public int a()
  {
    return this.j[n()];
  }

  public void a(double paramDouble)
  {
    this.r = paramDouble;
  }

  public void a(float paramFloat)
  {
    this.h = paramFloat;
    this.b.setStrokeWidth(paramFloat);
    o();
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.s = ((int)paramFloat1);
    this.t = ((int)paramFloat2);
  }

  public void a(int paramInt)
  {
    this.w = paramInt;
  }

  public void a(int paramInt1, int paramInt2)
  {
    float f1 = Math.min(paramInt1, paramInt2);
    if ((this.r <= 0.0D) || (f1 < 0.0F));
    for (f1 = (float)Math.ceil(this.h / 2.0F); ; f1 = (float)(f1 / 2.0F - this.r))
    {
      this.i = f1;
      return;
    }
  }

  public void a(Canvas paramCanvas, Rect paramRect)
  {
    RectF localRectF = this.a;
    localRectF.set(paramRect);
    localRectF.inset(this.i, this.i);
    float f1 = (this.e + this.g) * 360.0F;
    float f2 = (this.f + this.g) * 360.0F - f1;
    this.b.setColor(this.x);
    paramCanvas.drawArc(localRectF, f1, f2, false, this.b);
    a(paramCanvas, f1, f2, paramRect);
    if (this.u < 255)
    {
      this.v.setColor(this.w);
      this.v.setAlpha(255 - this.u);
      paramCanvas.drawCircle(paramRect.exactCenterX(), paramRect.exactCenterY(), paramRect.width() / 2, this.v);
    }
  }

  public void a(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
    o();
  }

  public void a(boolean paramBoolean)
  {
    if (this.o != paramBoolean)
    {
      this.o = paramBoolean;
      o();
    }
  }

  public void a(int[] paramArrayOfInt)
  {
    this.j = paramArrayOfInt;
    c(0);
  }

  public void b()
  {
    c(n());
  }

  public void b(float paramFloat)
  {
    this.e = paramFloat;
    o();
  }

  public void b(int paramInt)
  {
    this.x = paramInt;
  }

  public int c()
  {
    return this.u;
  }

  public void c(float paramFloat)
  {
    this.f = paramFloat;
    o();
  }

  public void c(int paramInt)
  {
    this.k = paramInt;
    this.x = this.j[this.k];
  }

  public float d()
  {
    return this.h;
  }

  public void d(float paramFloat)
  {
    this.g = paramFloat;
    o();
  }

  public void d(int paramInt)
  {
    this.u = paramInt;
  }

  public float e()
  {
    return this.e;
  }

  public void e(float paramFloat)
  {
    if (paramFloat != this.q)
    {
      this.q = paramFloat;
      o();
    }
  }

  public float f()
  {
    return this.l;
  }

  public float g()
  {
    return this.m;
  }

  public int h()
  {
    return this.j[this.k];
  }

  public float i()
  {
    return this.f;
  }

  public double j()
  {
    return this.r;
  }

  public float k()
  {
    return this.n;
  }

  public void l()
  {
    this.l = this.e;
    this.m = this.f;
    this.n = this.g;
  }

  public void m()
  {
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = 0.0F;
    b(0.0F);
    c(0.0F);
    d(0.0F);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     it
 * JD-Core Version:    0.6.2
 */