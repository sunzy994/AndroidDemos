package cmcm.com.myapplication;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherCondition;

public abstract class ajr extends Binder
  implements ajq
{
  public ajr()
  {
    attachInterface(this, "com.lazyswipe.features.weather.IWeatherCallback");
  }

  public static ajq a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.lazyswipe.features.weather.IWeatherCallback");
    if ((localIInterface != null) && ((localIInterface instanceof ajq)))
      return (ajq)localIInterface;
    return new ajs(paramIBinder);
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.lazyswipe.features.weather.IWeatherCallback");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherCallback");
      a();
      paramParcel2.writeNoException();
      return true;
    case 2:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherCallback");
      if (paramParcel1.readInt() != 0)
        localObject1 = (City)City.CREATOR.createFromParcel(paramParcel1);
      a((City)localObject1, paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 3:
    }
    paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherCallback");
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0)
      localObject1 = (WeatherCondition)WeatherCondition.CREATOR.createFromParcel(paramParcel1);
    a((WeatherCondition)localObject1, paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajr
 * JD-Core Version:    0.6.2
 */