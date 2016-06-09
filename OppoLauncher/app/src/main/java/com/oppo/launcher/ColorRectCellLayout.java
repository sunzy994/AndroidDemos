package com.oppo.launcher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class ColorRectCellLayout extends CellLayout
{
  private static final String TAG = "ColorRectCellLayout";
  boolean mFirstPage = false;
  int mPadLeft = 0;

  public ColorRectCellLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public ColorRectCellLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ColorRectCellLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mCellCountX = 6;
    this.mCellCountY = 1;
  }

  public void onDragExit(DropTarget.DragObject paramDragObject, boolean paramBoolean)
  {
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = (getWidth() - this.mOriginalWidthGap * (paramInt2 - 1) - this.mCellWidth * paramInt2) / 2;
    View localView;
    BaseCellLayout.LayoutParams localLayoutParams;
    if (this.mFirstPage)
    {
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localView = getChildAt(paramInt1);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (BaseCellLayout.LayoutParams)localView.getLayoutParams();
          paramInt4 = paramInt3 + (this.mOriginalWidthGap + this.mCellWidth) * paramInt1;
          int i = localLayoutParams.y;
          localView.layout(paramInt4, i, localLayoutParams.width + paramInt4, localLayoutParams.height + i);
        }
        paramInt1 += 1;
      }
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (BaseCellLayout.LayoutParams)localView.getLayoutParams();
        paramInt3 = localLayoutParams.x + this.mPadLeft;
        paramInt4 = localLayoutParams.y;
        localView.layout(paramInt3, paramInt4, localLayoutParams.width + paramInt3, localLayoutParams.height + paramInt4);
      }
      paramInt1 += 1;
    }
  }

  public void setFirstPage(boolean paramBoolean)
  {
    this.mFirstPage = paramBoolean;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ColorRectCellLayout
 * JD-Core Version:    0.6.2
 */