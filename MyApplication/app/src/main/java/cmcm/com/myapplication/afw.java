package cmcm.com.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class afw
{
  private static final Map<String, afw> a = new HashMap();
  private String b;
  private long c;
  private long d;

  public static List<String> a(int paramInt)
  {
    b();
    LinkedList localLinkedList = new LinkedList(a.values());
    Collections.sort(localLinkedList, new Comparator()
    {
      public int a(afw paramAnonymousafw1, afw paramAnonymousafw2)
      {
        if (afw.a(paramAnonymousafw1) < afw.a(paramAnonymousafw2))
          return 1;
        if (afw.a(paramAnonymousafw1) == afw.a(paramAnonymousafw2))
          return 0;
        return -1;
      }
    });
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    while ((i < localLinkedList.size()) && (i < paramInt))
    {
      afw localafw = (afw)localLinkedList.get(i);
      if ((!a(localafw.c)) && (!a(localafw.d)))
        localArrayList.add(localafw.b);
      i += 1;
    }
    return localArrayList;
  }

  private void a()
  {
    if ((a(this.c)) && (a(this.d)))
    {
      this.c = -1L;
      this.d = System.currentTimeMillis();
      return;
    }
    if ((a(this.c)) && (!a(this.d)))
    {
      this.c = this.d;
      this.d = System.currentTimeMillis();
      return;
    }
    if ((!a(this.c)) && (a(this.d)))
    {
      this.c = -1L;
      this.d = System.currentTimeMillis();
      return;
    }
    this.c = this.d;
    this.d = System.currentTimeMillis();
  }

  private static boolean a(long paramLong)
  {
    return System.currentTimeMillis() - paramLong > 600000L;
  }

  private static void b()
  {
    while (true)
    {
      try
      {
        Iterator localIterator = a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          afw localafw = (afw)((Entry)localIterator.next()).getValue();
          if ((!a(localafw.c)) || (!a(localafw.d)))
            break label90;
          i = 1;
          boolean bool = afv.a(localafw.b);
          if ((i == 0) && (!bool))
            continue;
          localIterator.remove();
          continue;
        }
      }
      catch (Exception localException)
      {
      }
      return;
      label90: int i = 0;
    }
  }

  private static void b(String paramString)
  {
    afw localafw = (afw)a.get(paramString);
    if (localafw == null)
    {
      localafw = new afw();
      localafw.b = paramString;
      localafw.c = System.currentTimeMillis();
      a.put(paramString, localafw);
    }
    while (true)
    {
      b();
      return;
      localafw.a();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afw
 * JD-Core Version:    0.6.2
 */