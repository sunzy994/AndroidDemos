package com.oppo.launcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.oppo.launcher.theme.ThemeUtil;
import com.oppo.unreaderloader.UnreadLoaderDrawInfo;

public class BaseTextView extends TextView
{
  protected static final long CLICK_TIME = 500L;
  private static final boolean DEBUG = false;
  static final boolean DEBUG_ENABLE = false;
  private static final int DRAWABLE_TOP = 1;
  private static final String TAG = "BaseTextView";
  private float mDownX = -1.0F;
  private float mDownY = -1.0F;
  ItemInfo mItemInfo;
  protected Launcher mLauncher;
  protected int mTouchSlop = 0;
  protected long mTouchTime = 0L;
  private UnreadLoaderDrawInfo mUnreadLoaderDrawInfo = null;
  int mValidAreaHeight = 0;
  protected Workspace mWorkspace;

  public BaseTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BaseTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LauncherUtil.setBaseTextViewSize(this, paramContext);
  }

  private void drawNum(Canvas paramCanvas)
  {
    if ((this.mItemInfo != null) && (this.mItemInfo.unreadNum > 0))
    {
      if (this.mUnreadLoaderDrawInfo == null)
        this.mUnreadLoaderDrawInfo = new UnreadLoaderDrawInfo(getContext(), this);
      this.mUnreadLoaderDrawInfo.drawNum(paramCanvas, this.mItemInfo.unreadNum, this);
      return;
    }
    this.mUnreadLoaderDrawInfo = null;
  }

  public boolean checkTouchArea(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    boolean bool1 = bool3;
    float f1;
    float f2;
    if (arrayOfDrawable[1] != null)
    {
      bool1 = bool3;
      if (arrayOfDrawable != null)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if ((this.mLauncher == null) || (!this.mLauncher.isWorkspaceInOrderMoreMode()))
          break label95;
      }
    }
    label95: for (bool1 = bool2; ; bool1 = false)
    {
      int i = getLineHeight();
      bool1 = LauncherUtil.checkTouchArea(new float[] { f1, f2 }, i * 2, this, bool1);
      return bool1;
    }
  }

  protected void clearEffects()
  {
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    drawNum(paramCanvas);
  }

  public void getLocalIconCenter(int[] paramArrayOfInt)
  {
    Object localObject = getCompoundDrawables();
    if (localObject[1] != null)
    {
      new Rect();
      int i = getPaddingTop();
      localObject = localObject[1].getBounds();
      paramArrayOfInt[0] = (getWidth() / 2);
      paramArrayOfInt[1] = (((Rect)localObject).height() / 2 + i);
    }
  }

  public int getValidAreaHeight()
  {
    if (this.mValidAreaHeight > 0)
      return this.mValidAreaHeight;
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (arrayOfDrawable[1] != null)
    {
      new Rect();
      int i = getLineHeight();
      int j = getPaddingTop();
      int k = getCompoundDrawablePadding();
      this.mValidAreaHeight = (arrayOfDrawable[1].getBounds().height() + j + k + i * 2 / 3);
    }
    return this.mValidAreaHeight;
  }

  protected boolean isOrderMoreMode()
  {
    if (this.mWorkspace == null)
      return false;
    return this.mWorkspace.isOrderMoreMode();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
      this.mDownX = -1.0F;
      this.mDownY = -1.0F;
    case 0:
    case 2:
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mDownX = paramMotionEvent.getX();
      this.mDownY = paramMotionEvent.getY();
      continue;
      float f1 = Math.abs(paramMotionEvent.getX() - this.mDownX);
      float f2 = Math.abs(paramMotionEvent.getY() - this.mDownY);
      if ((f1 > this.mTouchSlop) || (f2 > this.mTouchSlop))
      {
        if ((this instanceof FolderItemView))
          ((FolderItemView)this).getLongPressHelper().cancelLongPress();
        this.mDownX = -1.0F;
        this.mDownY = -1.0F;
        clearEffects();
      }
    }
  }

  public void setLauncher(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
    this.mWorkspace = paramLauncher.getWorkspace();
    if ((this.mLauncher.isWallpaperBright()) && (ThemeUtil.isDefaultTheme()))
      setTextAppearance(this.mLauncher, 2131558406);
  }

  public void setTag(Object paramObject)
  {
    super.setTag(paramObject);
    if ((paramObject != null) && ((paramObject instanceof ItemInfo)))
      this.mItemInfo = ((ItemInfo)paramObject);
  }

  public static class ApplicationRingAnimator
  {
    public static float sHeightPreviewSize = -1.0F;
    public static float sWidthPreviewSize = -1.0F;
    private ValueAnimator mAcceptAnimator;
    private BaseCellLayout mCellLayout;
    public int mCellX;
    public int mCellY;
    public Drawable mDrawable = null;
    private int mDrawableWidth = 0;
    private float mHeight = 0.0F;
    private ValueAnimator mNeutralAnimator;
    private float mOffset = 0.0F;
    int mOffsetX = 0;
    public float mTargetHeight;
    public float mTargetWidth;
    public TextView mViewIcon = null;
    private float mWidth = 0.0F;
    private float step = 2.0F;

    public ApplicationRingAnimator(Launcher paramLauncher, TextView paramTextView)
    {
      this.mViewIcon = paramTextView;
      paramLauncher = paramLauncher.getResources();
      this.mWidth = paramTextView.getWidth();
      this.mHeight = paramTextView.getHeight();
      int i = Utilities.getIconWidth();
      int j = paramLauncher.getDimensionPixelSize(2131361834);
      int k = paramLauncher.getDimensionPixelSize(2131361835);
      this.mOffsetX = paramLauncher.getDimensionPixelSize(2131361834);
      float f = (i - j * 2 - k) / 2.0F;
      sWidthPreviewSize = this.mWidth * f / i;
      sHeightPreviewSize = this.mHeight * f / i;
      this.mDrawable = paramTextView.getCompoundDrawables()[1];
      this.step = (this.mWidth / sWidthPreviewSize - 1.0F);
      this.mDrawableWidth = this.mDrawable.getIntrinsicWidth();
    }

    public void animateToBigState()
    {
      if (this.mNeutralAnimator != null)
        this.mNeutralAnimator.cancel();
      this.mAcceptAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.mAcceptAnimator.setDuration(200L);
      this.mAcceptAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ApplicationRingAnimator.this.mTargetWidth = ((ApplicationRingAnimator.this.step * f + 1.0F) * ApplicationRingAnimator.sWidthPreviewSize);
          ApplicationRingAnimator.this.mTargetHeight = ((ApplicationRingAnimator.this.step * f + 1.0F) * ApplicationRingAnimator.sHeightPreviewSize);
          ApplicationRingAnimator.access$102(ApplicationRingAnimator.this, (1.0F - f) * ApplicationRingAnimator.this.mOffsetX);
          if (ApplicationRingAnimator.this.mCellLayout != null)
            ApplicationRingAnimator.this.mCellLayout.invalidate();
        }
      });
      this.mAcceptAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (ApplicationRingAnimator.this.mViewIcon != null)
          {
            ApplicationRingAnimator.this.mViewIcon.setVisibility(0);
            if ((ApplicationRingAnimator.this.mViewIcon instanceof BubbleTextView))
              ((BubbleTextView)ApplicationRingAnimator.this.mViewIcon).beginOrSyncIconShakeAnim();
            if ((ApplicationRingAnimator.this.mCellLayout != null) && (ApplicationRingAnimator.this.mCellLayout.mLauncher != null))
            {
              paramAnonymousAnimator = ApplicationRingAnimator.this.mCellLayout.mLauncher;
              ColorRectPreview localColorRectPreview = paramAnonymousAnimator.getColorRectManager().getPreview();
              if (localColorRectPreview != null)
                localColorRectPreview.refreshPreviewPage(paramAnonymousAnimator.getCurrentWorkspaceScreen());
            }
          }
          ApplicationRingAnimator.this.mTargetWidth = Utilities.getIconWidth();
          ApplicationRingAnimator.this.mTargetHeight = Utilities.getIconWidth();
          ApplicationRingAnimator.this.mDrawable.setBounds(0, 0, (int)ApplicationRingAnimator.this.mTargetWidth, (int)ApplicationRingAnimator.this.mTargetHeight);
          if (ApplicationRingAnimator.this.mCellLayout != null)
            ApplicationRingAnimator.this.mCellLayout.hideApplicationChange(ApplicationRingAnimator.this);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
        }
      });
      this.mAcceptAnimator.start();
    }

    public void animateToSmallState()
    {
      if (this.mAcceptAnimator != null)
        this.mAcceptAnimator.cancel();
      this.mNeutralAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.mNeutralAnimator.setDuration(200L);
      this.mNeutralAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ApplicationRingAnimator.this.mTargetWidth = (((1.0F - f) * ApplicationRingAnimator.this.step + 1.0F) * ApplicationRingAnimator.sWidthPreviewSize);
          ApplicationRingAnimator.this.mTargetHeight = (((1.0F - f) * ApplicationRingAnimator.this.step + 1.0F) * ApplicationRingAnimator.sHeightPreviewSize);
          ApplicationRingAnimator.access$102(ApplicationRingAnimator.this, ApplicationRingAnimator.this.mOffsetX * f);
          if (ApplicationRingAnimator.this.mCellLayout != null)
            ApplicationRingAnimator.this.mCellLayout.invalidate();
        }
      });
      this.mNeutralAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
        }
      });
      this.mNeutralAnimator.start();
    }

    public void getCell(int[] paramArrayOfInt)
    {
      paramArrayOfInt[0] = this.mCellX;
      paramArrayOfInt[1] = this.mCellY;
    }

    public Drawable getDrawable()
    {
      return this.mDrawable;
    }

    public int getDrawableWidth()
    {
      return this.mDrawableWidth;
    }

    public float getHeight()
    {
      return this.mHeight;
    }

    public float getOffset()
    {
      return this.mOffset;
    }

    public float getTargetHeight()
    {
      return this.mTargetHeight;
    }

    public float getTargetWidth()
    {
      return this.mTargetWidth;
    }

    public float getWidth()
    {
      return this.mWidth;
    }

    public void setCell(int paramInt1, int paramInt2)
    {
      this.mCellX = paramInt1;
      this.mCellY = paramInt2;
    }

    public void setCellLayout(BaseCellLayout paramBaseCellLayout)
    {
      this.mCellLayout = paramBaseCellLayout;
    }

    public void setDrawable(Drawable paramDrawable)
    {
      this.mDrawable = paramDrawable;
    }

    public void setDrawableWidth(int paramInt)
    {
      this.mDrawableWidth = paramInt;
    }

    public void setHeight(float paramFloat)
    {
      this.mHeight = paramFloat;
    }

    public void setOffset(float paramFloat)
    {
      this.mOffset = paramFloat;
    }

    public void setTargetHeight(float paramFloat)
    {
      this.mTargetHeight = paramFloat;
    }

    public void setTargetWidth(float paramFloat)
    {
      this.mTargetWidth = paramFloat;
    }

    public void setWidth(float paramFloat)
    {
      this.mWidth = paramFloat;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.BaseTextView
 * JD-Core Version:    0.6.2
 */