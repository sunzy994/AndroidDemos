package cmcm.com.myapplication.com.facebook.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.NativeAd.MediaCacheFlag;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.n;
import com.facebook.ads.internal.adapters.o;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.a.a;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i
  implements a.a
{
  private final Context a;
  private final String b;
  private final com.facebook.ads.internal.server.a c;
  private final e d;
  private final c e;
  private final AdSize f;
  private final int g;
  private boolean h;
  private final Handler i;
  private final Runnable j;
  private i.a k;
  private com.facebook.ads.internal.dto.c l;

  public i(Context paramContext, String paramString, e parame, AdSize paramAdSize, c paramc, int paramInt, EnumSet<NativeAd.MediaCacheFlag> paramEnumSet)
  {
    this.a = paramContext;
    this.b = paramString;
    this.d = parame;
    this.f = paramAdSize;
    this.e = paramc;
    this.g = paramInt;
    this.c = new com.facebook.ads.internal.server.a();
    this.c.a(this);
    this.h = true;
    this.i = new Handler();
    this.j = new i.b(this);
  }

  private List<n> d()
  {
    com.facebook.ads.internal.dto.c localc = this.l;
    com.facebook.ads.internal.dto.a locala = localc.c();
    final ArrayList localArrayList = new ArrayList(localc.b());
    while (locala != null)
    {
      AdAdapter localAdAdapter = com.facebook.ads.internal.adapters.e.a(locala.b, AdPlacementType.NATIVE);
      if ((localAdAdapter != null) && (localAdAdapter.getPlacementType() == AdPlacementType.NATIVE))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("data", locala.c);
        localHashMap.put("definition", localc.a());
        ((n)localAdAdapter).a(this.a, new o()
        {
          public void a(n paramAnonymousn)
          {
            localArrayList.add(paramAnonymousn);
          }

          public void a(n paramAnonymousn, AdError paramAnonymousAdError)
          {
          }
        }
        , localHashMap);
      }
      locala = localc.c();
    }
    return localArrayList;
  }

  public void a()
  {
    com.facebook.ads.internal.dto.e locale = new com.facebook.ads.internal.dto.e(this.a, this.b, this.f, this.d, this.e, this.g, AdSettings.isTestMode(this.a));
    this.c.a(this.a, locale);
  }

  public void a(b paramb)
  {
    if (this.h)
      this.i.postDelayed(this.j, 1800000L);
    if (this.k != null)
      this.k.a(paramb);
  }

  public void a(i.a parama)
  {
    this.k = parama;
  }

  public void a(com.facebook.ads.internal.server.d paramd)
  {
    paramd = paramd.b();
    if (paramd == null)
      throw new IllegalStateException("no placement in response");
    if (this.h)
    {
      long l2 = paramd.a().b();
      long l1 = l2;
      if (l2 == 0L)
        l1 = 1800000L;
      this.i.postDelayed(this.j, l1);
    }
    this.l = paramd;
    paramd = d();
    if (this.k != null)
    {
      if (paramd.isEmpty())
        this.k.a(AdErrorType.NO_FILL.getAdErrorWrapper(""));
    }
    else
      return;
    this.k.a(paramd);
  }

  public void b()
  {
  }

  public void c()
  {
    this.h = false;
    this.i.removeCallbacks(this.j);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.i
 * JD-Core Version:    0.6.2
 */