package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class akq extends akr
{
  private final float A = -45.0F;
  private float B = 0.0F;
  private float C = 0.0F;
  private final float D = 0.2F;
  private float a = 0.0F;
  private float b = asq.a(16.67F);
  private float c = asq.a(2.0F);
  private float d = asq.a(0.25F);
  private float e = asq.a(3.33F);
  private float f = asq.a(2.0F);
  private int l = 0;
  private final int m = 50;
  private final int n = 100;
  private final int o = 130;
  private final int p = 310;
  private Paint q;
  private float r = -1.0F;
  private float s = -1.0F;
  private float t;
  private float u = this.b + this.e + this.c;
  private float v = this.u;
  private float w = this.u;
  private final float x = 0.25F;
  private float y = 1.0F;
  private final float z = 360.0F;

  public akq(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void f()
  {
    float f1;
    if (this.l <= 50)
    {
      f1 = (float)(Math.cos(this.l * 1.0F / 50.0F * 3.141592653589793D) / 2.0D + 0.5D) * 1.2F - 0.2F;
      if (f1 >= 0.0F)
      {
        this.a = (this.b * (1.0F - f1));
        if (this.v >= this.c)
        {
          this.v = (this.u * f1);
          this.w = (f1 * (this.u + this.d));
        }
      }
    }
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      invalidate();
      return;
      this.s = this.w;
      continue;
      if (this.r == -1.0F)
        this.r = this.v;
      this.a = (this.b * (1.0F + f1));
      float f2 = this.r;
      float f3 = this.b;
      this.v = (-f1 * f3 + f2);
      continue;
      if ((this.l > 50) && (this.l <= 100))
      {
        this.t = ((float)Math.abs(Math.cos((100 - this.l) * 1.0F / 50.0F * 3.141592653589793D) / 2.0D + 0.5D) * 360.0F);
        f1 = (float)Math.cos((100 - this.l) * 2.0F / 50.0F * 3.141592653589793D);
        this.w = (this.v - f1 * (this.v - this.s));
        if (this.v - this.w <= this.d)
          this.w = (this.v - this.d);
      }
      else if ((this.l > 100) && (this.l <= 310))
      {
        f1 = (float)(this.y * Math.cos((310 - this.l) * 1.0F / 30.0F * 3.141592653589793D));
        if ((310 - this.l) % 30 == 15)
          this.y -= 0.25F;
        if (this.y <= 0.0F)
          this.y = 0.0F;
        this.t = (f1 * -45.0F);
      }
    }
    postInvalidate();
  }

  public void a()
  {
    setLayerType(1, null);
    this.q = new Paint(1);
    this.q.setStyle(Style.FILL);
    this.q.setColor(-14336);
    this.q.setStrokeWidth(this.f);
    this.q.setStrokeCap(Cap.ROUND);
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
          akq.this.c();
          continue;
          if (!akq.this.b())
            akq.this.c();
          akq.this.j.sendEmptyMessageDelayed(1, akq.this.i);
          continue;
          if (akq.this.getParent() != null)
            akq.this.k.run();
        }
      }
    };
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.B = paramFloat1;
    this.C = paramFloat2;
  }

  public boolean b()
  {
    return (this.l > 0) && (this.l <= 310);
  }

  public void c()
  {
    this.l = 0;
    this.a = 0.0F;
    this.t = 0.0F;
    this.r = -1.0F;
    this.s = -1.0F;
    this.v = this.u;
    this.w = this.u;
    this.y = 1.0F;
    invalidate();
  }

  public void d()
  {
    this.b = (asq.a(16.67F) * 0.625F);
    this.c = (asq.a(2.0F) * 4);
    this.d = (asq.a(0.25F) * 0.625F);
    this.e = (asq.a(3.33F) * 0.625F);
    this.f = (0.625F * asq.a(2.0F));
    this.u = (this.b + this.e + this.c);
  }

  public void e()
  {
    this.l = 311;
    this.t = 0.0F;
    this.a = (this.b * 0.8F);
    this.v = this.c;
    this.w = (this.v + this.b * 0.2F);
  }

  public float getViewWidth()
  {
    return (this.b + this.c) * 2.0F;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.B, this.C);
    paramCanvas.drawCircle(this.u, this.u, this.a, this.q);
    paramCanvas.rotate(this.t, this.u, this.u);
    paramCanvas.save();
    int i = 0;
    while (i < 8)
    {
      paramCanvas.drawLine(this.u, this.v, this.u, this.w, this.q);
      paramCanvas.rotate(45.0F, this.u, this.u);
      i += 1;
    }
    paramCanvas.restore();
    this.l += 1;
    if (this.l <= 310)
      f();
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akq
 * JD-Core Version:    0.6.2
 */