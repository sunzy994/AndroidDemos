package cmcm.com.myapplication;

import android.util.Log;
import java.lang.reflect.Method;

public class aop extends aoi
{
  private Object a;
  private Method b;
  private Method c;
  private boolean d = false;

  public boolean a()
  {
    try
    {
      this.a = asq.e("hardware");
      this.b = this.a.getClass().getDeclaredMethod("setFlashlightEnabled", new Class[] { Boolean.TYPE });
      this.c = this.a.getClass().getDeclaredMethod("getFlashlightEnabled", new Class[0]);
      this.b.setAccessible(true);
      this.c.setAccessible(true);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean b()
  {
    return this.d;
  }

  public void c()
  {
    if (this.d)
      e();
  }

  public void d()
  {
    try
    {
      this.b.invoke(this.a, new Object[] { Boolean.valueOf(true) });
      this.d = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Swipe.Light", "LedLightServiceManager start exception", localThrowable);
    }
  }

  public void e()
  {
    try
    {
      this.b.invoke(this.a, new Object[] { Boolean.valueOf(false) });
      this.d = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Swipe.Light", "LedLightServiceManager stop exception", localThrowable);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aop
 * JD-Core Version:    0.6.2
 */