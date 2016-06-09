package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.lazyswipe.SwipeApplication;

public class aog extends View
{
  private static final String c = "Swipe." + aog.class.getSimpleName();
  public long a;
  protected yb b;
  private boolean d;
  private int e;
  private int f;
  private final Handler g = new Handler();

  public aog(Context paramContext)
  {
    super(paramContext);
  }

  private void a()
  {
    float f2 = (float)(this.b.getTabSectorOuterSize() * 1.1D) / this.e;
    if (this.d);
    for (float f1 = 0.0F; ; f1 = this.e)
    {
      setPivotX(f1);
      setPivotY(this.e);
      setScaleX(f2);
      setScaleY(f2);
      setAlpha(0.8F);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, View.ALPHA, new float[] { 0.0F });
      localObjectAnimator1.setInterpolator(new TimeInterpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          if (paramAnonymousFloat < 0.85D)
            return 0.0F;
          return (float)(6.67D * paramAnonymousFloat - 5.67D);
        }
      });
      localObjectAnimator1.setDuration(180L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, View.SCALE_X, new float[] { 1.0F });
      localObjectAnimator2.setDuration(180L);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, View.SCALE_Y, new float[] { 1.0F });
      localObjectAnimator3.setDuration(180L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          aog.a(aog.this).post(new Runnable()
          {
            public void run()
            {
              aog.f(aog.this);
              aog.this.setLayerType(0, null);
              aog.this.b.removeView(aog.this);
              aoe.a(aog.this, aog.this.a);
            }
          });
        }
      });
      localAnimatorSet.start();
      return;
    }
  }

  public static void a(Context paramContext, yb paramyb, int paramInt, long paramLong)
  {
    paramContext = new aog(paramContext);
    paramContext.a = paramLong;
    paramContext.a(paramyb, paramInt);
  }

  private void a(final yb paramyb, int paramInt)
  {
    this.b = paramyb;
    this.d = paramyb.n();
    paramyb = SwipeApplication.c().getResources().getDisplayMetrics();
    this.e = Math.min(paramyb.widthPixels, paramyb.heightPixels);
    this.f = asq.a(7.0F);
    paramyb = new FrameLayout.LayoutParams(this.e, this.e);
    int i;
    if (this.d)
      i = 3;
    while (true)
    {
      paramyb.gravity = (i | 0x50);
      paramyb.bottomMargin = 0;
      if (this.d)
        paramyb.leftMargin = 0;
      try
      {
        while (true)
        {
          setLayerType(aoe.d(), null);
          this.g.postDelayed(new Runnable()
          {
            public void run()
            {
              aog.this.setBackgroundDrawable(new aoh(aog.this.getContext(), aog.b(aog.this), aog.c(aog.this), aog.d(aog.this)));
              aog.this.b.addView(aog.this, paramyb);
              aog.e(aog.this);
              aoe.a();
            }
          }
          , paramInt * 168 + 1750);
          return;
          i = 5;
          break;
          paramyb.rightMargin = 0;
        }
      }
      catch (Exception paramyb)
      {
      }
    }
  }

  private void b()
  {
    setBackgroundDrawable(null);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g.postDelayed(new Runnable()
    {
      public void run()
      {
        aog.a(aog.this).removeCallbacksAndMessages(null);
      }
    }
    , 100L);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.e, this.e);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aog
 * JD-Core Version:    0.6.2
 */