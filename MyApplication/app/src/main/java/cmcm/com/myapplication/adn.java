package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.animation.LinearInterpolator;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.friend.FriendSector;
import com.lazyswipe.ui.RateView;

public class adn
  implements Callback
{
  private static final Camera f = new Camera();
  private static final Matrix g = new Matrix();
  private static Long o;
  boolean a;
  private final PointF b;
  private float c;
  private final PointF d;
  private final Handler e;
  private float h;
  private float i;
  private float j;
  private final adk k;
  private final adl l;
  private final adm m;
  private boolean n;
  private ValueAnimator p;
  private ValueAnimator q;
  private ValueAnimator r;
  private ValueAnimator s;
  private ValueAnimator t;
  private ValueAnimator u;
  private boolean v;

  private void a(float paramFloat)
  {
    if (this.j == paramFloat);
    do
    {
      return;
      this.j = paramFloat;
    }
    while (this.c <= 0.0F);
    float f1 = Math.abs((float)Math.toRadians(paramFloat));
    if (paramFloat >= 0.0F);
    for (int i1 = 1; ; i1 = -1)
    {
      float f2 = (float)(this.c * Math.sin(f1));
      paramFloat = (float)(this.b.x + i1 * f2 * Math.cos(f1));
      double d1 = this.b.y;
      double d2 = f2;
      f1 = (float)(d1 - Math.sin(f1) * d2);
      this.l.a(paramFloat, f1, this.d);
      this.m.a(this.d.x, this.d.y, true);
      this.l.b();
      this.k.invalidate();
      return;
    }
  }

  private void a(Context paramContext)
  {
  }

  private void b(float paramFloat)
  {
    if (this.h == paramFloat)
      return;
    this.h = paramFloat;
    this.k.invalidate();
  }

  private void c(float paramFloat)
  {
    if (this.i == paramFloat)
      return;
    this.i = paramFloat;
    this.l.a(paramFloat);
    this.k.invalidate();
  }

  private void f()
  {
    c();
    a(this.k.getContext(), 5000L);
  }

  private boolean g()
  {
    return (this.k.i()) || (e()) || (avw.d()) || (avy.d()) || (RateView.c()) || (FriendSector.a()) || ((yb.getInstance() != null) && (yb.getInstance().getItemLayer().f())) || (amk.b(SwipeApplication.c())) || (amk.c(SwipeApplication.c())) || (vj.l);
  }

  private void h()
  {
    if (e())
      return;
    this.b.set(this.l.c.x, this.l.c.y);
    this.c = this.m.a();
    this.n = true;
    i();
    o();
    j();
  }

  private void i()
  {
    this.p = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.p.setDuration(4000L);
    this.p.setStartDelay(150L);
    this.p.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)((1.0F - paramAnonymousFloat) * Math.sin(12.566370614359172D * paramAnonymousFloat));
      }
    });
    this.p.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (adn.this.e())
        {
          adn.a(adn.this).cancel();
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        adn.a(adn.this, f * 15.0F);
      }
    });
    this.p.start();
  }

  private void j()
  {
    this.q = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.q.setDuration(2000L);
    this.q.setStartDelay(1150L);
    this.q.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)Math.sin(6.283185307179586D * paramAnonymousFloat);
      }
    });
    this.q.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (adn.this.e())
        {
          adn.b(adn.this).cancel();
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        adn.b(adn.this, f * 35.0F);
      }
    });
    this.q.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        adn.c(adn.this);
        adn.d(adn.this);
      }
    });
    this.q.start();
  }

  private void k()
  {
    this.r = ValueAnimator.ofInt(new int[] { 0, 180 });
    this.r.setDuration(1000L);
    this.r.setInterpolator(new LinearInterpolator());
    this.r.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (adn.this.e())
        {
          adn.e(adn.this).cancel();
          return;
        }
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        adn.b(adn.this, i);
      }
    });
    this.r.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        adn.f(adn.this);
      }
    });
    this.r.start();
  }

  private void l()
  {
    final float f1 = this.l.a();
    this.s = ValueAnimator.ofInt(new int[] { 25 });
    this.s.setDuration(650L);
    this.s.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)((1.0F - paramAnonymousFloat * paramAnonymousFloat) * Math.sin(6.283185307179586D * paramAnonymousFloat));
      }
    });
    this.s.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (adn.this.e())
        {
          adn.g(adn.this).cancel();
          return;
        }
        int i = (int)f1;
        int j = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        adn.b(adn.this, j + i);
      }
    });
    this.s.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        adn.h(adn.this);
      }
    });
    this.s.start();
  }

  private void m()
  {
    this.n = false;
    this.v = false;
    this.k.k();
  }

  private void n()
  {
    this.t = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.t.setDuration(300L);
    this.t.setStartDelay(600L);
    this.t.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)Math.sin(6.283185307179586D * paramAnonymousFloat);
      }
    });
    this.t.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (adn.this.e())
        {
          adn.i(adn.this).cancel();
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        adn.j(adn.this).c(f);
        adn.k(adn.this).invalidate();
      }
    });
    this.t.start();
  }

  private void o()
  {
    if (ari.c(0, 2) == 0);
    for (final boolean bool = true; ; bool = false)
    {
      this.u = ValueAnimator.ofFloat(new float[] { 1.0F });
      this.u.setDuration(4000L);
      this.u.setStartDelay(150L);
      this.u.setInterpolator(new TimeInterpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          return (float)((1.0F - paramAnonymousFloat) * Math.sin(12.566370614359172D * paramAnonymousFloat));
        }
      });
      this.u.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          if (adn.this.e())
          {
            adn.l(adn.this).cancel();
            return;
          }
          if (bool);
          for (int i = -1; ; i = 1)
          {
            float f1 = i * 4;
            float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            adn.c(adn.this, f2 * f1);
            return;
          }
        }
      });
      this.u.start();
      return;
    }
  }

  private void p()
  {
  }

  void a()
  {
    a(this.k.getContext());
  }

  void a(Context paramContext, long paramLong)
  {
    if (o == null)
      o = Long.valueOf(vs.a(paramContext, "key_lucky_sst", 0L));
    long l1 = System.currentTimeMillis();
    if ((l1 >= o.longValue()) && (l1 - o.longValue() < 7200000L));
    o = Long.valueOf(l1);
    vs.b(paramContext, "key_lucky_sst", l1);
    this.e.sendEmptyMessageDelayed(2, paramLong);
  }

  void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.h != 0.0F)
    {
      g.reset();
      f.save();
      f.rotateX(this.h);
      f.getMatrix(g);
      f.restore();
      PointF localPointF = this.l.c();
      g.preTranslate(-localPointF.x, -localPointF.y);
      g.postTranslate(localPointF.x, localPointF.y);
      paramCanvas.concat(g);
    }
    this.m.a(paramCanvas);
    this.l.a(paramCanvas);
    paramCanvas.restore();
  }

  void b()
  {
    this.e.removeCallbacksAndMessages(null);
    p();
  }

  void c()
  {
    this.e.removeMessages(2);
    a(0.0F);
    b(0.0F);
    c(0.0F);
    asv.a(this.p);
    asv.a(this.q);
    asv.a(this.r);
    asv.a(this.t);
    asv.a(this.u);
    asv.a(this.p);
  }

  void d()
  {
    this.e.removeMessages(2);
    if (this.n)
    {
      c();
      f();
    }
  }

  boolean e()
  {
    return (this.k.getTouchState() != -1) || (this.a);
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (!this.k.f())
      return false;
    switch (paramMessage.what)
    {
    default:
      return false;
    case 2:
    }
    if (g())
    {
      f();
      return false;
    }
    h();
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adn
 * JD-Core Version:    0.6.2
 */