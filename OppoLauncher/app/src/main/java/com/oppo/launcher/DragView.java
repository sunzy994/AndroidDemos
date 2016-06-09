package com.oppo.launcher;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

public class DragView extends View
{
  protected static final boolean DEBUG = false;
  static final boolean DEBUG_DRAG = false;
  static final boolean DEBUG_ENABLE = false;
  static final boolean DEBUG_MOVE = false;
  private static final int DELAY_INVALIDATA_TIME = 30;
  private static final int ExceedScreenHeight = 2012;
  private static final int MAX_DELTA_SPEED = 160;
  private static final int MAX_DRAG_APPICON_DEGREE = 50;
  private static final int MAX_DRAG_DEGREE = 30;
  public static final int MAX_SPEED = 600;
  private static final int MESSAGE_DRAG_UPDATE_VIEW = 1;
  private static final int MIN_DRAG_MOVE_XY = 12;
  private static final int MIN_DRAG_SEPPD = 60;
  private static final int MIX_TOUCH_X = 15;
  private static final int MOVE_OFFSET_TO_BOTTOM = 80;
  private static final double PI = 3.1415926D;
  private static final int SHAKE_ONE_TIME = 300;
  private static final String TAG = "DragView";
  private static float sDragAlpha = 1.0F;
  ValueAnimator mAnim;
  protected Bitmap mBitmap;
  boolean mCanShake = true;
  private final int[] mCenterTemp = new int[2];
  private float mCurrentTouchX = 0.0F;
  private float mCurrentTouchY = 0.0F;
  private float mCurrentXDegree = 0.0F;
  private float mCurrentXSpeed = 0.0F;
  private float mCurrentYDegree = 0.0F;
  private float mCurrentYSpeed = 0.0F;
  private float mDeltaXSpeed = 0.0F;
  private float mDeltaYSpeed = 0.0F;
  protected DragLayer mDragLayer = null;
  private Rect mDragRegion = null;
  private DragViewHandler mDragViewHandler = new DragViewHandler(null);
  private Point mDragVisualizeOffset = null;
  private boolean mHasDrawn = false;
  protected Bitmap mIconBitmap;
  protected boolean mIsAppWidget = false;
  protected boolean mIsDraging = false;
  private boolean mIsShaking = false;
  private float mLastTouchX = 0.0F;
  private float mLastTouchY = 0.0F;
  private float mLastXSpeed = 0.0F;
  private float mLastYSpeed = 0.0F;
  private float mOffsetX = 0.0F;
  private float mOffsetY = 0.0F;
  protected int mOrignalRegistrationX;
  protected int mOrignalRegistrationY;
  protected Paint mPaint;
  protected PaintFlagsDrawFilter mPaintFlagsDrawFilter = null;
  private Bitmap mPreviewBitmap;
  protected int mRegistrationX;
  protected int mRegistrationY;
  private Rotate3d mRotation = null;
  protected final Paint mTrashPaint = new Paint();
  private boolean mWarning = false;
  private WindowManager mWindowManager;

  public DragView(Launcher paramLauncher)
  {
    super(paramLauncher);
    this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
    this.mDragLayer = paramLauncher.getDragLayer();
    int i = getResources().getColor(2131165184);
    this.mTrashPaint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
    this.mTrashPaint.setAlpha(200);
    this.mTrashPaint.setAntiAlias(true);
    this.mWindowManager = paramLauncher.getWindowManager();
    this.mIsAppWidget = false;
  }

  public DragView(Launcher paramLauncher, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, float paramFloat)
  {
    super(paramLauncher);
    init(paramLauncher, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean, paramFloat);
  }

  private void calculateDegree()
  {
    float f1 = getDegreeFromSpeed(this.mCurrentYSpeed);
    float f2 = -getDegreeFromSpeed(this.mCurrentXSpeed);
    this.mCurrentXDegree = smoothDegree(f1, getRotationX());
    this.mCurrentYDegree = smoothDegree(f2, getRotationY());
  }

  private void calculateSpeed()
  {
    this.mDeltaXSpeed = (this.mCurrentXSpeed - this.mLastXSpeed);
    this.mDeltaYSpeed = (this.mCurrentYSpeed - this.mLastYSpeed);
    this.mLastXSpeed = this.mCurrentXSpeed;
    this.mLastYSpeed = this.mCurrentYSpeed;
  }

