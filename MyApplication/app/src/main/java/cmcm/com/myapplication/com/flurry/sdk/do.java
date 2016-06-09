package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class do
{
  private static do a;
  private final Context b;
  private final Handler c;
  private final Handler d;

  private do(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new Handler(Looper.getMainLooper());
    paramContext = new HandlerThread("FlurryAgent");
    paramContext.start();
    this.d = new Handler(paramContext.getLooper());
  }

  public static do a()
  {
    return a;
  }

  public static void a(Context paramContext)
  {
    while (true)
    {
      try
      {
        do localdo = a;
        if (localdo != null)
          return;
        if (paramContext == null)
          throw new IllegalArgumentException("Context cannot be null");
      }
      finally
      {
      }
      a = new do(paramContext);
    }
  }

  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      return;
    this.c.post(paramRunnable);
  }

  public void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null)
      return;
    this.c.postDelayed(paramRunnable, paramLong);
  }

  public Context b()
  {
    return this.b;
  }

  public void b(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      return;
    this.c.removeCallbacks(paramRunnable);
  }

  public void b(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null)
      return;
    this.d.postDelayed(paramRunnable, paramLong);
  }

  public PackageManager c()
  {
    return this.b.getPackageManager();
  }

  public void c(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      return;
    this.d.post(paramRunnable);
  }

  public void d(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      return;
    this.d.removeCallbacks(paramRunnable);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.do
 * JD-Core Version:    0.6.2
 */