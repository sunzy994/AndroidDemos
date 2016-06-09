package cmcm.com.myapplication.com.lazyswipe.features.boostplus;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.lazyswipe.features.cleaner.CleaningEngine;

public class BoostProgressEngine extends CleaningEngine
{
  private boolean g;
  private int h;

  public BoostProgressEngine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected boolean a()
  {
    return false;
  }

  protected boolean b()
  {
    return false;
  }

  void c()
  {
    if (!this.a)
    {
      this.c.animate().alpha(0.0F).setDuration(500L);
      this.d.animate().alpha(1.0F).setDuration(500L);
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 23 });
    localValueAnimator.setDuration(800L);
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        BoostProgressEngine.a(BoostProgressEngine.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
    localValueAnimator.start();
    d();
  }

  public Point getCenter()
  {
    return new Point(getLeft() + getWidth() / 2, getTop() + getHeight() / 2);
  }

  protected int getFastFanSpeed()
  {
    return this.h;
  }

  protected int getSlowFanSpeed()
  {
    return this.h;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.g)
    {
      setScale(0.0F);
      animate().scaleX(1.0F).scaleY(1.0F).setDuration(350L).setInterpolator(new AccelerateInterpolator());
    }
  }

  void setNeedScale(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.boostplus.BoostProgressEngine
 * JD-Core Version:    0.6.2
 */