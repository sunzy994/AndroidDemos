package cmcm.com.myapplication.com.qq.e.comm.net.rr;

import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

public abstract interface Request
{
  public abstract void addHeader(String paramString1, String paramString2);

  public abstract void addQuery(String paramString1, String paramString2);

  public abstract int getConnectionTimeOut();

  public abstract Map<String, String> getHeaders();

  public abstract Request.Method getMethod();

  public abstract byte[] getPostData();

  public abstract int getPriority();

  public abstract Map<String, String> getQuerys();

  public abstract int getSocketTimeOut();

  public abstract String getUrl();

  public abstract String getUrlWithParas();

  public abstract Response initResponse(HttpUriRequest paramHttpUriRequest, HttpResponse paramHttpResponse);

  public abstract boolean isAutoClose();

  public abstract void setConnectionTimeOut(int paramInt);

  public abstract void setSocketTimeOut(int paramInt);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.rr.Request
 * JD-Core Version:    0.6.2
 */