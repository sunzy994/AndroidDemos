package cmcm.com.myapplication.com.lazyswipe.features.weather.bean;

import akc;
import akg;
import aks;
import akt;
import aku;
import akw;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherCondition
  implements Parcelable
{
  public static final Creator<WeatherCondition> CREATOR = new Creator()
  {
    public WeatherCondition a(Parcel paramAnonymousParcel)
    {
      try
      {
        paramAnonymousParcel = WeatherCondition.a(new JSONObject(paramAnonymousParcel.readString()));
        return paramAnonymousParcel;
      }
      catch (Exception paramAnonymousParcel)
      {
        Log.e("Swipe.WeatherCondition", "error create weatherforecat", paramAnonymousParcel);
      }
      return null;
    }

    public WeatherCondition[] a(int paramAnonymousInt)
    {
      return new WeatherCondition[paramAnonymousInt];
    }
  };
  private Date a;
  private City b;
  private String c;
  private List<akt> d = new ArrayList();
  private aks e;

  public static WeatherCondition a(JSONObject paramJSONObject)
  {
    try
    {
      WeatherCondition localWeatherCondition = new WeatherCondition();
      localWeatherCondition.b = new City(paramJSONObject.optString("location_city"), null, paramJSONObject.optString("cityid"));
      localWeatherCondition.c = paramJSONObject.optString("units_temperature");
      localWeatherCondition.a = new Date(paramJSONObject.optInt("date"));
      localWeatherCondition.d = a(localWeatherCondition.a, paramJSONObject.optJSONArray("forecastWeatherInfoList"));
      return localWeatherCondition;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("Swipe.WeatherCondition", "parse json error", paramJSONObject);
    }
    throw new akg(7);
  }

  private static List<akt> a(Date paramDate, JSONArray paramJSONArray)
  {
    paramDate = new ArrayList();
    if (paramJSONArray == null)
      return paramDate;
    int i = 0;
    while (i < paramJSONArray.length())
    {
      akt localakt = akt.a(paramJSONArray.getJSONObject(i));
      if (localakt != null)
        paramDate.add(localakt);
      i += 1;
    }
    return paramDate;
  }

  public City a()
  {
    return this.b;
  }

  public WeatherForecast a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (akt)localIterator.next();
      Object localObject1 = ((akt)localObject2).c();
      aku localaku1 = ((akt)localObject2).b(paramBoolean);
      aku localaku2 = ((akt)localObject2).c(paramBoolean);
      if ((localObject1 != null) && (localObject1.length == 2))
      {
        String str = this.c;
        localObject2 = ((akt)localObject2).a();
        int i = localObject1[0];
        if (localObject1[0] == localObject1[1]);
        for (localObject1 = null; ; localObject1 = String.valueOf(localObject1[1]))
        {
          localArrayList.add(new akw(str, (Date)localObject2, String.valueOf(i), (String)localObject1, Integer.valueOf(akt.a(localaku1)), akc.a(paramContext, akt.a(localaku1)), Integer.valueOf(akt.a(localaku2)), akc.a(paramContext, akt.a(localaku2))));
          break;
        }
      }
    }
    return new WeatherForecast(this.a, this.b, localArrayList);
  }

  public void a(aks paramaks)
  {
    if ((paramaks == null) || (paramaks.b == null));
    while (!paramaks.b.b().equalsIgnoreCase(paramaks.b.b()))
      return;
    if (!paramaks.b())
    {
      Log.w("Swipe.WeatherCondition", "setRealtimeWeatherData !realtimeWeather.isToday()");
      return;
    }
    this.e = paramaks;
  }

  public void a(WeatherCondition paramWeatherCondition)
  {
    akt localakt = c();
    Object localObject = paramWeatherCondition.c();
    if (localObject != null)
    {
      if (localakt == null)
        this.d.add(localObject);
    }
    else
      paramWeatherCondition = paramWeatherCondition.b().iterator();
    label153: 
    while (true)
      label39: if (paramWeatherCondition.hasNext())
      {
        localakt = (akt)paramWeatherCondition.next();
        localObject = new Date();
        if (!localakt.a().before((Date)localObject))
        {
          localObject = b().iterator();
          do
            if (!((Iterator)localObject).hasNext())
              break;
          while (!((akt)((Iterator)localObject).next()).a().equals(localakt.a()));
        }
      }
      else
      {
        for (int i = 1; ; i = 0)
        {
          if (i != 0)
            break label153;
          this.d.add(localakt);
          break label39;
          localakt.a((akt)localObject);
          break;
          return;
        }
      }
  }

  public List<akt> b()
  {
    return this.d;
  }

  public akt c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      akt localakt = (akt)localIterator.next();
      if (localakt.d())
        return localakt;
    }
    return null;
  }

  public JSONObject d()
  {
    JSONArray localJSONArray;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("date", this.a.getTime());
      localJSONObject.put("location_city", this.b.a());
      localJSONObject.put("cityid", this.b.b());
      localJSONObject.put("units_temperature", this.c);
      localJSONArray = new JSONArray();
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((akt)localIterator.next()).b());
    }
    catch (Exception localException)
    {
      Log.w("Swipe.WeatherCondition", "parse json error", localException);
      throw new akg(7);
    }
    localException.put("forecastWeatherInfoList", localJSONArray);
    return localException;
  }

  public int describeContents()
  {
    return 0;
  }

  public aks e()
  {
    if ((this.e != null) && (this.e.b()))
      return this.e;
    return null;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(d().toString());
      return;
    }
    catch (Exception paramParcel)
    {
      Log.w("Swipe.WeatherCondition", "error writeToParcel weatherCondition", paramParcel);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.weather.bean.WeatherCondition
 * JD-Core Version:    0.6.2
 */