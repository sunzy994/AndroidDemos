package cmcm.com.myapplication.com.facebook.ads.internal.view.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.i;
import com.facebook.ads.internal.view.j;

public class a extends LinearLayout
{
  private j a;
  private int b;

  public a(Context paramContext, NativeAd paramNativeAd, NativeAdViewAttributes paramNativeAdViewAttributes)
  {
    super(paramContext);
    setOrientation(1);
    setVerticalGravity(16);
    this.a = new j(getContext(), 2);
    this.a.setMinTextSize(paramNativeAdViewAttributes.getTitleTextSize() - 2);
    this.a.setText(paramNativeAd.getAdTitle());
    i.a(this.a, paramNativeAdViewAttributes);
    this.a.setLayoutParams(new LayoutParams(-2, -2));
    addView(this.a);
    this.b = Math.min(paramNativeAd.getAdTitle().length(), 21);
    addView(i.a(paramContext, paramNativeAd, paramNativeAdViewAttributes));
  }

  public int getMinVisibleTitleCharacters()
  {
    return this.b;
  }

  public TextView getTitleTextView()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.component.a
 * JD-Core Version:    0.6.2
 */