package cmcm.com.myapplication;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

final class kk
  implements IInterface
{
  private IBinder a;

  public kk(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public String a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      int i;
      if (paramBoolean)
      {
        i = 1;
        localParcel1.writeInt(i);
        this.a.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        i = localParcel2.readInt();
        if (i == 0)
          break label78;
      }
      label78: for (paramBoolean = bool; ; paramBoolean = false)
      {
        return paramBoolean;
        i = 0;
        break;
      }
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
 * Qualified Name:     kk
 * JD-Core Version:    0.6.2
 */