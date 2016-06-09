package cmcm.com.myapplication.com.lazyswipe.features.weather.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.io.Serializable;
import org.json.JSONObject;

public class AirQuality
  implements Parcelable, Serializable
{
  public static final Creator<AirQuality> CREATOR = new Creator()
  {
    public AirQuality a(Parcel paramAnonymousParcel)
    {
      try
      {
        paramAnonymousParcel = AirQuality.a(new JSONObject(paramAnonymousParcel.readString()));
        return paramAnonymousParcel;
      }
      catch (Exception paramAnonymousParcel)
      {
        Log.e("Swipe.AirQuality", "error create airQuality", paramAnonymousParcel);
      }
      return null;
    }

    public AirQuality[] a(int paramAnonymousInt)
    {
      return new AirQuality[paramAnonymousInt];
    }
  };
  private final int a;
  private final int b;

  public AirQuality(int paramInt)
  {
    this.b = paramInt;
    if (paramInt <= 50)
    {
      this.a = 1;
      return;
    }
    if (paramInt <= 100)
    {
      this.a = 2;
      return;
    }
    if (paramInt <= 150)
    {
      this.a = 3;
      return;
    }
    if (paramInt <= 200)
    {
      this.a = 4;
      return;
    }
    if (paramInt <= 300)
    {
      this.a = 5;
      return;
    }
    this.a = 6;
  }

  public static AirQuality a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
      return null;
    return new AirQuality(paramJSONObject.optInt("aqi", -1));
  }

  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 1:
      return "#8bce08";
    case 2:
      return "#ffcf37";
    case 3:
      return "#ec8b11";
    case 4:
      return "#e64217";
    case 5:
      return "#861c67";
    case 6:
    }
    return "#802216";
  }

  public static String a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 1:
      return paramContext.getString(2131231196);
    case 2:
      return paramContext.getString(2131231197);
    case 3:
      return paramContext.getString(2131231198);
    case 4:
      return paramContext.getString(2131231199);
    case 5:
      return paramContext.getString(2131231200);
    case 6:
    }
    return paramContext.getString(2131231201);
  }

  public String a()
  {
    return a(this.a);
  }

  public String a(Context paramContext)
  {
    return a(paramContext, this.a);
  }

  public int b()
  {
    switch (this.a)
    {
    default:
      return -1;
    case 1:
    case 2:
    case 3:
    }
    return -13421773;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.weather.bean.AirQuality
 * JD-Core Version:    0.6.2
 */