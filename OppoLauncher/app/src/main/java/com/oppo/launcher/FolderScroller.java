package com.oppo.launcher;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import com.oppo.launcher.widget.OppoScrollView;
import java.util.ArrayList;

public class FolderScroller extends OppoScrollView
{
  protected static int DRAG_SCROLL_ANIMATION_DURATION = 0;
  public static int MAX_SHOW_LINE = 0;
  public static final int STATE_SCROLL_CANCEL = 0;
  public static final int STATE_SCROLL_DOWN = 2;
  public static final int STATE_SCROLL_UP = 1;
  private static final String TAG = "FolderScroller";
  protected BaseCellLayout mContent;
  private int mContentHeightGap;
  private int mContentWidthGap;
  ValueAnimator mDragScrollAnimation;
  ValueAnimator mScrollAnimation;
  protected ArrayList<View> mVisibleItems = new ArrayList();
  int yStart = 0;

  public FolderScroller(Context paramContext)
  {
    super(paramContext);
    initLayoutParam();
  }

  public FolderScroller(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initLayoutParam();
  }

  public FolderScroller(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initLayoutParam();
  }

  private void getInvalidateRows(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length < 2)
    {
      Log.e("FolderScroller", "getInvalidateRows -- array length < 2!!!!");
      return;
    }
    int i = getContentCellHeight() + this.mContentHeightGap;
    if (i <= 0)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = 0;
      return;
    }
    paramArrayOfInt[0] = (getScrollY() / i);
    paramArrayOfInt[1] = (paramArrayOfInt[0] + MAX_SHOW_LINE);
  }

  private void initLayoutParam()
  {
    this.mContentWidthGap = getResources().getDimensionPixelSize(2131361839);
    this.mContentHeightGap = getResources().getDimensionPixelSize(2131361840);
  }

  public void cancelDragScroll()
  {
    if (this.mDragScrollAnimation != null)
    {
      this.mDragScrollAnimation.cancel();
      this.mDragScrollAnimation = null;
    }
  }

  public void cancelSmoothScroll()
  {
    if (this.mScrollAnimation != null)
    {
      this.mScrollAnimation.cancel();
      this.mScrollAnimation = null;
    }
  }

  public void checkFolderScrollDirection(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      dragScroll(-getContentCellHeight(), DRAG_SCROLL_ANIMATION_DURATION);
      return;
    case 2:
      dragScroll(getContentCellHeight(), DRAG_SCROLL_ANIMATION_DURATION);
      return;
    case 0:
    }
    cancelDragScroll();
  }

  public void dragScroll(int paramInt1, int paramInt2)
  {
    if ((this.mDragScrollAnimation != null) && (this.mDragScrollAnimation.isStarted()))
      return;
    this.yStart = getScrollY();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, paramInt1 }).setDuration(paramInt2);
    localValueAnimator.setInterpolator(new DecelerateInterpolator(1.0F));
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramAnonymousValueAnimator = (Float)paramAnonymousValueAnimator.getAnimatedValue();
        FolderScroller.this.scrollTo(0, FolderScroller.this.yStart + paramAnonymousValueAnimator.intValue());
      }
    });
    localValueAnimator.addListener(new AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
    this.mDragScrollAnimation = localValueAnimator;
    this.mDragScrollAnimation.start();
  }

  public ArrayList<View> getAndInvalidateVisibleItems()
  {
    this.mVisibleItems.clear();
    Object localObject = new int[2];
    getInvalidateRows((int[])localObject);
    int j = localObject[0];
    int k = localObject[1];
    int m = this.mContent.getCellCountY();
    int i = j;
    if (j >= m)
      i = m - 1;
    j = k;
    if (k >= m)
      j = m - 1;
    while (i <= j)
    {
      k = 0;
      while (k < this.mContent.getCellCountX())
      {
        localObject = this.mContent.getChildAt(k, i);
        if (localObject != null)
        {
          ((View)localObject).invalidate();
          this.mVisibleItems.add(localObject);
        }
        k += 1;
      }
      i += 1;
    }
    return this.mVisibleItems;
  }

  public int getContentCellHeight()
  {
    return this.mContent.getCellHeight();
  }

  public int getDesiredHeight()
  {
    if (this.mContent.getCellCountY() <= MAX_SHOW_LINE)
      return this.mContent.getDesiredHeight() + getPaddingTop() + getPaddingBottom();
    return this.mContent.getDesiredHeight(MAX_SHOW_LINE) + getPaddingTop() + getPaddingBottom();
  }

  public int getDesiredWidth()
  {
    return this.mContent.getDesiredWidth() + getPaddingLeft() + getPaddingRight();
  }

  public int getFirstChildPaddingLeft()
  {
    return getPaddingLeft() + this.mContent.getPaddingLeft();
  }

  public int getFirstChildPaddingTop()
  {
    return getPaddingTop() + this.mContent.getPaddingTop();
  }

  public BaseCellLayout getFolderContent()
  {
    return this.mContent;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mContent = ((BaseCellLayout)findViewById(2131492910));
    this.mContent.setGridSize(0, 0);
    this.mContent.setGap(this.mContentWidthGap, this.mContentHeightGap);
    this.mContent.setMotionEventSplittingEnabled(false);
    setOverScrollMode(2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = MeasureSpec.makeMeasureSpec(this.mContent.getDesiredWidth(), 1073741824);
    int j = MeasureSpec.makeMeasureSpec(this.mContent.getDesiredHeight(), 1073741824);
    this.mContent.measure(i, j);
    setMeasuredDimension(MeasureSpec.getSize(paramInt1), MeasureSpec.getSize(paramInt2));
  }

  public void setContentCellDimension()
  {
    int i = getContext().getResources().getDimensionPixelSize(2131361858);
    int j = Launcher.getCellWidth();
    int k = getResources().getDimensionPixelSize(2131361843);
    this.mContent.setCellDimension(j - i, k);
  }

  public void smoothScroll(final int paramInt1, int paramInt2)
  {
    this.mScrollAnimation = null;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, paramInt1 });
    localValueAnimator.setInterpolator(new DecelerateInterpolator(1.0F));
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramAnonymousValueAnimator = (Float)paramAnonymousValueAnimator.getAnimatedValue();
        FolderScroller.this.scrollTo(0, paramAnonymousValueAnimator.intValue());
      }
    });
    localValueAnimator.addListener(new AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        FolderScroller.this.scrollTo(0, 0);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        FolderScroller.this.scrollTo(0, paramInt1);
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
    localValueAnimator.setDuration(paramInt2);
    localValueAnimator.start();
    this.mScrollAnimation = localValueAnimator;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.FolderScroller
 * JD-Core Version:    0.6.2
 */