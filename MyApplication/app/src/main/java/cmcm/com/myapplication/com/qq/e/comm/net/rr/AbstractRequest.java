package cmcm.com.myapplication.com.qq.e.comm.net.rr;

import android.net.Uri;
import android.net.Uri.Builder;
import com.qq.e.comm.util.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbstractRequest
  implements Request
{
  private boolean a = true;
  private int b;
  private int c;
  private int d;
  private String e;
  private Map<String, String> f = new HashMap();
  private Map<String, String> g = new HashMap();
  private Map<String, String> h = Collections.unmodifiableMap(this.f);
  private Map<String, String> i = Collections.unmodifiableMap(this.g);
  private Request.Method j;
  private byte[] k;

  public AbstractRequest(String paramString, Request.Method paramMethod, byte[] paramArrayOfByte)
  {
    this.e = paramString;
    this.j = paramMethod;
    if (paramArrayOfByte == null)
    {
      this.k = null;
      return;
    }
    this.k = ((byte[])paramArrayOfByte.clone());
  }

  public void addHeader(String paramString1, String paramString2)
  {
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)))
      return;
    this.f.put(paramString1, paramString2);
  }

  public void addQuery(String paramString1, String paramString2)
  {
    this.g.put(paramString1, paramString2);
  }

  public int getConnectionTimeOut()
  {
    return this.c;
  }

  public Map<String, String> getHeaders()
  {
    return this.h;
  }

  public Request.Method getMethod()
  {
    return this.j;
  }

  public byte[] getPostData()
  {
    return this.k;
  }

  public int getPriority()
  {
    return this.b;
  }

  public Map<String, String> getQuerys()
  {
    return this.i;
  }

  public int getSocketTimeOut()
  {
    return this.d;
  }

  public String getUrl()
  {
    return this.e;
  }

  public String getUrlWithParas()
  {
    if (getQuerys().isEmpty())
      return getUrl();
    Builder localBuilder = Uri.parse(getUrl()).buildUpon();
    Iterator localIterator = getQuerys().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      localBuilder.appendQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localBuilder.build().toString();
  }

  public boolean isAutoClose()
  {
    return this.a;
  }

  public void setAutoClose(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void setConnectionTimeOut(int paramInt)
  {
    this.c = paramInt;
  }

  public void setPriority(int paramInt)
  {
    this.b = paramInt;
  }

  public void setSocketTimeOut(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.rr.AbstractRequest
 * JD-Core Version:    0.6.2
 */