package cmcm.com.myapplication.com.qq.e.comm;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class DownloadService extends Service
{
  private SVSD a;

  private boolean a(String paramString)
  {
    if (this.a == null);
    try
    {
      if (GDTADManager.getInstance().initWith(getApplicationContext(), paramString))
      {
        this.a = GDTADManager.getInstance().getPM().getPOFactory().getAPKDownloadServiceDelegate(this);
        this.a.onCreate();
      }
      while (this.a != null)
      {
        return true;
        GDTLogger.report("Init GDTADManager fail in DownloadService.oncreate");
      }
    }
    catch (Throwable paramString)
    {
      while (true)
        paramString.printStackTrace();
    }
    return false;
  }

  public IBinder onBind(Intent paramIntent)
  {
    GDTLogger.d("DownloadService.onBind");
    if (this.a != null)
      return this.a.onBind(paramIntent);
    String str = paramIntent.getStringExtra("GDT_APPID");
    GDTLogger.d("DownloadService.onBind,appID=" + str);
    if ((!StringUtil.isEmpty(str)) && (a(str)))
      return this.a.onBind(paramIntent);
    return null;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.a != null)
      this.a.onConfigurationChanged(paramConfiguration);
  }

  public void onCreate()
  {
    super.onCreate();
  }

  public void onDestroy()
  {
    if (this.a != null)
      this.a.onDestroy();
  }

  public void onLowMemory()
  {
    if (this.a != null)
      this.a.onLowMemory();
  }

  public void onRebind(Intent paramIntent)
  {
    if (this.a != null)
      this.a.onRebind(paramIntent);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      stopSelf(paramInt2);
      return 2;
    }
    String str = paramIntent.getStringExtra("GDT_APPID");
    if ((!StringUtil.isEmpty(str)) && (a(str)))
      return this.a.onStartCommand(paramIntent, paramInt1, paramInt2);
    GDTLogger.w("Failto Start new download Service");
    return 2;
  }

  public void onTaskRemoved(Intent paramIntent)
  {
    if (this.a != null)
      this.a.onTaskRemoved(paramIntent);
  }

  public void onTrimMemory(int paramInt)
  {
    if (this.a != null)
      this.a.onTrimMemory(paramInt);
  }

  public boolean onUnbind(Intent paramIntent)
  {
    if (this.a != null)
      return this.a.onUnbind(paramIntent);
    return super.onUnbind(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.DownloadService
 * JD-Core Version:    0.6.2
 */