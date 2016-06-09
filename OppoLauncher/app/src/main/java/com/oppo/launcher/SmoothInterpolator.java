package com.oppo.launcher;

import android.view.animation.Interpolator;

public class SmoothInterpolator
  implements Interpolator
{
  public static final int DEFAULT_CURVE_DURATION_MAX_TIME = 1000;
  public static final int DEFAULT_CURVE_DURATION_MIN_TIME = 550;
  public static final int DEFAULT_CURVE_DURATION_TIME = 700;
  public static final float DEFAULT_CURVE_DURATION_TIME_FACTOR = 1.65F;
  private static final float DEFAULT_CURVE_INTERSECT_AXIS_X = 1.0F;
  private static final float DEFAULT_CURVE_SPEED = 7.0F;
  private static final float DEFAULT_CURVE_START = 0.1F;
  private float mCurveCompensation = (float)Math.exp(-1.0D);
  private float mViscousFluidNormalize_extr = 1.0F;

  public static float getDurationTimeFactor()
  {
    return 1.65F;
  }

  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }

  public float getInterpolation2(float paramFloat)
  {
    return (-(float)Math.exp(-(1.0F + paramFloat * 7.0F)) + this.mCurveCompensation) * 0.9F * this.mViscousFluidNormalize_extr;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.SmoothInterpolator
 * JD-Core Version:    0.6.2
 */