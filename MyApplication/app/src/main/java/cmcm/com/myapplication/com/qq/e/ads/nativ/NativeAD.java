package cmcm.com.myapplication.com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.NADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class NativeAD
{
  private NADI a;
  private NativeAD.NativeAdListener b;
  private boolean c;
  private boolean d;
  private List<Integer> e = new ArrayList();
  private boolean f = false;
  private BrowserType g;
  private DownAPPConfirmPolicy h;

  public NativeAD(final Context paramContext, final String paramString1, final String paramString2, NativeAD.NativeAdListener paramNativeAdListener)
  {
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)) || (paramContext == null))
    {
      GDTLogger.e(String.format("GDTNativeAd Contructor paras error,appid=%s,posId=%s,context=%s", new Object[] { paramString1, paramString2, paramContext }));
      return;
    }
    this.c = true;
    if (!a.a(paramContext))
    {
      GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
      return;
    }
    this.d = true;
    this.b = paramNativeAdListener;
    GDTADManager.INIT_EXECUTOR.execute(new Runnable()
    {
      public void run()
      {
        if (GDTADManager.getInstance().initWith(paramContext, paramString1))
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
                    NativeAD.a(NativeAD.this, localPOFactory.getNativeADDelegate(NativeAD.1.this.a, NativeAD.1.this.b, NativeAD.1.this.c, new NativeAD.ADListenerAdapter(NativeAD.this, (byte)0)));
                    NativeAD.a(NativeAD.this, true);
                    if (NativeAD.a(NativeAD.this) != null)
                      NativeAD.this.setBrowserType(NativeAD.a(NativeAD.this));
                    if (NativeAD.b(NativeAD.this) != null)
                      NativeAD.this.setDownAPPConfirmPolicy(NativeAD.b(NativeAD.this));
                    Iterator localIterator = NativeAD.c(NativeAD.this).iterator();
                    while (localIterator.hasNext())
                    {
                      Integer localInteger = (Integer)localIterator.next();
                      NativeAD.this.loadAD(localInteger.intValue());
                    }
                  }
                }
                catch (Throwable localThrowable)
                {
                  GDTLogger.e("Exception while init Native Core", localThrowable);
                  return;
                  return;
                }
                finally
                {
                  NativeAD.a(NativeAD.this, true);
                }
              }
            });
            return;
          }
          catch (Throwable localThrowable)
          {
            GDTLogger.e("Exception while init Native plugin", localThrowable);
            return;
          }
        GDTLogger.e("Fail to init ADManager");
      }
    });
  }

  public void loadAD(int paramInt)
  {
    if ((!this.c) || (!this.d))
    {
      GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
      return;
    }
    if (!this.f)
    {
      this.e.add(Integer.valueOf(paramInt));
      return;
    }
    if (this.a != null)
    {
      this.a.loadAd(paramInt);
      return;
    }
    GDTLogger.e("NativeAD Init error,See More Logs");
  }

  public void setBrowserType(BrowserType paramBrowserType)
  {
    this.g = paramBrowserType;
    if ((this.a != null) && (paramBrowserType != null))
      this.a.setBrowserType(paramBrowserType.value());
  }

  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy)
  {
    this.h = paramDownAPPConfirmPolicy;
    if ((this.a != null) && (paramDownAPPConfirmPolicy != null))
      this.a.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.nativ.NativeAD
 * JD-Core Version:    0.6.2
 */