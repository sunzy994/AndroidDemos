package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.lazyswipe.SwipeApplication;

public class yq extends Drawable
{
  private int a;
  private int b;
  private float c;
  private float d;
  private Path e;
  private final Paint f = new Paint();
  private boolean g = false;
  private float h;
  private final float i = 4.0F;
  private final float j = 1.5F;
  private final int k;

  public yq(Context paramContext, boolean paramBoolean)
  {
    this.f.setStyle(Style.FILL);
    this.f.setStrokeWidth(paramContext.getResources().getDimension(2131296348));
    this.f.setColor(ahx.b(paramContext).l());
    this.f.setAntiAlias(true);
    this.g = paramBoolean;
    this.k = SwipeApplication.c().getResources().getDimensionPixelSize(2131296347);
  }

  private void a()
  {
    if (this.e == null)
      this.e = new Path();
    int m;
    int n;
    float f1;
    float f3;
    PointF localPointF1;
    PointF localPointF2;
    PointF localPointF3;
    PointF localPointF4;
    PointF localPointF5;
    float f4;
    float f2;
    float f5;
    float f6;
    while (true)
    {
      m = getIntrinsicHeight();
      n = getIntrinsicWidth();
      f1 = (float)Math.toDegrees(this.c / this.a);
      f3 = (float)Math.toDegrees(this.d / this.b);
      this.e.reset();
      if (!this.g)
        break label1268;
      localRectF1 = new RectF(-this.a, m - this.a, this.a, this.a + m);
      localRectF2 = new RectF(-this.b, m - this.b, this.b, this.b + m);
      if ((this.c <= 0.0F) || (this.d <= 0.0F))
        break;
      localPointF1 = new PointF((float)((this.a + this.c) * Math.cos(Math.toRadians(4.0F + f1))), (float)(m - (this.a + this.c) * Math.sin(Math.toRadians(4.0F + f1))));
      localPointF2 = new PointF((float)((this.a + this.c) * Math.cos(Math.toRadians(this.h - 4.0F - f1))), (float)(m - (this.a + this.c) * Math.sin(Math.toRadians(this.h - 4.0F - f1))));
      localPointF3 = new PointF((float)((this.b - this.d) * Math.cos(Math.toRadians(5.5F + f3))), (float)(m - (this.b - this.d) * Math.sin(Math.toRadians(5.5F + f3))));
      localPointF4 = new PointF((float)((this.b - this.d) * Math.cos(Math.toRadians(this.h - 4.0F - 1.5F - f3))), (float)(m - (this.b - this.d) * Math.sin(Math.toRadians(this.h - 4.0F - 1.5F - f3))));
      this.e.addCircle(localPointF1.x, localPointF1.y, this.c, Direction.CW);
      this.e.addCircle(localPointF2.x, localPointF2.y, this.c, Direction.CW);
      this.e.addCircle(localPointF3.x, localPointF3.y, this.d, Direction.CW);
      this.e.addCircle(localPointF4.x, localPointF4.y, this.d, Direction.CW);
      localPointF5 = new PointF(localPointF2.x - localPointF4.x, localPointF2.y - localPointF4.y);
      f4 = (this.d - this.c) / localPointF5.length();
      f2 = (float)Math.sqrt(1.0F - f4 * f4);
      localPointF5.set(localPointF5.x * f4 - localPointF5.y * f2, localPointF5.x * f2 + localPointF5.y * f4);
      f5 = localPointF5.length();
      localPointF5.x /= f5;
      localPointF5.y /= f5;
      this.e.moveTo(localPointF2.x + localPointF5.x * this.c, localPointF2.y + localPointF5.y * this.c);
      this.e.lineTo(localPointF4.x + localPointF5.x * this.d, localPointF4.y + localPointF5.y * this.d);
      this.e.lineTo((float)(this.b * Math.cos(Math.toRadians(this.h - 4.0F - 1.5F - f3))), (float)(m - this.b * Math.sin(Math.toRadians(this.h - 4.0F - 1.5F - f3))));
      this.e.arcTo(localRectF2, -this.h + 4.0F + 1.5F + f3, this.h - 8.0F - 3.0F - f3 * 2.0F);
      localPointF5.set(localPointF3.x - localPointF1.x, localPointF3.y - localPointF1.y);
      f3 = -f4;
      f4 = localPointF5.x;
      f5 = localPointF5.y;
      f6 = localPointF5.x;
      localPointF5.set(f4 * f3 - f5 * f2, f3 * localPointF5.y + f6 * f2);
      f2 = localPointF5.length();
      localPointF5.x /= f2;
      localPointF5.y /= f2;
      this.e.lineTo(localPointF3.x + localPointF5.x * this.d, localPointF3.y + localPointF5.y * this.d);
      this.e.lineTo(localPointF1.x + localPointF5.x * this.c, localPointF1.y + localPointF5.y * this.c);
      this.e.lineTo((float)(this.a * Math.cos(Math.toRadians(4.0F + f1))), (float)(m - this.a * Math.sin(Math.toRadians(4.0F + f1))));
      this.e.arcTo(localRectF1, -4.0F - f1, f1 * 2.0F + (-this.h + 8.0F));
      return;
      this.e.reset();
    }
    this.e.moveTo((float)(this.a * Math.cos(Math.toRadians(4.0D))), (float)(m - this.a * Math.sin(Math.toRadians(4.0D))));
    this.e.arcTo(localRectF1, -4.0F, -this.h + 8.0F);
    this.e.lineTo((float)(this.b * Math.cos(Math.toRadians(this.h - 4.0F - 1.5F))), (float)(m - this.b * Math.sin(Math.toRadians(this.h - 4.0F - 1.5F))));
    this.e.arcTo(localRectF2, -this.h + 4.0F + 1.5F, this.h - 8.0F - 3.0F);
    this.e.close();
    return;
    label1268: RectF localRectF1 = new RectF(n - this.a, m - this.a, this.a + n, this.a + m);
    RectF localRectF2 = new RectF(n - this.b, m - this.b, this.b + n, this.b + m);
    if ((this.c > 0.0F) && (this.d > 0.0F))
    {
      localPointF1 = new PointF((float)(n - (this.a + this.c) * Math.cos(Math.toRadians(4.0F + f1))), (float)(m - (this.a + this.c) * Math.sin(Math.toRadians(4.0F + f1))));
      localPointF2 = new PointF((float)(n - (this.a + this.c) * Math.cos(Math.toRadians(this.h - 4.0F - f1))), (float)(m - (this.a + this.c) * Math.sin(Math.toRadians(this.h - 4.0F - f1))));
      localPointF3 = new PointF((float)(n - (this.b - this.d) * Math.cos(Math.toRadians(5.5F + f3))), (float)(m - (this.b - this.d) * Math.sin(Math.toRadians(5.5F + f3))));
      localPointF4 = new PointF((float)(n - (this.b - this.d) * Math.cos(Math.toRadians(this.h - 4.0F - 1.5F - f3))), (float)(m - (this.b - this.d) * Math.sin(Math.toRadians(this.h - 4.0F - 1.5F - f3))));
      this.e.addCircle(localPointF1.x, localPointF1.y, this.c, Direction.CCW);
      this.e.addCircle(localPointF2.x, localPointF2.y, this.c, Direction.CCW);
      this.e.addCircle(localPointF3.x, localPointF3.y, this.d, Direction.CCW);
      this.e.addCircle(localPointF4.x, localPointF4.y, this.d, Direction.CCW);
      localPointF5 = new PointF(localPointF4.x - localPointF2.x, localPointF4.y - localPointF2.y);
      f4 = -(this.d - this.c) / localPointF5.length();
      f2 = (float)Math.sqrt(1.0F - f4 * f4);
      localPointF5.set(localPointF5.x * f4 - localPointF5.y * f2, localPointF5.x * f2 + localPointF5.y * f4);
      f5 = localPointF5.length();
      localPointF5.x /= f5;
      localPointF5.y /= f5;
      this.e.moveTo(localPointF2.x + localPointF5.x * this.c, localPointF2.y + localPointF5.y * this.c);
      this.e.lineTo(localPointF4.x + localPointF5.x * this.d, localPointF4.y + localPointF5.y * this.d);
      this.e.lineTo((float)(n - this.b * Math.cos(Math.toRadians(this.h - 4.0F - 1.5F - f3))), (float)(m - this.b * Math.sin(Math.toRadians(this.h - 4.0F - 1.5F - f3))));
      this.e.arcTo(localRectF2, -180.0F + this.h - 4.0F - 1.5F - f3, f3 * 2.0F + (-this.h + 8.0F + 3.0F));
      localPointF5.set(localPointF1.x - localPointF3.x, localPointF1.y - localPointF3.y);
      f3 = -f4;
      f4 = localPointF5.x;
      f5 = localPointF5.y;
      f6 = localPointF5.x;
      localPointF5.set(f4 * f3 - f5 * f2, f3 * localPointF5.y + f6 * f2);
      f2 = localPointF5.length();
      localPointF5.x /= f2;
      localPointF5.y /= f2;
      this.e.lineTo(localPointF3.x + localPointF5.x * this.d, localPointF3.y + localPointF5.y * this.d);
      this.e.lineTo(localPointF1.x + localPointF5.x * this.c, localPointF1.y + localPointF5.y * this.c);
      this.e.lineTo((float)(n - this.a * Math.cos(Math.toRadians(4.0F + f1))), (float)(m - this.a * Math.sin(Math.toRadians(4.0F + f1))));
      this.e.arcTo(localRectF1, -176.0F + f1, this.h - 8.0F - f1 * 2.0F);
      return;
    }
    this.e.moveTo((float)(n - this.a * Math.cos(Math.toRadians(4.0D))), (float)(m - this.a * Math.sin(Math.toRadians(4.0D))));
    this.e.arcTo(localRectF1, -176.0F, this.h - 8.0F);
    this.e.lineTo((float)(n - this.b * Math.cos(Math.toRadians(this.h - 4.0F - 1.5F))), (float)(m - this.b * Math.sin(Math.toRadians(this.h - 4.0F - 1.5F))));
    this.e.arcTo(localRectF2, -180.0F + this.h - 4.0F - 1.5F, -this.h + 8.0F + 3.0F);
    this.e.close();
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, false);
  }

  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.c = paramFloat1;
    this.d = (1.25F * paramFloat2);
    if (paramBoolean)
      a();
  }

  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true);
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 != this.a) || (paramInt2 != this.b))
    {
      this.a = (this.k + paramInt1);
      this.b = (paramInt2 - this.k);
      if (paramBoolean)
        a();
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    float f1 = 90.0F / paramInt;
    if (Math.abs(f1 - this.h) >= 0.01D)
    {
      this.h = f1;
      if (paramBoolean)
        a();
    }
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.e == null)
      return;
    paramCanvas.drawPath(this.e, this.f);
  }

  public int getIntrinsicHeight()
  {
    return (int)((this.b + this.k) * Math.sin(this.h * 3.141592653589793D / 180.0D));
  }

  public int getIntrinsicWidth()
  {
    return this.b + this.k;
  }

  public int getOpacity()
  {
    return -3;
  }

  public void setAlpha(int paramInt)
  {
    this.f.setAlpha(this.f.getAlpha() * paramInt / 255);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yq
 * JD-Core Version:    0.6.2
 */