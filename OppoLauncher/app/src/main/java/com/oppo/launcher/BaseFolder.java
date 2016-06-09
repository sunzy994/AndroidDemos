package com.oppo.launcher;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class BaseFolder extends LinearLayout
  implements DragSource, OnClickListener, OnLongClickListener, DropTarget, OnFocusChangeListener
{
  static final boolean DEBUG_DRAG = false;
  static final boolean DEBUG_ENABLE = false;
  protected static final int FOLDER_CLOSE_ANIMATE_DELAY = 80;
  protected static final int FOLDER_CLOSE_BACKGROUND_ANIMATE_DURATION = 150;
  protected static final int FOLDER_OPEN_BACKGROUND_ANIMATE_DELAY = 150;
  protected static final int FOLDER_OPEN_BACKGROUND_ANIMATE_DURATION = 120;
  protected static final int FULL_GROW = 0;
  protected static final int MAX_FOLDENAME_LEN = 9;
  protected static final int ON_EXIT_CLOSE_DELAY = 100;
  protected static final int PARTIAL_GROW = 1;
  protected static final int REORDER_ANIMATION_DURATION = 230;
  protected static int SCROLL_ANIMATION_DURATION = 0;
  static final int STATE_ANIMATING = 1;
  static final int STATE_NONE = -1;
  static final int STATE_OPEN = 2;
  static final int STATE_SMALL = 0;
  private static final String TAG = "BaseFolder";
  protected static String sDefaultFolderName;
  private float mBackgroundAlpha = 0.0F;
  protected Rect mBottomRect = new Rect();
  protected boolean mCanRemoveFolder = false;
  protected int mCellHeight;
  protected int mCellWidth;
  int[] mChildOffset = new int[2];
  protected View mCurrentDragView;
  protected boolean mDeleteFolderOnDropCompleted = false;
  protected DragController mDragController;
  protected boolean mDragInProgress = false;
  Rect mEditRect = new Rect();
  protected int[] mEmptyCell = new int[2];
  int[] mFirstChildCenter = new int[2];
  protected int mFoldAlphaAnimDuration = 145;
  protected float mFoldBackgroundAlpha = 0.3F;
  protected int mFoldCloseAnimDuration = 180;
  protected int mFoldCloseBackDelay = 145;
  protected int mFoldOpenBackAlphaAnimDuration = 110;
  protected int mFoldScaleAnimDuration = 185;
  protected TextView mFoldShower;
  protected int mFolderContentPadding;
  protected FrameLayout mFolderHeader;
  int[] mFolderIconCenter = new int[2];
  protected FolderEditText mFolderName;
  protected ImageView mFolderNameClear;
  protected int mFolderNameHeight;
  protected FrameLayout mFolderQuickTitleContainer;
  protected FolderScroller mFolderScoll;
  int[] mFolderScrollPos = new int[2];
  protected final IconCache mIconCache;
  protected Drawable mIconDrawable;
  protected Rect mIconRect = new Rect();
  protected final LayoutInflater mInflater;
  protected InputMethodManager mInputMethodManager;
  protected boolean mIsEditingName = false;
  protected boolean mItemAddedBackToSelfViaIcon = false;
  protected ArrayList<View> mItemsInReadingOrder = new ArrayList();
  protected boolean mItemsInvalidated = false;
  protected Launcher mLauncher;
  protected int mMaxCountX;
  protected int mMaxCountY;
  protected int mMaxNumItems;
  protected int mMode = 1;
  protected LauncherModel mModel;
  protected boolean mMoveInValidAera = false;
  protected OnClickListener mNameClickListener = new OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (paramAnonymousView == null)
        return;
      BaseFolder.this.startEditingFolderName();
      BaseFolder.this.viewVisibilityChange();
    }
  };
  protected float mNewAlpha;
  protected float mNewScaleX;
  protected float mNewScaleY;
  protected Rect mNewSize = new Rect();
  protected float mNewTranslationX;
  protected float mNewTranslationY;
  protected float mOldAlpha;
  protected float mOldScaleX;
  protected float mOldScaleY;
  protected float mOldTranslationX;
  protected float mOldTranslationY;
  protected Alarm mOnExitAlarm = new Alarm();
  public OnAlarmListener mOnExitAlarmListener = new OnAlarmListener()
  {
    public void onAlarm(Alarm paramAnonymousAlarm)
    {
      BaseFolder.this.completeDragExit();
    }
  };
  protected boolean mOpenInDragMode = false;
  protected int[] mPreviousTargetCell = new int[2];
  protected boolean mRearrangeOnClose = false;
  protected Alarm mReorderAlarm = new Alarm();
  Rect mScrollRect = new Rect();
  protected int mState = -1;
  protected boolean mSuppressFolderDeletion = false;
  protected boolean mSuppressOnAdd = false;
  Rect mTailRect = new Rect();
  protected int[] mTargetCell = new int[2];
  protected Rect mTempRect = new Rect();
  protected TextWatcher mTextWatcher = new TextWatcher()
  {
    private int ch;
    private int delNums = 0;
    private int editEnd;
    private int editStart;

    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      BaseFolder.this.mFolderName.removeTextChangedListener(BaseFolder.this.mTextWatcher);
      if (BaseFolder.this.calculateLength(paramAnonymousEditable.toString()) > 9L)
      {
        this.editStart = BaseFolder.this.mFolderName.getSelectionStart();
        this.editEnd = BaseFolder.this.mFolderName.getSelectionEnd();
        this.ch = paramAnonymousEditable.toString().charAt(this.editStart - 1);
        if ((this.ch >= 55296) && (this.ch <= 57343));
        for (this.delNums = 2; ; this.delNums = 1)
        {
          paramAnonymousEditable.delete(this.editStart - this.delNums, this.editEnd);
          break;
        }
      }
      BaseFolder.this.mFolderName.addTextChangedListener(BaseFolder.this.mTextWatcher);
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }
  };
  private Toast mToast = null;
  protected Rect mTopRect = new Rect();
  Rect mValidAeraRect = new Rect();

  public BaseFolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setAlwaysDrawnWithCacheEnabled(false);
    this.mInflater = LayoutInflater.from(paramContext);
    this.mIconCache = ((LauncherApplication)paramContext.getApplicationContext()).getIconCache();
    paramAttributeSet = getResources();
    this.mMaxCountX = paramAttributeSet.getInteger(2131296270);
    this.mMaxCountY = paramAttributeSet.getInteger(2131296271);
    this.mMaxNumItems = paramAttributeSet.getInteger(2131296272);
    if ((this.mMaxCountX < 0) || (this.mMaxCountY < 0) || (this.mMaxNumItems < 0))
    {
      this.mMaxCountX = LauncherModel.getCellCountX();
      this.mMaxCountY = LauncherModel.getCellCountY();
      this.mMaxNumItems = (this.mMaxCountX * this.mMaxCountY);
    }
    this.mInputMethodManager = ((InputMethodManager)getContext().getSystemService("input_method"));
    if (sDefaultFolderName == null)
      sDefaultFolderName = paramAttributeSet.getString(2131427330);
    this.mLauncher = ((Launcher)paramContext);
    this.mModel = this.mLauncher.getModel();
    setFocusableInTouchMode(true);
    this.mCellHeight = paramContext.getResources().getDimensionPixelSize(2131361844);
    this.mFolderContentPadding = paramContext.getResources().getDimensionPixelSize(2131361838);
    if ((this.mCellWidth < 0) || (this.mCellHeight < 0))
    {
      int i = this.mFolderContentPadding;
      int k = paramContext.getResources().getInteger(2131296270);
      int m = i * 2;
      int j = m / k;
      i = j;
      if (m % k != 0)
        i = j + 1;
      this.mCellWidth = (Launcher.getCellWidth() - i);
      this.mCellHeight = Launcher.getCellHeight();
    }
  }

  private long calculateLength(CharSequence paramCharSequence)
  {
    double d = 0.0D;
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int j = paramCharSequence.charAt(i);
      if ((j > 0) && (j < 127));
      for (d += 0.5D; ; d += 1.0D)
      {
        i += 1;
        break;
      }
    }
    return Math.round(d);
  }

  public static BaseFolder fromXml(Context paramContext)
  {
    return null;
  }

  public boolean acceptDrop(DropTarget.DragObject paramDragObject)
  {
    int i = ((ItemInfo)paramDragObject.dragInfo).itemType;
    return ((i == 0) || (i == 1)) && (!isFull());
  }

  public void animateBackground(boolean paramBoolean)
  {
    final Drawable localDrawable = getBackground();
    if (localDrawable == null)
      return;
    float f2 = 0.0F;
    float f1 = 1.0F;
    int j = 120;
    int i = 150;
    if (!paramBoolean)
    {
      f2 = this.mBackgroundAlpha;
      f1 = 0.0F;
      j = 150;
      i = 0;
    }
    while (true)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          BaseFolder.access$102(BaseFolder.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          if (localDrawable != null)
            localDrawable.setAlpha((int)(BaseFolder.this.mBackgroundAlpha * 255.0F));
        }
      });
      localValueAnimator.setDuration(j);
      localValueAnimator.setStartDelay(i);
      localValueAnimator.start();
      return;
      this.mBackgroundAlpha = 0.0F;
    }
  }

  public void animateClosed()
  {
  }

  public void animateOpen()
  {
  }

  public void arrangeChildren(ArrayList<View> paramArrayList)
  {
  }

  public void bind(ItemInfo paramItemInfo)
  {
  }

  public void cancelExitAlarm()
  {
    if (this.mOnExitAlarm != null)
      this.mOnExitAlarm.cancelAlarm();
  }

  public void centerAboutIcon()
  {
  }

  public void completeDragExit()
  {
  }

  protected boolean createAndAddApps(ItemInfo paramItemInfo)
  {
    return true;
  }

  public void dismissEditingName()
  {
    this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    doneEditingFolderName(true);
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }

  public void doneEditingFolderName(boolean paramBoolean)
  {
  }

  protected boolean findAndSetEmptyCells(ItemInfo paramItemInfo)
  {
    return false;
  }

  public boolean folderIsAnimating()
  {
    return this.mState == 1;
  }

  public Drawable getDragDrawable()
  {
    return this.mIconDrawable;
  }

  public float[] getDragViewVisualCenter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, DragView paramDragView, float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      paramArrayOfFloat = new float[2];
    while (true)
    {
      paramArrayOfFloat[0] = (paramDragView.getDragRegion().width() / 2 + (paramInt1 - paramInt3));
      paramArrayOfFloat[1] = (paramDragView.getDragRegion().height() / 2 + (paramInt2 - paramInt4));
      return paramArrayOfFloat;
    }
  }

  public DropTarget getDropTargetDelegate(DropTarget.DragObject paramDragObject)
  {
    return null;
  }

  public View getEditTextRegion()
  {
    return this.mFolderName;
  }

  public void getFolderEffectiveRegion(Rect paramRect, boolean paramBoolean)
  {
    if (paramRect == null)
      paramRect = new Rect();
    while (true)
    {
      DragLayer localDragLayer = this.mLauncher.getDragLayer();
      if (localDragLayer != null)
      {
        if ((this.mFolderHeader != null) && (paramBoolean))
        {
          localDragLayer.getDescendantRectRelativeToSelf(this.mFolderHeader, this.mEditRect);
          paramRect.union(this.mEditRect);
        }
        if (this.mFolderScoll != null)
        {
          localDragLayer.getDescendantRectRelativeToSelf(this.mFolderScoll, this.mScrollRect);
          paramRect.union(this.mScrollRect);
        }
      }
      return;
      paramRect.set(0, 0, 0, 0);
    }
  }

  public BaseFolderIcon getFolderIcon()
  {
    return null;
  }

  public void getHitRect(Rect paramRect)
  {
    if (this.mOpenInDragMode)
    {
      DragLayer localDragLayer = this.mLauncher.getDragLayer();
      if (localDragLayer != null)
        localDragLayer.getDescendantRectRelativeToSelf(this, paramRect);
      return;
    }
    getFolderEffectiveRegion(paramRect, isEditingName());
  }

  public ItemInfo getInfo()
  {
    return null;
  }

  public View getItemAt(int paramInt)
  {
    return null;
  }

  public int getItemCount()
  {
    return 0;
  }

  public ArrayList<View> getItemsInReadingOrder()
  {
    return getItemsInReadingOrder(true);
  }

  public ArrayList<View> getItemsInReadingOrder(boolean paramBoolean)
  {
    return null;
  }

  public void getLocationInDragLayer(int[] paramArrayOfInt)
  {
    this.mLauncher.getDragLayer().getLocationInDragLayer(this, paramArrayOfInt);
  }

  public View getNameShowRegion()
  {
    return this.mFoldShower;
  }

  public View getViewForInfo(ItemInfo paramItemInfo)
  {
    return null;
  }

  public boolean isDropEnabled(DropTarget.DragObject paramDragObject)
  {
    return (this.mOpenInDragMode) || (!folderIsAnimating());
  }

  public boolean isEditingName()
  {
    return this.mIsEditingName;
  }

  public boolean isFolderNameVisiable()
  {
    if (this.mFolderName == null);
    while (this.mFolderName.getVisibility() != 0)
      return false;
    return true;
  }

  public boolean isFull()
  {
    return false;
  }

  protected void makeToast(int paramInt)
  {
    if (this.mToast != null)
    {
      this.mToast.cancel();
      this.mToast = null;
    }
    this.mToast = Toast.makeText(getContext(), paramInt, 0);
    this.mToast.show();
  }

  public void notifyDataSetChanged()
  {
  }

  public void notifyDrop()
  {
    if (this.mDragInProgress)
      this.mItemAddedBackToSelfViaIcon = true;
  }

  public void onAdd(ItemInfo paramItemInfo)
  {
  }

  public void onClick(View paramView)
  {
  }

  public void onCloseComplete()
  {
  }

  public void onDragEnter(DropTarget.DragObject paramDragObject)
  {
    this.mPreviousTargetCell[0] = -1;
    this.mPreviousTargetCell[1] = -1;
    this.mOnExitAlarm.cancelAlarm();
    this.mMoveInValidAera = false;
    this.mDragInProgress = true;
    if (this.mIsEditingName)
      dismissEditingName();
  }

  public void onDragExit(DropTarget.DragObject paramDragObject)
  {
    if ((this.mOpenInDragMode) && (folderIsAnimating()))
    {
      Log.e("BaseFolder", "onDragExit --folderIsAnimating return!");
      return;
    }
    if (!paramDragObject.dragComplete)
    {
      this.mOnExitAlarm.setOnAlarmListener(this.mOnExitAlarmListener);
      this.mOnExitAlarm.setAlarm(100L);
    }
    this.mReorderAlarm.cancelAlarm();
  }

  public void onDragOver(DropTarget.DragObject paramDragObject)
  {
    if (this.mOpenInDragMode)
    {
      getFolderEffectiveRegion(this.mValidAeraRect, false);
      if ((paramDragObject.dragComplete) || (!this.mMoveInValidAera) || (this.mValidAeraRect.contains(paramDragObject.x, paramDragObject.y)))
        break label128;
      if (!this.mOnExitAlarm.alarmPending())
      {
        this.mOnExitAlarm.setOnAlarmListener(this.mOnExitAlarmListener);
        this.mOnExitAlarm.setAlarm(500L);
      }
    }
    while (true)
    {
      Rect localRect = new Rect();
      DragLayer localDragLayer = this.mLauncher.getDragLayer();
      if (localDragLayer != null)
        localDragLayer.getDescendantRectRelativeToSelf(this.mFolderName, localRect);
      paramDragObject.y = (paramDragObject.y - this.mFolderNameHeight - localRect.top);
      return;
      label128: this.mOnExitAlarm.cancelAlarm();
    }
  }

  public void onDrop(DropTarget.DragObject paramDragObject)
  {
    if ((this.mOpenInDragMode) && (this.mOnExitAlarm.alarmPending()))
      this.mOnExitAlarm.cancelAlarm();
    this.mDragInProgress = false;
  }

  public void onDropCompleted(View paramView, DropTarget.DragObject paramDragObject, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public void onFlingToDelete(DropTarget.DragObject paramDragObject, int paramInt1, int paramInt2, PointF paramPointF)
  {
  }

  public void onFlingToDeleteCompleted()
  {
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramView == this.mFolderName) && (paramBoolean))
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          BaseFolder.this.mInputMethodManager.showSoftInput(BaseFolder.this.mFolderName, 0);
        }
      }
      , 100L);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (folderIsAnimating()) || (super.onInterceptTouchEvent(paramMotionEvent));
  }

  public void onItemsChanged()
  {
    updateTextViewFocus();
  }

  public boolean onLongClick(View paramView)
  {
    return true;
  }

  public void onRemove(ItemInfo paramItemInfo)
  {
  }

  public void onTitleChanged(CharSequence paramCharSequence)
  {
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }

  public void positionAndSizeAsIcon()
  {
  }

  public void preOnDrop(DropTarget.DragObject paramDragObject)
  {
    onDragExit(paramDragObject);
  }

  public void realTimeReorder(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
  }

  public void removeDragViewApp(Object paramObject)
  {
  }

  public void replaceFolderWithFinalItem()
  {
  }

  public void restoreDragInfo(DropTarget.DragObject paramDragObject)
  {
  }

  public void sendCustomAccessibilityEvent(int paramInt, String paramString)
  {
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)getContext().getSystemService("accessibility");
    if (localAccessibilityManager.isEnabled())
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
      onInitializeAccessibilityEvent(localAccessibilityEvent);
      localAccessibilityEvent.getText().add(paramString);
      localAccessibilityManager.sendAccessibilityEvent(localAccessibilityEvent);
    }
  }

  public void setBackground(Drawable paramDrawable)
  {
    super.setBackground(paramDrawable);
    animateBackground(true);
  }

  public void setDragController(DragController paramDragController)
  {
    this.mDragController = paramDragController;
  }

  public void setFocusOnFirstChild()
  {
  }

  public void setFolderIcon(BaseFolderIcon paramBaseFolderIcon)
  {
  }

  public void setupContentDimensions(int paramInt)
  {
  }

  public void setupContentForNumItems(int paramInt)
  {
    setupContentDimensions(paramInt);
    if ((DragLayer.LayoutParams)getLayoutParams() == null)
    {
      DragLayer.LayoutParams localLayoutParams = new DragLayer.LayoutParams(0, 0);
      localLayoutParams.customPosition = true;
      setLayoutParams(localLayoutParams);
    }
    centerAboutIcon();
  }

  public void startEditingFolderName()
  {
    this.mFolderName.setHint("");
    this.mIsEditingName = true;
  }

  public boolean supportsFlingToDelete()
  {
    return false;
  }

  public void updateItemLocationsInDatabase()
  {
  }

  public void updateTextViewFocus()
  {
    View localView = getItemAt(getItemCount() - 1);
    if (localView != null)
    {
      this.mFolderName.setNextFocusDownId(localView.getId());
      this.mFolderName.setNextFocusRightId(localView.getId());
      this.mFolderName.setNextFocusLeftId(localView.getId());
      this.mFolderName.setNextFocusUpId(localView.getId());
    }
  }

  protected void viewVisibilityChange()
  {
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.BaseFolder
 * JD-Core Version:    0.6.2
 */