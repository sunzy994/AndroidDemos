package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.tile.ScreenCaptureActivity;
import com.lazyswipe.ui.DialogActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class anj extends ans
{
  static boolean a = false;
  private BroadcastReceiver b;

  public anj(Context paramContext)
  {
    this(paramContext, null);
  }

  public anj(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  private static void A()
  {
    if (a)
    {
      a = false;
      SwipeService.i().e.b();
    }
  }

  private static int B()
  {
    return "Swipe.ScreenCaptureTile".hashCode();
  }

  private static void C()
  {
    SwipeService localSwipeService = SwipeService.i();
    if ((localSwipeService != null) && (localSwipeService.e.i()))
      localSwipeService.e.d();
  }

  private static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    try
    {
      int i = asq.a(48.0F);
      Bitmap localBitmap = atw.a(paramString, i, i, false);
      paramString = (NotificationManager)paramContext.getSystemService("notification");
      if ((!(paramContext instanceof Activity)) && ((paramIntent.getFlags() & 0x10000000) == 0))
        paramIntent.addFlags(268435456);
      paramIntent = PendingIntent.getActivity(paramContext, 2131230782, paramIntent, 134217728);
      paramContext = new Notification.Builder(paramContext).setAutoCancel(true).setContentTitle(paramContext.getString(2131231059)).setContentText(paramContext.getString(2131231058)).setContentIntent(paramIntent);
      if (aqs.R());
      for (i = 2130837719; ; i = 2130903040)
      {
        paramContext = paramContext.setSmallIcon(i).setWhen(System.currentTimeMillis()).setOngoing(false).setLargeIcon(localBitmap).getNotification();
        paramString.notify(B(), paramContext);
        return;
      }
    }
    catch (Exception paramContext)
    {
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    A();
    Intent localIntent = asq.a(paramString, "image/*");
    a(SwipeApplication.c(), localIntent, paramString);
    arj.a(new Runnable() {
      public void run() {
        anj.s();
      }
    }
            , 60000L);
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + paramString)));
    aso.a(paramContext, "Screenshot saved as " + paramString, 1);
  }

  public static void f(Context paramContext)
  {
    A();
    aso.a(paramContext, "Failed to take a screenshot");
  }

  public static void g(Context paramContext)
  {
    if (VERSION.SDK_INT >= 21)
    {
      C();
      ScreenCaptureActivity.a(paramContext);
      return;
    }
    if (vs.v(paramContext))
    {
      C();
      arj.a(new Runnable() {
        public void run() {
          String str = anj.r();
          ase.a(new String[]{"/system/bin/screencap -p " + str}, true, false);
          if (new File(str).exists()) {
            anj.a(anj.this, str);
            return;
          }
          anj.f(anj.this);
        }
      });
      return;
    }
    a = false;
    DialogActivity.a(paramContext);
  }

  @SuppressLint({"SdCardPath"})
  public static String o()
  {
    if (Build.MODEL.equals("MI 3"));
    for (Object localObject = new File("/sdcard/Pictures"); ; localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES))
    {
      localObject = new File((File)localObject, "Screenshots");
      ((File)localObject).mkdirs();
      String str = ((File)localObject).getAbsolutePath();
      localObject = str;
      if (str.charAt(str.length() - 1) != File.separatorChar)
        localObject = str + File.separator;
      return localObject;
    }
  }

  public static boolean p()
  {
    return a;
  }

  public static String q()
  {
    return new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US).format(Long.valueOf(System.currentTimeMillis())) + ".png";
  }

  public static String r()
  {
    return o() + q();
  }

  public static void s()
  {
    try
    {
      ((NotificationManager)SwipeApplication.c().getSystemService("notification")).cancel(B());
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public int a(Context paramContext)
  {
    if (VERSION.SDK_INT >= 21);
    while (vs.v(paramContext))
      return 1;
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837835;
  }

  public boolean a_(Context paramContext)
  {
    return false;
  }

  public String b()
  {
    return "Screen capture";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_screen_capture";
  }

  public int c()
  {
    return 17;
  }

  public int d()
  {
    return 2131231128;
  }

  public boolean h()
  {
    return false;
  }

  public boolean i()
  {
    a = true;
    yb localyb = yb.getInstance();
    if (localyb != null)
      localyb.b();
    return true;
  }

  public void u_()
  {
    super.u_();
    if (!a)
      this.b = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("com.lazyswipe.extra.CAPTURE_FILE_PATH");
          if (paramAnonymousIntent == null)
            anj.f(paramAnonymousContext);
          while (true)
          {
            paramAnonymousContext.unregisterReceiver(this);
            return;
            anj.a(paramAnonymousContext, paramAnonymousIntent);
          }
        }
      };
    try
    {
      this.e.registerReceiver(this.b, new IntentFilter("com.lazyswipe.action.SCREEN_CAPTURE_FINISHED"));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void v_()
  {
    super.v_();
    if ((!a) && (this.b != null));
    try
    {
      this.e.unregisterReceiver(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anj
 * JD-Core Version:    0.6.2
 */