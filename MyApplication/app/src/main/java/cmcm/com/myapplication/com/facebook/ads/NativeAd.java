package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.adapters.d.a;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.b.b;
import com.facebook.ads.internal.util.k;
import com.facebook.ads.internal.util.l;
import com.facebook.ads.internal.view.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

public class NativeAd
  implements Ad
{
  private static final com.facebook.ads.internal.c a = com.facebook.ads.internal.c.a;
  private static final String b = NativeAd.class.getSimpleName();
  private static WeakHashMap<View, WeakReference<NativeAd>> c = new WeakHashMap();
  private final Context d;
  private final String e;
  private final String f = UUID.randomUUID().toString();
  private AdListener g;
  private ImpressionListener h;
  private h i;
  private volatile boolean j;
  private com.facebook.ads.internal.adapters.n k;
  private com.facebook.ads.internal.dto.d l;
  private View m;
  private List<View> n = new ArrayList();
  private OnTouchListener o;
  private com.facebook.ads.internal.adapters.d p;
  private com.facebook.ads.internal.adapters.m q;
  private NativeAd.a r;
  private NativeAd.b s;
  private o t;
  private NativeAdView.Type u;
  private boolean v;
  private boolean w;
  private boolean x;
  private long y;

  public NativeAd(Context paramContext, com.facebook.ads.internal.adapters.n paramn, com.facebook.ads.internal.dto.d paramd)
  {
    this(paramContext, null);
    this.l = paramd;
    this.j = true;
    this.k = paramn;
  }

  public NativeAd(Context paramContext, String paramString)
  {
    this.d = paramContext;
    this.e = paramString;
  }

  NativeAd(NativeAd paramNativeAd)
  {
    this(paramNativeAd.d, null);
    this.l = paramNativeAd.l;
    this.j = true;
    this.k = paramNativeAd.k;
  }

  private void a(View paramView)
  {
    this.n.add(paramView);
    paramView.setOnClickListener(this.r);
    paramView.setOnTouchListener(this.r);
  }

  private void a(List<View> paramList, View paramView)
  {
    if (((paramView instanceof com.facebook.ads.internal.view.video.a)) || ((paramView instanceof AdChoicesView)));
    while (true)
    {
      return;
      paramList.add(paramView);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i1 = 0;
        while (i1 < paramView.getChildCount())
        {
          a(paramList, paramView.getChildAt(i1));
          i1 += 1;
        }
      }
    }
  }

  private int d()
  {
    if (this.l != null)
      return this.l.e();
    if (this.k != null)
      return this.k.i();
    if ((this.i != null) && (this.i.a() != null))
      return this.i.a().f();
    return 0;
  }

  public static void downloadAndDisplayImage(NativeAd.Image paramImage, ImageView paramImageView)
  {
    if ((paramImage != null) && (paramImageView != null))
      new k(paramImageView).execute(new String[] { paramImage.getUrl() });
  }

  private int e()
  {
    if (this.l != null)
      return this.l.g();
    if (this.k != null)
      return this.k.j();
    if ((this.i != null) && (this.i.a() != null))
      return this.i.a().g();
    return 1000;
  }

  private void f()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.setOnClickListener(null);
      localView.setOnTouchListener(null);
    }
    this.n.clear();
  }

  private void g()
  {
    if ((this.k != null) && (this.k.d()))
    {
      this.s = new NativeAd.b(this, null);
      this.s.a();
      this.q = new com.facebook.ads.internal.adapters.m(this.d, new com.facebook.ads.internal.adapters.b()
      {
        public boolean a()
        {
          return true;
        }
      }
      , this.k);
    }
  }

  private int getMinViewabilityPercentage()
  {
    int i2 = 1;
    int i1;
    if (this.l != null)
      i1 = this.l.e();
    do
    {
      do
      {
        return i1;
        i1 = i2;
      }
      while (this.i == null);
      i1 = i2;
    }
    while (this.i.a() == null);
    return this.i.a().e();
  }

  private void logExternalClick(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("eil", Boolean.valueOf(true));
    localHashMap.put("eil_source", paramString);
    this.k.b(localHashMap);
  }

  private void logExternalImpression()
  {
    this.q.a();
  }

  private void registerExternalLogReceiver(final String paramString)
  {
    this.q = new com.facebook.ads.internal.adapters.m(this.d, new com.facebook.ads.internal.adapters.b()
    {
      public boolean b()
      {
        return true;
      }

      public String c()
      {
        return paramString;
      }
    }
    , this.k);
  }

  String a()
  {
    if (!isAdLoaded())
      return null;
    return this.k.v();
  }

  void a(NativeAdView.Type paramType)
  {
    this.u = paramType;
  }

  void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  String b()
  {
    if (!isAdLoaded())
      return null;
    return this.k.w();
  }

  void b(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }

  String c()
  {
    if (!isAdLoaded())
      return null;
    return this.k.x();
  }

  public void destroy()
  {
    if (this.s != null)
    {
      this.s.b();
      this.s = null;
    }
    if (this.i != null)
    {
      this.i.d();
      this.i = null;
    }
  }

  public String getAdBody()
  {
    if (!isAdLoaded())
      return null;
    return this.k.p();
  }

  public String getAdCallToAction()
  {
    if (!isAdLoaded())
      return null;
    return this.k.q();
  }

  public NativeAd.Image getAdChoicesIcon()
  {
    if (!isAdLoaded())
      return null;
    return this.k.t();
  }

  public String getAdChoicesLinkUrl()
  {
    if (!isAdLoaded())
      return null;
    return this.k.u();
  }

  public NativeAd.Image getAdCoverImage()
  {
    if (!isAdLoaded())
      return null;
    return this.k.l();
  }

  public AdExtras getAdExtras()
  {
    if (!isAdLoaded())
      return null;
    return this.k.y();
  }

  public NativeAd.Image getAdIcon()
  {
    if (!isAdLoaded())
      return null;
    return this.k.k();
  }

  public String getAdSocialContext()
  {
    if (!isAdLoaded())
      return null;
    return this.k.r();
  }

  public NativeAd.Rating getAdStarRating()
  {
    if (!isAdLoaded())
      return null;
    return this.k.s();
  }

  public String getAdSubtitle()
  {
    if (!isAdLoaded())
      return null;
    return this.k.o();
  }

  public String getAdTitle()
  {
    if (!isAdLoaded())
      return null;
    return this.k.n();
  }

  public NativeAdViewAttributes getAdViewAttributes()
  {
    if (!isAdLoaded())
      return null;
    return this.k.m();
  }

  public String getId()
  {
    if (!isAdLoaded())
      return null;
    return this.f;
  }

  public boolean isAdLoaded()
  {
    return this.k != null;
  }

  public boolean isNativeConfigEnabled()
  {
    return (isAdLoaded()) && (this.k.f());
  }

  public void loadAd()
  {
    loadAd(EnumSet.of(NativeAd.MediaCacheFlag.NONE));
  }

  public void loadAd(final EnumSet<NativeAd.MediaCacheFlag> paramEnumSet)
  {
    if (this.j)
      throw new IllegalStateException("loadAd cannot be called more than once");
    this.y = System.currentTimeMillis();
    this.j = true;
    e locale = e.j;
    this.i = new h(this.d, this.e, locale, null, a, 1, true);
    this.i.a(new com.facebook.ads.internal.a()
    {
      public void a()
      {
        if (NativeAd.b(NativeAd.this) != null)
          NativeAd.b(NativeAd.this).c();
      }

      public void a(final com.facebook.ads.internal.adapters.n paramAnonymousn)
      {
        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(b.b.a, AdPlacementType.NATIVE, System.currentTimeMillis() - NativeAd.c(NativeAd.this), null));
        if (paramAnonymousn == null)
          return;
        ArrayList localArrayList = new ArrayList(2);
        if ((paramEnumSet.contains(NativeAd.MediaCacheFlag.ICON)) && (paramAnonymousn.k() != null))
          localArrayList.add(paramAnonymousn.k().getUrl());
        if ((paramEnumSet.contains(NativeAd.MediaCacheFlag.IMAGE)) && (paramAnonymousn.l() != null))
          localArrayList.add(paramAnonymousn.l().getUrl());
        com.facebook.ads.internal.util.m.a(NativeAd.d(NativeAd.this), localArrayList, new l()
        {
          public void a()
          {
            NativeAd.a(NativeAd.this, paramAnonymousn);
            NativeAd.e(NativeAd.this);
            if (NativeAd.a(NativeAd.this) != null)
              NativeAd.a(NativeAd.this).onAdLoaded(NativeAd.this);
          }
        });
      }

      public void a(com.facebook.ads.internal.b paramAnonymousb)
      {
        if (NativeAd.a(NativeAd.this) != null)
          NativeAd.a(NativeAd.this).onError(NativeAd.this, paramAnonymousb.b());
      }

      public void b()
      {
        if (NativeAd.a(NativeAd.this) != null)
          NativeAd.a(NativeAd.this).onAdClicked(NativeAd.this);
      }

      public void c()
      {
        throw new IllegalStateException("Native ads manager their own impressions.");
      }
    });
    this.i.b();
  }

  public void registerViewForInteraction(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, paramView);
    registerViewForInteraction(paramView, localArrayList);
  }

  public void registerViewForInteraction(View paramView, List<View> paramList)
  {
    if (paramView == null)
      throw new IllegalArgumentException("Must provide a View");
    if ((paramList == null) || (paramList.size() == 0))
      throw new IllegalArgumentException("Invalid set of clickable views");
    if (!isAdLoaded())
    {
      Log.e(b, "Ad not loaded");
      return;
    }
    if (this.m != null)
    {
      Log.w(b, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
      unregisterView();
    }
    if (c.containsKey(paramView))
    {
      Log.w(b, "View already registered with a NativeAd. Auto unregistering and proceeding.");
      ((NativeAd)((WeakReference)c.get(paramView)).get()).unregisterView();
    }
    this.r = new NativeAd.a(this, null);
    this.m = paramView;
    if ((paramView instanceof ViewGroup))
    {
      this.t = new o(paramView.getContext(), new com.facebook.ads.internal.view.n()
      {
        public void a(int paramAnonymousInt)
        {
          if (NativeAd.f(NativeAd.this) != null)
            NativeAd.f(NativeAd.this).a(paramAnonymousInt);
        }
      });
      ((ViewGroup)paramView).addView(this.t);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      a((View)localIterator.next());
    this.q = new com.facebook.ads.internal.adapters.m(this.d, new NativeAd.c(this, null), this.k);
    this.q.a(paramList);
    int i1 = getMinViewabilityPercentage();
    this.p = new com.facebook.ads.internal.adapters.d(this.d, this.m, i1, new d.a()
    {
      public void a()
      {
        NativeAd.h(NativeAd.this).a(NativeAd.g(NativeAd.this));
        NativeAd.h(NativeAd.this).a(NativeAd.i(NativeAd.this));
        NativeAd.h(NativeAd.this).a(NativeAd.j(NativeAd.this));
        NativeAd.h(NativeAd.this).b(NativeAd.k(NativeAd.this));
        NativeAd.h(NativeAd.this).c(NativeAd.l(NativeAd.this));
        NativeAd.h(NativeAd.this).a();
      }
    });
    this.p.a(d());
    this.p.b(e());
    this.p.a();
    c.put(paramView, new WeakReference(this));
  }

  public void setAdListener(AdListener paramAdListener)
  {
    this.g = paramAdListener;
  }

  @Deprecated
  public void setImpressionListener(ImpressionListener paramImpressionListener)
  {
    this.h = paramImpressionListener;
  }

  public void setMediaViewAutoplay(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  public void setOnTouchListener(OnTouchListener paramOnTouchListener)
  {
    this.o = paramOnTouchListener;
  }

  public void unregisterView()
  {
    if (this.m == null)
      return;
    if ((!c.containsKey(this.m)) || (((WeakReference)c.get(this.m)).get() != this))
      throw new IllegalStateException("View not registered with this NativeAd");
    if (((this.m instanceof ViewGroup)) && (this.t != null))
    {
      ((ViewGroup)this.m).removeView(this.t);
      this.t = null;
    }
    c.remove(this.m);
    f();
    this.m = null;
    if (this.p != null)
    {
      this.p.b();
      this.p = null;
    }
    this.q = null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAd
 * JD-Core Version:    0.6.2
 */