package cmcm.com.myapplication.com.facebook.ads.internal.thirdparty.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class f
  implements p
{
  private final q a;

  public f()
  {
    this(new g());
  }

  public f(q paramq)
  {
    this.a = paramq;
  }

  public OutputStream a(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getOutputStream();
  }

  public HttpURLConnection a(String paramString)
  {
    return (HttpURLConnection)new URL(paramString).openConnection();
  }

  public void a(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    paramOutputStream.write(paramArrayOfByte);
  }

  public void a(HttpURLConnection paramHttpURLConnection, j paramj, String paramString)
  {
    paramHttpURLConnection.setRequestMethod(paramj.c());
    paramHttpURLConnection.setDoOutput(paramj.b());
    paramHttpURLConnection.setDoInput(paramj.a());
    if (paramString != null)
      paramHttpURLConnection.setRequestProperty("Content-Type", paramString);
    paramHttpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
  }

  public boolean a(m paramm)
  {
    n localn = paramm.a();
    if (this.a.a())
    {
      this.a.a("BasicRequestHandler.onError got");
      paramm.printStackTrace();
    }
    return (localn != null) && (localn.a() > 0);
  }

  public byte[] a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[16384];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }

  public InputStream b(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getInputStream();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.thirdparty.http.f
 * JD-Core Version:    0.6.2
 */