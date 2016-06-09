package cmcm.com.myapplication;

import java.lang.ref.WeakReference;

class aaf extends Thread
{
  private final WeakReference<zz> a;

  public aaf(zz paramzz)
  {
    this.a = new WeakReference(paramzz);
  }

  public void run()
  {
    if (this.a.get() == null)
      return;
    try
    {
      ((zz)this.a.get()).a();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aaf
 * JD-Core Version:    0.6.2
 */