package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;

public class afq extends aqv
{
  private static long b = -1L;

  public boolean a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if ((!e(paramContext).exists()) && (l - b > 600000L));
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
        b = l;
      return bool;
    }
  }

  public String b(Context paramContext)
  {
    return "amap1";
  }

  public String c(Context paramContext)
  {
    return "http://d.holalauncher.com/sdk/" + b(paramContext) + ".json";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afq
 * JD-Core Version:    0.6.2
 */