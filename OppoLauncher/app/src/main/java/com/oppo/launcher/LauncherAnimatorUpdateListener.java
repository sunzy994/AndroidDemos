package com.oppo.launcher;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

public abstract class LauncherAnimatorUpdateListener
  implements AnimatorUpdateListener
{
  public abstract void onAnimationUpdate(float paramFloat1, float paramFloat2);

  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    onAnimationUpdate(1.0F - f, f);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.LauncherAnimatorUpdateListener
 * JD-Core Version:    0.6.2
 */