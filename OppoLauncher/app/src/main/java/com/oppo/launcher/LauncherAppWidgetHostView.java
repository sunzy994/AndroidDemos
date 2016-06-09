package com.oppo.launcher;

import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RemoteViews;
import com.coloros.launcher.bitmapinfoutils.ICollectBitmapInfo;
import com.coloros.launcher.bitmapinfoutils.ICollectBitmapInfoCallBack;
import com.oppo.launcher.graphic.MaskBitmapUtilities;
import java.lang.reflect.Method;

public class LauncherAppWidgetHostView extends AppWidgetHostView
{
  private static final String TAG = "LauncherAppWidgetHostView";
  public static boolean mDraw2DViewFlag = false;
  public static boolean mReDrawFlag = false;
  private final boolean DEBUG = false;
  private final boolean DEBUG_CACHE = false;
  private final boolean DEBUG_EVENT = false;
  private final boolean DEBUG_NORMAL = false;
  protected float mBackgroundAlpha = 1.0F;
  protected Rect mBackgroundRect;
  private View mChildView = null;
  private ICollectBitmapInfoCallBack mCollectBitmapInfoCallBack = new ICollectBitmapInfoCallBack()
  {
    public int getBmpBrightness(Bitmap paramAnonymousBitmap, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      return MaskBitmapUtilities.getInstance().getBitmapBrightnessValue(paramAnonymousBitmap, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
    }
  };
  private Context mContext;
  private int mDelIconLeftPadding = 0;
  private int mDelIconTopPadding = 0;
  private Paint mDelPaint = new Paint();
  private View mErrorView;
  private boolean mHasPerformedLongPress;
  private LayoutInflater mInflater;
  private boolean mIsDrawWidget = false;
  private Launcher mLauncher;
  private CheckLongPressHelper mLongPressHelper;
  private int mNormalBGTopPadding = 0;
  protected Drawable mNormalBackground;
  boolean mNormalSize = false;
  private CheckForLongPress mPendingCheckForLongPress;
  private boolean mPressedDelIcon = false;

  public LauncherAppWidgetHostView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    LauncherApplication localLauncherApplication = (LauncherApplication)this.mContext.getApplicationContext();
    if (localLauncherApplication != null)
      this.mLauncher = localLauncherApplication.getLauncher();
    this.mLongPressHelper = new CheckLongPressHelper(this);
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mDelPaint.setFilterBitmap(true);
    paramContext = getResources();
    this.mNormalBackground = paramContext.getDrawable(2130837504);
    this.mNormalBGTopPadding = ((int)paramContext.getDimension(2131361935));
    this.mNormalBackground.setFilterBitmap(true);
    this.mBackgroundRect = new Rect();
    this.mDelIconLeftPadding = ((int)paramContext.getDimension(2131361917));
    this.mDelIconTopPadding = ((int)paramContext.getDimension(2131361918));
  }

