package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class po
{
  protected static pj a;
  protected static pj b;
  protected static RelativeLayout c;
  protected static pk d;
  protected static int e = 0;
  protected static List<String> f = new ArrayList();

  public static String a(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      a("getImei.error", paramContext);
    }
    return null;
  }

  public static JSONObject a(JSONArray paramJSONArray)
  {
    int k = 0;
    int i = 0;
    for (int j = 0; ; j = k)
    {
      while (true)
      {
        try
        {
          if (i < paramJSONArray.length())
          {
            j += paramJSONArray.getJSONObject(i).getInt("rate");
            i += 1;
            continue;
          }
          int m = new Random().nextInt(j);
          j = 0;
          i = k;
          if (i < paramJSONArray.length())
          {
            k = paramJSONArray.getJSONObject(i).getInt("rate") + j;
            if ((j > m) || (m >= k))
              break;
            if (i == -1)
            {
              c("no_placement", paramJSONArray.toString());
              return null;
            }
            paramJSONArray = paramJSONArray.getJSONObject(i);
            paramJSONArray.put("index", i);
            return paramJSONArray;
          }
        }
        catch (Exception paramJSONArray)
        {
          a("getRandPlacement.failed", paramJSONArray);
          return null;
        }
        i = -1;
      }
      i += 1;
    }
  }

  public static JSONObject a(JSONObject paramJSONObject, List<String> paramList)
  {
    int j = 0;
    while (true)
    {
      int i;
      int k;
      try
      {
        localObject1 = paramJSONObject.keys();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          i = paramJSONObject.getJSONObject((String)((Iterator)localObject1).next()).getInt("rate") + i;
          continue;
        }
        int m = new Random().nextInt(i);
        a("rand", String.valueOf(m));
        localObject2 = paramJSONObject.keys();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          k = paramJSONObject.getJSONObject((String)localObject1).getInt("rate") + i;
          a("begin-end", "begin=" + i + ", end=" + k);
          if ((i > m) || (m >= k))
            break label246;
          break label233;
          localObject2 = localObject1;
          if (i < 200)
          {
            localObject2 = localObject1;
            if (paramList.contains(localObject1))
            {
              localObject1 = a(paramJSONObject, null).getString("name");
              i += 1;
              continue;
            }
          }
          paramJSONObject = paramJSONObject.getJSONObject((String)localObject2);
          paramJSONObject.put("name", localObject2);
          return paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        a("getRandPlat.failed", paramJSONObject);
        return null;
      }
      Object localObject1 = null;
      label233: Object localObject2 = localObject1;
      if (paramList != null)
      {
        i = j;
        continue;
        label246: i = k;
      }
    }
  }

  public static void a()
  {
    try
    {
      Object localObject1 = pp.a(pn.c);
      a("conf", ((JSONObject)localObject1).toString());
      localObject1 = ((JSONObject)localObject1).getJSONObject("plats");
      a("plats", ((JSONObject)localObject1).toString());
      Object localObject2 = a((JSONObject)localObject1, f);
      a("plat", ((JSONObject)localObject2).toString());
      localObject1 = ((JSONObject)localObject2).getString("name");
      if (b != null)
      {
        b.b();
        b = null;
      }
      if (((String)localObject1).equals("fb"));
      for (b = new pl(); ; b = new pm())
      {
        String str = ((JSONObject)localObject2).getString("sdk_app_id");
        localObject2 = ((JSONObject)localObject2).getJSONObject("placements").getJSONArray("1");
        a("placements", ((JSONArray)localObject2).toString());
        localObject2 = a((JSONArray)localObject2).getString("id");
        a("sdkPlacementId", (String)localObject2);
        c = new RelativeLayout(pn.c);
        d = new pk()
        {
          public void a(Exception paramAnonymousException)
          {
            try
            {
              super.a(paramAnonymousException);
              po.f.add(po.this);
              po.b();
              return;
            }
            catch (Exception paramAnonymousException)
            {
              po.a("onError", paramAnonymousException);
            }
          }

          public void a(JSONObject paramAnonymousJSONObject)
          {
            try
            {
              super.a(paramAnonymousJSONObject);
              po.e = 0;
              po.f.clear();
              return;
            }
            catch (Exception paramAnonymousJSONObject)
            {
              po.a("onAdLoad", paramAnonymousJSONObject);
            }
          }
        };
        b.a(pn.c, str, (String)localObject2, pn.d, 1, "preload", c, d);
        return;
        if (!((String)localObject1).equals("gg"))
          break;
      }
    }
    catch (Exception localException)
    {
      a("Sdk.loadInterstitialAd", localException);
      b();
      return;
    }
    throw new Exception("unknown plat " + localException);
  }

  public static void a(int paramInt, String paramString, pk parampk)
  {
    Object localObject1 = null;
    while (true)
    {
      try
      {
        Object localObject2 = pp.a(pn.c).getJSONObject("plats");
        if (paramInt == 1)
          localObject1 = f;
        Object localObject3 = a((JSONObject)localObject2, (List)localObject1);
        localObject1 = ((JSONObject)localObject3).getString("name");
        localObject2 = ((JSONObject)localObject3).getString("sdk_app_id");
        localObject3 = a(((JSONObject)localObject3).getJSONObject("placements").getJSONArray(String.valueOf(paramInt))).getString("id");
        if (a != null)
        {
          a.b();
          a = null;
        }
        if ((paramInt == 1) && (b != null))
        {
          a = b;
          b = null;
          if (paramInt != 1)
            break label289;
          if (c == null)
            break label282;
          pn.e.removeAllViews();
          pn.e.addView(c);
          localObject1 = c;
          c = null;
          if (!a.a())
            ((RelativeLayout)localObject1).removeAllViews();
          if (d != null)
          {
            parampk.a(d);
            d = null;
          }
          a.b(pn.c, (String)localObject2, (String)localObject3, pn.d, paramInt, paramString, (RelativeLayout)localObject1, parampk);
          return;
        }
        if (((String)localObject1).equals("fb"))
        {
          a = new pl();
          continue;
        }
      }
      catch (Throwable paramString)
      {
        a("Sdk.showAd", paramString);
        return;
      }
      if (((String)localObject1).equals("gg"))
      {
        a = new pm();
      }
      else
      {
        throw new Exception("unknown_plat " + (String)localObject1);
        label282: localObject1 = pn.e;
        continue;
        label289: if (paramInt == 2)
        {
          localObject1 = pn.f;
        }
        else
        {
          if (paramInt != 3)
            break;
          localObject1 = pn.g;
        }
      }
    }
    throw new Exception("Unknown placementType " + paramInt);
  }

  public static void a(Context paramContext, final pz parampz)
  {
    Object localObject = pp.a(paramContext);
    if ((localObject == null) || (pp.a((JSONObject) localObject)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("http://i.haloapps.com/game_sdk_conf.lua?app_id=").append(pn.d).append("&pid=");
      if (pn.j == null)
      {
        localObject = "400113";
        localStringBuilder = localStringBuilder.append((String)localObject).append("&cid=");
        if (pn.j != null)
          break label144;
        localObject = qu.b(paramContext);
        label75: localStringBuilder = localStringBuilder.append((String)localObject).append("&cid2=");
        if (pn.j != null)
          break label156;
      }
      label144: label156: for (localObject = qu.c(paramContext); ; localObject = pn.j.d())
      {
        qa.a((String) localObject + "&imei=" + a(paramContext), new qb() {
          public void a(int paramAnonymousInt, String paramAnonymousString, final Throwable paramAnonymousThrowable) {
            super.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
            po.a("Http.json.error", paramAnonymousThrowable);
            po.a(new Runnable() {
              public void run() {
                po .2. this.b.a((Exception) paramAnonymousThrowable);
              }
            });
          }

          public void a(int paramAnonymousInt, final JSONObject paramAnonymousJSONObject) {
            super.a(paramAnonymousInt, paramAnonymousJSONObject);
            pp.a(po.this, paramAnonymousJSONObject);
            po.a("config.json", paramAnonymousJSONObject.toString());
            po.a(new Runnable() {
              public void run() {
                po .2. this.b.a(paramAnonymousJSONObject);
              }
            });
          }
        });
        return;
        localObject = pn.j.b();
        break;
        localObject = pn.j.c();
        break label75;
      }
    }
    a(new Runnable()
    {
      public void run()
      {
        po.this.a(this.b);
      }
    });
  }

  public static void a(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }

  public static void a(String paramString1, String paramString2)
  {
    if (!pn.a)
      return;
    String str = paramString2;
    if (paramString2 == null)
      str = "";
    Log.d("[H]:" + paramString1, str);
  }

  public static void a(String paramString, Throwable paramThrowable)
  {
    qq.a(pn.c, paramString, paramThrowable);
  }

  public static void a(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null);
    try
    {
      localJSONObject = new JSONObject();
      a("Java-notifyAdJs", "action=" + paramString + "\n" + "data=" + localJSONObject.toString());
      paramJSONObject = new JSONObject();
      paramJSONObject.put("action", paramString);
      paramJSONObject.put("data", localJSONObject);
      paramString = paramJSONObject.toString();
      pn.h.a(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      a("Sdk.notifyAdJs", paramString);
    }
  }

  public static String[] a(Context paramContext, String paramString, int paramInt)
  {
    String[] arrayOfString = new String[2];
    try
    {
      paramContext = pp.a(paramContext).getJSONObject("plats");
      if (paramString == null);
      for (paramContext = a(paramContext, null); ; paramContext = paramContext.getJSONObject(paramString))
      {
        arrayOfString[0] = paramContext.getString("sdk_app_id");
        arrayOfString[1] = a(paramContext.getJSONObject("placements").getJSONArray(String.valueOf(paramInt))).getString("id");
        return arrayOfString;
      }
    }
    catch (Throwable paramContext)
    {
      a("getRandKey.failed", paramContext);
    }
    return arrayOfString;
  }

  public static void b()
  {
    if (e < 3)
      a();
    e += 1;
  }

  public static void b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null)
      str = "";
    while (true)
    {
      try
      {
        a("LOG", "TAG: " + str + "\nMSG: " + paramString1);
        if (pn.i != null)
          pn.i.a(str, paramString1);
        return;
      }
      catch (Throwable paramString1)
      {
        qq.a(pn.c, "T.log.e", paramString1);
        return;
      }
      paramString1 = paramString2;
      if (paramString2 == null)
        paramString1 = "";
    }
  }

  public static void c()
  {
    if (a != null)
      a.b();
  }

  public static void c(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null)
      str = "";
    paramString1 = paramString2;
    if (paramString2 == null)
      paramString1 = "";
    qq.a(pn.c, "[H]:" + str, new Exception(paramString1));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     po
 * JD-Core Version:    0.6.2
 */