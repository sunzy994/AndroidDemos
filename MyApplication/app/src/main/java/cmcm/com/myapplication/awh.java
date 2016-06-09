package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

public class awh extends View
{
  private final Paint a = new Paint();
  private final int b;
  private final int c;
  private final int d;
  private final float e;
  private final float f;
  private final int g;
  private final int h;

  public awh(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.e = (0.889F * f1);
    this.f = (1.334F * f1);
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = ((int)(f1 * 16.0F));
    this.g = paramInt3;
    this.h = paramInt4;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f4 = (getMeasuredWidth() - this.d * 2) / (this.b - 1);
    float f5 = this.f;
    int i = 0;
    if (i < this.b)
    {
      float f1;
      label60: float f3;
      float f2;
      label85: Paint localPaint;
      if (i == this.c)
      {
        f1 = this.f;
        f3 = this.d + i * f4;
        if (f3 - f1 >= 0.0F)
          break label144;
        f2 = f1;
        localPaint = this.a;
        if (i != this.c)
          break label171;
      }
      label144: label171: for (int j = this.h; ; j = this.g)
      {
        localPaint.setColor(j);
        paramCanvas.drawCircle(f2, f5 + 1.0F, f1, this.a);
        i += 1;
        break;
        f1 = this.e;
        break label60;
        f2 = f3;
        if (f3 + f1 <= getMeasuredWidth())
          break label85;
        f2 = getMeasuredWidth() - f1;
        break label85;
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awh
 * JD-Core Version:    0.6.2
 */