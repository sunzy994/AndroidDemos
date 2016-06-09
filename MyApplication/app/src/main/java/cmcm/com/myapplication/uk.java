package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.holaverse.charging.model.Battery;

public abstract class uk extends uc
{
  public void a(Context paramContext, int paramInt)
  {
    uo.a("startView from batteryActivity");
    uh.a(paramContext, b(paramContext), paramInt);
  }

  public IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
    localIntentFilter.addAction("com.holaverse.common.POWER_CONNECTED");
    return localIntentFilter;
  }

  public abstract ui b(Context paramContext);

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.ACTION_POWER_CONNECTED".equals(paramIntent))
      a(paramContext, 1);
    do
    {
      do
        return;
      while (!"com.holaverse.common.POWER_CONNECTED".equals(paramIntent));
      paramIntent = ue.b(paramContext.getApplicationContext());
    }
    while ((paramIntent == null) || (!paramIntent.a()));
    a(paramContext, 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uk
 * JD-Core Version:    0.6.2
 */