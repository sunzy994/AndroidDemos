package cmcm.com.myapplication.android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import k;
import r;
import u;

public final class FragmentState
  implements Parcelable
{
  public static final Creator<FragmentState> CREATOR = new Creator()
  {
    public FragmentState a(Parcel paramAnonymousParcel)
    {
      return new FragmentState(paramAnonymousParcel);
    }

    public FragmentState[] a(int paramAnonymousInt)
    {
      return new FragmentState[paramAnonymousInt];
    }
  };
  final String a;
  final int b;
  final boolean c;
  final int d;
  final int e;
  final String f;
  final boolean g;
  final boolean h;
  final Bundle i;
  public Bundle j;
  public k k;

  public FragmentState(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.c = bool1;
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readString();
      if (paramParcel.readInt() == 0)
        break label110;
      bool1 = true;
      label69: this.g = bool1;
      if (paramParcel.readInt() == 0)
        break label115;
    }
    label110: label115: for (boolean bool1 = bool2; ; bool1 = false)
    {
      this.h = bool1;
      this.i = paramParcel.readBundle();
      this.j = paramParcel.readBundle();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
    }
  }

  public FragmentState(k paramk)
  {
    this.a = paramk.getClass().getName();
    this.b = paramk.g;
    this.c = paramk.p;
    this.d = paramk.x;
    this.e = paramk.y;
    this.f = paramk.z;
    this.g = paramk.C;
    this.h = paramk.B;
    this.i = paramk.i;
  }

  public k a(r paramr, k paramk)
  {
    if (this.k != null)
      return this.k;
    Context localContext = paramr.g();
    if (this.i != null)
      this.i.setClassLoader(localContext.getClassLoader());
    this.k = k.a(localContext, this.a, this.i);
    if (this.j != null)
    {
      this.j.setClassLoader(localContext.getClassLoader());
      this.k.e = this.j;
    }
    this.k.a(this.b, paramk);
    this.k.p = this.c;
    this.k.r = true;
    this.k.x = this.d;
    this.k.y = this.e;
    this.k.z = this.f;
    this.k.C = this.g;
    this.k.B = this.h;
    this.k.t = paramr.d;
    if (u.a)
      Log.v("FragmentManager", "Instantiated fragment " + this.k);
    return this.k;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    if (this.c)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeString(this.f);
      if (!this.g)
        break label106;
      paramInt = 1;
      label65: paramParcel.writeInt(paramInt);
      if (!this.h)
        break label111;
    }
    label106: label111: for (paramInt = m; ; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.i);
      paramParcel.writeBundle(this.j);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentState
 * JD-Core Version:    0.6.2
 */