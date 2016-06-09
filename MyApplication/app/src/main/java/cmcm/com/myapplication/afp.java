package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import com.holaverse.locate.amap.LocationManagerProxyAdapter;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;

public class afp
{
  private static Class<?> a = null;
  private static boolean b = true;
  private static final afq c = new afq();

  public static LocationManagerProxyAdapter a(Context paramContext)
  {
    if (!b)
      return null;
    if (a == null);
    try
    {
      paramContext = b(paramContext);
      if (paramContext == null)
        return null;
      a = paramContext.loadClass("com.holaverse.locate.amap.impl.LocationManagerProxyAdapterImpl");
      if (a == null);
    }
    catch (Exception paramContext)
    {
      try
      {
        paramContext = (LocationManagerProxyAdapter)a.getConstructor(new Class[0]).newInstance(new Object[0]);
        return paramContext;
        paramContext = paramContext;
        Log.w("Swipe.AMapSdkFactory", "error init amp sdk factory", paramContext);
        a(false);
      }
      catch (Throwable paramContext)
      {
        Log.w("Swipe.AMapSdkFactory", "amap sdk create error", paramContext);
        return null;
      }
    }
    return null;
  }

  private static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }

  private static DexClassLoader b(Context paramContext)
  {
    try
    {
      File localFile = c.e(paramContext);
      if (!localFile.exists())
        return null;
      paramContext = new DexClassLoader(localFile.getAbsolutePath(), localFile.getParentFile().getAbsolutePath(), null, paramContext.getClassLoader());
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afp
 * JD-Core Version:    0.6.2
 */