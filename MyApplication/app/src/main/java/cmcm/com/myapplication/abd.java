package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import com.lazyswipe.SwipeApplication;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class abd
  implements aaz
{
  public static final String f = "Swipe." + abd.class.getSimpleName();
  public static aba g;
  public static aba h;
  public static aen i;
  public static aba j;
  static final aar k = new aar();
  public static volatile boolean l;
  public static final Handler m;
  private static final HandlerThread n;
  private static final Random o = new Random();

  static
  {
    l = false;
    if (a())
    {
      n = new HandlerThread(f + "LP");
      n.setPriority(10);
      n.start();
      m = new Handler(n.getLooper());
      h();
      return;
    }
    n = null;
    m = wd.a;
    i();
  }

  public static int a(int paramInt1, int paramInt2)
  {
    SparseIntArray localSparseIntArray = aaw.c();
    if ((localSparseIntArray == null) || (localSparseIntArray.size() <= 0))
      return paramInt2;
    paramInt1 = a(localSparseIntArray, paramInt2);
    asp.a(f, "Category: " + paramInt1);
    return paramInt1;
  }

  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = 0;
    int i1 = 0;
    SparseIntArray localSparseIntArray1 = aaw.b();
    if ((localSparseIntArray1 == null) || (localSparseIntArray1.size() <= 0))
      return paramInt2;
    if (paramInt3 == 0)
    {
      int i3 = localSparseIntArray1.size() - 1;
      if (i3 == 0)
      {
        asp.a(f, "Default content type for placement #" + paramInt1 + " used: " + paramInt2);
        return paramInt2;
      }
      if (1 == i3)
        while (true)
        {
          i2 = paramInt2;
          if (i1 <= 1)
          {
            if (localSparseIntArray1.keyAt(i1) != paramInt3)
              i2 = localSparseIntArray1.keyAt(i1);
          }
          else
          {
            asp.a(f, "The only other content type used for placement #" + paramInt1 + ": " + i2);
            return i2;
          }
          i1 += 1;
        }
      i1 = localSparseIntArray1.indexOfKey(paramInt3);
      SparseIntArray localSparseIntArray2 = localSparseIntArray1.clone();
      localSparseIntArray2.delete(paramInt3);
      if (i1 != i3)
      {
        int i4 = localSparseIntArray1.valueAt(i1);
        if (i1 == 0);
        for (paramInt2 = i2; ; paramInt2 = localSparseIntArray1.valueAt(i1 - 1))
        {
          paramInt3 = i1;
          while (paramInt3 < i3)
          {
            localSparseIntArray2.put(localSparseIntArray2.keyAt(paramInt3), localSparseIntArray2.valueAt(paramInt3) - (i4 - paramInt2));
            paramInt3 += 1;
          }
        }
      }
      paramInt2 = a(localSparseIntArray2);
      asp.a(f, "The other content type used for placement #" + paramInt1 + ": " + paramInt2);
      return paramInt2;
    }
    asp.a(f, "Content: " + 0);
    return 0;
  }

  public static int a(int paramInt, Set<Integer> paramSet)
  {
    if ((k.i[paramInt] == null) || (k.i[paramInt].size() <= 0))
      i1 = k.j[paramInt];
    SparseIntArray localSparseIntArray1;
    int i2;
    do
    {
      return i1;
      localSparseIntArray1 = k.i[paramInt].clone();
      if (paramSet != null)
      {
        i1 = 0;
        while (i1 < a.length)
        {
          if (aav.a(i1))
            paramSet.add(Integer.valueOf(i1));
          i1 += 1;
        }
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          Integer localInteger = (Integer)paramSet.next();
          SparseIntArray localSparseIntArray2 = localSparseIntArray1.clone();
          int i3 = localSparseIntArray2.size() - 1;
          i1 = localInteger.intValue();
          i2 = localSparseIntArray2.indexOfKey(i1);
          if (i2 >= 0)
          {
            localSparseIntArray1.delete(i1);
            if (i2 != i3)
            {
              int i4 = localSparseIntArray2.valueAt(i2);
              if (i2 == 0)
                i1 = 0;
              while (i2 < i3)
              {
                localSparseIntArray1.put(localSparseIntArray1.keyAt(i2), localSparseIntArray1.valueAt(i2) - (i4 - i1));
                i2 += 1;
                continue;
                i1 = localSparseIntArray2.valueAt(i2 - 1);
              }
            }
          }
        }
      }
      i1 = localSparseIntArray1.size();
      if (i1 != 0)
        break;
      i2 = k.j[paramInt];
      i1 = i2;
    }
    while (i2 == -1);
    asp.a(f, "Backup vendor for placement #" + paramInt + " used: " + i2);
    return i2;
    if (1 == i1)
    {
      i1 = localSparseIntArray1.keyAt(0);
      asp.a(f, "The only valid vendor used for placement #" + paramInt + ": " + i1);
      return i1;
    }
    int i1 = a(localSparseIntArray1);
    asp.a(f, "Valid vendor used for placement #" + paramInt + ": " + i1);
    return i1;
  }

  private static int a(SparseIntArray paramSparseIntArray)
  {
    return a(paramSparseIntArray, -1);
  }

  private static int a(SparseIntArray paramSparseIntArray, int paramInt)
  {
    if ((paramSparseIntArray == null) || (paramSparseIntArray.size() <= 0));
    while (true)
    {
      return paramInt;
      int i2 = paramSparseIntArray.size() - 1;
      int i1 = paramSparseIntArray.valueAt(i2);
      int i3 = o.nextInt(i1);
      i1 = 0;
      while (i1 <= i2)
      {
        if (i3 + 1 <= paramSparseIntArray.valueAt(i1))
          return paramSparseIntArray.keyAt(i1);
        i1 += 1;
      }
    }
  }

  public static void a(aar paramaar, boolean paramBoolean)
  {
    paramaar = new abs(paramaar, paramBoolean);
    arj.a(m, paramaar);
  }

  public static void a(Context paramContext)
  {
    a(paramContext, true);
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    if (abj.n())
      mn.a(paramContext, paramIntent);
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (!aay.c()));
    while (true)
    {
      return;
      try
      {
        if ((za.s()) && ((alo.d(paramContext)) || (vs.z(paramContext))) && (j != null))
        {
          j.b();
          return;
        }
      }
      catch (Throwable paramContext)
      {
      }
    }
  }

  public static void a(boolean paramBoolean)
  {
    a(k, paramBoolean);
  }

  public static boolean a()
  {
    try
    {
      boolean bool = apz.b();
      if (!bool)
      {
        bool = true;
        return bool;
      }
      bool = false;
    }
    finally
    {
    }
  }

  public static boolean a(int paramInt)
  {
    return k.a(paramInt);
  }

  public static boolean a(int paramInt, long paramLong)
  {
    return k.a(paramInt, paramLong);
  }

  public static boolean a(Context paramContext, int paramInt)
  {
    if (a())
    {
      if (l)
        break label17;
      b();
    }
    label17: 
    do
    {
      return false;
      paramContext = arl.d(paramContext);
    }
    while (!arl.d(paramContext));
    return k.a(paramInt, arl.b(paramContext));
  }

  public static String b(int paramInt)
  {
    return k.m[paramInt];
  }

  public static void b()
  {
    a(k, false);
  }

  public static void b(Context paramContext)
  {
    if ((a(paramContext, 11)) && (g != null))
      g.b();
  }

  public static boolean b(int paramInt1, int paramInt2)
  {
    return k.b(paramInt1, paramInt2);
  }

  public static String c(int paramInt)
  {
    return k.n[paramInt];
  }

  public static void c()
  {
    if (j != null);
    try
    {
      j.a(null);
      j.e();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void c(Context paramContext)
  {
    if (j != null)
    {
      j.d();
      a(paramContext);
    }
  }

  public static boolean c(int paramInt1, int paramInt2)
  {
    return k.a(paramInt1, paramInt2);
  }

  public static boolean d()
  {
    return aay.a();
  }

  public static boolean e()
  {
    return aav.a() == 2;
  }

  public static int f()
  {
    return aaw.a();
  }

  public static Object g()
  {
    return afr.a();
  }

  private static void h()
  {
    SwipeApplication.c();
    b();
  }

  private static void i()
  {
    g = null;
    h = null;
    i = null;
    j = null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abd
 * JD-Core Version:    0.6.2
 */