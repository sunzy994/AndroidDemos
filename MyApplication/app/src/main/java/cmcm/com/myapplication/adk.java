package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.lazyswipe.features.leap.Curtain;
import com.lazyswipe.features.leap.card.CardFlow;

public class adk extends View
  implements Callback
{
  private float A;
  private boolean B;
  private RectF C;
  private int D;
  private tj E;
  private boolean F;
  private final adl a;
  private final adm b;
  private Curtain c;
  private CardFlow d;
  private final PointF e;
  private final PointF f;
  private int g;
  private int h;
  private VelocityTracker i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private boolean o;
  private boolean p;
  private final Handler q;
  private final FrameLayout.LayoutParams r;
  private yb s;
  private final adn t;
  private int u;
  private int v;
  private adj w;
  private adj x;
  private boolean y;
  private float z;

  public static float a(Context paramContext)
  {
    return vs.a(paramContext).getFloat("pref_lucky_lamp_cord_left", -0.01F);
  }

  private float a(Configuration paramConfiguration, float paramFloat)
  {
    float f2 = 0.91F;
    float f1;
    int i1;
    if ((!aqs.p(getContext())) && (paramConfiguration.orientation == 2))
      if (!this.s.n())
      {
        f1 = 0.09F;
        i1 = 0;
        label38: if (f1 > 0.0F)
          break label158;
        f1 = f2;
      }
    label158: 
    while (true)
    {
      float f3 = aqs.ac();
      f2 = f3 * f1;
      if (f2 - paramFloat / 2.0F < 0.0F)
      {
        paramFloat /= 2.0F;
        f1 = paramFloat;
        if (i1 != 0)
        {
          a(getContext(), paramFloat / f3);
          f1 = paramFloat;
        }
      }
      do
      {
        do
        {
          return f1;
          f1 = 0.91F;
          break;
          f1 = a(getContext());
          i1 = 1;
          break label38;
          f1 = f2;
        }
        while (paramFloat / 2.0F + f2 <= f3);
        paramFloat = f3 - paramFloat / 2.0F;
        f1 = paramFloat;
      }
      while (i1 == 0);
      a(getContext(), paramFloat / f3);
      return paramFloat;
    }
  }

  private void a(float paramFloat)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.b.a(), paramFloat });
    localValueAnimator.setDuration(220L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        adk.d(adk.this).a(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        adk.e(adk.this).b();
        adk.this.invalidate();
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (adk.a(adk.this) == 0)
          adk.this.setFullScreen(false);
      }
    });
    localValueAnimator.start();
  }

  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.b.b(paramFloat1, paramFloat2);
    if ((this.c == null) || (this.c.c()))
    {
      this.b.b(paramFloat1, paramFloat2);
      this.q.sendEmptyMessageDelayed(1, 17L);
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat2 > this.k)
      {
        a(1);
        return;
      }
      if (paramFloat2 < -this.l)
      {
        j();
        return;
      }
      if (this.D < this.n / 2)
      {
        j();
        return;
      }
      a(1);
      return;
    }
    a(false, true);
  }

  public static void a(Context paramContext, float paramFloat)
  {
    vs.a(paramContext).edit().putFloat("pref_lucky_lamp_cord_left", paramFloat).commit();
  }

  private void a(MotionEvent paramMotionEvent)
  {
    if (this.i == null)
      this.i = VelocityTracker.obtain();
    this.i.addMovement(paramMotionEvent);
  }

  private void a(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    if (paramBoolean1);
    for (int i1 = 0; ; i1 = this.n)
    {
      final int i2 = this.D;
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.D, i1 });
      localValueAnimator.setDuration((int)Math.abs((i1 - this.D) * 300.0F / this.n));
      localValueAnimator.setInterpolator(new DecelerateInterpolator());
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int j = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          adk.this.b(j);
          if (adk.a(adk.this) == 2);
          for (int i = 1; ; i = 0)
          {
            if ((!paramBoolean1) && (this.b != 0) && (i == 0))
            {
              float f1 = Math.abs((j - i2) / this.b);
              float f2 = adk.b(adk.this);
              float f3 = adk.b(adk.this) - adk.c(adk.this);
              adk.d(adk.this).a(f2 - f1 * f3 * 0.35F);
              adk.e(adk.this).b();
              adk.this.invalidate();
            }
            return;
          }
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (paramBoolean1)
          {
            adk.a(adk.this, 0);
            adk.a(adk.this, adk.b(adk.this));
            adk.this.setFullScreen(false);
            adk.f(adk.this).b();
            return;
          }
          if (adk.a(adk.this) == 2);
          for (int i = 1; ; i = 0)
          {
            adk.a(adk.this, 2);
            if ((i == 0) || (paramBoolean2))
              adk.a(adk.this, adk.c(adk.this));
            if ((!paramBoolean2) || (adk.g(adk.this) == null))
              break;
            adk.g(adk.this).a(false);
            return;
          }
        }
      });
      localValueAnimator.start();
      return;
    }
  }

  private void l()
  {
    a(getContext(), this.b.a.x / aqs.ac());
  }

  private void m()
  {
    if (this.i != null)
      this.i.recycle();
    this.i = null;
  }

  private void n()
  {
    this.b.b(0.0F, 0.0F);
    this.q.sendEmptyMessageDelayed(1, 17L);
  }

  private void o()
  {
  }

  private void p()
  {
    if (this.h != 0);
    while (!vg.k)
      return;
    apz.a(getContext());
    Object localObject = getContext();
    if (apz.b());
    for (int i1 = 1; ; i1 = 0)
    {
      vy.b((Context)localObject, "B54", i1);
      if (!apz.b())
        break;
      new avx(getContext()).c(2131231004).g(2131231003).a(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          vs.b(adk.this.getContext(), "pref_lucky_leap_never_show", true);
          adk.this.b();
          paramAnonymousDialogInterface.dismiss();
        }
      }).b(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
        }
      }).b();
      return;
    }
    localObject = (ViewGroup)LayoutInflater.from(getContext()).inflate(2130968626, null);
    if (aqs.h())
      ((ViewGroup)localObject).findViewById(2131755072).setBackgroundColor(-16777216);
    ((TextView)((ViewGroup)localObject).findViewById(2131755218)).setText(2131231002);
    ((ViewGroup)localObject).findViewById(2131755072).setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        asq.g(adk.this.getContext(), "com.lazyswipe.pro2");
        aqt.a(adk.h(adk.this));
        adk.a(adk.this, null);
        yb.p();
      }
    });
    ((ViewGroup)localObject).findViewById(2131755122).setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        aqt.a(adk.h(adk.this));
        adk.a(adk.this, null);
      }
    });
    this.E = new avx(getContext()).a((View)localObject).b();
  }

  private void q()
  {
    if ((this.h == 2) && (this.d != null))
    {
      this.d.a(true);
      localValueAnimator = ValueAnimator.ofInt(new int[] { 0, asq.a(40.0F) });
      localValueAnimator.setDuration(200L);
      localValueAnimator.setInterpolator(new CycleInterpolator(0.5F));
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          adk.d(adk.this).a(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue() + adk.c(adk.this));
          adk.e(adk.this).b();
          adk.this.invalidate();
        }
      });
      localValueAnimator.start();
    }
    while (this.h != 0)
    {
      ValueAnimator localValueAnimator;
      return;
    }
    this.b.b(0.0F, 0.0F);
    setFullScreen(true);
    a(2);
  }

  public void a()
  {
    try
    {
      this.s.addView(this, this.r);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Swipe.LuckyView", "Failed to attach", localException);
    }
  }

  public void a(int paramInt)
  {
    if ((paramInt != 4) && (paramInt != 5))
    {
      vy.b(getContext(), "B33", paramInt);
      vw.a(getContext(), "B33", "value", paramInt);
    }
    int i1;
    if (this.F)
    {
      i1 = this.x.a;
      a(false, false);
      if (paramInt == 5)
        break label105;
      vy.b(getContext(), "B34", i1);
      vw.a(getContext(), "B34", "icon", i1);
    }
    while (true)
    {
      this.c.g();
      return;
      i1 = this.w.a;
      break;
      label105: this.c.setAlpha(0.0F);
      setAlpha(0.0F);
    }
  }

  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i1 = asq.a(35.0F);
    RectF localRectF = this.C;
    float f1 = this.a.c.x;
    float f2 = this.a.e;
    float f3 = i1;
    float f4 = this.a.c.y;
    float f5 = this.a.e;
    float f6 = i1;
    float f7 = this.a.c.x;
    float f8 = this.a.e;
    float f9 = i1;
    float f10 = this.a.c.y;
    float f11 = this.a.e;
    localRectF.set(f1 - f2 - f3, f4 - f5 - f6, f7 + f8 + f9, i1 + (f10 + f11));
    return this.C.contains(paramFloat1, paramFloat2);
  }

  public void b()
  {
    try
    {
      if (this.d != null)
        this.d.d();
      this.s.removeView(this);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Swipe.LuckyView", "Failed to detach", localException);
    }
  }

  public void b(int paramInt)
  {
    this.D = paramInt;
    this.a.a(this.a.c.x, this.b.a() + this.a.e + paramInt, this.e);
    this.b.a(this.b.a.x, paramInt);
    this.b.a(this.e.x, this.e.y, false);
    this.a.b();
    if (this.c == null)
    {
      this.c = Curtain.a();
      this.d = this.c.getCardFlow();
    }
    if (!this.c.f())
    {
      this.c.a(this);
      bringToFront();
    }
    this.c.a(paramInt);
    invalidate();
  }

  public boolean c()
  {
    return (this.s != null) && (getParent() == this.s);
  }

  public void d()
  {
    setVisibility(0);
  }

  public void e()
  {
    this.q.removeCallbacksAndMessages(null);
    setVisibility(8);
  }

  public boolean f()
  {
    return (c()) && (getVisibility() == 0);
  }

  public boolean g()
  {
    if ((this.c != null) && (this.h == 2))
    {
      j();
      return true;
    }
    return false;
  }

  public int getPullState()
  {
    return this.h;
  }

  public int getTouchState()
  {
    return this.g;
  }

  public void h()
  {
    this.t.c();
    this.t.a(getContext(), 500L);
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (!f());
    int i1;
    do
    {
      do
      {
        return true;
        switch (paramMessage.what)
        {
        default:
          return true;
        case 0:
        case 1:
        }
      }
      while (this.g != 0);
      this.o = true;
      p();
      return true;
      i1 = 0;
      if (this.b.c())
      {
        this.a.b();
        i1 = 1;
      }
    }
    while (i1 == 0);
    invalidate();
    this.q.sendEmptyMessageDelayed(1, 17L);
    return true;
  }

  boolean i()
  {
    return (this.c != null) && (this.h != 0);
  }

  public void j()
  {
    a(true, false);
    this.c.h();
  }

  void k()
  {
    this.F = true;
    adi.a(getContext()).a(getContext(), this.x.a);
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.t.a();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.t.a = true;
    this.t.d();
    this.b.b(a(paramConfiguration, this.a.e * 2.0F));
    this.a.b();
    invalidate();
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.t.b();
    if (this.a != null)
      this.a.d();
    aqt.a(this.E);
    this.E = null;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.t.a(paramCanvas);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    a(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (this.g != -1)
    {
      return true;
      this.g = -1;
      this.o = false;
      this.p = false;
      this.B = false;
      if (this.p)
      {
        o();
      }
      else
      {
        if (this.a.a(f1, f2))
        {
          this.b.b();
          this.z = f1;
          this.A = f2;
          this.g = 0;
          this.q.sendEmptyMessageDelayed(0, this.m);
          this.t.d();
          invalidate();
        }
        this.f.set(f1, f2);
        continue;
        if ((!this.p) && (!this.o))
        {
          float f3 = f1 - this.f.x;
          float f4 = f2 - this.f.y;
          if ((Math.abs(f3) > 30.0F) || (Math.abs(f4) > 30.0F))
            this.B = true;
          if (this.g == 0)
          {
            this.i.computeCurrentVelocity(1000, this.j);
            float f5 = this.i.getXVelocity();
            float f6 = this.i.getYVelocity();
            if ((f6 > 0.0F) && (Math.abs(f6) > Math.abs(f5)) && (f4 > 30.0F))
            {
              this.g = 2;
              this.f.set(f1, f2);
              this.q.removeMessages(0);
              setFullScreen(true);
            }
            else if ((f6 > 0.0F) && (Math.abs(f6) > Math.abs(f5)) && (f4 > 30.0F))
            {
              this.g = 2;
              this.f.set(f1, f2);
              this.q.removeMessages(0);
              setFullScreen(true);
            }
            else if ((Math.abs(f5) > Math.abs(f6)) && (Math.abs(f3) > 30.0F))
            {
              this.g = 1;
              this.f.set(f1, f2);
              this.q.removeMessages(0);
            }
            else if ((this.h == 2) && (f6 < 0.0F) && (Math.abs(f6) > Math.abs(f5)) && (f4 < -30.0F))
            {
              this.g = 3;
              this.f.set(f1, f2);
              this.q.removeMessages(0);
            }
          }
          else if (this.g == 2)
          {
            int i1 = ari.b((int) (f2 - this.A), this.n);
            if (this.h == 2)
            {
              this.b.a(i1 + this.v);
              this.a.b();
              invalidate();
            }
            else
            {
              b(i1);
            }
          }
          else if (this.g == 1)
          {
            this.b.b(Math.max(Math.min(getWidth() - this.a.e, this.f.x), this.a.e));
            this.f.set(f1, f2);
            this.a.b();
            invalidate();
          }
          else if (this.g == 3)
          {
            b(ari.b((int) (this.n + f2 - this.A), this.n));
            continue;
            if (!this.p)
            {
              this.q.removeMessages(0);
              if (this.g == 0)
              {
                this.i.computeCurrentVelocity(1000, this.j);
                this.g = -1;
                if ((!this.o) && (!this.B))
                  q();
              }
              while (true)
              {
                m();
                invalidate();
                break;
                n();
                continue;
                if (this.g == 1)
                {
                  n();
                  l();
                  this.g = -1;
                }
                else if (this.g == 2)
                {
                  if (this.o)
                  {
                    n();
                    this.g = -1;
                  }
                  else
                  {
                    this.i.computeCurrentVelocity(1000, this.j);
                    f1 = this.i.getXVelocity();
                    f2 = this.i.getYVelocity();
                    if (this.h == 2);
                    for (boolean bool = true; ; bool = false)
                    {
                      a(f1, f2, bool);
                      break;
                    }
                  }
                }
                else if (this.g == 3)
                {
                  this.i.computeCurrentVelocity(1000, this.j);
                  a(this.i.getXVelocity(), this.i.getYVelocity(), false);
                }
                else
                {
                  this.g = -1;
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  public void setFullScreen(boolean paramBoolean)
  {
    if (this.s == null);
    while (this.y)
      return;
    try
    {
      this.y = paramBoolean;
      if (paramBoolean);
      for (this.r.height = -1; ; this.r.height = ((int)(Math.max(this.u, Math.abs(this.b.c.y - this.b.a.y)) + this.a.e * 3.0F)))
      {
        this.s.updateViewLayout(this, this.r);
        return;
      }
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adk
 * JD-Core Version:    0.6.2
 */