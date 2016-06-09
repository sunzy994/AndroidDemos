package cmcm.com.myapplication;

import android.database.Cursor;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class arf
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

  public static String a(InputStream paramInputStream)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramInputStream, localStringWriter);
    return localStringWriter.toString();
  }

  public static List<String> a(InputStream paramInputStream, String paramString)
  {
    if (paramString == null)
      return b(paramInputStream);
    return a(new InputStreamReader(paramInputStream, paramString));
  }

  public static List<String> a(Reader paramReader)
  {
    BufferedReader localBufferedReader = new BufferedReader(paramReader);
    ArrayList localArrayList = new ArrayList();
    for (paramReader = localBufferedReader.readLine(); paramReader != null; paramReader = localBufferedReader.readLine())
      localArrayList.add(paramReader);
    return localArrayList;
  }

  public static void a(Cursor paramCursor)
  {
    if (paramCursor != null);
    try
    {
      paramCursor.close();
      return;
    }
    catch (Exception paramCursor)
    {
    }
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
    }
  }

  public static void a(InputStream paramInputStream, File paramFile)
  {
    try
    {
      paramFile = aqx.c(paramFile);
      try
      {
        a(paramInputStream, paramFile);
        return;
      }
      finally
      {
      }
    }
    finally
    {
      a(paramInputStream);
    }
    throw paramFile;
  }

  public static void a(InputStream paramInputStream, Writer paramWriter)
  {
    a(new InputStreamReader(paramInputStream), paramWriter);
  }

  public static void a(String paramString, OutputStream paramOutputStream)
  {
    if (paramString != null)
      paramOutputStream.write(paramString.getBytes());
  }

  public static void a(String paramString1, OutputStream paramOutputStream, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null)
        a(paramString1, paramOutputStream);
    }
    else
      return;
    paramOutputStream.write(paramString1.getBytes(paramString2));
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

  public static List<String> b(InputStream paramInputStream)
  {
    return a(new InputStreamReader(paramInputStream));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arf
 * JD-Core Version:    0.6.2
 */