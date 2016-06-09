package cmcm.com.myapplication.com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class ADActivity extends Activity
{
  private ACTD a;

  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.a != null)
      this.a.onBackPressed();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.a != null)
      this.a.onConfigurationChanged(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getExtras().getString("gdt_activity_delegate_name");
    localObject = ((Intent)localObject).getExtras().getString("appid");
    if ((StringUtil.isEmpty(str)) || (StringUtil.isEmpty((String)localObject)))
    {
      if (this.a == null)
        break label174;
      this.a.onBeforeCreate(paramBundle);
    }
    while (true)
    {
      while (true)
      {
        super.onCreate(paramBundle);
        if (this.a != null)
          this.a.onAfterCreate(paramBundle);
        return;
        try
        {
          if (!GDTADManager.getInstance().initWith(getApplicationContext(), (String)localObject))
            break label166;
          this.a = GDTADManager.getInstance().getPM().getPOFactory().getActivityDelegate(str, this);
          if (this.a != null)
            break;
          GDTLogger.e("Init ADActivity Delegate return null,delegateName" + str);
        }
        catch (Throwable localThrowable)
        {
          GDTLogger.e("Init ADActivity Delegate Faile,DelegateName:" + str, localThrowable);
        }
      }
      break;
      label166: GDTLogger.e("Init GDTADManager fail in AdActivity");
      break;
      label174: finish();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
      this.a.onDestroy();
  }

  protected void onResume()
  {
    super.onResume();
    if (this.a != null)
      this.a.onResume();
  }

  protected void onStop()
  {
    super.onStop();
    if (this.a != null)
      this.a.onStop();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.ADActivity
 * JD-Core Version:    0.6.2
 */