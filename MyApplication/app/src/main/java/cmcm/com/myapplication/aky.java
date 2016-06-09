package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Scroller;
import java.util.ArrayList;

public class aky extends akz
  implements OnClickListener
{
  private Path B;
  private Path C;
  private Paint D;
  private Paint E;
  private Paint F;
  private Paint G;
  private Paint H;
  private float I;
  private float J;
  private final PointF K;
  private final PointF L;
  private boolean M;
  private boolean N;
  private long O;
  private Scroller P;
  private float Q;
  private int R;

  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return (1.0F - paramFloat5) * (1.0F - paramFloat5) * (1.0F - paramFloat5) * paramFloat1 + (1.0F - paramFloat5) * 3.0F * (1.0F - paramFloat5) * paramFloat5 * paramFloat2 + (1.0F - paramFloat5) * 3.0F * paramFloat5 * paramFloat5 * paramFloat3 + paramFloat5 * paramFloat5 * paramFloat5 * paramFloat4;
  }

  private float a(alb paramalb, Path paramPath, Paint paramPaint, boolean paramBoolean, float paramFloat)
  {
    float f3 = a(this.o, this.k, paramFloat);
    float f8 = a(this.p, this.l, paramFloat);
    float f5 = getHeight();
    int i = this.c.size();
    float f6 = getWidth();
    paramFloat = getHeight();
    float f1 = -f6 / 2.0F / i;
    float f7 = f6 / i;
    float f9 = paramFloat - getPaddingBottom() - (this.u.bottom - this.u.top) * 1.5F - this.v;
    float f10 = getPaddingTop();
    float f11 = this.u.bottom;
    float f12 = this.u.top;
    float f13 = this.v;
    float f2;
    float f4;
    float f14;
    label197: Object localObject1;
    label231: label252: Object localObject2;
    if (paramBoolean)
    {
      f2 = -this.s;
      f4 = (this.e + this.f) / 2.0F;
      f14 = f3 - f8 - this.s;
      if (!paramBoolean)
        break label663;
      if (this.w != null)
        break label652;
      paramPaint = null;
      localObject1 = paramPaint;
      if (paramPaint == null)
      {
        localObject1 = new alb();
        if (paramalb.b != null)
          break label671;
        paramFloat = (paramalb.f + f4) / 2.0F;
        ((alb)localObject1).b(paramFloat);
      }
      if (!paramBoolean)
        break label707;
      if (this.x != null)
        break label696;
      paramPaint = null;
      localObject2 = (alb)this.c.get(this.c.size() - 1);
      if (!paramBoolean)
        break label950;
      localObject2 = ((alb)localObject2).c;
    }
    label518: label536: label549: label950: 
    while (true)
    {
      Object localObject3;
      if (paramPaint == null)
      {
        localObject3 = new alb();
        if (((alb)localObject2).a == null)
        {
          paramFloat = (((alb)localObject2).f + f4) / 2.0F;
          label318: ((alb)localObject3).b(paramFloat);
        }
      }
      while (true)
      {
        ((alb)localObject2).b = ((alb)localObject3);
        ((alb)localObject3).a = ((alb)localObject2);
        ((alb)localObject1).b = paramalb;
        paramalb.a = ((alb)localObject1);
        long l = getDrawingTime();
        if (l > ((alb)localObject1).v)
        {
          localObject2 = localObject1;
          do
          {
            paramPaint = (Paint)localObject2;
            paramFloat = f1;
            if (((alb)localObject2).a == null)
              break;
            paramPaint = ((alb)localObject2).a;
            f1 -= f7;
            localObject2 = paramPaint;
          }
          while (paramPaint != localObject1);
          ((alb)localObject1).a.b = null;
          ((alb)localObject1).a = null;
          paramFloat = -f7 / 2.0F;
          f4 = -10000.0F;
          f1 = 10000.0F;
          localObject2 = paramPaint;
          f3 = paramFloat;
          paramFloat = f4;
          label450: if (localObject2 != null)
          {
            ((alb)localObject2).m = f3;
            if (f14 == 0.0F)
            {
              f4 = 0.0F;
              label472: ((alb)localObject2).h = (f9 - f4 * (f9 - f10 - (f11 - f12) * 1.5F - f13));
              if (paramFloat >= ((alb)localObject2).h)
                break label931;
              paramFloat = ((alb)localObject2).h;
              if (f1 <= ((alb)localObject2).h)
                break label928;
              f1 = ((alb)localObject2).h;
              localObject2 = ((alb)localObject2).b;
              if (localObject2 != paramPaint)
                break label918;
              localObject2 = paramPaint;
              alb localalb;
              do
              {
                if (localObject2 == null)
                  break;
                ((alb)localObject2).a(l);
                localalb = ((alb)localObject2).b;
                localObject2 = localalb;
              }
              while (localalb != paramPaint);
            }
          }
        }
        while (true)
        {
          f1 = f7 / 2.0F;
          paramPaint = paramalb;
          while (true)
            if ((paramPaint != null) && (paramPaint != localObject3))
            {
              paramPaint.g = f1;
              paramPaint.i = (paramPaint.g + paramPaint.p);
              paramPaint.k = (paramPaint.g + paramPaint.q);
              paramPaint = paramPaint.b;
              f1 += f7;
              continue;
              f2 = 0.0F;
              break;
              paramPaint = this.w.c;
              break label197;
              paramPaint = this.w;
              break label197;
              paramFloat = paramalb.f + (paramalb.f - paramalb.b.f) * 0.2F;
              break label231;
              label696: paramPaint = this.x.c;
              break label252;
              label707: paramPaint = this.x;
              break label252;
              paramFloat = ((alb)localObject2).f + (((alb)localObject2).f - ((alb)localObject2).a.f) * 0.2F;
              break label318;
              f4 = (((alb)localObject2).f - f8 + f2) / f14;
              break label472;
            }
          paramPath.reset();
          paramPath.moveTo(-f7 / 2.0F, ((alb)localObject1).h);
          f1 = -f7 / 2.0F;
          paramPaint = paramalb;
          while (true)
          {
            if (paramPaint != null)
            {
              paramPath.cubicTo(f1 + paramPaint.a.q, paramPaint.a.l, paramPaint.p + (f1 + f7), paramPaint.j, f1 + f7, paramPaint.h);
              if (paramPaint != localObject3);
            }
            else
            {
              paramPath.lineTo(f7 / 2.0F + f6, f5);
              paramPath.lineTo(-f7 / 2.0F, f5);
              paramPath.close();
              paramalb.a = null;
              ((alb)localObject1).b = null;
              ((alb)localObject3).a.b = null;
              ((alb)localObject3).a = null;
              return paramFloat;
            }
            paramPaint = paramPaint.b;
            f1 += f7;
          }
          continue;
          f3 += f7;
          break label450;
          break label536;
          break label518;
          break label549;
          paramFloat = -10000.0F;
        }
        localObject3 = paramPaint;
      }
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 * paramInt2 == 0)
      return;
    paramInt1 = (int)((1.0D - Math.sqrt(0.8509804010391235D)) * 255.0D + 0.5D) << 24;
    float f3 = paramInt2 - getPaddingBottom();
    float f4 = paramInt2 - getPaddingBottom() - (this.u.bottom - this.u.top) * 1.5F - this.v;
    float f2 = this.k - this.l - this.s;
    float f5 = f4 - getPaddingTop() - (this.u.bottom - this.u.top) * 1.5F - this.v;
    float f1;
    if (f2 == 0.0F)
    {
      f1 = 0.0F;
      if (f2 != 0.0F)
        break label286;
    }
    label286: for (f2 = 0.0F; ; f2 = 1.0F)
    {
      f2 = f4 - f2 * f5;
      this.E.setShader(new LinearGradient(0.0F, f4 - f1 * f5, 0.0F, paramInt2, 1090519039, 0xFFFFFF | paramInt1, Shader.TileMode.CLAMP));
      f1 = (f2 - f3) / (f2 - paramInt2);
      Paint localPaint = this.D;
      f3 = paramInt2;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      localPaint.setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { -2130706433, 654311423, 0xFFFFFF | paramInt1 }, new float[] { 0.0F, f1, 1.0F }, localTileMode));
      return;
      f1 = (this.m - this.l) / f2;
      break;
    }
  }

  private void g()
  {
    boolean bool = false;
    float f1 = 1.0F;
    if ((this.a == null) || (this.b == null))
    {
      this.B = null;
      this.C = null;
      return;
    }
    if ((getWidth() == 0) || (getHeight() == 0))
    {
      invalidate();
      return;
    }
    float f2;
    if ((this.B == null) || (this.C == null) || (this.A))
    {
      if (this.B == null)
        this.B = new Path();
      if (this.C == null)
        this.C = new Path();
      if (this.i)
        break label192;
      f2 = this.z.j();
      if (this.z.i())
        break label181;
      bool = false;
    }
    while (true)
    {
      a(f1);
      a(this.b, this.C, this.E, false, f1);
      a(this.a, this.B, this.D, true, f1);
      this.A = bool;
      return;
      label181: invalidate();
      f1 = f2;
      bool = true;
      continue;
      label192: bool = false;
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
    this.A = true;
    return f1;
  }

  private float i()
  {
    long l = getDrawingTime();
    if (this.O == -1L)
      this.O = l;
    float f = (float)(l - this.O) / 500.0F;
    if (f >= 1.0F)
    {
      this.M = false;
      return 1.0F;
    }
    return f;
  }

  private alb j()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.d != null) && (this.d.s))
      localObject1 = this.d;
    alb localalb;
    do
    {
      do
      {
        return localObject1;
        this.d = null;
        localObject1 = localObject2;
      }
      while (this.c.size() == 0);
      localalb = this.b;
      localObject1 = localObject2;
    }
    while (localalb == null);
    if (localalb.b == null)
      this.d = localalb;
    label162: 
    while (true)
    {
      return this.d;
      int j = this.c.size();
      int i = 0;
      label83: if (i < j)
      {
        localObject1 = (alb)this.c.get(i);
        if (((alb)localObject1).s)
          this.d = ((alb)localObject1);
      }
      for (i = 1; ; i = 0)
      {
        if (i != 0)
          break label162;
        this.d = ((alb)this.c.get(0));
        this.d.s = true;
        break;
        i += 1;
        break label83;
      }
    }
  }

  private void k()
  {
    this.R = 0;
    this.L.set(this.K);
    alb localalb1 = j();
    alb localalb2;
    float f3;
    float f1;
    if (localalb1 != null)
    {
      localalb2 = localalb1.c;
      if (localalb1.u < 0.0F)
        break label409;
      if (localalb1.b != null)
        break label298;
      f3 = localalb1.g;
      f2 = localalb1.h;
      if (localalb2.b != null)
        break label371;
      f1 = localalb2.h;
    }
    while (true)
    {
      if ((this.L.x > f3 - this.v) && (this.L.x < f3 + this.v) && (this.L.y > f1 - this.v) && (this.L.y < f2 + this.v))
      {
        this.R = 1;
        if (!this.P.isFinished())
          this.P.abortAnimation();
        this.Q = (localalb1.g + localalb1.u * getWidth() / this.c.size() - this.L.x);
        if (getParent() != null)
          getParent().requestDisallowInterceptTouchEvent(true);
      }
      if (this.R == 0)
      {
        i = (int)(getWidth() * 1.0F / this.c.size());
        f1 = (this.L.x - i / 2.0F) / i;
        if ((f1 >= 0.0F) && (f1 <= this.c.size() - 1))
          break label572;
        this.R = 0;
      }
      return;
      label298: f3 = a(localalb1.g, localalb1.k, localalb1.b.i, localalb1.b.g, localalb1.u);
      f2 = a(localalb1.h, localalb1.l, localalb1.b.j, localalb1.b.h, localalb1.u);
      break;
      label371: f1 = a(localalb2.h, localalb2.l, localalb2.b.j, localalb2.b.h, localalb1.u);
      continue;
      label409: if (localalb1.a == null)
        f1 = localalb1.g;
      for (f2 = localalb1.h; ; f2 = a(localalb1.h, localalb1.j, localalb1.a.l, localalb1.a.h, -localalb1.u))
      {
        if (localalb2.a != null)
          break label527;
        f4 = localalb2.h;
        f3 = f1;
        f1 = f4;
        break;
        f1 = a(localalb1.g, localalb1.i, localalb1.a.k, localalb1.a.g, -localalb1.u);
      }
      label527: float f4 = a(localalb2.h, localalb2.j, localalb2.a.l, localalb2.a.h, -localalb1.u);
      f3 = f1;
      f1 = f4;
    }
    label572: int i = (int)Math.floor(f1);
    float f2 = f1 - i;
    localalb1 = (alb)this.c.get(i);
    if (localalb1.b == null)
    {
      f1 = localalb1.h;
      localalb1 = localalb1.c;
      if (localalb1.b != null)
        break label711;
    }
    label711: for (f2 = localalb1.h; ; f2 = a(localalb1.h, localalb1.l, localalb1.b.j, localalb1.b.h, f2))
    {
      if ((this.L.y >= f1 + this.v) || (this.L.y <= f2 - this.v))
        break label745;
      this.R = 2;
      return;
      f1 = a(localalb1.h, localalb1.l, localalb1.b.j, localalb1.b.h, f2);
      break;
    }
    label745: this.R = 0;
  }

  private void l()
  {
    float f1 = this.K.x;
    float f2 = this.L.x;
    float f3 = this.K.y;
    float f4 = this.L.y;
    if (this.R == 2)
      if ((Math.abs(f1 - f2) > this.v / 2.0F) || (Math.abs(f3 - f4) > this.v / 2.0F))
        this.R = 0;
    while (this.R != 1)
      return;
    f1 = this.K.x;
    f2 = this.Q;
    f3 = getWidth() * 1.0F / this.c.size();
    f1 = (f1 + f2 - f3 / 2.0F) / f3;
    int i = (int)(0.5F + f1);
    f2 = i;
    if (i < 0)
    {
      f1 = 0.0F;
      i = 0;
    }
    while (true)
    {
      alb localalb = (alb)this.c.get(i);
      j();
      if (localalb != this.d)
      {
        if (this.d != null)
        {
          this.d.u = 0.0F;
          this.d.s = false;
        }
        this.d = localalb;
        this.d.s = true;
      }
      this.d.u = f1;
      invalidate();
      return;
      if (i >= this.c.size())
      {
        i = this.c.size() - 1;
        f1 = 0.0F;
      }
      else
      {
        f1 -= f2;
      }
    }
  }

  private void m()
  {
    if (this.R == 2)
      performClick();
    while (true)
    {
      this.R = 0;
      return;
      o();
    }
  }

  private void n()
  {
    if (this.R == 1)
      o();
    this.R = 0;
  }

  private void o()
  {
    float f1 = this.K.x;
    float f3 = this.Q;
    float f2 = getWidth() * 1.0F / this.c.size();
    f1 = (f1 + f3 - f2 / 2.0F) / f2;
    int i = (int)(0.5F + f1);
    f3 = i;
    if (i < 0)
    {
      f1 = 0.0F;
      i = 0;
    }
    while (true)
    {
      alb localalb = (alb)this.c.get(i);
      j();
      if (localalb != this.d)
      {
        if (this.d != null)
        {
          this.d.u = 0.0F;
          this.d.s = false;
        }
        this.d = localalb;
        this.d.s = true;
      }
      this.d.u = f1;
      if (f1 != 0.0F)
      {
        i = (int)(f2 * f1);
        this.P.startScroll(i, 0, -i, 0, Math.min(Math.abs(i * 4), 500));
        invalidate();
      }
      return;
      if (i >= this.c.size())
      {
        i = this.c.size() - 1;
        f1 = 0.0F;
      }
      else
      {
        f1 -= f3;
      }
    }
  }

  protected void a()
  {
    a(getWidth(), getHeight());
  }

  protected void a(boolean paramBoolean)
  {
    this.O = -1L;
    this.M = true;
    this.N = paramBoolean;
    invalidate();
  }

  public void onClick(View paramView)
  {
    if (this.i)
      break label7;
    label7: 
    while (this.c.isEmpty())
      return;
    paramView = j();
    int i = (int)(getWidth() * 1.0F / this.c.size());
    int j = (int)(this.K.x / i);
    if (j < 0)
      i = 0;
    while (true)
    {
      alb localalb = (alb)this.c.get(i);
      if ((localalb == paramView) || (localalb == null))
        break;
      localalb.s = true;
      if (paramView != null)
        paramView.s = false;
      a(true);
      return;
      i = j;
      if (j >= this.c.size())
        i = this.c.size() - 1;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    boolean bool1 = this.i;
    if (bool1)
      h();
    g();
    if ((this.B == null) || (this.C == null));
    label393: label417: label431: label823: label834: 
    while (true)
    {
      return;
      paramCanvas.drawPath(this.B, this.D);
      paramCanvas.drawPath(this.C, this.E);
      Object localObject;
      float f1;
      float f2;
      float f3;
      if (!bool1)
        if (this.M)
        {
          int j = (int)(i() * 255.0F);
          this.F.setAlpha((int)(j * 0.3F));
          localObject = this.t;
          if (this.N);
          for (int i = 255; ; i = j)
          {
            ((Paint)localObject).setAlpha(i);
            this.G.setAlpha(j);
            this.H.setAlpha((int)(j * 0.3F));
            bool1 = true;
            j = this.c.size();
            i = 0;
            while (i < j)
            {
              localObject = (alb)this.c.get(i);
              paramCanvas.drawText(((alb)localObject).d, ((alb)localObject).g, ((alb)localObject).h + this.y + (this.u.bottom - this.u.top) / 2.0F - this.u.bottom - this.u.top, this.t);
              paramCanvas.drawText(((alb)localObject).c.d, ((alb)localObject).g, ((alb)localObject).c.h - (this.u.bottom - this.u.top) / 2.0F - this.v / 3.0F, this.t);
              i += 1;
            }
          }
          localObject = j();
          bool2 = bool1;
          if (localObject != null)
          {
            bool2 = bool1;
            if (((alb)localObject).c != null)
            {
              if (!this.P.computeScrollOffset())
                break label823;
              f1 = getWidth() * 1.0F / this.c.size();
              ((alb)localObject).u = (this.P.getCurrX() / f1);
              bool1 = true;
              if (((alb)localObject).u < 0.0F)
                break label641;
              if (((alb)localObject).b != null)
                break label514;
              f1 = ((alb)localObject).g;
              if (((alb)localObject).b != null)
                break label552;
              f2 = ((alb)localObject).h;
              if (((alb)localObject).c.b != null)
                break label590;
              f3 = ((alb)localObject).c.h;
              label452: paramCanvas.drawLine(f1, f2, f1, f3 + this.J, this.F);
              paramCanvas.drawCircle(f1, f3, this.I, this.G);
              paramCanvas.drawCircle(f1, f3, this.J, this.H);
            }
          }
        }
      for (boolean bool2 = bool1; ; bool2 = bool1)
      {
        if (!bool2)
          break label834;
        invalidate();
        return;
        f1 = a(((alb)localObject).g, ((alb)localObject).k, ((alb)localObject).b.i, ((alb)localObject).b.g, ((alb)localObject).u);
        break label417;
        f2 = a(((alb)localObject).h, ((alb)localObject).l, ((alb)localObject).b.j, ((alb)localObject).b.h, ((alb)localObject).u);
        break label431;
        label590: f3 = a(((alb)localObject).c.h, ((alb)localObject).c.l, ((alb)localObject).c.b.j, ((alb)localObject).c.b.h, ((alb)localObject).u);
        break label452;
        if (((alb)localObject).a == null)
        {
          f1 = ((alb)localObject).g;
          if (((alb)localObject).a != null)
            break label732;
          f2 = ((alb)localObject).h;
          if (((alb)localObject).c.a != null)
            break label771;
        }
        for (f3 = ((alb)localObject).c.h; ; f3 = a(((alb)localObject).c.h, ((alb)localObject).c.j, ((alb)localObject).c.a.l, ((alb)localObject).c.a.h, -((alb)localObject).u))
        {
          break;
          f1 = a(((alb)localObject).g, ((alb)localObject).i, ((alb)localObject).a.k, ((alb)localObject).a.g, -((alb)localObject).u);
          break label655;
          label732: f2 = a(((alb)localObject).h, ((alb)localObject).j, ((alb)localObject).a.l, ((alb)localObject).a.h, -((alb)localObject).u);
          break label669;
        }
        break label393;
        break;
      }
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.b == null) || (this.b.b == null));
    while (true)
    {
      return false;
      this.K.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      default:
      case 0:
      case 2:
      case 1:
      case 3:
      }
      while (this.R != 0)
      {
        return true;
        k();
        continue;
        l();
        continue;
        m();
        continue;
        n();
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aky
 * JD-Core Version:    0.6.2
 */