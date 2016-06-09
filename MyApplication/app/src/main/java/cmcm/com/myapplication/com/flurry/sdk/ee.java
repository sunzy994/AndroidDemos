package cmcm.com.myapplication.com.flurry.sdk;

import java.util.Comparator;

public class ee
  implements Comparator<Runnable>
{
  private static final String a = ee.class.getSimpleName();

  private int a(Runnable paramRunnable)
  {
    int i = 2147483647;
    if (paramRunnable != null)
    {
      if (!(paramRunnable instanceof ef))
        break label36;
      paramRunnable = (fd)((ef)paramRunnable).a();
      if (paramRunnable == null)
        break label87;
    }
    label36: label87: for (i = paramRunnable.i(); ; i = 2147483647)
    {
      return i;
      if ((paramRunnable instanceof fd))
        return ((fd)paramRunnable).i();
      el.a(6, a, "Unknown runnable class: " + paramRunnable.getClass().getName());
      return 2147483647;
    }
  }

  public int a(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    int i = a(paramRunnable1);
    int j = a(paramRunnable2);
    if (i < j)
      return -1;
    if (i > j)
      return 1;
    return 0;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ee
 * JD-Core Version:    0.6.2
 */