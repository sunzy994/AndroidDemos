package com.oppo.launcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.oppo.launcher.graphic.IUpdateTextColor;
import com.oppo.launcher.theme.ThemeUtil;
import com.oppo.unreaderloader.UnreadLoaderDrawInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class FolderIcon extends BaseFolderIcon
  implements FolderInfo.FolderListener, DockBar.CallBacks, IShakeInterface, IUpdateTextColor, IIconTextVisible, OrderModeIconState
{
  private static final int CELLY_OF_DOCKABR = 4;
  private static final boolean DEBUG = false;
  private static final boolean DEBUG_UNREAD = false;
  private static final int REORDER_ANIMATION_DURATION = 280;
  private static final float REORDER_HINT_MAGNITUDE = 0.05F;
  private static final String TAG = "FolderIcon";
  private static int sIconSnowHeight;
  Folder mFolder;
  private Rect mGlobalVisibleRect = new Rect();
  public FolderInfo mInfo;
  private CheckLongPressHelper mLongPressHelper;
  private DockBar.MovingHelper mMovingHelper;
  private int mOrderMoreDropIndex = 0;
  private int mOrderMoreSelectItems = 0;
  private Paint mPaint = new Paint();
  private float mReorderHintAnimationMagnitude;
  private ReorderHintAnimation mShakeAnimators = null;
  private int mUninstallAndSelectIconLeftPadding = 0;
  private int mUninstallAndSelectIconTopPadding = 0;
  private UnreadLoaderDrawInfo mUnreadLoaderDrawInfo = null;
  public int marginTop = 0;

  public FolderIcon(Context paramContext)
  {
    this(paramContext, null);
  }

  public FolderIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FolderIcon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void drawNum(Canvas paramCanvas)
  {
    if ((this.mInfo != null) && (this.mInfo.unreadNum > 0))
    {
      if (this.mUnreadLoaderDrawInfo == null)
        this.mUnreadLoaderDrawInfo = new UnreadLoaderDrawInfo(getContext(), this);
      this.mUnreadLoaderDrawInfo.drawNum(paramCanvas, this.mInfo.unreadNum, this);
      return;
    }
    this.mUnreadLoaderDrawInfo = null;
  }

  public static FolderIcon fromXml(int paramInt, Launcher paramLauncher, ViewGroup paramViewGroup, FolderInfo paramFolderInfo, IconCache paramIconCache)
  {
    paramIconCache = (FolderIcon)LayoutInflater.from(paramLauncher).inflate(paramInt, paramViewGroup, false);
    paramFolderInfo.clearListener();
    paramIconCache.mFolderName = ((BaseTextView)paramIconCache.findViewById(2131492887));
    if ((paramLauncher.isWallpaperBright()) && (ThemeUtil.isDefaultTheme()) && (paramIconCache.mFolderName != null))
      paramIconCache.mFolderName.setTextAppearance(paramViewGroup.getContext(), 2131558406);
    paramIconCache.mFolderName.setText(LauncherUtil.getRealSystemFolderTitle(paramLauncher, paramFolderInfo.title.toString()));
    paramIconCache.mPreviewBackground = ((ImageView)paramIconCache.findViewById(2131492886));
    paramViewGroup = (MarginLayoutParams)paramIconCache.mPreviewBackground.getLayoutParams();
    paramViewGroup.width = Utilities.getIconWidth();
    paramViewGroup.height = Utilities.getIconWidth();
    paramInt = paramViewGroup.height / sIconSnowHeight;
    paramViewGroup.height += paramInt;
    paramIconCache.setPadding(paramIconCache.getPaddingLeft(), paramIconCache.getPaddingTop() - paramInt, paramIconCache.getPaddingRight(), 0);
    paramIconCache.marginTop = (paramInt - paramIconCache.getPaddingTop());
    paramIconCache.mPreviewBackground.setLayoutParams(paramViewGroup);
    paramIconCache.setTag(paramFolderInfo);
    paramIconCache.mInfo = paramFolderInfo;
    paramIconCache.mLauncher = paramLauncher;
    paramIconCache.setContentDescription(String.format(paramLauncher.getString(2131427356), new Object[] { paramFolderInfo.title }));
    paramViewGroup = Folder.fromXml(paramLauncher);
    paramViewGroup.setDragController(paramLauncher.getDragController());
    paramViewGroup.setFolderIcon(paramIconCache);
    paramViewGroup.bind(paramFolderInfo);
    paramIconCache.mFolder = paramViewGroup;
    paramIconCache.mFolderRingAnimator = new BaseFolderIcon.FolderRingAnimator(paramLauncher, null, paramIconCache);
    try
    {
      paramLauncher = paramLauncher.getResources().getDrawable(2130837522);
      paramInt = Utilities.getIconWidth();
      paramLauncher = new FastBitmapDrawable(Bitmap.createScaledBitmap(Utilities.drawable2Bitmap(paramLauncher), paramInt, paramInt, true));
      paramIconCache.mPreviewBackground.setImageDrawable(paramLauncher);
      paramFolderInfo.addListener(paramIconCache);
      return paramIconCache;
    }
    catch (Exception paramLauncher)
    {
      while (true)
        Log.e("FolderIcon", "fromXml --- e = " + paramLauncher);
    }
  }

  private void init()
  {
    this.mLongPressHelper = new CheckLongPressHelper(this);
    Resources localResources = getContext().getResources();
    sIconSnowHeight = localResources.getInteger(2131296283);
    this.mReorderHintAnimationMagnitude = (0.05F * localResources.getDimensionPixelSize(2131361823));
    this.mUninstallAndSelectIconLeftPadding = ((int)localResources.getDimension(2131361915));
    this.mUninstallAndSelectIconTopPadding = ((int)localResources.getDimension(2131361916));
    this.mPaint.setFilterBitmap(true);
  }

  private void updateFrame()
  {
    int i = this.mMovingHelper.getCurrX();
    int j = this.mMovingHelper.getCurrY();
    layout(i, j, i + getWidth(), j + getHeight());
  }

  public void addItem(ApplicationInfo paramApplicationInfo)
  {
    this.mInfo.add(paramApplicationInfo);
    paramApplicationInfo = this.mLauncher.getWorkspace();
    if ((paramApplicationInfo != null) && (paramApplicationInfo.isNormal()))
      paramApplicationInfo.removeNullScreen(true);
  }

  public void beginOrAdjustHintAnimations()
  {
    if (ValueAnimator.getDurationScale() == 0.0F);
    while ((this.mLauncher.isWorkspaceInOrderMoreMode()) || (this.mShakeAnimators != null))
      return;
    this.mShakeAnimators = new ReorderHintAnimation(this);
    this.mShakeAnimators.animate();
  }

  public void beginOrAdjustHintAnimations(int paramInt)
  {
    if (!this.mLauncher.isWorkspaceInOrderOneMode())
      Log.d("FolderIcon", "beginOrAdjustHintAnimations, workspace is not in order one mode, just reture!");
    while ((ValueAnimator.getDurationScale() == 0.0F) || (this.mShakeAnimators != null))
      return;
    this.mShakeAnimators = new ReorderHintAnimation(this);
    this.mShakeAnimators.animate(paramInt);
  }

  public void completeAndClearReorderHintAnimations(boolean paramBoolean)
  {
    if (this.mShakeAnimators != null)
    {
      this.mShakeAnimators.completeAnimationImmediately(paramBoolean);
      this.mShakeAnimators = null;
    }
  }

  public void computeScroll()
  {
    if (isMoving())
    {
      if (!this.mMovingHelper.computeScrollOffset())
        break label26;
      updateFrame();
    }
    while (true)
    {
      invalidate();
      return;
      label26: endMove();
      updateFrame();
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    super.dispatchDraw(paramCanvas);
    if (this.mFolder == null);
    while (((this.mFolder.getItemCount() == 0) && (!this.mAnimating)) || (this.mFolder.folderIsAnimating()))
      return;
    ArrayList localArrayList = this.mFolder.getItemsInReadingOrder(false);
    if (this.mAnimating)
      computePreviewDrawingParams(this.mAnimParams.drawable);
    while (true)
    {
      int j = Math.min(localArrayList.size(), 9);
      if (this.mAnimating)
        break;
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = ((android.widget.TextView)localArrayList.get(i)).getCompoundDrawables()[1];
        this.mParams = computePreviewItemDrawingParams(i, this.mParams);
        this.mParams.drawable = localDrawable;
        drawPreviewItem(paramCanvas, this.mParams);
        i += 1;
      }
      if (localArrayList.size() > 0)
        computePreviewDrawingParams(((android.widget.TextView)localArrayList.get(0)).getCompoundDrawables()[1]);
    }
    drawPreviewItem(paramCanvas, this.mAnimParams);
    paramCanvas.restore();
    if ((this.mLauncher != null) && (this.mLauncher.isWorkspaceInOrderMoreMode()) && (!this.mLauncher.getColorRectManager().isAnimating()))
      drawOrderMoreModeSelectedIcon(paramCanvas);
    drawNum(paramCanvas);
  }

  public void drawOrderMoreModeSelectedIcon(Canvas paramCanvas)
  {
    int i = getScrollX();
    int j = getScrollY();
    if (this.mInfo.mIsOrderModeSelected)
    {
      Bitmap localBitmap = Utilities.getOrderMoreModeSelectedBitmap(getContext());
      if (localBitmap != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i, j);
        int k = this.mUninstallAndSelectIconLeftPadding + (int)((getWidth() - Utilities.getIconWidth()) / 2 + localBitmap.getWidth() * 0.625F - localBitmap.getWidth() * 1.0F);
        int m = this.mUninstallAndSelectIconTopPadding + (int)(getWidth() / 3 * (1.0F - 1.0F));
        paramCanvas.drawBitmap(localBitmap, null, new Rect(k, m, (int)(k + localBitmap.getWidth() * 1.0F), (int)(m + localBitmap.getHeight() * 1.0F)), this.mPaint);
        paramCanvas.translate(-i, -j);
        paramCanvas.restore();
      }
    }
    else
    {
      return;
    }
    Log.w("FolderIcon", "drawOrderMoreModeSelectedIcon, mUninstallBitmap is null==========");
  }

  public void dropNoAnimation(DropTarget.DragObject paramDragObject, ItemInfo paramItemInfo, View paramView)
  {
    int i = 0;
    if (paramDragObject != null)
    {
      paramDragObject = (ApplicationInfo)paramDragObject.dragInfo;
      this.mFolder.notifyDrop();
      onDrop(paramDragObject, null, null, 1.0F, this.mInfo.contents.size(), null);
      i = 1;
    }
    if ((paramItemInfo != null) && (i == this.mInfo.contents.size()))
      onDrop((ApplicationInfo)paramItemInfo, null, null, 1.0F, this.mInfo.contents.size(), null);
    if ((this.mInfo.screenId != 999) && (paramView != null))
    {
      i = this.mLauncher.getModel().getScreenIndex(this.mInfo.screenId);
      paramDragObject = (CellLayout)this.mLauncher.getCellLayout(this.mInfo.container, i);
      if ((paramDragObject != null) && (paramView != null))
        paramDragObject.removeView(paramView);
    }
    do
    {
      do
        return;
      while (paramView == null);
      paramDragObject = this.mLauncher.getDockBar();
    }
    while (paramDragObject == null);
    paramDragObject.removeView(paramView);
  }

  public void endMove()
  {
    if (this.mMovingHelper != null)
    {
      this.mMovingHelper.endMove();
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null)
      {
        localViewGroup.computeScroll();
        invalidate();
      }
    }
  }

  public void fristStartOpenFolder()
  {
    this.mLauncher.openFolder(this, true);
  }

  public void getDrawableVisibleRect(Rect paramRect)
  {
    if (this.mPreviewBackground != null)
    {
      Drawable localDrawable = this.mPreviewBackground.getDrawable();
      float[] arrayOfFloat = new float[2];
      float[] tmp20_19 = arrayOfFloat;
      tmp20_19[0] = 0.0F;
      float[] tmp24_20 = tmp20_19;
      tmp24_20[1] = 0.0F;
      tmp24_20;
      if (this.mPreviewBackground.getMatrix() != null)
        this.mPreviewBackground.getMatrix().mapPoints(arrayOfFloat);
      arrayOfFloat[0] += this.mPreviewBackground.getLeft();
      arrayOfFloat[1] += this.mPreviewBackground.getTop();
      paramRect.left = ((int)arrayOfFloat[0]);
      paramRect.top = ((int)arrayOfFloat[1]);
      paramRect.right = (paramRect.left + localDrawable.getIntrinsicWidth());
      paramRect.bottom = (paramRect.top + localDrawable.getIntrinsicHeight());
    }
  }

  public float getDropAnimatorRect(Rect paramRect, int paramInt)
  {
    float f1 = 1.0F;
    if (paramRect == null)
      return 1.0F;
    int i = paramInt;
    if (paramInt >= 9)
      i = 4;
    int j = i / 3;
    int k = BaseFolderIcon.FolderRingAnimator.sPreviewSubIconGap;
    int n = this.mBaselineIconSize;
    int m = this.mBaselineIconSize;
    paramInt = getWidth();
    i = this.mPreviewOffsetX + (i % 3 * (n + k) + 0);
    float f2 = this.mPreviewOffsetY;
    if (this.mLauncher != null)
      f1 = this.mLauncher.getWorkspace().getSpringLoadedShrinkFactor();
    j = (int)(f2 / f1 + (j * (m + k) + 0));
    paramRect.set(i, j, i + paramInt, j + paramInt);
    return this.mBaselineIconScale;
  }

  public FastBitmapDrawable getFastBitmapDrawable()
  {
    Object localObject = this.mPreviewBackground.getDrawable();
    if (localObject != null)
      return (FastBitmapDrawable)localObject;
    Log.e("FolderIcon", "getFastBitmapDrawable == null !!, folder title = " + this.mFolderName.getText());
    localObject = this.mLauncher.getResources().getDrawable(2130837522);
    int i = Utilities.getIconWidth();
    localObject = new FastBitmapDrawable(Bitmap.createScaledBitmap(Utilities.drawable2Bitmap((Drawable)localObject), i, i, true));
    this.mPreviewBackground.setImageDrawable((Drawable)localObject);
    return (FastBitmapDrawable)localObject;
  }

  public Folder getFolder()
  {
    return this.mFolder;
  }

  public int getOrderMoreCurrentDropIndex()
  {
    return this.mOrderMoreDropIndex;
  }

  public boolean isDropEnabled(DropTarget.DragObject paramDragObject)
  {
    return ((Workspace)((ViewGroup)getParent()).getParent()).isNormal();
  }

  public boolean isFull()
  {
    return this.mFolder.isFull();
  }

  public boolean isMoving()
  {
    if (this.mMovingHelper != null)
      return this.mMovingHelper.isMoving();
    return false;
  }

  public boolean isOrderMoreModeSelected()
  {
    return this.mInfo.mIsOrderModeSelected;
  }

  public boolean isShaking()
  {
    return this.mShakeAnimators != null;
  }

  public void joinAnimations(View paramView)
  {
    if ((this.mShakeAnimators != null) && ((paramView instanceof IShakeInterface)))
    {
      paramView.clearAnimation();
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
      paramView.setTranslationX(0.0F);
      paramView.setTranslationY(0.0F);
      this.mShakeAnimators.join(paramView);
    }
  }

  public void onAdd(ApplicationInfo paramApplicationInfo)
  {
    invalidate();
    requestLayout();
  }

  protected void onAttachedToWindow()
  {
    Workspace localWorkspace = null;
    if (this.mLauncher != null)
      localWorkspace = this.mLauncher.getWorkspace();
    if (localWorkspace == null)
      Log.w("FolderIcon", "onAttachedToWindow -- workspace is null, return");
    do
    {
      return;
      super.onAttachedToWindow();
      if ((localWorkspace.isOrderOneMode()) && (this.mInfo != null) && (this.mInfo.container != -101L))
        localWorkspace.syncAnim(this);
    }
    while ((this.mLauncher == null) || (!this.mLauncher.isWorkspaceInOrderMoreMode()));
    setAlpha(0.7F);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    completeAndClearReorderHintAnimations(false);
  }

  public void onDragEnter(Object paramObject)
  {
    if (!willAcceptItem((ItemInfo)paramObject));
    while (true)
    {
      return;
      completeAndClearReorderHintAnimations(false);
      Object localObject = getParent();
      if ((localObject instanceof CellLayout))
      {
        paramObject = (BaseCellLayout.LayoutParams)getLayoutParams();
        localObject = (CellLayout)localObject;
        this.mFolderRingAnimator.setCell(paramObject.cellX, paramObject.cellY);
        this.mFolderRingAnimator.setCellLayout((BaseCellLayout)localObject);
        this.mFolderRingAnimator.setDockBar(null);
        this.mFolderRingAnimator.animateToAcceptState(false);
        ((CellLayout)localObject).showFolderAccept(this.mFolderRingAnimator);
      }
      while ((this.mLauncher != null) && (!this.mLauncher.isWorkspaceInOrderMoreMode()))
      {
        this.mOpenFolderAlarm.setOnAlarmListener(this.mOpenFolderAlarmListener);
        this.mOpenFolderAlarm.setAlarm(1500L);
        return;
        if ((localObject instanceof DockBar))
        {
          paramObject = (DockBar)localObject;
          localObject = (ItemInfo)getTag();
          this.mFolderRingAnimator.setCell(((ItemInfo)localObject).cellX, ((ItemInfo)localObject).cellY);
          this.mFolderRingAnimator.setCellLayout(null);
          this.mFolderRingAnimator.setDockBar(paramObject);
          this.mFolderRingAnimator.animateToAcceptState(false);
          paramObject.showFolderAccept(this.mFolderRingAnimator);
        }
      }
    }
  }

  public void onDragExit(Object paramObject)
  {
    if (this.mOpenFolderAlarm.alarmPending())
      this.mOpenFolderAlarm.cancelAlarm();
    beginOrAdjustHintAnimations();
    super.onDragExit(paramObject);
  }

  public void onDragOver(Object paramObject)
  {
  }

  public void onDrop(final ApplicationInfo paramApplicationInfo, DragView paramDragView, Rect paramRect, float paramFloat, int paramInt, Runnable paramRunnable)
  {
    paramApplicationInfo.cellX = -1;
    paramApplicationInfo.cellY = -1;
    Object localObject;
    if (paramApplicationInfo.container == -100L)
    {
      localObject = this.mLauncher.getModel();
      if (localObject != null)
        ((LauncherModel)localObject).removeItem(paramApplicationInfo);
    }
    while (paramDragView != null)
    {
      DragLayer localDragLayer = this.mLauncher.getDragLayer();
      Rect localRect = new Rect();
      localDragLayer.getViewRectRelativeToSelf(paramDragView, localRect);
      localObject = paramRect;
      paramRect = (Rect)localObject;
      float f1;
      float f2;
      if (localObject == null)
      {
        paramRect = new Rect();
        localObject = getParent();
        if (localObject == null)
        {
          Log.i("FolderIcon", "onDrop, parent of this folder icon is null, return !");
          this.mOnDropWithTransX = 0;
          return;
          if (paramApplicationInfo.container == -101L)
          {
            localObject = this.mLauncher.getDockBar();
            if (localObject != null)
              ((DockBar)localObject).removeItemInfo(paramApplicationInfo);
          }
        }
        else if ((localObject instanceof DockBar))
        {
          f1 = getScaleX();
          f2 = getScaleY();
          setScaleX(1.0F);
          setScaleY(1.0F);
          paramFloat = localDragLayer.getDescendantRectRelativeToSelf(this, paramRect);
          setScaleX(f1);
          setScaleY(f2);
        }
      }
      else
      {
        localObject = new int[2];
        f2 = getLocalCenterForIndex(paramInt, (int[])localObject);
        localObject[0] = Math.round(localObject[0] * paramFloat);
        localObject[1] = Math.round(localObject[1] * paramFloat);
        paramRect.offset(localObject[0] - paramDragView.getMeasuredWidth() / 2, localObject[1] - paramDragView.getMeasuredHeight() / 2);
        if (paramInt < 9);
        for (f1 = 0.5F; ; f1 = 0.0F)
        {
          localObject = null;
          if (this.mOnDropWithTransX != 0)
          {
            if (this.mMovingHelper == null)
              this.mMovingHelper = DockBar.MovingHelper.getInstance(this, super.getContext());
            localObject = this.mMovingHelper.getInterpolator(true);
            this.mFolderRingAnimator.setMoveXInterpolator((Interpolator)localObject);
          }
          localDragLayer.animateView(paramDragView, localRect, paramRect, f1, 1.0F, 1.0F, f2 * paramFloat, f2 * paramFloat, 300, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), (Interpolator)localObject, this.mOnDropWithTransX, paramRunnable, 0, null);
          this.mInfo.justAdd(paramApplicationInfo);
          postDelayed(new Runnable()
          {
            public void run()
            {
              FolderIcon.this.mInfo.justNoticeChange(paramApplicationInfo);
              Workspace localWorkspace = FolderIcon.this.mLauncher.getWorkspace();
              if (localWorkspace != null)
              {
                if (localWorkspace.isNormal())
                  localWorkspace.removeNullScreen(true);
                ViewParent localViewParent = FolderIcon.this.getParent();
                if ((localViewParent instanceof CellLayout))
                  localWorkspace.fillEmptyAfterCreateOrAddToFolder((CellLayout)localViewParent, null, true);
              }
              FolderIcon.this.mOnDropWithTransX = 0;
            }
          }
          , 300L);
          return;
          Workspace localWorkspace = this.mLauncher.getWorkspace();
          localWorkspace.setFinalTransitionTransform((CellLayout)localObject);
          f1 = getScaleX();
          f2 = getScaleY();
          setScaleX(1.0F);
          setScaleY(1.0F);
          paramFloat = localDragLayer.getDescendantRectRelativeToSelf(this, paramRect);
          setScaleX(f1);
          setScaleY(f2);
          localWorkspace.resetTransitionTransform((CellLayout)localObject);
          break;
        }
      }
    }
    addItem(paramApplicationInfo);
  }

  public void onDrop(DropTarget.DragObject paramDragObject)
  {
    if (this.mOpenFolderAlarm.alarmPending())
      this.mOpenFolderAlarm.cancelAlarm();
    ApplicationInfo localApplicationInfo = (ApplicationInfo)paramDragObject.dragInfo;
    this.mFolder.notifyDrop();
    onDrop(localApplicationInfo, paramDragObject.dragView, null, 1.0F, this.mInfo.contents.size(), paramDragObject.postAnimationRunnable);
  }

  public void onRemove(ApplicationInfo paramApplicationInfo)
  {
    invalidate();
    requestLayout();
  }

  public void onTextVisible(boolean paramBoolean)
  {
    if (paramBoolean)
      this.mFolderName.setVisibility(0);
    while ((Utilities.mHasNavigationBar) && (this.mInfo.container == -101L))
      return;
    this.mFolderName.setVisibility(4);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if ((paramMotionEvent.getAction() == 0) && (!checkTouchArea(paramMotionEvent)))
      bool1 = true;
    boolean bool2;
    do
    {
      do
      {
        long l1;
        long l2;
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool2 = super.onTouchEvent(paramMotionEvent);
                switch (paramMotionEvent.getAction())
                {
                default:
                  return bool2;
                case 0:
                  this.mLongPressHelper.postCheckForLongPress();
                  this.mTouchTime = SystemClock.uptimeMillis();
                  return bool2;
                case 3:
                  this.mLongPressHelper.cancelLongPress();
                  return bool2;
                case 2:
                  bool1 = bool2;
                case 1:
                }
              }
              while (checkTouchArea(paramMotionEvent));
              if (this.mLauncher.isWorkspaceInOrderMoreMode())
                break;
              bool1 = bool2;
            }
            while (!this.mLauncher.isWorkspaceSpringLoaded());
            this.mLongPressHelper.cancelLongPress();
            return bool2;
            this.mLongPressHelper.cancelLongPress();
            l1 = SystemClock.uptimeMillis();
            l2 = this.mTouchTime;
            bool1 = bool2;
          }
          while (!checkTouchArea(paramMotionEvent));
          bool1 = bool2;
        }
        while (l1 - l2 > 500L);
        if (!this.mLauncher.isWorkspaceInOrderMoreMode())
          break;
        bool1 = bool2;
      }
      while ((getParent() instanceof DockBar));
      bool1 = bool2;
    }
    while (!this.mLauncher.getColorRectManager().isInitState());
    if (!LauncherUtil.isSearchShowing())
      playSoundEffect(0);
    this.mLauncher.onClick(this);
    return bool2;
  }

  public void performCreateAnimation(ApplicationInfo paramApplicationInfo1, View paramView, ApplicationInfo paramApplicationInfo2, DragView paramDragView, Rect paramRect, float paramFloat, Runnable paramRunnable)
  {
    computePreviewDrawingParams(((android.widget.TextView)paramView).getCompoundDrawables()[1].getIntrinsicWidth(), paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    addItem(paramApplicationInfo1);
    onDrop(paramApplicationInfo2, paramDragView, paramRect, paramFloat, 1, paramRunnable);
  }

  public void removeAllNewInstallPrefix()
  {
    this.mFolder.removeAllNewInstallPrefix();
  }

  public void setDrawableAlpha(int paramInt)
  {
    paramInt = Color.argb(255 - paramInt, 0, 0, 0);
    this.mPreviewBackground.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
  }

  public void setFolderUnreadNum(int paramInt)
  {
    if (paramInt <= 0);
    for (this.mInfo.unreadNum = 0; ; this.mInfo.unreadNum = paramInt)
    {
      invalidate();
      return;
    }
  }

  public void setOrderMoreCurrentDropIndex(int paramInt)
  {
    this.mOrderMoreDropIndex = paramInt;
  }

  public void setOrderMoreModeSelected(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mInfo.mIsOrderModeSelected != paramBoolean1)
    {
      this.mInfo.mIsOrderModeSelected = paramBoolean1;
      invalidate();
    }
    if (this.mInfo.mIsOrderModeSelected);
    for (float f = 1.0F; ; f = 0.7F)
    {
      setAlpha(f);
      return;
    }
  }

  public void setOrderMoreModeSelected(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3)
    {
      this.mOrderMoreSelectItems = 0;
      if (this.mOrderMoreSelectItems <= 0)
        break label67;
    }
    label65: label67: for (paramBoolean1 = true; ; paramBoolean1 = false)
    {
      setOrderMoreModeSelected(paramBoolean1, false);
      return;
      if (paramBoolean1);
      for (this.mOrderMoreSelectItems += 1; ; this.mOrderMoreSelectItems -= 1)
      {
        if (this.mOrderMoreSelectItems >= 0)
          break label65;
        this.mOrderMoreSelectItems = 0;
        break;
      }
      break;
    }
  }

  public void startMove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.mFolderRingAnimator != null) && (this.mFolderRingAnimator.isExiting()))
      this.mFolderRingAnimator.cancelNeturalAnimator();
    if (this.mMovingHelper == null)
      this.mMovingHelper = DockBar.MovingHelper.getInstance(this, super.getContext());
    Object localObject = getParent();
    if (((localObject instanceof DockBar)) && (((DockBar)localObject).isAddToExistingFolderOnDrop()))
    {
      DockBar.MovingHelper localMovingHelper = this.mMovingHelper;
      int i = getLeft();
      int j = getTop();
      localObject = (DockBar)localObject;
      localMovingHelper.startMove(i, j, paramInt1, paramInt2, paramBoolean, 300);
    }
    while (true)
    {
      invalidate();
      return;
      this.mMovingHelper.startMove(getLeft(), getTop(), paramInt1, paramInt2, paramBoolean);
    }
  }

  public void startOpenFolder()
  {
    this.mLauncher.openFolder(this);
  }

  public boolean updateAppInfo(ApplicationInfo paramApplicationInfo)
  {
    if (this.mInfo.opened)
    {
      Log.w("FolderIcon", "app.screen != mInfo.screenId, return false");
      return false;
    }
    return this.mFolder.updateAppInfo(paramApplicationInfo);
  }

  public void updateFolderUnreadNum()
  {
    Object localObject = this.mInfo.contents;
    int i = 0;
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
      i += ((ApplicationInfo)((Iterator)localObject).next()).unreadNum;
    setFolderUnreadNum(i);
  }

  public void updateFolderUnreadNum(ComponentName paramComponentName, int paramInt)
  {
    Object localObject = this.mInfo.contents;
    int i = 0;
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)((Iterator)localObject).next();
      ComponentName localComponentName = localApplicationInfo.intent.getComponent();
      if ((localComponentName != null) && (localComponentName.equals(paramComponentName)))
        localApplicationInfo.unreadNum = paramInt;
      i += localApplicationInfo.unreadNum;
    }
    setFolderUnreadNum(i);
  }

  public void updateTextColor(int paramInt)
  {
    if (this.mFolderName != null)
    {
      if (paramInt != 1)
        break label38;
      this.mFolderName.setTextAppearance(getContext(), 2131558406);
    }
    while (true)
    {
      this.mFolder.updateTextColor(paramInt);
      invalidate();
      return;
      label38: if (paramInt == 0)
        this.mFolderName.setTextAppearance(getContext(), 2131558407);
    }
  }

  public boolean willAcceptItem(ItemInfo paramItemInfo)
  {
    int i = paramItemInfo.itemType;
    return ((i == 0) || (i == 1)) && (!this.mFolder.isFull()) && (paramItemInfo != this.mInfo) && (!this.mInfo.opened);
  }

  public void zoomAnimateView(DragView paramDragView)
  {
    DragLayer localDragLayer = this.mLauncher.getDragLayer();
    if (localDragLayer == null)
      return;
    Rect localRect1 = new Rect();
    localDragLayer.getViewRectRelativeToSelf(paramDragView, localRect1);
    int i = this.mInfo.contents.size();
    Object localObject = new int[2];
    float f2 = getLocalCenterForIndex(i, (int[])localObject);
    Rect localRect2 = new Rect();
    float f3 = localDragLayer.getDescendantRectRelativeToSelf(this, localRect2);
    localObject[0] = Math.round(localObject[0] * f3);
    localObject[1] = Math.round(localObject[1] * f3);
    localRect2.offset(localObject[0] - paramDragView.getMeasuredWidth() / 2, localObject[1] - paramDragView.getMeasuredHeight() / 2);
    if (i < 9);
    for (float f1 = 0.5F; ; f1 = 0.0F)
    {
      localObject = null;
      if (this.mOnDropWithTransX != 0)
      {
        if (this.mMovingHelper == null)
          this.mMovingHelper = DockBar.MovingHelper.getInstance(this, super.getContext());
        localObject = this.mMovingHelper.getInterpolator(true);
        this.mFolderRingAnimator.setMoveXInterpolator((Interpolator)localObject);
      }
      Runnable local2 = new Runnable()
      {
        public void run()
        {
          ItemInfo localItemInfo = FolderIcon.this.mLauncher.getDockBar().getSwitchInfo();
          FolderIcon.this.mInfo.add((ApplicationInfo)localItemInfo);
        }
      };
      localDragLayer.animateView(paramDragView, localRect1, localRect2, f1, 1.0F, 1.0F, f2 * f3, f2 * f3, 300, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), (Interpolator)localObject, this.mOnDropWithTransX, local2, 0, null);
      return;
    }
  }

  class ReorderHintAnimation
  {
    private static final int DURATION = 300;
    Animator a;
    View child;
    float finalDeltaX = 0.0F;
    float finalDeltaY = -FolderIcon.this.mReorderHintAnimationMagnitude;
    float finalScale;
    float initDeltaX;
    float initDeltaY;
    float initScale;
    ArrayList<View> mjoinView = new ArrayList();
    int progress = 0;

    public ReorderHintAnimation(View arg2)
    {
      Object localObject;
      this.initDeltaX = localObject.getTranslationX();
      this.initDeltaY = localObject.getTranslationY();
      this.finalScale = (1.0F - 7.0F / Utilities.getIconWidth());
      this.initScale = localObject.getScaleX();
      this.child = localObject;
      this.progress = 0;
    }

    private void completeAnimationImmediately(boolean paramBoolean)
    {
      if (this.a != null)
        this.a.cancel();
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.a = localAnimatorSet;
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.child, "scaleX", new float[] { 1.0F }), ObjectAnimator.ofFloat(this.child, "scaleY", new float[] { 1.0F }), ObjectAnimator.ofFloat(this.child, "translationX", new float[] { 0.0F }), ObjectAnimator.ofFloat(this.child, "translationY", new float[] { 0.0F }) });
      localAnimatorSet.setDuration(280L);
      localAnimatorSet.setInterpolator(new DecelerateInterpolator(1.5F));
      localAnimatorSet.start();
    }

    private void join(View paramView)
    {
      synchronized (this.mjoinView)
      {
        if (!this.mjoinView.contains(paramView))
          this.mjoinView.add(paramView);
        return;
      }
    }

    void animate()
    {
      animate((int)(Math.random() * 100.0D));
    }

    void animate(int paramInt)
    {
      if ((this.finalDeltaX == 0.0F) && (this.finalDeltaY == 0.0F))
        return;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.a = localValueAnimator;
      localValueAnimator.setRepeatMode(2);
      localValueAnimator.setRepeatCount(-1);
      localValueAnimator.setDuration(300L);
      localValueAnimator.setStartDelay(paramInt);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = ReorderHintAnimation.this.finalDeltaX;
          float f3 = ReorderHintAnimation.this.initDeltaX;
          float f4 = ReorderHintAnimation.this.finalDeltaY;
          float f5 = ReorderHintAnimation.this.initDeltaY;
          ReorderHintAnimation.this.child.setTranslationX(f2 * f1 + (1.0F - f1) * f3);
          ReorderHintAnimation.this.child.setTranslationY(f4 * f1 + (1.0F - f1) * f5);
          f1 = ReorderHintAnimation.this.finalScale * f1 + (1.0F - f1) * ReorderHintAnimation.this.initScale;
          ReorderHintAnimation.this.child.setScaleX(f1);
          ReorderHintAnimation.this.child.setScaleY(f1);
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator arg1)
        {
          synchronized (ReorderHintAnimation.this.mjoinView)
          {
            if (ReorderHintAnimation.this.mjoinView.size() > 0)
              ReorderHintAnimation.this.mjoinView.clear();
            return;
          }
        }

        public void onAnimationRepeat(Animator arg1)
        {
          ReorderHintAnimation.this.initDeltaX = 0.0F;
          ReorderHintAnimation.this.initDeltaY = 0.0F;
          ReorderHintAnimation.this.initScale = 1.0F;
          ??? = ReorderHintAnimation.this;
          ???.progress += 1;
          ??? = ReorderHintAnimation.this;
          ???.progress %= 2;
          while (true)
          {
            int i;
            synchronized (ReorderHintAnimation.this.mjoinView)
            {
              if ((ReorderHintAnimation.this.mjoinView.size() > 0) && (ReorderHintAnimation.this.progress % 2 == 0))
              {
                i = 0;
                if (i < ReorderHintAnimation.this.mjoinView.size())
                {
                  View localView = (View)ReorderHintAnimation.this.mjoinView.get(i);
                  if (localView != null)
                    ((IShakeInterface)localView).beginOrAdjustHintAnimations(0);
                }
                else
                {
                  ReorderHintAnimation.this.mjoinView.clear();
                }
              }
              else
              {
                return;
              }
            }
            i += 1;
          }
        }
      });
      localValueAnimator.start();
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.FolderIcon
 * JD-Core Version:    0.6.2
 */