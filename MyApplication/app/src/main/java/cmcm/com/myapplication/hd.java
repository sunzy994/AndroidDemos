package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

class hd
{
  public static void a(View paramView)
  {
    paramView.animate().cancel();
  }

  public static void a(View paramView, float paramFloat)
  {
    paramView.animate().alpha(paramFloat);
  }

  public static void a(View paramView, long paramLong)
  {
    paramView.animate().setDuration(paramLong);
  }

  public static void a(final View paramView, hf paramhf)
  {
    if (paramhf != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          hd.this.c(paramView);
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          hd.this.b(paramView);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          hd.this.a(paramView);
        }
      });
      return;
    }
    paramView.animate().setListener(null);
  }

  public static void b(View paramView)
  {
    paramView.animate().start();
  }

  public static void b(View paramView, float paramFloat)
  {
    paramView.animate().translationX(paramFloat);
  }

  public static void c(View paramView, float paramFloat)
  {
    paramView.animate().translationY(paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     hd
 * JD-Core Version:    0.6.2
 */