package cmcm.com.myapplication.com.lazyswipe.features.cleaner;

import acq;
import acw;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import aqs;
import ari;
import arj;
import asq;
import atw;
import vg;

public class CleaningEngine extends FrameLayout
{
  public boolean a;
  protected ImageView b;
  public ImageView c;
  public ImageView d;
  protected ImageView e;
  protected ImageView f;
  private boolean g;
  private int h;
  private int i;
  private Bitmap j;
  private Bitmap k;
  private Bitmap l;
  private Bitmap m;
  private Bitmap n;
  private Bitmap o;
  private boolean p;
  private final Handler q = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 1:
      }
      CleaningEngine.this.d();
    }
  };

  public CleaningEngine(Context paramContext)
  {
    super(paramContext);
  }

  public CleaningEngine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private Bitmap a(String paramString)
  {
    try
    {
      paramString = acq.a().a(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      this.p = true;
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
    }
    return null;
  }

  private float b(int paramInt1, int paramInt2)
  {
    if (!this.g)
      return 0.5F;
    try
    {
      paramInt1 = Math.abs(paramInt1 - this.h);
      float f1 = ari.a(ari.a(vg.e / 2 - acw.g, 0.5F, 0.0F, 1.0F, paramInt1), 0.0F, 1.0F);
      return f1;
    }
    catch (Exception localException)
    {
    }
    return 0.5F;
  }

  private void c()
  {
    if (!g())
    {
      h();
      f();
    }
  }

  private void f()
  {
    try
    {
      Bitmap localBitmap1 = atw.a(getResources(), 2130837558);
      int i1 = localBitmap1.getWidth();
      int i2 = localBitmap1.getHeight();
      Bitmap localBitmap2 = Bitmap.createBitmap(i1 * 2, i2 * 2, Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.rotate(0.0F, i1, i2);
      localCanvas.drawBitmap(localBitmap1, i1, 0.0F, null);
      localCanvas.rotate(0.0F, i1, i2);
      localCanvas.rotate(90.0F, i1, i2);
      localCanvas.drawBitmap(localBitmap1, i1, 0.0F, null);
      localCanvas.rotate(-90.0F, i1, i2);
      localCanvas.rotate(180.0F, i1, i2);
      localCanvas.drawBitmap(localBitmap1, i1, 0.0F, null);
      localCanvas.rotate(-180.0F, i1, i2);
      localCanvas.rotate(270.0F, i1, i2);
      localCanvas.drawBitmap(localBitmap1, i1, 0.0F, null);
      localCanvas.rotate(-270.0F, i1, i2);
      this.k = localBitmap2;
      atw.a(localBitmap1);
      this.a = true;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.k = atw.a(getResources(), 2130837814);
    }
  }

  private boolean g()
  {
    boolean bool2 = false;
    this.p = false;
    this.k = a("float_cleaner_fan_slow");
    this.l = a("float_cleaner_fan_fast");
    this.j = a("float_cleaner_border");
    this.m = a("float_cleaner_mask");
    this.n = a("float_cleaner_cap");
    this.o = a("float_cleaner_shadow");
    boolean bool1 = bool2;
    if (atw.b(this.l))
    {
      bool1 = bool2;
      if (atw.b(this.k))
        bool1 = true;
    }
    return bool1;
  }

  private void h()
  {
    atw.a(this.j);
    atw.a(this.k);
    atw.a(this.l);
    atw.a(this.m);
    atw.a(this.n);
    atw.a(this.o);
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
  }

  private void i()
  {
    int i1 = (aqs.ac() - getMeasuredWidth()) / 2;
    int i2 = (aqs.ad() - getMeasuredHeight()) / 2;
    animate().x(i1).y(i2).scaleX(1.0F).scaleY(1.0F).setDuration(200L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        CleaningEngine.this.animate().setListener(null);
        CleaningEngine.b(CleaningEngine.this);
      }
    });
  }

  private void j()
  {
    if (!b())
      return;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, asq.a(1.0F), 0.0F, 0.0F);
    localTranslateAnimation.setRepeatMode(1);
    localTranslateAnimation.setRepeatCount(-1);
    localTranslateAnimation.setInterpolator(new CycleInterpolator(1.0F));
    localTranslateAnimation.setDuration(210L);
    startAnimation(localTranslateAnimation);
  }

  void a(int paramInt1, int paramInt2)
  {
    setX(paramInt1 - getMeasuredWidth() / 2);
    setY(paramInt2 - getMeasuredHeight() / 2);
    setScale(b(paramInt1, paramInt2));
  }

  void a(final Runnable paramRunnable)
  {
    clearAnimation();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    localValueAnimator.setDuration(500L);
    localValueAnimator.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.2F)
          return 1.75F * paramAnonymousFloat + 1.0F;
        return -1.68F * paramAnonymousFloat + 1.68F;
      }
    });
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ari.a(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue(), 0.0F, 1.25F);
        CleaningEngine.this.setScale(f);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        CleaningEngine.this.postDelayed(new Runnable()
        {
          public void run()
          {
            CleaningEngine.6.this.a.run();
          }
        }
        , 10L);
      }
    });
    localValueAnimator.start();
  }

  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.c.animate().cancel();
    this.d.animate().cancel();
    if (!this.a)
    {
      if (this.g)
      {
        this.c.animate().alpha(0.0F).setDuration(50L);
        this.d.animate().alpha(1.0F).setDuration(50L);
      }
    }
    else
      return;
    this.c.animate().alpha(1.0F).setDuration(50L);
    this.d.animate().alpha(0.0F).setDuration(50L);
  }

  public boolean a()
  {
    return true;
  }

  public boolean b()
  {
    return true;
  }

  public void d()
  {
    float f1 = this.c.getRotation();
    float f2 = getSlowFanSpeed();
    this.c.setRotation(f1 + f2);
    f1 = this.d.getRotation();
    f2 = getFastFanSpeed();
    this.d.setRotation(f1 + f2);
    this.q.sendEmptyMessage(1);
  }

  void e()
  {
    if ((getMeasuredWidth() != 0) && (getMeasuredHeight() != 0))
    {
      i();
      return;
    }
    requestLayout();
    this.q.postDelayed(new Runnable()
    {
      public void run()
      {
        CleaningEngine.a(CleaningEngine.this);
      }
    }
    , 100L);
  }

  public int getFastFanSpeed()
  {
    return 23;
  }

  public int getSlowFanSpeed()
  {
    return 19;
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (a())
      this.q.sendEmptyMessage(1);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.q.removeMessages(1);
    h();
    if (this.p)
      arj.a(new Runnable()
      {
        public void run()
        {
          acq.a().b();
        }
      }
      , 500L);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((ImageView)findViewById(2131755243));
    this.c = ((ImageView)findViewById(2131755244));
    this.d = ((ImageView)findViewById(2131755245));
    this.e = ((ImageView)findViewById(2131755246));
    this.f = ((ImageView)findViewById(2131755247));
    c();
    this.b.setImageBitmap(this.j);
    this.c.setImageBitmap(this.k);
    this.d.setImageBitmap(this.l);
    this.e.setImageBitmap(this.m);
    this.f.setImageBitmap(this.n);
    setBackgroundDrawable(new BitmapDrawable(getResources(), this.o));
    this.h = (aqs.ac() / 2);
    this.i = (aqs.ad() / 2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setPivotX(getMeasuredWidth() / 2);
    setPivotY(getMeasuredHeight() / 2);
  }

  public void setScale(float paramFloat)
  {
    setScaleX(paramFloat);
    setScaleY(paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.cleaner.CleaningEngine
 * JD-Core Version:    0.6.2
 */