package cmcm.com.myapplication.com.facebook.ads.internal.thirdparty.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class o
  implements Map<String, String>
{
  private Map<String, String> a = new HashMap();

  public o a(Map<? extends String, ? extends String> paramMap)
  {
    putAll(paramMap);
    return this;
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append("&");
      localStringBuilder.append(str);
      str = (String)this.a.get(str);
      if (str != null)
      {
        localStringBuilder.append("=");
        try
        {
          localStringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
    return localStringBuilder.toString();
  }

  public String a(Object paramObject)
  {
    return (String)this.a.get(paramObject);
  }

  public String a(String paramString1, String paramString2)
  {
    return (String)this.a.put(paramString1, paramString2);
  }

  public String b(Object paramObject)
  {
    return (String)this.a.remove(paramObject);
  }

  public byte[] b()
  {
    try
    {
      byte[] arrayOfByte = a().getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }

  public void clear()
  {
    this.a.clear();
  }

  public boolean containsKey(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return this.a.containsValue(paramObject);
  }

  public Set<Entry<String, String>> entrySet()
  {
    return this.a.entrySet();
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public Set<String> keySet()
  {
    return this.a.keySet();
  }

  public void putAll(Map<? extends String, ? extends String> paramMap)
  {
    this.a.putAll(paramMap);
  }

  public int size()
  {
    return this.a.size();
  }

  public Collection<String> values()
  {
    return this.a.values();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.thirdparty.http.o
 * JD-Core Version:    0.6.2
 */