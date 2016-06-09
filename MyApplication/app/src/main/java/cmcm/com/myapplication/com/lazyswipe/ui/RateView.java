package cmcm.com.myapplication.com.lazyswipe.ui;

import afv;
import amk;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apz;
import asq;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.guide.GuideBackground;
import java.lang.ref.WeakReference;
import vs;
import vv;
import vy;
import yb;

public class RateView extends FrameLayout
  implements AnimatorListener, OnClickListener, Runnable
{
  static String a;
  private static final String b = "Swipe." + RateView.class.getSimpleName();
  private static boolean d;
  private static WeakReference<RateView> e;
  private static boolean n;
  private boolean c;
  private LinearLayout f;
  private LinearLayout g;
  private ImageView[] h;
  private ImageView[] i;
  private View j;
  private GuideBackground k;
  private int l;
  private final Runnable m = new Runnable()
  {
    public void run()
    {
      if (!RateView.h());
      while (RateView.c(RateView.this).length == 0)
        return;
      if (RateView.d(RateView.this) < RateView.c(RateView.this).length)
      {
        RateView.c(RateView.this)[RateView.d(RateView.this)].setVisibility(0);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        RateView.c(RateView.this)[RateView.d(RateView.this)].startAnimation(localAlphaAnimation);
        RateView.e(RateView.this);
        RateView.this.postDelayed(RateView.f(RateView.this), 200L);
        return;
      }
      RateView.a(RateView.this, 0);
      RateView.a(RateView.this, 2000L);
    }
  };

  public RateView(Context paramContext)
  {
    this(paramContext, null);
  }

  public RateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public RateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public static RateView a(ViewGroup paramViewGroup)
  {
    RateView localRateView = (RateView)LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968732, null, false);
    localRateView.setAttachedToActivity(false);
    localRateView.setVisibility(0);
    paramViewGroup.addView(localRateView);
    localRateView.a("编辑");
    return localRateView;
  }

  private void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      postDelayed(new Runnable()
      {
        public void run()
        {
          int i = 0;
          while (i < RateView.c(RateView.this).length)
          {
            RateView.c(RateView.this)[i].setVisibility(4);
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAlphaAnimation.setDuration(300L);
            RateView.c(RateView.this)[i].startAnimation(localAlphaAnimation);
            i += 1;
          }
          RateView.b(RateView.this, 300L);
        }
      }
      , paramLong);
      return;
    }
    b(0L);
  }

  private void b(long paramLong)
  {
    if (!d)
      return;
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new TranslateAnimation(1, 0.213F, 1, 0.0F, 1, 0.596F, 1, 0.0F));
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.setStartOffset(paramLong);
    localAnimationSet.setDuration(800L);
    localAnimationSet.setInterpolator(new AccelerateInterpolator());
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramAnonymousAnimation = new AnimationSet(true);
        paramAnonymousAnimation.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.213F, 1, 0.0F, 1, 0.596F));
        paramAnonymousAnimation.addAnimation(new AlphaAnimation(1.0F, 0.0F));
        paramAnonymousAnimation.setDuration(800L);
        paramAnonymousAnimation.setInterpolator(new DecelerateInterpolator());
        paramAnonymousAnimation.setFillAfter(true);
        paramAnonymousAnimation.setStartOffset(500L);
        RateView.b(RateView.this).startAnimation(paramAnonymousAnimation);
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    this.j.startAnimation(localAnimationSet);
    postDelayed(this.m, paramLong + 800L + 500L);
  }

  public static void b(boolean paramBoolean)
  {
    yb localyb = yb.getInstance();
    if ((localyb != null) && (localyb.h != null) && ((paramBoolean) || (localyb.h.hasMessages(4))))
    {
      n = false;
      localyb.h.removeMessages(4);
      localyb.h.sendEmptyMessageDelayed(4, 1000L);
    }
  }

  public static boolean b()
  {
    if (!d)
      return false;
    if ((e != null) && (e.get() != null));
    try
    {
      ((RateView)e.get()).a(false);
      while (true)
      {
        label36: vv.a().a("评星-Back返回", "Source", a);
        return true;
        d = false;
      }
    }
    catch (Throwable localThrowable)
    {
      break label36;
    }
  }

  public static boolean c()
  {
    return d;
  }

  public static boolean d()
  {
    if (!n)
    {
      yb localyb = yb.getInstance();
      if ((localyb != null) && (localyb.h != null) && (localyb.h.hasMessages(4)))
      {
        localyb.h.removeMessages(4);
        n = true;
      }
    }
    return n;
  }

  public static void e()
  {
    n = false;
  }

  public static void f()
  {
    b(n);
  }

  public static void g()
  {
    n = false;
    if (!vs.e(SwipeApplication.c(), false));
    do
    {
      return;
      vs.e(SwipeApplication.c(), 200);
      amk.c(SwipeApplication.c(), true);
    }
    while ((yb.getInstance() == null) || (yb.getInstance().h == null));
    Handler localHandler = yb.getInstance().h;
    localHandler.removeMessages(4);
    localHandler.sendEmptyMessageDelayed(4, 1250L);
  }

  public void a()
  {
    a(true);
  }

  public void a(String paramString)
  {
    n = false;
    if (d)
      return;
    amk.c(getContext(), false);
    a = paramString;
    d = true;
    setVisibility(0);
    animate().alpha(1.0F).setListener(null);
    e = new WeakReference(this);
    vv.a().a("评星-Show", "Source", a);
    post(new Runnable()
    {
      public void run()
      {
        int[] arrayOfInt1 = new int[2];
        RateView.a(RateView.this)[(RateView.a(RateView.this).length - 1)].getLocationOnScreen(arrayOfInt1);
        int[] arrayOfInt2 = new int[2];
        ((View)RateView.b(RateView.this).getParent()).getLocationOnScreen(arrayOfInt2);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)RateView.b(RateView.this).getLayoutParams();
        localLayoutParams.leftMargin = (arrayOfInt1[0] - arrayOfInt2[0] + asq.a(9.5F));
        localLayoutParams.topMargin = (arrayOfInt1[1] - arrayOfInt2[1] + asq.a(15.0F));
        RateView.b(RateView.this).setLayoutParams(localLayoutParams);
        RateView.b(RateView.this).setVisibility(0);
        RateView.a(RateView.this, 0L);
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    if (!d)
      return;
    a = null;
    if (e != null)
    {
      e.clear();
      e = null;
    }
    this.j.clearAnimation();
    removeCallbacks(this.m);
    d = false;
    if (paramBoolean)
    {
      ViewPropertyAnimator localViewPropertyAnimator = animate().alpha(0.0F);
      if (Build.VERSION.SDK_INT >= 16)
      {
        localViewPropertyAnimator.withEndAction(this);
        return;
      }
      localViewPropertyAnimator.setListener(this);
      return;
    }
    run();
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    if (paramBoolean2)
      if (!paramBoolean1)
        break label23;
    label23: for (int i1 = 2131230988; ; i1 = 2131230987)
    {
      setImageAndText(i1);
      return;
    }
  }

  public void onAnimationCancel(Animator paramAnimator)
  {
    setVisibility(8);
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
    setVisibility(8);
  }

  public void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public void onAnimationStart(Animator paramAnimator)
  {
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131755434:
    case 2131755436:
    case 2131755437:
    case 2131755438:
    default:
      return;
    case 2131755433:
    case 2131755435:
      afv.b();
      vv.a().a("评星-Cancel", "Source", a);
      a();
      vs.f(getContext(), true);
      vy.b(2);
      return;
    case 2131755440:
      afv.b();
      vv.a().a("评星-Dislike", "Source", a);
      a(false);
      if (!this.c)
      {
        yb.p();
        vs.f(getContext(), false);
      }
      asq.d(getContext(), new Intent(getContext(), FragmentContainer.FeedbackActivity.class));
      vy.b(1);
      return;
    case 2131755439:
    }
    afv.b();
    vv.a().a("评星-Rate", "Source", a);
    a(false);
    if (!this.c)
    {
      yb.p();
      vs.f(getContext(), false);
    }
    Context localContext = getContext();
    if (apz.b());
    for (paramView = "com.lazyswipe.pro2"; ; paramView = "com.lazyswipe")
    {
      asq.g(localContext, paramView);
      vy.b(0);
      return;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(this);
    findViewById(2131755434).setOnClickListener(this);
    findViewById(2131755435).setOnClickListener(this);
    findViewById(2131755439).setOnClickListener(this);
    findViewById(2131755440).setOnClickListener(this);
    this.f = ((LinearLayout)findViewById(2131755437));
    this.g = ((LinearLayout)findViewById(2131755438));
    this.j = findViewById(2131755441);
    this.h = new ImageView[this.f.getChildCount()];
    int i1 = 0;
    while (i1 < this.h.length)
    {
      this.h[i1] = ((ImageView)this.f.getChildAt(i1));
      i1 += 1;
    }
    this.i = new ImageView[this.g.getChildCount()];
    i1 = 0;
    while (i1 < this.i.length)
    {
      this.i[i1] = ((ImageView)this.g.getChildAt(i1));
      this.i[i1].setVisibility(4);
      i1 += 1;
    }
    this.k = ((GuideBackground)findViewById(2131755066));
    this.k.a(new int[] { -9711107, -9711107, -9278753, -12237959, -12237959 }, new float[] { 0.0F, 0.07F, 0.5F, 0.8F, 1.0F });
    this.k.setHillBottom(asq.a(125.0F));
    GuideBackground localGuideBackground = this.k;
    float f1 = GuideBackground.a(178);
    float f2 = GuideBackground.a(309);
    float f3 = GuideBackground.a(3);
    float[] arrayOfFloat1 = { GuideBackground.a(764), GuideBackground.a(282), GuideBackground.a(3) };
    float[] arrayOfFloat2 = { GuideBackground.a(672), GuideBackground.a(353), GuideBackground.a(3) };
    localGuideBackground.setStarsPosition(new float[][] { { f1, f2, f3 }, arrayOfFloat1, arrayOfFloat2 });
    this.k.a(new float[] { 366.0F, 338.0F }, new float[] { 545.0F, 237.0F });
    this.k.a();
  }

  public void run()
  {
    setVisibility(8);
  }

  public void setAttachedToActivity(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }

  public void setImageAndText(int paramInt)
  {
    ((TextView)findViewById(2131755080)).setText(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.RateView
 * JD-Core Version:    0.6.2
 */