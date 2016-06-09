package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class qw extends BroadcastReceiver
{
  private static boolean a = false;

  public void onReceive(final Context paramContext, Intent paramIntent)
  {
    if (a);
    do
    {
      return;
      a = true;
      qq.a("init", "init.when.wifi");
    }
    while (!oz.c(paramContext));
    qu.a(paramContext, false, new qh()
    {
      public void a(Object paramAnonymousObject)
      {
        qw.a(false);
        paramContext.unregisterReceiver(qv.a());
        qq.a("init", "init.when.wifi.OK");
      }

      public void a(pi paramAnonymouspi)
      {
        qw.a(false);
        qq.a("init", "init.when.wifi.Failed");
      }
    });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qw
 * JD-Core Version:    0.6.2
 */