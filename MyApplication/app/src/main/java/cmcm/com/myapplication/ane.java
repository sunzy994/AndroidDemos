package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

public class ane extends ans
{
  private static boolean a = false;
  private final anc b;

  public ane(Context paramContext)
  {
    this(paramContext, null);
  }

  public ane(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
    this.b = new anc(paramContext);
  }

  private static int a(String paramString)
  {
    int j = 1;
    int i;
    if (paramString != null)
    {
      paramString = paramString.toUpperCase();
      i = -1;
      switch (paramString.hashCode())
      {
      default:
      case -2087582999:
      case 935892539:
      case -290559304:
      case 1124965819:
      }
    }
    while (true)
      switch (i)
      {
      default:
        j = 0;
      case 0:
        return j;
        if (paramString.equals("CONNECTED"))
        {
          i = 0;
          continue;
          if (paramString.equals("DISCONNECTED"))
          {
            i = 1;
            continue;
            if (paramString.equals("CONNECTING"))
            {
              i = 2;
              continue;
              if (paramString.equals("SUSPENDED"))
                i = 3;
            }
          }
        }
        break;
      case 1:
      case 2:
      case 3:
      }
    return 0;
    return 2;
  }

  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 4;
    case 0:
      return 0;
    case 2:
      return 1;
    case 1:
    case 3:
    }
    return 2;
  }

  public int a(Context paramContext)
  {
    int i = 0;
    try
    {
      if (this.b.a())
        return 0;
      boolean bool = this.b.b();
      if (bool)
        return 1;
    }
    catch (Throwable paramContext)
    {
      i = b(this.b.c());
    }
    return i;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837825;
  }

  public String a()
  {
    return "android.intent.action.ANY_DATA_STATE";
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    if (!"android.intent.action.ANY_DATA_STATE".equals(paramIntent.getAction()))
      return;
    a(paramContext, a(paramIntent.getStringExtra("state")));
  }

  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (!this.b.a(paramBoolean));
    try
    {
      paramContext.startActivity(new Intent().setClassName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity").addFlags(268435456).addFlags(32768));
      label39: return true;
      return super.a(paramContext, paramBoolean);
    }
    catch (Exception paramContext)
    {
      break label39;
    }
  }

  public void a_(boolean paramBoolean)
  {
    a = paramBoolean;
  }

  public boolean a_(Context paramContext)
  {
    if (((aqs.y()) || (aqs.T()) || (aqs.U())) && (!f(paramContext)))
    {
      aso.a(paramContext, 2131230990);
      return false;
    }
    return super.a_(paramContext);
  }

  public Intent b(Context paramContext)
  {
    Intent localIntent = a("com.android.phone", "com.android.phone.MobileNetworkSettings");
    if (!asq.a(paramContext, localIntent))
      localIntent.setClassName("com.android.settings", "com.android.settings.Settings$MobileNetworkSettingsActivity");
    if (!asq.a(paramContext, localIntent))
    {
      if (!aqr.b(paramContext).equalsIgnoreCase("HTC"))
        break label91;
      localIntent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
      if (!asq.a(paramContext, localIntent))
        localIntent.setClassName("com.android.phone", "com.android.phone.Settings");
    }
    while (true)
    {
      if (!asq.a(paramContext, localIntent))
        localIntent.setClassName("com.android.settings", "com.android.settings.Settings");
      return localIntent;
      label91: localIntent.setClassName("com.android.phone", "com.android.phone.Settings");
    }
  }

  public String b()
  {
    return "Mobile data";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_mobile_data";
  }

  public int c()
  {
    return 7;
  }

  public int d()
  {
    return 2131231121;
  }

  public boolean d(Context paramContext)
  {
    if (!f(paramContext))
    {
      aso.a(paramContext, 2131230990);
      return false;
    }
    return super.d(paramContext);
  }

  public boolean e()
  {
    return (Build.VERSION.SDK_INT < 21) || (vs.v(this.e));
  }

  public boolean f(Context paramContext)
  {
    return !this.b.a();
  }

  public String g()
  {
    int j = vs.a(this.e, "pref_mobile_state_level", 0);
    try
    {
      int i = arl.j(this.e);
      if ((1 != i) && (i != 0) && (j < i))
        vs.b(this.e, "pref_mobile_state_level", i);
      i = j;
      if (j == 0)
        i = 2;
      return arl.a(this.e, this.e.getString(d()), i);
    }
    catch (Throwable localThrowable)
    {
      while (true)
        asp.a("Swipe.Tile", "getLabel failed.", localThrowable);
    }
  }

  public boolean l()
  {
    return a;
  }

  protected String w_()
  {
    return "com.lazyswipe.tile.data.action.REFRESH";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ane
 * JD-Core Version:    0.6.2
 */