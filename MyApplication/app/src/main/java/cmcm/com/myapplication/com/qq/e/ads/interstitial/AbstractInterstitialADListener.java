package cmcm.com.myapplication.com.qq.e.ads.interstitial;

import com.qq.e.comm.util.GDTLogger;

public abstract class AbstractInterstitialADListener
  implements InterstitialADListener
{
  public void onADClicked()
  {
    GDTLogger.i("ON InterstitialAD Clicked");
  }

  public void onADClosed()
  {
    GDTLogger.i("ON InterstitialAD Closed");
  }

  public void onADExposure()
  {
    GDTLogger.i("ON InterstitialAD Exposure");
  }

  public void onADLeftApplication()
  {
    GDTLogger.i("ON InterstitialAD LeftApplication");
  }

  public void onADOpened()
  {
    GDTLogger.i("ON InterstitialAD Opened");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.interstitial.AbstractInterstitialADListener
 * JD-Core Version:    0.6.2
 */