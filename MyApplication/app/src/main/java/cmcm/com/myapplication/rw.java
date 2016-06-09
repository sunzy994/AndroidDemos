package cmcm.com.myapplication;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class rw
{
  private final String b;
  private final long[] c;
  private boolean d;
  private ru e;
  private long f;

  private rw(rt paramrt, String paramString)
  {
    this.b = paramString;
    this.c = new long[rt.e(paramrt)];
  }

  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != rt.e(this.a))
      throw b(paramArrayOfString);
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.c[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw b(paramArrayOfString);
    }
  }

  private IOException b(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }

  public File a(int paramInt)
  {
    return new File(rt.f(this.a), this.b + "." + paramInt);
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long[] arrayOfLong = this.c;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      localStringBuilder.append(' ').append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }

  public File b(int paramInt)
  {
    return new File(rt.f(this.a), this.b + "." + paramInt + ".tmp");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rw
 * JD-Core Version:    0.6.2
 */