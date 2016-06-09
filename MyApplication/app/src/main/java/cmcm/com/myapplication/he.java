package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

class he
{
  public static void a(final View paramView, hf paramhf)
  {
    if (paramhf != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          he.this.c(paramView);
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          he.this.b(paramView);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          he.this.a(paramView);
        }
      });
      return;
    }
    paramView.animate().setListener(null);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     he
 * JD-Core Version:    0.6.2
 */