package cmcm.com.myapplication;

import com.lazyswipe.SwipeApplication;

public class anz extends acv
{
  private static anz c;

  public static anz h()
  {
    if (c == null)
      c = new anz();
    return c;
  }

  protected int a()
  {
    return 3;
  }

  protected boolean d()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (!abd.a());
    long l;
    do
    {
      do
        return false;
      while (asq.c(localSwipeApplication, "com.hola.launcher"));
      l = vs.a(localSwipeApplication, "key_booster_start_counting", 0L);
    }
    while ((l == -1L) || (System.currentTimeMillis() <= l));
    int i = vs.a(localSwipeApplication, "key_booster_times", 0);
    if (i % 10 < 4)
    {
      vs.b(localSwipeApplication, "key_booster_times", i + 1);
      return false;
    }
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anz
 * JD-Core Version:    0.6.2
 */