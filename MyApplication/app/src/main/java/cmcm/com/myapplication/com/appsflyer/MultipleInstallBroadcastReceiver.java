package cmcm.com.myapplication.com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import jl;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("AppsFlyer_1.13", "MultipleInstallBroadcastReceiver called");
    Iterator localIterator = paramContext.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0).iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      String str = paramIntent.getAction();
      if ((localResolveInfo.activityInfo.packageName.equals(paramContext.getPackageName())) && ("com.android.vending.INSTALL_REFERRER".equals(str)) && (!getClass().getName().equals(localResolveInfo.activityInfo.name)))
      {
        Log.i("AppsFlyer_1.13", "trigger onReceive: class: " + localResolveInfo.activityInfo.name);
        try
        {
          ((BroadcastReceiver)Class.forName(localResolveInfo.activityInfo.name).newInstance()).onReceive(paramContext, paramIntent);
        }
        catch (Throwable localThrowable)
        {
          Log.e("AppsFlyer_1.13", "error in BroadcastReceiver " + localResolveInfo.activityInfo.name, localThrowable);
        }
      }
    }
    new jl().onReceive(paramContext, paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.appsflyer.MultipleInstallBroadcastReceiver
 * JD-Core Version:    0.6.2
 */