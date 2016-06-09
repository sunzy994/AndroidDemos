package cmcm.com.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import org.json.JSONObject;

public class ps
{
  protected static ps a;
  protected Handler b = new Handler(Looper.getMainLooper());

  public static ps a()
  {
    if (a == null)
      a = new ps();
    return a;
  }

  @JavascriptInterface
  public String a(final String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    this.b.post(new Runnable()
    {
      public void run()
      {
        Log.d("notifyAdSdk", paramString);
        Object localObject4;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          Object localObject1 = localJSONObject.getString("action");
          localObject4 = localJSONObject.getJSONObject("data");
          po.a("notifyAdSdk:parsed", "action=" + (String)localObject1 + ", data=" + ((JSONObject)localObject4).toString());
          if (((String)localObject1).equals("sdk_init"))
          {
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("app_id", pn.d);
              ((JSONObject)localObject1).put("sdk_ver", 27);
              ((JSONObject)localObject1).put("tracking_user_id", pn.a().a());
              po.a("sdk_on_init", (JSONObject)localObject1);
              return;
            }
            catch (Exception localException1)
            {
              while (true)
                po.a("JSON put error", localException1);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          po.a("JsInterface.notifyAdSdk", localThrowable);
          return;
        }
        if (localThrowable.equals("init"))
        {
          po.a("init", "data=" + ((JSONObject)localObject4).toString());
          po.a(((JSONObject)localObject4).getString("on_init"), null);
          po.a(((JSONObject)localObject4).getString("on_ad_load"), null);
          return;
        }
        Object localObject2;
        final String str1;
        if (localThrowable.equals("showAd"))
        {
          localObject2 = ((JSONObject)localObject4).getString("on_error");
          str1 = ((JSONObject)localObject4).getString("on_ad_load");
          final String str2 = ((JSONObject)localObject4).getString("on_impression");
          final String str3 = ((JSONObject)localObject4).getString("on_click");
          final String str4 = ((JSONObject)localObject4).getString("on_close");
          po.a(((JSONObject)localObject4).getInt("placement_type"), ((JSONObject)localObject4).getString("placement_id"), new pk()
          {
            public void a(Exception paramAnonymous2Exception)
            {
              try
              {
                paramAnonymous2Exception = paramAnonymous2Exception.getMessage();
                po.a(this.a, new JSONObject("{\"error\": \"" + paramAnonymous2Exception + "\"}"));
                po.a("onError", paramAnonymous2Exception);
                return;
              }
              catch (Exception paramAnonymous2Exception)
              {
                po.a("AdEvent.onError", paramAnonymous2Exception);
              }
            }

            public void a(JSONObject paramAnonymous2JSONObject)
            {
              try
              {
                po.a(str1, paramAnonymous2JSONObject);
                po.a("onAdLoad", paramAnonymous2JSONObject.toString());
                return;
              }
              catch (Exception paramAnonymous2JSONObject)
              {
                po.a("AdEvent.onError", paramAnonymous2JSONObject);
              }
            }

            public void a(JSONObject paramAnonymous2JSONObject, boolean paramAnonymous2Boolean)
            {
              try
              {
                po.a(str4, null);
                po.a("onClose", "adInfo=" + paramAnonymous2JSONObject.toString() + "\n" + "userClose=" + paramAnonymous2Boolean);
                return;
              }
              catch (Exception paramAnonymous2JSONObject)
              {
                po.a("AdEvent.onClose", paramAnonymous2JSONObject);
              }
            }

            public void b(JSONObject paramAnonymous2JSONObject)
            {
              try
              {
                po.a(str2, paramAnonymous2JSONObject);
                po.a("onImpression", paramAnonymous2JSONObject.toString());
                return;
              }
              catch (Exception paramAnonymous2JSONObject)
              {
                po.a("AdEvent.onImpression", paramAnonymous2JSONObject);
              }
            }

            public void c(JSONObject paramAnonymous2JSONObject)
            {
              try
              {
                po.a(str3, paramAnonymous2JSONObject);
                po.a("onClick", paramAnonymous2JSONObject.toString());
                return;
              }
              catch (Exception paramAnonymous2JSONObject)
              {
                po.a("AdEvent.onClick", paramAnonymous2JSONObject);
              }
            }
          });
          return;
        }
        if (((String)localObject2).equals("tracking"))
          localObject2 = "";
        try
        {
          str1 = ((JSONObject)localObject4).getString("k");
          localObject2 = str1;
          localObject4 = ((JSONObject)localObject4).getString("v");
          localObject2 = localObject4;
          po.b(str1, (String)localObject2);
          return;
          if (((String)localObject2).equals("closeAd"))
          {
            po.c();
            return;
          }
          throw new Exception("notifyAdSdk:error: Unknown action " + (String)localObject2);
        }
        catch (Exception localException2)
        {
          while (true)
          {
            Object localObject3 = localObject2;
            localObject2 = "";
          }
        }
      }
    });
    return localJSONObject.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ps
 * JD-Core Version:    0.6.2
 */