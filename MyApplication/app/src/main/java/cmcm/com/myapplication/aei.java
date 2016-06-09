package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.features.ad.AdCoverView;
import com.lazyswipe.features.leap.dice.DiceAdView;

public class aei extends abg
  implements OnClickListener
{
  private aew i;

  public aei()
  {
    this(null);
  }

  public aei(aew paramaew)
  {
    a(paramaew);
  }

  public void a(aew paramaew)
  {
    this.i = paramaew;
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c.setMaxHeight(2147483647);
    if ((this.c instanceof AdCoverView))
      ((AdCoverView)this.c).setAdCoverSizeFix(false);
    if (this.h.isClickable())
      this.h.setClickable(false);
    if (paramBoolean1)
      this.b.setVisibility(0);
    while (paramBoolean2)
    {
      this.e.setVisibility(0);
      this.e.setOnClickListener(this);
      return;
      this.b.setVisibility(8);
    }
    this.e.setVisibility(8);
    this.e.setOnClickListener(null);
  }

  protected void c(abq paramabq)
  {
    this.c.setScaleType(ScaleType.CENTER_CROP);
    if (1 == paramabq.a())
    {
      ((AdCoverView)this.c).setAdCoverSizeFix(true);
      this.c.setImageDrawable(paramabq.j());
      this.d.setImageDrawable(paramabq.k());
    }
    do
    {
      return;
      Resources localResources = SwipeApplication.c().getResources();
      FanItem.g.a(localResources, this.c, paramabq.h(), "null", 0, 0, 0, null);
      paramabq = paramabq.f();
      if (!TextUtils.isEmpty(paramabq))
      {
        if (this.d.getVisibility() != 0)
          this.d.setVisibility(0);
        FanItem.g.a(localResources, this.d, paramabq, "null", 0, 0, 0, null);
        return;
      }
    }
    while (this.d.getVisibility() != 0);
    this.d.setVisibility(8);
  }

  public void e(abq paramabq)
  {
    ((DiceAdView)this.i.getAdView().b()).a(paramabq);
  }

  public void onClick(View paramView)
  {
    if ((paramView == this.e) && (this.i != null))
      this.i.d();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aei
 * JD-Core Version:    0.6.2
 */