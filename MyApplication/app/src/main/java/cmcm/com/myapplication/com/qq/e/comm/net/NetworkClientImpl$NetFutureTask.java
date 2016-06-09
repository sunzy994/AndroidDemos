package cmcm.com.myapplication.com.qq.e.comm.net;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class NetworkClientImpl$NetFutureTask<T> extends FutureTask<T>
  implements Comparable<NetFutureTask<T>>
{
  private final NetworkClient.Priority a;

  public NetworkClientImpl$NetFutureTask(Callable<T> paramCallable, NetworkClient.Priority paramPriority)
  {
    super(paramPriority);
    Object localObject;
    this.a = localObject;
  }

  public int compareTo(NetFutureTask<T> paramNetFutureTask)
  {
    if (paramNetFutureTask == null)
      return 1;
    return this.a.value() - paramNetFutureTask.a.value();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.NetworkClientImpl.NetFutureTask
 * JD-Core Version:    0.6.2
 */