package cmcm.com.myapplication.com.qq.e.ads.appwall;

import android.app.Activity;
import android.view.View;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.GWI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public final class GridAPPWall
{
  private GWI a;

  public GridAPPWall(Activity paramActivity, String paramString1, String paramString2, GridAPPWallListener paramGridAPPWallListener)
  {
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)) || (paramActivity == null))
    {
      GDTLogger.e(String.format("GridAPPWall ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[] { paramString1, paramString2, paramActivity }));
      return;
    }
    if (!a.a(paramActivity))
    {
      GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
      a(paramGridAPPWallListener, 602);
      return;
    }
    try
    {
      if (!GDTADManager.getInstance().initWith(paramActivity.getApplicationContext(), paramString1))
      {
        GDTLogger.e("Fail to Init GDT AD SDK,report logcat info filter by gdt_ad_mob");
        a(paramGridAPPWallListener, 301);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      GDTLogger.e("Fail to init new appwall plugin", paramActivity);
      a(paramGridAPPWallListener, 302);
      return;
      this.a = GDTADManager.getInstance().getPM().getPOFactory().createGridAppWallView(paramActivity, paramString1, paramString2);
      if (this.a != null)
      {
        this.a.setAdListener(paramGridAPPWallListener);
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      GDTLogger.e("Unknown Exception", paramActivity);
      a(paramGridAPPWallListener, 605);
      return;
    }
    GDTLogger.e("Fail to INIT GDT SDK");
    a(paramGridAPPWallListener, 303);
  }

  private static void a(GridAPPWallListener paramGridAPPWallListener, int paramInt)
  {
    if (paramGridAPPWallListener != null)
      paramGridAPPWallListener.onNoAD(paramInt);
  }

  public final void show()
  {
    if (this.a != null)
      this.a.show();
  }

  public final void showRelativeTo(int paramInt1, int paramInt2)
  {
    if (this.a != null)
      this.a.showRelativeTo(paramInt1, paramInt2);
  }

  public final void showRelativeTo(View paramView)
  {
    if (this.a != null)
      this.a.showRelativeTo(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.appwall.GridAPPWall
 * JD-Core Version:    0.6.2
 */