package cmcm.com.myapplication.com.qq.e.comm.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StringUtil
{
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }

  public static String join(String paramString, String[] paramArrayOfString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfString != null)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if ((paramString != null) && (i != 0))
          localStringBuffer.append(paramString);
        localStringBuffer.append(paramArrayOfString[i]);
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }

  public static int parseInteger(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
    }
    return paramInt;
  }

  // ERROR //
  public static String readAll(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 55	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 57	java/io/BufferedReader
    //   16: dup
    //   17: new 59	java/io/FileReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 62	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   25: invokespecial 65	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: new 67	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 71	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +36 -> 83
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: aload_3
    //   54: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -19 -> 39
    //   61: astore_2
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: astore_1
    //   66: aload_1
    //   67: athrow
    //   68: astore_2
    //   69: aload_0
    //   70: astore_1
    //   71: aload_2
    //   72: astore_0
    //   73: aload_1
    //   74: ifnull +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 77	java/io/BufferedReader:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 77	java/io/BufferedReader:close	()V
    //   94: aload_2
    //   95: areturn
    //   96: astore_0
    //   97: ldc 80
    //   99: aload_0
    //   100: invokestatic 86	com/qq/e/comm/util/GDTLogger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: areturn
    //   105: astore_1
    //   106: ldc 80
    //   108: aload_1
    //   109: invokestatic 86	com/qq/e/comm/util/GDTLogger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: goto -31 -> 81
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -45 -> 73
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: goto -58 -> 66
    //
    // Exception table:
    //   from	to	target	type
    //   31	39	61	java/io/IOException
    //   41	46	61	java/io/IOException
    //   52	58	61	java/io/IOException
    //   85	90	61	java/io/IOException
    //   31	39	68	finally
    //   41	46	68	finally
    //   52	58	68	finally
    //   66	68	68	finally
    //   85	90	68	finally
    //   90	94	96	java/lang/Exception
    //   77	81	105	java/lang/Exception
    //   13	29	115	finally
    //   13	29	121	java/io/IOException
  }

  public static void writeTo(String paramString, File paramFile)
  {
    if (paramFile == null)
      throw new IOException("Target File Can not be null in StringUtil.writeTo");
    File localFile = paramFile.getParentFile();
    if (!localFile.exists())
      localFile.mkdirs();
    paramFile = new FileWriter(paramFile);
    paramFile.write(paramString);
    paramFile.close();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.util.StringUtil
 * JD-Core Version:    0.6.2
 */