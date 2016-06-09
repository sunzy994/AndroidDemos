package cmcm.com.myapplication.com.lazyswipe.fan.hetero.iwatch;

import aao;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import aof;
import asw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yb;
import yd;
import ye;
import yj;
import zt;

public class WatchTabSector extends FrameLayout
  implements aof
{
  public static int a;
  final List<zt> b = new ArrayList(12);
  private int c;
  private yb d;
  private WatchSectorArea e;
  private boolean f;
  private int g;

  public WatchTabSector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a = getResources().getDimensionPixelSize(2131296287);
  }

  private void a(int paramInt1, aao paramaao, int paramInt2, int paramInt3)
  {
    if ((this.b.size() > paramInt1) && (this.b.get(paramInt1) != null))
    {
      ((zt)this.b.get(paramInt1)).b(paramaao.b(), paramInt2, paramInt3, this);
      return;
    }
    paramaao = zt.a(paramaao.b(), paramInt2, paramInt3, this);
    this.b.add(paramaao);
    addView(paramaao, paramaao.a(false));
  }

  private void a(zt paramzt)
  {
    if (paramzt.a > 90.0F)
      return;
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(yd.a() * 3);
    localAnimationSet.addAnimation((Animation)localObject);
    float f1 = paramzt.b;
    float f2 = paramzt.c;
    localObject = new TranslateAnimation(0.0F, -f1, 0.0F, f2);
    ((TranslateAnimation)localObject).setDuration(yd.a() * 4);
    ((TranslateAnimation)localObject).setInterpolator(new ye(true));
    localAnimationSet.addAnimation((Animation)localObject);
    paramzt.startAnimation(localAnimationSet);
  }

  private void a(zt paramzt, final AnimationListener paramAnimationListener)
  {
    if (paramzt.a > 90.0F)
      return;
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    float f1 = paramzt.b;
    float f2 = paramzt.c;
    Object localObject = new TranslateAnimation(-f1, 0.0F, f2, 0.0F);
    ((TranslateAnimation)localObject).setDuration(WatchItemSector.getDuration());
    ((TranslateAnimation)localObject).setInterpolator(new ye());
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(WatchItemSector.getDuration());
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(new asw()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (paramAnimationListener != null)
          paramAnimationListener.onAnimationEnd(paramAnonymousAnimation);
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        if (paramAnimationListener != null)
          paramAnimationListener.onAnimationStart(paramAnonymousAnimation);
      }
    });
    paramzt.startAnimation(localAnimationSet);
  }

  public void a()
  {
    aao localaao1 = this.e.getCurrentTab();
    aao localaao2 = this.e.getPreviousTab();
    aao localaao3 = this.e.getNextTab();
    a(0, localaao1, 45, 0);
    a(1, localaao2, 75, 0);
    a(2, localaao3, 15, 0);
    a(3, localaao1, 45, 90);
    a(4, localaao2, 75, 90);
    a(5, localaao3, 15, 90);
    a(6, localaao1, 45, 180);
    a(7, localaao2, 75, 180);
    a(8, localaao3, 15, 180);
    a(9, localaao1, 45, 270);
    a(10, localaao2, 75, 270);
    a(11, localaao3, 15, 270);
    setDegree(0);
  }

  public void a(yb paramyb, WatchSectorArea paramWatchSectorArea)
  {
    this.d = paramyb;
    this.e = paramWatchSectorArea;
  }

  public void a(boolean paramBoolean)
  {
    a();
    if (yb.v())
      d();
    while (true)
    {
      return;
      if (paramBoolean)
      {
        this.g = 0;
        asw local1 = new asw()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            WatchTabSector.b(WatchTabSector.this);
            if (WatchTabSector.c(WatchTabSector.this) == 0)
              WatchTabSector.d(WatchTabSector.this).a(false);
          }

          public void onAnimationStart(Animation paramAnonymousAnimation)
          {
            WatchTabSector.a(WatchTabSector.this);
          }
        };
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
          a((zt)localIterator.next(), local1);
      }
    }
  }

  public boolean a(Canvas paramCanvas)
  {
    try
    {
      draw(paramCanvas);
      return true;
    }
    catch (Exception paramCanvas)
    {
    }
    return false;
  }

  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      a((zt)localIterator.next());
    postDelayed(new Runnable()
    {
      public void run()
      {
        try
        {
          WatchTabSector.d(WatchTabSector.this).setVisibility(4);
          label11: WatchTabSector.this.post(new Runnable()
          {
            public void run()
            {
              WatchTabSector.d(WatchTabSector.this).c(false);
            }
          });
          return;
        }
        catch (Throwable localThrowable)
        {
          break label11;
        }
      }
    }
    , yd.a() * 4);
  }

  public boolean c()
  {
    return this.f;
  }

  public void d()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((zt)localIterator.next()).a();
    requestLayout();
  }

  public void e()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((zt)localIterator.next()).b();
    if (this.d.getHandTracker().d())
      this.d.a(true);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(a, a);
  }

  public void setDegree(int paramInt)
  {
    this.c = paramInt;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((zt)localIterator.next()).a(paramInt);
    requestLayout();
  }

  public void setDirection(boolean paramBoolean)
  {
    this.f = paramBoolean;
    WatchSectorArea.a(this, paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.hetero.iwatch.WatchTabSector
 * JD-Core Version:    0.6.2
 */