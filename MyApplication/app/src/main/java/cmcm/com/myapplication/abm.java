package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.holaverse.ad.google.nativead.AdListenerAdapter;
import com.holaverse.ad.google.nativead.GGNativeAdAdapter;
import com.holaverse.ad.google.nativead.GGNativeAdAdapter.AdViewElements;
import com.holaverse.ad.google.nativead.GGNativeAdAdapter.Image;
import com.holaverse.ad.google.nativead.NativeAppInstallAdAdapter;
import com.holaverse.ad.google.nativead.NativeAppInstallAdAdapter.OnAppInstallAdLoadedListenerAdapter;
import com.holaverse.ad.google.nativead.NativeContentAdAdapter;
import com.holaverse.ad.google.nativead.NativeContentAdAdapter.OnContentAdLoadedListenerAdapter;
import java.util.List;

public class abm
  implements abq
{
  private static final String c = "Swipe." + abm.class.getSimpleName();
  private static final String[] d = { "Something happened internally; for instance, an invalid response was received from the ad server.", "The ad request was invalid; for instance, the ad unit ID was incorrect.", "The ad request was unsuccessful due to network connectivity.", "The ad request was successful, but no ad was returned due to lack of ad inventory." };
  final int a;
  abr b;
  private ImageView e;
  private CharSequence f;
  private CharSequence g;
  private GGNativeAdAdapter.Image h;
  private CharSequence i;
  private GGNativeAdAdapter.Image j;
  private CharSequence k;
  private GGNativeAdAdapter.Image l;
  private CharSequence m;
  private CharSequence n;
  private float o;
  private final Context p;
  private final String q;
  private boolean r;
  private final GGNativeAdAdapter s;
  private NativeContentAdAdapter t;
  private NativeAppInstallAdAdapter u;
  private ViewGroup v;

  public abm(Context paramContext, int paramInt, String paramString, abr paramabr)
  {
    this(paramContext, paramInt, false, paramString, paramabr);
  }

  public abm(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    this.p = paramContext.getApplicationContext();
    this.a = paramInt;
    this.r = paramBoolean;
    this.q = paramString;
    this.s = abn.b(paramContext);
    if (this.s != null)
      this.s.init(paramContext, this.q);
  }

  public abm(Context paramContext, int paramInt, boolean paramBoolean, String paramString, abr paramabr)
  {
    this(paramContext, paramInt, paramBoolean, paramString);
    a(paramabr);
  }

  private ImageView a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
      return null;
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      if ((localView instanceof ImageView))
        return (ImageView)localView;
      if ((localView instanceof ViewGroup))
        return a((ViewGroup)localView);
      i1 += 1;
    }
    return null;
  }

  private void a(abg paramabg)
  {
    GGNativeAdAdapter.AdViewElements localAdViewElements = new GGNativeAdAdapter.AdViewElements();
    localAdViewElements.mBodyView = paramabg.g;
    localAdViewElements.mCallToActionView = paramabg.h;
    localAdViewElements.mHeadlineView = paramabg.f;
    localAdViewElements.mImageView = paramabg.c;
    if (this.u != null)
    {
      localAdViewElements.mAppIconView = paramabg.d;
      this.u.registerView(localAdViewElements);
    }
    while (this.t == null)
      return;
    localAdViewElements.mContentLogoView = paramabg.d;
    this.t.registerView(localAdViewElements);
  }

  public int a()
  {
    return 1;
  }

  public void a(abr paramabr)
  {
    this.b = paramabr;
  }

  public void a(View paramView)
  {
    if (paramView == null);
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag();
    }
    while ((localObject == null) || (!(localObject instanceof abg)));
    a((abg)localObject);
    label56: View localView;
    if (this.v == null)
    {
      if (this.u != null)
      {
        this.v = this.u.getAdView();
        if (this.v == null)
          break label152;
        this.e = a(this.v);
      }
    }
    else
    {
      localView = paramView.findViewById(2131755116);
      localObject = localView.getLayoutParams();
      if (localObject != null)
        break label154;
      localObject = new LayoutParams(-1, -1);
    }
    label152: label154: 
    while (true)
    {
      ((ViewGroup)paramView).removeView(localView);
      ((ViewGroup)paramView).addView(this.v, (LayoutParams)localObject);
      this.v.addView(localView, (LayoutParams)localObject);
      return;
      if (this.t == null)
        break label56;
      this.v = this.t.getAdView();
      break label56;
      break;
    }
  }

  public void a(View paramView, Runnable paramRunnable)
  {
  }

  public void a(boolean paramBoolean)
  {
    if (this.s == null)
      if (this.b != null)
        this.b.a(this, true, 4, "The ad sdk is missing or invalid.");
    do
    {
      return;
      this.t = null;
      this.u = null;
      this.r = paramBoolean;
      if (!this.r)
        break;
    }
    while (this.b == null);
    this.b.a(this, true, 5, "The ad type requested was invalid.");
    return;
    if (this.r)
      this.s.setContentAdEnable(new NativeContentAdAdapter.OnContentAdLoadedListenerAdapter()
      {
        public void onContentAdLoaded(NativeContentAdAdapter paramAnonymousNativeContentAdAdapter)
        {
          abm.a(abm.this, paramAnonymousNativeContentAdAdapter);
          abm.a(abm.this, paramAnonymousNativeContentAdAdapter.getHeadline());
          abm.b(abm.this, paramAnonymousNativeContentAdAdapter.getBody());
          List localList = paramAnonymousNativeContentAdAdapter.getImages();
          if ((localList != null) && (localList.size() > 0))
            abm.a(abm.this, (GGNativeAdAdapter.Image)localList.get(0));
          abm.b(abm.this, paramAnonymousNativeContentAdAdapter.getLogo());
          abm.c(abm.this, paramAnonymousNativeContentAdAdapter.getCallToAction());
          abm.d(abm.this, paramAnonymousNativeContentAdAdapter.getAdvertiser());
          abm.this.o();
        }
      });
    while (true)
    {
      this.s.setAdListener(new AdListenerAdapter()
      {
        public void onAdClosed()
        {
          super.onAdClosed();
        }

        public void onAdFailedToLoad(int paramAnonymousInt)
        {
          if ((paramAnonymousInt >= 0) && (paramAnonymousInt < abm.p().length));
          for (String str = abm.p()[paramAnonymousInt]; ; str = "Unknown error")
          {
            asp.b(abm.q(), "Could not fetch Google AD for placement " + abd.d[abm.this.a] + " due to error " + paramAnonymousInt + "/" + str);
            super.onAdFailedToLoad(paramAnonymousInt);
            vy.a(abm.this.a, paramAnonymousInt);
            if (abm.this.b != null)
              abm.this.b.a(abm.this, true, paramAnonymousInt, str);
            return;
          }
        }

        public void onAdLeftApplication()
        {
          super.onAdLeftApplication();
        }

        public void onAdLoaded()
        {
          super.onAdLoaded();
        }

        public void onAdOpened()
        {
          super.onAdOpened();
          if (abm.this.b != null)
            abm.this.b.a(abm.this);
        }
      });
      this.s.loadAd();
      return;
      this.s.setAppInstallAdEnable(new NativeAppInstallAdAdapter.OnAppInstallAdLoadedListenerAdapter()
      {
        public void onAppInstallAdLoaded(NativeAppInstallAdAdapter paramAnonymousNativeAppInstallAdAdapter)
        {
          abm.a(abm.this, paramAnonymousNativeAppInstallAdAdapter);
          abm.a(abm.this, paramAnonymousNativeAppInstallAdAdapter.getHeadline());
          abm.b(abm.this, paramAnonymousNativeAppInstallAdAdapter.getBody());
          List localList = paramAnonymousNativeAppInstallAdAdapter.getImages();
          if ((localList != null) && (localList.size() > 0))
            abm.a(abm.this, (GGNativeAdAdapter.Image)localList.get(0));
          abm.c(abm.this, paramAnonymousNativeAppInstallAdAdapter.getIcon());
          abm.c(abm.this, paramAnonymousNativeAppInstallAdAdapter.getCallToAction());
          abm.e(abm.this, paramAnonymousNativeAppInstallAdAdapter.getStore());
          abm.f(abm.this, paramAnonymousNativeAppInstallAdAdapter.getPrice());
          if (paramAnonymousNativeAppInstallAdAdapter.getStarRating() != null)
            abm.a(abm.this, paramAnonymousNativeAppInstallAdAdapter.getStarRating().floatValue());
          while (true)
          {
            abm.this.o();
            return;
            abm.a(abm.this, 0.0F);
          }
        }
      });
    }
  }

  public void b()
  {
    if (this.v == null)
      return;
    ViewGroup localViewGroup = (ViewGroup)this.v.getParent();
    View localView = this.v.getChildAt(0);
    if (localView != null)
    {
      this.v.removeView(localView);
      LayoutParams localLayoutParams = this.v.getLayoutParams();
      if (localLayoutParams != null)
        localView.setLayoutParams(localLayoutParams);
    }
    if (localViewGroup != null)
    {
      localViewGroup.removeView(this.v);
      if (localView != null)
        localViewGroup.addView(localView);
    }
    this.v = null;
    this.e = null;
  }

  public String c()
  {
    if (this.i != null)
      return this.i.toString();
    return null;
  }

  public String d()
  {
    if (this.f != null)
      return this.f.toString();
    return null;
  }

  public String e()
  {
    if (this.g != null)
      return this.g.toString();
    return null;
  }

  public String f()
  {
    return null;
  }

  public String g()
  {
    return null;
  }

  public String h()
  {
    return null;
  }

  public String i()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.h != null)
    {
      Uri localUri = this.h.getUri();
      localObject1 = localObject2;
      if (localUri != null)
        localObject1 = localUri.toString();
    }
    return localObject1;
  }

  public Drawable j()
  {
    if (this.h != null)
      return this.h.getDrawable();
    return null;
  }

  public Drawable k()
  {
    if (this.l != null)
      return this.l.getDrawable();
    return null;
  }

  public long l()
  {
    return 3600000L;
  }

  public void m()
  {
  }

  public ImageView n()
  {
    return this.e;
  }

  void o()
  {
    vy.a(this.a, 1, 1, "gg");
    if (this.b != null)
      this.b.a(this, false);
  }

  public String toString()
  {
    if (this.u != null)
      return "GoogleNativeAppInstallAd{headline=" + this.f + ";body=" + this.g + ";CTA=" + this.i + ";store=" + this.m + ";rating=" + this.o + ";price=" + this.n + "}";
    return "GoogleNativeContentAd{headline=" + this.f + ";body=" + this.g + ";CTA=" + this.i + ";advertiser=" + this.k + "}";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abm
 * JD-Core Version:    0.6.2
 */