package cmcm.com.myapplication;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import java.util.List;

class ol
{
  public static List<RunningAppProcessInfo> a(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ol
 * JD-Core Version:    0.6.2
 */