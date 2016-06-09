package cmcm.com.myapplication;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cq<K, V> extends df<K, V>
  implements Map<K, V>
{
  cw<K, V> a;

  private cw<K, V> b()
  {
    if (this.a == null)
      this.a = new cw()
      {
        protected int a()
        {
          return cq.this.h;
        }

        protected int a(Object paramAnonymousObject)
        {
          return cq.this.a(paramAnonymousObject);
        }

        protected Object a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return cq.this.g[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }

        protected V a(int paramAnonymousInt, V paramAnonymousV)
        {
          return cq.this.a(paramAnonymousInt, paramAnonymousV);
        }

        protected void a(int paramAnonymousInt)
        {
          cq.this.d(paramAnonymousInt);
        }

        protected void a(K paramAnonymousK, V paramAnonymousV)
        {
          cq.this.put(paramAnonymousK, paramAnonymousV);
        }

        protected int b(Object paramAnonymousObject)
        {
          return cq.this.b(paramAnonymousObject);
        }

        protected Map<K, V> b()
        {
          return cq.this;
        }

        protected void c()
        {
          cq.this.clear();
        }
      };
    return this.a;
  }

  public boolean a(Collection<?> paramCollection)
  {
    return cw.c(this, paramCollection);
  }

  public Set<Entry<K, V>> entrySet()
  {
    return b().d();
  }

  public Set<K> keySet()
  {
    return b().e();
  }

  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    a(this.h + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Entry localEntry = (Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }

  public Collection<V> values()
  {
    return b().f();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cq
 * JD-Core Version:    0.6.2
 */