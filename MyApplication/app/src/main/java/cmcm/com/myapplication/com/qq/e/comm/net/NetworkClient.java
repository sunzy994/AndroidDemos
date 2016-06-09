package cmcm.com.myapplication.com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import java.util.concurrent.Future;

public abstract interface NetworkClient
{
  public abstract Future<Response> submit(Request paramRequest);

  public abstract Future<Response> submit(Request paramRequest, NetworkClient.Priority paramPriority);

  public abstract void submit(Request paramRequest, NetworkCallBack paramNetworkCallBack);

  public abstract void submit(Request paramRequest, NetworkClient.Priority paramPriority, NetworkCallBack paramNetworkCallBack);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.NetworkClient
 * JD-Core Version:    0.6.2
 */