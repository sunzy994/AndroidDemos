package cmcm.com.myapplication.android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import e;
import f;
import java.util.ArrayList;
import k;
import u;

public final class BackStackState
  implements Parcelable
{
  public static final Creator<BackStackState> CREATOR = new Creator()
  {
    public BackStackState a(Parcel paramAnonymousParcel)
    {
      return new BackStackState(paramAnonymousParcel);
    }

    public BackStackState[] a(int paramAnonymousInt)
    {
      return new BackStackState[paramAnonymousInt];
    }
  };
  final int[] a;
  final int b;
  final int c;
  final String d;
  final int e;
  final int f;
  final CharSequence g;
  final int h;
  final CharSequence i;
  final ArrayList<String> j;
  final ArrayList<String> k;

  public BackStackState(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.j = paramParcel.createStringArrayList();
    this.k = paramParcel.createStringArrayList();
  }

  public BackStackState(e parame)
  {
    f localf = parame.c;
    int n;
    for (int m = 0; localf != null; m = n)
    {
      n = m;
      if (localf.i != null)
        n = m + localf.i.size();
      localf = localf.a;
    }
    this.a = new int[m + parame.e * 7];
    if (!parame.l)
      throw new IllegalStateException("Not on back stack");
    localf = parame.c;
    m = 0;
    if (localf != null)
    {
      int[] arrayOfInt = this.a;
      n = m + 1;
      arrayOfInt[m] = localf.c;
      arrayOfInt = this.a;
      int i1 = n + 1;
      if (localf.d != null);
      for (m = localf.d.g; ; m = -1)
      {
        arrayOfInt[n] = m;
        arrayOfInt = this.a;
        m = i1 + 1;
        arrayOfInt[i1] = localf.e;
        arrayOfInt = this.a;
        n = m + 1;
        arrayOfInt[m] = localf.f;
        arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = localf.g;
        arrayOfInt = this.a;
        n = m + 1;
        arrayOfInt[m] = localf.h;
        if (localf.i == null)
          break label318;
        i1 = localf.i.size();
        arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = i1;
        n = 0;
        while (n < i1)
        {
          this.a[m] = ((k)localf.i.get(n)).g;
          n += 1;
          m += 1;
        }
      }
      while (true)
      {
        localf = localf.a;
        break;
        label318: arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = 0;
      }
    }
    this.b = parame.j;
    this.c = parame.k;
    this.d = parame.n;
    this.e = parame.p;
    this.f = parame.q;
    this.g = parame.r;
    this.h = parame.s;
    this.i = parame.t;
    this.j = parame.u;
    this.k = parame.v;
  }

  public e a(u paramu)
  {
    e locale = new e(paramu);
    int i1 = 0;
    int m = 0;
    while (m < this.a.length)
    {
      f localf = new f();
      Object localObject = this.a;
      int n = m + 1;
      localf.c = localObject[m];
      if (u.a)
        Log.v("FragmentManager", "Instantiate " + locale + " op #" + i1 + " base fragment #" + this.a[n]);
      localObject = this.a;
      m = n + 1;
      n = localObject[n];
      if (n >= 0);
      for (localf.d = ((k)paramu.f.get(n)); ; localf.d = null)
      {
        localObject = this.a;
        n = m + 1;
        localf.e = localObject[m];
        localObject = this.a;
        m = n + 1;
        localf.f = localObject[n];
        localObject = this.a;
        n = m + 1;
        localf.g = localObject[m];
        localObject = this.a;
        m = n + 1;
        localf.h = localObject[n];
        localObject = this.a;
        n = m + 1;
        int i3 = localObject[m];
        m = n;
        if (i3 <= 0)
          break;
        localf.i = new ArrayList(i3);
        int i2 = 0;
        while (true)
        {
          m = n;
          if (i2 >= i3)
            break;
          if (u.a)
            Log.v("FragmentManager", "Instantiate " + locale + " set remove fragment #" + this.a[n]);
          localObject = (k)paramu.f.get(this.a[n]);
          localf.i.add(localObject);
          i2 += 1;
          n += 1;
        }
      }
      locale.a(localf);
      i1 += 1;
    }
    locale.j = this.b;
    locale.k = this.c;
    locale.n = this.d;
    locale.p = this.e;
    locale.l = true;
    locale.q = this.f;
    locale.r = this.g;
    locale.s = this.h;
    locale.t = this.i;
    locale.u = this.j;
    locale.v = this.k;
    locale.a(1);
    return locale;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    TextUtils.writeToParcel(this.g, paramParcel, 0);
    paramParcel.writeInt(this.h);
    TextUtils.writeToParcel(this.i, paramParcel, 0);
    paramParcel.writeStringList(this.j);
    paramParcel.writeStringList(this.k);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.6.2
 */