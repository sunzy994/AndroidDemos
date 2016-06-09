package cmcm.com.myapplication;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class cw<K, V>
{
  cw<K, V>.cy b;
  cw<K, V>.cz c;
  cw<K, V>.db d;

  public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      if (!paramMap.containsKey(paramCollection.next()))
        return false;
    return true;
  }

  public static <T> boolean a(Set<T> paramSet, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramSet == paramObject)
      bool1 = true;
    while (!(paramObject instanceof Set))
      return bool1;
    paramObject = (Set)paramObject;
    try
    {
      if (paramSet.size() == paramObject.size())
      {
        bool1 = paramSet.containsAll(paramObject);
        if (!bool1);
      }
      for (bool1 = bool2; ; bool1 = false)
        return bool1;
    }
    catch (ClassCastException paramSet)
    {
      return false;
    }
    catch (NullPointerException paramSet)
    {
    }
    return false;
  }

  public static <K, V> boolean b(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      paramMap.remove(paramCollection.next());
    return i != paramMap.size();
  }

  public static <K, V> boolean c(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
      if (!paramCollection.contains(localIterator.next()))
        localIterator.remove();
    return i != paramMap.size();
  }

  protected abstract int a();

  protected abstract int a(Object paramObject);

  protected abstract Object a(int paramInt1, int paramInt2);

  protected abstract V a(int paramInt, V paramV);

  protected abstract void a(int paramInt);

  protected abstract void a(K paramK, V paramV);

  public <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    int j = a();
    if (paramArrayOfT.length < j)
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    while (true)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayOfT[i] = a(i, paramInt);
        i += 1;
      }
      if (paramArrayOfT.length > j)
        paramArrayOfT[j] = null;
      return paramArrayOfT;
    }
  }

  protected abstract int b(Object paramObject);

  protected abstract Map<K, V> b();

  public Object[] b(int paramInt)
  {
    int j = a();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = a(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }

  protected abstract void c();

  public Set<Entry<K, V>> d()
  {
    if (this.b == null)
      this.b = new cy(this);
    return this.b;
  }

  public Set<K> e()
  {
    if (this.c == null)
      this.c = new cz(this);
    return this.c;
  }

  public Collection<V> f()
  {
    if (this.d == null)
      this.d = new db(this);
    return this.d;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cw
 * JD-Core Version:    0.6.2
 */