package cmcm.com.myapplication;

import android.os.Handler;
import android.os.HandlerThread;

public class arj
{
  private static final HandlerThread a = new HandlerThread("Swipe.Daemon");
  private static final Handler b = new Handler(a.getLooper());

  static
  {
    a.setPriority(10);
    a.start();
  }

  public static void a(Handler paramHandler, Runnable paramRunnable)
  {
    a(paramHandler, paramRunnable, 0L);
  }

  public static void a(Handler paramHandler, Runnable paramRunnable, long paramLong)
  {
    a(paramHandler, paramRunnable, false, paramLong);
  }

  public static void a(Handler paramHandler, Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null)
      localHandler = b;
    if (paramBoolean)
      localHandler.removeCallbacks(paramRunnable);
    localHandler.postDelayed(paramRunnable, paramLong);
  }

  public static void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0L);
  }

  public static void a(Runnable paramRunnable, long paramLong)
  {
    a(null, paramRunnable, paramLong);
  }

  public static void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    a(null, paramRunnable, paramBoolean, paramLong);
  }

  public static void a(Runnable paramRunnable, boolean paramBoolean)
  {
    a(paramRunnable, 0L, paramBoolean);
  }

  public static void b(Runnable paramRunnable)
  {
    b.removeCallbacks(paramRunnable);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arj
 * JD-Core Version:    0.6.2
 */