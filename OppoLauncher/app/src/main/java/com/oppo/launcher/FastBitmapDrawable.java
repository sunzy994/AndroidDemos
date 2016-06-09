package com.oppo.launcher;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class FastBitmapDrawable extends Drawable
{
  static final boolean DEBUG = false;
  static final String TAG = "FastBitmapDrawable";
  private static PorterDuffColorFilter mDefultColorFilter = new PorterDuffColorFilter(1677721600, PorterDuff.Mode.SRC_ATOP);
  private int mAlpha = 255;
  private Bitmap mBitmap;
  private int mHeight;
  private final Paint mPaint = new Paint();
  private int mWidth;
  private ColorFilter normalColorFilter = null;

  FastBitmapDrawable(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.mWidth = this.mBitmap.getWidth();
      this.mHeight = this.mBitmap.getHeight();
    }
    while (true)
    {
      this.mPaint.setFilterBitmap(true);
      this.normalColorFilter = this.mPaint.getColorFilter();
      return;
      this.mHeight = 0;
      this.mWidth = 0;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      if (this.mPaint.getColorFilter() != mDefultColorFilter)
        this.mPaint.setColorFilter(this.normalColorFilter);
      paramCanvas.drawBitmap(this.mBitmap, localRect.left, localRect.top, this.mPaint);
      return;
    }
    Log.e("FastBitmapDrawable", " draw --- but null == mBitmap.");
  }

  public int getAlpha()
  {
    return this.mAlpha;
  }

  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }

  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }

  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }

  public int getMinimumHeight()
  {
    return this.mHeight;
  }

  public int getMinimumWidth()
  {
    return this.mWidth;
  }

  public int getOpacity()
  {
    return -3;
  }

  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    this.mPaint.setAlpha(paramInt);
  }

  public void setAlphaDark()
  {
    setAlpha(200);
    invalidateSelf();
  }

  public void setAlphaDefault()
  {
    setAlpha(255);
    invalidateSelf();
  }

  public void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.mWidth = this.mBitmap.getWidth();
      this.mHeight = this.mBitmap.getHeight();
      return;
    }
    this.mHeight = 0;
    this.mWidth = 0;
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }

  public void setColorFilterDark()
  {
    this.mPaint.setColorFilter(mDefultColorFilter);
    invalidateSelf();
  }

  public void setPaintColorFilter(ColorFilter paramColorFilter)
  {
    this.normalColorFilter = paramColorFilter;
    invalidateSelf();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.FastBitmapDrawable
 * JD-Core Version:    0.6.2
 */