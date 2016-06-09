package com.oppo.launcher.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

public class OppoAccelerateDecelerateInterpolator
  implements Interpolator
{
  private static final boolean DEBUG = false;
  private static final String LOG_TAG = "OppoAccelerateDecelerateInterpolator";

  public OppoAccelerateDecelerateInterpolator()
  {
  }

  public OppoAccelerateDecelerateInterpolator(Context paramContext, AttributeSet paramAttributeSet)
  {
  }

  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.5F)
      return (float)((Math.cos((Math.sin(paramFloat * 3.141592653589793D / 2.0D) + 1.0D) * 3.141592653589793D) + 1.0D) / 2.0D);
    return (float)((Math.cos((Math.sqrt(paramFloat) + 1.0D) * 3.141592653589793D) + 1.0D) / 2.0D);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.animation.OppoAccelerateDecelerateInterpolator
 * JD-Core Version:    0.6.2
 */