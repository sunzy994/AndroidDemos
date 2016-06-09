package cmcm.com.myapplication;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherCondition;
import java.util.ArrayList;
import java.util.List;

class ajv
  implements ajt
{
  private IBinder a;

  ajv(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public City a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localCity = (City)City.CREATOR.createFromParcel(localParcel2);
        return localCity;
      }
      City localCity = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public WeatherCondition a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      localParcel1.writeString(paramString);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        paramString = (WeatherCondition)WeatherCondition.CREATOR.createFromParcel(localParcel2);
        return paramString;
      }
      paramString = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public List<City> a(City paramCity)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      if (paramCity != null)
      {
        localParcel1.writeInt(1);
        paramCity.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(9, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramCity = localParcel2.createTypedArrayList(City.CREATOR);
        return paramCity;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw paramCity;
  }

  public void a(ajq paramajq)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      if (paramajq != null);
      for (paramajq = paramajq.asBinder(); ; paramajq = null)
      {
        localParcel1.writeStrongBinder(paramajq);
        this.a.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw paramajq;
  }

  public void a(ajq paramajq, boolean paramBoolean)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      if (paramajq != null)
      {
        paramajq = paramajq.asBinder();
        localParcel1.writeStrongBinder(paramajq);
        if (!paramBoolean)
          break label79;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        paramajq = null;
        break;
        label79: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw paramajq;
  }

  public IBinder asBinder()
  {
    return this.a;
  }

  public void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public boolean c()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0)
        bool = true;
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public void d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public boolean e()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0)
        bool = true;
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public List<City> f()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      this.a.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.createTypedArrayList(City.CREATOR);
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public void g()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.features.weather.IWeatherService");
      this.a.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajv
 * JD-Core Version:    0.6.2
 */