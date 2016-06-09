package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import com.facebook.ads.internal.adapters.n;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.i;
import com.facebook.ads.internal.i.a;
import com.facebook.ads.internal.util.l;
import com.facebook.ads.internal.util.m;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class NativeAdsManager
{
  private static final c a = c.a;
  private final Context b;
  private final String c;
  private final int d;
  private final List<NativeAd> e;
  private int f;
  private NativeAdsManager.Listener g;
  private i h;
  private boolean i;
  private boolean j;

  public NativeAdsManager(Context paramContext, String paramString, int paramInt)
  {
    this.b = paramContext;
    this.c = paramString;
    this.d = Math.max(paramInt, 0);
    this.e = new ArrayList(paramInt);
    this.f = -1;
    this.j = false;
    this.i = false;
  }

  public void disableAutoRefresh()
  {
    this.i = true;
    if (this.h != null)
      this.h.c();
  }

  public int getUniqueNativeAdCount()
  {
    return this.e.size();
  }

  public boolean isLoaded()
  {
    return this.j;
  }

  public void loadAds()
  {
    loadAds(EnumSet.of(NativeAd.MediaCacheFlag.NONE));
  }

  public void loadAds(final EnumSet<NativeAd.MediaCacheFlag> paramEnumSet)
  {
    e locale = e.j;
    int k = this.d;
    if (this.h != null)
      this.h.b();
    this.h = new i(this.b, this.c, locale, null, a, k, paramEnumSet);
    if (this.i)
      this.h.c();
    this.h.a(new i.a()
    {
      public void a(b paramAnonymousb)
      {
        if (NativeAdsManager.c(NativeAdsManager.this) != null)
          NativeAdsManager.c(NativeAdsManager.this).onAdError(paramAnonymousb.b());
      }

      public void a(final List<n> paramAnonymousList)
      {
        final int i = 0;
        final NativeAd[] arrayOfNativeAd = new NativeAd[paramAnonymousList.size()];
        while (i < paramAnonymousList.size())
        {
          n localn = (n)paramAnonymousList.get(i);
          ArrayList localArrayList = new ArrayList(2);
          if ((paramEnumSet.contains(NativeAd.MediaCacheFlag.ICON)) && (localn.k() != null))
            localArrayList.add(localn.k().getUrl());
          if ((paramEnumSet.contains(NativeAd.MediaCacheFlag.IMAGE)) && (localn.l() != null))
            localArrayList.add(localn.l().getUrl());
          m.a(NativeAdsManager.a(NativeAdsManager.this), localArrayList, new l()
          {
            public void a()
            {
              arrayOfNativeAd[i] = new NativeAd(NativeAdsManager.a(NativeAdsManager.this), (n)paramAnonymousList.get(i), null);
              Object localObject1 = this.d;
              localObject1[0] += 1;
              if (this.d[0] == paramAnonymousList.size())
              {
                NativeAdsManager.a(NativeAdsManager.this, true);
                NativeAdsManager.b(NativeAdsManager.this).clear();
                NativeAdsManager.a(NativeAdsManager.this, 0);
                localObject1 = arrayOfNativeAd;
                int j = localObject1.length;
                int i = 0;
                while (i < j)
                {
                  Object localObject2 = localObject1[i];
                  if (localObject2 != null)
                    NativeAdsManager.b(NativeAdsManager.this).add(localObject2);
                  i += 1;
                }
                if (NativeAdsManager.c(NativeAdsManager.this) != null)
                  NativeAdsManager.c(NativeAdsManager.this).onAdsLoaded();
              }
            }
          });
          i += 1;
        }
      }
    });
    this.h.a();
  }

  public NativeAd nextNativeAd()
  {
    Object localObject;
    if (this.e.size() == 0)
      localObject = null;
    int k;
    NativeAd localNativeAd;
    do
    {
      return localObject;
      k = this.f;
      this.f = (k + 1);
      localNativeAd = (NativeAd)this.e.get(k % this.e.size());
      localObject = localNativeAd;
    }
    while (k < this.e.size());
    return new NativeAd(localNativeAd);
  }

  public void setListener(NativeAdsManager.Listener paramListener)
  {
    this.g = paramListener;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAdsManager
 * JD-Core Version:    0.6.2
 */