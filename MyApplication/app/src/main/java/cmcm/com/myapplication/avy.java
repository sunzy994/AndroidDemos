package cmcm.com.myapplication;

import android.content.Context;

public class avy extends tl
{
  private static boolean d;

  public avy(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public static boolean d()
  {
    return d;
  }

  public void dismiss()
  {
    super.dismiss();
    d = false;
  }

  public void show()
  {
    super.show();
    d = true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avy
 * JD-Core Version:    0.6.2
 */