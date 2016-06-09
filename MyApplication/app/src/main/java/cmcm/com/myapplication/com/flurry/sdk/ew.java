package cmcm.com.myapplication.com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

public class ew
  implements ThreadFactory
{
  private final ThreadGroup a;
  private final int b;

  public ew(String paramString, int paramInt)
  {
    this.a = new ThreadGroup(paramString);
    this.b = paramInt;
  }

  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.a, paramRunnable);
    paramRunnable.setName(this.a.getName() + ":" + paramRunnable.getId());
    paramRunnable.setPriority(this.b);
    return paramRunnable;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ew
 * JD-Core Version:    0.6.2
 */