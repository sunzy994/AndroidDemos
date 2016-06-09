package cmcm.com.myapplication;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class agu
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private boolean h;
  private boolean i = false;
  private boolean j;
  private String k;
  private boolean l;
  private String m;

  public static List<agu> a(String paramString)
  {
    int n = 0;
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      paramString = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList();
      while (n < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(n);
        agu localagu = new agu();
        localagu.b = localJSONObject.optString("name");
        localagu.c = localJSONObject.optString("icon");
        localagu.a = localJSONObject.optInt("id");
        localagu.d = localJSONObject.optString("url");
        localagu.g = localJSONObject.optString("js");
        localagu.h = localJSONObject.optBoolean("is_default");
        localagu.i = localJSONObject.optBoolean("hide_apps", false);
        localagu.e = localJSONObject.optString("search_box_url");
        localagu.f = localJSONObject.optString("auto_suggestion_url");
        localagu.j = localJSONObject.optBoolean("show_trending_word", true);
        localagu.k = localJSONObject.optString("trending_word_url");
        localagu.l = localJSONObject.optBoolean("show_trending_word_box", true);
        localagu.m = localJSONObject.optString("trending_word_box_url", localagu.k);
        localArrayList.add(localagu);
        n += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
    }
    return null;
  }

  public int a()
  {
    return this.a;
  }

  public String b()
  {
    return arb.a(b(""));
  }

  public String b(String paramString)
  {
    return String.format(this.d, new Object[] { asi.b(paramString) });
  }

  public String c()
  {
    return this.e;
  }

  public String c(String paramString)
  {
    if (TextUtils.isEmpty(this.f))
      return null;
    return String.format(this.f, new Object[] { asi.b(paramString) });
  }

  public String d(String paramString)
  {
    if (TextUtils.isEmpty(this.k))
      return null;
    return String.format(this.k, new Object[] { asi.b(paramString) });
  }

  public boolean d()
  {
    return this.h;
  }

  public String e(String paramString)
  {
    if (TextUtils.isEmpty(this.m))
      return null;
    return String.format(this.m, new Object[] { asi.b(paramString) });
  }

  public boolean e()
  {
    return this.j;
  }

  public String f()
  {
    return this.g;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agu
 * JD-Core Version:    0.6.2
 */