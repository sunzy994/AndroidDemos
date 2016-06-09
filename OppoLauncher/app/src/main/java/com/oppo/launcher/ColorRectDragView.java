package com.oppo.launcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class ColorRectDragView extends DragView
{
  public static final int ANIMATION_END_DISAPPEAR = 0;
  public static final int ANIMATION_END_FADE_OUT = 1;
  public static final int ANIMATION_END_REMAIN_VISIBLE = 2;
  protected static final boolean DEBUG_ANIMATE = false;
  private static final boolean DEBUG_LAYOUT = false;
  final String TAG = ColorRectDragView.class.getName();
  protected View mAnchorView = null;
  protected int mAnchorViewInitialScrollX = 0;
  private TimeInterpolator mCubicEaseOutInterpolator = new DecelerateInterpolator(1.5F);
  private int mDelayTime = 0;
  private ValueAnimator mDropAnim = null;
  protected ColorRectDragView mDropView = null;
  private ValueAnimator mFadeOutAnim;
  private int mMaxAnimationDuration = 500;
  private Rect mRectTo = null;
  private boolean mSameDuration = false;

  public ColorRectDragView(Launcher paramLauncher, Bitmap paramBitmap, float paramFloat)
  {
    super(paramLauncher);
    this.mBitmap = paramBitmap;
    this.mIconBitmap = this.mBitmap;
    setDragRegion(new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()));
    this.mRegistrationX = 0;
    this.mOrignalRegistrationX = 0;
    this.mRegistrationY = 0;
    this.mOrignalRegistrationY = 0;
    int i = MeasureSpec.makeMeasureSpec(0, 0);
    measure(i, i);
    this.mPaint = new Paint(2);
    this.mIsDraging = true;
    this.mMaxAnimationDuration = getResources().getInteger(2131296284);
  }

  public ColorRectDragView(Launcher paramLauncher, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, float paramFloat)
  {
    super(paramLauncher, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean, paramFloat);
  }

  private void cancelDropAnimation()
  {
    if (this.mDropAnim != null)
      this.mDropAnim.cancel();
    if (this.mFadeOutAnim != null)
      this.mFadeOutAnim.cancel();
  }

  private void fadeOutDragView()
  {
    int j = 0;
    int i = j;
    if (this.mDropView != null)
    {
      i = j;
      if (!this.mDropView.getCanShake())
        i = 1;
    }
    if (i != 0);
    for (final float f = 0.3F; ; f = 1.0F)
    {
      this.mFadeOutAnim = new ValueAnimator();
      this.mFadeOutAnim.setDuration(150L);
      this.mFadeOutAnim.setFloatValues(new float[] { 0.0F, 1.0F });
      this.mFadeOutAnim.removeAllUpdateListeners();
      this.mFadeOutAnim.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = f;
          ColorRectDragView.this.mDropView.setAlpha((1.0F - f1) * f2);
          ColorRectDragView.this.invalidate();
        }
      });
      this.mFadeOutAnim.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          ColorRectDragView.this.invalidate();
        }
      });
      this.mFadeOutAnim.start();
      return;
    }
  }

  public ValueAnimator animateView(AnimatorUpdateListener paramAnimatorUpdateListener, int paramInt1, TimeInterpolator paramTimeInterpolator, final Runnable paramRunnable, final int paramInt2, View paramView)
  {
    cancelDropAnimation();
    this.mDropView.cancelAnimation();
    this.mDropView.resetLayoutParams();
    this.mAnchorView = paramView;
    if (paramView != null)
      this.mAnchorViewInitialScrollX = paramView.getScrollX();
    this.mDropAnim = new ValueAnimator();
    if (this.mDelayTime > 0)
      this.mDropAnim.setStartDelay(this.mDelayTime);
    this.mDropAnim.setInterpolator(paramTimeInterpolator);
    this.mDropAnim.setDuration(paramInt1);
    this.mDropAnim.setFloatValues(new float[] { 0.0F, 1.0F });
    this.mDropAnim.addUpdateListener(paramAnimatorUpdateListener);
    this.mDropAnim.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ColorRectDragView.this.mDropView.setLayerType(0, null);
        switch (paramInt2)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
        while (true)
        {
          if (paramRunnable != null)
            paramRunnable.run();
          return;
          ColorRectDragView.this.clearAnimatedView();
          ColorRectDragView.this.mDropView.setVisibility(4);
          continue;
          ColorRectDragView.this.fadeOutDragView();
          continue;
          ColorRectDragView.this.clearAnimatedView();
        }
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        ColorRectDragView.this.mDropView.setLayerType(2, null);
      }
    });
    return this.mDropAnim;
  }

  public ValueAnimator animateView(final Rect paramRect1, final Rect paramRect2, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4, final float paramFloat5, int paramInt1, final Interpolator paramInterpolator1, final Interpolator paramInterpolator2, final Interpolator paramInterpolator3, final int paramInt2, Runnable paramRunnable, int paramInt3, View paramView)
  {
    Resources localResources = getResources();
    final float f1 = (float)Math.sqrt(Math.pow(paramRect2.left - paramRect1.left, 2.0D) + Math.pow(paramRect2.top - paramRect1.top, 2.0D));
    float f2 = localResources.getInteger(2131296269);
    if (!this.mSameDuration)
      if (paramInt1 < 0)
      {
        paramInt1 = this.mMaxAnimationDuration;
        int i = paramInt1;
        if (f1 < f2)
          i = (int)(paramInt1 * this.mCubicEaseOutInterpolator.getInterpolation(f1 / f2));
        paramInt1 = i;
        if (i < 50)
          paramInt1 = 50;
      }
    while (true)
    {
      f1 = getAlpha();
      paramRect2 = new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          int i = jdField_this.getMeasuredWidth();
          int j = jdField_this.getMeasuredHeight();
          float f2;
          float f3;
          label48: float f4;
          label58: float f5;
          float f6;
          float f7;
          float f8;
          float f9;
          float f10;
          int k;
          int m;
          int n;
          if (paramInterpolator2 == null)
          {
            f2 = f1;
            if (paramInterpolator1 != null)
              break label402;
            f3 = f1;
            if (paramInterpolator3 != null)
              break label417;
            f4 = 0.0F;
            paramAnonymousValueAnimator = paramRect2;
            if (ColorRectDragView.this.mRectTo != null)
              paramAnonymousValueAnimator = ColorRectDragView.this.mRectTo;
            f5 = paramFloat2 * this.val$dropViewScale;
            f6 = paramFloat3 * this.val$dropViewScale;
            f7 = paramFloat4;
            f8 = paramFloat5;
            f9 = paramFloat1;
            f10 = f1;
            float f11 = paramRect1.left + (f5 - 1.0F) * i / 2.0F;
            float f12 = paramRect1.top + (f6 - 1.0F) * j / 2.0F;
            j = (int)(Math.round((paramAnonymousValueAnimator.left - f11) * f3) + f11);
            k = (int)(Math.round((paramAnonymousValueAnimator.top - f12) * f3) + f12);
            m = (int)(paramInt2 * f4);
            n = ColorRectDragView.this.mDropView.getScrollX();
            if (ColorRectDragView.this.mAnchorView == null)
              break label432;
          }
          label402: label417: label432: for (i = ColorRectDragView.this.mAnchorViewInitialScrollX - ColorRectDragView.this.mAnchorView.getScrollX(); ; i = 0)
          {
            int i1 = ColorRectDragView.this.mDropView.getScrollY();
            ColorRectDragView.this.mDropView.setTranslationX(i + (j - n) + m);
            ColorRectDragView.this.mDropView.setTranslationY(k - i1);
            ColorRectDragView.this.mDropView.setScaleX(f7 * f1 + (1.0F - f1) * f5);
            ColorRectDragView.this.mDropView.setScaleY(f8 * f1 + (1.0F - f1) * f6);
            ColorRectDragView.this.mDropView.setAlpha(f9 * f2 + f10 * (1.0F - f2));
            ColorRectDragView.this.mDropView.invalidate();
            return;
            f2 = paramInterpolator2.getInterpolation(f1);
            break;
            f3 = paramInterpolator1.getInterpolation(f1);
            break label48;
            f4 = paramInterpolator3.getInterpolation(f1);
            break label58;
          }
        }
      };
      paramRect1 = null;
      if ((paramInterpolator2 == null) || (paramInterpolator1 == null))
        paramRect1 = this.mCubicEaseOutInterpolator;
      return animateView(paramRect2, paramInt1, paramRect1, paramRunnable, paramInt3, paramView);
      this.mMaxAnimationDuration = paramInt1;
      continue;
      paramInt1 = this.mMaxAnimationDuration;
    }
  }

  public ValueAnimator animateView(Rect paramRect1, Rect paramRect2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, Interpolator paramInterpolator1, Interpolator paramInterpolator2, Runnable paramRunnable, int paramInt2, View paramView)
  {
    return animateView(paramRect1, paramRect2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramInt1, paramInterpolator1, paramInterpolator2, null, 0, paramRunnable, paramInt2, paramView);
  }

  public void clearAnimatedView()
  {
    if (this.mDropAnim != null)
      this.mDropAnim = null;
  }

  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }

  public Bitmap getDrawingBitmap()
  {
    return this.mBitmap;
  }

  public int getMaxAnimationDuration(int paramInt)
  {
    int i = paramInt;
    if (this.mMaxAnimationDuration > paramInt)
      i = this.mMaxAnimationDuration;
    return i;
  }

  public void modifyDestination(Rect paramRect)
  {
    this.mRectTo = paramRect;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (getVisibility() == 0)
      super.onDraw(paramCanvas);
  }

  public void setAnimationDelay(int paramInt)
  {
    this.mDelayTime = paramInt;
  }

  public void setRegistrationPostion(int paramInt1, int paramInt2)
  {
    this.mRegistrationX = paramInt1;
    this.mOrignalRegistrationX = paramInt1;
    this.mRegistrationY = paramInt2;
    this.mOrignalRegistrationY = paramInt2;
  }

  public void setSameDuration(boolean paramBoolean)
  {
    this.mSameDuration = paramBoolean;
  }

  public void show(int paramInt1, int paramInt2)
  {
    DragLayer.LayoutParams localLayoutParams = new DragLayer.LayoutParams(0, 0);
    localLayoutParams.width = this.mBitmap.getWidth();
    localLayoutParams.height = this.mBitmap.getHeight();
    localLayoutParams.customPosition = true;
    setLayoutParams(localLayoutParams);
    setTranslationX(paramInt1 - this.mRegistrationX);
    setTranslationY(paramInt2 - this.mRegistrationY);
  }

  public Bitmap switchBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap = this.mBitmap;
    this.mBitmap = paramBitmap;
    return localBitmap;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ColorRectDragView
 * JD-Core Version:    0.6.2
 */