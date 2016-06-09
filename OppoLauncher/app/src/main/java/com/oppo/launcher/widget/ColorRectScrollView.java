package com.oppo.launcher.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.oppo.launcher.ColorRectManager;
import com.oppo.launcher.R.styleable;

public class ColorRectScrollView extends FrameLayout
{
  private static final boolean DEBUG = false;
  private final int CONTENT_COUNT = ColorRectManager.MAX_SELECT_COUNT;
  private final String TAG = "ColorRectScrollView";
  private AnimatorSet mAnimatorSet;
  private String[] mContent;
  private int mCurrentIndex;
  private TextView mCurrentTextView;
  private TextView mInvisibleTextView;
  private int mScrollDuration;
  private float mScrollHeight;
  private int mTextColor;
  private float mTextSize;

  public ColorRectScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ColorRectScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ColorRectScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130968579, this, true);
    Resources localResources = getResources();
    int j = localResources.getDimensionPixelSize(2131361931);
    int k = localResources.getInteger(2131296289);
    int m = localResources.getColor(2131296289);
    int n = localResources.getDimensionPixelSize(2131361932);
    this.mContent = new String[this.CONTENT_COUNT];
    int i = 0;
    while (i < this.CONTENT_COUNT)
    {
      this.mContent[i] = String.valueOf(this.CONTENT_COUNT - i);
      i += 1;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ColorRectScrollView, paramInt, 0);
    this.mScrollHeight = paramContext.getInteger(0, j);
    this.mScrollDuration = paramContext.getInteger(1, k);
    this.mTextColor = paramContext.getColor(3, m);
    this.mTextSize = paramContext.getDimension(2, n);
    paramContext.recycle();
  }

  public int getCurrentIndex()
  {
    return this.mCurrentIndex;
  }

  public boolean isAnimating()
  {
    if (this.mAnimatorSet != null)
      return this.mAnimatorSet.isRunning();
    return false;
  }

  public void next()
  {
    int j = this.mCurrentIndex;
    if ((this.mAnimatorSet != null) && (this.mAnimatorSet.isRunning()));
    for (int i = this.CONTENT_COUNT; j >= i; i = this.CONTENT_COUNT - 1)
      return;
    if (this.mAnimatorSet != null)
      this.mAnimatorSet.cancel();
    this.mAnimatorSet = new AnimatorSet();
    this.mAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.mCurrentTextView, "translationY", new float[] { -this.mScrollHeight }), ObjectAnimator.ofFloat(this.mInvisibleTextView, "translationY", new float[] { this.mScrollHeight, 0.0F }), ObjectAnimator.ofFloat(this.mCurrentTextView, "alpha", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.mInvisibleTextView, "alpha", new float[] { 0.0F, 1.0F }) });
    AnimatorListenerAdapter local1 = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        ColorRectScrollView.this.mInvisibleTextView.setText(ColorRectScrollView.this.mContent[ColorRectScrollView.this.mCurrentIndex]);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator = ColorRectScrollView.this.mInvisibleTextView;
        ColorRectScrollView.access$202(ColorRectScrollView.this, ColorRectScrollView.this.mCurrentTextView);
        ColorRectScrollView.access$302(ColorRectScrollView.this, paramAnonymousAnimator);
        ColorRectScrollView.this.mInvisibleTextView.setVisibility(8);
        if (ColorRectScrollView.this.mCurrentIndex < ColorRectScrollView.this.CONTENT_COUNT - 1)
          ColorRectScrollView.access$108(ColorRectScrollView.this);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        ColorRectScrollView.this.mInvisibleTextView.setText(ColorRectScrollView.this.mContent[(ColorRectScrollView.this.mCurrentIndex + 1)]);
        ColorRectScrollView.this.mInvisibleTextView.setVisibility(0);
      }
    };
    this.mAnimatorSet.setDuration(this.mScrollDuration);
    this.mAnimatorSet.setInterpolator(new DecelerateInterpolator(1.0F));
    this.mAnimatorSet.addListener(local1);
    this.mAnimatorSet.start();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mCurrentTextView = ((TextView)findViewById(2131492868));
    this.mInvisibleTextView = ((TextView)findViewById(2131492869));
    this.mCurrentTextView.setTextColor(this.mTextColor);
    this.mInvisibleTextView.setTextColor(this.mTextColor);
    this.mInvisibleTextView.setTextSize(0, this.mTextSize);
    this.mCurrentTextView.setTextSize(0, this.mTextSize);
  }

  public void previous()
  {
    int j = this.mCurrentIndex;
    if ((this.mAnimatorSet != null) && (this.mAnimatorSet.isRunning()));
    for (int i = -1; j <= i; i = 0)
      return;
    if (this.mAnimatorSet != null)
      this.mAnimatorSet.cancel();
    this.mAnimatorSet = new AnimatorSet();
    this.mAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.mCurrentTextView, "translationY", new float[] { this.mScrollHeight }), ObjectAnimator.ofFloat(this.mInvisibleTextView, "translationY", new float[] { -this.mScrollHeight, 0.0F }), ObjectAnimator.ofFloat(this.mCurrentTextView, "alpha", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.mInvisibleTextView, "alpha", new float[] { 0.0F, 1.0F }) });
    AnimatorListenerAdapter local2 = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        ColorRectScrollView.this.mInvisibleTextView.setText(ColorRectScrollView.this.mContent[ColorRectScrollView.this.mCurrentIndex]);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator = ColorRectScrollView.this.mInvisibleTextView;
        ColorRectScrollView.access$202(ColorRectScrollView.this, ColorRectScrollView.this.mCurrentTextView);
        ColorRectScrollView.access$302(ColorRectScrollView.this, paramAnonymousAnimator);
        ColorRectScrollView.this.mInvisibleTextView.setVisibility(8);
        if (ColorRectScrollView.this.mCurrentIndex > 0)
          ColorRectScrollView.access$110(ColorRectScrollView.this);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        ColorRectScrollView.this.mInvisibleTextView.setText(ColorRectScrollView.this.mContent[(ColorRectScrollView.this.mCurrentIndex - 1)]);
        ColorRectScrollView.this.mInvisibleTextView.setVisibility(0);
      }
    };
    this.mAnimatorSet.setDuration(this.mScrollDuration);
    this.mAnimatorSet.setInterpolator(new DecelerateInterpolator(1.0F));
    this.mAnimatorSet.addListener(local2);
    this.mAnimatorSet.start();
  }

  public void reset()
  {
    this.mCurrentIndex = (this.CONTENT_COUNT - 1);
    this.mCurrentTextView.setTranslationY(0.0F);
    this.mCurrentTextView.setText(this.mContent[this.mCurrentIndex]);
    this.mCurrentTextView.setAlpha(1.0F);
    this.mCurrentTextView.setVisibility(0);
    this.mInvisibleTextView.setVisibility(8);
  }

  public void setScrollHeight(float paramFloat)
  {
    this.mScrollHeight = paramFloat;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.widget.ColorRectScrollView
 * JD-Core Version:    0.6.2
 */