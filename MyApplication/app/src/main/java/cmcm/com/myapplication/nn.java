package cmcm.com.myapplication;

import android.content.Context;
import com.duapps.ad.a.a;
import java.util.Iterator;
import java.util.LinkedList;

public class nn extends lh
{
  private static final String g = nn.class.getSimpleName();
  private int h;
  private final LinkedList i = new LinkedList();
  private ml j = new no(this);

  public nn(Context paramContext, int paramInt1, long paramLong, int paramInt2)
  {
    super(paramContext, paramInt1, paramLong);
    this.h = paramInt2;
  }

  private lo e()
  {
    a locala;
    while (true)
    {
      synchronized (this.i)
      {
        locala = (a)this.i.poll();
        if ((locala != null) && (!locala.a()))
          continue;
        String str3 = g;
        StringBuilder localStringBuilder = new StringBuilder("OL poll title-> ");
        String str1;
        if (locala != null)
        {
          str1 = locala.b;
          mv.c(str3, str1);
          ??? = this.d;
          if (locala == null)
          {
            str1 = "FAIL";
            nr.d((Context) ???, str1, this.e);
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
    int k = c();
    if (this.h - k <= 0)
    {
      mv.c(g, "no need refresh");
      return;
    }
    if (this.b)
    {
      mv.c(g, "isRefreshing ...");
      return;
    }
    nb.a(this.d).a(Integer.valueOf(this.e).intValue(), 1, this.j, this.h - k);
  }

  public final int c()
  {
    int k;
    while (true)
    {
      synchronized (this.i)
      {
        Iterator localIterator = this.i.iterator();
        k = 0;
        if (!localIterator.hasNext())
          break;
        a locala = (a)localIterator.next();
        String str = locala.c;
        if ((np.a(this.d, str)) || (!locala.a()))
          localIterator.remove();
      }
      k += 1;
    }
    return k;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nn
 * JD-Core Version:    0.6.2
 */