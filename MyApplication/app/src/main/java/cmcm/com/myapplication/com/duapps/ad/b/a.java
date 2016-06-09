package cmcm.com.myapplication.com.duapps.ad.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import lu;
import lv;
import mv;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements Parcelable
{
  public static final Creator t = new lu();
  public String a;
  public int b;
  public String c;
  public String d;
  public long e;
  public int f;
  public int g;
  public String h;
  public String i;
  public float j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public long q;
  public boolean r = false;
  public boolean s = false;
  private int u;
  private int v;
  private int w;
  private String x;
  private String y = "inmobi";

  public a()
  {
  }

  private a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.c = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
    this.x = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.w = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.n = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.j = paramParcel.readFloat();
    this.q = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.r = bool1;
      if (paramParcel.readByte() == 0)
        break label224;
    }
    label224: for (boolean bool1 = bool2; ; bool1 = false)
    {
      this.s = bool1;
      return;
      bool1 = false;
      break;
    }
  }

  public a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, JSONObject paramJSONObject, long paramLong)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.d = paramString2;
    this.c = paramString3;
    this.e = paramJSONObject.optLong("id");
    this.x = paramJSONObject.optString("source");
    this.f = paramJSONObject.optInt("openType", -1);
    this.u = paramJSONObject.optInt("mType");
    this.v = paramJSONObject.optInt("label");
    this.g = paramJSONObject.optInt("preClick");
    this.w = paramJSONObject.optInt("cacheTime");
    this.q = paramLong;
    paramString1 = paramJSONObject.optJSONArray("ads").optJSONObject(paramInt2);
    if (paramString1 != null)
    {
      paramString2 = paramString1.optString("pubContent");
      this.o = paramString1.optString("contextCode");
      this.p = paramString1.optString("namespace");
      paramString1 = a(paramString2);
      if (paramString1 == null);
    }
    try
    {
      paramString1 = new JSONObject(paramString1);
      mv.c("IMData", "imAd==" + paramString1.toString());
      this.h = paramString1.optString("title");
      this.i = paramString1.optString("description");
      this.j = ((float)paramString1.optDouble("rating", 4.5D));
      this.n = paramString1.optString("cta");
      this.k = paramString1.optJSONObject("icon").optString("url");
      this.l = paramString1.optJSONObject("screenshots").optString("url");
      this.m = paramString1.optString("landingURL");
      return;
    }
    catch (JSONException paramString1)
    {
      mv.d("IMData", "JSONException:" + paramString1.toString());
    }
  }

  public a(String paramString1, String paramString2, long paramLong)
  {
    this.p = paramString1;
    this.o = paramString2;
    this.q = paramLong;
  }

  public static a a(JSONObject paramJSONObject)
  {
    a locala = new a();
    locala.y = paramJSONObject.optString("channel");
    locala.a = paramJSONObject.optString("license");
    locala.c = paramJSONObject.optString("logId");
    locala.b = paramJSONObject.optInt("sid");
    locala.d = paramJSONObject.optString("sType", "native");
    locala.e = paramJSONObject.optLong("id");
    locala.x = paramJSONObject.optString("source");
    locala.v = paramJSONObject.optInt("label");
    locala.g = paramJSONObject.optInt("preClick");
    locala.f = paramJSONObject.optInt("opentype");
    locala.w = paramJSONObject.optInt("cacheTime");
    locala.u = paramJSONObject.optInt("mType");
    locala.h = paramJSONObject.optString("title");
    locala.i = paramJSONObject.optString("description");
    locala.n = paramJSONObject.optString("cta");
    locala.k = paramJSONObject.optString("icon");
    locala.l = paramJSONObject.optString("screenshots");
    locala.m = paramJSONObject.optString("landingURL");
    locala.j = ((float)paramJSONObject.optLong("rating"));
    return locala;
  }

  private static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramString = new String(Base64.decode(paramString, 0, paramString.length, 0), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }

  public final String a(lv paramlv)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramlv == lv.a);
    for (int i1 = 18; ; i1 = 8)
    {
      localStringBuffer.append(this.o);
      localStringBuffer.append("<script>");
      localStringBuffer.append(this.p);
      localStringBuffer.append("recordEvent(" + i1 + ")");
      localStringBuffer.append("</script>");
      return localStringBuffer.toString();
    }
  }

  public final boolean a()
  {
    return System.currentTimeMillis() - this.q <= this.w * 60 * 1000;
  }

  public final String b()
  {
    String str = a(lv.a);
    return str + "<script>recordEvent(8)</script>";
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.x);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.w);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeFloat(this.j);
    paramParcel.writeLong(this.q);
    if (this.r)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.s)
        break label206;
    }
    label206: for (byte b1 = b2; ; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.duapps.ad.b.a
 * JD-Core Version:    0.6.2
 */