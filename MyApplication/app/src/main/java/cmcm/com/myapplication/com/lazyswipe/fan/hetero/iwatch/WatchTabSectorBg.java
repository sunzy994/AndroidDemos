package cmcm.com.myapplication.com.lazyswipe.fan.hetero.iwatch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import asq;
import atw;
import com.lazyswipe.features.guide.NewGuide;
import yb;
import yd;
import ye;

public class WatchTabSectorBg extends View
{
  private Paint a;
  private boolean b;
  private yb c;
  private int d;

  public WatchTabSectorBg(Context paramContext)
  {
    super(paramContext);
  }

  public WatchTabSectorBg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new Paint();
    this.a.setStyle(Style.STROKE);
    this.a.setColor(-1711276033);
    this.a.setStrokeWidth(asq.a(2.0F));
    this.a.setFlags(7);
    this.d = getResources().getDimensionPixelSize(2131296287);
  }

  void a()
  {
    float f = 0.0F;
    if (yb.v())
    {
      c();
      return;
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(WatchItemSector.getDuration());
    ((Animation)localObject).setFillAfter(true);
    localAnimationSet.addAnimation((Animation)localObject);
    if (this.b);
    while (true)
    {
      localObject = new ScaleAnimation(0.35F, 1.0F, 0.35F, 1.0F, 1, f, 1, 1.0F);
      ((ScaleAnimation)localObject).setDuration((int)(WatchItemSector.getDuration() * 0.58D));
      ((ScaleAnimation)localObject).setInterpolator(new ye());
      ((ScaleAnimation)localObject).setFillAfter(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setFillAfter(true);
      startAnimation(localAnimationSet);
      return;
      f = 1.0F;
    }
  }

  public void a(float paramFloat, int paramInt)
  {
    animate().scaleX(paramFloat).scaleY(paramFloat).setDuration(paramInt).setListener(null);
  }

  public void a(int paramInt)
  {
    animate().scaleX(1.0F).scaleY(1.0F).setDuration(paramInt).setListener(null);
  }

  void b()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Animation localAnimation = yd.d(this.b);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAnimation.setDuration(240L);
    localAlphaAnimation.setDuration(180L);
    localAnimationSet.addAnimation(localAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setFillAfter(true);
    startAnimation(localAnimationSet);
  }

  public void c()
  {
    float f = this.c.getHandTrackRatio();
    setScaleX(f);
    setScaleY(f);
    setAlpha(atw.a(f));
  }

  public void d()
  {
    setScaleX(1.0F);
    setScaleY(1.0F);
    setAlpha(1.0F);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    DrawFilter localDrawFilter = paramCanvas.getDrawFilter();
    paramCanvas.setDrawFilter(atw.a);
    if (this.b)
      paramCanvas.drawCircle(0.0F, this.d, this.d - asq.a(3.0F), this.a);
    while (true)
    {
      paramCanvas.setDrawFilter(localDrawFilter);
      return;
      paramCanvas.drawCircle(this.d, this.d, this.d - asq.a(3.0F), this.a);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.d, this.d);
    if (this.b);
    for (float f = 0.0F; ; f = getMeasuredWidth())
    {
      setPivotX(f);
      setPivotY(getMeasuredHeight());
      return;
    }
  }

  void setDirection(boolean paramBoolean)
  {
    this.b = paramBoolean;
    WatchSectorArea.a(this, paramBoolean);
    if (NewGuide.j());
    for (int i = 4; ; i = 0)
    {
      setVisibility(i);
      return;
    }
  }

  void setFan(yb paramyb)
  {
    this.c = paramyb;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.hetero.iwatch.WatchTabSectorBg
 * JD-Core Version:    0.6.2
 */