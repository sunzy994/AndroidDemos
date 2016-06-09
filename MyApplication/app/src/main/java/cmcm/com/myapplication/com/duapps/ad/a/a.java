package cmcm.com.myapplication.com.duapps.ad.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import lj;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements Parcelable
{
  public static final Creator u = new lj();
  private int A;
  private float B;
  private int C;
  private String D;
  private long E;
  private long F;
  private String G = "download";
  public long a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public float g;
  public int h;
  public int i = -1;
  public String j;
  public String k;
  public String l;
  public String m;
  public int n;
  public String o;
  public int p;
  public String q;
  public String[] r;
  public String[] s;
  public int t;
  private String v;
  private int w = -1;
  private boolean x;
  private boolean y;
  private long z;

  protected a()
  {
  }

  private a(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.v = paramParcel.readString();
    this.d = paramParcel.readString();
    this.w = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.x = bool1;
      if (paramParcel.readByte() == 0)
        break label288;
    }
    label288: for (boolean bool1 = bool2; ; bool1 = false)
    {
      this.y = bool1;
      this.g = paramParcel.readFloat();
      this.h = paramParcel.readInt();
      this.i = paramParcel.readInt();
      this.j = paramParcel.readString();
      this.z = paramParcel.readLong();
      this.A = paramParcel.readInt();
      this.B = paramParcel.readFloat();
      this.C = paramParcel.readInt();
      this.D = paramParcel.readString();
      this.p = paramParcel.readInt();
      this.k = paramParcel.readString();
      this.l = paramParcel.readString();
      this.m = paramParcel.readString();
      this.n = paramParcel.readInt();
      this.o = paramParcel.readString();
      this.q = paramParcel.readString();
      this.F = paramParcel.readLong();
      this.E = paramParcel.readLong();
      this.r = paramParcel.createStringArray();
      this.s = paramParcel.createStringArray();
      this.t = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }

  private a(String paramString1, int paramInt, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    this.m = paramString1;
    this.n = paramInt;
    this.o = paramString2;
    this.l = paramString3;
    this.a = paramJSONObject.optLong("id");
    this.b = paramJSONObject.optString("title");
    this.j = paramJSONObject.optString("source");
    this.f = paramJSONObject.optString("adUrl");
    this.c = paramJSONObject.optString("pkg");
    this.d = paramJSONObject.optString("shortDesc");
    this.v = paramJSONObject.optString("description");
    this.i = paramJSONObject.optInt("openType", -1);
    this.h = paramJSONObject.optInt("integral");
    this.g = ((float)paramJSONObject.optDouble("pts", 4.5D));
    this.B = ((float)paramJSONObject.optDouble("contentRating", 0.0D));
    this.C = paramJSONObject.optInt("label", 0);
    this.D = paramJSONObject.optString("cate");
    this.p = paramJSONObject.optInt("preClick");
    this.t = paramJSONObject.optInt("pp", 0);
    this.e = b(paramJSONObject.optJSONArray("images"));
    this.k = b(paramJSONObject.optJSONArray("bigImages"));
    this.q = paramJSONObject.optString("buttonDes");
    this.F = paramJSONObject.optLong("cacheTime", 120L);
    this.r = a(paramJSONObject.optJSONArray("impUrls"));
    this.s = a(paramJSONObject.optJSONArray("cUrls"));
  }

  public a(String paramString1, int paramInt, String paramString2, String paramString3, JSONObject paramJSONObject, long paramLong)
  {
    this(paramString1, paramInt, paramString2, paramString3, paramJSONObject);
    this.E = paramLong;
  }

  public static a a(JSONObject paramJSONObject)
  {
    a locala = new a();
    locala.G = paramJSONObject.optString("channel");
    locala.a = paramJSONObject.optLong("id");
    locala.b = paramJSONObject.optString("name");
    locala.c = paramJSONObject.optString("pkg");
    locala.v = paramJSONObject.optString("desc");
    locala.d = paramJSONObject.optString("sdesc");
    locala.w = paramJSONObject.optInt("pos");
    locala.i = paramJSONObject.optInt("opentype");
    locala.j = paramJSONObject.optString("urlsource");
    locala.e = paramJSONObject.optString("icon");
    locala.f = paramJSONObject.optString("playurl");
    locala.g = ((float)paramJSONObject.optDouble("pts"));
    locala.h = paramJSONObject.optInt("points");
    locala.z = paramJSONObject.optLong("down");
    locala.A = paramJSONObject.optInt("adtype");
    locala.B = ((float)paramJSONObject.optDouble("rating"));
    locala.l = paramJSONObject.optString("logId");
    locala.m = paramJSONObject.optString("license");
    locala.n = paramJSONObject.optInt("sid");
    locala.o = paramJSONObject.optString("sType", "native");
    locala.C = paramJSONObject.optInt("label");
    locala.p = paramJSONObject.optInt("preClick");
    locala.D = paramJSONObject.optString("cate");
    locala.r = a(paramJSONObject.optJSONArray("impUrls"));
    locala.s = a(paramJSONObject.optJSONArray("cUrls"));
    locala.t = paramJSONObject.optInt("pp", 0);
    return locala;
  }

  public static boolean a(a parama)
  {
    return parama.p > 0;
  }

  private static String[] a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int i2 = paramJSONArray.length();
      String[] arrayOfString2 = new String[i2];
      int i1 = 0;
      while (true)
      {
        arrayOfString1 = arrayOfString2;
        if (i1 >= i2)
          break label48;
        try
        {
          arrayOfString2[i1] = paramJSONArray.getString(i1);
          i1 += 1;
        }
        catch (JSONException paramJSONArray)
        {
          paramJSONArray.printStackTrace();
        }
      }
    }
    String[] arrayOfString1 = null;
    label48: return arrayOfString1;
  }

  private static String b(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
      return "";
    int i1 = 0;
    int i2 = paramJSONArray.length();
    while (i1 < i2)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i1);
      if (localJSONObject != null)
        return localJSONObject.optString("url", "");
      i1 += 1;
    }
    return "";
  }

  public static JSONObject b(a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("channel", parama.G);
    localJSONObject.put("id", parama.a);
    localJSONObject.put("name", parama.b);
    localJSONObject.put("pkg", parama.c);
    localJSONObject.put("desc", parama.v);
    localJSONObject.put("sdesc", parama.d);
    localJSONObject.put("pos", parama.w);
    localJSONObject.put("opentype", parama.i);
    localJSONObject.put("urlsource", parama.j);
    localJSONObject.put("icon", parama.e);
    localJSONObject.put("playurl", parama.f);
    localJSONObject.put("pts", parama.g);
    localJSONObject.put("points", parama.h);
    localJSONObject.put("down", parama.z);
    localJSONObject.put("adtype", parama.A);
    localJSONObject.put("rating", parama.B);
    localJSONObject.put("logId", parama.l);
    localJSONObject.put("license", parama.m);
    localJSONObject.put("sid", parama.n);
    localJSONObject.put("sType", parama.o);
    localJSONObject.put("label", parama.C);
    localJSONObject.put("preClick", parama.p);
    localJSONObject.put("cate", parama.D);
    localJSONObject.put("impUrls", parama.r);
    localJSONObject.put("cUrls", parama.s);
    localJSONObject.put("pp", parama.t);
    return localJSONObject;
  }

  public final boolean a()
  {
    return System.currentTimeMillis() - this.E <= this.F * 60L * 1000L;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        paramObject = (a)paramObject;
        if (this.c == null)
        {
          if (paramObject.c != null)
            return false;
        }
        else if (!this.c.equals(paramObject.c))
          return false;
        if (this.f != null)
          break;
      }
      while (paramObject.f == null);
      return false;
    }
    while (this.f.equals(paramObject.f));
    return false;
  }

  public final int hashCode()
  {
    int i2 = 0;
    int i1;
    if (this.c == null)
    {
      i1 = 0;
      if (this.f != null)
        break label39;
    }
    while (true)
    {
      return (i1 + 31) * 31 + i2;
      i1 = this.c.hashCode();
      break;
      label39: i2 = this.f.hashCode();
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.w);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    if (this.x)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.y)
        break label270;
    }
    label270: for (byte b1 = b2; ; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeFloat(this.g);
      paramParcel.writeInt(this.h);
      paramParcel.writeInt(this.i);
      paramParcel.writeString(this.j);
      paramParcel.writeLong(this.z);
      paramParcel.writeInt(this.A);
      paramParcel.writeFloat(this.B);
      paramParcel.writeInt(this.C);
      paramParcel.writeString(this.D);
      paramParcel.writeInt(this.p);
      paramParcel.writeString(this.k);
      paramParcel.writeString(this.l);
      paramParcel.writeString(this.m);
      paramParcel.writeInt(this.n);
      paramParcel.writeString(this.o);
      paramParcel.writeString(this.q);
      paramParcel.writeLong(this.F);
      paramParcel.writeLong(this.E);
      paramParcel.writeStringArray(this.r);
      paramParcel.writeStringArray(this.s);
      paramParcel.writeInt(this.t);
      return;
      b1 = 0;
      break;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.duapps.ad.a.a
 * JD-Core Version:    0.6.2
 */