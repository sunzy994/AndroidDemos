package cmcm.com.myapplication;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class apx extends Binder
  implements apw
{
  public static apw a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.lazyswipe.unlocker.ICheckLicenseService");
    if ((localIInterface != null) && ((localIInterface instanceof apw)))
      return (apw)localIInterface;
    return new apy(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.lazyswipe.unlocker.ICheckLicenseService");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.lazyswipe.unlocker.ICheckLicenseService");
      a(apu.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2:
      paramParcel1.enforceInterface("com.lazyswipe.unlocker.ICheckLicenseService");
      b(apu.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3:
    }
    paramParcel1.enforceInterface("com.lazyswipe.unlocker.ICheckLicenseService");
    a();
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apx
 * JD-Core Version:    0.6.2
 */