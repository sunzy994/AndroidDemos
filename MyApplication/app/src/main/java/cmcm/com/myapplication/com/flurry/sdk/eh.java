package cmcm.com.myapplication.com.flurry.sdk;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.HttpParams;

public final class eh
{
  private static SchemeRegistry a;

  public static HttpClient a(HttpParams paramHttpParams)
  {
    return new DefaultHttpClient(new SingleClientConnManager(paramHttpParams, a()), paramHttpParams);
  }

  private static SchemeRegistry a()
  {
    try
    {
      if (a != null);
      for (SchemeRegistry localSchemeRegistry = a; ; localSchemeRegistry = a)
      {
        return localSchemeRegistry;
        a = new SchemeRegistry();
        a.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        a.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      }
    }
    finally
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.eh
 * JD-Core Version:    0.6.2
 */