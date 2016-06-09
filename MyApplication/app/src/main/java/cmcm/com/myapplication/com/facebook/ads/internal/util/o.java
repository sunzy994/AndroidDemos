package cmcm.com.myapplication.com.facebook.ads.internal.util;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.ads.internal.thirdparty.http.n;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class o extends AsyncTask<String, Void, Void>
{
  private static final String a = o.class.getSimpleName();
  private static final Set<String> b = new HashSet();
  private Map<String, String> c;
  private Map<String, String> d;

  static
  {
    b.add("#");
    b.add("null");
  }

  public o()
  {
    this(null, null);
  }

  public o(Map<String, String> paramMap)
  {
    this(paramMap, null);
  }

  public o(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    this.c = paramMap1;
    this.d = paramMap2;
  }

  private String a(String paramString1, String paramString2, String paramString3)
  {
    if ((r.a(paramString1)) || (r.a(paramString2)) || (r.a(paramString3)))
      return paramString1;
    if (paramString1.contains("?"));
    for (String str = "&"; ; str = "?")
      return paramString1 + str + paramString2 + "=" + URLEncoder.encode(paramString3);
  }

  private boolean a(String paramString)
  {
    boolean bool = true;
    com.facebook.ads.internal.thirdparty.http.a locala = g.c();
    try
    {
      if ((this.d == null) || (this.d.size() == 0))
      {
        if (locala.a(paramString, null).a() != 200)
          break label115;
        return true;
      }
      com.facebook.ads.internal.thirdparty.http.o localo = new com.facebook.ads.internal.thirdparty.http.o();
      localo.a(this.d);
      int i = locala.b(paramString, localo).a();
      if (i != 200)
        return false;
    }
    catch (Exception localException)
    {
      Log.e(a, "Error opening url: " + paramString, localException);
      bool = false;
    }
    return bool;
    label115: return false;
  }

  private String b(String paramString)
  {
    try
    {
      String str = a(paramString, "analog", g.a(a.a()));
      return str;
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }

  protected Void a(String[] paramArrayOfString)
  {
    paramArrayOfString = paramArrayOfString[0];
    if ((r.a(paramArrayOfString)) || (b.contains(paramArrayOfString)));
    while (true)
    {
      return null;
      paramArrayOfString = b(paramArrayOfString);
      Object localObject = paramArrayOfString;
      if (this.c != null)
      {
        localObject = paramArrayOfString;
        if (!this.c.isEmpty())
        {
          localObject = this.c.entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Entry localEntry = (Entry)((Iterator)localObject).next();
            paramArrayOfString = a(paramArrayOfString, (String)localEntry.getKey(), (String)localEntry.getValue());
          }
          localObject = paramArrayOfString;
        }
      }
      int i = 1;
      while ((i <= 2) && (!a((String)localObject)))
        i += 1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.o
 * JD-Core Version:    0.6.2
 */