package cmcm.com.myapplication.com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class NetworkClientImpl$TaskCallable
  implements Callable<Response>
{
  private Request a;
  private NetworkCallBack b;

  public NetworkClientImpl$TaskCallable(Request paramRequest)
  {
    this(paramRequest, null);
  }

  public NetworkClientImpl$TaskCallable(Request paramRequest, NetworkCallBack paramNetworkCallBack)
  {
    this.a = paramRequest;
    this.b = paramNetworkCallBack;
  }

  private void a(HttpRequestBase paramHttpRequestBase)
  {
    Object localObject1 = this.a.getHeaders().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Entry)((Iterator)localObject1).next();
      paramHttpRequestBase.setHeader((String)((Entry)localObject2).getKey(), (String)((Entry)localObject2).getValue());
    }
    paramHttpRequestBase.setHeader("User-Agent", "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
    paramHttpRequestBase.addHeader("Accept-Encoding", "gzip");
    Object localObject2 = paramHttpRequestBase.getParams();
    localObject1 = localObject2;
    if (localObject2 == null)
      localObject1 = new BasicHttpParams();
    if (this.a.getConnectionTimeOut() > 0)
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, this.a.getConnectionTimeOut());
    if (this.a.getSocketTimeOut() > 0)
      HttpConnectionParams.setSoTimeout((HttpParams)localObject1, this.a.getSocketTimeOut());
    paramHttpRequestBase.setParams((HttpParams)localObject1);
  }

  public Response call()
  {
    Object localObject2 = null;
    try
    {
      Object localObject1 = this.b;
      HttpClient localHttpClient = NetworkClientImpl.a();
      switch (NetworkClientImpl.1.a[this.a.getMethod().ordinal()])
      {
      case 1:
      case 2:
      }
      while (true)
      {
        Object localObject3 = localHttpClient.execute((HttpUriRequest)localObject1);
        localObject1 = this.a.initResponse((HttpUriRequest)localObject1, (HttpResponse)localObject3);
        localObject2 = localObject1;
        localObject1 = null;
        label77: if (localObject1 == null)
        {
          if (this.b != null)
            this.b.onResponse(this.a, localObject2);
          if (this.a.isAutoClose())
            localObject2.close();
          return localObject2;
          localObject3 = new HttpPost(this.a.getUrlWithParas());
          a((HttpRequestBase)localObject3);
          byte[] arrayOfByte = this.a.getPostData();
          localObject1 = localObject3;
          if (arrayOfByte != null)
          {
            localObject1 = localObject3;
            if (arrayOfByte.length > 0)
            {
              ((HttpPost)localObject3).setEntity(new ByteArrayEntity(arrayOfByte));
              localObject1 = localObject3;
              continue;
              localObject1 = new HttpGet(this.a.getUrlWithParas());
              a((HttpRequestBase)localObject1);
            }
          }
        }
        else
        {
          localObject2.close();
          if (this.b != null)
          {
            GDTLogger.w("NetworkClientException", (Throwable)localObject1);
            this.b.onException((Exception)localObject1);
            return localObject2;
          }
          throw ((Throwable)localObject1);
          localObject1 = null;
        }
      }
    }
    catch (Exception localException)
    {
      break label77;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.NetworkClientImpl.TaskCallable
 * JD-Core Version:    0.6.2
 */