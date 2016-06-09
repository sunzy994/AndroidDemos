package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import org.json.JSONObject;

public class ajl
{
  public final String a;
  public int b;
  public String c;
  public String d;
  public long e;
  public String f;
  public final String g;
  public String h;
  public boolean i = false;
  public final boolean j = true;
  public String k;
  public String l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  private final Context s;

  public ajl(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.g = paramString2;
    this.s = paramContext.getApplicationContext();
  }

  private static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject == null)
      return paramInt;
    try
    {
      int i1 = Color.parseColor(paramJSONObject.getString(paramString));
      return i1;
    }
    catch (Exception paramJSONObject)
    {
    }
    return paramInt;
  }

  public static ajl a(Context paramContext)
  {
    try
    {
      paramContext = a(paramContext, vs.a(paramContext, "PREF_LAST_UPGRADE_INFO", ""));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e(ajm.a, "", paramContext);
    }
    return null;
  }

  public static ajl a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0));
    do
    {
      return null;
      paramString = new JSONObject(paramString);
    }
    while ((paramString == null) || (paramString.length() <= 0) || (!paramString.optBoolean("needUpdate", false)));
    paramContext = new ajl(paramContext, paramContext.getString(2131230782), "com.lazyswipe");
    paramContext.b = paramString.optInt("versionNumber", 0);
    paramContext.c = paramString.optString("versionName");
    paramContext.d = paramString.optString("downUrl");
    paramContext.h = paramString.optString("checksum");
    paramContext.f = paramString.optString("instruction");
    paramContext.e = paramString.optLong("fileSize");
    paramContext.i = paramString.optBoolean("forceUpdate", false);
    paramContext.k = paramString.optString("instruction");
    JSONObject localJSONObject = paramString.optJSONObject("display");
    paramContext.l = a(localJSONObject, "previewImg", "");
    paramContext.m = a(localJSONObject, "bgColor", 7575781);
    paramContext.n = a(localJSONObject, "txtColor", 16777215);
    paramContext.o = a(localJSONObject, "highlightBtnColor", 16777215);
    paramContext.p = a(localJSONObject, "highlightTxtColor", 7575781);
    paramContext.q = a(localJSONObject, "closeBtnColor", 16777215);
    paramContext.r = paramString.optInt("upgradePercentage", 93);
    return paramContext;
  }

  private String a(int paramInt)
  {
    return "#" + Integer.toHexString(paramInt);
  }

  private static String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject == null)
      return paramString2;
    try
    {
      paramJSONObject = paramJSONObject.optString(paramString1);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
    }
    return paramString2;
  }

  public static void b(Context paramContext)
  {
    vs.b(paramContext, "PREF_LAST_UPGRADE_INFO", "");
  }

  private Pair<Integer, Long> m()
  {
    Object localObject = vs.a(this.s, "PREF_UPGRADE_NOTIFY_TIME", "");
    try
    {
      localObject = ((String)localObject).split("_");
      localObject = Pair.create(Integer.valueOf(Integer.parseInt(localObject[0])), Long.valueOf(Long.parseLong(localObject[1])));
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String a()
  {
    return this.a + this.c + ".apk";
  }

  public File b()
  {
    return new File(aro.a("upgrade/"), a());
  }

  public String c()
  {
    return this.s.getString(2131231163) + " " + this.c;
  }

  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.f))
      localStringBuilder.append(this.f.replace("\r\n", "\n"));
    while (true)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.s.getString(2131230913));
    }
  }

  public boolean e()
  {
    return this.b > 22500;
  }

  public boolean f()
  {
    if ((!asq.c(this.s, "com.android.vending")) && (!TextUtils.isEmpty(this.d)) && (TextUtils.isEmpty(this.h)));
    return false;
  }

  public void g()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("needUpdate", true);
      localJSONObject1.put("versionNumber", this.b);
      localJSONObject1.put("versionName", this.c);
      localJSONObject1.put("downUrl", this.d);
      localJSONObject1.put("checksum", this.h);
      localJSONObject1.put("instruction", this.f);
      localJSONObject1.put("fileSize", this.e);
      localJSONObject1.put("forceUpdate", this.i);
      localJSONObject1.put("instruction", this.k);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("previewImg", this.l);
      localJSONObject2.put("bgColor", a(this.m));
      localJSONObject2.put("txtColor", a(this.n));
      localJSONObject2.put("highlightBtnColor", a(this.o));
      localJSONObject2.put("highlightTxtColor", a(this.p));
      localJSONObject2.put("closeBtnColor", a(this.q));
      localJSONObject1.put("display", localJSONObject2);
      vs.b(this.s, "PREF_LAST_UPGRADE_INFO", localJSONObject1.toString());
      localJSONObject1.put("upgradePercentage", this.r);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public String h()
  {
    return arh.a(this.l) + ".png";
  }

  public File i()
  {
    return new File(aro.a("upgrade/"), h());
  }

  public boolean j()
  {
    ato localato = new ato(i(), this.l, true);
    return atn.a(this.s, localato);
  }

  public long k()
  {
    Pair localPair = m();
    if ((localPair != null) && (((Integer)localPair.first).intValue() == this.b))
      return ((Long)localPair.second).longValue();
    return -1L;
  }

  public void l()
  {
    vs.b(this.s, "PREF_UPGRADE_NOTIFY_TIME", this.b + "_" + System.currentTimeMillis());
  }

  public String toString()
  {
    try
    {
      String str = "UpgradeApkInfo[" + "appName = " + this.a + ", versionCode = " + this.b + ", versionName = " + this.c + ", url = " + this.d + ", releaseNotes = " + this.f + ", isForceUpgrade = " + this.i + ", shouldUpgrade = " + e() + ", getLastNotifyTime = " + k() + ", instruction = " + this.k + ", previewImg = " + this.l + ", bgColor = " + a(this.m) + ", txtColor = " + a(this.n) + ", highlightBtnColor = " + a(this.o) + ", highlightTxtColor = " + a(this.p) + "]";
      return str;
    }
    catch (Exception localException)
    {
    }
    return super.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajl
 * JD-Core Version:    0.6.2
 */