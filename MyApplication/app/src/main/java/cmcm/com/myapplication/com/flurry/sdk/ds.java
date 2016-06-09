package cmcm.com.myapplication.com.flurry.sdk;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ds<K, V>
{
  private final Map<K, List<V>> a = new HashMap();
  private int b;

  private List<V> a(K paramK, boolean paramBoolean)
  {
    List localList = (List)this.a.get(paramK);
    Object localObject = localList;
    if (paramBoolean)
    {
      localObject = localList;
      if (localList == null)
        if (this.b <= 0)
          break label63;
    }
    label63: for (localObject = new ArrayList(this.b); ; localObject = new ArrayList())
    {
      this.a.put(paramK, localObject);
      return localObject;
    }
  }

  public List<V> a(K paramK)
  {
    if (paramK == null)
      paramK = Collections.emptyList();
    List localList;
    do
    {
      return paramK;
      localList = a(paramK, false);
      paramK = localList;
    }
    while (localList != null);
    return Collections.emptyList();
  }

  public void a()
  {
    this.a.clear();
  }

  public void a(ds<K, V> paramds)
  {
    if (paramds == null);
    while (true)
    {
      return;
      paramds = paramds.a.entrySet().iterator();
      while (paramds.hasNext())
      {
        Entry localEntry = (Entry)paramds.next();
        this.a.put(localEntry.getKey(), localEntry.getValue());
      }
    }
  }

  public void a(K paramK, V paramV)
  {
    if (paramK == null)
      return;
    a(paramK, true).add(paramV);
  }

  public Collection<Entry<K, V>> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.a.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Entry localEntry = (Entry)localIterator1.next();
      Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
      while (localIterator2.hasNext())
      {
        Object localObject = localIterator2.next();
        localArrayList.add(new AbstractMap.SimpleImmutableEntry(localEntry.getKey(), localObject));
      }
    }
    return localArrayList;
  }

  public boolean b(K paramK)
  {
    if (paramK == null)
      return false;
    if ((List)this.a.remove(paramK) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean b(K paramK, V paramV)
  {
    boolean bool1 = false;
    if (paramK == null);
    List localList;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        localList = a(paramK, false);
      }
      while (localList == null);
      bool2 = localList.remove(paramV);
      bool1 = bool2;
    }
    while (localList.size() != 0);
    this.a.remove(paramK);
    return bool2;
  }

  public Set<K> c()
  {
    return this.a.keySet();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ds
 * JD-Core Version:    0.6.2
 */