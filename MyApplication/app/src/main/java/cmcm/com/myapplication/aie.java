package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.features.theme.matched.LauncherThemeTip;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class aie
{
  static final String a = "Swipe." + aie.class.getSimpleName();
  public static boolean b;
  private static aie c;
  private static final Map<String, String> d = new HashMap();
  private final Context e;

  public aie(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }

  public static aie a(Context paramContext)
  {
    if (c == null)
      c = new aie(paramContext);
    return c;
  }

  public static void a(Context paramContext, final String paramString)
  {
    String str = ahx.b(paramContext).O();
    if ((!TextUtils.isEmpty(str)) && (str.equals(paramString)))
      arj.a(new Runnable() {
        public void run() {
          aif.a(aie.this);
          aty.a();
          SwipeApplication.c().a().a(true);
          String str = vs.a(aie.this, "WAIT_LAUNCHER_THEME_APK", "");
          long l = vs.a(aie.this, "WAIT_LAUNCHER_THEME_TIME", -1L);
          l = System.currentTimeMillis() - l;
          if ((str.equals(paramString)) && (l > 0L) && (l < 600000L))
            aie.this.startService(SwipeService.a(aie.this, true, "mostUsed"));
        }
      });
  }

  public static void a(String paramString, Context paramContext)
  {
    vs.b(paramContext, "WAIT_LAUNCHER_THEME_TIME", System.currentTimeMillis());
    vs.b(paramContext, "WAIT_LAUNCHER_THEME_APK", paramString);
  }

  public String a(String paramString)
  {
    return (String)d.get(paramString);
  }

  public void a()
  {
    Object localObject = vs.a(this.e, "THEME_MAPPING", "");
    try
    {
      HashMap localHashMap = new HashMap();
      localObject = new JSONObject((String)localObject);
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = ((JSONObject)localObject).optString(str1);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          localHashMap.put(str1, str2);
      }
      d.clear();
      d.putAll(localHashMap);
      Log.i(a, "主题映射关系： [ " + asq.a(d) + "]");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public LauncherThemeTip b()
  {
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aie
 * JD-Core Version:    0.6.2
 */