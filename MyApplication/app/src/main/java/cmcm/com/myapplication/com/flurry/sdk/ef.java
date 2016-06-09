package cmcm.com.myapplication.com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ef<V> extends FutureTask<V>
{
  private final WeakReference<Callable<V>> a = null;
  private final WeakReference<Runnable> b;

  public ef(Runnable paramRunnable, V paramV)
  {
    super(paramRunnable, paramV);
    this.b = new WeakReference(paramRunnable);
  }

  public Runnable a()
  {
    return (Runnable)this.b.get();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ef
 * JD-Core Version:    0.6.2
 */