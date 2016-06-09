package cmcm.com.myapplication.com.lazyswipe.features.weather.detail;

import aba;
import abd;
import abg;
import abp;
import abq;
import akx;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import atq;
import atv;
import com.lazyswipe.widget.FixWidthHeightRatioImageView;
import java.io.File;
import vg;
import yb;

public class RecentWeatherView extends akx
  implements abp
{
  private abq j;
  private abq k;

  public RecentWeatherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    paramImageView.setTag(paramString);
    paramString = (atv)this.d.a(new atv(paramImageView, paramString, this.i, 1)
    {
      public String c()
      {
        try
        {
          String str1 = RecentWeatherView.this.getContext().getExternalCacheDir().getAbsolutePath();
          return str1;
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            String str2 = RecentWeatherView.this.getContext().getCacheDir().getAbsolutePath();
            return str2;
          }
          catch (Throwable localThrowable2)
          {
          }
        }
        return null;
      }
    });
    if (paramString != null)
    {
      paramString.b();
      return;
    }
    a(paramImageView, paramBoolean);
  }

  private void a(ImageView paramImageView, boolean paramBoolean)
  {
    paramImageView.setImageDrawable(getResources().getDrawable(2130837743));
    paramImageView.setScaleType(ScaleType.CENTER_INSIDE);
  }

  private void d(abq paramabq)
  {
    i();
    a(1);
    View localView = LayoutInflater.from(this.b).inflate(2130968761, this.e, false);
    ((TextView)localView.findViewById(2131755097)).setText(paramabq.d());
    ((TextView)localView.findViewById(2131755102)).setText(paramabq.e());
    Object localObject = (TextView)localView.findViewById(2131755096);
    ((TextView)localObject).setText(paramabq.c());
    ColorDrawable localColorDrawable = new ColorDrawable(-16732929);
    LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { localColorDrawable, this.b.getResources().getDrawable(2130837803) });
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localLayerDrawable);
    localStateListDrawable.addState(new int[0], localColorDrawable);
    ((TextView)localObject).setBackgroundDrawable(localStateListDrawable);
    localObject = (FixWidthHeightRatioImageView)localView.findViewById(2131755098);
    if (2147483647 == ((FixWidthHeightRatioImageView)localObject).getMaxHeight())
      ((FixWidthHeightRatioImageView)localObject).setMaxHeight((int)(vg.e * 416.0F / 796.0F));
    a((ImageView)localObject, paramabq.i(), false);
    a((ImageView)localView.findViewById(2131755119), paramabq.g(), false);
    this.j = paramabq;
    if (this.j != null);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      this.e.addView(localView);
      paramabq.a(localView);
      return;
    }
  }

  private void h()
  {
    this.g.setVisibility(0);
    this.h.setVisibility(8);
  }

  private void i()
  {
    this.g.setVisibility(8);
    this.h.setVisibility(8);
  }

  private void j()
  {
    this.g.setVisibility(8);
    this.h.setVisibility(0);
  }

  public void a(abq paramabq)
  {
    yb.e(true);
  }

  public void a(abq paramabq, boolean paramBoolean)
  {
    if (this.j != null)
    {
      d(paramabq);
      return;
    }
    this.k = paramabq;
    e();
  }

  public void a(abq paramabq, boolean paramBoolean, int paramInt, String paramString)
  {
    j();
  }

  public View b(abq paramabq)
  {
    return null;
  }

  public void c(abq paramabq)
  {
  }

  protected boolean e()
  {
    if ((this.k != null) && (this.f.getVisibility() == 0) && (getScrollY() >= this.f.getTop()))
    {
      d(this.k);
      this.k = null;
      return true;
    }
    return false;
  }

  protected void f()
  {
    if (abd.g != null)
    {
      h();
      abd.g.b(this);
    }
  }

  protected void g()
  {
    if (abd.g != null)
      abd.g.f();
  }

  public abg getAdViewHolder()
  {
    return null;
  }

  public boolean i_()
  {
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.weather.detail.RecentWeatherView
 * JD-Core Version:    0.6.2
 */