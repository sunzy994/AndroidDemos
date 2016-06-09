package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.ItemSectorBg;
import java.io.File;

public class ahu extends ahq
{
  public static final int[] b = { -867512577, -867512577, -870109116 };
  public static final int[] c = { -1303720193, -1303720193, -1306316732 };
  public static final float[] d = { 0.0F, 0.12F, 1.0F };
  private static final String e = "Swipe." + ahu.class.getSimpleName();

  ahu(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext, paramString1, paramString2, paramInt);
  }

  public static Bitmap a(Context paramContext, yb paramyb, String paramString)
  {
    String str = ahx.a(paramContext);
    paramContext = a(paramContext, paramyb.n(), paramString, str);
    if (!paramContext.exists());
    do
    {
      return null;
      paramContext = atw.a(paramContext.getAbsolutePath(), false);
    }
    while (!atw.b(paramContext));
    return paramContext;
  }

  private static Drawable a(Context paramContext, yb paramyb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt4, int paramInt5, int paramInt6)
  {
    if (x())
    {
      paramyb = a(paramContext, paramyb, paramString1);
      if (paramyb != null)
        return new BitmapDrawable(paramContext.getResources(), paramyb);
    }
    return new yo(paramInt1, paramInt2, paramInt3, paramBoolean, paramString1, paramString2, paramArrayOfInt, paramArrayOfFloat, paramInt4, paramInt5, paramInt6, ItemSectorBg.d());
  }

  public static File a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    paramString1 = b(paramContext, paramBoolean, paramString1, paramString2) + ".png";
    return new File(f(paramContext), paramString1);
  }

  public static void a(Bitmap paramBitmap, boolean paramBoolean, String paramString1, String paramString2)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    atw.a(paramBitmap, a(localSwipeApplication, paramBoolean, paramString1, paramString2));
    atw.a(paramBitmap);
    vs.b(localSwipeApplication, d(localSwipeApplication, paramBoolean, paramString1, paramString2), true);
  }

  public static boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (vs.c(localSwipeApplication, d(localSwipeApplication, paramBoolean, paramString1, paramString2), false));
    while (a(localSwipeApplication, paramBoolean, paramString1, paramString2).exists())
      return false;
    return true;
  }

  public static String b(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramContext = "land";
      localStringBuilder = new StringBuilder().append(paramString1).append("_");
      if (!paramBoolean)
        break label81;
    }
    label81: for (paramString1 = "left"; ; paramString1 = "right")
    {
      return paramString1 + "_" + paramString2 + "_" + paramContext + "_v3";
      paramContext = "port";
      break;
    }
  }

  private static String d(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    return "gradient_theme_cache_" + b(paramContext, paramBoolean, paramString1, paramString2);
  }

  public static boolean d(Context paramContext)
  {
    return ahx.b(paramContext) instanceof ahu;
  }

  private static File f(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "gradient");
  }

  private static boolean x()
  {
    return ItemSectorBg.d();
  }

  public Drawable a(Context paramContext, yb paramyb)
  {
    String str = ahx.a(paramContext);
    boolean bool = paramyb.n();
    int i = paramContext.getResources().getDimensionPixelSize(2131296283);
    int j = paramyb.getCenterOffset();
    int k = ahx.b(paramContext).t();
    Drawable localDrawable = a(paramContext, paramyb, "BIG_SECTOR_INNER", str, i, (paramyb.getItemSectorOuterSize() + i) / 2, j, bool, c, d, 301989887, k, -2145874437);
    paramContext = a(paramContext, paramyb, "BIG_SECTOR_OUTER", str, i, paramyb.getItemSectorOuterSize(), j, bool, b, d, 301989887, k, 0);
    paramyb = new LayerDrawable(new Drawable[] { paramContext, localDrawable });
    if (bool)
    {
      paramyb.setLayerInset(1, 0, paramContext.getIntrinsicHeight() - localDrawable.getIntrinsicHeight(), paramContext.getIntrinsicWidth() - localDrawable.getIntrinsicWidth(), 0);
      return paramyb;
    }
    paramyb.setLayerInset(1, paramContext.getIntrinsicWidth() - localDrawable.getIntrinsicWidth(), paramContext.getIntrinsicHeight() - localDrawable.getIntrinsicHeight(), 0, 0);
    return paramyb;
  }

  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    arj.a(new Runnable() {
      public void run() {
        SwipeApplication localSwipeApplication = SwipeApplication.c();
        aqx.e(ahu.e(localSwipeApplication));
        String[] arrayOfString = new String[1];
        arrayOfString[0] = "technical";
        Editor localEditor = vs.a(localSwipeApplication).edit();
        int i = 0;
        while (i < arrayOfString.length) {
          localEditor.putBoolean(ahu.c(localSwipeApplication, true, "BIG_SECTOR_OUTER", arrayOfString[i]), false).putBoolean(ahu.c(localSwipeApplication, true, "BIG_SECTOR_INNER", arrayOfString[i]), false).putBoolean(ahu.c(localSwipeApplication, true, "SMALL_SECTOR", arrayOfString[i]), false).putBoolean(ahu.c(localSwipeApplication, false, "BIG_SECTOR_OUTER", arrayOfString[i]), false).putBoolean(ahu.c(localSwipeApplication, false, "BIG_SECTOR_INNER", arrayOfString[i]), false).putBoolean(ahu.c(localSwipeApplication, false, "SMALL_SECTOR", arrayOfString[i]), false);
          i += 1;
        }
        localEditor.apply();
      }
    });
  }

  public Drawable b(Context paramContext, yb paramyb)
  {
    String str = ahx.a(paramContext);
    int i = paramContext.getResources().getDimensionPixelSize(2131296283);
    int j = paramyb.getCenterOffset();
    int k = ahx.b(paramContext).t();
    return a(paramContext, paramyb, "SMALL_SECTOR", str, i, paramyb.getItemSectorInnerSize(), j, paramyb.n(), b, d, 301989887, k, -2145874437);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahu
 * JD-Core Version:    0.6.2
 */