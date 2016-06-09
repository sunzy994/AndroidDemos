package cmcm.com.myapplication.com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;

public abstract interface NetworkCallBack
{
  public abstract void onException(Exception paramException);

  public abstract void onResponse(Request paramRequest, Response paramResponse);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.NetworkCallBack
 * JD-Core Version:    0.6.2
 */