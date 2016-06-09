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

public class akl extends akr
{
  private float A;
  private float B = asq.a(6.67F);
  private float C = (this.o + this.e) / 2.0F;
  private float D = (this.o + this.e) / 2.0F;
  private float E = asq.a(5.0F);
  private float F = asq.a(3.33F);
  private float G = asq.a(6.67F);
  private RectF H = null;
  private float I = -90.0F;
  private float J = 0.0F;
  private float K = 10.0F;
  private float L = this.G + 1.0F;
  private float M = this.G + 1.0F;
  private float N = -this.E - 1.0F;
  private float O = 0.0F;
  private float P = 0.0F;
  private Paint a;
  private final PorterDuffXfermode b = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
  private final PorterDuffXfermode c = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  private float d = asq.a(13.33F);
  private float e = asq.a(10.0F);
  private float f = asq.a(15.0F);
  private float l = asq.a(5.0F);
  private float m = this.d;
  private float n = this.d;
  private float o = this.d * 2.0F + this.e / 4.0F;
  private float p = this.d * 2.0F - this.e;
  private final RectF q = new RectF(0.0F, 0.0F, this.o + this.e, this.d * 2.0F);
  private int r = 0;
  private final int s = 20;
  private final int t = 40;
  private final int u = 50;
  private final int v = 70;
  private final int w = 80;
  private final int x = 120;
  private final int y = 140;
  private float z = this.d * 2.0F;

  public akl(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void f()
  {
    if (this.r <= 20)
    {
      this.A = (this.B / 20.0F);
      this.z = (this.d * 2.0F + this.A * this.r);
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      invalidate();
      return;
      float f1;
      if ((this.r > 20) && (this.r <= 40))
      {
        f1 = (float)Math.abs(Math.sin((40 - this.r) * 1.0F / 20.0F * 3.141592653589793D));
        this.z = (this.d * 2.0F + this.A * 20.0F - f1 * (this.A * 20.0F) / 3.0F);
      }
      else
      {
        if ((this.r >= 50) && (this.r <= 70))
        {
          float f2 = (this.o + this.e - this.G) / 2.0F / 20.0F;
          if (this.C <= this.G)
          {
            f1 = this.G;
            label191: this.C = f1;
            if (this.D < this.o + this.e - this.G)
              break label251;
          }
          label251: for (f1 = this.o + this.e - this.G; ; f1 = this.D + f2)
          {
            this.D = f1;
            break;
            f1 = this.C - f2;
            break label191;
          }
        }
        if ((this.r > 70) && (this.r <= 80))
        {
          if (this.H == null)
            this.H = new RectF(this.D - this.l, this.z, this.D + this.l, this.z + this.F + this.E);
          this.K = 18.0F;
          this.J = (this.K * (this.r - 70));
        }
        else
        {
          if ((this.r > 80) && (this.r <= 120))
          {
            this.N = (this.z + this.F + this.E);
            this.M = this.D;
            if (this.L <= this.G);
            for (f1 = this.G; ; f1 = (1.0F - (this.r - 80) * 1.0F / 40.0F) * (this.D - this.G))
            {
              this.L = f1;
              break;
            }
          }
          if (this.r > 120)
          {
            f1 = (this.r - 120) * 1.0F / 20.0F * 180.0F;
            this.I = (-90.0F + f1);
            this.J = (180.0F - f1);
          }
        }
      }
    }
    postInvalidate();
  }

  public void a()
  {
    setLayerType(1, null);
    this.a = new Paint(1);
    this.a.setStyle(Style.FILL);
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
          akl.this.c();
          continue;
          if (!akl.this.b())
            akl.this.c();
          akl.this.j.sendEmptyMessageDelayed(1, akl.this.i);
          continue;
          if (akl.this.getParent() != null)
            akl.this.k.run();
        }
      }
    };
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.O = (this.o + this.e);
    this.P = paramFloat2;
  }

  public boolean b()
  {
    return (this.r > 0) && (this.r <= 140);
  }

  public void c()
  {
    this.r = 0;
    this.L = (this.G + 1.0F);
    this.M = (this.G + 1.0F);
    this.N = (-this.E - 1.0F);
    this.J = 0.0F;
    this.I = -90.0F;
    this.H = null;
    this.C = ((this.o + this.e) / 2.0F);
    this.D = ((this.o + this.e) / 2.0F);
    this.z = (this.d * 2.0F);
    invalidate();
  }

  public void d()
  {
    this.d = (asq.a(13.33F) * 0.6666667F);
    this.e = (asq.a(10.0F) * 0.6666667F);
    this.f = (asq.a(15.0F) * 0.6666667F);
    this.l = (asq.a(5.0F) * 0.6666667F);
    this.E = (asq.a(5.0F) * 0.6666667F);
    this.F = (asq.a(3.33F) * 0.6666667F);
    this.G = (asq.a(6.67F) * 0.6666667F);
    this.B = (0.6666667F * asq.a(6.67F));
    this.m = this.d;
    this.n = this.d;
    this.o = (this.d * 2.0F + this.e / 4.0F);
    this.p = (this.d * 2.0F - this.e);
    this.C = ((this.o + this.e) / 2.0F);
    this.D = ((this.o + this.e) / 2.0F);
    this.L = (this.G + 1.0F);
    this.N = (-this.E - 1.0F);
    this.M = (this.G + 1.0F);
  }

  public void e()
  {
    this.r = 141;
    this.C = this.G;
    this.D = (this.o + this.e - this.G);
    this.L = this.G;
    this.M = (this.o + this.e - this.G);
    this.z = (this.d * 2.0F + this.B);
    this.N = (this.z + this.F + this.E);
  }

  public float getViewWidth()
  {
    return this.o + this.e;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.O, this.P);
    paramCanvas.saveLayer(this.q, this.a, 31);
    this.a.setColor(-1);
    this.a.setStyle(Style.FILL);
    this.a.setStrokeWidth(this.d - this.e);
    paramCanvas.drawLine(this.d, this.d * 2.0F - (this.d - this.e) / 2.0F, this.o, this.d * 2.0F - (this.d - this.e) / 2.0F, this.a);
    paramCanvas.drawCircle(this.o, this.p, this.e, this.a);
    this.a.setColor(-1);
    paramCanvas.drawCircle(this.m, this.n, this.d, this.a);
    this.a.setXfermode(this.c);
    this.a.setStrokeWidth(1.0F);
    paramCanvas.drawCircle(this.o - this.e, (this.d - this.e) * 3.0F, this.f, this.a);
    paramCanvas.restore();
    this.a.setXfermode(this.b);
    this.a.setStrokeCap(Cap.ROUND);
    this.a.setStrokeWidth(this.E);
    this.a.setStyle(Style.STROKE);
    paramCanvas.drawLine(this.C, this.z, this.D, 0.1F + this.z, this.a);
    if (this.L != 0.0F)
      paramCanvas.drawLine(this.L, this.N, this.M, this.N, this.a);
    if (this.H != null)
      paramCanvas.drawArc(this.H, this.I, this.J, false, this.a);
    this.r += 1;
    if (this.r <= 140)
      f();
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akl
 * JD-Core Version:    0.6.2
 */