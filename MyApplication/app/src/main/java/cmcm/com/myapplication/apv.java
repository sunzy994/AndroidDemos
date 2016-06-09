package cmcm.com.myapplication;

import android.os.IBinder;
import android.os.Parcel;

class apv
  implements apt
{
  private IBinder a;

  apv(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public void a(int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.unlocker.ICheckLicenseCallback");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apv
 * JD-Core Version:    0.6.2
 */