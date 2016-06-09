package cmcm.com.myapplication.com.hola.channel.sdk.game.manager;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import oo;
import pd;
import pe;
import pg;
import qr;
import rn;
import sn;

public class DownloadService extends Service
{
  public static final String a = rn.a;
  private BroadcastReceiver b;
  private ContentObserver c;
  private Handler d;
  private Handler e;
  private long f;
  private Context g;

  private void a(Context paramContext)
  {
    sn.a(paramContext).a(this);
    this.g = paramContext;
    b(paramContext);
    this.d = new Handler();
    this.e = new Handler();
    this.c = new ContentObserver(this.d)
    {
      public void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
      {
        if (System.currentTimeMillis() - DownloadService.a(DownloadService.this) >= 15000L)
        {
          DownloadService.a(DownloadService.this, System.currentTimeMillis());
          DownloadService.a(DownloadService.this, DownloadService.b(DownloadService.this), "onChange", 2);
        }
      }
    };
    this.g.getContentResolver().registerContentObserver(rn.a("game_status"), true, this.c);
  }

  private void a(Context paramContext, String paramString, int paramInt)
  {
    int i = 0;
    if (!pg.a(paramContext))
      return;
    if (qr.b(paramContext))
    {
      paramInt = 0;
      label20: paramString = rn.a(paramContext).c();
      if (paramString != null)
        if (!sn.a(paramContext).a(paramString))
        {
          a(paramContext, paramString);
          paramInt = 1;
        }
      while (true)
      {
        int j = i + 1;
        if (paramInt != 0)
          break;
        i = j;
        if (j < 20)
          break label20;
        return;
        rn.a(paramContext).d(paramString.d);
        continue;
        paramInt = 1;
      }
    }
    switch (paramInt)
    {
    default:
      return;
    case 1:
      a(paramContext, rn.a(paramContext).e(), 3);
      return;
    case 2:
    }
    a(paramContext, rn.a(paramContext).f(), 3);
  }

  private void a(Context paramContext, List<pd> paramList, int paramInt)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        pd localpd = (pd)paramList.next();
        sn localsn = sn.a(paramContext);
        String str = localpd.d;
        if (!localpd.a);
        for (int i = paramInt; ; i = 5)
        {
          localsn.a(paramContext, str, i);
          break;
        }
      }
    }
  }

  private void a(Context paramContext, pe parampe)
  {
    if (qr.b(paramContext))
      sn.a(paramContext).a(paramContext, parampe);
  }

  private void b(Context paramContext)
  {
    if (this.b == null)
      this.b = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
            DownloadService.a(DownloadService.this, paramAnonymousContext, "createReceiver", 1);
        }
      };
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this.b, localIntentFilter);
  }

  public void a(final oo paramoo)
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        if (paramoo != null)
          paramoo.c();
      }
    });
  }

  public void b(final oo paramoo)
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        if (paramoo != null)
          paramoo.d();
      }
    });
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    a(this);
  }

  public void onDestroy()
  {
    if (this.c != null)
    {
      this.g.getContentResolver().unregisterContentObserver(this.c);
      this.c = null;
    }
    super.onDestroy();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    String str;
    int i;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      if (!TextUtils.isEmpty(str))
      {
        i = -1;
        switch (str.hashCode())
        {
        default:
          switch (i)
          {
          default:
          case 0:
          }
          break;
        case -1917331401:
        }
      }
    }
    while (true)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      if (!str.equals("action_down_next_hide_game"))
        break;
      i = 0;
      break;
      a(this, "onStartCommand", 2);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.manager.DownloadService
 * JD-Core Version:    0.6.2
 */