package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Time;
import java.util.Date;
import org.json.JSONObject;

public class akw
{
  private Date a;
  private final String b;
  private String c;
  private String d;
  private int e;
  private String f;
  private int g;
  private String h;
  private boolean i;

  public akw(String paramString1, Date paramDate, String paramString2, String paramString3, Integer paramInteger1, String paramString4, Integer paramInteger2, String paramString5)
  {
    this.b = paramString1;
    this.a = paramDate;
    this.c = paramString3;
    this.d = paramString2;
    this.e = paramInteger1.intValue();
    this.f = paramString4;
    this.g = paramInteger2.intValue();
    this.h = paramString5;
  }

  public static akw a(JSONObject paramJSONObject)
  {
    akw localakw = new akw(paramJSONObject.optString("unitTemperature", "C"), new Date(paramJSONObject.getLong("date")), paramJSONObject.optString("lowTemperature", ""), paramJSONObject.optString("highTemperature", ""), Integer.valueOf(paramJSONObject.optInt("imageId", -1)), paramJSONObject.optString("weatherDesc", ""), Integer.valueOf(paramJSONObject.optInt("nightImageId", -1)), paramJSONObject.optString("nightWeatherDesc", ""));
    localakw.i = paramJSONObject.optBoolean("isRealtime");
    return localakw;
  }

  public String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(this.c))
      return akc.a(akc.a(paramContext, this.c, this.b));
    return this.c;
  }

  public Date a()
  {
    return this.a;
  }

  public String b(Context paramContext)
  {
    if (!TextUtils.isEmpty(this.d))
      return akc.a(akc.a(paramContext, this.d, this.b));
    return this.d;
  }

  public boolean b()
  {
    return asq.a(new Date(), this.a) == 0;
  }

  public int c()
  {
    return this.e;
  }

  public String c(Context paramContext)
  {
    if (this.f != null)
      return this.f;
    return akc.a(paramContext, this.e);
  }

  public String d(Context paramContext)
  {
    if (this.h != null)
      return this.h;
    return akc.a(paramContext, this.g);
  }

  public boolean d()
  {
    return this.i;
  }

  public int e()
  {
    if ((this.e < 0) && (this.g >= 0))
      return this.g;
    if ((this.e >= 0) && (this.g < 0))
      return this.e;
    Time localTime = new Time();
    localTime.setToNow();
    if (akv.a(localTime.hour) == akv.b)
      return this.e;
    return this.g;
  }

  public String e(Context paramContext)
  {
    String str = a(paramContext);
    paramContext = b(paramContext);
    Time localTime = new Time();
    localTime.setToNow();
    if (akv.a(localTime.hour) == akv.b)
      return str;
    return paramContext;
  }

  public JSONObject f()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("unitTemperature", this.b);
    localJSONObject.putOpt("date", Long.valueOf(this.a.getTime()));
    localJSONObject.putOpt("lowTemperature", this.d);
    localJSONObject.putOpt("highTemperature", this.c);
    localJSONObject.putOpt("imageId", Integer.valueOf(this.e));
    localJSONObject.putOpt("weatherDesc", this.f);
    localJSONObject.putOpt("nightImageId", Integer.valueOf(this.g));
    localJSONObject.putOpt("nightWeatherDesc", this.h);
    localJSONObject.putOpt("isRealtime", Boolean.valueOf(this.i));
    return localJSONObject;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akw
 * JD-Core Version:    0.6.2
 */