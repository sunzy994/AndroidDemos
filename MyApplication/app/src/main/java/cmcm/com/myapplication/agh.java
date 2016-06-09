package cmcm.com.myapplication;

import android.text.TextUtils;
import org.json.JSONObject;

public class agh
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public long g;

  public static agh a(JSONObject paramJSONObject)
  {
    agh localagh = new agh();
    localagh.a = paramJSONObject.toString();
    localagh.b = paramJSONObject.optString("name");
    localagh.c = paramJSONObject.optString("pkg");
    localagh.d = paramJSONObject.optString("url");
    localagh.e = paramJSONObject.optString("intro");
    localagh.f = paramJSONObject.optString("icon");
    localagh.g = paramJSONObject.optLong("downloads");
    return localagh;
  }

  public static JSONObject a(agh paramagh)
  {
    if (!TextUtils.isEmpty(paramagh.a))
      try
      {
        paramagh = new JSONObject(paramagh.a);
        return paramagh;
      }
      catch (Exception paramagh)
      {
      }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agh
 * JD-Core Version:    0.6.2
 */