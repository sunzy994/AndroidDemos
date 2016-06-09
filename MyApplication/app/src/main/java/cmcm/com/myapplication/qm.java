package cmcm.com.myapplication;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

public class qm
{
  private static final String a = "GameSDK." + qm.class.getSimpleName();

  public static String a(File paramFile)
  {
    return a(paramFile.getAbsolutePath());
  }

  public static String a(String paramString)
  {
    int i = paramString.lastIndexOf(File.separatorChar);
    if (i <= 0)
      return paramString;
    return paramString.substring(i + 1);
  }

  public static void a(File paramFile, FilenameFilter paramFilenameFilter)
  {
    if (!paramFile.exists())
      throw new IllegalArgumentException(paramFile + " does not exist");
    if (!paramFile.isDirectory())
      throw new IllegalArgumentException(paramFile + " is not a directory");
    if (paramFilenameFilter == null);
    for (paramFilenameFilter = paramFile.listFiles(); paramFilenameFilter == null; paramFilenameFilter = paramFile.listFiles(paramFilenameFilter))
      throw new IOException("Failed to list contents of " + paramFile);
    int j = paramFilenameFilter.length;
    paramFile = null;
    int i = 0;
    while (true)
    {
      File localFile;
      if (i < j)
        localFile = paramFilenameFilter[i];
      try
      {
        d(localFile);
        label139: i += 1;
        continue;
        if (paramFile != null)
          throw paramFile;
      }
      catch (IOException paramFile)
      {
        break label139;
      }
    }
  }

  public static boolean a(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null)
      throw new NullPointerException("Source must not be null");
    if (paramFile2 == null)
      throw new NullPointerException("Destination must not be null");
    if (!paramFile1.exists())
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    return (paramFile1.renameTo(paramFile2)) || (b(paramFile1, paramFile2));
  }

  // ERROR //
  public static boolean a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 119	java/io/File:isFile	()Z
    //   7: ifeq +128 -> 135
    //   10: aload_1
    //   11: astore_3
    //   12: aload_1
    //   13: invokevirtual 75	java/io/File:isDirectory	()Z
    //   16: ifeq +16 -> 32
    //   19: new 35	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: aload_0
    //   25: invokestatic 121	qm:a	(Ljava/io/File;)Ljava/lang/String;
    //   28: invokespecial 124	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   31: astore_3
    //   32: ldc 126
    //   34: invokestatic 130	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   37: ldc 132
    //   39: iconst_2
    //   40: anewarray 21	java/lang/Class
    //   43: dup
    //   44: iconst_0
    //   45: ldc 35
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: ldc 35
    //   52: aastore
    //   53: invokevirtual 136	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   56: astore_1
    //   57: aload_1
    //   58: iconst_1
    //   59: invokevirtual 142	java/lang/reflect/Method:setAccessible	(Z)V
    //   62: aload_1
    //   63: aconst_null
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_0
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload_3
    //   75: aastore
    //   76: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 148	java/lang/Boolean
    //   82: invokevirtual 151	java/lang/Boolean:booleanValue	()Z
    //   85: istore 7
    //   87: iload_2
    //   88: ifeq +8 -> 96
    //   91: aload_0
    //   92: invokevirtual 154	java/io/File:delete	()Z
    //   95: pop
    //   96: iload 7
    //   98: ireturn
    //   99: astore_1
    //   100: aload_0
    //   101: invokestatic 158	qm:f	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   104: astore_0
    //   105: aload_0
    //   106: aload_3
    //   107: invokestatic 163	qp:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   110: aload_0
    //   111: invokestatic 166	qp:a	(Ljava/io/Closeable;)V
    //   114: iconst_1
    //   115: ireturn
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 166	qp:a	(Ljava/io/Closeable;)V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore_1
    //   126: aload 4
    //   128: astore_0
    //   129: aload_0
    //   130: invokestatic 166	qp:a	(Ljava/io/Closeable;)V
    //   133: aload_1
    //   134: athrow
    //   135: aload_1
    //   136: invokevirtual 62	java/io/File:exists	()Z
    //   139: ifne +24 -> 163
    //   142: aload_1
    //   143: invokevirtual 169	java/io/File:mkdirs	()Z
    //   146: pop
    //   147: aload_0
    //   148: invokevirtual 81	java/io/File:listFiles	()[Ljava/io/File;
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull +8 -> 161
    //   156: aload_3
    //   157: arraylength
    //   158: ifgt +22 -> 180
    //   161: iconst_1
    //   162: ireturn
    //   163: aload_1
    //   164: invokevirtual 119	java/io/File:isFile	()Z
    //   167: ifeq -20 -> 147
    //   170: new 64	java/lang/IllegalArgumentException
    //   173: dup
    //   174: ldc 171
    //   176: invokespecial 72	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: aload_3
    //   181: arraylength
    //   182: istore 6
    //   184: iconst_0
    //   185: istore 5
    //   187: iload 5
    //   189: iload 6
    //   191: if_icmpge +42 -> 233
    //   194: aload_3
    //   195: iload 5
    //   197: aaload
    //   198: astore 4
    //   200: aload 4
    //   202: new 35	java/io/File
    //   205: dup
    //   206: aload_1
    //   207: aload 4
    //   209: invokestatic 121	qm:a	(Ljava/io/File;)Ljava/lang/String;
    //   212: invokespecial 124	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   215: iload_2
    //   216: invokestatic 173	qm:a	(Ljava/io/File;Ljava/io/File;Z)Z
    //   219: ifne +5 -> 224
    //   222: iconst_0
    //   223: ireturn
    //   224: iload 5
    //   226: iconst_1
    //   227: iadd
    //   228: istore 5
    //   230: goto -43 -> 187
    //   233: aload_0
    //   234: invokevirtual 154	java/io/File:delete	()Z
    //   237: pop
    //   238: iconst_1
    //   239: ireturn
    //   240: astore_1
    //   241: goto -112 -> 129
    //   244: astore_1
    //   245: goto -126 -> 119
    //
    // Exception table:
    //   from	to	target	type
    //   32	87	99	java/lang/Throwable
    //   91	96	99	java/lang/Throwable
    //   100	105	116	java/lang/Throwable
    //   100	105	125	finally
    //   105	110	240	finally
    //   105	110	244	java/lang/Throwable
  }

  public static boolean b(File paramFile)
  {
    if (paramFile == null)
      return false;
    File localFile = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
    paramFile.renameTo(localFile);
    try
    {
      if (localFile.isDirectory())
        c(localFile);
      try
      {
        label54: boolean bool = localFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        Log.w(a, "Delete file failed: " + localFile, paramFile);
        return false;
      }
    }
    catch (Exception paramFile)
    {
      break label54;
    }
  }

  private static boolean b(File paramFile1, File paramFile2)
  {
    return a(paramFile1, paramFile2, true);
  }

  public static void c(File paramFile)
  {
    a(paramFile, null);
  }

  public static void d(File paramFile)
  {
    if (paramFile.isDirectory())
      e(paramFile);
    do
    {
      return;
      if (!paramFile.exists())
        throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    while (paramFile.delete());
    throw new IOException("Unable to delete file: " + paramFile);
  }

  public static void e(File paramFile)
  {
    if (!paramFile.exists());
    do
    {
      return;
      c(paramFile);
    }
    while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }

  public static FileInputStream f(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      if (!paramFile.canRead())
        throw new IOException("File '" + paramFile + "' cannot be read");
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qm
 * JD-Core Version:    0.6.2
 */