package cmcm.com.myapplication;

import com.lazyswipe.SwipeApplication;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class aqf
  implements oi
{
  public void a(oj paramoj)
  {
    if ((paramoj == null) || (paramoj.a == null))
      return;
    Iterator localIterator = paramoj.a.iterator();
    label22: SwipeApplication localSwipeApplication;
    if (localIterator.hasNext())
    {
      paramoj = (String)localIterator.next();
      paramoj = (String)aqe.b().get(paramoj);
      localSwipeApplication = SwipeApplication.c();
      if (paramoj == null)
        break label72;
    }
    while (true)
    {
      vy.a(localSwipeApplication, "D0", paramoj);
      break label22;
      break;
      label72: paramoj = "Unknown";
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqf
 * JD-Core Version:    0.6.2
 */