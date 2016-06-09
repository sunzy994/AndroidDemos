package cmcm.com.myapplication.com.qq.e.ads.nativ;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;

class NativeAD$ADListenerAdapter
  implements ADListener
{
  private NativeAD$ADListenerAdapter(NativeAD paramNativeAD)
  {
  }

  public void onADEvent(ADEvent paramADEvent)
  {
    if (NativeAD.d(this.a) == null)
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
        NativeAD.d(this.a).onNoAD(((Integer)paramADEvent.getParas()[0]).intValue());
        return;
      }
      GDTLogger.e("AdEvent.Paras error for NativeAD(" + paramADEvent + ")");
      return;
    case 2:
      if ((paramADEvent.getParas().length == 1) && ((paramADEvent.getParas()[0] instanceof List)))
      {
        NativeAD.d(this.a).onADLoaded((List)paramADEvent.getParas()[0]);
        return;
      }
      GDTLogger.e("ADEvent.Paras error for NativeAD(" + paramADEvent + ")");
      return;
    case 3:
    }
    if ((paramADEvent.getParas().length == 1) && ((paramADEvent.getParas()[0] instanceof NativeADDataRef)))
    {
      NativeAD.d(this.a).onADStatusChanged((NativeADDataRef)paramADEvent.getParas()[0]);
      return;
    }
    GDTLogger.e("ADEvent.Paras error for NativeAD(" + paramADEvent + ")");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.nativ.NativeAD.ADListenerAdapter
 * JD-Core Version:    0.6.2
 */