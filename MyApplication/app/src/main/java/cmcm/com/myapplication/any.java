package cmcm.com.myapplication;

import java.lang.ref.WeakReference;

class any
  implements Runnable
{
  private final WeakReference<anx> a;

  any(anx paramanx)
  {
    this.a = new WeakReference(paramanx);
  }

  public void run()
  {
    try
    {
      if (this.a.get() != null)
        anx.a((anx)this.a.get(), arl.b(((anx) this.a.get()).e));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     any
 * JD-Core Version:    0.6.2
 */