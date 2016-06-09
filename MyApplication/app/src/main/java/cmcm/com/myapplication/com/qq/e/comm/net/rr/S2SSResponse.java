package cmcm.com.myapplication.com.qq.e.comm.net.rr;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

public class S2SSResponse extends AbstractResponse
{
  public S2SSResponse(HttpResponse paramHttpResponse, HttpUriRequest paramHttpUriRequest)
  {
    super(paramHttpResponse, paramHttpUriRequest);
  }

  public byte[] getBytesContent()
  {
    try
    {
      byte[] arrayOfByte = a.b(super.getBytesContent());
      return arrayOfByte;
    }
    catch (a.b localb)
    {
      localb.printStackTrace();
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.rr.S2SSResponse
 * JD-Core Version:    0.6.2
 */