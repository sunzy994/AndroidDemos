package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class akn extends akr
{
  private float A = this.n;
  private float B;
  private float C = 0.75F;
  private final float D = 0.25F;
  private final float E = 0.2F;
  private float F = 0.0F;
  private float G = 0.0F;
  private Paint a;
  private float b = asq.a(13.33F);
  private float c = asq.a(10.0F);
  private float d = asq.a(2.0F);
  private float e = asq.a(2.0F);
  private float f = 1.0F;
  private float l = this.b;
  private float m = this.b + this.d;
  private float n = this.b * 2.0F + this.c / 4.0F;
  private float o = this.b * 2.0F - this.c;
  private int p = 0;
  private final int q = 10;
  private final int r = 20;
  private final int s = 80;
  private final int t = 100;
  private final int u = 120;
  private final int v = 180;
  private float w;
  private float x;
  private final float y = 20.0F;
  private final float z = 20.0F;

  public akn(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void f()
  {
    if (this.p <= 10)
    {
      this.w = (this.p * 1.0F / 10.0F * this.e);
      this.B = this.d;
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      invalidate();
      return;
      if ((this.p > 10) && (this.p <= 20))
      {
        this.B = (this.d + (this.p - 10) * 1.0F / 10.0F * (this.o * 2.0F - this.d));
      }
      else
      {
        float f1;
        float f2;
        if ((this.p > 20) && (this.p <= 80))
        {
          f1 = (float)Math.cos((this.p - 20) * 1.0F / 20.0F * 3.141592653589793D) / 2.0F;
          if ((this.p - 20) % 40.0F == 0.0F)
            this.C -= 0.25F;
          f2 = this.d;
          float f3 = this.o;
          this.B = ((f1 - 0.5F) * this.C * this.o * 2.0F + (f2 + f3 * 2.0F));
        }
        else if ((this.p > 80) && (this.p <= 100))
        {
          f1 = (float)(Math.cos((this.p - 80) * 1.0F / 20.0F * 3.141592653589793D) / 2.0D + 0.5D) * 1.2F - 0.2F;
          if (f1 >= 0.0F)
          {
            f2 = this.e;
            this.w = ((1.0F - f1) * (this.c * 1.2F - this.e) + f2);
          }
          else
          {
            this.w = ((f1 + 1.2F) * this.c);
          }
        }
        else if ((this.p > 100) && (this.p <= 120))
        {
          this.x = ((this.p - 100) * 1.0F / 20.0F * this.b);
        }
        else if ((this.p > 120) && (this.p <= 180))
        {
          this.f = this.c;
          f1 = (float)Math.cos((this.p - 120) * 1.0F / 20.0F * 3.141592653589793D) / 2.0F;
          f2 = this.n;
          this.A = ((f1 - 0.5F) * (this.n - this.l) + f2);
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
    this.a.setStrokeCap(Cap.ROUND);
    this.a.setColor(-1);
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
          akn.this.c();
          continue;
          if (!akn.this.b())
            akn.this.c();
          akn.this.j.sendEmptyMessageDelayed(1, akn.this.i);
          continue;
          if (akn.this.getParent() != null)
            akn.this.k.run();
        }
      }
    };
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.F = paramFloat1;
    this.G = paramFloat2;
  }

  public boolean b()
  {
    return (this.p > 0) && (this.p <= 180);
  }

  public void c()
  {
    this.p = 0;
    this.w = 0.0F;
    this.x = 0.0F;
    this.B = 0.0F;
    this.A = this.n;
    this.f = 1.0F;
    this.C = 0.75F;
    invalidate();
  }

  public void d()
  {
    this.b = (asq.a(13.33F) * 0.6666667F);
    this.c = (asq.a(10.0F) * 0.6666667F);
    this.d = (asq.a(2.0F) * 0.6666667F);
    this.e = (0.6666667F * asq.a(2.0F));
    this.l = this.b;
    this.m = (this.b + this.d);
    this.n = (this.b * 2.0F + this.c / 4.0F);
    this.o = (this.b * 2.0F - this.c);
    this.w = this.c;
    this.x = this.b;
    this.B = (this.o + this.d);
    this.A = this.l;
    this.f = this.c;
  }

  public void e()
  {
    this.p = 181;
    this.w = this.c;
    this.x = this.b;
    this.B = (this.o + this.d);
    this.A = this.l;
    this.f = this.c;
  }

  public float getViewWidth()
  {
    return this.n + this.c;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.F, this.G);
    this.a.setStrokeWidth(this.f);
    paramCanvas.drawCircle(this.n, this.B, this.w, this.a);
    paramCanvas.drawCircle(this.A, this.m, this.x, this.a);
    paramCanvas.drawLine(this.n, this.d + this.b * 2.0F - this.f / 2.0F, this.A, this.d + this.b * 2.0F - this.f / 2.0F, this.a);
    this.p += 1;
    if (this.p <= 180)
      f();
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akn
 * JD-Core Version:    0.6.2
 */