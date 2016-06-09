package com.oppo.launcher;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

public class PagePointView extends ImageView
{
  private static final boolean DEBUG_DRAW = false;
  private static final boolean DEBUG_NORMAL = false;
  private static final int ORIENTATION_HORIZONTAL = 1;
  private static String TAG = "PagePointView";
  private boolean mAutoPlay = false;
  private int mBitmapHeight = 0;
  private int mBitmapWidth = 0;
  private int mCurrentPage = 0;
  private int mDuration = 0;
  private Bitmap mFocusedPointBitmap = null;
  private int mInternalSpace = 0;
  private float mInterpolation = 0.0F;
  private Interpolator mInterpolator;
  private Launcher mLauncher;
  private Drawable mNavigate = null;
  private Bitmap mNormalPointBitmap = null;
  private int mOrientation = 1;
  private Paint mPaint = new Paint();
  private long mStartTime = 0L;
  private int mTotalPage = 1;

  public PagePointView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PagePointView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PagePointView, paramInt, 0);
    this.mOrientation = paramContext.getInt(0, 1);
    this.mInternalSpace = paramContext.getDimensionPixelOffset(1, 0);
    if (this.mOrientation == 1)
    {
      paramAttributeSet = getResources();
      recyclePointBitmap();
      paramInt = paramAttributeSet.getDimensionPixelSize(2131361875);
      this.mNormalPointBitmap = Bitmap.createScaledBitmap(((BitmapDrawable)paramAttributeSet.getDrawable(2130837526)).getBitmap(), paramInt, paramInt, true);
      this.mFocusedPointBitmap = Bitmap.createScaledBitmap(((BitmapDrawable)paramAttributeSet.getDrawable(2130837525)).getBitmap(), paramInt, paramInt, true);
      this.mBitmapWidth = this.mNormalPointBitmap.getWidth();
      this.mBitmapHeight = this.mNormalPointBitmap.getHeight();
    }
    paramContext.recycle();
  }

  private void autoPlay()
  {
    int i = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    if (i >= this.mDuration)
      this.mAutoPlay = false;
    float f = Math.min(1.0F, Math.max(0.0F, i / this.mDuration));
    this.mInterpolation = this.mInterpolator.getInterpolation(f);
    this.mPaint.setAlpha((int)(255.0F * f));
    invalidate();
  }

  private int computeExpandedOffset(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt2 * 2 + 1 - paramInt3;
    if (this.mInterpolation >= 0.0F)
      if (i != 0);
    while (i == 0)
    {
      return paramInt1;
      paramInt1 = (paramInt4 - 40) / 10;
      return (11 - paramInt3) * paramInt1 / 2 + 20 + paramInt1 * paramInt2;
    }
    return paramInt1 - Math.abs(i) * paramInt5 / i / 2;
  }

  private void recyclePointBitmap()
  {
    if ((this.mNormalPointBitmap != null) && (!this.mNormalPointBitmap.isRecycled()))
    {
      this.mNormalPointBitmap.recycle();
      this.mNormalPointBitmap = null;
    }
    if ((this.mFocusedPointBitmap != null) && (!this.mFocusedPointBitmap.isRecycled()))
    {
      this.mFocusedPointBitmap.recycle();
      this.mFocusedPointBitmap = null;
    }
  }

  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    clearAnimation();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int j = this.mInternalSpace;
    if (this.mOrientation == 1)
    {
      int i1 = getWidth();
      int i4 = getHeight();
      int i2 = this.mTotalPage;
      int i3 = this.mCurrentPage;
      Workspace localWorkspace = null;
      if (this.mLauncher != null)
      {
        localWorkspace = this.mLauncher.getWorkspace();
        this.mLauncher.getDragController();
      }
      if (localWorkspace == null)
        Log.w(TAG, "onDraw --- workspace is null, just return!");
      label177: 
      do
      {
        return;
        int k;
        int i5;
        int i;
        if (i2 > 0)
        {
          k = i2 - 1;
          i5 = m + n + this.mBitmapWidth * i2 + k * j;
          i = m + (i1 - i5) / 2;
          if (i5 > i1)
          {
            j = (i1 - m - n - this.mBitmapWidth * i2) / k;
            i = m;
          }
          i4 = (i4 - this.mBitmapHeight) / 2;
          k = 0;
          if (k >= i2)
            continue;
          i5 = computeExpandedOffset(i, k, i2, i1 - m - n, j);
          if (k != i3)
            break label265;
          paramCanvas.drawBitmap(this.mFocusedPointBitmap, i + (i5 - i) * this.mInterpolation, i4, this.mPaint);
        }
        while (true)
        {
          i += this.mBitmapWidth + j;
          k += 1;
          break label177;
          k = 0;
          break;
          paramCanvas.drawBitmap(this.mNormalPointBitmap, i + (i5 - i) * this.mInterpolation, i4, this.mPaint);
        }
      }
      while (!this.mAutoPlay);
      label265: autoPlay();
      return;
    }
    super.onDraw(paramCanvas);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.mOrientation == 1)
    {
      setImageDrawable(null);
      return;
    }
    this.mNavigate = getDrawable();
  }

  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if ((paramInt == 130) && (paramRect == null))
      return false;
    return super.requestFocus(paramInt, paramRect);
  }

  public void setLauncher(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
  }

  public void startAnimation(int paramInt)
  {
    if (this.mInterpolator == null)
      this.mInterpolator = new Interpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          if (paramAnonymousFloat < 0.8F)
            return (float)Math.sin(5.0F * paramAnonymousFloat * 3.141592653589793D / 4.0D);
          return (float)Math.sin((4.0F - 5.0F * paramAnonymousFloat) * 3.141592653589793D);
        }
      };
    this.mDuration = paramInt;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mAutoPlay = true;
    autoPlay();
  }

  public void updateIndicators(int paramInt1, int paramInt2)
  {
    getResources();
    if (paramInt2 > paramInt1)
      Log.w(TAG, "updateIndicators,level > total, return ");
    do
    {
      return;
      if (this.mOrientation == 1)
      {
        this.mCurrentPage = paramInt2;
        paramInt2 = this.mTotalPage;
        if (paramInt1 >= 0)
          this.mTotalPage = paramInt1;
        if (paramInt2 != this.mTotalPage)
        {
          requestLayout();
          return;
        }
        invalidate();
        return;
      }
    }
    while (this.mNavigate == null);
    this.mNavigate.setLevel(paramInt2);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.PagePointView
 * JD-Core Version:    0.6.2
 */