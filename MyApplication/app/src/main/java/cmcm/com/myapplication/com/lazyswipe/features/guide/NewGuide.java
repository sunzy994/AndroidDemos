package cmcm.com.myapplication.com.lazyswipe.features.guide;

import adf;
import adg;
import ahy;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import asq;
import atw;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import vs;
import vy;
import xu;
import xv;
import yb;

public class NewGuide extends adg
  implements OnClickListener
{
  private float A;
  private float B;
  private float C;
  private float D;
  private float E;
  private boolean F;
  private final Path G = new Path();
  private final Paint H = new Paint();
  private final Paint I = new Paint();
  private boolean J;
  private int K;
  private int L;
  private final int M;
  private final int N;
  private int O;
  private boolean g;
  private GuideBackground h;
  private View i;
  private TextView j;
  private ImageView k;
  private View l;
  private TextView m;
  private TextView n;
  private ImageView o;
  private ImageView p;
  private ImageView q;
  private TextView r;
  private TextView s;
  private ImageView t;
  private View u;
  private float v;
  private float w;
  private float x;
  private float y;
  private float z;

  public NewGuide(Context paramContext)
  {
    super(paramContext);
    this.H.setFlags(7);
    this.H.setColor(2147483647);
    this.M = asq.a(6.0F);
    this.N = asq.a(6.0F);
    this.I.setFlags(7);
    this.I.setColor(2147483647);
    this.I.setStyle(Style.FILL);
  }

  public NewGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.H.setFlags(7);
    this.H.setColor(2147483647);
    this.M = asq.a(6.0F);
    this.N = asq.a(6.0F);
    this.I.setFlags(7);
    this.I.setColor(2147483647);
    this.I.setStyle(Style.FILL);
  }

  private void A()
  {
    adf localadf = new adf(false);
    this.k.setImageDrawable(localadf);
    this.k.setPivotX(localadf.getIntrinsicWidth() / 2);
    this.k.setPivotY(localadf.getIntrinsicHeight() / 2);
    this.k.setScaleX(0.0F);
    this.k.setScaleY(0.0F);
    this.k.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(550L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.G(NewGuide.this).setOnClickListener(NewGuide.this);
      }
    });
    this.r.animate().alpha(1.0F).setDuration(100L);
  }

  private ValueAnimator a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = Color.argb(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0, 0, 0);
        NewGuide.this.setBackgroundColor(i);
      }
    });
    return localValueAnimator;
  }

  private void b(int paramInt)
  {
    if ((getFan() == null) || (getFan().getBaseSectorArea() == null))
      return;
    getFan().getBaseSectorArea().animate().alpha(1.0F).setDuration(paramInt).setListener(null);
  }

  private void c(int paramInt)
  {
    if ((getFan() == null) || (getFan().getBaseSectorArea() == null))
      return;
    getFan().getBaseSectorArea().animate().alpha(0.0F).setDuration(paramInt).setListener(null);
  }

  private void k()
  {
    this.i.setTranslationX(this.c / 2);
    this.i.setAlpha(0.0F);
    this.i.setVisibility(0);
    this.i.animate().translationX(0.0F).alpha(1.0F).setDuration(750L).setListener(null);
    this.m.setText(2131231165);
    this.n.setText(getContext().getString(2131231166));
    this.m.setVisibility(0);
    this.n.setVisibility(0);
    this.l.setAlpha(0.0F);
    this.l.setTranslationX(this.c / 2);
    this.l.setVisibility(0);
    this.l.animate().alpha(1.0F).translationX(0.0F).setDuration(750L).setStartDelay(500L).setListener(null);
    float f1 = this.l.getY();
    float f2 = this.l.getHeight();
    float f3 = asq.a(50.0F);
    this.t.setY(f1 + f2 + f3);
    this.t.setTranslationX(this.c / 2);
    this.t.setAlpha(0.0F);
    this.t.animate().alpha(1.0F).translationX(0.0F).setDuration(750L).setStartDelay(800L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.b(NewGuide.this).setOnClickListener(NewGuide.this);
      }
    });
    ColorDrawable localColorDrawable1 = new ColorDrawable(872415231);
    ColorDrawable localColorDrawable2 = new ColorDrawable(1627389951);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable2);
    localStateListDrawable.addState(new int[0], localColorDrawable1);
    this.u.setBackgroundDrawable(localStateListDrawable);
    this.u.animate().alpha(1.0F).setDuration(600L).setStartDelay(800L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.c(NewGuide.this).setOnClickListener(NewGuide.this);
      }
    });
  }

  private void l()
  {
    this.q.animate().alpha(0.0F).setDuration(600L).setListener(null);
    xu localxu = getFanLayer();
    if (localxu == null)
    {
      a(true);
      return;
    }
    ((xu)localxu).j();
    postDelayed(new Runnable()
    {
      public void run()
      {
        NewGuide.d(NewGuide.this).animate().alpha(1.0F).setDuration(600L).setListener(null);
        NewGuide.a(NewGuide.this, 300);
        ValueAnimator localValueAnimator = NewGuide.a(NewGuide.this, 0, 178, 600);
        localValueAnimator.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            NewGuide.this.postDelayed(new Runnable()
            {
              public void run()
              {
                NewGuide.d(NewGuide.this).c();
                NewGuide.this.postDelayed(new Runnable()
                {
                  public void run()
                  {
                    NewGuide.e(NewGuide.this);
                  }
                }
                , 100L);
              }
            }
            , 650L);
          }
        });
        localValueAnimator.start();
      }
    }
    , 300L);
  }

  private void m()
  {
    final xu localxu = getFanLayer();
    final FanItem localFanItem = getMockItem();
    if (localFanItem == null)
    {
      a(true);
      return;
    }
    localFanItem = (FanItem)localFanItem;
    int[] arrayOfInt = new int[2];
    localFanItem.getLocationOnScreen(arrayOfInt);
    final int i1 = arrayOfInt[0];
    i1 = asq.a(4.0F) + i1;
    final int i2 = arrayOfInt[1] + asq.a(4.0F);
    this.q.animate().x(i1).y(i2).setDuration(500L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.a(NewGuide.this, true);
        NewGuide.b(NewGuide.this, i1);
        NewGuide.c(NewGuide.this, i2);
        paramAnonymousAnimator = ValueAnimator.ofInt(new int[] { 0, asq.a(12.0F) });
        paramAnonymousAnimator.setDuration(150L);
        paramAnonymousAnimator.addUpdateListener(new AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            NewGuide.d(NewGuide.this, ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue());
            NewGuide.this.invalidate();
          }
        });
        paramAnonymousAnimator.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            NewGuide.32.this.c.b(NewGuide.32.this.d);
            NewGuide.f(NewGuide.this);
            paramAnonymous2Animator = ValueAnimator.ofInt(new int[] { asq.a(12.0F), 0 });
            paramAnonymous2Animator.setDuration(150L);
            paramAnonymous2Animator.addUpdateListener(new AnimatorUpdateListener()
            {
              public void onAnimationUpdate(ValueAnimator paramAnonymous3ValueAnimator)
              {
                NewGuide.d(NewGuide.this, ((Integer)paramAnonymous3ValueAnimator.getAnimatedValue()).intValue());
                NewGuide.this.invalidate();
              }
            });
            paramAnonymous2Animator.addListener(new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymous3Animator)
              {
                NewGuide.a(NewGuide.this, false);
              }
            });
            paramAnonymous2Animator.start();
          }
        });
        paramAnonymousAnimator.start();
      }
    });
  }

  private void n()
  {
    this.J = false;
    if (getFan() == null)
    {
      a(true);
      return;
    }
    if (getFanLayer() == null)
    {
      a(true);
      return;
    }
    FanItem localFanItem = a(1);
    if (localFanItem == null)
    {
      a(true);
      return;
    }
    getFanLayer().onLongClick((FanItem)localFanItem);
    getFanLayer().i();
    postDelayed(new Runnable()
    {
      public void run()
      {
        NewGuide.a(NewGuide.this, false);
        NewGuide.this.invalidate();
      }
    }
    , 300L);
    postDelayed(new Runnable()
    {
      public void run()
      {
        NewGuide.g(NewGuide.this);
      }
    }
    , 1000L);
  }

  private void o()
  {
    FanItem localFanItem = a(1);
    if (!(localFanItem instanceof FanItem))
    {
      a(true);
      return;
    }
    localFanItem = (FanItem)localFanItem;
    int[] arrayOfInt = new int[2];
    localFanItem.getLocationOnScreen(arrayOfInt);
    final int i1 = arrayOfInt[0] + localFanItem.getWidth() / 2;
    final int i2 = arrayOfInt[1];
    i2 = localFanItem.getHeight() * 2 / 3 + i2;
    int i3 = (int)(this.c * 0.65F);
    int i4 = this.d;
    this.q.setX(i3);
    this.q.setY(i4 - i3);
    this.q.setVisibility(0);
    this.q.setAlpha(1.0F);
    this.q.animate().x(i1).y(i2).setDuration(500L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.a(NewGuide.this, true);
        NewGuide.b(NewGuide.this, i1);
        NewGuide.c(NewGuide.this, i2);
        paramAnonymousAnimator = ValueAnimator.ofInt(new int[] { 0, asq.a(12.0F) });
        paramAnonymousAnimator.setDuration(150L);
        paramAnonymousAnimator.addUpdateListener(new AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            NewGuide.d(NewGuide.this, ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue());
            NewGuide.this.invalidate();
          }
        });
        paramAnonymousAnimator.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            NewGuide.this.postDelayed(new Runnable()
            {
              public void run()
              {
                NewGuide.h(NewGuide.this);
              }
            }
            , 300L);
          }
        });
        paramAnonymousAnimator.start();
      }
    });
  }

  private void p()
  {
    this.l.animate().alpha(0.0F).translationX(-this.c / 2).setDuration(750L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.i(NewGuide.this).setVisibility(8);
        paramAnonymousAnimator = NewGuide.a(NewGuide.this, 178, 0, 400);
        NewGuide.e(NewGuide.this, 400);
        paramAnonymousAnimator.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            NewGuide.this.postDelayed(new Runnable()
            {
              public void run()
              {
                NewGuide.j(NewGuide.this);
              }
            }
            , 600L);
          }
        });
        paramAnonymousAnimator.start();
        NewGuide.d(NewGuide.this).animate().alpha(0.0F).setDuration(400L).setListener(null);
      }
    });
  }

  private void q()
  {
    c(300);
    this.h.animate().alpha(1.0F).setDuration(300L).setListener(null);
    ValueAnimator localValueAnimator = a(0, 178, 300);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.k(NewGuide.this).setText(2131231164);
        NewGuide.k(NewGuide.this).setVisibility(0);
        NewGuide.l(NewGuide.this).setVisibility(8);
        NewGuide.i(NewGuide.this).setAlpha(0.0F);
        NewGuide.i(NewGuide.this).setVisibility(0);
        NewGuide.i(NewGuide.this).setTranslationX(NewGuide.this.c / 2);
        NewGuide.i(NewGuide.this).animate().alpha(1.0F).translationX(0.0F).setDuration(750L).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            NewGuide.this.postDelayed(new Runnable()
            {
              public void run()
              {
                NewGuide.m(NewGuide.this);
              }
            }
            , 1350L);
          }
        });
      }
    });
    localValueAnimator.start();
  }

  private void r()
  {
    a(178, 0, 300).start();
    if (ahy.d(getContext()));
    for (final int i1 = (int)(this.c * 0.6F); ; i1 = this.c / 2)
    {
      final int i2 = this.d - i1;
      this.v = this.K;
      this.w = this.L;
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.K, i1 });
      localValueAnimator.setInterpolator(new AccelerateInterpolator(2.8F));
      localValueAnimator.setDuration(1000L);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          NewGuide.b(NewGuide.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          NewGuide.o(NewGuide.this).setX(NewGuide.n(NewGuide.this));
          float f = NewGuide.p(NewGuide.this) * ((NewGuide.n(NewGuide.this) - NewGuide.q(NewGuide.this)) / (i1 - NewGuide.q(NewGuide.this)));
          NewGuide.a(NewGuide.this, NewGuide.n(NewGuide.this) - f * 0.707F);
          NewGuide.b(NewGuide.this, f * 0.707F + NewGuide.n(NewGuide.this));
          NewGuide.c(NewGuide.this, NewGuide.q(NewGuide.this) + (NewGuide.r(NewGuide.this) - NewGuide.q(NewGuide.this)) * 0.59F);
          NewGuide.d(NewGuide.this, NewGuide.q(NewGuide.this) + (NewGuide.s(NewGuide.this) - NewGuide.q(NewGuide.this)) * 0.56F);
          NewGuide.this.invalidate();
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          NewGuide.b(NewGuide.this, false);
          NewGuide.this.invalidate();
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          NewGuide.b(NewGuide.this, true);
          NewGuide.this.invalidate();
        }
      });
      localValueAnimator.start();
      localValueAnimator = ValueAnimator.ofInt(new int[] { this.L, i2 });
      localValueAnimator.setInterpolator(new AccelerateInterpolator(2.8F));
      localValueAnimator.setDuration(1000L);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          NewGuide.c(NewGuide.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          NewGuide.o(NewGuide.this).setY(NewGuide.t(NewGuide.this));
          float f = NewGuide.p(NewGuide.this) * ((NewGuide.t(NewGuide.this) - NewGuide.u(NewGuide.this)) / (i2 - NewGuide.u(NewGuide.this)));
          NewGuide.e(NewGuide.this, NewGuide.t(NewGuide.this) - f * 0.707F);
          NewGuide.f(NewGuide.this, f * 0.707F + NewGuide.t(NewGuide.this));
          NewGuide.g(NewGuide.this, NewGuide.u(NewGuide.this) + (NewGuide.v(NewGuide.this) - NewGuide.u(NewGuide.this)) * 0.69F);
          NewGuide.h(NewGuide.this, NewGuide.u(NewGuide.this) + (NewGuide.w(NewGuide.this) - NewGuide.u(NewGuide.this)) * 0.66F);
        }
      });
      localValueAnimator.start();
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator.setDuration(50L);
      localValueAnimator.setStartDelay(950L);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          NewGuide.o(NewGuide.this).setAlpha(f);
          if (f < 0.15F)
            NewGuide.a(NewGuide.this, false);
        }
      });
      localValueAnimator.start();
      postDelayed(new Runnable()
      {
        public void run()
        {
          NewGuide.x(NewGuide.this).setVisibility(8);
          NewGuide.y(NewGuide.this).setVisibility(8);
        }
      }
      , 300L);
      if (getFan() != null)
        postDelayed(new Runnable()
        {
          public void run()
          {
            vs.e(SwipeApplication.c(), 3);
            if (NewGuide.this.getFan() != null)
            {
              NewGuide.this.getFan().a("mostUsed", true);
              vs.b(NewGuide.this.getContext(), "auto_guide_swipe", true);
            }
          }
        }
        , 310L);
      postDelayed(new Runnable()
      {
        public void run()
        {
          NewGuide.z(NewGuide.this);
        }
      }
      , 3200L);
      return;
    }
  }

  private void s()
  {
    Object localObject = this.h;
    if (!e);
    for (boolean bool = true; ; bool = false)
    {
      ((GuideBackground)localObject).a(bool, null);
      localObject = a(0, 178, 500);
      ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (adg.e)
          {
            NewGuide.A(NewGuide.this);
            return;
          }
          NewGuide.B(NewGuide.this);
        }
      });
      ((ValueAnimator)localObject).start();
      return;
    }
  }

  private void t()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    int i1 = asq.a(35.0F);
    int i2 = asq.a(8.0F);
    final int i3 = asq.a(10.0F);
    final int i4 = this.d - asq.a(45.0F);
    this.q.setX(i1 + i3);
    this.q.setY(i2 + i4);
    this.q.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.q.animate().x(i3).y(i4);
    if (ahy.d(localSwipeApplication));
    for (long l1 = 320L; ; l1 = 250L)
    {
      localViewPropertyAnimator.setDuration(l1).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          NewGuide.a(NewGuide.this, true);
          NewGuide.b(NewGuide.this, i3);
          NewGuide.c(NewGuide.this, i4);
          paramAnonymousAnimator = ValueAnimator.ofInt(new int[] { 0, asq.a(12.0F) });
          paramAnonymousAnimator.setDuration(150L);
          paramAnonymousAnimator.addUpdateListener(new AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              NewGuide.d(NewGuide.this, ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue());
              NewGuide.this.invalidate();
            }
          });
          paramAnonymousAnimator.addListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              NewGuide.this.postDelayed(new Runnable()
              {
                public void run()
                {
                  NewGuide.C(NewGuide.this);
                }
              }
              , 150L);
            }
          });
          paramAnonymousAnimator.start();
        }
      });
      return;
    }
  }

  private void u()
  {
    this.l.animate().alpha(0.0F).translationX(-this.c / 2).setListener(null).setDuration(750L);
    this.h.animate().alpha(0.0F).setDuration(600L).setListener(null);
    ValueAnimator localValueAnimator = a(178, 255, 600);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.D(NewGuide.this);
      }
    });
    localValueAnimator.start();
  }

  private void v()
  {
    this.l.setVisibility(8);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(600L);
    localValueAnimator.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.2D)
          return 5.0F * paramAnonymousFloat;
        return (float)(1.0D - 0.5D * (paramAnonymousFloat - 0.2D));
      }
    });
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        NewGuide.x(NewGuide.this).setAlpha(f);
        NewGuide.y(NewGuide.this).setAlpha(f);
      }
    });
    localValueAnimator.start();
    postDelayed(new Runnable()
    {
      public void run()
      {
        NewGuide.E(NewGuide.this);
      }
    }
    , 600L);
  }

  private void w()
  {
    this.r.setAlpha(1.0F);
    this.m.setVisibility(0);
    this.n.setVisibility(8);
    this.m.setText(2131231168);
    this.l.setY(this.d * 0.5F - this.l.getHeight() / 2);
    this.l.setTranslationX(this.c / 2);
    this.l.animate().alpha(1.0F).translationX(0.0F).setDuration(750L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.this.postDelayed(new Runnable()
        {
          public void run()
          {
            NewGuide.F(NewGuide.this);
          }
        }
        , 1350L);
      }
    });
  }

  private void x()
  {
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator1.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.25D)
          return 1.0F - paramAnonymousFloat;
        return 0.75F + 6.0F * (paramAnonymousFloat - 0.25F) * (paramAnonymousFloat - 0.25F);
      }
    });
    localValueAnimator1.setDuration(600L);
    localValueAnimator1.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        NewGuide.G(NewGuide.this).setScaleX(f);
        NewGuide.G(NewGuide.this).setScaleY(f);
      }
    });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator2.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.3D)
          return 1.0F - paramAnonymousFloat;
        if (paramAnonymousFloat < 0.7D)
          return 0.7F;
        return -2.33F * paramAnonymousFloat + 2.33F;
      }
    });
    localValueAnimator2.setDuration(600L);
    localValueAnimator2.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        NewGuide.G(NewGuide.this).setAlpha(f);
      }
    });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.G(NewGuide.this).setVisibility(8);
        NewGuide.G(NewGuide.this).setOnClickListener(null);
        NewGuide.H(NewGuide.this);
      }
    });
    localAnimatorSet.playTogether(new Animator[] { localValueAnimator2, localValueAnimator1 });
    localAnimatorSet.start();
  }

  private void y()
  {
    this.i.animate().alpha(0.0F).translationX(-this.c / 2).setDuration(750L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.I(NewGuide.this).setVisibility(8);
      }
    });
    this.j.animate().alpha(0.0F).translationX(-this.c / 2).setStartDelay(350L).setDuration(750L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.J(NewGuide.this).setVisibility(8);
      }
    });
    this.h.b();
    postDelayed(new Runnable()
    {
      public void run()
      {
        NewGuide.A(NewGuide.this);
      }
    }
    , 600L);
  }

  private void z()
  {
    this.i.setTranslationX(this.c / 2);
    this.i.setAlpha(0.0F);
    this.i.setVisibility(0);
    this.i.animate().translationX(0.0F).alpha(1.0F).setDuration(750L);
    this.j.setTranslationX(this.c / 2);
    this.j.animate().translationX(0.0F).setStartDelay(450L).alpha(1.0F).setDuration(750L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewGuide.K(NewGuide.this);
      }
    });
  }

  protected void a()
  {
    postDelayed(new Runnable()
    {
      public void run()
      {
        NewGuide.a(NewGuide.this);
      }
    }
    , 200L);
  }

  protected boolean b()
  {
    return this.g;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.k)
      if (!this.g)
      {
        this.g = true;
        x();
        vy.b(getContext(), "B10", 2);
      }
    do
      while (true)
      {
        return;
        if ((paramView != this.u) && (paramView != this.r))
          break;
        if (d())
          f();
        while (paramView == this.r)
        {
          vy.b(getContext(), "B10", 1);
          return;
          a(true);
        }
      }
    while (paramView != this.t);
    h();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.J)
      paramCanvas.drawCircle(this.K + this.M, this.L + this.N, this.O, this.H);
    if (this.F)
    {
      this.G.reset();
      this.G.moveTo(this.v, this.w);
      this.G.quadTo(this.z, this.A, this.x, this.y);
      this.G.lineTo(this.B, this.C);
      this.G.quadTo(this.D, this.E, this.v, this.w);
      this.G.close();
      paramCanvas.drawPath(this.G, this.I);
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(this);
    this.h = ((GuideBackground)findViewById(2131755066));
    this.i = findViewById(2131755370);
    this.j = ((TextView)findViewById(2131755371));
    this.k = ((ImageView)findViewById(2131755372));
    this.l = findViewById(2131755373);
    this.m = ((TextView)findViewById(2131755070));
    this.n = ((TextView)findViewById(2131755374));
    this.s = ((TextView)findViewById(2131755071));
    this.o = ((ImageView)findViewById(2131755376));
    this.p = ((ImageView)findViewById(2131755377));
    Bitmap localBitmap = atw.c(((BitmapDrawable)this.o.getDrawable()).getBitmap());
    this.p.setImageBitmap(localBitmap);
    this.q = ((ImageView)findViewById(2131755378));
    this.u = findViewById(2131755072);
    this.t = ((ImageView)findViewById(2131755375));
    this.r = ((TextView)findViewById(2131755073));
    this.r.setOnClickListener(this);
    this.h.a(new int[] { -1302601475, -1671700227, 1299214300, 4539257, 4539257 }, new float[] { 0.0F, 0.06F, 0.28F, 0.5F, 1.0F });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.guide.NewGuide
 * JD-Core Version:    0.6.2
 */