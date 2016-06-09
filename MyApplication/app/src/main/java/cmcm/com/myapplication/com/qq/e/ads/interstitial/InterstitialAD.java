package cmcm.com.myapplication.com.qq.e.ads.interstitial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.IADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.ExecutorService;

@SuppressLint({"ViewConstructor"})
public class InterstitialAD
{
  private IADI a;
  private InterstitialADListener b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private volatile int f = 0;

  public InterstitialAD(final Activity paramActivity, final String paramString1, final String paramString2)
  {
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)) || (paramActivity == null))
    {
      GDTLogger.e(String.format("Intersitial Contructor paras error,appid=%s,posId=%s,context=%s", new Object[] { paramString1, paramString2, paramActivity }));
      return;
    }
    this.c = true;
    if (!a.a(paramActivity))
    {
      GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
      return;
    }
    this.d = true;
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
                    InterstitialAD.a(InterstitialAD.this, localPOFactory.getIADView(InterstitialAD.1.this.a, InterstitialAD.1.this.b, InterstitialAD.1.this.c));
                    InterstitialAD.a(InterstitialAD.this).setAdListener(new InterstitialAD.ADListenerAdapter(InterstitialAD.this, (byte)0));
                    InterstitialAD.a(InterstitialAD.this, true);
                    while (InterstitialAD.b(InterstitialAD.this) > 0)
                      InterstitialAD.this.loadAD();
                  }
                }
                catch (Throwable localThrowable)
                {
                  GDTLogger.e("Exception while init IAD Core", localThrowable);
                  return;
                  return;
                }
                finally
                {
                  InterstitialAD.a(InterstitialAD.this, true);
                }
              }
            });
            return;
          }
          catch (Throwable localThrowable)
          {
            GDTLogger.e("Exception while init IAD plugin", localThrowable);
            return;
          }
        GDTLogger.e("Fail to init ADManager");
      }
    });
  }

  public void closePopupWindow()
  {
    if (this.a != null)
      this.a.closePopupWindow();
  }

  public void destory()
  {
    if (this.a != null)
      this.a.destory();
  }

  public void loadAD()
  {
    if ((!this.c) || (!this.d))
    {
      GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
      return;
    }
    if (!this.e)
    {
      this.f += 1;
      return;
    }
    if (this.a != null)
    {
      this.a.loadAd();
      return;
    }
    GDTLogger.e("InterstitialAD Init error,See More Logs");
  }

  public void setADListener(InterstitialADListener paramInterstitialADListener)
  {
    this.b = paramInterstitialADListener;
  }

  public void show()
  {
    try
    {
      if (this.a != null)
        this.a.show();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void show(Activity paramActivity)
  {
    try
    {
      if (this.a != null)
        this.a.show(paramActivity);
      return;
    }
    finally
    {
      paramActivity = finally;
    }
    throw paramActivity;
  }

  public void showAsPopupWindow()
  {
    try
    {
      if (this.a != null)
        this.a.showAsPopupWindown();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void showAsPopupWindow(Activity paramActivity)
  {
    try
    {
      if (this.a != null)
        this.a.showAsPopupWindown(paramActivity);
      return;
    }
    finally
    {
      paramActivity = finally;
    }
    throw paramActivity;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.interstitial.InterstitialAD
 * JD-Core Version:    0.6.2
 */