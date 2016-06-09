package cmcm.com.myapplication;

import android.graphics.PointF;

public class bag
{
  protected int a = 0;
  private PointF b = new PointF();
  private PointF c = new PointF();
  private float d;
  private float e;
  private int f = 0;
  private int g = 0;
  private int h;
  private int i = 0;
  private float j = 1.2F;
  private float k = 1.7F;
  private boolean l = false;
  private int m = -1;
  private int n = 0;

  public void a(float paramFloat)
  {
    this.k = paramFloat;
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.l = true;
    this.i = this.f;
    this.b.set(paramFloat1, paramFloat2);
    this.c.set(paramFloat1, paramFloat2);
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    c(paramFloat3, paramFloat4 / this.k);
  }

  public void a(int paramInt)
  {
    this.j = (this.h * 1.0F / paramInt);
    this.a = paramInt;
  }

  protected void a(int paramInt1, int paramInt2)
  {
  }

  public void a(bag parambag)
  {
    this.f = parambag.f;
    this.g = parambag.g;
    this.h = parambag.h;
  }

  public boolean a()
  {
    return this.l;
  }

  public float b()
  {
    return this.k;
  }

  public void b(float paramFloat)
  {
    this.j = paramFloat;
    this.a = ((int)(this.h * paramFloat));
  }

  public final void b(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, paramFloat1 - this.b.x, paramFloat2 - this.b.y);
    this.b.set(paramFloat1, paramFloat2);
  }

  public final void b(int paramInt)
  {
    this.g = this.f;
    this.f = paramInt;
    a(paramInt, this.g);
  }

  public void c()
  {
    this.l = false;
  }

  protected void c(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
  }

  public void c(int paramInt)
  {
    this.h = paramInt;
    n();
  }

  public void d()
  {
    this.n = this.f;
  }

  public void d(int paramInt)
  {
    this.m = paramInt;
  }

  public boolean e()
  {
    return this.f >= this.n;
  }

  public boolean e(int paramInt)
  {
    return this.f == paramInt;
  }

  public float f()
  {
    return this.j;
  }

  public boolean f(int paramInt)
  {
    return paramInt < 0;
  }

  public int g()
  {
    return this.a;
  }

  public float h()
  {
    return this.d;
  }

  public float i()
  {
    return this.e;
  }

  public int j()
  {
    return this.g;
  }

  public int k()
  {
    return this.f;
  }

  public float l()
  {
    return this.b.x - this.c.x;
  }

  public float m()
  {
    return this.b.y - this.c.y;
  }

  protected void n()
  {
    this.a = ((int)(this.j * this.h));
  }

  public boolean o()
  {
    return this.f > 0;
  }

  public boolean p()
  {
    return (this.g == 0) && (o());
  }

  public boolean q()
  {
    return (this.g != 0) && (t());
  }

  public boolean r()
  {
    return this.f >= g();
  }

  public boolean s()
  {
    return this.f != this.i;
  }

  public boolean t()
  {
    return this.f == 0;
  }

  public boolean u()
  {
    return (this.g < g()) && (this.f >= g());
  }

  public boolean v()
  {
    return (this.g < this.h) && (this.f >= this.h);
  }

  public boolean w()
  {
    return this.f > x();
  }

  public int x()
  {
    if (this.m >= 0)
      return this.m;
    return this.h;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bag
 * JD-Core Version:    0.6.2
 */