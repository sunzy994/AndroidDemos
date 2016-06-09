package cmcm.com.myapplication.com.qq.e.ads.nativ;

import android.view.View;

public abstract interface NativeADDataRef
{
  public abstract double getAPPPrice();

  public abstract int getAPPScore();

  public abstract int getAPPStatus();

  public abstract String getDesc();

  public abstract long getDownloadCount();

  public abstract String getIconUrl();

  public abstract String getImgUrl();

  public abstract int getProgress();

  public abstract String getTitle();

  public abstract boolean isAPP();

  public abstract void onClicked(View paramView);

  public abstract void onExposured(View paramView);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.nativ.NativeADDataRef
 * JD-Core Version:    0.6.2
 */