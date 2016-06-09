package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.ViewConfiguration;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.hetero.iwatch.WatchItemSector;
import java.lang.ref.WeakReference;

public class yj
{
  private static final String a = "Swipe." + yj.class.getSimpleName();
  private final WeakReference<yb> b;
  private final WeakReference<xv> c;
  private final boolean d;
  private float e;
  private boolean f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private final int o;
  private final int p;
  private boolean q = false;
  private HandlerThread r;
  private boolean s;
  private float t = -1.0F;
  private float u = 1.0F;
  private float v = 250.0F;
  private TimeInterpolator w;
  private final Handler x = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      try
      {
        switch (paramAnonymousMessage.what)
        {
        case 0:
          yj.a(yj.this, ((Float)paramAnonymousMessage.obj).floatValue());
          yj.b(yj.this).w();
          return;
        case 1:
          yj.b(yj.this).x();
          sendEmptyMessageDelayed(2, 100L);
          return;
        case 2:
          if (yj.c(yj.this) != null)
          {
            yj.c(yj.this).quit();
            return;
          }
          break;
        case 3:
          removeMessages(3);
          if ((yj.d(yj.this)) || (yj.e(yj.this) <= 0.0F))
          {
            yj.b(yj.this, 0.0F);
            return;
          }
          yj.a(yj.this, yj.f(yj.this) + (yj.g(yj.this) - yj.f(yj.this)) * (1.0F - yj.e(yj.this)));
          yj.b(yj.this).w();
          if (yj.e(yj.this) == 1.0F)
            yj.c(yj.this, Math.max(Math.min(yj.g(yj.this) * 200.0F, 200.0F), 100.0F));
          yj.d(yj.this, yj.e(yj.this) - 17.0F / yj.h(yj.this));
          if (yj.e(yj.this) > 0.0F)
          {
            sendEmptyMessageDelayed(3, 17L);
            return;
          }
          yj.b(yj.this, 0.0F);
          return;
        }
        return;
      }
      catch (Throwable paramAnonymousMessage)
      {
      }
    }
  };

  public yj(yb paramyb)
  {
    this.b = new WeakReference(paramyb);
    this.c = new WeakReference(paramyb.getBaseSectorArea());
    this.d = paramyb.n();
    try
    {
      i1 = ViewConfiguration.get(j()).getScaledMinimumFlingVelocity();
      this.o = (i1 * 3);
      this.p = (i1 * 2);
      return;
    }
    catch (Exception paramyb)
    {
      while (true)
        int i1 = asq.a(50.0F);
    }
  }

  private float b(float paramFloat)
  {
    this.j = i().getOuterSize();
    if (paramFloat <= this.j)
      return paramFloat / this.j;
    if (this.f)
      return this.g * paramFloat * paramFloat + this.h * paramFloat + this.i;
    try
    {
      this.l = aqs.ag();
      this.n = f();
      this.k = (this.j * this.j);
      this.m = (this.l * this.l);
      this.g = ((this.n - 1.0F) / (this.m - this.k - 2.0F * this.l * (this.l - this.j)));
      this.h = (-2.0F * this.l * this.g);
      this.i = (1.0F - this.g * this.k - this.h * this.j);
      this.f = true;
      return this.g * paramFloat * paramFloat + this.h * paramFloat + this.i;
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.g = 0.0F;
        this.h = 0.0F;
        this.i = 1.0F;
      }
    }
  }

  private boolean b(float paramFloat1, float paramFloat2)
  {
    if ((this.e >= 1.0F) || (this.t >= 1.0F));
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (!this.d)
              break;
          }
          while ((paramFloat1 > this.o) && (paramFloat2 < -this.o));
          if ((paramFloat1 >= -this.p) || (paramFloat2 <= this.p))
            break;
          return false;
        }
        while ((paramFloat1 < -this.o) && (paramFloat2 < -this.o));
        if ((paramFloat1 > this.p) && (paramFloat2 > this.p))
          return false;
        if ((this.e > i().getHandTrackDismissThreshold()) || (this.t > i().getHandTrackDismissThreshold()));
        for (int i1 = 1; i1 == 0; i1 = 0)
          return false;
        if (!this.d)
          break;
      }
      while ((paramFloat1 >= 0.0F) || (paramFloat2 <= 0.0F));
      return false;
    }
    while ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F));
    return false;
  }

  private void c(float paramFloat1, float paramFloat2)
  {
    if (!i().h())
    {
      this.q = true;
      return;
    }
    this.q = false;
    if (this.e == 0.0F)
    {
      h().x();
      h().a(yb.a.g, false);
      return;
    }
    final ValueAnimator localValueAnimator = d(paramFloat1, paramFloat2);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        yj.a(yj.this).obtainMessage(0, paramAnonymousValueAnimator.getAnimatedValue()).sendToTarget();
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        yj.a(yj.this).sendEmptyMessage(1);
      }
    });
    this.r = new HandlerThread("")
    {
      public void onLooperPrepared()
      {
        localValueAnimator.start();
      }
    };
    this.r.start();
  }

  private ValueAnimator d(float paramFloat1, float paramFloat2)
  {
    final float f2 = this.e;
    float f1 = Math.abs(f2 - 1.0F) * 0.05F + 0.95F;
    ValueAnimator localValueAnimator;
    if (f2 >= 1.0F)
    {
      localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, 1.0F });
      localValueAnimator.setInterpolator(new TimeInterpolator()
      {
        private float a(float paramAnonymousFloat)
        {
          return (1.0F - paramAnonymousFloat) * 0.5F * (1.0F - paramAnonymousFloat) + (1.0F - paramAnonymousFloat) * 0.5F;
        }

        public float getInterpolation(float paramAnonymousFloat)
        {
          return (float)(a(paramAnonymousFloat) * Math.cos(paramAnonymousFloat * 3.141592653589793D * 1.5D - 3.141592653589793D) + 1.0D);
        }
      });
      localValueAnimator.setDuration((int)(f1 * (yd.a() * 4)));
      return localValueAnimator;
    }
    if (ahy.d(j()))
    {
      f1 = WatchItemSector.getDuration() * f1;
      if (f2 <= 0.0F)
        break label225;
    }
    label225: for (this.w = new TimeInterpolator()
    {
      final TimeInterpolator a = new ye(false);

      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat = (paramAnonymousFloat - f2) / (1.0F - f2);
        return this.a.getInterpolation(paramAnonymousFloat) * (1.0F - f2) + f2;
      }
    }
    ; ; this.w = new ye(false))
    {
      localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, 1.0F });
      paramFloat2 = (float)Math.hypot(paramFloat1, paramFloat2);
      float f3 = h().getRealRadius();
      paramFloat1 = f1;
      if (paramFloat2 > 0.0F)
      {
        paramFloat1 = Math.max(Math.min((1.0F - f2) * f3 * 2.0F / paramFloat2 * 1000.0F, f1), f1 * (1.0F - f2));
        localValueAnimator.setInterpolator(new TimeInterpolator()
        {
          public float getInterpolation(float paramAnonymousFloat)
          {
            return 1.0F - (1.0F - paramAnonymousFloat) * (1.0F - paramAnonymousFloat);
          }
        });
      }
      localValueAnimator.setDuration((int)paramFloat1);
      return localValueAnimator;
      f1 = yd.a() * 6 * f1;
      break;
    }
  }

  public static boolean e()
  {
    return !aqs.z();
  }

  private float f()
  {
    int i1 = aqs.ac();
    if (ahy.d(j()));
    for (float f1 = 1.18F; ; f1 = 1.08F)
      return Math.min(f1 * i1 / this.j, 1.3F);
  }

  private void g()
  {
    afv.b();
    h().c(true);
  }

  private yb h()
  {
    return (yb)this.b.get();
  }

  private xv i()
  {
    return (xv)this.c.get();
  }

  private Context j()
  {
    return SwipeApplication.c();
  }

  public float a(float paramFloat)
  {
    if (this.w == null)
      return paramFloat;
    return this.w.getInterpolation(paramFloat);
  }

  public void a()
  {
    h();
    if (!yb.v());
    while (!this.q)
      return;
    c(0.0F, 0.0F);
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    h();
    if (!yb.v())
      return;
    this.s = true;
    if (b(paramFloat1, paramFloat2))
    {
      c(paramFloat1, paramFloat2);
      return;
    }
    this.q = false;
    g();
  }

  public void a(int paramInt)
  {
    h();
    if (!yb.v())
      return;
    float f1 = b(paramInt);
    if (this.u > 0.0F)
    {
      this.t = f1;
      this.x.sendEmptyMessageDelayed(3, 17L);
    }
    while (true)
    {
      h().w();
      return;
      this.e = f1;
    }
  }

  public float b()
  {
    return this.e;
  }

  public boolean c()
  {
    return this.s;
  }

  public boolean d()
  {
    h();
    return (yb.v()) && (this.e > 0.0F);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yj
 * JD-Core Version:    0.6.2
 */