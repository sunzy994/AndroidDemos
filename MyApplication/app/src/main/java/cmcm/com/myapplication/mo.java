package cmcm.com.myapplication;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class mo
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);

  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "TooboxThread #" + this.a.getAndIncrement());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mo
 * JD-Core Version:    0.6.2
 */