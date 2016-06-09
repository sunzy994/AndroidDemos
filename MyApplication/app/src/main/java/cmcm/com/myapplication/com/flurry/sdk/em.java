package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class em
  implements eq
{
  private static em a;
  private final List<eq> b = b();

  public static em a()
  {
    try
    {
      if (a == null)
        a = new em();
      em localem = a;
      return localem;
    }
    finally
    {
    }
  }

  private static List<eq> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new en("com.flurry.android.impl.analytics.FlurryAnalyticsModule", 10));
    localArrayList.add(new en("com.flurry.android.impl.ads.FlurryAdModule", 10));
    return Collections.unmodifiableList(localArrayList);
  }

  public void a(dj paramdj)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((eq)localIterator.next()).a(paramdj);
  }

  public void a(dj paramdj, Context paramContext)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((eq)localIterator.next()).a(paramdj, paramContext);
  }

  public void b(dj paramdj, Context paramContext)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((eq)localIterator.next()).b(paramdj, paramContext);
  }

  public void c(dj paramdj, Context paramContext)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((eq)localIterator.next()).c(paramdj, paramContext);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.em
 * JD-Core Version:    0.6.2
 */