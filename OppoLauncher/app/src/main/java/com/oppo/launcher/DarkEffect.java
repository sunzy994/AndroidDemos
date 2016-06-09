package com.oppo.launcher;

public abstract interface DarkEffect
{
  public abstract void clearDarkEffect();

  public abstract void setDarkEffect();

  public abstract void setDarkEffectListener(DarkEffectListener paramDarkEffectListener);

  public static abstract interface DarkEffectListener
  {
    public abstract void onClearDarkEffect();

    public abstract void onSetDarkEffect(DarkEffect paramDarkEffect);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.DarkEffect
 * JD-Core Version:    0.6.2
 */