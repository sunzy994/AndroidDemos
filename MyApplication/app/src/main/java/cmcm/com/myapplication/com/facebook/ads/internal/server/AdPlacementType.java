package cmcm.com.myapplication.com.facebook.ads.internal.server;

import com.facebook.ads.internal.util.r;
import java.util.Locale;

public enum AdPlacementType
{
  private String a;

  private AdPlacementType(String paramString)
  {
    this.a = paramString;
  }

  public static AdPlacementType fromString(String paramString)
  {
    if (r.a(paramString))
      return UNKNOWN;
    try
    {
      paramString = valueOf(paramString.toUpperCase(Locale.US));
      return paramString;
    }
    catch (Exception paramString)
    {
    }
    return UNKNOWN;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.server.AdPlacementType
 * JD-Core Version:    0.6.2
 */