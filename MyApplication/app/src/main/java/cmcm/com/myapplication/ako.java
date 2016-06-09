package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class ako extends akr
{
  private float A = asq.a(16.67F);
  private float B = this.A * 3.0F / 2.0F;
  private int C;
  private int D;
  private float E = asq.a(0.67F);
  private float F = this.e / 2.0F - this.E;
  private float G = 0.0F;
  private float H = this.F;
  private float I;
  private float J = asq.a(2.0F);
  private float K = this.m + this.F / 2.0F;
  private float L = this.e * 2.0F + this.J;
  private float M = this.e * 2.0F + this.J;
  private float N = (this.m + this.o + this.F) / 2.0F;
  private float O = this.e * 2.0F + this.J;
  private float P = this.e * 2.0F + this.J;
  private float Q = this.o + this.F / 2.0F;
  private float R = this.e * 2.0F + this.J;
  private float S = this.e * 2.0F + this.J;
  private float T = asq.a(3.33F);
  private final RectF U = new RectF(0.0F, 0.0F, this.d, this.e * 2.0F + this.B);
  private RectF V = new RectF(this.m - this.F / 2.0F, this.e * 2.0F + this.B - (this.N - this.F / 2.0F) / 6.0F, this.N, this.e * 2.0F + this.B + (this.N - this.F / 2.0F) / 4.0F);
  private RectF W = new RectF(-this.K * 2.0F + this.T * 8.0F, this.e * 2.0F + this.B - this.N / 2.0F, this.K, this.e * 2.0F + this.B + this.N / 2.0F);
  private Paint a;
  private RectF aa = new RectF(this.Q, this.e * 2.0F + this.B - (this.N - this.F / 2.0F) / 3.0F, this.Q + (this.d - this.Q) * 2.0F - this.T * 2.0F, this.e * 2.0F + this.B + (this.N - this.F / 2.0F) / 3.0F);
  private float ab;
  private float ac;
  private float ad;
  private float ae;
  private float af = -180.0F;
  private float ag;
  private float ah;
  private float ai;
  private float aj = asq.a(10.0F);
  private float ak = asq.a(7.0F);
  private float al = asq.a(8.0F);
  private float am = 0.0F;
  private float an = 0.0F;
  private float ao = asq.a(2.33F);
  private final PorterDuffXfermode b = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
  private final PorterDuffXfermode c = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  private float d = asq.a(46.0F);
  private float e = asq.a(13.33F);
  private float f = asq.a(10.0F);
  private float l = asq.a(15.0F);
  private float m = this.e;
  private float n = this.e;
  private float o = this.e * 2.0F + this.f / 4.0F;
  private float p = this.e * 2.0F - this.f;
  private int q = 0;
  private final int r = 20;
  private final int s = 30;
  private final int t = 50;
  private final int u = 50;
  private final int v = 60;
  private final int w = 70;
  private final int x = 20;
  private final int y = 30;
  private final int z = 220;

  public ako(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void a(int paramInt)
  {
    float f1;
    if ((this.q > paramInt) && (this.q <= paramInt + 20))
    {
      f1 = (this.q - paramInt) * 1.0F / 20.0F;
      this.O = (this.e * 2.0F + this.J + (this.B - this.J) * f1);
      if (f1 * (this.B - this.J) >= this.A)
        this.P = (this.O - this.A);
    }
    do
    {
      do
      {
        return;
        if ((this.q > paramInt + 20) && (this.q <= paramInt + 20 + 15))
        {
          f1 = (this.q - (paramInt + 20)) * 1.0F / 15.0F;
          this.P = (this.e * 2.0F + this.B - this.A + this.A * f1);
          this.ac = (f1 * -180.0F);
          return;
        }
      }
      while ((this.q <= paramInt + 20 + 15.0F) || (this.q > paramInt + 20 + 30));
      f1 = (this.q - (paramInt + 20 + 15.0F)) * 1.0F / 15.0F;
      this.ab = (-180.0F * f1);
      this.ac = (f1 * 180.0F - 180.0F);
    }
    while (this.q != paramInt + 20 + 30);
    this.O = (this.e * 2.0F + this.J);
    this.P = (this.e * 2.0F + this.J);
    this.ab = 0.0F;
    this.ac = 0.0F;
  }

  private void b(int paramInt)
  {
    float f1;
    if ((this.q > paramInt) && (this.q <= paramInt + 20))
    {
      f1 = (this.q - paramInt) * 1.0F / 20.0F;
      this.R = (this.e * 2.0F + this.J + (this.B - this.J) * f1);
      if (f1 * (this.B - this.J) >= this.A)
        this.S = (this.R - this.A);
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.q <= paramInt + 20) || (this.q > paramInt + 20 + 15))
            break;
          f1 = (this.q - (paramInt + 20)) * 1.0F / 15.0F;
          this.S = (this.e * 2.0F + this.B - this.A + this.A * f1);
          this.ag = (f1 * 90.0F);
        }
        while (this.q != paramInt + 20 + 15);
        this.ai = asq.a(1.0F);
        return;
      }
      while ((this.q <= paramInt + 20 + 15.0F) || (this.q > paramInt + 20 + 30));
      f1 = (this.q - (paramInt + 20 + 15.0F)) * 1.0F / 15.0F;
      this.af = (90.0F * f1 - 180.0F);
      this.ag = (90.0F - f1 * 90.0F);
    }
    while (this.q != paramInt + 20 + 30);
    this.ai = 0.0F;
    this.R = (this.e * 2.0F + this.J);
    this.S = (this.e * 2.0F + this.J);
    this.af = -180.0F;
    this.ag = 0.0F;
  }

  private void c(int paramInt)
  {
    float f1;
    if ((this.q > paramInt) && (this.q <= paramInt + 20))
    {
      f1 = (this.q - paramInt) * 1.0F / 20.0F;
      this.L = (this.e * 2.0F + this.J + (this.B - this.J) * f1);
      if (f1 * (this.B - this.J) >= this.A)
        this.M = (this.L - this.A);
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.q <= paramInt + 20) || (this.q > paramInt + 20 + 15))
            break;
          f1 = (this.q - (paramInt + 20)) * 1.0F / 15.0F;
          this.M = (this.e * 2.0F + this.B - this.A + this.A * f1);
          this.ad = (f1 * -90.0F);
        }
        while (this.q != paramInt + 20 + 15);
        this.ah = asq.a(1.0F);
        return;
      }
      while ((this.q <= paramInt + 20 + 15.0F) || (this.q > paramInt + 20 + 30));
      f1 = (this.q - (paramInt + 20 + 15.0F)) * 1.0F / 15.0F;
      this.ae = (-90.0F * f1);
      this.ad = (f1 * 90.0F - 90.0F);
    }
    while (this.q != paramInt + 20 + 30);
    this.ah = 0.0F;
    this.L = (this.e * 2.0F + this.J);
    this.M = (this.e * 2.0F + this.J);
    this.ae = 0.0F;
    this.ad = 0.0F;
  }

  private void f()
  {
    float f1;
    if (this.q <= 20)
    {
      f1 = this.q * 1.0F / 20.0F;
      this.C = Color.argb((int)(255.0F * f1), 255, 255, 255);
      this.D = Color.argb((int)(255.0F * f1), 255, 255, 255);
      this.G = (this.F * f1 / 2.0F);
      float f2 = this.F / 2.0F;
      this.H = ((1.0F - f1) * this.F / 2.0F + f2);
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      invalidate();
      return;
      if ((this.q > 20) && (this.q <= 30))
      {
        this.I = ((this.q - 20) * 1.0F / 10.0F * this.f);
      }
      else if ((this.q > 30) && (this.q <= 50))
      {
        f1 = (this.q - 30) * 1.0F / 20.0F;
      }
      else if ((this.q > 50) && (this.q <= 220))
      {
        a(50);
        b(60);
        c(70);
        b(110);
        a(120);
        c(130);
        if ((this.q > 180) && (this.q <= 200))
          this.R = ((this.q - 180) * 1.0F / 20.0F * this.al + this.e * 2.0F + this.J);
        if ((this.q > 190) && (this.q <= 210))
          this.L = ((this.q - 190) * 1.0F / 20.0F * this.ak + this.e * 2.0F + this.J);
        if ((this.q > 200) && (this.q <= 220))
          this.O = ((this.q - 200) * 1.0F / 20.0F * this.aj + this.e * 2.0F + this.J);
      }
    }
    postInvalidate();
  }

  public void a()
  {
    setLayerType(1, null);
    this.a = new Paint(1);
    this.a.setStyle(Style.FILL);
    this.a.setStrokeCap(Cap.ROUND);
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
          ako.this.c();
          continue;
          if (!ako.this.b())
            ako.this.c();
          ako.this.j.sendEmptyMessageDelayed(1, ako.this.i);
          continue;
          if (ako.this.getParent() != null)
            ako.this.k.run();
        }
      }
    };
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.am = paramFloat1;
    this.an = paramFloat2;
  }

  public boolean b()
  {
    return (this.q > 0) && (this.q <= 220);
  }

  public void c()
  {
    this.q = 0;
    this.O = (this.e * 2.0F + this.J);
    this.P = (this.e * 2.0F + this.J);
    this.ab = 0.0F;
    this.ac = 0.0F;
    this.ai = 0.0F;
    this.R = (this.e * 2.0F + this.J);
    this.S = (this.e * 2.0F + this.J);
    this.af = -180.0F;
    this.ag = 0.0F;
    this.ah = 0.0F;
    this.L = (this.e * 2.0F + this.J);
    this.M = (this.e * 2.0F + this.J);
    this.ae = 0.0F;
    this.ad = 0.0F;
    invalidate();
  }

  public void d()
  {
    this.d = (asq.a(46.0F) * 0.6666667F);
    this.e = (asq.a(13.33F) * 0.6666667F);
    this.f = (asq.a(10.0F) * 0.6666667F);
    this.l = (asq.a(15.0F) * 0.6666667F);
    this.T = (asq.a(3.33F) * 0.6666667F);
    this.J = (asq.a(2.0F) * 0.6666667F);
    this.A = (asq.a(16.67F) * 0.6666667F);
    this.aj = (asq.a(10.0F) * 0.6666667F);
    this.ak = (asq.a(7.0F) * 0.6666667F);
    this.al = (asq.a(8.0F) * 0.6666667F);
    this.ao = (asq.a(2.33F) * 0.6666667F);
    this.E = (asq.a(0.67F) * 0.6666667F);
    this.F = (this.e / 2.0F * 0.6666667F - this.E);
    this.H = (0.6666667F * this.F);
    this.m = this.e;
    this.n = this.e;
    this.o = (this.e * 2.0F + this.f / 4.0F);
    this.p = (this.e * 2.0F - this.f);
    this.B = (this.A * 3.0F / 2.0F);
    this.K = (this.m + this.F / 2.0F);
    this.L = (this.e * 2.0F + this.J);
    this.M = (this.e * 2.0F + this.J);
    this.N = ((this.m + this.o + this.F) / 2.0F);
    this.O = (this.e * 2.0F + this.J);
    this.P = (this.e * 2.0F + this.J);
    this.Q = (this.o + this.F / 2.0F);
    this.R = (this.e * 2.0F + this.J);
    this.S = (this.e * 2.0F + this.J);
    this.V = new RectF(this.m - this.F / 2.0F, this.e * 2.0F + this.B - (this.N - this.F / 2.0F) / 6.0F, this.N, this.e * 2.0F + this.B + (this.N - this.F / 2.0F) / 4.0F);
    this.W = new RectF(-this.K * 2.0F + this.T * 8.0F, this.e * 2.0F + this.B - this.N / 2.0F, this.K, this.e * 2.0F + this.B + this.N / 2.0F);
    this.aa = new RectF(this.Q, this.e * 2.0F + this.B - (this.N - this.F / 2.0F) / 3.0F, this.Q + (this.d - this.Q) * 2.0F - this.T * 2.0F, this.e * 2.0F + this.B + (this.N - this.F / 2.0F) / 3.0F);
  }

  public void e()
  {
    this.q = 221;
    this.C = -1;
    this.D = -1;
    this.I = this.f;
    this.R = (this.al + this.e * 2.0F + this.J);
    this.S = (this.e * 2.0F + this.J);
    this.L = (this.ak + this.e * 2.0F + this.J);
    this.M = (this.e * 2.0F + this.J);
    this.O = (this.aj + this.e * 2.0F + this.J);
    this.P = (this.e * 2.0F + this.J);
  }

  public float getViewWidth()
  {
    return this.o + this.f - this.F;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.am, this.an);
    this.a.setXfermode(this.b);
    paramCanvas.saveLayer(this.U, this.a, 31);
    if (this.q > 50)
    {
      this.a.setStrokeWidth(this.ao);
      this.a.setColor(-12988417);
      this.a.setStyle(Style.STROKE);
      this.a.setStrokeCap(Cap.ROUND);
      paramCanvas.drawLine(this.N, this.O, this.N, this.P, this.a);
      paramCanvas.drawArc(this.V, this.ab, this.ac, false, this.a);
      paramCanvas.drawLine(this.Q, this.R, this.Q, this.S, this.a);
      paramCanvas.drawArc(this.aa, this.af, this.ag, false, this.a);
      paramCanvas.drawLine(this.K, this.L, this.K, this.M, this.a);
      paramCanvas.drawArc(this.W, this.ae, this.ad, false, this.a);
      this.a.setStyle(Style.FILL);
      paramCanvas.drawCircle(this.T / 3.0F, this.e * 2.0F + this.B - this.N / 2.0F, this.ah, this.a);
      paramCanvas.drawCircle(this.d - this.T / 5.0F, this.e * 2.0F + this.B - (this.N - this.F / 2.0F) / 3.0F, this.ai, this.a);
    }
    this.a.setColor(this.C);
    this.a.setStyle(Style.FILL);
    if (this.q > 20)
    {
      this.a.setStrokeWidth(this.I);
      float f1 = this.e;
      float f2 = this.F / 2.0F;
      float f3 = this.e;
      float f4 = this.I / 2.0F;
      float f5 = this.o;
      paramCanvas.drawLine(f2 + f1, f3 * 2.0F - f4, this.F / 2.0F + f5, this.e * 2.0F - this.I / 2.0F, this.a);
    }
    paramCanvas.drawCircle(this.o + this.H, this.p, this.f, this.a);
    this.a.setColor(this.D);
    paramCanvas.drawCircle(this.m + this.G, this.n, this.e, this.a);
    if (this.q > 20)
    {
      this.a.setXfermode(this.c);
      this.a.setStrokeWidth(1.0F);
      paramCanvas.drawCircle(this.o - this.f + this.F / 2.0F, (this.e - this.f) * 3.0F, this.l, this.a);
    }
    paramCanvas.restore();
    this.q += 1;
    if (this.q <= 220)
      f();
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ako
 * JD-Core Version:    0.6.2
 */