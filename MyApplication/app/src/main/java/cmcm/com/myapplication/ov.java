package cmcm.com.myapplication;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class ov
{
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = b(paramInputStream, paramOutputStream);
    if (l > 2147483647L)
      return -1;
    return (int)l;
  }

  public static int a(Reader paramReader, Writer paramWriter)
  {
    long l = b(paramReader, paramWriter);
    if (l > 2147483647L)
      return -1;
    return (int)l;
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      ow.a(paramCloseable);
    }
  }

  public static void a(InputStream paramInputStream, File paramFile)
  {
    a(paramInputStream, paramFile, false);
  }

  // ERROR //
  public static void a(InputStream paramInputStream, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 37	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 41	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: aload_0
    //   10: aload_3
    //   11: invokestatic 43	ov:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   14: pop
    //   15: aload_3
    //   16: invokestatic 45	ov:a	(Ljava/io/Closeable;)V
    //   19: iload_2
    //   20: ifeq +7 -> 27
    //   23: aload_0
    //   24: invokestatic 45	ov:a	(Ljava/io/Closeable;)V
    //   27: return
    //   28: astore_1
    //   29: aconst_null
    //   30: astore_3
    //   31: aload_3
    //   32: invokestatic 45	ov:a	(Ljava/io/Closeable;)V
    //   35: iload_2
    //   36: ifeq +7 -> 43
    //   39: aload_0
    //   40: invokestatic 45	ov:a	(Ljava/io/Closeable;)V
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: goto -15 -> 31
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	28	finally
    //   9	15	45	finally
  }

  public static void a(InputStream paramInputStream, Writer paramWriter)
  {
    a(new InputStreamReader(paramInputStream), paramWriter);
  }

  public static long b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i)
        break;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }

  public static long b(Reader paramReader, Writer paramWriter)
  {
    char[] arrayOfChar = new char[4096];
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramReader.read(arrayOfChar);
      if (-1 == i)
        break;
      paramWriter.write(arrayOfChar, 0, i);
    }
    return l;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ov
 * JD-Core Version:    0.6.2
 */