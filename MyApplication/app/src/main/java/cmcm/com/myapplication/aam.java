package cmcm.com.myapplication;

import android.content.Context;
import com.lazyswipe.SwipeApplication;
import java.util.Iterator;
import java.util.List;

public class aam extends aag
{
  private void b(SwipeApplication paramSwipeApplication, String paramString)
  {
    wm localwm = paramSwipeApplication.a();
    Object localObject = wt.a(b(paramSwipeApplication) * 2);
    if (anu.e(paramSwipeApplication));
    for (String str = amu.g(paramSwipeApplication); ; str = null)
    {
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        do
        {
          wk localwk;
          do
          {
            if (!((Iterator)localObject).hasNext())
              break;
            localwk = (wk)((Iterator)localObject).next();
          }
          while (!localwm.a.a(localwk.i, new String[] { str, paramString }));
          this.b.add(new yt(localwk));
        }
        while (this.b.size() < b(paramSwipeApplication));
      }
      return;
    }
  }

  public String a(Context paramContext)
  {
    return paramContext.getString(2131231071);
  }

  protected void a(SwipeApplication paramSwipeApplication, String paramString)
  {
    b(paramSwipeApplication, paramString);
  }

  public void a(List<yw> paramList, int paramInt1, int paramInt2, xy paramxy)
  {
  }

  public String b()
  {
    return "recentlyUsed";
  }

  public int c()
  {
    return 5;
  }

  public boolean d()
  {
    return false;
  }

  public boolean e()
  {
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aam
 * JD-Core Version:    0.6.2
 */