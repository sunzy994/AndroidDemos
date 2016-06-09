package cmcm.com.myapplication;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class rv extends FilterOutputStream
{
  private rv(ru paramru, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public void close()
  {
    try
    {
      this.out.close();
      return;
    }
    catch (IOException localIOException)
    {
      ru.a(this.a, true);
    }
  }

  public void flush()
  {
    try
    {
      this.out.flush();
      return;
    }
    catch (IOException localIOException)
    {
      ru.a(this.a, true);
    }
  }

  public void write(int paramInt)
  {
    try
    {
      this.out.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      ru.a(this.a, true);
    }
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      ru.a(this.a, true);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rv
 * JD-Core Version:    0.6.2
 */