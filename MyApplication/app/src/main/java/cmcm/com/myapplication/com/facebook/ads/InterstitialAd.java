package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.a;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.util.g;

public class InterstitialAd
  implements Ad
{
  private static final c a = c.a;
  private final Context b;
  private final String c;
  private h d;
  private boolean e;
  private boolean f;
  private InterstitialAdListener g;
  private ImpressionListener h;

  public InterstitialAd(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = paramString;
  }

  public void destroy()
  {
    if (this.d != null)
    {
      this.d.d();
      this.d = null;
    }
  }

  public boolean isAdLoaded()
  {
    return this.e;
  }

  public void loadAd()
  {
    this.e = false;
    if (this.f)
      throw new IllegalStateException("InterstitialAd cannot be loaded while being displayed. Make sure your adapter calls adapterListener.onInterstitialDismissed().");
    if (this.d != null)
    {
      this.d.d();
      this.d = null;
    }
    AdSize localAdSize = AdSize.INTERSTITIAL;
    e locale = g.a(AdSize.INTERSTITIAL);
    this.d = new h(this.b, this.c, locale, localAdSize, a, 1, true);
    this.d.a(new a()
    {
      public void a()
      {
        InterstitialAd.a(InterstitialAd.this, true);
        if (InterstitialAd.a(InterstitialAd.this) != null)
          InterstitialAd.a(InterstitialAd.this).onAdLoaded(InterstitialAd.this);
      }

      public void a(View paramAnonymousView)
      {
      }

      public void a(b paramAnonymousb)
      {
        if (InterstitialAd.a(InterstitialAd.this) != null)
          InterstitialAd.a(InterstitialAd.this).onError(InterstitialAd.this, paramAnonymousb.b());
      }

      public void b()
      {
        if (InterstitialAd.a(InterstitialAd.this) != null)
          InterstitialAd.a(InterstitialAd.this).onAdClicked(InterstitialAd.this);
      }

      public void c()
      {
        if (InterstitialAd.b(InterstitialAd.this) != null)
          InterstitialAd.b(InterstitialAd.this).onLoggingImpression(InterstitialAd.this);
        if (((InterstitialAd.a(InterstitialAd.this) instanceof ImpressionListener)) && (InterstitialAd.a(InterstitialAd.this) != InterstitialAd.b(InterstitialAd.this)))
          ((ImpressionListener)InterstitialAd.a(InterstitialAd.this)).onLoggingImpression(InterstitialAd.this);
      }

      public void d()
      {
        if (InterstitialAd.a(InterstitialAd.this) != null)
          InterstitialAd.a(InterstitialAd.this).onInterstitialDisplayed(InterstitialAd.this);
      }

      public void e()
      {
        InterstitialAd.b(InterstitialAd.this, false);
        if (InterstitialAd.c(InterstitialAd.this) != null)
        {
          InterstitialAd.c(InterstitialAd.this).d();
          InterstitialAd.a(InterstitialAd.this, null);
        }
        if (InterstitialAd.a(InterstitialAd.this) != null)
          InterstitialAd.a(InterstitialAd.this).onInterstitialDismissed(InterstitialAd.this);
      }
    });
    this.d.b();
  }

  public void setAdListener(InterstitialAdListener paramInterstitialAdListener)
  {
    this.g = paramInterstitialAdListener;
  }

  @Deprecated
  public void setImpressionListener(ImpressionListener paramImpressionListener)
  {
    this.h = paramImpressionListener;
  }

  public boolean show()
  {
    if (!this.e)
    {
      if (this.g != null)
        this.g.onError(this, AdError.INTERNAL_ERROR);
      return false;
    }
    this.d.c();
    this.f = true;
    this.e = false;
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.InterstitialAd
 * JD-Core Version:    0.6.2
 */