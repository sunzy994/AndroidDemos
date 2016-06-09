package cmcm.com.myapplication.com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class dq
{
  private Map<String, Object> a = new HashMap();
  private Map<String, List<dq.a>> b = new HashMap();

  private boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  private void b(String paramString, Object paramObject)
  {
    if (this.b.get(paramString) != null)
    {
      Iterator localIterator = ((List)this.b.get(paramString)).iterator();
      while (localIterator.hasNext())
        ((dq.a)localIterator.next()).a(paramString, paramObject);
    }
  }

  public Object a(String paramString)
  {
    try
    {
      paramString = this.a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
    }
    throw paramString;
  }

  public void a(String paramString, dq.a parama)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool);
      while (true)
      {
        return;
        if (parama != null)
        {
          List localList = (List)this.b.get(paramString);
          Object localObject = localList;
          if (localList == null)
            localObject = new LinkedList();
          ((List)localObject).add(parama);
          this.b.put(paramString, localObject);
        }
      }
    }
    finally
    {
    }
    throw paramString;
  }

  public void a(String paramString, Object paramObject)
  {
    while (true)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool)
          return;
        if (a(paramObject, this.a.get(paramString)))
          continue;
        if (paramObject == null)
        {
          this.a.remove(paramString);
          b(paramString, paramObject);
          continue;
        }
      }
      finally
      {
      }
      this.a.put(paramString, paramObject);
    }
  }

  public boolean b(String paramString, dq.a parama)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
        bool = false;
      while (true)
      {
        return bool;
        if (parama == null)
        {
          bool = false;
        }
        else
        {
          paramString = (List)this.b.get(paramString);
          if (paramString == null)
            bool = false;
          else
            bool = paramString.remove(parama);
        }
      }
    }
    finally
    {
    }
    throw paramString;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dq
 * JD-Core Version:    0.6.2
 */