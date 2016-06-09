package com.oppo.launcher;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class StrokedTextView extends TextView
{
  private Bitmap mCache;
  private final Canvas mCanvas = new Canvas();
  private final Paint mPaint = new Paint();
  private int mStrokeColor;
  private float mStrokeWidth;
  private int mTextColor;
  private boolean mUpdateCachedBitmap;

  public StrokedTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null, 0);
  }

  public StrokedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet, 0);
  }

  public StrokedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }

  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.StrokedTextView, paramInt, 0);
    this.mStrokeColor = paramContext.getColor(0, -16777216);
    this.mStrokeWidth = paramContext.getFloat(2, 0.0F);
    this.mTextColor = paramContext.getColor(1, -1);
    paramContext.recycle();
    this.mUpdateCachedBitmap = true;
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Style.FILL_AND_STROKE);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mCache != null)
    {
      if (this.mUpdateCachedBitmap)
      {
        int k = getMeasuredWidth();
        int j = getMeasuredHeight();
        String str = getText().toString();
        Rect localRect = new Rect();
        Object localObject = getPaint();
        int m = (int)((Paint)localObject).measureText(str);
        ((Paint)localObject).getTextBounds("x", 0, 1, localRect);
        this.mCanvas.setBitmap(this.mCache);
        this.mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        int n = getPaddingLeft();
        int i1 = getPaddingTop();
        localObject = getCompoundDrawables();
        int i = 0;
        while (i < localObject.length)
        {
          if (localObject[i] != null)
          {
            localObject[i].setBounds(n, i1, localObject[i].getIntrinsicWidth() + n, localObject[i].getIntrinsicHeight() + i1);
            localObject[i].draw(this.mCanvas);
          }
          i += 1;
        }
        i = k - getPaddingRight() - m;
        j = (localRect.height() + j) / 2;
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setColor(this.mStrokeColor);
        this.mPaint.setTextSize(getTextSize());
        this.mCanvas.drawText(str, i, j, this.mPaint);
        this.mPaint.setStrokeWidth(0.0F);
        this.mPaint.setColor(this.mTextColor);
        this.mCanvas.drawText(str, i, j, this.mPaint);
        this.mUpdateCachedBitmap = false;
      }
      paramCanvas.drawBitmap(this.mCache, 0.0F, 0.0F, this.mPaint);
      return;
    }
    super.onDraw(paramCanvas);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mUpdateCachedBitmap = true;
      this.mCache = Bitmap.createBitmap(paramInt1, paramInt2, Config.ARGB_8888);
      return;
    }
    this.mCache = null;
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.mUpdateCachedBitmap = true;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.StrokedTextView
 * JD-Core Version:    0.6.2
 */