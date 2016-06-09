package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class akm extends akr
{
  private float A = 0.0F;
  private float B = 0.0F;
  private Paint a;
  private final PorterDuffXfermode b = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
  private final PorterDuffXfermode c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  private float d = asq.a(16.0F);
  private float e = asq.a(12.0F);
  private float f = asq.a(3.0F);
  private int l = 0;
  private final int m = 40;
  private final int n = 152;
  private final int o = 7;
  private final int p = (int)Math.ceil(3.5D);
  private final float q = 16.0F;
  private float r = asq.a(92.0F);
  private float s = asq.a(46.0F);
  private final RectF t = new RectF(0.0F, 0.0F, this.s, this.r);
  private float u = this.r + this.d + this.f;
  private final float v = 1.0F / this.p;
  private float w = 1.0F;
  private float x = 0.0F;
  private final float y = 60.0F;
  private float z = asq.a(10.0F);

  public akm(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void f()
  {
    float f1;
    if (this.l <= 40)
    {
      f1 = (float)Math.cos(this.l * 1.0F / 40.0F * 3.141592653589793D) / 2.0F;
      float f2 = this.r;
      float f3 = this.d;
      float f4 = this.f;
      this.u = ((f1 - 0.5F) * this.r + (f2 + f3 + f4));
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      invalidate();
      return;
      if ((this.l > 40) && (this.l <= 152))
      {
        f1 = (float)Math.cos((this.l - 40) * 1.0F / 16.0F * 3.141592653589793D) / 2.0F - 0.5F;
        int i = 0;
        while (i < 6)
        {
          if ((this.l - 40) / 16.0F == i * 2)
            this.w -= this.v;
          i += 1;
        }
        if (this.w <= 0.0F)
          this.w = 0.0F;
        this.u = (this.d + this.f - this.w * f1 * this.z);
        this.x = (this.w * f1 * 60.0F);
      }
    }
    postInvalidate();
  }

  public void a()
  {
    this.a = new Paint(1);
    this.a.setColor(-14336);
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
          akm.this.c();
          continue;
          if (!akm.this.b())
            akm.this.c();
          akm.this.j.sendEmptyMessageDelayed(1, akm.this.i);
          continue;
          if (akm.this.getParent() != null)
            akm.this.k.run();
        }
      }
    };
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.A = paramFloat1;
    this.B = paramFloat2;
  }

  public boolean b()
  {
    return (this.l > 0) && (this.l <= 152);
  }

  public void c()
  {
    this.l = 0;
    this.x = 0.0F;
    this.w = 1.0F;
    this.u = (this.r + this.d);
    invalidate();
  }

  public void d()
  {
    this.d = (asq.a(16.0F) * 0.6666667F);
    this.e = (asq.a(12.0F) * 0.6666667F);
    this.f = (asq.a(3.0F) * 0.6666667F);
    this.r = (asq.a(92.0F) * 0.6666667F);
    this.s = (asq.a(46.0F) * 0.6666667F);
    this.z = (0.6666667F * asq.a(10.0F));
    this.u = (this.r + this.d + this.f);
  }

  public void e()
  {
    this.l = 153;
    this.x = (60.0F * -this.v);
    this.u = (this.d + this.f);
  }

  public float getViewWidth()
  {
    return this.d * 3.0F / 2.0F + this.d;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.A, this.B);
    this.t.set(0.0F, this.u - (float)(Math.sin(0.5235987755982988D) * this.d + this.e), this.s, this.u + this.d);
    paramCanvas.rotate(this.x, (float)(this.d + Math.sin(0.7853981633974483D) * this.d), this.u);
    this.a.setXfermode(this.b);
    paramCanvas.saveLayer(this.t, this.a, 31);
    paramCanvas.drawCircle(this.d * 3.0F / 2.0F, this.u, this.d, this.a);
    this.a.setXfermode(this.c);
    paramCanvas.drawCircle(this.d * 3.0F / 2.0F + this.e, this.u, this.e, this.a);
    paramCanvas.restore();
    if (this.l <= 152)
    {
      this.l += 1;
      f();
    }
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akm
 * JD-Core Version:    0.6.2
 */