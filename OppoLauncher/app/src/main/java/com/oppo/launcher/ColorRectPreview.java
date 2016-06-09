package com.oppo.launcher;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import android.widget.Toast;
import com.oppo.NearMeStatistics.LauncherStatistics;
import com.oppo.launcher.effect.EffectController;

public class ColorRectPreview extends PagedView
  implements DropTarget, DragScroller, OnClickListener
{
  static final boolean DEBUG = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  public static final int DROP_ANIMATE_TIME = 300;
  public static final int DROP_DONE_TIME = 400;
  public static final int MaxItem = 6;
  static final String TAG = "ColorRectPreview";
  Rect mColorRect = new Rect();
  private ColorRect mDragTargetPage;
  private boolean mIsLock = false;
  private int mLastTotalScreen = 0;
  private int mLastWorkSpaceIndex = -1;
  OnGlobalLayoutListener mLayoutListener = new OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (ColorRectPreview.this.visibility())
      {
        if (ColorRectPreview.this.mLastTotalScreen == ColorRectPreview.this.mWorkspace.getChildCount())
          break label49;
        if (ColorRectPreview.this.mLastTotalScreen != 0)
          break label41;
      }
      label41: label49: 
      while (ColorRectPreview.this.getVisibility() != 0)
      {
        return;
        ColorRectPreview.this.refresh();
        return;
      }
      ColorRectPreview.this.refreshPreviewPage(-1);
    }
  };
  private View mLeftArrow = null;
  public boolean mNeedDelete = true;
  private int mOldDropCellLayout = -1;
  private ColorRectTips mPopTips = null;
  private View mRightArrow = null;
  private ViewTreeObserver mVto;
  private Workspace mWorkspace;

  public ColorRectPreview(Context paramContext)
  {
    this(paramContext, null);
  }

  public ColorRectPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ColorRectPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mScrollEffect = new EffectController(this, paramContext);
    this.mIsDataReady = true;
  }

  protected void acceleratedOverScroll(float paramFloat)
  {
    Workspace localWorkspace;
    if (paramFloat < 0.0F)
      localWorkspace = this.mWorkspace;
    int i;
    for (this.mScrollX = ((int)(paramFloat * 0.4F)); ; this.mScrollX = (i + (int)(paramFloat * 0.4F)))
    {
      i = getMeasuredWidth() / 2;
      screenScrolled(this.mOverScrollX + i);
      return;
      i = this.mMaxScrollX;
      localWorkspace = this.mWorkspace;
    }
  }

  public boolean acceptDrop(DragObject paramDragObject)
  {
    boolean bool2;
    if (this.mWorkspace.isOrderMoreMode())
    {
      if (this.mDragTargetPage != null)
        this.mDragTargetPage.onDragExit();
      bool2 = this.mLauncher.getColorRectManager().acceptDrop(this, paramDragObject);
    }
    ItemInfo localItemInfo;
    boolean bool1;
    int i;
    do
    {
      return bool2;
      localItemInfo = (ItemInfo)paramDragObject.dragInfo;
      bool1 = false;
      bool2 = false;
      i = 1;
      this.mNeedDelete = true;
    }
    while (this.mDragTargetPage == null);
    LauncherStatistics.getInstance(this.mLauncher).launcherStatisticsDropItemTypeWhenOrderOne(localItemInfo);
    int[] arrayOfInt = new int[2];
    CellLayout localCellLayout = this.mDragTargetPage.getCellLayout();
    if ((localCellLayout != null) && (localCellLayout.getFirstEmptyCell(arrayOfInt, localItemInfo.spanX, localItemInfo.spanY)))
    {
      int j = ((LauncherApplication)this.mLauncher.getApplicationContext()).getModel().getScreenId(this.mDragTargetPage.mScreenIndex);
      if (DEBUG)
      {
        paramDragObject = new StringBuilder().append(" screen ").append(j).append("\\ itemInfo screenId").append(localItemInfo.screenId).append(", findrect[0] == itemInfo.cellX ");
        if (arrayOfInt[0] == localItemInfo.cellX)
        {
          bool1 = true;
          label195: paramDragObject = paramDragObject.append(bool1).append(", findrect[1] == itemInfo.cellY ");
          if (arrayOfInt[1] != localItemInfo.cellY)
            break label383;
          bool1 = true;
          label220: Log.d("ColorRectPreview", bool1);
        }
      }
      else
      {
        if ((arrayOfInt[0] != localItemInfo.cellX) || (arrayOfInt[1] != localItemInfo.cellY) || (localItemInfo.screenId != j) || (localItemInfo.container != -100L))
          break label389;
        i = 0;
        this.mNeedDelete = false;
        bool1 = true;
      }
    }
    while (true)
    {
      if (this.mDragTargetPage != null)
      {
        this.mDragTargetPage.onDragExit();
        if ((!bool1) && (i != 0))
          Toast.makeText(this.mLauncher, 2131427377, 0).show();
      }
      bool2 = bool1;
      if (!DEBUG)
        break;
      Log.i("ColorRectPreview", " acceptDrop?= " + bool1 + " mNeedDelete ?= " + this.mNeedDelete);
      return bool1;
      bool1 = false;
      break label195;
      label383: bool1 = false;
      break label220;
      label389: bool1 = true;
      continue;
      paramDragObject.deferDragViewCleanupPostAnimation = false;
    }
  }

  public void dropAnimate(DragObject paramDragObject, ColorRect paramColorRect)
  {
    if ((paramDragObject == null) || (paramColorRect == null))
    {
      Log.e("ColorRectPreview", "dropAnimate : null == dragObject || null == targetPage");
      return;
    }
    Rect localRect1 = new Rect();
    this.mLauncher.getDragLayer().getViewRectRelativeToSelf(paramDragObject.dragView, localRect1);
    Rect localRect2 = new Rect();
    paramColorRect.getGlobalVisibleRect(localRect2);
    localRect2.offset(-paramDragObject.dragView.getMeasuredWidth() / 2, -paramDragObject.dragView.getMeasuredHeight() / 2);
    int[] arrayOfInt = new int[2];
    CellLayout localCellLayout = paramColorRect.getCellLayout();
    if (localCellLayout == null)
    {
      Log.e("ColorRectPreview", "dropAnimate : null == layout");
      return;
    }
    localCellLayout.getFirstEmptyCell(arrayOfInt, ((ItemInfo)paramDragObject.dragInfo).spanX, ((ItemInfo)paramDragObject.dragInfo).spanY);
    RectF localRectF = new RectF();
    localCellLayout.cellToRect(arrayOfInt[0], arrayOfInt[1], ((ItemInfo)paramDragObject.dragInfo).spanX, ((ItemInfo)paramDragObject.dragInfo).spanY, localRectF);
    paramColorRect = paramColorRect.mapRect(localRectF);
    localRect2.offset((int)(paramColorRect.left + paramColorRect.width() / 2.0F), (int)(paramColorRect.top + paramColorRect.height() / 2.0F));
    float f1 = paramColorRect.width() / localRectF.width();
    float f2 = paramColorRect.height() / localRectF.height();
    paramDragObject.deferDragViewCleanupPostAnimation = true;
    this.mLauncher.getDragLayer().animateView(paramDragObject.dragView, localRect1, localRect2, 0.3F, 1.0F, 1.0F, f1, f2, 300, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), null, 0, null);
  }

  ColorRect getColorRect(int paramInt)
  {
    CellLayout localCellLayout = (CellLayout)getChildAt(paramInt / 6);
    ColorRect localColorRect = null;
    if (localCellLayout != null)
      localColorRect = (ColorRect)localCellLayout.getChildAt(paramInt % 6);
    return localColorRect;
  }

  public ColorRect getDragTargetPage(Rect paramRect, int paramInt1, int paramInt2)
  {
    ColorRectCellLayout localColorRectCellLayout = (ColorRectCellLayout)getChildAt(getCurrentPage());
    if (localColorRectCellLayout == null)
      return null;
    int i = 0;
    while (i < localColorRectCellLayout.getChildCount())
    {
      this.mColorRect.setEmpty();
      View localView = localColorRectCellLayout.getChildAt(i);
      localView.getGlobalVisibleRect(this.mColorRect);
      if (paramRect != null)
        this.mColorRect.bottom = paramRect.bottom;
      if (DEBUG)
        Log.d("ColorRectPreview", "getDragTargetPage -- mColorRect = " + this.mColorRect);
      if (this.mColorRect.contains(paramInt1, paramInt2))
        return (ColorRect)localView;
      i += 1;
    }
    return null;
  }

  ColorRect getDragTargetPage(DragObject paramDragObject)
  {
    Rect localRect = new Rect();
    super.getGlobalVisibleRect(localRect, null);
    int i = paramDragObject.x + localRect.left;
    int j = paramDragObject.y + localRect.top;
    if (DEBUG)
      Log.d("ColorRectPreview", "getDragTargetPage -- dragObjectX = " + i + ", dragObjectY = " + j);
    return getDragTargetPage(localRect, i, j);
  }

  public DropTarget getDropTargetDelegate(DragObject paramDragObject)
  {
    return null;
  }

  public boolean getGlobalVisibleRect(Rect paramRect, Point paramPoint)
  {
    boolean bool = super.getGlobalVisibleRect(paramRect, paramPoint);
    if ((this.mLauncher.isOrderMode()) && (this.mLauncher != null))
      paramRect.bottom = this.mLauncher.getDragLayerHeight();
    return bool;
  }

  public void getLocationInDragLayer(int[] paramArrayOfInt)
  {
    this.mLauncher.getDragLayer().getLocationInDragLayer(this, paramArrayOfInt);
  }

  protected PagePointView getScrollingIndicator()
  {
    return null;
  }

  public ColorRect getTagetColorRect()
  {
    return this.mDragTargetPage;
  }

  public boolean handleMotionEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    super.handleMotionEvent(paramMotionEvent);
    boolean bool1;
    if (getChildCount() <= 0)
      bool1 = false;
    int i;
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        }
        while (this.mTotalMotionX > MIN_LENGTH_FOR_FLING);
        switch (paramMotionEvent.getActionMasked())
        {
        default:
          return true;
        case 6:
        }
        i = paramMotionEvent.getActionIndex();
        paramMotionEvent = getDragTargetPage(null, (int)paramMotionEvent.getX(i), (int)paramMotionEvent.getY(i));
        bool1 = bool2;
      }
      while (paramMotionEvent == null);
      i = paramMotionEvent.getScreenIndex();
      bool1 = bool2;
    }
    while (i == this.mWorkspace.getCurrentPage());
    refreshPreviewPage(i);
    paramMotionEvent.onClick();
    this.mWorkspace.snapToPage(i);
    LauncherStatistics.getInstance(this.mLauncher).launcherStatisticsClickPreviewCardWhenOrderAndDragging(this.mWorkspace.isOrderMoreMode());
    return true;
  }

  public boolean isDropEnabled(DragObject paramDragObject)
  {
    return getVisibility() == 0;
  }

  public void onCellDrag()
  {
    int i = this.mWorkspace.getCurrentDropLayoutIndex();
    refreshPreviewPage(i);
    if (i != this.mOldDropCellLayout)
    {
      if (this.mOldDropCellLayout != -1)
        refreshPreviewPage(this.mOldDropCellLayout);
      this.mOldDropCellLayout = i;
    }
  }

  public void onClick(View paramView)
  {
    if ((paramView instanceof ColorRect))
    {
      ColorRect localColorRect = (ColorRect)paramView;
      int i = localColorRect.getScreenIndex();
      if (DEBUG)
        Log.d("ColorRectPreview", " onClick " + i + " dd " + ((ViewGroup)paramView.getParent()).indexOfChild(paramView));
      refreshPreviewPage(i);
      localColorRect.onClick();
      this.mWorkspace.snapToPage(i);
      LauncherStatistics.getInstance(this.mLauncher).launcherStatisticsClickPreviewCardWhenOrder(this.mWorkspace.isOrderMoreMode());
    }
  }

  public void onDragEnter(DragObject paramDragObject)
  {
    if (DEBUG)
      Log.d("ColorRectPreview", " onDragEnter ");
    ColorRect localColorRect = getDragTargetPage(paramDragObject);
    if ((this.mDragTargetPage != null) && (this.mDragTargetPage != localColorRect))
      this.mDragTargetPage.onDragExit();
    this.mDragTargetPage = localColorRect;
    if (this.mDragTargetPage != null)
      this.mDragTargetPage.onDragEnter(paramDragObject);
    if (this.mWorkspace != null)
      this.mWorkspace.removeFolderIcon(paramDragObject);
  }

  public void onDragExit(DragObject paramDragObject)
  {
    if (DEBUG)
      Log.d("ColorRectPreview", " onDragExit " + paramDragObject.dragInfo);
    if (this.mDragTargetPage != null)
    {
      this.mDragTargetPage.onDragExit();
      if (this.mLauncher.isWorkspaceInOrderMoreMode())
        this.mDragTargetPage.getCellLayout().clearDragOutlines(false);
      this.mDragTargetPage = null;
    }
  }

  public void onDragOver(DragObject paramDragObject)
  {
    if (DEBUG)
      Log.d("ColorRectPreview", " onDragOver ");
    Object localObject = (ItemInfo)paramDragObject.dragInfo;
    if ((((ItemInfo)localObject).spanX < 0) || (((ItemInfo)localObject).spanY < 0))
      throw new RuntimeException("Improper spans found");
    if (DEBUG)
      Log.d("ColorRectPreview", "onDragOver -- dragObject.x = " + paramDragObject.x + ", dragObject.y = " + paramDragObject.y + ", mDragTargetPage = " + this.mDragTargetPage);
    localObject = getDragTargetPage(paramDragObject);
    if (localObject != this.mDragTargetPage)
    {
      if (this.mDragTargetPage != null)
      {
        this.mDragTargetPage.getCellLayout().onDragExit(paramDragObject, false);
        this.mDragTargetPage.onDragExit();
      }
      this.mDragTargetPage = ((ColorRect)localObject);
      if (this.mDragTargetPage != null)
        this.mDragTargetPage.onDragEnter(paramDragObject);
    }
  }

  public void onDrop(DragObject paramDragObject)
  {
    if (DEBUG)
      Log.d("ColorRectPreview", " onDrop dragObject = " + paramDragObject);
    this.mDragTargetPage = getDragTargetPage(paramDragObject);
    if (this.mDragTargetPage != null)
    {
      if (!this.mLauncher.isWorkspaceInOrderMoreMode())
        break label104;
      this.mLauncher.getColorRectManager().onDrop(this, paramDragObject);
    }
    while (true)
    {
      this.mDragTargetPage.onDragExit();
      postDelayed(new Runnable()
      {
        public void run()
        {
          ColorRectPreview.this.mDragTargetPage.invalidate();
        }
      }
      , 400L);
      paramDragObject.dragSource.restoreDragInfo(paramDragObject);
      return;
      label104: ItemInfo localItemInfo = (ItemInfo)paramDragObject.dragInfo;
      dropAnimate(paramDragObject, this.mDragTargetPage);
      this.mWorkspace.onDropByColorRect(null, localItemInfo, this.mDragTargetPage.getCellLayout(), true, paramDragObject);
    }
  }

  public void onFlingToDelete(DragObject paramDragObject, int paramInt1, int paramInt2, PointF paramPointF)
  {
  }

  protected void onPageEndMoving()
  {
    super.onPageEndMoving();
    updateArrow(true);
  }

  protected void overScroll(float paramFloat)
  {
    acceleratedOverScroll(paramFloat);
  }

  public void preOnDrop(DragObject paramDragObject)
  {
    if (this.mWorkspace != null)
      this.mWorkspace.cleanupReoderAndFolderCreateion();
    if (DEBUG)
      Log.d("ColorRectPreview", " preOnDrop " + paramDragObject.dragInfo);
  }

  public void refresh()
  {
    int n = this.mWorkspace.getNormalSize();
    int k = 0;
    int i = k;
    int m;
    if (this.mLastTotalScreen != this.mWorkspace.getChildCount())
    {
      this.mLastTotalScreen = this.mWorkspace.getChildCount();
      j = getChildCount();
      m = (n - 1) / 6 + 1;
      if (j > m)
      {
        j -= 1;
        while (true)
        {
          i = k;
          if (j < m)
            break;
          removeViewAt(m);
          j -= 1;
        }
      }
      if (j < m)
        while (true)
        {
          i = k;
          if (j >= m)
            break;
          addView((ColorRectCellLayout)this.mLauncher.getLayoutInflater().inflate(2130968582, this, false), j);
          j += 1;
        }
      i = 1;
    }
    int j = 0;
    if (j <= (n - 1) / 6)
    {
      ColorRectCellLayout localColorRectCellLayout = (ColorRectCellLayout)getChildAt(j);
      if (localColorRectCellLayout == null);
      while (true)
      {
        j += 1;
        break;
        if (j == 0)
          localColorRectCellLayout.setFirstPage(true);
        int i1;
        int i2;
        while (true)
        {
          i1 = Math.min(6, n - j * 6);
          i2 = localColorRectCellLayout.getChildCount();
          k = i2 - 1;
          while (k >= i1)
          {
            localColorRectCellLayout.removeViewWithoutMarkingCells(localColorRectCellLayout.getChildAt(k));
            k -= 1;
          }
          localColorRectCellLayout.setFirstPage(false);
        }
        m = j * 6;
        k = 0;
        if (m < i1 + j * 6)
        {
          ColorRect localColorRect;
          if (k < i2)
          {
            localColorRect = (ColorRect)localColorRectCellLayout.getChildAt(k);
            localColorRect.setLayoutParams(new BaseCellLayout.LayoutParams(k, 0, 1, 1));
          }
          while (true)
          {
            localColorRect.setLauncher(this.mLauncher);
            localColorRect.setCellLayout((CellLayout)this.mWorkspace.getChildAt(m), m);
            localColorRect.setOnClickListener(this);
            m += 1;
            k += 1;
            break;
            localColorRect = new ColorRect(this.mContext, this.mPopTips);
            localColorRectCellLayout.addViewToCellLayout(localColorRect, k, k, new BaseCellLayout.LayoutParams(k, 0, 1, 1), false, false);
          }
        }
        if (i != 0)
          refreshPreviewPage(-1);
        else
          updateArrow(true);
      }
    }
  }

  void refreshPreviewPage(int paramInt)
  {
    if (paramInt == -1)
    {
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        localObject = (ViewGroup)getChildAt(paramInt);
        int i = 0;
        if (i < ((ViewGroup)localObject).getChildCount())
        {
          View localView = ((ViewGroup)localObject).getChildAt(i);
          ColorRect localColorRect;
          if ((localView instanceof ColorRect))
          {
            localColorRect = (ColorRect)localView;
            if (localColorRect.getCellLayout() != this.mWorkspace.getCurrentDropLayout())
              break label90;
            localColorRect.setSelect(true);
          }
          while (true)
          {
            localView.invalidate();
            i += 1;
            break;
            label90: localColorRect.setSelect(false);
          }
        }
        paramInt += 1;
      }
    }
    Object localObject = getColorRect(paramInt);
    if (localObject != null)
      ((ColorRect)localObject).invalidate();
  }

  public void selectRect()
  {
    if (!visibility());
    label157: label173: 
    while (true)
    {
      return;
      if (DEBUG)
        Log.d("ColorRectPreview", " selectRect come here ");
      int i;
      if (this.mLastWorkSpaceIndex != this.mWorkspace.getCurrentPage())
      {
        this.mLastWorkSpaceIndex = this.mWorkspace.getCurrentPage();
        i = 0;
      }
      while (true)
      {
        if (i >= getChildCount())
          break label173;
        ViewGroup localViewGroup = (ViewGroup)getChildAt(i);
        int j = 0;
        label70: if (j < localViewGroup.getChildCount())
        {
          View localView = localViewGroup.getChildAt(j);
          if ((localView instanceof ColorRect))
          {
            if (((ColorRect)localView).getCellLayout() != this.mWorkspace.getCurrentDropLayout())
              break label157;
            ((ColorRect)localView).setSelect(true);
            snapToPage(((ColorRect)localView).getScreenIndex() / 6);
          }
          while (true)
          {
            j += 1;
            break label70;
            if (!DEBUG)
              break;
            Log.i("ColorRectPreview", "selectRect come here,no need update");
            return;
            ((ColorRect)localView).setSelect(false);
          }
        }
        i += 1;
      }
    }
  }

  void setCurrentPage(int paramInt)
  {
    if (!this.mScroller.isFinished())
      this.mScroller.abortAnimation();
    if (getChildCount() == 0)
      return;
    this.mCurrentPage = Math.max(0, Math.min(paramInt, getPageCount() - 1));
    updateCurrentPageScroll();
    notifyPageSwitchListener();
    invalidate();
  }

  public void setLauncher(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
    this.mWorkspace = paramLauncher.getWorkspace();
    this.mVto = this.mWorkspace.getViewTreeObserver();
    this.mVto.addOnGlobalLayoutListener(this.mLayoutListener);
    this.mLeftArrow = paramLauncher.findViewById(2131492882);
    this.mRightArrow = paramLauncher.findViewById(2131492883);
    this.mPopTips = new ColorRectTips(this.mContext, this.mLauncher.getDragLayer());
  }

  public void setLock(boolean paramBoolean)
  {
    this.mIsLock = paramBoolean;
  }

  public void syncPageItems(int paramInt1, int paramInt2, boolean paramBoolean)
  {
  }

  public void syncPageItems(int paramInt, boolean paramBoolean)
  {
  }

  public void updateArrow(boolean paramBoolean)
  {
    int i = getCurrentPage();
    if (DEBUG)
      Log.d("ColorRectPreview", "updateArrow " + i + "   TotalScreen  " + getChildCount());
    if ((paramBoolean) && (visibility()))
    {
      if (i >= 1)
        this.mLeftArrow.setVisibility(0);
      while (i < getChildCount() - 1)
      {
        this.mRightArrow.setVisibility(0);
        return;
        this.mLeftArrow.setVisibility(4);
      }
      this.mRightArrow.setVisibility(4);
      return;
    }
    this.mLeftArrow.setVisibility(4);
    this.mRightArrow.setVisibility(4);
  }

  public void updatePage()
  {
    if ((getVisibility() == 0) && (this.mWorkspace != null))
    {
      final int i = this.mWorkspace.getCurrentPage() / 6;
      this.mLastWorkSpaceIndex = this.mWorkspace.getCurrentPage();
      setCurrentPage(i);
      postDelayed(new Runnable()
      {
        public void run()
        {
          ColorRectPreview.this.snapToPage(i, 200);
        }
      }
      , 50L);
    }
  }

  public boolean visibility()
  {
    return (getVisibility() == 0) && (!this.mIsLock);
  }

  public boolean willRemoveDrageCell()
  {
    if (DEBUG)
      Log.d("ColorRectPreview", " willRemoveDrageCell " + this.mNeedDelete);
    return this.mNeedDelete;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ColorRectPreview
 * JD-Core Version:    0.6.2
 */