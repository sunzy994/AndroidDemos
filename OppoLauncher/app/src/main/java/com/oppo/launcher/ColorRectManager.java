package com.oppo.launcher;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.oppo.NearMeStatistics.LauncherStatistics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.graphics.Point;>;
import java.util.ListIterator;
import java.util.Set;

public class ColorRectManager
{
  private static final boolean DEBUG = false;
  public static int MAX_SELECT_COUNT = 0;
  public static final float ORDER_MORE_ALPHA_NORMAL = 0.7F;
  public static final float ORDER_MORE_ALPHA_SELECTED = 1.0F;
  public static final float ORDER_ONE_ALPHA_NORMAL = 1.0F;
  public static final boolean ORDER_WITH_DOCKBAR = false;
  static final int STATE_COMEHERE_ANIMATION = 4096;
  static final int STATE_INIT = 0;
  static final int STATE_TAIL_ANIMATION = 8192;
  private static final String TAG = "ColorRectManager";
  public static float sCurrentIconAlpha = 1.0F;
  final int RESET_INIT_DELAY_TIME = 100;
  private ValueAnimator mColorRectIconVAnimator = null;
  ColorRectPreview mColorRectPreview = null;
  ColorRectTopBar mColorRectTopBar = null;
  private ValueAnimator mColorRectVAnimator = null;
  private final int[] mCoordinatesTemp = new int[2];
  private DelIconAnim mDelIconAnim = null;
  private DragLayer mDragLayer = null;
  List<ColorRectDragView> mDragViewList = new ArrayList();
  private Folder mDragWithFolder = null;
  ColorRectDragView mHeadDragView = null;
  private ValueAnimator mHelpAnim = null;
  private int mIconAlphaAniDuration;
  private boolean mIsComeHereAnimation = false;
  private Launcher mLauncher = null;
  int mMotionOffX = 0;
  int mMotionOffY = 0;
  int mMotionX = 0;
  int mMotionY = 0;
  private final String mSelectedFullToastText;
  List<View> mSelectedViews = new ArrayList();
  private int mState = 0;
  ColorRectTailAnimation mTailanimation = new ColorRectTailAnimation();
  private int mTopbarAniDuration;
  private Workspace mWorkspace = null;
  private ValueAnimator mWorkspaceViewAnimator = null;
  private final PagedView.ZoomInInterpolator mZoomInInterpolator = new PagedView.ZoomInInterpolator();
  int workspaceTranslation = 0;

  public ColorRectManager(Launcher paramLauncher, Workspace paramWorkspace)
  {
    this.mLauncher = paramLauncher;
    this.mWorkspace = paramWorkspace;
    this.mDragLayer = paramLauncher.getDragLayer();
    paramLauncher = this.mLauncher.getResources();
    if (Utilities.mHasNavigationBar)
    {
      paramWorkspace = (RelativeLayout)this.mLauncher.findViewById(2131492880);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramWorkspace.getLayoutParams();
      localLayoutParams.setMargins(0, 0, 0, localLayoutParams.bottomMargin + Utilities.mNavigationBarHeight);
      paramWorkspace.setLayoutParams(localLayoutParams);
    }
    this.mColorRectPreview = ((ColorRectPreview)this.mLauncher.findViewById(2131492881));
    this.mColorRectTopBar = ((ColorRectTopBar)this.mLauncher.findViewById(2131492870));
    this.mColorRectTopBar.setContext(this.mLauncher, this);
    this.mColorRectPreview.setLauncher(this.mLauncher);
    this.mTopbarAniDuration = paramLauncher.getInteger(2131296285);
    this.mIconAlphaAniDuration = paramLauncher.getInteger(2131296286);
    this.mSelectedFullToastText = String.format(paramLauncher.getString(2131427383), new Object[] { Integer.valueOf(MAX_SELECT_COUNT) });
    this.mDelIconAnim = DelIconAnim.getInstance();
  }

