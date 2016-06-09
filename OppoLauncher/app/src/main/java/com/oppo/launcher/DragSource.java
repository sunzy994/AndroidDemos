package com.oppo.launcher;

import android.view.View;

public abstract interface DragSource
{
  public abstract void onDropCompleted(View paramView, DropTarget.DragObject paramDragObject, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void onFlingToDeleteCompleted();

  public abstract void removeDragViewApp(Object paramObject);

  public abstract void restoreDragInfo(DropTarget.DragObject paramDragObject);

  public abstract boolean supportsFlingToDelete();
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.DragSource
 * JD-Core Version:    0.6.2
 */