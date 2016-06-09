package cmcm.com.myapplication.com.holaverse.charging.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class Battery
  implements Parcelable, Serializable
{
  public static final Creator<Battery> CREATOR = new Creator()
  {
    public Battery a(Parcel paramAnonymousParcel)
    {
      return new Battery(paramAnonymousParcel, null);
    }

    public Battery[] a(int paramAnonymousInt)
    {
      return new Battery[paramAnonymousInt];
    }
  };
  public int a;
  public int b;
  public int c;
  public int d;
  public long e;
  public int f;

  public Battery()
  {
  }

  private Battery(Parcel paramParcel)
  {
    a(paramParcel);
  }

  public void a(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readInt();
  }

  public boolean a()
  {
    return (this.d == 2) || (this.c == 1) || (this.c == 2) || (this.c == 1) || (4 == this.c);
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString()).append('[');
    float f1 = this.a / this.b;
    localStringBuilder.append("plugger:").append(this.c).append(',');
    localStringBuilder.append("level:").append(this.a).append(',');
    localStringBuilder.append("scale:").append(this.b).append(',');
    localStringBuilder.append("batteryPct:").append(f1).append(',');
    localStringBuilder.append("chargingModel:").append(this.f).append(',');
    localStringBuilder.append("remainTime:").append(this.e).append(']');
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeInt(this.f);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.charging.model.Battery
 * JD-Core Version:    0.6.2
 */