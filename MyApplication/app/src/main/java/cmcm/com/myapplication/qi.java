package cmcm.com.myapplication;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class qi<E> extends AbstractSet<E>
{
  private final ConcurrentMap<E, Boolean> a = new ConcurrentHashMap();

  public boolean add(E paramE)
  {
    return this.a.put(paramE, Boolean.TRUE) == null;
  }

  public void clear()
  {
    this.a.clear();
  }

  public boolean contains(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public Iterator<E> iterator()
  {
    return this.a.keySet().iterator();
  }

  public boolean remove(Object paramObject)
  {
    return this.a.remove(paramObject) == Boolean.TRUE;
  }

  public int size()
  {
    return this.a.size();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qi
 * JD-Core Version:    0.6.2
 */