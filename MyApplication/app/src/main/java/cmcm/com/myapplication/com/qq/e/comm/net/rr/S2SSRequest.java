package cmcm.com.myapplication.com.qq.e.comm.net.rr;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

public class S2SSRequest extends AbstractRequest
{
  public S2SSRequest(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString, Request.Method.POST, paramArrayOfByte);
  }

  public byte[] getPostData()
  {
    return a.a(super.getPostData());
  }

  public Response initResponse(HttpUriRequest paramHttpUriRequest, HttpResponse paramHttpResponse)
  {
    return new S2SSResponse(paramHttpResponse, paramHttpUriRequest);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.rr.S2SSRequest
 * JD-Core Version:    0.6.2
 */