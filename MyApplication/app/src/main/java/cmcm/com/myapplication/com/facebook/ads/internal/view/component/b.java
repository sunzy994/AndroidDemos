package cmcm.com.myapplication.com.facebook.ads.internal.view.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.i;
import com.facebook.ads.internal.view.k;

public class b extends LinearLayout
{
  private ImageView a;
  private a b;
  private TextView c;
  private LinearLayout d;

  public b(Context paramContext, NativeAd paramNativeAd, NativeAdViewAttributes paramNativeAdViewAttributes, boolean paramBoolean, int paramInt)
  {
    super(paramContext);
    Object localObject1 = paramContext.getResources().getDisplayMetrics();
    setVerticalGravity(16);
    setOrientation(1);
    paramContext = new LinearLayout(getContext());
    paramContext.setOrientation(1);
    paramContext.setGravity(16);
    Object localObject2 = new LayoutParams(-1, -1);
    ((LayoutParams)localObject2).setMargins(Math.round(15.0F * ((DisplayMetrics)localObject1).density), Math.round(15.0F * ((DisplayMetrics)localObject1).density), Math.round(15.0F * ((DisplayMetrics)localObject1).density), Math.round(15.0F * ((DisplayMetrics)localObject1).density));
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    addView(paramContext);
    this.d = new LinearLayout(getContext());
    localObject2 = new LayoutParams(-1, 0);
    this.d.setOrientation(0);
    this.d.setGravity(16);
    ((LayoutParams)localObject2).weight = 3.0F;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.addView(this.d);
    this.a = new c(getContext());
    paramInt = a(paramBoolean, paramInt);
    localObject2 = new LayoutParams(Math.round(paramInt * ((DisplayMetrics)localObject1).density), Math.round(paramInt * ((DisplayMetrics)localObject1).density));
    ((LayoutParams)localObject2).setMargins(0, 0, Math.round(15.0F * ((DisplayMetrics)localObject1).density), 0);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    NativeAd.downloadAndDisplayImage(paramNativeAd.getAdIcon(), this.a);
    this.d.addView(this.a);
    localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setLayoutParams(new LayoutParams(-1, -1));
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setGravity(16);
    this.d.addView((View)localObject2);
    this.b = new a(getContext(), paramNativeAd, paramNativeAdViewAttributes);
    Object localObject3 = new LayoutParams(-2, -1);
    ((LayoutParams)localObject3).setMargins(0, 0, Math.round(15.0F * ((DisplayMetrics)localObject1).density), 0);
    ((LayoutParams)localObject3).weight = 0.5F;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).addView(this.b);
    this.c = new TextView(getContext());
    this.c.setPadding(Math.round(6.0F * ((DisplayMetrics)localObject1).density), Math.round(6.0F * ((DisplayMetrics)localObject1).density), Math.round(6.0F * ((DisplayMetrics)localObject1).density), Math.round(6.0F * ((DisplayMetrics)localObject1).density));
    this.c.setText(paramNativeAd.getAdCallToAction());
    this.c.setTextColor(paramNativeAdViewAttributes.getButtonTextColor());
    this.c.setTextSize(14.0F);
    this.c.setTypeface(paramNativeAdViewAttributes.getTypeface(), 1);
    this.c.setMaxLines(2);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    this.c.setGravity(17);
    localObject3 = new GradientDrawable();
    ((GradientDrawable)localObject3).setColor(paramNativeAdViewAttributes.getButtonColor());
    ((GradientDrawable)localObject3).setCornerRadius(((DisplayMetrics)localObject1).density * 5.0F);
    ((GradientDrawable)localObject3).setStroke(1, paramNativeAdViewAttributes.getButtonBorderColor());
    this.c.setBackgroundDrawable((Drawable)localObject3);
    localObject1 = new LayoutParams(-2, -2);
    ((LayoutParams)localObject1).weight = 0.25F;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((LinearLayout)localObject2).addView(this.c);
    if (paramBoolean)
    {
      localObject1 = new k(getContext());
      ((k)localObject1).setText(paramNativeAd.getAdBody());
      i.b((TextView)localObject1, paramNativeAdViewAttributes);
      ((k)localObject1).setMinTextSize(paramNativeAdViewAttributes.getDescriptionTextSize() - 1);
      paramNativeAd = new LayoutParams(-1, 0);
      paramNativeAd.weight = 1.0F;
      ((k)localObject1).setLayoutParams(paramNativeAd);
      ((k)localObject1).setGravity(80);
      paramContext.addView((View)localObject1);
    }
  }

  private int a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      double d1 = 3.0D / (i + 3);
      return (int)((paramInt - 30) * d1);
    }
  }

  public TextView getCallToActionView()
  {
    return this.c;
  }

  public ImageView getIconView()
  {
    return this.a;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    TextView localTextView = this.b.getTitleTextView();
    if (localTextView.getLayout().getLineEnd(localTextView.getLineCount() - 1) < this.b.getMinVisibleTitleCharacters())
    {
      this.d.removeView(this.a);
      super.onMeasure(paramInt1, paramInt2);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.component.b
 * JD-Core Version:    0.6.2
 */