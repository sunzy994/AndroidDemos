package cmcm.com.myapplication.com.facebook.ads.internal.thirdparty.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public abstract interface p
{
  public abstract OutputStream a(HttpURLConnection paramHttpURLConnection);

  public abstract HttpURLConnection a(String paramString);

  public abstract void a(OutputStream paramOutputStream, byte[] paramArrayOfByte);

  public abstract void a(HttpURLConnection paramHttpURLConnection, j paramj, String paramString);

  public abstract boolean a(m paramm);

  public abstract byte[] a(InputStream paramInputStream);

  public abstract InputStream b(HttpURLConnection paramHttpURLConnection);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.thirdparty.http.p
 * JD-Core Version:    0.6.2
 */