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

public class akp extends akr
{
  private final int A = 130;
  private final int B = 150;
  private final int C = 160;
  private final int D = 180;
  private final int E = 10;
  private float F = 1.0F;
  private final float G = 0.2F;
  private final int H = 20;
  private float I = 1.0F;
  private final float J = 0.25F;
  private float K;
  private float L = asq.a(10.0F);
  private float M = asq.a(7.0F);
  private float N = this.r;
  private float O = this.s;
  private float P;
  private float Q = 12.5F;
  private float R = (this.r + this.t) / 2.0F;
  private float S = asq.a(2.0F);
  private float T = this.S;
  private float U;
  private float V;
  private int W = -1;
  private Paint a;
  private int aa = 16777215;
  private float ab = 0.0F;
  private float ac = 0.0F;
  private Paint b;
  private Paint c;
  private Paint d;
  private final PorterDuffXfermode e = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
  private final PorterDuffXfermode f = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  private float l = asq.a(46.0F);
  private float m = asq.a(13.33F);
  private float n = asq.a(10.0F);
  private float o = asq.a(15.0F);
  private float p = asq.a(7.0F);
  private float q = asq.a(5.0F);
  private float r = this.m + this.p;
  private float s = this.m;
  private float t = this.m * 2.0F + this.n / 4.0F + this.p;
  private float u = this.m * 2.0F - this.n;
  private final RectF v = new RectF(0.0F, 0.0F, this.l, this.l * 2.0F);
  private int w = 0;
  private final int x = 50;
  private final int y = 40;
  private final int z = 70;

