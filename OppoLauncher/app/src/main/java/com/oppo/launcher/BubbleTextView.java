package com.oppo.launcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.oppo.launcher.graphic.IUpdateTextColor;
import com.oppo.launcher.screenGrid.ScreenGridUtils;
import com.oppo.launcher.widget.OppoEnvironment;
import com.oppo.launcher.widget.OppoImageSpan;
import com.oppo.theme.OppoConvertIcon;
import java.util.ArrayList;

public class BubbleTextView extends BaseTextView
  implements DarkEffect, DockBar.CallBacks, AnimationListener, IShakeInterface, IUpdateTextColor, IIconTextVisible, OrderModeIconState
{
  private static final boolean DEBUG = false;
  private static final boolean DEBUG_DEL = false;
  private static final boolean DEBUG_ENABLE = false;
  private static final boolean DEBUG_EVENT = false;
  private static final boolean DEBUG_ORDER_MODE = false;
  private static final int REORDER_ANIMATION_DURATION = 280;
  private static final float REORDER_HINT_MAGNITUDE = 0.05F;
  private static final String TAG = "BubbleTextView";
  protected static final int TOP_DRAWABLE_ID = 1;
  private static float mReorderHintAnimationMagnitude = 0.0F;
  final int NEW_PREFIX_BURST_ANIM_DURATION = 600;
  final int TITLE_MOVE_TO_MIDDLE_ANIM_DURATION = 300;
  protected ApplicationInfo mApplicationInfo;
  private Drawable mBackground;
  private boolean mBackgroundSizeChanged;
  private float mBubbleColorAlpha;
  private ValueAnimator mBurstAnim = null;
  private Bitmap mBurstPicture = null;
  protected DarkEffectListener mDarkEffectListener;
  private Paint mDelPaint = new Paint();
  protected FastBitmapDrawable mDrawableTop;
  private boolean mFreezing = false;
  private Rect mGlobalVisibleRect = new Rect();
  private boolean mIsInFolder = false;
  private CheckLongPressHelper mLongPressHelper;
  private DockBar.MovingHelper mMovingHelper;
  private Drawable mNewInstallPrefix;
  private int mNewPrefixAlpha;
  private float mNewPrefixScale;
  boolean mNormalSize = false;
  private Paint mPaint;
  private boolean mPressedDelIcon = false;
  private int mPrevAlpha = -1;
  private ReorderHintAnimation mShakeAnimators = null;
  private ValueAnimator mTitleMoveAnim = null;
  private float mTitleMoveProgress;
  private int mUninstallAndSelectIconLeftPadding = 0;
  private int mUninstallAndSelectIconTopPadding = 0;

  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }

  private void animateTitleToMiddle()
  {
    this.mTitleMoveAnim = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mTitleMoveAnim.setDuration(300L);
    this.mTitleMoveAnim.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mTitleMoveAnim.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        BubbleTextView.access$802(BubbleTextView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        BubbleTextView.this.invalidate();
      }
    });
    this.mTitleMoveAnim.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        BubbleTextView.this.setText(BubbleTextView.this.mApplicationInfo.title);
        BubbleTextView.access$902(BubbleTextView.this, null);
        Utilities.resetNewInstallPrefix();
        Utilities.recycleFrameBitmap();
      }
    });
    this.mTitleMoveAnim.start();
  }

  private boolean checkUninstallPressed(int paramInt1, int paramInt2)
  {
    if (!uninstallEnable());
    int i;
    int j;
    int k;
    int m;
    do
    {
      return false;
      i = this.mUninstallAndSelectIconLeftPadding + (getWidth() - Utilities.getIconWidth()) / 2 - (int)(Utilities.getUnistallBitmapWidth(getContext()) * 0.625F);
      j = Utilities.getUnistallBitmapWidth(getContext());
      k = this.mUninstallAndSelectIconTopPadding;
      m = Utilities.getUnistallBitmapHeight(getContext()) * 3 / 2;
    }
    while ((paramInt1 > i + j * 2) || (paramInt1 < i) || (paramInt2 > m) || (paramInt2 < k));
    return true;
  }

  private void init(Context paramContext)
  {
    this.mLongPressHelper = new CheckLongPressHelper(this);
    this.mBackground = getBackground();
    Resources localResources = getContext().getResources();
    int i = localResources.getColor(2131165186);
    this.mPaint = new Paint();
    this.mPaint.setColor(i);
    this.mBubbleColorAlpha = (Color.alpha(i) / 255.0F);
    this.mNewInstallPrefix = Utilities.getNewInstallPrefix(paramContext);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mDelPaint.setFilterBitmap(true);
    mReorderHintAnimationMagnitude = 0.05F * localResources.getDimensionPixelSize(2131361823);
    this.mUninstallAndSelectIconLeftPadding = ((int)localResources.getDimension(2131361915));
    this.mUninstallAndSelectIconTopPadding = ((int)localResources.getDimension(2131361916));
  }

  private void resetAnimator()
  {
    if (this.mBurstAnim != null)
    {
      this.mBurstAnim.cancel();
      this.mBurstAnim = null;
    }
    if (this.mTitleMoveAnim != null)
    {
      this.mTitleMoveAnim.cancel();
      this.mTitleMoveAnim = null;
    }
  }

  private void setTextPrefixIfNeed(ApplicationInfo paramApplicationInfo, String paramString)
  {
    if (paramApplicationInfo == null)
      return;
    if (paramApplicationInfo.isAppUnavailable())
    {
      paramApplicationInfo = new SpannableString("@" + Utilities.dealTitleString(paramString));
      paramApplicationInfo.setSpan(new ImageSpan(Utilities.getSdCardStatePrefix(getContext()), 0), 0, 1, 17);
      setText(paramApplicationInfo);
      return;
    }
    if ((paramApplicationInfo.isApplication()) && (paramApplicationInfo.newinstalled == 1))
    {
      if (this.mNewInstallPrefix == null)
        this.mNewInstallPrefix = Utilities.getNewInstallPrefix(getContext());
      paramApplicationInfo = new SpannableString("@" + Utilities.dealTitleString(paramString));
      paramApplicationInfo.setSpan(new OppoImageSpan(getContext(), this, this.mNewInstallPrefix, 1), 0, 1, 33);
      setText(paramApplicationInfo);
      return;
    }
    setText(paramApplicationInfo.title);
  }

  private void updateBurstFrame(float paramFloat)
  {
    this.mBurstPicture = Utilities.getNewPrefixBurstFrames(getContext())[((int)(10.0F * paramFloat * 1.3F))];
  }

  private void updateFrame()
  {
    int i = this.mMovingHelper.getCurrX();
    int j = this.mMovingHelper.getCurrY();
    layout(i, j, i + getWidth(), j + getHeight());
    requestLayout();
  }

  public void animateNewPrefixBurst(int paramInt)
  {
    if (this.mApplicationInfo.newinstalled == 0)
    {
      Log.d("BubbleTextView", "animateNewPrefixBurst -- this app is not new installed, return!");
      return;
    }
    resetAnimator();
    this.mBurstAnim = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mBurstAnim.setDuration(600L);
    this.mBurstAnim.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mBurstAnim.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        BubbleTextView.access$402(BubbleTextView.this, 1.8F * f + (1.0F - f) * 1.0F);
        BubbleTextView.access$502(BubbleTextView.this, (int)((1.0F - f) * 255.0F));
        BubbleTextView.this.updateBurstFrame(f);
        BubbleTextView.this.invalidate();
      }
    });
    this.mBurstAnim.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        BubbleTextView.this.animateTitleToMiddle();
      }
    });
    this.mBurstAnim.setStartDelay(paramInt);
    this.mBurstAnim.start();
  }

  public void applyFromApplicationInfo(ApplicationInfo paramApplicationInfo, IconCache paramIconCache)
  {
    this.mApplicationInfo = paramApplicationInfo;
    Object localObject2 = paramApplicationInfo.getIcon(paramIconCache);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!(localObject2 instanceof BitmapDrawable));
    }
    else
    {
      localObject1 = null;
      if (localObject2 != null)
        localObject1 = ((BitmapDrawable)localObject2).getBitmap();
      localObject2 = localObject1;
      if (localObject1 == null)
        localObject2 = paramIconCache.getDefaultIcon();
      paramIconCache = (IconCache)localObject2;
      if (paramApplicationInfo.isShortcut())
        paramIconCache = OppoConvertIcon.convertIconBitmap(new BitmapDrawable((Bitmap)localObject2), getResources(), true);
      localObject1 = new FastBitmapDrawable(paramIconCache);
    }
    setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject1, null, null);
    if (LauncherUtil.DEBUG_FANCY_ICON)
      Log.d("BubbleTextView", "debugFancyIcon, applyFromApplicationInfo, app = " + paramApplicationInfo.componentName + ", icon = " + localObject1);
    setTextPrefixIfNeed(paramApplicationInfo, (String)paramApplicationInfo.title);
    setTag(paramApplicationInfo);
  }

  public void beginOrAdjustHintAnimations()
  {
    if (ValueAnimator.getDurationScale() == 0.0F);
    while (this.mShakeAnimators != null)
      return;
    this.mShakeAnimators = new ReorderHintAnimation(this);
    this.mShakeAnimators.animate();
  }

  public void beginOrAdjustHintAnimations(int paramInt)
  {
    if (!this.mWorkspace.isOrderOneMode())
      Log.d("BubbleTextView", "beginOrAdjustHintAnimations, workspace is not in order one mode, just reture!");
    while ((ValueAnimator.getDurationScale() == 0.0F) || (this.mShakeAnimators != null))
      return;
    this.mShakeAnimators = new ReorderHintAnimation(this);
    this.mShakeAnimators.animate(paramInt);
  }

  public void beginOrSyncIconShakeAnim()
  {
    if (this.mShakeAnimators != null);
    ViewParent localViewParent;
    do
    {
      return;
      localViewParent = getParent();
    }
    while ((localViewParent == null) || (!(localViewParent instanceof CellLayout)));
    if (((CellLayout)localViewParent).getChildCount() <= 2)
      beginOrAdjustHintAnimations();
    ((CellLayout)localViewParent).mWorkspace.syncAnim(this);
  }

  public void clearDarkEffect()
  {
    if (this.mDrawableTop != null)
    {
      this.mDrawableTop.setColorFilter(null);
      this.mDrawableTop.setAlphaDefault();
    }
  }

  protected void clearEffects()
  {
    clearDarkEffect();
    this.mPressedDelIcon = false;
  }

  public void click()
  {
    this.mLauncher.onClick(this);
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

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    Drawable localDrawable = this.mBackground;
    int i;
    int j;
    if (localDrawable != null)
    {
      i = getScrollX();
      j = getScrollY();
      if (this.mBackgroundSizeChanged)
      {
        localDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        this.mBackgroundSizeChanged = false;
      }
      if ((i | j) != 0)
        break label83;
      localDrawable.draw(paramCanvas);
    }
    while (true)
    {
      super.draw(paramCanvas);
      paramCanvas.restore();
      return;
      label83: paramCanvas.translate(i, j);
      localDrawable.draw(paramCanvas);
      paramCanvas.translate(-i, -j);
    }
  }

  public void drawDelIcon(Canvas paramCanvas)
  {
    if (!this.mWorkspace.isOrderOneMode());
    do
    {
      return;
      localObject = this.mApplicationInfo;
    }
    while ((localObject == null) || (!((ApplicationInfo)localObject).uninstallable) || (!DelIconAnim.shouldRefresh()));
    int k = getScrollX();
    int m = getScrollY();
    float f = 1.0F;
    if (!this.mNormalSize)
      f = DelIconAnim.getScale();
    Object localObject = Utilities.getUnistallBitmap(getContext());
    if (localObject != null)
    {
      paramCanvas.save();
      paramCanvas.translate(k, m);
      int n = this.mUninstallAndSelectIconLeftPadding + (int)((getWidth() - Utilities.getIconWidth()) / 2 + ((Bitmap)localObject).getWidth() * 0.625F - ((Bitmap)localObject).getWidth() * f);
      int j = this.mUninstallAndSelectIconTopPadding + (int)(getWidth() / 3 * (1.0F - f));
      int i = j;
      if (ScreenGridUtils.getScreenYGridNum() != 5)
      {
        i = j;
        if (!ScreenGridUtils.isOnDockBar(this))
          i = j + ScreenGridUtils.getPaddingTopDifference();
      }
      Rect localRect = new Rect(n, i, (int)(n + ((Bitmap)localObject).getWidth() * f), (int)(i + ((Bitmap)localObject).getHeight() * f));
      i = (int)(255.0F * f);
      this.mDelPaint.setAlpha(i);
      paramCanvas.drawBitmap((Bitmap)localObject, null, localRect, this.mDelPaint);
      paramCanvas.translate(-k, -m);
      paramCanvas.restore();
      return;
    }
    Log.w("BubbleTextView", "drawDelIcon, mUninstallBitmap is null==========");
  }

  public void drawOrderMoreModeSelectedIcon(Canvas paramCanvas)
  {
    if ((this.mLauncher != null) && (!this.mLauncher.getColorRectManager().isAnimating()) && (isOrderMoreMode()))
    {
      int k = getScrollX();
      int m = getScrollY();
      if (this.mItemInfo.mIsOrderModeSelected)
      {
        Bitmap localBitmap = Utilities.getOrderMoreModeSelectedBitmap(getContext());
        if (localBitmap != null)
        {
          paramCanvas.save();
          paramCanvas.translate(k, m);
          int n = this.mUninstallAndSelectIconLeftPadding + (int)((getWidth() - Utilities.getIconWidth()) / 2 + localBitmap.getWidth() * 0.625F - localBitmap.getWidth() * 1.0F);
          int j = this.mUninstallAndSelectIconTopPadding + (int)(getWidth() / 3 * (1.0F - 1.0F));
          int i = j;
          if (ScreenGridUtils.getScreenYGridNum() != 5)
            i = j + ScreenGridUtils.getPaddingTopDifference();
          Rect localRect = new Rect(n, i, (int)(n + localBitmap.getWidth() * 1.0F), (int)(i + localBitmap.getHeight() * 1.0F));
          this.mDelPaint.setAlpha(255);
          paramCanvas.drawBitmap(localBitmap, null, localRect, this.mDelPaint);
          paramCanvas.translate(-k, -m);
          paramCanvas.restore();
        }
      }
    }
  }

  protected void drawableStateChanged()
  {
    Drawable localDrawable = this.mBackground;
    if ((localDrawable != null) && (localDrawable.isStateful()))
      localDrawable.setState(getDrawableState());
    super.drawableStateChanged();
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

  public FastBitmapDrawable getFastBitmapDrawable()
  {
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (arrayOfDrawable[1] != null)
      return (FastBitmapDrawable)arrayOfDrawable[1];
    Log.e("BubbleTextView", "getFastBitmapDrawable == null !! icon title = " + getText());
    if (this.mDrawableTop != null)
    {
      setCompoundDrawables(null, this.mDrawableTop, null, null);
      return this.mDrawableTop;
    }
    Log.e("BubbleTextView", "getFastBitmapDrawable -- mDrawableTop == null -- return null !!");
    return null;
  }

  public CheckLongPressHelper getLongPressHelper()
  {
    return this.mLongPressHelper;
  }

  public int getNewPrefixAlpha()
  {
    return this.mNewPrefixAlpha;
  }

  public Bitmap getNewPrefixBurst()
  {
    return this.mBurstPicture;
  }

  public float getNewPrefixScale()
  {
    return this.mNewPrefixScale;
  }

  public float getTitleMoveProgress()
  {
    return this.mTitleMoveProgress;
  }

  protected boolean handEventWhenNotTidyUp(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 3:
    case 1:
    case 2:
    }
    do
    {
      return bool;
      if ((this.mDarkEffectListener != null) && (!isOrderMoreMode()) && (!LauncherUtil.isSearchShowing()))
        this.mDarkEffectListener.onSetDarkEffect(this);
      if (!(getParent() instanceof DockBar))
        this.mLongPressHelper.postCheckForLongPress();
      this.mTouchTime = SystemClock.uptimeMillis();
      return bool;
      clearDarkEffect();
      this.mLongPressHelper.cancelLongPress();
      return bool;
      this.mLongPressHelper.cancelLongPress();
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.mTouchTime;
      if ((checkTouchArea(paramMotionEvent)) && (l1 - l2 <= 500L))
      {
        if (((getParent() == null) || (!isOrderMoreMode()) || (!(getParent() instanceof DockBar))) && (!LauncherUtil.isSearchShowing()))
          playSoundEffect(0);
        click();
        return bool;
      }
      clearDarkEffect();
      return bool;
    }
    while ((!isOrderMoreMode()) || (checkTouchArea(paramMotionEvent)));
    this.mLongPressHelper.cancelLongPress();
    return bool;
  }

  protected boolean handEventWhenTidyUp(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
      return bool;
    case 0:
      if ((this.mWorkspace != null) && (this.mWorkspace.isSpringLoaded()))
      {
        clearDarkEffect();
        this.mLongPressHelper.cancelLongPress();
        this.mPressedDelIcon = false;
        return bool;
      }
      if (checkUninstallPressed(i, j))
      {
        this.mPressedDelIcon = true;
        cancelLongPress();
        return bool;
      }
      if ((this.mDarkEffectListener != null) && (!isOrderMoreMode()))
        this.mDarkEffectListener.onSetDarkEffect(this);
      this.mLongPressHelper.postCheckForLongPress();
      this.mPressedDelIcon = false;
      return bool;
    case 3:
      clearDarkEffect();
      this.mLongPressHelper.cancelLongPress();
      this.mPressedDelIcon = false;
      return bool;
    case 1:
    }
    if (this.mPressedDelIcon)
      post(new Runnable()
      {
        public void run()
        {
          BubbleTextView.this.mLauncher.uninstallApplication(BubbleTextView.this.mApplicationInfo);
        }
      });
    this.mLongPressHelper.cancelLongPress();
    clearDarkEffect();
    this.mPressedDelIcon = false;
    return bool;
  }

  public boolean isBurstAnimRunning()
  {
    return (this.mBurstAnim != null) && (this.mBurstAnim.isRunning());
  }

  public boolean isMoving()
  {
    if (this.mMovingHelper != null)
      return this.mMovingHelper.isMoving();
    return false;
  }

  public boolean isOrderMoreModeSelected()
  {
    return this.mItemInfo.mIsOrderModeSelected;
  }

  public boolean isShaking()
  {
    return this.mShakeAnimators != null;
  }

  public boolean isTitleAnimRunning()
  {
    return (this.mTitleMoveAnim != null) && (this.mTitleMoveAnim.isRunning());
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

  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((getLeft() != paramInt1) || (getRight() != paramInt3) || (getTop() != paramInt2) || (getBottom() != paramInt4))
      this.mBackgroundSizeChanged = true;
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }

  protected void onAttachedToWindow()
  {
    float f = 1.0F;
    if (this.mWorkspace == null)
    {
      Log.w("BubbleTextView", "onAttachedToWindow -- mWorkspace is null, return");
      return;
    }
    super.onAttachedToWindow();
    if (this.mBackground != null)
      this.mBackground.setCallback(this);
    if ((!this.mFreezing) && ((View)getParent() != null) && (this.mItemInfo != null) && (this.mWorkspace.isOrderOneMode()))
    {
      if (this.mItemInfo.container != -100L)
        break label119;
      this.mWorkspace.syncAnim(this);
    }
    while ((this.mApplicationInfo != null) && (this.mApplicationInfo.isAppUnavailable()))
    {
      setAlpha(0.7F);
      return;
      label119: if (this.mItemInfo.container != -101L)
        beginOrAdjustHintAnimations();
    }
    if (isOrderMoreMode())
    {
      if (this.mItemInfo.mIsOrderModeSelected);
      while (true)
      {
        setAlpha(f);
        return;
        f = 0.7F;
      }
    }
    setAlpha(1.0F);
  }

  protected void onDetachedFromWindow()
  {
    if (!this.mFreezing)
      completeAndClearReorderHintAnimations(false);
    super.onDetachedFromWindow();
    if (this.mBackground != null)
      this.mBackground.setCallback(null);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawDelIcon(paramCanvas);
    drawOrderMoreModeSelectedIcon(paramCanvas);
  }

  public void onPause()
  {
    ApplicationInfo localApplicationInfo = (ApplicationInfo)getTag();
    ((LauncherApplication)getContext().getApplicationContext()).mIconCache.onPauseDrawable(localApplicationInfo.intent);
  }

  public void onResume()
  {
    ApplicationInfo localApplicationInfo = (ApplicationInfo)getTag();
    ((LauncherApplication)getContext().getApplicationContext()).mIconCache.onResumeDrawable(localApplicationInfo.intent);
  }

  protected boolean onSetAlpha(int paramInt)
  {
    if (this.mPrevAlpha != paramInt)
    {
      this.mPrevAlpha = paramInt;
      this.mPaint.setAlpha((int)(paramInt * this.mBubbleColorAlpha));
      super.onSetAlpha(paramInt);
    }
    return false;
  }

  public void onTextVisible(boolean paramBoolean)
  {
    if (paramBoolean)
      if ((this.mItemInfo instanceof ApplicationInfo))
        setTextPrefixIfNeed((ApplicationInfo)this.mItemInfo, (String)this.mItemInfo.title);
    while ((Utilities.mHasNavigationBar) && (this.mItemInfo.container == -101L))
      return;
    setText(null);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (!this.mWorkspace.isSpringLoaded()) && (!checkTouchArea(paramMotionEvent)))
      return true;
    if ((this.mWorkspace != null) && (this.mWorkspace.isSpringLoadedOrOrderOne()))
      return handEventWhenTidyUp(paramMotionEvent);
    return handEventWhenNotTidyUp(paramMotionEvent);
  }

  public void setAlpha(float paramFloat)
  {
    float f = paramFloat;
    if (this.mApplicationInfo.isAppUnavailable())
    {
      f = paramFloat;
      if (!OppoEnvironment.isSDCardInside(getContext()))
        f = 0.7F;
    }
    super.setAlpha(f);
  }

  public void setBlankButton(boolean paramBoolean)
  {
  }

  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = getCompoundDrawables();
    if ((paramDrawable1 != null) && (paramDrawable1[1] != null) && ((paramDrawable1[1] instanceof FastBitmapDrawable)))
      this.mDrawableTop = ((FastBitmapDrawable)paramDrawable1[1]);
  }

  public void setDarkEffect()
  {
    if (this.mDrawableTop != null)
    {
      this.mDrawableTop.setAlphaDark();
      this.mDrawableTop.setColorFilterDark();
    }
  }

  public void setDarkEffectListener(DarkEffectListener paramDarkEffectListener)
  {
    this.mDarkEffectListener = paramDarkEffectListener;
  }

  public void setDrawableAlpha(int paramInt)
  {
    paramInt = Color.argb(255 - paramInt, 0, 0, 0);
    if (this.mDrawableTop != null)
      this.mDrawableTop.setPaintColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
  }

  public void setFreezing(boolean paramBoolean)
  {
    this.mFreezing = paramBoolean;
  }

  public void setInFolder(boolean paramBoolean)
  {
    this.mIsInFolder = paramBoolean;
  }

  public void setNormalSize(boolean paramBoolean)
  {
    this.mNormalSize = paramBoolean;
  }

  public void setOrderMoreModeSelected(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mItemInfo.mIsOrderModeSelected != paramBoolean1)
    {
      this.mItemInfo.mIsOrderModeSelected = paramBoolean1;
      invalidate();
    }
    if (this.mItemInfo.mIsOrderModeSelected);
    for (float f = 1.0F; ; f = 0.7F)
    {
      setAlpha(f);
      return;
    }
  }

  public void startMove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mMovingHelper == null)
      this.mMovingHelper = DockBar.MovingHelper.getInstance(this, super.getContext());
    this.mMovingHelper.startMove(getLeft(), getTop(), paramInt1, paramInt2, paramBoolean);
    invalidate();
  }

  protected boolean uninstallEnable()
  {
    return (this.mApplicationInfo != null) && (this.mApplicationInfo.uninstallable);
  }

  public void updateApplicationUnreadNum(int paramInt)
  {
    Object localObject = getTag();
    if ((localObject != null) && ((localObject instanceof ItemInfo)))
      ((ItemInfo)localObject).unreadNum = paramInt;
    destroyDrawingCache();
    invalidate();
  }

  public void updateTextColor(int paramInt)
  {
    if (paramInt == 1)
      setTextAppearance(getContext(), 2131558406);
    while (true)
    {
      invalidate();
      return;
      if (paramInt == 0)
        setTextAppearance(getContext(), 2131558407);
    }
  }

  public void updateTextPrefixAndAlphaWhenAppInfoUpdated(ApplicationInfo paramApplicationInfo)
  {
    ApplicationInfo localApplicationInfo = (ApplicationInfo)getTag();
    if (paramApplicationInfo.isAppUnavailable())
    {
      setAlpha(0.7F);
      localApplicationInfo.updateAppUnavailableFlag(getContext());
      if (!localApplicationInfo.isApplication())
        break label58;
      setTextPrefixIfNeed(paramApplicationInfo, (String)paramApplicationInfo.title);
    }
    label58: 
    while (!localApplicationInfo.isShortcut())
    {
      return;
      setAlpha(1.0F);
      break;
    }
    setTextPrefixIfNeed(localApplicationInfo, (String)localApplicationInfo.title);
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (paramDrawable == this.mBackground) || (super.verifyDrawable(paramDrawable));
  }

  class ReorderHintAnimation
  {
    private static final int DURATION = 300;
    Animator a;
    View child;
    float finalDeltaX = 0.0F;
    float finalDeltaY = -BubbleTextView.mReorderHintAnimationMagnitude;
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
      if (paramBoolean)
      {
        AnimatorSet localAnimatorSet = new AnimatorSet();
        this.a = localAnimatorSet;
        localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.child, "scaleX", new float[] { 1.0F }), ObjectAnimator.ofFloat(this.child, "scaleY", new float[] { 1.0F }), ObjectAnimator.ofFloat(this.child, "translationX", new float[] { 0.0F }), ObjectAnimator.ofFloat(this.child, "translationY", new float[] { 0.0F }) });
        localAnimatorSet.setDuration(280L);
        localAnimatorSet.setInterpolator(new DecelerateInterpolator(1.5F));
        localAnimatorSet.start();
        return;
      }
      this.child.setScaleX(1.0F);
      this.child.setScaleY(1.0F);
      this.child.setTranslationX(0.0F);
      this.child.setTranslationY(0.0F);
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
          if (ReorderHintAnimation.this.child == null);
          while ((BubbleTextView.this.mIsInFolder) && (!Utilities.isViewOnScreen(ReorderHintAnimation.this.child)))
            return;
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
 * Qualified Name:     com.oppo.launcher.BubbleTextView
 * JD-Core Version:    0.6.2
 */