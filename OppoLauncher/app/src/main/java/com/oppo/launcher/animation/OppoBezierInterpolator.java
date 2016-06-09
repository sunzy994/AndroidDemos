package com.oppo.launcher.animation;

import android.view.animation.Interpolator;

public class OppoBezierInterpolator
  implements Interpolator
{
  private final float ABOVE_ONE = 1.0F;
  private final float BELOW_ONE = 0.99F;
  private final boolean DEBUG = false;
  private final double EPSILON = 6.25E-05D;
  private final String TAG = "OppoBezierInterpolator";
  private boolean mAbove = false;
  private boolean mLimit = false;
  private OppoUnitBezier mOppoUnitBezier;

  public OppoBezierInterpolator(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, boolean paramBoolean)
  {
    this.mLimit = paramBoolean;
    this.mOppoUnitBezier = new OppoUnitBezier(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }

  public float getInterpolation(float paramFloat)
  {
    double d2 = this.mOppoUnitBezier.solve(paramFloat, 6.25E-05D);
    double d3 = d2;
    if (this.mLimit)
    {
      double d1 = d2;
      if (d2 > 1.0D)
      {
        d1 = d2;
        if (!this.mAbove)
        {
          d1 = 1.0D;
          this.mAbove = true;
        }
      }
      if (this.mAbove)
        d1 = 1.0D;
      d3 = d1;
      if (paramFloat > 0.99F)
      {
        this.mAbove = false;
        d3 = d1;
      }
    }
    return (float)d3;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.animation.OppoBezierInterpolator
 * JD-Core Version:    0.6.2
 */