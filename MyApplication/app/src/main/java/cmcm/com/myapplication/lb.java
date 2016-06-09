package cmcm.com.myapplication;

import android.text.TextUtils;

public class lb
{
  public static final lb a = new lb(1000, "Network Error");
  public static final lb b = new lb(1001, "No Fill");
  public static final lb c = new lb(1002, "Ad was re-loaded too frequently");
  public static final lb d = new lb(2000, "Server Error");
  public static final lb e = new lb(2001, "Internal Error");
  public static final lb f = new lb(3000, "Time Out");
  public static final lb g = new lb(3001, "unknow error");
  public static final lb h = new lb(2002, "Native ad failed to load due to missing properties");
  private final int i;
  private final String j;

  public lb(int paramInt, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "unknown error";
    this.i = paramInt;
    this.j = str;
  }

  public int a()
  {
    return this.i;
  }

  public String b()
  {
    return this.j;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lb
 * JD-Core Version:    0.6.2
 */