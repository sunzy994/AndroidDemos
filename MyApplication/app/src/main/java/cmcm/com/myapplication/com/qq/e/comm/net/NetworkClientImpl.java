package cmcm.com.myapplication.com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class NetworkClientImpl
  implements NetworkClient
{
  private static final HttpClient a = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  private static final NetworkClient b = new NetworkClientImpl();
  private final ExecutorService c = new ThreadPoolExecutor(5, 10, 180L, TimeUnit.SECONDS, this.d);
  private PriorityBlockingQueue<Runnable> d = new PriorityBlockingQueue(15);

  static
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, 30000L);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(3));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
    HttpProtocolParams.setUserAgent(localBasicHttpParams, "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
  }

  public static NetworkClient getInstance()
  {
    return b;
  }

  public Future<Response> submit(Request paramRequest)
  {
    return submit(paramRequest, NetworkClient.Priority.Mid);
  }

  public Future<Response> submit(Request paramRequest, NetworkClient.Priority paramPriority)
  {
    paramRequest = new NetworkClientImpl.NetFutureTask(this, new NetworkClientImpl.TaskCallable(paramRequest), paramPriority);
    this.c.execute(paramRequest);
    GDTLogger.d("QueueSize:" + this.d.size());
    return paramRequest;
  }

  public void submit(Request paramRequest, NetworkCallBack paramNetworkCallBack)
  {
    submit(paramRequest, NetworkClient.Priority.Mid, paramNetworkCallBack);
  }

  public void submit(Request paramRequest, NetworkClient.Priority paramPriority, NetworkCallBack paramNetworkCallBack)
  {
    paramRequest = new NetworkClientImpl.NetFutureTask(this, new NetworkClientImpl.TaskCallable(paramRequest, paramNetworkCallBack), paramPriority);
    this.c.execute(paramRequest);
    GDTLogger.d("QueueSize:" + this.d.size());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.NetworkClientImpl
 * JD-Core Version:    0.6.2
 */