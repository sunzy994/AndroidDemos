package cmcm.com.myapplication.com.facebook.ads.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class h$c extends BroadcastReceiver
{
  private h$c(h paramh)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
      h.i(this.a);
    while (!"android.intent.action.SCREEN_ON".equals(paramContext))
      return;
    h.b(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.h.c
 * JD-Core Version:    0.6.2
 */