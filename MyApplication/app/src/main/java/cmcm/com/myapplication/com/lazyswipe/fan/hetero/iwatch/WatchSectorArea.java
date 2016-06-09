package cmcm.com.myapplication.com.lazyswipe.fan.hetero.iwatch;

import aao;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import aqs;
import auu;
import com.lazyswipe.ui.RateView;
import java.util.ArrayList;
import java.util.List;
import xu;
import xv;
import yb;

public class WatchSectorArea extends xv
{
  private static final String i = "Swipe." + WatchSectorArea.class.getSimpleName();
  public WatchItemSector f;
  public WatchTabSector g;
  public WatchTabSectorBg h;

  public WatchSectorArea(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof FrameLayout.LayoutParams))
    {
      paramView = (FrameLayout.LayoutParams)paramView;
      if (!paramBoolean)
        break label30;
    }
    label30: for (int j = 83; ; j = 85)
    {
      paramView.gravity = j;
      return;
    }
  }

  public void a()
  {
    super.a();
    this.f.o();
    this.g.b();
    this.h.b();
  }

  public void a(int paramInt)
  {
    super.a(paramInt);
    this.g.a(true);
    this.h.a();
  }

  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }

  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    super.a(paramInt, paramBoolean1, paramBoolean2);
    System.currentTimeMillis();
    auu.a("WatchSectorArea Started loading items for tab " + paramInt);
    List localList = this.d.a(getCurrentTab());
    auu.a("WatchSectorArea Finished loading tab " + getCurrentTab().a(getContext()));
    Object localObject1;
    if (paramBoolean2)
    {
      localObject1 = new ArrayList(0);
      auu.a("WatchSectorArea Finished loading tab " + getPreviousTab().a(getContext()));
      if (!paramBoolean2)
        break label233;
    }
    label233: for (Object localObject2 = new ArrayList(0); ; localObject2 = this.d.a(getNextTab()))
    {
      auu.a("WatchSectorArea Finished loading tab " + getNextTab().a(getContext()));
      auu.a("WatchSectorArea Finished loading items");
      auu.a("WatchSectorArea Started popping items");
      WatchItemSector localWatchItemSector = this.f;
      paramInt = this.a;
      if (!paramBoolean1)
        bool = true;
      localWatchItemSector.a(localList, (List)localObject1, (List)localObject2, paramInt, bool, paramBoolean2);
      return;
      localObject1 = this.d.a(getPreviousTab());
      break;
    }
  }

  public void a(boolean paramBoolean)
  {
    a(this.a, true, paramBoolean);
  }

  public void b()
  {
    super.b();
    this.f.b(true);
  }

  public boolean c()
  {
    if (this.f.f())
    {
      this.f.j();
      return true;
    }
    return false;
  }

  public void f()
  {
    super.f();
    this.f.q();
    this.g.d();
    this.h.c();
  }

  public void g()
  {
    super.g();
    this.f.r();
    this.g.e();
    this.h.d();
  }

  public float getHandTrackDismissThreshold()
  {
    return 0.35F;
  }

  public xu getItemLayer()
  {
    return this.f;
  }

  public ViewGroup getItemSector()
  {
    return this.f;
  }

  public View getItemSectorBg()
  {
    return null;
  }

  public int getOuterSize()
  {
    if (this.f.getMeasuredWidth() <= 0)
      return aqs.ac();
    return this.f.getMeasuredWidth();
  }

  public ViewGroup getTabSector()
  {
    return this.g;
  }

  public View getTabSectorBg()
  {
    return this.h;
  }

  public WatchItemSector getWatchItemSector()
  {
    return this.f;
  }

  public WatchTabSector getWatchTabSector()
  {
    return this.g;
  }

  public void j()
  {
    a(this.a, true, false);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((WatchItemSector)findViewById(2131755231));
    this.g = ((WatchTabSector)findViewById(2131755226));
    this.h = ((WatchTabSectorBg)findViewById(2131755221));
  }

  public void setCurrentTab(int paramInt)
  {
    RateView.f();
    paramInt = (this.d.e + paramInt) % this.d.e;
    this.d.c[paramInt].a(getContext(), this.d);
    this.a = paramInt;
  }

  public void setDirection(boolean paramBoolean)
  {
    super.setDirection(paramBoolean);
    this.f.setDirection(paramBoolean);
    this.g.setDirection(paramBoolean);
    this.h.setDirection(paramBoolean);
  }

  public void setFan(yb paramyb)
  {
    super.setFan(paramyb);
    this.f.a(paramyb, this);
    this.g.a(paramyb, this);
    this.h.setFan(paramyb);
  }

  public void setTab(int paramInt)
  {
    super.setTab(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.hetero.iwatch.WatchSectorArea
 * JD-Core Version:    0.6.2
 */