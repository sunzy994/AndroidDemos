package cmcm.com.myapplication;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;
import java.lang.reflect.Method;

public class aon extends aoi
{
  private Camera a;

  public aon()
  {
    try
    {
      this.a = Camera.open();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Swipe.Light", "Open camera failed: " + localThrowable.getMessage());
    }
  }

  public boolean a()
  {
    try
    {
      Parameters localParameters = this.a.getParameters();
      Parameters.class.getDeclaredMethod("setFlashLightMode", new Class[] { String.class }).invoke(localParameters, new Object[] { "on" });
      Parameters.class.getDeclaredMethod("setCameraMode", new Class[] { String.class }).invoke(localParameters, new Object[] { "camera-status-record" });
      Parameters.class.getDeclaredMethod("getFlashLightMode", new Class[0]).invoke(localParameters, new Object[0]);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("Swipe.Light", "LedLightMeizuMx is not available ", localException);
    }
    return false;
  }

  public boolean b()
  {
    boolean bool = false;
    try
    {
      Object localObject = this.a.getParameters();
      localObject = Parameters.class.getDeclaredMethod("getFlashLightMode", new Class[0]).invoke(localObject, new Object[0]);
      if ((localObject instanceof String))
        bool = "on".equals(localObject);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("Swipe.Light", "LedLightMeizuMx isOn error ", localException);
    }
    return false;
  }

  public void c()
  {
    e();
    this.a.release();
    this.a = null;
  }

  public void d()
  {
    try
    {
      Parameters localParameters = this.a.getParameters();
      Parameters.class.getDeclaredMethod("setFlashLightMode", new Class[] { String.class }).invoke(localParameters, new Object[] { "on" });
      Parameters.class.getDeclaredMethod("setCameraMode", new Class[] { String.class }).invoke(localParameters, new Object[] { "camera-status-record" });
      this.a.setParameters(localParameters);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Swipe.Light", "LedLightMeizuMx start error ", localException);
    }
  }

  public void e()
  {
    try
    {
      Parameters localParameters = this.a.getParameters();
      Parameters.class.getDeclaredMethod("setFlashLightMode", new Class[] { String.class }).invoke(localParameters, new Object[] { "off" });
      this.a.setParameters(localParameters);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Swipe.Light", "LedLightMeizuMx stop error ", localException);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aon
 * JD-Core Version:    0.6.2
 */