package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class aft
{
  private static final String a = "Swipe." + aft.class.getSimpleName();
  private static final Object b = new Object();
  private static Set<String> c;
  private static Set<String> d;
  private static Set<String> e;
  private static Set<String> f;

  private static String a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      return "";
    if (paramInt == 0)
      return "";
    while (true)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        if (i < paramArrayOfInt.length)
        {
          String str = Integer.toBinaryString(paramArrayOfInt[i]);
          if (i != 0)
            break label122;
          j = paramInt - (paramArrayOfInt.length - 1) * 12;
          int m = str.length();
          int k = 0;
          if (k < j - m)
          {
            localStringBuilder.append("0");
            k += 1;
            continue;
          }
          localStringBuilder.append(str);
          i += 1;
          continue;
        }
        paramArrayOfInt = localStringBuilder.toString();
        return paramArrayOfInt;
      }
      catch (Exception paramArrayOfInt)
      {
        return "";
      }
      label122: int j = 12;
    }
  }

  public static Set<String> a()
  {
    b();
    return new HashSet(c);
  }

  public static void a(String paramString)
  {
    aru.b(SwipeApplication.c(), "POP_TIME_USER_BLACK_LIST", paramString);
    o();
    c.clear();
    l();
    wq.d();
  }

  public static void a(Collection<String> paramCollection)
  {
    if (paramCollection == null)
      return;
    b();
    synchronized (b)
    {
      c.remove("com.sec.android.app.videoplayer");
      localHashSet = new HashSet(c);
      localHashSet.removeAll(new HashSet(paramCollection));
      localObject2 = localHashSet.iterator();
      if (((Iterator)localObject2).hasNext())
        vy.e((String)((Iterator)localObject2).next());
    }
    f.addAll(localHashSet);
    Object localObject2 = new HashSet(c);
    HashSet localHashSet = new HashSet(paramCollection);
    localHashSet.removeAll((Collection)localObject2);
    localObject2 = localHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
      vy.d((String)((Iterator)localObject2).next());
    f.removeAll(localHashSet);
    c = new HashSet(paramCollection);
    e = new HashSet(paramCollection);
    if (c.contains("com.samsung.everglades.video"))
      c.add("com.sec.android.app.videoplayer");
    p();
  }

  private static void a(boolean paramBoolean)
  {
    boolean bool = false;
    if ((e == null) || (paramBoolean))
      bool = o();
    if ((f == null) || (paramBoolean))
      bool = n();
    if ((d == null) || (paramBoolean))
      bool = m();
    if ((bool) || (c == null) || (paramBoolean))
      l();
    if (vg.j)
      wq.d();
    h(a);
  }

  public static void a(final boolean paramBoolean, List<wk> paramList)
  {
    if (!vg.j);
    final SwipeApplication localSwipeApplication;
    Set localSet;
    final HashSet localHashSet;
    do
    {
      return;
      localSwipeApplication = SwipeApplication.c();
      localSet = q();
      paramList = b(paramBoolean, paramList);
      localHashSet = new HashSet(0);
      localHashSet.addAll(localSet);
      localHashSet.addAll(paramList);
      b(localHashSet);
    }
    while ((localHashSet == null) || (localHashSet.isEmpty()));
    if (!arl.h(localSwipeApplication))
    {
      aly.a("POP_TIME_CLOUD_BLACK_LAST_FAIL_LIST", localHashSet);
      return;
    }
    arj.a(wd.a, new Runnable() {
      private Set<String> a() {
        Object localObject1 = new ArrayList(localHashSet);
        Object localObject2 = aft.k();
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("p", aft.a((List) localObject1));
        localObject2 = ard.a(localSwipeApplication, (String) localObject2, localHashMap);
        if (((arq) localObject2).a != arr.a) {
          aly.a("POP_TIME_CLOUD_BLACK_LAST_FAIL_LIST", localHashSet);
          return null;
        }
        localObject2 = ((arq) localObject2).c;
        try {
          localObject1 = aft.a((String) localObject2, (List) localObject1);
          return localObject1;
        } catch (Exception localException) {
          Log.e(aft.j(), "parseResult failed.", localException);
          aly.a("POP_TIME_CLOUD_BLACK_LAST_FAIL_LIST", localHashSet);
        }
        return null;
      }

      // ERROR //
      public void run() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 21	aft$1:a	Ljava/util/Set;
        //   4: invokeinterface 105 1 0
        //   9: ifne +14 -> 23
        //   12: invokestatic 110	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
        //   15: ldc 112
        //   17: invokestatic 118	java/lang/System:currentTimeMillis	()J
        //   20: invokestatic 123	aru:b	(Landroid/content/Context;Ljava/lang/String;J)V
        //   23: aload_0
        //   24: getfield 23	aft$1:b	Landroid/content/Context;
        //   27: ldc 125
        //   29: iconst_1
        //   30: invokestatic 128	aru:a	(Landroid/content/Context;Ljava/lang/String;Z)V
        //   33: aload_0
        //   34: invokespecial 130	aft$1:a	()Ljava/util/Set;
        //   37: astore_2
        //   38: aload_2
        //   39: ifnonnull +4 -> 43
        //   42: return
        //   43: invokestatic 134	aft:g	()Ljava/lang/Object;
        //   46: astore_1
        //   47: aload_1
        //   48: monitorenter
        //   49: aload_0
        //   50: getfield 25	aft$1:c	Z
        //   53: ifeq +69 -> 122
        //   56: aload_2
        //   57: invokestatic 137	aft:a	(Ljava/util/Set;)Ljava/util/Set;
        //   60: pop
        //   61: invokestatic 140	aft:i	()V
        //   64: invokestatic 144	wq:d	()V
        //   67: aload_1
        //   68: monitorexit
        //   69: ldc 146
        //   71: invokestatic 149	aft:h	()Ljava/util/Set;
        //   74: invokestatic 79	aly:a	(Ljava/lang/String;Ljava/util/Set;)V
        //   77: aload_0
        //   78: getfield 23	aft$1:b	Landroid/content/Context;
        //   81: ldc 74
        //   83: ldc 151
        //   85: invokestatic 154	aru:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
        //   88: aload_0
        //   89: getfield 23	aft$1:b	Landroid/content/Context;
        //   92: ldc 112
        //   94: ldc2_w 155
        //   97: invokestatic 123	aru:b	(Landroid/content/Context;Ljava/lang/String;J)V
        //   100: return
        //   101: astore_1
        //   102: invokestatic 88	aft:j	()Ljava/lang/String;
        //   105: ldc 158
        //   107: aload_1
        //   108: invokestatic 96	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   111: pop
        //   112: ldc 74
        //   114: aload_0
        //   115: getfield 27	aft$1:d	Ljava/util/Set;
        //   118: invokestatic 79	aly:a	(Ljava/lang/String;Ljava/util/Set;)V
        //   121: return
        //   122: invokestatic 149	aft:h	()Ljava/util/Set;
        //   125: ifnonnull +14 -> 139
        //   128: new 160	java/util/HashSet
        //   131: dup
        //   132: invokespecial 161	java/util/HashSet:<init>	()V
        //   135: invokestatic 137	aft:a	(Ljava/util/Set;)Ljava/util/Set;
        //   138: pop
        //   139: invokestatic 149	aft:h	()Ljava/util/Set;
        //   142: aload_2
        //   143: invokeinterface 165 2 0
        //   148: pop
        //   149: goto -88 -> 61
        //   152: astore_2
        //   153: aload_1
        //   154: monitorexit
        //   155: aload_2
        //   156: athrow
        //
        // Exception table:
        //   from	to	target	type
        //   0	23	101	java/lang/Exception
        //   23	38	101	java/lang/Exception
        //   43	49	101	java/lang/Exception
        //   69	100	101	java/lang/Exception
        //   155	157	101	java/lang/Exception
        //   49	61	152	finally
        //   61	69	152	finally
        //   122	139	152	finally
        //   139	149	152	finally
        //   153	155	152	finally
      }
    });
  }

  private static String b(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(",");
      localStringBuilder.append(str);
    }
    return aqw.b(asi.h(localStringBuilder.toString()), s());
  }

  private static Set<String> b(String paramString, List<String> paramList)
  {
    int j = 0;
    paramString = new JSONObject(paramString);
    if (paramString.optInt("ret") != 200)
      throw new RuntimeException("json.optInt(\"ret\") != 200");
    paramString = paramString.optJSONArray("statusCode");
    if (paramString == null)
      throw new RuntimeException("blacklist == null");
    Object localObject = new int[paramString.length()];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = paramString.getInt(i);
      i += 1;
    }
    paramString = a((int[])localObject, paramList.size());
    if (paramString.length() != paramList.size())
      throw new RuntimeException("blacklist.length() " + paramString.length() + " ,  apps.size()" + paramList.size());
    localObject = new HashSet(paramString.length());
    i = j;
    while (i < paramList.size())
    {
      if (paramString.charAt(i) == '1')
        ((Set)localObject).add(paramList.get(i));
      i += 1;
    }
    return localObject;
  }

  private static Set<String> b(boolean paramBoolean, List<wk> paramList)
  {
    Object localObject = SwipeApplication.c();
    if (!aru.b((Context) localObject, "POP_TIME_HAS_EVER_FETCHED_BLACK_LIST", false))
      paramList.addAll(((SwipeApplication)localObject).a().a());
    localObject = new HashSet(0);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        wk localwk = (wk)paramList.next();
        if ((localwk != null) && (localwk.i != null))
          ((Set)localObject).add(localwk.i.getPackageName());
      }
    }
    return localObject;
  }

  public static void b()
  {
    a(false);
  }

  public static void b(String paramString)
  {
    aru.b(SwipeApplication.c(), "POP_TIME_USER_WHITE_LIST", paramString);
    n();
    c.clear();
    l();
    wq.d();
  }

  private static void b(Set<String> paramSet)
  {
    try
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
        if (((String)paramSet.next()).startsWith("com.google.android"))
          paramSet.remove();
    }
    catch (Exception paramSet)
    {
    }
  }

  public static void c()
  {
    a(true);
  }

  public static void c(String paramString)
  {
    b();
    synchronized (b)
    {
      if (f != null)
        f.add(paramString);
      if (e != null)
        e.remove(paramString);
      if (c != null)
      {
        c.remove(paramString);
        if ("com.samsung.everglades.video".equals(paramString))
          c.remove("com.sec.android.app.videoplayer");
      }
      vy.e(paramString);
      p();
      return;
    }
  }

  public static void d(String paramString)
  {
    b();
    synchronized (b)
    {
      if (f != null)
        f.remove(paramString);
      if (e != null)
        e.add(paramString);
      if (c != null)
      {
        c.add(paramString);
        if ("com.samsung.everglades.video".equals(paramString))
          c.add("com.sec.android.app.videoplayer");
      }
      vy.d(paramString);
      p();
      return;
    }
  }

  public static boolean d()
  {
    b();
    return c.isEmpty();
  }

  public static boolean e()
  {
    return (c == null) || (c.isEmpty());
  }

  public static boolean e(String paramString)
  {
    b();
    return c.contains(paramString);
  }

  public static int f()
  {
    b();
    return c.size();
  }

  public static boolean f(String paramString)
  {
    b();
    return f.contains(paramString);
  }

  public static boolean g(String paramString)
  {
    b();
    return d.contains(paramString);
  }

  private static void h(String paramString)
  {
  }

  private static void l()
  {
    synchronized (b)
    {
      c = new HashSet();
      if (d != null)
        c.addAll(d);
      if (e != null)
        c.addAll(e);
      if (f != null)
        c.removeAll(f);
      if (c.contains("com.samsung.everglades.video"))
        c.add("com.sec.android.app.videoplayer");
      return;
    }
  }

  private static boolean m()
  {
    Set localSet = aly.c("POP_TIME_CLOUD_BLACK_LIST");
    synchronized (b)
    {
      d = localSet;
      return true;
    }
  }

  private static boolean n()
  {
    Set localSet = aly.c("POP_TIME_USER_WHITE_LIST");
    synchronized (b)
    {
      f = localSet;
      if (f != null)
        f.add(SwipeApplication.c().getPackageName());
      return true;
    }
  }

  private static boolean o()
  {
    Set localSet = aly.c("POP_TIME_USER_BLACK_LIST");
    synchronized (b)
    {
      e = localSet;
      return true;
    }
  }

  private static void p()
  {
    aly.a("POP_TIME_USER_BLACK_LIST", e);
    aly.a("POP_TIME_USER_WHITE_LIST", f);
  }

  private static Set<String> q()
  {
    if (Math.abs(aru.a(SwipeApplication.c(), "POP_TIME_CLOUD_BLACK_LAST_FAIL_LIST_REFETCH_TIME", -1L) - System.currentTimeMillis()) > 86400000L);
    for (int i = 1; i != 0; i = 0)
      return aly.c("POP_TIME_CLOUD_BLACK_LAST_FAIL_LIST");
    return new HashSet(0);
  }

  private static String r()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://a.lazyswipe.cn/").append("hotwords2").append("?uid=").append(vs.u(localSwipeApplication)).append("&pid=").append("300105");
    return localStringBuilder.toString();
  }

  private static String s()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(asq.q());
    if (asq.p())
      localStringBuilder.append(asi.a(asq.r()));
    localStringBuilder.append(ard.a());
    localStringBuilder.append(asi.a(9, true));
    localStringBuilder.append(asi.a(arl.a() - 'a'));
    localStringBuilder.append("I0");
    localStringBuilder.append(asi.a(6, false));
    localStringBuilder.append(asq.o() + 5);
    if (asq.p())
      localStringBuilder.append("F");
    localStringBuilder.append(asi.a(18));
    localStringBuilder.append(arb.a());
    localStringBuilder.append(asq.o() + 3);
    localStringBuilder.append("w");
    if (i < asq.o())
    {
      if (asq.p())
        localStringBuilder.append("=");
      while (true)
      {
        i += 1;
        break;
        localStringBuilder.append(")");
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aft
 * JD-Core Version:    0.6.2
 */