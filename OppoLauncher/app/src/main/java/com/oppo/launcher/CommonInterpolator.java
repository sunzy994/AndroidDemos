package com.oppo.launcher;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.Interpolator;

public class CommonInterpolator
  implements Interpolator
{
  private static final float BROKEX_CONSTANT = 0.2F;
  private static final boolean DBG = false;
  private float a0;
  private float a1;
  private float b0;
  private float b1;
  private float brokex;
  private float brokey;
  private float distance;
  private float duration;
  private float k0;
  private float k1;
  private Paint paint = new Paint();
  private float[] path = new float['Ê'];
  private float velocity;

  private float cubeRoot(float paramFloat)
  {
    float f2 = 1.0F;
    for (float f1 = 1.0F * 1.0F * 1.0F - paramFloat; (f1 >= 0.001F) || (f1 <= -0.001F); f1 = f2 * f2 * f2 - paramFloat)
      f2 -= f1 / (3.0F * f2 * f2);
    return f2;
  }

  private void dumpState()
  {
  }

  private float getDefiniteIntegral(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return getQuadraticIntegral(paramFloat1, paramFloat2, paramFloat3, paramFloat5) - getQuadraticIntegral(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  private float getQuadraticIntegral(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat2 = paramFloat4 - paramFloat2;
    return paramFloat1 * paramFloat2 * paramFloat2 * paramFloat2 / 3.0F + paramFloat3 * paramFloat4;
  }

  public void draw(Bitmap paramBitmap)
  {
    paramBitmap.eraseColor(0);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramBitmap = new Canvas(paramBitmap);
    this.paint.setColor(-65536);
    float f5 = this.duration / i;
    float f6 = this.b0 / j;
    i = 0;
    float f7 = this.duration / 100.0F;
    for (float f1 = 0.0F; f1 < this.duration; f1 += f7)
    {
      float f2 = this.a0;
      float f3 = this.b0;
      float f4 = this.k0;
      if (f1 > this.brokex)
      {
        f2 = this.a1;
        f3 = this.b1;
        f4 = this.k1;
      }
      float[] arrayOfFloat = this.path;
      int k = i + 1;
      arrayOfFloat[i] = (f1 / f5);
      arrayOfFloat = this.path;
      i = k + 1;
      arrayOfFloat[k] = (j - ((f1 - f2) * f4 * (f1 - f2) + f3) / f6);
    }
    paramBitmap.drawPoints(this.path, this.paint);
  }

  public float getDistance()
  {
    return this.distance;
  }

  public float getDuration()
  {
    return this.duration * 1000.0F;
  }

  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < this.brokex / this.duration);
    for (paramFloat = getDefiniteIntegral(this.k0, this.a0, this.b0, 0.0F, paramFloat * this.duration); ; paramFloat = getDefiniteIntegral(this.k0, this.a0, this.b0, 0.0F, this.brokex) + getDefiniteIntegral(this.k1, this.a1, this.b1, this.brokex, paramFloat * this.duration))
      return paramFloat / this.distance;
  }

  public void setBoundDistanceAndTime(float paramFloat, int paramInt)
  {
    this.distance = paramFloat;
    this.duration = (paramInt / 1000.0F);
    this.velocity = 0.0F;
    paramFloat = this.duration * 0.2F;
    float f3 = this.duration;
    this.a0 = paramFloat;
    this.a1 = f3;
    this.b1 = 0.0F;
    float f1 = paramFloat - this.a0;
    f1 = f1 * f1 * f1 / 3.0F;
    float f2 = 0.0F - this.a0;
    f2 = f2 * f2 * f2 / 3.0F;
    f3 -= this.a1;
    f3 = f3 * f3 * f3 / 3.0F;
    float f4 = paramFloat - this.a1;
    f4 = f4 * f4 * f4 / 3.0F;
    float f5 = this.a0;
    float f6 = this.a0;
    float f7 = (paramFloat - this.a1) * (paramFloat - this.a1);
    float f8 = paramFloat * paramFloat - 2.0F * this.a0 * paramFloat;
    this.k1 = (this.distance * f8 / ((f1 - f2 - f5 * f6 * (paramFloat - 0.0F)) * f7 + (f3 - f4) * f8));
    this.k0 = (this.k1 * f7 / f8);
    f1 = paramFloat - this.a1;
    this.brokey = (this.k1 * f1 * f1);
    this.brokex = paramFloat;
    this.b0 = (-this.a0 * this.a0 * this.k0);
  }

  public void setVelocityDistance(float paramFloat1, float paramFloat2)
  {
    this.velocity = paramFloat1;
    this.distance = paramFloat2;
    this.duration = (1.5F * this.distance / this.velocity);
    this.a0 = 0.0F;
    this.b0 = this.velocity;
    this.k0 = (-this.b0 / (this.duration * this.duration));
    this.brokex = this.duration;
    this.brokey = 0.0F;
    this.k1 = 0.0F;
    this.b1 = 0.0F;
    this.a1 = 0.0F;
  }

  public void setVelocityDistanceTime(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.velocity = paramFloat1;
    this.distance = paramFloat2;
    this.duration = (paramFloat3 / 1000.0F);
    paramFloat1 = this.duration * 0.2F;
    paramFloat2 = this.distance * 3.0F / (2.0F * paramFloat1 + this.duration);
    paramFloat3 = 1.5F * this.distance / paramFloat1;
    float f = (paramFloat3 - paramFloat2) / 2.0F;
    if (this.velocity < paramFloat2)
      this.velocity = (this.velocity * f / (paramFloat2 + f) + paramFloat2);
    while (true)
    {
      this.a0 = 0.0F;
      this.b0 = this.velocity;
      this.a1 = this.duration;
      this.b1 = 0.0F;
      paramFloat2 = paramFloat1 - this.a1;
      paramFloat2 *= paramFloat2;
      this.k0 = ((this.distance * 3.0F - this.b0 * 2.0F * paramFloat1 - this.a1 * this.b0) / (this.a1 * paramFloat1 * paramFloat1));
      this.k1 = ((this.k0 * paramFloat1 * paramFloat1 + this.b0) / paramFloat2);
      this.brokex = paramFloat1;
      this.brokey = (this.k1 * paramFloat2);
      return;
      if (this.velocity > paramFloat3)
        this.velocity = (paramFloat3 - f / 2.0F);
    }
  }

  public void setVelocityTime(float paramFloat, int paramInt)
  {
    this.velocity = paramFloat;
    this.duration = (paramInt / 1000.0F);
    this.brokex = (this.duration * 0.2F);
    this.brokey = (this.velocity * 0.8F);
    this.a0 = 0.0F;
    this.b0 = this.velocity;
    this.k0 = ((this.brokey - this.b0) / ((this.brokex - this.a0) * (this.brokex - this.a0)));
    this.a1 = this.duration;
    this.b1 = 0.0F;
    this.k1 = ((this.brokey - this.b1) / ((this.brokex - this.a1) * (this.brokex - this.a1)));
    paramFloat = getDefiniteIntegral(this.k0, this.a0, this.b0, 0.0F, this.brokex);
    this.distance = (getDefiniteIntegral(this.k1, this.a1, this.b1, this.brokex, this.duration) + paramFloat);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.CommonInterpolator
 * JD-Core Version:    0.6.2
 */