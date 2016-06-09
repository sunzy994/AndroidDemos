package com.oppo.launcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.oppo.NearMeStatistics.LauncherStatistics;

public class InstallShortcutReceiver extends BroadcastReceiver
{
  public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
  public static final boolean DEBUG = false;
  public static final String SHORTCUT_MIMETYPE = "com.oppo.launcher/shortcut";
  private static final String TAG = "InstallShortcutReceiver";

  private boolean installShortcutInWorkspace(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("android.intent.extra.shortcut.NAME");
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
    LauncherStatistics localLauncherStatistics;
    Object localObject1;
    if ((localIntent != null) && (paramContext != null))
    {
      localLauncherStatistics = LauncherStatistics.getInstance(paramContext);
      Object localObject2 = LauncherModelDataHelper.getPackageNameByIntent(paramContext, localIntent);
      localObject1 = localObject2;
      if (localObject2 == null)
        localObject1 = "null";
      localObject2 = str;
      Object localObject3 = localObject2;
      if (localObject2 == null)
        localObject3 = "null";
      localObject1 = (String)localObject1 + "/" + (String)localObject3;
      if ((LauncherModelDataHelper.isShortcutInWhiteList(paramContext, localIntent, str)) || (Utilities.isCmccTestVersion()))
      {
        if (localIntent.getAction() == null)
          localIntent.setAction("android.intent.action.VIEW");
        if (LauncherModel.shortcutExists(paramContext, str, localIntent))
          break label233;
        localObject2 = (LauncherApplication)paramContext.getApplicationContext();
        paramIntent = ((LauncherApplication)localObject2).getModel().infoFromShortcutIntent(paramContext, paramIntent, null);
        if (paramIntent != null)
        {
          localObject2 = ((LauncherApplication)localObject2).getLauncher();
          if (localObject2 != null)
          {
            ((Launcher)localObject2).bindShortcutsAdded(paramIntent);
            Toast.makeText(paramContext, paramContext.getString(2131427338, new Object[] { str }), 0).show();
            localLauncherStatistics.onEvent("not_intercepted_shortcut", (String)localObject1);
            return true;
          }
          Log.e("InstallShortcutReceiver", "installShortcutInWorkspace -- launcher = null");
        }
      }
    }
    while (true)
    {
      localLauncherStatistics.onEvent("intercepted_shortcut", (String)localObject1);
      return false;
      label233: Toast.makeText(paramContext, paramContext.getString(2131427340, new Object[] { str }), 0).show();
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.android.launcher.action.INSTALL_SHORTCUT".equals(paramIntent.getAction()))
    {
      Launcher localLauncher = ((LauncherApplication)paramContext.getApplicationContext()).getLauncher();
      if (localLauncher != null)
        installShortcutInWorkspace(localLauncher, paramIntent);
    }
    else
    {
      return;
    }
    if (paramContext != null)
    {
      installShortcutInWorkspace(paramContext, paramIntent);
      return;
    }
    Log.e("InstallShortcutReceiver", "onReceive, launcher is null, context is null!");
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.InstallShortcutReceiver
 * JD-Core Version:    0.6.2
 */