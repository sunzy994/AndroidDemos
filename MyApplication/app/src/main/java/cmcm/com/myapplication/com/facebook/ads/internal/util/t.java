package cmcm.com.myapplication.com.facebook.ads.internal.util;

import java.lang.ref.WeakReference;

public abstract class t<T>
  implements Runnable
{
  private final WeakReference<T> a;

  public t(T paramT)
  {
    this.a = new WeakReference(paramT);
  }

  public T a()
  {
    return this.a.get();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.t
 * JD-Core Version:    0.6.2
 */