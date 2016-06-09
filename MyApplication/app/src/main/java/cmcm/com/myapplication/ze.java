package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import java.util.Random;

class ze
{
  final Paint a = new Paint(1);
  final PointF b = new PointF();
  final PointF c = new PointF();
  final PointF d = new PointF();
  float e;
  int f = 0;
  int g = 10;
  boolean h = false;
  boolean i = true;

  ze(zc paramzc)
  {
  }

  void a()
  {
    Object localObject;
    if (zc.c(this.j))
      if (zc.d(this.j) > 0)
      {
        zc.e(this.j);
        this.j.b[0] = (this.j.a.nextInt(10) * 3 + 175.0F);
        this.j.b[1] = 1.0F;
        this.j.b[2] = 1.0F;
        localObject = this.a;
        if (this.f % 3 != 0)
          break label251;
      }
    label251: for (int k = 255; ; k = 128)
    {
      ((Paint)localObject).setColor(Color.HSVToColor(k, this.j.b));
      return;
      this.j.b[0] = (this.j.a.nextInt(10) * 12.0F - 60.0F);
      if (this.j.b[0] >= 0.0F)
        break;
      localObject = this.j.b;
      localObject[0] += 360.0F;
      break;
      if (zc.d(this.j) > 0)
      {
        zc.e(this.j);
        this.j.b[0] = (this.j.a.nextInt(10) * 2.5F + 280.0F);
        break;
      }
      this.j.b[0] = (this.j.a.nextInt(10) * 12.0F + 120.0F);
      break;
    }
  }

  void a(float paramFloat1, float paramFloat2)
  {
    float f2 = paramFloat2 - zc.b(this.j);
    paramFloat2 = (float)Math.hypot(paramFloat1, f2);
    float f1 = (this.d.x * f2 + this.d.y * -paramFloat1) / paramFloat2;
    f2 = f2 * (2.0F * f1) / paramFloat2;
    paramFloat1 = f1 * 2.0F * -paramFloat1 / paramFloat2;
    this.d.x = (f2 - this.d.x);
    this.d.y = (paramFloat1 - this.d.y);
  }

  void a(int paramInt)
  {
    this.f = paramInt;
    if (!this.h)
    {
      int k = zc.a(this.j).getResources().getDimensionPixelSize(2131296335);
      f2 = k / 2.0F;
      if (paramInt > 8)
      {
        f1 = 3.5F;
        f2 = 2.5F * (f2 * 1.5F) / f1;
        f3 = k / 2.0F;
        if (paramInt <= 8)
          break label262;
        f1 = 8.0F;
        label70: f1 = 2.5F * (f3 * 1.5F) / f1;
        this.e = (f1 + this.j.a.nextFloat() * (f2 - f1));
      }
    }
    else
    {
      if (paramInt >= 3)
        break label268;
      this.g = 20;
      f1 = zc.b(this.j) - this.j.a.nextFloat() * this.e * 0.8F;
      f2 = (float)Math.toRadians(30.0D * Math.pow(-1.0D, paramInt) * Math.ceil(paramInt / 2.0F));
      this.c.set((float)(f1 * Math.sin(f2)), (float)(zc.b(this.j) - f1 * Math.cos(f2)));
    }
    while (true)
    {
      if (!this.h)
      {
        this.b.x = this.c.x;
        this.b.y = (-this.e);
        a();
        this.d.set(0.0F, 0.0F);
      }
      this.h = true;
      this.i = true;
      return;
      f1 = 2.5F;
      break;
      label262: f1 = 4.5F;
      break label70;
      label268: if (paramInt < 8)
      {
        this.g = 13;
        f2 = zc.b(this.j) - zc.b(this.j) / 2.0F - (this.j.a.nextFloat() - 0.5F) * this.e * 0.5F;
        f3 = (float)Math.ceil((paramInt - 3.0F) / 2.0F);
        if (f3 > 0.0F);
        for (f1 = (f3 - 1.0F) * 5.0F; ; f1 = 0.0F)
        {
          f1 = (float)Math.toRadians((30.0F * f3 - f1) * Math.pow(-1.0D, paramInt - 3));
          this.c.set((float)(f2 * Math.sin(f1) / Math.cos(f1)), zc.b(this.j) - f2);
          break;
        }
      }
      if (paramInt >= 14)
        break label541;
      this.g = 6;
      f1 = zc.b(this.j) - zc.b(this.j) / 1.4F - (this.j.a.nextFloat() - 0.25F) * this.e * 0.6F;
      f2 = (float)Math.ceil((paramInt - 7.0F) / 2.0F);
      f2 = (float)Math.toRadians((32.0F * f2 - (f2 - 1.0F) * 15.0F) * Math.pow(-1.0D, paramInt - 7));
      this.c.set((float)(f1 * Math.sin(f2) / Math.cos(f2)), zc.b(this.j) - f1);
    }
    label541: this.g = 0;
    float f2 = zc.b(this.j) - zc.b(this.j) / 1.1F;
    float f3 = (float)Math.ceil((paramInt - 14) / 2.0F);
    if (f3 > 0.0F);
    for (float f1 = (f3 - 1.0F) * 67.0F; ; f1 = 0.0F)
    {
      f1 = (float)Math.toRadians((75.0F * f3 - f1) * Math.pow(-1.0D, paramInt - 14));
      this.c.set((float)(f2 * Math.sin(f1) / Math.cos(f1) + (this.j.a.nextFloat() - 0.5F) * this.e), zc.b(this.j) - f2 + (this.j.a.nextFloat() - 0.1F) * this.e * 0.5F);
      break;
    }
  }

