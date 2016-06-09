package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import com.lazyswipe.SwipeApplication;

public class afr
  implements ws
{
  private static afr b;
  private final String a = "Swipe." + afr.class.getSimpleName();
  private Intent c = new Intent("com.holaverse.common.POWER_CONNECTED");

  public static afr a()
  {
    try
    {
      if (b == null)
        b = new afr();
      return b;
    }
    finally
    {
    }
  }

  public void a(ComponentName paramComponentName)
  {
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      SwipeApplication.c().sendBroadcast(this.c);
  }

  public void b(ComponentName paramComponentName)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afr
 * JD-Core Version:    0.6.2
 */