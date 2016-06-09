package cmcm.com.myapplication.com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;

public abstract interface IADI
{
  public abstract void closePopupWindow();

  public abstract void destory();

  public abstract void loadAd();

  public abstract void setAdListener(ADListener paramADListener);

  public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy);

  public abstract void show();

  public abstract void show(Activity paramActivity);

  public abstract void showAsPopupWindown();

  public abstract void showAsPopupWindown(Activity paramActivity);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.pi.IADI
 * JD-Core Version:    0.6.2
 */