package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class aun extends Binder
  implements aum
{
  public aun()
  {
    attachInterface(this, "com.lazyswipe.util.image.downloader.IImageDownloader");
  }

  public static aum a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.lazyswipe.util.image.downloader.IImageDownloader");
    if ((localIInterface != null) && ((localIInterface instanceof aum)))
      return (aum)localIInterface;
    return new auo(paramIBinder);
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
      paramParcel2.writeString("com.lazyswipe.util.image.downloader.IImageDownloader");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.lazyswipe.util.image.downloader.IImageDownloader");
      a(auk.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2:
      paramParcel1.enforceInterface("com.lazyswipe.util.image.downloader.IImageDownloader");
      b(auk.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3:
      paramParcel1.enforceInterface("com.lazyswipe.util.image.downloader.IImageDownloader");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      boolean bool1;
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0)
          break label202;
      }
      label202: for (boolean bool2 = true; ; bool2 = false)
      {
        paramParcel1 = a(str1, str2, bool1, bool2, paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 == null)
          break label208;
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
        bool1 = false;
        break;
      }
      label208: paramParcel2.writeInt(0);
      return true;
    case 4:
    }
    paramParcel1.enforceInterface("com.lazyswipe.util.image.downloader.IImageDownloader");
    a(paramParcel1.createStringArray());
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aun
 * JD-Core Version:    0.6.2
 */