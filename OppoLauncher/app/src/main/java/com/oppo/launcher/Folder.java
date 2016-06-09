package com.oppo.launcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.oppo.NearMeStatistics.LauncherStatistics;
import com.oppo.launcher.animation.OppoBezierInterpolator;
import com.oppo.launcher.graphic.IUpdateTextColor;
import com.oppo.launcher.screenGrid.ScreenGridUtils;
import com.oppo.launcher.theme.ThemeUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.ArrayList<Landroid.view.View;>;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Folder extends BaseFolder
  implements FolderInfo.FolderListener
{
  static final boolean DEBUG_DRAG = false;
  static final boolean DEBUG_ENABLE = false;
  static final boolean DEBUG_NORMAL = false;
  private static final int FOLDER_ZOOM_CLOSE_DURATION = 270;
  private static final int FOLDER_ZOOM_OPEN_DURATION = 320;
  private static final String TAG = "Launcher.Folder";
  private static final int TOUCH_TO_CLOSE_FOLDER_TIMEOUT = 2000;
  private long mActionDownMills;
  public Callback mActionModeCallback = new Callback()
  {
    public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
    {
      return false;
    }

    public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
    {
      return false;
    }

    public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
    {
    }

    public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
    {
      return false;
    }
  };
  AlphaComparator mAlphaComparator = new AlphaComparator();
  protected CellLayout mContent;
  private ApplicationInfo mCurrentDragInfo;
  private Runnable mDeferredGobackAction;
  ApplicationInfo mDropItem = null;
  ItemInfo mFinalItem = null;
  View mFinalView = null;
  private int mFoldScrollPaddingBottom;
  private int mFoldScrollPaddingLeft;
  private int mFoldScrollPaddingRight;
  private int mFoldScrollPaddingTop;
  private Drawable mFolderHeaderBg;
  private FolderIcon mFolderIcon;
  private Drawable mFolderScrollerBg;
  protected float mFolderShrinkFactor;
  protected FolderInfo mInfo;
  PositionComparator mPositionComparator = new PositionComparator();
  public OnAlarmListener mReorderAlarmListener = new OnAlarmListener()
  {
    public void onAlarm(Alarm paramAnonymousAlarm)
    {
      Folder.this.realTimeReorder(Folder.this.mEmptyCell, Folder.this.mTargetCell);
    }
  };
  private float mScrollerBgAlpha = 0.0F;
  private int mTotalHeight;

  public Folder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.mFolderHeaderBg = paramContext.getDrawable(2130837530);
    this.mFolderScrollerBg = paramContext.getDrawable(2130837531);
    this.mFoldScrollPaddingLeft = paramContext.getDimensionPixelSize(2131361854);
    this.mFoldScrollPaddingRight = paramContext.getDimensionPixelSize(2131361855);
    this.mFoldScrollPaddingTop = paramContext.getDimensionPixelSize(2131361853);
    this.mFoldScrollPaddingBottom = paramContext.getDimensionPixelSize(2131361856);
    this.mFolderShrinkFactor = (paramContext.getInteger(2131296263) / 100.0F);
  }

  public static Folder fromXml(Context paramContext)
  {
    return (Folder)LayoutInflater.from(paramContext).inflate(2130968593, null);
  }

  private boolean getPreEmptyCell(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = paramArrayOfInt2;
    if (paramArrayOfInt2 == null)
      arrayOfInt = new int[2];
    int j = paramArrayOfInt1[0];
    int k = paramArrayOfInt1[1];
    int n = k;
    int i = k;
    while (i >= 0)
    {
      int m = n;
      if (i != n)
      {
        j = this.mContent.getCellCountX() - 1;
        m = i;
      }
      n = j;
      while (n >= 0)
      {
        if ((this.mContent.getChildAt(n, i) == null) && ((i != k) || (n != j)))
        {
          arrayOfInt[0] = n;
          arrayOfInt[1] = i;
          return true;
        }
        n -= 1;
      }
      i -= 1;
      n = m;
    }
    return false;
  }

  private ApplicationInfo isExistsInFolder(ApplicationInfo paramApplicationInfo)
  {
    Object localObject2 = null;
    Iterator localIterator = this.mInfo.contents.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext())
        break;
      localObject1 = (ApplicationInfo)localIterator.next();
    }
    while (!LauncherUtil.isApplicationInfoEqualed((ApplicationInfo)localObject1, paramApplicationInfo));
    return localObject1;
  }

  private boolean isExistsInFolder(ArrayList<ApplicationInfo> paramArrayList, ApplicationInfo paramApplicationInfo)
  {
    boolean bool2 = false;
    paramArrayList = paramArrayList.iterator();
    do
    {
      bool1 = bool2;
      if (!paramArrayList.hasNext())
        break;
    }
    while (!LauncherUtil.isApplicationInfoEqualed((ApplicationInfo)paramArrayList.next(), paramApplicationInfo));
    boolean bool1 = true;
    return bool1;
  }

  private void resetGridSize(int paramInt)
  {
    this.mContent.getCellCountX();
    this.mContent.getCellCountY();
    int i;
    int j;
    if (this.mOpenInDragMode)
    {
      i = 1;
      j = this.mMaxCountX;
      if (paramInt % this.mMaxCountX == 0)
        break label63;
      paramInt = paramInt / this.mMaxCountX + 1;
    }
    while (true)
    {
      this.mContent.setGridSize(j, paramInt);
      return;
      i = 0;
      break;
      label63: if (paramInt > 0)
        paramInt = paramInt / this.mMaxCountX + i;
      else
        paramInt = 1;
    }
  }

  private void updateFolderEditTextColor(int paramInt)
  {
    Context localContext = getContext();
    if (this.mFoldShower != null)
      this.mFoldShower.setTextAppearance(localContext, paramInt);
    if (this.mFolderName != null)
      this.mFolderName.setTextAppearance(localContext, paramInt);
  }

  public void animateClosed()
  {
    if (!(getParent() instanceof DragLayer))
      return;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    if (this.mMode == 1)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 0.1F }) });
      localObjectAnimator.setDuration(270L);
      localArrayList.add(localObjectAnimator);
    }
    while (true)
    {
      localArrayList.add(drawZoomAnimation(false));
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          Folder.this.mItemsInvalidated = true;
          Folder.this.onCloseComplete();
          Folder.this.mState = 0;
          if (Folder.this.mDeferredGobackAction != null)
            Folder.this.mDeferredGobackAction.run();
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          Folder.this.sendCustomAccessibilityEvent(32, Folder.this.getContext().getString(2131427354));
          Folder.this.mState = 1;
          Folder.this.endTidyuping();
          Folder.this.mFolderHeader.setVisibility(4);
          Folder.this.showFolderScrollerBackground(false);
        }
      });
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      if (!this.mOpenInDragMode)
        break;
      this.mOpenInDragMode = false;
      return;
      ObjectAnimator.ofPropertyValuesHolder((DragLayer.LayoutParams)getLayoutParams(), new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("width", new int[] { this.mIconRect.width() }), PropertyValuesHolder.ofInt("height", new int[] { this.mIconRect.height() }), PropertyValuesHolder.ofInt("x", new int[] { this.mIconRect.left }), PropertyValuesHolder.ofInt("y", new int[] { this.mIconRect.top }) }).addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          Folder.this.requestLayout();
        }
      });
    }
  }

  public void animateOpen()
  {
    if (this.mDragController.isDragging())
    {
      this.mOpenInDragMode = true;
      this.mMoveInValidAera = false;
    }
    while (true)
    {
      setupContentDimensions(getItemCount());
      this.mFolderScoll.smoothScrollTo(0, 0);
      positionAndSizeAsIcon();
      localObject1 = this.mLauncher.getDragLayer();
      measure(MeasureSpec.makeMeasureSpec(((DragLayer)localObject1).getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(((DragLayer)localObject1).getHeight(), 1073741824));
      layoutChildren();
      if ((getParent() instanceof DragLayer))
        break;
      return;
      this.mOpenInDragMode = false;
    }
    Object localObject1 = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (DragLayer.LayoutParams)getLayoutParams();
    centerAboutIcon();
    final View localView = this.mLauncher.getWorkspace().getChildAt(this.mLauncher.getModel().getScreenIndex(this.mInfo.screenId));
    final DockBar localDockBar = this.mLauncher.getDockBar();
    final PagePointView localPagePointView = this.mLauncher.getWorkspace().getScrollingIndicator();
    if (this.mMode == 1)
    {
      localObject2 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F }) });
      ((ObjectAnimator)localObject2).setDuration(this.mFoldAlphaAnimDuration);
      localArrayList.add(localObject2);
    }
    while (true)
    {
      localArrayList.add(drawZoomAnimation(true));
      ((AnimatorSet)localObject1).addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (Folder.this.getParent() == null)
          {
            Folder.this.mState = 0;
            if (localView != null)
              localView.setAlpha(1.0F);
            if (localDockBar != null)
              localDockBar.setAlpha(1.0F);
            if (localPagePointView != null)
              localPagePointView.setAlpha(1.0F);
            Folder.this.mFolderHeader.setVisibility(0);
            if (!Folder.this.mLauncher.isWorkspaceInOrderMoreMode())
              break label186;
            Folder.this.mFoldShower.setClickable(false);
          }
          while (true)
          {
            Folder.this.mFolderScoll.setScrollBarDefaultDelayBeforeFade(1000);
            if ((Folder.this.mCanRemoveFolder) && (!Folder.this.mOpenInDragMode))
              Folder.this.mLauncher.getWorkspace().fillEmptyAfterCreateOrAddToFolder((CellLayout)Folder.this.mFolderIcon.getParent(), null, false);
            return;
            Folder.this.mState = 2;
            Folder.this.requestFocus();
            Folder.this.startTidyuping();
            break;
            label186: Folder.this.mFoldShower.setClickable(true);
          }
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          Folder.this.sendCustomAccessibilityEvent(32, String.format(Folder.this.getContext().getString(2131427353), new Object[] { Integer.valueOf(Folder.this.mContent.getCellCountX()), Integer.valueOf(Folder.this.mContent.getCellCountY()) }));
          Folder.this.mState = 1;
          Folder.this.mFolderHeader.setVisibility(0);
        }
      });
      ((AnimatorSet)localObject1).playTogether(localArrayList);
      ((AnimatorSet)localObject1).start();
      if (!this.mOpenInDragMode)
        break;
      int i = getItemCount();
      this.mEmptyCell[0] = (i % this.mContent.getCellCountX());
      this.mEmptyCell[1] = (i / this.mContent.getCellCountX());
      return;
      ObjectAnimator.ofPropertyValuesHolder(localObject2, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("width", new int[] { this.mNewSize.width() }), PropertyValuesHolder.ofInt("height", new int[] { this.mNewSize.height() }), PropertyValuesHolder.ofInt("x", new int[] { this.mNewSize.left }), PropertyValuesHolder.ofInt("y", new int[] { this.mNewSize.top }) }).addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          Folder.this.requestLayout();
        }
      });
      localObject2 = PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F });
      localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.mContent, new PropertyValuesHolder[] { localObject2 });
      ((ObjectAnimator)localObject2).setDuration(this.mFoldScaleAnimDuration);
      ((ObjectAnimator)localObject2).setInterpolator(new AccelerateInterpolator(2.0F));
      ((ObjectAnimator)localObject2).start();
    }
  }

  public void animateOpen(boolean paramBoolean)
  {
    this.mCanRemoveFolder = paramBoolean;
    animateOpen();
  }

  public void arrangeChildren(ArrayList<View> paramArrayList)
  {
    int[] arrayOfInt = new int[2];
    Object localObject1 = paramArrayList;
    if (paramArrayList == null)
      localObject1 = getItemsInReadingOrder();
    this.mContent.removeAllViews();
    ArrayList localArrayList = new ArrayList();
    paramArrayList = null;
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    if (localIterator.hasNext())
    {
      localObject1 = (View)localIterator.next();
      this.mContent.getVacantCell(arrayOfInt, 1, 1);
      BaseCellLayout.LayoutParams localLayoutParams = (BaseCellLayout.LayoutParams)((View)localObject1).getLayoutParams();
      localLayoutParams.cellX = arrayOfInt[0];
      localLayoutParams.cellY = arrayOfInt[1];
      ItemInfo localItemInfo = (ItemInfo)((View)localObject1).getTag();
      if ((localItemInfo.cellX != arrayOfInt[0]) || (localItemInfo.cellY != arrayOfInt[1]))
      {
        localObject2 = (ApplicationInfo)localItemInfo;
        i = arrayOfInt[0];
        localItemInfo.cellX = i;
        ((ApplicationInfo)localObject2).tmpFolderCellX = i;
        localObject2 = (ApplicationInfo)localItemInfo;
        i = arrayOfInt[1];
        localItemInfo.cellY = i;
        ((ApplicationInfo)localObject2).tmpFolderCellY = i;
        localArrayList.add(localItemInfo);
      }
      Object localObject2 = this.mContent;
      if (0 != 0);
      for (int i = 0; ; i = -1)
      {
        ((CellLayout)localObject2).addViewToCellLayout((View)localObject1, i, (int)localItemInfo.id, localLayoutParams, true);
        if (this.mDropItem != localItemInfo)
          break;
        paramArrayList = (ArrayList<View>)localObject1;
        break;
      }
    }
    if ((this.mLauncher != null) && (this.mLauncher.getWorkspace() != null) && (paramArrayList != null))
      syncAnim(paramArrayList);
    this.mItemsInvalidated = true;
    if (localArrayList.size() > 0)
    {
      if (this.mModel != null)
        this.mModel.updateDatabaseRunnable(this.mLauncher, localArrayList, this.mInfo.id, this.mInfo.screenId, LauncherModel.UpdateDatabaseMode.INSERT_OR_UPDATE, false, null);
    }
    else
      return;
    Log.w("Launcher.Folder", "arrangeChildren mModel == null");
  }

  public void bind(FolderInfo paramFolderInfo)
  {
    this.mInfo = paramFolderInfo;
    Object localObject2 = paramFolderInfo.contents;
    paramFolderInfo = new ArrayList();
    Object localObject1 = new ArrayList();
    setupContentForNumItems(((ArrayList)localObject2).size());
    int i = 0;
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)((Iterator)localObject2).next();
      if ((isExistsInFolder((ArrayList)localObject1, localApplicationInfo)) || (!createAndAddApplication(localApplicationInfo)))
      {
        paramFolderInfo.add(localApplicationInfo);
      }
      else
      {
        ((ArrayList)localObject1).add(localApplicationInfo);
        i += 1;
      }
    }
    setupContentForNumItems(i);
    paramFolderInfo = paramFolderInfo.iterator();
    while (paramFolderInfo.hasNext())
    {
      localObject1 = (ApplicationInfo)paramFolderInfo.next();
      this.mInfo.remove((ApplicationInfo)localObject1);
      LauncherModel.deleteItemFromDatabase(this.mLauncher, (ItemInfo)localObject1);
    }
    this.mItemsInvalidated = true;
    updateTextViewFocus();
    this.mInfo.addListener(this);
    if (!sDefaultFolderName.contentEquals(this.mInfo.title))
    {
      this.mFoldShower.setText(LauncherUtil.getRealSystemFolderTitle(this.mLauncher, this.mInfo.title.toString()), BufferType.EDITABLE);
      return;
    }
    this.mFoldShower.setText(sDefaultFolderName, BufferType.EDITABLE);
  }

  public void centerAboutIcon()
  {
    CellLayout localCellLayout = this.mLauncher.getWorkspace().getCurrentDropLayout();
    if (localCellLayout == null)
      return;
    DragLayer.LayoutParams localLayoutParams = (DragLayer.LayoutParams)getLayoutParams();
    int k = getPaddingLeft() + getPaddingRight() + this.mFolderScoll.getDesiredWidth();
    int m = getPaddingTop() + getPaddingBottom() + this.mFolderScoll.getDesiredHeight() + this.mFolderNameHeight;
    DragLayer localDragLayer = (DragLayer)this.mLauncher.findViewById(2131492888);
    localDragLayer.getDescendantRectRelativeToSelf(this.mFolderIcon, this.mTempRect);
    int i = this.mTempRect.centerX();
    int j = this.mTempRect.centerY();
    int i1 = k / 2;
    int n = m / 2;
    Rect localRect = new Rect();
    localDragLayer.getDescendantRectRelativeToSelf(localCellLayout, localRect);
    i = Math.min(Math.max(localRect.left, i - i1), localRect.left + localRect.width() - k);
    j = Math.min(Math.max(localRect.top, j - n), localRect.top + localRect.height() - m);
    if (k >= localRect.width())
      i = localRect.left + (localRect.width() - k) / 2;
    if (m >= localRect.height())
      j = localRect.top + (localRect.height() - m) / 2;
    if (this.mMode == 1)
    {
      localLayoutParams.width = k;
      localLayoutParams.height = m;
      localLayoutParams.x = i;
      localLayoutParams.y = j;
      return;
    }
    this.mNewSize.set(i, j, i + k, j + m);
  }

  public void checkFolderScrollDirection(int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    if ((this.mFolderScoll.getLocalVisibleRect(localRect)) && (this.mState != 1))
    {
      if (localRect.contains(paramInt1, paramInt2))
        this.mMoveInValidAera = true;
      this.mTopRect.set(localRect.left, localRect.top, localRect.right, localRect.top + this.mFolderScoll.getContentCellHeight() / 2);
      this.mBottomRect.set(localRect.left, localRect.bottom - this.mFolderScoll.getContentCellHeight() / 2, localRect.right, localRect.bottom);
      if (this.mTopRect.contains(paramInt1, paramInt2))
        this.mFolderScoll.checkFolderScrollDirection(1);
    }
    else
    {
      return;
    }
    if (this.mBottomRect.contains(paramInt1, paramInt2))
    {
      this.mFolderScoll.checkFolderScrollDirection(2);
      return;
    }
    this.mFolderScoll.checkFolderScrollDirection(0);
  }

  public void checkTopBarInOrderMode(boolean paramBoolean)
  {
    if ((this.mLauncher != null) && (this.mLauncher.isWorkspaceInOrderOneMode()))
    {
      if (paramBoolean)
        this.mLauncher.getColorRectManager().showTopBar();
    }
    else
      return;
    this.mLauncher.getColorRectManager().hideTopBar();
  }

  public void completeDragExit()
  {
    super.completeDragExit();
    this.mLauncher.closeFolder();
    this.mCurrentDragInfo = null;
    this.mCurrentDragView = null;
    this.mSuppressOnAdd = false;
    this.mRearrangeOnClose = true;
  }

  protected boolean createAndAddApplication(ApplicationInfo paramApplicationInfo)
  {
    boolean bool2 = true;
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1 = localIterator;
    if (this.mLauncher != null)
    {
      localObject1 = localIterator;
      if (this.mLauncher.isWorkspaceInOrderMoreMode())
      {
        localIterator = this.mLauncher.getColorRectManager().getSelectedViews().iterator();
        while (true)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext())
            break;
          localObject1 = (View)localIterator.next();
          if (((localObject1 instanceof FolderItemView)) && (paramApplicationInfo.equals(((View)localObject1).getTag())))
            localObject2 = (FolderItemView)localObject1;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
      localObject2 = (FolderItemView)this.mInflater.inflate(ScreenGridUtils.getFolderShortcutLayout(), this, false);
    ((FolderItemView)localObject2).applyFromApplicationInfo(paramApplicationInfo, this.mIconCache);
    ((FolderItemView)localObject2).setLauncher(this.mLauncher);
    ((FolderItemView)localObject2).setInFolder(true);
    ((FolderItemView)localObject2).setFolder(this);
    ((FolderItemView)localObject2).setOnLongClickListener(this);
    ((FolderItemView)localObject2).setFreezing(true);
    ((BubbleTextView)localObject2).setDarkEffectListener(this.mLauncher.getDarkEffectListener());
    boolean bool1;
    if (!findAndSetEmptyCells(paramApplicationInfo))
    {
      Log.w("Launcher.Folder", "createAndAddApplication --- findAndSetEmptyCells(item) return false");
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            localObject1 = new BaseCellLayout.LayoutParams(paramApplicationInfo.cellX, paramApplicationInfo.cellY, paramApplicationInfo.spanX, paramApplicationInfo.spanY);
            ((FolderItemView)localObject2).setOnKeyListener(new FolderKeyEventListener());
            this.mContent.addViewToCellLayout((View)localObject2, -1, (int)paramApplicationInfo.id, (BaseCellLayout.LayoutParams)localObject1, true);
            bool1 = bool2;
          }
          while (this.mLauncher == null);
          bool1 = bool2;
        }
        while (this.mLauncher.getWorkspace() == null);
        bool1 = bool2;
      }
      while (this.mDropItem == paramApplicationInfo);
      bool1 = bool2;
    }
    while (getItemCount() <= 1);
    syncAnim((View)localObject2);
    return true;
  }

  public void doneEditingFolderName(boolean paramBoolean)
  {
    if (this.mLauncher != null)
    {
      if (this.mLauncher.isWorkspaceInOrderOneMode())
        this.mLauncher.getColorRectManager().showTopBar();
      this.mLauncher.setNavBarColor(true);
    }
    String str1 = this.mFolderName.getText().toString().trim();
    String str2 = LauncherUtil.getRealSystemFolderTitle(this.mLauncher, this.mInfo.title.toString());
    if ((!TextUtils.isEmpty(str1)) && (!str1.equals(str2)))
    {
      this.mInfo.setTitle(str1);
      this.mFoldShower.setText(str1, BufferType.EDITABLE);
    }
    while (true)
    {
      this.mFolderName.clearFocus();
      this.mFolderName.setVisibility(4);
      this.mFolderNameClear.setVisibility(4);
      this.mFoldShower.setVisibility(0);
      this.mFolderHeader.setBackgroundDrawable(null);
      LauncherModel.updateItemInDatabase(this.mLauncher, this.mInfo);
      if (paramBoolean)
        sendCustomAccessibilityEvent(32, String.format(getContext().getString(2131427355), new Object[] { str1 }));
      requestFocus();
      this.mIsEditingName = false;
      return;
      this.mFoldShower.setText(str2, BufferType.EDITABLE);
    }
  }

  public Animator drawZoomAnimation(final boolean paramBoolean)
  {
    Object localObject = new int[2];
    int[] arrayOfInt = new int[2];
    float f2 = this.mFolderIcon.getSmallIconSize() / Utilities.getIconWidth() * this.mFolderShrinkFactor;
    float f1 = f2;
    this.mFolderIcon.getLocationOnScreen((int[])localObject);
    this.mFolderIcon.getLocalCenterForIndex(0, arrayOfInt);
    float f4 = f2;
    float f3 = f1;
    if (this.mLauncher != null)
    {
      f4 = f2;
      f3 = f1;
      if (!this.mLauncher.isWorkspaceNormal())
      {
        Workspace localWorkspace = this.mLauncher.getWorkspace();
        f4 = f2;
        f3 = f1;
        if (localWorkspace != null)
        {
          f3 = localWorkspace.getSpringLoadedShrinkFactor();
          arrayOfInt[0] = ((int)(arrayOfInt[0] * f3));
          arrayOfInt[1] = ((int)(arrayOfInt[1] * f3));
          f4 = f2 * f3;
          f3 = f1 * f3;
        }
      }
    }
    this.mFolderIconCenter[0] = (localObject[0] + arrayOfInt[0]);
    this.mFolderIconCenter[1] = (localObject[1] + arrayOfInt[1]);
    if ((!paramBoolean) && (getScaleX() < 1.0F))
    {
      Log.w("Launcher.Folder", " drawZoomAnimation -- -- getScaleX() = " + getScaleX());
      localObject = (BubbleTextView)this.mContent.getChildAtPosition(0);
      if (localObject != null)
        ((BubbleTextView)localObject).getLocalIconCenter(this.mChildOffset);
      this.mFirstChildCenter[0] = (this.mFolderScrollPos[0] + this.mFolderScoll.getFirstChildPaddingLeft() + this.mChildOffset[0]);
      this.mFirstChildCenter[1] = (this.mFolderScrollPos[1] + this.mFolderScoll.getFirstChildPaddingTop() + this.mChildOffset[1]);
      if (!paramBoolean)
        break label507;
      this.mOldScaleX = f4;
      this.mOldScaleY = f3;
      this.mOldTranslationX = (this.mFolderIconCenter[0] - this.mFirstChildCenter[0]);
      this.mOldTranslationY = (this.mFolderIconCenter[1] - this.mFirstChildCenter[1] - getTop());
      setPivotX(this.mFirstChildCenter[0]);
      setPivotY(this.mFirstChildCenter[1]);
      this.mOldAlpha = 0.1F;
      this.mNewTranslationX = 0.0F;
      this.mNewTranslationY = 0.0F;
      this.mNewScaleX = 1.0F;
      this.mNewScaleY = 1.0F;
      this.mNewAlpha = 1.0F;
      label409: if (!paramBoolean)
        break label632;
    }
    label632: for (int i = 320; ; i = 270)
    {
      localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(i);
      ((ValueAnimator)localObject).setInterpolator(new OppoBezierInterpolator(0.3741999864578247D, 0.1252000033855438D, 0.2034000009298325D, 1.0D, true));
      ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          Folder.this.setTranslationX(Folder.this.mNewTranslationX);
          Folder.this.setTranslationY(Folder.this.mNewTranslationY);
          Folder.this.setScaleX(Folder.this.mNewScaleX);
          Folder.this.setScaleY(Folder.this.mNewScaleY);
          Folder.this.mFolderIcon.setVisibility(0);
          if (!paramBoolean)
            Folder.this.mFolderIcon.invalidate();
          while (!Folder.this.mDragController.isDragging())
            return;
          Folder.this.showFolderScrollerBackground(true);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (paramBoolean)
          {
            Folder.this.setTranslationX(Folder.this.mOldTranslationX);
            Folder.this.setTranslationY(Folder.this.mOldTranslationY);
            Folder.this.setScaleX(Folder.this.mOldScaleX);
            Folder.this.setScaleY(Folder.this.mOldScaleY);
          }
          Folder.this.mFolderIcon.invalidate();
        }
      });
      ((ValueAnimator)localObject).addUpdateListener(new LauncherAnimatorUpdateListener()
      {
        public void onAnimationUpdate(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          Folder.this.setTranslationX(Folder.this.mOldTranslationX * paramAnonymousFloat1 + Folder.this.mNewTranslationX * paramAnonymousFloat2);
          Folder.this.setTranslationY(Folder.this.mOldTranslationY * paramAnonymousFloat1 + Folder.this.mNewTranslationY * paramAnonymousFloat2);
          Folder.this.setScaleX(Folder.this.mOldScaleX * paramAnonymousFloat1 + Folder.this.mNewScaleX * paramAnonymousFloat2);
          Folder.this.setScaleY(Folder.this.mOldScaleY * paramAnonymousFloat1 + Folder.this.mNewScaleY * paramAnonymousFloat2);
        }
      });
      return localObject;
      this.mFolderScoll.getLocationOnScreen(this.mFolderScrollPos);
      break;
      label507: this.mOldTranslationX = getTranslationX();
      this.mOldTranslationY = getTranslationY();
      this.mOldScaleX = getScaleX();
      this.mOldScaleY = getScaleY();
      this.mOldAlpha = getAlpha();
      this.mNewTranslationX = (this.mFolderIconCenter[0] - this.mFirstChildCenter[0]);
      this.mNewTranslationY = (this.mFolderIconCenter[1] - this.mFirstChildCenter[1] - getTop());
      this.mNewScaleX = f4;
      this.mNewScaleY = f3;
      this.mNewAlpha = 0.2F;
      setPivotX(this.mFirstChildCenter[0]);
      setPivotY(this.mFirstChildCenter[1]);
      break label409;
    }
  }

  public void endTidyuping()
  {
    Object localObject;
    if (this.mLauncher != null)
    {
      localObject = this.mLauncher.getWorkspace();
      if (localObject != null)
        ((Workspace)localObject).cancelSyncAnim();
    }
    if (this.mContent != null)
    {
      int j = this.mContent.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.mContent.getChildAt(i);
        if ((localObject instanceof BubbleTextView))
          ((BubbleTextView)localObject).setFreezing(true);
        i += 1;
      }
      this.mContent.stopShakeAnimations(false);
    }
  }

  protected boolean findAndSetEmptyCells(ApplicationInfo paramApplicationInfo)
  {
    int[] arrayOfInt = new int[2];
    if (this.mContent.findCellForSpan(arrayOfInt, paramApplicationInfo.spanX, paramApplicationInfo.spanY))
    {
      paramApplicationInfo.cellX = arrayOfInt[0];
      paramApplicationInfo.cellY = arrayOfInt[1];
      paramApplicationInfo.tmpFolderCellX = arrayOfInt[0];
      paramApplicationInfo.tmpFolderCellY = arrayOfInt[1];
      return true;
    }
    Log.w("Launcher.Folder", "findAndSetEmptyCells --- return false, -- item = " + paramApplicationInfo);
    return false;
  }

  public ArrayList<View> getAndInvalidateVisibleItems()
  {
    return this.mFolderScoll.getAndInvalidateVisibleItems();
  }

  public CellLayout getContent()
  {
    return this.mContent;
  }

  public View getEditTextRegion()
  {
    return this.mFoldShower;
  }

  public BaseFolderIcon getFolderIcon()
  {
    return this.mFolderIcon;
  }

  public FolderInfo getInfo()
  {
    return this.mInfo;
  }

  public View getItemAt(int paramInt)
  {
    return this.mContent.getChildAt(paramInt);
  }

  public int getItemCount()
  {
    return this.mContent.getChildCount();
  }

  public ArrayList<View> getItemsInReadingOrder(boolean paramBoolean)
  {
    if (this.mItemsInvalidated)
    {
      this.mItemsInReadingOrder.clear();
      int i = 0;
      while (i < this.mContent.getCellCountY())
      {
        int j = 0;
        while (j < this.mContent.getCellCountX())
        {
          View localView = this.mContent.getChildAt(j, i);
          if ((localView != null) && (((ApplicationInfo)localView.getTag() != this.mCurrentDragInfo) || (paramBoolean)))
            this.mItemsInReadingOrder.add(localView);
          j += 1;
        }
        i += 1;
      }
      this.mItemsInvalidated = false;
    }
    return this.mItemsInReadingOrder;
  }

  public View getViewForInfo(ApplicationInfo paramApplicationInfo)
  {
    int i = 0;
    while (i < this.mContent.getCellCountY())
    {
      int j = 0;
      if (j < this.mContent.getCellCountX())
      {
        View localView = this.mContent.getChildAt(j, i);
        if (localView == null);
        while (localView.getTag() != paramApplicationInfo)
        {
          j += 1;
          break;
        }
        return localView;
      }
      i += 1;
    }
    return null;
  }

  public boolean isOpenedOrAnimating()
  {
    return (this.mState == 1) || (this.mState == 2);
  }

  void launcherStatisticsMoveItem(View paramView)
  {
    if (-101L == this.mInfo.container)
      return;
    Workspace localWorkspace = this.mLauncher.getWorkspace();
    int j = this.mLauncher.getModel().getScreenIndex(this.mInfo.screenId);
    if ((paramView instanceof Workspace));
    for (int i = localWorkspace.mCurrentPage; ; i = localWorkspace.mDropColorRectScreen)
    {
      paramView = LauncherStatistics.getInstance(this.mLauncher);
      if (!localWorkspace.isOrderMode())
        break label106;
      if (i != j)
        break label98;
      paramView.onEvent("move_icon_folder_in_current_page_normal_mode");
      return;
      if (!(paramView instanceof ColorRectPreview))
        break;
    }
    label98: paramView.onEvent("move_icon_folder_to_other_page_normal_mode");
    return;
    label106: if (i == j)
    {
      paramView.onEvent("move_icon_folder_in_current_page_small_launcher");
      return;
    }
    paramView.onEvent("move_icon_folder_to_other_page_small_launcher");
  }

  protected void layoutChildren()
  {
    int m = getMeasuredWidth();
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    int j = getPaddingTop() + (getMeasuredHeight() - this.mTotalHeight) / 2 - this.mFolderNameHeight;
    int i2 = getChildCount();
    int i = 0;
    while (i < i2)
    {
      View localView = getChildAt(i);
      int k = j;
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        j += localLayoutParams.topMargin;
        int i4 = getPaddingLeft() + (m - n - i1 - k) / 2 + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
        localView.layout(i4, j, i4 + k, j + i3);
        k = j + (localLayoutParams.bottomMargin + i3);
      }
      i += 1;
      j = k;
    }
  }

  public void notifyDataSetChanged()
  {
    this.mContent.removeAllViewsInLayout();
    bind(this.mInfo);
  }

  public void onAdd(ApplicationInfo paramApplicationInfo)
  {
    this.mItemsInvalidated = true;
    if (this.mSuppressOnAdd)
      return;
    if (!findAndSetEmptyCells(paramApplicationInfo))
    {
      setupContentForNumItems(getItemCount() + 1);
      findAndSetEmptyCells(paramApplicationInfo);
    }
    createAndAddApplication(paramApplicationInfo);
    LauncherModel.addOrMoveItemInDatabase(this.mLauncher, paramApplicationInfo, this.mInfo.id, this.mInfo.screenId, paramApplicationInfo.cellX, paramApplicationInfo.cellY);
    if ((this.mInfo.opened) && (this.mOpenInDragMode))
    {
      this.mOpenInDragMode = false;
      this.mItemsInvalidated = true;
      setupContentDimensions(getItemCount());
    }
    this.mDropItem = null;
  }

  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof BaseCellLayout.CellInfo))
      this.mLauncher.closeFolder();
  }

  public void onCloseComplete()
  {
    this.mDragController.removeDropTarget(this);
    clearFocus();
    this.mFolderIcon.requestFocus();
    this.mFolderScoll.cancelSmoothScroll();
    this.mFolderScoll.cancelDragScroll();
    this.mFolderScoll.smoothScrollTo(0, 0);
    this.mFoldShower.setVisibility(0);
    this.mFoldShower.setEnabled(true);
    Object localObject = LauncherUtil.getRealSystemFolderTitle(this.mLauncher, this.mInfo.title.toString());
    this.mFoldShower.setText((CharSequence)localObject, BufferType.EDITABLE);
    this.mFolderHeader.setBackgroundDrawable(null);
    this.mFolderName.setVisibility(4);
    this.mFolderNameClear.setVisibility(4);
    if (this.mRearrangeOnClose)
    {
      setupContentForNumItems(getItemCount());
      this.mRearrangeOnClose = false;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mLauncher != null)
    {
      bool1 = bool2;
      if (this.mLauncher.getWorkspace() != null)
        bool1 = this.mLauncher.getWorkspace().isSwitchDockBarViewAnimRunning();
    }
    if ((getItemCount() < 1) || ((this.mCanRemoveFolder) && (getItemCount() == 1)))
      if ((!this.mDragInProgress) && (!this.mSuppressFolderDeletion) && (getItemCount() < 1) && (!bool1))
        replaceFolderWithFinalItem();
    while (true)
    {
      this.mSuppressFolderDeletion = false;
      localObject = (DragLayer)getParent();
      if (localObject != null)
      {
        ((DragLayer)localObject).removeView(this);
        localObject = ((DragLayer)localObject).getLauncher();
        if (localObject != null)
          ((Launcher)localObject).commandCloseFolder();
      }
      return;
      if ((this.mCanRemoveFolder) && (getItemCount() == 1) && (this.mDragInProgress))
      {
        replaceFolderWithFinalItem();
      }
      else if (this.mDragInProgress)
      {
        this.mDeleteFolderOnDropCompleted = true;
        continue;
        this.mCanRemoveFolder = false;
      }
    }
  }

  public void onDragOver(DropTarget.DragObject paramDragObject)
  {
    super.onDragOver(paramDragObject);
    paramDragObject = getDragViewVisualCenter(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset, paramDragObject.dragView, null);
    paramDragObject[0] += this.mFolderScoll.getScrollX();
    paramDragObject[1] += this.mFolderScoll.getScrollY();
    checkFolderScrollDirection((int)paramDragObject[0], (int)paramDragObject[1]);
    if ((this.mOpenInDragMode) && (!this.mMoveInValidAera))
    {
      int i = getItemCount();
      this.mTargetCell[0] = (i % this.mContent.getCellCountX());
      this.mTargetCell[1] = (i / this.mContent.getCellCountX());
    }
    while (true)
    {
      if (((this.mTargetCell[0] != this.mPreviousTargetCell[0]) || (this.mTargetCell[1] != this.mPreviousTargetCell[1])) && (!folderIsAnimating()))
      {
        this.mReorderAlarm.cancelAlarm();
        this.mReorderAlarm.setOnAlarmListener(this.mReorderAlarmListener);
        this.mReorderAlarm.setAlarm(150L);
        this.mPreviousTargetCell[0] = this.mTargetCell[0];
        this.mPreviousTargetCell[1] = this.mTargetCell[1];
      }
      return;
      this.mTargetCell = this.mContent.findNearestArea((int)paramDragObject[0], (int)paramDragObject[1], 1, 1, this.mTargetCell);
    }
  }

  public void onDrop(DropTarget.DragObject paramDragObject)
  {
    super.onDrop(paramDragObject);
    ApplicationInfo localApplicationInfo = (ApplicationInfo)paramDragObject.dragInfo;
    if (localApplicationInfo == this.mCurrentDragInfo)
    {
      Object localObject = (ApplicationInfo)this.mCurrentDragView.getTag();
      BaseCellLayout.LayoutParams localLayoutParams = (BaseCellLayout.LayoutParams)this.mCurrentDragView.getLayoutParams();
      int i = this.mEmptyCell[0];
      localLayoutParams.cellX = i;
      ((ApplicationInfo)localObject).tmpFolderCellX = i;
      ((ApplicationInfo)localObject).cellX = i;
      i = this.mEmptyCell[1];
      localLayoutParams.cellY = i;
      ((ApplicationInfo)localObject).tmpFolderCellY = i;
      ((ApplicationInfo)localObject).cellY = i;
      localObject = new Runnable()
      {
        public void run()
        {
          if (Folder.this.mCurrentDragView != null)
            Folder.this.mCurrentDragView.setVisibility(0);
        }
      };
      this.mContent.addViewToCellLayout(this.mCurrentDragView, -1, (int)localApplicationInfo.id, localLayoutParams, true);
      this.mCurrentDragView.setVisibility(4);
      if (paramDragObject.dragView.hasDrawn())
      {
        this.mLauncher.getDragLayer().animateViewIntoPosition(paramDragObject.dragView, this.mCurrentDragView, (Runnable)localObject);
        this.mItemsInvalidated = true;
        setupContentDimensions(getItemCount());
        this.mSuppressOnAdd = true;
        if ((this.mLauncher != null) && (this.mLauncher.getWorkspace() != null))
          this.mLauncher.getWorkspace().syncAnim(this.mCurrentDragView);
      }
    }
    while (true)
    {
      this.mDropItem = localApplicationInfo;
      this.mInfo.add(localApplicationInfo);
      return;
      paramDragObject.deferDragViewCleanupPostAnimation = false;
      this.mCurrentDragView.setVisibility(0);
      break;
      if (paramDragObject.dragView != null)
      {
        paramDragObject.deferDragViewCleanupPostAnimation = false;
        paramDragObject.dragView.recycleBitmap();
      }
      showFolderScrollerBackground(false);
    }
  }

  public void onDropCompleted(View paramView, DropTarget.DragObject paramDragObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int k = 1;
    if (paramBoolean2)
    {
      launcherStatisticsMoveItem(paramView);
      i = 0;
      j = i;
      Object localObject;
      if ((paramView instanceof DockBar))
      {
        paramDragObject = (DockBar)paramView;
        j = i;
        if (paramDragObject.getChangeViewFlag())
        {
          j = 1;
          localObject = paramDragObject.getSwitchInfo();
          if (!(localObject instanceof ApplicationInfo))
            return;
          ((ItemInfo)localObject).screenId = this.mInfo.screenId;
          ((ItemInfo)localObject).container = this.mInfo.id;
          notifyDrop();
          this.mFolderIcon.dropNoAnimation(null, this.mFinalItem, this.mFinalView);
          this.mFinalItem = null;
          this.mFinalView = null;
          if (this.mFolderIcon.getParent() == null)
            reAddFolderIcon();
          paramDragObject = paramDragObject.getSwitchPostion();
          localObject = new int[2];
          this.mFolderIcon.getLocationOnScreen((int[])localObject);
          this.mLauncher.getWorkspace().switchDockBarView(this.mFolderIcon, paramDragObject, (int[])localObject);
        }
      }
      if ((!this.mDeleteFolderOnDropCompleted) || (this.mItemAddedBackToSelfViaIcon))
      {
        i = k;
        if (this.mCanRemoveFolder)
        {
          i = k;
          if (getItemCount() == 1)
          {
            i = k;
            if (paramView != this)
            {
              i = k;
              if (j != 0);
            }
          }
        }
      }
      else
      {
        replaceFolderWithFinalItem();
        if (!this.mLauncher.isWorkspaceInOrderMoreMode())
          break label421;
      }
      label421: for (i = 1; ; i = 0)
      {
        j = i;
        if (getItemCount() == 0)
        {
          paramDragObject = new int[2];
          paramDragObject[0] = this.mInfo.cellX;
          paramDragObject[1] = this.mInfo.cellY;
          j = this.mLauncher.getModel().getScreenIndex(this.mInfo.screenId);
          localObject = (CellLayout)this.mLauncher.getWorkspace().getChildAt(j);
          j = i;
          if (localObject != null)
          {
            j = i;
            if (!((CellLayout)localObject).isOccupied(paramDragObject[0], paramDragObject[1]))
            {
              ((CellLayout)localObject).fillUpEmptyCell(paramDragObject, true, false);
              j = i;
            }
          }
        }
        if ((paramView != this) && (this.mOnExitAlarm.alarmPending()))
        {
          this.mOnExitAlarm.cancelAlarm();
          completeDragExit();
        }
        this.mDeleteFolderOnDropCompleted = false;
        this.mDragInProgress = false;
        this.mItemAddedBackToSelfViaIcon = false;
        this.mCurrentDragInfo = null;
        this.mCurrentDragView = null;
        this.mSuppressOnAdd = false;
        showFolderScrollerBackground(false);
        if (j == 0)
          break;
        updateItemLocationsInDatabase();
        return;
      }
    }
    int i = 0;
    if (this.mFolderIcon.getParent() == null)
      i = 1;
    if ((paramView == null) || (i != 0))
    {
      this.mFolderIcon.dropNoAnimation(paramDragObject, this.mFinalItem, this.mFinalView);
      this.mFinalItem = null;
      this.mFinalView = null;
    }
    while (true)
    {
      if (this.mFolderIcon.getParent() == null)
        reAddFolderIcon();
      if ((this.mOnExitAlarm.alarmPending()) || (this.mState == 1))
        this.mSuppressFolderDeletion = true;
      paramDragObject.deferDragViewCleanupPostAnimation = false;
      break;
      this.mFolderIcon.onDrop(paramDragObject);
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mFolderHeader = ((FrameLayout)findViewById(2131492904));
    this.mFolderQuickTitleContainer = ((FrameLayout)findViewById(2131492908));
    this.mFolderScoll = ((FolderScroller)findViewById(2131492909));
    this.mFolderScoll.setPadding(this.mFoldScrollPaddingLeft, this.mFoldScrollPaddingTop, this.mFoldScrollPaddingRight, this.mFoldScrollPaddingBottom);
    this.mContent = ((CellLayout)this.mFolderScoll.getFolderContent());
    this.mContent.setOnClickListener(this);
    this.mFolderName = ((FolderEditText)findViewById(2131492905));
    this.mFolderName.setSelectAllOnFocus(false);
    this.mFolderName.addTextChangedListener(this.mTextWatcher);
    this.mFolderName.setFolder(this);
    this.mFolderName.setOnFocusChangeListener(this);
    this.mFolderName.setEditFlag(1);
    this.mFolderNameClear = ((ImageView)findViewById(2131492907));
    this.mFolderNameClear.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Folder.this.mFolderName != null)
        {
          paramAnonymousView = Folder.this.mFolderName.getText();
          if (paramAnonymousView != null)
            ((Editable)paramAnonymousView).delete(0, paramAnonymousView.length());
          Folder.this.mFolderName.setText("");
        }
      }
    });
    this.mFolderHeader.measure(0, 0);
    this.mFolderNameHeight = this.mFolderHeader.getMeasuredHeight();
    this.mFolderName.setCustomSelectionActionModeCallback(this.mActionModeCallback);
    this.mFolderName.setInputType(this.mFolderName.getInputType() | 0x80000 | 0x2000);
    this.mFolderName.setVisibility(4);
    this.mFoldShower = ((TextView)findViewById(2131492906));
    this.mFoldShower.setCursorVisible(false);
    this.mFoldShower.setFocusable(false);
    this.mFoldShower.setOnClickListener(this.mNameClickListener);
    this.mFoldShower.setVisibility(0);
    if ((this.mLauncher.isWallpaperBright()) && (ThemeUtil.isDefaultTheme()))
      updateFolderEditTextColor(2131558406);
  }

  public void onItemsChanged()
  {
    if (this.mFolderIcon != null)
      this.mFolderIcon.updateFolderUnreadNum();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getPaddingTop() + (getBottom() - getTop() - this.mTotalHeight) / 2 - this.mFolderNameHeight;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = getChildCount();
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      View localView = getChildAt(paramInt2);
      int i = paramInt4;
      if (localView.getVisibility() != 8)
      {
        i = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramInt4 += localLayoutParams.topMargin;
        int i1 = getPaddingLeft() + (paramInt3 - paramInt1 - j - k - i) / 2 + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
        localView.layout(i1, paramInt4, i1 + i, paramInt4 + n);
        i = paramInt4 + (localLayoutParams.bottomMargin + n);
      }
      paramInt2 += 1;
      paramInt4 = i;
    }
  }

  public boolean onLongClick(View paramView)
  {
    if (this.mLauncher.isWorkspaceInOrderMoreMode())
    {
      localObject1 = this.mLauncher.getColorRectManager();
      return (localObject1 != null) && (!((ColorRectManager)localObject1).isAnimating()) && ((paramView instanceof FolderItemView)) && (((ColorRectManager)localObject1).comeHere(paramView));
    }
    Object localObject1 = this.mLauncher.getWorkspace();
    if (localObject1 == null)
      return false;
    Object localObject2 = paramView.getTag();
    if ((localObject2 instanceof ApplicationInfo))
    {
      localObject2 = (ApplicationInfo)localObject2;
      if (!paramView.isInTouchMode())
        return false;
      if (((Workspace)localObject1).isNormal())
      {
        DragLayer.sStartTidyUpInFolder = true;
        this.mLauncher.getColorRectManager().enterOrderOneMode(true);
        startTidyuping();
      }
      ((Workspace)localObject1).onDragStartedWithItem(paramView);
      ((Workspace)localObject1).beginDragShared(paramView, this);
      this.mIconDrawable = ((TextView)paramView).getCompoundDrawables()[1];
      this.mCurrentDragInfo = ((ApplicationInfo)localObject2);
      this.mEmptyCell[0] = ((ApplicationInfo)localObject2).cellX;
      this.mEmptyCell[1] = ((ApplicationInfo)localObject2).cellY;
      this.mCurrentDragView = paramView;
      this.mContent.removeView(this.mCurrentDragView);
      this.mInfo.remove(this.mCurrentDragInfo);
      this.mDragInProgress = true;
      this.mItemAddedBackToSelfViaIcon = false;
      this.mOpenInDragMode = false;
      showFolderScrollerBackground(true);
    }
    return true;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mTotalHeight = 0;
    this.mFolderScoll.setContentCellDimension();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    paramInt1 = localDisplayMetrics.widthPixels;
    paramInt2 = localDisplayMetrics.heightPixels;
    int i = this.mFolderScoll.getDesiredHeight();
    int j = MeasureSpec.makeMeasureSpec(this.mFolderScoll.getDesiredWidth(), 1073741824);
    int k = MeasureSpec.makeMeasureSpec(i, 1073741824);
    this.mFolderScoll.measure(j, k);
    this.mFolderQuickTitleContainer.measure(j, k);
    this.mTotalHeight += i;
    i = MeasureSpec.makeMeasureSpec(this.mFolderScoll.getDesiredWidth() - this.mFoldScrollPaddingLeft - this.mFoldScrollPaddingRight, 1073741824);
    this.mFolderHeader.measure(i, MeasureSpec.makeMeasureSpec(this.mFolderNameHeight, 1073741824));
    setMeasuredDimension(paramInt1, paramInt2);
  }

  public void onOrderMoreGoBack()
  {
    this.mDeleteFolderOnDropCompleted = false;
  }

  public void onOrderMoreModeChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mCanRemoveFolder = false;
      this.mFoldShower.setClickable(false);
      endTidyuping();
      return;
    }
    this.mFoldShower.setClickable(true);
    startTidyuping();
  }

  public void onRemove(ApplicationInfo paramApplicationInfo)
  {
    this.mItemsInvalidated = true;
    if (paramApplicationInfo == this.mCurrentDragInfo)
    {
      Log.w("Launcher.Folder", "onRemove item == mCurrentDragInfo, -- item = " + paramApplicationInfo);
      return;
    }
    View localView = getViewForInfo(paramApplicationInfo);
    if (localView == null)
    {
      Log.w("Launcher.Folder", "onRemove v == null, -- item = " + paramApplicationInfo);
      return;
    }
    if (this.mLauncher == null)
    {
      paramApplicationInfo = null;
      label86: if ((paramApplicationInfo == null) || (paramApplicationInfo.getState() != 4096) || (!paramApplicationInfo.mSelectedViews.contains(localView)))
        break label183;
      this.mContent.removeView(localView);
      label121: if (this.mState != 1)
        break label212;
      this.mRearrangeOnClose = true;
    }
    while (true)
    {
      if (getItemCount() < 1)
        this.mLauncher.closeFolder();
      if ((this.mInfo.opened) || (getItemCount() >= 1))
        break;
      replaceFolderWithFinalItem();
      return;
      paramApplicationInfo = this.mLauncher.getColorRectManager();
      break label86;
      label183: this.mContent.removeViewInLayout(localView, true);
      if (paramApplicationInfo != null)
        paramApplicationInfo.checkTopbarSelectedText(localView);
      ((FolderItemView)localView).setFolder(null);
      break label121;
      label212: if ((this.mDragController != null) && (this.mDragController.isDragging()) && (this.mCurrentDragInfo != null))
      {
        resetGridSize(getItemCount() + 1);
        paramApplicationInfo = new int[2];
        tmp251_250 = paramApplicationInfo;
        tmp251_250[0] = -1;
        tmp255_251 = tmp251_250;
        tmp255_251[1] = -1;
        tmp255_251;
        if (getPreEmptyCell(this.mEmptyCell, paramApplicationInfo))
        {
          this.mEmptyCell[0] = paramApplicationInfo[0];
          this.mEmptyCell[1] = paramApplicationInfo[1];
        }
      }
      else
      {
        setupContentDimensions(getItemCount());
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return true;
      this.mActionDownMills = System.currentTimeMillis();
      continue;
      if ((System.currentTimeMillis() - this.mActionDownMills < 2000L) && (this.mLauncher != null))
        this.mLauncher.closeFolder();
    }
  }

  public void positionAndSizeAsIcon()
  {
    if (!(getParent() instanceof DragLayer))
      return;
    DragLayer.LayoutParams localLayoutParams = (DragLayer.LayoutParams)getLayoutParams();
    if (this.mMode == 1)
    {
      setScaleX(1.0F);
      setScaleY(1.0F);
      setAlpha(0.0F);
      setTranslationX(0.0F);
      setTranslationY(0.0F);
    }
    while (true)
    {
      this.mState = 0;
      return;
      this.mLauncher.getDragLayer().getDescendantRectRelativeToSelf(this.mFolderIcon, this.mIconRect);
      localLayoutParams.width = this.mIconRect.width();
      localLayoutParams.height = this.mIconRect.height();
      localLayoutParams.x = this.mIconRect.left;
      localLayoutParams.y = this.mIconRect.top;
      this.mContent.setAlpha(0.0F);
    }
  }

  public void reAddFolderIcon()
  {
    Object localObject;
    if (this.mInfo.container == -101L)
    {
      localObject = this.mLauncher.getDockBar();
      if (localObject != null)
        ((DockBar)localObject).addView(this.mFolderIcon, this.mInfo.cellX);
    }
    do
    {
      return;
      i = this.mLauncher.getModel().getScreenIndex(this.mInfo.screenId);
      localObject = (CellLayout)this.mLauncher.getCellLayout(this.mInfo.container, i);
    }
    while (localObject == null);
    int i = LauncherModel.getCellLayoutChildIdFromScreenId(this.mInfo.container, this.mInfo.screenId, this.mInfo.cellX, this.mInfo.cellY, this.mInfo.spanX, this.mInfo.spanY);
    BaseCellLayout.LayoutParams localLayoutParams = (BaseCellLayout.LayoutParams)this.mFolderIcon.getLayoutParams();
    Log.d("Launcher.Folder", "reAddeFolderIcon addViewToCellLayout lp.cell = " + localLayoutParams.cellX + " " + localLayoutParams.cellY + "lp.tmp = " + localLayoutParams.tmpCellX + " " + localLayoutParams.tmpCellY);
    Log.d("Launcher.Folder", "reAddeFolderIcon addViewToCellLayout mInfo.id = " + this.mInfo.id);
    ((CellLayout)localObject).addViewToCellLayout(this.mFolderIcon, -1, i, localLayoutParams, true, false);
  }

  public void realTimeReorder(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = 0;
    int k = 0;
    float f1 = 30.0F;
    int i;
    label48: int j;
    label75: label94: View localView;
    float f2;
    int n;
    if (LauncherUtil.readingOrderGreaterThan(paramArrayOfInt2, paramArrayOfInt1))
    {
      if (paramArrayOfInt1[0] >= this.mContent.getCellCountX() - 1)
      {
        i = 1;
        if (i == 0)
          break label148;
        i = paramArrayOfInt1[1] + 1;
        j = i;
      }
      while (true)
      {
        if (j > paramArrayOfInt2[1])
          return;
        if (j == paramArrayOfInt1[1])
        {
          i = paramArrayOfInt1[0] + 1;
          if (j >= paramArrayOfInt2[1])
            break label162;
          m = this.mContent.getCellCountX() - 1;
          if (i > m)
            break label230;
          localView = this.mContent.getChildAt(i, j);
          if (localView != null)
            break label170;
          f2 = f1;
          n = k;
        }
        while (true)
        {
          i += 1;
          k = n;
          f1 = f2;
          break label94;
          i = 0;
          break;
          label148: i = paramArrayOfInt1[1];
          break label48;
          i = 0;
          break label75;
          label162: m = paramArrayOfInt2[0];
          break label94;
          label170: n = k;
          f2 = f1;
          if (this.mContent.animateChildToPosition(localView, paramArrayOfInt1[0], paramArrayOfInt1[1], 230, k))
          {
            paramArrayOfInt1[0] = i;
            paramArrayOfInt1[1] = j;
            n = (int)(k + f1);
            f2 = (float)(f1 * 0.9D);
          }
        }
        label230: j += 1;
      }
    }
    if (paramArrayOfInt1[0] == 0)
    {
      i = 1;
      if (i == 0)
        break label356;
      i = paramArrayOfInt1[1] - 1;
      label260: j = i;
      k = m;
    }
    while (true)
    {
      if (j < paramArrayOfInt2[1])
        return;
      if (j == paramArrayOfInt1[1])
      {
        i = paramArrayOfInt1[0] - 1;
        label291: if (j <= paramArrayOfInt2[1])
          break label378;
        m = 0;
        label302: if (i < m)
          break label446;
        localView = this.mContent.getChildAt(i, j);
        if (localView != null)
          break label386;
        f2 = f1;
        n = k;
      }
      while (true)
      {
        i -= 1;
        k = n;
        f1 = f2;
        break label302;
        i = 0;
        break;
        label356: i = paramArrayOfInt1[1];
        break label260;
        i = this.mContent.getCellCountX() - 1;
        break label291;
        label378: m = paramArrayOfInt2[0];
        break label302;
        label386: n = k;
        f2 = f1;
        if (this.mContent.animateChildToPosition(localView, paramArrayOfInt1[0], paramArrayOfInt1[1], 230, k))
        {
          paramArrayOfInt1[0] = i;
          paramArrayOfInt1[1] = j;
          n = (int)(k + f1);
          f2 = (float)(f1 * 0.9D);
        }
      }
      label446: j -= 1;
    }
  }

  public void removeAllNewInstallPrefix()
  {
    this.mContent.removeAllNewInstallPrefixInPage(false, true);
  }

  public void replaceFolderWithFinalItem()
  {
    this.mFinalItem = null;
    if ((getItemCount() == 1) && (this.mCanRemoveFolder))
    {
      this.mCanRemoveFolder = false;
      this.mFinalItem = ((ItemInfo)this.mInfo.contents.get(0));
      this.mContent.removeAllViews();
    }
    Object localObject1 = null;
    int i = 0;
    int m = 0;
    boolean bool2 = false;
    int j;
    Object localObject2;
    boolean bool1;
    int k;
    if (this.mInfo.screenId != 999)
    {
      j = this.mLauncher.getModel().getScreenIndex(this.mInfo.screenId);
      i = j;
      CellLayout localCellLayout = (CellLayout)this.mLauncher.getCellLayout(this.mInfo.container, j);
      if (localCellLayout == null)
      {
        Log.e("Launcher.Folder", "replaceFolderWithFinalItem -- null == cellLayout");
        return;
      }
      localCellLayout.removeView(this.mFolderIcon);
      localObject2 = localCellLayout;
      bool1 = bool2;
      k = m;
      localObject1 = localObject2;
      j = i;
      if (localCellLayout.getChildCount() <= 0)
      {
        k = 1;
        j = i;
        localObject1 = localObject2;
        bool1 = bool2;
      }
      label175: this.mInfo.contents.clear();
      if (this.mLauncher.getColorRectManager().getState() != 4096)
        break label485;
      this.mDeleteFolderOnDropCompleted = true;
    }
    while (true)
    {
      this.mLauncher.removeFolder(this.mInfo);
      if (this.mFinalItem != null)
        LauncherModel.addOrMoveItemInDatabase(this.mLauncher, this.mFinalItem, this.mInfo.container, this.mInfo.screenId, this.mInfo.cellX, this.mInfo.cellY);
      if ((this.mLauncher.getWorkspace().isNormal()) && (k != 0))
        this.mLauncher.getWorkspace().removeNullScreen(true);
      if (this.mFinalItem == null)
        break;
      if (this.mInfo.screenId == 999)
        break label528;
      this.mFinalView = this.mLauncher.createApplicationView(ScreenGridUtils.getApplicationLayout(bool1), localObject1, (ApplicationInfo)this.mFinalItem);
      this.mLauncher.getWorkspace().addInScreen(this.mFinalView, this.mInfo.container, j, this.mInfo.cellX, this.mInfo.cellY, this.mInfo.spanX, this.mInfo.spanY);
      this.mLauncher.getWorkspace().syncAnim(this.mFinalView);
      if (!(this.mFinalView instanceof BubbleTextView))
        break;
      ((BubbleTextView)this.mFinalView).setDarkEffectListener(this.mLauncher.getDarkEffectListener());
      return;
      localObject2 = this.mLauncher.getDockBar();
      bool1 = bool2;
      k = m;
      j = i;
      if (localObject2 == null)
        break label175;
      ((DockBar)localObject2).removeView(this.mFolderIcon);
      ((DockBar)localObject2).removeFolderInfo(this.mInfo);
      localObject1 = localObject2;
      bool1 = true;
      k = m;
      j = i;
      break label175;
      label485: localObject2 = this.mLauncher.getModel();
      if (localObject2 != null)
      {
        ((LauncherModel)localObject2).removeFolder(this.mInfo);
        ((LauncherModel)localObject2).removeItem(this.mInfo);
        ((LauncherModel)localObject2).deleteItemInDatabaseById(this.mInfo.id);
      }
    }
    label528: this.mLauncher.getDockBar().addViewInPos(this.mFinalItem, this.mInfo.cellX);
  }

  public void setChildViewAlpha(float paramFloat, boolean paramBoolean)
  {
    if (this.mContent != null)
      this.mContent.setChildViewAlpha(paramFloat, paramBoolean);
  }

  public void setDeferredAction(Runnable paramRunnable)
  {
    this.mDeferredGobackAction = paramRunnable;
  }

  public void setFocusOnFirstChild()
  {
    View localView = this.mContent.getChildAt(0, 0);
    if (localView != null)
      localView.requestFocus();
  }

  public void setFolderIcon(FolderIcon paramFolderIcon)
  {
    this.mFolderIcon = paramFolderIcon;
  }

  public void setupContentDimensions(int paramInt)
  {
    ArrayList localArrayList = getItemsInReadingOrder();
    this.mContent.getCellCountX();
    this.mContent.getCellCountY();
    int i;
    int j;
    if (this.mOpenInDragMode)
    {
      i = 1;
      j = this.mMaxCountX;
      if (paramInt % this.mMaxCountX == 0)
        break label75;
      paramInt = paramInt / this.mMaxCountX + 1;
    }
    while (true)
    {
      this.mContent.setGridSize(j, paramInt);
      arrangeChildren(localArrayList);
      return;
      i = 0;
      break;
      label75: if (paramInt > 0)
        paramInt = paramInt / this.mMaxCountX + i;
      else
        paramInt = 1;
    }
  }

  public void showFolderScrollerBackground(final boolean paramBoolean)
  {
    final Drawable localDrawable = this.mFolderScrollerBg;
    if (localDrawable == null)
      return;
    float f2 = 0.0F;
    float f1 = 1.0F;
    if (!paramBoolean)
    {
      f2 = this.mScrollerBgAlpha;
      f1 = 0.0F;
    }
    while (true)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          Folder.access$202(Folder.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          if (localDrawable != null)
            localDrawable.setAlpha((int)(Folder.this.mScrollerBgAlpha * 255.0F));
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!paramBoolean)
          {
            Folder.this.mFolderScoll.setBackgroundDrawable(null);
            Folder.this.mFolderScoll.setPadding(Folder.this.mFoldScrollPaddingLeft, Folder.this.mFoldScrollPaddingTop, Folder.this.mFoldScrollPaddingRight, Folder.this.mFoldScrollPaddingBottom);
          }
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (paramBoolean)
          {
            Folder.this.mFolderScoll.setBackgroundDrawable(Folder.this.mFolderScrollerBg);
            Folder.this.mFolderScoll.setPadding(Folder.this.mFoldScrollPaddingLeft, Folder.this.mFoldScrollPaddingTop, Folder.this.mFoldScrollPaddingRight, Folder.this.mFoldScrollPaddingBottom);
          }
        }
      });
      localValueAnimator.setDuration(300);
      localValueAnimator.setStartDelay(0);
      localValueAnimator.start();
      return;
      this.mScrollerBgAlpha = 0.0F;
    }
  }

  public void startEditingFolderName()
  {
    this.mFoldShower.setVisibility(4);
    this.mFoldShower.clearFocus();
    this.mFolderHeader.setBackgroundDrawable(this.mFolderHeaderBg);
    this.mFolderName.setVisibility(0);
    this.mFolderName.setCursorVisible(true);
    this.mFolderNameClear.setVisibility(0);
    this.mFolderName.setText(this.mFoldShower.getText());
    this.mFolderName.requestFocus();
    this.mIsEditingName = true;
    this.mLauncher.setNavBarColor(false);
  }

  public void startTidyuping()
  {
    if ((this.mLauncher.isWorkspaceInOrderOneMode()) && (this.mContent != null))
    {
      int j = this.mContent.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.mContent.getChildAt(i);
        if ((localView instanceof BubbleTextView))
          ((BubbleTextView)localView).setFreezing(false);
        i += 1;
      }
      this.mContent.beginShakeAnimations();
    }
  }

  public String stripStart(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0)
      {
        str = paramString;
        if (paramString.charAt(0) == ' ')
          str = paramString.substring(1);
      }
    }
    return str;
  }

  public boolean supportsFlingToDelete()
  {
    return false;
  }

  public void syncAnim(View paramView)
  {
    int i = 0;
    while (true)
    {
      if (i < this.mContent.getChildCount())
      {
        View localView = this.mContent.getChildAt(i);
        if ((localView != null) && ((localView instanceof IShakeInterface)) && (localView.getVisibility() == 0) && (localView != paramView) && (((IShakeInterface)localView).isShaking()))
          this.mLauncher.getWorkspace().syncAnim(paramView, this.mContent);
      }
      else
      {
        return;
      }
      i += 1;
    }
  }

  public void tempRemoveFolderIcon()
  {
    int i = this.mLauncher.getModel().getScreenIndex(this.mInfo.screenId);
    Object localObject;
    if (this.mInfo.container == -101L)
    {
      localObject = this.mLauncher.getDockBar();
      if (localObject != null);
    }
    do
    {
      return;
      ((DockBar)localObject).removeView(this.mFolderIcon);
      return;
      localObject = (CellLayout)this.mLauncher.getCellLayout(this.mInfo.container, i);
    }
    while (localObject == null);
    ((CellLayout)localObject).removeView(this.mFolderIcon);
  }

  public boolean updateAppInfo(ApplicationInfo paramApplicationInfo)
  {
    return this.mContent.updateAppInfo(paramApplicationInfo, true);
  }

  public void updateItemLocationsInDatabase()
  {
    Object localObject = getItemsInReadingOrder();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
      localArrayList.add((ItemInfo)((View)((Iterator)localObject).next()).getTag());
    if (localArrayList.size() > 0)
    {
      if (this.mModel != null)
        this.mModel.updateDatabaseRunnable(this.mLauncher, localArrayList, this.mInfo.id, this.mInfo.screenId, LauncherModel.UpdateDatabaseMode.INSERT_OR_UPDATE, false, null);
    }
    else
      return;
    Log.w("Launcher.Folder", "updateItemLocationsInDatabase mModel == null");
  }

  public void updateTextColor(int paramInt)
  {
    if (paramInt == 1)
      updateFolderEditTextColor(2131558406);
    while (true)
    {
      invalidate();
      CellLayout localCellLayout = (CellLayout)findViewById(2131492910);
      int j = localCellLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localCellLayout.getChildAt(i);
        if ((localView instanceof IUpdateTextColor))
          ((IUpdateTextColor)localView).updateTextColor(paramInt);
        i += 1;
      }
      if (paramInt == 0)
        updateFolderEditTextColor(2131558407);
    }
  }

  protected void viewVisibilityChange()
  {
    checkTopBarInOrderMode(false);
  }

  class AlphaComparator
    implements Comparator<ApplicationInfo>
  {
    private final Collator sCollator = Collator.getInstance();

    AlphaComparator()
    {
    }

    public final int compare(ApplicationInfo paramApplicationInfo1, ApplicationInfo paramApplicationInfo2)
    {
      return this.sCollator.compare(Folder.this.stripStart(paramApplicationInfo1.title.toString()), Folder.this.stripStart(paramApplicationInfo2.title.toString()));
    }
  }

  class PositionComparator
    implements Comparator<ApplicationInfo>
  {
    PositionComparator()
    {
    }

    public final int compare(ApplicationInfo paramApplicationInfo1, ApplicationInfo paramApplicationInfo2)
    {
      return paramApplicationInfo1.tmpFolderCellY * Folder.this.mContent.mCellCountX + paramApplicationInfo1.tmpFolderCellX - (paramApplicationInfo2.tmpFolderCellY * Folder.this.mContent.mCellCountX + paramApplicationInfo2.tmpFolderCellX);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.Folder
 * JD-Core Version:    0.6.2
 */