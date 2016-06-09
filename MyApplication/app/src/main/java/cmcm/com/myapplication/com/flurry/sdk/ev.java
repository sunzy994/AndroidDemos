package cmcm.com.myapplication.com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ev
  implements eu<String>
{
  public void a(OutputStream paramOutputStream, String paramString)
  {
    if ((paramOutputStream == null) || (paramString == null))
      return;
    paramString = paramString.getBytes("utf-8");
    paramOutputStream.write(paramString, 0, paramString.length);
  }

  public String b(InputStream paramInputStream)
  {
    if (paramInputStream == null)
      return null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    fb.a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ev
 * JD-Core Version:    0.6.2
 */