package cmcm.com.myapplication.com.lazyswipe.fan;

import aao;
import afv;
import ahr;
import ahx;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import aqr;
import ari;
import asq;
import auu;
import com.lazyswipe.ui.RateView;
import xu;
import xv;
import yb;
import ym;

public class SectorArea extends xv
  implements AnimatorListener, Runnable
{
  private static final String s = "Swipe." + SectorArea.class.getSimpleName();
  private static final Interpolator t = new DecelerateInterpolator();
  private boolean A;
  private boolean B;
  public ItemSector f;
  final GestureDetector g;
  double h;
  double i;
  double j;
  float k;
  float l;
  public boolean m;
  boolean n;
  int o;
  public boolean p;
  public boolean q;
  public boolean r;
  private TabSector u;
  private TabSectorBg v;
  private ItemSectorBg w;
  private final int x;
  private boolean y;
  private boolean z;

  public SectorArea(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.x = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.g = new GestureDetector(paramContext, new ym(this), new Handler());
  }

  public static View a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent)
  {
    int i2 = (int)paramMotionEvent.getX();
    int i3 = (int)paramMotionEvent.getY();
    paramMotionEvent = new Rect();
    int i4 = paramViewGroup.getChildCount();
    int i1 = 0;
    if (i1 < i4)
    {
      View localView = paramViewGroup.getChildAt(i1);
      if (localView.getVisibility() != 0);
      do
      {
        i1 += 1;
        break;
        localView.getHitRect(paramMotionEvent);
      }
      while (!paramMotionEvent.contains(i2, i3));
      return localView;
    }
    return null;
  }

  private boolean b(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (this.c);
    for (float f1 = 0.0F; ari.a(f2, f3, f1, getHeight()) < this.d.getItemSectorOuterSize() + this.d.getCenterOffset(); f1 = getWidth())
      return true;
    return false;
  }

  private float getCurrentLayerEndAngle()
  {
    int i1;
    if (this.n)
    {
      i1 = -90;
      if (!this.c)
        break label30;
    }
    label30: for (int i2 = 1; ; i2 = -1)
    {
      return i1 * i2;
      i1 = 90;
      break;
    }
  }

  private float getCurrentLayerStartAngle()
  {
    return 0.0F;
  }

  private float getTabIndicatorEndAngle()
  {
    int i1 = (int)this.u.b(this.o);
    if (this.A)
    {
      if (this.c)
        if (this.o == 0)
          i1 += 360;
      while (true)
      {
        return i1;
        i1 -= 360;
        continue;
        if (this.o == 0)
          i1 -= 360;
        else
          i1 += 360;
      }
    }
    return i1;
  }

  private float getTabIndicatorStartAngle()
  {
    return this.u.b(this.a);
  }

  private float getTargetLayerEndAngle()
  {
    int i1 = 360;
    int i2 = 0;
    if (this.c)
    {
      if (this.n);
      for (i1 = i2; ; i1 = 360)
        return i1;
    }
    if (this.n);
    while (true)
    {
      return i1;
      i1 = 0;
    }
  }

  private float getTargetLayerStartAngle()
  {
    int i1 = 270;
    int i2 = 90;
    if (this.c)
    {
      if (this.n);
      for (i1 = i2; ; i1 = 270)
        return i1;
    }
    if (this.n);
    while (true)
    {
      return i1;
      i1 = 90;
    }
  }

  private void k()
  {
    if (!this.p);
    for (boolean bool = true; ; bool = false)
    {
      this.p = bool;
      if (!this.p)
        break;
      RateView.f();
      this.f.getCurrentFanLayer().setLayerType(aqr.b, null);
      this.f.getNextFanLayer().setLayerType(aqr.b, null);
      return;
    }
    if (this.z)
    {
      this.a = this.o;
      this.f.c();
      this.u.setTab(this.o);
      this.d.k();
      yb.a(false, null, 0, null, null);
    }
    vj.l = false;
  }

  private boolean l()
  {
    return (Math.abs(this.h) % 90.0D >= 10.0D) || (this.y);
  }

  private void m()
  {
    if (this.n);
    for (int i1 = this.a + 1; ; i1 = this.a - 1)
    {
      this.o = i1;
      if (this.o >= 0)
        break;
      this.o = (this.d.e - 1);
      this.A = true;
      return;
    }
    if (this.o >= this.d.e)
    {
      this.o = 0;
      this.A = true;
      return;
    }
    this.A = false;
  }

  public void a()
  {
    this.f.a();
    this.u.b();
  }

  public void a(int paramInt)
  {
    super.a(paramInt);
    this.u.a();
  }

  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d.k();
    int i1 = (this.d.e + paramInt2) % this.d.e;
    aao localaao = this.d.c[i1];
    FanLayer localFanLayer1;
    FanLayer localFanLayer2;
    if (paramBoolean2)
    {
      if (paramInt2 - paramInt1 > 0)
      {
        paramBoolean2 = true;
        this.n = paramBoolean2;
      }
    }
    else
    {
      this.o = i1;
      this.i = getTargetLayerStartAngle();
      this.h = getCurrentLayerStartAngle();
      localFanLayer1 = this.f.getCurrentFanLayer();
      localFanLayer2 = this.f.getNextFanLayer();
      if (localFanLayer2.getVisibility() != 0)
        localFanLayer2.setVisibility(0);
      if (localaao.equals(localFanLayer2.getTab()))
        break label248;
      paramInt2 = this.f.getHeight();
      if (!this.c)
        break label237;
      paramInt1 = 0;
      label144: localFanLayer1.setPivotX(paramInt1);
      localFanLayer2.setPivotX(paramInt1);
      localFanLayer1.setPivotY(paramInt2);
      localFanLayer2.setPivotY(paramInt2);
    }
    label237: label248: for (paramInt1 = 1; ; paramInt1 = 0)
    {
      if (paramInt1 != 0)
        localFanLayer2.a(localaao, this.d.a(localaao), this.d.getStartPosition(), false, false);
      localFanLayer1.setRotation((float)this.h);
      localFanLayer2.setRotation((float)this.i);
      a(true, paramBoolean1);
      return;
      paramBoolean2 = false;
      break;
      paramInt1 = this.f.getWidth();
      break label144;
    }
  }

  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramInt, paramBoolean1, paramBoolean2);
    aao localaao = getCurrentTab();
    auu.a("SectorArea Started popping items for tab " + localaao.a(getContext()));
    this.f.a(localaao, this.d.a(localaao), true, localaao.h(), paramBoolean1);
    auu.a("SectorArea Finished popping items");
  }

  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if ((this.p) || (!this.q))
      return true;
    float f1 = getMeasuredHeight() - 0.1F;
    float f2 = paramFloat2;
    if (paramFloat2 > f1)
      f2 = f1;
    paramFloat2 = paramFloat4;
    if (paramFloat4 > f1)
      paramFloat2 = f1;
    if (this.c)
      if ((paramFloat5 < 0.0F) && (paramFloat6 < 0.0F))
        bool1 = false;
    while (this.d.e <= 1)
    {
      return true;
      if ((paramFloat5 > 0.0F) && (paramFloat6 > 0.0F))
      {
        bool1 = true;
      }
      else
      {
        if ((!this.m) && (paramFloat5 > this.x) && (paramFloat6 < -this.x))
        {
          this.d.c(true);
          return true;
        }
        return true;
        if ((paramFloat5 > 0.0F) && (paramFloat6 < 0.0F))
        {
          bool1 = false;
        }
        else if ((paramFloat5 < 0.0F) && (paramFloat6 > 0.0F))
        {
          bool1 = true;
        }
        else
        {
          if ((!this.m) && (paramFloat5 < -this.x) && (paramFloat6 < -this.x))
          {
            this.d.c(true);
            return true;
          }
          return true;
        }
      }
    }
    int i2 = this.f.getHeight();
    int i1;
    FanLayer localFanLayer1;
    FanLayer localFanLayer2;
    if (this.c)
    {
      i1 = 0;
      localFanLayer1 = this.f.getCurrentFanLayer();
      localFanLayer2 = this.f.getNextFanLayer();
      localFanLayer1.setVisibility(0);
      localFanLayer2.setVisibility(0);
      bool2 = bool1;
      if (this.B)
      {
        if ((!this.c) || (((!this.n) || (this.h < 0.0D)) && ((this.n) || (this.h > 0.0D))))
        {
          bool2 = bool1;
          if (this.c)
            break label406;
          if ((!this.n) || (this.h > 0.0D))
          {
            bool2 = bool1;
            if (this.n)
              break label406;
            bool2 = bool1;
            if (this.h < 0.0D)
              break label406;
          }
        }
        this.m = false;
        vj.l = false;
        if (this.n)
          break label715;
      }
    }
    label406: label715: for (boolean bool2 = true; ; bool2 = false)
    {
      if (this.m)
        break label721;
      this.B = false;
      this.m = true;
      vj.l = true;
      this.n = bool2;
      this.h = getCurrentLayerStartAngle();
      this.i = getTargetLayerStartAngle();
      m();
      this.j = getTabIndicatorStartAngle();
      localFanLayer2.setVisibility(0);
      aao localaao = this.d.c[this.o];
      if (!localaao.equals(localFanLayer2.getTab()))
        localFanLayer2.a(localaao, this.d.a(localaao), this.d.getStartPosition(), false, false);
      if ((getCurrentTab().i() <= 4) && (localaao.i() > 4))
        this.f.a(true, 0);
      localFanLayer1.setPivotX(i1);
      localFanLayer2.setPivotX(i1);
      localFanLayer1.setPivotY(i2);
      localFanLayer2.setPivotY(i2);
      d = asq.a(i2, i1, f2, paramFloat1);
      d = asq.a(i2, i1, paramFloat2, paramFloat3) - d;
      this.h += d;
      this.k = paramFloat3;
      this.l = paramFloat2;
      localFanLayer1.setRotation((float)this.h);
      this.i += d;
      localFanLayer2.setRotation((float)this.i);
      this.j -= d / this.d.e;
      this.u.setIndicatorDegree((float)this.j);
      return true;
      i1 = this.f.getWidth();
      break;
    }
    label721: double d = asq.a(i2, i1, this.l, this.k);
    if (bool2 != this.n)
      if (this.B)
        break label770;
    label770: for (boolean bool1 = true; ; bool1 = false)
    {
      this.B = bool1;
      break;
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    FanLayer localFanLayer = this.f.getCurrentFanLayer();
    View localView = a(localFanLayer, paramMotionEvent);
    boolean bool1;
    if (localView != null)
      bool1 = localFanLayer.onLongClick(localView);
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (localFanLayer.f());
      bool1 = bool2;
    }
    while (!b(paramMotionEvent));
    localFanLayer.g();
    return false;
  }

  boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false);
  }

  boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.q = false;
    if ((!this.p) && ((this.m) || (paramBoolean1)))
    {
      afv.b();
      this.m = false;
      this.p = false;
      this.f.getNextFanLayer().j();
      this.f.getCurrentFanLayer().j();
      int i2 = getCurrentTab().i();
      int i3 = this.d.c[this.o].i();
      int i1;
      ValueAnimator localValueAnimator;
      if ((Math.max(i2, i3) > 4) && (Math.min(i2, i3) <= 4))
      {
        i1 = 1;
        if ((!paramBoolean1) && ((this.o == this.a) || (!l())))
          break label319;
        this.z = true;
        this.d.c[this.o].a(getContext(), this.d);
        if ((!paramBoolean1) || ((!paramBoolean1) || (paramBoolean2)))
        {
          localValueAnimator = ValueAnimator.ofFloat(new float[] { this.u.getIndicatorDegree(), getTabIndicatorEndAngle() });
          localValueAnimator.setDuration('ð');
          localValueAnimator.setInterpolator(t);
          localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              SectorArea.a(SectorArea.this).setIndicatorDegree(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
            }
          });
          localValueAnimator.start();
        }
        this.f.getCurrentFanLayer().animate().rotation(getCurrentLayerEndAngle()).setDuration('ð').setListener(null).setInterpolator(t);
        this.f.getNextFanLayer().animate().rotation(getTargetLayerEndAngle()).setDuration('ð').setListener(this).setInterpolator(t);
        if (i1 != 0)
          this.f.a(false, i3);
      }
      label319: 
      do
      {
        return true;
        i1 = 0;
        break;
        this.z = false;
        localValueAnimator = ValueAnimator.ofFloat(new float[] { this.u.getIndicatorDegree(), getTabIndicatorStartAngle() });
        localValueAnimator.setDuration('ð');
        localValueAnimator.setInterpolator(t);
        localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            SectorArea.a(SectorArea.this).setIndicatorDegree(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          }
        });
        localValueAnimator.start();
        this.f.getCurrentFanLayer().animate().rotation(getCurrentLayerStartAngle()).setDuration('ð').setListener(null).setInterpolator(t);
        this.f.getNextFanLayer().animate().rotation(getTargetLayerStartAngle()).setDuration('ð').setListener(this).setInterpolator(t);
      }
      while (i1 == 0);
      this.f.a(false, i2);
      return true;
    }
    return false;
  }

  public void b()
  {
    this.f.b();
    this.u.d();
  }

  public boolean c()
  {
    if (this.f.getCurrentFanLayer().f())
    {
      this.f.getCurrentFanLayer().a(true, true, true);
      return true;
    }
    return false;
  }

  public void d()
  {
    super.d();
    this.v.setDrawBackIcon(true);
  }

  public void e()
  {
    super.e();
    this.v.setDrawBackIcon(false);
  }

  public void f()
  {
    super.f();
    this.f.d();
    this.w.f();
    this.u.e();
    this.v.e();
  }

  public void g()
  {
    super.g();
    this.f.e();
    this.w.g();
    this.u.f();
    this.v.f();
  }

  public float getHandTrackDismissThreshold()
  {
    if (ItemSectorBg.a)
      return 0.35F;
    return 0.42F;
  }

  public xu getHiddenItemLayer()
  {
    return this.f.getNextFanLayer();
  }

  public xu getItemLayer()
  {
    return this.f.getCurrentFanLayer();
  }

  public ItemSector getItemSector()
  {
    return this.f;
  }

  public ItemSectorBg getItemSectorBg()
  {
    return this.w;
  }

  public int getOuterSize()
  {
    return this.d.getRealRadius();
  }

  public TabSector getTabSector()
  {
    return this.u;
  }

  public TabSectorBg getTabSectorBg()
  {
    return this.v;
  }

  public void i()
  {
    if ((ahx.b(getContext()) instanceof ahr))
      this.u.c();
  }

  boolean j()
  {
    boolean bool = false;
    if ((this.d.e <= 1) || (a(false)))
      bool = true;
    return bool;
  }

  public void onAnimationCancel(Animator paramAnimator)
  {
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
    k();
  }

  public void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public void onAnimationStart(Animator paramAnimator)
  {
    k();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      this.f.getNextFanLayer().setVisibility(4);
      return;
    }
    catch (Exception paramConfiguration)
    {
    }
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((ItemSector)findViewById(2131755223));
    this.u = ((TabSector)findViewById(2131755226));
    this.v = ((TabSectorBg)findViewById(2131755221));
    this.w = ((ItemSectorBg)findViewById(2131755222));
  }

  public void run()
  {
    k();
  }

  public void setDirection(boolean paramBoolean)
  {
    super.setDirection(paramBoolean);
    yb.a(this, paramBoolean);
    yb.a(this.u, paramBoolean);
    yb.a(this.f, paramBoolean);
    this.f.setDirection(paramBoolean);
    this.u.setDirection(paramBoolean);
    this.v.setDirection(paramBoolean);
    this.w.setDirection(paramBoolean);
  }

  public void setFan(yb paramyb)
  {
    super.setFan(paramyb);
    this.f.a(paramyb, this);
    this.u.a(paramyb, this);
    this.v.setFan(paramyb);
    this.w.setFan(paramyb);
  }

  public void setTab(int paramInt)
  {
    super.setTab(paramInt);
    this.u.setTab(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.SectorArea
 * JD-Core Version:    0.6.2
 */