package cmcm.com.myapplication;

import android.graphics.PointF;

class aes
{
  private final int a;
  private final PointF b = new PointF();
  private final PointF c = new PointF();
  private float d;
  private float e;
  private float f;

  public aes(int paramInt)
  {
    if (paramInt < 3)
      throw new IllegalArgumentException("Polygon edges should not be less than 3");
    this.a = paramInt;
  }

  private void a(float paramFloat, boolean paramBoolean)
  {
    if ((paramFloat <= 1.0F) || ((paramBoolean) && (this.c.length() > 15.0F)))
      return;
    PointF localPointF = this.c;
    localPointF.x *= paramFloat;
    localPointF = this.c;
    localPointF.y *= paramFloat;
  }

  static boolean a(aes paramaes1, aes paramaes2)
  {
    if (Math.hypot(paramaes1.b.x - paramaes2.b.x, paramaes1.b.y - paramaes2.b.y) < paramaes1.d + paramaes2.d);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        f1 = paramaes2.b.x - paramaes1.b.x;
        f2 = paramaes2.b.y - paramaes1.b.y;
        f3 = (float)Math.hypot(f1, f2);
        f1 /= f3;
        f2 /= f3;
        f3 = paramaes1.c.x * f1 + paramaes1.c.y * f2;
        f4 = paramaes2.c.x * f1 + paramaes2.c.y * f2;
        if (f3 > f4)
          break;
      }
      return false;
    }
    float f1 = (f3 - f4) * 1.7F * f1;
    float f2 = (f3 - f4) * 1.7F * f2;
    float f3 = paramaes1.c.x;
    float f4 = paramaes1.c.y;
    float f5 = paramaes2.c.x;
    float f6 = paramaes2.c.y;
    paramaes1.c.set(f3 - f1, f4 - f2);
    paramaes2.c.set(f1 + f5, f2 + f6);
    return true;
  }

  public aes a(float paramFloat)
  {
    this.d = paramFloat;
    return this;
  }

  public aes a(float paramFloat1, float paramFloat2)
  {
    this.b.set(paramFloat1, paramFloat2);
    return this;
  }

  public boolean a()
  {
    this.e += this.f;
    this.b.offset(this.c.x, this.c.y);
    if (this.c.length() > 15.0F)
    {
      PointF localPointF = this.c;
      localPointF.x *= 0.95F;
      localPointF = this.c;
      localPointF.y *= 0.95F;
    }
    return (Math.abs(this.f) > 1.0F) || (Math.hypot(this.c.x, this.c.y) > 1.0D);
  }

  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i;
    int j;
    label64: int k;
    if ((this.b.x - paramFloat1 < this.d) && (this.c.x < 0.0F))
    {
      i = 1;
      if ((this.b.y - paramFloat2 >= this.d) || (this.c.y >= 0.0F))
        break label178;
      j = 1;
      if ((paramFloat3 - this.b.x >= this.d) || (this.c.x <= 0.0F))
        break label184;
      k = 1;
      label96: if ((paramFloat4 - this.b.y >= this.d) || (this.c.y <= 0.0F))
        break label190;
    }
    label178: label184: label190: for (int m = 1; ; m = 0)
    {
      if (((i == 0) || (j == 0)) && ((k == 0) || (m == 0)))
        break label196;
      aeo.a(this.c, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      a(1.3F, true);
      return true;
      i = 0;
      break;
      j = 0;
      break label64;
      k = 0;
      break label96;
    }
    label196: if (((i != 0) && (m != 0)) || ((k != 0) && (j != 0)))
    {
      aeo.a(this.c, paramFloat3 - paramFloat1, paramFloat2 - paramFloat4);
      a(1.3F, true);
      return true;
    }
    if ((i != 0) || (k != 0))
    {
      aeo.a(this.c, 1.0F, 0.0F);
      a(1.3F, true);
      return true;
    }
    if ((j != 0) || (m != 0))
    {
      aeo.a(this.c, 0.0F, 1.0F);
      a(1.3F, true);
      return true;
    }
    return false;
  }

  public aes b(float paramFloat)
  {
    this.f = paramFloat;
    return this;
  }

  public aes b(float paramFloat1, float paramFloat2)
  {
    this.c.set(paramFloat1, paramFloat2);
    return this;
  }

  public boolean b()
  {
    if (Math.abs(this.f) <= 1.0F)
      return false;
    float f1;
    if (this.f > 0.0F)
    {
      f1 = this.f - 1.0F;
      this.f = f1;
      this.e += this.f;
      this.b.offset(this.c.x, this.c.y);
      PointF localPointF = this.c;
      localPointF.x *= 0.5F;
      localPointF = this.c;
      localPointF.y *= 0.5F;
      if (Math.abs(this.f) <= 1.0F)
        break label127;
    }
    label127: for (boolean bool = true; ; bool = false)
    {
      return bool;
      f1 = this.f + 1.0F;
      break;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aes
 * JD-Core Version:    0.6.2
 */