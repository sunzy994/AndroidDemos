package cmcm.com.myapplication.com.qq.e.ads.splash;

import android.app.Activity;
import android.view.ViewGroup;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.b;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.SPVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public final class SplashAD
{
  private SPVI a;
  private SplashADListener b;

  public SplashAD(Activity paramActivity, ViewGroup paramViewGroup, String paramString1, String paramString2, SplashADListener paramSplashADListener)
  {
    this.b = paramSplashADListener;
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)) || (paramViewGroup == null) || (paramActivity == null))
    {
      GDTLogger.e(String.format("SplashAd Contructor paras error,appid=%s,posId=%s,context=%s", new Object[] { paramString1, paramString2, paramActivity }));
      a(paramSplashADListener, 300);
      return;
    }
    if (!a.a(paramActivity))
    {
      GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
      a(paramSplashADListener, 300);
      return;
    }
    try
    {
      if (!GDTADManager.getInstance().initWith(paramActivity, paramString1))
      {
        GDTLogger.e("Fail to Init GDT AD SDK,report logcat info filter by gdt_ad_mob");
        a(paramSplashADListener, 301);
        return;
      }
    }
    catch (b paramActivity)
    {
      GDTLogger.e("Fail to init splash plugin", paramActivity);
      a(paramSplashADListener, 302);
      return;
      this.a = GDTADManager.getInstance().getPM().getPOFactory().getSplashAdView(paramActivity, paramString1, paramString2);
      if (this.a != null)
      {
        this.a.setAdListener(new SplashAD.ADListenerAdapter(this, (byte)0));
        this.a.fetchAndShowIn(paramViewGroup);
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      GDTLogger.e("Unknown Exception", paramActivity);
      a(paramSplashADListener, 605);
      return;
    }
    GDTLogger.e("SplashAdView created by factory return null");
    a(paramSplashADListener, 303);
  }

  private static void a(SplashADListener paramSplashADListener, int paramInt)
  {
    if (paramSplashADListener != null)
      paramSplashADListener.onNoAD(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.splash.SplashAD
 * JD-Core Version:    0.6.2
 */