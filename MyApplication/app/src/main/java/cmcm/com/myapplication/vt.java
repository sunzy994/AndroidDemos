package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.lazyswipe.SwipeService;

public final class vt extends BroadcastReceiver
{
  public vt(SwipeService paramSwipeService)
  {
  }

  private void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("state");
    asp.a("Swipe.Service", "Phone state changed: " + paramIntent);
    if (TelephonyManager.EXTRA_STATE_RINGING.equals(paramIntent))
    {
      SwipeService.a(this.a, true);
      yb.e(true);
      if (!this.a.e.i())
        this.a.e.d();
    }
    do
    {
      do
        return;
      while (!TelephonyManager.EXTRA_STATE_IDLE.equals(paramIntent));
      SwipeService.a(this.a, false);
    }
    while (this.a.e.i());
    SwipeService.b(this.a);
  }

  private void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("reason");
    asp.a("Swipe.Service", "Closing system dialogs, reason: " + paramIntent);
    if (TextUtils.isEmpty(paramIntent))
      return;
    int i = -1;
    switch (paramIntent.hashCode())
    {
    default:
    case 1092716832:
    case 350448461:
    }
    while (true)
      switch (i)
      {
      default:
        return;
      case 0:
        ci.a(this.a).a(new Intent("BROADCAST_ACTION_HOME_KEY"));
        yb.e(true);
        return;
        if (paramIntent.equals("homekey"))
        {
          i = 0;
          continue;
          if (paramIntent.equals("recentapps"))
            i = 1;
        }
        break;
      case 1:
      }
    yb.e(true);
  }

  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    this.a.registerReceiver(this, localIntentFilter);
  }

  public void b()
  {
    this.a.unregisterReceiver(this);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext))
      return;
    int i = -1;
    switch (paramContext.hashCode())
    {
    default:
    case -1326089125:
    case -403228793:
    }
    while (true)
      switch (i)
      {
      default:
        return;
      case 0:
        a(paramIntent);
        return;
        if (paramContext.equals("android.intent.action.PHONE_STATE"))
        {
          i = 0;
          continue;
          if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
            i = 1;
        }
        break;
      case 1:
      }
    b(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vt
 * JD-Core Version:    0.6.2
 */