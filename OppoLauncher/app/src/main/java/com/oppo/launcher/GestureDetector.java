package com.oppo.launcher;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.Scroller;

public class GestureDetector
{
  private static final float BASELINE_FLING_VELOCITY = 4000.0F;
  private static final boolean DBG = false;
  private static final int DEFAULT_BOUND_TIME = 500;
  private static final int DEFAULT_SCREEN_SNAP_TIME = 500;
  private static final float FLING_VELOCITY_INFLUENCE = 0.8F;
  private static final float MAX_FLING_DURATION = 3000.0F;
  public static final int MODE_SCREEN_SNAP = 1;
  public static final int MODE_SCROLL_SNAP = 2;
  private static final float NANOTIME_DIV = 1.0E+09F;
  private static final float OUTSIDE_DIATANCE_CONSTANT = 0.5F;
  private static final float SMOOTHING_CONSTANT = (float)(0.016D / Math.log(0.75D));
  private static final float SMOOTHING_SPEED = 0.75F;
  public static final int SNAP_DIRECTION_HORIZONTAL = 3;
  public static final int SNAP_DIRECTION_NONE = 5;
  public static final int SNAP_DIRECTION_VERTICAL = 4;
  private static final String TAG = "GestureDetector";
  private int mBoundTime = 500;
  private int mDirection;
  private CommonInterpolator mInterpolator = new CommonInterpolator();
  private int mLastScrollX;
  private int mLastScrollY;
  private int mLastTouchX;
  private int mLastTouchY;
  private int mMaximumVelocity;
  private int mMinimumFlingVelocity;
  private int mMode;
  private boolean mMoving;
  private int mScreenSnapTime = 500;
  private Scroller mScroller = new Scroller(paramContext, this.mInterpolator);
  private boolean mScrolling;
  private float mSmoothingTime;
  private ScrollTarget mTarget;
  private int mTouchSlop;
  private float mTouchX;
  private float mTouchY;
  private VelocityTracker mVelocityTracker;

