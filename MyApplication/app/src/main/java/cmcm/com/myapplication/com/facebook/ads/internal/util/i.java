package cmcm.com.myapplication.com.facebook.ads.internal.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
{
  private final String a;
  private final String b;
  private final String c;
  private final List<String> d;
  private final String e;
  private final String f;

  private i(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramList;
    this.e = paramString4;
    this.f = paramString5;
  }

  public static i a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return null;
    String str1 = paramJSONObject.optString("package");
    String str2 = paramJSONObject.optString("appsite");
    String str3 = paramJSONObject.optString("appsite_url");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("key_hashes");
    ArrayList localArrayList = new ArrayList();
    if (localJSONArray != null)
    {
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add(localJSONArray.optString(i));
        i += 1;
      }
    }
    return new i(str1, str2, str3, localArrayList, paramJSONObject.optString("market_uri"), paramJSONObject.optString("fallback_url"));
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.i
 * JD-Core Version:    0.6.2
 */