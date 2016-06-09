package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.util.Log;

public class amm extends ans
{
  public amm(Context paramContext)
  {
    this(paramContext, null);
  }

  public amm(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  public int a(Context paramContext)
  {
    if (asl.a(paramContext))
      return 1;
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837810;
  }

  public String a()
  {
    return "android.intent.action.AIRPLANE_MODE";
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    a(paramContext, a(paramContext));
  }

  public boolean a(Context paramContext, boolean paramBoolean)
  {
    return c(paramBoolean);
  }

  boolean a(final boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if (a(this.e) == 1);
    for (boolean bool1 = true; paramBoolean1 == bool1; bool1 = false)
      return false;
    if (VERSION.SDK_INT >= 17);
    for (int i = 1; (vs.v(this.e)) && (paramBoolean2) && (i != 0); i = 0)
    {
      arj.a(new Runnable() {
        public void run() {
          yb.e(true);
          StringBuilder localStringBuilder = new StringBuilder().append("settings put global airplane_mode_on");
          Object localObject;
          if (paramBoolean1) {
            localObject = " 1";
            localObject = localStringBuilder.append((String) localObject).append("; am broadcast -a android.intent.action.AIRPLANE_MODE ").append("--ez state ");
            if (paramBoolean1)
              break label91;
          }
          label91:
          for (boolean bool = true; ; bool = false) {
            if (!ase.a(bool, true, false).d)
              amm.this.a(paramBoolean1, false);
            return;
            localObject = " 0";
            break;
          }
        }
      });
      return false;
    }
    Object localObject;
    if (i == 0)
    {
      localObject = this.e.getContentResolver();
      if (!paramBoolean1)
        break label172;
      i = 1;
    }
    while (true)
    {
      Settings.System.putInt((ContentResolver)localObject, "airplane_mode_on", i);
      try
      {
        localObject = new Intent("android.intent.action.AIRPLANE_MODE");
        ((Intent)localObject).putExtra("state", paramBoolean1);
        this.e.sendBroadcast((Intent)localObject);
        if (a(this.e) == 1)
        {
          paramBoolean2 = true;
          if ((paramBoolean2 == paramBoolean1) || (!k(this.e)))
            break label196;
          paramBoolean1 = bool2;
          return paramBoolean1;
          label172: i = 0;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.e("Swipe.Tile", "setAirplaneMode error", localException);
          continue;
          paramBoolean2 = false;
          continue;
          label196: paramBoolean1 = false;
        }
      }
    }
  }

  public Intent b(Context paramContext)
  {
    Object localObject;
    if ((aqs.N()) || (aqs.O()))
      localObject = a("com.android.settings", "com.android.settings.HWSettings");
    Intent localIntent;
    do
    {
      return localObject;
      if ((aqs.o()) || ((aqs.n()) && (aqs.A())))
        return a("com.android.settings", "com.android.settings.MiuiSettings");
      if (aqs.y())
        return a("com.android.settings", "com.android.settings.Settings");
      if (("SM-G730V".equals(Build.MODEL)) || ("SM-G3608".equals(Build.MODEL)))
        return asq.i();
      localIntent = asq.f("android.settings.AIRPLANE_MODE_SETTINGS");
      localObject = localIntent;
    }
    while (asq.a(paramContext, localIntent));
    return asq.f("android.settings.WIRELESS_SETTINGS");
  }

  public String b()
  {
    return "Airplane mode";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_airplane_mode";
  }

  public int c()
  {
    return 0;
  }

  boolean c(boolean paramBoolean)
  {
    return a(paramBoolean, true);
  }

  public int d()
  {
    return 2131231110;
  }

  public boolean e()
  {
    return (!aqs.P()) || (vs.v(this.e));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amm
 * JD-Core Version:    0.6.2
 */