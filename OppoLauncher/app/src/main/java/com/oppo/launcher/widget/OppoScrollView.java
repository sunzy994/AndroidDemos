package com.oppo.launcher.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.Span;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class OppoScrollView extends FrameLayout
{
  static final int ANIMATED_SCROLL_GAP = 250;
  protected static final int INVALID_POINTER = -1;
  static final float MAX_SCROLL_FACTOR = 0.5F;
  private static final String TAG = "ScrollView";
  protected int mActivePointerId = -1;
  private View mChildToScrollTo = null;
  private boolean mEdgeEffectVisiable = true;
  protected EdgeEffect mEdgeGlowBottom;
  protected EdgeEffect mEdgeGlowTop;

  @ViewDebug.ExportedProperty(category="layout")
  private boolean mFillViewport;
  protected StrictMode.Span mFlingStrictSpan = null;
  protected boolean mIsBeingDragged = false;
  private boolean mIsLayoutDirty = true;
  protected int mLastMotionY;
  private long mLastScroll;
  protected int mMaximumVelocity;
  protected int mMinimumVelocity;
  protected int mOverflingDistance;
  protected int mOverscrollDistance;
  protected StrictMode.Span mScrollStrictSpan = null;
  protected OppoScroller mScroller;
  private boolean mSmoothScrollingEnabled = true;
  private final Rect mTempRect = new Rect();
  protected int mTouchSlop;
  protected VelocityTracker mVelocityTracker;

  public OppoScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public OppoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }

  public OppoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initScrollView();
    setFillViewport(false);
  }

  private boolean canScroll()
  {
    boolean bool2 = false;
    View localView = getChildAt(0);
    boolean bool1 = bool2;
    if (localView != null)
    {
      int i = localView.getHeight();
      bool1 = bool2;
      if (getHeight() < this.mPaddingTop + i + this.mPaddingBottom)
        bool1 = true;
    }
    return bool1;
  }

  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0))
      i = 0;
    do
    {
      return i;
      i = paramInt1;
    }
    while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }

  private void doScrollY(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.mSmoothScrollingEnabled)
        smoothScrollBy(0, paramInt);
    }
    else
      return;
    scrollBy(0, paramInt);
  }

  private void endDrag()
  {
    this.mIsBeingDragged = false;
    recycleVelocityTracker();
    if (this.mEdgeGlowTop != null)
    {
      this.mEdgeGlowTop.onRelease();
      this.mEdgeGlowBottom.onRelease();
    }
    if (this.mScrollStrictSpan != null)
    {
      this.mScrollStrictSpan.finish();
      this.mScrollStrictSpan = null;
    }
  }

  private View findFocusableViewInBounds(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    Object localObject2 = null;
    int m = 0;
    int i1 = localArrayList.size();
    int k = 0;
    if (k < i1)
    {
      View localView = (View)localArrayList.get(k);
      int n = localView.getTop();
      int i2 = localView.getBottom();
      Object localObject1 = localObject2;
      int j = m;
      int i;
      if (paramInt1 < i2)
      {
        localObject1 = localObject2;
        j = m;
        if (n < paramInt2)
        {
          if ((paramInt1 >= n) || (i2 >= paramInt2))
            break label133;
          i = 1;
          label103: if (localObject2 != null)
            break label139;
          localObject1 = localView;
          j = i;
        }
      }
      while (true)
      {
        k += 1;
        localObject2 = localObject1;
        m = j;
        break;
        label133: i = 0;
        break label103;
        label139: if (((paramBoolean) && (n < localObject2.getTop())) || ((!paramBoolean) && (i2 > localObject2.getBottom())));
        for (n = 1; ; n = 0)
        {
          if (m == 0)
            break label218;
          localObject1 = localObject2;
          j = m;
          if (i == 0)
            break;
          localObject1 = localObject2;
          j = m;
          if (n == 0)
            break;
          localObject1 = localView;
          j = m;
          break;
        }
        label218: if (i != 0)
        {
          localObject1 = localView;
          j = 1;
        }
        else
        {
          localObject1 = localObject2;
          j = m;
          if (n != 0)
          {
            localObject1 = localView;
            j = m;
          }
        }
      }
    }
    return localObject2;
  }

  private boolean inChild(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getChildCount() > 0)
    {
      int i = this.mScrollY;
      View localView = getChildAt(0);
      bool1 = bool2;
      if (paramInt2 >= localView.getTop() - i)
      {
        bool1 = bool2;
        if (paramInt2 < localView.getBottom() - i)
        {
          bool1 = bool2;
          if (paramInt1 >= localView.getLeft())
          {
            bool1 = bool2;
            if (paramInt1 < localView.getRight())
              bool1 = true;
          }
        }
      }
    }
    return bool1;
  }

  private void initOrResetVelocityTracker()
  {
    if (this.mVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.mVelocityTracker.clear();
  }

  private void initScrollView()
  {
    this.mScroller = new OppoScroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(this.mContext);
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mOverscrollDistance = localViewConfiguration.getScaledOverscrollDistance();
    this.mOverflingDistance = localViewConfiguration.getScaledOverflingDistance();
  }

  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
  }

  private boolean isOffScreen(View paramView)
  {
    boolean bool = false;
    if (!isWithinDeltaOfScreen(paramView, 0, getHeight()))
      bool = true;
    return bool;
  }

  private static boolean isViewDescendantOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2);
    do
    {
      return true;
      paramView1 = paramView1.getParent();
    }
    while (((paramView1 instanceof ViewGroup)) && (isViewDescendantOf((View)paramView1, paramView2)));
    return false;
  }

  private boolean isWithinDeltaOfScreen(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    return (this.mTempRect.bottom + paramInt1 >= getScrollY()) && (this.mTempRect.top - paramInt1 <= getScrollY() + paramInt2);
  }

  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
      if (i != 0)
        break label57;
    label57: for (i = 1; ; i = 0)
    {
      this.mLastMotionY = ((int)paramMotionEvent.getY(i));
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null)
        this.mVelocityTracker.clear();
      return;
    }
  }

  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }

  private boolean scrollAndFocus(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    int j = getHeight();
    int i = getScrollY();
    j = i + j;
    if (paramInt1 == 33);
    for (boolean bool1 = true; ; bool1 = false)
    {
      View localView = findFocusableViewInBounds(bool1, paramInt2, paramInt3);
      Object localObject = localView;
      if (localView == null)
        localObject = this;
      if ((paramInt2 < i) || (paramInt3 > j))
        break;
      bool1 = false;
      if (localObject != findFocus())
        ((View)localObject).requestFocus(paramInt1);
      return bool1;
    }
    if (bool1)
      paramInt2 -= i;
    while (true)
    {
      doScrollY(paramInt2);
      bool1 = bool2;
      break;
      paramInt2 = paramInt3 - j;
    }
  }

  private void scrollToChild(View paramView)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    if (i != 0)
      scrollBy(0, i);
  }

  private boolean scrollToChildRect(Rect paramRect, boolean paramBoolean)
  {
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0);
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean)
          break;
        scrollBy(0, i);
      }
      return bool;
    }
    smoothScrollBy(0, i);
    return bool;
  }

  public void addView(View paramView)
  {
    if (getChildCount() > 0)
      throw new IllegalStateException("ScrollView can host only one direct child");
    super.addView(paramView);
  }

  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0)
      throw new IllegalStateException("ScrollView can host only one direct child");
    super.addView(paramView, paramInt);
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0)
      throw new IllegalStateException("ScrollView can host only one direct child");
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0)
      throw new IllegalStateException("ScrollView can host only one direct child");
    super.addView(paramView, paramLayoutParams);
  }

  public boolean arrowScroll(int paramInt)
  {
    boolean bool = false;
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this)
      localView1 = null;
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int k = getMaxScrollAmount();
    if ((localView2 != null) && (isWithinDeltaOfScreen(localView2, k, getHeight())))
    {
      localView2.getDrawingRect(this.mTempRect);
      offsetDescendantRectToMyCoords(localView2, this.mTempRect);
      doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (isOffScreen(localView1)))
      {
        paramInt = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(paramInt);
      }
      bool = true;
      label130: return bool;
    }
    int j = k;
    int i;
    if ((paramInt == 33) && (getScrollY() < j))
    {
      i = getScrollY();
      label158: if (i == 0)
        break label249;
      if (paramInt != 130)
        break label251;
    }
    while (true)
    {
      doScrollY(i);
      break;
      i = j;
      if (paramInt != 130)
        break label158;
      i = j;
      if (getChildCount() <= 0)
        break label158;
      int m = getChildAt(0).getBottom();
      int n = getScrollY() + getHeight() - this.mPaddingBottom;
      i = j;
      if (m - n >= k)
        break label158;
      i = m - n;
      break label158;
      label249: break label130;
      label251: i = -i;
    }
  }

  public void computeScroll()
  {
    int j = 1;
    if (this.mScroller.computeScrollOffset())
    {
      k = this.mScrollX;
      m = this.mScrollY;
      n = this.mScroller.getCurrX();
      i1 = this.mScroller.getCurrY();
      if ((k != n) || (m != i1))
      {
        i2 = getScrollRange();
        i3 = getOverScrollMode();
        i = j;
        if (i3 != 0)
        {
          if ((i3 != 1) || (i2 <= 0))
            break label168;
          i = j;
        }
        overScrollBy(n - k, i1 - m, k, m, 0, i2, 0, this.mOverflingDistance, false);
        onScrollChanged(this.mScrollX, this.mScrollY, k, m);
        if (i != 0)
        {
          if ((i1 >= 0) || (m < 0))
            break label173;
          this.mEdgeGlowTop.onAbsorb((int)this.mScroller.getCurrVelocity());
        }
      }
      if (!awakenScrollBars())
        postInvalidateOnAnimation();
    }
    label168: label173: 
    while (this.mFlingStrictSpan == null)
      while (true)
      {
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        return;
        int i = 0;
        continue;
        if ((i1 > i2) && (m <= i2))
          this.mEdgeGlowBottom.onAbsorb((int)this.mScroller.getCurrVelocity());
      }
    this.mFlingStrictSpan.finish();
    this.mFlingStrictSpan = null;
  }

  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0);
    int m;
    int j;
    do
    {
      return 0;
      m = getHeight();
      i = getScrollY();
      int k = i + m;
      int n = getVerticalFadingEdgeLength();
      j = i;
      if (paramRect.top > 0)
        j = i + n;
      i = k;
      if (paramRect.bottom < getChildAt(0).getHeight())
        i = k - n;
      if ((paramRect.bottom > i) && (paramRect.top > j))
      {
        if (paramRect.height() > m);
        for (j = 0 + (paramRect.top - j); ; j = 0 + (paramRect.bottom - i))
          return Math.min(j, getChildAt(0).getBottom() - i);
      }
    }
    while ((paramRect.top >= j) || (paramRect.bottom >= i));
    if (paramRect.height() > m);
    for (int i = 0 - (i - paramRect.bottom); ; i = 0 - (j - paramRect.top))
      return Math.max(i, -getScrollY());
  }

  protected int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }

  protected int computeVerticalScrollRange()
  {
    int j = getChildCount();
    int i = getHeight() - this.mPaddingBottom - this.mPaddingTop;
    if (j == 0)
      return i;
    j = getChildAt(0).getBottom();
    int k = this.mScrollY;
    int m = Math.max(0, j - i);
    if (k < 0)
      i = j - k;
    while (true)
    {
      return i;
      i = j;
      if (k > m)
        i = j + (k - m);
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.mEdgeGlowTop != null) && (true == this.mEdgeEffectVisiable))
    {
      int i = this.mScrollY;
      int j;
      int k;
      int m;
      if (!this.mEdgeGlowTop.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth();
        m = this.mPaddingLeft;
        int n = this.mPaddingRight;
        paramCanvas.translate(this.mPaddingLeft, Math.min(0, i));
        this.mEdgeGlowTop.setSize(k - m - n, getHeight());
        if (this.mEdgeGlowTop.draw(paramCanvas))
          postInvalidateOnAnimation();
        paramCanvas.restoreToCount(j);
      }
      if (!this.mEdgeGlowBottom.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth() - this.mPaddingLeft - this.mPaddingRight;
        m = getHeight();
        paramCanvas.translate(-k + this.mPaddingLeft, Math.max(getScrollRange(), i) + m);
        paramCanvas.rotate(180.0F, k, 0.0F);
        this.mEdgeGlowBottom.setSize(k, m);
        if (this.mEdgeGlowBottom.draw(paramCanvas))
          postInvalidateOnAnimation();
        paramCanvas.restoreToCount(j);
      }
    }
  }

  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    this.mTempRect.setEmpty();
    if (!canScroll())
    {
      bool1 = bool2;
      if (isFocused())
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 4)
        {
          View localView = findFocus();
          paramKeyEvent = localView;
          if (localView == this)
            paramKeyEvent = null;
          paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            bool1 = bool2;
            if (paramKeyEvent != this)
            {
              bool1 = bool2;
              if (paramKeyEvent.requestFocus(130))
                bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    bool2 = false;
    boolean bool1 = bool2;
    if (paramKeyEvent.getAction() == 0);
    switch (paramKeyEvent.getKeyCode())
    {
    default:
      bool1 = bool2;
    case 19:
    case 20:
      while (true)
      {
        return bool1;
        if (!paramKeyEvent.isAltPressed())
        {
          bool1 = arrowScroll(33);
        }
        else
        {
          bool1 = fullScroll(33);
          continue;
          if (!paramKeyEvent.isAltPressed())
            bool1 = arrowScroll(130);
          else
            bool1 = fullScroll(130);
        }
      }
    case 62:
    }
    if (paramKeyEvent.isShiftPressed());
    for (int i = 33; ; i = 130)
    {
      pageScroll(i);
      bool1 = bool2;
      break;
    }
  }

  public void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      int i = getHeight() - this.mPaddingBottom - this.mPaddingTop;
      int j = getChildAt(0).getHeight();
      this.mScroller.fling(this.mScrollX, this.mScrollY, 0, paramInt, 0, 0, 0, Math.max(0, j - i), 0, i / 2);
      if (this.mFlingStrictSpan == null)
        this.mFlingStrictSpan = StrictMode.enterCriticalSpan("ScrollView-fling");
      postInvalidateOnAnimation();
    }
  }

  public boolean fullScroll(int paramInt)
  {
    if (paramInt == 130);
    for (int i = 1; ; i = 0)
    {
      int j = getHeight();
      this.mTempRect.top = 0;
      this.mTempRect.bottom = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          View localView = getChildAt(i - 1);
          this.mTempRect.bottom = (localView.getBottom() + this.mPaddingBottom);
          this.mTempRect.top = (this.mTempRect.bottom - j);
        }
      }
      return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
    }
  }

  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0)
      return 0.0F;
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = this.mPaddingBottom;
    j = getChildAt(0).getBottom() - this.mScrollY - (j - k);
    if (j < i)
      return j / i;
    return 1.0F;
  }

  public int getMaxScrollAmount()
  {
    return (int)(0.5F * (this.mBottom - this.mTop));
  }

  protected int getScrollRange()
  {
    int i = 0;
    if (getChildCount() > 0)
      i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - this.mPaddingBottom - this.mPaddingTop));
    return i;
  }

  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0)
      return 0.0F;
    int i = getVerticalFadingEdgeLength();
    if (this.mScrollY < i)
      return this.mScrollY / i;
    return 1.0F;
  }

  public boolean isFillViewport()
  {
    return this.mFillViewport;
  }

  public boolean isSmoothScrollingEnabled()
  {
    return this.mSmoothScrollingEnabled;
  }

  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight, localLayoutParams.width), MeasureSpec.makeMeasureSpec(0, 0));
  }

  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    MarginLayoutParams localMarginLayoutParams = (MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width), MeasureSpec.makeMeasureSpec(localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin, 0));
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mScrollStrictSpan != null)
    {
      this.mScrollStrictSpan.finish();
      this.mScrollStrictSpan = null;
    }
    if (this.mFlingStrictSpan != null)
    {
      this.mFlingStrictSpan.finish();
      this.mFlingStrictSpan = null;
    }
  }

  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0)
      switch (paramMotionEvent.getAction())
      {
      default:
      case 8:
      }
    while (true)
    {
      return super.onGenericMotionEvent(paramMotionEvent);
      if (!this.mIsBeingDragged)
      {
        float f = paramMotionEvent.getAxisValue(9);
        if (f != 0.0F)
        {
          int i = (int)(getVerticalScrollFactor() * f);
          int j = getScrollRange();
          int m = this.mScrollY;
          int k = m - i;
          if (k < 0)
            i = 0;
          while (i != m)
          {
            super.scrollTo(this.mScrollX, i);
            return true;
            i = k;
            if (k > j)
              i = j;
          }
        }
      }
    }
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(OppoScrollView.class.getName());
    if (getScrollRange() > 0);
    for (boolean bool = true; ; bool = false)
    {
      paramAccessibilityEvent.setScrollable(bool);
      paramAccessibilityEvent.setScrollX(this.mScrollX);
      paramAccessibilityEvent.setScrollY(this.mScrollY);
      paramAccessibilityEvent.setMaxScrollX(this.mScrollX);
      paramAccessibilityEvent.setMaxScrollY(getScrollRange());
      return;
    }
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(OppoScrollView.class.getName());
    if (isEnabled())
    {
      int i = getScrollRange();
      if (i > 0)
      {
        paramAccessibilityNodeInfo.setScrollable(true);
        if (this.mScrollY > 0)
          paramAccessibilityNodeInfo.addAction(8192);
        if (this.mScrollY < i)
          paramAccessibilityNodeInfo.addAction(4096);
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((paramMotionEvent.getAction() == 2) && (this.mIsBeingDragged))
      return true;
    if ((getScrollY() == 0) && (!canScrollVertically(1)))
      return false;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4:
    case 5:
    default:
    case 2:
    case 0:
    case 1:
    case 3:
    case 6:
    }
    while (true)
    {
      return this.mIsBeingDragged;
      int i = this.mActivePointerId;
      if (i != -1)
      {
        int j = paramMotionEvent.findPointerIndex(i);
        if (j == -1)
        {
          Log.e("ScrollView", "Invalid pointerId=" + i + " in onInterceptTouchEvent");
        }
        else
        {
          i = (int)paramMotionEvent.getY(j);
          if (Math.abs(i - this.mLastMotionY) > this.mTouchSlop)
          {
            this.mIsBeingDragged = true;
            this.mLastMotionY = i;
            initVelocityTrackerIfNotExists();
            this.mVelocityTracker.addMovement(paramMotionEvent);
            if (this.mScrollStrictSpan == null)
              this.mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
            paramMotionEvent = getParent();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              continue;
              i = (int)paramMotionEvent.getY();
              if (!inChild((int)paramMotionEvent.getX(), i))
              {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
              }
              else
              {
                this.mLastMotionY = i;
                this.mActivePointerId = paramMotionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(paramMotionEvent);
                if (!this.mScroller.isFinished());
                while (true)
                {
                  this.mIsBeingDragged = bool;
                  if ((!this.mIsBeingDragged) || (this.mScrollStrictSpan != null))
                    break;
                  this.mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
                  break;
                  bool = false;
                }
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                recycleVelocityTracker();
                continue;
                onSecondaryPointerUp(paramMotionEvent);
              }
            }
          }
        }
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mIsLayoutDirty = false;
    if ((this.mChildToScrollTo != null) && (isViewDescendantOf(this.mChildToScrollTo, this)))
      scrollToChild(this.mChildToScrollTo);
    this.mChildToScrollTo = null;
    scrollTo(this.mScrollX, this.mScrollY);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.mFillViewport);
    View localView;
    do
    {
      do
        return;
      while ((MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    }
    while (localView.getMeasuredHeight() >= paramInt2);
    LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, this.mPaddingLeft + this.mPaddingRight, localLayoutParams.width), MeasureSpec.makeMeasureSpec(paramInt2 - this.mPaddingTop - this.mPaddingBottom, 1073741824));
  }

  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.mScroller.isFinished())
    {
      this.mScrollX = paramInt1;
      this.mScrollY = paramInt2;
      invalidateParentIfNeeded();
      if (!paramBoolean2);
    }
    while (true)
    {
      awakenScrollBars();
      return;
      super.scrollTo(paramInt1, paramInt2);
    }
  }

  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    View localView;
    if (paramInt == 2)
    {
      i = 130;
      if (paramRect != null)
        break label46;
      localView = FocusFinder.getInstance().findNextFocus(this, null, i);
      label25: if (localView != null)
        break label60;
    }
    label46: label60: 
    while (isOffScreen(localView))
    {
      return false;
      i = paramInt;
      if (paramInt != 1)
        break;
      i = 33;
      break;
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
      break label25;
    }
    return localView.requestFocus(i, paramRect);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView));
    while (!isWithinDeltaOfScreen(localView, 0, paramInt4))
      return;
    localView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(localView, this.mTempRect);
    doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    initVelocityTrackerIfNotExists();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    case 4:
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      return true;
      if (getChildCount() == 0)
        return false;
      if (!this.mScroller.isFinished());
      for (boolean bool = true; ; bool = false)
      {
        this.mIsBeingDragged = bool;
        if (bool)
        {
          ViewParent localViewParent = getParent();
          if (localViewParent != null)
            localViewParent.requestDisallowInterceptTouchEvent(true);
        }
        if (!this.mScroller.isFinished())
        {
          this.mScroller.abortAnimation();
          if (this.mFlingStrictSpan != null)
          {
            this.mFlingStrictSpan.finish();
            this.mFlingStrictSpan = null;
          }
        }
        this.mLastMotionY = ((int)paramMotionEvent.getY());
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        break;
      }
      int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i == -1)
      {
        Log.e("ScrollView", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
      }
      else
      {
        int k = (int)paramMotionEvent.getY(i);
        int j = this.mLastMotionY - k;
        i = j;
        if (!this.mIsBeingDragged)
        {
          i = j;
          if (Math.abs(j) > this.mTouchSlop)
          {
            paramMotionEvent = getParent();
            if (paramMotionEvent != null)
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            this.mIsBeingDragged = true;
            if (j <= 0)
              break label486;
            i = j - this.mTouchSlop;
          }
        }
        label302: if (this.mIsBeingDragged)
        {
          this.mLastMotionY = k;
          int m = this.mScrollX;
          int n = this.mScrollY;
          k = getScrollRange();
          j = getOverScrollMode();
          if ((j == 0) || ((j == 1) && (k > 0)))
          {
            j = 1;
            label358: if (overScrollBy(0, i, 0, this.mScrollY, 0, k, 0, this.mOverscrollDistance, true))
              this.mVelocityTracker.clear();
            onScrollChanged(this.mScrollX, this.mScrollY, m, n);
            if (j != 0)
            {
              j = n + i;
              if (j < 0)
              {
                this.mEdgeGlowTop.onPull(i / getHeight());
                if (!this.mEdgeGlowBottom.isFinished())
                  this.mEdgeGlowBottom.onRelease();
              }
            }
          }
          else
          {
            while ((this.mEdgeGlowTop != null) && ((!this.mEdgeGlowTop.isFinished()) || (!this.mEdgeGlowBottom.isFinished())))
            {
              postInvalidateOnAnimation();
              break;
              label486: i = j + this.mTouchSlop;
              break label302;
              j = 0;
              break label358;
              if (j > k)
              {
                this.mEdgeGlowBottom.onPull(i / getHeight());
                if (!this.mEdgeGlowTop.isFinished())
                  this.mEdgeGlowTop.onRelease();
              }
            }
            if (this.mIsBeingDragged)
            {
              paramMotionEvent = this.mVelocityTracker;
              paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
              i = (int)paramMotionEvent.getYVelocity(this.mActivePointerId);
              if ((getChildCount() > 0) && (Math.abs(i) > this.mMinimumVelocity))
                fling(-i);
              this.mActivePointerId = -1;
              endDrag();
              continue;
              if ((this.mIsBeingDragged) && (getChildCount() > 0))
              {
                this.mActivePointerId = -1;
                endDrag();
                continue;
                i = paramMotionEvent.getActionIndex();
                this.mLastMotionY = ((int)paramMotionEvent.getY(i));
                this.mActivePointerId = paramMotionEvent.getPointerId(i);
                continue;
                onSecondaryPointerUp(paramMotionEvent);
                this.mLastMotionY = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId)));
              }
            }
          }
        }
      }
    }
  }

  public boolean pageScroll(int paramInt)
  {
    int i;
    int j;
    if (paramInt == 130)
    {
      i = 1;
      j = getHeight();
      if (i == 0)
        break label123;
      this.mTempRect.top = (getScrollY() + j);
      i = getChildCount();
      if (i > 0)
      {
        View localView = getChildAt(i - 1);
        if (this.mTempRect.top + j > localView.getBottom())
          this.mTempRect.top = (localView.getBottom() - j);
      }
    }
    while (true)
    {
      this.mTempRect.bottom = (this.mTempRect.top + j);
      return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
      i = 0;
      break;
      label123: this.mTempRect.top = (getScrollY() - j);
      if (this.mTempRect.top < 0)
        this.mTempRect.top = 0;
    }
  }

  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle))
      return true;
    if (!isEnabled())
      return false;
    switch (paramInt)
    {
    default:
      return false;
    case 4096:
      paramInt = getHeight();
      i = this.mPaddingBottom;
      j = this.mPaddingTop;
      paramInt = Math.min(this.mScrollY + (paramInt - i - j), getScrollRange());
      if (paramInt != this.mScrollY)
      {
        smoothScrollTo(0, paramInt);
        return true;
      }
      return false;
    case 8192:
    }
    paramInt = getHeight();
    int i = this.mPaddingBottom;
    int j = this.mPaddingTop;
    paramInt = Math.max(this.mScrollY - (paramInt - i - j), 0);
    if (paramInt != this.mScrollY)
    {
      smoothScrollTo(0, paramInt);
      return true;
    }
    return false;
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.mIsLayoutDirty)
      scrollToChild(paramView2);
    while (true)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.mChildToScrollTo = paramView2;
    }
  }

  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return scrollToChildRect(paramRect, paramBoolean);
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean)
      recycleVelocityTracker();
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }

  public void requestLayout()
  {
    this.mIsLayoutDirty = true;
    super.requestLayout();
  }

  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = clamp(paramInt1, getWidth() - this.mPaddingRight - this.mPaddingLeft, localView.getWidth());
      paramInt2 = clamp(paramInt2, getHeight() - this.mPaddingBottom - this.mPaddingTop, localView.getHeight());
      if ((paramInt1 != this.mScrollX) || (paramInt2 != this.mScrollY))
        super.scrollTo(paramInt1, paramInt2);
    }
  }

  public void setEdgetEffectVisiable(boolean paramBoolean)
  {
    this.mEdgeEffectVisiable = paramBoolean;
    invalidate();
  }

  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.mFillViewport)
    {
      this.mFillViewport = paramBoolean;
      requestLayout();
    }
  }

  public void setOverScrollMode(int paramInt)
  {
    Context localContext;
    if (paramInt != 2)
      if (this.mEdgeGlowTop == null)
      {
        localContext = getContext();
        this.mEdgeGlowTop = new EdgeEffect(localContext);
      }
    for (this.mEdgeGlowBottom = new EdgeEffect(localContext); ; this.mEdgeGlowBottom = null)
    {
      super.setOverScrollMode(paramInt);
      return;
      this.mEdgeGlowTop = null;
    }
  }

  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollingEnabled = paramBoolean;
  }

  public boolean shouldDelayChildPressedState()
  {
    return true;
  }

  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0)
      return;
    if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L)
    {
      paramInt1 = getHeight();
      int i = this.mPaddingBottom;
      int j = this.mPaddingTop;
      i = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i - j));
      paramInt1 = this.mScrollY;
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, i));
      this.mScroller.startScroll(this.mScrollX, paramInt1, 0, paramInt2 - paramInt1);
      postInvalidateOnAnimation();
    }
    while (true)
    {
      this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.mScroller.isFinished())
      {
        this.mScroller.abortAnimation();
        if (this.mFlingStrictSpan != null)
        {
          this.mFlingStrictSpan.finish();
          this.mFlingStrictSpan = null;
        }
      }
      scrollBy(paramInt1, paramInt2);
    }
  }

  public final void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - this.mScrollX, paramInt2 - this.mScrollY);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.widget.OppoScrollView
 * JD-Core Version:    0.6.2
 */