package cmcm.com.myapplication.com.lazyswipe.features.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import asq;
import com.lazyswipe.SwipeApplication;

public class NewSwipeGuideContentView extends FrameLayout
{
  private static final int a = asq.a(200.0F);
  private ImageView b;
  private final Handler c = new Handler();
  private final Path d = new Path();
  private boolean e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private boolean u;
  private final Paint v = new Paint();
  private final Paint w = new Paint();
  private final Runnable x = new Runnable()
  {
    public void run()
    {
      NewSwipeGuideContentView.a(NewSwipeGuideContentView.this);
    }
  };

  public NewSwipeGuideContentView(Context paramContext)
  {
    super(paramContext);
  }

  public NewSwipeGuideContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setLayerType(1, null);
    this.b = new ImageView(getContext());
    this.b.setBackgroundResource(2130837616);
    paramContext = new LayoutParams(-2, -2);
    paramContext.gravity = 83;
    addView(this.b, paramContext);
    this.v.setFlags(7);
    this.v.setColor(2147483647);
    this.h = asq.a(6.0F);
    this.i = asq.a(6.0F);
    this.j = asq.a(12.0F);
    this.w.setFlags(7);
    this.w.setColor(2147483647);
    this.w.setStyle(Style.FILL);
  }

  private void a()
  {
    SwipeApplication.c();
    final int i1 = asq.a(10.0F);
    final int i2 = getHeight() - asq.a(75.0F);
    this.b.setX(i1);
    this.b.setY(i2);
    this.b.setAlpha(1.0F);
    this.e = true;
    this.f = i1;
    this.g = i2;
    i1 = (int)(a * 0.6F);
    i2 = getHeight() - i1;
    this.k = this.f;
    this.l = this.g;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.f, i1 });
    localValueAnimator.setInterpolator(new AccelerateInterpolator(2.8F));
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        NewSwipeGuideContentView.a(NewSwipeGuideContentView.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        NewSwipeGuideContentView.c(NewSwipeGuideContentView.this).setX(NewSwipeGuideContentView.b(NewSwipeGuideContentView.this));
        float f = NewSwipeGuideContentView.d(NewSwipeGuideContentView.this) * ((NewSwipeGuideContentView.b(NewSwipeGuideContentView.this) - NewSwipeGuideContentView.e(NewSwipeGuideContentView.this)) / (i1 - NewSwipeGuideContentView.e(NewSwipeGuideContentView.this)));
        NewSwipeGuideContentView.a(NewSwipeGuideContentView.this, NewSwipeGuideContentView.b(NewSwipeGuideContentView.this) - f * 0.707F);
        NewSwipeGuideContentView.b(NewSwipeGuideContentView.this, f * 0.707F + NewSwipeGuideContentView.b(NewSwipeGuideContentView.this));
        NewSwipeGuideContentView.c(NewSwipeGuideContentView.this, NewSwipeGuideContentView.e(NewSwipeGuideContentView.this) + (NewSwipeGuideContentView.f(NewSwipeGuideContentView.this) - NewSwipeGuideContentView.e(NewSwipeGuideContentView.this)) * 0.59F);
        NewSwipeGuideContentView.d(NewSwipeGuideContentView.this, NewSwipeGuideContentView.e(NewSwipeGuideContentView.this) + (NewSwipeGuideContentView.g(NewSwipeGuideContentView.this) - NewSwipeGuideContentView.e(NewSwipeGuideContentView.this)) * 0.56F);
        NewSwipeGuideContentView.this.invalidate();
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewSwipeGuideContentView.a(NewSwipeGuideContentView.this, false);
        NewSwipeGuideContentView.this.invalidate();
        NewSwipeGuideContentView.i(NewSwipeGuideContentView.this).postDelayed(NewSwipeGuideContentView.h(NewSwipeGuideContentView.this), 2000L);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        NewSwipeGuideContentView.a(NewSwipeGuideContentView.this, true);
        NewSwipeGuideContentView.this.invalidate();
      }
    });
    localValueAnimator.start();
    localValueAnimator = ValueAnimator.ofInt(new int[] { this.g, i2 });
    localValueAnimator.setInterpolator(new AccelerateInterpolator(2.8F));
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        NewSwipeGuideContentView.b(NewSwipeGuideContentView.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        NewSwipeGuideContentView.c(NewSwipeGuideContentView.this).setY(NewSwipeGuideContentView.j(NewSwipeGuideContentView.this));
        float f = NewSwipeGuideContentView.d(NewSwipeGuideContentView.this) * ((NewSwipeGuideContentView.j(NewSwipeGuideContentView.this) - NewSwipeGuideContentView.k(NewSwipeGuideContentView.this)) / (i2 - NewSwipeGuideContentView.k(NewSwipeGuideContentView.this)));
        NewSwipeGuideContentView.e(NewSwipeGuideContentView.this, NewSwipeGuideContentView.j(NewSwipeGuideContentView.this) - f * 0.707F);
        NewSwipeGuideContentView.f(NewSwipeGuideContentView.this, f * 0.707F + NewSwipeGuideContentView.j(NewSwipeGuideContentView.this));
        NewSwipeGuideContentView.g(NewSwipeGuideContentView.this, NewSwipeGuideContentView.k(NewSwipeGuideContentView.this) + (NewSwipeGuideContentView.l(NewSwipeGuideContentView.this) - NewSwipeGuideContentView.k(NewSwipeGuideContentView.this)) * 0.69F);
        NewSwipeGuideContentView.h(NewSwipeGuideContentView.this, NewSwipeGuideContentView.k(NewSwipeGuideContentView.this) + (NewSwipeGuideContentView.m(NewSwipeGuideContentView.this) - NewSwipeGuideContentView.k(NewSwipeGuideContentView.this)) * 0.66F);
      }
    });
    localValueAnimator.start();
    localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(50L);
    localValueAnimator.setStartDelay(950L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        NewSwipeGuideContentView.c(NewSwipeGuideContentView.this).setAlpha(f);
        if (f < 0.15F)
          NewSwipeGuideContentView.b(NewSwipeGuideContentView.this, false);
      }
    });
    localValueAnimator.start();
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.e)
      paramCanvas.drawCircle(this.f + this.h, this.g + this.i, this.j, this.v);
    if (this.u)
    {
      this.d.reset();
      this.d.moveTo(this.k, this.l);
      this.d.quadTo(this.o, this.p, this.m, this.n);
      this.d.lineTo(this.q, this.r);
      this.d.quadTo(this.s, this.t, this.k, this.l);
      this.d.close();
      paramCanvas.drawPath(this.d, this.w);
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.c.postDelayed(this.x, 120L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.guide.NewSwipeGuideContentView
 * JD-Core Version:    0.6.2
 */