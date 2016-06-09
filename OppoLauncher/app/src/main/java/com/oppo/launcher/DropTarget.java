package com.oppo.launcher;

import android.graphics.PointF;
import android.graphics.Rect;

public abstract interface DropTarget
{
  public static final String TAG = "DropTarget";

  public abstract boolean acceptDrop(DragObject paramDragObject);

  public abstract DropTarget getDropTargetDelegate(DragObject paramDragObject);

  public abstract void getHitRect(Rect paramRect);

  public abstract int getLeft();

  public abstract void getLocationInDragLayer(int[] paramArrayOfInt);

  public abstract int getTop();

  public abstract int getVisibility();

  public abstract boolean isDropEnabled(DragObject paramDragObject);

  public abstract void onDragEnter(DragObject paramDragObject);

  public abstract void onDragExit(DragObject paramDragObject);

  public abstract void onDragOver(DragObject paramDragObject);

  public abstract void onDrop(DragObject paramDragObject);

  public abstract void onFlingToDelete(DragObject paramDragObject, int paramInt1, int paramInt2, PointF paramPointF);

  public abstract void preOnDrop(DragObject paramDragObject);

  public static class DragObject
  {
    public boolean cancelled = false;
    public boolean deferDragViewCleanupPostAnimation = true;
    public boolean dragComplete = false;
    public Object dragInfo = null;
    public DragSource dragSource = null;
    public DragView dragView = null;
    public int orderViewCount = 1;
    public Runnable postAnimationRunnable = null;
    public int x = -1;
    public int xOffset = -1;
    public int y = -1;
    public int yOffset = -1;

    public String toString()
    {
      return "DragObject(x:" + this.x + " y:" + this.y + " xOffset:" + this.xOffset + " yOffset:" + this.yOffset + " dragComplete:" + this.dragComplete + " dragView:" + this.dragView + " cancelled:" + this.cancelled;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.DropTarget
 * JD-Core Version:    0.6.2
 */