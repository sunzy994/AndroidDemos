package cmcm.com.myapplication.com.flurry.sdk;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class eo
{
  private static final String a = eo.class.getSimpleName();

  public static eq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      eq localeq = (eq)Class.forName(paramString).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      paramString = localeq;
      return paramString;
    }
    catch (Exception localException)
    {
      while (true)
      {
        el.a(5, a, "FlurryModule " + paramString + " is not available:", localException);
        paramString = null;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.eo
 * JD-Core Version:    0.6.2
 */