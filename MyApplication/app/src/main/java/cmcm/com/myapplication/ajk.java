package cmcm.com.myapplication;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.lazyswipe.SwipeApplication;
import java.util.Calendar;

public class ajk
{
  static final String a = "Swipe." + ajk.class.getSimpleName();
  public static boolean b = false;
  private static ajk c;
  private static boolean d = false;
  private final Handler e = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 6:
      }
      ajk.this.b(SwipeApplication.c());
    }
  };

  private ajk()
  {
    b = false;
  }

  private static int a(int paramInt)
  {
    return paramInt / 100;
  }

  public static ajk a()
  {
    if (c == null)
      c = new ajk();
    return c;
  }

  private void a(Context paramContext, ajl paramajl)
  {
    int i = 2130903040;
    Object localObject = paramContext.getString(2131231162);
    String str = paramContext.getString(2131231161, new Object[] { paramajl.r + "%" });
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 1, new Intent("com.lazyswipe.action.OPEN_FROM_NOTIFICATION"), 0);
    Bitmap localBitmap = atw.a(paramContext.getResources(), 2130903040);
    Builder localBuilder = new Builder(paramContext);
    if (aqs.R())
      i = 2130837719;
    localObject = localBuilder.setSmallIcon(i).setLargeIcon(localBitmap).setContentTitle((CharSequence)localObject).setTicker((CharSequence)localObject).setContentText(str).setContentIntent(localPendingIntent).setAutoCancel(true).getNotification();
    ((NotificationManager)paramContext.getSystemService("notification")).notify(1002, (Notification)localObject);
    vs.b(paramContext, "UPGRADE_NOTI_DATE", asq.m());
    paramajl.l();
    b = true;
    vy.b(paramContext, "B26");
  }

  private static boolean a(int paramInt, long paramLong)
  {
    if ((paramInt >= 10) && (paramLong > 86400000L));
    while (((paramInt >= 3) && (paramLong > 172800000L)) || ((paramInt >= 1) && (paramLong > 259200000L)))
      return true;
    return false;
  }

  private boolean c(Context paramContext)
  {
    if (!arl.i(paramContext));
    label76: 
    while (true)
    {
      return false;
      long l1 = System.currentTimeMillis();
      long l2 = ajm.a(paramContext);
      if ((l1 - l2 < 0L) || (l1 - l2 > 86400000L));
      for (int i = 1; ; i = 0)
      {
        if (i == 0)
          break label76;
        l2 = vs.b();
        if ((l2 > 0L) && (Math.abs(l2 - l1) < 43200000L))
          break;
        return true;
      }
    }
  }

  public void a(final Context paramContext)
  {
    if (!c(paramContext));
    while (d)
      return;
    d = true;
    arj.a(wd.a, new we(paramContext) {
      protected void a() {
        try {
          ajk.a(ajk.this).removeMessages(6);
          ajl localajl = ajm.a(paramContext, "auto");
          if ((localajl != null) && (localajl.e())) {
            localajl.g();
            localajl.j();
            ajk.a(ajk.this).sendEmptyMessage(6);
          }
          return;
        } catch (Exception localException) {
        } finally {
          ajm.a(paramContext, System.currentTimeMillis());
          ajk.a(false);
        }
      }
    });
  }

  public void b(Context paramContext)
  {
    if (!arl.g(paramContext));
    long l1;
    long l2;
    ajl localajl;
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            return;
            l1 = System.currentTimeMillis();
            l2 = vs.b();
          }
          while ((l2 > 0L) && (Math.abs(l2 - l1) < 43200000L));
          i = Calendar.getInstance().get(11);
        }
        while ((i < 9) || (i >= 22));
        localajl = ajl.a(paramContext);
      }
      while ((localajl == null) || (!localajl.e()));
      l2 = localajl.k();
      if (l2 < 0L)
      {
        a(paramContext, localajl);
        return;
      }
    }
    while (!a(a(localajl.b) - a(22500), l1 - l2));
    a(paramContext, localajl);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajk
 * JD-Core Version:    0.6.2
 */