  private void animationToColorRect(ColorRect paramColorRect, List<Point> paramList)
  {
    int j = 300;
    CellLayout localCellLayout = paramColorRect.getCellLayout();
    int i = 0;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    ListIterator localListIterator = this.mDragViewList.listIterator(this.mDragViewList.size());
    while (localListIterator.hasPrevious())
    {
      ColorRectDragView localColorRectDragView = (ColorRectDragView)localListIterator.previous();
      Object localObject2 = (View)localColorRectDragView.getTag();
      Object localObject1 = (View)localColorRectDragView.getTag(2131492865);
      if ((localObject1 == null) || (localObject2 == null))
      {
        Log.e("ColorRectManager", "animationToColorRect dropedView error !!!");
      }
      else
      {
        localObject2 = new Rect();
        this.mLauncher.getDragLayer().getViewRectRelativeToSelf(localColorRectDragView, (Rect)localObject2);
        Rect localRect = new Rect();
        paramColorRect.getGlobalVisibleRect(localRect);
        localRect.offset(-localColorRectDragView.getMeasuredWidth() / 2, -localColorRectDragView.getMeasuredHeight() / 2);
        Object localObject3 = (Point)paramList.get(i);
        RectF localRectF = new RectF();
        localCellLayout.cellToRect(((Point)localObject3).x, ((Point)localObject3).y, 1, 1, localRectF);
        localObject3 = paramColorRect.mapRect(localRectF);
        localRect.offset((int)(((RectF)localObject3).left + ((RectF)localObject3).width() / 2.0F), (int)(((RectF)localObject3).top + ((RectF)localObject3).height() / 2.0F));
        float f1 = ((RectF)localObject3).width() / localRectF.width();
        float f2 = ((RectF)localObject3).height() / localRectF.height();
        localColorRectDragView.setSameDuration(false);
        localObject1 = localColorRectDragView.animateView((Rect)localObject2, localRect, 0.3F, 1.0F, 1.0F, f1, f2, j, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), new Runnable()
        {
          public void run()
          {
            this.val$dstView.setVisibility(0);
          }
        }
        , 0, null);
        j = localColorRectDragView.getMaxAnimationDuration(j);
        i += 1;
        localArrayList.add(localObject1);
      }
    }
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ColorRectManager.this.destroyViewsInDragLayer();
        ColorRectManager.this.resetOrderMoreState(true);
      }
    });
    localAnimatorSet.start();
  }

  private void animationToDockbar()
  {
    int i = 300;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    ListIterator localListIterator = this.mDragViewList.listIterator(this.mDragViewList.size());
    while (localListIterator.hasPrevious())
    {
      ColorRectDragView localColorRectDragView = (ColorRectDragView)localListIterator.previous();
      Object localObject2 = (View)localColorRectDragView.getTag();
      Object localObject1 = (View)localColorRectDragView.getTag(2131492865);
      if ((localObject1 == null) || (localObject2 == null))
      {
        Log.e("ColorRectManager", "animationToNewPostion dropedView error !!!");
      }
      else
      {
        localObject2 = new Rect();
        localColorRectDragView.setSameDuration(false);
        localColorRectDragView.modifyDestination(null);
        this.mDragLayer.getViewRectRelativeToSelf(localColorRectDragView, (Rect)localObject2);
        Object localObject3 = this.mLauncher.getDockBar();
        Rect localRect1 = ((DockBar)localObject3).getChildLocation(((DockBar)localObject3).indexOfChild((View)localObject1), ((DockBar)localObject3).getChildCount(), true);
        int j = localRect1.width();
        Rect localRect2 = new Rect();
        this.mDragLayer.getViewRectRelativeToSelf((View)localObject3, localRect2);
        localRect2.left += localRect1.left;
        localRect2.top += ((View)localObject1).getPaddingTop();
        localRect1.right = (localRect1.left + ((Rect)localObject2).width());
        localRect1.bottom = (localRect1.top + ((Rect)localObject2).height());
        localObject3 = computerAnimationOffSetForDockbar((View)localObject1, j);
        localRect1.offset(localObject3[0], localObject3[1]);
        localObject1 = localColorRectDragView.animateView((Rect)localObject2, localRect1, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, i, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), new Runnable()
        {
          public void run()
          {
            this.val$dstView.setVisibility(0);
          }
        }
        , 1, null);
        i = localColorRectDragView.getMaxAnimationDuration(i);
        localArrayList.add(localObject1);
      }
    }
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ColorRectManager.this.destroyViewsInDragLayer();
        ColorRectManager.this.resetOrderMoreState(true);
      }
    });
    localAnimatorSet.start();
  }

  private void animationToWorkSpace()
  {
    int i = 500;
    reNewBitmapForDrop(false);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    ListIterator localListIterator = this.mDragViewList.listIterator(this.mDragViewList.size());
    while (localListIterator.hasPrevious())
    {
      ColorRectDragView localColorRectDragView = (ColorRectDragView)localListIterator.previous();
      Object localObject2 = (View)localColorRectDragView.getTag();
      Object localObject1 = (View)localColorRectDragView.getTag(2131492865);
      if ((localObject1 == null) || (localObject2 == null))
      {
        Log.e("ColorRectManager", "animationToNewPostion dropedView error !!!");
      }
      else
      {
        localObject2 = new Rect();
        localColorRectDragView.setSameDuration(false);
        localColorRectDragView.modifyDestination(null);
        this.mDragLayer.getViewRectRelativeToSelf(localColorRectDragView, (Rect)localObject2);
        Rect localRect = new Rect();
        int[] arrayOfInt = new int[2];
        int[] tmp158_156 = arrayOfInt;
        tmp158_156[0] = 0;
        int[] tmp162_158 = tmp158_156;
        tmp162_158[1] = 0;
        tmp162_158;
        if ((((View)localObject1).getLayoutParams() instanceof BaseCellLayout.LayoutParams))
        {
          localObject3 = (BaseCellLayout.LayoutParams)((View)localObject1).getLayoutParams();
          arrayOfInt[0] = ((BaseCellLayout.LayoutParams)localObject3).x;
          arrayOfInt[1] = ((BaseCellLayout.LayoutParams)localObject3).y;
        }
        Object localObject3 = computerAnimationOffSet((View)localObject1);
        localRect.offset(localObject3[0], localObject3[1]);
        this.mDragLayer.getDescendantCoordRelativeToSelf((View)((View)localObject1).getParent(), arrayOfInt);
        localRect.left = arrayOfInt[0];
        localRect.top = arrayOfInt[1];
        localRect.right = (arrayOfInt[0] + ((Rect)localObject2).width());
        localRect.bottom = (arrayOfInt[1] + ((Rect)localObject2).height());
        localRect.offset(localObject3[0], localObject3[1]);
        localObject1 = localColorRectDragView.animateView((Rect)localObject2, localRect, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), new Runnable()
        {
          public void run()
          {
            this.val$dstView.setVisibility(0);
          }
        }
        , 1, this.mWorkspace);
        i = localColorRectDragView.getMaxAnimationDuration(i);
        localArrayList.add(localObject1);
      }
    }
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ColorRectManager.this.destroyViewsInDragLayer();
        ColorRectManager.this.doDropCompleted(ColorRectManager.this.mWorkspace, true, true);
        ColorRectManager.this.resetOrderMoreState(true);
      }
    });
    localAnimatorSet.start();
  }

  private void checkFolderIcon(FolderIcon paramFolderIcon)
  {
    FolderInfo localFolderInfo;
    CellLayout localCellLayout;
    if (paramFolderIcon.getParent() == null)
    {
      localFolderInfo = paramFolderIcon.getFolder().getInfo();
      int i = this.mLauncher.getModel().getScreenIndex(localFolderInfo.screenId);
      localCellLayout = (CellLayout)this.mLauncher.getCellLayout(localFolderInfo.container, i);
      if (localCellLayout != null);
    }
    else
    {
      return;
    }
    View localView = localCellLayout.getChildAt(localFolderInfo.cellX, localFolderInfo.cellY);
    if (localView != null)
      localCellLayout.removeView(localView);
    localCellLayout.addViewToCellLayout(paramFolderIcon, -1, LauncherModel.getCellLayoutChildIdFromScreenId(localFolderInfo.container, localFolderInfo.screenId, localFolderInfo.cellX, localFolderInfo.cellY, localFolderInfo.spanX, localFolderInfo.spanY), (BaseCellLayout.LayoutParams)paramFolderIcon.getLayoutParams(), true, false);
  }

  private boolean comeHereAnimation(View paramView)
  {
    if ((this.mSelectedViews.size() > 0) && (!this.mSelectedViews.contains(paramView)) && (!(paramView instanceof FolderIcon)))
    {
      Log.e("ColorRectManager", "comeHereAnimation  mSelectViewList.size()>0 but view is not in mSelectViewList just return");
      return false;
    }
    if (this.mState == 0)
    {
      if ((paramView instanceof FolderIcon))
        clearSelectedViews();
      if (this.mSelectedViews.size() < 1)
        selectView(paramView);
      if (this.mSelectedViews.size() < 1)
      {
        Log.e("ColorRectManager", "comeHereAnimation  maybe alse failed ");
        return false;
      }
      this.mState = 4096;
      this.mColorRectTopBar.onChangeState(ColorRectTopBar.State.ORDER_MORE_DRAG);
      createViewsInDragLayer(paramView);
      this.mLauncher.getDragController().vibrate();
      Rect localRect = new Rect();
      this.mDragLayer.getViewRectRelativeToSelf(paramView, localRect);
      int[] arrayOfInt = computerAnimationOffSet(paramView);
      localRect.offset(arrayOfInt[0], arrayOfInt[1]);
      int i = 0;
      this.mIsComeHereAnimation = true;
      this.mMotionOffX = (this.mMotionX - localRect.left);
      this.mMotionOffY = (this.mMotionY - localRect.top);
      AnimatorSet localAnimatorSet;
      ArrayList localArrayList;
      label277: ColorRectDragView localColorRectDragView;
      if (this.mMotionOffY > localRect.height())
      {
        this.mMotionOffY = localRect.height();
        localAnimatorSet = new AnimatorSet();
        localArrayList = new ArrayList();
        if ((paramView instanceof FolderItemView))
          this.mDragWithFolder = ((FolderItemView)paramView).getFolder();
        ListIterator localListIterator = this.mDragViewList.listIterator(this.mDragViewList.size());
        if (!localListIterator.hasPrevious())
          break label491;
        localColorRectDragView = (ColorRectDragView)localListIterator.previous();
        View localView = (View)localColorRectDragView.getTag();
        localView.setVisibility(8);
        paramView = this.mWorkspace.getParentCellLayoutForView(localView);
        if (paramView != null)
          paramView.markCellsAsUnoccupiedForView(localView);
        paramView = new Rect();
        if (!(localView instanceof FolderItemView))
          break label478;
        Folder localFolder = ((FolderItemView)localView).getFolder();
        if (this.mDragWithFolder == localFolder)
          break label465;
        paramView = ((FolderItemView)localView).getFolderIconOriginalPos();
      }
      while (true)
      {
        paramView.offset(arrayOfInt[0], arrayOfInt[1]);
        localColorRectDragView.setSameDuration(true);
        paramView = localColorRectDragView.animateView(paramView, localRect, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), null, 2, null);
        i = localColorRectDragView.getMaxAnimationDuration(i);
        localArrayList.add(paramView);
        break label277;
        if (this.mMotionOffY >= 0)
          break;
        this.mMotionOffY = 0;
        break;
        label465: this.mDragLayer.getViewRectRelativeToSelf(localColorRectDragView, paramView);
        continue;
        label478: this.mDragLayer.getViewRectRelativeToSelf(localColorRectDragView, paramView);
      }
      label491: localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      this.mHelpAnim = new ValueAnimator();
      this.mHelpAnim.setDuration(i);
      this.mHelpAnim.setFloatValues(new float[] { 0.0F, 1.0F });
      this.mHelpAnim.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          if (ColorRectManager.this.mState == 4096)
            ColorRectManager.this.comeHereAnimationHelp();
        }
      });
      this.mHelpAnim.addListener(new AnimatorListener()
      {
        boolean isCancel = false;

        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.isCancel = true;
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if ((ColorRectManager.this.mState != 4096) || (this.isCancel))
          {
            Log.e("ColorRectManager", "comeHereAnimation  error state is " + this.isCancel + " state " + ColorRectManager.this.mState);
            return;
          }
          ColorRectManager.access$602(ColorRectManager.this, false);
          if (ColorRectManager.this.mHeadDragView == null)
          {
            Log.e("ColorRectManager", "comeHereAnimation  mHeadDragView == null");
            return;
          }
          if (!ColorRectManager.this.mDragLayer.mIsOnTouching)
          {
            Log.e("ColorRectManager", "comeHereAnimation  mIsOnTouching ==  " + ColorRectManager.this.mDragLayer.mIsOnTouching);
            ColorRectManager.this.goBackAnimation(true);
            return;
          }
          paramAnonymousAnimator = new BaseCellLayout.CellInfo();
          View localView = (View)ColorRectManager.this.mHeadDragView.getTag();
          Object localObject = localView.getParent();
          if ((localObject instanceof CellLayout))
          {
            localObject = (CellLayout)localObject;
            BaseCellLayout.LayoutParams localLayoutParams = (BaseCellLayout.LayoutParams)localView.getLayoutParams();
            paramAnonymousAnimator.cell = localView;
            paramAnonymousAnimator.cellX = localLayoutParams.cellX;
            paramAnonymousAnimator.cellY = localLayoutParams.cellY;
            paramAnonymousAnimator.spanX = localLayoutParams.cellHSpan;
            paramAnonymousAnimator.spanY = localLayoutParams.cellVSpan;
            ((CellLayout)localObject).setTag(paramAnonymousAnimator);
          }
          ColorRectManager.access$202(ColorRectManager.this, 8192);
          ColorRectManager.this.mHeadDragView.setRegistrationPostion(ColorRectManager.this.mMotionOffX, ColorRectManager.this.mMotionOffY);
          ColorRectManager.this.mWorkspace.beginDragSharedByColorRect(ColorRectManager.this.mHeadDragView, ColorRectManager.this.mWorkspace, ColorRectManager.this.mMotionX, ColorRectManager.this.mMotionY);
          ColorRectManager.this.mTailanimation.setList(ColorRectManager.this.mDragViewList);
          ColorRectManager.this.mTailanimation.startTail();
        }

        public void onAnimationRepeat(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
        }
      });
      this.mHelpAnim.start();
      return true;
    }
    return false;
  }

  private void comeHereAnimationHelp()
  {
    if (this.mDragViewList.size() > 0)
    {
      int i = this.mMotionX - this.mMotionOffX;
      int j = this.mMotionY - this.mMotionOffY;
      Rect localRect = new Rect(i, j, this.mHeadDragView.getWidth() + i, this.mHeadDragView.getHeight() + j);
      ListIterator localListIterator = this.mDragViewList.listIterator(this.mDragViewList.size());
      while (localListIterator.hasPrevious())
      {
        ColorRectDragView localColorRectDragView = (ColorRectDragView)localListIterator.previous();
        if (this.mIsComeHereAnimation)
          localColorRectDragView.modifyDestination(localRect);
      }
    }
  }

  private int[] computerAnimationOffSet(View paramView)
  {
    return new int[] { 0, 0 };
  }

  private int[] computerAnimationOffSetForDockbar(View paramView, int paramInt)
  {
    int k = 0;
    int m = 0;
    Object localObject;
    int i;
    int j;
    if ((paramView instanceof TextView))
    {
      localObject = ((TextView)paramView).getCompoundDrawables()[1];
      paramView = (TextView)paramView;
      i = k;
      j = m;
      if (localObject != null)
      {
        i = paramView.getCompoundPaddingLeft() + paramView.getCompoundPaddingRight() + (paramInt - ((Drawable)localObject).getIntrinsicWidth()) / 2;
        j = paramView.getPaddingTop();
      }
    }
    while (true)
    {
      return new int[] { i, j };
      i = k;
      j = m;
      if ((paramView instanceof FolderIcon))
      {
        paramView = (FolderIcon)paramView;
        localObject = paramView.getFastBitmapDrawable();
        i = k;
        j = m;
        if (localObject != null)
        {
          i = (int)((paramInt - ((Drawable)localObject).getIntrinsicWidth() * this.mLauncher.getDockBar().getScaleX()) / 2.0F);
          j = paramView.marginTop + paramView.getPaddingTop();
        }
      }
    }
  }

  private void createViewsInDragLayer(View paramView)
  {
    if (this.mSelectedViews.size() < 1)
    {
      Log.e("ColorRectManager", "createViewsInDragLayer  mSelectViewList.size()<1");
      return;
    }
    if (this.mSelectedViews.get(0) != paramView)
    {
      this.mSelectedViews.remove(paramView);
      this.mSelectedViews.add(0, paramView);
    }
    paramView = this.mSelectedViews.listIterator(this.mSelectedViews.size());
    if (paramView.hasPrevious())
    {
      View localView = (View)paramView.previous();
      if ((localView instanceof OrderModeIconState))
        ((OrderModeIconState)localView).setOrderMoreModeSelected(false, false);
      ViewParent localViewParent = localView.getParent();
      Object localObject = this.mWorkspace.getShortCutBitmapByColorRect(localView, false, null);
      this.mDragLayer.getLocationInDragLayer(localView, this.mCoordinatesTemp);
      localObject = new ColorRectDragView(this.mLauncher, (Bitmap)localObject, localView.getScaleX());
      ((ColorRectDragView)localObject).setTag(localView);
      this.mDragLayer.addView((View)localObject);
      ((ColorRectDragView)localObject).move(this.mCoordinatesTemp[0], this.mCoordinatesTemp[1]);
      this.mDragViewList.add(localObject);
      DropTarget.DragObject localDragObject = new DropTarget.DragObject();
      localDragObject.dragComplete = false;
      localDragObject.dragInfo = localView.getTag();
      localDragObject.dragView = ((DragView)localObject);
      if ((localViewParent != null) && ((localViewParent instanceof DockBar)))
        localDragObject.dragSource = this.mLauncher.getDockBar();
      while (true)
      {
        ((ColorRectDragView)localObject).setTag(2131492864, localDragObject);
        break;
        if ((localView instanceof FolderItemView))
          localDragObject.dragSource = ((FolderItemView)localView).getFolder();
        else
          localDragObject.dragSource = this.mWorkspace;
      }
    }
    this.mHeadDragView = ((ColorRectDragView)this.mDragViewList.get(this.mDragViewList.size() - 1));
  }

  private void destroyViewsInDragLayer()
  {
    ListIterator localListIterator = this.mDragViewList.listIterator(this.mDragViewList.size());
    while (localListIterator.hasPrevious())
    {
      DragView localDragView = (DragView)localListIterator.previous();
      if ((localDragView != null) && (localDragView.getParent() != null))
      {
        this.mDragLayer.removeView(localDragView);
        localDragView.recycleBitmap();
      }
    }
    this.mWorkspace.onDragEnd();
    this.mHeadDragView = null;
  }

  private void doDropCompleted(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mDragViewList == null) || (this.mDragViewList.size() <= 0))
      Log.e("ColorRectManager", "doDropCompleted. mDragViewList is null !");
    while (true)
    {
      return;
      ListIterator localListIterator = this.mDragViewList.listIterator(this.mDragViewList.size());
      while (localListIterator.hasPrevious())
      {
        DropTarget.DragObject localDragObject = (DropTarget.DragObject)((ColorRectDragView)localListIterator.previous()).getTag(2131492864);
        DragSource localDragSource = localDragObject.dragSource;
        if (localDragSource != null)
          localDragSource.onDropCompleted(paramView, localDragObject, paramBoolean1, paramBoolean2);
      }
    }
  }

  private void doGobackWithAnim()
  {
    boolean bool;
    AnimatorSet localAnimatorSet;
    ArrayList localArrayList;
    int i;
    float f1;
    Iterator localIterator;
    if (!isOrderingFolderIcon())
    {
      bool = true;
      reNewBitmapForDrop(bool);
      localAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      i = 500;
      f1 = 1.0F;
      localIterator = this.mDragViewList.iterator();
    }
    while (true)
      if (localIterator.hasNext())
      {
        ColorRectDragView localColorRectDragView = (ColorRectDragView)localIterator.next();
        Object localObject1 = (View)localColorRectDragView.getTag();
        if (localObject1 == null)
        {
          Log.e("ColorRectManager", "goBackAnimation dropedView error !!!");
          continue;
          bool = false;
          break;
        }
        if (((View)((View)localObject1).getParent() == null) && (!(localObject1 instanceof FolderItemView)))
        {
          Log.e("ColorRectManager", "dropOnWorkSpace error itsParent == null view already be removed!");
          localColorRectDragView.setTag(null);
        }
        else
        {
          Object localObject2 = this.mWorkspace.getParentCellLayoutForView((View)localObject1);
          if (localObject2 != null)
            ((CellLayout)localObject2).markCellsAsOccupiedForView((View)localObject1);
          localObject2 = new Rect();
          Rect localRect = new Rect();
          localColorRectDragView.setSameDuration(false);
          localColorRectDragView.modifyDestination(null);
          float f2 = 1.0F;
          this.mDragLayer.getViewRectRelativeToSelf(localColorRectDragView, localRect);
          if (!(localObject1 instanceof FolderItemView))
            this.mDragLayer.getViewRectRelativeToSelf((View)localObject1, (Rect)localObject2);
          while (true)
          {
            Object localObject3 = computerAnimationOffSet((View)localObject1);
            ((Rect)localObject2).offset(localObject3[0], localObject3[1]);
            localObject1 = localColorRectDragView.animateView(localRect, (Rect)localObject2, f1, 1.0F, 1.0F, f2, f2, -1, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), new Runnable()
            {
              public void run()
              {
                this.val$orginView.setVisibility(0);
                if ((this.val$orginView instanceof FolderItemView))
                {
                  FolderItemView localFolderItemView = (FolderItemView)this.val$orginView;
                  localFolderItemView.getFolderIcon().addItem((ApplicationInfo)this.val$orginView.getTag());
                  localFolderItemView.setOrderMoreModeSelected(true, true);
                }
              }
            }
            , 0, null);
            i = localColorRectDragView.getMaxAnimationDuration(i);
            localArrayList.add(localObject1);
            break;
            Object localObject4 = (FolderItemView)localObject1;
            localObject3 = ((FolderItemView)localObject4).getFolderIcon();
            Folder localFolder = ((FolderItemView)localObject4).getFolder();
            int j = ((FolderIcon)localObject3).getOrderMoreCurrentDropIndex();
            f2 = ((FolderIcon)localObject3).getDropAnimatorRect((Rect)localObject2, localFolder.getItemCount() + j);
            ((Rect)localObject2).right = (((Rect)localObject2).left + localRect.width());
            ((Rect)localObject2).bottom = (((Rect)localObject2).right + localRect.height());
            localObject4 = ((FolderItemView)localObject4).getFolderIconOriginalPos();
            ((Rect)localObject2).offset(((Rect)localObject4).left, ((Rect)localObject4).top);
            ((Rect)localObject2).offset(-localRect.width() / 2, -localRect.height() / 2);
            ((FolderIcon)localObject3).setOrderMoreCurrentDropIndex(j + 1);
            f1 = 0.7F;
          }
        }
      }
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ColorRectManager.this.destroyViewsInDragLayer();
        ColorRectManager.this.resetOrderMoreState(ColorRectManager.this.isOrderingFolderIcon());
      }
    });
    localAnimatorSet.start();
    this.mColorRectTopBar.onChangeState(ColorRectTopBar.State.ORDER_MORE_SELECTED);
  }

  private void doGobackWithNoAnim()
  {
    Iterator localIterator = this.mDragViewList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ColorRectDragView)localIterator.next();
      View localView = (View)((ColorRectDragView)localObject).getTag();
      if (localView == null)
      {
        Log.e("ColorRectManager", "goBackAnimation dropedView error !!!");
      }
      else if (((View)localView.getParent() == null) && (!(localView instanceof FolderItemView)))
      {
        Log.e("ColorRectManager", "dropOnWorkSpace error itsParent == null view already be removed!");
        ((ColorRectDragView)localObject).setTag(null);
      }
      else
      {
        localObject = this.mWorkspace.getParentCellLayoutForView(localView);
        if (localObject != null)
          ((CellLayout)localObject).markCellsAsOccupiedForView(localView);
        localView.setVisibility(0);
        if ((localView instanceof FolderItemView))
          ((FolderItemView)localView).getFolderIcon().addItem((ApplicationInfo)localView.getTag());
        ((OrderModeIconState)localView).setOrderMoreModeSelected(true, true);
      }
    }
    destroyViewsInDragLayer();
    resetOrderMoreState(isOrderingFolderIcon());
    this.mColorRectTopBar.onChangeState(ColorRectTopBar.State.ORDER_MORE_SELECTED);
  }

  private boolean dropOnFolderIcon(final DropTarget.DragObject paramDragObject, final CellLayout paramCellLayout)
  {
    if (isOrderingFolderIcon())
      return false;
    Rect localRect1 = new Rect();
    paramDragObject = this.mWorkspace.createUserFolderInOrderMoreIfNecessary(paramDragObject, paramCellLayout, localRect1);
    if (paramDragObject == null)
    {
      Log.e("ColorRectManager", "dropOnFolderIcon. folderIcon is null.");
      goBackAnimation(true);
      return false;
    }
    if (paramDragObject.getLayerType() != 2)
      paramDragObject.setLayerType(2, null);
    paramDragObject.setOrderMoreCurrentDropIndex(0);
    Object localObject1 = this.mDragViewList.listIterator(this.mDragViewList.size());
    Object localObject4;
    while (((ListIterator)localObject1).hasPrevious())
    {
      localObject2 = (ColorRectDragView)((ListIterator)localObject1).previous();
      localObject3 = (View)((ColorRectDragView)localObject2).getTag();
      localObject4 = ((DropTarget.DragObject)((ColorRectDragView)localObject2).getTag(2131492864)).dragSource;
      if (localObject3 == null)
      {
        Log.e("ColorRectManager", "dropOnFolderIcon error !!!orginView == null");
      }
      else if (((View)((View)localObject3).getParent() == null) && (!(localObject3 instanceof FolderItemView)))
      {
        Log.e("ColorRectManager", "dropOnFolderIcon error itsParent == null view already be removed! " + localObject3);
        ((ColorRectDragView)localObject2).setTag(null);
      }
      else
      {
        if ((localObject4 != null) && ((localObject4 instanceof Workspace)))
        {
          localObject4 = this.mWorkspace.getParentCellLayoutForView((View)localObject3);
          if (localObject4 != null)
            ((ViewGroup)localObject4).removeView((View)localObject3);
        }
        while (true)
        {
          ((ColorRectDragView)localObject2).modifyDestination(null);
          break;
          if ((localObject4 != null) && ((localObject4 instanceof DockBar)))
          {
            localObject4 = (DockBar)((View)localObject3).getParent();
            if (localObject4 != null)
              ((DockBar)localObject4).removeView((View)localObject3);
          }
        }
      }
    }
    localObject1 = new AnimatorSet();
    Object localObject2 = new ArrayList();
    int i = 200;
    Object localObject3 = this.mDragViewList.listIterator(this.mDragViewList.size());
    while (((ListIterator)localObject3).hasPrevious())
    {
      localObject4 = (ColorRectDragView)((ListIterator)localObject3).previous();
      Object localObject5 = (View)((ColorRectDragView)localObject4).getTag();
      if (localObject5 == null)
      {
        Log.e("ColorRectManager", "dropOnFolderIcon dropedView error !!!");
      }
      else
      {
        Rect localRect2 = new Rect();
        Rect localRect3 = new Rect();
        ((ColorRectDragView)localObject4).setSameDuration(true);
        ((ColorRectDragView)localObject4).modifyDestination(null);
        this.mDragLayer.getViewRectRelativeToSelf((View)localObject4, localRect3);
        Object localObject6 = paramDragObject.getFolder();
        int j = paramDragObject.getOrderMoreCurrentDropIndex();
        float f = paramDragObject.getDropAnimatorRect(localRect2, ((Folder)localObject6).getItemCount() + j);
        localRect2.right = (localRect2.left + localRect3.width());
        localRect2.bottom = (localRect2.right + localRect3.height());
        localRect2.offset(localRect1.left, localRect1.top);
        localRect2.offset(-localRect3.width() / 2, -localRect3.height() / 2);
        paramDragObject.setOrderMoreCurrentDropIndex(j + 1);
        localObject6 = computerAnimationOffSet((View)localObject5);
        localRect2.offset(localObject6[0], localObject6[1]);
        localObject5 = ((ColorRectDragView)localObject4).animateView(localRect3, localRect2, 0.7F, 1.0F, 1.0F, f, f, -1, new DecelerateInterpolator(2.0F), new AccelerateInterpolator(2.0F), new Runnable()
        {
          public void run()
          {
            this.val$orginView.setVisibility(0);
            paramDragObject.addItem((ApplicationInfo)this.val$orginView.getTag());
          }
        }
        , 0, null);
        i = ((ColorRectDragView)localObject4).getMaxAnimationDuration(i);
        ((List)localObject2).add(localObject5);
      }
    }
    ((AnimatorSet)localObject1).playTogether((Collection)localObject2);
    ((AnimatorSet)localObject1).addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ColorRectManager.this.destroyViewsInDragLayer();
        ColorRectManager.this.doDropCompleted(ColorRectManager.this.mWorkspace, true, true);
        ColorRectManager.this.resetOrderMoreState(true);
        paramCellLayout.compactDisplayIcons(true);
      }
    });
    ((AnimatorSet)localObject1).start();
    return true;
  }

  private void dropOnWorkspace(CellLayout paramCellLayout, List<Point> paramList, boolean paramBoolean)
  {
    int i = 0;
    Object localObject1 = this.mDragViewList.listIterator(this.mDragViewList.size());
    Object localObject3;
    Object localObject4;
    while (((ListIterator)localObject1).hasPrevious())
    {
      localObject2 = (ColorRectDragView)((ListIterator)localObject1).previous();
      localObject3 = (View)((ColorRectDragView)localObject2).getTag();
      localObject4 = ((DropTarget.DragObject)((ColorRectDragView)localObject2).getTag(2131492864)).dragSource;
      if (localObject3 == null)
      {
        Log.e("ColorRectManager", "dropOnWorkSpace error !!!orginView == null");
      }
      else if (((View)((View)localObject3).getParent() == null) && (!(localObject3 instanceof FolderItemView)))
      {
        Log.e("ColorRectManager", "dropOnWorkSpace error itsParent == null view already be removed!");
        ((ColorRectDragView)localObject2).setTag(null);
      }
      else
      {
        if (localObject4 != null)
        {
          if (!(localObject4 instanceof Workspace))
            break label170;
          localObject4 = this.mWorkspace.getParentCellLayoutForView((View)localObject3);
          if (localObject4 != null)
            ((ViewGroup)localObject4).removeView((View)localObject3);
        }
        while (true)
        {
          ((ColorRectDragView)localObject2).modifyDestination(null);
          break;
          label170: if ((localObject4 instanceof DockBar))
          {
            localObject4 = (DockBar)((View)localObject3).getParent();
            if (localObject4 != null)
              ((DockBar)localObject4).removeView((View)localObject3);
          }
        }
      }
    }
    if (paramBoolean)
    {
      this.mWorkspace.persistentTmpReorder();
      localObject1 = this.mWorkspace.getTargetCells();
      paramList = (List<Point>)localObject1;
      if (((List)localObject1).size() < this.mDragViewList.size())
      {
        goBackAnimation(true);
        return;
      }
    }
    localObject1 = new ArrayList();
    boolean bool1 = false;
    Object localObject2 = this.mDragViewList.listIterator(this.mDragViewList.size());
    while (((ListIterator)localObject2).hasPrevious())
    {
      localObject3 = (ColorRectDragView)((ListIterator)localObject2).previous();
      localObject4 = (View)((ColorRectDragView)localObject3).getTag();
      Object localObject6 = (Point)paramList.get(i);
      DropTarget.DragObject localDragObject = (DropTarget.DragObject)((ColorRectDragView)localObject3).getTag(2131492864);
      if (localObject4 == null)
      {
        Log.e("ColorRectManager", "ondrop dropedView error 1!!!");
        ((ColorRectDragView)localObject3).setVisibility(8);
      }
      else
      {
        boolean bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (((ItemInfo)((View)localObject4).getTag()).screenId != paramCellLayout.getScreenId())
            bool2 = true;
        }
        Object localObject5 = this.mWorkspace;
        int j = ((Point)localObject6).x;
        int k = ((Point)localObject6).y;
        localObject6 = ((View)localObject4).getTag();
        localObject5 = ((Workspace)localObject5).onDropByColorRect(new int[] { j, k }, localObject6, paramCellLayout, true, localDragObject);
        if (localObject5 == null)
        {
          Log.e("ColorRectManager", "ondrop dropedView error 2!!!");
          bool1 = bool2;
        }
        else
        {
          if (((localObject5 instanceof FolderIcon)) && (((View)localObject5).getLayerType() != 2))
            ((View)localObject5).setLayerType(2, null);
          ((ArrayList)localObject1).add((ItemInfo)((View)localObject4).getTag());
          ((ColorRectDragView)localObject3).setTag(2131492865, localObject5);
          localObject3 = localDragObject.dragSource;
          if ((localObject3 != null) && ((localObject3 instanceof Workspace)))
            paramCellLayout.markCellsAsOccupiedForView((View)localObject5);
          if ((localObject5 instanceof OrderModeIconState))
            ((OrderModeIconState)localObject5).setOrderMoreModeSelected(false, false);
          i += 1;
          bool1 = bool2;
        }
      }
    }
    if ((((ArrayList)localObject1).size() > 0) && (this.mLauncher.getModel() != null))
      this.mLauncher.getModel().updateDatabaseRunnable(this.mLauncher, (ArrayList)localObject1, -100L, paramCellLayout.getScreenId(), LauncherModel.UpdateDatabaseMode.UPDATE, false, null);
    if (paramBoolean)
      animationToWorkSpace();
    LauncherStatistics.getInstance(this.mLauncher).launcherStatisticsDropPageOnColorRect(bool1);
  }

  private void exitOrderOneModeToNormal(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mWorkspace.startWorkspaceViewTranslationY(PagedView.State.ORDER_ONE, false, paramBoolean2);
    this.mWorkspace.changeStateToSmall(PagedView.State.NORMAL, paramBoolean2, 0);
    show(paramBoolean1, paramBoolean2);
  }

  private void reNewBitmapForDrop(boolean paramBoolean)
  {
    Iterator localIterator = this.mDragViewList.iterator();
    while (localIterator.hasNext())
    {
      ColorRectDragView localColorRectDragView = (ColorRectDragView)localIterator.next();
      View localView = (View)localColorRectDragView.getTag();
      if (localView == null)
      {
        Log.e("ColorRectManager", "reNewBitmapForDrop dropedView error !!!");
      }
      else
      {
        if ((localView instanceof OrderModeIconState))
          ((OrderModeIconState)localView).setOrderMoreModeSelected(paramBoolean, false);
        this.mWorkspace.getShortCutBitmapByColorRect(localView, true, localColorRectDragView.getBitmap());
      }
    }
  }

  private void showOrderMoreMode(final boolean paramBoolean)
  {
    if (this.mColorRectVAnimator != null)
    {
      this.mColorRectVAnimator.cancel();
      this.mColorRectIconVAnimator = null;
    }
    if (this.mColorRectIconVAnimator != null)
    {
      this.mColorRectIconVAnimator.cancel();
      this.mColorRectIconVAnimator = null;
    }
    this.mColorRectVAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(this.mTopbarAniDuration);
    this.mColorRectVAnimator.setInterpolator(new DecelerateInterpolator());
    this.mColorRectIconVAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(this.mIconAlphaAniDuration);
    this.mColorRectIconVAnimator.setInterpolator(new LinearInterpolator());
    Object localObject2 = this.mColorRectTopBar.getEnterView();
    Object localObject3 = this.mColorRectTopBar.getBackToOrderOneImgButton();
    final View localView = this.mColorRectTopBar.getSelectInfoView();
    final TextView localTextView = this.mColorRectTopBar.getHintTextView();
    final int i = this.mColorRectTopBar.getHeight();
    final int j = ((View)localObject3).getWidth();
    Object localObject1 = this.mWorkspace.getOpenFolder();
    final DragController localDragController = this.mLauncher.getDragController();
    if (localDragController == null)
    {
      Log.e("ColorRectManager", "dragController is null");
      return;
    }
    this.mColorRectPreview.refreshPreviewPage(-1);
    this.mColorRectTopBar.reset();
    LauncherAnimatorUpdateListener local4 = new LauncherAnimatorUpdateListener()
    {
      public void onAnimationUpdate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (paramBoolean)
        {
          this.val$enterView.setTranslationY(i * paramAnonymousFloat2);
          if (paramAnonymousFloat2 <= 0.7F)
            this.val$enterView.setAlpha(1.0F - paramAnonymousFloat2 / 0.7F);
          this.val$backToOrderOneImgButton.setTranslationX(-paramAnonymousFloat1 * j);
          localTextView.setTranslationY(-paramAnonymousFloat1 * i);
          return;
        }
        this.val$enterView.setTranslationY(i * paramAnonymousFloat1);
        if (paramAnonymousFloat1 <= 0.7F)
          this.val$enterView.setAlpha((0.7F - paramAnonymousFloat1) / 0.7F);
        this.val$backToOrderOneImgButton.setTranslationX(-paramAnonymousFloat2 * j);
        if (localTextView.getTranslationY() <= 0.0F)
        {
          localTextView.setTranslationY(-paramAnonymousFloat2 * i);
          return;
        }
        localView.setTranslationY(-paramAnonymousFloat2 * i);
      }
    };
    localObject2 = new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (paramBoolean)
        {
          this.val$enterView.setTranslationY(i);
          this.val$enterView.setAlpha(0.0F);
          this.val$backToOrderOneImgButton.setTranslationX(0.0F);
          localTextView.setTranslationY(0.0F);
          ColorRectManager.this.clearSelectedViews();
          localDragController.addDropTarget(ColorRectManager.this.mColorRectTopBar);
          return;
        }
        this.val$enterView.setTranslationY(0.0F);
        this.val$enterView.setAlpha(1.0F);
        this.val$backToOrderOneImgButton.setTranslationX(-j);
        localDragController.removeDropTarget(ColorRectManager.this.mColorRectTopBar);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (paramBoolean)
        {
          this.val$enterView.setTranslationY(0.0F);
          this.val$enterView.setAlpha(1.0F);
          this.val$backToOrderOneImgButton.setTranslationX(-j);
          localTextView.setTranslationY(-i);
          localView.setTranslationY(-i);
          this.val$enterView.setVisibility(0);
          this.val$backToOrderOneImgButton.setVisibility(0);
          localTextView.setVisibility(0);
          localView.setVisibility(0);
          return;
        }
        this.val$enterView.setTranslationY(i);
        this.val$enterView.setAlpha(0.0F);
        this.val$backToOrderOneImgButton.setTranslationX(0.0F);
      }
    };
    localObject3 = new LauncherAnimatorUpdateListener()
    {
      public void onAnimationUpdate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (paramBoolean);
        for (paramAnonymousFloat1 = paramAnonymousFloat1 * 0.3F + 0.7F; ; paramAnonymousFloat1 = paramAnonymousFloat2 * 0.3F + 0.7F)
        {
          ColorRectManager.this.mWorkspace.setChildViewAlpha(paramAnonymousFloat1, true, true);
          ColorRectManager.this.mLauncher.getDockBar().setChildViewAlpha(paramAnonymousFloat1, true);
          if (this.val$openFolder != null)
            this.val$openFolder.setChildViewAlpha(paramAnonymousFloat1, true);
          return;
        }
      }
    };
    localObject1 = new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (paramBoolean)
        {
          ColorRectManager.this.mWorkspace.setChildViewAlpha(0.7F, false, true);
          ColorRectManager.this.mLauncher.getDockBar().setChildViewAlpha(0.7F, true);
          if (this.val$openFolder != null)
            this.val$openFolder.setChildViewAlpha(0.7F, true);
        }
        do
        {
          return;
          ColorRectManager.this.mWorkspace.setChildViewAlpha(1.0F, false, false);
          ColorRectManager.this.mLauncher.getDockBar().setChildViewAlpha(1.0F, false);
        }
        while (this.val$openFolder == null);
        this.val$openFolder.setChildViewAlpha(1.0F, false);
      }
    };
    this.mColorRectVAnimator.addUpdateListener(local4);
    this.mColorRectVAnimator.addListener((AnimatorListener)localObject2);
    this.mColorRectVAnimator.start();
    this.mColorRectIconVAnimator.addUpdateListener((AnimatorUpdateListener)localObject3);
    this.mColorRectIconVAnimator.addListener((AnimatorListener)localObject1);
    this.mColorRectIconVAnimator.start();
  }

  private void startWorkspaceViewTranslationY(final boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mWorkspaceViewAnimator != null)
    {
      this.mWorkspaceViewAnimator.cancel();
      this.mWorkspaceViewAnimator = null;
    }
    int i = this.mLauncher.getResources().getInteger(2131296260);
    this.workspaceTranslation = getWorkspaceTranslation();
    if (!paramBoolean2)
    {
      if (this.mWorkspace == null)
        return;
      if (paramBoolean1)
      {
        this.mWorkspace.setTranslationY(-this.workspaceTranslation);
        return;
      }
      this.mWorkspace.setTranslationY(0.0F);
      return;
    }
    this.mWorkspaceViewAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(i);
    this.mWorkspaceViewAnimator.setInterpolator(this.mZoomInInterpolator);
    this.mWorkspaceViewAnimator.addUpdateListener(new LauncherAnimatorUpdateListener()
    {
      public void onAnimationUpdate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (paramAnonymousFloat2 == 0.0F);
        while (ColorRectManager.this.mWorkspace == null)
          return;
        if (paramBoolean1)
        {
          ColorRectManager.this.mWorkspace.setTranslationY(-ColorRectManager.this.workspaceTranslation * paramAnonymousFloat2);
          return;
        }
        ColorRectManager.this.mWorkspace.setTranslationY(-ColorRectManager.this.workspaceTranslation * (1.0F - paramAnonymousFloat2));
      }
    });
    this.mWorkspaceViewAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        if (ColorRectManager.this.mWorkspace == null)
          return;
        if (paramBoolean1)
        {
          ColorRectManager.this.mWorkspace.setTranslationY(-ColorRectManager.this.workspaceTranslation);
          return;
        }
        ColorRectManager.this.mWorkspace.setTranslationY(0.0F);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (ColorRectManager.this.mWorkspace == null)
          return;
        if (paramBoolean1)
        {
          ColorRectManager.this.mWorkspace.setTranslationY(-ColorRectManager.this.workspaceTranslation);
          return;
        }
        ColorRectManager.this.mWorkspace.setTranslationY(0.0F);
      }
    });
    this.mWorkspaceViewAnimator.start();
  }

  public boolean acceptDrop(DropTarget paramDropTarget, DropTarget.DragObject paramDragObject)
  {
    if ((paramDropTarget instanceof Workspace))
    {
      boolean bool = this.mWorkspace.onAcceptDropOnOrderMoreMode(paramDragObject);
      if (!bool)
        Toast.makeText(this.mLauncher, 2131427377, 0).show();
      return bool;
    }
    if ((paramDropTarget instanceof DockBar))
      return false;
    if ((paramDropTarget instanceof ColorRectPreview))
    {
      paramDropTarget = ((ColorRectPreview)paramDropTarget).getTagetColorRect();
      if (paramDropTarget != null)
      {
        LauncherStatistics.getInstance(this.mLauncher).onEvent("drop_on_preview_card_when_order_more");
        if (paramDropTarget.getCellLayout().getEmptyCells().size() < this.mDragViewList.size())
        {
          Toast.makeText(this.mLauncher, 2131427377, 0).show();
          return false;
        }
        return true;
      }
      return false;
    }
    return false;
  }

  public boolean checkSelectedComponent(ComponentName paramComponentName)
  {
    if (paramComponentName == null);
    Object localObject;
    do
    {
      Log.i("ColorRectManager", "checkSelectedComponent. The componentName is null.");
      do
      {
        Iterator localIterator;
        do
        {
          return false;
          if ((this.mSelectedViews == null) || (this.mSelectedViews.size() <= 0))
          {
            Log.i("ColorRectManager", "checkSelectedComponent. The mSelectViewList is empty.");
            return false;
          }
          paramComponentName = paramComponentName.getPackageName();
          localIterator = this.mSelectedViews.iterator();
        }
        while (!localIterator.hasNext());
        localObject = (ApplicationInfo)((View)localIterator.next()).getTag();
      }
      while (localObject == null);
      localObject = ((ApplicationInfo)localObject).intent.getComponent();
    }
    while ((localObject == null) || (!((ComponentName)localObject).getPackageName().equals(paramComponentName)));
    return true;
  }

  public void checkTopbarSelectedText(View paramView)
  {
    if ((!this.mWorkspace.isOrderMoreMode()) || (this.mState == 4096))
      Log.d("ColorRectManager", "checkTopbarSelectedText return. mState = " + this.mState);
    List localList;
    do
    {
      return;
      localList = getSelectedViews();
    }
    while ((localList == null) || (!localList.contains(paramView)));
    localList.remove(paramView);
    if ((paramView instanceof FolderItemView))
      ((FolderItemView)paramView).getFolderIcon().setOrderMoreModeSelected(false, false, false);
    this.mColorRectTopBar.showSelectedText(false);
  }

  public void clearSelectedViews()
  {
    if (this.mSelectedViews != null)
    {
      Iterator localIterator = this.mSelectedViews.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView instanceof OrderModeIconState))
          ((OrderModeIconState)localView).setOrderMoreModeSelected(false, true);
      }
      this.mSelectedViews.clear();
    }
    int j = this.mWorkspace.getChildCount();
    int i = 0;
    while (i < j)
    {
      ((CellLayout)this.mWorkspace.getChildAt(i)).mIconCountSelectedInOrderMore = 0;
      i += 1;
    }
  }

  public boolean comeHere(View paramView)
  {
    boolean bool1 = false;
    while (true)
    {
      Object localObject1;
      try
      {
        localObject1 = paramView.getParent();
        if (localObject1 != null)
        {
          boolean bool2 = localObject1 instanceof DockBar;
          if (bool2)
            return bool1;
        }
        localObject1 = new HashSet();
        if (!comeHereAnimation(paramView))
          continue;
        paramView = this.mSelectedViews.iterator();
        if (paramView.hasNext())
        {
          Object localObject2 = (View)paramView.next();
          if (!(localObject2 instanceof FolderItemView))
            continue;
          Object localObject3 = (FolderItemView)localObject2;
          localObject2 = ((FolderItemView)localObject3).getFolder();
          localObject3 = ((FolderItemView)localObject3).getTag();
          if (!(localObject3 instanceof ApplicationInfo))
            continue;
          ((Folder)localObject2).getInfo().remove((ApplicationInfo)localObject3);
          ((Set)localObject1).add((FolderIcon)((Folder)localObject2).getFolderIcon());
          continue;
        }
      }
      finally
      {
      }
      paramView = ((Set)localObject1).iterator();
      while (paramView.hasNext())
        ((FolderIcon)paramView.next()).setOrderMoreModeSelected(false, false, true);
      if ((this.mDragWithFolder != null) && (this.mDragWithFolder.getItemCount() > 0))
        this.mLauncher.closeFolder(this.mDragWithFolder);
      bool1 = true;
    }
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mWorkspace.isOrderMoreMode());
    do
    {
      while ((this.mState != 4096) && (this.mState != 8192))
      {
        return false;
        this.mMotionX = ((int)paramMotionEvent.getX());
        this.mMotionY = ((int)paramMotionEvent.getY());
        switch (paramMotionEvent.getAction())
        {
        case 0:
        case 2:
        default:
        case 1:
        case 3:
        }
      }
      return this.mTailanimation.onTouchEvent(paramMotionEvent);
    }
    while (this.mState != 4096);
    goBackAnimation(true);
    return false;
  }

  public boolean enterOrderMoreMode(boolean paramBoolean)
  {
    return enterOrderMoreMode(paramBoolean, true, false);
  }

  public boolean enterOrderMoreMode(final boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    PagedView.State localState = this.mWorkspace.getOrderMode();
    if ((this.mColorRectVAnimator != null) && (this.mColorRectVAnimator.isRunning()))
      return false;
    final Folder localFolder = this.mWorkspace.getOpenFolder();
    if (paramBoolean1)
    {
      if (localState != PagedView.State.ORDER_ONE)
      {
        Log.e("ColorRectManager", "enterOderMoreMode do nothing ---- state is not Workspace.State.ORDER_ONE");
        return false;
      }
      this.mWorkspace.setOrderMode(PagedView.State.ORDER_MORE);
      if (localFolder != null)
        localFolder.onOrderMoreModeChanged(true);
      this.mWorkspace.stopShakeAnimations(true);
      this.mDelIconAnim.initAnimParam(false, new Runnable()
      {
        public void run()
        {
          ColorRectManager.this.showOrderMoreMode(paramBoolean1);
        }
      });
      this.mState = 0;
      LauncherApplication.setLongPressTimeout(300);
      return true;
    }
    if (localState != PagedView.State.ORDER_MORE)
    {
      Log.e("ColorRectManager", "enterOderMoreMode do nothing ---- state is not Workspace.State.ORDER_MORE");
      return false;
    }
    clearSelectedViews();
    if (!paramBoolean3)
    {
      this.mWorkspace.setOrderMode(PagedView.State.ORDER_ONE);
      this.mDelIconAnim.initAnimParam(true, new Runnable()
      {
        public void run()
        {
          ColorRectManager.this.showOrderMoreMode(paramBoolean1);
          ColorRectManager.this.mWorkspace.beginShakeAnimations(true);
          if (localFolder != null)
            localFolder.onOrderMoreModeChanged(false);
          ColorRectManager.access$202(ColorRectManager.this, 0);
        }
      });
    }
    while (true)
    {
      Utilities.onExitOrderMoreMode();
      break;
      enterOrderOneMode(false);
    }
  }

  public boolean enterOrderOneMode(boolean paramBoolean)
  {
    return enterOrderOneMode(paramBoolean, false, true);
  }

  public boolean enterOrderOneMode(final boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    if ((!this.mLauncher.getModel().isLoadTaskFinished()) && (!paramBoolean2))
      return false;
    if ((this.mColorRectVAnimator != null) && (this.mColorRectVAnimator.isRunning()) && (!paramBoolean2))
      return false;
    PagedView.State localState = this.mWorkspace.getOrderMode();
    if (paramBoolean1)
    {
      if (localState == PagedView.State.ORDER_ONE)
      {
        Log.e("ColorRectManager", "  do nothing ---- same state of Workspace.State.ORDER_ONE");
        return false;
      }
      this.mColorRectTopBar.getEnterView().setClickable(true);
      this.mColorRectTopBar.onChangeState(ColorRectTopBar.State.ORDER_ONE);
      show(paramBoolean1, paramBoolean3);
      LauncherApplication.setLongPressTimeout(100);
      this.mWorkspace.setOrderMode(PagedView.State.ORDER_ONE);
      this.mWorkspace.startWorkspaceViewTranslationY(PagedView.State.ORDER_ONE, true, true);
      this.mWorkspace.changeStateToSmall(PagedView.State.ORDER_ONE, paramBoolean3, 0);
      this.mColorRectPreview.setLock(true);
      this.mColorRectPreview.refresh();
      this.mColorRectPreview.updatePage();
      return true;
    }
    if (localState == PagedView.State.NORMAL)
    {
      Log.e("ColorRectManager", "  do nothing ----   same state of Workspace.State.NORMAL");
      return false;
    }
    this.mColorRectTopBar.getEnterView().setClickable(false);
    this.mColorRectPreview.setLock(true);
    this.mWorkspace.endTidyUp(false);
    this.mWorkspace.setOrderMode(PagedView.State.NORMAL);
    this.mWorkspace.clearAppWidgetAnimation();
    if (!paramBoolean3)
    {
      exitOrderOneModeToNormal(paramBoolean1, paramBoolean3);
      this.mDelIconAnim.initAnimParam(false);
      return true;
    }
    this.mDelIconAnim.initAnimParam(false, new Runnable()
    {
      public void run()
      {
        ColorRectManager.this.exitOrderOneModeToNormal(paramBoolean1, paramBoolean3);
      }
    });
    return true;
  }

  public int getDragViewCount()
  {
    if (this.mDragViewList != null)
      return this.mDragViewList.size();
    return 0;
  }

  public List<ColorRectDragView> getDragViewList()
  {
    return this.mDragViewList;
  }

  public ColorRectPreview getPreview()
  {
    return this.mColorRectPreview;
  }

  public List<View> getSelectedViews()
  {
    return this.mSelectedViews;
  }

  public int getState()
  {
    return this.mState;
  }

  public ColorRectTopBar getTopBar()
  {
    return this.mColorRectTopBar;
  }

  public int getTopBarHeight()
  {
    if (this.mColorRectTopBar == null)
      return 0;
    return this.mColorRectTopBar.getHeight();
  }

  public int getWorkspaceTranslation()
  {
    return (int)(this.mLauncher.getDragLayerHeight() * 0.041F);
  }

  public void goBackAnimation(final boolean paramBoolean)
  {
    if (this.mState == 0)
      Log.e("ColorRectManager", "goBackAnimation  error state return");
    while (true)
    {
      return;
      if ((this.mDragWithFolder != null) && (this.mDragWithFolder.folderIsAnimating()))
      {
        this.mDragWithFolder.setDeferredAction(new Runnable()
        {
          public void run()
          {
            if (ColorRectManager.this.mDragWithFolder != null)
              ColorRectManager.this.mDragWithFolder.setDeferredAction(null);
            ColorRectManager.this.goBackAnimation(paramBoolean);
          }
        });
        return;
      }
      if ((this.mHelpAnim != null) && (this.mHelpAnim.isRunning()))
        this.mHelpAnim.cancel();
      this.mTailanimation.endTail(true);
      Object localObject1 = new HashSet();
      Object localObject2 = this.mSelectedViews.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (View)((Iterator)localObject2).next();
        if ((localObject3 instanceof FolderItemView))
        {
          Folder localFolder = ((FolderItemView)localObject3).getFolder();
          if ((localFolder != null) && ((((View)localObject3).getTag() instanceof ApplicationInfo)))
            ((Set)localObject1).add(localFolder);
        }
      }
      if (((Set)localObject1).size() > 0)
      {
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Folder)((Iterator)localObject1).next();
          localObject3 = (FolderIcon)((Folder)localObject2).getFolderIcon();
          ((FolderIcon)localObject3).setOrderMoreCurrentDropIndex(0);
          checkFolderIcon((FolderIcon)localObject3);
          ((Folder)localObject2).onOrderMoreGoBack();
        }
      }
      if (paramBoolean)
        doGobackWithAnim();
      while (this.mWorkspace != null)
      {
        this.mWorkspace.clearDragInfo();
        return;
        doGobackWithNoAnim();
      }
    }
  }

  public void hideTopBar()
  {
    if (this.mColorRectTopBar != null)
      this.mColorRectTopBar.hide();
  }

  public boolean isAnimating()
  {
    return ((this.mColorRectVAnimator != null) && (this.mColorRectVAnimator.isRunning())) || ((this.mColorRectIconVAnimator != null) && (this.mColorRectIconVAnimator.isRunning()));
  }

  public boolean isInSelectedState()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mSelectedViews != null)
    {
      bool1 = bool2;
      if (this.mSelectedViews.size() > 0)
        bool1 = true;
    }
    return bool1;
  }

  public boolean isInitState()
  {
    return this.mState == 0;
  }

  public boolean isOrderingFolderIcon()
  {
    return (this.mSelectedViews != null) && (this.mSelectedViews.size() == 1) && ((this.mSelectedViews.get(0) instanceof FolderIcon));
  }

  public boolean isTopBarVisible()
  {
    if (this.mColorRectTopBar == null);
    while (this.mColorRectTopBar.getVisibility() != 0)
      return false;
    return true;
  }

  public boolean isViewSelected(View paramView)
  {
    if (this.mSelectedViews == null)
      return false;
    return this.mSelectedViews.contains(paramView);
  }

  public void onDrop(DropTarget paramDropTarget, DropTarget.DragObject paramDragObject)
  {
    this.mTailanimation.endTail(true);
    Object localObject1 = this.mWorkspace.getCurrentDropLayout();
    int j;
    int i;
    if ((paramDropTarget instanceof Workspace))
    {
      paramDropTarget = this.mWorkspace.getTargetCells();
      if ((this.mWorkspace.willCreateUserFolderOnDrop()) || (this.mWorkspace.willAddToExistingFolderOnDrop()))
      {
        dropOnFolderIcon(paramDragObject, (CellLayout)localObject1);
        paramDragObject = (DropTarget.DragObject)localObject1;
        j = this.mWorkspace.getChildCount();
        paramDropTarget = this.mWorkspace.getCurrentDropLayout();
        i = 0;
        label80: if (i >= j)
          break label679;
        localObject1 = (CellLayout)this.mWorkspace.getChildAt(i);
        if ((((CellLayout)localObject1).mIconCountSelectedInOrderMore > 0) && (localObject1 != paramDragObject))
          if (localObject1 != paramDropTarget)
            break label673;
      }
    }
    label673: for (boolean bool = true; ; bool = false)
    {
      ((CellLayout)localObject1).compactDisplayIcons(bool);
      ((CellLayout)localObject1).mIconCountSelectedInOrderMore = 0;
      i += 1;
      break label80;
      dropOnWorkspace((CellLayout)localObject1, paramDropTarget, true);
      paramDragObject = (DropTarget.DragObject)localObject1;
      break;
      DockBar localDockBar;
      if ((paramDropTarget instanceof DockBar))
      {
        localDockBar = (DockBar)paramDropTarget;
        if (4 - localDockBar.getVisibleChildCount() >= this.mDragViewList.size());
      }
      do
      {
        return;
        i = 0;
        j = localDockBar.getPosInDock(paramDragObject.x, paramDragObject.y, paramDragObject.xOffset, paramDragObject.yOffset);
        paramDragObject = this.mDragViewList.listIterator(this.mDragViewList.size());
        View localView;
        Object localObject2;
        while (paramDragObject.hasPrevious())
        {
          Object localObject3 = (ColorRectDragView)paramDragObject.previous();
          localView = (View)((ColorRectDragView)localObject3).getTag();
          localObject2 = (DropTarget.DragObject)((ColorRectDragView)localObject3).getTag(2131492864);
          DragSource localDragSource = ((DropTarget.DragObject)localObject2).dragSource;
          if (localView == null)
          {
            Log.e("ColorRectManager", "ondrop dropedView error !!!");
          }
          else if (((View)localView.getParent() == null) && (!(localView instanceof FolderItemView)))
          {
            Log.e("ColorRectManager", "ondrop error itsParent == null view already be removed!");
            ((ColorRectDragView)localObject3).setTag(null);
          }
          else if ((localDragSource != null) && ((localDragSource instanceof Workspace)))
          {
            localDragSource.onDropCompleted((View)paramDropTarget, (DropTarget.DragObject)localObject2, true, true);
            localObject2 = this.mWorkspace.getParentCellLayoutForView(localView);
            if (localObject2 != null)
              ((ViewGroup)localObject2).removeView(localView);
          }
          else if ((localDragSource != null) && ((localDragSource instanceof DockBar)))
          {
            localObject3 = (DockBar)localView.getParent();
            if (localObject3 != null)
              ((DockBar)localObject3).removeView(localView);
            localDragSource.onDropCompleted((View)paramDropTarget, (DropTarget.DragObject)localObject2, true, true);
          }
        }
        paramDropTarget = this.mDragViewList.listIterator(this.mDragViewList.size());
        while (paramDropTarget.hasPrevious())
        {
          paramDragObject = (ColorRectDragView)paramDropTarget.previous();
          localView = (View)paramDragObject.getTag();
          localObject2 = (DropTarget.DragObject)paramDragObject.getTag(2131492864);
          if (localView == null)
          {
            Log.e("ColorRectManager", "ondrop dropedView error 1!!!");
            paramDragObject.setVisibility(8);
          }
          else
          {
            localView = localDockBar.addViewInPos(((DropTarget.DragObject)localObject2).dragInfo, j + i);
            if (localView == null)
            {
              Log.e("ColorRectManager", "ondrop dropedView error 2!!!");
            }
            else
            {
              localView.setVisibility(8);
              paramDragObject.setTag(2131492865, localView);
              paramDragObject.modifyDestination(null);
              if ((localView instanceof OrderModeIconState))
                ((OrderModeIconState)localView).setOrderMoreModeSelected(false, false);
              i += 1;
            }
          }
        }
        localDockBar.clear();
        localDockBar.requestLayout();
        animationToDockbar();
        paramDragObject = (DropTarget.DragObject)localObject1;
        break;
        paramDragObject = (DropTarget.DragObject)localObject1;
        if (!(paramDropTarget instanceof ColorRectPreview))
          break;
        paramDropTarget = ((ColorRectPreview)paramDropTarget).getTagetColorRect();
      }
      while (paramDropTarget == null);
      paramDragObject = paramDropTarget.getCellLayout();
      localObject1 = paramDragObject.getEmptyCells();
      dropOnWorkspace(paramDragObject, (List)localObject1, false);
      animationToColorRect(paramDropTarget, (List)localObject1);
      break;
    }
    label679: this.mColorRectTopBar.onChangeState(ColorRectTopBar.State.ORDER_MORE_SELECTED);
  }

  public void onExitOrderMoreModeToNormal()
  {
    int i = this.mColorRectTopBar.getHeight();
    View localView1 = this.mColorRectTopBar.getEnterView();
    ImageButton localImageButton = this.mColorRectTopBar.getBackToOrderOneImgButton();
    TextView localTextView = this.mColorRectTopBar.getHintTextView();
    View localView2 = this.mColorRectTopBar.getSelectInfoView();
    localView1.setTranslationY(0.0F);
    localView1.setAlpha(1.0F);
    localImageButton.setTranslationX(-localImageButton.getWidth());
    localView2.setTranslationY(-i);
    localTextView.setTranslationY(-i);
    localTextView.setVisibility(4);
    clearSelectedViews();
    this.mWorkspace.setChildViewAlpha(1.0F, false, false);
    this.mLauncher.getDockBar().setChildViewAlpha(1.0F, false);
    this.mWorkspace.destroySensorDetector();
    this.mWorkspace.removeNullScreen(true);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mState == 4096;
  }

  public void resetOrderMoreState(boolean paramBoolean)
  {
    this.mState = 0;
    if (!paramBoolean)
    {
      this.mDragViewList.clear();
      if (this.mSelectedViews == null);
    }
    do
    {
      return;
      this.mHeadDragView = null;
      clearSelectedViews();
      this.mColorRectTopBar.showSelectedText(false);
      this.mDragViewList.clear();
    }
    while (this.mDragWithFolder == null);
    this.mDragWithFolder.setDeferredAction(null);
    this.mDragWithFolder = null;
  }

  public void selectView(View paramView)
  {
    if (isAnimating());
    do
    {
      do
      {
        return;
        if ((paramView instanceof FolderItemView))
          ((FolderItemView)paramView).initPositionForOrderMore();
        localObject = paramView.getParent();
      }
      while ((paramView != null) && ((localObject instanceof DockBar)));
      if (this.mState != 0)
        break;
    }
    while (!(paramView instanceof OrderModeIconState));
    boolean bool = false;
    Object localObject = (CellLayout)this.mWorkspace.getChildAt(this.mWorkspace.getCurrentPage());
    if (this.mSelectedViews.contains(paramView))
    {
      this.mSelectedViews.remove(paramView);
      this.mColorRectTopBar.showSelectedText(false);
    }
    for (((CellLayout)localObject).mIconCountSelectedInOrderMore -= 1; ; ((CellLayout)localObject).mIconCountSelectedInOrderMore += 1)
    {
      ((OrderModeIconState)paramView).setOrderMoreModeSelected(bool, true);
      int i = this.mColorRectPreview.getCurrentPage();
      if ((i < 0) || (i >= this.mColorRectPreview.getChildCount()))
        break;
      this.mColorRectPreview.getChildAt(i).invalidate();
      return;
      if (this.mSelectedViews.size() >= MAX_SELECT_COUNT)
      {
        Toast.makeText(this.mLauncher, this.mSelectedFullToastText, 0).show();
        return;
      }
      bool = true;
      this.mSelectedViews.add(paramView);
      this.mColorRectTopBar.showSelectedText(true);
    }
    Log.e("ColorRectManager", "selectView  error state");
  }

  public void show(boolean paramBoolean)
  {
    show(paramBoolean, true);
  }

  public void show(final boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (this.mColorRectPreview.getVisibility() == 0)
    {
      bool = true;
      if (paramBoolean1 != bool)
        break label26;
    }
    label26: 
    while (this.mWorkspace == null)
    {
      return;
      bool = false;
      break;
    }
    if (this.mColorRectVAnimator != null)
    {
      this.mColorRectVAnimator.cancel();
      this.mColorRectVAnimator = null;
    }
    Object localObject1 = this.mLauncher.getDockBar();
    if (localObject1 == null)
    {
      Log.e("ColorRectManager", "dockbar is null");
      return;
    }
    Object localObject2 = this.mLauncher.getDragController();
    if (localObject2 == null)
    {
      Log.e("ColorRectManager", "dragController is null");
      return;
    }
    final PagePointView localPagePointView = this.mLauncher.getPagePointView();
    if (localPagePointView == null)
    {
      Log.e("ColorRectManager", "pagePointView is null");
      return;
    }
    final Folder localFolder = this.mWorkspace.getOpenFolder();
    if (!Utilities.mHasNavigationBar)
    {
      ((DockBar)localObject1).bringToFront();
      if (localFolder != null)
      {
        this.mLauncher.getFolderBlurBg().bringToFront();
        localFolder.bringToFront();
      }
      this.mLauncher.bringDragViewToFront();
    }
    Resources localResources = this.mLauncher.getResources();
    final int j = localResources.getInteger(2131296260);
    final int i;
    final float f;
    if (Utilities.mHasNavigationBar)
    {
      i = (int)(localResources.getDimensionPixelSize(2131361898) * localResources.getInteger(2131296293) / 100.0F);
      localResources.getDimensionPixelSize(2131361897);
      f = localResources.getInteger(2131296261) / 100.0F;
      if (!paramBoolean1)
        break label392;
      ((DragController)localObject2).addDropTarget(this.mColorRectPreview);
      ((DragController)localObject2).addDragScroller(this.mColorRectPreview);
    }
    while (true)
    {
      this.mColorRectVAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(j);
      this.mColorRectVAnimator.setInterpolator(this.mZoomInInterpolator);
      j = this.mColorRectTopBar.getHeight();
      localObject2 = new LauncherAnimatorUpdateListener()
      {
        public void onAnimationUpdate(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          if (this.val$dockbar != null)
          {
            if (paramBoolean1)
            {
              ColorRectManager.this.mColorRectPreview.setScaleX(paramAnonymousFloat2);
              ColorRectManager.this.mColorRectPreview.setScaleY(paramAnonymousFloat2);
              ColorRectManager.this.mColorRectTopBar.setTranslationY(-paramAnonymousFloat1 * j);
              this.val$dockbar.setTranslationY(i * paramAnonymousFloat2);
              this.val$dockbar.setScaleX(f + (1.0F - f) * paramAnonymousFloat1);
              this.val$dockbar.setScaleY(f + (1.0F - f) * paramAnonymousFloat1);
              localPagePointView.setScaleX(0.6F * paramAnonymousFloat2 + 1.0F);
              localPagePointView.setScaleY(0.6F * paramAnonymousFloat2 + 1.0F);
            }
          }
          else
            return;
          ColorRectManager.this.mColorRectPreview.setScaleX(paramAnonymousFloat1);
          ColorRectManager.this.mColorRectPreview.setScaleY(paramAnonymousFloat1);
          ColorRectManager.this.mColorRectTopBar.setTranslationY(-paramAnonymousFloat2 * j);
          this.val$dockbar.setTranslationY(i * paramAnonymousFloat1);
          this.val$dockbar.setScaleX(f + (1.0F - f) * paramAnonymousFloat2);
          this.val$dockbar.setScaleY(f + (1.0F - f) * paramAnonymousFloat2);
          localPagePointView.setScaleX(0.6F * paramAnonymousFloat1 + 1.0F);
          localPagePointView.setScaleY(0.6F * paramAnonymousFloat1 + 1.0F);
        }
      };
      localObject1 = new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          ColorRectManager.this.mColorRectPreview.setLayerType(0, null);
          ColorRectManager.this.mColorRectPreview.setLock(false);
          if ((ColorRectManager.this.mWorkspace != null) && (this.val$dockbar != null))
          {
            if (paramBoolean1)
            {
              ColorRectManager.this.mColorRectPreview.setScaleX(1.0F);
              ColorRectManager.this.mColorRectPreview.setScaleY(1.0F);
              this.val$dockbar.onTextVisible(false);
              ColorRectManager.this.mColorRectPreview.updateArrow(true);
              ColorRectManager.this.mColorRectTopBar.setTranslationY(0.0F);
              ColorRectManager.this.mColorRectTopBar.setAlpha(1.0F);
              LauncherUtil.hideStatusBar(ColorRectManager.this.mLauncher.getWindow());
            }
          }
          else
            return;
          ColorRectManager.this.mColorRectPreview.setVisibility(8);
          this.val$dockbar.setScaleX(1.0F);
          this.val$dockbar.setScaleY(1.0F);
          ColorRectManager.this.mWorkspace.setOrderMode(PagedView.State.NORMAL);
          localPagePointView.setAlpha(1.0F);
          localPagePointView.setVisibility(0);
          localPagePointView.setScaleX(1.0F);
          localPagePointView.setScaleY(1.0F);
          ColorRectManager.this.mColorRectTopBar.setTranslationY(-j);
          ColorRectManager.this.mColorRectTopBar.setVisibility(4);
          ColorRectManager.this.mColorRectPreview.updateArrow(false);
          LauncherUtil.showStatusBar(ColorRectManager.this.mLauncher.getWindow());
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          ColorRectManager.this.mColorRectPreview.setLayerType(2, null);
          if (paramBoolean1)
          {
            if ((localFolder != null) && (localFolder.getInfo().container != -101L))
              ColorRectManager.this.mColorRectTopBar.bringToFront();
            ColorRectManager.this.mColorRectPreview.setVisibility(0);
            ColorRectManager.this.mColorRectPreview.setLock(false);
            ColorRectManager.this.mColorRectPreview.updateArrow(false);
            ColorRectManager.this.mColorRectTopBar.setTranslationY(-j);
            ColorRectManager.this.mColorRectTopBar.setVisibility(0);
            localPagePointView.setVisibility(4);
            return;
          }
          ColorRectManager.this.onExitOrderMoreModeToNormal();
          this.val$dockbar.onTextVisible(true);
          localPagePointView.setVisibility(0);
          ColorRectManager.this.mColorRectPreview.updateArrow(false);
        }
      };
      if (!paramBoolean2)
        break label413;
      this.mColorRectVAnimator.addUpdateListener((AnimatorUpdateListener)localObject2);
      this.mColorRectVAnimator.addListener((AnimatorListener)localObject1);
      this.mColorRectVAnimator.start();
      return;
      i = localResources.getDimensionPixelSize(2131361898);
      break;
      label392: ((DragController)localObject2).removeDropTarget(this.mColorRectPreview);
      ((DragController)localObject2).removeDragScroller(this.mColorRectPreview);
    }
    label413: ((AnimatorListenerAdapter)localObject1).onAnimationStart(null);
    ((LauncherAnimatorUpdateListener)localObject2).onAnimationUpdate(0.0F, 1.0F);
    this.mColorRectPreview.postDelayed(new Runnable()
    {
      public void run()
      {
        ColorRectManager.this.mColorRectPreview.setLock(false);
        this.val$animatorListener.onAnimationEnd(null);
      }
    }
    , 100L);
  }

  public void showTopBar()
  {
    if (this.mColorRectTopBar != null)
      this.mColorRectTopBar.show();
  }

  public void updateColorRect(int paramInt)
  {
    if (this.mColorRectPreview != null)
      this.mColorRectPreview.refreshPreviewPage(paramInt);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ColorRectManager
 * JD-Core Version:    0.6.2
 */