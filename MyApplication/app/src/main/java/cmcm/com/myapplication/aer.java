package cmcm.com.myapplication;

import android.graphics.PointF;
import android.graphics.Rect;

class aer
{
  final PointF a = new PointF();
  final PointF b = new PointF();
  final PointF c = new PointF();
  final PointF d = new PointF();
  float e;
  float f;
  float g = 29.411764F;
  int h = 0;
  boolean i = false;
  aes j;
  aes k;

  private aer(aeo paramaeo)
  {
  }

  public void a()
  {
    this.i = false;
    this.j = null;
    this.k = null;
  }

  public void a(aes paramaes1, aes paramaes2, int paramInt)
  {
    if (this.i)
      return;
    this.i = true;
    aes localaes;
    label48: float f1;
    if (aes.b(paramaes1).x < aes.b(paramaes2).x)
    {
      localaes = paramaes1;
      this.j = localaes;
      if (this.j != paramaes1)
        break label196;
      this.k = paramaes2;
      this.c.set(aes.b(this.j));
      this.d.set(aes.b(this.k));
      this.e = aes.c(this.j);
      this.e %= 360.0F;
      if (this.e <= 180.0F)
        break label201;
      f1 = this.e - 360.0F;
      label122: this.e = f1;
      this.f = aes.c(this.k);
      this.f %= 360.0F;
      if (this.f <= 180.0F)
        break label232;
      f1 = this.f - 360.0F;
    }
    while (true)
    {
      this.f = f1;
      this.g = (paramInt / 17.0F);
      this.h = 0;
      return;
      localaes = paramaes2;
      break;
      label196: paramaes2 = paramaes1;
      break label48;
      label201: if (this.e < -180.0F)
      {
        f1 = this.e + 360.0F;
        break label122;
      }
      f1 = this.e;
      break label122;
      label232: if (this.f < -180.0F)
        f1 = this.f + 360.0F;
      else
        f1 = this.f;
    }
  }

  public void a(Rect paramRect)
  {
    if (aeo.a(this.l))
    {
      this.a.set(paramRect.left + paramRect.width() * 0.2916667F, paramRect.top + paramRect.height() * aeo.b(this.l) / 2.0F);
      this.b.set(paramRect.right - 0.2916667F * paramRect.width(), paramRect.top + paramRect.height() * aeo.b(this.l) / 2.0F);
      return;
    }
    this.a.set(paramRect.left + paramRect.width() * aeo.b(this.l) / 2.0F, paramRect.top + paramRect.height() * 0.2916667F);
    this.b.set(paramRect.left + paramRect.width() * aeo.b(this.l) / 2.0F, paramRect.bottom - 0.2916667F * paramRect.height());
  }

  public boolean b()
  {
    if (!this.i)
      return false;
    float f1;
    int m;
    if (this.g <= 0.0F)
    {
      f1 = 1.0F;
      if (f1 <= 1.0F)
        break label262;
      m = 1;
      label28: float f2 = f1;
      if (f1 >= 1.0F)
        f2 = 1.0F;
      aes.b(this.j).x = (this.c.x + (this.a.x - this.c.x) * f2 * f2);
      aes.b(this.j).y = (this.c.y + (this.a.y - this.c.y) * f2 * f2);
      aes.a(this.j, this.e * (1.0F - f2));
      aes.b(this.k).x = (this.d.x + (this.b.x - this.d.x) * f2 * f2);
      aes.b(this.k).y = (this.d.y + (this.b.y - this.d.y) * f2 * f2);
      aes.a(this.k, (1.0F - f2 * f2) * this.f);
      if (m != 0)
        this.i = false;
      if (m != 0)
        break label267;
    }
    label262: label267: for (boolean bool = true; ; bool = false)
    {
      return bool;
      m = this.h;
      this.h = (m + 1);
      f1 = m / this.g;
      break;
      m = 0;
      break label28;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aer
 * JD-Core Version:    0.6.2
 */