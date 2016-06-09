package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import aho;
import ahv;
import ahw;
import ahx;
import ahz;
import aia;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class OnlineThemeEntity
  implements ahv, Parcelable
{
  public static final Creator<OnlineThemeEntity> CREATOR = new Creator()
  {
    public OnlineThemeEntity a(Parcel paramAnonymousParcel)
    {
      return new OnlineThemeEntity(paramAnonymousParcel);
    }

    public OnlineThemeEntity[] a(int paramAnonymousInt)
    {
      return new OnlineThemeEntity[paramAnonymousInt];
    }
  };
  public String a;
  public String b;
  public String c;
  public List<String> d;
  public int e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public int s;
  public int t;

  protected OnlineThemeEntity(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.createStringArrayList();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
  }

  public OnlineThemeEntity(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return;
    this.a = paramJSONObject.optString("id");
    this.b = paramJSONObject.optString("name");
    this.c = paramJSONObject.optString("author");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("previews");
    if (localJSONArray != null)
    {
      this.d = new ArrayList();
      int i1 = 0;
      while (i1 < localJSONArray.length())
      {
        this.d.add(localJSONArray.optString(i1));
        i1 += 1;
      }
    }
    this.e = paramJSONObject.optInt("downloads");
    this.f = paramJSONObject.optString("versionCode");
    this.g = paramJSONObject.optString("versionName");
    this.h = paramJSONObject.optString("from");
    this.i = paramJSONObject.optString("pkg");
    this.j = paramJSONObject.optString("code");
    this.k = paramJSONObject.optString("checksum");
    this.l = paramJSONObject.optString("file");
    this.m = paramJSONObject.optString("len");
    this.n = paramJSONObject.optString("cover");
    this.o = paramJSONObject.optString("publishTime");
    this.p = paramJSONObject.optString("publishType");
    this.q = paramJSONObject.optString("desc");
    this.s = paramJSONObject.optInt("isZip");
    this.r = paramJSONObject.optString("color");
    this.t = paramJSONObject.optInt("originType");
  }

  public String J()
  {
    return this.n;
  }

  public String K()
  {
    return this.b;
  }

  public boolean L()
  {
    return this.j.equals(ahx.a(SwipeApplication.c()));
  }

  public List M()
  {
    return this.d;
  }

  public String N()
  {
    return this.j;
  }

  public ahw a()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (b())
      return new aho(localSwipeApplication, this.j, this.b);
    if (g())
      return new ahz(localSwipeApplication, this.j, this.b);
    return new aia(localSwipeApplication, this.j, this.b);
  }

  public boolean b()
  {
    return this.j.startsWith("com.hola.launcher.theme.");
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean g()
  {
    return this.t == 2;
  }

  public int i()
  {
    try
    {
      int i1 = Color.parseColor(this.r);
      return i1;
    }
    catch (Exception localException)
    {
    }
    return SwipeApplication.c().getResources().getColor(2131689549);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeStringList(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.OnlineThemeEntity
 * JD-Core Version:    0.6.2
 */