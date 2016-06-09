package cmcm.com.myapplication;

import com.lazyswipe.SwipeApplication;

public class afv
{
  private static final String a = "Swipe." + afv.class.getSimpleName();
  private static long b;
  private static boolean c = false;

  public static void a()
  {
    b = System.currentTimeMillis();
    c = false;
  }

  public static void a(yc paramyc)
  {
    if ((amk.b(SwipeApplication.c())) || (paramyc == null))
      return;
    if ((c) || (System.currentTimeMillis() - b > 2000L))
    {
      vy.a(true, paramyc);
      vw.a(SwipeApplication.c(), "fanOpen", "valid", 1);
      return;
    }
    b(wq.g());
    vy.a(false, paramyc);
    vw.a(SwipeApplication.c(), "fanOpen", "valid", 0);
  }

  public static void b()
  {
    c = true;
    yb.l();
  }

  private static void b(String paramString)
  {
    if (c(paramString))
      return;
    afw.a(paramString);
  }

  private static boolean c(String paramString)
  {
    if ("com.lazyswipe".equals(paramString));
    while ((aft.e(paramString)) || (aft.f(paramString)) || (asq.a(SwipeApplication.c(), paramString)))
      return true;
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afv
 * JD-Core Version:    0.6.2
 */