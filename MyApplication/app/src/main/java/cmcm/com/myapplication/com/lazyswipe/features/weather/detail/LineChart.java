package cmcm.com.myapplication.com.lazyswipe.features.weather.detail;

import akz;
import alb;
import ale;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import java.util.ArrayList;

public class LineChart extends akz
{
  private Paint B;
  private boolean C = true;
  private Path D;
  private Path E;
  private Path F;
  private final long G = 1000L;
  private boolean H = true;
  private boolean I = false;
  private long J = 500L;
  private long K = -1L;
  private float L;

  public LineChart(Context paramContext)
  {
    this(paramContext, null);
  }

  public LineChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LineChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }

  public LineChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(paramContext);
  }

  private float a(alb paramalb, Path paramPath, Paint paramPaint, boolean paramBoolean, float paramFloat)
  {
    float f1 = a(this.o, this.k, paramFloat);
    float f5 = a(this.p, this.l, paramFloat);
    int i = this.c.size();
    float f2 = getWidth();
    paramFloat = getHeight();
    float f4 = f2 / i;
    float f6 = (this.u.bottom - this.u.top) * 3.0F;
    float f7 = paramFloat - getPaddingBottom() - f6;
    float f8 = getPaddingTop();
    float f3;
    float f9;
    label152: Object localObject1;
    label186: label207: Object localObject2;
    if (paramBoolean)
    {
      f2 = -this.s;
      f3 = (this.e + this.f) / 2.0F;
      f9 = f1 - f5 - this.s;
      if (!paramBoolean)
        break label525;
      if (this.w != null)
        break label514;
      paramPaint = null;
      localObject1 = paramPaint;
      if (paramPaint == null)
      {
        localObject1 = new alb();
        if (paramalb.b != null)
          break label533;
        paramFloat = (paramalb.f + f3) / 2.0F;
        ((alb)localObject1).b(paramFloat);
      }
      if (!paramBoolean)
        break label569;
      if (this.x != null)
        break label558;
      paramPaint = null;
      localObject2 = (alb)this.c.get(this.c.size() - 1);
      if (!paramBoolean)
        break label762;
      localObject2 = ((alb)localObject2).c;
    }
    label276: label434: label452: label605: label750: label753: label756: label759: label762: 
    while (true)
    {
      Object localObject3 = paramPaint;
      if (paramPaint == null)
      {
        localObject3 = new alb();
        if (((alb)localObject2).a == null)
        {
          paramFloat = (((alb)localObject2).f + f3) / 2.0F;
          ((alb)localObject3).b(paramFloat);
        }
      }
      else
      {
        ((alb)localObject2).b = ((alb)localObject3);
        ((alb)localObject3).a = ((alb)localObject2);
        ((alb)localObject1).b = paramalb;
        paramalb.a = ((alb)localObject1);
        paramFloat = -10000.0F;
        f1 = 10000.0F;
        if (getDrawingTime() > ((alb)localObject1).v)
        {
          localObject2 = localObject1;
          do
          {
            paramPaint = (Paint)localObject2;
            if (((alb)localObject2).a == null)
              break;
            paramPaint = ((alb)localObject2).a;
            localObject2 = paramPaint;
          }
          while (paramPaint != localObject1);
          ((alb)localObject1).a.b = null;
          ((alb)localObject1).a = null;
          localObject2 = paramPaint;
          paramFloat = -10000.0F;
          label382: if (localObject2 == null)
            break label759;
          if (f9 != 0.0F)
            break label605;
          f3 = 0.0F;
          ((alb)localObject2).h = (f7 - f3 * (f7 - f8 - f6));
          if (paramFloat >= ((alb)localObject2).h)
            break label756;
          paramFloat = ((alb)localObject2).h;
          if (f1 <= ((alb)localObject2).h)
            break label753;
          f1 = ((alb)localObject2).h;
          localObject2 = ((alb)localObject2).b;
          if (localObject2 != paramPaint)
            break label750;
        }
      }
      while (true)
      {
        paramPath.reset();
        f1 = f4 / 2.0F;
        paramPaint = paramalb;
        while (true)
          if ((paramPaint != null) && (paramPaint != localObject3))
          {
            paramPaint.g = f1;
            paramPaint = paramPaint.b;
            f1 += f4;
            continue;
            f2 = 0.0F;
            break;
            paramPaint = this.w.c;
            break label152;
            paramPaint = this.w;
            break label152;
            paramFloat = paramalb.f + (paramalb.f - paramalb.b.f) * 0.2F;
            break label186;
            paramPaint = this.x.c;
            break label207;
            paramPaint = this.x;
            break label207;
            paramFloat = ((alb)localObject2).f + (((alb)localObject2).f - ((alb)localObject2).a.f) * 0.2F;
            break label276;
            f3 = (((alb)localObject2).f - f5 + f2) / f9;
            break label397;
          }
        paramPath.moveTo(paramalb.g, paramalb.h);
        this.F.addCircle(paramalb.g, paramalb.h, this.L, Direction.CCW);
        for (paramPaint = paramalb.b; ; paramPaint = paramPaint.b)
        {
          if ((paramPaint == null) || (paramPaint == localObject3) || (paramPaint == localObject1))
          {
            paramalb.a = null;
            ((alb)localObject1).b = null;
            ((alb)localObject3).a.b = null;
            ((alb)localObject3).a = null;
            return paramFloat;
          }
          paramPath.lineTo(paramPaint.g, paramPaint.h);
          this.F.addCircle(paramPaint.g, paramPaint.h, this.L, Direction.CCW);
        }
        break label382;
        break label452;
        break label434;
      }
    }
  }

  private void b(Context paramContext)
  {
    setWillNotDraw(false);
    float f = getResources().getDisplayMetrics().density;
    this.B = new Paint();
    this.B.setStyle(Style.STROKE);
    this.B.setStrokeWidth(1.0F * f);
    this.B.setColor(-2130706433);
    this.L = (f * 2.0F);
  }

  private void g()
  {
    float f1 = 1.0F;
    if ((this.a == null) || (this.b == null))
    {
      this.D = null;
      this.E = null;
      this.F = null;
      return;
    }
    if ((getWidth() == 0) || (getHeight() == 0))
    {
      invalidate();
      return;
    }
    if (this.D == null)
      this.D = new Path();
    if (this.E == null)
      this.E = new Path();
    if (this.F == null)
      this.F = new Path();
    float f2;
    boolean bool;
    if (this.C)
      if (!this.i)
      {
        f2 = this.z.j();
        if (!this.z.i())
        {
          bool = false;
          a(f1);
          this.F.reset();
          a(this.b, this.E, null, false, f1);
          a(this.a, this.D, null, true, f1);
        }
      }
    while (true)
    {
      this.C = bool;
      return;
      invalidate();
      f1 = f2;
      bool = true;
      break;
      bool = false;
      break;
      bool = false;
    }
  }

  private float h()
  {
    long l = getDrawingTime();
    if (this.j == -1L)
      this.j = l;
    float f2 = (float)(l - this.j) / 1000.0F;
    float f1 = f2;
    if (f2 >= 1.0F)
    {
      this.i = false;
      f1 = 1.0F;
    }
    f2 = (this.k + this.n) / 2.0F;
    alb localalb = this.a;
    float f3;
    float f4;
    double d1;
    double d2;
    if (localalb != null)
    {
      if (f1 < 0.3F)
      {
        f3 = f1 / 0.3F;
        f4 = this.l;
        float f5 = this.s;
        localalb.f = (f3 * f3 * (f2 - this.l - this.s) + (f4 + f5));
      }
      while (true)
      {
        localalb = localalb.b;
        break;
        if (f1 < 0.9F)
        {
          f3 = (f1 - 0.3F) / 0.6F;
          d1 = f2;
          d2 = localalb.e - f2;
          localalb.f = ((float)(Math.sin(f3 * 1.570796326794897D) * d2 + d1));
        }
      }
    }
    f2 = (this.l + this.m) / 2.0F;
    localalb = this.b;
    if (localalb != null)
    {
      if (f1 < 0.1F)
        localalb.f = this.l;
      while (true)
      {
        localalb = localalb.b;
        break;
        if (f1 < 0.4F)
        {
          f3 = (f1 - 0.1F) / 0.3F;
          f4 = this.l;
          localalb.f = ((1.0F - (1.0F - f3) * (1.0F - f3)) * (f2 - this.l) + f4);
        }
        else
        {
          f3 = (f1 - 0.4F) / 0.6F;
          d1 = f2;
          d2 = localalb.e - f2;
          localalb.f = ((float)(Math.sin(f3 * 1.570796326794897D) * d2 + d1));
        }
      }
    }
    this.C = true;
    return f1;
  }

  protected void a()
  {
  }

  protected void a(boolean paramBoolean)
  {
    this.K = -1L;
    this.H = true;
    this.I = paramBoolean;
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    boolean bool = this.i;
    if (bool)
      h();
    g();
    if ((this.F == null) || (this.D == null) || (this.E == null));
    do
    {
      return;
      paramCanvas.drawPath(this.D, this.B);
      paramCanvas.drawPath(this.E, this.B);
      paramCanvas.drawPath(this.F, this.t);
      if (!bool)
      {
        int j = this.c.size();
        int i = 0;
        while (i < j)
        {
          alb localalb = (alb)this.c.get(i);
          paramCanvas.drawText(localalb.d, localalb.g, localalb.h + this.y + (this.u.bottom - this.u.top) / 2.0F - this.u.bottom - this.u.top, this.t);
          paramCanvas.drawText(localalb.c.d, localalb.g, localalb.c.h - (this.u.bottom - this.u.top) / 2.0F - this.v / 3.0F, this.t);
          i += 1;
        }
      }
    }
    while (!bool);
    invalidate();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.weather.detail.LineChart
 * JD-Core Version:    0.6.2
 */