package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.tile.MirrorActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class anu
{
  private static final String a = "Swipe." + anu.class.getSimpleName();
  private static final List<String> b = new ArrayList();
  private static final Map<String, anv> c;
  private static final Map<String, anv> d = new HashMap();
  private static final Map<String, anv> e = new HashMap();

  static
  {
    b.add("Camera");
    b.add("Music volume");
    b.add("Sound");
    b.add("Brightness");
    b.add("Booster");
    b.add("Flashlight");
    b.add("Wi-Fi");
    b.add("Mobile data");
    b.add("Swipe settings");
    c = Collections.unmodifiableMap(d);
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    Resources localResources = localSwipeApplication.getResources();
    a(new anv("Airplane mode", 2131231110, 2130837810, localResources));
    a(new anv("Bluetooth", 2131231113, 2130837813, localResources));
    a(new anv("Brightness", 2131231115, 2130837818, localResources));
    a(new anv("Camera", 2131231116, 2130837820, localResources));
    a(new anv("Mobile data", 2131231121, 2130837825, localResources));
    a(new anv("Screen rotation", 2131231129, 2130837836, localResources));
    a(new anv("Screen timeout", 2131231130, 2130837837, localResources));
    a(new anv("Sound", 2131231125, 2130837833, localResources));
    a(new anv("Flashlight", 2131231118, 2130837822, localResources));
    a(new anv("Music volume", 2131231122, 2130837829, localResources));
    a(new anv("Wi-Fi", 2131231135, 2130837846, localResources));
    a(new anv("Wi-Fi AP", 2131231136, 2130837847, localResources));
    a(new anv("Booster", 2131231114, 2130837814, localResources));
    a(new anv("Home", 2131231119, 2130837823, localResources));
    a(new anv("Sleep", 2131231131, 2130837842, localResources));
    a(new anv("Swipe settings", 2131231132, 2130837843, localResources));
    a(new anv("System settings", 2131231133, 2130837844, localResources));
    a(new anv("Search", 2131230947, 2130837841, localResources));
    a(new anv("Theme", 2131231134, 2130837845, localResources));
    a(new anv("PowerSaving mode", 2131231123, 2130837830, localResources));
    if (Build.VERSION.SDK_INT >= 21)
      d.put("Screen capture", new anv("Screen capture", 2131231128, 2130837835, localResources));
    while (true)
    {
      d.put("Recent apps", new anv("Recent apps", 2131231124, 2130837831, localResources));
      if (Build.VERSION.SDK_INT >= 16)
        d.put("Back", new anv("Back", 2131231112, 2130837812, localResources));
      Intent localIntent = amu.f(localSwipeApplication);
      if (localIntent != null)
      {
        PackageManager localPackageManager = localSwipeApplication.getPackageManager();
        a(new anv("Calculator", localPackageManager.resolveActivity(localIntent, 0).activityInfo.loadLabel(localPackageManager), 2130837819, localResources));
      }
      if (amn.c(localSwipeApplication) != null)
        a(new anv("Alarm", 2131231111, 2130837811, localResources));
      if (MirrorActivity.a())
        a(new anv("Mirror", 2131231120, 2130837824, localResources));
      return;
      e.put("Screen capture", new anv("Screen capture", 2131231128, 2130837835, localResources));
    }
  }

  public static ans a(Context paramContext, String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 931691921:
    case -322116978:
    case 1729588080:
    case -1653340047:
    case 2011082565:
    case 295439432:
    case 810391366:
    case -163077998:
    case 1730169293:
    case 80074991:
    case 83519902:
    case 1355368945:
    case -2104856171:
    case 2255103:
    case 79969975:
    case -698301518:
    case -1530549655:
    case 618850004:
    case -413606665:
    case 2062599:
    case -991782967:
    case -1822469688:
    case 80774569:
    case 854935330:
    case -1990043681:
    case 63343153:
    case 774209764:
    }
    while (true)
      switch (i)
      {
      default:
        return null;
        if (paramString.equals("Airplane mode"))
        {
          i = 0;
          continue;
          if (paramString.equals("Bluetooth"))
          {
            i = 1;
            continue;
            if (paramString.equals("Booster"))
            {
              i = 2;
              continue;
              if (paramString.equals("Brightness"))
              {
                i = 3;
                continue;
                if (paramString.equals("Camera"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("Mobile data"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("Flashlight"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("Screen rotation"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("Screen timeout"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("Sound"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("Wi-Fi"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("Wi-Fi AP"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("Music volume"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("Home"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("Sleep"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("Screen capture"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("Swipe settings"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString.equals("System settings"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString.equals("Recent apps"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString.equals("Back"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString.equals("Expand SystemUI"))
                                                {
                                                  i = 20;
                                                  continue;
                                                  if (paramString.equals("Search"))
                                                  {
                                                    i = 21;
                                                    continue;
                                                    if (paramString.equals("Theme"))
                                                    {
                                                      i = 22;
                                                      continue;
                                                      if (paramString.equals("Calculator"))
                                                      {
                                                        i = 23;
                                                        continue;
                                                        if (paramString.equals("Mirror"))
                                                        {
                                                          i = 24;
                                                          continue;
                                                          if (paramString.equals("Alarm"))
                                                          {
                                                            i = 25;
                                                            continue;
                                                            if (paramString.equals("PowerSaving mode"))
                                                              i = 26;
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      }
    return new amm(paramContext);
    return new amr(paramContext);
    return new ams(paramContext);
    return new amt(paramContext);
    return new amv(paramContext);
    return new ane(paramContext);
    return new amy(paramContext);
    return new ank(paramContext);
    return new anl(paramContext);
    return new ani(paramContext);
    return new anx(paramContext);
    return new anw(paramContext);
    return new anf(paramContext);
    return new ana(paramContext);
    return new ann(paramContext);
    return new anj(paramContext);
    return new anp(paramContext);
    return new anq(paramContext);
    return new anh(paramContext);
    return new amp(paramContext);
    return new amx(paramContext);
    return new anm(paramContext);
    return new anr(paramContext);
    return new amu(paramContext);
    return new anb(paramContext);
    return new amn(paramContext);
    return new ang(paramContext);
  }

  public static String a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
      return "";
    return TextUtils.join("|", paramList);
  }

  public static List<String> a(Context paramContext, boolean paramBoolean)
  {
    return a(b(paramContext, paramBoolean));
  }

  public static List<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return new ArrayList(0);
    return new ArrayList(Arrays.asList(paramString.split("\\|")));
  }

  public static Map<String, anv> a(Context paramContext)
  {
    if (vs.v(paramContext))
      d("Screen capture");
    while (true)
    {
      return c;
      if (Build.VERSION.SDK_INT < 21)
        c("Screen capture");
    }
  }

  public static void a()
  {
    vs.b(SwipeApplication.c(), "key_switchers_ever_changed", true);
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    vs.b(paramContext, "key_pre_power_saving_mode_brightness", paramInt1);
    vs.b(paramContext, "key_pre_power_saving_mode_brightness_mode", paramInt2);
    vs.b(paramContext, "key_pre_power_saving_mode_timeout", paramInt3);
  }

  static void a(anv paramanv)
  {
    d.put(paramanv.a(), paramanv);
  }

  public static boolean a(boolean paramBoolean)
  {
    return vs.c(SwipeApplication.c(), "key_has_power_saving_mode", paramBoolean);
  }

  public static String b(Context paramContext, boolean paramBoolean)
  {
    String str2 = vs.a(paramContext).getString("key_switchers", null);
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = c(paramContext);
        b(paramContext, str1);
      }
    }
    return str1;
  }

  public static List<String> b(Context paramContext)
  {
    if (!b());
    for (boolean bool = true; ; bool = false)
      return a(paramContext, bool);
  }

  public static void b(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    vs.b(paramContext, "key_cur_power_saving_mode_brightness", paramInt1);
    vs.b(paramContext, "key_cur_power_saving_mode_brightness_mode", paramInt2);
    vs.b(paramContext, "key_cur_power_saving_mode_timeout", paramInt3);
  }

  public static void b(Context paramContext, String paramString)
  {
    vs.a(paramContext).edit().putString("key_switchers", paramString).apply();
  }

  private static void b(String paramString)
  {
    d.remove(paramString);
    e.remove(paramString);
    b.remove(paramString);
  }

  public static boolean b()
  {
    return vs.c(SwipeApplication.c(), "key_switchers_ever_changed", false);
  }

  public static int c()
  {
    return vs.a(SwipeApplication.c(), "key_pre_power_saving_mode_brightness", -1);
  }

  public static String c(Context paramContext)
  {
    d(paramContext);
    int k = aao.b(paramContext) - b.size();
    if (k > 0)
    {
      paramContext = new ArrayList(b);
      Iterator localIterator = d.keySet().iterator();
      int i = 0;
      while (true)
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!paramContext.contains(str))
          {
            paramContext.add(str);
            int j = i + 1;
            i = j;
            if (j < k);
          }
        }
        else
        {
          return TextUtils.join("|", paramContext);
        }
    }
    return TextUtils.join("|", b);
  }

  public static void c(Context paramContext, boolean paramBoolean)
  {
    vs.b(paramContext, "key_has_power_saving_mode", paramBoolean);
  }

  private static void c(String paramString)
  {
    if (d.containsKey(paramString))
      e.put(paramString, d.remove(paramString));
  }

  public static int d()
  {
    return vs.a(SwipeApplication.c(), "key_pre_power_saving_mode_brightness_mode", -1);
  }

  protected static void d(Context paramContext)
  {
    try
    {
      if (!asq.k(paramContext))
      {
        b("Mobile data");
        b("Wi-Fi AP");
      }
      if (!asq.e())
        b("Bluetooth");
      if (!asq.f())
      {
        b("Camera");
        b("Flashlight");
      }
      return;
    }
    finally
    {
    }
    throw paramContext;
  }

  private static void d(String paramString)
  {
    if (e.containsKey(paramString))
      d.put(paramString, e.remove(paramString));
  }

  public static int e()
  {
    return vs.a(SwipeApplication.c(), "key_pre_power_saving_mode_timeout", -1);
  }

  public static boolean e(Context paramContext)
  {
    boolean bool2 = false;
    List localList = b(paramContext);
    int j = Math.min(aao.b(paramContext), localList.size());
    int i = 0;
    while (true)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if ("Calculator".equals(localList.get(i)))
          bool1 = true;
      }
      else
        return bool1;
      i += 1;
    }
  }

  public static int f()
  {
    return vs.a(SwipeApplication.c(), "key_cur_power_saving_mode_brightness", -1);
  }

  public static int g()
  {
    return vs.a(SwipeApplication.c(), "key_cur_power_saving_mode_brightness_mode", -1);
  }

  public static int h()
  {
    return vs.a(SwipeApplication.c(), "key_cur_power_saving_mode_timeout", -1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anu
 * JD-Core Version:    0.6.2
 */