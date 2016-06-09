package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.WindowManager;
import com.lazyswipe.SwipeApplication;
import java.lang.reflect.Method;
import java.util.List;

public class aqs
{
  private static final String a = Build.PRODUCT.toLowerCase();
  private static final String b = Build.MODEL.toLowerCase();
  private static final String c = Build.MANUFACTURER.toLowerCase();
  private static final String d = Build.DISPLAY.toLowerCase();
  private static Boolean e;

  public static boolean A()
  {
    return VERSION.SDK_INT >= 16;
  }

  public static boolean B()
  {
    return VERSION.SDK_INT >= 14;
  }

  public static boolean C()
  {
    return (c.equals("samsung")) && (b.equals("sm-n9006"));
  }

  public static boolean D()
  {
    return (d.contains("miui")) || (d.contains("mione")) || (!TextUtils.isEmpty(a("ro.miui.ui.version.name")));
  }

  public static boolean E()
  {
    return !TextUtils.isEmpty(a("ro.build.version.opporom"));
  }

  public static boolean F()
  {
    String str = a("ro.miui.ui.version.name");
    return (str != null) && ((str.equalsIgnoreCase("V5")) || (str.equalsIgnoreCase("V6")));
  }

  public static boolean G()
  {
    String str = a("ro.miui.ui.version.name");
    return (str != null) && (str.equalsIgnoreCase("V5"));
  }

  public static boolean H()
  {
    String str = a("ro.miui.ui.version.name");
    return (str != null) && (str.equalsIgnoreCase("V6"));
  }

