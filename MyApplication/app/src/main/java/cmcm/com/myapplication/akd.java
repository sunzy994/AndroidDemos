package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherCondition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public class akd
{
  private static final WeatherCondition a = null;
  private static String b = null;

  public static City a(Context paramContext)
  {
    return City.a(vs.a(paramContext, "widgetview_city_setting", null));
  }

  static WeatherCondition a(Context paramContext, City paramCity, WeatherCondition paramWeatherCondition)
  {
    if (paramWeatherCondition == null)
      return null;
    WeatherCondition localWeatherCondition = b(paramContext, paramCity);
    if (localWeatherCondition != null)
      paramWeatherCondition.a(localWeatherCondition);
    b(paramContext, paramCity, paramWeatherCondition);
    return paramWeatherCondition;
  }

  private static List<City> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null)
      return localArrayList;
    paramString = paramString.split("~");
    int i = 0;
    while (i < paramString.length)
    {
      if (!TextUtils.isEmpty(paramString[i]))
      {
        City localCity = City.a(paramString[i]);
        if (localCity != null)
          localArrayList.add(localCity);
      }
      i += 1;
    }
    return localArrayList;
  }

  static void a(Context paramContext, long paramLong)
  {
    vs.b(paramContext, "lastupdate_timestamp", paramLong);
  }

  public static void a(Context paramContext, City paramCity)
  {
    vs.b(paramContext, "widgetview_city_setting", paramCity.toString());
  }

  public static void a(Context paramContext, City paramCity, String paramString)
  {
    vs.b(paramContext, "realtime_weatherforecast_weather_" + paramCity.b(), paramString);
  }

  static void a(Context paramContext, WeatherCondition paramWeatherCondition)
  {
    try
    {
      paramContext = aks.a(c(paramContext, paramWeatherCondition.a()));
      if (paramContext != null)
        paramWeatherCondition.a(paramContext);
      return;
    }
    catch (akg paramContext)
    {
      Log.w("Swipe.WeatherData", "addRealtimeWeatherToWeatherCondition" + paramContext);
    }
  }

  public static void a(Context paramContext, List<City> paramList)
  {
    int i = 0;
    Object localObject = "";
    String str;
    if (i < paramList.size())
    {
      str = (String)localObject + ((City)paramList.get(i)).a() + ";" + ((City)paramList.get(i)).c() + ";" + ((City)paramList.get(i)).b();
      if (TextUtils.isEmpty(((City)paramList.get(i)).a))
        break label202;
      str = str + ";" + ((City)paramList.get(i)).a;
    }
    label202: 
    while (true)
    {
      localObject = str;
      if (i != paramList.size() - 1)
        localObject = str + "~";
      i += 1;
      break;
      vs.b(paramContext, "user_chooosed_cities", (String)localObject);
      return;
    }
  }

  public static WeatherCondition b(Context paramContext, City paramCity)
  {
    if (paramCity == null)
      return null;
    if ((a != null) && (a.a().equals(paramCity)))
      return a;
    paramCity = vs.a(paramContext, "weatherforecast_weather_" + paramCity.b(), null);
    if (paramCity != null);
    while (true)
    {
      try
      {
        if (paramCity.length() > 0)
        {
          paramCity = WeatherCondition.a(new JSONObject(paramCity));
          a(paramContext, paramCity);
          paramContext = paramCity;
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("Swipe.WeatherData", "Failed to decode the json weather info.", paramContext);
        return null;
      }
      paramContext = null;
    }
  }

  public static Date b(Context paramContext)
  {
    long l = vs.a(paramContext, "lastupdate_timestamp", 0L);
    try
    {
      paramContext = new Date(Long.valueOf(l).longValue());
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return new Date();
  }

  static void b(Context paramContext, long paramLong)
  {
    vs.a(paramContext).edit().putLong("realtime_weather_lastupdate_timestamp", paramLong).putLong("key_weather_details_times", 0L).apply();
  }

  public static void b(Context paramContext, City paramCity, WeatherCondition paramWeatherCondition)
  {
    try
    {
      vs.b(paramContext, "weatherforecast_weather_" + paramCity.b(), paramWeatherCondition.d().toString());
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("Swipe.WeatherData", "Failed to encode the json weather info.", paramContext);
    }
  }

  static String c(Context paramContext, City paramCity)
  {
    if (paramCity == null)
      return null;
    return vs.a(paramContext, "realtime_weatherforecast_weather_" + paramCity.b(), null);
  }

  public static Date c(Context paramContext)
  {
    long l = vs.a(paramContext, "realtime_weather_lastupdate_timestamp", 0L);
    try
    {
      paramContext = new Date(Long.valueOf(l).longValue());
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return new Date();
  }

  public static List<City> d(Context paramContext, City paramCity)
  {
    List localList = e(paramContext);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      City localCity = (City)localList.get(i);
      if (localCity.equals(paramCity))
      {
        localList.remove(i);
        localList.add(localCity);
        a(paramContext, localList);
        return localList;
      }
      i += 1;
    }
    while (true)
      if (i >= 9)
      {
        localList.remove(0);
        i = localList.size();
      }
      else
      {
        localList.add(paramCity);
        a(paramContext, localList);
        return localList;
        i = j;
      }
  }

  public static void d(Context paramContext)
  {
    vs.b(paramContext, "user_chooosed_cities", "");
  }

  public static List<City> e(Context paramContext)
  {
    return a(vs.a(paramContext, "user_chooosed_cities", null));
  }

  public static boolean f(Context paramContext)
  {
    return vs.c(paramContext, "ever_auto_locating", false);
  }

  public static void g(Context paramContext)
  {
    vs.b(paramContext, "ever_auto_locating", true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akd
 * JD-Core Version:    0.6.2
 */