package cmcm.com.myapplication;

import android.accessibilityservice.AccessibilityService;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.boostplus.BoostPlusDispatcherActivity;
import java.util.List;

public class ack
{
  private static final String a = "Swipe." + ack.class.getSimpleName();
  private static ack b;
  private static Runnable i;
  private static int j = 0;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private int f = -2147483648;
  private String g = null;
  private final Handler h = new Handler();
  private final AccessibilityService k;

  public ack(AccessibilityService paramAccessibilityService)
  {
    this.k = paramAccessibilityService;
  }

  private int a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    int n = 0;
    if (paramInt == 1);
    while (true)
    {
      int m;
      try
      {
        String[] arrayOfString = { "force_stop", "common_force_stop", "finish_application" };
        Context localContext = SwipeApplication.c().createPackageContext(paramAccessibilityEvent.getPackageName().toString(), 2);
        int i1 = arrayOfString.length;
        m = 0;
        if (m < i1)
        {
          String str = arrayOfString[m];
          int i2 = localContext.getResources().getIdentifier(str, "string", paramAccessibilityEvent.getPackageName().toString());
          if (i2 <= 0)
            break label216;
          i2 = aci.a(paramAccessibilityEvent, localContext.getString(i2));
          if (i2 == -4)
            break label216;
          return i2;
          arrayOfString = new String[] { "ok", "dlg_ok" };
          continue;
        }
        if (paramInt == 1)
        {
          arrayOfString = new String[] { "com.android.settings:id/left_button", "com.android.settings:id/force_stop_button", "miui:id/v5_icon_menu_bar_primary_item" };
          m = arrayOfString.length;
          paramInt = n;
          if (paramInt >= m)
            break label213;
          n = aci.b(paramAccessibilityEvent, arrayOfString[paramInt]);
          if (n != -4)
            return n;
        }
        else
        {
          arrayOfString = new String[] { "android:id/button1" };
          continue;
        }
        paramInt += 1;
        continue;
      }
      catch (NameNotFoundException paramAccessibilityEvent)
      {
      }
      label213: return -4;
      label216: m += 1;
    }
  }

  public static ack a()
  {
    return b;
  }

  public static void a(AccessibilityService paramAccessibilityService)
  {
    b = new ack(paramAccessibilityService);
    amk.a(paramAccessibilityService, true);
  }

  private void a(boolean paramBoolean, int paramInt)
  {
    if (!this.c)
      return;
    if (i != null)
      this.h.removeCallbacks(i);
    i = null;
    j = 0;
    aci.a(this.k);
    this.c = false;
    if (paramBoolean)
      paramInt = -1;
    a(paramInt);
  }

  private static Intent b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("package:" + paramString));
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 65536);
    if ((paramContext == null) || (paramContext.size() <= 0))
      throw new ActivityNotFoundException();
    localIntent.addFlags(1073741824);
    localIntent.addFlags(8388608);
    localIntent.addFlags(65536);
    localIntent.addFlags(67108864);
    localIntent.addFlags(262144);
    return localIntent;
  }

  public static void b()
  {
    b = null;
    amk.a(SwipeApplication.c(), false);
  }

  private void b(AccessibilityEvent paramAccessibilityEvent)
  {
    String str = paramAccessibilityEvent.getClassName().toString();
    int m;
    if (!this.e)
      if ("com.android.settings.applications.InstalledAppDetailsTop".equals(str))
      {
        m = a(paramAccessibilityEvent, 1);
        if ((m == 0) || (m == 1))
        {
          this.g = str;
          this.e = true;
        }
      }
    do
    {
      do
      {
        do
        {
          return;
          if (m == -4)
          {
            this.d = true;
            return;
          }
          a(false, m);
          return;
        }
        while ((!this.d) || (!"android.widget.FrameLayout".equals(paramAccessibilityEvent.getClassName().toString())));
        m = a(paramAccessibilityEvent, 1);
        if ((m == 0) || (m == 1))
        {
          this.g = str;
          this.e = true;
          return;
        }
        a(false, m);
        return;
        if (this.f != -2147483648)
          break;
      }
      while (!str.contains("AlertDialog"));
      this.f = a(paramAccessibilityEvent, 2);
      return;
    }
    while (!this.g.equals(str));
    a(true, this.f);
  }

  private void e()
  {
    this.c = false;
    if (i != null)
      this.h.removeCallbacks(i);
  }

  void a(int paramInt)
  {
    SwipeApplication.c().sendBroadcast(new Intent("com.lazyswipe.action.BOOST_RESULT").putExtra("com.lazyswipe.extra.RESULT", paramInt).setPackage("com.lazyswipe"));
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null);
    do
    {
      return;
      paramIntent = paramIntent.getExtras();
    }
    while ((paramIntent == null) || (paramIntent.size() <= 0));
    if (paramIntent.getInt("com.lazyswipe.extra.CMD", 1) == 1)
    {
      a(paramContext, paramIntent.getString("com.lazyswipe.extra.APP"));
      return;
    }
    e();
  }

  void a(final Context paramContext, final String paramString)
  {
    if (!amk.a(paramContext))
      return;
    this.c = true;
    try
    {
      Intent localIntent = new Intent(paramContext, BoostPlusDispatcherActivity.class);
      localIntent.putExtra("package", b(paramContext, paramString));
      asq.d(paramContext, localIntent);
      this.d = false;
      this.e = false;
      this.f = -2147483648;
      this.g = null;
      i = new Runnable()
      {
        public void run()
        {
          ack.c();
          if (ack.d() < 1)
          {
            ack.a(ack.this, false);
            ack.this.a(paramContext, paramString);
            return;
          }
          ack.a(ack.this, false, -20);
        }
      };
      this.h.postDelayed(i, 8000L);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      a(-10);
    }
  }

  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    paramAccessibilityEvent.getEventType();
    if (!this.c)
      return;
    try
    {
      b(paramAccessibilityEvent);
      return;
    }
    catch (Throwable paramAccessibilityEvent)
    {
      Log.e(a, "force stop exception", paramAccessibilityEvent);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ack
 * JD-Core Version:    0.6.2
 */