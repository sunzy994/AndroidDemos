package com.oppo.launcher.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import com.oppo.launcher.BubbleTextView;

public class OppoImageSpan extends ImageSpan
{
  private String TAG = "OppoImageSpan";
  private int mBottom;
  private Context mContext;
  private float mDensityScale;
  private Drawable mDrawable;
  private int mLeft;
  private int mPadding;
  private int mRight;
  private int mTop;
  private BubbleTextView mViewIcon;
  private int mWidth;

  public OppoImageSpan(Context paramContext, BubbleTextView paramBubbleTextView, Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
    this.mViewIcon = paramBubbleTextView;
    this.mContext = paramContext;
    init();
  }

  private void drawBurstAnim(Canvas paramCanvas, float paramFloat, int paramInt)
  {
    Bitmap localBitmap = this.mViewIcon.getNewPrefixBurst();
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      Log.e(this.TAG, "drawBurstAnim -- burstFrame is null, return");
      return;
    }
    paramCanvas.save();
    int i = this.mViewIcon.getNewPrefixAlpha();
    float f = this.mViewIcon.getNewPrefixScale();
    paramCanvas.translate(paramFloat - this.mWidth / 2 * (f - 1.0F) * 9.0F / 7.0F, paramInt - this.mWidth / 2 * (f - 1.0F) * 9.0F / 7.0F);
    paramCanvas.scale(f, f);
    this.mDrawable.setAlpha(i);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(paramFloat - this.mWidth / 2 * (f - 1.0F) * 9.0F / 7.0F * (2.0F - this.mDensityScale), paramInt - this.mWidth / 2 * (f - 1.0F) * 9.0F / 7.0F * (2.0F - this.mDensityScale));
    paramCanvas.scale(this.mDensityScale * f, this.mDensityScale * f);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    paramCanvas.restore();
  }

  private void drawTitleAnim()
  {
    float f = this.mViewIcon.getTitleMoveProgress();
    this.mRight = ((int)(this.mRight * (1.0F - f)));
    this.mBottom = this.mRight;
    this.mDrawable.setBounds(this.mLeft, this.mTop, this.mRight, this.mBottom);
  }

  private void init()
  {
    this.mDrawable = getDrawable();
    this.mDrawable.setAlpha(255);
    Object localObject = this.mDrawable.getBounds();
    this.mLeft = ((Rect)localObject).left;
    this.mRight = ((Rect)localObject).right;
    this.mTop = ((Rect)localObject).top;
    this.mBottom = ((Rect)localObject).bottom;
    this.mWidth = this.mRight;
    localObject = this.mContext.getResources();
    this.mPadding = ((int)((Resources)localObject).getDimension(2131361936));
    this.mDensityScale = (((Resources)localObject).getDisplayMetrics().density / 3.0F);
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramInt2 = paramInt5 - this.mDrawable.getBounds().bottom + this.mPadding;
    paramInt1 = paramInt2;
    if (this.mVerticalAlignment == 1)
      paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
    if (this.mViewIcon.isBurstAnimRunning())
    {
      drawBurstAnim(paramCanvas, paramFloat, paramInt1);
      return;
    }
    if (this.mViewIcon.isTitleAnimRunning())
    {
      drawTitleAnim();
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt1);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.widget.OppoImageSpan
 * JD-Core Version:    0.6.2
 */