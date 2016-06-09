package cmcm.com.myapplication.com.qq.e.ads.nativ;

import java.util.List;

public abstract interface NativeAD$NativeAdListener
{
  public abstract void onADLoaded(List<NativeADDataRef> paramList);

  public abstract void onADStatusChanged(NativeADDataRef paramNativeADDataRef);

  public abstract void onNoAD(int paramInt);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.nativ.NativeAD.NativeAdListener
 * JD-Core Version:    0.6.2
 */