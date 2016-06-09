package com.oppo.launcher;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class ElasticScroller
{
  private static final int DEFAULT_DURATION = 250;
  private static final int FLING_MODE = 1;
  private static final int SCROLL_MODE = 0;
  private float mCoeffX = 0.0F;
  private float mCoeffY = 1.0F;
  private float mCurrFloatX;
  private float mCurrFloatY;
  private int mCurrX;
  private int mCurrY;
  private final float mDeceleration;
  private float mDeltaX;
  private float mDeltaY;
  private int mDuration;
  private float mDurationReciprocal;
  private float mFinalFloatX;
  private float mFinalFloatY;
  private int mFinalX;
  private int mFinalY;
  private boolean mFinished = true;
  private Interpolator mInterpolator;
  private int mMaxX;
  private int mMaxY;
  private int mMinX;
  private int mMinY;
  private int mMode;
  private float mStartFloatX;
  private float mStartFloatY;
  private long mStartTime;
  private int mStartX;
  private int mStartY;
  private float mVelocity;
  private float mViscousFluidNormalize;
  private float mViscousFluidScale;

  public ElasticScroller(Context paramContext)
  {
    this(paramContext, null);
  }

  public ElasticScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
    this.mDeceleration = (386.0878F * (paramContext.getResources().getDisplayMetrics().density * 160.0F) * ViewConfiguration.getScrollFriction());
  }

  public void abortAnimation()
  {
    this.mCurrX = this.mFinalX;
    this.mCurrY = this.mFinalY;
    this.mFinished = true;
  }

  public boolean checkFinished()
  {
    if ((!this.mFinished) && ((int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) >= this.mDuration * 5))
      abortAnimation();
    return this.mFinished;
  }

  public boolean computeScrollOffset()
  {
    if (this.mFinished)
      return false;
    int i = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    if (i < this.mDuration)
    {
      switch (this.mMode)
      {
      default:
        return true;
      case 0:
        f = i * this.mDurationReciprocal;
        if (this.mInterpolator == null);
        for (f = viscousFluid(f); ; f = this.mInterpolator.getInterpolation(f))
        {
          this.mCurrX = (this.mStartX + Math.round(this.mDeltaX * f));
          this.mCurrY = (this.mStartY + Math.round(this.mDeltaY * f));
          return true;
        }
      case 1:
      }
      float f = i / 1000.0F;
      f = this.mVelocity * f - this.mDeceleration * f * f / 2.0F;
      this.mCurrX = (this.mStartX + Math.round(this.mCoeffX * f));
      this.mCurrX = Math.min(this.mCurrX, this.mMaxX);
      this.mCurrX = Math.max(this.mCurrX, this.mMinX);
      this.mCurrY = (this.mStartY + Math.round(this.mCoeffY * f));
      this.mCurrY = Math.min(this.mCurrY, this.mMaxY);
      this.mCurrY = Math.max(this.mCurrY, this.mMinY);
      return true;
    }
    this.mCurrX = this.mFinalX;
    this.mCurrY = this.mFinalY;
    this.mFinished = true;
    return true;
  }

  public boolean computeScrollOffsetForFloat()
  {
    if (this.mFinished)
      return false;
    int i = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    if (i < this.mDuration)
    {
      switch (this.mMode)
      {
      default:
        return true;
      case 0:
      }
      float f = i * this.mDurationReciprocal;
      if (this.mInterpolator == null);
      for (f = viscousFluid(f); ; f = this.mInterpolator.getInterpolation(f))
      {
        this.mCurrFloatX = (this.mStartFloatX + this.mDeltaX * f);
        this.mCurrFloatY = (this.mStartFloatY + this.mDeltaY * f);
        return true;
      }
    }
    this.mCurrFloatX = this.mFinalFloatX;
    this.mCurrFloatY = this.mFinalFloatY;
    this.mFinished = true;
    return true;
  }

  public void extendDuration(int paramInt)
  {
    this.mDuration = (timePassed() + paramInt);
    this.mDurationReciprocal = (1.0F / this.mDuration);
    this.mFinished = false;
  }

  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.mMode = 1;
    this.mFinished = false;
    float f2 = (float)Math.hypot(paramInt3, paramInt4);
    this.mVelocity = f2;
    this.mDuration = ((int)(1000.0F * f2 / this.mDeceleration));
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    if (f2 == 0.0F)
    {
      f1 = 1.0F;
      this.mCoeffX = f1;
      if (f2 != 0.0F)
        break label232;
    }
    label232: for (float f1 = 1.0F; ; f1 = paramInt4 / f2)
    {
      this.mCoeffY = f1;
      paramInt3 = (int)(f2 * f2 / (2.0F * this.mDeceleration));
      this.mMinX = paramInt5;
      this.mMaxX = paramInt6;
      this.mMinY = paramInt7;
      this.mMaxY = paramInt8;
      this.mFinalX = (Math.round(paramInt3 * this.mCoeffX) + paramInt1);
      this.mFinalX = Math.min(this.mFinalX, this.mMaxX);
      this.mFinalX = Math.max(this.mFinalX, this.mMinX);
      this.mFinalY = (Math.round(paramInt3 * this.mCoeffY) + paramInt2);
      this.mFinalY = Math.min(this.mFinalY, this.mMaxY);
      this.mFinalY = Math.max(this.mFinalY, this.mMinY);
      return;
      f1 = paramInt3 / f2;
      break;
    }
  }

  public final void forceFinished(boolean paramBoolean)
  {
    this.mFinished = paramBoolean;
  }

  public final float getCurrFloatX()
  {
    return this.mCurrFloatX;
  }

  public final float getCurrFloatY()
  {
    return this.mCurrFloatY;
  }

  public float getCurrVelocity()
  {
    return this.mVelocity - this.mDeceleration * timePassed() / 2000.0F;
  }

  public final int getCurrX()
  {
    return this.mCurrX;
  }

  public final int getCurrY()
  {
    return this.mCurrY;
  }

  public float getDeceleration()
  {
    return this.mDeceleration;
  }

  public final int getDuration()
  {
    return this.mDuration;
  }

  public final int getFinalX()
  {
    return this.mFinalX;
  }

  public final int getFinalY()
  {
    return this.mFinalY;
  }

  public final int getStartX()
  {
    return this.mStartX;
  }

  public final int getStartY()
  {
    return this.mStartY;
  }

  public final boolean isFinished()
  {
    return this.mFinished;
  }

  public void setFinalX(int paramInt)
  {
    this.mFinalX = paramInt;
    this.mDeltaX = (this.mFinalX - this.mStartX);
    this.mFinished = false;
  }

  public void setFinalY(int paramInt)
  {
    this.mFinalY = paramInt;
    this.mDeltaY = (this.mFinalY - this.mStartY);
    this.mFinished = false;
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }

  public void startScroll(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    startScroll(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 250);
  }

  public void startScroll(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    this.mMode = 0;
    this.mFinished = false;
    this.mDuration = paramInt;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartFloatX = paramFloat1;
    this.mStartFloatY = paramFloat2;
    this.mFinalFloatX = (paramFloat1 + paramFloat3);
    this.mFinalFloatY = (paramFloat2 + paramFloat4);
    this.mDeltaX = paramFloat3;
    this.mDeltaY = paramFloat4;
    this.mDurationReciprocal = (1.0F / this.mDuration);
    this.mViscousFluidScale = 8.0F;
    this.mViscousFluidNormalize = 1.0F;
    this.mViscousFluidNormalize = (1.0F / viscousFluid(1.0F));
  }

  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }

  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mMode = 0;
    this.mFinished = false;
    this.mDuration = paramInt5;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    this.mFinalX = (paramInt1 + paramInt3);
    this.mFinalY = (paramInt2 + paramInt4);
    this.mDeltaX = paramInt3;
    this.mDeltaY = paramInt4;
    this.mDurationReciprocal = (1.0F / this.mDuration);
    this.mViscousFluidScale = 8.0F;
    this.mViscousFluidNormalize = 1.0F;
    this.mViscousFluidNormalize = (1.0F / viscousFluid(1.0F));
  }

  public int timePassed()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
  }

  public float viscousFluid(float paramFloat)
  {
    paramFloat *= this.mViscousFluidScale;
    if (paramFloat < 1.0F);
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat); ; paramFloat = 0.3678795F + (1.0F - 0.3678795F) * (1.0F - (float)Math.exp(1.0F - paramFloat)))
      return paramFloat * this.mViscousFluidNormalize;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ElasticScroller
 * JD-Core Version:    0.6.2
 */