  public akp(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    this.b.setStrokeWidth(8.0F);
    paramCanvas.translate(0.0F, this.P);
    paramCanvas.rotate(90.0F + this.Q, this.N, this.O);
    int i = 0;
    while (i < 3)
    {
      float f1 = this.N;
      float f2 = this.O;
      float f3 = this.L / 2.0F;
      float f4 = this.N;
      float f5 = this.O;
      paramCanvas.drawLine(f1, f2 - f3, f4, this.L / 2.0F + f5, this.b);
      paramCanvas.rotate(60.0F, this.N, this.O);
      i += 1;
    }
    paramCanvas.drawCircle(this.N, this.O, this.L / 2.6F, this.b);
    paramCanvas.restore();
  }

  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    this.c.setColor(this.W);
    paramCanvas.translate(this.V, this.U);
    paramCanvas.drawCircle(this.R, this.u, this.T, this.c);
    this.d.setColor(this.aa);
    paramCanvas.rotate(90.0F, this.R, this.u);
    int i = 0;
    while (i < 3)
    {
      float f1 = this.R;
      float f2 = this.u;
      float f3 = this.M / 2.0F;
      float f4 = this.R;
      float f5 = this.u;
      paramCanvas.drawLine(f1, f2 - f3, f4, this.M / 2.0F + f5, this.d);
      paramCanvas.rotate(60.0F, this.R, this.u);
      i += 1;
    }
    paramCanvas.drawCircle(this.R, this.u, this.M / 2.6F, this.d);
    paramCanvas.restore();
  }

  private void f()
  {
    float f1;
    if (this.w <= 50)
    {
      f1 = (float)Math.cos(this.w * 1.0D / 10.0D * 3.141592653589793D) / 2.0F;
      if (this.w % 10 == 0)
        this.F -= 0.2F;
      this.K = ((f1 - 0.5F) * this.F * this.p);
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      invalidate();
      return;
      if ((this.w > 40) && (this.w <= 70))
      {
        this.P = (-(float)(Math.cos((this.w - 40) * 1.0F / 30.0F * 3.141592653589793D) / 2.0D - 0.5D) * (this.m + this.q + this.L / 2.0F));
      }
      else if ((this.w > 70) && (this.w <= 130))
      {
        f1 = (float)Math.cos((this.w - 70) * 1.0D / 20.0D * 3.141592653589793D) / 2.0F;
        if (this.w % 20 == 0)
          this.I -= 0.25F;
        this.Q = (12.5F - (f1 - 0.5F) * this.I * 12.5F);
      }
      else if ((this.w > 130) && (this.w <= 150))
      {
        this.U = ((this.w - 130) * 1.0F / 20.0F * (this.n + this.q));
      }
      else if ((this.w > 150) && (this.w <= 160))
      {
        f1 = (float)((this.w - 150) * 1.0D / 10.0D);
        float f2 = (float)(1.0D / Math.tan((this.w - 150) * 1.0D / 10.0D / 3.0D * 3.141592653589793D + 1.256637061435917D));
        this.U = (this.n + this.q - f2 * this.q / 2.0F);
        this.V = (f1 * this.q);
      }
      else if ((this.w > 160) && (this.w <= 180))
      {
        f1 = (float)((this.w - 160) * 1.0D / 20.0D);
        this.T = (this.S + (this.M / 2.0F - this.S) * f1);
        this.W = Color.argb((int)(255.0F * (1.0F - f1)), 255, 255, 255);
        this.aa = Color.argb((int)(f1 * 255.0F), 255, 255, 255);
      }
    }
    postInvalidate();
  }

  public void a()
  {
    setLayerType(1, null);
    this.a = new Paint(1);
    this.a.setColor(-1);
    this.a.setStrokeCap(Cap.ROUND);
    this.b = new Paint(1);
    this.b.setColor(-1);
    this.b.setStrokeCap(Cap.ROUND);
    this.b.setShadowLayer(5.0F, 0.0F, 0.0F, -1);
    this.c = new Paint(1);
    this.c.setStrokeCap(Cap.ROUND);
    this.d = new Paint(1);
    this.d.setStrokeCap(Cap.ROUND);
    this.d.setStrokeWidth(7.0F);
    this.d.setColor(this.aa);
    this.d.setShadowLayer(5.0F, 0.0F, 0.0F, -1);
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
          akp.this.c();
          continue;
          if (!akp.this.b())
            akp.this.c();
          akp.this.j.sendEmptyMessageDelayed(1, akp.this.i);
          continue;
          if (akp.this.getParent() != null)
            akp.this.k.run();
        }
      }
    };
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.ab = paramFloat1;
    this.ac = paramFloat2;
  }

  public boolean b()
  {
    return (this.w > 0) && (this.w <= 180);
  }

  public void c()
  {
    this.w = 0;
    this.W = -1;
    this.aa = 16777215;
    this.T = this.S;
    this.U = 0.0F;
    this.V = 0.0F;
    this.P = 0.0F;
    this.I = 1.0F;
    this.K = 0.0F;
    this.F = 1.0F;
    invalidate();
  }

  public void d()
  {
    this.l = (asq.a(46.0F) * 0.6666667F);
    this.m = (asq.a(13.33F) * 0.6666667F);
    this.n = (asq.a(10.0F) * 0.6666667F);
    this.o = (asq.a(15.0F) * 0.6666667F);
    this.p = (asq.a(7.0F) * 0.6666667F);
    this.q = (asq.a(5.0F) * 0.6666667F);
    this.S = (asq.a(2.0F) * 0.6666667F);
    this.L = (asq.a(10.0F) * 0.6666667F);
    this.M = (0.6666667F * asq.a(7.0F));
    this.r = (this.m + this.p);
    this.s = this.m;
    this.t = (this.m * 2.0F + this.n / 4.0F + this.p);
    this.u = (this.m * 2.0F - this.n);
    this.N = this.r;
    this.O = this.s;
    this.R = ((this.r + this.t) / 2.0F);
    this.T = this.S;
  }

  public void e()
  {
    this.w = 181;
    this.aa = -1;
    this.P = (this.m + this.q + this.L / 2.0F);
    this.V = this.q;
    this.U = (this.n + this.q + this.q / 4.0F);
  }

  public float getViewWidth()
  {
    return this.t + this.n;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.ab, this.ac);
    this.a.setXfermode(this.e);
    b(paramCanvas);
    a(paramCanvas);
    paramCanvas.translate(this.K, 0.0F);
    paramCanvas.saveLayer(this.v, this.a, 31);
    this.a.setXfermode(this.e);
    this.a.setColor(-1);
    this.a.setStyle(Style.FILL);
    this.a.setStrokeWidth(this.m - this.n);
    float f1 = this.m;
    paramCanvas.drawLine(this.p + f1, this.m * 2.0F - (this.m - this.n) / 2.0F, this.t, this.m * 2.0F - (this.m - this.n) / 2.0F, this.a);
    paramCanvas.drawCircle(this.t, this.u, this.n, this.a);
    this.a.setColor(-1);
    paramCanvas.drawCircle(this.r, this.s, this.m, this.a);
    this.a.setXfermode(this.f);
    this.a.setStrokeWidth(1.0F);
    paramCanvas.drawCircle(this.t - this.n, (this.m - this.n) * 3.0F, this.o, this.a);
    paramCanvas.restore();
    this.w += 1;
    if (this.w <= 180)
      f();
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akp
 * JD-Core Version:    0.6.2
 */