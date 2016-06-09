package com.oppo.launcher;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

public class AppWidgetResizeFrame extends FrameLayout
{
  public static final int BOTTOM = 3;
  private static boolean DEBUG = false;
  public static final int LEFT = 0;
  public static final int RIGHT = 2;
  private static final String TAG = "AppWidgetResizeFrame";
  public static final int TOP = 1;
  private static Rect mTmpRect = new Rect();
  final int BACKGROUND_PADDING = 24;
  final float DIMMED_HANDLE_ALPHA = 0.0F;
  final float RESIZE_THRESHOLD = 0.66F;
  final int SNAP_DURATION = 150;
  private int mBackgroundPadding;
  private int mBaselineHeight;
  private int mBaselineWidth;
  private int mBaselineX;
  private int mBaselineY;
  private boolean mBottomBorderActive;
  private ImageView mBottomHandle;
  private CellLayout mCellLayout;
  private int mDeltaX;
  private int mDeltaXAddOn;
  private int mDeltaY;
  private int mDeltaYAddOn;
  private DragLayer mDragLayer;
  private Launcher mLauncher;
  private boolean mLeftBorderActive;
  private ImageView mLeftHandle;
  private int mMinHSpan;
  private int mMinVSpan;
  private int mResizeMode;
  private boolean mRightBorderActive;
  private ImageView mRightHandle;
  private int mRunningHInc;
  private int mRunningVInc;
  private boolean mTopBorderActive;
  private ImageView mTopHandle;
  private int mTouchTargetWidth;
  private int mWidgetPaddingBottom;
  private int mWidgetPaddingLeft;
  private int mWidgetPaddingRight;
  private int mWidgetPaddingTop;
  private Rect mWidgetSizeRect = new Rect();
  private LauncherAppWidgetHostView mWidgetView;

  public AppWidgetResizeFrame(Context paramContext, ItemInfo paramItemInfo, LauncherAppWidgetHostView paramLauncherAppWidgetHostView, CellLayout paramCellLayout, DragLayer paramDragLayer)
  {
    super(paramContext);
    this.mLauncher = ((Launcher)paramContext);
    this.mCellLayout = paramCellLayout;
    this.mWidgetView = paramLauncherAppWidgetHostView;
    this.mResizeMode = paramLauncherAppWidgetHostView.getAppWidgetInfo().resizeMode;
    this.mDragLayer = paramDragLayer;
    paramItemInfo = paramLauncherAppWidgetHostView.getAppWidgetInfo();
    paramItemInfo = this.mLauncher.getMinResizeSpanForWidget(paramItemInfo, null);
    this.mMinHSpan = paramItemInfo[0];
    this.mMinVSpan = paramItemInfo[1];
    setBackgroundResource(2130837569);
    setPadding(0, 0, 0, 0);
    this.mLeftHandle = new ImageView(paramContext);
    this.mLeftHandle.setImageResource(2130837571);
    paramItemInfo = new LayoutParams(-2, -2, 19);
    addView(this.mLeftHandle, paramItemInfo);
    this.mRightHandle = new ImageView(paramContext);
    this.mRightHandle.setImageResource(2130837572);
    paramItemInfo = new LayoutParams(-2, -2, 21);
    addView(this.mRightHandle, paramItemInfo);
    this.mTopHandle = new ImageView(paramContext);
    this.mTopHandle.setImageResource(2130837573);
    paramItemInfo = new LayoutParams(-2, -2, 49);
    addView(this.mTopHandle, paramItemInfo);
    this.mBottomHandle = new ImageView(paramContext);
    this.mBottomHandle.setImageResource(2130837570);
    paramItemInfo = new LayoutParams(-2, -2, 81);
    addView(this.mBottomHandle, paramItemInfo);
    paramContext = AppWidgetHostView.getDefaultPaddingForWidget(paramContext, paramLauncherAppWidgetHostView.getAppWidgetInfo().provider, null);
    this.mWidgetPaddingLeft = paramContext.left;
    this.mWidgetPaddingTop = paramContext.top;
    this.mWidgetPaddingRight = paramContext.right;
    this.mWidgetPaddingBottom = paramContext.bottom;
    if (this.mResizeMode == 1)
    {
      this.mTopHandle.setVisibility(8);
      this.mBottomHandle.setVisibility(8);
    }
    while (true)
    {
      this.mBackgroundPadding = ((int)Math.ceil(24.0F * this.mLauncher.getResources().getDisplayMetrics().density));
      this.mTouchTargetWidth = (this.mBackgroundPadding * 2);
      this.mCellLayout.markCellsAsUnoccupiedForView(this.mWidgetView);
      return;
      if (this.mResizeMode == 2)
      {
        this.mLeftHandle.setVisibility(8);
        this.mRightHandle.setVisibility(8);
      }
    }
  }

