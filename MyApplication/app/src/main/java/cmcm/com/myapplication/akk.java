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

public class akk extends akr
{
  private float A = this.b;
  private float B = this.a + this.v / 2.0F;
  private final RectF C = new RectF(0.0F, 0.0F, this.l, this.l * 2.0F);
  private int D = 0;
  private final int E = 30;
  private final int F = 0;
  private final int G = 60;
  private final int H = 120;
  private final int I = 20;
  private float J = 1.0F;
  private final float K = 0.5F;
  private final float L = 40.0F;
  private float M = 0.0F;
  private float N;
  private float O;
  private final float P = -80.0F;
  private float Q = 0.0F;
  private float R = 0.0F;
  float a = this.p * 5.0F / 4.0F;
  float b = this.p + this.z;
  float c = this.p * 9.0F / 4.0F + this.q / 4.0F;
  float d = this.p * 2.0F - this.q + this.z;
  private Paint e;
  private Paint f;
  private float l = asq.a(46.0F);
  private final PorterDuffXfermode m = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
  private final PorterDuffXfermode n = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  private final PorterDuffXfermode o = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  private float p = asq.a(13.33F);
  private float q = asq.a(10.0F);
  private float r = asq.a(11.0F);
  private float s = asq.a(13.33F);
  private float t = asq.a(10.0F);
  private float u = asq.a(11.0F);
  private float v = asq.a(10.0F);
  private float w = asq.a(7.0F);
  private float x = asq.a(7.0F);
  private float y = asq.a(8.0F);
  private float z = this.x + this.v;

  public akk(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void f()
  {
    if ((this.D > 0) && (this.D <= 60))
      this.M = ((float)Math.abs(Math.cos((this.D + 0) * 1.0F / 60.0F * 3.141592653589793D) / 2.0D - 0.5D) * -80.0F);
    float f1;
    if (this.D <= 30)
    {
      f1 = (float)Math.abs(Math.cos(this.D * 1.0F / 30.0F * 2.0F * 3.141592653589793D) / 2.0D - 0.5D) * 0.2F;
      this.p = (this.s * (1.0F + f1));
      this.q = (this.t + this.s * f1);
      float f2 = this.u;
      this.r = (f1 * this.s + f2);
      f1 = (float)Math.abs(Math.cos(this.D * 1.0F / 30.0F * 3.141592653589793D) / 2.0D - 0.5D);
      this.A = (this.s + this.v + this.x - f1 * (this.s + this.x));
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      invalidate();
      return;
      if ((this.D > 30) && (this.D <= 60))
      {
        f1 = (float)Math.abs(Math.cos((this.D - 30) * 1.0F / 30.0F * 3.141592653589793D) / 2.0D - 0.5D);
        this.O = (this.y * f1);
        this.N = (f1 * (this.c - this.B));
      }
      else if ((this.D > 60) && (this.D <= 120))
      {
        f1 = (float)Math.abs(Math.cos((this.D - 60) * 1.0F / 20.0F * 3.141592653589793D) / 2.0D - 0.5D);
        if (((this.D - 60) % 20 == 0) && (f1 < 0.25F))
          this.J -= 0.5F;
        this.M = (-80.0F + 40.0F * this.J * f1);
        this.N = (this.c - this.B - f1 * (this.s / 4.0F * this.J));
      }
    }
    postInvalidate();
  }

  public void a()
  {
    this.e = new Paint(1);
    this.e.setStyle(Style.FILL);
    this.e.setStrokeCap(Cap.ROUND);
    this.f = new Paint(1);
    this.f.setStyle(Style.FILL);
    this.f.setStrokeCap(Cap.ROUND);
    this.f.setColor(-14336);
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
          akk.this.c();
          continue;
          if (!akk.this.b())
            akk.this.c();
          akk.this.j.sendEmptyMessageDelayed(1, akk.this.i);
          continue;
          if (akk.this.getParent() != null)
            akk.this.k.run();
        }
      }
    };
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.Q = paramFloat1;
    this.R = paramFloat2;
  }

  public boolean b()
  {
    return (this.D > 0) && (this.D <= 120);
  }

  public void c()
  {
    this.D = 0;
    this.M = 0.0F;
    this.N = 0.0F;
    this.O = 0.0F;
    this.A = this.b;
    this.B = (this.a + this.v / 2.0F);
    this.J = 1.0F;
    invalidate();
  }

  public void d()
  {
    this.l = (asq.a(46.0F) * 0.6666667F);
    this.p = (asq.a(13.33F) * 0.6666667F);
    this.q = (asq.a(10.0F) * 0.6666667F);
    this.r = (asq.a(11.0F) * 0.6666667F);
    this.s = (asq.a(13.33F) * 0.6666667F);
    this.t = (asq.a(10.0F) * 0.6666667F);
    this.u = (asq.a(11.0F) * 0.6666667F);
    this.v = (asq.a(10.0F) * 0.6666667F);
    this.w = (asq.a(7.0F) * 0.6666667F);
    this.x = (asq.a(7.0F) * 0.6666667F);
    this.y = (0.6666667F * asq.a(8.0F));
    this.z = (this.x + this.v);
    this.a = (this.p * 5.0F / 4.0F);
    this.b = (this.p + this.z);
    this.c = (this.p * 9.0F / 4.0F + this.q / 4.0F);
    this.d = (this.p * 2.0F - this.q + this.z);
    this.A = this.b;
    this.B = (this.a + this.v / 2.0F);
  }

  public void e()
  {
    this.D = 121;
    this.N = (this.c - this.B - this.s / 4.0F * 0.5F);
    this.O = this.y;
    this.A = this.v;
    this.M = -60.0F;
  }

  public float getViewWidth()
  {
    return this.c + this.q;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.Q, this.R);
    this.f.setXfermode(this.m);
    this.e.setXfermode(this.m);
    paramCanvas.saveLayer(this.C, this.e, 31);
    this.f.setColor(-14336);
    paramCanvas.translate(this.N, this.O);
    paramCanvas.rotate(this.M, this.B, this.A);
    paramCanvas.drawCircle(this.B, this.A, this.v, this.f);
    this.f.setXfermode(this.o);
    paramCanvas.drawCircle(this.B + this.w, this.A, this.w, this.f);
    paramCanvas.rotate(-this.M, this.B, this.A);
    paramCanvas.translate(-this.N, -this.O);
    paramCanvas.restore();
    paramCanvas.saveLayer(this.C, this.e, 31);
    this.e.setColor(-1);
    this.e.setStyle(Style.FILL);
    float f1 = this.a;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.b;
    paramCanvas.drawRect(f1, f2, f3, this.p + f4, this.e);
    paramCanvas.drawCircle(this.c, this.d, this.q, this.e);
    this.e.setColor(-1);
    paramCanvas.drawCircle(this.a, this.b, this.p, this.e);
    this.e.setXfermode(this.n);
    this.e.setStrokeWidth(1.0F);
    paramCanvas.drawCircle(this.c - this.q / 2.0F, (this.p - this.q) * 4.0F + this.z, this.r, this.e);
    paramCanvas.restore();
    this.D += 1;
    if (this.D <= 120)
      f();
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akk
 * JD-Core Version:    0.6.2
 */