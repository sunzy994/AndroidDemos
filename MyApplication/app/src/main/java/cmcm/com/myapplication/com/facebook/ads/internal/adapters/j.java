package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.action.a;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.util.b.a;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.e;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.util.f.a;
import com.facebook.ads.internal.util.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends n
  implements f.a
{
  private static final String a = j.class.getSimpleName();
  private String A;
  private String B;
  private NativeAd.Image C;
  private String D;
  private String E;
  private j.a F;
  private AdExtras G;
  private NativeAdViewAttributes H;
  private boolean I;
  private boolean J;
  private boolean K;
  private boolean L;
  private boolean M;
  private long N = 0L;
  private b.a O = null;
  private Context b;
  private Uri c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private NativeAd.Image i;
  private NativeAd.Image j;
  private NativeAd.Rating k;
  private String l;
  private String m;
  private String n;
  private String o;
  private e p;
  private String q;
  private Collection<String> r;
  private boolean s;
  private boolean t;
  private boolean u;
  private int v;
  private int w;
  private int x;
  private int y;
  private String z;

  private boolean A()
  {
    return (this.d != null) && (this.d.length() > 0) && (this.g != null) && (this.g.length() > 0) && (this.i != null) && (this.j != null);
  }

  private void B()
  {
    if (!this.M)
    {
      new com.facebook.ads.internal.util.o().execute(new String[] { this.o });
      this.M = true;
    }
  }

  private void a(String paramString, Map<String, String> paramMap, Map<String, Object> paramMap1)
  {
    if (paramMap1.containsKey(paramString))
      paramMap.put(paramString, String.valueOf(paramMap1.get(paramString)));
  }

  private void a(Map<String, String> paramMap, Map<String, Object> paramMap1)
  {
    if (paramMap1.containsKey("mil"))
    {
      boolean bool = ((Boolean)paramMap1.get("mil")).booleanValue();
      paramMap1.remove("mil");
      if (!bool)
        return;
    }
    paramMap.put("mil", String.valueOf(true));
  }

  private void b(Map<String, String> paramMap, Map<String, Object> paramMap1)
  {
    a("nti", paramMap, paramMap1);
    a("nhs", paramMap, paramMap1);
    a("nmv", paramMap, paramMap1);
  }

  private Map<String, String> c(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap.containsKey("view"))
      localHashMap.put("view", String.valueOf(paramMap.get("view")));
    if (paramMap.containsKey("snapshot"))
      localHashMap.put("snapshot", String.valueOf(paramMap.get("snapshot")));
    return localHashMap;
  }

  public e a()
  {
    return this.p;
  }

  public void a(int paramInt)
  {
    if (!z());
    while ((paramInt != 0) || (this.N <= 0L) || (this.O == null))
      return;
    c.a(com.facebook.ads.internal.util.b.a(this.N, this.O, this.E));
    this.N = 0L;
    this.O = null;
  }

  public void a(Context paramContext, o paramo, Map<String, Object> paramMap)
  {
    a((JSONObject)paramMap.get("data"));
    if (f.a(paramContext, this))
    {
      paramo.a(this, AdError.NO_FILL);
      return;
    }
    this.b = paramContext;
    if (paramo != null)
      paramo.a(this);
    com.facebook.ads.internal.util.b.a = this.E;
  }

  public void a(final Map<String, Object> paramMap)
  {
    if (!z());
    while (this.K)
      return;
    final HashMap localHashMap = new HashMap();
    if (paramMap != null)
    {
      a(localHashMap, paramMap);
      b(localHashMap, paramMap);
    }
    new com.facebook.ads.internal.util.o(localHashMap).execute(new String[] { this.l });
    if ((e()) || (g()));
    try
    {
      paramMap = c(paramMap);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          new com.facebook.ads.internal.util.o(localHashMap, paramMap).execute(new String[] { j.a(j.this) });
        }
      }
      , this.v * 1000);
      label112: this.F.a("impression");
      this.K = true;
      return;
    }
    catch (Exception paramMap)
    {
      break label112;
    }
  }

  public void a(JSONObject paramJSONObject)
  {
    Object localObject3 = null;
    if (this.I)
      throw new IllegalStateException("Adapter already loaded data");
    if (paramJSONObject == null)
      return;
    this.c = Uri.parse(paramJSONObject.optString("fbad_command"));
    this.d = paramJSONObject.optString("title");
    this.e = paramJSONObject.optString("subtitle");
    this.f = paramJSONObject.optString("body");
    this.g = paramJSONObject.optString("call_to_action");
    this.h = paramJSONObject.optString("social_context");
    this.i = NativeAd.Image.fromJSONObject(paramJSONObject.optJSONObject("icon"));
    this.j = NativeAd.Image.fromJSONObject(paramJSONObject.optJSONObject("image"));
    this.k = NativeAd.Rating.fromJSONObject(paramJSONObject.optJSONObject("star_rating"));
    this.l = paramJSONObject.optString("impression_report_url");
    this.m = paramJSONObject.optString("native_view_report_url");
    this.n = paramJSONObject.optString("click_report_url");
    this.o = paramJSONObject.optString("used_report_url");
    this.G = new AdExtras().setIsOrganic(paramJSONObject.optBoolean("is_organic", false));
    this.s = paramJSONObject.optBoolean("manual_imp");
    this.t = paramJSONObject.optBoolean("enable_view_log");
    this.u = paramJSONObject.optBoolean("enable_snapshot_log");
    this.v = paramJSONObject.optInt("snapshot_log_delay_second", 4);
    this.w = paramJSONObject.optInt("snapshot_compress_quality", 0);
    this.x = paramJSONObject.optInt("viewability_check_initial_delay", 0);
    this.y = paramJSONObject.optInt("viewability_check_interval", 1000);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("ad_choices_icon");
    Object localObject1 = paramJSONObject.optJSONObject("native_ui_config");
    if (localObject1 == null)
      localObject1 = null;
    while (true)
    {
      this.H = ((NativeAdViewAttributes)localObject1);
      if (localJSONObject != null)
        this.C = NativeAd.Image.fromJSONObject(localJSONObject);
      this.D = paramJSONObject.optString("ad_choices_link_url");
      this.E = paramJSONObject.optString("request_id");
      this.p = e.a(paramJSONObject.optString("invalidation_behavior"));
      this.q = paramJSONObject.optString("invalidation_report_url");
      try
      {
        localObject1 = new JSONArray(paramJSONObject.optString("detection_strings"));
        this.r = f.a((JSONArray)localObject1);
        this.F = new j.a(paramJSONObject.optJSONArray("trackers"));
        this.z = paramJSONObject.optString("video_url");
        this.A = paramJSONObject.optString("video_play_report_url");
        this.B = paramJSONObject.optString("video_time_report_url");
        this.I = true;
        this.J = A();
        return;
        localObject1 = new NativeAdViewAttributes((JSONObject)localObject1);
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          Object localObject2 = localObject3;
        }
      }
    }
  }

  public String b()
  {
    return this.q;
  }

  public void b(Map<String, Object> paramMap)
  {
    if (!z());
    do
    {
      return;
      if (!this.L)
      {
        HashMap localHashMap = new HashMap();
        if (paramMap != null)
        {
          a(localHashMap, paramMap);
          b(localHashMap, paramMap);
          localHashMap.put("touch", g.a(paramMap));
        }
        new com.facebook.ads.internal.util.o(localHashMap).execute(new String[] { this.n });
        this.F.a("click");
        this.L = true;
        g.a(this.b, "Click logged");
      }
      paramMap = com.facebook.ads.internal.action.b.a(this.b, this.c);
    }
    while (paramMap == null);
    try
    {
      this.N = System.currentTimeMillis();
      this.O = paramMap.a();
      paramMap.b();
      return;
    }
    catch (Exception paramMap)
    {
      Log.e(a, "Error executing action", paramMap);
    }
  }

  public Collection<String> c()
  {
    return this.r;
  }

  public boolean d()
  {
    return (z()) && (this.s);
  }

  public boolean e()
  {
    return (z()) && (this.t);
  }

  public boolean f()
  {
    return (z()) && (this.H != null);
  }

  public boolean g()
  {
    return (z()) && (this.u);
  }

  public int h()
  {
    if ((this.w < 0) || (this.w > 100))
      return 0;
    return this.w;
  }

  public int i()
  {
    return this.x;
  }

  public int j()
  {
    return this.y;
  }

  public NativeAd.Image k()
  {
    if (!z())
      return null;
    return this.i;
  }

  public NativeAd.Image l()
  {
    if (!z())
      return null;
    return this.j;
  }

  public NativeAdViewAttributes m()
  {
    if (!z())
      return null;
    return this.H;
  }

  public String n()
  {
    if (!z())
      return null;
    B();
    return this.d;
  }

  public String o()
  {
    if (!z())
      return null;
    B();
    return this.e;
  }

  public void onDestroy()
  {
  }

  public String p()
  {
    if (!z())
      return null;
    B();
    return this.f;
  }

  public String q()
  {
    if (!z())
      return null;
    B();
    return this.g;
  }

  public String r()
  {
    if (!z())
      return null;
    B();
    return this.h;
  }

  public NativeAd.Rating s()
  {
    if (!z())
      return null;
    B();
    return this.k;
  }

  public NativeAd.Image t()
  {
    if (!z())
      return null;
    return this.C;
  }

  public String u()
  {
    if (!z())
      return null;
    return this.D;
  }

  public String v()
  {
    if (!z())
      return null;
    return this.z;
  }

  public String w()
  {
    if (!z())
      return null;
    return this.A;
  }

  public String x()
  {
    if (!z())
      return null;
    return this.B;
  }

  public AdExtras y()
  {
    if (!z())
      return null;
    return this.G;
  }

  public boolean z()
  {
    return (this.I) && (this.J);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.j
 * JD-Core Version:    0.6.2
 */