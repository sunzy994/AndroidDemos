package com.oppo.launcher;

import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.List;

public class ColorRect extends View
{
  static final boolean DEBUG = false;
  private static final int DRAG_VIEW_ALPHA = 154;
  static final int GAPSIZE = 12;
  static final int LONGPRESSTIME = 600;
  static final int PADDINGSIZE = 2;
  final String TAG = getClass().getName();
  final int TIP_DELAY_SHOW_TIME = 120;
  private CellLayout mCellLayout = null;
  private int mColorPreviewNormal;
  private int mColorPreviewSelected;
  private int mDropPosRectColor = 0;
  private Drawable mErroDrawableBg = null;
  private Drawable mErroDrawableSelectedBg = null;
  int mGapSize = 0;
  private Drawable mHighlightDrawableBg = null;
  private Drawable mHighlightDrawableSelectBg = null;
  boolean mIsEnter = false;
  boolean mIsFull = false;
  boolean mIsSelect = false;
  protected Launcher mLauncher;
  private Drawable mNormalDrawableBg = null;
  int mPaddingSize = 0;
  private Runnable mRunnableOutLines = new Runnable()
  {
    public void run()
    {
      if ((ColorRect.this.mTargetCell[1] != -1) && (ColorRect.this.mTargetCell[0] != -1))
        ColorRect.this.mLauncher.getWorkspace().drawDragOutlinesByColorect(ColorRect.this.mCellLayout, ColorRect.this.mTargetCell[0], ColorRect.this.mTargetCell[1]);
    }
  };
  private Runnable mRunnableTipsShow = new Runnable()
  {
    public void run()
    {
      if (ColorRect.this.mIsEnter)
        ColorRect.this.showTips();
    }
  };
  int mScreenIndex = 0;
  private Drawable mSelectDrawableBg = null;
  private ColorRectTips mShareTips = null;
  private int[] mTargetCell = { -1, -1 };
  int mTipsOffX = 0;
  int mTipsOffY = 0;
  final Paint mpaint = new Paint();

