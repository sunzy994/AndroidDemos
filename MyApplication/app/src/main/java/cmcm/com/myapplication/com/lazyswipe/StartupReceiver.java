package cmcm.com.myapplication.com.lazyswipe;

import ajk;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import aqx;
import arl;
import asp;
import com.lazyswipe.ui.DismissKeyguardActivity;
import com.lazyswipe.ui.MainActivity;
import vs;
import vy;
import wd;
import xi;
import yb;

public class StartupReceiver extends BroadcastReceiver
{
  private static long a;

  private void a(final Context paramContext)
  {
    SwipeService.h();
    if (arl.h(paramContext))
      wd.a(paramContext.getApplicationContext());
    asp.b();
    new AsyncTask()
    {
      protected Void a(Void[] paramAnonymousArrayOfVoid)
      {
        try
        {
          paramContext.getContentResolver().delete(xi.a, "dateCreated<?", new String[] { String.valueOf(System.currentTimeMillis() - 259200000L) });
          label33: paramAnonymousArrayOfVoid = SwipeApplication.c().getExternalCacheDir();
          if (paramAnonymousArrayOfVoid != null);
          try
          {
            aqx.a(paramAnonymousArrayOfVoid, 1209600000L);
            label51: return null;
          }
          catch (Throwable paramAnonymousArrayOfVoid)
          {
            break label51;
          }
        }
        catch (Throwable paramAnonymousArrayOfVoid)
        {
          break label33;
        }
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = vs.H(paramContext);
    String str = paramIntent.getAction();
    int i;
    switch (str.hashCode())
    {
    default:
      i = -1;
      label91: switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
      break;
    case 1947666138:
    case -1042022227:
    case 1162734567:
    case -1459943346:
    case 1041332296:
    case 798292259:
    case 823795052:
    case -1172645946:
    }
    label329: 
    do
    {
      do
        do
        {
          return;
          if (!str.equals("android.intent.action.ACTION_SHUTDOWN"))
            break;
          i = 0;
          break label91;
          if (!str.equals("com.lazyswipe.action.OPEN"))
            break;
          i = 1;
          break label91;
          if (!str.equals("com.lazyswipe.action.OPEN_FROM_WIDGET"))
            break;
          i = 2;
          break label91;
          if (!str.equals("com.lazyswipe.action.OPEN_FROM_NOTIFICATION"))
            break;
          i = 3;
          break label91;
          if (!str.equals("android.intent.action.DATE_CHANGED"))
            break;
          i = 4;
          break label91;
          if (!str.equals("android.intent.action.BOOT_COMPLETED"))
            break;
          i = 5;
          break label91;
          if (!str.equals("android.intent.action.USER_PRESENT"))
            break;
          i = 6;
          break label91;
          if (!str.equals("android.net.conn.CONNECTIVITY_CHANGE"))
            break;
          i = 7;
          break label91;
          vs.a(paramContext).edit().putBoolean("key_boot_completed_received", false).apply();
          return;
          if (!bool)
          {
            if (!isOrderedBroadcast())
            {
              MainActivity.a(paramContext);
              return;
            }
            setResultCode(-1);
            return;
          }
          if (!isOrderedBroadcast())
            break label329;
          setResultCode(0);
        }
        while (vs.d(paramContext) == 1);
      while (yb.o());
      if (paramIntent.hasExtra("com.lazyswipe.extra.IS_LEFT"));
      for (bool = paramIntent.getBooleanExtra("com.lazyswipe.extra.IS_LEFT", false); ; bool = vs.B(paramContext))
      {
        SwipeService.a(paramContext, SwipeService.a(paramContext, bool, paramIntent.getStringExtra("tab_id")).getExtras());
        return;
      }
      if (!yb.o())
      {
        ajo.a = true;
        yb.a(paramContext, null);
      }
      vy.b(paramContext, "B29");
      return;
      a(paramContext);
      return;
      vs.a(paramContext).edit().putBoolean("key_boot_completed_received", true).apply();
      if (!bool)
        Process.killProcess(Process.myPid());
      while (true)
      {
        ajk.a().b(paramContext);
        return;
        if (!SwipeService.b())
        {
          paramIntent = new Bundle(1);
          paramIntent.putInt("operation", 1);
          SwipeService.a(paramContext, paramIntent);
        }
        wd.a();
        SwipeService.d();
        if (str.equals("android.intent.action.USER_PRESENT"))
        {
          DismissKeyguardActivity.b(paramContext);
          if (arl.h(paramContext))
            vy.c();
        }
      }
      paramIntent = arl.d(paramContext);
    }
    while ((paramIntent == null) || (!paramIntent.isConnected()) || (System.currentTimeMillis() - a < 10000L));
    a = System.currentTimeMillis();
    wd.a(paramContext.getApplicationContext());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.StartupReceiver
 * JD-Core Version:    0.6.2
 */