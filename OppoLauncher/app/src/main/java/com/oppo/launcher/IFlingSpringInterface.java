package com.oppo.launcher;

public abstract interface IFlingSpringInterface
{
  public static final float BASELINE_FLING_VELOCITY = 2500.0F;
  public static final float FLING_VELOCITY_INFLUENCE = 0.4F;
  public static final int INVALID_SCREEN = -1;
  public static final float NANOTIME_DIV = 1.0E+09F;
  public static final float SMOOTHING_CONSTANT = (float)(0.016D / Math.log(0.75D));
  public static final float SMOOTHING_SPEED = 0.75F;
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.IFlingSpringInterface
 * JD-Core Version:    0.6.2
 */