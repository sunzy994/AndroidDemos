package cmcm.com.myapplication.com.lazyswipe.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;

public class PsProcess
  implements Parcelable
{
  public static final Creator<PsProcess> CREATOR = new Creator()
  {
    public PsProcess a(Parcel paramAnonymousParcel)
    {
      return new PsProcess(paramAnonymousParcel, null);
    }

    public PsProcess[] a(int paramAnonymousInt)
    {
      return new PsProcess[paramAnonymousInt];
    }
  };
  public final String a;
  public final int b;
  public final int c;
  public final int d;
  public final long e;
  public final long f;
  public final int g;
  public final int h;
  public final int i;
  public final int j;
  public final int k;
  public final String l;
  public final String m;
  public final String n;
  public final String o;
  public final String p;
  public final long q;
  public final long r;

  private PsProcess(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readLong();
    this.r = paramParcel.readLong();
  }

  public PsProcess(String paramString)
  {
    paramString = paramString.split("\\s+");
    this.a = paramString[0];
    this.b = Process.getUidForName(this.a);
    this.c = Integer.parseInt(paramString[1]);
    this.d = Integer.parseInt(paramString[2]);
    this.e = (Integer.parseInt(paramString[3]) * 1024);
    this.f = (Integer.parseInt(paramString[4]) * 1024);
    this.g = Integer.parseInt(paramString[5]);
    this.h = Integer.parseInt(paramString[6]);
    this.i = Integer.parseInt(paramString[7]);
    this.j = Integer.parseInt(paramString[8]);
    this.k = Integer.parseInt(paramString[9]);
    if (paramString.length == 16)
    {
      this.l = "";
      this.m = paramString[10];
      this.n = paramString[11];
      this.o = paramString[12];
      this.p = paramString[13];
      this.q = (Integer.parseInt(paramString[14].split(":")[1].replace(",", "")) * 1000);
      this.r = (Integer.parseInt(paramString[15].split(":")[1].replace(")", "")) * 1000);
      return;
    }
    this.l = paramString[10];
    this.m = paramString[11];
    this.n = paramString[12];
    this.o = paramString[13];
    this.p = paramString[14];
    this.q = (Integer.parseInt(paramString[15].split(":")[1].replace(",", "")) * 1000);
    this.r = (Integer.parseInt(paramString[16].split(":")[1].replace(")", "")) * 1000);
  }

  public static int a(String paramString)
  {
    return Integer.parseInt(paramString.split("\\s+")[1]);
  }

  public String a()
  {
    if (!this.a.matches("u\\d+_a\\d+"))
      return null;
    if (this.p.contains(":"))
      return this.p.split(":")[0];
    return this.p;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeLong(this.q);
    paramParcel.writeLong(this.r);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.util.PsProcess
 * JD-Core Version:    0.6.2
 */