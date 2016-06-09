package cmcm.com.myapplication;

import android.content.Context;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.guide.NewGuide;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aal extends aah
{
  private void a(Context paramContext, wm paramwm, List<wk> paramList)
  {
    Object localObject1 = paramwm.a();
    if (asq.a((Collection) localObject1));
    do
    {
      return;
      Object localObject2 = null;
      Iterator localIterator = ((List)localObject1).iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext())
          break;
        localObject1 = (wk)localIterator.next();
      }
      while ((!paramwm.a.a(((wk)localObject1).i, new String[0])) || (paramList.contains(localObject1)));
      localObject1 = new adh((wk)localObject1);
    }
    while (localObject1 == null);
    if (ahy.d(paramContext))
    {
      i = 3;
      if (this.b.size() < i)
        break label175;
      paramwm = this.b;
      if (!ahy.d(paramContext))
        break label159;
    }
    label159: for (int i = 2; ; i = this.b.size() - 1)
    {
      paramwm.set(i, localObject1);
      return;
      i = b(paramContext);
      break;
    }
    label175: this.b.add(localObject1);
  }

  private List<wk> j()
  {
    Object localObject1 = SwipeApplication.c().a();
    int i = b(SwipeApplication.c());
    Object localObject2 = ((wm)localObject1).a(i * 3);
    localObject1 = new ArrayList(i);
    if (asq.a((Collection) localObject2))
      return localObject1;
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      wk localwk = (wk)((Iterator)localObject2).next();
      if (localwk.a())
        ((List)localObject1).add(localwk);
    }
    return localObject1;
  }

  public String a(Context paramContext)
  {
    return paramContext.getString(2131231070);
  }

  public void a(SwipeApplication paramSwipeApplication)
  {
    if (this.b != null)
      return;
    wm localwm = paramSwipeApplication.a();
    int j = b(paramSwipeApplication);
    int i;
    int k;
    label57: List localList;
    String str;
    label121: int n;
    wk localwk;
    int i1;
    if (j > 9)
    {
      i = 1;
      boolean bool = NewGuide.i();
      if ((i == 0) && (!bool) && (!vs.c(paramSwipeApplication, "key_add_clicked_in_favorites", false)))
        break label217;
      k = 0;
      int m = j;
      if (k != 0)
        m = j - 1;
      localList = localwm.a(m * 3);
      this.b = new ArrayList(m);
      if (!asq.a(localList))
      {
        j = 1;
        i = 0;
        if (!anu.e(paramSwipeApplication))
          break label223;
        str = amu.g(paramSwipeApplication);
        int i2 = localList.size();
        n = 0;
        if ((i < m) && (n < i2))
        {
          localwk = (wk)localList.get(n);
          i1 = j;
          if (localwk.a())
            break label228;
          if (i <= 0)
            j = 0;
          i1 = j;
          if (j == 0)
            break label228;
        }
      }
      if (!bool)
        break label292;
      a(paramSwipeApplication, localwm, localList);
    }
    while (true)
    {
      localList.clear();
      return;
      i = 0;
      break;
      label217: k = 1;
      break label57;
      label223: str = null;
      break label121;
      label228: if (!localwm.a.a(localwk.i, new String[] { str }));
      while (true)
      {
        n += 1;
        j = i1;
        break;
        this.b.add(new yt(localwk));
        i += 1;
      }
      label292: if (k != 0)
        this.b.add(ys.a(paramSwipeApplication, 2130837669));
    }
  }

  public void a(List<yw> paramList, int paramInt1, int paramInt2, xy paramxy)
  {
    super.a(paramList, paramInt1, paramInt2, paramxy);
    if (asq.a(paramList));
    do
    {
      return;
      paramInt1 = 0;
      if (paramInt1 < paramList.size())
      {
        Object localObject = (yw)paramList.get(paramInt1);
        if (localObject == null);
        while (true)
        {
          paramInt1 += 1;
          break;
          localObject = ((yw)localObject).e();
          if (localObject != null)
          {
            ((wk)localObject).f = (2147483547 + (b(SwipeApplication.c()) - paramInt1));
            SwipeApplication.c().a().b((wk)localObject, new Runnable()
            {
              public void run()
              {
                afs.a();
              }
            });
          }
        }
      }
    }
    while (paramxy == null);
    paramxy.a(this.b);
  }

  public String b()
  {
    return "mostUsed";
  }

  public int c()
  {
    return 4;
  }

  public boolean e()
  {
    return (super.e()) && ((this.b == null) || (this.b.size() <= 0) || (!(this.b.get(this.b.size() - 1) instanceof ys)));
  }

  public yt f()
  {
    if (this.b == null)
      return null;
    try
    {
      Object localObject2 = j();
      if (((List)localObject2).size() < b(SwipeApplication.c()))
        return null;
      Object localObject1 = new HashSet(this.b.size());
      int i = 0;
      while (true)
      {
        if (i < this.b.size())
        {
          if ((this.b.get(i) instanceof yt))
            ((Set)localObject1).add(((yw)this.b.get(i)).e());
        }
        else
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            wk localwk = (wk)((Iterator)localObject2).next();
            if (!((Set)localObject1).contains(localwk))
            {
              localObject1 = new yt(localwk);
              return localObject1;
            }
          }
          return null;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aal
 * JD-Core Version:    0.6.2
 */