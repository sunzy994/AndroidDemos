package cmcm.com.myapplication.com.duapps.ad.b;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import lw;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  implements Parcelable
{
  public final List a = new ArrayList();
  private String b;
  private int c;
  private String d;
  private String e;
  private long f;

  static
  {
    new lw();
  }

  public d()
  {
  }

  private d(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.d = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readLong();
    paramParcel.readTypedList(this.a, a.t);
  }

  public d(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject, long paramLong)
  {
    this.b = paramString1;
    this.c = paramInt;
    this.e = paramString2;
    this.f = paramLong;
    label41: if (paramJSONObject == null)
      break label41;
    while (true)
    {
      return;
      if (paramInt == paramJSONObject.optInt("sId"))
      {
        this.d = paramJSONObject.optString("logId");
        paramJSONObject = paramJSONObject.optJSONArray("list");
        if (paramJSONObject.length() == 0)
          break;
        paramJSONObject = paramJSONObject.optJSONObject(0);
        if (paramJSONObject == null)
          break;
        JSONArray localJSONArray = paramJSONObject.optJSONArray("ads");
        int i = 0;
        while (i < localJSONArray.length())
        {
          this.a.add(new a(paramString1, paramInt, paramString2, this.d, i, paramJSONObject, paramLong));
          i += 1;
        }
      }
    }
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeTypedList(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.duapps.ad.b.d
 * JD-Core Version:    0.6.2
 */