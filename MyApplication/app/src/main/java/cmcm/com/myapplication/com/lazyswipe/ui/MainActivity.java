package cmcm.com.myapplication.com.lazyswipe.ui;

import agi;
import ahl;
import amd;
import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import apa;
import apf;
import aqs;
import asq;
import atw;
import com.lazyswipe.SettingsService;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.features.guide.NewSwipeGuideView;
import com.lazyswipe.features.splash.SplashView;
import vg;
import vs;
import vw;
import vy;

public class MainActivity extends FragmentContainer
  implements apf
{
  private RateView i;

  public static void a(int paramInt, boolean paramBoolean)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (!vg.j)
    {
      vs.i(localSwipeApplication, true);
      if (vs.c(localSwipeApplication, "white_dot_by_suggest", false))
        vs.a(localSwipeApplication, 0);
      a(localSwipeApplication, paramBoolean);
      i();
      apa.a();
      vy.a(localSwipeApplication, "BG", String.valueOf(paramInt));
      return;
    }
    localSwipeApplication.sendBroadcast(new Intent("com.lazyswipe.action.ACTION_ENABLE_SWIPE").setPackage("com.lazyswipe").putExtra("param_1", paramInt));
  }

  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MainActivity.class);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    asq.d(paramContext, localIntent);
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("operation", 1);
    localBundle.putBoolean("param_1", paramBoolean);
    SwipeService.a(paramContext, localBundle);
  }

  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
      a(1, false);
    do
    {
      return;
      b(paramContext);
      vy.a(paramContext, "BG", "0");
    }
    while (!paramBoolean2);
    h();
  }

  public static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putInt("operation", 2);
    SwipeService.a(paramContext, localBundle);
  }

  private static void h()
  {
    int j = 2130903040;
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    Object localObject1 = new Intent(localSwipeApplication, SwipeService.class);
    ((Intent)localObject1).putExtra("operation", 12);
    localObject1 = PendingIntent.getService(localSwipeApplication, 0, (Intent)localObject1, 134217728);
    Object localObject2 = localSwipeApplication.getString(2131230998);
    String str = localSwipeApplication.getString(2131230997);
    Bitmap localBitmap = atw.a(localSwipeApplication.getResources(), 2130903040);
    localObject2 = new Builder(localSwipeApplication).setContentTitle((CharSequence)localObject2).setContentText(str).setTicker((CharSequence)localObject2);
    if (aqs.R())
      j = 2130837719;
    localObject1 = ((Builder)localObject2).setSmallIcon(j).setLargeIcon(localBitmap).setContentIntent((PendingIntent)localObject1).setAutoCancel(true).setOngoing(false).getNotification();
    ((NotificationManager)localSwipeApplication.getSystemService("notification")).notify(15065, (Notification)localObject1);
  }

  private static void i()
  {
    ((NotificationManager)SwipeApplication.c().getSystemService("notification")).cancel(15065);
  }

  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.i == null)
    {
      this.i = ((RateView)LayoutInflater.from(this).inflate(2130968732, null, false));
      this.i.a(paramBoolean, false);
      addContentView(this.i, new LayoutParams(-1, -1));
    }
    this.i.setImageAndText(paramInt);
    this.i.a(paramString);
  }

  public void onBackPressed()
  {
    Object localObject = (ViewGroup)b(16908290);
    localObject = ((ViewGroup)localObject).getChildAt(((ViewGroup)localObject).getChildCount() - 1);
    if ((localObject instanceof SplashView))
      ((SplashView)localObject).a();
    while (RateView.b())
      return;
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startService(new Intent(this, SettingsService.class));
    NewSwipeGuideView.b(this);
    vy.e();
    if (!vs.m(this))
      vy.d(this);
    ahl.a(this);
    aqs.a(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    RateView.b();
    amd.a(asq.s());
    stopService(new Intent(this, SettingsService.class));
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }

  protected void onPause()
  {
    super.onPause();
    vw.c(this);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    agi.a(this);
  }

  protected void onResume()
  {
    super.onResume();
    if (getIntent().hasExtra("finish"))
    {
      finish();
      return;
    }
    vw.b(this);
  }

  public void showHintView(View paramView)
  {
    addContentView(paramView, new LayoutParams(-1, -1));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.MainActivity
 * JD-Core Version:    0.6.2
 */