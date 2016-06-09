package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.splash.SplashView;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahl
{
  private static final String a = new File(aro.c(), "splash").getAbsolutePath();
  private static Long b;
  private static List<ahm> c;
  private static boolean d;

  private static SharedPreferences a(String paramString, int paramInt)
  {
    return SwipeApplication.c().getSharedPreferences(paramString, paramInt);
  }

  private static List<ahm> a(Context paramContext)
  {
    try
    {
      paramContext = b(b(paramContext, "splash", "pref_local_list", ""));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
    }
    return null;
  }

  public static void a(final Activity paramActivity)
  {
    final Integer localInteger = null;
    long l1;
    long l2;
    int i;
    ahm localahm;
    try
    {
      if (apz.b())
        return;
      l1 = System.currentTimeMillis();
      l2 = b(paramActivity, "splash", "pref_last_display_time", 0L);
      if ((l1 > l2) && (l1 - l2 < b(paramActivity, "splash", "pref_display_interval", 0L)))
        return;
      if (!a(paramActivity, l2))
        c(paramActivity, "splash", "pref_display_count", 0L);
      l2 = b(paramActivity, "splash", "pref_display_count", 0L);
      long l3 = b(paramActivity, "splash", "pref_max_display_count", -1L);
      if ((l3 >= 0L) && (l2 >= l3))
        return;
      if (b == null)
        b = Long.valueOf(b(paramActivity, "splash", "pref_last_req_time", 0L));
      if (((l1 - b.longValue() > b(paramActivity, "splash", "pref_req_interval", 86400000L)) || (b.longValue() > l1)) && (arl.i(paramActivity)) && (art.b()))
        b(paramActivity);
      if (c == null)
        c = a(paramActivity);
      if ((c == null) || (c.isEmpty()))
        return;
      i = (int)(Math.random() * c.size());
      localahm = (ahm)c.get(i);
      if ((!TextUtils.isEmpty(localahm.h)) && (asq.c(paramActivity, localahm.h)))
      {
        c.remove(localahm);
        c(paramActivity, "splash", "pref_local_list", c(c));
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      Log.e("Swipe.SplashController", "Failed to show the splash", paramActivity);
      return;
    }
    File localFile = new File(a, localahm.d);
    if (localFile.exists())
    {
      final SplashView localSplashView = (SplashView)LayoutInflater.from(paramActivity).inflate(2130968748, null);
      localSplashView.setImage(BitmapFactory.decodeFile(localFile.getPath()));
      localSplashView.setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!TextUtils.isEmpty(ahl.this.g))
          {
            paramAnonymousView = abf.a(paramActivity, ahl.this.g, -1);
            ahl.a(paramActivity, paramAnonymousView);
          }
          vy.a(paramActivity, "CA", ahl.this.e);
          ahl.this.a.a(paramActivity, ahl.this);
        }
      });
      c(paramActivity, "splash", "pref_last_display_time", System.currentTimeMillis());
      c(paramActivity, "splash", "pref_display_count", l2 + 1L);
      paramActivity.addContentView(localSplashView, new LayoutParams(-1, -1));
      vy.a(paramActivity, "CA", localahm.e);
      l1 = 1000L * Math.min(10, localahm.c);
      i = paramActivity.getRequestedOrientation();
      if (i != 1)
      {
        localInteger = Integer.valueOf(i);
        paramActivity.setRequestedOrientation(1);
      }
      if (!TextUtils.isEmpty(localahm.f))
        b(paramActivity, abf.a(paramActivity, localahm.f, -1));
      localSplashView.a(l1, paramActivity, Integer.valueOf(i));
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          ahl.a(ahl.this, localSplashView, localInteger);
        }
      }
      , l1);
    }
  }

  public static void a(Activity paramActivity, SplashView paramSplashView, Integer paramInteger)
  {
    if (paramInteger != null)
      paramActivity.setRequestedOrientation(paramInteger.intValue());
    paramActivity = paramSplashView.getParent();
    if ((paramActivity != null) && ((paramActivity instanceof ViewGroup)))
      ((ViewGroup)paramActivity).removeView(paramSplashView);
  }

  private static boolean a(Context paramContext, long paramLong)
  {
    paramContext = Calendar.getInstance();
    paramContext.setTimeInMillis(paramLong);
    Calendar localCalendar = Calendar.getInstance();
    return (localCalendar.get(1) == paramContext.get(1)) && (localCalendar.get(2) == paramContext.get(2)) && (localCalendar.get(5) == paramContext.get(5));
  }

  private static long b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, 1).getLong(paramString2, paramLong);
  }

  private static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, 1).getString(paramString2, paramString3);
  }

  private static List<ahm> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new JSONArray(paramString);
      i = 0;
    }
    while (true)
    {
      if (i < paramString.length());
      while (true)
      {
        int j;
        try
        {
          Object localObject1 = paramString.getJSONObject(i);
          ahm localahm = new ahm();
          localahm.f = ((JSONObject)localObject1).optString("impressionLogUrl");
          localahm.g = ((JSONObject)localObject1).optString("clickLogUrl");
          localahm.h = ((JSONObject)localObject1).optString("packageName");
          localahm.e = ((JSONObject)localObject1).optString("id");
          localahm.d = ((JSONObject)localObject1).getString("imgUrl");
          localahm.b = ((JSONObject)localObject1).optString("param");
          localahm.c = ((JSONObject)localObject1).optInt("stayTime", 3);
          int k = ((JSONObject)localObject1).getInt("type");
          localObject1 = ahn.values();
          int m = localObject1.length;
          j = 0;
          if (j < m)
          {
            Object localObject2 = localObject1[j];
            if (k != localObject2.c)
              break label275;
            localahm.a = localObject2;
            break label275;
          }
          if (localahm.a == null)
            Log.w("Swipe.SplashController", "Splash type " + k + " is not supported and ignored.");
          else
            localArrayList.add(localahm);
        }
        catch (Throwable localThrowable)
        {
          Log.e("Swipe.SplashController", "Failed to parse the " + i + "th element", localThrowable);
        }
        return localArrayList;
        label275: j += 1;
      }
      i += 1;
    }
  }

  private static void b(Context paramContext)
  {
    if (d)
      return;
    d = true;
    new AsyncTask()
    {
      public Void a(Void[] paramAnonymousArrayOfVoid)
      {
        while (true)
        {
          Object localObject;
          HashSet localHashSet;
          Iterator localIterator;
          ahm localahm;
          File localFile1;
          File localFile2;
          boolean bool;
          try
          {
            paramAnonymousArrayOfVoid = String.format("http://a.lazyswipe.cn//splashs?w=%s&pcode=%s&vcode=%s", new Object[] { Integer.valueOf(aqs.ae()), "300105", "00" });
            paramAnonymousArrayOfVoid = new arb(ahl.this).a(paramAnonymousArrayOfVoid, null);
            if (TextUtils.isEmpty(paramAnonymousArrayOfVoid))
              break label628;
            paramAnonymousArrayOfVoid = new JSONObject(paramAnonymousArrayOfVoid);
            localObject = paramAnonymousArrayOfVoid.getString("results");
            if (TextUtils.isEmpty((CharSequence)localObject))
              break label527;
            localObject = ahl.a((String)localObject);
            localHashSet = new HashSet();
            localIterator = ((List)localObject).iterator();
            if (!localIterator.hasNext())
              break label402;
            localahm = (ahm)localIterator.next();
            if ((!TextUtils.isEmpty(localahm.h)) && (asq.c(ahl.this, localahm.h)))
            {
              Log.w("Swipe.SplashController", "Target packageName " + localahm.h + " and it is ignored");
              localIterator.remove();
              continue;
            }
          }
          catch (Throwable paramAnonymousArrayOfVoid)
          {
            Log.e("Swipe.SplashController", "Failed to query from the server.", paramAnonymousArrayOfVoid);
            return null;
            String str = arh.a(localahm.d);
            localFile1 = new File(ahl.a(), str + "_temp");
            localFile2 = new File(ahl.a(), str);
            if (localFile2.exists())
            {
              bool = true;
              if (!bool)
                break label358;
              localahm.d = str;
              localHashSet.add(localahm.d);
              continue;
            }
          }
          finally
          {
            ahl.a(false);
          }
          if ((new arb(ahl.this).a(localahm.d, null, localFile1)) && (localFile1 != null) && (localFile1.exists()))
          {
            bool = localFile1.renameTo(localFile2);
            continue;
            label358: Log.w("Swipe.SplashController", "Failed to load the splash image from " + localahm.d + " and ignored.");
            localIterator.remove();
            continue;
            label402: ahl.a(ahl.this, "splash", "pref_local_list", ahl.a((List)localObject));
            ahl.a(Long.valueOf(System.currentTimeMillis()));
            ahl.a(ahl.this, "splash", "pref_last_req_time", ahl.b().longValue());
            if (ahl.c() != null)
            {
              localIterator = new ArrayList(ahl.c()).iterator();
              while (localIterator.hasNext())
              {
                localahm = (ahm)localIterator.next();
                if (!localHashSet.contains(localahm.d))
                  aqx.e(new File(localahm.d));
              }
            }
            ahl.b((List)localObject);
            label527: int i;
            if (paramAnonymousArrayOfVoid.has("reqInterval"))
            {
              i = paramAnonymousArrayOfVoid.getInt("reqInterval");
              ahl.a(ahl.this, "splash", "pref_req_interval", i * 1000);
            }
            if (paramAnonymousArrayOfVoid.has("displayInterval"))
            {
              i = paramAnonymousArrayOfVoid.getInt("displayInterval");
              ahl.a(ahl.this, "splash", "pref_display_interval", i * 1000);
            }
            if (paramAnonymousArrayOfVoid.has("maxDisplay"))
            {
              i = paramAnonymousArrayOfVoid.getInt("maxDisplay");
              ahl.a(ahl.this, "splash", "pref_max_display_count", i);
            }
            label628: ahl.a(false);
            return null;
          }
          else
          {
            bool = false;
          }
        }
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private static void b(Context paramContext, final String paramString)
  {
    try
    {
      new Thread()
      {
        public void run()
        {
          new arb(ahl.this).a(paramString, null);
        }
      }
      .start();
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }

  private static String c(List<ahm> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ahm localahm = (ahm)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("impressionLogUrl", localahm.f);
      localJSONObject.put("clickLogUrl", localahm.g);
      localJSONObject.put("packageName", localahm.h);
      if (!TextUtils.isEmpty(localahm.e))
        localJSONObject.put("id", localahm.e);
      localJSONObject.put("imgUrl", localahm.d);
      localJSONObject.put("param", localahm.b);
      localJSONObject.put("stayTime", localahm.c);
      localJSONObject.put("type", localahm.a.c);
      localJSONArray.put(localJSONObject);
    }
    return localJSONArray.toString();
  }

  private static void c(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    a(paramString1, 1).edit().putLong(paramString2, paramLong).apply();
  }

  private static void c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, 1).edit().putString(paramString2, paramString3).apply();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahl
 * JD-Core Version:    0.6.2
 */