package cmcm.com.myapplication.com.facebook.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.BannerAdapter;
import com.facebook.ads.internal.adapters.BannerAdapterListener;
import com.facebook.ads.internal.adapters.InterstitialAdapter;
import com.facebook.ads.internal.adapters.InterstitialAdapterListener;
import com.facebook.ads.internal.adapters.n;
import com.facebook.ads.internal.adapters.o;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.a.a;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.r;
import java.util.HashMap;
import java.util.Map;

public class h
  implements a.a
{
  private static final String b = h.class.getSimpleName();
  protected a a;
  private final Context c;
  private final String d;
  private final com.facebook.ads.internal.server.a e;
  private final Handler f;
  private final Runnable g;
  private final Runnable h;
  private volatile boolean i;
  private boolean j;
  private volatile boolean k;
  private AdAdapter l;
  private View m;
  private com.facebook.ads.internal.dto.c n;
  private com.facebook.ads.internal.dto.e o;
  private e p;
  private c q;
  private AdSize r;
  private int s;
  private final h.c t;
  private boolean u;

  public h(Context paramContext, String paramString, e parame, AdSize paramAdSize, c paramc, int paramInt, boolean paramBoolean)
  {
    this.c = paramContext;
    this.d = paramString;
    this.p = parame;
    this.r = paramAdSize;
    this.q = paramc;
    this.s = paramInt;
    this.t = new h.c(this, null);
    this.e = new com.facebook.ads.internal.server.a();
    this.e.a(this);
    this.f = new Handler();
    this.g = new h.a(this);
    this.h = new h.b(this);
    this.j = paramBoolean;
    i();
  }

  private void a(AdAdapter paramAdAdapter)
  {
    if (paramAdAdapter != null)
      paramAdAdapter.onDestroy();
  }

  private void i()
  {
    if (this.j)
      return;
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    this.c.registerReceiver(this.t, localIntentFilter);
    this.u = true;
  }

  private void j()
  {
    if (this.u);
    try
    {
      this.c.unregisterReceiver(this.t);
      this.u = false;
      return;
    }
    catch (Exception localException)
    {
      com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(localException, "Error unregistering screen state receiever"));
    }
  }

  private void k()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException("Adapter listener must be called on the main thread.");
  }

  private AdPlacementType l()
  {
    if (this.r == null)
      return AdPlacementType.NATIVE;
    if (this.r == AdSize.INTERSTITIAL)
      return AdPlacementType.INTERSTITIAL;
    return AdPlacementType.BANNER;
  }

  private void m()
  {
    this.o = new com.facebook.ads.internal.dto.e(this.c, this.d, this.r, this.p, this.q, this.s, AdSettings.isTestMode(this.c));
    this.e.a(this.c, this.o);
  }

  private void n()
  {
    try
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          try
          {
            h.d(h.this);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void o()
  {
    Object localObject4 = this.n;
    Object localObject3 = ((com.facebook.ads.internal.dto.c)localObject4).c();
    if (localObject3 == null)
    {
      this.a.a(AdErrorType.NO_FILL.getAdErrorWrapper(""));
      p();
      return;
    }
    Object localObject1 = ((com.facebook.ads.internal.dto.a)localObject3).b;
    Object localObject2 = com.facebook.ads.internal.adapters.e.a((String)localObject1, ((com.facebook.ads.internal.dto.c)localObject4).a().a());
    if (localObject2 == null)
    {
      Log.e(b, "Adapter does not exist: " + (String)localObject1);
      n();
      return;
    }
    if (l() != ((AdAdapter)localObject2).getPlacementType())
    {
      this.a.a(AdErrorType.INTERNAL_ERROR.getAdErrorWrapper(""));
      return;
    }
    localObject1 = new HashMap();
    localObject4 = ((com.facebook.ads.internal.dto.c)localObject4).a();
    ((Map)localObject1).put("data", ((com.facebook.ads.internal.dto.a)localObject3).c);
    ((Map)localObject1).put("definition", localObject4);
    if (this.o == null)
    {
      localObject3 = AdErrorType.UNKNOWN_ERROR.getAdErrorWrapper("environment is empty");
      this.a.a((b)localObject3);
    }
    switch (2.a[localObject2.getPlacementType().ordinal()])
    {
    default:
      Log.e(b, "attempt unexpected adapter type");
      return;
    case 2:
      localObject2 = (BannerAdapter)localObject2;
      localObject3 = new Runnable()
      {
        public void run()
        {
          h.a(h.this, this.a);
          h.c(h.this);
        }
      };
      this.f.postDelayed((Runnable)localObject3, 10000L);
      ((BannerAdapter)localObject2).loadBannerAd(this.c, this.r, new BannerAdapterListener()
      {
        public void onBannerAdClicked(BannerAdapter paramAnonymousBannerAdapter)
        {
          h.e(h.this);
          h.this.a.b();
        }

        public void onBannerAdExpanded(BannerAdapter paramAnonymousBannerAdapter)
        {
          h.e(h.this);
          h.i(h.this);
        }

        public void onBannerAdLoaded(BannerAdapter paramAnonymousBannerAdapter, View paramAnonymousView)
        {
          h.e(h.this);
          h.f(h.this).removeCallbacks(this.a);
          AdAdapter localAdAdapter = h.g(h.this);
          h.b(h.this, paramAnonymousBannerAdapter);
          h.a(h.this, paramAnonymousView);
          if (!h.h(h.this))
          {
            h.this.a.a();
            return;
          }
          h.this.a.a(paramAnonymousView);
          h.a(h.this, localAdAdapter);
          h.b(h.this);
        }

        public void onBannerAdMinimized(BannerAdapter paramAnonymousBannerAdapter)
        {
          h.e(h.this);
          h.b(h.this);
        }

        public void onBannerError(BannerAdapter paramAnonymousBannerAdapter, AdError paramAnonymousAdError)
        {
          h.e(h.this);
          h.f(h.this).removeCallbacks(this.a);
          h.a(h.this, paramAnonymousBannerAdapter);
          h.c(h.this);
        }

        public void onBannerLoggingImpression(BannerAdapter paramAnonymousBannerAdapter)
        {
          h.e(h.this);
          h.this.a.c();
        }
      }
      , (Map)localObject1);
      return;
    case 1:
      localObject2 = (InterstitialAdapter)localObject2;
      localObject3 = new Runnable()
      {
        public void run()
        {
          h.a(h.this, this.a);
          h.c(h.this);
        }
      };
      this.f.postDelayed((Runnable)localObject3, 10000L);
      ((InterstitialAdapter)localObject2).loadInterstitialAd(this.c, new InterstitialAdapterListener()
      {
        public void onInterstitialAdClicked(InterstitialAdapter paramAnonymousInterstitialAdapter, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          h.e(h.this);
          h.this.a.b();
          if (!r.a(paramAnonymousString));
          for (int i = 1; ; i = 0)
          {
            if ((paramAnonymousBoolean) && (i != 0))
            {
              paramAnonymousInterstitialAdapter = new Intent("android.intent.action.VIEW");
              if (!(h.j(h.this).d instanceof Activity))
                paramAnonymousInterstitialAdapter.addFlags(268435456);
              paramAnonymousInterstitialAdapter.setData(Uri.parse(paramAnonymousString));
              h.j(h.this).d.startActivity(paramAnonymousInterstitialAdapter);
            }
            return;
          }
        }

        public void onInterstitialAdDismissed(InterstitialAdapter paramAnonymousInterstitialAdapter)
        {
          h.e(h.this);
          h.this.a.e();
        }

        public void onInterstitialAdDisplayed(InterstitialAdapter paramAnonymousInterstitialAdapter)
        {
          h.e(h.this);
          h.this.a.d();
        }

        public void onInterstitialAdLoaded(InterstitialAdapter paramAnonymousInterstitialAdapter)
        {
          h.e(h.this);
          h.f(h.this).removeCallbacks(this.a);
          h.b(h.this, paramAnonymousInterstitialAdapter);
          h.this.a.a();
          h.b(h.this);
        }

        public void onInterstitialError(InterstitialAdapter paramAnonymousInterstitialAdapter, AdError paramAnonymousAdError)
        {
          h.e(h.this);
          h.f(h.this).removeCallbacks(this.a);
          h.a(h.this, paramAnonymousInterstitialAdapter);
          h.c(h.this);
        }

        public void onInterstitialLoggingImpression(InterstitialAdapter paramAnonymousInterstitialAdapter)
        {
          h.e(h.this);
          h.this.a.c();
        }
      }
      , (Map)localObject1);
      return;
    case 3:
    }
    localObject2 = (n)localObject2;
    localObject3 = new Runnable()
    {
      public void run()
      {
        h.a(h.this, this.a);
        h.c(h.this);
      }
    };
    this.f.postDelayed((Runnable)localObject3, 10000L);
    ((n)localObject2).a(this.c, new o()
    {
      public void a(n paramAnonymousn)
      {
        h.e(h.this);
        h.f(h.this).removeCallbacks(this.a);
        h.b(h.this, paramAnonymousn);
        h.this.a.a();
      }

      public void a(n paramAnonymousn, AdError paramAnonymousAdError)
      {
        h.e(h.this);
        h.f(h.this).removeCallbacks(this.a);
        h.a(h.this, paramAnonymousn);
        h.c(h.this);
      }
    }
    , (Map)localObject1);
  }

  private void p()
  {
    if ((this.j) || (this.i))
      return;
    switch (2.a[l().ordinal()])
    {
    default:
      return;
    case 1:
      if (!g.a(this.c))
        this.f.postDelayed(this.h, 1000L);
      label74: if (this.n != null)
        break;
    case 2:
    }
    for (long l1 = 30000L; l1 > 0L; l1 = this.n.a().b())
    {
      this.f.postDelayed(this.g, l1);
      this.i = true;
      return;
      if (this.n == null);
      for (int i1 = 1; (this.m != null) && (!g.a(this.c, this.m, i1)); i1 = this.n.a().e())
      {
        this.f.postDelayed(this.h, 1000L);
        return;
      }
      break label74;
    }
  }

  private void q()
  {
    if (!this.i)
      return;
    this.f.removeCallbacks(this.g);
    this.i = false;
  }

  public com.facebook.ads.internal.dto.d a()
  {
    if (this.n == null)
      return null;
    return this.n.a();
  }

  public void a(a parama)
  {
    this.a = parama;
  }

  public void a(final b paramb)
  {
    try
    {
      this.f.post(new Runnable()
      {
        public void run()
        {
          h.this.a.a(paramb);
          if ((h.k(h.this)) || (h.l(h.this)))
            return;
          switch (paramb.a().getErrorCode())
          {
          case 1001:
          default:
            return;
          case 1000:
          case 1002:
          }
          switch (h.2.a[h.m(h.this).ordinal()])
          {
          default:
            return;
          case 2:
          }
          h.f(h.this).postDelayed(h.n(h.this), 30000L);
          h.a(h.this, true);
        }
      });
      return;
    }
    finally
    {
      paramb = finally;
    }
    throw paramb;
  }

  public void a(final com.facebook.ads.internal.server.d paramd)
  {
    try
    {
      this.f.post(new Runnable()
      {
        public void run()
        {
          com.facebook.ads.internal.dto.c localc = paramd.b();
          if ((localc == null) || (localc.a() == null))
            throw new IllegalStateException("invalid placement in response");
          h.a(h.this, localc);
          h.c(h.this);
        }
      });
      return;
    }
    finally
    {
      paramd = finally;
    }
    throw paramd;
  }

  public void b()
  {
    m();
  }

  public void c()
  {
    if (this.l == null)
      throw new IllegalStateException("no adapter ready to start");
    if (this.k)
      throw new IllegalStateException("ad already started");
    this.k = true;
    Object localObject = this.l.getPlacementType();
    switch (2.a[localObject.ordinal()])
    {
    default:
      Log.e(b, "start unexpected adapter type");
    case 1:
    case 2:
      do
      {
        return;
        ((InterstitialAdapter)this.l).show();
        return;
      }
      while (this.m == null);
      this.a.a(this.m);
      p();
      return;
    case 3:
    }
    localObject = (n)this.l;
    if (!((n)localObject).z())
      throw new IllegalStateException("ad is not ready or already displayed");
    this.a.a((n)localObject);
  }

  public void d()
  {
    j();
    if (!this.k)
      return;
    q();
    a(this.l);
    this.m = null;
    this.k = false;
  }

  public void e()
  {
    if (!this.k)
      return;
    q();
  }

  public void f()
  {
    if (!this.k)
      return;
    p();
  }

  public void g()
  {
    q();
    m();
  }

  public void h()
  {
    this.j = true;
    q();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.h
 * JD-Core Version:    0.6.2
 */