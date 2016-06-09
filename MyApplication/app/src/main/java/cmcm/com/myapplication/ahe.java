package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lagu;>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahe
{
  public static final String a = aro.b(SwipeApplication.c()).getAbsolutePath();
  private static agu b;
  private static List<agy> c;
  private static ahf d;
  private static boolean e;
  private static long f;

  private static CharSequence a(String paramString1, String paramString2, int paramInt)
  {
    int i = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
    if (i < 0)
      return null;
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new ForegroundColorSpan(paramInt), i, paramString2.length() + i, 33);
    return paramString1;
  }

  private static String a(String paramString)
  {
    if (paramString == null)
      return "";
    return asi.b(paramString);
  }

  public static List<String> a(Context paramContext)
  {
    paramContext = vs.a(paramContext, "pref_history_search_query", "");
    if (TextUtils.isEmpty(paramContext))
      return null;
    return new ArrayList(Arrays.asList(asi.a(paramContext, ',')));
  }

  public static List<ahk> a(Context paramContext, agu paramagu, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a(paramContext);
    if (paramString == null)
      return localArrayList;
    int j;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      if ((localList != null) && (!localList.isEmpty()))
      {
        j = localList.size();
        i = 0;
        while (i < j)
        {
          paramContext = new ahk((String)localList.get(i));
          paramContext.f = true;
          localArrayList.add(paramContext);
          i += 1;
        }
      }
    }
    else
    {
      paramContext = agt.a(paramContext, paramagu, paramString);
      int k = paramContext.size();
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramagu = new HashSet();
        int m = localList.size();
        i = 0;
        ahk localahk;
        if (i < m)
        {
          j = 0;
          while (true)
          {
            if (j < k)
            {
              localahk = (ahk)paramContext.get(j);
              if (((String)localList.get(i)).equalsIgnoreCase(localahk.e()))
              {
                paramagu.add(Integer.valueOf(i));
                localahk.f = true;
                localahk.a(a(localahk.e(), paramString, -14364694));
                localArrayList.add(localahk);
              }
            }
            else
            {
              i += 1;
              break;
            }
            j += 1;
          }
        }
        i = 0;
        while (i < m)
        {
          if ((!paramagu.contains(Integer.valueOf(i))) && (((String)localList.get(i)).toLowerCase().contains(paramString.toLowerCase())))
          {
            localahk = new ahk((String)localList.get(i));
            localahk.f = true;
            localahk.a(a(localahk.e(), paramString, -14364694));
            localArrayList.add(localahk);
          }
          i += 1;
        }
      }
      if (!paramContext.isEmpty())
      {
        i = 0;
        while (i < k)
        {
          paramagu = (ahk)paramContext.get(i);
          if (!paramagu.f)
          {
            paramagu.a(a(paramagu.e(), paramString, -14364694));
            localArrayList.add(paramContext.get(i));
          }
          i += 1;
        }
      }
      if (localArrayList.isEmpty())
      {
        paramContext = new ahk(paramString);
        paramContext.a(a(paramContext.e(), paramContext.e(), -14364694));
        localArrayList.add(paramContext);
      }
    }
    return localArrayList;
  }

  public static List<agy> a(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, paramBoolean);
    if (c != null)
      return c;
    paramContext = vs.a(paramContext, "pref_hotword_data", "");
    if (TextUtils.isEmpty(paramContext));
    for (c = new ArrayList(); ; c = b(paramContext))
      return c;
  }

  public static void a(Context paramContext, String paramString)
  {
    List localList = a(paramContext);
    Object localObject = localList;
    if (localList == null)
      localObject = new ArrayList();
    ((List)localObject).remove(paramString);
    ((List)localObject).add(0, paramString);
    if (((List)localObject).size() > 5)
      ((List)localObject).remove(((List)localObject).size() - 1);
    vs.b(paramContext, "pref_history_search_query", asi.a((Collection) localObject, ','));
  }

  private static void a(Context paramContext, List<agu> paramList)
  {
    while (true)
    {
      try
      {
        int i = vs.a(paramContext, "pref_se_set", -1);
        Object localObject2 = paramList;
        if (paramList == null)
          localObject2 = f(paramContext);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          paramList = null;
          Iterator localIterator = ((List)localObject2).iterator();
          if (!localIterator.hasNext())
            break label165;
          agu localagu = (agu)localIterator.next();
          localObject1 = paramList;
          if (paramList == null)
          {
            localObject1 = paramList;
            if (localagu.d())
              localObject1 = localagu;
          }
          if (localagu.a() != i)
          {
            paramList = (List<agu>)localObject1;
            if (i != -1)
              continue;
            paramList = (List<agu>)localObject1;
            if (!localagu.d())
              continue;
          }
          b = localagu;
          if (b == null)
          {
            vs.h(paramContext, "pref_se_set");
            b = (agu)localObject1;
          }
          if (b == null)
            b = (agu)((List)localObject2).get(0);
        }
        return;
      }
      finally
      {
      }
      label165: Object localObject1 = paramList;
    }
  }

  public static void a(Context paramContext, boolean paramBoolean, final Runnable paramRunnable)
  {
    if (!arl.i(paramContext));
    long l1;
    long l2;
    do
    {
      return;
      l1 = vs.a(paramContext, "pref_se_t", 0L);
      l2 = System.currentTimeMillis();
    }
    while ((!paramBoolean) && (l2 - l1 <= 86400000L) && (l2 >= l1));
    new Thread()
    {
      public void run()
      {
        ahe.d(ahe.this);
        if (paramRunnable != null)
          paramRunnable.run();
      }
    }
    .start();
  }

  public static String b(Context paramContext)
  {
    return "http://i.haloapps.com/se?" + c(paramContext);
  }

  private static List<agy> b(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("statusCode", -1) != 200)
          return localArrayList;
        Object localObject = paramString.get("results");
        if ((localObject instanceof JSONObject))
        {
          paramString = ((JSONObject)localObject).getJSONArray("keywords");
          i = 0;
          if ((i < paramString.length()) && (i < 200))
          {
            localObject = paramString.getJSONObject(i);
            agy localagy = new agy(((JSONObject)localObject).getString("keyword"));
            localagy.b = ((JSONObject)localObject).optString("icon", null);
            localagy.c = ((JSONObject)localObject).optString("cover", null);
            localagy.d = ((JSONObject)localObject).optInt("mark", 0);
            if (((JSONObject)localObject).optInt("paid", 1) != 1)
              break label238;
            bool = true;
            localagy.e = bool;
            localArrayList.add(localagy);
            i += 1;
            continue;
          }
        }
        else
        {
          paramString = (JSONArray)paramString.opt("results");
          if ((i < paramString.length()) && (i < 200))
          {
            localArrayList.add(new agy(paramString.getString(i)));
            i += 1;
            continue;
          }
        }
      }
      catch (Throwable paramString)
      {
      }
      return localArrayList;
      label238: boolean bool = false;
    }
  }

  public static void b(Context paramContext, String paramString)
  {
    List localList = a(paramContext);
    Object localObject = localList;
    if (localList == null)
      localObject = new ArrayList();
    ((List)localObject).remove(paramString);
    vs.b(paramContext, "pref_history_search_query", asi.a((Collection) localObject, ','));
  }

  private static void b(Context paramContext, boolean paramBoolean)
  {
    if (!arl.i(paramContext));
    while (true)
    {
      return;
      long l2 = System.currentTimeMillis();
      long l3 = vs.a(paramContext, "pref_hotword_timestamp", 0L);
      long l1;
      if (paramBoolean)
        l1 = 600000L;
      while ((l3 >= l2) || (l2 - l3 > l1))
      {
        vs.b(paramContext, "pref_hotword_timestamp", l2);
        new Thread()
        {
          public void run()
          {
            if (!ahe.c(ahe.this, "http://i.haloapps.com/tkw?"))
              ahe.c(ahe.this, "http://a.holaworld.cn/hotwords?");
          }
        }
        .start();
        return;
        if (arl.g(paramContext))
          l1 = 3600000L;
        else
          l1 = 21600000L;
      }
    }
  }

  public static StringBuilder c(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lang=").append(asq.j());
    localStringBuilder.append("&pid=").append("300105");
    localStringBuilder.append("&cid=").append("26100");
    localStringBuilder.append("&vid=").append("00");
    localStringBuilder.append("&w=").append(aqs.ae());
    localStringBuilder.append("&h=").append(aqs.af());
    localStringBuilder.append("&uid=").append(vs.u(paramContext));
    paramContext = kv.a().t();
    localStringBuilder.append("&").append("gaid=").append(a(paramContext));
    localStringBuilder.append("&a=").append("300105");
    localStringBuilder.append("&v=").append(22500);
    return localStringBuilder;
  }

  public static void d(Context paramContext)
  {
    if (!arl.i(paramContext))
      return;
    String str = new arb(paramContext).a(b(paramContext), null);
    List localList = agu.a(str);
    if (localList != null);
    try
    {
      if (localList.size() > 0)
        vs.b(paramContext, "pref_se", str);
      vs.b(paramContext, "pref_se_t", System.currentTimeMillis());
      a(paramContext, localList);
      return;
    }
    finally
    {
    }
    throw paramContext;
  }

  private static boolean d(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = new StringBuilder(paramString);
      ((StringBuilder)localObject).append("lang=").append(asq.j());
      ((StringBuilder)localObject).append("&pid=").append("300105");
      ((StringBuilder)localObject).append("&cid=").append("26100");
      ((StringBuilder)localObject).append("&vid=").append("00");
      ((StringBuilder)localObject).append("&vn=").append("2.25");
      ((StringBuilder)localObject).append("&vc=").append(22500);
      localObject = new arb(paramContext).a(((StringBuilder)localObject).toString(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        List localList = b((String)localObject);
        if ((localList != null) && (localList.size() > 0))
        {
          vs.b(paramContext, "pref_hotword_data", (String)localObject);
          c = localList;
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("Swipe.Search", "Failed to load hotword for url " + paramString, paramContext);
    }
    return false;
  }

  public static agu e(Context paramContext)
  {
    if (b != null)
      return b;
    a(paramContext, null);
    return b;
  }

  public static List<agu> f(Context paramContext)
  {
    return agu.a(vs.a(paramContext, "pref_se", ""));
  }

  public static ahf g(Context paramContext)
  {
    if (d == null)
    {
      d = ahf.a(vs.a(paramContext, "pref_ss", ""));
      if (d != null)
        d.b = atw.a(d.a().getPath(), true, 480);
    }
    return d;
  }

  public static void h(Context paramContext)
  {
    if (e);
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    }
    while ((l > f) && (l - f <= 7200000L));
    new Thread()
    {
      public void run()
      {
        try
        {
          ahe.a(System.currentTimeMillis());
          ahe.a(true);
          Object localObject1 = new arb(ahe.this).a("http://a.holaworld.cn/holasearch/setting?" + ahe.c(ahe.this), null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            Object localObject3 = new JSONObject((String)localObject1).getJSONObject("result");
            localObject1 = new ahf();
            ((ahf)localObject1).c = Color.parseColor(((JSONObject)localObject3).getString("bgColor"));
            ((ahf)localObject1).a = ((JSONObject)localObject3).getString("bgImg");
            int i = ((ahf)localObject1).c;
            if (i == 0)
              return;
            if (ahe.a() != null)
            {
              boolean bool = ahe.a().a.equals(((ahf)localObject1).a);
              if (bool)
                return;
            }
            localObject3 = ((ahf)localObject1).a();
            if (!((File)localObject3).exists())
              new arb(ahe.this).a(((ahf)localObject1).a, null, (File)localObject3);
            if (((File)localObject3).exists())
            {
              vs.b(ahe.this, "pref_ss", ahf.a((ahf) localObject1));
              ((ahf)localObject1).b = atw.a(((File) localObject3).getPath(), false, 480);
              if (ahe.a() != null)
                atw.a(ahe.a().b);
              ahe.a((ahf)localObject1);
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
        }
        finally
        {
          ahe.a(false);
        }
      }
    }
    .start();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahe
 * JD-Core Version:    0.6.2
 */