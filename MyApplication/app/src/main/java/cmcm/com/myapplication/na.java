package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class na
{
  private static final String a = na.class.getSimpleName();
  private static final Object b = new Object();
  private static final byte[] c = { -53, -49, 125, 31, 17, 26, 81, 36, -53, 17, 39, 43, -64, 79, 48, -9, 32, -60, -21, -92, -48, 58, -59, -73, -36, -121, -71, -92, -87, 87, -121, 19, -92, -96, 67, 53, 51, 99, 53, 59, 57, 33, 121, -22, 31, -80, 118, -69 };

  static
  {
    new Object();
  }

  public static int a(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getInt("dl_" + paramInt, 2000);
  }

  public static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getLong("last_modified_" + paramString, 0L);
  }

  public static void a(Context arg0)
  {
    Editor localEditor = ???.getSharedPreferences("_toolbox_prefs", 0).edit();
    synchronized (b)
    {
      localEditor.putInt("fb_no_fill_c", 0);
      localEditor.putLong("fb_no_fill_t", 0L);
      np.a(localEditor);
      return;
    }
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, "dl_" + paramInt1, paramInt2);
  }

  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    String str = "priotity_server" + paramInt;
    paramContext.getSharedPreferences("_toolbox_prefs", 0).edit().putLong(str, paramLong).commit();
  }

  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
    paramContext.putString("priotity_" + paramInt, paramString);
    np.a(paramContext);
  }

  public static void a(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
    paramContext.putLong("ls_priotity_server", paramLong);
    np.a(paramContext);
  }

  private static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
    paramContext.putInt(paramString, paramInt);
    np.a(paramContext);
  }

  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
    paramContext.putLong("last_modified_" + paramString, paramLong);
    np.a(paramContext);
  }

  public static boolean a(String paramString, Context paramContext)
  {
    long l = d(paramString, paramContext);
    if (l == 0L);
    do
    {
      return true;
      l = System.currentTimeMillis() - l;
    }
    while ((l > 300000L) || ((l <= 300000L) && (c(paramString, paramContext) < 60)));
    return false;
  }

  public static int b(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getInt("fb_" + paramInt, 2000);
  }

  public static void b(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
    paramContext.putLong("fb_success_t", System.currentTimeMillis());
    np.a(paramContext);
  }

  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, "fb_" + paramInt1, paramInt2);
  }

  public static void b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    paramContext.getSharedPreferences("_toolbox_prefs", 0).edit().putString("imid", paramString).apply();
  }

  public static void b(String paramString, Context paramContext)
  {
    long l = d(paramString, paramContext);
    if (System.currentTimeMillis() - l >= 300000L)
    {
      Editor localEditor = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
      localEditor.putLong(paramString + "_pull_time", System.currentTimeMillis());
      np.a(localEditor);
    }
    for (int i = 1; ; i = c(paramString, paramContext) + 1)
    {
      paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
      paramContext.putInt(paramString, i);
      np.a(paramContext);
      return;
    }
  }

  public static int c(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getInt("im_" + paramInt, 2000);
  }

  private static int c(String paramString, Context paramContext)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getInt(paramString, 0);
  }

  public static void c(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
    paramContext.putLong("ls_priotity_client", System.currentTimeMillis());
    np.a(paramContext);
  }

  public static void c(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, "im_" + paramInt1, paramInt2);
  }

  public static int d(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getInt("ol_" + paramInt, 2000);
  }

  public static long d(Context paramContext)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getLong("ls_priotity_client", 0L);
  }

  private static long d(String paramString, Context paramContext)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getLong(paramString + "_pull_time", 0L);
  }

  public static void d(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, "ol_" + paramInt1, paramInt2);
  }

  public static long e(Context paramContext)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getLong("ls_priotity_server", 0L);
  }

  public static long e(Context paramContext, int paramInt)
  {
    String str = "priotity_server" + paramInt;
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getLong(str, 0L);
  }

  public static boolean f(Context paramContext)
  {
    return a("load_frequently_times", paramContext);
  }

  public static String[] f(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getString("priotity_" + paramInt, "facebook#inmobi#online#download").split("#");
  }

  public static void g(Context paramContext)
  {
    b("load_frequently_times", paramContext);
  }

  public static void g(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).edit();
    paramContext.putInt("log_priotity", paramInt);
    np.a(paramContext);
  }

  public static int h(Context paramContext)
  {
    return paramContext.getSharedPreferences("_toolbox_prefs", 0).getInt("log_priotity", 3);
  }

  public static String i(Context paramContext)
  {
    try
    {
      String str = new String(mp.a("8a1n9d0i3c1y0c2f", "8a1n9d0i3c1y0c2f", c));
      mv.d(a, "getInID(): " + str);
      paramContext = paramContext.getSharedPreferences("_toolbox_prefs", 0).getString("imid", str);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      mv.d(a, "getInID Exception :" + paramContext.toString());
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     na
 * JD-Core Version:    0.6.2
 */