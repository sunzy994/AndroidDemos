package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.holaverse.charging.model.Battery;

class uf extends uc
{
  uf(ue paramue)
  {
  }

  public IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
    localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
    localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
    localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
    return localIntentFilter;
  }

  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    new Thread()
    {
      public void run()
      {
        Object localObject = paramIntent.getAction();
        if ("android.intent.action.BATTERY_CHANGED".equals(localObject))
        {
          localObject = ue.a(paramIntent);
          uf.this.a.a((Battery)localObject);
        }
        do
        {
          return;
          if ("android.intent.action.BATTERY_LOW".equals(localObject))
          {
            uf.this.a.a(0);
            return;
          }
          if ("android.intent.action.BATTERY_OKAY".equals(localObject))
          {
            uf.this.a.a(1);
            return;
          }
          if ("android.intent.action.ACTION_POWER_CONNECTED".equals(localObject))
          {
            uf.this.a.c();
            return;
          }
        }
        while (!"android.intent.action.ACTION_POWER_DISCONNECTED".equals(localObject));
        uf.this.a.d();
      }
    }
    .start();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uf
 * JD-Core Version:    0.6.2
 */