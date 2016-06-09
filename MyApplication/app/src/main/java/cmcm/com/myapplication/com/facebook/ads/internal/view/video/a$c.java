package cmcm.com.myapplication.com.facebook.ads.internal.view.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;

class a$c extends Button
{
  private Paint b;
  private Path c;
  private Path d;
  private Path e;
  private int f;
  private boolean g = true;

  public a$c(a parama, Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void a()
  {
    this.f = 60;
    this.c = new Path();
    this.d = new Path();
    this.e = new Path();
    this.b = new Paint()
    {
    };
    b();
    setClickable(true);
    setBackgroundColor(0);
  }

  private void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    refreshDrawableState();
    invalidate();
  }

  private void b()
  {
    Object localObject = getResources().getDisplayMetrics();
    int i = (int)(this.f * ((DisplayMetrics)localObject).density);
    float f1 = this.f;
    localObject = new RelativeLayout.LayoutParams(i, (int)(((DisplayMetrics)localObject).density * f1));
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }

  private boolean c()
  {
    return this.g;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((paramCanvas.isHardwareAccelerated()) && (Build.VERSION.SDK_INT < 17))
      setLayerType(1, null);
    float f1 = Math.max(paramCanvas.getWidth(), paramCanvas.getHeight()) / 100.0F;
    if (c())
    {
      this.e.rewind();
      this.e.moveTo(26.5F * f1, 15.5F * f1);
      this.e.lineTo(26.5F * f1, 84.5F * f1);
      this.e.lineTo(82.5F * f1, 50.5F * f1);
      this.e.lineTo(26.5F * f1, f1 * 15.5F);
      this.e.close();
      paramCanvas.drawPath(this.e, this.b);
    }
    while (true)
    {
      super.onDraw(paramCanvas);
      return;
      this.c.rewind();
      this.c.moveTo(29.0F * f1, 21.0F * f1);
      this.c.lineTo(29.0F * f1, 79.0F * f1);
      this.c.lineTo(45.0F * f1, 79.0F * f1);
      this.c.lineTo(45.0F * f1, 21.0F * f1);
      this.c.lineTo(29.0F * f1, 21.0F * f1);
      this.c.close();
      this.d.rewind();
      this.d.moveTo(55.0F * f1, 21.0F * f1);
      this.d.lineTo(55.0F * f1, 79.0F * f1);
      this.d.lineTo(71.0F * f1, 79.0F * f1);
      this.d.lineTo(71.0F * f1, 21.0F * f1);
      this.d.lineTo(55.0F * f1, f1 * 21.0F);
      this.d.close();
      paramCanvas.drawPath(this.c, this.b);
      paramCanvas.drawPath(this.d, this.b);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.video.a.c
 * JD-Core Version:    0.6.2
 */