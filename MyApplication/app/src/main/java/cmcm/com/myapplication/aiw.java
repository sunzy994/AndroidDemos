package cmcm.com.myapplication;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class aiw
  implements alj
{
  private final Bitmap a;
  private boolean b;
  private boolean c;
  private final Rect d = new Rect();
  private WeakReference<View> e;
  private boolean f;
  private float g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;

  private aiw(Resources paramResources)
  {
    this.a = atw.a(paramResources, 2130837845);
  }

  public static void a(Context paramContext)
  {
    vs.b(paramContext, "_show_tip", true);
    all.a(new aiw(paramContext.getResources()));
    SwipeService.a("", true);
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
  }

  public static void e()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (vs.c(localSwipeApplication, "_show_tip", false));
    Calendar localCalendar;
    int m;
    do
    {
      do
        return;
      while (vs.c(localSwipeApplication, "_applied", false));
      localCalendar = Calendar.getInstance();
      m = localCalendar.get(11);
    }
    while ((localCalendar.before(aiv.a())) || (localCalendar.after(aiv.b())) || (m < 18) || (m > 22));
    boolean bool = arl.f(localSwipeApplication);
    if ((!aiu.b(localSwipeApplication)) && (!bool))
    {
      a(localSwipeApplication, false);
      return;
    }
    a(localSwipeApplication);
  }

  public static void f()
  {
    all.a(null);
  }

  private void g()
  {
    if ((this.e != null) && (this.e.get() != null))
      ((View)this.e.get()).invalidate();
  }

  public void a()
  {
    if (this.b)
      return;
    this.g = 1.0F;
    this.b = true;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        aiw.a(aiw.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        aiw.a(aiw.this);
      }
    });
    localValueAnimator.start();
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (!atw.b(this.a))
      return;
    float f1 = this.a.getWidth();
    float f2 = this.a.getHeight();
    float f3 = ari.b(paramInt1 / f1, paramInt2 / f2, 1.0F);
    this.h = ((int)(f1 * f3));
    this.i = ((int)(f3 * f2));
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = ari.b(asq.a(10.0F), this.j - this.h);
  }

  public void a(Canvas paramCanvas)
  {
    if ((!this.b) || (!atw.b(this.a)))
      return;
    int m = (int)(this.g * this.h);
    int n = (int)(this.g * this.i);
    int i1 = (int)(this.g * this.l);
    if (this.f)
      this.d.set(i1, this.k - n - i1, m + i1, this.k - i1);
    while (true)
    {
      paramCanvas.drawBitmap(this.a, null, this.d, null);
      return;
      this.d.set(this.j - m - i1, this.k - n - i1, this.j - i1, this.k - i1);
    }
  }

  public void a(View paramView, boolean paramBoolean)
  {
    if (this.c)
      return;
    this.e = new WeakReference(paramView);
    this.f = paramBoolean;
    this.c = true;
  }

  public void a(boolean paramBoolean)
  {
    if (!this.b)
      return;
    this.b = false;
    f();
    g();
    atw.a(this.a);
  }

  public void b()
  {
  }

  public boolean c()
  {
    return this.b;
  }

  public void d()
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aiw
 * JD-Core Version:    0.6.2
 */