  public GestureDetector(Context paramContext)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.mTouchSlop = (paramContext.getScaledTouchSlop() / 2);
    this.mMaximumVelocity = paramContext.getScaledMaximumFlingVelocity();
    this.mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
    this.mMode = 2;
    this.mDirection = 3;
  }

  private float getDurationFromVelocity(float paramFloat)
  {
    return -(1000.0F * 3000.0F / (Math.abs(paramFloat) + 1000.0F)) + 3000.0F;
  }

  private float getMaxOutsideDistance()
  {
    if (this.mTarget != null)
    {
      int i = 0;
      int j = 0;
      if (this.mDirection != 4)
        i = this.mTarget.getWidth();
      if (this.mDirection != 3)
        j = this.mTarget.getHeight();
      return (float)Math.sqrt(i * i + j * j) * 0.5F;
    }
    return 0.0F;
  }

  private float getMaxScrollX()
  {
    if (this.mTarget != null)
    {
      int i = this.mTarget.getWidth();
      int j = this.mTarget.getWidthAll();
      if (j < i);
      for (i = 0; ; i = j - i)
        return i + getMaxOutsideDistance();
    }
    return 0.0F;
  }

  private float getMaxScrollXNormal()
  {
    if (this.mTarget != null)
      return this.mTarget.getWidthAll() - this.mTarget.getWidth();
    return 0.0F;
  }

  private float getMaxScrollY()
  {
    if (this.mTarget != null)
    {
      int i = this.mTarget.getHeight();
      int j = this.mTarget.getHeightAll();
      if (j < i);
      for (i = 0; ; i = j - i)
        return i + getMaxOutsideDistance();
    }
    return 0.0F;
  }

  private float getMaxScrollYNormal()
  {
    if (this.mTarget != null)
      return this.mTarget.getHeightAll() - this.mTarget.getHeight();
    return 0.0F;
  }

  private float getMinScrollX()
  {
    if (this.mTarget != null)
      return -this.mTarget.getWidth() * 0.5F;
    return 0.0F;
  }

  private float getMinScrollXNormal()
  {
    return 0.0F;
  }

  private float getMinScrollY()
  {
    if (this.mTarget != null)
      return -this.mTarget.getHeight() * 0.5F;
    return 0.0F;
  }

  private float getMinScrollYNormal()
  {
    return 0.0F;
  }

  public void computeScroll()
  {
    if (this.mTarget == null);
    int i4;
    int i2;
    int m;
    int n;
    label166: 
    do
    {
      return;
      if (this.mScroller.computeScrollOffset())
      {
        this.mTarget.setScrollXY(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        this.mTarget.postInvalidate();
        return;
      }
      i4 = this.mTarget.getWidth();
      i2 = this.mTarget.getHeight();
      m = this.mTarget.getScrollX();
      n = this.mTarget.getScrollY();
      int i5 = this.mTarget.getWidthAll();
      int i3 = this.mTarget.getHeightAll();
      if (this.mMoving)
      {
        float f3 = (float)System.nanoTime() / 1.0E+09F;
        float f4 = (float)Math.exp((f3 - this.mSmoothingTime) / SMOOTHING_CONSTANT);
        float f1;
        if (this.mDirection != 4)
        {
          f1 = this.mTouchX - m;
          if (this.mDirection == 3)
            break label256;
        }
        for (float f2 = this.mTouchY - n; ; f2 = 0.0F)
        {
          this.mTarget.setScrollXY((int)(m + f1 * f4), (int)(n + f2 * f4));
          this.mSmoothingTime = f3;
          if ((f1 <= 1.0F) && (f1 >= -1.0F) && (f2 <= 1.0F) && (f2 >= -1.0F))
            break;
          this.mTarget.postInvalidate();
          return;
          f1 = 0.0F;
          break label166;
        }
      }
      if (((this.mDirection != 4) && ((m < 0) || ((i5 < i4) && (m > 0)) || ((i5 > i4) && (m + i4 > i5)))) || ((this.mDirection != 3) && ((n < 0) || ((i3 < i2) && (n > 0)) || ((i3 > i2) && (n + i2 > i3)))))
      {
        System.gc();
        int i1 = this.mBoundTime;
        int j = 0;
        int k = 0;
        int i = j;
        if (this.mDirection != 4)
        {
          if ((m < 0) || ((i5 < i4) && (m > 0)))
            i = -m;
        }
        else
        {
          j = k;
          if (this.mDirection != 3)
          {
            if ((n >= 0) && ((i3 >= i2) || (n <= 0)))
              break label523;
            j = -n;
          }
        }
        while (true)
        {
          this.mInterpolator.setBoundDistanceAndTime((float)Math.sqrt(i * i + j * j), i1);
          this.mScroller.startScroll(m, n, i, j, i1);
          this.mScrolling = true;
          this.mTarget.postInvalidate();
          return;
          i = j;
          if (i5 <= i4)
            break;
          i = j;
          if (m + i4 <= i5)
            break;
          i = i5 - m - i4;
          break;
          j = k;
          if (i3 > i2)
          {
            j = k;
            if (n + i2 > i3)
              j = i3 - n - i2;
          }
        }
      }
    }
    while ((!this.mScrolling) || ((this.mMode != 2) && ((this.mDirection != 3) || (m % i4 != 0)) && ((this.mDirection != 4) || (n % i2 != 0))));
    label256: label523: this.mScrolling = false;
    this.mTarget.stopScroll();
    this.mTarget.postInvalidate();
  }

  public int getBoundTime()
  {
    return this.mBoundTime;
  }

  public int getScreenSnapTime()
  {
    return this.mScreenSnapTime;
  }

  public boolean isScrolling()
  {
    return (this.mScrolling) || (this.mMoving);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mTarget == null)
      return false;
    int i16 = paramMotionEvent.getAction();
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    int i14 = this.mTarget.getWidth();
    int i12 = this.mTarget.getHeight();
    int i2 = this.mTarget.getScrollX();
    int i1 = this.mTarget.getScrollY();
    int i15 = this.mTarget.getWidthAll();
    int i13 = this.mTarget.getHeightAll();
    double d;
    float f3;
    if (this.mDirection == 3)
    {
      d = i14;
      f3 = (float)d * 0.5F;
      if (this.mVelocityTracker == null)
        this.mVelocityTracker = VelocityTracker.obtain();
      this.mVelocityTracker.addMovement(paramMotionEvent);
    }
    label363: int k;
    float f1;
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
    case 2:
      do
      {
        while (true)
        {
          this.mTarget.postInvalidate();
          return true;
          if (this.mDirection == 4)
          {
            d = i12;
            break;
          }
          d = Math.sqrt(i14 * i14 + i12 * i12);
          break;
          this.mMoving = false;
          this.mLastTouchX = m;
          this.mLastTouchY = n;
          this.mLastScrollX = i2;
          this.mLastScrollY = i1;
          if (!this.mScroller.isFinished())
            this.mScroller.abortAnimation();
        }
        i = this.mLastTouchX - m;
        j = this.mLastTouchY - n;
        if (((this.mDirection != 3) || (Math.abs(i) <= this.mTouchSlop)) && ((this.mDirection != 4) || (Math.abs(j) <= this.mTouchSlop)) && ((this.mDirection != 5) || (Math.sqrt(i * i + j * j) <= this.mTouchSlop)))
          break label765;
        i = 1;
        if ((!this.mMoving) && (i != 0))
        {
          this.mMoving = true;
          this.mTouchX = i2;
          this.mTouchY = i1;
          if (!this.mScrolling)
            this.mTarget.startScroll();
        }
      }
      while (!this.mMoving);
      j = this.mLastTouchX - m;
      k = this.mLastTouchY - n;
      if ((this.mDirection != 4) && (j != 0))
      {
        if ((i2 >= 0) || (j >= 0))
        {
          i = j;
          if (i14 >= i15)
          {
            i = j;
            if (i2 > 0)
            {
              i = j;
              if (j <= 0);
            }
          }
        }
        else
        {
          f1 = j;
          if (i2 <= 0)
            break label771;
          i = -i2;
          label502: i = (int)((i + f3) / f3 * f1);
        }
        j = i;
        if (i14 < i15)
        {
          i2 += i14;
          j = i;
          if (i2 > i15)
          {
            j = i;
            if (i > 0)
              j = (int)(i * ((f3 - i2 + i15) / f3));
          }
        }
        this.mTouchX += j;
      }
      else if ((this.mDirection != 3) && (k != 0))
      {
        if ((i1 >= 0) || (k >= 0))
        {
          i = k;
          if (i12 >= i13)
          {
            i = k;
            if (i1 > 0)
            {
              i = k;
              if (k <= 0);
            }
          }
        }
        else
        {
          f1 = k;
          if (i1 <= 0)
            break label778;
        }
      }
      label771: label778: for (i = -i1; ; i = i1)
      {
        i = (int)((i + f3) / f3 * f1);
        j = i;
        if (i12 < i13)
        {
          k = i1 + i12;
          j = i;
          if (k > i13)
          {
            j = i;
            if (i > 0)
              j = (int)(i * ((f3 - k + i13) / f3));
          }
        }
        this.mTouchY += j;
        this.mSmoothingTime = ((float)System.nanoTime() / 1.0E+09F);
        this.mLastTouchX = m;
        this.mLastTouchY = n;
        break;
        label765: i = 0;
        break label363;
        i = i2;
        break label502;
      }
    case 1:
    case 3:
    case 4:
    }
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
    label817: float f2;
    label834: float f4;
    int i4;
    int i9;
    int i10;
    int i8;
    int i11;
    int i5;
    int i6;
    int i7;
    int i3;
    if (this.mDirection != 4)
    {
      f1 = this.mVelocityTracker.getXVelocity();
      if (this.mDirection == 3)
        break label1104;
      f2 = this.mVelocityTracker.getYVelocity();
      f4 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      i4 = 0;
      i9 = 0;
      i10 = 0;
      i8 = 0;
      i11 = 0;
      i5 = 0;
      i = 0;
      i6 = 0;
      i7 = 0;
      m = 0;
      j = 0;
      n = 0;
      k = 0;
      i3 = 0;
      if (((this.mDirection == 4) || ((i2 >= 0) && ((i15 >= i14) || (i2 <= 0)))) && ((this.mDirection == 3) || ((i1 >= 0) && ((i13 >= i12) || (i1 <= 0)))))
        break label1110;
      m = this.mBoundTime;
      if (this.mDirection != 4)
        i = -i2;
      j = k;
      if (this.mDirection != 3)
        j = -i1;
      f1 = (float)Math.sqrt(i * i + j * j);
      this.mInterpolator.setBoundDistanceAndTime(f1, m);
      k = m;
    }
    label1104: label1110: label1511: label1644: 
    do
    {
      do
      {
        do
        {
          while (true)
          {
            if ((i != 0) || (j != 0))
            {
              System.gc();
              this.mScroller.startScroll(i2, i1, i, j, k);
              this.mScrolling = true;
            }
            if (this.mVelocityTracker != null)
            {
              this.mVelocityTracker.recycle();
              this.mVelocityTracker = null;
            }
            if ((this.mMoving) && (!this.mScrolling))
              this.mTarget.stopScroll();
            this.mMoving = false;
            break;
            f1 = 0.0F;
            break label817;
            f2 = 0.0F;
            break label834;
            if (((this.mDirection != 4) && (i15 >= i14) && (i2 + i14 > i15)) || ((this.mDirection != 3) && (i13 >= i12) && (i1 + i12 > i13)))
            {
              k = this.mBoundTime;
              i = i9;
              if (this.mDirection != 4)
                i = i15 - i2 - i14;
              j = i7;
              if (this.mDirection != 3)
                j = i13 - i1 - i12;
              f1 = (float)Math.sqrt(i * i + j * j);
              this.mInterpolator.setBoundDistanceAndTime(f1, k);
            }
            else
            {
              if ((!this.mMoving) && ((f4 <= this.mMinimumFlingVelocity) || (i16 != 1)))
                break label2069;
              if (this.mMode != 1)
                break label1644;
              n = this.mScreenSnapTime;
              if (this.mMoving)
              {
                i = i10;
                if (this.mDirection != 4)
                {
                  i = i2 % i14;
                  if (i2 > this.mLastScrollX)
                    i = i14 - i;
                }
                else
                {
                  k = i;
                  j = m;
                  if (this.mDirection != 3)
                  {
                    j = i1 % i12;
                    if (i1 <= this.mLastScrollY)
                      break label1433;
                    j = i12 - j;
                    k = i;
                  }
                }
              }
              do
              {
                do
                {
                  do
                  {
                    while (true)
                    {
                      f1 = (float)Math.sqrt(k * k + j * j);
                      if (Math.abs(f4) <= this.mMinimumFlingVelocity)
                        break label1622;
                      this.mInterpolator.setVelocityDistanceTime(Math.abs(f4), f1, n);
                      i = k;
                      k = n;
                      break;
                      i = -i;
                      break label1322;
                      j = -j;
                      k = i;
                    }
                    i = i8;
                    if (this.mDirection != 4)
                      if ((f1 <= 0.0F) || (i2 <= getMinScrollXNormal()))
                      {
                        i = i8;
                        if (f1 < 0.0F)
                        {
                          i = i8;
                          if (i2 >= getMaxScrollXNormal());
                        }
                      }
                      else
                      {
                        if (f1 <= 0.0F)
                          break label1610;
                        i = -1;
                        i *= i14;
                      }
                    k = i;
                    j = m;
                  }
                  while (this.mDirection == 3);
                  if ((f2 > 0.0F) && (i1 > getMinScrollYNormal()))
                    break label1586;
                  k = i;
                  j = m;
                }
                while (f2 >= 0.0F);
                k = i;
                j = m;
              }
              while (i1 >= getMaxScrollYNormal());
              if (f2 > 0.0F);
              for (j = -1; ; j = 1)
              {
                j *= i12;
                k = i;
                break;
                i = 1;
                break label1511;
              }
              this.mInterpolator.setBoundDistanceAndTime(f1, n);
              i = k;
              k = n;
            }
          }
          i = (int)getDurationFromVelocity(f4);
          this.mInterpolator.setVelocityTime(Math.abs(1.2F * f4), i);
          k = i11;
          float f5;
          if (this.mDirection != 4)
          {
            f5 = this.mInterpolator.getDistance();
            if (f1 > 0.0F)
            {
              i = -1;
              k = (int)(i * f5 * 1.2F);
            }
          }
          else
          {
            m = j;
            if (this.mDirection != 3)
            {
              f5 = this.mInterpolator.getDistance();
              if (f2 <= 0.0F)
                break label1933;
              i = -1;
              m = (int)(i * f5 * 1.2F);
            }
            n = 0;
            i = k;
            j = n;
            if (this.mDirection != 4)
            {
              if ((f1 <= 0.0F) || (i2 - Math.abs(k) >= -f3))
                break label1939;
              i = (int)-(i2 + f3);
              j = 1;
            }
            k = m;
            n = j;
            if (this.mDirection != 3)
            {
              if ((f2 <= 0.0F) || (i1 - Math.abs(m) >= -f3))
                break label2004;
              k = (int)-(i1 + f3);
              n = 1;
            }
          }
          while (true)
          {
            if (n != 0)
            {
              f1 = (float)Math.sqrt(i * i + k * k);
              this.mInterpolator.setVelocityDistance(Math.abs(f4), Math.abs(f1));
            }
            m = (int)this.mInterpolator.getDuration();
            j = k;
            k = m;
            break;
            i = 1;
            break label1702;
            i = 1;
            break label1746;
            i = k;
            j = n;
            if (f1 >= 0.0F)
              break label1814;
            i = k;
            j = n;
            if (i2 + i14 + k <= i15 + f3)
              break label1814;
            i = (int)(i15 + f3 - i2 - i14);
            j = 1;
            break label1814;
            k = m;
            n = j;
            if (f2 < 0.0F)
            {
              k = m;
              n = j;
              if (i1 + i12 + m > i13 + f3)
              {
                k = (int)(i13 + f3 - i1 - i12);
                n = 1;
              }
            }
          }
          i = i4;
          j = i6;
          k = i3;
        }
        while (this.mMode != 1);
        if ((this.mDirection != 4) && (i2 % i14 != 0))
          break label2145;
        i = i4;
        j = i6;
        k = i3;
      }
      while (this.mDirection == 3);
      i = i4;
      j = i6;
      k = i3;
    }
    while (i1 % i12 == 0);
    label1322: label1586: label1610: label1622: label2145: int i = i5;
    label1433: label1702: label1746: label2004: if (this.mDirection != 4)
    {
      i = i2 % i14;
      if (i > i14 / 2)
        i = i14 - i;
    }
    else
    {
      j = n;
      if (this.mDirection != 3)
      {
        j = i1 % i12;
        if (j <= i12 / 2)
          break label2264;
      }
    }
    label1814: label2264: for (int j = i12 - j; ; j = -j)
    {
      k = this.mBoundTime;
      f1 = (float)Math.sqrt(i * i + j * j);
      this.mInterpolator.setBoundDistanceAndTime(Math.abs(f1), k);
      break;
      i = -i;
      break label2180;
    }
  }

  public void scroll(int paramInt, boolean paramBoolean)
  {
    if (this.mTarget == null)
      return;
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f5;
    float f6;
    float f1;
    float f2;
    if (this.mDirection == 3)
    {
      f4 = this.mTarget.getScrollX();
      f5 = this.mTarget.getWidth();
      f6 = paramInt;
      if (this.mMode == 2)
      {
        f1 = 0.25F;
        if (!paramBoolean)
          break label205;
        f2 = 0.0F;
        label69: f1 = f5 * f6 * f1 - f2;
        f5 = f4 + f1;
        if (f5 >= getMinScrollX())
          break label212;
        f1 = getMinScrollX() - f4;
        f2 = f3;
      }
    }
    while (true)
    {
      f3 = this.mScreenSnapTime;
      this.mInterpolator.setVelocityDistanceTime(Math.abs(3000.0F), (float)Math.sqrt(f1 * f1 + f2 * f2), f3);
      this.mTarget.startScroll();
      this.mScroller.startScroll(this.mTarget.getScrollX(), this.mTarget.getScrollY(), (int)f1, (int)f2, (int)f3);
      this.mScrolling = true;
      this.mTarget.postInvalidate();
      return;
      f1 = 1.0F;
      break;
      label205: f2 = f4;
      break label69;
      label212: f2 = f3;
      if (f5 > getMaxScrollX())
      {
        f1 = getMaxScrollX() - f4;
        f2 = f3;
        continue;
        f1 = f4;
        f2 = f3;
        if (this.mDirection == 4)
        {
          f3 = this.mTarget.getScrollY();
          f5 = this.mTarget.getHeight();
          f6 = paramInt;
          if (this.mMode == 2)
          {
            f1 = 0.25F;
            label296: if (!paramBoolean)
              break label352;
          }
          label352: for (f2 = 0.0F; ; f2 = f3)
          {
            f5 = f5 * f6 * f1 - f2;
            f6 = f3 + f5;
            if (f6 >= getMinScrollY())
              break label359;
            f1 = getMinScrollY() - f3;
            f2 = f5;
            break;
            f1 = 1.0F;
            break label296;
          }
          label359: f1 = f4;
          f2 = f5;
          if (f6 > getMaxScrollY())
          {
            f1 = getMaxScrollY() - f3;
            f2 = f5;
          }
        }
      }
    }
  }

  public void scrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mTarget == null)
      return;
    this.mInterpolator.setVelocityDistanceTime((float)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4), (float)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2), paramInt5);
    this.mTarget.startScroll();
    this.mScroller.startScroll(this.mTarget.getScrollX(), this.mTarget.getScrollY(), paramInt1, paramInt2, paramInt5);
    this.mScrolling = true;
    this.mTarget.postInvalidate();
  }

  public void setBoundTime(int paramInt)
  {
    this.mBoundTime = paramInt;
  }

  public void setDirection(int paramInt)
  {
    if (paramInt == this.mDirection)
      return;
    switch (paramInt)
    {
    default:
      this.mDirection = 5;
      return;
    case 3:
    case 4:
    }
    this.mDirection = paramInt;
  }

  public void setMode(int paramInt)
  {
    this.mMode = paramInt;
  }

  public void setScreenSnapTime(int paramInt)
  {
    this.mScreenSnapTime = paramInt;
  }

  public void setTarget(ScrollTarget paramScrollTarget)
  {
    this.mTarget = paramScrollTarget;
  }

  public void setmDirection(int paramInt)
  {
    this.mDirection = paramInt;
  }

  public void trackScroll(int paramInt1, int paramInt2)
  {
    this.mTouchX = paramInt1;
    this.mTouchY = paramInt2;
    this.mSmoothingTime = ((float)System.nanoTime() / 1.0E+09F);
  }

  public static abstract interface ScrollTarget
  {
    public abstract int getHeight();

    public abstract int getHeightAll();

    public abstract int getScrollX();

    public abstract int getScrollY();

    public abstract int getWidth();

    public abstract int getWidthAll();

    public abstract void postInvalidate();

    public abstract void setScrollXY(int paramInt1, int paramInt2);

    public abstract void startScroll();

    public abstract void stopScroll();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.GestureDetector
 * JD-Core Version:    0.6.2
 */