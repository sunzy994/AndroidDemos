package cmcm.com.myapplication.com.facebook.ads.internal.dto;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.d;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.AdInternalSettings;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class e
{
  protected String a;
  protected AdPlacementType b;
  protected b c;
  public Context d;
  public com.facebook.ads.internal.e e;
  public boolean f;
  private com.facebook.ads.internal.c g;
  private int h;
  private AdSize i;

  public e(Context paramContext, String paramString, AdSize paramAdSize, com.facebook.ads.internal.e parame, com.facebook.ads.internal.c paramc, int paramInt, boolean paramBoolean)
  {
    this.a = paramString;
    this.i = paramAdSize;
    this.e = parame;
    this.c = b.a(parame);
    this.g = paramc;
    this.h = paramInt;
    this.f = paramBoolean;
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.d = paramContext;
    f.a(paramContext);
    f();
  }

  private void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (AdInternalSettings.shouldUseLiveRailEndpoint())
    {
      paramMap.put("LR_" + paramString1, paramString2);
      return;
    }
    paramMap.put(paramString1, paramString2);
  }

  private static Map<String, String> b(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("VIEWABLE", "1");
    localHashMap.put("SCHEMA", "json");
    localHashMap.put("SDK", "android");
    localHashMap.put("SDK_VERSION", "4.8.2");
    localHashMap.put("LOCALE", Locale.getDefault().toString());
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    int j = paramContext.getResources().getDisplayMetrics().widthPixels;
    int k = paramContext.getResources().getDisplayMetrics().heightPixels;
    localHashMap.put("DENSITY", String.valueOf(f1));
    localHashMap.put("SCREEN_WIDTH", String.valueOf((int)(j / f1)));
    localHashMap.put("SCREEN_HEIGHT", String.valueOf((int)(k / f1)));
    localHashMap.put("IDFA", f.o);
    if (f.p);
    for (paramContext = "0"; ; paramContext = "1")
    {
      localHashMap.put("IDFA_FLAG", paramContext);
      localHashMap.put("ATTRIBUTION_ID", f.n);
      localHashMap.put("ID_SOURCE", f.q);
      localHashMap.put("OS", "Android");
      localHashMap.put("OSVERS", f.a);
      localHashMap.put("BUNDLE", f.d);
      localHashMap.put("APPNAME", f.e);
      localHashMap.put("APPVERS", f.f);
      localHashMap.put("APPBUILD", String.valueOf(f.g));
      localHashMap.put("CARRIER", f.i);
      localHashMap.put("MAKE", f.b);
      localHashMap.put("MODEL", f.c);
      localHashMap.put("COPPA", String.valueOf(AdSettings.isChildDirected()));
      localHashMap.put("INSTALLER", f.h);
      localHashMap.put("SDK_CAPABILITY", d.b());
      return localHashMap;
    }
  }

  private void f()
  {
    if (this.c == null)
      this.c = b.a;
    switch (1.a[this.c.ordinal()])
    {
    default:
      this.b = AdPlacementType.UNKNOWN;
      return;
    case 1:
      this.b = AdPlacementType.INTERSTITIAL;
      return;
    case 2:
      this.b = AdPlacementType.BANNER;
      return;
    case 3:
    }
    this.b = AdPlacementType.NATIVE;
  }

  public String a()
  {
    return this.a;
  }

  public b b()
  {
    return this.c;
  }

  public AdSize c()
  {
    return this.i;
  }

  public int d()
  {
    return this.h;
  }

  public Map<String, String> e()
  {
    HashMap localHashMap = new HashMap();
    a(localHashMap, "PLACEMENT_ID", this.a);
    if (this.b != AdPlacementType.UNKNOWN)
      a(localHashMap, "PLACEMENT_TYPE", this.b.toString().toLowerCase());
    Iterator localIterator = b(this.d).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      a(localHashMap, (String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if (this.i != null)
    {
      a(localHashMap, "WIDTH", String.valueOf(this.i.getWidth()));
      a(localHashMap, "HEIGHT", String.valueOf(this.i.getHeight()));
    }
    a(localHashMap, "ADAPTERS", com.facebook.ads.internal.adapters.e.a(this.b));
    if (this.e != null)
      a(localHashMap, "TEMPLATE_ID", String.valueOf(this.e.a()));
    if (this.g != null)
      a(localHashMap, "REQUEST_TYPE", String.valueOf(this.g.a()));
    if (this.f)
      a(localHashMap, "TEST_MODE", "1");
    if (this.h != 0)
      a(localHashMap, "NUM_ADS_REQUESTED", String.valueOf(this.h));
    a(localHashMap, "CLIENT_EVENTS", com.facebook.ads.internal.util.c.a());
    return localHashMap;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.dto.e
 * JD-Core Version:    0.6.2
 */