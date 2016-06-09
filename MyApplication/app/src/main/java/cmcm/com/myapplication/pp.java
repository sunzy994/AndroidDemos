package cmcm.com.myapplication;

import android.content.Context;
import org.json.JSONObject;

public class pp
{
  public static JSONObject a(Context paramContext)
  {
    try
    {
      paramContext = qd.a(paramContext, "config");
      if (paramContext != null)
      {
        if (paramContext.isEmpty())
          return null;
        paramContext = new JSONObject(paramContext);
        int i = paramContext.getInt("sdk_ver");
        if (i >= 22)
          return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      po.a("Config.get.e", paramContext);
    }
    return null;
  }

  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("up_time", System.currentTimeMillis());
      paramJSONObject.put("sdk_ver", 22);
      qd.b(paramContext, "config", paramJSONObject.toString());
      return;
    }
    catch (Exception paramContext)
    {
      po.a("Config.save.error", paramContext);
    }
  }

  public static boolean a(JSONObject paramJSONObject)
  {
    try
    {
      long l1 = paramJSONObject.getLong("up_time");
      long l2 = System.currentTimeMillis();
      long l3 = pn.b;
      po.a("upTime", "upTime=" + l1 + ", currTime=" + l2 + ", minTime=" + l3);
      if (l1 < l2 - l3)
        return true;
    }
    catch (Exception paramJSONObject)
    {
      po.a("Config.isExpire.error", paramJSONObject);
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pp
 * JD-Core Version:    0.6.2
 */