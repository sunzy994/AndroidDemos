package cmcm.com.myapplication;

import android.os.IBinder;
import android.os.Parcel;

class apy
  implements apw
{
  private IBinder a;

  apy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public void a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.unlocker.ICheckLicenseService");
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public void a(apt paramapt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.unlocker.ICheckLicenseService");
      if (paramapt != null);
      for (paramapt = paramapt.asBinder(); ; paramapt = null)
      {
        localParcel1.writeStrongBinder(paramapt);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw paramapt;
  }

  public IBinder asBinder()
  {
    return this.a;
  }

  public void b(apt paramapt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.unlocker.ICheckLicenseService");
      if (paramapt != null);
      for (paramapt = paramapt.asBinder(); ; paramapt = null)
      {
        localParcel1.writeStrongBinder(paramapt);
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
    throw paramapt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apy
 * JD-Core Version:    0.6.2
 */