package cmcm.com.myapplication;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class apu extends Binder
  implements apt
{
  public apu()
  {
    attachInterface(this, "com.lazyswipe.unlocker.ICheckLicenseCallback");
  }

  public static apt a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.lazyswipe.unlocker.ICheckLicenseCallback");
    if ((localIInterface != null) && ((localIInterface instanceof apt)))
      return (apt)localIInterface;
    return new apv(paramIBinder);
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.lazyswipe.unlocker.ICheckLicenseCallback");
      return true;
    case 1:
    }
    paramParcel1.enforceInterface("com.lazyswipe.unlocker.ICheckLicenseCallback");
    a(paramParcel1.readInt(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apu
 * JD-Core Version:    0.6.2
 */