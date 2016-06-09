package cmcm.com.myapplication.com.lazyswipe.features.weather.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class City
  implements Parcelable, Serializable
{
  public static final Creator<City> CREATOR = new Creator()
  {
    public City a(Parcel paramAnonymousParcel)
    {
      return City.a(paramAnonymousParcel.readString());
    }

    public City[] a(int paramAnonymousInt)
    {
      return new City[paramAnonymousInt];
    }
  };
  public String a;
  private final String b;
  private final String c;
  private final String d;

  public City(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString3;
    this.d = paramString2;
  }

  public static City a(String paramString)
  {
    City localCity = null;
    if (paramString == null)
      paramString = localCity;
    String[] arrayOfString;
    do
    {
      do
      {
        return paramString;
        arrayOfString = paramString.split(";");
        paramString = localCity;
      }
      while (arrayOfString.length < 3);
      localCity = new City(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      paramString = localCity;
    }
    while (arrayOfString.length <= 3);
    localCity.a = arrayOfString[3];
    return localCity;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public String c()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof City)) && (((City)paramObject).b() != null) && (((City)paramObject).b().equals(b()));
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b).append(";");
    localStringBuilder.append(this.d).append(";");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(toString());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.weather.bean.City
 * JD-Core Version:    0.6.2
 */