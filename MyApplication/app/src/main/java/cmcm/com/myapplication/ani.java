package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Vibrator;
import android.provider.Settings.Global;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;
import com.lazyswipe.notification.SwipeNotificationListenerService;

public class ani extends ano
{
  public static int a;
  private AudioManager b;
  private Vibrator c;
  private boolean d;
  private ContentObserver m;
  private boolean n;

  public ani(Context paramContext)
  {
    this(paramContext, null);
  }

  public ani(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
    f(paramContext);
  }

  private void f(Context paramContext)
  {
    boolean bool2 = true;
    this.b = ((AudioManager)paramContext.getSystemService("audio"));
    this.c = asq.o(paramContext);
    r();
    if ((this.c != null) && (!this.n))
    {
      bool1 = true;
      this.d = bool1;
      q();
      paramContext = new StringBuilder().append("Has vibrator? ").append(this.d).append("; register observer? ");
      if (this.m == null)
        break label118;
    }
    label118: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Log.i("Swipe.Tile", bool1 + "; is miui lollipop? " + this.n);
      return;
      bool1 = false;
      break;
    }
  }

  private boolean p()
  {
    return (VERSION.SDK_INT >= 23) || (!aqs.R()) || (aqs.p(this.e)) || (aqs.X()) || (aqs.W()) || (aqs.V()) || (aqs.J());
  }

  private void q()
  {
    if ((Build.DISPLAY.indexOf("Flyme OS ") == 0) && ((int)(asi.c(Build.DISPLAY.substring(9, 12)) * 10.0F) >= 42))
      this.m = new ContentObserver(this.h)
      {
        public void onChange(boolean paramAnonymousBoolean)
        {
          onChange(paramAnonymousBoolean, null);
        }

        @TargetApi(17)
        public void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
        {
          try
          {
            int i = Settings.Global.getInt(ani.this.e.getContentResolver(), "mode_ringer");
            paramAnonymousUri = new Intent("android.media.RINGER_MODE_CHANGED").putExtra("FROM_OBSERVER", true).putExtra("android.media.EXTRA_RINGER_MODE", i);
            ani.this.a(ani.this.e, paramAnonymousUri);
            return;
          }
          catch (Settings.SettingNotFoundException paramAnonymousUri)
          {
          }
        }
      };
  }

  private void r()
  {
    if ((VERSION.SDK_INT >= 21) && (aqs.D()));
    for (boolean bool = true; ; bool = false)
    {
      this.n = bool;
      return;
    }
  }

  private int s()
  {
    int j = this.b.getRingerMode();
    int i = j;
    if (this.n)
    {
      i = j;
      if (j == 1)
        i = 0;
    }
    return i;
  }

  public int a(Context paramContext)
  {
    int j = 1;
    if (this.b == null)
      j = 4;
    while (true)
    {
      return j;
      if (this.b.getRingerMode() == 2);
      for (int i = 1; i == 0; i = 0)
        return 0;
    }
  }

  public int a(boolean paramBoolean)
  {
    return 0;
  }

  public String a()
  {
    return "android.media.RINGER_MODE_CHANGED";
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if ((!"android.media.RINGER_MODE_CHANGED".equals(paramIntent.getAction())) || ((this.m != null) && (!paramIntent.getBooleanExtra("FROM_OBSERVER", false))))
      return;
    if ((this.g) && (isInitialStickyBroadcast()))
    {
      this.g = false;
      return;
    }
    if (paramIntent.getIntExtra("android.media.EXTRA_RINGER_MODE", 1) == 2);
    while (true)
    {
      a(paramContext, i);
      return;
      i = 0;
    }
  }

  public boolean a(int paramInt)
  {
    return e(this.e) != 2130837833;
  }

  public boolean a(Context paramContext, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (this.b != null)
      switch (this.b.getRingerMode())
      {
      default:
        i = 2;
      case 2:
      case 0:
      case 1:
      }
    while (true)
    {
      if (i != -1)
        this.b.setRingerMode(i);
      return super.a(paramContext, paramBoolean);
      i = j;
      if (!this.n)
        if (p())
        {
          i = 0;
        }
        else if (VERSION.SDK_INT >= 21)
        {
          if (this.d)
          {
            this.c.vibrate(250L);
            i = j;
          }
          else
          {
            i = 2;
          }
        }
        else if (this.d)
        {
          this.c.vibrate(250L);
          i = j;
        }
        else
        {
          i = 2;
          continue;
          if (this.d)
          {
            this.c.vibrate(250L);
            i = j;
          }
          else
          {
            i = 2;
            continue;
            i = 2;
          }
        }
    }
  }

  public String b()
  {
    return "Sound";
  }

  public String b(boolean paramBoolean)
  {
    if ((!p()) && (SwipeNotificationListenerService.a(this.e)) && (SwipeNotificationListenerService.a() == 3))
      return "tile_ringer_mode_silient";
    try
    {
      switch (s())
      {
      case 1:
        return "tile_ringer_mode_vibrate";
      default:
      case 2:
      case 0:
      }
    }
    catch (Exception localException)
    {
      Log.e("Swipe.Tile", "Failed to get the ringer mode.", localException);
      return "tile_ringer_mode_normal";
    }
    return "tile_ringer_mode_normal";
    return "tile_ringer_mode_normal";
    return "tile_ringer_mode_silient";
  }

  public int c()
  {
    return 9;
  }

  public int d()
  {
    switch (s())
    {
    default:
      return 2131231125;
    case 1:
      return 2131231127;
    case 0:
    }
    return 2131231126;
  }

  public int e(Context paramContext)
  {
    try
    {
      int i = s();
      switch (i)
      {
      case 2:
      default:
        return 2130837832;
      case 0:
        return 2130837833;
      case 1:
      }
      return 2130837834;
    }
    catch (Exception paramContext)
    {
      Log.e("Swipe.Tile", "Failed to get the ringer mode.", paramContext);
    }
    return 2130837832;
  }

  public boolean e()
  {
    return false;
  }

  @TargetApi(17)
  public void u_()
  {
    super.u_();
    if (this.m != null)
      this.e.getContentResolver().registerContentObserver(Settings.Global.getUriFor("mode_ringer"), false, this.m);
  }

  public void v_()
  {
    super.v_();
    if (this.m != null)
      this.e.getContentResolver().unregisterContentObserver(this.m);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ani
 * JD-Core Version:    0.6.2
 */