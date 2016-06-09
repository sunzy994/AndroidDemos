package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public class amn extends amo
{
  private static final String[][] b = { arrayOfString1, { "Nexus", "com.android.alarmclock", "com.android.alarmclock.AlarmClock" }, arrayOfString2, { "SAMSUNG", "com.sec.android.app.clockpackage", "com.sec.android.app.clockpackage.ClockPackage" }, arrayOfString3, arrayOfString4, arrayOfString5, { "None2", "com.android.alarmclock", "com.android.alarmclock.AlarmClock" }, arrayOfString6, arrayOfString7, { "Moto Blur Alarm Clock", "com.motorola.blur.alarmclock", "com.motorola.blur.alarmclock.AlarmClock" }, { "Lenovo", "com.lenovomobile.deskclock", "com.lenovomobile.clock.Clock" }, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, { "T-smart D58X", "com.ontim.clock", "com.ontim.clock.alarmclock.AlarmClock" }, { "Nexus 4.4", "com.google.android.deskclock", "com.android.deskclock.DeskClock" }, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, { "OPPO Find5", "com.oppo.alarmclock", "com.oppo.alarmclock.AlarmClock" }, { "MATE 7", "com.android.deskclock", "com.android.deskclock.AlarmsMainActivity" }, { "nubia", "cn.nubia.deskclock.preset", "cn.nubia.deskclock.DeskClock" }, arrayOfString17 };
  private static Intent c;

  static
  {
    String[] arrayOfString1 = { "Froyo Nexus Alarm Clock", "com.google.android.deskclock", "com.android.deskclock.AlarmClock" };
    String[] arrayOfString2 = { "HTC", "com.htc.android.worldclock", "com.htc.android.worldclock.WorldClockTabControl" };
    String[] arrayOfString3 = { "Sharp", "jp.co.sharp.android.timerapps", "jp.co.sharp.android.timerapps.TimerAppsActivity" };
    String[] arrayOfString4 = { "ZTE", "zte.com.cn.alarmclock", "zte.com.cn.alarmclock.AlarmClock" };
    String[] arrayOfString5 = { "None1", "com.android.deskclock", "com.android.deskclock.AlarmClock" };
    String[] arrayOfString6 = { "None3", "com.google.android.deskclock", "com.google.android.deskclock.AlarmClock" };
    String[] arrayOfString7 = { "None4", "com.android.clock", "com.android.clock.Clock" };
    String[] arrayOfString8 = { "UMEOX A603", "org.outsource.alarmtable", "org.outsource.alarmtable.AlarmTable" };
    String[] arrayOfString9 = { "KTouch W606", "com.pekall.clockset", "com.pekall.clockset.ClockSet" };
    String[] arrayOfString10 = { "KTouch W808", "com.ty.clock", "com.ty.clock.MainActivity" };
    String[] arrayOfString11 = { "LT26ii", "com.sonyericsson.organizer", "com.sonyericsson.organizer.Organizer" };
    String[] arrayOfString12 = { "Nexus 4.4-2", "com.android.deskclock", "com.android.deskclock.DeskClock" };
    String[] arrayOfString13 = { "Lenovo A850", "com.lenovo.deskclock", "com.lenovo.clock.Clock" };
    String[] arrayOfString14 = { "Coolpad8297", "com.yulong.android.xtime", "yulong.xtime.ui.main.XTimeActivity" };
    String[] arrayOfString15 = { "Vivo X3T", "com.android.BBKClock", "com.android.BBKClock.Timer" };
    String[] arrayOfString16 = { "NX503A", "com.android.timemanager", "com.android.timemanager.TimeManager" };
    String[] arrayOfString17 = { "LG G2", "com.lge.clock", "com.lge.clock.AlarmClockActivity" };
  }

  public amn(Context paramContext)
  {
    super(paramContext);
  }

  public static Intent c(Context paramContext)
  {
    if (c != null)
      return c;
    paramContext = paramContext.getPackageManager();
    int i = 0;
    while (i < b.length)
    {
      Object localObject1 = b[i][1];
      Object localObject2 = b[i][2];
      try
      {
        localObject1 = new ComponentName((String)localObject1, (String)localObject2);
        paramContext.getActivityInfo((ComponentName)localObject1, 128);
        localObject2 = new Intent();
        ((Intent)localObject2).setComponent((ComponentName)localObject1);
        ((Intent)localObject2).setFlags(268435456);
        c = (Intent)localObject2;
        localObject1 = c;
        return localObject1;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
    return null;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837811;
  }

  public String b()
  {
    return "Alarm";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_alarm";
  }

  public int c()
  {
    return 28;
  }

  public int d()
  {
    return 2131231111;
  }

  public String g()
  {
    return this.e.getString(d());
  }

  protected void s_()
  {
    this.a = c(this.e);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amn
 * JD-Core Version:    0.6.2
 */