package com.oppo.launcher;

import android.view.animation.Interpolator;

public class ElasticInterpolator
  implements Interpolator
{
  private static final float DEFAULT_TENSION = 1.3F;
  private float mTension;

  public ElasticInterpolator()
  {
    this.mTension = 1.3F;
  }

  public ElasticInterpolator(float paramFloat)
  {
    this.mTension = paramFloat;
  }

  public void disableSettle()
  {
    this.mTension = 0.0F;
  }

  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * ((this.mTension + 1.0F) * paramFloat + this.mTension) + 1.0F;
  }

  public void setDistance(int paramInt)
  {
    float f = 1.3F;
    if (paramInt > 0)
      f = 1.3F / paramInt;
    this.mTension = f;
  }

  public void setTension(float paramFloat)
  {
    this.mTension = paramFloat;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ElasticInterpolator
 * JD-Core Version:    0.6.2
 */