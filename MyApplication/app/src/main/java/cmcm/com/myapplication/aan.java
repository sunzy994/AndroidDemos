package cmcm.com.myapplication;

import android.content.Context;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aan extends aah
{
  private boolean c;

  private void j()
  {
    if (this.c);
    while (true)
    {
      return;
      if (this.b != null)
      {
        this.c = true;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          yw localyw = (yw)localIterator.next();
          if ((localyw instanceof zf))
            ((zf)localyw).u();
        }
      }
    }
  }

  private void k()
  {
    if (!this.c);
    while (true)
    {
      return;
      this.c = false;
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          yw localyw = (yw)localIterator.next();
          if ((localyw instanceof zf))
            ((zf)localyw).v();
        }
      }
    }
  }

  public String a(Context paramContext)
  {
    return paramContext.getString(2131231072);
  }

  public void a(SwipeApplication paramSwipeApplication)
  {
    if (this.b == null)
    {
      List localList = anu.b(paramSwipeApplication);
      int j = Math.min(localList.size(), b(paramSwipeApplication));
      this.b = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        auu.a("Started instantiate " + (String) localList.get(i));
        ans localans = anu.a(paramSwipeApplication, (String) localList.get(i));
        auu.a("Instantiated " + localans);
        if (localans != null)
          this.b.add(new zf(paramSwipeApplication, localans));
        i += 1;
      }
    }
  }

  public void a(List<yw> paramList, int paramInt1, int paramInt2, xy paramxy)
  {
    super.a(paramList, paramInt1, paramInt2, paramxy);
    if (asq.a(paramList));
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        yw localyw = (yw)paramList.next();
        if ((localyw instanceof zf))
          localArrayList.add(((zf)localyw).t());
      }
      anu.b(SwipeApplication.c(), anu.a(localArrayList));
    }
    while (paramxy == null);
    paramxy.a(this.b);
  }

  protected void a(yw paramyw)
  {
    ((zf)paramyw).v();
  }

  public boolean a(Context paramContext, yb paramyb)
  {
    super.a(paramContext, paramyb);
    ani.a = 0;
    anf.a = false;
    j();
    return true;
  }

  public String b()
  {
    return "switcher";
  }

  public boolean b_()
  {
    return false;
  }

  public int c()
  {
    return 3;
  }

  public void g()
  {
    k();
    super.g();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aan
 * JD-Core Version:    0.6.2
 */