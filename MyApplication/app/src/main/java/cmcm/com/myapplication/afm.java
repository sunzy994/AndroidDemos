package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.holaverse.locate.amap.LocationManagerProxyAdapter;
import com.lazyswipe.features.weather.bean.City;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class afm
{
  private final Context a;
  private boolean b = false;
  private afe c;
  private afg d;
  private afn e;
  private afo f;
  private final List<Integer> g = new ArrayList();
  private final Handler h = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 1:
      }
      do
        return;
      while (afm.a(afm.this));
      afm.b(afm.this);
    }
  };

  public afm(Context paramContext)
  {
    this.a = paramContext;
  }

  public static String a(Context paramContext, String paramString1, double paramDouble1, double paramDouble2, String paramString2)
  {
    return asq.p(paramContext, "http://tq.holalauncher.com/" + "searchCityByLatLng?lat=" + paramDouble1 + "&lng=" + paramDouble2 + "&info=" + URLEncoder.encode(paramString2) + "&type=" + URLEncoder.encode(paramString1) + "&lang=" + paramContext.getResources().getConfiguration().locale.toString());
  }

  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    return asq.p(paramContext, "http://weather.qiigame.com/weather/thirdpart/" + "search?name=" + URLEncoder.encode(paramString) + "&pageSize=" + paramInt1 + "&lang=" + paramContext.getResources().getConfiguration().locale.toString() + "&page=" + paramInt2);
  }

  private void a(Integer paramInteger)
  {
    this.g.remove(paramInteger);
    if (this.g.isEmpty())
    {
      this.b = true;
      if (this.e != null)
        this.e.a(0);
    }
  }

  private void a(Integer paramInteger, City paramCity)
  {
    this.g.remove(paramInteger);
    if (this.b);
    do
    {
      return;
      a();
    }
    while (this.e == null);
    this.e.a(paramCity);
  }

  private void b()
  {
    Object localObject = afp.a(this.a);
    if (localObject != null)
    {
      this.g.add(Integer.valueOf(2));
      ((LocationManagerProxyAdapter)localObject).init(this.a);
      this.c = new afe(this.a, (LocationManagerProxyAdapter)localObject);
      localObject = new ajy(this.a);
      this.c.a((ajy)localObject, this.f);
    }
  }

  public void a()
  {
    this.b = true;
    if (this.c != null)
      this.c.a();
    if (this.d != null)
      this.d.b();
  }

  public void a(afn paramafn)
  {
    this.e = paramafn;
    this.b = false;
    this.f = new afo()
    {
      public void a(final int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, String paramAnonymousString)
      {
        Context localContext = afm.c(afm.this);
        String str;
        if (paramAnonymousInt == 2)
        {
          str = "amap";
          if (!TextUtils.isEmpty(paramAnonymousString))
            break label81;
          paramAnonymousString = "";
        }
        label81: 
        while (true)
        {
          paramAnonymousString = afm.a(localContext, str, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousString);
          new arb(afm.c(afm.this)).a(paramAnonymousString, null, new arc()
          {
            public void a(int paramAnonymous2Int, String paramAnonymous2String)
            {
              paramAnonymous2Int = 0;
              try
              {
                if (TextUtils.isEmpty(paramAnonymous2String))
                {
                  afm.a(afm.this, Integer.valueOf(paramAnonymousInt));
                  return;
                }
                paramAnonymous2String = new JSONObject(paramAnonymous2String);
                if (paramAnonymous2String.optInt("statusCode") != 200)
                {
                  afm.a(afm.this, Integer.valueOf(paramAnonymousInt));
                  return;
                }
              }
              catch (Exception paramAnonymous2String)
              {
                Log.e("Swipe.LocationService", "update weather exception", paramAnonymous2String);
              }
              while (true)
              {
                afm.a(afm.this, Integer.valueOf(paramAnonymousInt));
                return;
                if (paramAnonymous2String.opt("searchWeatherInfoList") == null)
                {
                  afm.a(afm.this, Integer.valueOf(paramAnonymousInt));
                  return;
                }
                paramAnonymous2String = paramAnonymous2String.getJSONArray("searchWeatherInfoList");
                while (paramAnonymous2Int < paramAnonymous2String.length())
                {
                  Object localObject = paramAnonymous2String.getJSONObject(paramAnonymous2Int);
                  String str = ((JSONObject)localObject).optString("name");
                  localObject = ((JSONObject)localObject).optString("cityid");
                  if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
                  {
                    str = str.trim();
                    if (str.contains(","));
                    for (paramAnonymous2String = str.substring(0, str.indexOf(',')).trim(); ; paramAnonymous2String = str)
                    {
                      paramAnonymous2String = new City(paramAnonymous2String, null, (String)localObject);
                      paramAnonymous2String.a = str;
                      afm.a(afm.this, Integer.valueOf(paramAnonymousInt), paramAnonymous2String);
                      return;
                    }
                  }
                  paramAnonymous2Int += 1;
                }
              }
            }

            public void a(Throwable paramAnonymous2Throwable)
            {
              afm.a(afm.this, Integer.valueOf(paramAnonymousInt));
            }
          });
          return;
          str = "android";
          break;
        }
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (afm.a(afm.this))
          return;
        afm.a(afm.this, Integer.valueOf(paramAnonymousInt1));
      }

      public void a(int paramAnonymousInt, City paramAnonymousCity)
      {
        if (paramAnonymousCity != null)
        {
          afm.a(afm.this, Integer.valueOf(paramAnonymousInt), paramAnonymousCity);
          return;
        }
        afm.a(afm.this, Integer.valueOf(paramAnonymousInt));
      }
    };
    paramafn = new afq();
    if (!new afq().e(this.a).exists())
    {
      aqu.a(this.a, paramafn, this.h, 1);
      return;
    }
    b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afm
 * JD-Core Version:    0.6.2
 */