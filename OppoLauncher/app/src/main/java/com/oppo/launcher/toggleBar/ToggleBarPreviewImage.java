package com.oppo.launcher.toggleBar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ToggleBarPreviewImage extends ImageView
{
  private final String TAG = "ToggleBarPreviewImage";
  private int mHookLeft;
  private int mHookSize;
  private int mHookTop;
  private boolean mInUsing = false;
  private Drawable mInUsingDrawable = null;
  private boolean mTopCrop = false;

  public ToggleBarPreviewImage(Context paramContext)
  {
    super(paramContext);
  }

  public ToggleBarPreviewImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    init(paramContext, paramAttributeSet, 0);
  }

  public ToggleBarPreviewImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    drawInUsing(paramCanvas);
  }

  public void drawInUsing(Canvas paramCanvas)
  {
    if ((this.mInUsing) && (this.mInUsingDrawable != null))
    {
      this.mInUsingDrawable.setBounds(this.mHookLeft, this.mHookTop, this.mHookLeft + this.mHookSize, this.mHookTop + this.mHookSize);
      this.mInUsingDrawable.draw(paramCanvas);
    }
  }

  public boolean getInUsing()
  {
    return this.mInUsing;
  }

  public boolean getTopCrop()
  {
    return this.mTopCrop;
  }

  public void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = getResources();
    if (paramContext != null)
    {
      this.mInUsingDrawable = paramContext.getDrawable(2130837529);
      this.mHookSize = paramContext.getDimensionPixelSize(2131361811);
      this.mHookLeft = paramContext.getDimensionPixelSize(2131361809);
      this.mHookTop = paramContext.getDimensionPixelSize(2131361810);
    }
  }

  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getDrawable() == null)
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = paramInt3 - paramInt1;
    if ((getTopCrop()) && (i > 0))
    {
      setScaleType(ScaleType.MATRIX);
      float f1 = (i - getPaddingLeft() - getPaddingRight()) / getDrawable().getIntrinsicWidth();
      float f2 = getDrawable().getIntrinsicHeight();
      float f3 = paramInt4 - paramInt2;
      Matrix localMatrix = getImageMatrix();
      localMatrix.setScale(f1, f1, 0.0F, 0.0F);
      localMatrix.postTranslate(0.0F, -(f2 * f1 - f3));
      setImageMatrix(localMatrix);
    }
    return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setInUsing(boolean paramBoolean)
  {
    this.mInUsing = paramBoolean;
    invalidate();
  }

  public void setTopCrop(boolean paramBoolean)
  {
    this.mTopCrop = paramBoolean;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarPreviewImage
 * JD-Core Version:    0.6.2
 */