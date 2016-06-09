package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;

public class agi
{
  public static boolean a;
  private static final String b = "Swipe." + agi.class.getSimpleName();

  public static void a(Context paramContext)
  {
  }

  public static void b(Context paramContext)
  {
    arj.a(new Runnable() {
      public void run() {
        File localFile = agi.this.getExternalCacheDir();
        if (localFile != null) {
          localFile = new File(localFile, "app_promotion.png");
          if (localFile.exists()) {
            agi.a = true;
            aqx.l(localFile);
          }
        }
      }
    });
  }

  public static boolean c(Context paramContext)
  {
    return false;
  }

  public static Bitmap d(Context paramContext)
  {
    try
    {
      paramContext = atw.a(paramContext.getExternalCacheDir().getAbsolutePath() + "/" + "app_promotion.png", 2560, 2560);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agi
 * JD-Core Version:    0.6.2
 */