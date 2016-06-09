package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

class il extends OvalShape
{
  private RadialGradient b;
  private Paint c = new Paint();
  private int d;

  public il(ik paramik, int paramInt1, int paramInt2)
  {
    ik.a(paramik, paramInt1);
    this.d = paramInt2;
    float f1 = this.d / 2;
    float f2 = this.d / 2;
    float f3 = ik.a(paramik);
    paramik = Shader.TileMode.CLAMP;
    this.b = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, paramik);
    this.c.setShader(this.b);
  }

  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int i = this.a.getWidth();
    int j = this.a.getHeight();
    paramCanvas.drawCircle(i / 2, j / 2, this.d / 2 + ik.a(this.a), this.c);
    paramCanvas.drawCircle(i / 2, j / 2, this.d / 2, paramPaint);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     il
 * JD-Core Version:    0.6.2
 */