  private void drawDelIcon(Canvas paramCanvas)
  {
    Object localObject = (LauncherAppWidgetInfo)getTag();
    if (DelIconAnim.shouldRefresh())
    {
      int i = getScrollX();
      int j = getScrollY();
      float f = 1.0F;
      if (!this.mNormalSize)
        f = DelIconAnim.getScale();
      localObject = Utilities.getUnistallBitmap(getContext());
      int k = ((Bitmap)localObject).getWidth();
      int m = ((Bitmap)localObject).getHeight();
      if (localObject != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i, j);
        int n = this.mDelIconLeftPadding + (int)(Utilities.getIconWidth() / 2 * (1.0F - f));
        int i1 = this.mDelIconTopPadding + (int)(Utilities.getIconWidth() / 2 * (1.0F - f));
        Rect localRect = new Rect(n, i1, (int)(n + k * f), (int)(i1 + m * f));
        k = (int)(255.0F * f);
        this.mDelPaint.setAlpha(k);
        paramCanvas.drawBitmap((Bitmap)localObject, null, localRect, this.mDelPaint);
        paramCanvas.translate(-i, -j);
        paramCanvas.restore();
      }
    }
    else
    {
      return;
    }
    Log.w("LauncherAppWidgetHostView", "drawDelIcon, mUninstallBitmap is null==========");
  }

  public void cancelLongPress()
  {
    super.cancelLongPress();
    this.mLongPressHelper.cancelLongPress();
    this.mHasPerformedLongPress = false;
    if (this.mPendingCheckForLongPress != null)
      removeCallbacks(this.mPendingCheckForLongPress);
  }

  public boolean checkUninstallPressed(int paramInt1, int paramInt2)
  {
    int i = this.mDelIconLeftPadding;
    int j = Utilities.getUnistallBitmapWidth(getContext()) * 3 / 2;
    int k = this.mDelIconTopPadding;
    int m = Utilities.getUnistallBitmapHeight(getContext()) * 3 / 2;
    return (paramInt1 <= i + j) && (paramInt1 >= 0) && (paramInt2 <= k + m) && (paramInt2 >= 0);
  }

  public Object command(int paramInt, int[] paramArrayOfInt, Object paramObject)
  {
    Object localObject1 = null;
    if (this.mChildView != null)
      localObject1 = this.mChildView.getClass();
    try
    {
      int[] arrayOfInt = new int[2];
      Object localObject2 = new Object();
      localObject1 = ((Class)localObject1).getDeclaredMethod("onCommand", new Class[] { Integer.TYPE, arrayOfInt.getClass(), localObject2.getClass() });
      ((Method)localObject1).setAccessible(true);
      localObject1 = ((Method)localObject1).invoke(this.mChildView, new Object[] { Integer.valueOf(paramInt), paramArrayOfInt, paramObject });
      return localObject1;
    }
    catch (Exception paramArrayOfInt)
    {
      Log.e("LauncherAppWidgetHostView", "LauncherAppWidgetHostView --- command, e = " + paramArrayOfInt);
    }
    return null;
  }

  public void destroyOurDrawingCache()
  {
  }

  public void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = (LauncherAppWidgetInfo)getTag();
    localObject = this.mNormalBackground;
    ((Drawable)localObject).setAlpha((int)(this.mBackgroundAlpha * 255.0F));
    if ((this.mLauncher.getWorkspace().isSpringLoadedOrOrderOne()) && (!this.mIsDrawWidget))
    {
      this.mBackgroundRect.set(0, this.mNormalBGTopPadding, getWidth(), getHeight() - this.mNormalBGTopPadding);
      ((Drawable)localObject).setBounds(this.mBackgroundRect);
      ((Drawable)localObject).draw(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
    drawDelIcon(paramCanvas);
    this.mIsDrawWidget = false;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Workspace localWorkspace = null;
    if (this.mLauncher != null)
      localWorkspace = this.mLauncher.getWorkspace();
    if (localWorkspace == null)
      return false;
    LauncherAppWidgetInfo localLauncherAppWidgetInfo = (LauncherAppWidgetInfo)getTag();
    if (localWorkspace.isSpringLoadedOrOrderOne())
      return handEventWhenTidyUp(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 1:
    case 3:
    case 0:
    }
    do
    {
      do
        while (true)
        {
          return super.dispatchTouchEvent(paramMotionEvent);
          this.mLongPressHelper.cancelLongPress();
          this.mHasPerformedLongPress = false;
          if (this.mPendingCheckForLongPress != null)
            removeCallbacks(this.mPendingCheckForLongPress);
        }
      while (this.mLauncher == null);
      if (!localWorkspace.isNormal())
        break;
    }
    while (!localWorkspace.isSpringLoadedOrOrderOne());
    return false;
  }

  public void drawWidgetView(Canvas paramCanvas)
  {
    this.mIsDrawWidget = true;
    super.draw(paramCanvas);
  }

  public View getChildView()
  {
    return this.mChildView;
  }

  public int getDescendantFocusability()
  {
    return 393216;
  }

  public Bitmap getDrawingCache(boolean paramBoolean)
  {
    if (!mReDrawFlag)
      return super.getDrawingCache(paramBoolean);
    destroyDrawingCache();
    return null;
  }

  protected View getErrorView()
  {
    this.mErrorView = this.mInflater.inflate(2130968578, this, false);
    return this.mErrorView;
  }

  protected boolean handEventWhenTidyUp(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    final LauncherAppWidgetInfo localLauncherAppWidgetInfo = (LauncherAppWidgetInfo)getTag();
    if ((paramMotionEvent.getAction() != 1) || (!this.mPressedDelIcon))
      bool = super.dispatchTouchEvent(paramMotionEvent);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
      return bool;
    case 0:
      if (checkUninstallPressed(i, j))
      {
        this.mPressedDelIcon = true;
        cancelLongPress();
        return bool;
      }
      this.mLongPressHelper.postCheckForLongPress();
      this.mPressedDelIcon = false;
      return false;
    case 3:
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
          if (LauncherAppWidgetHostView.this.mLauncher.getWorkspace() != null)
            LauncherAppWidgetHostView.this.mLauncher.getWorkspace().removeAppWidgetInPage(localLauncherAppWidgetInfo);
        }
      });
    this.mLongPressHelper.cancelLongPress();
    this.mPressedDelIcon = false;
    return bool;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLongPressHelper.hasPerformedLongPress())
      this.mLongPressHelper.cancelLongPress();
    while (!this.mLauncher.getWorkspace().isNormal())
      return true;
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      return false;
      this.mLongPressHelper.postCheckForLongPress();
      continue;
      this.mLongPressHelper.cancelLongPress();
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mBackgroundRect.set(0, 0, paramInt1, paramInt2);
  }

  public void setChildView(View paramView)
  {
    this.mChildView = paramView;
    if ((this.mChildView instanceof ICollectBitmapInfo))
      ((ICollectBitmapInfo)this.mChildView).setCollectBitmapInfoCallBack(this.mCollectBitmapInfoCallBack);
  }

  public void setNormalSize(boolean paramBoolean)
  {
    this.mNormalSize = paramBoolean;
  }

  public void setOppoWidget()
  {
    if (this.mErrorView != null)
      this.mErrorView.setVisibility(8);
  }

  protected boolean uninstallEnable()
  {
    return (LauncherAppWidgetInfo)getTag() != null;
  }

  public void updateAppWidget(RemoteViews paramRemoteViews)
  {
    super.updateAppWidget(paramRemoteViews);
    if ((paramRemoteViews == null) && (this.mContext != null))
    {
      paramRemoteViews = (LauncherApplication)this.mContext.getApplicationContext();
      if (paramRemoteViews != null)
        paramRemoteViews.getLauncher().getWorkspace().commandLauncherAddAppWidget(this);
    }
  }

  class CheckForLongPress
    implements Runnable
  {
    private int mOriginalWindowAttachCount;

    CheckForLongPress()
    {
    }

    public void rememberWindowAttachCount()
    {
      this.mOriginalWindowAttachCount = LauncherAppWidgetHostView.this.getWindowAttachCount();
    }

    public void run()
    {
      if ((LauncherAppWidgetHostView.this.getParent() != null) && (LauncherAppWidgetHostView.this.hasWindowFocus()) && (this.mOriginalWindowAttachCount == LauncherAppWidgetHostView.this.getWindowAttachCount()) && (!LauncherAppWidgetHostView.this.mHasPerformedLongPress) && (LauncherAppWidgetHostView.this.performLongClick()))
        LauncherAppWidgetHostView.access$102(LauncherAppWidgetHostView.this, true);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.LauncherAppWidgetHostView
 * JD-Core Version:    0.6.2
 */