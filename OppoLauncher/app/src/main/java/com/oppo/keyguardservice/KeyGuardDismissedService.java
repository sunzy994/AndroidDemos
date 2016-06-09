package com.oppo.keyguardservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.util.Log;
import com.oppo.launcher.Launcher;
import com.oppo.launcher.LauncherApplication;
import com.oppo.launcher.LauncherUtil;

public class KeyGuardDismissedService extends Service
{
  public static boolean DEBUG = false;
  private static final int MESSAGE_TIMEOUT = 300;
  private static final int MSG_CHANGE_PAGE_VISIBILITY = 1;
  private static final int MSG_DO_ANIMATION = 2;
  private static final int MSG_HIDE_PAGE = 1;
  private static final String TAG = "KeyGuardDismissedService";
  private final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Launcher localLauncher = ((LauncherApplication)KeyGuardDismissedService.this.getApplicationContext()).getLauncher();
      if (KeyGuardDismissedService.DEBUG)
        Log.d("KeyGuardDismissedService", "handleMessage --- msg.what = " + paramAnonymousMessage.what + ", msg.arg1 = " + paramAnonymousMessage.arg1);
      long l = SystemClock.uptimeMillis() - paramAnonymousMessage.getWhen();
      int i;
      boolean bool;
      if (l > 300L)
      {
        i = 1;
        if (1 != paramAnonymousMessage.what)
          break label167;
        if (paramAnonymousMessage.arg1 != 1)
          break label154;
        bool = true;
        label103: if (localLauncher != null)
        {
          if ((!bool) || (i == 0))
            break label160;
          if (KeyGuardDismissedService.DEBUG)
            Log.d("KeyGuardDismissedService", "KeyGuardDismissedService launcher is busy, so ignore the hide page message deltaTime = " + l);
        }
      }
      label154: label160: label167: 
      do
      {
        do
        {
          return;
          i = 0;
          break;
          bool = false;
          break label103;
          localLauncher.postHideCurrentPage(bool);
          return;
        }
        while ((2 != paramAnonymousMessage.what) || (localLauncher == null));
        if (i == 0)
          break label221;
        localLauncher.postHideCurrentPage(false);
      }
      while (!KeyGuardDismissedService.DEBUG);
      Log.d("KeyGuardDismissedService", "KeyGuardDismissedService launcher is busy, so ignore the animation message, but we ensure the launcher page's visibility deltaTime = " + l);
      return;
      label221: localLauncher.postDoKeyguardDismissedAnim();
    }
  };

  public IBinder onBind(Intent paramIntent)
  {
    return new Messenger(this.mHandler).getBinder();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.keyguardservice.KeyGuardDismissedService
 * JD-Core Version:    0.6.2
 */