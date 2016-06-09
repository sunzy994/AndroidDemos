package cmcm.com.myapplication.com.lazyswipe.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import atw;
import vl;

public class ShadowView extends FrameLayout
{
  private int a;
  private int b;
  private int c;
  private View d;
  private Bitmap e;
  private boolean f;
  private final Paint g;

  public ShadowView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ShadowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ShadowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, vl.ShadowView, paramInt, 0);
      this.a = paramContext.getDimensionPixelSize(0, 0);
      this.b = paramContext.getDimensionPixelSize(1, 0);
      this.c = paramContext.getDimensionPixelSize(2, 419430400);
      paramContext.recycle();
      label53: this.g = new Paint(7);
      this.g.setStyle(Style.FILL);
      paramInt = Color.red(this.c);
      int i = Color.green(this.c);
      int j = Color.blue(this.c);
      float f1 = Color.alpha(this.c) / 255.0F;
      float f2 = paramInt;
      float f3 = i;
      float f4 = j;
      this.g.setColorFilter(new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, 0.0F, 0.0F, 0.0F, 0.0F, f4, 0.0F, 0.0F, 0.0F, f1, 0.0F }));
      return;
    }
    catch (Exception paramContext)
    {
      break label53;
    }
  }

  private void b()
  {
    if ((!this.f) && (!atw.b(this.e)) && (this.d.getWidth() > 0) && (this.d.getHeight() > 0))
      this.e = atw.a(this.d);
    this.f = true;
  }

  public void a()
  {
    this.e = atw.a(this.d);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.a == 0) && (this.b == 0))
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    if (!atw.b(this.e))
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    if ((this.a >= 0) && (this.b >= 0))
    {
      paramCanvas.drawBitmap(this.e, this.a, this.b, this.g);
      paramCanvas.drawBitmap(this.e, 0.0F, 0.0F, null);
      return;
    }
    if ((this.a >= 0) && (this.b < 0))
    {
      paramCanvas.drawBitmap(this.e, this.a, 0.0F, this.g);
      paramCanvas.drawBitmap(this.e, 0.0F, -this.b, null);
      return;
    }
    if ((this.a < 0) && (this.b >= 0))
    {
      paramCanvas.drawBitmap(this.e, 0.0F, this.b, this.g);
      paramCanvas.drawBitmap(this.e, -this.a, 0.0F, null);
      return;
    }
    if ((this.a < 0) && (this.b < 0))
    {
      paramCanvas.drawBitmap(this.e, 0.0F, 0.0F, this.g);
      paramCanvas.drawBitmap(this.e, -this.a, -this.a, null);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    atw.a(this.e);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() != 1)
      throw new RuntimeException("ShadowView children count should be 1");
    this.d = getChildAt(0);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.d.getMeasuredWidth() + Math.abs(this.a), this.d.getMeasuredHeight() + Math.abs(this.b));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.view.ShadowView
 * JD-Core Version:    0.6.2
 */