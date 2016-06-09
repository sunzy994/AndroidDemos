package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import java.util.Locale;

public enum f
{
  public static f a(String paramString)
  {
    if (paramString == null)
      return a;
    try
    {
      paramString = (f)Enum.valueOf(f.class, paramString.toUpperCase(Locale.getDefault()));
      return paramString;
    }
    catch (Exception paramString)
    {
    }
    return a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.f
 * JD-Core Version:    0.6.2
 */