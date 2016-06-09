package cmcm.com.myapplication;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class v
  implements AnimationListener
{
  private AnimationListener a = null;
  private boolean b = false;
  private View c = null;

  public v(View paramView, Animation paramAnimation)
  {
    if ((paramView == null) || (paramAnimation == null))
      return;
    this.c = paramView;
  }

  public v(View paramView, Animation paramAnimation, AnimationListener paramAnimationListener)
  {
    if ((paramView == null) || (paramAnimation == null))
      return;
    this.a = paramAnimationListener;
    this.c = paramView;
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.c != null) && (this.b))
      this.c.post(new Runnable()
      {
        public void run()
        {
          ez.a(v.a(v.this), 0, null);
        }
      });
    if (this.a != null)
      this.a.onAnimationEnd(paramAnimation);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.a != null)
      this.a.onAnimationRepeat(paramAnimation);
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.c != null)
    {
      this.b = u.a(this.c, paramAnimation);
      if (this.b)
        this.c.post(new Runnable()
        {
          public void run()
          {
            ez.a(v.a(v.this), 2, null);
          }
        });
    }
    if (this.a != null)
      this.a.onAnimationStart(paramAnimation);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     v
 * JD-Core Version:    0.6.2
 */