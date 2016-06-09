package cmcm.com.myapplication.com.qq.e.comm.managers.status;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.qq.e.comm.util.StringUtil;

public class APPStatus
{
  private String a;
  private Context b;

  public APPStatus(String paramString, Context paramContext)
  {
    this.a = paramString;
    this.b = paramContext;
  }

  public String getAPPID()
  {
    return this.a;
  }

  public String getAPPName()
  {
    return this.b.getPackageName();
  }

  public String getAPPVersion()
  {
    String str1 = null;
    String str2 = getAPPName();
    if (!StringUtil.isEmpty(str2));
    try
    {
      str1 = this.b.getPackageManager().getPackageInfo(str2, 0).versionName;
      return str1;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.status.APPStatus
 * JD-Core Version:    0.6.2
 */