  static int getCellHeight(Launcher paramLauncher)
  {
    paramLauncher = paramLauncher.getWorkspace();
    if (paramLauncher != null)
    {
      paramLauncher = paramLauncher.getCurrentDropLayout();
      if (paramLauncher != null)
        return paramLauncher.getCellHeight();
    }
    return -1;
  }

  static int getCellWidth(Launcher paramLauncher)
  {
    paramLauncher = paramLauncher.getWorkspace();
    if (paramLauncher != null)
    {
      paramLauncher = paramLauncher.getCurrentDropLayout();
      if (paramLauncher != null)
        return paramLauncher.getCellWidth();
    }
    return -1;
  }

  static Rect getWidgetSizeRanges(Launcher paramLauncher, int paramInt1, int paramInt2, Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null)
      localRect = new Rect();
    float f = paramLauncher.getResources().getDisplayMetrics().density;
    int j = getCellWidth(paramLauncher);
    int i = getCellHeight(paramLauncher);
    paramInt1 = (int)((paramInt1 * j + (paramInt1 - 1) * 0) / f);
    paramInt2 = (int)((paramInt2 * i + (paramInt2 - 1) * 0) / f);
    localRect.set(paramInt1, paramInt2, paramInt1, paramInt2);
    return localRect;
  }

  private void resizeWidgetIfNeeded(boolean paramBoolean)
  {
    int i = this.mCellLayout.getCellWidth();
    int j = this.mCellLayout.getWidthGap();
    int k = this.mCellLayout.getCellHeight();
    int m = this.mCellLayout.getHeightGap();
    int n = this.mDeltaX;
    int i1 = this.mDeltaXAddOn;
    int i2 = this.mDeltaY;
    int i3 = this.mDeltaYAddOn;
    float f1 = 1.0F * (n + i1) / (i + j) - this.mRunningHInc;
    float f2 = 1.0F * (i2 + i3) / (k + m) - this.mRunningVInc;
    i1 = 0;
    m = 0;
    i2 = 0;
    int i5 = 0;
    int i4 = this.mCellLayout.getCellCountX();
    int i9 = this.mCellLayout.getCellCountY();
    if (Math.abs(f1) > 0.66F)
      i1 = Math.round(f1);
    if (Math.abs(f2) > 0.66F)
      m = Math.round(f2);
    if ((!paramBoolean) && (i1 == 0) && (m == 0))
      return;
    BaseCellLayout.LayoutParams localLayoutParams = (BaseCellLayout.LayoutParams)this.mWidgetView.getLayoutParams();
    int i7 = localLayoutParams.cellHSpan;
    int i6 = localLayoutParams.cellVSpan;
    label222: label237: int i8;
    if (localLayoutParams.useTmpCoords)
    {
      j = localLayoutParams.tmpCellX;
      if (!localLayoutParams.useTmpCoords)
        break label589;
      i = localLayoutParams.tmpCellY;
      k = 0;
      i8 = 0;
      if (!this.mLeftBorderActive)
        break label599;
      k = Math.max(-j, i1);
      i3 = Math.min(localLayoutParams.cellHSpan - this.mMinHSpan, k);
      k = Math.min(j, i1 * -1);
      n = Math.max(-(localLayoutParams.cellHSpan - this.mMinHSpan), k);
      k = -n;
      label311: if (!this.mTopBorderActive)
        break label658;
      i1 = Math.max(-i, m);
      i4 = Math.min(localLayoutParams.cellVSpan - this.mMinVSpan, i1);
      m = Math.min(i, m * -1);
      i2 = Math.max(-(localLayoutParams.cellVSpan - this.mMinVSpan), m);
      i1 = -i2;
    }
    while (true)
    {
      if (!this.mLeftBorderActive)
      {
        i5 = j;
        m = i7;
        if (!this.mRightBorderActive);
      }
      else
      {
        m = i7 + n;
        i5 = j + i3;
      }
      if (!this.mTopBorderActive)
      {
        n = i;
        j = i6;
        if (!this.mBottomBorderActive);
      }
      else
      {
        j = i6 + i2;
        n = i + i4;
      }
      if ((!paramBoolean) && (i1 == 0) && (k == 0))
        break;
      if (this.mCellLayout.createAreaForResize(i5, n, m, j, this.mWidgetView, paramBoolean))
      {
        localLayoutParams.tmpCellX = i5;
        localLayoutParams.cellX = i5;
        localLayoutParams.tmpCellY = n;
        localLayoutParams.cellY = n;
        localLayoutParams.cellHSpan = m;
        localLayoutParams.cellVSpan = j;
        this.mRunningVInc += i1;
        this.mRunningHInc += k;
        if (!paramBoolean)
          updateWidgetSizeRanges(this.mWidgetView, this.mLauncher, m, j);
      }
      this.mWidgetView.requestLayout();
      return;
      j = localLayoutParams.cellX;
      break label222;
      label589: i = localLayoutParams.cellY;
      break label237;
      label599: i3 = i2;
      n = i1;
      if (!this.mRightBorderActive)
        break label311;
      k = Math.min(i4 - (j + i7), i1);
      n = Math.max(-(localLayoutParams.cellHSpan - this.mMinHSpan), k);
      k = n;
      i3 = i2;
      break label311;
      label658: i4 = i5;
      i1 = i8;
      i2 = m;
      if (this.mBottomBorderActive)
      {
        m = Math.min(i9 - (i + i6), m);
        i2 = Math.max(-(localLayoutParams.cellVSpan - this.mMinVSpan), m);
        i1 = i2;
        i4 = i5;
      }
    }
  }

  static void updateWidgetSizeRanges(AppWidgetHostView paramAppWidgetHostView, Launcher paramLauncher, int paramInt1, int paramInt2)
  {
    getWidgetSizeRanges(paramLauncher, paramInt1, paramInt2, mTmpRect);
    paramAppWidgetHostView.updateAppWidgetSize(null, mTmpRect.left, mTmpRect.top, mTmpRect.right, mTmpRect.bottom);
  }

  private void visualizeResizeForDelta(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    updateDeltas(paramInt1, paramInt2);
    DragLayer.LayoutParams localLayoutParams = (DragLayer.LayoutParams)getLayoutParams();
    if (this.mLeftBorderActive)
    {
      localLayoutParams.x = (this.mBaselineX + this.mDeltaX);
      localLayoutParams.width = (this.mBaselineWidth - this.mDeltaX);
      if (!this.mTopBorderActive)
        break label119;
      localLayoutParams.y = (this.mBaselineY + this.mDeltaY);
      localLayoutParams.height = (this.mBaselineHeight - this.mDeltaY);
    }
    while (true)
    {
      resizeWidgetIfNeeded(paramBoolean);
      requestLayout();
      return;
      if (!this.mRightBorderActive)
        break;
      localLayoutParams.width = (this.mBaselineWidth + this.mDeltaX);
      break;
      label119: if (this.mBottomBorderActive)
        localLayoutParams.height = (this.mBaselineHeight + this.mDeltaY);
    }
  }

  public boolean beginResizeIfPointInRegion(int paramInt1, int paramInt2)
  {
    float f2 = 1.0F;
    if ((this.mWidgetView != null) && (this.mWidgetView.checkUninstallPressed(paramInt1, paramInt2)))
      return false;
    int i;
    int j;
    label48: boolean bool;
    label64: label91: label113: ImageView localImageView;
    if ((this.mResizeMode & 0x1) != 0)
    {
      i = 1;
      if ((this.mResizeMode & 0x2) == 0)
        break label308;
      j = 1;
      if ((paramInt1 >= this.mTouchTargetWidth) || (i == 0))
        break label314;
      bool = true;
      this.mLeftBorderActive = bool;
      if ((paramInt1 <= getWidth() - this.mTouchTargetWidth) || (i == 0))
        break label320;
      bool = true;
      this.mRightBorderActive = bool;
      if ((paramInt2 >= this.mTouchTargetWidth) || (j == 0))
        break label326;
      bool = true;
      this.mTopBorderActive = bool;
      if ((paramInt2 <= getHeight() - this.mTouchTargetWidth) || (j == 0))
        break label332;
      bool = true;
      label140: this.mBottomBorderActive = bool;
      if ((!this.mLeftBorderActive) && (!this.mRightBorderActive) && (!this.mTopBorderActive) && (!this.mBottomBorderActive))
        break label338;
      bool = true;
      label177: this.mBaselineWidth = getMeasuredWidth();
      this.mBaselineHeight = getMeasuredHeight();
      this.mBaselineX = getLeft();
      this.mBaselineY = getTop();
      if (bool)
      {
        localImageView = this.mLeftHandle;
        if (!this.mLeftBorderActive)
          break label344;
        f1 = 1.0F;
        label229: localImageView.setAlpha(f1);
        localImageView = this.mRightHandle;
        if (!this.mRightBorderActive)
          break label349;
        f1 = 1.0F;
        label250: localImageView.setAlpha(f1);
        localImageView = this.mTopHandle;
        if (!this.mTopBorderActive)
          break label354;
        f1 = 1.0F;
        label271: localImageView.setAlpha(f1);
        localImageView = this.mBottomHandle;
        if (!this.mBottomBorderActive)
          break label359;
      }
    }
    label308: label314: label320: label326: label332: label338: label344: label349: label354: label359: for (float f1 = f2; ; f1 = 0.0F)
    {
      localImageView.setAlpha(f1);
      return bool;
      i = 0;
      break;
      j = 0;
      break label48;
      bool = false;
      break label64;
      bool = false;
      break label91;
      bool = false;
      break label113;
      bool = false;
      break label140;
      bool = false;
      break label177;
      f1 = 0.0F;
      break label229;
      f1 = 0.0F;
      break label250;
      f1 = 0.0F;
      break label271;
    }
  }

  public void commitResize()
  {
    resizeWidgetIfNeeded(true);
    requestLayout();
  }

  public void onTouchUp()
  {
    int i = this.mCellLayout.getCellWidth();
    int j = this.mCellLayout.getWidthGap();
    int k = this.mCellLayout.getCellHeight();
    int m = this.mCellLayout.getHeightGap();
    this.mDeltaXAddOn = (this.mRunningHInc * (i + j));
    this.mDeltaYAddOn = (this.mRunningVInc * (k + m));
    this.mDeltaX = 0;
    this.mDeltaY = 0;
    post(new Runnable()
    {
      public void run()
      {
        AppWidgetResizeFrame.this.snapToWidget(true);
        if (AppWidgetResizeFrame.this.mCellLayout != null)
        {
          AppWidgetResizeFrame.this.mCellLayout.commitTempPlacement();
          AppWidgetResizeFrame.this.mCellLayout.completeAndClearReorderHintAnimations();
          AppWidgetResizeFrame.this.mCellLayout.setItemPlacementDirty(false);
        }
      }
    });
  }

  public void snapToWidget(boolean paramBoolean)
  {
    Object localObject = (DragLayer.LayoutParams)getLayoutParams();
    this.mWidgetView.getGlobalVisibleRect(this.mWidgetSizeRect);
    int n = this.mWidgetSizeRect.width() + this.mBackgroundPadding * 2 - this.mWidgetPaddingLeft - this.mWidgetPaddingRight;
    int k = this.mWidgetSizeRect.height() + this.mBackgroundPadding * 2 - this.mWidgetPaddingTop - this.mWidgetPaddingBottom;
    int i1 = this.mWidgetSizeRect.left - this.mBackgroundPadding + this.mWidgetPaddingLeft;
    int m = this.mWidgetSizeRect.top - this.mBackgroundPadding + this.mWidgetPaddingTop;
    int i = k;
    int j = m;
    if (m < 0)
    {
      i = k - -m;
      j = 0;
    }
    k = i;
    if (j + i > this.mDragLayer.getHeight())
      k = i - (j + i - this.mDragLayer.getHeight());
    if (!paramBoolean)
    {
      ((DragLayer.LayoutParams)localObject).width = n;
      ((DragLayer.LayoutParams)localObject).height = k;
      ((DragLayer.LayoutParams)localObject).x = i1;
      ((DragLayer.LayoutParams)localObject).y = j;
      this.mLeftHandle.setAlpha(1.0F);
      this.mRightHandle.setAlpha(1.0F);
      this.mTopHandle.setAlpha(1.0F);
      this.mBottomHandle.setAlpha(1.0F);
      requestLayout();
      return;
    }
    localObject = ObjectAnimator.ofPropertyValuesHolder(localObject, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("width", new int[] { ((DragLayer.LayoutParams)localObject).width, n }), PropertyValuesHolder.ofInt("height", new int[] { ((DragLayer.LayoutParams)localObject).height, k }), PropertyValuesHolder.ofInt("x", new int[] { ((DragLayer.LayoutParams)localObject).x, i1 }), PropertyValuesHolder.ofInt("y", new int[] { ((DragLayer.LayoutParams)localObject).y, j }) });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mLeftHandle, "alpha", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mRightHandle, "alpha", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mTopHandle, "alpha", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.mBottomHandle, "alpha", new float[] { 1.0F });
    ((ObjectAnimator)localObject).addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppWidgetResizeFrame.this.requestLayout();
      }
    });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (this.mResizeMode == 2)
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator3, localObjectAnimator4 });
    while (true)
    {
      localAnimatorSet.setDuration(150L);
      localAnimatorSet.start();
      return;
      if (this.mResizeMode == 1)
        localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2 });
      else
        localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    }
  }

  public void updateDeltas(int paramInt1, int paramInt2)
  {
    if (this.mLeftBorderActive)
    {
      this.mDeltaX = Math.max(-this.mBaselineX, paramInt1);
      this.mDeltaX = Math.min(this.mBaselineWidth - this.mTouchTargetWidth * 2, this.mDeltaX);
    }
    do
      while (this.mTopBorderActive)
      {
        this.mDeltaY = Math.max(-this.mBaselineY, paramInt2);
        this.mDeltaY = Math.min(this.mBaselineHeight - this.mTouchTargetWidth * 2, this.mDeltaY);
        return;
        if (this.mRightBorderActive)
        {
          this.mDeltaX = Math.min(this.mDragLayer.getWidth() - (this.mBaselineX + this.mBaselineWidth), paramInt1);
          this.mDeltaX = Math.max(-this.mBaselineWidth + this.mTouchTargetWidth * 2, this.mDeltaX);
        }
      }
    while (!this.mBottomBorderActive);
    this.mDeltaY = Math.min(this.mDragLayer.getHeight() - (this.mBaselineY + this.mBaselineHeight), paramInt2);
    this.mDeltaY = Math.max(-this.mBaselineHeight + this.mTouchTargetWidth * 2, this.mDeltaY);
  }

  public void visualizeResizeForDelta(int paramInt1, int paramInt2)
  {
    visualizeResizeForDelta(paramInt1, paramInt2, false);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.AppWidgetResizeFrame
 * JD-Core Version:    0.6.2
 */