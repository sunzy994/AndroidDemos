package cmcm.com.myapplication;

import android.content.Context;
import android.provider.Settings.System;

public class anl extends amw
{
  private static final int[] a = { 2130837837, 2130837839, 2130837838, 2130837840 };
  private static final String[] b = { "tile_screen_timeout_15_seconds", "tile_screen_timeout_30_seconds", "tile_screen_timeout_1_minute", "tile_screen_timeout_5_minute" };
  private static final int[] c = { 15000, 30000, 60000, 300000 };
  private int d;

  public anl(Context paramContext)
  {
    this(paramContext, null);
  }

  public anl(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  private void p()
  {
    int i = Settings.System.getInt(this.e.getContentResolver(), "screen_off_timeout", 0);
    if (i <= c[0])
      this.d = 0;
    while (true)
    {
      return;
      if (i >= c[(c.length - 1)])
      {
        this.d = (c.length - 1);
        return;
      }
      for (this.d = (c.length - 2); (this.d > 0) && (i < c[this.d]); this.d -= 1);
    }
  }

  public int a(Context paramContext)
  {
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 0;
  }

  public boolean a(int paramInt)
  {
    return e(this.e) != 2130837837;
  }

  public String b()
  {
    return "Screen timeout";
  }

  public String b(boolean paramBoolean)
  {
    p();
    return b[this.d];
  }

  public int c()
  {
    return 11;
  }

  public int d()
  {
    return 2131231130;
  }

  public boolean d(Context paramContext)
  {
    int i = this.d + 1;
    this.d = i;
    if (i >= a.length)
      this.d = 0;
    Settings.System.putInt(this.e.getContentResolver(), "screen_off_timeout", c[this.d]);
    return false;
  }

  public int e(Context paramContext)
  {
    p();
    return a[this.d];
  }

  public void y_()
  {
    super.y_();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anl
 * JD-Core Version:    0.6.2
 */