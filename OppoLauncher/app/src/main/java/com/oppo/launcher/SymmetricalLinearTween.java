package com.oppo.launcher;

import android.os.Handler;
import android.os.SystemClock;

class SymmetricalLinearTween
{
  private static final int FPS = 30;
  private static final int FRAME_TIME = 33;
  long mBase;
  TweenCallback mCallback;
  boolean mDirection;
  int mDuration;
  Handler mHandler;
  boolean mRunning;
  Runnable mTick = new Runnable()
  {
    public void run()
    {
      long l1 = SymmetricalLinearTween.this.mBase;
      long l2 = SystemClock.uptimeMillis() - l1;
      int i = SymmetricalLinearTween.this.mDuration;
      float f2 = (float)l2 / i;
      float f1 = f2;
      if (!SymmetricalLinearTween.this.mDirection)
        f1 = 1.0F - f2;
      if (f1 > 1.0F)
        f2 = 1.0F;
      while (true)
      {
        f1 = SymmetricalLinearTween.this.mValue;
        SymmetricalLinearTween.this.mValue = f2;
        SymmetricalLinearTween.this.mCallback.onTweenValueChanged(f2, f1);
        long l3 = ((int)(l2 / 33L) + 1) * 33;
        if (l2 < i)
          SymmetricalLinearTween.this.mHandler.postAtTime(this, l1 + l3);
        if (l2 >= i)
        {
          SymmetricalLinearTween.this.mCallback.onTweenFinished();
          SymmetricalLinearTween.this.mRunning = false;
        }
        return;
        f2 = f1;
        if (f1 < 0.0F)
          f2 = 0.0F;
      }
    }
  };
  float mValue;

  public SymmetricalLinearTween(boolean paramBoolean, int paramInt, TweenCallback paramTweenCallback)
  {
    if (paramBoolean);
    for (float f = 1.0F; ; f = 0.0F)
    {
      this.mValue = f;
      this.mDirection = paramBoolean;
      this.mDuration = paramInt;
      this.mCallback = paramTweenCallback;
      this.mHandler = new Handler();
      return;
    }
  }

  public void start(boolean paramBoolean)
  {
    start(paramBoolean, SystemClock.uptimeMillis());
  }

  public void start(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean != this.mDirection)
    {
      if (this.mRunning)
        break label61;
      this.mBase = paramLong;
      this.mRunning = true;
      this.mCallback.onTweenStarted();
      paramLong = SystemClock.uptimeMillis();
      this.mHandler.postAtTime(this.mTick, paramLong + 33L);
    }
    while (true)
    {
      this.mDirection = paramBoolean;
      return;
      label61: paramLong = SystemClock.uptimeMillis();
      this.mBase = (paramLong + (paramLong - this.mBase) - this.mDuration);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.SymmetricalLinearTween
 * JD-Core Version:    0.6.2
 */