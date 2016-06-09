package cmcm.com.myapplication.com.lazyswipe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import asp;
import wm;

public class PackageReceiver extends BroadcastReceiver
{
  private static final String a = "Swipe." + PackageReceiver.class.getSimpleName();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    SwipeApplication localSwipeApplication = (SwipeApplication)paramContext.getApplicationContext();
    wm localwm = localSwipeApplication.a(false);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder().append("Action received: ").append(paramIntent.getAction()).append("; model is running? ");
    if (localwm != null)
      bool = true;
    asp.a(str, bool);
    if (localwm != null)
      return;
    localSwipeApplication.a().onReceive(paramContext, paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.PackageReceiver
 * JD-Core Version:    0.6.2
 */