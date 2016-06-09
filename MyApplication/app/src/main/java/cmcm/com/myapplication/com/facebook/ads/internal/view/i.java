package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.NativeAdViewAttributes;

public abstract class i
{
  public static LinearLayout a(Context paramContext, NativeAd paramNativeAd, NativeAdViewAttributes paramNativeAdViewAttributes)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    NativeAd.Rating localRating = paramNativeAd.getAdStarRating();
    if ((localRating != null) && (localRating.getValue() >= 3.0D))
    {
      paramContext = new RatingBar(paramContext, null, 16842877);
      paramContext.setLayoutParams(new LayoutParams(-2, -2));
      paramContext.setStepSize(0.1F);
      paramContext.setIsIndicator(true);
      paramContext.setNumStars((int)localRating.getScale());
      paramContext.setRating((float)localRating.getValue());
      localLinearLayout.addView(paramContext);
      return localLinearLayout;
    }
    paramContext = new k(paramContext);
    paramContext.setText(paramNativeAd.getAdSocialContext());
    b(paramContext, paramNativeAdViewAttributes);
    localLinearLayout.addView(paramContext);
    return localLinearLayout;
  }

  public static void a(TextView paramTextView, NativeAdViewAttributes paramNativeAdViewAttributes)
  {
    paramTextView.setTextColor(paramNativeAdViewAttributes.getTitleTextColor());
    paramTextView.setTextSize(paramNativeAdViewAttributes.getTitleTextSize());
    paramTextView.setTypeface(paramNativeAdViewAttributes.getTypeface(), 1);
  }

  public static void b(TextView paramTextView, NativeAdViewAttributes paramNativeAdViewAttributes)
  {
    paramTextView.setTextColor(paramNativeAdViewAttributes.getDescriptionTextColor());
    paramTextView.setTextSize(paramNativeAdViewAttributes.getDescriptionTextSize());
    paramTextView.setTypeface(paramNativeAdViewAttributes.getTypeface());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.i
 * JD-Core Version:    0.6.2
 */