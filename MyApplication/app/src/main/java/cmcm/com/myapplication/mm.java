package cmcm.com.myapplication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class mm
{
  private static final ThreadFactory a = new mo();
  private static final BlockingQueue b = new LinkedBlockingQueue(200);
  private static mm c;
  private ThreadPoolExecutor d = new ThreadPoolExecutor(5, 50, 1L, TimeUnit.SECONDS, b, a);

  public static mm a()
  {
    try
    {
      if (c == null)
        c = new mm();
      mm localmm = c;
      return localmm;
    }
    finally
    {
    }
  }

  public static void b(Runnable paramRunnable)
  {
    a().a(paramRunnable);
  }

  public final void a(Runnable paramRunnable)
  {
    this.d.execute(paramRunnable);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mm
 * JD-Core Version:    0.6.2
 */