package cmcm.com.myapplication;

import android.content.Context;
import android.os.Vibrator;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class aoo extends aoi
{
  private final Context a;
  private Object b;
  private boolean c = false;
  private Method d;

  aoo(Context paramContext)
  {
    this.a = paramContext;
  }

  private void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    try
    {
      this.d.invoke(this.b, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public boolean a()
  {
    try
    {
      Object localObject = (Vibrator)this.a.getSystemService("vibrator");
      Field localField = Class.forName(localObject.getClass().getName()).getDeclaredField("mService");
      localField.setAccessible(true);
      this.b = localField.get(localObject);
      this.d = this.b.getClass().getMethod("setFlashlightEnabled", new Class[] { Boolean.TYPE });
      localObject = this.b;
      this.d.invoke(localObject, new Object[] { Boolean.valueOf(true) });
      this.d.invoke(localObject, new Object[] { Boolean.valueOf(false) });
      d();
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean b()
  {
    return this.c;
  }

  public void c()
  {
    if (this.c)
      e();
  }

  public void d()
  {
    if (!this.c)
      a(true);
  }

  public void e()
  {
    if (this.c)
      a(false);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aoo
 * JD-Core Version:    0.6.2
 */