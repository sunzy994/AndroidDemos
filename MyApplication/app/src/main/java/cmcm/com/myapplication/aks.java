package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import com.lazyswipe.features.weather.bean.AirQuality;
import com.lazyswipe.features.weather.bean.City;
import java.util.Date;
import org.json.JSONObject;

public class aks
{
  public Date a;
  public City b;
  public String c;
  public int d = -1;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public int k;
  public int l;
  public String m;

  public static aks a(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      aks localaks = a(new JSONObject(paramString));
      return localaks;
    }
    catch (Exception localException)
    {
      Log.w("Swipe.RealTimeCondition", "parse RealtimeWeatherCondition json error: " + paramString, localException);
    }
    throw new akg(7);
  }

  public static aks a(JSONObject paramJSONObject)
  {
    aks localaks = new aks();
    localaks.b = new City(paramJSONObject.optString("location_city"), null, paramJSONObject.optString("cityid"));
    localaks.a = new Date(Long.parseLong(paramJSONObject.optString("condition_date")));
    localaks.l = paramJSONObject.optInt("aqi", -1);
    localaks.c = paramJSONObject.optString("condition_temp", "0");
    localaks.d = paramJSONObject.optInt("condition_code", -1);
    localaks.e = paramJSONObject.optString("condition_text");
    localaks.m = paramJSONObject.optString("units_temperature", "C");
    localaks.g = paramJSONObject.optString("atmosphere_humidity", "");
    localaks.f = paramJSONObject.optString("feelsLike", "");
    localaks.i = paramJSONObject.optString("wind_direction", "");
    localaks.h = paramJSONObject.optString("wind_speed", "");
    localaks.j = paramJSONObject.optString("units_speed", "km/h");
    localaks.k = paramJSONObject.optInt("uv", -2);
    return localaks;
  }

  public String a(Context paramContext)
  {
    return akc.a(paramContext, this.d);
  }

  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("location_city", this.b.a());
      localJSONObject.put("cityid", this.b.b());
      localJSONObject.put("condition_date", this.a.getTime());
      localJSONObject.put("condition_temp", this.c);
      localJSONObject.put("aqi", this.l);
      localJSONObject.put("condition_code", this.d);
      localJSONObject.put("condition_text", this.e);
      localJSONObject.put("units_temperature", this.m);
      localJSONObject.put("atmosphere_humidity", this.g);
      localJSONObject.put("feelsLike", this.f);
      localJSONObject.put("wind_direction", this.i);
      localJSONObject.put("wind_speed", this.h);
      localJSONObject.put("units_speed", this.j);
      localJSONObject.put("uv", this.k);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Log.w("Swipe.RealTimeCondition", "parse json error", localException);
    }
    throw new akg(7);
  }

  public void a(aks paramaks)
  {
    this.a = paramaks.a;
    this.l = paramaks.l;
    if (paramaks.d != -1)
      this.d = paramaks.d;
    if (asi.i(paramaks.c))
      this.c = paramaks.c;
    if (asi.i(paramaks.m))
      this.m = paramaks.m;
    if (asi.i(paramaks.e))
      this.e = paramaks.e;
    if (asi.i(paramaks.f))
      this.f = paramaks.f;
    if (asi.i(paramaks.g))
      this.g = paramaks.g;
    if (asi.i(paramaks.h))
      this.h = paramaks.h;
    if (asi.i(paramaks.i))
      this.i = paramaks.i;
    if (asi.i(paramaks.j))
      this.j = paramaks.j;
    this.k = paramaks.k;
  }

  public String b(Context paramContext)
  {
    return akc.a(paramContext, this.c, this.m);
  }

  public boolean b()
  {
    return asq.a(new Date(), this.a) == 0;
  }

  public AirQuality c()
  {
    if (this.l < 0)
      return null;
    return new AirQuality(this.l);
  }

  public String c(Context paramContext)
  {
    return akc.a(paramContext, this.f, this.m);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aks
 * JD-Core Version:    0.6.2
 */