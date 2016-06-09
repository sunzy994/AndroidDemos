package cmcm.com.myapplication;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class cy
  implements Set<Map.Entry<K, V>>
{
  cy(cw paramcw)
  {
  }

  public boolean a(Map.Entry<K, V> paramEntry)
  {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
  {
    int i = this.a.a();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      this.a.a(localEntry.getKey(), localEntry.getValue());
    }
    return i != this.a.a();
  }

  public void clear()
  {
    this.a.c();
  }

  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry));
    int i;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      i = this.a.a(paramObject.getKey());
    }
    while (i < 0);
    return cr.a(this.a.a(i, 1), paramObject.getValue());
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      if (!contains(paramCollection.next()))
        return false;
    return true;
  }

  public boolean equals(Object paramObject)
  {
    return cw.a(this, paramObject);
  }

  public int hashCode()
  {
    int j = this.a.a() - 1;
    int i = 0;
    if (j >= 0)
    {
      Object localObject1 = this.a.a(j, 0);
      Object localObject2 = this.a.a(j, 1);
      int k;
      if (localObject1 == null)
      {
        k = 0;
        label47: if (localObject2 != null)
          break label80;
      }
      label80: for (int m = 0; ; m = localObject2.hashCode())
      {
        j -= 1;
        i += (m ^ k);
        break;
        k = localObject1.hashCode();
        break label47;
      }
    }
    return i;
  }

  public boolean isEmpty()
  {
    return this.a.a() == 0;
  }

  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new da(this.a);
  }

  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public int size()
  {
    return this.a.a();
  }

  public Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cy
 * JD-Core Version:    0.6.2
 */