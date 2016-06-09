package com.oppo.launcher;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DragScrollerAreaController
  implements OnAlarmListener
{
  static final boolean DEBUG = false;
  public static final int DRAG_SCROLLER_AREA_DURATION = 400;
  public static final int DRAG_SCROLLER_AREA_START_DURATION = 600;
  static final int SCROLL_LEFT = 0;
  static final int SCROLL_NONE = -1;
  private static final int SCROLL_OUTSIDE_ZONE = 0;
  static final int SCROLL_RIGHT = 1;
  private static final int SCROLL_WAITING_IN_ZONE = 1;
  private static final String TAG = "DragScrollerAreaController";
  Alarm mAlarm;
  private CellLayout mCellLayout;
  DragScroller mDragScroller;
  int mDragViewLeft;
  int mDragViewRight;
  int mDragViewWidth;
  boolean mIsInArea = false;
  private Launcher mLauncher;
  int mPositionX;
  int mPositionY;
  private int mScrollState = 0;
  private int mScrollerZoneWidth = 80;
  private Workspace mWorkspace;

  public DragScrollerAreaController(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
    this.mWorkspace = paramLauncher.getWorkspace();
    this.mScrollerZoneWidth = this.mLauncher.getResources().getDimensionPixelSize(2131361933);
    this.mAlarm = new Alarm();
    this.mAlarm.setOnAlarmListener(this);
  }

  public boolean alarmPending()
  {
    return (this.mAlarm.alarmPending()) || (this.mIsInArea);
  }

  public void cancel()
  {
    this.mScrollState = 0;
    this.mAlarm.cancelAlarm();
    this.mIsInArea = false;
  }

  public boolean enterArea(int paramInt1, int paramInt2)
  {
    if (this.mWorkspace != null)
    {
      this.mCellLayout = this.mWorkspace.getCurrentDropLayout();
      this.mScrollerZoneWidth = ((int)((1.0F - this.mCellLayout.getScaleX()) * this.mWorkspace.getWidth() / 2.0F));
      if (((paramInt1 <= this.mScrollerZoneWidth) || (paramInt1 >= this.mWorkspace.getWidth() - this.mScrollerZoneWidth)) && (paramInt2 <= this.mWorkspace.getBottom() + this.mWorkspace.getTranslationY()))
        return true;
    }
    return false;
  }

  public void onAlarm(Alarm paramAlarm)
  {
    int i = this.mLauncher.getResources().getDisplayMetrics().widthPixels;
    if ((this.mDragViewLeft < 0) && (Math.abs(this.mDragViewLeft) > this.mDragViewWidth * 1 / 3))
    {
      this.mDragScroller.onDragViewEnterScrollArea();
      this.mDragScroller.scrollLeft();
      this.mDragScroller.onDragViewExitScrollArea();
      this.mIsInArea = true;
      return;
    }
    if (this.mDragViewRight - i > this.mDragViewWidth * 1 / 3)
    {
      this.mDragScroller.onDragViewEnterScrollArea();
      this.mDragScroller.scrollRight();
      this.mDragScroller.onDragViewExitScrollArea();
      this.mIsInArea = true;
      return;
    }
    if (this.mPositionX <= this.mScrollerZoneWidth)
    {
      if (this.mScrollState == 0)
      {
        this.mScrollState = 1;
        if (this.mDragScroller.onEnterScrollArea(this.mPositionX, this.mPositionY, 0, this.mScrollerZoneWidth))
        {
          this.mDragScroller.scrollLeft();
          this.mScrollState = 0;
          this.mDragScroller.onExitScrollArea();
          this.mIsInArea = true;
        }
      }
    }
    else if ((this.mPositionX >= this.mWorkspace.getWidth() - this.mScrollerZoneWidth) && (this.mScrollState == 0))
    {
      this.mScrollState = 1;
      if (this.mDragScroller.onEnterScrollArea(this.mPositionX, this.mPositionY, 1, this.mScrollerZoneWidth))
      {
        this.mDragScroller.scrollRight();
        this.mScrollState = 0;
        this.mDragScroller.onExitScrollArea();
        this.mIsInArea = true;
        return;
      }
    }
    this.mIsInArea = false;
    if (this.mScrollState == 1)
    {
      this.mScrollState = 0;
      this.mDragScroller.onExitScrollArea();
    }
    this.mAlarm.cancelAlarm();
  }

  public void setAlarm(DragScroller paramDragScroller, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mAlarm.cancelAlarm();
    this.mAlarm.setAlarm(paramInt3);
    this.mPositionX = paramInt1;
    this.mPositionY = paramInt2;
    this.mDragScroller = paramDragScroller;
    this.mCellLayout = this.mWorkspace.getCurrentDropLayout();
    this.mScrollerZoneWidth = ((int)((1.0F - this.mCellLayout.getScaleX()) * this.mWorkspace.getWidth() / 2.0F));
    this.mDragViewLeft = 0;
    this.mDragViewRight = 0;
  }

  public void setAlarm(DragScroller paramDragScroller, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.mAlarm.cancelAlarm();
    this.mAlarm.setAlarm(paramInt2);
    this.mDragViewLeft = paramArrayOfInt[0];
    this.mDragViewRight = paramArrayOfInt[1];
    this.mDragViewWidth = paramInt1;
    this.mDragScroller = paramDragScroller;
    this.mCellLayout = this.mWorkspace.getCurrentDropLayout();
    this.mPositionX = (this.mScrollerZoneWidth * 2);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.DragScrollerAreaController
 * JD-Core Version:    0.6.2
 */