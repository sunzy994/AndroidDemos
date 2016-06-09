package cmcm.com.myapplication;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class co<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final cn<T> a;

  public co(cn<T> paramcn)
  {
    this.a = paramcn;
  }

  public T createFromParcel(Parcel paramParcel)
  {
    return this.a.a(paramParcel, null);
  }

  public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return this.a.a(paramParcel, paramClassLoader);
  }

  public T[] newArray(int paramInt)
  {
    return this.a.a(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     co
 * JD-Core Version:    0.6.2
 */