package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.os.Handler;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.lazyswipe.SwipeApplication;

public class acz extends FrameLayout
{
  protected static boolean a;
  private static final String b = "Swipe." + acz.class.getSimpleName();
  private static final int c = asq.a(49.5F);
  private static final int d = asq.a(80.0F) + c;
  private static final int e = asq.a(50.0F);
  private static final int f = asq.a(10.0F);
  private static final int g = asq.a(62.0F);
  private static acz t;
  private final acw h;
  private final boolean i;
  private final Handler j;
  private final Paint k;
  private final Paint l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private ImageView r;
  private View s;
  private Runnable u = new Runnable()
  {
    public void run()
    {
      if (acz.d() == null)
        return;
      acz.a(acz.this);
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { acz.b(acz.this), acz.c(acz.this) });
      localValueAnimator.setDuration(1000L);
      localValueAnimator.setInterpolator(new AccelerateInterpolator(2.0F));
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
        {
          if (acz.d() != null)
            acz.a(acz.this, ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue());
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymous2Animator)
        {
          if (acz.d() != null)
          {
            acz.a(acz.this);
            acz.e(acz.this).postDelayed(acz.d(acz.this), 200L);
          }
        }
      });
      localValueAnimator.start();
    }
  };
  private Runnable v = new Runnable()
  {
    public void run()
    {
      if (acz.d() == null)
        return;
      acz.a(acz.this);
      acz.this.animate().alpha(0.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymous2Animator)
        {
          if (acz.d() != null)
          {
            acz.a(acz.this);
            acz.a(acz.this, acz.b(acz.this));
            acz.e(acz.this).postDelayed(acz.f(acz.this), 150L);
          }
        }
      });
    }
  };
  private Runnable w = new Runnable()
  {
    public void run()
    {
      if (acz.d() == null)
        return;
      acz.a(acz.this);
      acz.this.animate().alpha(1.0F).setDuration(100L).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymous2Animator)
        {
          if (acz.d() != null)
          {
            acz.a(acz.this);
            acz.e(acz.this).postDelayed(acz.g(acz.this), 50L);
          }
        }
      });
    }
  };

  public acz(Context paramContext, acw paramacw)
  {
    super(paramContext);
    setAlpha(0.0F);
    this.h = paramacw;
    this.i = paramacw.u();
    this.j = new Handler();
    this.k = new Paint(atw.b);
    this.k.setColor(-1);
    this.l = new Paint(atw.b);
    this.l.setStrokeWidth(f * 2);
    this.l.setStyle(Style.STROKE);
    this.l.setColor(-1);
    this.r = new ImageView(paramContext);
    this.r.setScaleType(ScaleType.CENTER_INSIDE);
    int i1 = asq.a(47.599998F);
    this.r.setImageBitmap(atw.a(paramContext.getResources(), 2130837616, c, i1));
    addView(this.r, new LayoutParams(c, i1));
    this.s = new View(paramContext);
    i1 = f * 2;
    this.s.setBackgroundDrawable(new ada(g, i1, this.h.u()));
    paramContext = this.s;
    if (this.h.u());
    while (true)
    {
      paramContext.setPivotX(f1);
      addView(this.s, new LayoutParams(g, i1));
      return;
      f1 = g;
    }
  }

  private void a(int paramInt)
  {
    this.p = paramInt;
    this.r.setX(this.p + this.q);
    float f1 = Math.abs((this.p - this.m) / (this.n - this.m));
    this.s.setScaleX(f1);
    invalidate();
  }

  public static boolean a()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (getInstance() != null);
    long l1;
    do
    {
      do
        return false;
      while (vs.a(localSwipeApplication, "mem_tip_clean_time", -1L) > 0L);
      l1 = vs.a(localSwipeApplication, "memory_tip_swipe_guide_time", -1L);
      if (l1 <= 0L)
        return true;
    }
    while (System.currentTimeMillis() - l1 > 7000L);
    return true;
  }

  private void e()
  {
    this.j.removeCallbacks(this.u);
    this.j.removeCallbacks(this.v);
    this.j.removeCallbacks(this.w);
  }

  protected static acz getInstance()
  {
    return t;
  }

  public void b()
  {
    Object localObject = this.h.getCenterPoint();
    WindowManager.LayoutParams localLayoutParams = ast.a(getContext(), false);
    localLayoutParams.gravity = 51;
    localLayoutParams.width = d;
    localLayoutParams.height = e;
    localLayoutParams.y = (((Point)localObject).y - f);
    this.o = f;
    if (this.i)
    {
      localLayoutParams.x = ((Point)localObject).x;
      this.m = f;
      this.n = (this.m + g);
      this.q = (-asq.a(2.0F));
      this.s.setX(this.m);
    }
    while (true)
    {
      this.r.setY(this.o);
      this.p = this.m;
      ast.a(getContext(), this, localLayoutParams);
      vs.b(getContext(), "memory_tip_swipe_guide_time", System.currentTimeMillis());
      localObject = this.h;
      acw.e(getContext(), false);
      localObject = this.h;
      acw.c(getContext(), false);
      return;
      localLayoutParams.x = (((Point)localObject).x - d);
      this.m = (d - f);
      this.n = (this.m - g);
      this.q = (-asq.a(5.0F));
      this.s.setX(this.n);
    }
  }

  public void c()
  {
    ast.a(getContext(), this);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.p, this.o, f, this.k);
    super.dispatchDraw(paramCanvas);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    t = this;
    setAlpha(0.0F);
    a(this.m);
    this.j.post(this.w);
    this.j.postDelayed(new Runnable()
    {
      public void run()
      {
        acz.this.c();
      }
    }
    , 7000L);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
    t = null;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(d, e);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acz
 * JD-Core Version:    0.6.2
 */