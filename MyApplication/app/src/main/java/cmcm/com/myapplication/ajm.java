package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class ajm
{
  static final String a = "Swipe." + ajm.class.getSimpleName();
  private static final Map<String, Integer> b = new HashMap();
  private static final Map<String, Integer> c = new HashMap();

  static
  {
    b.put("com.lazyswipe", Integer.valueOf(1));
  }

  public static long a(Context paramContext)
  {
    return vs.a(paramContext, "pref_upgrade_last_upgrade_time", 0L);
  }

  public static ajl a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString);
  }

  public static Intent a(Context paramContext, Class<?> paramClass)
  {
    paramContext = new Intent(paramContext, paramClass);
    paramContext.addFlags(67108864);
    paramContext.addFlags(536870912);
    paramContext.addFlags(268435456);
    return paramContext;
  }

  public static void a(Context paramContext, long paramLong)
  {
    vs.b(paramContext, "pref_upgrade_last_upgrade_time", paramLong);
  }

  public static void a(String paramString)
  {
    a(paramString, false);
  }

  public static void a(String paramString, boolean paramBoolean)
  {
    Map localMap = c;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localMap.put(paramString, Integer.valueOf(i));
      return;
    }
  }

  public static boolean a(Context paramContext, ajl paramajl, Intent paramIntent, atd paramatd, ajn paramajn)
  {
    if (paramajl.f())
    {
      if (yb.getInstance() != null)
        yb.getInstance().c(false);
      asq.a(paramContext, "com.lazyswipe", true, true);
    }
    do
    {
      return false;
      if (art.d())
        break;
      aqt.a(paramContext, paramContext.getString(2131230917), paramContext.getString(2131230920));
    }
    while (paramajn == null);
    paramajn.a(-1);
    return false;
    paramContext = new atc(paramContext, paramajl.a(), paramajl.b(), paramajl.d, paramajl.h, new asz(), paramatd);
    paramContext.a(paramIntent);
    paramContext.a();
    return true;
  }

  public static boolean a(Context paramContext, ajl paramajl1, Intent paramIntent, atd paramatd, ajn paramajn, ajl paramajl2)
  {
    if (c(paramajl1.g))
    {
      aso.a(paramContext, 2131230923);
      return false;
    }
    return a(paramContext, paramajl2, paramIntent, paramatd, paramajn);
  }

  private static ajl b(Context paramContext, String paramString)
  {
    paramString = aqg.a().execute((HttpGet) aqg.a(paramContext, c(paramContext, paramString), true, true));
    int i = paramString.getStatusLine().getStatusCode();
    if (200 == i)
    {
      paramString = aqg.a(paramString);
      paramContext = ajl.a(paramContext, arf.a(paramString));
      paramString.close();
      return paramContext;
    }
    if (304 == i)
      return null;
    throw new IOException("Error response status code:" + i);
  }

  public static void b(String paramString)
  {
    c.remove(paramString);
  }

  public static boolean b(Context paramContext)
  {
    paramContext = ajl.a(paramContext);
    return (paramContext != null) && (paramContext.e());
  }

  public static boolean b(String paramString, boolean paramBoolean)
  {
    if (!c.containsKey(paramString))
      return false;
    int i = ((Integer)c.get(paramString)).intValue();
    if ((paramBoolean) || (i == 0));
    for (paramBoolean = true; ; paramBoolean = false)
      return paramBoolean;
  }

  private static String c(Context paramContext, String paramString)
  {
    paramContext = asq.v(paramContext);
    if (!TextUtils.isEmpty(paramString))
      paramContext.put("entry", paramString);
    paramContext = asq.b(paramContext);
    return "http://a.lazyswipe.cn//clients/upgrade?" + paramContext;
  }

  public static boolean c(String paramString)
  {
    return b(paramString, false);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajm
 * JD-Core Version:    0.6.2
 */