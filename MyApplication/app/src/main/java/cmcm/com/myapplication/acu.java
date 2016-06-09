package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;

public class acu extends ImageView
  implements auc
{
  private static final String a = "Swipe." + acu.class.getSimpleName();
  private final String b;
  private final int c;
  private final int d;
  private final int e;
  private final float f;
  private final int g;
  private long h;
  private boolean i;
  private final Handler j = new Handler();
  private final Point k;
  private long l;
  private boolean m;
  private boolean n;
  private ValueAnimator o;
  private ValueAnimator p;
  private ValueAnimator q;
  private int r;
  private ValueAnimator s;
  private int t;
  private final int u = (int)(360.0F * ari.c(1.0F, 2.0F));
  private ValueAnimator v;

  private acu(Context paramContext, String paramString, Point paramPoint)
  {
    super(paramContext);
    this.b = paramString;
    this.c = 0;
    this.e = ari.c(0, 360);
    this.g = ari.c(1400, 2000);
    int i1 = aqs.ae() / 2;
    int i2 = asq.a(25.0F);
    this.d = ari.c(i1 - i2, i1 + i2);
    this.f = ari.c(0.9F, 1.05F);
    this.r = this.d;
    this.t = this.e;
    this.k = paramPoint;
    setScaleType(ScaleType.CENTER_INSIDE);
    setLayerType(2, null);
    setScaleType(ScaleType.CENTER_INSIDE);
    setScaleX(this.f);
    setScaleY(this.f);
    setAlpha(0.0F);
  }

  public static acu a(Context paramContext, Point paramPoint)
  {
    return new acu(paramContext, "leaf", paramPoint);
  }

  public static acu a(Context paramContext, String paramString, Point paramPoint)
  {
    return new acu(paramContext, paramString, paramPoint);
  }

  public static acu b(Context paramContext, Point paramPoint)
  {
    return new acu(paramContext, "fake", paramPoint);
  }

  private void b()
  {
    this.l = (System.currentTimeMillis() + this.c);
    Object localObject = SwipeApplication.c().a().a(this.b);
    aty localaty = FanItem.g;
    if (localObject != null)
    {
      localaty.a(getResources(), this, (wk)localObject, this);
      return;
    }
    if (i())
    {
      localObject = atp.a(2130837607, getContext());
      localObject = new BitmapDrawable(getContext().getResources(), (Bitmap)localObject);
      setImageDrawable((Drawable)localObject);
      a((Drawable)localObject);
      return;
    }
    localObject = atp.g(getContext());
    localObject = new BitmapDrawable(getContext().getResources(), (Bitmap)localObject);
    setImageDrawable((Drawable)localObject);
    a((Drawable)localObject);
  }

  private void c()
  {
    if (System.currentTimeMillis() - this.l <= 0L)
    {
      d();
      return;
    }
    this.j.postDelayed(new Runnable()
    {
      public void run()
      {
        acu.a(acu.this);
      }
    }
    , System.currentTimeMillis() - this.l);
  }

  private void d()
  {
    if ((!this.m) || (this.i))
      return;
    e();
    f();
    g();
    j();
    l();
  }

  private void e()
  {
    this.o = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.o.setDuration(this.g);
    this.o.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.2F)
          return 5.0F * paramAnonymousFloat;
        if (paramAnonymousFloat < 0.7D)
          return 1.0F;
        return 3.3F - 3.3F * paramAnonymousFloat;
      }
    });
    this.o.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ari.a(((Float) paramAnonymousValueAnimator.getAnimatedValue()).floatValue(), 0.0F, 1.0F);
        acu.this.setAlpha(f);
      }
    });
    this.o.start();
  }

  private void f()
  {
    this.p = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.p.setDuration(this.g);
    this.p.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat > 0.6D)
          return 2.125F - 1.875F * paramAnonymousFloat;
        return 1.0F;
      }
    });
    this.p.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ari.a(((Float) paramAnonymousValueAnimator.getAnimatedValue()).floatValue(), 0.0F, 1.0F) * acu.b(acu.this);
        acu.this.setScaleX(f);
        acu.this.setScaleY(f);
      }
    });
    this.p.start();
  }

  private void g()
  {
    ValueAnimator localValueAnimator;
    if (h())
    {
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, this.u });
      this.q = localValueAnimator;
      if (!h())
        break label120;
    }
    label120: for (int i1 = this.g; ; i1 = 1200)
    {
      int i2 = this.g / i1;
      this.q.setDuration(i1);
      this.q.setRepeatCount(i2 + 1);
      this.q.setRepeatMode(1);
      this.q.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          acu.this.setRotation(f);
        }
      });
      this.q.start();
      return;
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      break;
    }
  }

  private boolean h()
  {
    return "leaf".equals(this.b);
  }

  private boolean i()
  {
    return "fake".equals(this.b);
  }

  private void j()
  {
    this.s = ValueAnimator.ofInt(new int[] { this.d, 0 });
    this.s.setDuration(this.g);
    this.s.setInterpolator(new AccelerateInterpolator());
    this.s.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        acu.a(acu.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        acu.c(acu.this);
      }
    });
    this.s.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        acu.d(acu.this);
      }
    });
    this.s.start();
  }

  private void k()
  {
    this.j.postDelayed(new Runnable()
    {
      public void run()
      {
        if (acu.this.getParent() != null);
        try
        {
          ((ViewGroup)acu.this.getParent()).removeView(acu.this);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    }
    , 100L);
  }

  private void l()
  {
    this.v = ValueAnimator.ofInt(new int[] { this.e + this.u, 0 });
    this.v.setDuration(this.g);
    this.v.setInterpolator(new AccelerateInterpolator());
    this.v.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        acu.b(acu.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        acu.c(acu.this);
      }
    });
    this.v.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        acu.a(acu.this, false);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        acu.a(acu.this, System.currentTimeMillis());
        acu.a(acu.this, true);
      }
    });
    this.v.start();
  }

  private void m()
  {
    int i1 = (int)(this.r * Math.cos(Math.toRadians(this.t)));
    int i2 = (int)(this.r * Math.sin(Math.toRadians(this.t)));
    int i3 = this.k.x;
    int i4 = getMeasuredWidth() / 2;
    int i5 = this.k.y;
    int i6 = getMeasuredWidth() / 2;
    setX(i1 + i3 - i4);
    setY(i2 + i5 - i6);
  }

  private void n()
  {
    Log.i(a, "recycle()");
    this.j.removeCallbacksAndMessages(null);
    setLayerType(0, null);
    asv.a(this.o);
    asv.a(this.p);
    asv.a(this.q);
    asv.a(this.s);
    asv.a(this.v);
  }

  public void a()
  {
    this.i = true;
  }

  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
      c();
  }

  public void a(FrameLayout paramFrameLayout)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 51;
    paramFrameLayout.addView(this, localLayoutParams);
    b();
  }

  public void a(RelativeLayout paramRelativeLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(10);
    paramRelativeLayout.addView(this, localLayoutParams);
    b();
  }

  public long getRequireTime()
  {
    if ((!this.m) || (!this.n))
      return 0L;
    long l1 = System.currentTimeMillis();
    long l2 = this.h;
    return ari.a(this.g - (l1 - l2) + 100L, 0L, 2000L);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.m = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    n();
    this.m = false;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setPivotX(getMeasuredWidth() / 2);
    setPivotY(getMeasuredHeight() / 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acu
 * JD-Core Version:    0.6.2
 */