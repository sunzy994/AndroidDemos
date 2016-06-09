package cmcm.com.myapplication.com.lazyswipe.features.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqs;
import com.lazyswipe.SwipeService;

public class UpgradeGuide extends RelativeLayout
  implements OnClickListener
{
  private static final String a = "Swipe." + UpgradeGuide.class.getSimpleName();
  private GuideBackground b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;

  public UpgradeGuide(Context paramContext)
  {
    super(paramContext);
  }

  public UpgradeGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a()
  {
    postDelayed(new Runnable()
    {
      public void run()
      {
        UpgradeGuide.b(UpgradeGuide.this).a(true, new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            UpgradeGuide.a(UpgradeGuide.this);
          }
        });
      }
    }
    , 100L);
  }

  private void b()
  {
    this.c.animate().alpha(1.0F).setDuration(800L).setStartDelay(300L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        UpgradeGuide.c(UpgradeGuide.this);
      }
    });
  }

  private void c()
  {
    this.c.animate().alpha(0.0F).setDuration(1800L).setStartDelay(1800L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        UpgradeGuide.d(UpgradeGuide.this);
      }
    });
  }

  private void d()
  {
    this.d.animate().alpha(1.0F).setDuration(1800L).setStartDelay(700L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        UpgradeGuide.this.postDelayed(new Runnable()
        {
          public void run()
          {
            UpgradeGuide.e(UpgradeGuide.this);
          }
        }
        , 700L);
      }
    });
  }

  private void e()
  {
    this.d.animate().setListener(null);
    this.e.animate().setListener(null);
    this.d.setVisibility(8);
    this.e.setAlpha(1.0F);
    f();
  }

  private void f()
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.e.getLocationOnScreen(arrayOfInt1);
    this.f.getLocationOnScreen(arrayOfInt2);
    int m = this.e.getWidth();
    int n = this.e.getHeight();
    int i1 = this.f.getWidth();
    int i2 = this.f.getHeight();
    int i3 = arrayOfInt2[0];
    int i4 = arrayOfInt1[0];
    int i5 = arrayOfInt2[1];
    int i6 = arrayOfInt1[1];
    float f1 = i1 / m;
    float f2 = i2 / n;
    this.e.setPivotX(0.0F);
    this.e.setPivotY(0.0F);
    this.e.animate().scaleX(f1).scaleY(f2).translationX(i3 - i4).translationY(i5 - i6).setDuration(300L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        UpgradeGuide.f(UpgradeGuide.this).setAlpha(1.0F);
        UpgradeGuide.g(UpgradeGuide.this).setVisibility(8);
        UpgradeGuide.h(UpgradeGuide.this);
      }
    });
  }

  private void g()
  {
    this.g.animate().alpha(1.0F).setDuration(500L).setStartDelay(200L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        UpgradeGuide.i(UpgradeGuide.this);
      }
    });
  }

  private void h()
  {
    int m = aqs.ac();
    this.h.setTranslationX(m / 2);
    this.h.animate().alpha(1.0F).translationX(0.0F).setDuration(650L).setStartDelay(500L).setListener(null);
    this.j.setTranslationX(m / 2);
    this.j.animate().alpha(1.0F).translationX(0.0F).setDuration(650L).setStartDelay(1000L).setListener(null);
  }

  public void a(final boolean paramBoolean)
  {
    animate().alpha(0.0F).setDuration(200L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        UpgradeGuideActivity.g();
        if (paramBoolean)
          SwipeService.a(UpgradeGuide.this.getContext(), SwipeService.a(UpgradeGuide.this.getContext(), true).getExtras());
      }
    });
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131755072:
    case 2131755073:
    }
    a(true);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(this);
    this.b = ((GuideBackground)findViewById(2131755066));
    this.b.a(new int[] { -9711107, -9711107, -9278753, -12237959 }, new float[] { 0.0F, 0.07F, 0.5F, 1.0F });
    this.h = ((TextView)findViewById(2131755070));
    this.j = ((TextView)findViewById(2131755072));
    this.i = ((TextView)findViewById(2131755073));
    this.k = ((TextView)findViewById(2131755071));
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.c = ((ImageView)findViewById(2131755067));
    this.d = ((ImageView)findViewById(2131755068));
    this.e = ((ImageView)findViewById(2131755069));
    this.f = ((ImageView)findViewById(2131755356));
    this.g = ((ImageView)findViewById(2131755357));
    this.f.setAlpha(0.0F);
    this.g.setAlpha(0.0F);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.guide.UpgradeGuide
 * JD-Core Version:    0.6.2
 */