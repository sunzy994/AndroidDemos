package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class qf
{
  private static String a;
  private static Object b;

  public static Object a(Context paramContext, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    try
    {
      a(paramContext);
      paramContext = ox.a(b, paramString, paramArrayOfObject, paramArrayOfClass);
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      qq.c("ChannelS.call: " + paramContext.getMessage());
      return null;
    }
    catch (Throwable paramContext)
    {
      while (true)
        qq.a("ChannelS.call", paramContext);
    }
  }

  public static void a(Context paramContext)
  {
    if (a == null)
      a = oy.a(paramContext, "analytics.jar").getAbsolutePath();
    Object localObject1;
    Object localObject3;
    if (b == null)
    {
      b = ox.a(ox.a(ox.a(paramContext, a), "com.statistics.channel.ChannelS"), "getInstance", new Object[0]);
      localObject1 = b;
      boolean bool = qj.a;
      localObject3 = Boolean.TYPE;
      ox.a(localObject1, "setDebug", new Object[] { Boolean.valueOf(bool) }, new Class[] { localObject3 });
    }
    try
    {
      localObject1 = b;
      localObject3 = qu.b(paramContext) + '_' + qu.c(paramContext);
      localObject4 = Integer.TYPE;
      ox.a(localObject1, "init", new Object[] { paramContext, "400113", localObject3, Integer.valueOf(22) }, new Class[] { Context.class, String.class, String.class, localObject4 });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        while (true)
        {
          localObject1 = b;
          localObject3 = qu.b(paramContext) + "_apk_int";
          localObject4 = qu.c(paramContext);
          Class localClass = Boolean.TYPE;
          ox.a(localObject1, "setPromotion", new Object[] { paramContext, Boolean.valueOf(true), localObject3, localObject4 }, new Class[] { Context.class, localClass, String.class, String.class });
          ox.a(b, "setCheckinKey", new Object[] { paramContext, "GC2" }, new Class[] { Context.class, String.class });
          return;
          localNoSuchMethodException1 = localNoSuchMethodException1;
          ox.a(b, "init", new Object[] { paramContext, "400113", qu.b(paramContext) + '_' + qu.c(paramContext) }, new Class[] { Context.class, String.class, String.class });
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        while (true)
        {
          Object localObject2 = b;
          localObject3 = qu.b(paramContext) + '_' + qu.c(paramContext);
          Object localObject4 = Boolean.TYPE;
          ox.a(localObject2, "setPromotion", new Object[] { paramContext, Boolean.valueOf(true), localObject3 }, new Class[] { Context.class, localObject4, String.class });
        }
      }
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("C", String.valueOf(22));
    localHashMap.put("A", String.valueOf(c(paramContext)));
    Object localObject = null;
    try
    {
      String str = qn.c(oy.b(paramContext, "rtgamerunjar.jar")) + "|" + qn.c(oy.b(paramContext, "libcantkrt.so"));
      localObject = str;
      localHashMap.put("R", localObject);
      localHashMap.put("T", paramString);
      a(paramContext, "GC1", localHashMap);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        qq.a(paramContext, "get.rt.ver", localThrowable);
    }
  }

  public static void a(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, String.valueOf(paramInt));
  }

  public static void a(Context paramContext, final String paramString1, final String paramString2)
  {
    qn.c(new Runnable() {
      public void run() {
        qf.a(qf.this, "onEvent", new Object[]{qf.this, paramString1, paramString2}, new Class[]{Context.class, String.class, String.class});
      }
    });
  }

  public static void a(final Context paramContext, final String paramString, HashMap<String, String> paramHashMap)
  {
    qn.c(new Runnable() {
      public void run() {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(qf.this);
        qf.a(paramContext, paramString, localArrayList);
      }
    });
  }

  public static void a(Context paramContext, final String paramString, final List<HashMap<String, String>> paramList)
  {
    qn.c(new Runnable() {
      public void run() {
        qf.a(qf.this, "onEvent", new Object[]{qf.this, paramString, paramList}, new Class[]{Context.class, String.class, List.class});
      }
    });
  }

  public static String b(Context paramContext)
  {
    return (String)a(paramContext, "getUserId", new Object[] { paramContext }, new Class[] { Context.class });
  }

  public static int c(Context paramContext)
  {
    paramContext = a(paramContext, "getSDKVersion", new Object[0], new Class[0]);
    if (paramContext == null)
      return 0;
    return ((Integer)paramContext).intValue();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qf
 * JD-Core Version:    0.6.2
 */