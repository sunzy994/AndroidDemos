package cmcm.com.myapplication.com.facebook.ads.internal.thirdparty.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class n
{
  private int a;
  private String b;
  private Map<String, List<String>> c;
  private byte[] d;

  public n(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    try
    {
      this.a = paramHttpURLConnection.getResponseCode();
      this.b = paramHttpURLConnection.getURL().toString();
      this.c = paramHttpURLConnection.getHeaderFields();
      this.d = paramArrayOfByte;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public int a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public Map<String, List<String>> c()
  {
    return this.c;
  }

  public byte[] d()
  {
    return this.d;
  }

  public String e()
  {
    if (this.d != null)
      return new String(this.d);
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.thirdparty.http.n
 * JD-Core Version:    0.6.2
 */