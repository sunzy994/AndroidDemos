package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.g.a;
import com.facebook.ads.internal.util.r;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class AdSettings
{
  public static final boolean DEBUG = false;
  static volatile boolean a = false;
  private static final String b = AdSettings.class.getSimpleName();
  private static final Collection<String> c;
  private static final Collection<String> d;
  private static String e = null;
  private static boolean f = false;
  private static String g = null;

  static
  {
    c = new HashSet();
    d = new HashSet();
    d.add("sdk");
    d.add("google_sdk");
    d.add("vbox86p");
    d.add("vbox86tp");
  }

  private static void a(String paramString)
  {
    if (a)
      return;
    a = true;
    Log.d(b, "Test mode device hash: " + paramString);
    Log.d(b, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + paramString + "\");");
  }

  public static void addTestDevice(String paramString)
  {
    c.add(paramString);
  }

  public static void addTestDevices(Collection<String> paramCollection)
  {
    c.addAll(paramCollection);
  }

  public static void clearTestDevices()
  {
    c.clear();
  }

  public static String getUrlPrefix()
  {
    return e;
  }

  public static boolean isChildDirected()
  {
    return f;
  }

  public static boolean isTestMode(Context paramContext)
  {
    if (d.contains(Build.PRODUCT))
      return true;
    SharedPreferences localSharedPreferences;
    if (g == null)
    {
      localSharedPreferences = paramContext.getSharedPreferences("FBAdPrefs", 0);
      g = localSharedPreferences.getString("deviceIdHash", null);
      if (r.a(g))
      {
        paramContext = g.a(paramContext.getContentResolver());
        if (r.a(paramContext.b))
          break label122;
        g = r.b(paramContext.b);
      }
    }
    while (true)
    {
      localSharedPreferences.edit().putString("deviceIdHash", g).apply();
      if (c.contains(g))
        break;
      a(g);
      return false;
      label122: if (!r.a(paramContext.a))
        g = r.b(paramContext.a);
      else
        g = r.b(UUID.randomUUID().toString());
    }
  }

  public static void setIsChildDirected(boolean paramBoolean)
  {
    f = paramBoolean;
  }

  public static void setUrlPrefix(String paramString)
  {
    e = paramString;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.AdSettings
 * JD-Core Version:    0.6.2
 */