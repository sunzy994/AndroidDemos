package cmcm.com.myapplication;

import android.content.Context;
import com.duapps.ad.a.a;
import java.util.Iterator;
import java.util.LinkedList;

public class nk extends lh
{
  private static final String g = nk.class.getSimpleName();
  private final LinkedList h = new LinkedList();
  private ml i = new nl(this);

  public nk(Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, paramInt, paramLong);
  }

  private lo e()
  {
    a locala;
    while (true)
    {
      synchronized (this.h)
      {
        locala = (a)this.h.poll();
        if ((locala != null) && (!locala.a()))
          continue;
        String str3 = g;
        StringBuilder localStringBuilder = new StringBuilder("DL poll title-> ");
        String str1;
        if (locala != null)
        {
          str1 = locala.b;
          mv.c(str3, str1);
          ??? = this.d;
          if (locala == null)
          {
            str1 = "FAIL";
            nr.b((Context) ???, str1, this.e);
            if (locala != null)
              break;
            return null;
          }
        }
        else
        {
          str1 = "null";
        }
      }
      String str2 = "OK";
    }
    return new lo(this.d, locala, this.f);
  }

  public final void a()
  {
    if (!np.b(this.d))
      return;
    if (c() > 0)
    {
      mv.c(g, "no need refresh");
      return;
    }
    if (this.b)
    {
      mv.c(g, "isRefreshing...");
      return;
    }
    nb.a(this.d).a(Integer.valueOf(this.e).intValue(), 1, this.i);
  }

  public final int c()
  {
    int j;
    while (true)
    {
      synchronized (this.h)
      {
        Iterator localIterator = this.h.iterator();
        j = 0;
        if (!localIterator.hasNext())
          break;
        a locala = (a)localIterator.next();
        String str = locala.c;
        if ((np.a(this.d, str)) || (!locala.a()))
          localIterator.remove();
      }
      j += 1;
    }
    return j;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nk
 * JD-Core Version:    0.6.2
 */