  public static boolean I()
  {
    boolean bool = true;
    String str = a("ro.miui.ui.version.name");
    if (TextUtils.isEmpty(str))
      return false;
    if (asi.e(str.substring(1)) >= 6);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public static boolean J()
  {
    return (c.equals("oppo")) && (b.contains("x909"));
  }

  public static boolean K()
  {
    return c.equalsIgnoreCase("huawei");
  }

  public static boolean L()
  {
    return (asq.a(a("ro.build.version.emui"), "EmotionUI_2.3")) || (Build.DISPLAY.startsWith("EMUI2.3"));
  }

  public static boolean M()
  {
    return (asq.a(a("ro.build.version.emui"), "EmotionUI_3.1")) || (Build.DISPLAY.startsWith("EMUI3.1"));
  }

  public static boolean N()
  {
    return (c.equalsIgnoreCase("huawei")) && (b.contains("p6-u06"));
  }

  public static boolean O()
  {
    return (c.equalsIgnoreCase("huawei")) && (b.contains("u9508"));
  }

  public static boolean P()
  {
    return VERSION.SDK_INT >= 17;
  }

  public static boolean Q()
  {
    return VERSION.SDK_INT >= 19;
  }

  public static boolean R()
  {
    return VERSION.SDK_INT >= 21;
  }

  public static boolean S()
  {
    return ("amoi n826".equalsIgnoreCase(b)) || ("amoi n821".equalsIgnoreCase(b)) || ("amoi n820".equalsIgnoreCase(b));
  }

  public static boolean T()
  {
    return (c.equals("coolpad")) && (a.contains("7298a"));
  }

  public static boolean U()
  {
    return (c.equals("coolpad")) && (b.contains("7295"));
  }

  public static boolean V()
  {
    return (c.equals("huawei")) && (a.equals("rio-al00"));
  }

  public static boolean W()
  {
    return (c.equals("huawei")) && (a.equals("plk-al10"));
  }

  public static boolean X()
  {
    return c.contains("samsung");
  }

  public static String Y()
  {
    try
    {
      Object localObject = SwipeApplication.c();
      DisplayMetrics localDisplayMetrics = ((Context)localObject).getResources().getDisplayMetrics();
      localObject = "MANUFACTURER:" + Build.MANUFACTURER + ", PRODUCT:" + Build.PRODUCT + "， ID:" + Build.ID + ", brand:" + Build.BRAND + ", display:" + Build.DISPLAY + ", MODEL:" + Build.MODEL + ", DPI:" + aqr.d((Context)localObject) + ", SDK:" + VERSION.SDK_INT + ", screenWidth:" + localDisplayMetrics.widthPixels + ", screenHeight:" + localDisplayMetrics.heightPixels;
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return "UNKNOWN";
  }

  public static String Z()
  {
    try
    {
      String str = a("ro.serialno");
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static int a(int paramInt)
  {
    int i = 480;
    if (paramInt < 480)
      i = 320;
    while (paramInt < 720)
      return i;
    if (paramInt < 1080)
      return 720;
    return 1080;
  }

  public static String a(String paramString)
  {
    try
    {
      paramString = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
    }
    return null;
  }

  public static void a(Context paramContext)
  {
  }

  public static boolean a()
  {
    return c.equals("meizu");
  }

  @TargetApi(19)
  public static boolean a(Context paramContext, int paramInt)
  {
    paramContext = (AppOpsManager)paramContext.getSystemService("appops");
    Method localMethod = arp.b(AppOpsManager.class, "checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
    try
    {
      paramInt = ((Integer) arp.a(paramContext, localMethod, new Object[]{Integer.valueOf(paramInt), Integer.valueOf(Binder.getCallingUid()), "com.lazyswipe"})).intValue();
      if (paramInt == 0)
        return true;
      if (3 == paramInt)
      {
        paramInt = VERSION.SDK_INT;
        if (paramInt <= 22);
      }
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    catch (Exception paramContext)
    {
      Log.w("Swipe.DeviceUtils", "checkOp failed", paramContext);
    }
    return false;
  }

  public static boolean aa()
  {
    return (Build.MODEL.startsWith("XT103")) && (Build.MANUFACTURER.equals("motorola"));
  }

  public static boolean ab()
  {
    return (Build.MODEL.equals("XT1254")) && (Build.MANUFACTURER.equals("motorola"));
  }

  public static int ac()
  {
    return vj.e;
  }

  public static int ad()
  {
    return vj.f;
  }

  public static int ae()
  {
    return Math.min(vj.e, vj.f);
  }

  public static int af()
  {
    return Math.max(vj.e, vj.f);
  }

  public static int ag()
  {
    return (int)Math.hypot(vj.e, vj.f);
  }

  public static boolean ah()
  {
    boolean bool = false;
    if (e != null)
      return e.booleanValue();
    if (VERSION.SDK_INT < 22)
      e = Boolean.valueOf(false);
    while (true)
    {
      return e.booleanValue();
      String str = VERSION.RELEASE;
      if (TextUtils.isEmpty(str))
      {
        e = Boolean.valueOf(false);
      }
      else
      {
        if (asi.a(str.replaceAll("\\.", ""), 50) > 51)
          bool = true;
        e = Boolean.valueOf(bool);
      }
    }
  }

  public static boolean ai()
  {
//    if (a());
//    while ((VERSION.SDK_INT < 22) && (!W()) && ((VERSION.SDK_INT <= 21) || ((!aj()) && (!Build.BRAND.equals("motorola")) && (!Build.BRAND.equals("Sony")) && (!X()) && (!K()))))
//      return false;
//    return true;
    if (a());
    while ( ((VERSION.SDK_INT <= 21) || ((!aj()) && (!Build.BRAND.equals("motorola")) && (!Build.BRAND.equals("Sony")) && (!X()) && (!K()))))
      return false;
    return true;
  }

  public static boolean aj()
  {
    return !TextUtils.isEmpty(a("ro.cm.version"));
  }

  public static int ak()
  {
    if (vj.n)
      return 0;
    if (-1 == vj.o)
      vj.o = asq.a(25.0F);
    return vj.o;
  }

  public static int b(Context paramContext, int paramInt)
  {
    return a(Math.min(ae(), paramInt));
  }

  public static boolean b()
  {
    return a.contains("meizu_mx");
  }

  @TargetApi(19)
  public static boolean b(Context paramContext)
  {
    if (VERSION.SDK_INT >= 19)
      return a(paramContext, 24);
    paramContext = Integer.toBinaryString(paramContext.getApplicationInfo().flags);
    int i = paramContext.length() - 28;
    return (i >= 0) && (paramContext.charAt(i) == '1');
  }

  public static void c(Context paramContext)
  {
    asq.d(paramContext, new Intent("com.meizu.safe.security.SHOW_APPSEC").putExtra("packageName", "com.lazyswipe").addFlags(268435456));
  }

  public static boolean c()
  {
    return a.contains("meizu_mx2");
  }

  public static void d(Context paramContext)
  {
    asq.d(paramContext, new Intent().setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionTopActivity"));
  }

  public static boolean d()
  {
    return a.contains("meizu_mx3");
  }

  public static void e(Context paramContext)
  {
    try
    {
      paramContext.startActivity(new Intent().setClassName("com.oppo.purebackground", "com.oppo.purebackground.PurebackgroundTopActivity").addFlags(268435456));
      return;
    }
    catch (Exception paramContext)
    {
      Log.w("Swipe.DeviceUtils", "Failed to launch Oppo pure background: " + Y());
    }
  }

  public static boolean e()
  {
    return a.contains("meizu_mx4");
  }

  public static void f(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      Log.w("Swipe.DeviceUtils", "Failed to launch HuaWei Proected Apps: " + Y());
    }
  }

  public static boolean f()
  {
    return a.startsWith("meizu_mx");
  }

  public static void g(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      Log.w("Swipe.DeviceUtils", "Failed to launch HuaWei Startup Manager: " + Y());
    }
  }

  public static boolean g()
  {
    return (c.startsWith("meizu")) && (a.contains("m2 note"));
  }

  public static void h(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent();
      String str;
      if (M())
        str = "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity";
      while (true)
      {
        localIntent.setClassName("com.huawei.systemmanager", str).putExtra("showTabsNumber", 1).addFlags(268435456);
        paramContext.startActivity(localIntent);
        return;
        if (L())
          str = "com.huawei.systemmanager.SystemManagerMainActivity";
        else
          str = "com.huawei.notificationmanager.ui.NotificationManagmentActivity";
      }
    }
    catch (Exception paramContext)
    {
      Log.w("Swipe.DeviceUtils", "Failed to launch HuaWei NotificationManagementActivity: " + Y());
    }
  }

  public static boolean h()
  {
    return c.equalsIgnoreCase("tcl");
  }

  public static boolean i()
  {
    return (c.equals("zte")) && (b.contains("zte u985"));
  }

  public static boolean i(Context paramContext)
  {
    Intent localIntent = new Intent().setClassName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
    if ((!H()) || (!asq.d(paramContext, localIntent)))
    {
      j(paramContext);
      return false;
    }
    return true;
  }

  public static void j(Context paramContext)
  {
    Intent localIntent;
    if (H())
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", "com.lazyswipe");
    }
    try
    {
      while (true)
      {
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
        return;
        localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.addFlags(32768);
        localIntent.setData(Uri.fromParts("package", "com.lazyswipe", null));
      }
    }
    catch (Exception paramContext)
    {
      Log.e("Swipe.DeviceUtils", "startMiuiPermissionActivity failed, no activity found: " + localIntent);
    }
  }

  public static boolean j()
  {
    return (c.equals("htc")) && (b.contains("htc one x"));
  }

  public static boolean k()
  {
    return (c.equals("htc")) && (b.contains("htc 802w"));
  }

  public static boolean k(Context paramContext)
  {
    return asq.c(paramContext, "com.huawei.systemmanager");
  }

  public static String l(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext != null)
        return paramContext;
      return "";
    }
    catch (Exception paramContext)
    {
    }
    return "";
  }

  public static boolean l()
  {
    return b.contains("htc 801e");
  }

  public static String m(Context paramContext)
  {
    String str1 = l(paramContext);
    String str2 = str1;
    if (str1 == null)
      str2 = "";
    str1 = asl.b(paramContext);
    String str3;
    if (str1 != null)
    {
      str3 = str1;
      if (!str1.equals(str2));
    }
    else
    {
      str3 = "";
    }
    str1 = null;
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
      str1 = arl.c(paramContext);
    paramContext = str1;
    if (str1 == null)
      paramContext = "";
    return str2 + "_" + str3 + "_" + paramContext;
  }

  public static boolean m()
  {
    return (c.equals("samsung")) && (b.equals("gt-i9100"));
  }

  public static String n(Context paramContext)
  {
    String str2 = asl.b(paramContext);
    String str1 = Z();
    if (TextUtils.isEmpty(str2))
    {
      paramContext = arl.c(paramContext);
      if (!TextUtils.isEmpty(paramContext))
        return arh.b(paramContext + "_" + str1);
      return "";
    }
    return arh.b(str2 + "_" + str1);
  }

  public static boolean n()
  {
    return b.startsWith("mi-one");
  }

  public static String o(Context paramContext)
  {
    String str1 = asl.b(paramContext);
    paramContext = l(paramContext);
    String str2 = Z();
    return arh.a(str1 + paramContext + str2);
  }

  public static boolean o()
  {
    return (c.equals("xiaomi")) && (Build.DEVICE.startsWith("HM"));
  }

  public static boolean p()
  {
    return c.equals("xiaomi");
  }

  public static boolean p(Context paramContext)
  {
    return (paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3;
  }

  public static boolean q()
  {
    return b.equalsIgnoreCase("gt-s5830");
  }

  public static boolean q(Context paramContext)
  {
    if (v())
      return true;
    paramContext = (SensorManager)paramContext.getSystemService("sensor");
    if (paramContext != null)
    {
      paramContext = paramContext.getSensorList(5);
      if ((paramContext != null) && (!paramContext.isEmpty()));
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    return false;
  }

  public static int r(Context paramContext)
  {
    int i = 1;
    Object localObject;
    if (VERSION.SDK_INT >= 17)
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      localObject = new Point();
      paramContext.getRealSize((Point)localObject);
      i = ((Point)localObject).x;
      int j = ((Point)localObject).y;
      paramContext.getSize((Point)localObject);
      i = Math.max(i - ((Point)localObject).x, j - ((Point)localObject).y);
    }
    while (true)
    {
      asp.a("Swipe.DeviceUtils", "Navigation bar height: " + i);
      return i;
      Resources localResources = paramContext.getResources();
      String str = "navigation_bar_height";
      if (1 == localResources.getConfiguration().orientation);
      while (true)
      {
        localObject = str;
        if (i == 0)
        {
          localObject = str;
          if (p(paramContext))
            localObject = "navigation_bar_height_landscape";
        }
        i = localResources.getIdentifier((String)localObject, "dimen", "android");
        if (i <= 0)
          break label181;
        i = localResources.getDimensionPixelSize(i);
        break;
        i = 0;
      }
      label181: i = 0;
    }
  }

  public static boolean r()
  {
    return b.equalsIgnoreCase("gt-s5830i");
  }

  public static boolean s()
  {
    return b.equalsIgnoreCase("gt-p1000");
  }

  public static boolean s(Context paramContext)
  {
    boolean bool1 = true;
    int i;
    if (VERSION.SDK_INT >= 17)
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      Point localPoint = new Point();
      paramContext.getRealSize(localPoint);
      i = localPoint.x;
      int j = localPoint.y;
      paramContext.getSize(localPoint);
      int k = localPoint.x;
      int m = localPoint.y;
      if ((i - k > 0) || (j - m > 0))
        bool1 = true;
    }
    boolean bool2;
    boolean bool3;
    do
    {
      while (true)
      {
        asp.a("Swipe.DeviceUtils", "Navigation bar present? " + bool1);
        return bool1;
        bool1 = false;
        continue;
        i = paramContext.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        if (i <= 0)
          break;
        bool1 = paramContext.getResources().getBoolean(i);
      }
      bool2 = KeyCharacterMap.deviceHasKey(4);
      bool3 = KeyCharacterMap.deviceHasKey(3);
    }
    while ((!bool2) && (!bool3));
    while (true)
      bool1 = false;
  }

  public static boolean t()
  {
    return b.startsWith("me525");
  }

  public static boolean t(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (vj.d == 160)
    {
      bool1 = bool2;
      if (ae() >= 600)
        bool1 = true;
    }
    return bool1;
  }

  public static boolean u()
  {
    return b.startsWith("me860");
  }

  public static boolean v()
  {
    return b.startsWith("lg-p970");
  }

  public static boolean w()
  {
    return b.startsWith("u8800");
  }

  public static boolean x()
  {
    return b.equalsIgnoreCase("deovo v5");
  }

  public static boolean y()
  {
    return b.contains("lenovo a850");
  }

  public static boolean z()
  {
    return b.equalsIgnoreCase("lenovo a789");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqs
 * JD-Core Version:    0.6.2
 */