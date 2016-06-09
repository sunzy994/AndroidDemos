package cmcm.com.myapplication.com.qq.e.comm.util;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil
{
  // ERROR //
  public static boolean copyTo(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_3
    //   16: astore_2
    //   17: aload_1
    //   18: invokevirtual 19	java/io/File:getParentFile	()Ljava/io/File;
    //   21: invokevirtual 23	java/io/File:exists	()Z
    //   24: ifne +29 -> 53
    //   27: aload_3
    //   28: astore_2
    //   29: aload_1
    //   30: invokevirtual 19	java/io/File:getParentFile	()Ljava/io/File;
    //   33: invokevirtual 26	java/io/File:mkdirs	()Z
    //   36: istore 7
    //   38: iload 7
    //   40: ifne +13 -> 53
    //   43: aload_0
    //   44: invokestatic 30	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   47: aconst_null
    //   48: invokestatic 33	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_3
    //   54: astore_2
    //   55: new 35	java/io/FileOutputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 38	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: astore_3
    //   64: sipush 1024
    //   67: newarray byte
    //   69: astore_2
    //   70: aload_0
    //   71: aload_2
    //   72: invokevirtual 44	java/io/InputStream:read	([B)I
    //   75: istore 6
    //   77: iload 6
    //   79: ifle +49 -> 128
    //   82: aload_3
    //   83: aload_2
    //   84: iconst_0
    //   85: iload 6
    //   87: invokevirtual 48	java/io/FileOutputStream:write	([BII)V
    //   90: goto -20 -> 70
    //   93: astore 4
    //   95: aload_3
    //   96: astore_2
    //   97: ldc 50
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_1
    //   106: invokevirtual 54	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: aastore
    //   110: invokestatic 60	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   113: aload 4
    //   115: invokestatic 66	com/qq/e/comm/util/GDTLogger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_0
    //   119: invokestatic 30	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   122: aload_3
    //   123: invokestatic 33	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: aload_0
    //   129: invokestatic 30	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   132: aload_3
    //   133: invokestatic 33	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   136: iconst_1
    //   137: ireturn
    //   138: astore_1
    //   139: aload_0
    //   140: invokestatic 30	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/InputStream;)V
    //   143: aload_2
    //   144: invokestatic 33	com/qq/e/comm/util/FileUtil:tryClose	(Ljava/io/OutputStream;)V
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: aload_3
    //   151: astore_2
    //   152: goto -13 -> 139
    //   155: astore 4
    //   157: aload 5
    //   159: astore_3
    //   160: goto -65 -> 95
    //
    // Exception table:
    //   from	to	target	type
    //   64	70	93	java/lang/Throwable
    //   70	77	93	java/lang/Throwable
    //   82	90	93	java/lang/Throwable
    //   17	27	138	finally
    //   29	38	138	finally
    //   55	64	138	finally
    //   97	118	138	finally
    //   64	70	149	finally
    //   70	77	149	finally
    //   82	90	149	finally
    //   17	27	155	java/lang/Throwable
    //   29	38	155	java/lang/Throwable
    //   55	64	155	java/lang/Throwable
  }

  public static boolean renameTo(File paramFile1, File paramFile2)
  {
    if ((paramFile1 == null) || (paramFile2 == null) || (!paramFile1.exists()))
      return false;
    if (!paramFile1.renameTo(paramFile2))
      return copyTo(null, paramFile2);
    return true;
  }

  public static void tryClose(InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
    }
  }

  public static void tryClose(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null);
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (Exception paramOutputStream)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.util.FileUtil
 * JD-Core Version:    0.6.2
 */