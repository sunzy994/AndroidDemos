package cmcm.com.myapplication.com.duapps.ad.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import lk;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  implements Parcelable
{
  public final List a = new ArrayList();
  private String b;
  private String c;
  private int d;
  private String e;
  private int f;
  private int g;
  private int h;
  private long i;
  private String j;
  private String k;
  private String l;
  private String m;

  static
  {
    new lk();
  }

  public c()
  {
  }

  private c(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    paramParcel.readTypedList(this.a, a.u);
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.i = paramParcel.readLong();
  }

  public c(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject, long paramLong)
  {
    this.b = paramString1;
    this.d = paramInt;
    this.e = paramString2;
    if (paramJSONObject == null);
    do
    {
      do
        return;
      while (paramInt != paramJSONObject.optInt("sId"));
      this.f = paramJSONObject.optInt("pn");
      this.g = paramJSONObject.optInt("ps");
      this.h = paramJSONObject.optInt("total");
      this.c = paramJSONObject.optString("logId");
      this.j = paramJSONObject.optString("ext");
      this.k = paramJSONObject.optString("title");
      this.l = paramJSONObject.optString("shortdesc");
      this.m = paramJSONObject.optString("description");
      paramJSONObject = paramJSONObject.optJSONArray("list");
    }
    while (paramJSONObject == null);
    int i1 = paramJSONObject.length();
    int n = 0;
    label159: JSONObject localJSONObject;
    if (n < i1)
    {
      localJSONObject = paramJSONObject.optJSONObject(n);
      if (localJSONObject != null)
        break label189;
    }
    while (true)
    {
      n += 1;
      break label159;
      break;
      label189: this.a.add(new a(paramString1, paramInt, paramString2, this.c, localJSONObject, paramLong));
    }
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeTypedList(this.a);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeLong(this.i);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.duapps.ad.a.c
 * JD-Core Version:    0.6.2
 */