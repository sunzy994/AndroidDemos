package com.oppo.launcher.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OppoScroller
{
  private static final int DEFAULT_DURATION = 250;
  private static final int DEFAULT_TIME_GAP = 15;
  private static final int FLING_MODE = 1;
  private static final int FLING_SCROLL_BACK_DURATION = 750;
  private static final int FLING_SCROLL_BACK_MODE = 3;
  private static final int FLING_SPRING_MODE = 2;
  private static final int GALLERY_LIST_MODE = 5;
  private static final int GALLERY_TIME_GAP = 25;
  private static final int SCROLL_LIST_MODE = 4;
  private static final int SCROLL_MODE = 0;
  final boolean DEBUG_SPRING = false;
  final String TAG = "OppoScroller";
  private float mCoeffX = 0.0F;
  private float mCoeffY = 1.0F;
  private int mCount = 1;
  private int mCurrVX;
  private int mCurrVY;
  private int mCurrX;
  private int mCurrY;
  public final float mDeceleration;
  private float mDeltaX;
  private float mDeltaY;
  private int mDuration;
  private float mDurationReciprocal;
  private int mFinalX;
  private int mFinalY;
  private boolean mFinished = true;
  private Interpolator mInterpolator;
  private int mLastCurrY = 0;
  private int mMaxX;
  private int mMaxY;
  private int mMinX;
  private int mMinY;
  private int mMode;
  private long mStartTime;
  private int mStartX;
  private int mStartY;
  private float mVelocity;
  private float mViscousFluidNormalize;
  private float mViscousFluidScale;

  public OppoScroller(Context paramContext)
  {
    this(paramContext, null);
  }

  public OppoScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
    this.mDeceleration = (386.0878F * (paramContext.getResources().getDisplayMetrics().density * 160.0F) * ViewConfiguration.getScrollFriction());
  }

  private float getInterpolation(float paramFloat)
  {
    return (1.0F - (float)Math.exp(-(paramFloat * 8.0F))) * (1.0F - 0.3678795F) * this.mViscousFluidNormalize;
  }

  private float viscousFluid(float paramFloat)
  {
    paramFloat *= this.mViscousFluidScale;
    if (paramFloat < 1.0F);
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat); ; paramFloat = 0.3678795F + (1.0F - 0.3678795F) * (1.0F - (float)Math.exp(1.0F - paramFloat)))
      return paramFloat * this.mViscousFluidNormalize;
  }

  public void abortAnimation()
  {
    this.mCurrX = this.mFinalX;
    this.mCurrY = this.mFinalY;
    this.mFinished = true;
  }

  public boolean computeScrollOffset()
  {
    if (this.mFinished)
      return false;
    int i = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    if (4 == this.mMode)
    {
      i = this.mCount * 15;
      if (i >= this.mDuration)
        break label794;
      switch (this.mMode)
      {
      default:
      case 0:
      case 5:
      case 4:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      return true;
      if (5 != this.mMode)
        break;
      i = this.mCount * 25;
      break;
      float f1 = i * this.mDurationReciprocal;
      if (this.mInterpolator == null);
      for (f1 = viscousFluid(f1); ; f1 = this.mInterpolator.getInterpolation(f1))
      {
        this.mCurrX = (this.mStartX + Math.round(this.mDeltaX * f1));
        this.mCurrY = (this.mStartY + Math.round(this.mDeltaY * f1));
        if ((this.mCurrX != this.mFinalX) || (this.mCurrY != this.mFinalY))
          break;
        this.mFinished = true;
        break;
      }
      f1 = getInterpolation(i * this.mDurationReciprocal);
      this.mCurrX = (this.mStartX + Math.round(this.mDeltaX * f1));
      this.mCurrY = (this.mStartY + Math.round(this.mDeltaY * f1));
      this.mCurrVY = Math.round((this.mCurrY - this.mLastCurrY) * 250 / 15);
      this.mLastCurrY = this.mCurrY;
      if (((this.mCurrX == this.mFinalX) && (this.mCurrY == this.mFinalY)) || (this.mCurrVY == 0))
      {
        this.mFinalY = this.mCurrY;
        this.mFinished = true;
        continue;
        f1 = i / 1000.0F;
        float f2 = this.mVelocity * f1 - this.mDeceleration * f1 * f1 / 2.0F;
        this.mCurrX = (this.mStartX + Math.round(this.mCoeffX * f2));
        this.mCurrX = Math.min(this.mCurrX, this.mMaxX);
        this.mCurrX = Math.max(this.mCurrX, this.mMinX);
        this.mCurrY = (this.mStartY + Math.round(this.mCoeffY * f2));
        this.mCurrY = Math.min(this.mCurrY, this.mMaxY);
        this.mCurrY = Math.max(this.mCurrY, this.mMinY);
        f1 = this.mVelocity - this.mDeceleration * f1;
        this.mCurrVX = Math.round(this.mCoeffX * f1);
        this.mCurrVY = Math.round(this.mCoeffY * f1);
        if ((this.mCurrX == this.mFinalX) && (this.mCurrY == this.mFinalY))
        {
          this.mFinished = true;
          continue;
          f1 = i / 1000.0F;
          f1 = this.mVelocity * f1 - this.mDeceleration * f1 * f1 / 2.0F;
          this.mCurrX = (this.mStartX + Math.round(this.mCoeffX * f1));
          this.mCurrX = Math.min(this.mCurrX, this.mMaxX);
          this.mCurrX = Math.max(this.mCurrX, this.mMinX);
          this.mCurrY = (this.mStartY + Math.round(this.mCoeffY * f1));
          this.mCurrY = Math.min(this.mCurrY, this.mMaxY);
          this.mCurrY = Math.max(this.mCurrY, this.mMinY);
          if ((this.mCurrX == this.mFinalX) || (this.mCurrY == this.mFinalY))
          {
            startScroll(this.mCurrX, this.mCurrY, (int)(this.mDeltaX + (this.mFinalX - this.mCurrX)), (int)(this.mDeltaY + (this.mFinalY - this.mCurrY)), 750);
            this.mMode = 3;
            continue;
            f1 = viscousFluid(i * this.mDurationReciprocal);
            this.mCurrX = (this.mStartX + Math.round(this.mDeltaX * f1));
            this.mCurrY = (this.mStartY + Math.round(this.mDeltaY * f1));
            if ((this.mCurrX == this.mFinalX) && (this.mCurrY == this.mFinalY))
            {
              this.mFinished = true;
              continue;
              label794: if (this.mMode == 2)
              {
                startScroll(this.mCurrX, this.mCurrY, (int)(this.mDeltaX + (this.mFinalX - this.mCurrX)), (int)(this.mDeltaY + (this.mFinalY - this.mCurrY)), 750);
                this.mMode = 3;
                return true;
              }
              this.mCurrX = this.mFinalX;
              this.mCurrY = this.mFinalY;
              this.mFinished = true;
            }
          }
        }
      }
    }
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

  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5 - paramInt9, paramInt6 + paramInt9, paramInt7 - paramInt10, paramInt8 + paramInt10);
    this.mDeltaY = 0.0F;
    this.mDeltaX = 0.0F;
    if ((this.mFinalX > paramInt6) || (this.mFinalX < paramInt5))
    {
      this.mMode = 2;
      if (this.mFinalX <= paramInt6)
        break label128;
    }
    label128: for (this.mDeltaX = (paramInt6 - this.mFinalX); ; this.mDeltaX = (paramInt5 - this.mFinalX))
    {
      if ((this.mFinalY > paramInt8) || (this.mFinalY < paramInt7))
      {
        this.mMode = 2;
        if (this.mFinalY <= paramInt8)
          break;
        this.mDeltaY = (paramInt8 - this.mFinalY);
      }
      return;
    }
    this.mDeltaY = (paramInt7 - this.mFinalY);
  }

  public final void forceFinished(boolean paramBoolean)
  {
    this.mFinished = paramBoolean;
  }

  public final int getCurrVX()
  {
    return this.mCurrVX;
  }

  public final int getCurrVY()
  {
    return this.mCurrVY;
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

  public void setCount(int paramInt)
  {
    this.mCount = paramInt;
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

  public void startGalleryList(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    this.mMode = 5;
    this.mCount = 1;
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

  public void startScrollList(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    this.mMode = 4;
    this.mViscousFluidNormalize = 1.0F;
    this.mViscousFluidNormalize = (1.0F / getInterpolation(1.0F));
    this.mLastCurrY = 0;
    this.mCount = 1;
  }

  public int timePassed()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.widget.OppoScroller
 * JD-Core Version:    0.6.2
 */