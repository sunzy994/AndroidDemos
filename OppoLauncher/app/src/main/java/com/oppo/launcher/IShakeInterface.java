package com.oppo.launcher;

import android.view.View;

public abstract interface IShakeInterface
{
  public abstract void beginOrAdjustHintAnimations();

  public abstract void beginOrAdjustHintAnimations(int paramInt);

  public abstract void completeAndClearReorderHintAnimations(boolean paramBoolean);

  public abstract boolean isShaking();

  public abstract void joinAnimations(View paramView);
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.IShakeInterface
 * JD-Core Version:    0.6.2
 */