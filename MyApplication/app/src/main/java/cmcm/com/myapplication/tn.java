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
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class tn extends Drawable
  implements Animatable, Runnable
{
  private final int a;
  private long b = -1L;
  private long c;
  private final float d;
  private final float e;
  private final Paint f;
  private final RectF g = new RectF();
  private final int h;
  private final int i;
  private final Point j = new Point();
  private int k = 0;
  private final Interpolator l;
  private final Interpolator m;
  private boolean n = false;

  public tn(Context paramContext)
  {
    this(paramContext, 0, 0);
  }

  public tn(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 0);
  }

  public tn(Context paramContext, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 == 0)
      i1 = (int)(paramContext.getResources().getDisplayMetrics().density * 40.0F);
    this.a = i1;
    paramInt1 = paramInt2;
    if (paramInt2 == 0)
      paramInt1 = paramContext.getResources().getColor(tq.hola_custom_dialog_primary_color);
    this.i = paramInt1;
    this.f = new Paint(1);
    this.f.setStyle(Style.STROKE);
    this.f.setStrokeCap(Cap.ROUND);
    this.f.setColor(this.i);
    this.d = (this.a * 2 / 5);
    this.e = (this.d / 10.0F);
    this.f.setStrokeWidth(this.e);
    this.k = 1;
    this.l = new AccelerateInterpolator(1.25F);
    this.m = new DecelerateInterpolator(1.25F);
    this.h = -1052689;
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

  public boolean isRunning()
  {
    return this.n;
  }

  public void run()
  {
    int i2 = getLevel() + 500;
    int i1 = i2;
    if (i2 >= 10000)
      i1 = 0;
    setLevel(i1);
    invalidateSelf();
    scheduleSelf(this, SystemClock.uptimeMillis() + 50L);
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }

  public void start()
  {
    if (!this.n)
    {
      this.n = true;
      run();
    }
  }

  public void stop()
  {
    if (this.n)
    {
      this.n = false;
      unscheduleSelf(this);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     tn
 * JD-Core Version:    0.6.2
 */