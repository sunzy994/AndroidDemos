package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

public class jq
{
  private static jq a = new jq();
  private Map<String, Object> b = new HashMap();
  private boolean c;
  private boolean d;
  private String e;
  private boolean f;

  public static jq a()
  {
    return a;
  }

  public String a(Context paramContext)
  {
    if (this.e != null)
      return this.e;
    return paramContext.getSharedPreferences("appsflyer-data", 0).getString("referrer", null);
  }

  public void a(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    this.b.put(paramString, Boolean.toString(paramBoolean));
  }

  public String[] a(String paramString)
  {
    return (String[])this.b.get(paramString);
  }

  public String b(String paramString)
  {
    return (String)this.b.get(paramString);
  }

  protected void b()
  {
    this.c = true;
  }

  public boolean b(String paramString, boolean paramBoolean)
  {
    paramString = b(paramString);
    if (paramString == null)
      return paramBoolean;
    return Boolean.valueOf(paramString).booleanValue();
  }

  protected void c(String paramString)
  {
    this.e = paramString;
  }

  protected boolean c()
  {
    return this.d;
  }

  protected void d()
  {
    this.d = true;
  }

  public boolean e()
  {
    return this.f;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jq
 * JD-Core Version:    0.6.2
 */