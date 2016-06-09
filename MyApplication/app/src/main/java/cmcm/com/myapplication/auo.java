package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class auo
  implements aum
{
  private IBinder a;

  auo(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public Bitmap a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int j = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.util.image.downloader.IImageDownloader");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      int i;
      if (paramBoolean1)
      {
        i = 1;
        localParcel1.writeInt(i);
        if (!paramBoolean2)
          break label137;
        i = j;
        label55: localParcel1.writeInt(i);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        this.a.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() == 0)
          break label143;
      }
      label137: label143: for (paramString1 = (Bitmap)Bitmap.CREATOR.createFromParcel(localParcel2); ; paramString1 = null)
      {
        return paramString1;
        i = 0;
        break;
        i = 0;
        break label55;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw paramString1;
  }

  public void a(auj paramauj)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.util.image.downloader.IImageDownloader");
      if (paramauj != null);
      for (paramauj = paramauj.asBinder(); ; paramauj = null)
      {
        localParcel1.writeStrongBinder(paramauj);
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
    throw paramauj;
  }

  public void a(String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.util.image.downloader.IImageDownloader");
      localParcel1.writeStringArray(paramArrayOfString);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw paramArrayOfString;
  }

  public IBinder asBinder()
  {
    return this.a;
  }

  public void b(auj paramauj)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.util.image.downloader.IImageDownloader");
      if (paramauj != null);
      for (paramauj = paramauj.asBinder(); ; paramauj = null)
      {
        localParcel1.writeStrongBinder(paramauj);
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
    throw paramauj;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auo
 * JD-Core Version:    0.6.2
 */