  private void init(Launcher paramLauncher, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, final float paramFloat)
  {
    this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
    this.mDragLayer = paramLauncher.getDragLayer();
    Object localObject = getResources();
    int i = ((Resources)localObject).getColor(2131165184);
    this.mTrashPaint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
    this.mTrashPaint.setAlpha(200);
    this.mTrashPaint.setAntiAlias(true);
    this.mWindowManager = paramLauncher.getWindowManager();
    this.mIsAppWidget = paramBoolean;
    final float f2 = ((Resources)localObject).getDimensionPixelSize(2131361908);
    final float f3 = ((Resources)localObject).getDimensionPixelSize(2131361909);
    final float f1;
    if (paramBoolean)
    {
      f1 = ((Resources)localObject).getDimensionPixelSize(2131361919);
      f1 = (paramInt5 - f1) / paramInt5;
    }
    while (true)
    {
      this.mAnim = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.mAnim.setDuration(150L);
      this.mAnim.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          int i = (int)(f2 * f - DragView.this.mOffsetX);
          int j = (int)(f3 * f - DragView.this.mOffsetY);
          DragView.access$016(DragView.this, i);
          DragView.access$116(DragView.this, j);
          DragView.this.setScaleX(paramFloat + (f1 - paramFloat) * f);
          DragView.this.setScaleY(paramFloat + (f1 - paramFloat) * f);
          if (DragView.sDragAlpha != 1.0F)
            DragView.this.setAlpha(DragView.sDragAlpha * f + (1.0F - f));
          if (DragView.this.getParent() == null)
          {
            paramAnonymousValueAnimator.cancel();
            return;
          }
          DragView.this.setTranslationX(DragView.this.getTranslationX() + i);
          DragView.this.setTranslationY(DragView.this.getTranslationY() + j);
        }
      });
      this.mBitmap = Bitmap.createBitmap(paramBitmap, paramInt3, paramInt4, paramInt5, paramInt6);
      this.mIconBitmap = this.mBitmap;
      setDragRegion(new Rect(0, 0, paramInt5, paramInt6));
      this.mRegistrationX = paramInt1;
      this.mOrignalRegistrationX = paramInt1;
      this.mRegistrationY = paramInt2;
      this.mOrignalRegistrationY = paramInt2;
      paramInt1 = MeasureSpec.makeMeasureSpec(0, 0);
      measure(paramInt1, paramInt1);
      this.mPaint = new Paint(2);
      this.mIsDraging = true;
      return;
      f1 = ((Resources)localObject).getDimensionPixelSize(2131361920);
      localObject = null;
      if (paramLauncher.getDockBar() != null)
        localObject = paramLauncher.getDockBar().getDragView();
      if (localObject != null)
      {
        paramLauncher = Utilities.getViewBitmap((View)localObject);
        if ((paramLauncher != null) && (paramLauncher.getWidth() == paramInt5) && (paramLauncher.getHeight() == paramInt6))
          f1 = (paramInt6 + f1) / paramInt6;
        else
          f1 = (paramInt5 + f1) / paramInt5;
      }
      else
      {
        f1 = (paramInt5 + f1) / paramInt5;
      }
    }
  }

  public boolean becomeStoped()
  {
    return (float)Math.hypot(this.mDeltaXSpeed, this.mDeltaYSpeed) >= 60.0F;
  }

  public void cancelAnimation()
  {
    this.mDragViewHandler.removeMessages(1);
    if ((this.mAnim != null) && (this.mAnim.isRunning()))
      this.mAnim.cancel();
    if (this.mRotation != null)
      this.mRotation.cancel();
  }

  public void cancelDraging()
  {
    this.mIsDraging = false;
    clearAnimation();
    setRotationX(0.0F);
    setRotationY(0.0F);
  }

  public void changeDragViewState(DragViewState paramDragViewState)
  {
    if (DragViewState.ICON == paramDragViewState)
    {
      this.mBitmap = this.mIconBitmap;
      setRegistrationXY(false);
    }
    while (true)
    {
      paramDragViewState = (DragLayer.LayoutParams)getLayoutParams();
      paramDragViewState.width = this.mBitmap.getWidth();
      paramDragViewState.height = this.mBitmap.getHeight();
      setTranslationX((int)this.mCurrentTouchX - this.mRegistrationX + (int)this.mOffsetX);
      setTranslationY((int)this.mCurrentTouchY - this.mRegistrationY + (int)this.mOffsetY);
      paramDragViewState.customPosition = true;
      int i = MeasureSpec.makeMeasureSpec(0, 0);
      measure(i, i);
      requestLayout();
      return;
      if (this.mPreviewBitmap != null)
        this.mBitmap = this.mPreviewBitmap;
      setRegistrationXY(true);
    }
  }

  public boolean getCanShake()
  {
    return this.mCanShake;
  }

  public float getDegreeFromSpeed(float paramFloat)
  {
    if (this.mIsAppWidget);
    float f2;
    for (float f1 = 30.0F; ; f1 = 50.0F)
    {
      f2 = Math.signum(paramFloat);
      paramFloat = Math.abs(paramFloat);
      if (!this.mIsAppWidget)
        break label175;
      if (60.0F <= paramFloat)
        break;
      return 0.0F;
    }
    if (100.0F > paramFloat)
      return f2 * f1 / 8.0F;
    if (120.0F > paramFloat)
      return f2 * f1 / 4.0F;
    if (150.0F > paramFloat)
      return f2 * f1 * 3.0F / 8.0F;
    if (200.0F > paramFloat)
      return f2 * f1 / 2.0F;
    if (300.0F > paramFloat)
      return f2 * f1 * 5.0F / 8.0F;
    if (400.0F > paramFloat)
      return f2 * f1 * 3.0F / 4.0F;
    if (480.0F > paramFloat)
      return f2 * f1 * 7.0F / 8.0F;
    return f2 * f1;
    label175: if (20.0F > paramFloat)
      return 0.0F;
    if (60.0F > paramFloat)
      return f2 * f1 / 8.0F;
    if (100.0F > paramFloat)
      return f2 * f1 / 6.0F;
    if (120.0F > paramFloat)
      return f2 * f1 / 5.0F;
    if (150.0F > paramFloat)
      return f2 * f1 / 4.0F;
    if (200.0F > paramFloat)
      return f2 * f1 / 3.0F;
    if (300.0F > paramFloat)
      return f2 * f1 / 2.0F;
    if (400.0F > paramFloat)
      return f2 * f1 * 2.0F / 3.0F;
    if (480.0F > paramFloat)
      return f2 * f1 * 4.0F / 5.0F;
    return f2 * f1;
  }

  public Rect getDragRegion()
  {
    return this.mDragRegion;
  }

  public int getDragRegionHeight()
  {
    return this.mDragRegion.height();
  }

  public int getDragRegionLeft()
  {
    return this.mDragRegion.left;
  }

  public int getDragRegionTop()
  {
    return this.mDragRegion.top;
  }

  public int getDragRegionWidth()
  {
    return this.mDragRegion.width();
  }

  public Point getDragVisualizeOffset()
  {
    return this.mDragVisualizeOffset;
  }

  public float getOffsetY()
  {
    return this.mOffsetY;
  }

  public Bitmap getPreviewBitmap()
  {
    return this.mPreviewBitmap;
  }

  public int getXOffset()
  {
    return this.mOrignalRegistrationX;
  }

  public int getYOffset()
  {
    return this.mOrignalRegistrationY;
  }

  public boolean hasDrawn()
  {
    return this.mHasDrawn;
  }

  public boolean isSmoothState()
  {
    float f1 = (float)Math.hypot(this.mCurrentXSpeed, this.mCurrentYSpeed);
    float f2 = (float)Math.hypot(this.mCurrentTouchX - this.mLastTouchX, this.mCurrentTouchY - this.mLastTouchY);
    if (this.mIsAppWidget)
    {
      if ((60.0F <= f1) && (12.0F <= f2));
    }
    else
      while ((30.0F > f1) || (6.0F > f2))
        return true;
    return false;
  }

  int move(int paramInt1, int paramInt2)
  {
    this.mLastTouchX = this.mCurrentTouchX;
    this.mLastTouchY = this.mCurrentTouchY;
    this.mCurrentTouchX = paramInt1;
    this.mCurrentTouchY = paramInt2;
    Display localDisplay = this.mWindowManager.getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    int i = localPoint.x;
    int j = localPoint.y;
    float f2 = paramInt1 - this.mRegistrationX + (int)this.mOffsetX;
    float f3 = paramInt2 - this.mRegistrationY + (int)this.mOffsetY;
    paramInt1 = getWidth();
    float f1;
    if (getLeft() + f2 + paramInt1 <= paramInt1 / 3)
    {
      f1 = -paramInt1 * 2 / 3;
      if (getY() > 0.0F)
        break label242;
      f2 = f3;
      if (paramInt2 < 15)
        f2 = 15 - this.mRegistrationY;
    }
    while (true)
    {
      setTranslationX(f1);
      setTranslationY(f2);
      if (this.mCanShake)
        this.mDragViewHandler.sendEmptyMessageDelayed(1, 30L);
      getLocationOnScreen(this.mCenterTemp);
      if (getHeight() != 0)
        break label269;
      return 2012;
      f1 = f2;
      if (getLeft() + f2 < i - paramInt1 / 3)
        break;
      f1 = i - paramInt1 / 3;
      break;
      label242: f2 = f3;
      if (f3 >= j - 80)
        f2 = j - 80;
    }
    label269: return this.mCenterTemp[1] + getHeight() / 2;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.mHasDrawn = true;
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      Bitmap localBitmap = this.mBitmap;
      if (this.mWarning);
      for (Paint localPaint = this.mTrashPaint; ; localPaint = this.mPaint)
      {
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
        return;
      }
    }
    Log.i("DragView", "onDraw, bimtap is recycle");
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.mBitmap.getWidth(), this.mBitmap.getHeight());
  }

  public void recycleBitmap()
  {
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
    if (this.mIconBitmap != null)
    {
      this.mIconBitmap.recycle();
      this.mIconBitmap = null;
    }
    if (this.mPreviewBitmap != null)
    {
      this.mPreviewBitmap.recycle();
      this.mPreviewBitmap = null;
    }
  }

  void remove()
  {
    clearAnimation();
    this.mDragLayer.removeView(this);
  }

  public void resetLayoutParams()
  {
    this.mOffsetY = 0.0F;
    this.mOffsetX = 0.0F;
    requestLayout();
  }

  public void setAlpha(float paramFloat)
  {
    super.setAlpha(paramFloat);
    if (this.mPaint == null)
      this.mPaint = new Paint();
    this.mPaint.setAlpha((int)(255.0F * paramFloat));
    invalidate();
  }

  public void setCanShake(boolean paramBoolean)
  {
    this.mCanShake = paramBoolean;
  }

  public void setColor(int paramInt)
  {
    if (this.mPaint == null)
      this.mPaint = new Paint(2);
    if (paramInt != 0)
      this.mPaint.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
    while (true)
    {
      invalidate();
      return;
      this.mPaint.setColorFilter(null);
    }
  }

  public void setDragRegion(Rect paramRect)
  {
    this.mDragRegion = paramRect;
  }

  public void setDragVisualizeOffset(Point paramPoint)
  {
    this.mDragVisualizeOffset = paramPoint;
  }

  public void setMoveSpeed(float paramFloat1, float paramFloat2)
  {
    this.mCurrentXSpeed = paramFloat1;
    this.mCurrentYSpeed = paramFloat2;
  }

  public void setPaint(Paint paramPaint)
  {
    this.mPaint = paramPaint;
    invalidate();
  }

  public void setPreviewBitmap(Bitmap paramBitmap)
  {
    this.mPreviewBitmap = paramBitmap;
  }

  public void setRegistrationXY(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mRegistrationX = (this.mBitmap.getWidth() / 2);
      this.mRegistrationY = (this.mBitmap.getHeight() / 2);
      return;
    }
    this.mRegistrationX = this.mOrignalRegistrationX;
    this.mRegistrationY = this.mOrignalRegistrationY;
  }

  public void shakeView()
  {
    if (this.mRotation == null)
    {
      this.mRotation = new Rotate3d();
      this.mRotation.setFillAfter(true);
      this.mRotation.setInterpolator(new DecelerateInterpolator());
      this.mRotation.setAnimationListener(new mAnimationListener(null));
    }
    while (true)
    {
      this.mRotation.init(this.mCurrentXDegree, this.mCurrentYDegree);
      startAnimation(this.mRotation);
      return;
      this.mRotation.reset();
    }
  }

  public void show(int paramInt1, int paramInt2)
  {
    show(paramInt1, paramInt2, false);
  }

  public void show(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mDragLayer.addView(this);
    DragLayer.LayoutParams localLayoutParams = new DragLayer.LayoutParams(0, 0);
    localLayoutParams.width = this.mBitmap.getWidth();
    localLayoutParams.height = this.mBitmap.getHeight();
    localLayoutParams.customPosition = true;
    setLayoutParams(localLayoutParams);
    setTranslationX(paramInt1 - this.mRegistrationX);
    setTranslationY(paramInt2 - this.mRegistrationY);
    if (!paramBoolean)
      this.mAnim.start();
  }

  public float smoothDegree(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= paramFloat2;
    float f = Math.abs(paramFloat1);
    if (f >= 6.0F)
      if (paramFloat1 > 0.0F)
        paramFloat1 = 3.0F;
    while (true)
    {
      return paramFloat2 + paramFloat1;
      paramFloat1 = -3.0F;
      continue;
      if ((1.0F < f) && (f <= 6.0F))
      {
        if (paramFloat1 > 0.0F);
        for (paramFloat1 = 0.4F * f + 0.6F; ; paramFloat1 = -(0.4F * f + 0.6F))
          break;
      }
    }
  }

  public void startDragOrAnimation()
  {
    calculateSpeed();
    calculateDegree();
    if (isSmoothState())
    {
      if ((!this.mIsShaking) && (this.mIsDraging))
      {
        if (becomeStoped())
        {
          shakeView();
          return;
        }
        setRotationX(this.mCurrentXDegree);
        setRotationY(this.mCurrentYDegree);
        return;
      }
      setRotationX(this.mCurrentXDegree);
      setRotationY(this.mCurrentYDegree);
      return;
    }
    clearAnimation();
    if (this.mRotation != null)
      this.mRotation.cancel();
    setRotationX(this.mCurrentXDegree);
    setRotationY(this.mCurrentYDegree);
  }

  public void updatePaint(boolean paramBoolean)
  {
    this.mWarning = paramBoolean;
    invalidate();
  }

  private class DragViewHandler extends Handler
  {
    private DragViewHandler()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
      }
      if (!DragView.this.mIsDraging)
      {
        DragView.this.clearAnimation();
        return;
      }
      DragView.this.startDragOrAnimation();
    }
  }

  public static enum DragViewState
  {
    ICON, PREVIEW;
  }

  public class Rotate3d extends Animation
  {
    private int mShakeTimes = 0;
    private float mXFromDegrees;
    private float mYFromDegrees;

    public Rotate3d()
    {
    }

    private int calculateShakeTimes()
    {
      float f = (float)Math.hypot(DragView.this.mDeltaXSpeed, DragView.this.mDeltaYSpeed);
      this.mShakeTimes = 0;
      if (f <= 40.0F)
        this.mShakeTimes = 1;
      while (true)
      {
        return this.mShakeTimes;
        if ((f > 40.0F) && (f < 80.0F))
          this.mShakeTimes = 2;
        else if ((f > 80.0F) && (f < 160.0F))
          this.mShakeTimes = 4;
        else if (f > 160.0F)
          this.mShakeTimes = 6;
      }
    }

    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      float f1 = this.mXFromDegrees;
      float f2 = this.mYFromDegrees;
      DragView.access$702(DragView.this, getDegreesFromInput(f1, paramFloat, this.mShakeTimes));
      DragView.access$802(DragView.this, getDegreesFromInput(f2, paramFloat, this.mShakeTimes));
      DragView.this.setRotationX(DragView.this.mCurrentXDegree);
      DragView.this.setRotationY(DragView.this.mCurrentYDegree);
    }

    public void cancel()
    {
      super.cancel();
      DragView.access$902(DragView.this, false);
      this.mShakeTimes = 0;
    }

    public float getDegreesFromInput(float paramFloat1, float paramFloat2, int paramInt)
    {
      return (float)((1.0F - paramFloat2) / (1.0F + paramFloat2) * paramFloat1 * Math.cos(paramFloat2 * ((paramInt + 0) * 3.1415926D)));
    }

    public void init(float paramFloat1, float paramFloat2)
    {
      this.mXFromDegrees = paramFloat1;
      this.mYFromDegrees = paramFloat2;
      calculateShakeTimes();
      setDuration(this.mShakeTimes * 300);
    }

    public void setStartDegree(float paramFloat1, float paramFloat2)
    {
      this.mXFromDegrees = paramFloat1;
      this.mYFromDegrees = paramFloat2;
    }
  }

  private class mAnimationListener
    implements AnimationListener
  {
    private mAnimationListener()
    {
    }

    public void onAnimationEnd(Animation paramAnimation)
    {
      DragView.access$902(DragView.this, false);
    }

    public void onAnimationRepeat(Animation paramAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnimation)
    {
      DragView.access$902(DragView.this, true);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.DragView
 * JD-Core Version:    0.6.2
 */