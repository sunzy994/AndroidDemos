package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class aji extends BroadcastReceiver
{
  private static final String a = "Swipe." + aji.class.getSimpleName();
  private boolean b;

  public static void b(Context paramContext)
  {
    Intent localIntent = new Intent("theme_changed");
    localIntent.setPackage("com.lazyswipe");
    paramContext.sendBroadcast(localIntent);
  }

  public void a(Context paramContext)
  {
  }

  public void c(Context paramContext)
  {
    if (this.b)
      return;
    try
    {
      this.b = true;
      paramContext.registerReceiver(this, new IntentFilter("theme_changed"));
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public void d(Context paramContext)
  {
    if (!this.b)
      return;
    try
    {
      this.b = false;
      paramContext.unregisterReceiver(this);
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
      return;
    paramIntent = paramIntent.getAction();
    int i = -1;
    switch (paramIntent.hashCode())
    {
    default:
    case 748987966:
    }
    while (true)
    {
      switch (i)
      {
      default:
        return;
      case 0:
      }
      a(paramContext);
      return;
      if (paramIntent.equals("theme_changed"))
        i = 0;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aji
 * JD-Core Version:    0.6.2
 */