package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class atp
{
  private static final String a = "Swipe." + atp.class.getSimpleName();
  private static final Map<Integer, SoftReference<Bitmap>> b = new HashMap();
  private static SoftReference<Bitmap> c;

  public static Bitmap a(int paramInt, Context paramContext)
  {
    SoftReference localSoftReference = (SoftReference)b.get(Integer.valueOf(paramInt));
    if ((localSoftReference != null) && (atw.b((Bitmap) localSoftReference.get())))
      return (Bitmap)localSoftReference.get();
    paramContext = atw.a(paramContext.getResources(), paramInt);
    localSoftReference = new SoftReference(paramContext);
    b.put(Integer.valueOf(paramInt), localSoftReference);
    return paramContext;
  }

  public static Bitmap a(Context paramContext)
  {
    return a(2130837656, paramContext);
  }

  public static Bitmap b(Context paramContext)
  {
    return a(2130837509, paramContext);
  }

  public static Bitmap c(Context paramContext)
  {
    return a(2130837578, paramContext);
  }

  public static Bitmap d(Context paramContext)
  {
    return a(2130837649, paramContext);
  }

  public static Bitmap e(Context paramContext)
  {
    return a(2130837753, paramContext);
  }

  public static Bitmap f(Context paramContext)
  {
    return a(2130837705, paramContext);
  }

  public static Bitmap g(Context paramContext)
  {
    Object localObject1 = null;
    if (c == null);
    while (true)
    {
      Object localObject2 = localObject1;
      if (!atw.b((Bitmap) localObject1));
      try
      {
        localObject1 = acq.a().b("float_cleaner_leaf");
        int i = asq.a(24.0F);
        int j = asq.a(46.0F);
        localObject1 = atw.b(((File) localObject1).getAbsolutePath());
        localObject2 = Bitmap.createBitmap(i, j, Config.ARGB_8888);
        new Canvas((Bitmap)localObject2).drawBitmap((Bitmap)localObject1, null, new Rect(0, 0, i, j), atw.b);
        atw.a((Bitmap) localObject1);
        c = new SoftReference(localObject2);
        return localObject2;
        localObject1 = (Bitmap)c.get();
      }
      catch (Throwable localThrowable)
      {
      }
    }
    return a(2130837607, paramContext);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atp
 * JD-Core Version:    0.6.2
 */