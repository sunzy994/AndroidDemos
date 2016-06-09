package cmcm.com.myapplication.com.lazyswipe.features.leap;

import adk;
import ado;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import asq;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.leap.card.CardFlow;
import com.lazyswipe.ui.EmptyActivity;
import vj;
import yb;

public class Curtain extends FrameLayout
{
  private static boolean m;
  private adk a;
  private View b;
  private ado c;
  private CardFlow d;
  private View e;
  private int f;
  private int g;
  private int h;
  private boolean i;
  private boolean j;
  private int k = asq.a(400.0F);
  private LayoutParams l;
  private int n = 0;
  private float o;
  private float p;
  private VelocityTracker q;
  private int r;

  public Curtain(Context paramContext)
  {
    super(paramContext);
  }

  public Curtain(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    this.g = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.f = paramAttributeSet.getScaledMinimumFlingVelocity();
    this.h = paramAttributeSet.getScaledTouchSlop();
    this.l = new LayoutParams(-1, -1);
    this.l.gravity = 49;
    this.k = paramContext.getResources().getDimensionPixelSize(2131296373);
  }

  public static Curtain a()
  {
    return (Curtain)LayoutInflater.from(SwipeApplication.c()).inflate(2130968690, null);
  }

  private void a(adk paramadk, yb paramyb)
  {
    if (!this.j)
    {
      this.j = true;
      this.a = paramadk;
      d();
      paramyb.addView(this, this.l);
    }
  }

  private void a(MotionEvent paramMotionEvent)
  {
    if (this.q == null)
      this.q = VelocityTracker.obtain();
    this.q.addMovement(paramMotionEvent);
  }

  private void i()
  {
    if (this.q != null)
    {
      this.q.recycle();
      this.q = null;
    }
  }

  public void a(int paramInt)
  {
    if (!vj.g)
      this.b.setTranslationY(-this.k + paramInt);
  }

  public void a(adk paramadk)
  {
    yb localyb = yb.getInstance();
    if (localyb == null)
      return;
    if (vj.g)
    {
      EmptyActivity.a(getContext(), 2);
      m = true;
      a(paramadk, localyb);
      this.a.a(3);
      return;
    }
    m = false;
    a(paramadk, localyb);
  }

  public void b()
  {
    if (m)
    {
      EmptyActivity.a(getContext());
      m = false;
    }
    yb localyb = yb.getInstance();
    if (localyb == null)
      return;
    localyb.removeView(this);
    e();
  }

  public boolean c()
  {
    return (m) && (this.a.getPullState() != 2);
  }

  public void d()
  {
    this.d.a();
  }

  public void e()
  {
    this.d.b();
  }

  public boolean f()
  {
    return this.i;
  }

  public void g()
  {
    if (this.r == 229)
      return;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 229 }).setDuration(300L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        Curtain.a(Curtain.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        Curtain.b(Curtain.this).setBackgroundColor(Color.argb(Curtain.a(Curtain.this), 0, 0, 0));
      }
    });
    localValueAnimator.start();
  }

  public CardFlow getCardFlow()
  {
    return this.d;
  }

  public View getLeapView()
  {
    return this.a;
  }

  public View getMainArea()
  {
    return this.b;
  }

  public void h()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 229, 0 }).setDuration(300L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        Curtain.a(Curtain.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        Curtain.b(Curtain.this).setBackgroundColor(Color.argb(Curtain.a(Curtain.this), 0, 0, 0));
      }
    });
    localValueAnimator.start();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.i = true;
    this.j = false;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.i = false;
    this.j = false;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131755349);
    this.b.setTranslationY(-this.k);
    this.c = ((ado)findViewById(2131755351));
    this.d = ((CardFlow)findViewById(2131755350));
    this.e = findViewById(2131755348);
    this.c.a(this);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    while (this.n != 0)
    {
      return true;
      this.n = 0;
      this.o = paramMotionEvent.getX();
      this.p = paramMotionEvent.getY();
      continue;
      if (this.n == 0)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = this.o;
        float f3 = paramMotionEvent.getY() - this.p;
        if ((f3 < -this.h) && (Math.abs(f3) > Math.abs(f1 - f2)))
          this.n = 1;
      }
    }
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    int i1 = (int)(paramMotionEvent.getY() - this.p);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
      do
      {
        float f3;
        do
        {
          return true;
          this.o = paramMotionEvent.getX();
          this.p = paramMotionEvent.getY();
          return true;
          if (this.n != 0)
            break;
          f1 = paramMotionEvent.getX();
          f2 = this.o;
          f3 = paramMotionEvent.getY() - this.p;
        }
        while ((f3 >= -this.h) || (Math.abs(f3) <= Math.abs(f1 - f2)));
        this.n = 1;
        return true;
      }
      while ((this.n != 1) || (i1 >= 0) || (c()));
      this.a.b(i1 + this.k);
      return true;
    case 1:
    case 3:
    }
    this.q.computeCurrentVelocity(1000, this.g);
    float f1 = this.q.getXVelocity();
    float f2 = this.q.getYVelocity();
    if (!c())
    {
      if ((Math.abs(f2) <= Math.abs(f1)) || (f2 >= -this.f))
        break label244;
      this.a.j();
    }
    while (true)
    {
      i();
      return true;
      label244: if (i1 <= 0)
        if (i1 < -this.k / 2)
          this.a.j();
        else if ((Math.abs(i1) < this.h) && (!this.a.a(this.o, this.p)))
          this.a.j();
        else
          this.a.a(4);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.Curtain
 * JD-Core Version:    0.6.2
 */