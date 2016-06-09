package cmcm.com.myapplication;

import android.animation.TimeInterpolator;

public class aod
  implements TimeInterpolator
{
  final float a = 0.96F;
  final float b = 0.975F;
  final float c = -0.18F;
  float d = 0.0F;
  float e = 0.0F;
  float f = 0.0F;
  float g = 0.0F;
  float h = 0.0F;
  boolean i;

  private aod()
  {
    try
    {
      this.d = 1.085069F;
      double d1 = -0.02902508F;
      double d2 = -0.04000002F;
      double d3 = -0.0421235F;
      double d4 = -0.02902508F;
      this.e = ((float)((1.180000066757202D + d1 * 0.5D - d2 * 0.5D) / (-0.04000002F * 0.5D + (d3 - d4 * 1.5D))));
      this.f = ((float)(-0.5D - this.e * 1.5D));
      this.g = ((float)(this.e * 0.5D + 0.5D));
      this.h = (1.0F - this.e * 0.96F * 0.96F * 0.96F - this.f * 0.96F * 0.96F - this.g * 0.96F);
      this.i = true;
      return;
    }
    catch (Exception localException)
    {
      this.i = false;
    }
  }

  public float getInterpolation(float paramFloat)
  {
    if (!this.i)
      return (float)(1.0D - 4.0D * (paramFloat - 0.5D) * (paramFloat - 0.5D));
    if (paramFloat < 0.96F)
      return 1.0F - (paramFloat - 0.96F) * (paramFloat - 0.96F) * this.d;
    float f1 = paramFloat * paramFloat;
    float f2 = this.e;
    return f1 * this.f + f1 * paramFloat * f2 + this.g * paramFloat + this.h;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aod
 * JD-Core Version:    0.6.2
 */