package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;

public abstract class asd
{
  public abstract String a(Context paramContext, String paramString);

  public String a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(a(paramContext, paramString1, paramBoolean), paramString2);
  }

  public abstract String a(Context paramContext, String paramString, boolean paramBoolean);

  protected String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString2))
        str = String.format(paramString1, new Object[] { paramString2 });
    }
    return str;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asd
 * JD-Core Version:    0.6.2
 */