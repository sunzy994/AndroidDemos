package cmcm.com.myapplication.com.facebook.ads.internal.thirdparty.http;

import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class g
  implements q
{
  private void a(Map<String, List<String>> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator1 = paramMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str1 = (String)localIterator1.next();
        Iterator localIterator2 = ((List)paramMap.get(str1)).iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          a(str1 + ":" + str2);
        }
      }
    }
  }

  public void a(n paramn)
  {
    if (paramn != null)
    {
      a("=== HTTP Response ===");
      a("Receive url: " + paramn.b());
      a("Status: " + paramn.a());
      a(paramn.c());
      a("Content:\n" + paramn.e());
    }
  }

  public void a(String paramString)
  {
    System.out.println(paramString);
  }

  public void a(HttpURLConnection paramHttpURLConnection, Object paramObject)
  {
    a("=== HTTP Request ===");
    a(paramHttpURLConnection.getRequestMethod() + " " + paramHttpURLConnection.getURL().toString());
    if ((paramObject instanceof String))
      a("Content: " + (String)paramObject);
    a(paramHttpURLConnection.getRequestProperties());
  }

  public boolean a()
  {
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.thirdparty.http.g
 * JD-Core Version:    0.6.2
 */