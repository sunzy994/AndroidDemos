package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public class dw
{
  static final dx a = new dy();

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new ea();
      return;
    }
    if (i >= 11)
    {
      a = new dz();
      return;
    }
  }

  public static void a(LayoutInflater paramLayoutInflater, eg parameg)
  {
    a.a(paramLayoutInflater, parameg);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dw
 * JD-Core Version:    0.6.2
 */