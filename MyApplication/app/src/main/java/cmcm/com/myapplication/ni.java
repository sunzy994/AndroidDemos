package cmcm.com.myapplication;

import com.duapps.ad.a.a;
import com.duapps.ad.a.c;
import java.util.Iterator;
import java.util.List;

final class ni
  implements Runnable
{
  ni(nb paramnb, c paramc)
  {
  }

  public final void run()
  {
    if ((this.a == null) || (this.a.a == null) || (this.a.a.size() == 0))
      mv.c("ToolboxCacheManager", "ads == null || ads.list == null || ads.list.size() == 0");
    do
      while (true)
      {
        return;
        this.b.a();
        try
        {
          Iterator localIterator = this.a.a.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            mv.c("ToolboxCacheManager", "wall---before insert: ad.package: " + locala.c + ",ad.preParse:" + locala.t);
            this.b.b(new oa(locala));
          }
        }
        catch (Exception localException)
        {
        }
      }
    while (!mv.a());
    mv.a("ToolboxCacheManager", "wall---batch update or insert triggerPreParse data error: ", localException);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ni
 * JD-Core Version:    0.6.2
 */