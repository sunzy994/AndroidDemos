package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;

class aul
  implements auj
{
  private IBinder a;

  aul(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.util.image.downloader.IImageDownloadCallback");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeInt(paramInt3);
      localParcel1.writeIntArray(paramArrayOfInt);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw paramString1;
  }

  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.lazyswipe.util.image.downloader.IImageDownloadCallback");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      if (paramBitmap != null)
      {
        localParcel1.writeInt(1);
        paramBitmap.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw paramString1;
  }

  public IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aul
 * JD-Core Version:    0.6.2
 */