package cmcm.com.myapplication;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.lazyswipe.features.boostplus.BoostActivity;
import com.lazyswipe.features.cleaner.CleaningView;
import com.lazyswipe.features.search.SearchWebActivity;
import com.lazyswipe.ui.CleanerSettingsActivity;
import java.lang.ref.WeakReference;

public class aco extends FrameLayout
  implements OnClickListener
{
  static final int a = asq.a(51.66F);
  private static final String b = "Swipe." + CleaningView.class.getSimpleName();
  private final int c;
  private final int d;
  private Point e;
  private Paint f;
  private int g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private WeakReference<acw> k;
  private boolean l;
  private boolean m;
  private final BroadcastReceiver n;

  private void a(View paramView, int paramInt)
  {
    if (paramView == null)
      return;
    int i1 = this.e.x;
    int i2 = this.d / 2;
    int i3 = this.e.y;
    int i4 = this.d / 2;
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i5 = ((LayoutParams)localObject).leftMargin;
    int i6 = ((LayoutParams)localObject).topMargin;
    localObject = new TranslateAnimation(i1 - i2 - i5, 0.0F, i3 - i4 - i6, 0.0F);
    ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(3.0F));
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.3F, 1.0F, 0.3F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator(3.0F));
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setDuration(400L);
    localAnimationSet.setStartOffset(paramInt);
    localAnimationSet.setFillAfter(true);
    paramView.startAnimation(localAnimationSet);
  }

  private void a(View paramView, int paramInt, AnimationListener paramAnimationListener)
  {
    if (paramView == null)
      return;
    int i1 = this.e.x;
    int i2 = this.d / 2;
    int i3 = this.e.y;
    int i4 = this.d / 2;
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i5 = ((LayoutParams)localObject).leftMargin;
    int i6 = ((LayoutParams)localObject).topMargin;
    localObject = new TranslateAnimation(0.0F, i1 - i2 - i5, 0.0F, i3 - i4 - i6);
    ((TranslateAnimation)localObject).setInterpolator(new AnticipateOvershootInterpolator(2.0F));
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setDuration(400L);
    localAnimationSet.setStartOffset(paramInt);
    localAnimationSet.setAnimationListener(paramAnimationListener);
    localAnimationSet.setFillAfter(true);
    paramView.startAnimation(localAnimationSet);
  }

  private void b()
  {
    c();
    d();
    try
    {
      ((acw)this.k.get()).d_();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void c()
  {
    new ValueAnimator();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.c / 2 });
    localValueAnimator.setDuration(400L);
    localValueAnimator.setInterpolator(new OvershootInterpolator(2.0F));
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        aco.a(aco.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        aco.this.invalidate();
      }
    });
    localValueAnimator.start();
  }

  private void d()
  {
    a(this.h, 0);
    a(this.j, 40);
    a(this.i, 80);
  }

  // ERROR //
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 172	aco:l	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 172	aco:l	Z
    //   13: aload_0
    //   14: invokespecial 226	aco:f	()V
    //   17: aload_0
    //   18: invokespecial 228	aco:g	()V
    //   21: aload_0
    //   22: getfield 180	aco:k	Ljava/lang/ref/WeakReference;
    //   25: invokevirtual 186	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   28: checkcast 188	acw
    //   31: invokevirtual 231	acw:e_	()V
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 172	aco:l	Z
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 172	aco:l	Z
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 172	aco:l	Z
    //   53: aload_1
    //   54: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   13	34	40	java/lang/Throwable
    //   13	34	47	finally
  }

  private void f()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.c / 2, 0 });
    localValueAnimator.setDuration(400L);
    localValueAnimator.setInterpolator(new AnticipateOvershootInterpolator(2.0F));
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        aco.a(aco.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        aco.this.invalidate();
      }
    });
    localValueAnimator.start();
  }

  private void g()
  {
    a(this.i, 0, null);
    a(this.j, 40, null);
    a(this.h, 80, new asw()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        aco.this.post(new Runnable()
        {
          public void run()
          {
            aco.a(aco.this, false);
            aco.this.a();
          }
        });
      }
    });
  }

  private void h()
  {
    if (this.m)
      return;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("BROADCAST_ACTION_HOME_KEY");
      ci.a(getContext()).a(this.n, localIntentFilter);
      this.m = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void i()
  {
    if (!this.m)
      return;
    try
    {
      ci.a(getContext()).a(this.n);
      this.m = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  void a()
  {
    ast.a(getContext(), this);
    if (this.k.get() != null);
    try
    {
      ((acw)this.k.get()).k();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.e.x, this.e.y, this.g, this.f);
    super.dispatchDraw(paramCanvas);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      e();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
    h();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.h)
    {
      a();
      if (BoostActivity.g())
      {
        vv.a().a("小悬浮窗", "Click", "Boost");
        paramView = new Intent(getContext(), BoostActivity.class);
        paramView.addFlags(67108864);
        asq.d(getContext(), paramView);
      }
    }
    do
    {
      do
      {
        return;
        vv.a().a("小悬浮窗", "Click", "SimpleClean");
      }
      while (this.k.get() == null);
      try
      {
        ((acw)this.k.get()).f_();
        return;
      }
      catch (Throwable paramView)
      {
        return;
      }
      if (paramView == this.j)
      {
        vv.a().a("小悬浮窗", "Click", "Search");
        SearchWebActivity.a(getContext(), "", 3);
        a();
        return;
      }
      if (paramView == this.i)
      {
        vv.a().a("小悬浮窗", "Click", "Settings");
        paramView = new Intent(getContext(), CleanerSettingsActivity.class);
        paramView.addFlags(67108864);
        asq.d(getContext(), paramView);
        a();
        return;
      }
    }
    while (paramView != this);
    e();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    i();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aco
 * JD-Core Version:    0.6.2
 */