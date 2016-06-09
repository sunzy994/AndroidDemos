package cmcm.com.myapplication.com.lazyswipe.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UiReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    label9: int i;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        i = -1;
        switch (paramContext.hashCode())
        {
        default:
        case -1072644092:
        }
      }
    }
    while (true)
      switch (i)
      {
      default:
        return;
        paramContext = null;
        break label9;
        if (paramContext.equals("com.lazyswipe.action.ACTION_ENABLE_SWIPE"))
          i = 0;
        break;
      case 0:
      }
    MainActivity.a(paramIntent.getIntExtra("param_1", 0), true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.UiReceiver
 * JD-Core Version:    0.6.2
 */