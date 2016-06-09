package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

class ada extends Drawable
{
  boolean a;
  private int b;
  private int c;
  private Paint d;

  public ada(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = paramBoolean;
    this.d = new Paint(atw.b);
    if (paramBoolean);
    for (LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, paramInt1, 0.0F, 16777215, -520093697, Shader.TileMode.CLAMP); ; localLinearGradient = new LinearGradient(0.0F, 0.0F, paramInt1, 0.0F, -520093697, 16777215, Shader.TileMode.CLAMP))
    {
      this.d.setStrokeWidth(paramInt2);
      this.d.setStyle(Style.STROKE);
      this.d.setShader(localLinearGradient);
      return;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawLine(0.0F, this.c / 2, this.b, this.c / 2, this.d);
  }

  public int getIntrinsicHeight()
  {
    return this.c;
  }

  public int getIntrinsicWidth()
  {
    return this.b;
  }

  public int getOpacity()
  {
    return 0;
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ada
 * JD-Core Version:    0.6.2
 */