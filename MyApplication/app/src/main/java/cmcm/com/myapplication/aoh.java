package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;

public class aoh extends Drawable
{
  private final Paint a;
  private final int b;
  private final int c;
  private final boolean d;

  public aoh(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean;
    this.a = new Paint();
    this.a.setColor(ahx.b(paramContext).w());
    this.a.setStyle(Style.STROKE);
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(this.c);
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.d);
    for (float f = 0.0F; ; f = this.b)
    {
      paramCanvas.drawCircle(f, this.b, this.b - this.c, this.a);
      return;
    }
  }

  public int getIntrinsicHeight()
  {
    return this.b;
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
 * Qualified Name:     aoh
 * JD-Core Version:    0.6.2
 */