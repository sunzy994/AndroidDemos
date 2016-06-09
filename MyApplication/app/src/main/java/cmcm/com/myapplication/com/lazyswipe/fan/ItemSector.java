package cmcm.com.myapplication.com.lazyswipe.fan;

import aao;
import ahr;
import ahx;
import android.content.Context;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import asp;
import asq;
import asw;
import java.util.List;
import yb;
import yd;
import yk;
import yl;
import yw;

public class ItemSector extends FrameLayout
{
  private static final String d = "Swipe." + ItemSector.class.getSimpleName();
  FanLayer a;
  FanLayer b;
  boolean c;
  private yb e;
  private SectorArea f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private float j;
  private float k;
  private final int l;
  private int m = 0;

  public ItemSector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.l = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }

  private void a(boolean paramBoolean)
  {
    final ItemSectorBg localItemSectorBg = (ItemSectorBg)this.e.getItemSectorBg();
    localItemSectorBg.clearAnimation();
    localItemSectorBg.setVisibility(0);
    if (paramBoolean)
      localItemSectorBg.a();
    for (this.h = false; yb.v(); this.h = true)
    {
      d();
      return;
      localItemSectorBg.a(0);
    }
    Animation localAnimation = yd.a(this.i);
    localAnimation.setAnimationListener(new asw()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        localItemSectorBg.b();
        ((TabSectorBg)ItemSector.a(ItemSector.this).getTabSectorBg()).c();
      }
    });
    this.e.getItemSectorBg().startAnimation(localAnimation);
  }

  private void f()
  {
    if ((this.h) && (this.g))
    {
      ((ItemSectorBg)this.e.getItemSectorBg()).b(240);
      this.h = false;
    }
    while ((this.h) || (this.g))
      return;
    ((ItemSectorBg)this.e.getItemSectorBg()).a(240);
    this.h = true;
  }

  void a()
  {
    this.a.a(this.e.getStartPosition());
    Animation localAnimation = yd.c(this.i);
    localAnimation.setAnimationListener(new asw()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        ((ItemSectorBg)ItemSector.a(ItemSector.this).getItemSectorBg()).c();
        ((TabSectorBg)ItemSector.a(ItemSector.this).getTabSectorBg()).d();
      }
    });
    this.e.getItemSectorBg().startAnimation(localAnimation);
  }

  void a(aao paramaao, List<yw> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int n = 4;
    label44: FanLayer localFanLayer;
    label54: yl localyl;
    if ((!paramBoolean2) && (paramList.size() <= 4))
    {
      paramBoolean2 = true;
      this.g = paramBoolean2;
      if (paramBoolean1)
      {
        if (paramBoolean3)
          break label110;
        a(this.g);
      }
      if (!paramBoolean1)
        break label128;
      localFanLayer = this.a;
      if (paramBoolean1)
        n = 0;
      localFanLayer.setVisibility(n);
      localyl = this.e.getStartPosition();
      if (paramBoolean3)
        break label137;
    }
    label128: label137: for (paramBoolean1 = true; ; paramBoolean1 = false)
    {
      localFanLayer.a(paramaao, paramList, localyl, paramBoolean1, false);
      this.f.setPopupPrepared(true);
      return;
      paramBoolean2 = false;
      break;
      label110: if (this.g != this.h)
        break label44;
      f();
      break label44;
      localFanLayer = this.b;
      break label54;
    }
  }

  void a(yb paramyb, SectorArea paramSectorArea)
  {
    this.e = paramyb;
    this.f = paramSectorArea;
    if (this.e.getTabCount() <= 1)
      this.b.setVisibility(8);
    int i2 = this.e.getTextOffset();
    int i3 = (this.e.getItemSectorInnerSize() + this.e.getTabSectorOuterSize() - this.e.getCenterOffset() + i2) / 2;
    int i1 = (this.e.getItemSectorInnerSize() + this.e.getItemSectorOuterSize()) / 2;
    int n = i1;
    if ((ahx.b(getContext()) instanceof ahr))
      n = i1 - asq.a(1.0F);
    yk.a(i3, n, i2 / 2);
    this.a.a(this.e, this.f);
    this.b.a(this.e, this.f);
    setOnClickListener(this.e);
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) && (paramInt <= 4));
    for (paramBoolean = true; ; paramBoolean = false)
    {
      if (this.g != paramBoolean)
      {
        this.g = paramBoolean;
        f();
      }
      return;
    }
  }

  void b()
  {
    clearAnimation();
    this.e.getItemSectorBg().clearAnimation();
    this.a.b(true);
    this.b.b(true);
  }

  public void c()
  {
    FanLayer localFanLayer = this.a;
    this.a = this.b;
    this.b = localFanLayer;
  }

  public void d()
  {
    this.a.p();
  }

  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    try
    {
      boolean bool = super.dispatchDragEvent(paramDragEvent);
      return bool;
    }
    catch (Throwable paramDragEvent)
    {
    }
    return false;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
    }
    return false;
  }

  public void e()
  {
    this.a.q();
  }

  public FanLayer getCurrentFanLayer()
  {
    return this.a;
  }

  public FanLayer getNextFanLayer()
  {
    return this.b;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((FanLayer)findViewById(2131755224));
    this.b = ((FanLayer)findViewById(2131755225));
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getActionMasked();
    if (this.a.f());
    float f1;
    float f2;
    do
    {
      return false;
      switch (n)
      {
      case 1:
      default:
        this.m = 0;
        return false;
      case 0:
        this.j = paramMotionEvent.getX();
        this.k = paramMotionEvent.getY();
        this.f.q = true;
        return false;
      case 2:
      }
      if (1 == this.m)
        break;
      f1 = Math.abs(paramMotionEvent.getX() - this.j);
      f2 = Math.abs(paramMotionEvent.getY() - this.k);
    }
    while ((f1 <= this.l) && (f2 <= this.l));
    this.m = 1;
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(0);
    this.f.g.onTouchEvent(paramMotionEvent);
    return true;
    return true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent == null) || (this.e.g()));
    while (true)
    {
      return true;
      if (this.m != 0);
      int n = paramMotionEvent.getAction();
      try
      {
        this.f.g.onTouchEvent(paramMotionEvent);
        if ((3 != n) && (1 != n))
          continue;
        this.m = 0;
        this.c = false;
        this.f.j();
        return true;
      }
      catch (Throwable paramMotionEvent)
      {
        while (true)
          asp.b(d, "Exception in GestureDetector.onTouchEvent: " + paramMotionEvent.getMessage());
      }
    }
  }

  void setDirection(boolean paramBoolean)
  {
    this.i = paramBoolean;
    yb.a(this.b, paramBoolean);
    yb.a(this.a, paramBoolean);
    this.a.setDirection(paramBoolean);
    this.b.setDirection(paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.ItemSector
 * JD-Core Version:    0.6.2
 */