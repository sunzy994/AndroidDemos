package cmcm.com.myapplication.com.qq.e.ads.appwall;

import android.content.Context;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.b;
import com.qq.e.comm.pi.AWI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class APPWall
{
  private AWI a;

  public APPWall(Context paramContext, String paramString1, String paramString2)
  {
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)) || (paramContext == null))
    {
      GDTLogger.e(String.format("APPWall ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[] { paramString1, paramString2, paramContext }));
      return;
    }
    if (!a.a(paramContext))
    {
      GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
      return;
    }
    if (GDTADManager.getInstance().initWith(paramContext, paramString1))
      try
      {
        this.a = GDTADManager.getInstance().getPM().getPOFactory().getAppWallView(paramContext, paramString1, paramString2);
        return;
      }
      catch (b paramContext)
      {
        GDTLogger.e("Exception while init APPWall plugin", paramContext);
        return;
      }
    GDTLogger.e("Fail to init ADManager");
  }

  public void doShowAppWall()
  {
    if (this.a != null)
      this.a.showAppWall();
  }

  public void prepare()
  {
    if (this.a != null)
      this.a.prepare();
  }

  public void setScreenOrientation(int paramInt)
  {
    if (this.a != null)
      this.a.setScreenOrientation(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.appwall.APPWall
 * JD-Core Version:    0.6.2
 */