package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import com.holaverse.ad.google.nativead.GGNativeAdAdapter;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;

public class abn
{
  private static Class<?> a = null;
  private static boolean b = true;
  private static final abo c = new abo();

  public static File a(Context paramContext)
  {
    File localFile = c.e(paramContext);
    if (!localFile.exists())
    {
      aqu.a(paramContext, c, null, 0);
      return null;
    }
    return localFile;
  }

  private static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }

  public static GGNativeAdAdapter b(Context paramContext)
  {
    if (!b)
      return null;
    if (a == null);
    try
    {
      paramContext = c(paramContext);
      if (paramContext == null)
        return null;
      aqu.a(paramContext);
      a = paramContext.loadClass("com.holaverse.ad.google.nativead.impl.GGNativeAdImpl");
      paramContext.loadClass("com.google.android.gms.ads.AdActivity");
      if (a == null);
    }
    catch (Exception paramContext)
    {
      try
      {
        paramContext = (GGNativeAdAdapter)a.getConstructor(new Class[0]).newInstance(new Object[0]);
        return paramContext;
        paramContext = paramContext;
        Log.e("Swipe.GGNativeAdFactory", "Could not init google native ad", paramContext);
        a(false);
      }
      catch (Throwable paramContext)
      {
        Log.e("Swipe.GGNativeAdFactory", "Could not instantiate GGNativeAdImpl", paramContext);
        return null;
      }
    }
    return null;
  }

  private static DexClassLoader c(Context paramContext)
  {
    try
    {
      File localFile = a(paramContext);
      if (localFile == null)
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
 * Qualified Name:     abn
 * JD-Core Version:    0.6.2
 */