package cmcm.com.myapplication.com.qq.e.comm.net.rr;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

public class PlainRequest extends AbstractRequest
{
  public PlainRequest(String paramString, Request.Method paramMethod, byte[] paramArrayOfByte)
  {
    super(paramString, paramMethod, paramArrayOfByte);
  }

  public Response initResponse(HttpUriRequest paramHttpUriRequest, HttpResponse paramHttpResponse)
  {
    return new PlainResponse(paramHttpResponse, paramHttpUriRequest);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.rr.PlainRequest
 * JD-Core Version:    0.6.2
 */