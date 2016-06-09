package cmcm.com.myapplication.com.qq.e.ads.splash;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.GDTLogger;

class SplashAD$ADListenerAdapter
  implements ADListener
{
  private SplashAD$ADListenerAdapter(SplashAD paramSplashAD)
  {
  }

  public void onADEvent(ADEvent paramADEvent)
  {
    if (SplashAD.a(this.a) == null)
    {
      GDTLogger.e("SplashADListener == null");
      return;
    }
    switch (paramADEvent.getType())
    {
    default:
      return;
    case 1:
      SplashAD.a(this.a).onADDismissed();
      return;
    case 2:
      if ((paramADEvent.getParas().length == 1) && ((paramADEvent.getParas()[0] instanceof Integer)))
      {
        SplashAD.a(this.a).onNoAD(((Integer)paramADEvent.getParas()[0]).intValue());
        return;
      }
      GDTLogger.e("Splash ADEvent error,");
      return;
    case 3:
    }
    SplashAD.a(this.a).onADPresent();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.splash.SplashAD.ADListenerAdapter
 * JD-Core Version:    0.6.2
 */