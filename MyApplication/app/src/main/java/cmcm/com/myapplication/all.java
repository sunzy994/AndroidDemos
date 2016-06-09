package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import java.lang.ref.WeakReference;

public class all
  implements alj
{
  public static alj a;
  private static final String b = "Swipe." + all.class.getSimpleName();
  private int A;
  private long B;
  private final int[] C = new int[3];
  private final int[] D = new int[3];
  private int E;
  private PointF F;
  private PointF G;
  private PointF H;
  private PointF I;
  private PointF J;
  private Path K;
  private Paint L;
  private Paint M;
  private Paint N;
  private RectF O;
  private int c;
  private ValueAnimator d;
  private ValueAnimator e;
  private ValueAnimator f;
  private ValueAnimator g;
  private ValueAnimator h;
  private ValueAnimator i;
  private int j;
  private WeakReference<View> k;
  private Handler l;
  private boolean m;
  private boolean n;
  private int o;
  private int p;
  private PointF q;
  private int r;
  private int s;
  private int t;
  private int u;
  private PointF v;
  private PointF w;
  private int x;
  private int y;
  private int z;

  public all(View paramView, boolean paramBoolean)
  {
    a(paramView, paramBoolean);
  }

  public static void a(alj paramalj)
  {
    a = paramalj;
  }

  private void a(PointF paramPointF1, float paramFloat1, float paramFloat2, PointF paramPointF2)
  {
    paramPointF1.x += (float)(paramFloat1 * Math.cos(paramFloat2));
    paramPointF1.y -= (float)(paramFloat1 * Math.sin(paramFloat2));
  }

  private boolean a(Canvas paramCanvas, int paramInt)
  {
    long l1 = System.currentTimeMillis() - this.B;
    if (l1 < paramInt * 312L)
      return true;
    if ((l1 >= (paramInt + 1) * 312L) || (this.c > 3))
    {
      paramCanvas.drawCircle(this.v.x + this.C[paramInt], this.v.y, this.E, this.M);
      return false;
    }
    int i1 = (int)(l1 - paramInt * 312L);
    float f1 = i1 / 312.0F;
    double d1 = this.D[paramInt];
    double d2 = Math.cos(0.02513274F * i1);
    i1 = (int)((1.0F - f1 * f1) * (d1 * d2));
    paramCanvas.drawCircle(this.v.x + this.C[paramInt], this.v.y - i1, this.E, this.M);
    return true;
  }

  private void b(Canvas paramCanvas)
  {
    switch (this.c)
    {
    default:
      return;
    case 1:
      c(paramCanvas);
      return;
    case 2:
      e(paramCanvas);
      return;
    case 3:
      d(paramCanvas);
      return;
    case 4:
      f(paramCanvas);
      return;
    case 5:
      g(paramCanvas);
      return;
    case 6:
    }
    h(paramCanvas);
  }

  public static void b(boolean paramBoolean)
  {
    try
    {
      Object localObject = SwipeService.i();
      if (localObject == null)
        return;
      localObject = ((SwipeService)localObject).e;
      if (localObject != null)
      {
        ((vu)localObject).b(paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(b, "forcePlay", localException);
    }
  }

  private void c(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.v.x, this.v.y, this.x, this.L);
    paramCanvas.drawCircle(this.w.x, this.w.y, this.y, this.L);
    h();
    paramCanvas.drawPath(this.K, this.L);
    j();
  }

  private void c(boolean paramBoolean)
  {
    d();
    if (paramBoolean)
      j();
  }

  private void d(Canvas paramCanvas)
  {
    this.v.x = this.q.x;
    this.v.y = this.q.y;
    this.A = this.z;
    this.x = this.z;
    paramCanvas.drawCircle(this.v.x, this.v.y, this.x, this.L);
    this.A = this.z;
    g();
    paramCanvas.drawRoundRect(this.O, 4.0F, 4.0F, this.L);
    int i1 = 0;
    int i2 = 0;
    while (i1 < 3)
    {
      if (a(paramCanvas, i1))
        i2 = 1;
      i1 += 1;
    }
    if (i2 != 0)
    {
      j();
      return;
    }
    this.l.removeMessages(3);
    this.c = 4;
    j();
    paramCanvas = this.l.obtainMessage(3, 5, 0);
    this.l.sendMessageDelayed(paramCanvas, 4000L);
  }

  private void e(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.v.x, this.v.y, this.x, this.L);
    g();
    paramCanvas.drawRoundRect(this.O, 4.0F, 4.0F, this.L);
    j();
  }

  private void f()
  {
    i();
    try
    {
      if (!asq.q(((View) this.k.get()).getContext()))
      {
        this.c = 6;
        j();
        return;
      }
      k();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void f(Canvas paramCanvas)
  {
    this.v.x = this.q.x;
    this.v.y = this.q.y;
    this.x = this.z;
    this.A = this.z;
    this.x = this.z;
    paramCanvas.drawCircle(this.v.x, this.v.y, this.x, this.L);
    this.A = this.z;
    g();
    paramCanvas.drawRoundRect(this.O, 4.0F, 4.0F, this.L);
    int i1 = 0;
    while (i1 < 3)
    {
      a(paramCanvas, i1);
      i1 += 1;
    }
  }

  private void g()
  {
    if (this.n)
    {
      this.O.set(this.v.x - this.A, this.v.y, this.v.x, this.v.y + this.A);
      return;
    }
    this.O.set(this.v.x, this.v.y, this.v.x + this.A, this.v.y + this.A);
  }

  private void g(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.v.x, this.v.y, this.x, this.L);
    j();
  }

  private void h()
  {
    if ((this.x == 0) || (this.y == 0))
      return;
    this.K.reset();
    this.K.addCircle(this.v.x, this.v.y, this.x, Direction.CW);
    this.K.addCircle(this.w.x, this.w.y, this.y, Direction.CW);
    float f3 = (float)Math.hypot(this.v.x - this.w.x, this.v.y - this.w.y) * (this.x / (this.x + this.y));
    float f4 = (float)Math.acos(Math.abs(this.x / f3));
    float f1;
    float f2;
    label173: PointF localPointF;
    if (this.n)
    {
      f1 = 3.926991F;
      if (!this.n)
        break label444;
      f2 = 0.7853982F;
      a(this.v, this.x, f1 - f4, this.F);
      a(this.v, this.x, f1 + f4, this.H);
      a(this.w, this.y, f2 + f4, this.G);
      a(this.w, this.y, f2 - f4, this.I);
      localPointF = this.J;
      f1 = this.v.x;
      if (!this.n)
        break label451;
    }
    label444: label451: for (int i1 = -1; ; i1 = 1)
    {
      localPointF.x = (i1 * (f3 * 0.707F) + f1);
      this.J.y = (this.v.y + f3 * 0.707F);
      this.K.moveTo(this.G.x, this.G.y);
      this.K.quadTo(this.J.x, this.J.y, this.F.x, this.F.y);
      this.K.lineTo(this.H.x, this.H.y);
      this.K.quadTo(this.J.x, this.J.y, this.I.x, this.I.y);
      this.K.close();
      return;
      f1 = 5.497788F;
      break;
      f2 = 2.356195F;
      break label173;
    }
  }

  private void h(Canvas paramCanvas)
  {
    float f1 = this.q.x;
    if (this.n);
    for (int i1 = -this.t; ; i1 = this.t)
    {
      paramCanvas.drawCircle(i1 + f1, this.q.y + this.t, this.u, this.L);
      return;
    }
  }

  private void i()
  {
    this.c = 0;
    this.B = 0L;
    this.l.removeCallbacksAndMessages(null);
    if (this.d != null)
      this.d.cancel();
    if (this.e != null)
      this.e.cancel();
    if (this.f != null)
      this.f.cancel();
    if (this.g != null)
      this.g.cancel();
    if (this.h != null)
      this.h.cancel();
    if (this.i != null)
      this.i.cancel();
  }

  private void j()
  {
    this.l.sendEmptyMessage(0);
  }

  private void k()
  {
    this.c = 1;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    this.d = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, -0.5F), Keyframe.ofFloat(0.1F, -0.35F), Keyframe.ofFloat(0.2F, -0.25F), Keyframe.ofFloat(0.3F, -0.08F), Keyframe.ofFloat(0.4F, 0.3F), Keyframe.ofFloat(0.5F, 0.6F), Keyframe.ofFloat(0.6F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
    this.d.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = all.a(all.this) * f1;
        paramAnonymousValueAnimator = all.b(all.this);
        if (all.c(all.this));
        for (f1 = f2; ; f1 = all.d(all.this) - f2)
        {
          paramAnonymousValueAnimator.x = f1;
          all.b(all.this).y = (all.e(all.this) - f2);
          return;
        }
      }
    });
    this.e = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, -0.5F), Keyframe.ofFloat(0.5F, -0.5F), Keyframe.ofFloat(0.6F, 0.0F), Keyframe.ofFloat(0.7F, 0.1F), Keyframe.ofFloat(0.75F, 0.11F), Keyframe.ofFloat(0.8F, 0.13F), Keyframe.ofFloat(0.85F, 0.3F), Keyframe.ofFloat(0.9F, 0.58F), Keyframe.ofFloat(0.95F, 0.95F), Keyframe.ofFloat(0.98F, 0.99F), Keyframe.ofFloat(1.0F, 1.0F) }) });
    this.e.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = all.a(all.this) * f1;
        paramAnonymousValueAnimator = all.f(all.this);
        if (all.c(all.this));
        for (f1 = f2; ; f1 = all.d(all.this) - f2)
        {
          paramAnonymousValueAnimator.x = f1;
          all.f(all.this).y = (all.e(all.this) - f2);
          return;
        }
      }
    });
    this.f = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.1F), Keyframe.ofFloat(0.1F, 0.78F), Keyframe.ofFloat(0.6F, 0.78F), Keyframe.ofFloat(1.0F, 1.0F) }) });
    this.f.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        all.a(all.this, (int)(f * all.g(all.this)));
      }
    });
    this.g = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.1F), Keyframe.ofFloat(0.2F, 0.8F), Keyframe.ofFloat(1.0F, 1.0F) }) });
    this.g.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        all.b(all.this, (int)(f * all.h(all.this)));
      }
    });
    localAnimatorSet.setDuration(850L);
    localAnimatorSet.playTogether(new Animator[] { this.d, this.e, this.f, this.g });
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        all.i(all.this).obtainMessage(3, 2, 0).sendToTarget();
      }
    });
    localAnimatorSet.start();
    j();
  }

  private void l()
  {
    this.c = 2;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    this.h = ValueAnimator.ofFloat(new float[] { 1.0F, 0.87F });
    this.h.setDuration(135L);
    this.h.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        all.a(all.this, (int)(f * all.g(all.this)));
      }
    });
    this.i = ValueAnimator.ofFloat(new float[] { 0.9F, 1.0F });
    this.i.setDuration(135L);
    this.i.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        all.c(all.this, (int)(f * all.j(all.this)));
      }
    });
    localAnimatorSet.setDuration(135L);
    localAnimatorSet.playTogether(new Animator[] { this.h, this.i });
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        all.i(all.this).obtainMessage(3, 3, 0).sendToTarget();
      }
    });
    localAnimatorSet.start();
    j();
  }

  private void m()
  {
    this.B = System.currentTimeMillis();
    j();
    this.l.removeMessages(3);
  }

  private void n()
  {
    this.c = 5;
    this.d = ValueAnimator.ofFloat(new float[] { 0.0F, this.t });
    this.d.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = all.b(all.this);
        float f3 = all.k(all.this).x;
        if (all.c(all.this));
        for (float f1 = -f2; ; f1 = f2)
        {
          paramAnonymousValueAnimator.x = (f1 + f3);
          all.b(all.this).y = (f2 + all.k(all.this).y);
          return;
        }
      }
    });
    this.f = ValueAnimator.ofInt(new int[] { this.z, this.u });
    this.f.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        all.a(all.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(550L);
    localAnimatorSet.playTogether(new Animator[] { this.d, this.f });
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        all.i(all.this).obtainMessage(3, 6, 0).sendToTarget();
      }
    });
    localAnimatorSet.start();
    j();
  }

  public void a()
  {
    if (e() != null)
      e().a();
    while (this.m)
      return;
    this.m = true;
    this.l.sendEmptyMessage(1);
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (e() != null)
    {
      e().a(paramInt1, paramInt2);
      return;
    }
    SwipeApplication.c();
    this.o = paramInt1;
    this.p = paramInt2;
    paramInt2 = Math.min(this.o, asq.a(30.0F));
    this.r = ((int)(paramInt2 * 0.32F));
    int i1 = this.r;
    PointF localPointF;
    if ((this.k.get() instanceof avb))
    {
      paramInt1 = this.o - paramInt2 >> 2;
      this.j = (paramInt1 + (paramInt2 - i1));
      localPointF = this.q;
      if (!this.n)
        break label295;
    }
    label295: for (float f1 = this.j; ; f1 = this.o - this.j)
    {
      localPointF.x = f1;
      this.q.y = (this.p - this.j);
      this.s = ((int)(this.r * 0.7D));
      this.z = ((int)(this.r * 0.87F));
      this.u = ((int)(this.r * 0.5F));
      this.t = (this.r - this.u);
      this.C[0] = (-(int)(this.r * 0.425D));
      this.C[1] = 0;
      this.C[2] = ((int)(this.r * 0.425D));
      this.D[0] = ((int)(this.r * 0.55D));
      this.D[1] = ((int)(this.r * 0.28D));
      this.D[2] = ((int)(this.r * 0.12D));
      this.E = asq.a(1.0F);
      return;
      paramInt1 = 0;
      break;
    }
  }

  public void a(Canvas paramCanvas)
  {
    if (e() != null)
      e().a(paramCanvas);
    while (!this.m)
      return;
    DrawFilter localDrawFilter = paramCanvas.getDrawFilter();
    paramCanvas.setDrawFilter(atw.a);
    b(paramCanvas);
    paramCanvas.setDrawFilter(localDrawFilter);
  }

  public void a(View paramView, boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.k = new WeakReference(paramView);
    this.l = new alm(this, null);
    this.L = new Paint();
    this.L.setColor(-65536);
    this.L.setStyle(Style.FILL);
    this.L.setFlags(7);
    this.M = new Paint();
    this.M.setColor(-1);
    this.M.setStyle(Style.FILL);
    this.M.setFlags(7);
    this.N = new Paint();
    this.N.setColor(-16777216);
    this.q = new PointF();
    this.v = new PointF();
    this.w = new PointF();
    this.F = new PointF();
    this.J = new PointF();
    this.G = new PointF();
    this.H = new PointF();
    this.I = new PointF();
    this.K = new Path();
    this.O = new RectF();
  }

  public void a(boolean paramBoolean)
  {
    if (e() != null)
      e().a(paramBoolean);
    while (!this.m)
      return;
    this.m = false;
    this.l.obtainMessage(2, Boolean.valueOf(paramBoolean)).sendToTarget();
  }

  public void b()
  {
    if (e() != null)
      e().b();
    while (!this.m)
      return;
    this.l.removeCallbacksAndMessages(null);
    this.l.sendEmptyMessageDelayed(1, 500L);
  }

  public boolean c()
  {
    if (e() != null)
      return e().c();
    return this.m;
  }

  public void d()
  {
    if (e() != null)
    {
      e().d();
      return;
    }
    i();
    this.m = false;
  }

  public alj e()
  {
    if (a != null)
      a.a((View)this.k.get(), this.n);
    return a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     all
 * JD-Core Version:    0.6.2
 */