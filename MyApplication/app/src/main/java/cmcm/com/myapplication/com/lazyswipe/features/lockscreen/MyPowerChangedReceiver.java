package cmcm.com.myapplication.com.lazyswipe.features.lockscreen;

import android.content.Context;
import ui;
import uk;

public class MyPowerChangedReceiver extends uk
{
  protected ui b(Context paramContext)
  {
    return new ui()
    {
      public void a()
      {
        ChargingActivity.c();
      }

      public boolean a(int paramAnonymousInt)
      {
        return ChargingActivity.a(paramAnonymousInt);
      }
    };
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.lockscreen.MyPowerChangedReceiver
 * JD-Core Version:    0.6.2
 */