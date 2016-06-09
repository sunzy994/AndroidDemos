package cmcm.com.myapplication;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class ark<T> extends WeakReference<T>
{
  private static final String a = "Swipe." + ark.class.getSimpleName();

  public ark(T paramT)
  {
    super(paramT);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Reference))
      if (get() != ((Reference)paramObject).get());
    while (get() == paramObject)
    {
      return true;
      return false;
    }
    return false;
  }

  public int hashCode()
  {
    int i = 0;
    try
    {
      if (get() != null)
        i = get().hashCode();
      return i;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ark
 * JD-Core Version:    0.6.2
 */