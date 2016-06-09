package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.dto.d;
import com.facebook.ads.internal.util.b.a;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.view.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class h extends BannerAdapter
{
  private static final String a = h.class.getSimpleName();
  private com.facebook.ads.internal.view.a b;
  private l c;
  private BannerAdapterListener d;
  private Map<String, Object> e;
  private j f;
  private Context g;
  private long h;
  private b.a i;

  private void a(d paramd)
  {
    this.h = 0L;
    this.i = null;
    final k localk = k.a((JSONObject)this.e.get("data"));
    if (f.a(this.g, localk))
      this.d.onBannerError(this, AdError.NO_FILL);
    do
    {
      return;
      this.b = new com.facebook.ads.internal.view.a(this.g, new a.a()
      {
        public void a()
        {
          h.c(h.this).c();
        }

        public void a(int paramAnonymousInt)
        {
          if ((paramAnonymousInt == 0) && (h.d(h.this) > 0L) && (h.e(h.this) != null))
          {
            c.a(com.facebook.ads.internal.util.b.a(h.d(h.this), h.e(h.this), localk.i()));
            h.a(h.this, 0L);
            h.a(h.this, null);
          }
        }

        public void a(String paramAnonymousString)
        {
          if (h.a(h.this) != null)
            h.a(h.this).onBannerAdClicked(h.this);
          paramAnonymousString = Uri.parse(paramAnonymousString);
          paramAnonymousString = com.facebook.ads.internal.action.b.a(h.b(h.this), paramAnonymousString);
          if (paramAnonymousString != null);
          try
          {
            h.a(h.this, paramAnonymousString.a());
            h.a(h.this, System.currentTimeMillis());
            paramAnonymousString.b();
            return;
          }
          catch (Exception paramAnonymousString)
          {
            Log.e(h.a(), "Error executing action", paramAnonymousString);
          }
        }

        public void b()
        {
          h.this.onViewableImpression();
        }
      }
      , paramd.e());
      this.b.a(paramd.f(), paramd.g());
      this.c = new l(this.g, this.b, new b()
      {
        public void d()
        {
          if (h.a(h.this) != null)
            h.a(h.this).onBannerLoggingImpression(h.this);
        }
      });
      this.c.a(localk);
      this.b.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), localk.d(), "text/html", "utf-8", null);
    }
    while (this.d == null);
    this.d.onBannerAdLoaded(this, this.b);
  }

  public void loadBannerAd(Context paramContext, AdSize paramAdSize, BannerAdapterListener paramBannerAdapterListener, Map<String, Object> paramMap)
  {
    this.g = paramContext;
    this.d = paramBannerAdapterListener;
    this.e = paramMap;
    a((d)paramMap.get("definition"));
  }

  public void onDestroy()
  {
    if (this.b != null)
    {
      com.facebook.ads.internal.util.h.a(this.b);
      this.b.destroy();
      this.b = null;
    }
    if (this.f != null)
    {
      this.f.onDestroy();
      this.f = null;
    }
  }

  public void onViewableImpression()
  {
    if (this.c != null)
      this.c.a();
    while (this.f == null)
      return;
    HashMap localHashMap = new HashMap();
    localHashMap.put("mil", Boolean.valueOf(false));
    this.f.a(localHashMap);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.h
 * JD-Core Version:    0.6.2
 */