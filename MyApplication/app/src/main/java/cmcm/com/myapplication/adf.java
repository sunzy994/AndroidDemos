package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class adf extends aue
{
  private final Paint a;
  private final Paint b;
  private final Path c;
  private final int d;
  private final int e = 2;
  private final boolean f;

  public adf(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.d = asq.a(47.0F);
    this.b = new Paint();
    this.b.setColor(-1);
    this.b.setStyle(Style.STROKE);
    this.b.setStrokeCap(Cap.ROUND);
    this.b.setStrokeWidth(asq.a(2.0F));
    this.b.setFlags(7);
    this.a = new Paint();
    this.a.setFlags(7);
    if (paramBoolean)
    {
      this.a.setColor(872415231);
      this.a.setStyle(Style.FILL);
    }
    while (true)
    {
      this.c = new Path();
      this.c.moveTo(this.d / 2 - asq.a(3.67F), this.d / 2 - asq.a(6.33F));
      this.c.lineTo(this.d / 2 + asq.a(5.33F), this.d / 2);
      this.c.lineTo(this.d / 2 - asq.a(3.67F), this.d / 2 + asq.a(6.33F));
      return;
      this.a.setColor(-1);
      this.a.setStyle(Style.STROKE);
      this.a.setStrokeWidth(2.0F);
    }
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.f)
      paramCanvas.drawCircle(this.d / 2, this.d / 2, (this.d - 2) / 2, this.a);
    while (true)
    {
      paramCanvas.drawPath(this.c, this.b);
      return;
      paramCanvas.drawCircle(this.d / 2, this.d / 2, (this.d - 2) / 2, this.a);
    }
  }

  public int getIntrinsicHeight()
  {
    return this.d;
  }

  public int getIntrinsicWidth()
  {
    return this.d;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adf
 * JD-Core Version:    0.6.2
 */