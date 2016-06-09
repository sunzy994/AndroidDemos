package cmcm.com.myapplication.com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class et
  implements eu<byte[]>
{
  public void a(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    if ((paramOutputStream == null) || (paramArrayOfByte == null))
      return;
    paramOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public byte[] b(InputStream paramInputStream)
  {
    if (paramInputStream == null)
      return null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    fb.a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.et
 * JD-Core Version:    0.6.2
 */