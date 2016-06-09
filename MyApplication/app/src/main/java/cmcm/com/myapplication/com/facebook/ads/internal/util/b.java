package cmcm.com.myapplication.com.facebook.ads.internal.util;

import com.facebook.ads.internal.server.AdPlacementType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static String a = null;
  private String b;
  private Map<String, Object> c;
  private int d;
  private String e;

  public b(String paramString1, Map<String, Object> paramMap, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.c = paramMap;
    this.d = paramInt;
    this.e = paramString2;
  }

  public static b a(long paramLong, b.a parama, String paramString)
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("Time", String.valueOf(l - paramLong));
    localHashMap.put("AdAction", String.valueOf(parama.f));
    return new b("bounceback", localHashMap, (int)(l / 1000L), paramString);
  }

  public static b a(b.b paramb, AdPlacementType paramAdPlacementType, long paramLong, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("LatencyType", String.valueOf(paramb.b));
    localHashMap.put("AdPlacementType", paramAdPlacementType.toString());
    localHashMap.put("Time", String.valueOf(paramLong));
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (paramString != null);
    while (true)
    {
      return new b("latency", localHashMap, i, paramString);
      paramString = a;
    }
  }

  public static b a(Throwable paramThrowable, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ex", paramThrowable.getClass().getSimpleName());
    localHashMap.put("ex_msg", paramThrowable.getMessage());
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (paramString != null);
    while (true)
    {
      return new b("error", localHashMap, i, paramString);
      paramString = a;
    }
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.b);
      localJSONObject.put("data", new JSONObject(this.c));
      localJSONObject.put("time", this.d);
      localJSONObject.put("request_id", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.b
 * JD-Core Version:    0.6.2
 */