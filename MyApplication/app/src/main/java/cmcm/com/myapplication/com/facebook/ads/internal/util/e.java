package cmcm.com.myapplication.com.facebook.ads.internal.util;

import java.util.Locale;

public enum e
{
  public static e a(String paramString)
  {
    if (r.a(paramString))
      return a;
    try
    {
      paramString = valueOf(paramString.toUpperCase(Locale.US));
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
    }
    return a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.e
 * JD-Core Version:    0.6.2
 */