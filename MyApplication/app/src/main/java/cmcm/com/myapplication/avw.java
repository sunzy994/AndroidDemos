package cmcm.com.myapplication;

import android.content.Context;

public class avw extends tj
{
  private static boolean c;

  public avw(Context paramContext)
  {
    this(paramContext, 2131427342);
  }

  public avw(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public static boolean d()
  {
    return c;
  }

  public void dismiss()
  {
    super.dismiss();
    c = false;
  }

  public void show()
  {
    super.show();
    c = true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avw
 * JD-Core Version:    0.6.2
 */