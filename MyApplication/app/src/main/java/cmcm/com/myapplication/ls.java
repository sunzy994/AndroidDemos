package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;

public final class ls
  implements AdListener, li
{
  private static final ll g = new lt();
  private NativeAd a;
  private ll b = g;
  private String c;
  private volatile boolean d = false;
  private Context e;
  private int f;
  private long h = 0L;

  public ls(Context paramContext, String paramString, int paramInt)
  {
    this.e = paramContext;
    this.c = paramString;
    this.f = paramInt;
    this.a = new NativeAd(paramContext, paramString);
    this.a.setAdListener(this);
  }

  public final void a()
  {
    this.a.unregisterView();
  }

  public final void a(View paramView)
  {
    this.a.registerViewForInteraction(paramView);
    nr.d(this.e, this.f);
  }

  public final void a(ll paramll)
  {
    if (paramll == null)
    {
      this.b = g;
      return;
    }
    this.b = paramll;
  }

  public final void b()
  {
    this.b = g;
    this.a.destroy();
  }

  public final String c()
  {
    return this.a.getAdCoverImage().getUrl();
  }

  public final String d()
  {
    return this.a.getAdIcon().getUrl();
  }

  public final String e()
  {
    return this.a.getAdCallToAction();
  }

  public final String f()
  {
    return this.a.getAdBody();
  }

  public final String g()
  {
    return this.a.getAdTitle();
  }

  public final float h()
  {
    NativeAd.Rating localRating = this.a.getAdStarRating();
    if (localRating != null)
      return (float)localRating.getValue();
    return 4.5F;
  }

  public final boolean i()
  {
    long l = System.currentTimeMillis() - this.h;
    return (l < 3300000L) && (l > 0L);
  }

  public final void j()
  {
    if (this.a.isAdLoaded())
      this.b.a();
    while (this.d)
      return;
    this.d = true;
    this.a.loadAd();
  }

  public final String k()
  {
    return this.c;
  }

  public final void onAdClicked(Ad paramAd)
  {
    this.b.b();
    nr.e(this.e, this.f);
  }

  public final void onAdLoaded(Ad paramAd)
  {
    this.h = System.currentTimeMillis();
    this.b.a();
  }

  public final void onError(Ad paramAd, AdError paramAdError)
  {
    this.b.a(paramAdError.getErrorCode(), paramAdError.getErrorMessage());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ls
 * JD-Core Version:    0.6.2
 */