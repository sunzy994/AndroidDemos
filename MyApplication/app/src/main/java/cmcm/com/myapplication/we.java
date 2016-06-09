package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;

public abstract class we
  implements Runnable
{
  protected final Context a;

  public we(Context paramContext)
  {
    this.a = paramContext;
  }

  public abstract void a();

  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Swipe.API", "Execution failed: " + getClass().getSimpleName(), localThrowable);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     we
 * JD-Core Version:    0.6.2
 */