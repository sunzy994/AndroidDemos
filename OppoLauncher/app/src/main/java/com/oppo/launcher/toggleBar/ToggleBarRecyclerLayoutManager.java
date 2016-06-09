package com.oppo.launcher.toggleBar;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearLayoutManager.LayoutState;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;

public class ToggleBarRecyclerLayoutManager extends LinearLayoutManager
{
  private static final String TAG = "ToggleBarRecyclerLayoutManager";
  private boolean mIsOverShoot;
  private int mScrollState;
  private int mScrollTime;
  private float mTension;

  public ToggleBarRecyclerLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }

  public ToggleBarRecyclerLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }

  public void doSwitchToOvershoot(boolean paramBoolean, float paramFloat)
  {
    this.mIsOverShoot = paramBoolean;
    this.mTension = paramFloat;
  }

  protected int scrollBy(int paramInt, Recycler paramRecycler, State paramState)
  {
    if ((getChildCount() == 0) || (paramInt == 0))
      return 0;
    LinearLayoutManager.LayoutState localLayoutState = getLayoutState();
    localLayoutState.setRecycle(true);
    ensureLayoutState();
    int i;
    if (paramInt > 0)
    {
      i = 1;
      updateLayoutState(i, Math.abs(paramInt), true, paramState);
      i = localLayoutState.getScrollingOffset() + fill(paramRecycler, localLayoutState, paramState, false);
      if ((this.mScrollState != 2) && (i < 0))
        break label108;
      if ((i >= 0) || (this.mScrollState != 2))
        break label105;
    }
    while (true)
    {
      offsetChildren(-paramInt);
      return paramInt;
      i = -1;
      break;
      label105: continue;
      label108: if (this.mScrollState != 0)
        paramInt = (int)(paramInt * 0.3F);
    }
  }

  public void setScrollState(int paramInt)
  {
    this.mScrollState = paramInt;
  }

  public void setScrollTime(int paramInt)
  {
    this.mScrollTime = paramInt;
  }

  public void smoothScrollToPosition(RecyclerView paramRecyclerView, State paramState, int paramInt)
  {
    paramRecyclerView = new ToggleBarRecyclerScroller(paramRecyclerView.getContext())
    {
      public PointF computeScrollVectorForPosition(int paramAnonymousInt)
      {
        return ToggleBarRecyclerLayoutManager.this.computeScrollVectorForPosition(paramAnonymousInt);
      }
    };
    paramRecyclerView.setScrollTime(this.mScrollTime);
    paramRecyclerView.doSwitchToOvershoot(this.mIsOverShoot, this.mTension);
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarRecyclerLayoutManager
 * JD-Core Version:    0.6.2
 */