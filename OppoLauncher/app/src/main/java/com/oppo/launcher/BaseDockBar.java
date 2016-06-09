package com.oppo.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class BaseDockBar extends LinearLayout
{
  protected static final boolean DEBUG_ENABLE = false;
  protected static final boolean DEBUG_LAYOUT = false;
  protected static final int HOTSEAT_ANIMATION_DURATION = 500;
  public static final int MAX_NUM_HOTSEATS = 4;
  private static final String TAG = "BaseDockBar";
  protected int mChildCountInOrderMode = 1;
  protected int mHomeAnimationHeight;
  protected boolean mIsAnimating = false;
  protected int mItemAnimationHeight;
  protected Launcher mLauncher;
  protected LauncherModel mModel;
  protected int mWillChildCount = -1;
  protected int mWillPos = -1;

  public BaseDockBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext().getResources();
    this.mItemAnimationHeight = ((int)paramContext.getDimension(2131361866));
    this.mHomeAnimationHeight = ((int)paramContext.getDimension(2131361867));
    setDescendantFocusability(393216);
  }

  public int[] getChildCenter(int paramInt1, int paramInt2)
  {
    Rect localRect = getChildLocation(paramInt1, paramInt2, false);
    return new int[] { localRect.left + (int)(getChildWidth() * getScaleX()) / 2, localRect.top + (int)(getChildHeight() * getScaleY()) / 2 };
  }

  protected int getChildHeight()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }

  public int[] getChildLeftAndTop(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Rect localRect = getChildLocation(paramInt1, paramInt2, paramBoolean);
    return new int[] { localRect.left, localRect.top };
  }

  public Rect getChildLocation(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 4))
    {
      Log.w("BaseDockBar", "getChildLocation. Illegal pos! pos is " + paramInt1);
      return new Rect();
    }
    if ((paramInt2 < 0) || (paramInt2 > 4))
    {
      Log.w("BaseDockBar", "getChildLocation. Illegal childCount! childCount is " + paramInt2);
      return new Rect();
    }
    float f1 = 1.0F;
    float f2 = 1.0F;
    if (paramBoolean)
    {
      f1 = getScaleX();
      f2 = getScaleY();
    }
    int i = (int)(getChildWidth() * f1);
    int j = (int)(getChildHeight() * f2);
    int k = (int)(getFirstChildLeft(paramInt2) * f1);
    paramInt2 = (int)(getPaddingTop() * f2);
    paramInt1 = k + i * paramInt1;
    return new Rect(paramInt1, paramInt2, paramInt1 + i, paramInt2 + j);
  }

  protected int getChildWidth()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 4;
  }

  protected int getFirstChildLeft(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4))
    {
      Log.w("BaseDockBar", "getFirstChildLeft. Illegal childCount! childCount is " + paramInt);
      return 0;
    }
    return getPaddingLeft() + (getWidth() - getPaddingLeft() - getPaddingRight()) * (4 - paramInt) / 4 / 2;
  }

  protected void onAnimationEnd()
  {
    super.onAnimationEnd();
    clearAnimation();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    if (j <= 0)
      Log.w("BaseDockBar", "onLayout. childCount is 0!");
    do
    {
      return;
      getWidth();
      getHeight();
      if ((this.mWillChildCount < 0) || (this.mWillChildCount == j))
      {
        onLayoutChildren();
        return;
      }
    }
    while (this.mIsAnimating);
    int k = getChildWidth();
    int m = getFirstChildLeft(this.mWillChildCount);
    int n = getPaddingTop();
    paramInt3 = -1;
    paramInt1 = 0;
    label85: View localView;
    int i;
    if (paramInt1 < j)
    {
      localView = getChildAt(paramInt1);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      paramInt2 = 0;
      if (localLayoutParams.width != k)
      {
        paramInt2 = 1;
        localLayoutParams.width = k;
        localView.setLayoutParams(localLayoutParams);
      }
      paramInt4 = paramInt3;
      if (localView.getVisibility() != 8)
      {
        i = paramInt3 + 1;
        paramInt4 = localView.getMeasuredHeight();
        if (i >= this.mWillPos)
          break label226;
      }
    }
    label226: for (paramInt3 = m + k * i; ; paramInt3 = k * i + m + this.mChildCountInOrderMode * k)
    {
      localView.layout(paramInt3, n, paramInt3 + k, n + paramInt4);
      paramInt4 = i;
      if (paramInt2 != 0)
      {
        localView.requestLayout();
        paramInt4 = i;
      }
      paramInt1 += 1;
      paramInt3 = paramInt4;
      break label85;
      break;
    }
  }

  protected void onLayoutChildren()
  {
    int m = getPaddingLeft();
    int n = getPaddingTop();
    int i1 = getChildCount();
    int j = getWidth() - m * 2;
    int i = 0;
    while (i < i1)
    {
      j -= getChildAt(i).getMeasuredWidth();
      i += 1;
    }
    int i2 = j / (i1 + 1);
    int k = 0;
    i = 0;
    while (i < i1)
    {
      View localView = getChildAt(i);
      j = k;
      if (i > 0)
        j = k + getChildAt(i - 1).getMeasuredWidth();
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredHeight();
        int i3 = (i + 1) * i2 + m + j;
        localView.layout(i3, n, i3 + localView.getMeasuredWidth(), n + k);
      }
      i += 1;
      k = j;
    }
  }

  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (paramInt == 2);
    while ((paramInt == 130) && (paramRect == null))
      return false;
    return super.requestFocus(paramInt, paramRect);
  }

  public void setLauncher(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
    this.mModel = paramLauncher.getModel();
  }

  public void updateAppsUnreadChanged(ComponentName paramComponentName, int paramInt)
  {
    int i = 0;
    if (i < getChildCount())
    {
      Object localObject1 = getChildAt(i);
      Object localObject2 = ((View)localObject1).getTag();
      if ((localObject2 instanceof ApplicationInfo))
      {
        localObject1 = (BubbleTextView)localObject1;
        localObject2 = (ApplicationInfo)localObject2;
        if ((localObject2 != null) && (((ApplicationInfo)localObject2).intent != null));
      }
      while (true)
      {
        i += 1;
        break;
        ComponentName localComponentName = ((ApplicationInfo)localObject2).intent.getComponent();
        if ((localObject2 != null) && (localComponentName != null) && (localComponentName.equals(paramComponentName)))
        {
          ((ApplicationInfo)localObject2).unreadNum = paramInt;
          ((BubbleTextView)localObject1).destroyDrawingCache();
          ((BubbleTextView)localObject1).invalidate();
          continue;
          if ((localObject2 instanceof FolderInfo))
            ((FolderIcon)localObject1).updateFolderUnreadNum(paramComponentName, paramInt);
        }
      }
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.BaseDockBar
 * JD-Core Version:    0.6.2
 */