package cmcm.com.myapplication.com.flurry.sdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class de
  implements er
{
  protected final String d;
  Set<String> e = new HashSet();
  dg f;
  protected String g = "defaultDataKey_";

  public de(String paramString1, String paramString2)
  {
    this.d = paramString2;
    es.a().a(this);
    a(paramString1);
  }

  protected String a(String paramString1, String paramString2)
  {
    return this.g + paramString1 + "_" + paramString2;
  }

  protected void a(final de.a parama)
  {
    a(new fc()
    {
      public void a()
      {
        de.this.f();
        if (parama != null)
          parama.a();
      }
    });
  }

  protected void a(fc paramfc)
  {
    do.a().c(paramfc);
  }

  protected void a(final String paramString)
  {
    a(new fc()
    {
      public void a()
      {
        de.this.f = new dg(paramString);
      }
    });
  }

  protected void a(final String paramString1, final String paramString2, int paramInt)
  {
    a(new fc()
    {
      public void a()
      {
        if (!de.this.f.a(paramString1, paramString2))
          el.a(6, de.this.d, "Internal error. Block wasn't deleted with id = " + paramString1);
        if (!de.this.e.remove(paramString1))
          el.a(6, de.this.d, "Internal error. Block with id = " + paramString1 + " was not in progress state");
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    el.a(4, this.d, "onNetworkStateChanged : isNetworkEnable = " + paramBoolean);
    if (paramBoolean)
      d();
  }

  protected abstract void a(byte[] paramArrayOfByte, String paramString1, String paramString2);

  protected void a(byte[] paramArrayOfByte, String paramString1, String paramString2, de.a parama)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      el.a(6, this.d, "Report that has to be sent is EMPTY or NULL");
      return;
    }
    c(paramArrayOfByte, paramString1, paramString2);
    a(parama);
  }

  protected void b(final String paramString1, String paramString2)
  {
    a(new fc()
    {
      public void a()
      {
        if (!de.this.e.remove(paramString1))
          el.a(6, de.this.d, "Internal error. Block with id = " + paramString1 + " was not in progress state");
      }
    });
  }

  public void b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    a(paramArrayOfByte, paramString1, paramString2, null);
  }

  protected int c()
  {
    return this.e.size();
  }

  protected void c(String paramString1, String paramString2)
  {
    if (!this.f.a(paramString1, paramString2))
      el.a(6, this.d, "Internal error. Block wasn't deleted with id = " + paramString1);
    if (!this.e.remove(paramString1))
      el.a(6, this.d, "Internal error. Block with id = " + paramString1 + " was not in progress state");
  }

  protected void c(final byte[] paramArrayOfByte, final String paramString1, final String paramString2)
  {
    a(new fc()
    {
      public void a()
      {
        de.this.d(paramArrayOfByte, paramString1, paramString2);
      }
    });
  }

  protected String d(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    paramString2 = new df();
    paramString2.a(paramArrayOfByte);
    paramArrayOfByte = paramString2.a();
    this.f.a(paramString2, paramString1);
    return paramArrayOfByte;
  }

  protected void d()
  {
    a(null);
  }

  protected boolean e()
  {
    return c() <= 5;
  }

  protected void f()
  {
    if (!es.a().c())
    {
      el.a(5, this.d, "Reports were not sent! No Internet connection!");
      return;
    }
    label59: String str1;
    do
    {
      Object localObject;
      do
      {
        localObject = this.f.a();
        if ((localObject == null) || (((List)localObject).isEmpty()))
        {
          el.a(4, this.d, "No more reports to send.");
          return;
        }
        localObject = ((List)localObject).iterator();
      }
      while (!((Iterator)localObject).hasNext());
      str1 = (String)((Iterator)localObject).next();
    }
    while (!e());
    List localList = this.f.c(str1);
    el.a(4, this.d, "Number of not sent blocks = " + localList.size());
    int i = 0;
    label129: String str2;
    if (i < localList.size())
    {
      str2 = (String)localList.get(i);
      if (!this.e.contains(str2))
        break label176;
    }
    while (true)
    {
      i += 1;
      break label129;
      break label59;
      label176: if (!e())
        break;
      byte[] arrayOfByte = new df(str2).b();
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        el.a(6, this.d, "Internal ERROR! Report is empty!");
        this.f.a(str2, str1);
      }
      else
      {
        this.e.add(str2);
        a(arrayOfByte, str2, str1);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.de
 * JD-Core Version:    0.6.2
 */