package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class agg
{
  public String a;
  public final List<agh> b = new ArrayList();

  public static agg a(Context paramContext)
  {
    String str = vs.a(paramContext, "key_hola_family_pref_banner", "");
    paramContext = vs.a(paramContext, "key_hola_family_pref_list", "");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramContext)))
      try
      {
        JSONArray localJSONArray = new JSONArray(paramContext);
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          agg localagg = new agg();
          localagg.a = str;
          int i = 0;
          while (true)
          {
            paramContext = localagg;
            if (i >= localJSONArray.length())
              break;
            paramContext = agh.a(localJSONArray.getJSONObject(i));
            if (paramContext != null)
              localagg.b.add(paramContext);
            i += 1;
          }
        }
      }
      catch (Exception paramContext)
      {
      }
    else
      paramContext = null;
    return paramContext;
  }

  public static void a(Context paramContext, agg paramagg)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject = new ArrayList();
      ((List)localObject).addAll(paramagg.b);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        JSONObject localJSONObject = agh.a((agh) ((Iterator) localObject).next());
        if (localJSONObject != null)
          localJSONArray.put(localJSONObject);
      }
      vs.b(paramContext, "key_hola_family_pref_banner", paramagg.a);
      vs.b(paramContext, "key_hola_family_pref_list", localJSONArray.toString());
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public static agg b(Context paramContext)
  {
    int i = 0;
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http://a.holaworld.cn").append("/family?");
      ((StringBuilder)localObject).append("w=").append(aqs.ae());
      ((StringBuilder)localObject).append("&h=").append(aqs.af());
      ((StringBuilder)localObject).append("&pid=").append("300105");
      ((StringBuilder)localObject).append("&vid=").append("00");
      ((StringBuilder)localObject).append("&cid=").append("26100");
      ((StringBuilder)localObject).append("&lang=").append(asq.j());
      ((StringBuilder)localObject).append("&uid=").append(vs.u(paramContext));
      ((StringBuilder)localObject).append("&ver=").append(22500);
      localObject = ((StringBuilder)localObject).toString();
      paramContext = new arb(paramContext).a((String)localObject, null);
      if (!TextUtils.isEmpty(paramContext))
      {
        localObject = new JSONObject(paramContext);
        if (!((JSONObject)localObject).optBoolean("success", false))
          return null;
        paramContext = new agg();
        paramContext.a = ((JSONObject)localObject).optString("banner");
        localObject = ((JSONObject)localObject).getJSONArray("families");
        while (i < ((JSONArray)localObject).length())
        {
          agh localagh = agh.a(((JSONArray) localObject).getJSONObject(i));
          if ((localagh != null) && (!localagh.c.equals("com.lazyswipe")))
            paramContext.b.add(localagh);
          i += 1;
        }
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agg
 * JD-Core Version:    0.6.2
 */