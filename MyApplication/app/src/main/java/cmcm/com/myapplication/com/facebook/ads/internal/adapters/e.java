package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static final Set<g> a = new HashSet();
  private static final Map<AdPlacementType, String> b = new ConcurrentHashMap();

  static
  {
    g[] arrayOfg = g.values();
    int j = arrayOfg.length;
    int i = 0;
    while (true)
    {
      g localg;
      Object localObject;
      label86: Class localClass3;
      Class localClass1;
      if (i < j)
      {
        localg = arrayOfg[i];
        switch (1.a[localg.g.ordinal()])
        {
        default:
          localObject = null;
          if (localObject != null)
          {
            localClass3 = localg.d;
            localClass1 = localClass3;
            if (localClass3 != null)
              break;
          }
          break;
        case 1:
        case 2:
        case 3:
        }
      }
      try
      {
        localClass1 = Class.forName(localg.e);
        if ((localClass1 != null) && (((Class)localObject).isAssignableFrom(localClass1)))
          a.add(localg);
        i += 1;
        continue;
        localObject = BannerAdapter.class;
        break label86;
        localObject = InterstitialAdapter.class;
        break label86;
        localObject = n.class;
        break label86;
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        while (true)
          Class localClass2 = localClass3;
      }
    }
  }

  public static AdAdapter a(f paramf, AdPlacementType paramAdPlacementType)
  {
    try
    {
      g localg = b(paramf, paramAdPlacementType);
      if ((localg != null) && (a.contains(localg)))
      {
        paramAdPlacementType = localg.d;
        paramf = paramAdPlacementType;
        if (paramAdPlacementType == null)
          paramf = Class.forName(localg.e);
        paramf = (AdAdapter)paramf.newInstance();
        return paramf;
      }
    }
    catch (Exception paramf)
    {
      paramf.printStackTrace();
    }
    return null;
  }

  public static AdAdapter a(String paramString, AdPlacementType paramAdPlacementType)
  {
    return a(f.a(paramString), paramAdPlacementType);
  }

  public static String a(AdPlacementType paramAdPlacementType)
  {
    if (b.containsKey(paramAdPlacementType))
      return (String)b.get(paramAdPlacementType);
    Object localObject = new HashSet();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg.g == paramAdPlacementType)
        ((Set)localObject).add(localg.f.toString());
    }
    localObject = s.a((Set)localObject, ",");
    b.put(paramAdPlacementType, localObject);
    return localObject;
  }

  private static g b(f paramf, AdPlacementType paramAdPlacementType)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if ((localg.f == paramf) && (localg.g == paramAdPlacementType))
        return localg;
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.e
 * JD-Core Version:    0.6.2
 */