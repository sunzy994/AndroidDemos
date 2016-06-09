package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class akj extends akr
{
  private float A = asq.a(2.0F);
  private float B = asq.a(1.67F);
  private float C = this.w + this.x + this.z + this.v;
  private final RectF D = new RectF(0.0F, 0.0F, this.o, this.s * 2.0F + this.C);
  private final RectF E = new RectF();
  private int F = 0;
  private final int G = 30;
  private final int H = 45;
  private final int I = 95;
  private final int J = 115;
  private float K = asq.a(1.33F);
  private float L = this.K;
  private float M = 0.0F;
  private float N = this.f;
  private float O = this.f + this.y;
  private float P = this.e;
  private float Q = this.e;
  private float R;
  private float S;
  private float T = 0.0F;
  private float U = 0.0F;
  float a = this.s;
  float b = this.s + this.C;
  float c = this.s * 2.0F + this.t / 4.0F;
  float d = this.s * 2.0F - this.t + this.C;
  float e = this.s * 2.0F;
  float f = this.w + this.x + this.z + this.v + this.s / 4.0F;
  private Paint l;
  private Paint m;
  private Paint n;
  private float o = asq.a(46.0F);
  private final PorterDuffXfermode p = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
  private final PorterDuffXfermode q = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  private final PorterDuffXfermode r = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
  private float s = asq.a(12.0F);
  private float t = asq.a(8.0F);
  private float u = asq.a(11.0F);
  private float v = asq.a(10.0F);
  private float w = asq.a(6.0F);
  private float x = asq.a(3.33F);
  private float y = asq.a(0.2F);
  private float z = asq.a(0.33F);

  public akj(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void f()
  {
    if (this.F <= 30)
      this.M = (this.F * 1.0F / 30.0F * (this.v * 2.0F));
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      invalidate();
      return;
      float f1;
      if ((this.F > 30) && (this.F <= 45))
      {
        f1 = (this.F - 30) * 1.0F / 15.0F;
        this.L = (this.v * f1);
        this.N = (this.f - (this.f - this.A) * f1);
        this.O = (this.f + this.y - f1 * (this.f - this.A));
        this.R = this.N;
      }
      else
      {
        float f2;
        if ((this.F > 45) && (this.F <= 95))
        {
          f1 = (this.F - 45) * 1.0F / 50.0F;
          f2 = this.R;
          this.N = (f1 * (this.f - this.v - this.z - this.x - this.w) + f2);
          this.O = (this.N + this.y);
          this.S = this.O;
        }
        else if ((this.F > 95) && (this.F <= 115))
        {
          f1 = (this.F - 95) * 1.0F / 20.0F;
          f2 = this.S;
          this.O = (f1 * this.x + f2);
        }
      }
    }
    postInvalidate();
  }

  public void a()
  {
    setLayerType(1, null);
    this.l = new Paint(1);
    this.l.setStyle(Style.FILL);
    this.l.setStrokeCap(Cap.ROUND);
    this.m = new Paint(1);
    this.m.setStyle(Style.FILL);
    this.m.setStrokeCap(Cap.ROUND);
    this.m.setXfermode(this.r);
    this.m.setColor(-14336);
    this.n = new Paint(1);
    this.n.setStyle(Style.FILL);
    this.n.setStrokeCap(Cap.ROUND);
    this.n.setColor(-14336);
    this.n.setXfermode(this.r);
    this.n.setStrokeWidth(this.B);
    this.j = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          akj.this.c();
          continue;
          if (!akj.this.b())
            akj.this.c();
          akj.this.j.sendEmptyMessageDelayed(1, akj.this.i);
          continue;
          if (akj.this.getParent() != null)
            akj.this.k.run();
        }
      }
    };
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.T = paramFloat1;
    this.U = paramFloat2;
  }

  public boolean b()
  {
    return (this.F > 0) && (this.F <= 115);
  }

  public void c()
  {
    this.F = 0;
    this.L = this.K;
    this.M = 0.0F;
    this.N = this.f;
    this.O = (this.f + this.y);
    this.R = 0.0F;
    this.S = 0.0F;
    invalidate();
  }

  public void d()
  {
    this.o = (asq.a(46.0F) * 0.6666667F);
    this.s = (asq.a(12.0F) * 0.6666667F);
    this.t = (asq.a(8.0F) * 0.6666667F);
    this.u = (asq.a(11.0F) * 0.6666667F);
    this.v = (asq.a(10.0F) * 0.6666667F);
    this.w = (asq.a(6.0F) * 0.6666667F);
    this.x = (asq.a(3.33F) * 0.6666667F);
    this.y = (asq.a(0.2F) * 0.6666667F);
    this.z = (asq.a(0.33F) * 0.6666667F);
    this.A = (asq.a(2.0F) * 0.6666667F);
    this.K = (asq.a(1.33F) * 0.6666667F);
    this.B = (0.6666667F * asq.a(1.67F));
    this.C = (this.w + this.x + this.z + this.v);
    this.a = this.s;
    this.b = (this.s + this.C);
    this.c = (this.s * 2.0F + this.t / 4.0F);
    this.d = (this.s * 2.0F - this.t + this.C);
    this.e = (this.s * 2.0F);
    this.f = (this.w + this.x + this.z + this.v + this.s / 4.0F);
    this.L = this.K;
    this.N = this.f;
    this.O = (this.f + this.y);
    this.P = this.e;
    this.Q = this.e;
  }

  public void e()
  {
    this.F = 116;
    this.M = (this.v * 2.0F);
    this.L = this.v;
    this.N = (this.A + (this.f - this.v - this.z - this.x - this.w));
    this.O = (this.N + this.y + this.x);
  }

  public float getViewWidth()
  {
    return this.e + this.x + this.z + this.A;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.T, this.U);
    this.l.setXfermode(this.p);
    paramCanvas.saveLayer(this.D, this.l, 31);
    this.l.setColor(-1);
    this.l.setStyle(Style.FILL);
    this.l.setStrokeWidth(this.s - this.t);
    float f1 = this.s;
    float f2 = this.s;
    float f3 = (this.s - this.t) / 2.0F;
    float f4 = this.C;
    float f5 = this.c;
    float f6 = this.s;
    float f7 = (this.s - this.t) / 2.0F;
    paramCanvas.drawLine(f1, f4 + (f2 * 2.0F - f3), f5, this.C + (f6 * 2.0F - f7), this.l);
    paramCanvas.drawCircle(this.c, this.d, this.t, this.l);
    this.l.setColor(-1);
    paramCanvas.drawCircle(this.a, this.b, this.s, this.l);
    this.l.setXfermode(this.q);
    this.l.setStrokeWidth(1.0F);
    paramCanvas.drawCircle(this.c - this.t, (this.s - this.t) * 3.0F + this.C, this.u, this.l);
    if (this.F <= 30)
    {
      this.E.set(this.e - this.K, this.f + this.v - this.M, this.e + this.K, this.f + this.v);
      paramCanvas.drawRoundRect(this.E, 5.0F, 5.0F, this.m);
    }
    while (true)
    {
      paramCanvas.restore();
      this.F += 1;
      if (this.F <= 115)
        f();
      super.onDraw(paramCanvas);
      return;
      this.E.set(this.e - this.L, this.f + this.v - this.M, this.e + this.L, this.f + this.v);
      paramCanvas.drawOval(this.E, this.m);
      int i = 0;
      while (i < 8)
      {
        paramCanvas.drawLine(this.P, this.N, this.Q, this.O, this.n);
        paramCanvas.rotate(45.0F, this.e, this.f);
        i += 1;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akj
 * JD-Core Version:    0.6.2
 */