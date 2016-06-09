package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class uy extends View
{
  public String a;
  private DrawFilter b;
  private Bitmap c;
  private int d = 0;
  private Rect e;
  private Rect f;
  private PaintFlagsDrawFilter g = new PaintFlagsDrawFilter(0, 7);
  private Paint h = new Paint(1);
  private Matrix i;

  public uy(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public uy(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(final Intent paramIntent)
  {
    this.a = paramIntent.getAction();
    new Thread(new Runnable()
    {
      public void run()
      {
        uy.a(uy.this, ul.a(uy.this.getContext(), paramIntent));
        uy.this.postInvalidate();
      }
    }).start();
  }

  public String getAction()
  {
    return this.a;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b == null)
    {
      this.b = paramCanvas.getDrawFilter();
      this.e = new Rect(getPaddingLeft(), getPaddingTop(), getWidth(), getHeight());
      this.f = new Rect(getWidth() - getPaddingLeft() - getPaddingRight(), 0, getWidth(), getPaddingTop() + getPaddingBottom());
    }
    paramCanvas.setDrawFilter(this.g);
    if (this.c != null)
    {
      if (this.i == null)
      {
        this.i = new Matrix();
        float f1 = getWidth() / this.c.getWidth();
        this.i.setScale(f1, f1);
      }
      paramCanvas.drawBitmap(this.c, this.i, null);
    }
    this.h.setColor(-65536);
    paramCanvas.drawCircle(this.f.centerX(), this.f.centerY(), this.f.width() / 2, this.h);
    this.h.setColor(-1);
    this.h.setTextAlign(Align.CENTER);
    this.h.setTextSize(this.f.width() * 2 / 3);
    FontMetricsInt localFontMetricsInt = this.h.getFontMetricsInt();
    int j = this.f.top;
    int k = (this.f.bottom - this.f.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
    int m = localFontMetricsInt.top;
    paramCanvas.drawText(String.valueOf(this.d), this.f.centerX(), j + k - m, this.h);
    super.onDraw(paramCanvas);
    paramCanvas.setDrawFilter(this.b);
    super.dispatchDraw(paramCanvas);
  }

  public void setCount(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uy
 * JD-Core Version:    0.6.2
 */