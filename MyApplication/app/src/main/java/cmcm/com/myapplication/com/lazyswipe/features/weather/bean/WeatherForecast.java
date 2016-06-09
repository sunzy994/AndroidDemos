package cmcm.com.myapplication.com.lazyswipe.features.weather.bean;

import akw;
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

public class WeatherForecast
  implements Parcelable
{
  public static final Creator<WeatherForecast> CREATOR = new Creator()
  {
    public WeatherForecast a(Parcel paramAnonymousParcel)
    {
      try
      {
        paramAnonymousParcel = WeatherForecast.a(new JSONObject(paramAnonymousParcel.readString()));
        return paramAnonymousParcel;
      }
      catch (Exception paramAnonymousParcel)
      {
        Log.e("Swipe.WeatherForecast", "error create weatherforecat", paramAnonymousParcel);
      }
      return null;
    }

    public WeatherForecast[] a(int paramAnonymousInt)
    {
      return new WeatherForecast[paramAnonymousInt];
    }
  };
  private Date a;
  private City b;
  private List<akw> c;

  public WeatherForecast(Date paramDate, City paramCity, List<akw> paramList)
  {
    this.a = paramDate;
    this.b = paramCity;
    this.c = paramList;
  }

  public static WeatherForecast a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramJSONObject.getJSONArray("forecasts");
    if (localObject != null)
    {
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        if (localJSONObject != null)
          localArrayList.add(akw.a(localJSONObject));
        i += 1;
      }
    }
    localObject = City.a(paramJSONObject.getString("city"));
    if (localObject == null)
      return null;
    return new WeatherForecast(new Date(paramJSONObject.getLong("date")), (City)localObject, localArrayList);
  }

  public List<akw> a()
  {
    return this.c;
  }

  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("date", this.a.getTime());
    localJSONObject.put("city", this.b.toString());
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.c.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (akw)localIterator.next();
      if (localObject == null);
      for (localObject = null; ; localObject = ((akw)localObject).f())
      {
        localJSONArray.put(localObject);
        break;
      }
    }
    localJSONObject.put("forecasts", localJSONArray);
    return localJSONObject;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(b().toString());
      return;
    }
    catch (Exception paramParcel)
    {
      Log.e("Swipe.WeatherForecast", "error writeToParcel weatherforecat", paramParcel);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.weather.bean.WeatherForecast
 * JD-Core Version:    0.6.2
 */