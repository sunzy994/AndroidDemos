package com.oppo.launcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.oppo.launcher.screenGrid.ScreenGridUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class BaseCellLayout extends ViewGroup
{
  protected static final boolean DEBUG = false;
  private static final boolean DEBUG_DRAG = false;
  private static final boolean DEBUG_DRAW = false;
  static final boolean DEBUG_MEASURE = false;
  private static final boolean DEBUG_PRESS = false;
  private static final int MAX_CELL_COUNT_Y = 4;
  private static final String TAG = "BaseCellLayout";
  protected ArrayList<BaseTextView.ApplicationRingAnimator> mApplicationRings = new ArrayList();
  protected int mCellCountX;
  protected int mCellCountY;
  protected int mCellHeight;
  protected final CellInfo mCellInfo = new CellInfo();
  protected int mCellWidth;
  protected final Point mDragCenter = new Point();
  protected boolean mDragging = false;
  protected int[] mFolderLeaveBehindCell = { -1, -1 };
  protected int mFolderLeftMargin = 0;
  protected ArrayList<BaseFolderIcon.FolderRingAnimator> mFolderOuterRings = new ArrayList();
  protected int mFolderTopMargin = 0;
  protected int mForegroundAlpha = 0;
  protected int mHeightGap;
  protected OnTouchListener mInterceptTouchListener;
  protected boolean mIsDragOverlapping = false;
  protected boolean mLastDownOnOccupiedCell = false;
  protected Launcher mLauncher = null;
  protected int mMaxGap;
  protected boolean[][] mOccupied;
  protected int mOriginalCellHeight;
  protected int mOriginalCellWidth;
  protected int mOriginalHeightGap;
  protected int mOriginalWidthGap;
  protected final Rect mRect = new Rect();
  protected HashMap<LayoutParams, Animator> mReorderAnimators = new HashMap();
  protected boolean mScrollingTransformsDirty = false;
  protected int[] mTempLocation = new int[2];
  protected boolean[][] mTmpOccupied;
  protected final int[] mTmpPoint = new int[2];
  protected final PointF mTmpPointF = new PointF();
  protected final int[] mTmpXY = new int[2];
  protected int mWidthGap;
  protected Workspace mWorkspace = null;

  public BaseCellLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public BaseCellLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BaseCellLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mLauncher = ((Launcher)paramContext);
    if (this.mLauncher != null)
      this.mWorkspace = this.mLauncher.getWorkspace();
    setDescendantFocusability(393216);
  }

  public static boolean findFirstEmptyCell(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean[][] paramArrayOfBoolean)
  {
    int j = 0;
    while (j < paramInt4)
    {
      int k = 0;
      if (k < paramInt3)
      {
        if ((paramArrayOfBoolean[k][j] != 0) || (k > paramInt3 - paramInt1) || (j > paramInt4 - paramInt2));
        int i;
        do
        {
          k += 1;
          break;
          i = 1;
          int m = k;
          while ((m < k + paramInt1) && (k < paramInt3) && (i != 0))
          {
            int n = j;
            if ((n < j + paramInt2) && (j < paramInt4) && (i != 0))
            {
              if ((m < paramInt3) && (n < paramInt4))
                if ((i != 0) && (paramArrayOfBoolean[m][n] == 0))
                  i = 1;
              while (true)
              {
                n += 1;
                break;
                i = 0;
                continue;
                i = 0;
              }
            }
            m += 1;
          }
        }
        while (i == 0);
        paramArrayOfInt[0] = k;
        paramArrayOfInt[1] = j;
        return true;
      }
      j += 1;
    }
    return false;
  }

  public static boolean findVacantCell(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean[][] paramArrayOfBoolean)
  {
    int j = 0;
    while (j < paramInt4)
    {
      int k = 0;
      while (k < paramInt3)
      {
        int i;
        int m;
        if (paramArrayOfBoolean[k][j] == 0)
        {
          i = 1;
          m = k;
        }
        while (true)
        {
          int n = i;
          if (m < k + paramInt1 - 1)
          {
            n = i;
            if (k < paramInt3)
              n = j;
          }
          while (true)
          {
            if ((n >= j + paramInt2 - 1) || (j >= paramInt4))
              break label150;
            if ((i != 0) && (paramArrayOfBoolean[m][n] == 0));
            for (i = 1; ; i = 0)
            {
              if (i != 0)
                break label141;
              n = i;
              if (n == 0)
                break label159;
              paramArrayOfInt[0] = k;
              paramArrayOfInt[1] = j;
              return true;
              i = 0;
              break;
            }
            label141: n += 1;
          }
          label150: m += 1;
        }
        label159: k += 1;
      }
      j += 1;
    }
    return false;
  }

  private void markCellsForView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = paramInt1;
    while ((i < paramInt1 + paramInt3) && (i < this.mCellCountX))
    {
      int j = paramInt2;
      while ((j < paramInt2 + paramInt4) && (j < this.mCellCountY))
      {
        this.mOccupied[i][j] = paramBoolean;
        j += 1;
      }
      i += 1;
    }
  }

  public boolean addViewToCellLayout(View paramView, int paramInt1, int paramInt2, LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return addViewToCellLayout(paramView, paramInt1, paramInt2, paramLayoutParams, paramBoolean, true);
  }

  public boolean addViewToCellLayout(View paramView, int paramInt1, int paramInt2, LayoutParams paramLayoutParams, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramLayoutParams.cellX >= 0) && (paramLayoutParams.cellX <= this.mCellCountX - 1) && (paramLayoutParams.cellY >= 0) && (paramLayoutParams.cellY <= this.mCellCountY - 1))
    {
      if (paramLayoutParams.cellHSpan < 0)
        paramLayoutParams.cellHSpan = this.mCellCountX;
      if (paramLayoutParams.cellVSpan < 0)
        paramLayoutParams.cellVSpan = this.mCellCountY;
      paramView.setId(paramInt2);
      addView(paramView, paramInt1, paramLayoutParams);
      if (paramBoolean1)
        markCellsAsOccupiedForView(paramView);
      return true;
    }
    return false;
  }

  public boolean animateChildToPosition(final View paramView, final int paramInt1, final int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((paramInt1 >= this.mCellCountX) || (paramInt2 >= this.mCellCountY))
    {
      Log.w("BaseCellLayout", "animateChildToPosition --- cellX = " + paramInt1 + ", mCellCountX = " + this.mCellCountX + ", cellY = " + paramInt2 + ", mCellCountY = " + this.mCellCountY);
      return false;
    }
    if ((paramBoolean) && (this.mOccupied[paramInt1][paramInt2] != 0))
      return false;
    if (indexOfChild(paramView) != -1)
    {
      final LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (this.mReorderAnimators.containsKey(localLayoutParams))
      {
        ((Animator)this.mReorderAnimators.get(localLayoutParams)).cancel();
        this.mReorderAnimators.remove(localLayoutParams);
      }
      final int i = localLayoutParams.x;
      final int j = localLayoutParams.y;
      if ((paramBoolean) && (this.mOccupied[paramInt1][paramInt2] == 0))
      {
        this.mOccupied[localLayoutParams.cellX][localLayoutParams.cellY] = 0;
        this.mOccupied[paramInt1][paramInt2] = 1;
      }
      localLayoutParams.isLockedToGrid = true;
      localLayoutParams.tmpCellX = paramInt1;
      localLayoutParams.cellX = paramInt1;
      localLayoutParams.tmpCellY = paramInt2;
      localLayoutParams.cellY = paramInt2;
      setupLp(localLayoutParams);
      localLayoutParams.isLockedToGrid = false;
      paramInt1 = localLayoutParams.x;
      paramInt2 = localLayoutParams.y;
      localLayoutParams.x = i;
      localLayoutParams.y = j;
      paramView.requestLayout();
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator.setDuration(paramInt3);
      this.mReorderAnimators.put(localLayoutParams, localValueAnimator);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          localLayoutParams.x = ((int)((1.0F - f) * i + paramInt1 * f));
          localLayoutParams.y = ((int)((1.0F - f) * j + paramInt2 * f));
          paramView.requestLayout();
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        boolean cancelled = false;

        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.cancelled = true;
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!this.cancelled)
          {
            localLayoutParams.isLockedToGrid = true;
            paramView.requestLayout();
          }
          if (BaseCellLayout.this.mReorderAnimators.containsKey(localLayoutParams))
            BaseCellLayout.this.mReorderAnimators.remove(localLayoutParams);
        }
      });
      localValueAnimator.setStartDelay(paramInt4);
      localValueAnimator.start();
      return true;
    }
    return false;
  }

  public boolean animateChildToPosition(final View paramView, final int paramInt1, final int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.mOccupied;
    if (!paramBoolean1)
      localObject = this.mTmpOccupied;
    if (indexOfChild(paramView) != -1)
    {
      final LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      ItemInfo localItemInfo = (ItemInfo)paramView.getTag();
      if ((!paramBoolean1) && (paramInt1 == localLayoutParams.tmpCellX) && (paramInt2 == localLayoutParams.tmpCellY))
        return true;
      if (this.mReorderAnimators.containsKey(localLayoutParams))
      {
        ((Animator)this.mReorderAnimators.get(localLayoutParams)).cancel();
        this.mReorderAnimators.remove(localLayoutParams);
      }
      final int i = localLayoutParams.x;
      final int j = localLayoutParams.y;
      if (paramBoolean2)
      {
        localObject[localLayoutParams.cellX][localLayoutParams.cellY] = 0;
        localObject[paramInt1][paramInt2] = 1;
      }
      localLayoutParams.isLockedToGrid = true;
      if (paramBoolean1)
      {
        localItemInfo.cellX = paramInt1;
        localLayoutParams.cellX = paramInt1;
        localItemInfo.cellY = paramInt2;
        localLayoutParams.cellY = paramInt2;
      }
      localLayoutParams.tmpCellX = paramInt1;
      localLayoutParams.tmpCellY = paramInt2;
      setupLp(localLayoutParams);
      localLayoutParams.isLockedToGrid = false;
      paramInt1 = localLayoutParams.x;
      paramInt2 = localLayoutParams.y;
      localLayoutParams.x = i;
      localLayoutParams.y = j;
      if ((i == paramInt1) && (j == paramInt2))
      {
        localLayoutParams.isLockedToGrid = true;
        return true;
      }
      localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(paramInt3);
      this.mReorderAnimators.put(localLayoutParams, localObject);
      ((ValueAnimator)localObject).addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          localLayoutParams.x = ((int)((1.0F - f) * i + paramInt1 * f));
          localLayoutParams.y = ((int)((1.0F - f) * j + paramInt2 * f));
          paramView.requestLayout();
        }
      });
      ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
      {
        boolean cancelled = false;

        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.cancelled = true;
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!this.cancelled)
          {
            localLayoutParams.isLockedToGrid = true;
            paramView.requestLayout();
          }
          if (BaseCellLayout.this.mReorderAnimators.containsKey(localLayoutParams))
            BaseCellLayout.this.mReorderAnimators.remove(localLayoutParams);
        }
      });
      ((ValueAnimator)localObject).setStartDelay(paramInt4);
      ((ValueAnimator)localObject).start();
      return true;
    }
    return false;
  }

  public void cancelLongPress()
  {
    super.cancelLongPress();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).cancelLongPress();
      i += 1;
    }
  }

  public void cancleAnimation()
  {
    Iterator localIterator = this.mReorderAnimators.keySet().iterator();
    while (localIterator.hasNext())
    {
      LayoutParams localLayoutParams = (LayoutParams)localIterator.next();
      ((Animator)this.mReorderAnimators.get(localLayoutParams)).cancel();
    }
  }

  public void cellToCenterPoint(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    paramArrayOfInt[0] = ((this.mCellWidth + this.mWidthGap) * paramInt1 + i + this.mCellWidth / 2);
    paramArrayOfInt[1] = ((this.mCellHeight + this.mHeightGap) * paramInt2 + j + this.mCellHeight / 2);
  }

  void cellToPoint(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    paramArrayOfInt[0] = ((this.mCellWidth + this.mWidthGap) * paramInt1 + i);
    paramArrayOfInt[1] = ((this.mCellHeight + this.mHeightGap) * paramInt2 + j);
  }

  public void cellToRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, RectF paramRectF)
  {
    int i = this.mCellWidth;
    int j = this.mCellHeight;
    int k = this.mWidthGap;
    int m = this.mHeightGap;
    int i1 = getPaddingLeft();
    int n = getPaddingTop();
    paramInt1 = i1 + (i + k) * paramInt1;
    paramInt2 = n + (j + m) * paramInt2;
    paramRectF.set(paramInt1, paramInt2, paramInt1 + (paramInt3 * i + (paramInt3 - 1) * k), paramInt2 + (paramInt4 * j + (paramInt4 - 1) * m));
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }

  public void clearFolderLeaveBehind()
  {
    this.mFolderLeaveBehindCell[0] = -1;
    this.mFolderLeaveBehindCell[1] = -1;
    invalidate();
  }

  public void clearOccupiedCells()
  {
    int i = 0;
    while (i < this.mCellCountX)
    {
      int j = 0;
      while (j < this.mCellCountY)
      {
        this.mOccupied[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }

  protected void clearTagCellInfo()
  {
    CellInfo localCellInfo = this.mCellInfo;
    localCellInfo.cell = null;
    localCellInfo.cellX = -1;
    localCellInfo.cellY = -1;
    localCellInfo.spanX = 0;
    localCellInfo.spanY = 0;
    setTag(localCellInfo);
  }

  public void destroyAllChildrenDrawingCache()
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      Object localObject = getChildAt(i);
      ((View)localObject).setTag(null);
      ((View)localObject).destroyDrawingCache();
      if ((localObject instanceof TextView))
      {
        localObject = ((TextView)localObject).getCompoundDrawables();
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          if (localObject[j] != null)
            localObject[j].setCallback(null);
          j += 1;
        }
      }
      i += 1;
    }
  }

  public void drawApplicationAnimation(Canvas paramCanvas)
  {
    Iterator localIterator = this.mApplicationRings.iterator();
    while (true)
    {
      BaseTextView.ApplicationRingAnimator localApplicationRingAnimator;
      Drawable localDrawable;
      if (localIterator.hasNext())
      {
        localApplicationRingAnimator = (BaseTextView.ApplicationRingAnimator)localIterator.next();
        localDrawable = localApplicationRingAnimator.getDrawable();
        if (localDrawable != null);
      }
      else
      {
        return;
      }
      int i = (int)localApplicationRingAnimator.getTargetWidth();
      int j = (int)localApplicationRingAnimator.getTargetHeight();
      cellToPoint(localApplicationRingAnimator.mCellX, localApplicationRingAnimator.mCellY, this.mTempLocation);
      paramCanvas.save();
      int k = this.mTempLocation[0];
      int m = (this.mCellWidth - localApplicationRingAnimator.getDrawableWidth()) / 2;
      int n = (int)localApplicationRingAnimator.getOffset();
      int i1 = this.mTempLocation[1];
      int i2 = (int)localApplicationRingAnimator.getOffset();
      int i3 = this.mFolderTopMargin;
      int i4 = BaseFolderIcon.FolderRingAnimator.sPreviewTopPadding;
      paramCanvas.save();
      paramCanvas.translate(k + m + n, i1 + i2 + i3 + i4);
      paramCanvas.scale(i / localApplicationRingAnimator.getWidth(), j / localApplicationRingAnimator.getHeight());
      localDrawable.setBounds(0, 0, i, j);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }

  public void drawFolderAnimation(Canvas paramCanvas)
  {
    int k = Utilities.getIconWidth();
    int i = k;
    Object localObject = this.mFolderOuterRings.iterator();
    int j = i;
    while (((Iterator)localObject).hasNext())
    {
      BaseFolderIcon.FolderRingAnimator localFolderRingAnimator = (BaseFolderIcon.FolderRingAnimator)((Iterator)localObject).next();
      Drawable localDrawable = localFolderRingAnimator.getSharedInnerRingDrawable();
      cellToPoint(localFolderRingAnimator.mCellX, localFolderRingAnimator.mCellY, this.mTempLocation);
      i = (int)localFolderRingAnimator.getOuterRingSize();
      j = i;
      k = this.mTempLocation[0];
      int m = this.mCellWidth / 2;
      int n = this.mFolderLeftMargin;
      int i1 = this.mTempLocation[1];
      int i2 = BaseFolderIcon.FolderRingAnimator.sPreviewSize / 2;
      int i3 = this.mFolderTopMargin;
      int i4 = BaseFolderIcon.FolderRingAnimator.sPreviewTopPadding;
      paramCanvas.save();
      paramCanvas.translate(k + m - n - i / 2, i1 + i2 + i3 + i4 - j / 2);
      localDrawable.setBounds(0, 0, i, j);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      k = i;
    }
    if ((this.mFolderLeaveBehindCell[0] >= 0) && (this.mFolderLeaveBehindCell[1] >= 0))
    {
      localObject = FolderIcon.sSharedFolderLeaveBehind;
      cellToPoint(this.mFolderLeaveBehindCell[0], this.mFolderLeaveBehindCell[1], this.mTempLocation);
      paramCanvas.save();
      ((Drawable)localObject).setBounds(0, 0, k, j);
      ((Drawable)localObject).draw(paramCanvas);
      paramCanvas.restore();
    }
  }

  public boolean findCellForSpan(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return findCellForSpanThatIntersectsIgnoring(paramArrayOfInt, paramInt1, paramInt2, -1, -1, null);
  }

  public boolean findCellForSpanIgnoring(int[] paramArrayOfInt, int paramInt1, int paramInt2, View paramView)
  {
    return findCellForSpanThatIntersectsIgnoring(paramArrayOfInt, paramInt1, paramInt2, -1, -1, paramView);
  }

  public boolean findCellForSpanThatIntersects(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return findCellForSpanThatIntersectsIgnoring(paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }

  public boolean findCellForSpanThatIntersectsIgnoring(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    markCellsAsUnoccupiedForView(paramView);
    boolean bool1 = false;
    int j = paramInt4;
    int i = paramInt3;
    while (true)
    {
      paramInt3 = 0;
      if (i >= 0)
        paramInt3 = Math.max(0, i - (paramInt1 - 1));
      int m = this.mCellCountX - (paramInt1 - 1);
      int k = m;
      int n;
      if (i >= 0)
      {
        if (paramInt1 == 1)
        {
          paramInt4 = 1;
          k = Math.min(m, paramInt4 + (i + (paramInt1 - 1)));
        }
      }
      else
      {
        paramInt4 = 0;
        if (j >= 0)
          paramInt4 = Math.max(0, j - (paramInt2 - 1));
        n = this.mCellCountY - (paramInt2 - 1);
        m = n;
        if (j >= 0)
        {
          if (paramInt2 != 1)
            break label225;
          m = 1;
          label127: m = Math.min(n, m + (j + (paramInt2 - 1)));
        }
      }
      while (true)
      {
        if ((paramInt4 >= m) || (bool1))
          break label279;
        n = paramInt3;
        label159: boolean bool2 = bool1;
        if (n < k)
        {
          int i1 = 0;
          while (true)
          {
            if (i1 >= paramInt1)
              break label249;
            int i2 = 0;
            while (true)
            {
              if (i2 >= paramInt2)
                break label240;
              if (this.mOccupied[(n + i1)][(paramInt4 + i2)] != 0)
              {
                n = n + i1 + 1;
                break label159;
                paramInt4 = 0;
                break;
                label225: m = 0;
                break label127;
              }
              i2 += 1;
            }
            label240: i1 += 1;
          }
          label249: if (paramArrayOfInt != null)
          {
            paramArrayOfInt[0] = n;
            paramArrayOfInt[1] = paramInt4;
          }
          bool2 = true;
        }
        paramInt4 += 1;
        bool1 = bool2;
      }
      label279: if ((i == -1) && (j == -1))
      {
        markCellsAsOccupiedForView(paramView);
        return bool1;
      }
      i = -1;
      j = -1;
    }
  }

  public int[] findNearestArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return findNearestAreaIngoreOccupiedCells(paramInt1, paramInt2, paramInt3, paramInt4, paramView, paramBoolean, paramArrayOfInt, false);
  }

  public int[] findNearestArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return findNearestArea(paramInt1, paramInt2, paramInt3, paramInt4, null, false, paramArrayOfInt);
  }

  public int[] findNearestAreaIngoreOccupiedCells(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return findNearestAreaIngoreOccupiedCells(paramInt1, paramInt2, paramInt3, paramInt4, paramView, paramBoolean, paramArrayOfInt, true);
  }

  protected int[] findNearestAreaIngoreOccupiedCells(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView, boolean paramBoolean1, int[] paramArrayOfInt, boolean paramBoolean2)
  {
    markCellsAsUnoccupiedForView(paramView);
    int k = (int)(paramInt1 - (this.mCellWidth + this.mWidthGap) * (paramInt3 - 1) / 2.0F);
    int m = (int)(paramInt2 - (this.mCellHeight + this.mHeightGap) * (paramInt4 - 1) / 2.0F);
    double d1;
    int n;
    int i1;
    if (paramArrayOfInt != null)
    {
      paramView = paramArrayOfInt;
      d1 = 1.7976931348623157E+308D;
      n = this.mCellCountX;
      i1 = this.mCellCountY;
      if (paramBoolean2)
        break label182;
      paramArrayOfInt = this.mOccupied;
      label88: paramInt2 = 0;
    }
    while (true)
    {
      if (paramInt2 >= i1 - (paramInt4 - 1))
        break label317;
      paramInt1 = 0;
      label103: if (paramInt1 < n - (paramInt3 - 1))
      {
        int i;
        label121: int j;
        double d2;
        if (paramBoolean1)
        {
          i = 0;
          if (i < paramInt3)
          {
            j = 0;
            if (j < paramInt4)
              if (paramArrayOfInt[(paramInt1 + i)][(paramInt2 + j)] != 0)
              {
                i = paramInt1 + i;
                d2 = d1;
              }
          }
        }
        while (true)
        {
          paramInt1 = i + 1;
          d1 = d2;
          break label103;
          paramView = new int[2];
          break;
          paramArrayOfInt = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { n, i1 });
          break label88;
          j += 1;
          break label130;
          i += 1;
          break label121;
          int[] arrayOfInt = this.mTmpXY;
          cellToCenterPoint(paramInt1, paramInt2, arrayOfInt);
          double d3 = Math.sqrt(Math.pow(arrayOfInt[0] - k, 2.0D) + Math.pow(arrayOfInt[1] - m, 2.0D));
          d2 = d1;
          i = paramInt1;
          if (d3 <= d1)
          {
            d2 = d3;
            paramView[0] = paramInt1;
            paramView[1] = paramInt2;
            i = paramInt1;
          }
        }
      }
      label130: label182: paramInt2 += 1;
    }
    label317: if (d1 == 1.7976931348623157E+308D)
    {
      paramView[0] = -1;
      paramView[1] = -1;
    }
    return paramView;
  }

  public int[] findNearestVacantArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView, int[] paramArrayOfInt)
  {
    return findNearestArea(paramInt1, paramInt2, paramInt3, paramInt4, paramView, true, paramArrayOfInt);
  }

  public int[] findNearestVacantArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return findNearestVacantArea(paramInt1, paramInt2, paramInt3, paramInt4, null, paramArrayOfInt);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }

  public int getCellCountX()
  {
    return this.mCellCountX;
  }

  public int getCellCountY()
  {
    return this.mCellCountY;
  }

  public int getCellHeight()
  {
    return this.mCellHeight;
  }

  public int getCellWidth()
  {
    return this.mCellWidth;
  }

  public View getChildAt(int paramInt1, int paramInt2)
  {
    return null;
  }

  public View getChildAt(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (paramBoolean)
      {
        if ((localLayoutParams.cellX > paramInt1) || (paramInt1 >= localLayoutParams.cellX + localLayoutParams.cellHSpan) || (localLayoutParams.cellY > paramInt2) || (paramInt2 >= localLayoutParams.cellY + localLayoutParams.cellVSpan));
      }
      else
        while ((localLayoutParams.cellX == paramInt1) && (localLayoutParams.cellY == paramInt2))
          return localView;
      i += 1;
    }
    return null;
  }

  public View getChildAtPosition(int paramInt)
  {
    return getChildAt(paramInt % this.mCellCountX, paramInt / this.mCellCountX);
  }

  public int getChildCountOnPage()
  {
    return getChildCount();
  }

  public View getChildOnPageAt(int paramInt)
  {
    return getChildAt(paramInt);
  }

  public int getDesiredHeight()
  {
    if (this.mCellHeight < 0)
      this.mCellHeight = Launcher.getCellHeight();
    return getPaddingTop() + getPaddingBottom() + this.mCellCountY * this.mCellHeight + Math.max(this.mCellCountY - 1, 0) * this.mHeightGap;
  }

  public int getDesiredHeight(int paramInt)
  {
    return getPaddingTop() + getPaddingBottom() + this.mCellHeight * paramInt + Math.max(paramInt - 1, 0) * this.mHeightGap;
  }

  public int getDesiredWidth()
  {
    if (this.mCellWidth < 0)
      this.mCellWidth = Launcher.getCellWidth();
    return getPaddingLeft() + getPaddingRight() + this.mCellCountX * this.mCellWidth + Math.max(this.mCellCountX - 1, 0) * this.mWidthGap;
  }

  public List<Point> getEmptyCells()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mCellCountY)
    {
      int j = 0;
      if (j < this.mCellCountX)
      {
        if (this.mOccupied[j][i] != 0);
        while (true)
        {
          j += 1;
          break;
          localArrayList.add(new Point(j, i));
        }
      }
      i += 1;
    }
    return localArrayList;
  }

  public boolean getFirstEmptyCell(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return findFirstEmptyCell(paramArrayOfInt, paramInt1, paramInt2, this.mCellCountX, this.mCellCountY, this.mOccupied);
  }

  public int getHeightGap()
  {
    return this.mHeightGap;
  }

  public View getIconAt(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof AppWidgetHostView));
      LayoutParams localLayoutParams;
      do
      {
        i += 1;
        break;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
      }
      while ((localLayoutParams.cellX != paramInt1) || (localLayoutParams.cellY != paramInt2));
      return localView;
    }
    return null;
  }

  public boolean getIsDragOverlapping()
  {
    return this.mIsDragOverlapping;
  }

  public int getMaxCellCountY()
  {
    return 4;
  }

  public int getPositionYForIndex(int paramInt)
  {
    int i = this.mCellHeight;
    int j = this.mHeightGap;
    int k = getPaddingTop();
    return (i + j) * (paramInt / this.mCellCountX) + k - getPaddingTop();
  }

  public int getPositionYForRows(int paramInt)
  {
    return (this.mCellHeight + this.mHeightGap) * paramInt + getPaddingTop() - getPaddingTop();
  }

  public CellInfo getTag()
  {
    return (CellInfo)super.getTag();
  }

  public boolean getVacantCell(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return findVacantCell(paramArrayOfInt, paramInt1, paramInt2, this.mCellCountX, this.mCellCountY, this.mOccupied);
  }

  public int getWidthGap()
  {
    return this.mWidthGap;
  }

  public void hideApplicationChange(BaseTextView.ApplicationRingAnimator paramApplicationRingAnimator)
  {
    if (this.mApplicationRings.contains(paramApplicationRingAnimator))
      this.mApplicationRings.remove(paramApplicationRingAnimator);
    invalidate();
  }

  public void hideFolderAccept(BaseFolderIcon.FolderRingAnimator paramFolderRingAnimator)
  {
    if (this.mFolderOuterRings.contains(paramFolderRingAnimator))
      this.mFolderOuterRings.remove(paramFolderRingAnimator);
    invalidate();
  }

  public int indexOfChildOnPage(View paramView)
  {
    return indexOfChild(paramView);
  }

  public void invalidateChildren()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).invalidate();
      i += 1;
    }
  }

  public boolean isOccupied(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < this.mCellCountX) && (paramInt2 < this.mCellCountY))
      return this.mOccupied[paramInt1][paramInt2];
    throw new RuntimeException("Position exceeds the bound of this CellLayout");
  }

  public boolean lastDownOnOccupiedCell()
  {
    return this.mLastDownOnOccupiedCell;
  }

  public void markCellsAsOccupiedForView(View paramView)
  {
    if (paramView == null)
      return;
    paramView = (LayoutParams)paramView.getLayoutParams();
    markCellsForView(paramView.cellX, paramView.cellY, paramView.cellHSpan, paramView.cellVSpan, true);
  }

  public void markCellsAsUnoccupiedForView(View paramView)
  {
    if (paramView == null)
      return;
    paramView = (LayoutParams)paramView.getLayoutParams();
    markCellsForView(paramView.cellX, paramView.cellY, paramView.cellHSpan, paramView.cellVSpan, false);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (getParent() != null)
      this.mCellInfo.screen = ((ViewGroup)getParent()).indexOfChild(this);
  }

  public void onDragChild(View paramView)
  {
    ((LayoutParams)paramView.getLayoutParams()).isDragging = true;
  }

  public void onDragEnter(DropTarget.DragObject paramDragObject)
  {
    this.mDragging = true;
  }

  public abstract void onDragExit(DropTarget.DragObject paramDragObject, boolean paramBoolean);

  public void onDragOver(DropTarget.DragObject paramDragObject)
  {
  }

  protected void onDropChild(View paramView)
  {
    if (paramView != null)
    {
      ((LayoutParams)paramView.getLayoutParams()).dropped = true;
      paramView.requestLayout();
      markCellsAsOccupiedForView(paramView);
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
      clearTagCellInfo();
    if ((this.mInterceptTouchListener != null) && (this.mInterceptTouchListener.onTouch(this, paramMotionEvent)))
      return true;
    if (i == 0)
      setTagToCellInfoForPoint((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    return false;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt3 = localLayoutParams.x;
        paramInt4 = localLayoutParams.y;
        localView.layout(paramInt3, paramInt4, localLayoutParams.width + paramInt3, localLayoutParams.height + paramInt4);
      }
      paramInt1 += 1;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = MeasureSpec.getMode(paramInt1);
    int i = MeasureSpec.getSize(paramInt1);
    paramInt1 = MeasureSpec.getMode(paramInt2);
    paramInt2 = MeasureSpec.getSize(paramInt2);
    if ((j == 0) || (paramInt1 == 0))
      throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
    if ((this.mCellCountX < 1) || (this.mCellCountY < 1))
      throw new RuntimeException("CellLayout mCellCountX < 1 ||mCellCountY < 1 ");
    paramInt1 = this.mCellCountX - 1;
    int k = this.mCellCountY - 1;
    int i4;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    if ((this.mOriginalWidthGap < 0) && (this.mOriginalHeightGap < 0))
    {
      i4 = getPaddingLeft();
      int i5 = getPaddingRight();
      m = getPaddingTop();
      n = getPaddingBottom();
      int i6 = this.mCellCountX;
      int i7 = this.mOriginalCellWidth;
      i1 = this.mCellCountY;
      i2 = this.mOriginalCellHeight;
      i3 = this.mMaxGap;
      if (paramInt1 > 0)
      {
        paramInt1 = (i - i4 - i5 - i6 * i7) / paramInt1;
        this.mWidthGap = Math.min(i3, paramInt1);
        i3 = this.mMaxGap;
        if (k <= 0)
          break label311;
        paramInt1 = (paramInt2 - m - n - i1 * i2) / k;
        label209: this.mHeightGap = Math.min(i3, paramInt1);
      }
    }
    while (true)
    {
      paramInt1 = i;
      if (j == -2147483648)
      {
        paramInt1 = getPaddingLeft() + getPaddingRight() + this.mCellCountX * this.mCellWidth + (this.mCellCountX - 1) * this.mWidthGap;
        paramInt2 = getPaddingTop() + getPaddingBottom() + this.mCellCountY * this.mCellHeight + (this.mCellCountY - 1) * this.mHeightGap;
        setMeasuredDimension(paramInt1, paramInt2);
      }
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = 0;
      break;
      label311: paramInt1 = 0;
      break label209;
      if ((this.mOriginalCellWidth < 0) && (this.mOriginalCellHeight < 0))
      {
        m = getPaddingLeft();
        n = getPaddingRight();
        i1 = getPaddingTop();
        i2 = getPaddingBottom();
        i3 = this.mOriginalWidthGap;
        i4 = this.mOriginalHeightGap;
        this.mCellWidth = ((i - m - n - i3 * paramInt1) / this.mCellCountX);
        this.mCellHeight = ((paramInt2 - i1 - i2 - i4 * k) / this.mCellCountY);
        if (getPaddingLeft() != 0)
        {
          ScreenGridUtils.setCellWidth(this.mCellWidth);
          ScreenGridUtils.setCellHeight(this.mCellHeight);
        }
      }
      else
      {
        this.mWidthGap = this.mOriginalWidthGap;
        this.mHeightGap = this.mOriginalHeightGap;
        this.mCellWidth = this.mOriginalCellWidth;
        this.mCellHeight = this.mOriginalCellHeight;
      }
    }
  }

  public void onMove(View paramView, int paramInt1, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    markCellsAsUnoccupiedForView(paramView);
    markCellsForView(paramInt1, paramInt2, localLayoutParams.cellHSpan, localLayoutParams.cellVSpan, true);
  }

  void pointToCellExact(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    paramArrayOfInt[0] = ((paramInt1 - i) / (this.mCellWidth + this.mWidthGap));
    paramArrayOfInt[1] = ((paramInt2 - j) / (this.mCellHeight + this.mHeightGap));
    paramInt1 = this.mCellCountX;
    paramInt2 = this.mCellCountY;
    if (paramArrayOfInt[0] < 0)
      paramArrayOfInt[0] = 0;
    if (paramArrayOfInt[0] >= paramInt1)
      paramArrayOfInt[0] = (paramInt1 - 1);
    if (paramArrayOfInt[1] < 0)
      paramArrayOfInt[1] = 0;
    if (paramArrayOfInt[1] >= paramInt2)
      paramArrayOfInt[1] = (paramInt2 - 1);
  }

  public void preOnDrop(DropTarget.DragObject paramDragObject)
  {
  }

  public void removeAllViewsInLayout()
  {
    ArrayList localArrayList = new ArrayList();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof LauncherAppWidgetHostView))
        localArrayList.add((LauncherAppWidgetHostView)localView);
      i += 1;
    }
    clearOccupiedCells();
    super.removeAllViewsInLayout();
    i = 0;
    while (i < localArrayList.size())
    {
      ((LauncherAppWidgetHostView)localArrayList.get(i)).command(2, null, null);
      i += 1;
    }
  }

  public void removeView(View paramView)
  {
    if (paramView == null)
    {
      Log.e("BaseCellLayout", "removeView, null = view,return");
      return;
    }
    markCellsAsUnoccupiedForView(paramView);
    super.removeView(paramView);
  }

  public void removeViewAt(int paramInt)
  {
    if (getChildOnPageAt(paramInt) == null)
      return;
    markCellsAsUnoccupiedForView(getChildAt(paramInt));
    super.removeViewAt(paramInt);
  }

  public void removeViewInLayout(View paramView)
  {
    markCellsAsUnoccupiedForView(paramView);
    super.removeViewInLayout(paramView);
  }

  public void removeViewWithoutMarkingCells(View paramView)
  {
    super.removeView(paramView);
  }

  public void removeViews(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (i < paramInt1 + paramInt2)
    {
      if (getChildOnPageAt(i) == null);
      while (true)
      {
        i += 1;
        break;
        markCellsAsUnoccupiedForView(getChildAt(i));
      }
    }
    super.removeViews(paramInt1, paramInt2);
  }

  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (i < paramInt1 + paramInt2)
    {
      if (getChildOnPageAt(i) == null);
      while (true)
      {
        i += 1;
        break;
        markCellsAsUnoccupiedForView(getChildAt(i));
      }
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if (paramView1 != null)
    {
      paramView2 = new Rect();
      paramView1.getDrawingRect(paramView2);
      requestRectangleOnScreen(paramView2);
    }
  }

  public void setCellDimension(int paramInt1, int paramInt2)
  {
    this.mCellWidth = paramInt1;
    this.mOriginalCellWidth = paramInt1;
    this.mCellHeight = paramInt2;
    this.mOriginalCellHeight = paramInt2;
  }

  protected void setChildrenDrawingCacheEnabled(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setDrawingCacheEnabled(paramBoolean);
      if ((!localView.isHardwareAccelerated()) && (paramBoolean))
        localView.buildDrawingCache(true);
      i += 1;
    }
  }

  public void setFolderLeaveBehindCell(int paramInt1, int paramInt2)
  {
    this.mFolderLeaveBehindCell[0] = paramInt1;
    this.mFolderLeaveBehindCell[1] = paramInt2;
    invalidate();
  }

  public void setGap(int paramInt1, int paramInt2)
  {
    this.mWidthGap = paramInt1;
    this.mOriginalWidthGap = paramInt1;
    this.mHeightGap = paramInt2;
    this.mOriginalHeightGap = paramInt2;
    requestLayout();
  }

  public void setGridSize(int paramInt1, int paramInt2)
  {
    this.mCellCountX = paramInt1;
    this.mCellCountY = paramInt2;
    paramInt1 = this.mCellCountX;
    paramInt2 = this.mCellCountY;
    this.mOccupied = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { paramInt1, paramInt2 }));
    requestLayout();
  }

  public void setIsDragOverlapping(boolean paramBoolean)
  {
    if (this.mIsDragOverlapping != paramBoolean)
    {
      this.mIsDragOverlapping = paramBoolean;
      invalidate();
    }
  }

  public void setOnInterceptTouchListener(OnTouchListener paramOnTouchListener)
  {
    this.mInterceptTouchListener = paramOnTouchListener;
  }

  public void setOverscrollTransformsDirty(boolean paramBoolean)
  {
    this.mScrollingTransformsDirty = paramBoolean;
  }

  public void setPivotX(float paramFloat)
  {
    super.setPivotX(paramFloat);
  }

  public void setPivotY(float paramFloat)
  {
    super.setPivotY(paramFloat);
  }

  public void setRotation(float paramFloat)
  {
    super.setRotation(paramFloat);
  }

  public void setRotationX(float paramFloat)
  {
    super.setRotationX(paramFloat);
  }

  public void setRotationY(float paramFloat)
  {
    super.setRotationY(paramFloat);
  }

  public void setScaleX(float paramFloat)
  {
    super.setScaleX(paramFloat);
  }

  public void setScaleY(float paramFloat)
  {
    super.setScaleY(paramFloat);
  }

  public void setTagToCellInfoForPoint(int paramInt1, int paramInt2)
  {
    CellInfo localCellInfo = this.mCellInfo;
    Object localObject = this.mRect;
    int i = paramInt1 + getScrollX();
    paramInt2 += getScrollY();
    paramInt1 = getChildCount();
    boolean bool2 = false;
    paramInt1 -= 1;
    while (true)
    {
      boolean bool1 = bool2;
      if (paramInt1 >= 0)
      {
        View localView = getChildAt(paramInt1);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (((localView.getVisibility() == 0) || (localView.getAnimation() != null)) && (localLayoutParams.isLockedToGrid))
        {
          localView.getHitRect((Rect)localObject);
          if (((Rect)localObject).contains(i, paramInt2))
          {
            localCellInfo.cell = localView;
            localCellInfo.cellX = localLayoutParams.cellX;
            localCellInfo.cellY = localLayoutParams.cellY;
            localCellInfo.spanX = localLayoutParams.cellHSpan;
            localCellInfo.spanY = localLayoutParams.cellVSpan;
            bool1 = true;
          }
        }
      }
      else
      {
        this.mLastDownOnOccupiedCell = bool1;
        if (!bool1)
        {
          localObject = this.mTmpXY;
          pointToCellExact(i, paramInt2, (int[])localObject);
          localCellInfo.cell = null;
          localCellInfo.cellX = localObject[0];
          localCellInfo.cellY = localObject[1];
          localCellInfo.spanX = 1;
          localCellInfo.spanY = 1;
        }
        setTag(localCellInfo);
        return;
      }
      paramInt1 -= 1;
    }
  }

  public void setTranslationX(float paramFloat)
  {
    super.setTranslationX(paramFloat);
  }

  public void setTranslationY(float paramFloat)
  {
    super.setTranslationY(paramFloat);
  }

  public void setX(float paramFloat)
  {
    super.setX(paramFloat);
  }

  public void setY(float paramFloat)
  {
    super.setY(paramFloat);
  }

  public void setupLp(LayoutParams paramLayoutParams)
  {
    paramLayoutParams.setup(this.mCellWidth, this.mCellHeight, this.mWidthGap, this.mHeightGap, getPaddingLeft(), getPaddingTop());
  }

  public void showApplicationChange(BaseTextView.ApplicationRingAnimator paramApplicationRingAnimator)
  {
    this.mApplicationRings.add(paramApplicationRingAnimator);
  }

  public void showFolderAccept(BaseFolderIcon.FolderRingAnimator paramFolderRingAnimator)
  {
    this.mFolderOuterRings.add(paramFolderRingAnimator);
  }

  public boolean updateAppInfo(ApplicationInfo paramApplicationInfo, boolean paramBoolean)
  {
    return false;
  }

  public static final class CellInfo
    implements Cloneable
  {
    View cell;
    int cellX = -1;
    int cellY = -1;
    long container;
    long pid = -1L;
    int screen;
    int spanX;
    int spanY;

    public CellInfo clone()
    {
      try
      {
        CellInfo localCellInfo = (CellInfo)super.clone();
        return localCellInfo;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        Log.e("BaseCellLayout", "clone --- e = " + localCloneNotSupportedException);
      }
      return null;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Cell[view:");
      if (this.cell == null);
      for (Object localObject = "null"; ; localObject = this.cell.getClass())
        return localObject + ", x:" + this.cellX + ", y:" + this.cellY + ", spanX:" + this.spanX + ", spanY:" + this.spanY + ", screen:" + this.screen + ", container:" + this.container + "]";
    }
  }

  public static class LayoutParams extends MarginLayoutParams
  {
    public boolean canReorder = true;

    @ViewDebug.ExportedProperty
    public int cellHSpan;

    @ViewDebug.ExportedProperty
    public int cellVSpan;

    @ViewDebug.ExportedProperty
    public int cellX;

    @ViewDebug.ExportedProperty
    public int cellY;
    boolean dropped;
    public boolean isDragging;
    public boolean isLockedToGrid = true;
    private Object mTag;
    public int tmpCellX;
    public int tmpCellY;
    public boolean useTmpCoords;

    @ViewDebug.ExportedProperty
    int x;

    @ViewDebug.ExportedProperty
    int y;

    public LayoutParams()
    {
      super(-1);
      this.cellHSpan = 1;
      this.cellVSpan = 1;
    }

    public LayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(-1);
      this.cellX = paramInt1;
      this.cellY = paramInt2;
      this.cellHSpan = paramInt3;
      this.cellVSpan = paramInt4;
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.cellHSpan = 1;
      this.cellVSpan = 1;
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.cellHSpan = 1;
      this.cellVSpan = 1;
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.cellX = paramLayoutParams.cellX;
      this.cellY = paramLayoutParams.cellY;
      this.cellHSpan = paramLayoutParams.cellHSpan;
      this.cellVSpan = paramLayoutParams.cellVSpan;
    }

    public int getHeight()
    {
      return this.height;
    }

    public Object getTag()
    {
      return this.mTag;
    }

    public int getWidth()
    {
      return this.width;
    }

    public int getX()
    {
      return this.x;
    }

    public int getY()
    {
      return this.y;
    }

    public void setHeight(int paramInt)
    {
      this.height = paramInt;
    }

    public void setTag(Object paramObject)
    {
      this.mTag = paramObject;
    }

    public void setWidth(int paramInt)
    {
      this.width = paramInt;
    }

    public void setX(int paramInt)
    {
      this.x = paramInt;
    }

    public void setY(int paramInt)
    {
      this.y = paramInt;
    }

    public void setup(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      int k;
      int m;
      int i;
      if (this.isLockedToGrid)
      {
        k = this.cellHSpan;
        m = this.cellVSpan;
        if (!this.useTmpCoords)
          break label134;
        i = this.tmpCellX;
        if (!this.useTmpCoords)
          break label143;
      }
      label134: label143: for (int j = this.tmpCellY; ; j = this.cellY)
      {
        this.width = (k * paramInt1 + (k - 1) * paramInt3 - this.leftMargin - this.rightMargin);
        this.height = (m * paramInt2 + (m - 1) * paramInt4 - this.topMargin - this.bottomMargin);
        this.x = ((paramInt1 + paramInt3) * i + paramInt5 + this.leftMargin);
        this.y = ((paramInt2 + paramInt4) * j + paramInt6 + this.topMargin);
        return;
        i = this.cellX;
        break;
      }
    }

    public String toString()
    {
      return "(" + this.cellX + ", " + this.cellY + ")";
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.BaseCellLayout
 * JD-Core Version:    0.6.2
 */