package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;

public class adl
{
  private static final Camera i = new Camera();
  private static final Matrix j = new Matrix();
  PointF a;
  PointF b;
  final PointF c;
  final Paint d;
  float e;
  float f;
  Bitmap g;
  Bitmap h;

  float a()
  {
    return this.f;
  }

  void a(float paramFloat)
  {
    this.f = paramFloat;
  }

  void a(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    this.c.set(paramFloat1, paramFloat2);
    if (paramPointF != null)
    {
      f2 = this.b.x - paramFloat1;
      paramFloat1 = this.b.y - paramFloat2;
      paramFloat2 = (float)Math.hypot(f2, paramFloat1);
      if (paramFloat2 == 0.0F)
        paramPointF.set(this.c.x, this.c.y + this.e);
    }
    else
    {
      return;
    }
    float f1 = this.c.x;
    float f2 = f2 * this.e / paramFloat2;
    float f3 = this.c.y;
    paramPointF.set(f2 + f1, paramFloat1 * this.e / paramFloat2 + f3);
  }

  void a(Canvas paramCanvas)
  {
    float f1 = this.a.x;
    float f2 = this.a.y - 40.0F;
    float f3 = (float)Math.toDegrees(Math.atan2(this.b.x - this.c.x, this.b.y - this.c.y));
    paramCanvas.save();
    paramCanvas.rotate(180.0F - f3, f1, f2);
    if (this.f != 0.0F)
    {
      j.reset();
      i.save();
      i.rotateY(this.f);
      i.getMatrix(j);
      i.restore();
      j.preTranslate(-f1, -f2);
      j.postTranslate(f1, f2);
      paramCanvas.concat(j);
    }
    if (this.h != null)
      if ((this.f > 90.0F) && (this.f <= 270.0F))
        paramCanvas.drawBitmap(this.h, f1 - this.h.getWidth() / 2.0F, f2, this.d);
    while (true)
    {
      paramCanvas.restore();
      return;
      if (!this.g.isRecycled())
      {
        paramCanvas.drawBitmap(this.g, f1 - this.g.getWidth() / 2.0F, f2, this.d);
        continue;
        if (!this.g.isRecycled())
          paramCanvas.drawBitmap(this.g, f1 - this.g.getWidth() / 2.0F, f2, this.d);
      }
    }
  }

  boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.e <= 0.0F);
    while (Math.hypot(paramFloat1 - this.c.x, paramFloat2 - this.c.y) >= this.e * 1.4F * Math.max(1.0F, 1.0F))
      return false;
    return true;
  }

  void b()
  {
    float f4 = this.a.x - this.b.x;
    float f1 = this.a.y - this.b.y;
    float f2 = (float)Math.hypot(f4, f1);
    if (f2 == 0.0F)
    {
      this.c.set(this.a.x, this.a.y);
      return;
    }
    PointF localPointF = this.c;
    float f3 = this.a.x;
    f4 = f4 * this.e / f2;
    float f5 = this.a.y;
    localPointF.set(f4 + f3, f1 * this.e / f2 + f5);
  }

  PointF c()
  {
    return this.a;
  }

  void d()
  {
    atw.a(this.g);
    atw.a(this.h);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adl
 * JD-Core Version:    0.6.2
 */