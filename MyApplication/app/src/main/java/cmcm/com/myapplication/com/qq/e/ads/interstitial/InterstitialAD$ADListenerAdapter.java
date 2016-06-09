package cmcm.com.myapplication.com.qq.e.ads.interstitial;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.GDTLogger;

class InterstitialAD$ADListenerAdapter
  implements ADListener
{
  private InterstitialAD$ADListenerAdapter(InterstitialAD paramInterstitialAD)
  {
  }

  public void onADEvent(ADEvent paramADEvent)
  {
    if (InterstitialAD.c(this.a) == null)
    {
      GDTLogger.i("No DevADListener Binded");
      return;
    }
    switch (paramADEvent.getType())
    {
    default:
      return;
    case 1:
      if ((paramADEvent.getParas().length == 1) && ((paramADEvent.getParas()[0] instanceof Integer)))
      {
        InterstitialAD.c(this.a).onNoAD(((Integer)paramADEvent.getParas()[0]).intValue());
        return;
      }
      GDTLogger.e("AdEvent.Paras error for Banner(" + paramADEvent + ")");
      return;
    case 2:
      InterstitialAD.c(this.a).onADReceive();
      return;
    case 3:
      InterstitialAD.c(this.a).onADExposure();
      return;
    case 4:
      InterstitialAD.c(this.a).onADOpened();
      return;
    case 5:
      InterstitialAD.c(this.a).onADClicked();
      return;
    case 6:
      InterstitialAD.c(this.a).onADLeftApplication();
      return;
    case 7:
    }
    InterstitialAD.c(this.a).onADClosed();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.interstitial.InterstitialAD.ADListenerAdapter
 * JD-Core Version:    0.6.2
 */