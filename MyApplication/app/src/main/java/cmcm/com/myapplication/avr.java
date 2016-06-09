package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class avr extends Drawable
{
  private int a;
  private long b = -1L;
  private long c;
  private float d;
  private float e;
  private Paint f;
  private RectF g = new RectF();
  private int h = -1052689;
  private int i = -16732417;
  private Point j = new Point();
  private int k = 0;
  private Interpolator l;
  private Interpolator m;

  public avr(Context paramContext)
  {
    this(paramContext, (int)(paramContext.getResources().getDisplayMetrics().density * 40.0F));
  }

  public avr(Context paramContext, int paramInt)
  {
    this.a = paramInt;
    this.f = new Paint(1);
    this.f.setStyle(Style.STROKE);
    this.f.setStrokeCap(Cap.ROUND);
    this.f.setColor(-16776961);
    this.d = (paramInt * 2 / 5);
    this.e = (this.d / 10.0F);
    this.f.setStrokeWidth(this.e);
    this.k = 1;
    this.l = new AccelerateInterpolator(1.25F);
    this.m = new DecelerateInterpolator(1.25F);
  }

  private float a(float paramFloat)
  {
    if (paramFloat <= 0.5F)
      return this.l.getInterpolation(paramFloat * 2.0F) / 2.0F;
    return this.m.getInterpolation(paramFloat * 2.0F - 1.0F) / 2.0F + 0.5F;
  }

  private void a()
  {
    float f1 = (float)(this.c - this.b) % 1250.0F;
    this.j.x = ((int)(a(Math.min(f1 / 1000.0F, 1.0F)) * 360.0F) + this.k);
    this.j.y = ((int)(a(Math.max((f1 - 250.0F) / 1000.0F, 0.0F)) * 360.0F) - this.k);
  }

  private int b()
  {
    return (int)((float)(this.c - this.b) % 2500.0F / 2500.0F * 360.0F);
  }

  public void draw(Canvas paramCanvas)
  {
    this.c = System.currentTimeMillis();
    if (this.b < 0L)
      this.b = this.c;
    Rect localRect = getBounds();
    float f1 = localRect.exactCenterX();
    float f2 = localRect.exactCenterY();
    this.g.set(f1 - this.d, f2 - this.d, this.d + f1, this.d + f2);
    this.f.setColor(this.h);
    paramCanvas.drawCircle(f1, f2, this.d, this.f);
    paramCanvas.save();
    paramCanvas.rotate(b(), this.g.centerX(), this.g.centerY());
    this.f.setColor(this.i);
    a();
    paramCanvas.drawArc(this.g, this.j.x - 90, this.j.y - this.j.x, false, this.f);
    paramCanvas.restore();
  }

  public int getIntrinsicHeight()
  {
    return this.a;
  }

  public int getIntrinsicWidth()
  {
    return this.a;
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
 * Qualified Name:     avr
 * JD-Core Version:    0.6.2
 */