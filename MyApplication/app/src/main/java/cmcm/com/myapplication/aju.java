package cmcm.com.myapplication;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherCondition;

public abstract class aju extends Binder
  implements ajt
{
  public aju()
  {
    attachInterface(this, "com.lazyswipe.features.weather.IWeatherService");
  }

  public static ajt a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.lazyswipe.features.weather.IWeatherService");
    if ((localIInterface != null) && ((localIInterface instanceof ajt)))
      return (ajt)localIInterface;
    return new ajv(paramIBinder);
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    int j = 0;
    boolean bool = false;
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.lazyswipe.features.weather.IWeatherService");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      ajq localajq = ajr.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
        bool = true;
      a(localajq, bool);
      paramParcel2.writeNoException();
      return true;
    case 2:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      a(ajr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 4:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      b();
      paramParcel2.writeNoException();
      return true;
    case 6:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      bool = c();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool)
        paramInt1 = 1;
      paramParcel2.writeInt(paramInt1);
      return true;
    case 7:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      d();
      paramParcel2.writeNoException();
      return true;
    case 8:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      bool = e();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool)
        paramInt1 = 1;
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (City)City.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        paramParcel1 = a(paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(paramParcel1);
        return true;
      }
    case 10:
      paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
      paramParcel1 = f();
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      return true;
    case 11:
    }
    paramParcel1.enforceInterface("com.lazyswipe.features.weather.IWeatherService");
    g();
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aju
 * JD-Core Version:    0.6.2
 */