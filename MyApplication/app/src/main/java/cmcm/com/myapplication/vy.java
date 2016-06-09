package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.notification.SwipeAccessibilityService;
import java.util.HashMap;
import java.util.Map;

public final class vy extends vv
{
  private static volatile boolean b;
  private static volatile boolean c;

  public static void a(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap(2);
      String str2 = String.valueOf(paramInt);
      if (asq.r(SwipeApplication.c()));
      for (String str1 = "Lockscreen"; ; str1 = "")
      {
        localHashMap.put("I", str2);
        localHashMap.put("B", str1);
        a(SwipeApplication.c(), 5, "B8", new HashMap[] { localHashMap });
        vw.a(SwipeApplication.c(), "B8", new String[] { "I", str2, "B", str1 });
        return;
      }
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 3)
    {
      a(paramInt1, 1, paramInt2, "gg");
      return;
    }
    a("AA", "gg", paramInt1, String.valueOf(paramInt2), "1");
  }

  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    a("A9", paramString, paramInt1, String.valueOf(paramInt3), String.valueOf(paramInt2));
  }

  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    a("AA", paramString, paramInt1, String.valueOf(paramInt2), "1");
  }

  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, "C3", String.valueOf(paramInt));
  }

  public static void a(Context paramContext, int paramInt, String paramString, Object paramObject)
  {
    if ((TextUtils.isEmpty(paramString)) && (9 != paramInt))
      return;
    vy localvy = new vy();
    localvy.a(paramContext);
    switch (paramInt)
    {
    case 8:
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 9:
    case -1:
    }
    while (true)
    {
      localvy.b(paramContext);
      return;
      kv.a().e(paramString);
      continue;
      kv localkv = kv.a();
      if (paramObject == null);
      for (paramObject = ""; ; paramObject = (String)paramObject)
      {
        localkv.a(paramString, paramObject);
        break;
      }
      kv.a().a(paramString, (HashMap[])paramObject);
      continue;
      kv.a().g(paramString);
      continue;
      localkv = kv.a();
      if (paramObject == null);
      for (paramObject = ""; ; paramObject = (String)paramObject)
      {
        localkv.b(paramString, paramObject);
        break;
      }
      kv.a().c(paramString, (HashMap[])paramObject);
      continue;
      kv.a().h(paramString);
      continue;
      kv.a().b(paramString, (HashMap[])paramObject);
      continue;
      localkv = kv.a();
      if (paramObject == null);
      for (paramString = ""; ; paramString = (String)paramObject)
      {
        localkv.i(paramString);
        break;
      }
      kv.a().f(paramString);
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, 3, paramString, null);
  }

  public static void a(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, 1, paramString, String.valueOf(paramInt));
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, 4, paramString1, paramString2);
  }

  public static void a(String paramString, int paramInt)
  {
    b("A0", paramString, paramInt);
  }

  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("V", "b" + paramInt);
    localHashMap.put("P", paramString3);
    localHashMap.put("T", paramString4);
    localHashMap.put("I", paramString2);
    a(SwipeApplication.c(), 7, paramString1, new HashMap[] { localHashMap });
  }

  public static void a(boolean paramBoolean, String paramString)
  {
    String str1;
    String str2;
    try
    {
      if (asq.r(SwipeApplication.c()))
      {
        str1 = "Lockscreen";
        break label98;
        while (true)
        {
          HashMap localHashMap = new HashMap(2);
          localHashMap.put("P", paramString);
          localHashMap.put("B", str1);
          a(SwipeApplication.c(), 5, str2, new HashMap[] { localHashMap });
          vw.a(SwipeApplication.c(), str2, new String[] { "P", paramString, "B", str1 });
          return;
          label90: str2 = "B9";
        }
      }
    }
    catch (Exception paramString)
    {
      return;
    }
    while (true)
    {
      label98: if (!paramBoolean)
        break label90;
      str2 = "BA";
      break;
      str1 = "";
    }
  }

  public static void a(boolean paramBoolean, yc paramyc)
  {
    while (true)
    {
      try
      {
        HashMap localHashMap = new HashMap(8);
        localHashMap.put("S", String.valueOf(paramyc.c));
        localHashMap.put("D", String.valueOf(paramyc.d));
        localHashMap.put("B", "");
        localHashMap.put("C", "");
        localHashMap.put("X", String.valueOf(paramyc.h));
        localHashMap.put("Y", String.valueOf(paramyc.i));
        localHashMap.put("T", String.valueOf(paramyc.j));
        if (SwipeAccessibilityService.a() != null)
        {
          paramyc = "1";
          localHashMap.put("A", paramyc);
          if (!aqs.s(SwipeApplication.c()))
            break label194;
          paramyc = "1";
          localHashMap.put("N", String.valueOf(paramyc));
          localHashMap.put("V", String.valueOf("-1"));
          SwipeApplication localSwipeApplication = SwipeApplication.c();
          if (paramBoolean)
          {
            paramyc = "BY";
            a(localSwipeApplication, 5, paramyc, new HashMap[] { localHashMap });
            return;
          }
          paramyc = "BZ";
          continue;
        }
      }
      catch (Exception paramyc)
      {
        asq.b(paramyc);
        return;
      }
      paramyc = "0";
      continue;
      label194: paramyc = "0";
    }
  }

  public static void b()
  {
    kv.a().j(String.valueOf(22500));
  }

  public static void b(int paramInt)
  {
    a(SwipeApplication.c(), 4, "BQ", String.valueOf(paramInt));
  }

  public static void b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 1001) || (paramInt2 == 1002))
    {
      a(paramInt1, 1, paramInt2, "fb");
      return;
    }
    a("AA", "fb", paramInt1, String.valueOf(paramInt2), "1");
  }

  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, 6, paramString, null);
  }

  public static void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, String.valueOf(paramInt));
  }

  public static void b(String paramString, int paramInt)
  {
    b("A3", paramString, paramInt);
  }

  public static void b(String paramString1, String paramString2, int paramInt)
  {
    if (1 == paramInt);
    for (String str = "2"; ; str = "1")
    {
      a(paramString1, paramString2, paramInt, str, "8");
      return;
    }
  }

  public static void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "l"; ; str = "r")
    {
      a(SwipeApplication.c(), 4, "B1", str);
      if (vj.g)
        b(SwipeApplication.c(), "B24", 1);
      if (vj.n)
        b(SwipeApplication.c(), "B24", 2);
      vw.a(SwipeApplication.c(), "B1", "position", str);
      return;
    }
  }

  public static void c()
  {
    arj.a(wd.a, new wf(null));
  }

  public static void c(String paramString)
  {
    try
    {
      if (asq.r(SwipeApplication.c()));
      for (String str = "Lockscreen"; ; str = "")
      {
        HashMap localHashMap = new HashMap(2);
        localHashMap.put("P", paramString);
        localHashMap.put("B", str);
        a(SwipeApplication.c(), 5, "BB", new HashMap[] { localHashMap });
        vw.a(SwipeApplication.c(), "BB", new String[] { "P", paramString, "B", str });
        return;
      }
    }
    catch (Exception paramString)
    {
    }
  }

  public static void c(boolean paramBoolean)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      a(localSwipeApplication, 4, "BM", str);
      return;
    }
  }

  public static void d()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (xl.a(localSwipeApplication, 2L, 28800000L))
    {
      xl.b(localSwipeApplication, 2L);
      a(localSwipeApplication, -1, "B0", null);
    }
  }

  public static void d(Context paramContext)
  {
    if (c)
    {
      Log.i("Swipe.SwipeAnalysis", "Sending referrer on progress...");
      return;
    }
    c = true;
    vy localvy = new vy();
    localvy.a(paramContext);
    kv.a().e(true);
    kv.a().b("400105");
    kv.a().c(aqs.m(paramContext));
    kv.a().d(asl.c(paramContext));
    kv.a().a(new ks()
    {
      public void a(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Install referrer ");
        if (paramAnonymousBoolean);
        for (String str = "sent successfully"; ; str = "failed to sent")
        {
          asp.a("Swipe.SwipeAnalysis", str + "; Result code: " + paramAnonymousInt);
          if (paramAnonymousBoolean)
            vs.a(vy.this, true);
          vy.d(false);
          return;
        }
      }
    });
    localvy.b(paramContext);
  }

  public static void d(String paramString)
  {
    a(SwipeApplication.c(), 4, "BC", "");
  }

  public static void e()
  {
    a(SwipeApplication.c(), 3, "B6", null);
  }

  public static void e(String paramString)
  {
    a(SwipeApplication.c(), 4, "BD", "");
  }

  public static String f()
  {
    return kv.a().p();
  }

  public static void f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      a(SwipeApplication.c(), 4, "BV", paramString);
  }

  public static void g()
  {
    a(SwipeApplication.c(), 3, "BP", null);
  }

  public static void g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      a(SwipeApplication.c(), 4, "BU", paramString);
  }

  public static void h()
  {
    a(SwipeApplication.c(), 3, "BO", null);
  }

  public void a(Context paramContext)
  {
    if (!b)
    {
      b = true;
      kv.a().a(paramContext, "0", "300105", "00", "26100", String.valueOf(22500));
      kv.a().a(false);
      kv.a().b(false);
      kv.a().d(false);
      kv.a().g(false);
      kv.a().l("");
      b();
    }
    paramContext = vs.u(paramContext);
    if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals(kv.a().b())))
      b(paramContext);
  }

  public void a(String paramString)
  {
    throw new RuntimeException("Unimplemented, please use logEvent(Context, int, String, Object)");
  }

  public void a(String paramString, Map<String, String> paramMap)
  {
    throw new RuntimeException("Unimplemented, please use logEvent(Context, int, String, Object)");
  }

  public void b(Context paramContext)
  {
  }

  public void b(String paramString)
  {
    kv.a().a(paramString);
    kv.a().f(vs.s(SwipeApplication.c()));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vy
 * JD-Core Version:    0.6.2
 */