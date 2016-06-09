package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class ago extends View
{
  private final Paint a = new Paint();
  private int[] b = null;
  private long c = -1L;
  private int d = 16777215;
  private boolean e = true;
  private float f = -1.0F;
  private Runnable g;
  private final float h = 0.0F;
  private final float i = 0.0F;

  public ago(Context paramContext)
  {
    super(paramContext);
    b();
  }

  private int[] a(float paramFloat)
  {
    return this.b;
  }

  private int b(float paramFloat)
  {
    if (this.e)
      return (int)(128.0F + 127.0F * paramFloat);
    return 255;
  }

  private void b()
  {
    setLayerType(1, new Paint());
  }

  public void a()
  {
    this.c = -1L;
    invalidate();
  }

  public void a(int[] paramArrayOfInt, Runnable paramRunnable)
  {
    this.b = paramArrayOfInt;
    this.a.setColor(this.d);
    this.c = 0L;
    this.g = paramRunnable;
    invalidate();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    long l = getDrawingTime();
    if (this.c < 0L);
    do
    {
      float f1;
      int[] arrayOfInt;
      do
      {
        return;
        if (this.c == 0L)
          this.c = l;
        f1 = Math.min(((float)l - (float)this.c) / 300.0F, 1.0F);
        this.a.setAlpha(b(f1));
        arrayOfInt = a(f1);
      }
      while (arrayOfInt == null);
      paramCanvas.drawCircle(arrayOfInt[0], arrayOfInt[1] + (1.0F - f1) * 0.0F * (1.0F - f1), this.f * f1 + (1.0F - f1) * 0.0F * (1.0F - f1), this.a);
      if (f1 < 1.0F)
      {
        invalidate();
        return;
      }
    }
    while (this.g == null);
    this.g.run();
    this.c = -1L;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b == null)
      return;
    paramInt1 = this.b[0];
    paramInt2 = this.b[1];
    paramInt1 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
    paramInt2 = getMeasuredWidth() - this.b[0];
    paramInt3 = this.b[1];
    paramInt1 = Math.max(paramInt1, (int)Math.sqrt(paramInt2 * paramInt2 + paramInt3 * paramInt3));
    paramInt2 = this.b[0];
    paramInt3 = getMeasuredHeight() - this.b[1];
    paramInt1 = Math.max(paramInt1, (int)Math.sqrt(paramInt2 * paramInt2 + paramInt3 * paramInt3));
    paramInt2 = getMeasuredWidth() - this.b[0];
    paramInt3 = getMeasuredHeight() - this.b[1];
    this.f = (Math.max(paramInt1, (int)Math.sqrt(paramInt2 * paramInt2 + paramInt3 * paramInt3)) + 1);
  }

  public void setColor(int paramInt)
  {
    this.d = paramInt;
  }

  public void setNeedAlpha(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ago
 * JD-Core Version:    0.6.2
 */