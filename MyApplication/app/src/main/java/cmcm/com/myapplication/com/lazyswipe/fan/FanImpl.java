package cmcm.com.myapplication.com.lazyswipe.fan;

import abd;
import add;
import adk;
import adv;
import aew;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import asr;
import asv;
import com.lazyswipe.features.leap.slot.SlotMachine;
import com.lazyswipe.features.locate.CityQueryView;
import com.lazyswipe.features.weather.detail.WeatherPopupView;
import com.lazyswipe.view.WebViewWithTitle;
import vg;
import xs;
import yb;
import yc;
import yj;
import za;

public class FanImpl extends yb
{
  private WebViewWithTitle s;
  private adk t;
  private SlotMachine u;
  private aew v;
  private int w;
  private int x;
  private Runnable y;

  public FanImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public aew A()
  {
    if (this.v == null)
    {
      this.v = new aew(getContext());
      this.v.a(this);
    }
    return this.v;
  }

  public void a(Context paramContext, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
    if (this.s == null)
    {
      this.s = ((WebViewWithTitle)asr.a(paramContext, 2130968764));
      this.w = getResources().getInteger(17694720);
      this.x = 300;
      this.y = new Runnable()
      {
        public void run()
        {
          FanImpl.a(FanImpl.this).setVisibility(0);
        }
      };
    }
    while (true)
    {
      addView(this.s);
      this.s.a(paramCharSequence, paramString);
      float f = paramInt1 * 1.0F / vg.e;
      this.s.setPivotX(paramInt1);
      this.s.setPivotY(paramInt2);
      this.s.setScaleX(f);
      this.s.setScaleY(f);
      this.s.setAlpha(0.4F);
      asv.a(this.s.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(this.x).setStartDelay(this.w), this.y);
      return;
      if (this.s.getParent() != null)
        ((ViewGroup)this.s.getParent()).removeView(this.s);
    }
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    if (super.a(paramString, paramBoolean))
    {
      if ((paramBoolean) && (!a(getContext())) && (this.t != null))
      {
        this.t.d();
        if (17 == a.n)
        {
          this.t.setFullScreen(true);
          this.t.a(5);
        }
      }
      return true;
    }
    return false;
  }

  public void addView(View paramView, int paramInt, LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((((paramView instanceof TutorialView)) || ((paramView instanceof xs))) && (this.t != null))
      this.t.e();
  }

  public void b(boolean paramBoolean)
  {
    if (((!v()) || (this.r.d())) && (this.t != null))
      this.t.h();
    adv.a().a(getContext());
    super.b(paramBoolean);
  }

  public View getLeapView()
  {
    return this.t;
  }

  public boolean j()
  {
    View localView = getChildAt(getChildCount() - 1);
    if (((localView instanceof CityQueryView)) || ((localView instanceof WeatherPopupView)))
      removeView(localView);
    do
    {
      return true;
      if ((this.s != null) && (this.s.getParent() != null))
      {
        this.s.animate().cancel();
        removeView(this.s);
        return true;
      }
      if ((this.u != null) && (this.u.a()))
      {
        this.u = null;
        return true;
      }
      if ((this.v != null) && (this.v.f()))
      {
        this.v = null;
        return true;
      }
    }
    while ((this.t != null) && (this.t.g()));
    return super.j();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.t != null)
      this.t.a();
    add.a(getContext());
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.t != null)
      this.t.b();
  }

  public void onDismiss()
  {
    super.onDismiss();
    if (za.c)
    {
      za.c = false;
      abd.c(getContext());
    }
    if (this.s != null)
      this.s.a();
    if (this.t != null)
      this.t.e();
  }

  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if ((((paramView instanceof TutorialView)) || ((paramView instanceof xs))) && (this.t != null))
      this.t.d();
  }

  public SlotMachine z()
  {
    if (this.u == null)
      this.u = SlotMachine.a(this);
    return this.u;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.FanImpl
 * JD-Core Version:    0.6.2
 */