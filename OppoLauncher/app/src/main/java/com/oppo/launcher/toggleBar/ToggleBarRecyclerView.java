package com.oppo.launcher.toggleBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.oppo.launcher.DragController;
import com.oppo.launcher.DragLayer;
import com.oppo.launcher.DragSource;
import com.oppo.launcher.DragView;
import com.oppo.launcher.DragView.DragViewState;
import com.oppo.launcher.DropTarget;
import com.oppo.launcher.DropTarget.DragObject;
import com.oppo.launcher.Launcher;
import com.oppo.launcher.LauncherUtil;
import com.oppo.launcher.LauncherViewPropertyAnimator;
import com.oppo.launcher.OppoPendingAddWidgetInfo;
import com.oppo.launcher.R.styleable;
import com.oppo.launcher.Utilities;
import com.oppo.launcher.Workspace;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ToggleBarRecyclerView extends RecyclerView
  implements DragSource, DropTarget
{
  private static final boolean DEBUG = false;
  public static final int ITEM_COUNT_ONE_SCREEN = 4;
  private static final int JUDGE_INSTRUCTIONS_RUN_DELAY_MSEL = 200;
  private static final int SNAP_VELOCITY = 200;
  private static final String TAG = ToggleBarRecyclerView.class.getName();
  private Comparator<PointerID> comparator = new Comparator()
  {
    public int compare(PointerID paramAnonymousPointerID1, PointerID paramAnonymousPointerID2)
    {
      return (int)Math.signum(paramAnonymousPointerID1.getPointerID() - paramAnonymousPointerID2.getPointerID());
    }
  };
  private List<PointerID> l = new LinkedList();
  private int mActivePointerID;
  private View mDragView;
  private DragController mDrager;
  private final CustomedHandler mHandler;
  private boolean mIsFirstTimeDraw = false;
  private AnimatorSet mItemOutAnimatorSet = null;
  private Runnable mJudgeInstructionsRunnable = new Runnable()
  {
    public void run()
    {
      ToggleBarRecyclerView.this.judgetImageViewVisibility();
    }
  };
  private Launcher mLauncher;
  private OnElementViewVisibilityListener mOnLeftElementVisibilityListener;
  private OnElementViewVisibilityListener mOnRightElementVisibilityListener;
  OnScrollListener mOnScrollListener = new OnScrollListener()
  {
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      paramAnonymousRecyclerView = ToggleBarRecyclerView.this.getLayoutManager();
      if (paramAnonymousRecyclerView == null);
      do
      {
        return;
        ((ToggleBarRecyclerLayoutManager)paramAnonymousRecyclerView).setScrollState(paramAnonymousInt);
      }
      while (paramAnonymousInt != 0);
      ToggleBarRecyclerView.this.judgetImageViewVisibility();
    }

    public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
    }
  };
  private int mPreviewItemHeight;
  private int mPreviewItemWidth;
  private final Resources mRes;
  private Canvas mTmpCanvas = new Canvas();
  private Matrix mTmpMatrix = new Matrix();
  private Paint mTmpPaint = new Paint();
  private ToggleBarShadow mToggleBarShadow;
  private VelocityTracker mVelocityTracker;
  private float offsetX;

  public ToggleBarRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ToggleBarRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ToggleBarRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mRes = paramContext.getResources();
    initResources(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
    setClipToPadding(true);
    ViewCompat.setOverScrollMode(this, 0);
    setOnScrollListener(this.mOnScrollListener);
    this.mHandler = new CustomedHandler(this);
  }

  private void clearList()
  {
    this.l.clear();
  }

  private void doSwitchToNormal()
  {
    LayoutManager localLayoutManager = getLayoutManager();
    if (localLayoutManager == null)
      return;
    ((ToggleBarRecyclerLayoutManager)localLayoutManager).doSwitchToOvershoot(false, 0.0F);
  }

  private void doSwitchToOvershoot(float paramFloat)
  {
    LayoutManager localLayoutManager = getLayoutManager();
    if (localLayoutManager == null)
      return;
    ((ToggleBarRecyclerLayoutManager)localLayoutManager).doSwitchToOvershoot(true, paramFloat);
  }

  private int getActivePointerID()
  {
    return this.mActivePointerID;
  }

  private Bitmap getCacheBimtap(View paramView)
  {
    Object localObject1 = paramView.getTag();
    float f1;
    float f2;
    if ((localObject1 != null) && ((localObject1 instanceof OppoPendingAddWidgetInfo)))
    {
      Object localObject2 = (OppoPendingAddWidgetInfo)localObject1;
      localObject1 = ToggleBarPreviewUtils.createAppWidgetPreviewDrawable((OppoPendingAddWidgetInfo)localObject2, this.mLauncher);
      paramView = (View)localObject1;
      if (localObject1 == null)
        paramView = ((OppoPendingAddWidgetInfo)localObject2).mDrawable;
      int i = paramView.getIntrinsicWidth();
      int j = paramView.getIntrinsicHeight();
      localObject1 = this.mLauncher.getResources();
      int k = ((Resources)localObject1).getDimensionPixelSize(2131361799);
      int m = ((Resources)localObject1).getDimensionPixelSize(2131361798);
      if ((k == 0) || (m == 0) || (i == 0) || (j == 0))
        break label332;
      f1 = k / i;
      f2 = m / j;
      if ((f1 <= 1.0F) || (f2 <= 1.0F))
        if (f1 < f2)
        {
          f1 = (float)(0.85D * f1);
          label152: int n = (int)(k - i * f1) / 2;
          int i1 = (int)(m - j * f1) / 2;
          localObject2 = (BitmapDrawable)paramView;
          this.mTmpMatrix.reset();
          this.mTmpMatrix.postScale(f1, f1);
          Bitmap localBitmap = Bitmap.createBitmap(((BitmapDrawable)localObject2).getBitmap(), 0, 0, i, j, this.mTmpMatrix, true);
          localObject1 = Bitmap.createBitmap(k, m, Config.ARGB_8888);
          paramView = this.mTmpCanvas;
          this.mTmpCanvas.setBitmap((Bitmap)localObject1);
          Paint localPaint = this.mTmpPaint;
          paramView.drawBitmap(localBitmap, n, i1, localPaint);
          paramView = (View)localObject1;
          if (localBitmap != ((BitmapDrawable)localObject2).getBitmap())
          {
            localBitmap.recycle();
            paramView = (View)localObject1;
          }
        }
    }
    do
    {
      return paramView;
      f1 = f2;
      break;
      f1 = 0.85F;
      break label152;
      localObject1 = Utilities.getViewBitmap(paramView);
      paramView = (View)localObject1;
    }
    while (localObject1 != null);
    Log.e(TAG, "getCacheBimtap, b is null");
    return localObject1;
    label332: return null;
  }

  private int getCountPage()
  {
    Adapter localAdapter = getAdapter();
    if (localAdapter == null)
      return 0;
    return localAdapter.getItemCount();
  }

  private int getItemCount()
  {
    Adapter localAdapter = getAdapter();
    if (localAdapter == null)
      return 0;
    return localAdapter.getItemCount();
  }

  private AnimatorSet getItemOutAnimator(final View paramView)
  {
    if (paramView == null)
      return null;
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setAlpha(0.0F);
    LauncherViewPropertyAnimator localLauncherViewPropertyAnimator = new LauncherViewPropertyAnimator(paramView);
    localLauncherViewPropertyAnimator.translationY(0.0F).setDuration(450L).setInterpolator(new OvershootInterpolator(0.9F));
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(290L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
      }
    });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localLauncherViewPropertyAnimator).after(0L);
    localAnimatorSet.play(localObjectAnimator).after(100L);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        paramView.setAlpha(1.0F);
        paramView.setTranslationY(0.0F);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramView.setAlpha(1.0F);
        paramView.setTranslationY(0.0F);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramView.setTranslationY(ToggleBarRecyclerView.this.mPreviewItemHeight);
      }
    });
    return localAnimatorSet;
  }

  private Bitmap getPreviewBitmap(View paramView)
  {
    int[] arrayOfInt = null;
    Object localObject = paramView.getTag();
    paramView = arrayOfInt;
    if ((localObject instanceof OppoPendingAddWidgetInfo))
    {
      paramView = (OppoPendingAddWidgetInfo)localObject;
      arrayOfInt = LauncherUtil.estimateItemSize(this.mLauncher, paramView.spanX, paramView.spanY, paramView, true);
      arrayOfInt[0] = ((int)(arrayOfInt[0] * 0.85F));
      arrayOfInt[1] = ((int)(arrayOfInt[1] * 0.85F));
      localObject = paramView.componentName.getPackageName();
      localObject = this.mLauncher.getApplicationIcon((String)localObject, paramView.icon);
      paramView = Utilities.getWidgetPreView(this.mLauncher, paramView.componentName, paramView.previewImage, (Drawable)localObject, paramView.spanX, paramView.spanY, arrayOfInt[0], arrayOfInt[1]);
    }
    return paramView;
  }

  private void initList()
  {
    clearList();
    this.l.add(new PointerID());
    setActivePointerID(0);
  }

  private void initResources(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Container_ToggleBar, paramInt, 0);
    this.mPreviewItemWidth = paramContext.getDimensionPixelSize(1, Math.round(this.mRes.getDimension(2131361792)));
    this.mPreviewItemHeight = paramContext.getDimensionPixelSize(2, Math.round(this.mRes.getDimension(2131361793)));
    this.offsetX = this.mRes.getDimension(2131361796);
    paramContext.recycle();
  }

  private void initView(Context paramContext)
  {
    setAlwaysDrawnWithCacheEnabled(false);
  }

  private void insertPointerIDToList(PointerID paramPointerID)
  {
    int i = Collections.binarySearch(this.l, paramPointerID, this.comparator);
    if (i < 0)
      this.l.add(-i - 1, paramPointerID);
  }

  private void judgetImageViewVisibility()
  {
    int m = getCountPage();
    LayoutManager localLayoutManager = getLayoutManager();
    if (localLayoutManager == null);
    int n;
    do
    {
      return;
      n = ((ToggleBarRecyclerLayoutManager)localLayoutManager).findFirstCompletelyVisibleItemPosition();
    }
    while (n == -1);
    int k = 0;
    int j = 0;
    int i;
    if (m <= 1)
    {
      i = 4;
      j = 4;
    }
    while (true)
    {
      if (this.mOnLeftElementVisibilityListener != null)
        this.mOnLeftElementVisibilityListener.onVisible(i);
      if (this.mOnRightElementVisibilityListener == null)
        break;
      this.mOnRightElementVisibilityListener.onVisible(j);
      return;
      if (n == 0)
      {
        i = 4;
      }
      else
      {
        i = k;
        if (n == m - 1)
        {
          j = 4;
          i = k;
        }
      }
    }
  }

  private void obtainActivePointerIDFromList(int paramInt)
  {
    PointerID localPointerID = new PointerID(paramInt);
    if (paramInt == getActivePointerID())
    {
      paramInt = Collections.binarySearch(this.l, localPointerID, this.comparator);
      if (paramInt >= 0)
      {
        if (paramInt != 0)
          break label84;
        paramInt += 1;
      }
    }
    try
    {
      while (true)
      {
        if ((PointerID)this.l.get(paramInt) != null)
          setActivePointerID(((PointerID)this.l.get(paramInt)).getPointerID());
        removePointerIDFromList(localPointerID);
        return;
        label84: paramInt = 0;
      }
    }
    catch (Exception localException)
    {
      while (true)
        setActivePointerID(0);
    }
  }

  private void obtainVelocityTracker(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
    this.mVelocityTracker.addMovement(paramMotionEvent);
  }

  private void releaseVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }

  private void removePointerIDFromList(PointerID paramPointerID)
  {
    this.l.remove(paramPointerID);
  }

  private void setActivePointerID(int paramInt)
  {
    this.mActivePointerID = paramInt;
  }

  public boolean acceptDrop(DropTarget.DragObject paramDragObject)
  {
    return false;
  }

  public void doBarAnimationOut(int paramInt)
  {
    int j = getChildCount();
    int i = j;
    if (j > 4)
      i = 4;
    if (this.mItemOutAnimatorSet != null)
    {
      this.mItemOutAnimatorSet.cancel();
      this.mItemOutAnimatorSet = null;
    }
    this.mItemOutAnimatorSet = new AnimatorSet();
    if (i > 0)
    {
      View localView = getChildAt(0);
      if (localView != null)
      {
        j = ((ViewGroup)localView).getChildCount();
        i = 0;
        while (i < j)
        {
          new AnimatorSet();
          AnimatorSet localAnimatorSet = getItemOutAnimator(((ViewGroup)localView).getChildAt(i));
          if (localAnimatorSet != null)
            this.mItemOutAnimatorSet.play(localAnimatorSet).after(i * 80 + paramInt);
          i += 1;
        }
        this.mItemOutAnimatorSet.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationCancel(Animator paramAnonymousAnimator)
          {
          }

          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
          }

          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
          }
        });
        this.mItemOutAnimatorSet.start();
      }
    }
    setVisibility(0);
  }

  public View findViewByPosition(int paramInt)
  {
    LayoutManager localLayoutManager = getLayoutManager();
    if (localLayoutManager == null)
      return null;
    return localLayoutManager.findViewByPosition(paramInt);
  }

  public DropTarget getDropTargetDelegate(DropTarget.DragObject paramDragObject)
  {
    return null;
  }

  public void getHitRect(Rect paramRect)
  {
    if (getVisibility() != 0)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    super.getHitRect(paramRect);
  }

  public void getLocationInDragLayer(int[] paramArrayOfInt)
  {
    this.mLauncher.getDragLayer().getLocationInDragLayer(this, paramArrayOfInt);
  }

  public void getLocationInToggleBar(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramInt / 4;
    paramInt %= 4;
    View localView = findViewByPosition(i);
    if ((localView != null) && (paramInt >= 0) && (paramInt < ((ViewGroup)localView).getChildCount()))
    {
      localView = ((ViewGroup)localView).getChildAt(paramInt);
      if (localView != null)
        localView.getLocationInWindow(paramArrayOfInt);
    }
  }

  public boolean isDropEnabled()
  {
    return true;
  }

  public boolean isDropEnabled(DropTarget.DragObject paramDragObject)
  {
    return true;
  }

  public void onDragEnter(DropTarget.DragObject paramDragObject)
  {
    if (paramDragObject.dragSource == this)
      paramDragObject.dragView.changeDragViewState(DragView.DragViewState.ICON);
  }

  public void onDragExit(DropTarget.DragObject paramDragObject)
  {
    if (paramDragObject.dragSource == this)
      paramDragObject.dragView.changeDragViewState(DragView.DragViewState.PREVIEW);
  }

  public void onDragOver(DropTarget.DragObject paramDragObject)
  {
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mIsFirstTimeDraw)
    {
      if (!(getAdapter() instanceof WidgetPreviewAdapter))
        break label27;
      judgetImageViewVisibility();
    }
    label27: 
    while (getVisibility() != 0)
      return;
    this.mIsFirstTimeDraw = false;
    postDelayed(this.mJudgeInstructionsRunnable, 200L);
  }

  public void onDrop(DropTarget.DragObject paramDragObject)
  {
  }

  public void onDropCompleted(View paramView, DropTarget.DragObject paramDragObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mLauncher.getWorkspace().clearOutlines();
    if (!paramBoolean2)
      paramDragObject.deferDragViewCleanupPostAnimation = false;
    this.mDragView = null;
  }

  public void onFlingToDelete(DropTarget.DragObject paramDragObject, int paramInt1, int paramInt2, PointF paramPointF)
  {
  }

  public void onFlingToDeleteCompleted()
  {
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      initList();
      continue;
      clearList();
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((Utilities.hasNavigationBar()) && (this.mRes != null))
    {
      paramInt1 = MeasureSpec.getSize(paramInt1);
      paramInt2 = MeasureSpec.getSize(paramInt2);
      setMeasuredDimension(paramInt1, Utilities.mNavigationBarHeight + paramInt2);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (getAdapter() == null)
      return false;
    int i = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
    obtainVelocityTracker(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    case 2:
    case 4:
    default:
    case 0:
    case 1:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      return true;
      initList();
      doSwitchToNormal();
      continue;
      clearList();
      doSwitchToNormal();
      paramMotionEvent = this.mVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      snapToDestination((int)paramMotionEvent.getXVelocity());
      releaseVelocityTracker();
      continue;
      clearList();
      snapToDestination(0);
      releaseVelocityTracker();
      continue;
      insertPointerIDToList(new PointerID(i));
      continue;
      obtainActivePointerIDFromList(i);
    }
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
    {
      this.mIsFirstTimeDraw = true;
      return;
    }
    removeCallbacks(this.mJudgeInstructionsRunnable);
  }

  public void preOnDrop(DropTarget.DragObject paramDragObject)
  {
  }

  public void removeAllViews()
  {
    LayoutManager localLayoutManager = getLayoutManager();
    if (localLayoutManager == null)
      return;
    localLayoutManager.removeAllViews();
  }

  public void removeDragViewApp(Object paramObject)
  {
  }

  public void restoreDragInfo(DropTarget.DragObject paramDragObject)
  {
  }

  public void setAdapter(Adapter paramAdapter, boolean paramBoolean)
  {
    stopScroll();
    if (paramBoolean)
    {
      setVisibility(4);
      Object localObject = getAdapter();
      LayoutManager localLayoutManager = getLayoutManager();
      if ((localObject != null) && (localLayoutManager != null))
      {
        int i = ((ToggleBarRecyclerLayoutManager)localLayoutManager).findFirstVisibleItemPosition();
        localObject = ((ToggleBarPreviewAdapter)localObject).getNewViewForAnimation(i);
        if (localObject != null)
          this.mToggleBarShadow.doBarAnimationIn(0, (ViewGroup)localObject);
      }
    }
    super.setAdapter(paramAdapter);
    if (this.mHandler.hasMessages(1))
      this.mHandler.removeMessages(1);
    if (paramBoolean)
      this.mHandler.sendEmptyMessageDelayed(1, 50L);
  }

  protected void setChildrenDrawingCacheEnabled(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setDrawingCacheEnabled(paramBoolean);
      localView.buildDrawingCache(true);
      i += 1;
    }
  }

  public void setDragController(DragController paramDragController)
  {
    this.mDrager = paramDragController;
  }

  public void setLauncher(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
  }

  public void setOnElementViewVisibilityListener(OnElementViewVisibilityListener paramOnElementViewVisibilityListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mOnLeftElementVisibilityListener = paramOnElementViewVisibilityListener;
      return;
    }
    this.mOnRightElementVisibilityListener = paramOnElementViewVisibilityListener;
  }

  public void setShadow(ToggleBarShadow paramToggleBarShadow)
  {
    this.mToggleBarShadow = paramToggleBarShadow;
  }

  public void snapToDestination(int paramInt)
  {
    int i = computeHorizontalScrollOffset();
    if (paramInt > 200)
      paramInt = (int)(i / this.offsetX);
    while (true)
    {
      snapToScreen(paramInt);
      return;
      if (paramInt < -200)
        paramInt = (int)((i + this.offsetX) / this.offsetX);
      else
        paramInt = (int)((i + this.offsetX / 2.0F) / this.offsetX);
    }
  }

  public void snapToScreen(int paramInt)
  {
    int j = Math.max(0, Math.min(paramInt, getCountPage() - 1));
    paramInt = computeHorizontalScrollOffset();
    if (paramInt != j * this.offsetX)
    {
      int i = (int)(Math.abs((int)(j * this.offsetX - paramInt)) * 0.3F);
      paramInt = i;
      if (i < 120)
        paramInt = 120;
      Object localObject = getLayoutManager();
      if (localObject != null)
        ((ToggleBarRecyclerLayoutManager)localObject).setScrollTime(paramInt);
      smoothScrollToPosition(j);
      localObject = getAdapter();
      if (localObject != null)
        ((ToggleBarPreviewAdapter)localObject).setToBeShowingPosition(j);
      invalidate();
      return;
    }
    this.mVelocityTracker.computeCurrentVelocity(1000);
    stopScroll();
    invalidate();
  }

  public void startDrag(View paramView)
  {
    this.mDragView = paramView;
    this.mLauncher.getWorkspace().clearDragInfo();
    Bitmap localBitmap1 = getCacheBimtap(paramView);
    Bitmap localBitmap2 = getPreviewBitmap(paramView);
    int[] arrayOfInt = new int[2];
    this.mLauncher.getDragLayer().getLocationInDragLayer(paramView, arrayOfInt);
    int i = arrayOfInt[0];
    int j = (int)((this.mPreviewItemWidth - localBitmap1.getWidth()) / 2.0F);
    int k = arrayOfInt[1];
    this.mDrager.startDrag(localBitmap1, localBitmap2, i + j, k, this, paramView.getTag(), DragController.DRAG_ACTION_COPY, null, null, false, 1.0F);
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
      localBitmap1.recycle();
    invalidate();
  }

  public boolean supportsFlingToDelete()
  {
    return false;
  }

  private class CustomedHandler extends Handler
  {
    private static final int MSG_DO_BAR_ANIMATION_OUT = 1;

    public CustomedHandler(ToggleBarRecyclerView arg2)
    {
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      }
      while (true)
      {
        super.handleMessage(paramMessage);
        return;
        ToggleBarRecyclerView.this.doBarAnimationOut(0);
      }
    }
  }

  public static abstract interface OnElementViewVisibilityListener
  {
    public abstract void onVisible(int paramInt);
  }

  private static final class PointerID
  {
    private int mPointerID;

    PointerID()
    {
      this(0);
    }

    PointerID(int paramInt)
    {
      this.mPointerID = paramInt;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof PointerID)))
          break;
      }
      while (getPointerID() == ((PointerID)paramObject).getPointerID());
      return false;
      return false;
    }

    int getPointerID()
    {
      return this.mPointerID;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarRecyclerView
 * JD-Core Version:    0.6.2
 */