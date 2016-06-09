package cmcm.com.myapplication;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ail extends FilterInputStream
{
  private byte[] a = null;
  private int b = 0;
  private boolean c = true;

  public ail(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public static int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[2] & 0xFF0000 | (paramArrayOfByte[3] & 0xFF) << 24;
  }

  public void close()
  {
    this.b = 0;
    this.a = null;
    this.c = true;
    super.close();
  }

  public boolean markSupported()
  {
    return false;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramInt1 + paramInt2 > paramArrayOfByte.length)
      throw new IOException(" offset + count should less then buffer.length ");
    if (paramInt2 == 0)
      return paramInt2;
    if (this.c);
    int i;
    do
    {
      try
      {
        byte[] arrayOfByte = new byte[4];
        i = 0;
        int k;
        do
        {
          k = super.read(arrayOfByte, i, 4 - i);
          if (k <= 0)
            break;
          k = i + k;
          i = k;
        }
        while (k < 4);
        i = a(arrayOfByte);
        continue;
        this.a = new byte[i];
        while (i > 0)
        {
          k = super.read(this.a, j, i);
          if (k <= 0)
            break;
          j += k;
          i -= k;
        }
        this.a = air.a(this.a);
        this.c = false;
        if (paramInt2 <= this.a.length - this.b)
        {
          System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
          this.b += paramInt2;
          return paramInt2;
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        return -1;
      }
      System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, this.a.length - this.b);
      i = this.a.length - this.b;
      this.b += i;
      return super.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i) + i;
      i = 0;
    }
    while (i >= 0);
    return -1;
  }

  public void reset()
  {
    super.reset();
    this.b = 0;
    this.a = null;
    this.c = true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ail
 * JD-Core Version:    0.6.2
 */