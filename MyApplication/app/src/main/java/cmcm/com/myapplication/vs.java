package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class vs
{
  public static final int[] a = { 1, 2, 4, 8 };
  private static boolean b;
  private static final Set<String> c = new HashSet();

  public static int A(Context paramContext)
  {
    paramContext = a(paramContext);
    int i;
    try
    {
      i = paramContext.getInt("key_toucher_position", 3);
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      i = Integer.parseInt(paramContext.getString("key_toucher_position", null));
      paramContext.edit().remove("key_toucher_position").apply();
      paramContext.edit().putInt("key_toucher_position", i).apply();
    }
    return i;
  }

  public static boolean B(Context paramContext)
  {
    return a(paramContext).getBoolean("key_pop_on_left", false);
  }

  public static void C(Context paramContext)
  {
    long l = System.currentTimeMillis() / 86400000L;
    a(paramContext).edit().putLong("key_daily_report_sent", l).apply();
  }

  public static boolean D(Context paramContext)
  {
    return System.currentTimeMillis() / 86400000L == a(paramContext).getLong("key_daily_report_sent", 0L);
  }

  public static int E(Context paramContext)
  {
    int i = 1;
    paramContext = a(paramContext);
    if (!paramContext.contains("key_is_first_startup"))
    {
      paramContext.edit().putBoolean("key_is_first_startup", true).apply();
      i = 0;
    }
    while (paramContext.getBoolean("key_is_first_startup", true))
      return i;
    if (paramContext.getBoolean("key_enable_float_window", true))
      return 2;
    return 3;
  }

  public static int F(Context paramContext)
  {
    return a(paramContext).getInt("key_tutorial_step", 1);
  }

  public static void G(Context paramContext)
  {
    a(paramContext).edit().putBoolean("key_is_first_startup", false).apply();
    if (arl.h(paramContext))
      wd.a(paramContext.getApplicationContext());
  }

  public static boolean H(Context paramContext)
  {
    return c(paramContext, "key_enable_float_window", true);
  }

  public static String I(Context paramContext)
  {
    return a(paramContext, "key_when_to_pop", "3");
  }

  public static boolean J(Context paramContext)
  {
    return a(I(paramContext));
  }

  public static boolean K(Context paramContext)
  {
    return f(paramContext, I(paramContext));
  }

  public static String L(Context paramContext)
  {
    paramContext = a(paramContext);
    String str = paramContext.getString("key_default_tab_selection", "");
    if (str.length() > 1)
      return str;
    return paramContext.getString("key_last_section", "switcher");
  }

  public static String M(Context paramContext)
  {
    return a(paramContext, "key_white_list", null);
  }

  public static int N(Context paramContext)
  {
    paramContext = O(paramContext);
    if (paramContext != null)
      return paramContext.size();
    return 0;
  }

  public static List<String> O(Context paramContext)
  {
    String str = M(paramContext);
    paramContext = null;
    if (!TextUtils.isEmpty(str))
      paramContext = Arrays.asList(str.split(","));
    return paramContext;
  }

  public static Set<String> P(Context paramContext)
  {
    try
    {
      if (!b)
        a(paramContext, null);
      paramContext = c;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  public static boolean Q(Context paramContext)
  {
    return c(paramContext, "animation_on", true);
  }

  public static boolean R(Context paramContext)
  {
    paramContext = a(paramContext, "temperatur_unit", null);
    try
    {
      int i = Integer.parseInt(paramContext);
      return 1 == i;
    }
    catch (Throwable paramContext)
    {
    }
    return true;
  }

  public static int a(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = u(paramContext);
    if (TextUtils.isEmpty(paramContext))
      return paramInt2;
    return Math.abs(paramContext.hashCode()) % paramInt1;
  }

  public static int a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext).getInt(paramString, paramInt);
  }

  public static long a(Context paramContext, String paramString, long paramLong)
  {
    return a(paramContext).getLong(paramString, paramLong);
  }

  public static SharedPreferences a(Context paramContext)
  {
    return amd.a(paramContext, asq.s());
  }

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).getString(paramString1, paramString2);
  }

  public static void a()
  {
    if (b() <= 0L)
      b(SwipeApplication.c(), "key_first_install_time", System.currentTimeMillis());
  }

  public static void a(int paramInt)
  {
    abf.a(SwipeApplication.c(), paramInt);
  }

  public static void a(Context paramContext, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramContext);
    try
    {
      b(paramContext, "key_toucher_type", String.valueOf(paramInt));
      return;
    }
    catch (ClassCastException paramContext)
    {
      localSharedPreferences.edit().remove("key_toucher_type").apply();
      localSharedPreferences.edit().putString("key_toucher_type", String.valueOf(paramInt)).apply();
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    a(paramContext).edit().putString("key_notification_style", paramString).apply();
  }

  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext).edit().putString("key_user_id", paramString).putBoolean("key_is_new_user", paramBoolean).apply();
  }

  public static void a(Context paramContext, List<String> paramList)
  {
    try
    {
      c.clear();
      List localList = d();
      c.addAll(localList);
      localList.clear();
      localList = e();
      if (localList != null)
      {
        c.addAll(localList);
        localList.clear();
      }
      if (paramList != null)
        c.addAll(paramList);
      for (b = true; ; b = true)
      {
        return;
        paramContext = O(paramContext);
        if ((paramContext != null) && (paramContext.size() > 0))
          c.addAll(paramContext);
      }
    }
    finally
    {
    }
    throw paramContext;
  }

  public static void a(Context paramContext, Set<String> paramSet)
  {
    a(paramContext).edit().putStringSet("key_seen_sms_ids", paramSet).apply();
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean("key_install_referrer_sent", paramBoolean).apply();
  }

  public static boolean a(int paramInt, boolean paramBoolean)
  {
    return abf.a(SwipeApplication.c(), paramInt, paramBoolean);
  }

  public static boolean a(Context paramContext, long paramLong)
  {
    return abf.a(paramContext, paramLong);
  }

  public static boolean a(String paramString)
  {
    return "1".equals(paramString);
  }

  public static int b(Context paramContext)
  {
    String str2 = a(paramContext).getString("key_notification_style", null);
    String str1 = str2;
    if (str2 == null)
      str1 = paramContext.getString(2131231210);
    return asi.a(str1, 1);
  }

  public static int b(Context paramContext, boolean paramBoolean)
  {
    if ((o(paramContext)) && ((paramBoolean) || (asq.r(paramContext)) || (!aqs.s(paramContext))))
      return 2010;
    return 2003;
  }

  public static long b()
  {
    return a(SwipeApplication.c(), "key_first_install_time", -1L);
  }

  public static String b(Context paramContext, String paramString)
  {
    return a(paramContext).getString("key_user_id", paramString);
  }

  public static void b(Context paramContext, int paramInt)
  {
    a(paramContext).edit().putInt("key_toucher_size_scale", paramInt).apply();
  }

  public static void b(Context paramContext, long paramLong)
  {
    paramContext = a(paramContext);
    if (paramContext.getLong("key_notification_apps", 0L) == -1L)
      return;
    paramContext.edit().putLong("key_notification_apps", paramLong).apply();
  }

  public static void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext).edit().putInt(paramString, paramInt).apply();
  }

  public static void b(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext).edit().putLong(paramString, paramLong).apply();
  }

  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext).edit().putString(paramString1, paramString2).apply();
  }

  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean(paramString, paramBoolean).apply();
  }

  public static int c(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, paramInt + 1);
  }

  public static Set<String> c(Context paramContext)
  {
    return a(paramContext).getStringSet("key_seen_sms_ids", Collections.EMPTY_SET);
  }

  public static void c()
  {
    b(SwipeApplication.c(), "key_install_time_this_version", System.currentTimeMillis());
  }

  public static void c(Context paramContext, String paramString)
  {
    a(paramContext).edit().putString("key_installed_app_package", paramString).apply();
  }

  public static void c(Context paramContext, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean("key_root_enabled", paramBoolean).apply();
  }

  public static boolean c(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(paramContext).getBoolean(paramString, paramBoolean);
  }

  public static int d(Context paramContext)
  {
    paramContext = a(paramContext);
    int i;
    try
    {
      i = asi.a(paramContext.getString("key_toucher_type", null), 0);
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      i = paramContext.getInt("key_toucher_type", 0);
      paramContext.edit().remove("key_toucher_type").apply();
      paramContext.edit().putString("key_toucher_type", String.valueOf(i)).apply();
    }
    return i;
  }

  public static List<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.lazyswipe");
    localArrayList.add("android");
    localArrayList.add("com.android.phone");
    localArrayList.add("com.android.mms");
    localArrayList.add("com.android.settings");
    localArrayList.add("com.android.systemui");
    localArrayList.add("com.android.providers.settings");
    localArrayList.add("com.android.providers.applications");
    localArrayList.add("com.android.providers.contacts");
    localArrayList.add("com.android.providers.userdictionary");
    localArrayList.add("com.android.providers.telephony");
    localArrayList.add("com.android.providers.drm");
    localArrayList.add("com.android.providers.downloads");
    localArrayList.add("com.android.providers.media");
    return localArrayList;
  }

  public static void d(Context paramContext, int paramInt)
  {
    b(paramContext, "key_toucher_position", paramInt);
  }

  public static void d(Context paramContext, String paramString)
  {
    b(paramContext, "key_notification_apps_selected", paramString);
  }

  public static void d(Context paramContext, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean("key_hint_app_installed", paramBoolean).apply();
  }

  public static List<String> e()
  {
    String str1 = Build.MODEL;
    String str2 = Build.MANUFACTURER;
    ArrayList localArrayList = new ArrayList();
    if (str2.equalsIgnoreCase("HTC"))
    {
      localArrayList.add("com.android.htccontacts");
      localArrayList.add("com.android.htcdialer");
      localArrayList.add("com.htc.messagecs");
      localArrayList.add("com.htc.idlescreen.shortcut");
      localArrayList.add("com.android.providers.htcCheckin");
      if ((!str1.equalsIgnoreCase("HTC Sensation Z710e")) && (!str1.equalsIgnoreCase("HTC Sensation G14")) && (!str1.equalsIgnoreCase("HTC Z710e")))
        break label418;
      localArrayList.add("android.process.acore");
    }
    while (true)
    {
      if (localArrayList.size() == 0)
        break label870;
      return localArrayList;
      if (str2.equalsIgnoreCase("ZTE"))
      {
        localArrayList.add("zte.com.cn.alarmclock");
        localArrayList.add("com.android.utk");
        break;
      }
      if (str2.equalsIgnoreCase("huawei"))
      {
        localArrayList.add("com.huawei.widget.localcityweatherclock");
        break;
      }
      if (str2.equalsIgnoreCase("Sony Ericsson"))
      {
        localArrayList.add("com.sonyericsson.provider.useragent");
        localArrayList.add("com.sonyericsson.provider.customization");
        localArrayList.add("com.sonyericsson.secureclockservice");
        localArrayList.add("com.sonyericsson.widget.digitalclock");
        localArrayList.add("com.sonyericsson.digitalclockwidget");
        break;
      }
      if (str2.equalsIgnoreCase("samsung"))
      {
        localArrayList.add("com.samsung.inputmethod");
        localArrayList.add("com.sec.android.app.controlpanel");
        localArrayList.add("com.sonyericsson.provider.customization");
        break;
      }
      if (str2.equalsIgnoreCase("motorola"))
      {
        localArrayList.add("com.motorola.numberlocation");
        localArrayList.add("com.motorola.android.fota");
        localArrayList.add("com.motorola.atcmd");
        localArrayList.add("com.motorola.locationsensor");
        localArrayList.add("com.motorola.blur.conversations");
        localArrayList.add("com.motorola.blur.alarmclock");
        localArrayList.add("com.motorola.blur.providers.contacts");
        break;
      }
      if (str2.equalsIgnoreCase("LGE"))
      {
        localArrayList.add("com.lge.clock");
        break;
      }
      if (!str2.equalsIgnoreCase("magnum2x"))
        break;
      localArrayList.add("ty.com.android.TYProfileSetting");
      break;
      label418: if (str1.equalsIgnoreCase("LT18i"))
      {
        localArrayList.add("com.sonyericsson.provider.customization");
        localArrayList.add("com.sonyericsson.provider.useragent");
      }
      else if ((str1.equalsIgnoreCase("U8500")) || (str1.equalsIgnoreCase("U8500 HiQQ")))
      {
        localArrayList.add("android.process.launcherdb");
        localArrayList.add("com.motorola.process.system");
        localArrayList.add("com.nd.assistance.ServerService");
      }
      else if (str1.equalsIgnoreCase("MT15I"))
      {
        localArrayList.add("com.sonyericsson.eventstream.calllogplugin");
      }
      else if ((str1.equalsIgnoreCase("GT-I9100")) || (str1.equalsIgnoreCase("GT-I9100G")))
      {
        localArrayList.add("com.samsung.inputmethod");
        localArrayList.add("com.sec.android.app.controlpanel");
        localArrayList.add("com.sec.android.app.FileTransferManager");
        localArrayList.add("com.sec.android.providers.downloads");
        localArrayList.add("com.android.providers.downloads.ui");
      }
      else if (str1.equalsIgnoreCase("DROIDX"))
      {
        localArrayList.add("com.motorola.blur.contacts.data");
        localArrayList.add("com.motorola.blur.contacts");
      }
      else if ((str1.equalsIgnoreCase("DROID2")) || (str1.equalsIgnoreCase("DROID2 GLOBA")))
      {
        localArrayList.add("com.motorola.blur.contacts");
      }
      else if (aqs.w())
      {
        localArrayList.add("com.huawei.android.gpms");
        localArrayList.add("com.android.hwdrm");
        localArrayList.add("com.huawei.omadownload");
      }
      else if (str1.equalsIgnoreCase("LG-P503"))
      {
        localArrayList.add("com.lge.simcontacts");
      }
      else if (str1.equalsIgnoreCase("XT702"))
      {
        localArrayList.add("com.motorola.usb");
        localArrayList.add("com.android.alarmclock");
      }
      else if (str1.equalsIgnoreCase("e15i"))
      {
        localArrayList.add("com.sec.ccl.csp.app.secretwallpaper.themetwo");
      }
      else if (str1.equalsIgnoreCase("zte-c n600"))
      {
        c.add("com.android.wallpaper");
        c.add("com.android.musicvis");
        c.add("com.android.magicsmoke");
      }
      else if ((aqs.q()) || (aqs.r()) || (str1.startsWith("HTC Velocity 4G")))
      {
        c.add("com.android.providers.downloads.ui");
      }
    }
    label870: return null;
  }

  public static void e(Context paramContext, int paramInt)
  {
    if (((amk.b(paramContext)) || (E(paramContext) <= 1)) && (paramInt > 100))
      return;
    a(paramContext).edit().putInt("key_tutorial_step", paramInt).apply();
  }

  public static void e(Context paramContext, String paramString)
  {
    b(paramContext, "key_when_to_pop", paramString);
  }

  public static boolean e(Context paramContext)
  {
    boolean bool = false;
    if ((a(paramContext).getInt("key_pref_clicked", 0) & 0x1) != 0)
      bool = true;
    return bool;
  }

  public static boolean e(Context paramContext, boolean paramBoolean)
  {
    int i = 7;
    boolean bool1 = false;
    boolean bool2 = false;
    String str = Locale.getDefault().getLanguage();
    if ((str != null) && ((str.equals("in")) || (str.equals("th"))) && (!a(paramContext, 86400000L)));
    long l;
    do
    {
      do
      {
        do
          return bool2;
        while ((vj.d == 120) && (vj.f <= 320));
        paramContext = a(paramContext);
        l = paramContext.getLong("key_hint_rate", 0L);
        if (-1L != l)
          break;
        bool2 = bool1;
      }
      while (!paramBoolean);
      bool2 = bool1;
    }
    while (!bool1);
    paramContext.edit().putLong("key_hint_rate", System.currentTimeMillis()).apply();
    return bool1;
    int j;
    if (l > 0L)
    {
      j = paramContext.getInt("key_rate_cancel_times", 1);
      if (j <= 7)
        break label198;
    }
    while (true)
    {
      if (System.currentTimeMillis() - l > i * 86400000L);
      for (bool1 = true; ; bool1 = false)
        break;
      bool1 = true;
      break;
      label198: i = j;
    }
  }

  public static void f(Context paramContext)
  {
    paramContext = a(paramContext);
    int i = paramContext.getInt("key_pref_clicked", 0);
    paramContext.edit().putInt("key_pref_clicked", i | 0x1).apply();
  }

  public static void f(Context paramContext, boolean paramBoolean)
  {
    paramContext = a(paramContext);
    Editor localEditor = paramContext.edit();
    if (paramBoolean);
    for (long l = System.currentTimeMillis(); ; l = -1L)
    {
      localEditor = localEditor.putLong("key_hint_rate", l);
      if (paramBoolean)
      {
        int i = paramContext.getInt("key_rate_cancel_times", 0);
        if (i < 7)
          localEditor.putInt("key_rate_cancel_times", i + 1);
      }
      localEditor.apply();
      return;
    }
  }

  public static boolean f()
  {
    String str = Locale.getDefault().getCountry();
    return (TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("us"));
  }

  public static boolean f(Context paramContext, String paramString)
  {
    return ("2".equals(paramString)) || (acw.b(paramContext));
  }

  public static void g(Context paramContext)
  {
    paramContext = a(paramContext);
    int i = paramContext.getInt("key_pref_clicked", 0);
    paramContext.edit().putInt("key_pref_clicked", i & 0xFFFFFFFE).apply();
  }

  public static void g(Context paramContext, String paramString)
  {
    b(paramContext, "key_last_section", paramString);
  }

  public static void g(Context paramContext, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean("key_hint_notification_service_enabled", paramBoolean).apply();
  }

  public static void h(Context paramContext)
  {
    paramContext = a(paramContext);
    int i = paramContext.getInt("key_pref_clicked", 0);
    paramContext.edit().putInt("key_pref_clicked", i | 0x2).apply();
  }

  public static void h(Context paramContext, String paramString)
  {
    a(paramContext).edit().remove(paramString).apply();
  }

  public static void h(Context paramContext, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean("key_pop_on_left", paramBoolean).putLong("key_last_fan_open", System.currentTimeMillis()).apply();
  }

  public static void i(Context paramContext, String paramString)
  {
    b = false;
    b(paramContext, "key_white_list", paramString);
  }

  public static void i(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, "key_enable_float_window", paramBoolean);
  }

  public static boolean i(Context paramContext)
  {
    boolean bool = false;
    if ((a(paramContext).getInt("key_pref_clicked", 0) & 0x4) != 0)
      bool = true;
    return bool;
  }

  public static void j(Context paramContext)
  {
    paramContext = a(paramContext);
    int i = paramContext.getInt("key_pref_clicked", 0);
    paramContext.edit().putInt("key_pref_clicked", i | 0x4).apply();
  }

  public static boolean k(Context paramContext)
  {
    boolean bool = false;
    if ((a(paramContext).getInt("key_pref_clicked", 0) & 0x8) != 0)
      bool = true;
    return bool;
  }

  public static void l(Context paramContext)
  {
    paramContext = a(paramContext);
    int i = paramContext.getInt("key_pref_clicked", 0);
    paramContext.edit().putInt("key_pref_clicked", i | 0x8).apply();
  }

  public static boolean m(Context paramContext)
  {
    return a(paramContext).getBoolean("key_install_referrer_sent", false);
  }

  public static int n(Context paramContext)
  {
    return b(paramContext, false);
  }

  public static boolean o(Context paramContext)
  {
    return a(paramContext).getBoolean("key_show_over_lockscreen", false);
  }

  public static int p(Context paramContext)
  {
    return a(paramContext).getInt("key_toucher_size_scale", 48);
  }

  public static boolean q(Context paramContext)
  {
    long l = a(paramContext).getLong("key_last_fan_open", 0L);
    return (l > 0L) && (System.currentTimeMillis() - l >= 86400000L);
  }

  public static boolean r(Context paramContext)
  {
    return a(paramContext).getBoolean("key_is_version_pre_2112", false);
  }

  public static boolean s(Context paramContext)
  {
    return a(paramContext).getBoolean("key_is_new_user", true);
  }

  public static int t(Context paramContext)
  {
    return a(paramContext, 10, 11);
  }

  public static String u(Context paramContext)
  {
    return b(paramContext, null);
  }

  public static boolean v(Context paramContext)
  {
    return a(paramContext).getBoolean("key_root_enabled", false);
  }

  public static String w(Context paramContext)
  {
    return a(paramContext).getString("key_installed_app_package", null);
  }

  public static boolean x(Context paramContext)
  {
    return a(paramContext).getBoolean("key_hint_app_installed", true);
  }

  public static boolean y(Context paramContext)
  {
    return a(paramContext).getBoolean("key_hint_notification_service_enabled", true);
  }

  public static boolean z(Context paramContext)
  {
    return a(paramContext).getBoolean("key_sms_notification", true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vs
 * JD-Core Version:    0.6.2
 */