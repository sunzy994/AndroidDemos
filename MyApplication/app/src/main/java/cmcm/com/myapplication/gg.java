package cmcm.com.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class gg extends dh
{
  public gg(ViewPager paramViewPager)
  {
  }

  private boolean b()
  {
    return (ViewPager.access$200(this.b) != null) && (ViewPager.access$200(this.b).getCount() > 1);
  }

  public void a(View paramView, hg paramhg)
  {
    super.a(paramView, paramhg);
    paramhg.a(ViewPager.class.getName());
    paramhg.a(b());
    if (this.b.canScrollHorizontally(1))
      paramhg.a(4096);
    if (this.b.canScrollHorizontally(-1))
      paramhg.a(8192);
  }

  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle))
      return true;
    switch (paramInt)
    {
    default:
      return false;
    case 4096:
      if (this.b.canScrollHorizontally(1))
      {
        this.b.setCurrentItem(ViewPager.access$300(this.b) + 1);
        return true;
      }
      return false;
    case 8192:
    }
    if (this.b.canScrollHorizontally(-1))
    {
      this.b.setCurrentItem(ViewPager.access$300(this.b) - 1);
      return true;
    }
    return false;
  }

  public void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.d(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramView = ib.a();
    paramView.a(b());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.access$200(this.b) != null))
    {
      paramView.a(ViewPager.access$200(this.b).getCount());
      paramView.b(ViewPager.access$300(this.b));
      paramView.c(ViewPager.access$300(this.b));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     gg
 * JD-Core Version:    0.6.2
 */