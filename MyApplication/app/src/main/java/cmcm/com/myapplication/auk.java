package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class auk extends Binder
  implements auj
{
  public auk()
  {
    attachInterface(this, "com.lazyswipe.util.image.downloader.IImageDownloadCallback");
  }

  public static auj a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.lazyswipe.util.image.downloader.IImageDownloadCallback");
    if ((localIInterface != null) && ((localIInterface instanceof auj)))
      return (auj)localIInterface;
    return new aul(paramIBinder);
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
      paramParcel2.writeString("com.lazyswipe.util.image.downloader.IImageDownloadCallback");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.lazyswipe.util.image.downloader.IImageDownloadCallback");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        a(str1, str2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 2:
    }
    paramParcel1.enforceInterface("com.lazyswipe.util.image.downloader.IImageDownloadCallback");
    a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createIntArray());
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auk
 * JD-Core Version:    0.6.2
 */