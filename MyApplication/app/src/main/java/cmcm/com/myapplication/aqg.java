package cmcm.com.myapplication;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class aqg
{
  public static InputStream a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null)
      return null;
    InputStream localInputStream = paramHttpResponse.getEntity().getContent();
    paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Encoding");
    if ((paramHttpResponse != null) && (paramHttpResponse.getValue().equalsIgnoreCase("gzip")))
      return new GZIPInputStream(localInputStream);
    return localInputStream;
  }

  public static <T> T a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    int m = 0;
    Object localObject2 = null;
    int n = -1;
    NetworkInfo localNetworkInfo = arl.d(paramContext);
    int j = m;
    int i = n;
    Object localObject1 = localObject2;
    if (localNetworkInfo != null)
    {
      j = m;
      i = n;
      localObject1 = localObject2;
      if (localNetworkInfo.getType() != 1)
      {
        localObject1 = Proxy.getHost(paramContext);
        m = Proxy.getPort(paramContext);
        if ((localObject1 == null) || (m <= 0))
          break label146;
        i = k;
        j = i;
        i = m;
      }
    }
    if (paramBoolean1);
    for (paramContext = new HttpGet(paramString); ; paramContext = new HttpPost(paramString))
    {
      if (j != 0)
      {
        paramString = new HttpHost((String)localObject1, i);
        ConnRouteParams.setDefaultProxy(paramContext.getParams(), paramString);
      }
      if (paramBoolean2)
        paramContext.addHeader("Accept-Encoding", "gzip");
      return paramContext;
      label146: i = 0;
      break;
    }
  }

  public static HttpClient a()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpClientParams.setRedirecting(localBasicHttpParams, true);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, "lazy");
    return new DefaultHttpClient(localBasicHttpParams);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqg
 * JD-Core Version:    0.6.2
 */