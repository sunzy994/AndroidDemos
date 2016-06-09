package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.ads.internal.util.e;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.util.f.a;
import com.facebook.ads.internal.util.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  implements f.a
{
  private final String a;
  private final String b;
  private final String c;
  private final e d;
  private final String e;
  private final Collection<String> f;
  private final Map<String, String> g;
  private final String h;
  private final int i;
  private final int j;

  private k(String paramString1, String paramString2, String paramString3, e parame, String paramString4, Collection<String> paramCollection, Map<String, String> paramMap, String paramString5, int paramInt1, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = parame;
    this.e = paramString4;
    this.f = paramCollection;
    this.g = paramMap;
    this.h = paramString5;
    this.i = paramInt1;
    this.j = paramInt2;
  }

  public static k a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("markup");
    String str2 = paramBundle.getString("native_impression_report_url");
    String str3 = paramBundle.getString("request_id");
    int k = paramBundle.getInt("viewability_check_initial_delay");
    int m = paramBundle.getInt("viewability_check_interval");
    return new k(str1, null, str2, e.a, "", null, null, str3, k, m);
  }

  public static k a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return null;
    String str1 = paramJSONObject.optString("markup");
    String str2 = paramJSONObject.optString("activation_command");
    String str3 = paramJSONObject.optString("native_impression_report_url");
    String str4 = paramJSONObject.optString("request_id");
    e locale = e.a(paramJSONObject.optString("invalidation_behavior"));
    String str5 = paramJSONObject.optString("invalidation_report_url");
    try
    {
      Object localObject = new JSONArray(paramJSONObject.optString("detection_strings"));
      localObject = f.a((JSONArray)localObject);
      paramJSONObject = paramJSONObject.optJSONObject("metadata");
      localHashMap = new HashMap();
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str6 = (String)localIterator.next();
          localHashMap.put(str6, paramJSONObject.optString(str6));
        }
      }
    }
    catch (JSONException localJSONException)
    {
      HashMap localHashMap;
      Collection localCollection;
      while (true)
      {
        localJSONException.printStackTrace();
        localCollection = null;
      }
      int k = 0;
      int m = 1000;
      if (localHashMap.containsKey("viewability_check_initial_delay"))
        k = Integer.parseInt((String)localHashMap.get("viewability_check_initial_delay"));
      if (localHashMap.containsKey("viewability_check_interval"))
        m = Integer.parseInt((String)localHashMap.get("viewability_check_interval"));
      return new k(str1, str2, str3, locale, str5, localCollection, localHashMap, str4, k, m);
    }
  }

  public static k b(Intent paramIntent)
  {
    String str1 = g.a(paramIntent.getByteArrayExtra("markup"));
    String str2 = paramIntent.getStringExtra("activation_command");
    String str3 = paramIntent.getStringExtra("native_impression_report_url");
    String str4 = paramIntent.getStringExtra("request_id");
    int k = paramIntent.getIntExtra("viewability_check_initial_delay", 0);
    int m = paramIntent.getIntExtra("viewability_check_interval", 1000);
    return new k(str1, str2, str3, e.a, "", null, null, str4, k, m);
  }

  public e a()
  {
    return this.d;
  }

  public void a(Intent paramIntent)
  {
    paramIntent.putExtra("markup", g.a(this.a));
    paramIntent.putExtra("activation_command", this.b);
    paramIntent.putExtra("native_impression_report_url", this.c);
    paramIntent.putExtra("request_id", this.h);
    paramIntent.putExtra("viewability_check_initial_delay", this.i);
    paramIntent.putExtra("viewability_check_interval", this.j);
  }

  public String b()
  {
    return this.e;
  }

  public Collection<String> c()
  {
    return this.f;
  }

  public String d()
  {
    return this.a;
  }

  public String e()
  {
    return this.b;
  }

  public String f()
  {
    return this.c;
  }

  public String g()
  {
    return "facebookAd.sendImpression();";
  }

  public Map<String, String> h()
  {
    return this.g;
  }

  public String i()
  {
    return this.h;
  }

  public int j()
  {
    return this.i;
  }

  public int k()
  {
    return this.j;
  }

  public Bundle l()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("markup", this.a);
    localBundle.putString("native_impression_report_url", this.c);
    localBundle.putString("request_id", this.h);
    localBundle.putInt("viewability_check_initial_delay", this.i);
    localBundle.putInt("viewability_check_interval", this.j);
    return localBundle;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.k
 * JD-Core Version:    0.6.2
 */