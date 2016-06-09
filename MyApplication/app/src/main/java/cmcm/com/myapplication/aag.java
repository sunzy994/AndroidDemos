package cmcm.com.myapplication;

import android.content.Context;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class aag extends aah
{
  private void b(SwipeApplication paramSwipeApplication)
  {
    this.b = new ArrayList(b(paramSwipeApplication));
    int i = d(paramSwipeApplication);
    if (i > 0)
      vv.a().a("收到消息", "count", i);
    i = this.b.size();
    if ((i >= b(paramSwipeApplication)) || (!arl.h(paramSwipeApplication)));
    do
    {
      return;
      za localza = za.a(i);
      if (localza != null)
        this.b.add(localza);
    }
    while (!ajo.a(paramSwipeApplication));
    this.b.add(new ajo());
  }

  private int d(Context paramContext)
  {
    int m = b(paramContext);
    Iterator localIterator = alo.e().entrySet().iterator();
    int k = 1;
    int i = 0;
    while (true)
    {
      int j = i;
      Entry localEntry;
      String str;
      if (localIterator.hasNext())
      {
        localEntry = (Entry)localIterator.next();
        str = (String)localEntry.getKey();
        j = k;
        if (k != 0)
          if (asi.a(str, -1) <= 0)
            break label134;
      }
      label134: for (j = 1; ; j = 0)
      {
        this.b.add(new yx(paramContext, str, ((Integer)localEntry.getValue()).intValue()));
        if (this.b.size() < m)
          break;
        j = m;
        return j;
      }
      i += 1;
      k = j;
    }
  }

  private String e(Context paramContext)
  {
    if (!yy.t());
    yy localyy;
    do
    {
      return null;
      localyy = new yy(paramContext);
    }
    while (!localyy.s());
    if (i() >= b(paramContext))
      this.b.remove(b(paramContext) - 1);
    this.b.add(0, localyy);
    return localyy.f();
  }

  private void f(Context paramContext)
  {
    if (!aiu.s())
      return;
    aiu localaiu = new aiu(paramContext);
    if (i() >= b(paramContext))
      this.b.remove(b(paramContext) - 1);
    this.b.add(0, localaiu);
  }

  public void a(SwipeApplication paramSwipeApplication)
  {
    if (this.b != null);
    while (true)
    {
      return;
      try
      {
        b(paramSwipeApplication);
        String str = e(paramSwipeApplication);
        f(paramSwipeApplication);
        int i = b(paramSwipeApplication);
        if (i() < i)
        {
          a(paramSwipeApplication, str);
          return;
        }
      }
      catch (Throwable paramSwipeApplication)
      {
      }
    }
  }

  protected void a(SwipeApplication paramSwipeApplication, String paramString)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aag
 * JD-Core Version:    0.6.2
 */