package cmcm.com.myapplication;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class cm<T>
  implements Parcelable.Creator<T>
{
  final cn<T> a;

  public cm(cn<T> paramcn)
  {
    this.a = paramcn;
  }

  public T createFromParcel(Parcel paramParcel)
  {
    return this.a.a(paramParcel, null);
  }

  public T[] newArray(int paramInt)
  {
    return this.a.a(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cm
 * JD-Core Version:    0.6.2
 */