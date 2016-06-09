package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.features.guide.NewGuide;
import com.lazyswipe.features.guide.NewGuideActivity;
import com.lazyswipe.features.guide.NewSwipeGuideView;
import com.lazyswipe.ui.MainActivity;
import java.lang.ref.WeakReference;

public abstract class adg extends RelativeLayout
{
  protected static final String a = "Swipe." + adg.class.getSimpleName();
  public static boolean e;
  protected static boolean f;
  protected final Handler b = new Handler();
  public int c;
  public int d;
  private WeakReference<yb> g;
  private boolean h;

  public adg(Context paramContext)
  {
    super(paramContext);
  }

  public adg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static adg a(yb paramyb)
  {
    if (f)
      return null;
    adg localadg = (adg)LayoutInflater.from(SwipeApplication.c()).inflate(2130968705, null);
    localadg.b(paramyb);
    return localadg;
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (!yb.o())
    {
      amk.b(paramContext, true);
      e = paramBoolean;
      vs.e(paramContext, 2);
      SwipeService.b("mostUsed", true);
    }
  }

  private void b(yb paramyb)
  {
    this.g = new WeakReference(paramyb);
    paramyb.addView(this, new FrameLayout.LayoutParams(-1, -1));
    int i = asq.a(25.0F);
    this.c = vg.e;
    this.d = (vg.f - i);
  }

  public static boolean d()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    return ((Build.VERSION.SDK_INT < 19) && ((!aqs.p()) || (!aqs.F()))) || ((!aqs.b(localSwipeApplication)) || ((aqs.ai()) && (!wu.b(localSwipeApplication))));
  }

  public static void g()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    amk.b(localSwipeApplication, false);
    int i = vs.F(localSwipeApplication);
    int j = getGuideEndStep();
    vs.G(localSwipeApplication);
    if (i < j)
      vs.e(localSwipeApplication, j);
  }

  public static int getGuideEndStep()
  {
    return 4;
  }

  public static int getShowCount()
  {
    return vs.a(SwipeApplication.c(), "user_guide_show_count", 0);
  }

  public static boolean i()
  {
    return (amk.b(SwipeApplication.c())) && (vs.F(SwipeApplication.c()) < 4);
  }

  public static boolean j()
  {
    return (amk.b(SwipeApplication.c())) && (vs.F(SwipeApplication.c()) < 3);
  }

  private static void k()
  {
    int i = getShowCount();
    vs.b(SwipeApplication.c(), "user_guide_show_count", i + 1);
  }

  public FanItem a(int paramInt)
  {
    Object localObject = getFanLayer();
    if ((localObject == null) || (((xu)localObject).getChildCount() == 0))
      return null;
    int i = paramInt;
    if (paramInt > ((xu)localObject).getChildCount() - 1)
      i = ((xu)localObject).getChildCount() - 1;
    View localView = ((xu)localObject).getChildAt(i);
    if (((localView instanceof FanItem)) && (!(localView.getTag() instanceof ys)))
      return (FanItem)localView;
    paramInt = i - 1;
    if (paramInt < 0)
      return null;
    localObject = ((xu)localObject).getChildAt(paramInt);
    if ((localObject instanceof FanItem))
      return (FanItem)localObject;
    return null;
  }

  public abstract void a();

  public void a(final boolean paramBoolean)
  {
    if (this.h);
    do
    {
      return;
      this.h = true;
      g();
      if ((getFan() != null) && (getFan().getBaseSectorArea() != null))
        getFan().getBaseSectorArea().setVisibility(4);
      animate().alpha(0.0F).setDuration(800L).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          adg.this.post(new Runnable()
          {
            public void run()
            {
              adg.this.c();
              yb.e(false);
              if (adg.1.this.a)
                adg.this.post(new Runnable()
                {
                  public void run()
                  {
                    if (vs.c(adg.this.getContext(), "auto_guide_swipe", false))
                    {
                      SwipeService.a(adg.this.getContext(), SwipeService.a(adg.this.getContext(), false).getExtras());
                      return;
                    }
                    NewSwipeGuideView.a(adg.this.getContext());
                  }
                });
            }
          });
        }
      });
    }
    while (aqs.g());
    NewGuideActivity.g();
  }

  public abstract boolean b();

  public void c()
  {
    try
    {
      g();
      if ((this.g != null) && (this.g.get() != null))
        ((yb)this.g.get()).removeView(this);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void e()
  {
    g();
    amk.b(SwipeApplication.c(), false);
    NewGuideActivity.g();
  }

  public void f()
  {
    e();
    c();
    getFan().c(false);
    getContext().startActivity(new Intent(getContext(), MainActivity.class).addFlags(268435456));
  }

  public yb getFan()
  {
    if (this.g != null)
      return (yb)this.g.get();
    return null;
  }

  public xu getFanLayer()
  {
    Object localObject = getFan();
    if (localObject == null)
      return null;
    localObject = ((yb)localObject).getItemLayer();
    if (localObject != null);
    while (true)
    {
      return localObject;
      localObject = null;
    }
  }

  public FanItem getMockItem()
  {
    if (getFanLayer() == null);
    xu localxu;
    do
    {
      return null;
      localxu = getFanLayer();
    }
    while (localxu.getChildCount() == 0);
    int i = 0;
    while (i < localxu.getChildCount())
    {
      View localView = localxu.getChildAt(i);
      if (((localView instanceof FanItem)) && ((localView.getTag() instanceof adh)))
        return (FanItem)localView;
      i += 1;
    }
    return a(9);
  }

  public void h()
  {
    final Context localContext = getContext().getApplicationContext();
    getFan().getBaseSectorArea().setVisibility(4);
    animate().alpha(0.0F).setDuration(800L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        adg.this.post(new Runnable()
        {
          public void run()
          {
            adg.this.c();
            yb.e(false);
            adg.this.post(new Runnable()
            {
              public void run()
              {
                NewGuide.a(adg.2.this.a, true);
              }
            });
          }
        });
      }
    });
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    k();
    f = true;
    a();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((b()) || (getShowCount() > 1))
      g();
    this.b.removeCallbacksAndMessages(null);
    f = false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adg
 * JD-Core Version:    0.6.2
 */