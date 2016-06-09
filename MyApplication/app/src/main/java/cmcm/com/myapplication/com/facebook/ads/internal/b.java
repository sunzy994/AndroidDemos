package cmcm.com.myapplication.com.facebook.ads.internal;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.r;

public class b
{
  private final AdErrorType a;
  private final String b;

  public b(AdErrorType paramAdErrorType, String paramString)
  {
    String str = paramString;
    if (r.a(paramString))
      str = paramAdErrorType.getDefaultErrorMessage();
    this.a = paramAdErrorType;
    this.b = str;
  }

  public AdErrorType a()
  {
    return this.a;
  }

  public AdError b()
  {
    if (this.a.a())
      return new AdError(this.a.getErrorCode(), this.b);
    return new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.b
 * JD-Core Version:    0.6.2
 */