  public ColorRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ColorRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getResources();
    this.mColorPreviewNormal = paramContext.getColor(2131165202);
    this.mColorPreviewSelected = paramContext.getColor(2131165203);
    this.mHighlightDrawableBg = paramContext.getDrawable(2130837512);
    this.mNormalDrawableBg = paramContext.getDrawable(2130837509);
    this.mSelectDrawableBg = paramContext.getDrawable(2130837514);
    this.mErroDrawableBg = paramContext.getDrawable(2130837510);
    this.mHighlightDrawableSelectBg = paramContext.getDrawable(2130837513);
    this.mErroDrawableSelectedBg = paramContext.getDrawable(2130837511);
    this.mGapSize = ((int)(paramContext.getDisplayMetrics().density * 12.0F));
    this.mPaddingSize = ((int)(paramContext.getDisplayMetrics().density * 2.0F));
    this.mDropPosRectColor = getResources().getColor(2131165197);
    this.mTipsOffX = paramContext.getDimensionPixelSize(2131361904);
    this.mTipsOffY = paramContext.getDimensionPixelSize(2131361903);
    setBackground(this.mNormalDrawableBg);
  }

  public ColorRect(Context paramContext, ColorRectTips paramColorRectTips)
  {
    this(paramContext, null, 0);
    this.mShareTips = paramColorRectTips;
  }

  public void drawColorRect(Canvas paramCanvas)
  {
    int k = this.mCellLayout.getChildCount();
    Paint localPaint = this.mpaint;
    Rect localRect = new Rect();
    int j = 0;
    Object localObject = this.mCellLayout.getDragCell();
    int i = j;
    BaseCellLayout.LayoutParams localLayoutParams;
    if (this.mCellLayout == this.mLauncher.getWorkspace().getCurrentDropLayout())
    {
      i = j;
      if (localObject != null)
      {
        i = j;
        if (localObject[0] != -1)
        {
          i = j;
          if (localObject[1] != -1)
          {
            localLayoutParams = this.mCellLayout.getDragViewParams();
            i = j;
            if (localLayoutParams != null)
            {
              int[] arrayOfInt = new int[2];
              this.mCellLayout.cellToPoint(localObject[0], localObject[1], arrayOfInt);
              localRect.left = (arrayOfInt[0] + this.mGapSize);
              localRect.top = (arrayOfInt[1] + this.mGapSize);
              localRect.right = (arrayOfInt[0] + localLayoutParams.width - this.mGapSize);
              localRect.bottom = (arrayOfInt[1] + localLayoutParams.height - this.mGapSize);
              localPaint.setColor(this.mDropPosRectColor);
              localPaint.setAlpha(154);
              paramCanvas.drawRect(localRect, localPaint);
              i = 1;
            }
          }
        }
      }
    }
    j = 0;
    while (j < k)
    {
      localObject = this.mCellLayout.getChildAt(j);
      if ((((View)localObject).getVisibility() != 0) && (((this.mLauncher != null) && (this.mLauncher.isWorkspaceInOrderMoreMode())) || (i != 0) || (this.mCellLayout != this.mLauncher.getWorkspace().getCurrentDropLayout())))
      {
        j += 1;
      }
      else
      {
        localLayoutParams = (BaseCellLayout.LayoutParams)((View)localObject).getLayoutParams();
        localRect.left = (localLayoutParams.x + this.mGapSize);
        localRect.top = (localLayoutParams.y + this.mGapSize);
        localRect.right = (localLayoutParams.x + localLayoutParams.width - this.mGapSize);
        localRect.bottom = (localLayoutParams.y + localLayoutParams.height - this.mGapSize);
        if ((localObject instanceof BubbleTextView))
        {
          localPaint.setColor(this.mColorPreviewNormal);
          if ((((BubbleTextView)localObject).isOrderMoreModeSelected()) && (this.mLauncher.isWorkspaceInOrderMoreMode()))
            localPaint.setColor(this.mColorPreviewSelected);
        }
        while (true)
        {
          localPaint.setAlpha(75);
          paramCanvas.drawRect(localRect, localPaint);
          break;
          if ((localObject instanceof AppWidgetHostView))
          {
            localPaint.setColor(this.mColorPreviewNormal);
          }
          else if ((localObject instanceof FolderIcon))
          {
            localPaint.setColor(this.mColorPreviewNormal);
            if ((((FolderIcon)localObject).isOrderMoreModeSelected()) && (this.mLauncher.isWorkspaceInOrderMoreMode()))
              localPaint.setColor(this.mColorPreviewSelected);
          }
        }
      }
    }
  }

  public CellLayout getCellLayout()
  {
    return this.mCellLayout;
  }

  public int getScreenIndex()
  {
    return this.mScreenIndex;
  }

  boolean isFull(DropTarget.DragObject paramDragObject)
  {
    boolean bool1 = true;
    if ((paramDragObject == null) || (getCellLayout() == null))
      bool1 = false;
    boolean bool2;
    do
    {
      return bool1;
      this.mTargetCell[0] = -1;
      this.mTargetCell[1] = -1;
      ItemInfo localItemInfo = (ItemInfo)paramDragObject.dragInfo;
      bool2 = getCellLayout().getFirstEmptyCell(this.mTargetCell, localItemInfo.spanX, localItemInfo.spanY);
      if (paramDragObject.orderViewCount == 1)
        break;
    }
    while (getCellLayout().getEmptyCells().size() >= paramDragObject.orderViewCount);
    return false;
    return bool2;
  }

  public boolean isSelect()
  {
    return this.mIsSelect;
  }

  public RectF mapRect(RectF paramRectF)
  {
    int i = this.mCellLayout.getWidth();
    int j = this.mCellLayout.getHeight();
    float f2 = getMeasuredWidth();
    float f1 = getMeasuredHeight();
    f2 = (f2 - this.mPaddingSize * 2) / i;
    f1 = (f1 - this.mPaddingSize * 2) / j;
    i = (int)(paramRectF.left * f2 + this.mGapSize);
    j = (int)(paramRectF.top * f1 + this.mGapSize);
    return new RectF(i, j, i + paramRectF.width() * f2 - this.mGapSize, j + paramRectF.height() * f1 - this.mGapSize);
  }

  public void onClick()
  {
    if (!this.mIsSelect)
      setBackground(this.mHighlightDrawableBg);
  }

  public void onDragEnter(DropTarget.DragObject paramDragObject)
  {
    if (!isFull(paramDragObject));
    for (boolean bool = true; ; bool = false)
    {
      this.mIsFull = bool;
      onDragEnter(this.mIsFull);
      postDelayed(new Runnable()
      {
        public void run()
        {
          if ((ColorRect.this.mIsEnter) && (ColorRect.this.mLauncher.getWorkspace() != null))
            ColorRect.this.mLauncher.getWorkspace().snapToPage(ColorRect.this.getScreenIndex());
        }
      }
      , 600L);
      return;
    }
  }

  public void onDragEnter(boolean paramBoolean)
  {
    this.mIsEnter = true;
    if ((this.mHighlightDrawableBg != null) && (!paramBoolean))
      if (this.mIsSelect)
      {
        setBackground(this.mHighlightDrawableSelectBg);
        if (!paramBoolean)
          break label123;
        if (!this.mLauncher.isWorkspaceInOrderMoreMode())
          break label118;
        removeCallbacks(this.mRunnableTipsShow);
        postDelayed(this.mRunnableTipsShow, 120L);
      }
    label118: label123: 
    while (!this.mLauncher.isWorkspaceInOrderMoreMode())
    {
      return;
      setBackground(this.mHighlightDrawableBg);
      break;
      if ((this.mErroDrawableBg == null) || (!paramBoolean))
        break;
      if (this.mIsSelect)
      {
        setBackground(this.mErroDrawableSelectedBg);
        break;
      }
      setBackground(this.mErroDrawableBg);
      break;
      showTips();
      return;
    }
    removeCallbacks(this.mRunnableOutLines);
    postDelayed(this.mRunnableOutLines, 120L);
  }

  public void onDragExit()
  {
    this.mIsEnter = false;
    if (this.mNormalDrawableBg != null)
    {
      if (this.mIsSelect)
        break label76;
      setBackground(this.mNormalDrawableBg);
    }
    while (true)
    {
      if (this.mShareTips.isShowing())
        this.mShareTips.dismiss();
      this.mTargetCell[0] = -1;
      this.mTargetCell[1] = -1;
      if (this.mLauncher.isWorkspaceInOrderMoreMode())
        this.mCellLayout.clearDragOutlines();
      return;
      label76: setBackground(this.mSelectDrawableBg);
    }
  }

  public void onDragOver()
  {
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mCellLayout != null)
    {
      CellLayout localCellLayout = this.mCellLayout;
      int i = localCellLayout.getWidth();
      int j = localCellLayout.getHeight();
      float f2 = getMeasuredWidth();
      float f1 = getMeasuredHeight();
      f2 = (f2 - this.mPaddingSize * 2) / i;
      f1 = (f1 - this.mPaddingSize * 2) / j;
      paramCanvas.save();
      paramCanvas.translate(this.mPaddingSize, this.mPaddingSize);
      paramCanvas.scale(f2, f1);
      drawColorRect(paramCanvas);
      paramCanvas.restore();
    }
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.mIsSelect = false;
      this.mIsFull = false;
      this.mIsEnter = false;
    }
    super.onVisibilityChanged(paramView, paramInt);
  }

  public void setCellLayout(CellLayout paramCellLayout, int paramInt)
  {
    this.mCellLayout = paramCellLayout;
    this.mScreenIndex = paramInt;
  }

  public void setLauncher(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
  }

  public void setSelect(boolean paramBoolean)
  {
    this.mIsSelect = paramBoolean;
    if (this.mIsSelect)
    {
      if ((this.mIsFull) && (this.mIsEnter))
      {
        setBackground(this.mErroDrawableSelectedBg);
        return;
      }
      if ((!this.mIsFull) && (this.mIsEnter))
      {
        setBackground(this.mHighlightDrawableSelectBg);
        return;
      }
      setBackground(this.mSelectDrawableBg);
      return;
    }
    if (this.mIsEnter)
    {
      if (this.mIsFull)
      {
        setBackground(this.mErroDrawableBg);
        return;
      }
      setBackground(this.mHighlightDrawableBg);
      return;
    }
    setBackground(this.mNormalDrawableBg);
  }

  public void showTips()
  {
    if (this.mShareTips.isShowing())
      return;
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationInWindow(arrayOfInt1);
    arrayOfInt1[1] -= this.mTipsOffY;
    int j = this.mShareTips.getWidthMost();
    int k = this.mScreenIndex % 6;
    int i;
    if (this.mLauncher.getWorkspace().getNormalSize() >= 6)
    {
      i = 1;
      if ((k != 0) || (i == 0))
        break label120;
      i = 3;
      arrayOfInt2[0] = (arrayOfInt1[0] + getWidth() / 2 - this.mTipsOffX);
    }
    while (true)
    {
      arrayOfInt2[1] = arrayOfInt1[1];
      this.mShareTips.show(arrayOfInt2, i);
      return;
      i = 0;
      break;
      label120: if (k == 5)
      {
        i = 5;
        arrayOfInt2[0] = (arrayOfInt1[0] + getWidth() / 2 - (j - this.mTipsOffX));
      }
      else
      {
        i = 17;
        arrayOfInt2[0] = (arrayOfInt1[0] + getWidth() / 2 - j / 2);
      }
    }
  }

  public String toString()
  {
    return "beyond to " + this.mScreenIndex;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ColorRect
 * JD-Core Version:    0.6.2
 */