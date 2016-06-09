package cmcm.com.myapplication.com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class fc
  implements Runnable
{
  private static final String a = fc.class.getSimpleName();
  PrintStream g;
  PrintWriter h;

  public abstract void a();

  public final void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.g == null)
        break label33;
    }
    localThrowable.printStackTrace(this.g);
    while (true)
    {
      el.a(6, a, "", localThrowable);
      return;
      label33: if (this.h != null)
        localThrowable.printStackTrace(this.h);
      else
        localThrowable.printStackTrace();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.fc
 * JD-Core Version:    0.6.2
 */