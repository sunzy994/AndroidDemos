package com.oppo.launcher;

abstract interface TweenCallback
{
  public abstract void onTweenFinished();

  public abstract void onTweenStarted();

  public abstract void onTweenValueChanged(float paramFloat1, float paramFloat2);
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.TweenCallback
 * JD-Core Version:    0.6.2
 */