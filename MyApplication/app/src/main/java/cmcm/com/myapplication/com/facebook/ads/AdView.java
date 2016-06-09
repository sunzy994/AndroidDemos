package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.util.g;

public class AdView extends RelativeLayout
  implements Ad
{
  private static final c a = c.a;
  private final DisplayMetrics b;
  private final AdSize c;
  private h d;
  private volatile boolean e;
  private AdListener f;
  private ImpressionListener g;
  private View h;
  private boolean i = false;

  public AdView(Context paramContext, String paramString, AdSize paramAdSize)
  {
    super(paramContext);
    if ((paramAdSize == null) || (paramAdSize == AdSize.INTERSTITIAL))
      throw new IllegalArgumentException("adSize");
    this.b = getContext().getResources().getDisplayMetrics();
    this.c = paramAdSize;
    this.d = new h(paramContext, paramString, g.a(paramAdSize), paramAdSize, a, 1, false);
    this.d.a(new com.facebook.ads.internal.a()
    {
      public void a()
      {
        if (AdView.b(AdView.this) != null)
          AdView.b(AdView.this).c();
      }

      public void a(View paramAnonymousView)
      {
        if (paramAnonymousView == null)
          throw new IllegalStateException("Cannot present null view");
        AdView.a(AdView.this, true);
        AdView.a(AdView.this, paramAnonymousView);
        AdView.this.removeAllViews();
        AdView.this.addView(AdView.c(AdView.this));
        if ((AdView.c(AdView.this) instanceof com.facebook.ads.internal.view.a))
          g.a(AdView.d(AdView.this), AdView.c(AdView.this), AdView.e(AdView.this));
        if (AdView.a(AdView.this) != null)
          AdView.a(AdView.this).onAdLoaded(AdView.this);
      }

      public void a(b paramAnonymousb)
      {
        if (AdView.a(AdView.this) != null)
          AdView.a(AdView.this).onError(AdView.this, paramAnonymousb.b());
      }

      public void b()
      {
        if (AdView.a(AdView.this) != null)
          AdView.a(AdView.this).onAdClicked(AdView.this);
      }

      public void c()
      {
        if (AdView.f(AdView.this) != null)
          AdView.f(AdView.this).onLoggingImpression(AdView.this);
        if (((AdView.a(AdView.this) instanceof ImpressionListener)) && (AdView.a(AdView.this) != AdView.f(AdView.this)))
          ((ImpressionListener)AdView.a(AdView.this)).onLoggingImpression(AdView.this);
      }
    });
  }

  public void destroy()
  {
    if (this.d != null)
    {
      this.d.d();
      this.d = null;
    }
    removeAllViews();
    this.h = null;
  }

  public void disableAutoRefresh()
  {
    if (this.d != null)
      this.d.h();
  }

  public void loadAd()
  {
    if (!this.e)
    {
      this.d.b();
      this.e = true;
    }
    while (this.d == null)
      return;
    this.d.g();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.h != null)
      g.a(this.b, this.h, this.c);
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (this.d == null);
    do
    {
      return;
      if (paramInt == 0)
      {
        this.d.f();
        return;
      }
    }
    while (paramInt != 8);
    this.d.e();
  }

  public void setAdListener(AdListener paramAdListener)
  {
    this.f = paramAdListener;
  }

  @Deprecated
  public void setImpressionListener(ImpressionListener paramImpressionListener)
  {
    this.g = paramImpressionListener;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.AdView
 * JD-Core Version:    0.6.2
 */