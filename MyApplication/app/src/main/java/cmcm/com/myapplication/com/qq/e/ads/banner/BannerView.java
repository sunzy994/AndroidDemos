package cmcm.com.myapplication.com.qq.e.ads.banner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.qq.e.ads.cfg.BannerRollAnimation;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.BVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.ExecutorService;

@SuppressLint({"ViewConstructor"})
public class BannerView extends FrameLayout
{
  private BVI a;
  private BannerADListener b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private Integer f;
  private BannerRollAnimation g;
  private DownAPPConfirmPolicy h;
  private Boolean i;
  private volatile int j = 0;

  public BannerView(final Activity paramActivity, final ADSize paramADSize, final String paramString1, final String paramString2)
  {
    super(paramActivity);
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)) || (paramActivity == null))
    {
      GDTLogger.e(String.format("Banner ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[] { paramString1, paramString2, paramActivity }));
      return;
    }
    this.c = true;
    if (!a.a(paramActivity))
    {
      GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
      return;
    }
    this.d = true;
    setLayoutParams(new LayoutParams(-1, -2));
    GDTADManager.INIT_EXECUTOR.execute(new Runnable()
    {
      public void run()
      {
        if (GDTADManager.getInstance().initWith(paramActivity, paramString1))
          try
          {
            final POFactory localPOFactory = GDTADManager.getInstance().getPM().getPOFactory();
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                try
                {
                  if (localPOFactory != null)
                  {
                    BannerView.a(BannerView.this, localPOFactory.getBannerView(BannerView.1.this.a, BannerView.1.this.c, BannerView.1.this.b, BannerView.1.this.d));
                    BannerView.a(BannerView.this).setAdListener(new BannerView.ADListenerAdapter(BannerView.this, (byte)0));
                    BannerView.this.addView(BannerView.a(BannerView.this).getView());
                    BannerView.a(BannerView.this, true);
                    if (BannerView.b(BannerView.this) != null)
                      BannerView.this.setDownConfirmPilicy(BannerView.b(BannerView.this));
                    if (BannerView.c(BannerView.this) != null)
                      BannerView.this.setRefresh(BannerView.c(BannerView.this).intValue());
                    if (BannerView.d(BannerView.this) != null)
                      BannerView.this.setRollAnimation(BannerView.d(BannerView.this));
                    if (BannerView.e(BannerView.this) != null)
                      BannerView.this.setShowClose(BannerView.e(BannerView.this).booleanValue());
                    while (BannerView.f(BannerView.this) > 0)
                      BannerView.this.loadAD();
                  }
                }
                catch (Throwable localThrowable)
                {
                  GDTLogger.e("Exception while init Banner Core", localThrowable);
                  return;
                  return;
                }
                finally
                {
                  BannerView.a(BannerView.this, true);
                }
              }
            });
            return;
          }
          catch (Throwable localThrowable)
          {
            GDTLogger.e("Exception while init Banner plugin", localThrowable);
            return;
          }
        GDTLogger.e("Fail to init ADManager");
      }
    });
  }

  public void destroy()
  {
    if (this.a != null)
      this.a.destroy();
  }

  public void loadAD()
  {
    if ((!this.c) || (!this.d))
    {
      GDTLogger.e("Banner init Paras OR Context error,See More logs while new BannerView");
      return;
    }
    if (!this.e)
    {
      this.j += 1;
      return;
    }
    if (this.a != null)
    {
      this.a.fetchAd();
      return;
    }
    GDTLogger.e("Banner Init error,See More Logs");
  }

  public void setADListener(BannerADListener paramBannerADListener)
  {
    this.b = paramBannerADListener;
  }

  public void setDownConfirmPilicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy)
  {
    this.h = paramDownAPPConfirmPolicy;
    if ((paramDownAPPConfirmPolicy != null) && (this.a != null))
      this.a.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy.value());
  }

  public void setRefresh(int paramInt)
  {
    this.f = Integer.valueOf(paramInt);
    int k;
    if ((paramInt < 30) && (paramInt != 0))
      k = 30;
    while (true)
    {
      if (this.a != null)
        this.a.setRefresh(k);
      return;
      k = paramInt;
      if (paramInt > 120)
        k = 120;
    }
  }

  public void setRollAnimation(BannerRollAnimation paramBannerRollAnimation)
  {
    this.g = paramBannerRollAnimation;
    if ((paramBannerRollAnimation != null) && (this.a != null))
      this.a.setRollAnimation(paramBannerRollAnimation.value());
  }

  public void setShowClose(boolean paramBoolean)
  {
    this.i = Boolean.valueOf(paramBoolean);
    if (this.a != null)
      this.a.setShowCloseButton(paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.banner.BannerView
 * JD-Core Version:    0.6.2
 */