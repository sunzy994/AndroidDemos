package cmcm.com.myapplication;

import android.app.Activity;
import android.os.Build.VERSION;

public class b extends ce
{
  public static void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      c.a(paramActivity);
      return;
    }
    paramActivity.finish();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */