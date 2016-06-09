package cmcm.com.myapplication;

import android.content.Context;
import java.util.HashMap;

public class lf
{
  private static lf c;
  private HashMap a = new HashMap();
  private Context b;

  private lf(Context paramContext)
  {
    this.b = paramContext;
  }

  public static lf a(Context paramContext)
  {
    try
    {
      if (c == null)
        c = new lf(paramContext.getApplicationContext());
      return c;
    }
    finally
    {
    }
    throw paramContext;
  }

  public le a(int paramInt1, int paramInt2)
  {
    if (this.a.containsKey(Integer.valueOf(paramInt1)))
      return (le)this.a.get(Integer.valueOf(paramInt1));
    lg locallg = new lg(this.b, paramInt1, paramInt2);
    this.a.put(Integer.valueOf(paramInt1), locallg);
    return locallg;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lf
 * JD-Core Version:    0.6.2
 */