package cmcm.com.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aqe
{
  public static final String a = "Swipe." + aqe.class.getSimpleName();
  private static final Map<String, String> b = new HashMap();

  static
  {
    b.put("com.qiigame.flocker", "206");
    b.put("com.hola.launcher", "300102");
    b.put("com.lazyswipe", "300105");
    b.put("com.hola.screenlock", "300107");
    b.put("com.hola.launcher.plugin.notification", "300108");
    b.put("com.autumn.privacyace", "300109");
  }

  public static void a()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    long l1 = vs.a(localSwipeApplication, "ALLIANCE_LAST_TIME", 0L);
    long l2 = System.currentTimeMillis();
    if ((l1 < l2) && (l2 - l1 < 86400000L))
      return;
    vs.b(localSwipeApplication, "ALLIANCE_LAST_TIME", System.currentTimeMillis());
    og.a(false);
    og.a(localSwipeApplication, new aqf(null));
  }

  public static void a(Context paramContext)
  {
  }

  public static void b(Context paramContext)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqe
 * JD-Core Version:    0.6.2
 */