package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;

public class amv extends ans
{
  public amv(Context paramContext)
  {
    this(paramContext, null);
  }

  public amv(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  public static Intent k()
  {
    return new Intent("android.media.action.STILL_IMAGE_CAMERA");
  }

  public int a(Context paramContext)
  {
    return 1;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837820;
  }

  public boolean a(int paramInt)
  {
    return true;
  }

  public boolean a_(Context paramContext)
  {
    return false;
  }

  public String b()
  {
    return "Camera";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_camera";
  }

  public int c()
  {
    return 4;
  }

  public int d()
  {
    return 2131231116;
  }

  public boolean h()
  {
    return false;
  }

  public boolean i()
  {
    try
    {
      this.e.startActivity(k().addFlags(268435456));
      return true;
    }
    catch (Throwable localThrowable)
    {
      aso.a(this.e, "Could not start Camera");
    }
    return false;
  }

  public boolean x_()
  {
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amv
 * JD-Core Version:    0.6.2
 */