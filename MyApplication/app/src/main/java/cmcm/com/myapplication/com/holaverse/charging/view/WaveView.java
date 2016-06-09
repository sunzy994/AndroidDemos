package cmcm.com.myapplication.com.holaverse.charging.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import java.util.Timer;
import uz;
import va;
import vc;
import vd;
import ve;

public class WaveView extends View
{
  private static int D = 10;
  private static boolean c = false;
  private Timer A;
  private uz B;
  private int C;
  private Handler E = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      WaveView.this.invalidate();
    }
  };
  private float F;
  private vd G;
  private int H;
  private int I;
  public vc a;
  private va b;
  private int d = -1;
  private int e;
  private int f;
  private boolean g = false;
  private ve h;
  private ve i;
  private Paint j;
  private int k = -16733441;
  private int l = -12861441;
  private float m;
  private float n;
  private float o;
  private int p;
  private int q;
  private float r = 1.0F;
  private boolean s = false;
  private Path t;
  private Paint u;
  private float v;
  private int w = -1;
  private int x = 436207616;
  private Path y;
  private Path z = new Path();

  public WaveView(Context paramContext)
  {
    super(paramContext);
    d();
  }

  public WaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }

  public WaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }

  private void a(float paramFloat)
  {
    this.n = paramFloat;
    if (this.G != null)
      this.G.b(paramFloat);
  }

  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramBoolean == this.g) && (paramInt1 == this.e) && (paramInt2 == this.f))
      return;
    this.g = paramBoolean;
    this.e = paramInt1;
    this.f = paramInt2;
    if (paramBoolean)
    {
      paramInt2 = Math.min(paramInt1, paramInt2);
      this.H = (this.e - paramInt2 >> 1);
      this.I = (this.f - paramInt2 >> 1);
      paramInt1 = paramInt2;
    }
    while (true)
    {
      this.p = ((int)(paramInt2 * 0.08F));
      this.q = (paramInt2 - this.p);
      this.m = (paramInt1 / 30.0F / D);
      setStatus(this.d);
      if (this.a == null)
      {
        this.a = new vc();
        this.a.a((int)(getResources().getDisplayMetrics().density * 10.0F));
      }
      this.a.a(paramInt1, paramInt2);
      this.h.a(this.a);
      this.i.a(this.a);
      this.y.addCircle(paramInt1 >> 1, paramInt2 >> 1, (Math.min(paramInt1, paramInt2) - this.v) / 2.0F, Direction.CCW);
      this.t.addCircle(paramInt1 >> 1, paramInt2 >> 1, (Math.min(paramInt1, paramInt2) - this.v) / 2.0F, Direction.CW);
      a(this.F, false);
      if (!c)
        break;
      Log.d("WaveView", "layout  maxLevel=" + this.q + " minLevel=" + this.p + " speed=" + this.m);
      return;
      this.H = 0;
      this.I = 0;
    }
  }

  private void d()
  {
    this.v = (getResources().getDisplayMetrics().density * 2.0F);
    this.u = new Paint();
    this.u.setAntiAlias(true);
    this.u.setColor(-1);
    this.u.setStrokeWidth(this.v);
    this.u.setStyle(Style.STROKE);
    this.y = new Path();
    this.t = new Path();
    this.h = new ve();
    this.i = new ve();
    this.i.a(-1);
    this.i.a(1.2F);
    ve.a(this.h, this.k);
    ve.a(this.i, this.l);
    setStatus(0);
    this.j = new Paint();
    this.j.setStyle(Style.FILL);
    this.j.setColor(-16776961);
    this.A = new Timer();
  }

  private void e()
  {
    if (this.b != null)
      this.b.a();
  }

  private void f()
  {
    if (this.a == null)
      return;
    switch (this.d)
    {
    default:
    case -1:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      this.h.a();
      this.i.a();
      this.C += 1;
      return;
      if (this.n == this.o)
        setStatus(0);
      if (this.n == this.o)
      {
        if (this.C % 1000 == 0)
          e();
      }
      else if (this.n + this.r < this.o)
      {
        a(this.n + this.r);
        g();
      }
      else if (this.n - this.r > this.o)
      {
        a(this.n - this.r);
        g();
      }
      else
      {
        a(this.o);
        g();
        continue;
        if (this.n > this.p)
        {
          a(this.n - this.r);
          g();
        }
        else if (this.n != this.p)
        {
          a(this.p);
          g();
        }
        else if (!this.s)
        {
          this.o = ((float)Math.min(this.o, (this.q - this.p) * 0.58D));
          setStatus(2);
          continue;
          if (this.n + this.r <= this.o)
          {
            a(this.n + this.r);
            g();
          }
          else if (this.n - this.r >= this.o)
          {
            a(this.n - this.r);
            g();
          }
          else if (this.n == this.o)
          {
            setStatus(0);
          }
          else
          {
            a(this.o);
          }
        }
      }
    }
  }

  private void g()
  {
  }

  public void a()
  {
    if (c)
      Log.d("WaveView", "start() ");
    if (this.B != null)
    {
      this.B.cancel();
      this.B = null;
    }
    this.B = new uz(this, this.E);
    this.A.schedule(this.B, 0L, D);
  }

  public void a(float paramFloat, boolean paramBoolean)
  {
    this.F = paramFloat;
    long l1 = this.q - this.p;
    this.o = ((float)l1 * paramFloat);
    float f1;
    if (paramBoolean)
    {
      f1 = this.p;
      a(f1);
      if (Math.abs(this.o - this.n) >= this.r)
      {
        setStatus(0);
        if (paramFloat >= 0.4F)
          break label153;
        f1 = 1.2F;
      }
    }
    while (true)
    {
      this.r = (f1 * this.m);
      if (c)
        Log.d("WaveView", "mock memory used=" + paramFloat + " destLeve=" + this.o + " levelLength = " + l1);
      return;
      f1 = this.o;
      break;
      label153: if (paramFloat < 0.8F)
        f1 = 2.0F;
      else
        f1 = 2.5F;
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (this.h != null)
      ve.a(this.h, paramInt1);
    if (this.i != null)
      ve.a(this.i, paramInt2);
    this.k = paramInt1;
    this.l = paramInt2;
  }

  public void b()
  {
    if (c)
      Log.d("WaveView", "stop() ");
    if (this.B != null)
    {
      this.B.cancel();
      this.B = null;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.H != 0) || (this.I != 0))
    {
      paramCanvas.save();
      paramCanvas.translate(this.H, this.I);
    }
    if (this.g)
    {
      paramCanvas.save(2);
      paramCanvas.clipPath(this.z);
      paramCanvas.clipPath(this.y, Region.Op.REPLACE);
      this.u.setColor(this.x);
      this.u.setStyle(Style.FILL);
      paramCanvas.drawPath(this.t, this.u);
    }
    float f1 = this.q - this.n;
    this.i.a(paramCanvas, 0.0F, f1, this.j);
    this.h.a(paramCanvas, 0.0F, f1, this.j);
    this.j.setColor(ve.a(this.i));
    paramCanvas.drawRect(0.0F, f1 + vc.a(this.a) / 2.0F - 1.0F, getWidth(), getHeight(), this.j);
    if (this.g)
    {
      paramCanvas.restore();
      this.u.setColor(this.w);
      this.u.setStyle(Style.STROKE);
      paramCanvas.drawPath(this.t, this.u);
    }
    if ((this.H != 0) || (this.I != 0))
      paramCanvas.restore();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
      a(this.g, getMeasuredWidth(), getMeasuredHeight());
    if (c)
      Log.d("WaveView", "onLayout " + paramBoolean + " " + (paramInt3 - paramInt1) + " " + (paramInt4 - paramInt2));
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (c)
      Log.d("WaveView", "onMeasure " + getMeasuredWidth() + " " + getMeasuredHeight());
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (c)
      Log.d("WaveView", "onSizeChanged " + paramInt1 + " " + paramInt1);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (c)
      Log.d("WaveView", "onWindowFocusChanged " + paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
  }

  public void setCleaning(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public void setOnStatusChanaged(va paramva)
  {
    this.b = paramva;
  }

  public void setStatus(int paramInt)
  {
    this.d = paramInt;
    switch (paramInt)
    {
    default:
    case -1:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      if (c)
        Log.d("WaveView", "setStatus =" + paramInt);
      return;
      this.s = false;
      this.h.a(this.m * 3.0F);
      this.i.a(this.m * 3.0F);
      this.r = (this.m * 2.0F);
      continue;
      this.s = false;
      this.h.a(this.m);
      this.i.a(this.m);
      this.r = this.m;
      continue;
      this.h.a(this.m * 3.0F);
      this.i.a(this.m * 3.0F);
      this.r = this.m;
      continue;
      float f1 = (float)(0.7D + Math.random() * 0.049D);
      if (c)
        Log.d("WaveView", "clean back destLevel = " + f1);
      this.o = Math.min(this.o, f1 * (this.q - this.p));
      this.h.a(this.m * 3.0F);
      this.i.a(this.m * 3.0F);
      this.r = this.m;
    }
  }

  public void setStyle(boolean paramBoolean)
  {
    a(paramBoolean, this.e, this.f);
  }

  public void setWaveLevelChangeListener(vd paramvd)
  {
    this.G = paramvd;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.charging.view.WaveView
 * JD-Core Version:    0.6.2
 */