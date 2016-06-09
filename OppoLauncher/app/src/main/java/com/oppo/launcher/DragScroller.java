package com.oppo.launcher;

import android.view.MotionEvent;

public abstract interface DragScroller
{
  public abstract int getVisibility();

  public abstract boolean handleMotionEvent(MotionEvent paramMotionEvent);

  public abstract void onDragViewEnterScrollArea();

  public abstract void onDragViewExitScrollArea();

  public abstract boolean onEnterScrollArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract boolean onExitScrollArea();

  public abstract void scrollLeft();

  public abstract void scrollRight();
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.DragScroller
 * JD-Core Version:    0.6.2
 */