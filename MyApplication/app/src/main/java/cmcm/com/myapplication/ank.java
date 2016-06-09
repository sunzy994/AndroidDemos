package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings.System;

public class ank extends amw
{
  public ank(Context paramContext)
  {
    this(paramContext, null);
  }

  public ank(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  public int a(Context paramContext)
  {
    if (Settings.System.getInt(this.e.getContentResolver(), "accelerometer_rotation", 0) != 0);
    for (int i = 1; i != 0; i = 0)
      return 1;
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837836;
  }

  public String b()
  {
    return "Screen rotation";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_screen_rotation";
  }

  public int c()
  {
    return 10;
  }

  public int d()
  {
    return 2131231129;
  }

  public boolean d(Context paramContext)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    if (a(paramContext) == 0);
    for (int i = 1; ; i = 0)
    {
      Settings.System.putInt(localContentResolver, "accelerometer_rotation", i);
      return false;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ank
 * JD-Core Version:    0.6.2
 */