package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class ik extends ImageView
{
  private Animation.AnimationListener a;
  private int b;

  public ik(Context paramContext, int paramInt, float paramFloat)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(paramFloat * f * 2.0F);
    int j = (int)(1.75F * f);
    int k = (int)(0.0F * f);
    this.b = ((int)(3.5F * f));
    if (a())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      ez.f(this, f * 4.0F);
    }
    while (true)
    {
      paramContext.getPaint().setColor(paramInt);
      setBackgroundDrawable(paramContext);
      return;
      paramContext = new ShapeDrawable(new il(this, this.b, i));
      ez.a(this, 1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.b, k, j, 503316480);
      i = this.b;
      setPadding(i, i, i, i);
    }
  }

  private boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }

  public void a(Animation.AnimationListener paramAnimationListener)
  {
    this.a = paramAnimationListener;
  }

  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.a != null)
      this.a.onAnimationEnd(getAnimation());
  }

  public void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.a != null)
      this.a.onAnimationStart(getAnimation());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!a())
      setMeasuredDimension(getMeasuredWidth() + this.b * 2, getMeasuredHeight() + this.b * 2);
  }

  public void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable))
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ik
 * JD-Core Version:    0.6.2
 */