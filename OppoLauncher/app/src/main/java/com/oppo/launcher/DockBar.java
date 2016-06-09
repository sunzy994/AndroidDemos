package com.oppo.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import com.oppo.NearMeStatistics.LauncherStatistics;
import com.oppo.launcher.graphic.IUpdateTextColor;
import com.oppo.launcher.screenGrid.ScreenGridUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DockBar extends BaseDockBar
  implements DragSource, DropTarget, IIconTextVisible
{
  private static final boolean DEBUG_DRAG = false;
  private static final boolean DEBUG_NORMAL = false;
  static final boolean DEBUG_UNREAD = false;
  private static final int DRAG_MODE_ADD_TO_FOLDER = 1;
  private static final int DRAG_MODE_NONE = 0;
  public static final int DROP_IN_ANIMATION_DURATION = 300;
  private static final String TAG = "DockBar";
  public static WorkspaceScreenData sScreenData = new WorkspaceScreenData();
  private boolean mAddToExistingFolderOnDrop = false;
  private boolean mChangeView = false;
  private DragController mDragController;
  private int mDragInFolderPosition = -1;
  private int mDragMode = 0;
  private FolderIcon mDragOverFolderIcon = null;
  private View mDragView;
  private float mFolderCreationMaxDistanceX;
  private float mFolderCreationMaxDistanceY;
  protected ArrayList<BaseFolderIcon.FolderRingAnimator> mFolderOuterRings = new ArrayList();
  private int mLastFolderTempPosition = -1;
  private ItemInfo mSwitchItemInfo = null;
  private int[] mSwitchPositon;
  protected int[] mTempLocation = new int[2];
  private Rect mTmpRect = new Rect();
  private int mWillLastFolderTempPosition = -1;

  public DockBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources();
    this.mFolderCreationMaxDistanceX = (0.4F * paramContext.getDimensionPixelSize(2131361876));
    this.mFolderCreationMaxDistanceY = (0.75F * paramContext.getDimensionPixelSize(2131361876));
  }

  private void addToFolder(DropTarget.DragObject paramDragObject, int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    boolean bool;
    if (this.mWillChildCount == i)
    {
      paramInt2 = paramInt1;
      View localView = getChildAt(paramInt2);
      if ((localView instanceof FolderIcon))
      {
        if (this.mWillChildCount != i)
          break label141;
        bool = true;
        label44: bool = willAddToExistingUserFolder(paramDragObject, paramInt2, paramInt1, bool);
        if ((!bool) || (this.mDragMode != 0))
          break label147;
        this.mDragOverFolderIcon = ((FolderIcon)localView);
        if (this.mDragOverFolderIcon != null)
        {
          this.mTempLocation = getChildLeftAndTop(paramInt1, this.mWillChildCount, false);
          this.mDragOverFolderIcon.onDragEnter(paramDragObject.dragInfo);
          this.mLastFolderTempPosition = paramInt2;
          this.mWillLastFolderTempPosition = paramInt1;
          setDragMode(1);
        }
      }
    }
    label141: label147: 
    while ((bool) || (1 != this.mDragMode))
    {
      return;
      if (paramInt1 == paramInt2 - 1)
      {
        paramInt2 -= 1;
        break;
      }
      break;
      bool = false;
      break label44;
    }
    if (this.mWillChildCount == i)
    {
      this.mWillChildCount = (i + 1);
      this.mWillPos = -1;
    }
    setDragMode(0);
  }

  private boolean changeViewIntentInPos(DragSource paramDragSource, Object paramObject, int paramInt)
  {
    if (paramObject == null);
    View localView;
    ItemInfo localItemInfo1;
    ItemInfo localItemInfo2;
    do
    {
      do
      {
        return false;
        localView = getChildAt(paramInt);
      }
      while (localView == null);
      localItemInfo1 = (ItemInfo)localView.getTag();
      localItemInfo2 = (ItemInfo)paramObject;
    }
    while ((localItemInfo2 instanceof FolderInfo));
    if ((localItemInfo1 instanceof FolderInfo))
    {
      if ((paramDragSource instanceof Workspace))
        this.mModel.removeItem(localItemInfo2);
      ((FolderIcon)localView).mFolder.notifyDrop();
      ((FolderInfo)localItemInfo1).add((ApplicationInfo)localItemInfo2);
    }
    while (true)
    {
      return true;
      if ((this.mLauncher != null) && (this.mLauncher.getWorkspace() != null))
        this.mLauncher.getWorkspace().createDockBarSwitchBitmap(localView);
      int[] arrayOfInt = new int[2];
      localView.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] = arrayOfInt[0];
      arrayOfInt[1] = arrayOfInt[1];
      this.mSwitchPositon = arrayOfInt;
      removeView(localView);
      if ((paramDragSource instanceof Workspace))
        this.mModel.removeItem(localItemInfo2);
      switchItemInfoData(localItemInfo2, localItemInfo1, true);
      if ((localItemInfo2 instanceof ApplicationInfo))
        removeItemInfo(localItemInfo1);
      addViewInPos(paramObject, paramInt);
      if (((paramDragSource instanceof Workspace)) || ((paramDragSource instanceof Folder)))
      {
        this.mChangeView = true;
        this.mSwitchItemInfo = localItemInfo1;
      }
    }
  }

  private void checkTextVisible()
  {
    if (this.mLauncher.getWorkspace().isOrderMode())
    {
      onTextVisible(false);
      return;
    }
    onTextVisible(true);
  }

  private void cleanupAddToFolder()
  {
    if (this.mDragOverFolderIcon != null)
    {
      this.mDragOverFolderIcon.onDragExit(null);
      syncAnim(this.mDragOverFolderIcon);
      this.mDragOverFolderIcon = null;
    }
  }

  private void clearAllPos()
  {
    this.mWillPos = -1;
    this.mWillChildCount = -1;
    this.mChildCountInOrderMode = 1;
  }

  private void clearDragView()
  {
    this.mDragView = null;
  }

  private int findNearestPosition(DropTarget.DragObject paramDragObject)
  {
    paramDragObject = getDragViewVisualCenter(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset, paramDragObject.dragView, null);
    int j = (int)(getChildWidth() * getScaleX());
    int k = getFirstChildLeft(this.mWillChildCount);
    int i = -1;
    if (paramDragObject[0] < k)
      i = 0;
    while (true)
    {
      j = i;
      if (i >= this.mWillChildCount)
        j = this.mWillChildCount - 1;
      return j;
      if (j > 0)
        i = (int)((paramDragObject[0] - k) / j);
    }
  }

  private float[] getDistanceFromCellToPointer(float paramFloat1, float paramFloat2, int paramInt)
  {
    int[] arrayOfInt = getChildCenter(paramInt, getChildCount());
    float[] arrayOfFloat = new float[2];
    getMatrix().mapPoints(arrayOfFloat);
    return new float[] { Math.abs(arrayOfFloat[0] + paramFloat1 - arrayOfInt[0]), Math.abs(arrayOfFloat[1] + paramFloat2 - arrayOfInt[1]) };
  }

  private void onDragOverOneItem(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (paramInt == i)
        if ((localView instanceof BaseFolderIcon))
          localView.setBackgroundDrawable(null);
      while (true)
      {
        i += 1;
        break;
        localView.setBackgroundResource(2130837517);
        continue;
        localView.setBackgroundDrawable(null);
      }
    }
  }

  private void setDragMode(int paramInt)
  {
    if (paramInt != this.mDragMode)
    {
      if (paramInt == 0)
        cleanupAddToFolder();
      this.mDragMode = paramInt;
    }
  }

  private void setOnDropWithTransX()
  {
    View localView = getChildAt(this.mLastFolderTempPosition);
    if ((localView instanceof FolderIcon))
    {
      int i = (int)((getChildLocation(this.mLastFolderTempPosition, getChildCount(), false).left - localView.getLeft()) * getScaleX());
      ((FolderIcon)localView).setOnDropWithTransX(i);
    }
  }

  private void startAnimation(int paramInt)
  {
    startAnimation(paramInt, 1);
  }

  private void startAnimation(int paramInt1, int paramInt2)
  {
    this.mChildCountInOrderMode = paramInt2;
    if (getVisibility() != 0);
    int m;
    do
    {
      return;
      m = getChildCount();
    }
    while (m <= 0);
    getChildAt(0);
    this.mIsAnimating = true;
    int n = getChildWidth();
    View localView;
    int i;
    if (-1 == paramInt1)
    {
      paramInt2 = getFirstChildLeft(m);
      paramInt1 = 0;
      while (paramInt1 < m)
      {
        localView = getChildAt(paramInt1);
        i = localView.getLeft();
        if ((localView instanceof CallBacks))
          ((CallBacks)localView).startMove(paramInt2 + n * paramInt1 - i, 0, true);
        paramInt1 += 1;
      }
    }
    if (this.mWillChildCount > 0)
    {
      int i1 = getFirstChildLeft(this.mWillChildCount);
      int j = 0;
      i = 0;
      if (i < m)
      {
        localView = getChildAt(i);
        int k = j;
        if (localView.getVisibility() == 0)
        {
          localView.getLeft();
          if (j >= paramInt1)
            break label224;
        }
        label224: for (k = i1 + n * j; ; k = n * j + i1 + n * paramInt2)
        {
          int i2 = localView.getLeft();
          if ((localView instanceof CallBacks))
            ((CallBacks)localView).startMove(k - i2, 0, true);
          k = j + 1;
          i += 1;
          j = k;
          break;
        }
      }
    }
    postInvalidate();
  }

  private void switchItemInfoData(ItemInfo paramItemInfo1, ItemInfo paramItemInfo2, boolean paramBoolean)
  {
    long l = paramItemInfo1.container;
    int i = paramItemInfo1.screenId;
    int j = paramItemInfo1.cellX;
    int k = paramItemInfo1.cellY;
    int m = paramItemInfo1.spanX;
    int n = paramItemInfo1.spanY;
    if (paramBoolean)
    {
      paramItemInfo1.container = paramItemInfo2.container;
      paramItemInfo1.screenId = paramItemInfo2.screenId;
      paramItemInfo1.cellX = paramItemInfo2.cellX;
      paramItemInfo1.cellY = paramItemInfo2.cellY;
      paramItemInfo1.spanX = paramItemInfo2.spanX;
      paramItemInfo1.spanY = paramItemInfo2.spanY;
    }
    paramItemInfo2.container = l;
    paramItemInfo2.screenId = i;
    paramItemInfo2.cellX = j;
    paramItemInfo2.cellY = k;
    paramItemInfo2.spanX = m;
    paramItemInfo2.spanY = n;
    if ((paramItemInfo1 instanceof FolderInfo))
    {
      Iterator localIterator = ((FolderInfo)paramItemInfo1).contents.iterator();
      while (localIterator.hasNext())
        ((ItemInfo)localIterator.next()).screenId = paramItemInfo1.screenId;
    }
    if ((paramItemInfo2 instanceof FolderInfo))
    {
      paramItemInfo1 = ((FolderInfo)paramItemInfo2).contents.iterator();
      while (paramItemInfo1.hasNext())
        ((ItemInfo)paramItemInfo1.next()).screenId = paramItemInfo2.screenId;
    }
  }

  private void updateDataBaseForDockBar()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ItemInfo localItemInfo = (ItemInfo)getChildAt(i).getTag();
      localItemInfo.cellX = i;
      LauncherModel.addOrMoveItemInDatabase(this.mLauncher, localItemInfo, -101L, 999, i, 0);
      i += 1;
    }
  }

  private void updateDatabasesWhenInsertOneItem(ItemInfo paramItemInfo, int paramInt)
  {
    int j = getChildCount();
    int i = paramInt;
    while (i < j)
    {
      ItemInfo localItemInfo = (ItemInfo)getChildAt(i).getTag();
      localItemInfo.cellX = i;
      LauncherModel.addOrMoveItemInDatabase(this.mLauncher, localItemInfo, -101L, 999, i, 0);
      i += 1;
    }
    if (!sScreenData.containsItem(paramItemInfo))
    {
      if (paramInt <= sScreenData.mItems.size())
        break label132;
      sScreenData.mItems.add(paramItemInfo);
    }
    while (true)
    {
      if ((paramItemInfo instanceof FolderInfo))
      {
        updateFolderChildToDataBase((FolderInfo)paramItemInfo);
        sScreenData.mFolders.put(Long.valueOf(paramItemInfo.id), (FolderInfo)paramItemInfo);
      }
      return;
      label132: sScreenData.mItems.add(paramInt, paramItemInfo);
    }
  }

  private void updateTagInfoWhenMetaVersionChange(View paramView, ApplicationInfo paramApplicationInfo)
  {
    if (!paramApplicationInfo.isApplication());
    while (true)
    {
      return;
      ItemInfo localItemInfo = (ItemInfo)paramView.getTag();
      String[] arrayOfString = paramApplicationInfo.loadMetaComponentName(getContext(), true);
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          if ((((ApplicationInfo)localItemInfo).intent.getComponent().getPackageName() + "/" + ((ApplicationInfo)localItemInfo).intent.getComponent().getClassName()).equals(arrayOfString[i]))
          {
            ((ApplicationInfo)localItemInfo).setIcon(paramApplicationInfo.getIcon());
            ((ApplicationInfo)localItemInfo).title = paramApplicationInfo.title.toString();
            ((ApplicationInfo)localItemInfo).intent = paramApplicationInfo.generateIntent(paramApplicationInfo.componentName.getPackageName(), paramApplicationInfo.componentName.getClassName());
            if ((paramView instanceof BubbleTextView))
              ((BubbleTextView)paramView).applyFromApplicationInfo((ApplicationInfo)localItemInfo, ((LauncherApplication)this.mLauncher.getApplicationContext()).getIconCache());
            if (LauncherModel.DEBUG_META)
              Log.d("LauncherModelMeta", "updateDockbarItemApps -after setTag-- itemInfo = " + localItemInfo);
          }
          i += 1;
        }
      }
    }
  }

  private boolean willAddToExistingUserFolder(DropTarget.DragObject paramDragObject, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = getDistanceFromCellToPointer(paramDragObject.x, paramDragObject.y, paramInt2);
    if ((localObject[0] > this.mFolderCreationMaxDistanceX) || ((!paramBoolean) && (localObject[1] > this.mFolderCreationMaxDistanceY)))
      paramBoolean = false;
    do
    {
      return paramBoolean;
      localObject = getChildAt(paramInt1);
      if (!(localObject instanceof FolderIcon))
        break;
      paramBoolean = bool;
    }
    while (((FolderIcon)localObject).acceptDrop(paramDragObject.dragInfo));
    return false;
  }

  public boolean acceptDrop(DropTarget.DragObject paramDragObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.mLauncher.isWorkspaceInOrderMoreMode())
      bool1 = this.mLauncher.getColorRectManager().acceptDrop(this, paramDragObject);
    View localView;
    do
    {
      do
      {
        return bool1;
        if (getChildCount() < 4)
          break;
        localView = getChildAt(getPosInDock(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset));
        if (localView == null)
          break;
        bool1 = bool2;
      }
      while ((paramDragObject.dragInfo instanceof FolderInfo));
      if (!(localView instanceof FolderIcon))
        break;
      bool1 = bool2;
    }
    while (!((FolderIcon)localView).acceptDrop(paramDragObject.dragInfo));
    return true;
    return true;
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    int i = paramInt;
    if (paramInt < 0)
      i = getChildCount();
    super.addView(paramView, i, paramLayoutParams);
    syncAnim(paramView);
  }

  public View addViewInPos(Object paramObject, int paramInt)
  {
    if (paramObject == null)
      return null;
    ItemInfo localItemInfo = (ItemInfo)paramObject;
    int i;
    switch (localItemInfo.itemType)
    {
    case 2:
    default:
      throw new IllegalStateException("Unknown item type: " + localItemInfo.itemType);
    case 0:
    case 1:
      paramObject = this.mLauncher.createApplicationView(ScreenGridUtils.getApplicationLayout(true), this, (ApplicationInfo)localItemInfo);
      ViewGroup.LayoutParams localLayoutParams = paramObject.getLayoutParams();
      localLayoutParams.width = Utilities.getIconWidth();
      paramObject.setLayoutParams(localLayoutParams);
      paramObject.setOnLongClickListener(this.mLauncher);
      i = getChildCount();
      if (i == 0)
      {
        paramInt = 0;
        localItemInfo.cellX = 0;
        addView(paramObject, 0);
      }
      break;
    case 3:
    }
    while (true)
    {
      syncAnim(paramObject);
      updateDatabasesWhenInsertOneItem(localItemInfo, paramInt);
      return paramObject;
      paramObject = this.mLauncher.createFolderIcon((FolderInfo)localItemInfo, this);
      break;
      if (paramInt < 0)
      {
        paramInt = 0;
        localItemInfo.cellX = 0;
        addView(paramObject, 0);
      }
      else if (paramInt > i)
      {
        paramInt = i;
        localItemInfo.cellX = paramInt;
        addView(paramObject, paramInt);
      }
      else
      {
        localItemInfo.cellX = paramInt;
        addView(paramObject, paramInt);
      }
    }
  }

  public void beginShakeAnimations()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof IShakeInterface))
        ((IShakeInterface)localView).beginOrAdjustHintAnimations();
      i += 1;
    }
  }

  public void cancelDragFromDockbar()
  {
    clearChangeViewFlag();
    int i = getChildCount();
    clearAllPos();
    if (i < 4)
    {
      startAnimation(-1);
      return;
    }
    onDragOverOneItem(-1);
  }

  public void clear()
  {
    clearAllPos();
    clearDragView();
  }

  public void clearChangeViewFlag()
  {
    this.mChangeView = false;
  }

  public void computeScroll()
  {
    int j = 0;
    if (this.mIsAnimating)
    {
      int i = 0;
      while (i < getChildCount())
      {
        CallBacks localCallBacks = (CallBacks)getChildAt(i);
        int k = j;
        if (localCallBacks != null)
        {
          k = j;
          if (localCallBacks.isMoving())
            k = 1;
        }
        i += 1;
        j = k;
      }
      if (j == 0)
      {
        this.mIsAnimating = false;
        requestLayout();
      }
    }
  }

  public void dispatchDraw(Canvas paramCanvas)
  {
    if (this.mFolderOuterRings.size() > 0)
      drawFolderAnimation(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }

  public void drawFolderAnimation(Canvas paramCanvas)
  {
    Utilities.getIconWidth();
    Iterator localIterator = this.mFolderOuterRings.iterator();
    while (localIterator.hasNext())
    {
      BaseFolderIcon.FolderRingAnimator localFolderRingAnimator = (BaseFolderIcon.FolderRingAnimator)localIterator.next();
      Drawable localDrawable = localFolderRingAnimator.getSharedInnerRingDrawable();
      if (getChildCount() == 4)
        this.mTempLocation = getChildLeftAndTop(localFolderRingAnimator.mCellX, getChildCount(), false);
      int i = (int)localFolderRingAnimator.getOuterRingSize();
      int j = (int)localFolderRingAnimator.mXOffset;
      int k = this.mTempLocation[0];
      int m = getChildWidth() / 2;
      int n = this.mTempLocation[1];
      int i1 = BaseFolderIcon.FolderRingAnimator.sPreviewSize / 2;
      int i2 = BaseFolderIcon.FolderRingAnimator.sPreviewTopPadding;
      paramCanvas.save();
      paramCanvas.translate(k + m + j - i / 2, n + i1 + i2 - i / 2);
      localDrawable.setBounds(0, 0, i, i);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }

  public Rect estimateDropLocation(DragSource paramDragSource, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DragView paramDragView, Object paramObject, Rect paramRect)
  {
    return null;
  }

  View findNearestIcon(DropTarget.DragObject paramDragObject)
  {
    paramDragObject = getDragViewVisualCenter(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset, paramDragObject.dragView, null);
    int j = getChildCount();
    int[] arrayOfInt = new int[2];
    float f = getScaleX();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      arrayOfInt[0] = localView.getLeft();
      arrayOfInt[1] = localView.getTop();
      this.mLauncher.getDragLayer().getLocationInDragLayer(localView, arrayOfInt);
      int k = arrayOfInt[0];
      int m = (int)(arrayOfInt[0] + localView.getWidth() * f);
      if (m < paramDragObject[0]);
      do
      {
        i += 1;
        break;
        if (k > paramDragObject[0])
          return null;
      }
      while ((m < paramDragObject[0]) || (k > paramDragObject[0]));
      this.mDragInFolderPosition = i;
      return localView;
    }
    return null;
  }

  public boolean getChangeViewFlag()
  {
    return this.mChangeView;
  }

  public View getDragView()
  {
    return this.mDragView;
  }

  protected float[] getDragViewVisualCenter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, DragView paramDragView, float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      paramArrayOfFloat = new float[2];
    while (true)
    {
      int i = getResources().getDimensionPixelSize(2131361908);
      int j = getResources().getDimensionPixelSize(2131361909);
      paramArrayOfFloat[0] = (paramDragView.getDragRegion().width() / 2 + (paramInt1 + i - paramInt3));
      paramArrayOfFloat[1] = (paramDragView.getDragRegion().height() / 2 + (paramInt2 + j - paramInt4));
      return paramArrayOfFloat;
    }
  }

  public DropTarget getDropTargetDelegate(DropTarget.DragObject paramDragObject)
  {
    return null;
  }

  public void getHitRect(Rect paramRect)
  {
    super.getHitRect(paramRect);
    paramRect.left = 0;
    paramRect.top = getTop();
    paramRect.bottom = this.mLauncher.getDragLayer().getHeight();
    paramRect.right = this.mLauncher.getDragLayer().getWidth();
  }

  public void getLocationInDragLayer(int[] paramArrayOfInt)
  {
    this.mLauncher.getDragLayer().getLocationInDragLayer(this, paramArrayOfInt);
    paramArrayOfInt[0] = 0;
  }

  int getPosInDock(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = -1;
    int j = getChildCount();
    paramInt3 = 0;
    paramInt2 = 0;
    int[] arrayOfInt = new int[2];
    View localView;
    if ((j < 4) || (isOrderDockBar()))
    {
      i = 0;
      while (true)
      {
        paramInt3 = paramInt4;
        if (i < j)
        {
          localView = getChildAt(i);
          paramInt3 = paramInt2;
          if (localView.getVisibility() != 0)
            break label151;
          this.mTmpRect.setEmpty();
          localView.getHitRect(this.mTmpRect);
          arrayOfInt[0] = localView.getLeft();
          arrayOfInt[1] = localView.getTop();
          this.mLauncher.getDragLayer().getLocationInDragLayer(localView, arrayOfInt);
          if (paramInt1 < (int)(arrayOfInt[0] + localView.getWidth() * getScaleX() / 2.0F))
            paramInt3 = paramInt2;
        }
        else
        {
          paramInt1 = paramInt3;
          if (paramInt3 < 0)
            paramInt1 = j;
          return paramInt1;
        }
        paramInt3 = paramInt2 + 1;
        label151: i += 1;
        paramInt2 = paramInt3;
      }
    }
    int i = 0;
    for (paramInt2 = paramInt3; ; paramInt2 = paramInt3)
    {
      paramInt3 = paramInt4;
      if (i < j)
      {
        localView = getChildAt(i);
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 0)
          break label282;
        this.mTmpRect.setEmpty();
        localView.getHitRect(this.mTmpRect);
        arrayOfInt[0] = localView.getLeft();
        arrayOfInt[1] = localView.getTop();
        this.mLauncher.getDragLayer().getLocationInDragLayer(localView, arrayOfInt);
        if (paramInt1 < (int)(arrayOfInt[0] + localView.getWidth() * getScaleX()))
          paramInt3 = paramInt2;
      }
      else
      {
        paramInt1 = paramInt3;
        if (paramInt3 >= 0)
          break;
        return j - 1;
      }
      paramInt3 = paramInt2 + 1;
      label282: i += 1;
    }
  }

  public ItemInfo getSwitchInfo()
  {
    return this.mSwitchItemInfo;
  }

  public int[] getSwitchPostion()
  {
    return this.mSwitchPositon;
  }

  public int getVisibleChildCount()
  {
    int m = getChildCount();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      int k = j;
      if (localView != null)
      {
        k = j;
        if (localView.getVisibility() == 0)
          k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }

  public void hideFolderAccept(BaseFolderIcon.FolderRingAnimator paramFolderRingAnimator)
  {
    if (this.mFolderOuterRings.contains(paramFolderRingAnimator))
      this.mFolderOuterRings.remove(paramFolderRingAnimator);
    invalidate();
  }

  public boolean isAddToExistingFolderOnDrop()
  {
    return this.mAddToExistingFolderOnDrop;
  }

  public boolean isDropEnabled(DropTarget.DragObject paramDragObject)
  {
    if (this.mLauncher.getWorkspace().isFolderShowing());
    while ((!(paramDragObject.dragInfo instanceof ApplicationInfo)) && (!(paramDragObject.dragInfo instanceof FolderInfo)))
      return false;
    return true;
  }

  public boolean isOrderDockBar()
  {
    if (this.mLauncher.isWorkspaceInOrderMoreMode());
    return false;
  }

  public void notifyFolderAnimEnd()
  {
    startAnimation(-1);
    clearAllPos();
  }

  public void onDragEnter(DropTarget.DragObject paramDragObject)
  {
    if (this.mLauncher.isWorkspaceInOrderMoreMode())
      return;
    clearChangeViewFlag();
    if ((this.mLauncher != null) && (this.mLauncher.getWorkspace() != null))
      this.mLauncher.getWorkspace().removeFolderIcon(paramDragObject);
    int i;
    if (isOrderDockBar())
      i = getVisibleChildCount();
    int j;
    while (i < 4)
    {
      j = getPosInDock(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset);
      if (isOrderDockBar())
        break label231;
      View localView = findNearestIcon(paramDragObject);
      boolean bool = false;
      if ((localView instanceof CallBacks))
        bool = ((CallBacks)localView).isMoving();
      if ((localView != null) && ((localView instanceof FolderIcon)) && (!bool))
      {
        this.mWillChildCount = i;
        if (willAddToExistingUserFolder(paramDragObject, this.mDragInFolderPosition, this.mDragInFolderPosition, true))
        {
          this.mDragOverFolderIcon = null;
          this.mWillPos = this.mDragInFolderPosition;
          this.mDragInFolderPosition = -1;
          return;
          i = getChildCount();
        }
      }
      else
      {
        this.mWillChildCount = (i + 1);
        this.mDragInFolderPosition = -1;
        if ((this.mWillPos != j) && (!this.mIsAnimating))
          startAnimation(j);
      }
    }
    for (this.mWillPos = j; ; this.mWillPos = j)
    {
      label231: 
      do
      {
        this.mDragOverFolderIcon = null;
        checkTextVisible();
        return;
        i = this.mLauncher.getColorRectManager().getSelectedViews().size();
        int k = getVisibleChildCount() + i;
        if (k > 4)
          break;
        this.mWillChildCount = k;
        this.mWillPos = -1;
      }
      while ((this.mWillPos == j) || (this.mIsAnimating));
      startAnimation(j, i);
    }
  }

  public void onDragExit(DropTarget.DragObject paramDragObject)
  {
    if (this.mLauncher.isWorkspaceInOrderMoreMode())
      return;
    cleanupAddToFolder();
    if (paramDragObject.dragComplete)
    {
      Log.i("DockBar", "onDragExit return, dragObject.dragComplete = " + paramDragObject.dragComplete);
      return;
    }
    clearChangeViewFlag();
    int i = getChildCount();
    Object localObject1;
    if (i < 4)
    {
      paramDragObject = null;
      if (this.mLastFolderTempPosition != -1)
        paramDragObject = getChildAt(this.mLastFolderTempPosition);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramDragObject != null)
      {
        localObject1 = localObject2;
        if ((paramDragObject instanceof FolderIcon))
          localObject1 = ((FolderIcon)paramDragObject).getFolderRingAnimator();
      }
      if ((localObject1 != null) && (((BaseFolderIcon.FolderRingAnimator)localObject1).isExiting()))
      {
        ((BaseFolderIcon.FolderRingAnimator)localObject1).setNotifyParent(true);
        label128: setDragMode(0);
      }
    }
    while (true)
    {
      this.mLastFolderTempPosition = -1;
      this.mWillLastFolderTempPosition = -1;
      setDragMode(0);
      if (!isOrderDockBar())
        break;
      this.mIsAnimating = false;
      return;
      if ((localObject1 != null) && (this.mDragMode == 1) && (this.mWillChildCount == i + 1))
      {
        this.mTempLocation = getChildLeftAndTop(this.mWillLastFolderTempPosition, this.mWillChildCount, false);
        ((BaseFolderIcon.FolderRingAnimator)localObject1).setNotifyParent(true);
        break label128;
      }
      startAnimation(-1);
      clearAllPos();
      break label128;
      onDragOverOneItem(-1);
      clearAllPos();
    }
  }

  public void onDragOver(DropTarget.DragObject paramDragObject)
  {
    if (this.mLauncher.isWorkspaceInOrderMoreMode());
    int j;
    label363: 
    do
    {
      int m;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  m = getChildCount();
                  if (!isOrderDockBar())
                    break;
                  i = getVisibleChildCount();
                }
                while (i >= 4);
                j = getPosInDock(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset);
              }
              while ((this.mWillChildCount == i) || (this.mWillPos == j));
              k = this.mLauncher.getColorRectManager().getSelectedViews().size();
            }
            while (i + k > 4);
            startAnimation(j, k);
            this.mWillPos = j;
            return;
            if (m >= 4)
              break label363;
            j = getPosInDock(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset);
            if ((this.mWillChildCount == m) || (this.mWillPos == j) || (this.mIsAnimating) || (1 == this.mDragMode))
              break;
            paramDragObject = null;
            if (this.mLastFolderTempPosition != -1)
              paramDragObject = getChildAt(this.mLastFolderTempPosition);
          }
          while ((paramDragObject != null) && ((paramDragObject instanceof FolderIcon)) && (((FolderIcon)paramDragObject).getFolderRingAnimator() != null) && (((FolderIcon)paramDragObject).getFolderRingAnimator().isExiting()));
          startAnimation(j);
          this.mWillPos = j;
          this.mLastFolderTempPosition = -1;
          this.mWillLastFolderTempPosition = -1;
          return;
        }
        while (this.mIsAnimating);
        i = j;
        if (this.mWillPos != j)
          i = this.mWillPos;
        int k = findNearestPosition(paramDragObject);
        j = k;
        if (k < 0)
          j = 0;
        if ((this.mWillChildCount == m) || (j == i - 1) || (j == i + 1))
        {
          addToFolder(paramDragObject, j, i);
          return;
        }
      }
      while (1 != this.mDragMode);
      if (this.mWillChildCount == m)
      {
        this.mWillChildCount = (m + 1);
        this.mWillPos = -1;
      }
      setDragMode(0);
      return;
      j = getPosInDock(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset);
    }
    while (this.mWillPos == j);
    Object localObject = getChildAt(j);
    boolean bool2 = localObject instanceof FolderIcon;
    cleanupAddToFolder();
    boolean bool1 = bool2;
    if (bool2)
    {
      localObject = (FolderIcon)localObject;
      this.mDragOverFolderIcon = ((FolderIcon)localObject);
      if (!((FolderIcon)localObject).acceptDrop(paramDragObject.dragInfo))
        bool1 = true;
    }
    else
    {
      if ((!bool1) && (!(paramDragObject.dragInfo instanceof FolderInfo)))
        break label502;
    }
    label502: for (int i = 1; ; i = 0)
    {
      if (i == 0)
      {
        onDragOverOneItem(j);
        if (this.mDragOverFolderIcon != null)
          this.mDragOverFolderIcon.onDragEnter(paramDragObject.dragInfo);
      }
      this.mWillPos = j;
      return;
      bool1 = false;
      break;
    }
  }

  public void onDrop(DropTarget.DragObject paramDragObject)
  {
    if (isOrderDockBar())
    {
      this.mLauncher.getColorRectManager().onDrop(this, paramDragObject);
      checkTextVisible();
      return;
    }
    this.mLauncher.getWorkspace().sendCommandToCurrScreen(18, null);
    int i;
    ItemInfo localItemInfo;
    if (getChildCount() < 4)
    {
      i = getPosInDock(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset);
      if (this.mWillPos != i)
      {
        startAnimation(i);
        this.mWillPos = i;
      }
      localItemInfo = (ItemInfo)paramDragObject.dragInfo;
      Object localObject;
      if (this.mAddToExistingFolderOnDrop)
      {
        localObject = getChildAt(this.mLastFolderTempPosition);
        if ((localObject instanceof FolderIcon))
        {
          if ((paramDragObject.dragSource != this) || (this.mDragView == null))
            break label193;
          removeItemInfo(localItemInfo);
        }
        while (true)
        {
          updateDataBaseForDockBar();
          setOnDropWithTransX();
          ((FolderIcon)localObject).onDrop(paramDragObject);
          startAnimation(-1);
          setDragMode(0);
          this.mLastFolderTempPosition = -1;
          this.mWillLastFolderTempPosition = -1;
          this.mAddToExistingFolderOnDrop = false;
          paramDragObject.deferDragViewCleanupPostAnimation = true;
          clearAllPos();
          return;
          label193: this.mModel.removeItem(localItemInfo);
        }
      }
      if ((paramDragObject.dragSource == this) && (this.mDragView != null))
      {
        removeItemInfo(localItemInfo);
        this.mDragView.setVisibility(4);
        addView(this.mDragView, i);
        localObject = getChildLocation(i, this.mWillChildCount, true);
        paramDragObject.deferDragViewCleanupPostAnimation = true;
        this.mLauncher.getDragLayer().animateViewIntoPosition(paramDragObject.dragView, this.mDragView, (Rect)localObject, -1, null, this);
        updateDataBaseForDockBar();
        if (i > sScreenData.mItems.size())
          sScreenData.mItems.add(localItemInfo);
      }
    }
    while (true)
    {
      if (this.mDragView != null);
      clear();
      requestLayout();
      checkTextVisible();
      return;
      sScreenData.mItems.add(i, localItemInfo);
      continue;
      this.mModel.removeItem(localItemInfo);
      addViewInPos(paramDragObject.dragInfo, this.mWillPos);
      paramDragObject.deferDragViewCleanupPostAnimation = false;
      continue;
      onDragOverOneItem(-1);
      i = getPosInDock(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset);
      if ((this.mWillPos != i) && (!this.mIsAnimating))
      {
        startAnimation(i);
        this.mWillPos = i;
      }
      if (paramDragObject.dragSource != this)
        changeViewIntentInPos(paramDragObject.dragSource, paramDragObject.dragInfo, this.mWillPos);
      paramDragObject.deferDragViewCleanupPostAnimation = false;
    }
  }

  public void onDropCompleted(View paramView, DropTarget.DragObject paramDragObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (this.mLauncher != null))
      LauncherStatistics.getInstance(this.mLauncher).launcherStatisticsDropFailedWhenOrder(this.mLauncher.getWorkspace().getOrderMode());
    if (isOrderDockBar())
    {
      if (!paramBoolean2)
        this.mLauncher.getColorRectManager().goBackAnimation(true);
      while (!paramBoolean1)
        return;
      this.mWillChildCount = -1;
    }
    if (!paramBoolean2)
      if (this.mDragView != null)
      {
        this.mWillChildCount = (getChildCount() + 1);
        this.mLauncher.getWorkspace().sendCommandToCurrScreen(18, null);
        int i = ((ItemInfo)this.mDragView.getTag()).cellX;
        startAnimation(i);
        if ((i > -1) && (i <= getChildCount()))
        {
          addView(this.mDragView, i);
          this.mDragView.setVisibility(0);
        }
        paramDragObject.deferDragViewCleanupPostAnimation = false;
      }
    while (true)
    {
      clear();
      return;
      if (paramView != this)
      {
        removeItemInfo((ItemInfo)paramDragObject.dragInfo);
        if ((paramDragObject.dragInfo instanceof FolderInfo))
          removeFolderInfo((FolderInfo)paramDragObject.dragInfo);
        updateDataBaseForDockBar();
        requestLayout();
      }
    }
  }

  public void onFlingToDelete(DropTarget.DragObject paramDragObject, int paramInt1, int paramInt2, PointF paramPointF)
  {
  }

  public void onFlingToDeleteCompleted()
  {
  }

  protected void onLayoutChildren()
  {
    int m = getChildCount();
    int n = getChildWidth();
    int i1 = getFirstChildLeft(m);
    int i2 = getPaddingTop();
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      Object localObject = localView.getLayoutParams();
      int k = 0;
      int j = k;
      if (((ViewGroup.LayoutParams)localObject).width != n)
      {
        j = k;
        if (!this.mIsAnimating)
        {
          j = 1;
          ((ViewGroup.LayoutParams)localObject).width = n;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = (CallBacks)localView;
      if ((localView.getVisibility() != 8) && (!((CallBacks)localObject).isMoving()))
      {
        k = localView.getMeasuredHeight();
        int i3 = i1 + n * i;
        localView.layout(i3, i2, i3 + n, i2 + k);
        if (j != 0)
          localView.requestLayout();
      }
      i += 1;
    }
  }

  public void onTextVisible(boolean paramBoolean)
  {
    if ((Utilities.mHasNavigationBar) && (!paramBoolean));
    while (true)
    {
      return;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        if ((localView instanceof IIconTextVisible))
          ((IIconTextVisible)localView).onTextVisible(paramBoolean);
        i += 1;
      }
    }
  }

  public void preOnDrop(DropTarget.DragObject paramDragObject)
  {
    onDragOverOneItem(-1);
    if (this.mDragMode == 1)
    {
      this.mAddToExistingFolderOnDrop = true;
      return;
    }
    cleanupAddToFolder();
  }

  public void removeAllNewInstallPrefix()
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof BubbleTextView))
      {
        ApplicationInfo localApplicationInfo = (ApplicationInfo)localView.getTag();
        if (localApplicationInfo.newinstalled == 1)
          ((BubbleTextView)localView).setText(localApplicationInfo.title);
      }
      while (true)
      {
        i += 1;
        break;
        if ((localView instanceof FolderIcon))
          ((FolderIcon)localView).removeAllNewInstallPrefix();
      }
    }
  }

  public void removeDragViewApp(Object paramObject)
  {
  }

  public void removeFolderInfo(FolderInfo paramFolderInfo)
  {
    sScreenData.mFolders.remove(paramFolderInfo);
  }

  public void removeItemInfo(ItemInfo paramItemInfo)
  {
    sScreenData.mItems.remove(paramItemInfo);
  }

  void removeItems(ArrayList<ApplicationInfo> paramArrayList)
  {
    removeItems(paramArrayList, false, false);
  }

  void removeItems(ArrayList<ApplicationInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0));
    int j;
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      for (int i = 0; i < getChildCount(); i = j + 1)
      {
        localObject1 = getChildAt(i);
        Object localObject2 = ((View)localObject1).getTag();
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if ((!paramBoolean1) && ((localObject2 instanceof FolderInfo)))
        {
          localObject1 = (FolderInfo)localObject2;
          localObject3 = ((FolderInfo)localObject1).contents;
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (ApplicationInfo)((Iterator)localObject3).next();
            localObject5 = ((ApplicationInfo)localObject4).intent.getComponent();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
              if (((((ApplicationInfo)localObject4).isApplication()) && (((ComponentName)localObject5).equals(localApplicationInfo.componentName))) || ((((ApplicationInfo)localObject4).isShortcut()) && (((ApplicationInfo)localObject4).packageName != null) && (((ApplicationInfo)localObject4).packageName.equals(localApplicationInfo.packageName))))
              {
                LauncherModel.deleteItemFromDatabase(this.mLauncher, (ItemInfo)localObject4);
                ((ArrayList)localObject2).add(localObject4);
              }
            }
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          while (true)
          {
            j = i;
            if (!((Iterator)localObject2).hasNext())
              break;
            ((FolderInfo)localObject1).remove((ApplicationInfo)((Iterator)localObject2).next());
            if (((FolderInfo)localObject1).contents.size() == 0)
              i -= 1;
          }
        }
        j = i;
        if ((localObject2 instanceof ApplicationInfo))
        {
          localObject2 = (ApplicationInfo)localObject2;
          localObject3 = ((ApplicationInfo)localObject2).intent.getComponent();
          localObject4 = paramArrayList.iterator();
          while (true)
          {
            j = i;
            if (!((Iterator)localObject4).hasNext())
              break;
            localObject5 = (ApplicationInfo)((Iterator)localObject4).next();
            if (((ApplicationInfo)localObject2).isApplication())
            {
              if (((ComponentName)localObject3).equals(((ApplicationInfo)localObject5).componentName))
                localArrayList.add(localObject1);
            }
            else if (((ApplicationInfo)localObject2).isShortcut())
              if (paramBoolean2)
              {
                if ((((ApplicationInfo)localObject2).intent != null) && (((ApplicationInfo)localObject2).intent.toUri(0).equals(((ApplicationInfo)localObject5).intent.toUri(0))))
                  localArrayList.add(localObject1);
              }
              else if ((((ApplicationInfo)localObject2).packageName != null) && (((ApplicationInfo)localObject2).packageName.equals(((ApplicationInfo)localObject5).packageName)))
                localArrayList.add(localObject1);
          }
        }
      }
      j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        paramArrayList = (View)localArrayList.get(i);
        localObject1 = (ItemInfo)paramArrayList.getTag();
        removeView(paramArrayList);
        removeItemInfo((ItemInfo)localObject1);
        if (!paramBoolean2)
          LauncherModel.deleteItemFromDatabase(this.mLauncher, (ItemInfo)localObject1);
        i += 1;
      }
    }
    while (j <= 0);
    updateDataBaseForDockBar();
  }

  void removeShortcut(ApplicationInfo paramApplicationInfo)
  {
    if (paramApplicationInfo == null);
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      for (int i = 0; i < getChildCount(); i = j + 1)
      {
        localObject1 = getChildAt(i);
        Object localObject2 = (ItemInfo)((View)localObject1).getTag();
        if ((localObject2 instanceof FolderInfo))
        {
          localObject1 = (FolderInfo)localObject2;
          Object localObject3 = ((FolderInfo)localObject1).contents;
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ApplicationInfo localApplicationInfo = (ApplicationInfo)((Iterator)localObject3).next();
            if (localApplicationInfo == paramApplicationInfo)
              ((ArrayList)localObject2).add(localApplicationInfo);
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          while (true)
          {
            j = i;
            if (!((Iterator)localObject2).hasNext())
              break;
            localObject3 = (ApplicationInfo)((Iterator)localObject2).next();
            ((FolderInfo)localObject1).remove((ApplicationInfo)localObject3);
            LauncherModel.deleteItemFromDatabase(this.mLauncher, (ItemInfo)localObject3);
            if (((FolderInfo)localObject1).contents.size() == 0)
              i -= 1;
          }
        }
        j = i;
        if ((localObject2 instanceof ApplicationInfo))
        {
          j = i;
          if ((ApplicationInfo)localObject2 == paramApplicationInfo)
          {
            localArrayList.add(localObject1);
            j = i;
          }
        }
      }
      int j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        paramApplicationInfo = (View)localArrayList.get(i);
        localObject1 = (ItemInfo)paramApplicationInfo.getTag();
        removeView(paramApplicationInfo);
        removeItemInfo((ItemInfo)localObject1);
        LauncherModel.deleteItemFromDatabase(this.mLauncher, (ItemInfo)localObject1);
        i += 1;
      }
    }
  }

  public void restoreDragInfo(DropTarget.DragObject paramDragObject)
  {
  }

  public void restoreDragInfo(Object paramObject)
  {
    if (this.mDragView != null)
    {
      paramObject = (ItemInfo)this.mDragView.getTag();
      addView(this.mDragView, paramObject.cellX);
    }
    clear();
  }

  public void setChildViewAlpha(float paramFloat, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      localView.setAlpha(paramFloat);
      if ((localView instanceof FolderIcon))
      {
        if (!paramBoolean)
          break label62;
        if (localView.getLayerType() != 2)
          localView.setLayerType(2, null);
      }
      while (true)
      {
        i += 1;
        break;
        label62: if (localView.getLayerType() != 0)
          localView.setLayerType(0, null);
      }
    }
  }

  public void setDragController(DragController paramDragController)
  {
    this.mDragController = paramDragController;
  }

  public void showFolderAccept(BaseFolderIcon.FolderRingAnimator paramFolderRingAnimator)
  {
    this.mFolderOuterRings.add(paramFolderRingAnimator);
  }

  public void startDrag(View paramView)
  {
    if (this.mDragController.isDragging())
      return;
    this.mWillPos = indexOfChild(paramView);
    this.mWillChildCount = getChildCount();
    this.mDragView = paramView;
    this.mLauncher.getWorkspace().sendCommandToCurrScreen(17, null);
    if ((paramView instanceof BubbleTextView))
      ((BubbleTextView)paramView).setNormalSize(true);
    ((IIconTextVisible)paramView).onTextVisible(true);
    this.mDragController.startDrag(paramView, this, paramView.getTag(), DragController.DRAG_ACTION_MOVE, null, false, 1.0F);
    ((IIconTextVisible)paramView).onTextVisible(false);
    if ((paramView instanceof BubbleTextView))
      ((BubbleTextView)paramView).setNormalSize(false);
    removeView(paramView);
  }

  public void stopShakeAnimations(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof IShakeInterface))
        ((IShakeInterface)localView).completeAndClearReorderHintAnimations(paramBoolean);
      i += 1;
    }
  }

  public boolean supportsFlingToDelete()
  {
    return false;
  }

  public void syncAnim(View paramView)
  {
    if (paramView == null);
    final Workspace localWorkspace;
    do
    {
      do
      {
        return;
        localWorkspace = this.mLauncher.getWorkspace();
      }
      while (localWorkspace == null);
      if ((getChildCount() == 1) && (getChildAt(0) == paramView) && (localWorkspace.isOrderOneMode()))
      {
        ((IShakeInterface)paramView).beginOrAdjustHintAnimations();
        return;
      }
    }
    while (!(paramView instanceof IShakeInterface));
    int i = 0;
    while (true)
    {
      View localView = null;
      if (i < getChildCount())
      {
        localView = getChildAt(i);
        if ((localView == null) || (!(localView instanceof IShakeInterface)) || (localView.getVisibility() != 0) || (localView == paramView));
      }
      else
      {
        if (localView != null)
        {
          ((IShakeInterface)paramView).completeAndClearReorderHintAnimations(false);
          ((IShakeInterface)localView).joinAnimations(paramView);
        }
        postDelayed(new Runnable()
        {
          public void run()
          {
            boolean bool = localWorkspace.isOrderOneMode();
            if ((!bool) || (this.val$followView.isShaking()));
            label126: 
            do
            {
              return;
              Object localObject = null;
              int i = 0;
              while (true)
              {
                if (i < DockBar.this.getChildCount())
                {
                  View localView = DockBar.this.getChildAt(i);
                  if ((localView != null) && ((localView instanceof IShakeInterface)) && (localView.getVisibility() == 0) && (localView != this.val$followView))
                  {
                    localObject = localView;
                    if (!((IShakeInterface)localView).isShaking())
                      break label126;
                    localObject = localView;
                  }
                }
                else
                {
                  if (localObject == null)
                    break;
                  this.val$followView.completeAndClearReorderHintAnimations(false);
                  ((IShakeInterface)localObject).joinAnimations((View)this.val$followView);
                  return;
                }
                localObject = null;
                i += 1;
              }
            }
            while (!bool);
            DockBar.this.beginShakeAnimations();
          }
        }
        , 300L);
        return;
      }
      i += 1;
    }
  }

  public void updateDockbarItemApps(ArrayList<ApplicationInfo> paramArrayList)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject1 = getChildAt(i);
      Object localObject2 = (ItemInfo)((View)localObject1).getTag();
      if (((localObject2 instanceof FolderInfo)) && ((localObject1 instanceof FolderIcon)))
      {
        localObject1 = (FolderIcon)localObject1;
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
          ((FolderIcon)localObject1).updateAppInfo((ApplicationInfo)((Iterator)localObject2).next());
        ((FolderIcon)localObject1).invalidate();
      }
      while (true)
      {
        i += 1;
        break;
        if ((localObject2 instanceof ApplicationInfo))
        {
          localObject2 = (ApplicationInfo)localObject2;
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
            BubbleTextView localBubbleTextView = (BubbleTextView)localObject1;
            if ((((ApplicationInfo)localObject2).packageName != null) && (localApplicationInfo.packageName != null) && (((ApplicationInfo)localObject2).packageName.equals(localApplicationInfo.packageName)))
              localBubbleTextView.updateTextPrefixAndAlphaWhenAppInfoUpdated(localApplicationInfo);
            if ((((ApplicationInfo)localObject2).isApplication()) && (localApplicationInfo != null) && (localApplicationInfo.componentName != null))
              if (localApplicationInfo.componentName.toString().equals(((ApplicationInfo)localObject2).componentName.toString()))
              {
                ((ApplicationInfo)localObject2).setIcon(localApplicationInfo.getIcon());
                ((ApplicationInfo)localObject2).intent = new Intent(localApplicationInfo.intent);
                ((ApplicationInfo)localObject2).title = localApplicationInfo.title.toString();
                LauncherModel.updateItemInDatabase(this.mLauncher, (ItemInfo)localObject2);
                if ((localBubbleTextView.mDrawableTop != null) && ((localBubbleTextView.mDrawableTop instanceof FastBitmapDrawable)))
                  localBubbleTextView.mDrawableTop.setBitmap(localApplicationInfo.getIconBitmap());
                else
                  localBubbleTextView.setCompoundDrawablesWithIntrinsicBounds(null, ((ApplicationInfo)localObject2).getIcon(), null, null);
              }
              else if (localApplicationInfo.getMetaVersion() > 0)
              {
                updateTagInfoWhenMetaVersionChange((View)localObject1, localApplicationInfo);
              }
          }
        }
      }
    }
  }

  public void updateDrawables()
  {
  }

  void updateFolderChildToDataBase(FolderInfo paramFolderInfo)
  {
    if (paramFolderInfo == null);
    do
    {
      return;
      if ((this.mModel != null) && (this.mModel.contains(paramFolderInfo)))
      {
        this.mModel.removeItem(paramFolderInfo);
        this.mModel.removeFolder(paramFolderInfo);
      }
    }
    while (this.mModel == null);
    this.mModel.updateItemsScreenIdInFolder(this.mLauncher, paramFolderInfo, 999, new Runnable()
    {
      public void run()
      {
        Workspace localWorkspace = DockBar.this.mLauncher.getWorkspace();
        if ((localWorkspace != null) && (localWorkspace.isNormal()))
          localWorkspace.removeNullScreen(true);
      }
    });
  }

  public void updateTextColor(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof IUpdateTextColor))
        ((IUpdateTextColor)localView).updateTextColor(paramInt);
      i += 1;
    }
  }

  public static abstract interface CallBacks
  {
    public abstract void endMove();

    public abstract boolean isMoving();

    public abstract void startMove(int paramInt1, int paramInt2, boolean paramBoolean);
  }

  public static class MovingHelper
  {
    private boolean mMoving = false;
    private ElasticInterpolator mScrollInterpolator = null;
    private ElasticScroller mScroller;

    public MovingHelper(View paramView, Context paramContext)
    {
      this.mScroller = new ElasticScroller(paramContext);
      this.mScrollInterpolator = new ElasticInterpolator();
      this.mScrollInterpolator.setTension(3.0F);
    }

    public static MovingHelper getInstance(View paramView, Context paramContext)
    {
      return new MovingHelper(paramView, paramContext);
    }

    public boolean computeScrollOffset()
    {
      return this.mScroller.computeScrollOffset();
    }

    public void endMove()
    {
      this.mMoving = false;
    }

    public int getCurrX()
    {
      return this.mScroller.getCurrX();
    }

    public int getCurrY()
    {
      return this.mScroller.getCurrY();
    }

    public Interpolator getInterpolator(boolean paramBoolean)
    {
      if (paramBoolean)
        return new Interpolator()
        {
          public float getInterpolation(float paramAnonymousFloat)
          {
            return MovingHelper.this.mScroller.viscousFluid(paramAnonymousFloat);
          }
        };
      return this.mScrollInterpolator;
    }

    public boolean isMoving()
    {
      return this.mMoving;
    }

    public void startMove(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      if (paramBoolean)
        this.mScroller.setInterpolator(null);
      while (true)
      {
        this.mMoving = true;
        this.mScroller.startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
        this.mScroller.setInterpolator(this.mScrollInterpolator);
      }
    }

    public void startMove(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
    {
      if (paramBoolean)
        this.mScroller.setInterpolator(null);
      while (true)
      {
        this.mMoving = true;
        this.mScroller.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        return;
        this.mScroller.setInterpolator(this.mScrollInterpolator);
      }
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.DockBar
 * JD-Core Version:    0.6.2
 */