  void a(boolean paramBoolean)
  {
    if (!this.h)
      return;
    float f1 = this.b.x;
    float f4 = this.d.x + f1;
    float f3 = this.b.y + this.d.y;
    float f5 = (float)Math.hypot(f4, f3 - zc.b(this.j));
    float f6 = zc.b(this.j);
    float f2 = f3;
    f1 = f4;
    if (f5 > f6)
    {
      if (paramBoolean)
        break label141;
      f1 = f4 * f6 / f5;
      f2 = (f3 - zc.b(this.j)) * f6 / f5 + zc.b(this.j);
      a(f1, f2);
    }
    while (true)
    {
      this.b.set(f1, f2);
      return;
      label141: this.h = false;
      this.d.set(0.0F, 0.0F);
      f2 = f3;
      f1 = f4;
    }
  }

  boolean a(Canvas paramCanvas)
  {
    boolean bool2 = true;
    if (!this.h)
      return false;
    boolean bool1;
    if (!zc.f(this.j))
      if (!b())
      {
        a(true);
        bool1 = bool2;
      }
    while (true)
    {
      paramCanvas.drawCircle(this.b.x + zc.g(this.j).x, zc.g(this.j).y - zc.b(this.j) + this.b.y, this.e, this.a);
      return bool1;
      if (this.i)
      {
        int k = this.g;
        this.g = (k - 1);
        bool1 = bool2;
        if (k <= 0)
          if ((float)Math.hypot(this.b.x - this.c.x, this.b.y - this.c.y) > this.e / 16.0F)
          {
            PointF localPointF = this.b;
            localPointF.x += (this.c.x - this.b.x) / 8.0F;
            localPointF = this.b;
            localPointF.y += (this.c.y - this.b.y) / 8.0F;
            bool1 = bool2;
          }
          else
          {
            this.i = false;
          }
      }
      else
      {
        bool1 = false;
      }
    }
  }

  void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (float f1 = (float)(6.283185307179586D * this.j.a.nextFloat()); ; f1 = (float)(3.141592653589793D * (this.j.a.nextFloat() * 0.25F + 0.375F)))
    {
      float f2 = (this.j.a.nextFloat() * 0.5F + 0.5F) * this.j.c;
      PointF localPointF = this.d;
      float f3 = (float)(Math.cos(f1) * f2);
      double d1 = Math.sin(f1);
      localPointF.set(f3, (float)(f2 * d1));
      return;
    }
  }

  boolean b()
  {
    return this.d.x * this.d.y == 0.0F;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ze
 * JD-Core Version:    0.6.2
 */