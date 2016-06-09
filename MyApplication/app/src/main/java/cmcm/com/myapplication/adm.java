package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

public class adm
{
  final PointF a;
  final PointF b;
  final PointF c;
  final PointF d;
  final PointF e;
  final PointF f;
  final PointF g;
  final PointF h;
  float i;
  float j;
  boolean k;
  float l;
  int m;
  final Path n;
  final Paint o;

  private void a(boolean paramBoolean)
  {
    float f1;
    float f2;
    float f3;
    if (paramBoolean)
    {
      f1 = this.a.x;
      f2 = this.c.x;
      f3 = this.a.x;
      float f4 = this.a.y;
      float f5 = this.c.y;
      float f6 = this.a.y;
      this.b.set(f1 + (f2 - f3) * 0.25F, f4 + (f5 - f6) * 0.5F);
    }
    while (true)
    {
      d();
      return;
      f1 = (this.a.x + this.c.x) / 2.0F;
      f2 = (this.a.y + this.c.y) / 2.0F;
      f3 = f();
      this.b.set(f1, f2 + f3);
    }
  }

  private void e()
  {
    this.b.set((this.a.x + this.c.x) / 2.0F, (this.a.y + this.c.y) / 2.0F + f());
    d();
  }

  private float f()
  {
    float f1 = ari.a(this.a.x, this.a.y, this.c.x, this.c.y);
    if (f1 >= this.i)
      return 0.0F;
    return (this.i - f1) * 1.0F;
  }

  private void g()
  {
    float f1 = this.i / 2.0F;
    float f2 = (float)Math.hypot(this.a.x - this.b.x, this.a.y - this.b.y);
    if (f2 < f1)
      this.f.set(0.0F, 0.0F);
    while (true)
    {
      f2 = (float)Math.hypot(this.b.x - this.c.x, this.b.y - this.c.y);
      if (f2 >= f1)
        break;
      this.g.set(0.0F, 0.0F);
      return;
      float f3 = (f2 - f1) * 1.0F;
      this.f.set((this.a.x - this.b.x) / f2 * f3, (this.a.y - this.b.y) / f2 * f3);
    }
    f1 = (f2 - f1) * 1.0F;
    this.g.set((this.b.x - this.c.x) / f2 * f1, f1 * ((this.b.y - this.c.y) / f2));
  }

  float a()
  {
    return ari.a(this.a.x, this.a.y, this.c.x, this.c.y);
  }

  void a(float paramFloat)
  {
    this.i = (paramFloat - 2.0F * this.j / 1.0F);
    this.c.set(this.a.x, this.a.y + paramFloat);
    e();
  }

  void a(float paramFloat1, float paramFloat2)
  {
    this.a.set(paramFloat1, paramFloat2);
    e();
  }

  void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.h.set(paramFloat1, paramFloat2);
    this.c.set(paramFloat1, paramFloat2);
    a(paramBoolean);
  }

  void a(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.n, this.o);
  }

  void b()
  {
    this.k = false;
    this.g.set(0.0F, 0.0F);
    this.e.set(0.0F, 0.0F);
    this.f.set(0.0F, 0.0F);
    this.d.set(0.0F, 0.0F);
  }

  void b(float paramFloat)
  {
    paramFloat -= this.a.x;
    this.a.offset(paramFloat, 0.0F);
    this.b.offset(paramFloat, 0.0F);
    this.c.offset(paramFloat, 0.0F);
    d();
  }

  void b(float paramFloat1, float paramFloat2)
  {
    this.e.set(paramFloat1 / 72.0F, paramFloat2 / 72.0F);
    this.k = true;
  }

  void c(float paramFloat)
  {
    float f1;
    if (paramFloat >= 0.0F)
    {
      f1 = paramFloat;
      if (paramFloat <= 1.0F);
    }
    else
    {
      f1 = 1.0F;
    }
    this.o.setAlpha((int)(this.m * f1));
    this.o.setStrokeWidth((int)(this.l * f1));
  }

  boolean c()
  {
    if (!this.k);
    do
    {
      return false;
      g();
      this.d.offset(this.f.x, this.f.y);
      this.d.offset(-this.g.x, -this.g.y);
      PointF localPointF = this.d;
      localPointF.x *= 0.9F;
      localPointF = this.d;
      localPointF.y *= 0.9F;
      this.b.offset(this.d.x, this.d.y);
      this.e.offset(0.0F, this.j);
      this.e.offset(this.g.x / 2.0F, this.g.y / 2.0F);
      localPointF = this.e;
      localPointF.x *= 0.9F;
      localPointF = this.e;
      localPointF.y *= 0.9F;
      this.c.offset(this.e.x, this.e.y);
      d();
    }
    while ((this.d.length() <= 1.0F) && (this.e.length() <= 1.0F) && (Math.abs(this.a.x - this.c.x) <= 1.0F) && (Math.abs(this.a.x - this.b.x) <= 1.0F) && (Math.abs(Math.abs(this.c.y - this.a.y) - this.i) <= 4.0F * this.j));
    return true;
  }

  void d()
  {
    this.n.reset();
    this.n.moveTo(this.a.x, this.a.y);
    this.n.quadTo(this.b.x, this.b.y, this.c.x, this.c.y);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adm
 * JD-Core Version:    0.6.2
 */