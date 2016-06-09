package com.oppo.launcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

public class InterruptibleInOutAnimator
{
  private static final int IN = 1;
  private static final int OUT = 2;
  private static final int STOPPED = 0;
  private ValueAnimator mAnimator;
  private int mDirection = 0;
  private boolean mFirstRun = true;
  private long mOriginalDuration;
  private float mOriginalFromValue;
  private float mOriginalToValue;
  private Object mTag = null;

  public InterruptibleInOutAnimator(long paramLong, float paramFloat1, float paramFloat2)
  {
    this.mAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }).setDuration(paramLong);
    this.mOriginalDuration = paramLong;
    this.mOriginalFromValue = paramFloat1;
    this.mOriginalToValue = paramFloat2;
    this.mAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        InterruptibleInOutAnimator.access$002(InterruptibleInOutAnimator.this, 0);
      }
    });
  }

  private void animate(int paramInt)
  {
    long l1 = this.mAnimator.getCurrentPlayTime();
    float f1;
    if (paramInt == 1)
    {
      f1 = this.mOriginalToValue;
      if (!this.mFirstRun)
        break label109;
    }
    label109: for (float f2 = this.mOriginalFromValue; ; f2 = ((Float)this.mAnimator.getAnimatedValue()).floatValue())
    {
      cancel();
      this.mDirection = paramInt;
      long l2 = this.mOriginalDuration;
      this.mAnimator.setDuration(Math.max(0L, Math.min(l2 - l1, this.mOriginalDuration)));
      this.mAnimator.setFloatValues(new float[] { f2, f1 });
      this.mAnimator.start();
      this.mFirstRun = false;
      return;
      f1 = this.mOriginalFromValue;
      break;
    }
  }

  public void animateIn()
  {
    animate(1);
  }

  public void animateOut()
  {
    animate(2);
  }

  public void cancel()
  {
    this.mAnimator.cancel();
    this.mDirection = 0;
  }

  public void end()
  {
    this.mAnimator.end();
    this.mDirection = 0;
  }

  public ValueAnimator getAnimator()
  {
    return this.mAnimator;
  }

  public Object getTag()
  {
    return this.mTag;
  }

  public boolean isStopped()
  {
    return this.mDirection == 0;
  }

  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.InterruptibleInOutAnimator
 * JD-Core Version:    0.6.2
 */