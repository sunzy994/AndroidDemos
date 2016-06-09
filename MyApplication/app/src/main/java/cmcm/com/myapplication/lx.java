package cmcm.com.myapplication;

import android.content.Context;
import com.duapps.ad.b.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class lx extends lh
{
  private int g;
  private final LinkedList h = new LinkedList();
  private ml i = new ly(this);

  public lx(Context paramContext, int paramInt1, long paramLong, int paramInt2)
  {
    super(paramContext, paramInt1, paramLong);
    this.g = paramInt2;
  }

  public final void a()
  {
    if (!np.b(this.d));
    String str;
    int j;
    do
    {
      return;
      if (this.g == 0)
      {
        mv.c("InMobiCacheManager", "cacheSize is zero");
        return;
      }
      str = nm.a(this.d).c();
      mv.c("InMobiCacheManager", "ImCache inId = " + str);
      j = this.g - c();
    }
    while ((j <= 0) || (this.b));
    this.b = true;
    nb.a(this.d).a(Integer.valueOf(this.e).intValue(), str, String.valueOf(j), this.i);
  }

  public final li b()
  {
    while (true)
    {
      synchronized (this.h)
      {
        a locala1 = (a)this.h.poll();
        if ((locala1 != null) && (!locala1.a()))
          continue;
        Context localContext = this.d;
        if (locala1 == null)
        {
          ??? = "FAIL";
          nr.c(localContext, (String) ???, this.e);
          if (locala1 != null)
            break;
          return null;
        }
      }
      ??? = "OK";
    }
    return new mg(this.d, locala2, this.f);
  }

  public final int c()
  {
    int j;
    synchronized (this.h)
    {
      Iterator localIterator = this.h.iterator();
      j = 0;
      while (localIterator.hasNext())
        if (((a)localIterator.next()).a())
          j += 1;
        else
          localIterator.remove();
    }
    return j;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lx
 * JD-Core Version:    0.6.2
 */