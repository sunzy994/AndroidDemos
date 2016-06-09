package cmcm.com.myapplication.com.hola.alliance;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppInfo
  implements Parcelable
{
  public static final Creator<AppInfo> CREATOR = new Creator()
  {
    public AppInfo a(Parcel paramAnonymousParcel)
    {
      return new AppInfo(paramAnonymousParcel, null);
    }

    public AppInfo[] a(int paramAnonymousInt)
    {
      return new AppInfo[paramAnonymousInt];
    }
  };
  public String a;
  public int b;

  public AppInfo()
  {
  }

  private AppInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }

  private void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.alliance.AppInfo
 * JD-Core Version:    0.6.2
 */