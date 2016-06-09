package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class fw
{
  static final gb a = new fx();

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new ga();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new fz();
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      a = new fy();
      return;
    }
  }

  public static int a(ViewConfiguration paramViewConfiguration)
  {
    return a.a(paramViewConfiguration);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     fw
 * JD-Core Version:    0.6.2
 */