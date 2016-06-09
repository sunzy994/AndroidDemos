package cmcm.com.myapplication.com.facebook.ads;

import android.view.View;
import android.view.ViewGroup;
import es;
import java.util.ArrayList;
import java.util.List;

class NativeAdScrollView$a extends es
{
  private List<NativeAd> b = new ArrayList();

  public NativeAdScrollView$a(NativeAdScrollView paramNativeAdScrollView)
  {
  }

  public void a()
  {
    this.b.clear();
    int j = Math.min(NativeAdScrollView.a(this.a), NativeAdScrollView.b(this.a).getUniqueNativeAdCount());
    int i = 0;
    while (i < j)
    {
      NativeAd localNativeAd = NativeAdScrollView.b(this.a).nextNativeAd();
      localNativeAd.a(true);
      this.b.add(localNativeAd);
      i += 1;
    }
    notifyDataSetChanged();
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramInt < this.b.size())
    {
      if (NativeAdScrollView.c(this.a) == null)
        break label48;
      ((NativeAd)this.b.get(paramInt)).unregisterView();
    }
    while (true)
    {
      paramViewGroup.removeView((View)paramObject);
      return;
      label48: NativeAdScrollView.f(this.a).destroyView((NativeAd)this.b.get(paramInt), (View)paramObject);
    }
  }

  public int getCount()
  {
    return this.b.size();
  }

  public int getItemPosition(Object paramObject)
  {
    int i = this.b.indexOf(paramObject);
    if (i >= 0)
      return i;
    return -2;
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (NativeAdScrollView.c(this.a) != null);
    for (View localView = NativeAdView.render(NativeAdScrollView.d(this.a), (NativeAd)this.b.get(paramInt), NativeAdScrollView.c(this.a), NativeAdScrollView.e(this.a)); ; localView = NativeAdScrollView.f(this.a).createView((NativeAd)this.b.get(paramInt), paramInt))
    {
      paramViewGroup.addView(localView);
      return localView;
    }
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAdScrollView.a
 * JD-Core Version:    0.6.2
 */