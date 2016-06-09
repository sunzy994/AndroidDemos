package cmcm.com.myapplication;

import java.util.Iterator;
import java.util.Map.Entry;

final class da
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  int a;
  int b;
  boolean c = false;

  da(cw paramcw)
  {
    this.a = (paramcw.a() - 1);
    this.b = -1;
  }

  public Map.Entry<K, V> a()
  {
    this.b += 1;
    this.c = true;
    return this;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!this.c)
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    if (!(paramObject instanceof Map.Entry))
      return false;
    paramObject = (Map.Entry)paramObject;
    if ((cr.a(paramObject.getKey(), this.d.a(this.b, 0))) && (cr.a(paramObject.getValue(), this.d.a(this.b, 1))));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public K getKey()
  {
    if (!this.c)
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    return this.d.a(this.b, 0);
  }

  public V getValue()
  {
    if (!this.c)
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    return this.d.a(this.b, 1);
  }

  public boolean hasNext()
  {
    return this.b < this.a;
  }

  public final int hashCode()
  {
    int j = 0;
    if (!this.c)
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    Object localObject1 = this.d.a(this.b, 0);
    Object localObject2 = this.d.a(this.b, 1);
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null)
        break label69;
    }
    while (true)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label69: j = localObject2.hashCode();
    }
  }

  public void remove()
  {
    if (!this.c)
      throw new IllegalStateException();
    this.d.a(this.b);
    this.b -= 1;
    this.a -= 1;
    this.c = false;
  }

  public V setValue(V paramV)
  {
    if (!this.c)
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    return this.d.a(this.b, paramV);
  }

  public final String toString()
  {
    return getKey() + "=" + getValue();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     da
 * JD-Core Version:    0.6.2
 */