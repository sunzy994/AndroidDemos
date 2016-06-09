package cmcm.com.myapplication;

import java.io.Closeable;
import java.io.InputStream;

public final class rx
  implements Closeable
{
  private final String b;
  private final long c;
  private final InputStream[] d;

  private rx(rt paramrt, String paramString, long paramLong, InputStream[] paramArrayOfInputStream)
  {
    this.b = paramString;
    this.c = paramLong;
    this.d = paramArrayOfInputStream;
  }

  public InputStream a(int paramInt)
  {
    return this.d[paramInt];
  }

  public void close()
  {
    InputStream[] arrayOfInputStream = this.d;
    int j = arrayOfInputStream.length;
    int i = 0;
    while (i < j)
    {
      qp.a(arrayOfInputStream[i]);
      i += 1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rx
 * JD-Core Version:    0.6.2
 */