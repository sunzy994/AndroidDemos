package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

class abi
{
  public final String a;
  public String b;
  public String c;
  public String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public String k;
  public final String l;

  private abi(abh paramabh, Context paramContext, JSONObject paramJSONObject, int paramInt)
  {
    this.a = paramJSONObject.optString("id");
    this.b = paramJSONObject.optString("clkUrl");
    if (!TextUtils.isEmpty(this.b))
      this.b = abf.a(paramContext, this.b, paramInt);
    this.c = paramJSONObject.optString("impUrl");
    if (!TextUtils.isEmpty(this.c))
      this.c = abf.a(paramContext, this.c, paramInt);
    this.d = paramJSONObject.optString("icon");
    if (!TextUtils.isEmpty(this.d))
      this.d = abf.a(paramContext, this.d, paramInt);
    this.e = abf.a(paramContext, paramJSONObject.optString("img"), paramInt);
    this.f = paramJSONObject.optString("title");
    this.h = paramJSONObject.optString("text");
    this.i = paramJSONObject.optString("cta");
    this.g = paramJSONObject.optString("rating");
    this.j = paramJSONObject.optString("packageName");
    this.l = (aro.a(abh.a(paramabh)) + arh.a(this.e));
    if (!TextUtils.isEmpty(this.d))
    {
      this.d = abf.a(paramContext, this.d, paramInt);
      this.k = (aro.a(abh.a(paramabh)) + arh.a(this.d));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abi
 * JD-Core Version:    0.6.2
 */