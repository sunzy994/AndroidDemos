package cmcm.com.myapplication.com.lazyswipe.fan;

import ahr;
import ahs;
import ahw;
import ahx;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.lazyswipe.features.guide.NewGuide;
import yb;
import yd;
import yn;
import yp;

public class TabSectorBg extends ImageView
  implements Callback
{
  private boolean a;
  private yb b;
  private Drawable c;
  private Handler d;
  private float e;

  public TabSectorBg(Context paramContext)
  {
    super(paramContext);
  }

  public TabSectorBg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TabSectorBg(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  void a()
  {
    setVisibility(0);
    if (yb.v())
    {
      e();
      return;
    }
    startAnimation(yd.b(this.a));
  }

  public void a(float paramFloat, int paramInt)
  {
    Object localObject = yb.getInstance();
    if (localObject == null);
    do
    {
      return;
      if ((ahx.b(getContext()) instanceof ahr))
      {
        animate().scaleX(paramFloat).scaleY(paramFloat).setDuration(paramInt).setListener(null);
        return;
      }
    }
    while (!(getBackground() instanceof yn));
    setTripleFanDrawableVisible(false);
    this.e = paramFloat;
    final yn localyn = (yn)getBackground();
    final int i = ((yb)localObject).getCenterOffset();
    int j = ((yb)localObject).getTabSectorOuterSize() - i;
    localObject = ValueAnimator.ofInt(new int[] { j, (int)(j * paramFloat) });
    ((ValueAnimator)localObject).setDuration(paramInt);
    ((ValueAnimator)localObject).addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        localyn.b = i;
        this.b.width = (i + i);
        this.b.height = (i + i);
        TabSectorBg.this.setLayoutParams(this.b);
      }
    });
    ((ValueAnimator)localObject).start();
  }

  public void a(int paramInt)
  {
    Object localObject = yb.getInstance();
    if (localObject == null);
    do
    {
      return;
      if ((ahx.b(getContext()) instanceof ahr))
      {
        animate().scaleX(1.0F).scaleY(1.0F).setDuration(paramInt).setListener(null);
        return;
      }
    }
    while (!(getBackground() instanceof yn));
    final yn localyn = (yn)getBackground();
    final int i = ((yb)localObject).getCenterOffset();
    int j = ((yb)localObject).getTabSectorOuterSize() - i;
    localObject = ValueAnimator.ofInt(new int[] { (int)(j * this.e), j });
    ((ValueAnimator)localObject).setDuration(paramInt);
    ((ValueAnimator)localObject).addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        localyn.b = i;
        this.b.width = (i + i);
        this.b.height = (i + i);
        TabSectorBg.this.setLayoutParams(this.b);
      }
    });
    ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        TabSectorBg.this.setTripleFanDrawableVisible(true);
      }
    });
    ((ValueAnimator)localObject).start();
  }

  void b()
  {
    startAnimation(yd.d(this.a));
  }

  void c()
  {
    this.d.removeMessages(1);
    this.d.sendEmptyMessageDelayed(0, 200L);
  }

  void d()
  {
    this.d.removeMessages(0);
    this.d.sendEmptyMessageDelayed(1, 200L);
  }

  public void e()
  {
    float f = this.b.getHandTrackRatio();
    setScaleX(f);
    setScaleY(f);
  }

  public void f()
  {
    setScaleX(1.0F);
    setScaleY(1.0F);
    c();
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return false;
    case 0:
      if (getLayerType() != 1)
        setLayerType(1, null);
      break;
    case 1:
    }
    while (true)
    {
      return true;
      if (getLayerType() != 0)
        setLayerType(0, null);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a);
    for (float f = 0.0F; ; f = getMeasuredWidth())
    {
      setPivotX(f);
      setPivotY(getMeasuredHeight());
      return;
    }
  }

  void setDirection(boolean paramBoolean)
  {
    if (!(getLayoutParams() instanceof FrameLayout.LayoutParams))
      setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    if (paramBoolean)
    {
      i = 83;
      localLayoutParams.gravity = i;
      this.a = paramBoolean;
      this.c = ahx.b(getContext()).d(getContext(), this.b);
      setBackgroundDrawable(ahx.b(getContext()).a(getContext(), this.b, this.c));
      if (!NewGuide.j())
        break label118;
    }
    label118: for (int i = 4; ; i = 0)
    {
      setVisibility(i);
      return;
      i = 85;
      break;
    }
  }

  public void setDrawBackIcon(boolean paramBoolean)
  {
    if ((this.c instanceof yp))
      ((yp)this.c).a(paramBoolean);
    invalidate();
  }

  void setFan(yb paramyb)
  {
    this.b = paramyb;
    this.d = new Handler(this);
  }

  public void setTripleFanDrawableVisible(boolean paramBoolean)
  {
    if ((this.c instanceof yp))
      ((yp)this.c).b(paramBoolean);
    while (true)
    {
      invalidate();
      return;
      if ((this.c instanceof ahs))
        ((ahs)this.c).a(paramBoolean);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.TabSectorBg
 * JD-Core Version:    0.6.2
 */