package cmcm.com.myapplication.com.qq.e.comm.pi;

import android.view.View;
import com.qq.e.ads.appwall.GridAPPWallListener;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;

public abstract interface GWI
{
  public abstract GridAPPWallListener getAdListener();

  public abstract void setAdListener(GridAPPWallListener paramGridAPPWallListener);

  public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy);

  public abstract void show();

  public abstract void showRelativeTo(int paramInt1, int paramInt2);

  public abstract void showRelativeTo(View paramView);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.pi.GWI
 * JD-Core Version:    0.6.2
 */