package cmcm.com.myapplication.com.flurry.sdk;

import android.os.Build.VERSION;
import android.text.TextUtils;

public final class en extends ep
{
  private final int a;

  public en(String paramString, int paramInt)
  {
    super(a(paramString, paramInt));
    this.a = paramInt;
  }

  private static eq a(String paramString, int paramInt)
  {
    eq localeq = null;
    if (b(paramString, paramInt))
      localeq = eo.a(paramString);
    return localeq;
  }

  private static boolean b(String paramString, int paramInt)
  {
    return (!TextUtils.isEmpty(paramString)) && (Build.VERSION.SDK_INT >= paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.en
 * JD-Core Version:    0.6.2
 */