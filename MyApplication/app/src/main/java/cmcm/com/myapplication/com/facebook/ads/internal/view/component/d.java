package cmcm.com.myapplication.com.facebook.ads.internal.view.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.i;

public class d extends LinearLayout
{
  public d(Context paramContext, NativeAd paramNativeAd, NativeAdViewAttributes paramNativeAdViewAttributes)
  {
    super(paramContext);
    Object localObject = paramContext.getResources().getDisplayMetrics();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setGravity(17);
    paramContext.setVerticalGravity(16);
    LayoutParams localLayoutParams = new LayoutParams(-1, -1);
    localLayoutParams.setMargins(Math.round(((DisplayMetrics)localObject).density * 15.0F), Math.round(((DisplayMetrics)localObject).density * 15.0F), Math.round(((DisplayMetrics)localObject).density * 15.0F), Math.round(((DisplayMetrics)localObject).density * 15.0F));
    paramContext.setLayoutParams(localLayoutParams);
    addView(paramContext);
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(paramNativeAd.getAdSubtitle());
    i.a((TextView)localObject, paramNativeAdViewAttributes);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setSingleLine(true);
    paramContext.addView((View)localObject);
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(paramNativeAd.getAdBody());
    i.b((TextView)localObject, paramNativeAdViewAttributes);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setMaxLines(2);
    paramContext.addView((View)localObject);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.component.d
 * JD-Core Version:    0.6.2
 */