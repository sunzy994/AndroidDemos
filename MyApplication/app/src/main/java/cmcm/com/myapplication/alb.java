package cmcm.com.myapplication;

public class alb
{
  public alb a;
  public alb b;
  public alb c;
  public String d;
  public float e;
  public float f;
  public float g;
  public float h;
  float i;
  float j;
  float k;
  float l;
  float m;
  float n;
  float o;
  float p;
  float q;
  boolean r = false;
  boolean s = false;
  boolean t;
  float u;
  public long v;

  public alb a(float paramFloat)
  {
    alb localalb = new alb();
    localalb.b(paramFloat);
    localalb.a = this;
    this.b = localalb;
    return localalb;
  }

  void a()
  {
    if (this.m < this.a.m);
    int i2;
    do
    {
      return;
      while (((this.j - this.a.l) * (this.h - this.a.l) >= 0.0F) && ((this.n - this.a.o) * (this.m - this.a.o) >= 0.0F))
        i1 = 0;
      float f1 = this.n;
      float f2 = this.j;
      this.n = (this.m + (this.n - this.m) * 0.9F);
      this.j = (this.h + (this.j - this.h) * 0.9F);
      if (Math.hypot(f1 - this.n, f2 - this.j) < 1.0D)
      {
        float f3 = this.m;
        this.n = ((f1 - this.m) * 0.5F + f3);
        this.j = (this.h + (f2 - this.h) * 0.5F);
      }
      i2 = i1 + 1;
      int i1 = i2;
    }
    while (i2 != 100);
  }

  public void a(long paramLong)
  {
    this.v = paramLong;
    if ((this.a == null) || (this.b == null))
    {
      this.n = this.m;
      this.j = this.h;
      this.o = this.m;
      this.l = this.h;
    }
    while (true)
    {
      if (this.a != null)
        a();
      if ((this.a != null) && (this.a.r))
        this.a.b();
      this.p = (this.n - this.m);
      this.q = (this.o - this.m);
      return;
      float f1 = Math.min(Math.abs(this.m - this.a.m), Math.abs(this.m - this.b.m));
      float f5 = this.m + f1;
      float f7 = this.m - f1;
      if ((this.h - this.a.h) * (this.h - this.b.h) < 0.0F)
      {
        this.r = true;
        float f9 = (this.a.m + f5) / 2.0F;
        float f6 = (this.a.h + this.b.h) / 2.0F;
        f1 = (this.m + f7) / 2.0F;
        float f2 = (this.h + this.a.h) / 2.0F;
        float f3 = (this.m + f5) / 2.0F;
        float f4 = (this.h + this.b.h) / 2.0F;
        f7 = (f7 + f9) / 2.0F;
        float f8 = (this.a.h + f6) / 2.0F;
        f5 = (f5 + f9) / 2.0F;
        f6 = (this.b.h + f6) / 2.0F;
        this.n = (2.0F * f1 - f7);
        this.j = (2.0F * f2 - f8);
        this.o = (2.0F * f3 - f5);
        this.l = (2.0F * f4 - f6);
      }
      else
      {
        this.n = ((f7 + this.m) / 2.0F);
        this.j = this.h;
        this.o = ((this.m + f5) / 2.0F);
        this.l = this.h;
        this.r = false;
      }
    }
  }

  void b()
  {
    if (this.m > this.b.m);
    int i2;
    do
    {
      return;
      while (((this.l - this.b.j) * (this.h - this.b.j) >= 0.0F) && ((this.o - this.b.n) * (this.m - this.b.n) >= 0.0F))
        i1 = 0;
      float f1 = this.o;
      float f2 = this.l;
      this.o = (this.m + (this.o - this.m) * 0.9F);
      this.l = (this.h + (this.l - this.h) * 0.9F);
      if (Math.hypot(f1 - this.o, f2 - this.l) < 1.0D)
      {
        float f3 = this.m;
        this.o = ((f1 - this.m) * 0.5F + f3);
        this.l = (this.h + (f2 - this.h) * 0.5F);
      }
      i2 = i1 + 1;
      int i1 = i2;
    }
    while (i2 != 100);
  }

  public void b(float paramFloat)
  {
    this.e = paramFloat;
    this.f = paramFloat;
    this.d = (Integer.toString((int)paramFloat) + "°");
  }

  public String toString()
  {
    return "Point{txt='" + this.d + '\'' + ", data=" + this.e + ", x=" + this.g + ", y=" + this.h + ", px=" + this.i + ", py=" + this.j + ", nx=" + this.k + ", ny=" + this.l + ", bx=" + this.m + ", bpx=" + this.n + ", bnx=" + this.o + ", dpx=" + this.p + ", dnx=" + this.q + ", isMid=" + this.r + ", isCurrent=" + this.s + ", isToday=" + this.t + ", ratio=" + this.u + ", updateTime=" + this.v + '}';
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alb
 * JD-Core Version:    0.6.2
 */