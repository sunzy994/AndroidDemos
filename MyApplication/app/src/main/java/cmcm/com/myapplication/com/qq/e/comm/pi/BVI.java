package cmcm.com.myapplication.com.qq.e.comm.pi;

import android.view.View;
import com.qq.e.comm.adevent.ADListener;

public abstract interface BVI
{
  public abstract void destroy();

  public abstract void fetchAd();

  public abstract View getView();

  public abstract void setAdListener(ADListener paramADListener);

  public abstract void setDownAPPConfirmPolicy(int paramInt);

  public abstract void setRefresh(int paramInt);

  public abstract void setRollAnimation(int paramInt);

  public abstract void setShowCloseButton(boolean paramBoolean);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.pi.BVI
 * JD-Core Version:    0.6.2
 */