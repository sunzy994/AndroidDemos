package cmcm.com.myapplication;

import android.util.Log;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.zip.CRC32;

public class aqx
{
  public static final File[] a = new File[0];

  public static FileOutputStream a(File paramFile, boolean paramBoolean)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      if (!paramFile.canWrite())
        throw new IOException("File '" + paramFile + "' cannot be written to");
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs()))
        throw new IOException("File '" + paramFile + "' could not be created");
    }
    return new FileOutputStream(paramFile, paramBoolean);
  }

  public static String a(File paramFile)
  {
    return a(paramFile.getAbsolutePath());
  }

  public static String a(File paramFile, int paramInt, String paramString)
  {
    try
    {
      Method localMethod = Class.forName("android.os.FileUtils").getDeclaredMethod("readTextFile", new Class[] { File.class, Integer.TYPE, String.class });
      localMethod.setAccessible(true);
      paramFile = (String)localMethod.invoke(null, new Object[] { paramFile, Integer.valueOf(paramInt), paramString });
      return paramFile;
    }
    catch (Throwable paramFile)
    {
    }
    return null;
  }

  public static String a(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      while (true)
      {
        String str = paramInputStream.readLine();
        if (str == null)
          break;
        localStringBuilder.append(str).append("\n");
      }
    }
    catch (OutOfMemoryError paramInputStream)
    {
      Log.e("Swipe.FileUtils", "readTextStream failed", paramInputStream);
    }
    return localStringBuilder.toString();
  }

  public static String a(String paramString)
  {
    int i = paramString.lastIndexOf(File.separatorChar);
    if (i <= 0)
      return paramString;
    return paramString.substring(i + 1);
  }

  // ERROR //
  private static java.util.zip.Checksum a(File paramFile, java.util.zip.Checksum paramChecksum)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 23	java/io/File:isDirectory	()Z
    //   4: ifeq +13 -> 17
    //   7: new 156	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 158
    //   13: invokespecial 159	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 161	java/util/zip/CheckedInputStream
    //   20: dup
    //   21: new 163	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: aload_1
    //   30: invokespecial 169	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   33: astore_2
    //   34: aload_2
    //   35: new 171	aqy
    //   38: dup
    //   39: aconst_null
    //   40: invokespecial 174	aqy:<init>	(Laqx$1;)V
    //   43: invokestatic 179	arf:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   46: pop
    //   47: aload_2
    //   48: ifnull +7 -> 55
    //   51: aload_2
    //   52: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   55: aload_1
    //   56: areturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: aload_2
    //   72: astore_1
    //   73: goto -13 -> 60
    //
    // Exception table:
    //   from	to	target	type
    //   17	34	57	finally
    //   34	47	70	finally
  }

  public static void a(File paramFile, int paramInt, long paramLong)
  {
    try
    {
      Method localMethod = Class.forName("android.os.FileUtils").getDeclaredMethod("deleteOlderFiles", new Class[] { File.class, Integer.TYPE, Long.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramFile, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      return;
    }
    catch (Throwable localThrowable)
    {
      b(paramFile, paramInt, paramLong);
    }
  }

  public static void a(File paramFile, long paramLong)
  {
    a(paramFile, 0, paramLong);
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
        h(localFile);
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

  public static void a(File paramFile, String paramString1, String paramString2, boolean paramBoolean)
  {
    File localFile = null;
    try
    {
      paramFile = a(paramFile, paramBoolean);
      localFile = paramFile;
      arf.a(paramString1, paramFile, paramString2);
      return;
    }
    finally
    {
      arf.a(localFile);
    }
    throw paramFile;
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

  public static boolean a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramFile1.isFile())
    {
      localObject = paramFile2;
      if (paramFile2.isDirectory())
        localObject = new File(paramFile2, a(paramFile1));
    }
    do
    {
      do
      {
        try
        {
          paramFile2 = Class.forName("android.os.FileUtils").getDeclaredMethod("copyFile", new Class[] { File.class, File.class });
          paramFile2.setAccessible(true);
          bool2 = ((Boolean)paramFile2.invoke(null, new Object[] { paramFile1, localObject })).booleanValue();
          bool1 = bool2;
          if (paramBoolean)
          {
            paramFile1.delete();
            bool1 = bool2;
          }
          return bool1;
        }
        catch (Throwable paramFile1)
        {
          return false;
        }
        if (paramFile2.exists())
          break;
        paramFile2.mkdirs();
        localObject = paramFile1.listFiles();
        bool1 = bool2;
      }
      while (localObject == null);
      boolean bool1 = bool2;
    }
    while (localObject.length <= 0);
    int j = localObject.length;
    int i = 0;
    while (true)
    {
      if (i >= j)
        break label215;
      File localFile = localObject[i];
      if (!a(localFile, new File(paramFile2, a(localFile)), paramBoolean))
      {
        return false;
        if (!paramFile2.isFile())
          break;
        throw new IllegalArgumentException("destFile must be a directory!");
      }
      i += 1;
    }
    label215: paramFile1.delete();
    return true;
  }

  public static boolean a(File paramFile, String paramString)
  {
    return a(paramFile.getAbsolutePath(), paramString);
  }

  public static boolean a(File paramFile, String paramString, boolean paramBoolean)
  {
    return a(paramFile.getAbsolutePath(), paramString, paramBoolean);
  }

  public static boolean a(InputStream paramInputStream, File paramFile)
  {
    try
    {
      Method localMethod = Class.forName("android.os.FileUtils").getDeclaredMethod("copyToFile", new Class[] { InputStream.class, File.class });
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(null, new Object[] { paramInputStream, paramFile })).booleanValue();
      return bool;
    }
    catch (Throwable paramInputStream)
    {
    }
    return false;
  }

  public static boolean a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, false);
  }

  // ERROR //
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: iload_2
    //   12: ifne +57 -> 69
    //   15: ldc 79
    //   17: invokestatic 85	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   20: ldc_w 279
    //   23: iconst_2
    //   24: anewarray 81	java/lang/Class
    //   27: dup
    //   28: iconst_0
    //   29: ldc 95
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: ldc 95
    //   36: aastore
    //   37: invokevirtual 99	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   40: astore_3
    //   41: aload_3
    //   42: iconst_1
    //   43: invokevirtual 105	java/lang/reflect/Method:setAccessible	(Z)V
    //   46: aload_3
    //   47: aconst_null
    //   48: iconst_2
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_1
    //   59: aastore
    //   60: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_0
    //   67: iconst_0
    //   68: ireturn
    //   69: new 64	java/io/FileOutputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   77: astore 5
    //   79: aload 5
    //   81: astore_3
    //   82: aload 7
    //   84: astore_0
    //   85: aload 6
    //   87: astore 4
    //   89: aload 5
    //   91: invokevirtual 284	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   94: invokevirtual 290	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   97: astore 6
    //   99: aload 5
    //   101: astore_3
    //   102: aload 6
    //   104: astore_0
    //   105: aload 6
    //   107: astore 4
    //   109: aload 5
    //   111: aload_1
    //   112: invokevirtual 294	java/lang/String:getBytes	()[B
    //   115: invokevirtual 298	java/io/FileOutputStream:write	([B)V
    //   118: aload 5
    //   120: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   123: aload 6
    //   125: ifnull -61 -> 64
    //   128: aload 6
    //   130: invokevirtual 303	java/nio/channels/FileLock:isValid	()Z
    //   133: ifeq -69 -> 64
    //   136: aload 6
    //   138: invokevirtual 306	java/nio/channels/FileLock:release	()V
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_0
    //   144: iconst_1
    //   145: ireturn
    //   146: astore 6
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: astore_3
    //   152: aload 4
    //   154: astore_0
    //   155: ldc 133
    //   157: ldc_w 308
    //   160: aload 6
    //   162: invokestatic 311	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   165: pop
    //   166: aload_1
    //   167: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   170: aload 4
    //   172: ifnull +16 -> 188
    //   175: aload 4
    //   177: invokevirtual 303	java/nio/channels/FileLock:isValid	()Z
    //   180: ifeq +8 -> 188
    //   183: aload 4
    //   185: invokevirtual 306	java/nio/channels/FileLock:release	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: astore_1
    //   191: aconst_null
    //   192: astore 4
    //   194: aload_3
    //   195: astore_0
    //   196: aload 4
    //   198: astore_3
    //   199: aload_3
    //   200: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   203: aload_0
    //   204: ifnull +14 -> 218
    //   207: aload_0
    //   208: invokevirtual 303	java/nio/channels/FileLock:isValid	()Z
    //   211: ifeq +7 -> 218
    //   214: aload_0
    //   215: invokevirtual 306	java/nio/channels/FileLock:release	()V
    //   218: aload_1
    //   219: athrow
    //   220: astore_0
    //   221: goto -33 -> 188
    //   224: astore_0
    //   225: goto -7 -> 218
    //   228: astore_1
    //   229: goto -30 -> 199
    //   232: astore 6
    //   234: aload 5
    //   236: astore_1
    //   237: goto -87 -> 150
    //
    // Exception table:
    //   from	to	target	type
    //   15	64	66	java/lang/Throwable
    //   136	141	143	java/lang/Throwable
    //   69	79	146	java/lang/Throwable
    //   69	79	190	finally
    //   183	188	220	java/lang/Throwable
    //   214	218	224	java/lang/Throwable
    //   89	99	228	finally
    //   109	118	228	finally
    //   155	166	228	finally
    //   89	99	232	java/lang/Throwable
    //   109	118	232	java/lang/Throwable
  }

  public static FileInputStream b(File paramFile)
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

  public static String b(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = a(paramInputStream);
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
    }
    return null;
  }

  public static void b(File paramFile, int paramInt, long paramLong)
  {
    int k = 0;
    if ((paramInt < 0) || (paramLong < 0L))
      throw new IllegalArgumentException("Constraints must be positive or 0");
    paramFile = paramFile.listFiles();
    if (paramFile == null);
    while (true)
    {
      return;
      Comparator local1 = new Comparator()
      {
        public int a(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          return (int)(paramAnonymousFile1.lastModified() - paramAnonymousFile2.lastModified());
        }
      };
      try
      {
        Arrays.sort(paramFile, local1);
        i = 1;
        long l = System.currentTimeMillis();
        int m = paramFile.length;
        int n = paramFile.length;
        int j = 0;
        while (k < n)
        {
          local1 = paramFile[k];
          if (j >= m - paramInt)
            break;
          if (l - local1.lastModified() <= paramLong)
            break label132;
          local1.delete();
          k += 1;
          j += 1;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        label132: 
        do
          while (true)
            i = 0;
        while (i == 0);
      }
    }
  }

  public static void b(File paramFile, String paramString)
  {
    b(paramFile, paramString, false);
  }

  public static void b(File paramFile, String paramString, boolean paramBoolean)
  {
    a(paramFile, paramString, null, paramBoolean);
  }

  public static void b(InputStream paramInputStream, File paramFile)
  {
    try
    {
      paramFile = c(paramFile);
      try
      {
        arf.a(paramInputStream, paramFile);
        return;
      }
      finally
      {
      }
    }
    finally
    {
      arf.a(paramInputStream);
    }
    throw paramFile;
  }

  public static boolean b(File paramFile1, File paramFile2)
  {
    return a(paramFile1, paramFile2, true);
  }

  // ERROR //
  public static boolean b(File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 350	java/io/RandomAccessFile
    //   5: dup
    //   6: aload_0
    //   7: ldc_w 352
    //   10: invokespecial 353	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore_2
    //   14: iload_1
    //   15: ifeq +155 -> 170
    //   18: aload_2
    //   19: invokevirtual 354	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   22: invokevirtual 290	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   25: astore_0
    //   26: aload_2
    //   27: invokevirtual 357	java/io/RandomAccessFile:length	()J
    //   30: lstore 4
    //   32: aload_2
    //   33: lconst_1
    //   34: lload 4
    //   36: ladd
    //   37: invokevirtual 361	java/io/RandomAccessFile:setLength	(J)V
    //   40: aload_2
    //   41: lload 4
    //   43: invokevirtual 361	java/io/RandomAccessFile:setLength	(J)V
    //   46: aload_2
    //   47: ifnull +7 -> 54
    //   50: aload_2
    //   51: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   54: aload_0
    //   55: ifnull +14 -> 69
    //   58: aload_0
    //   59: invokevirtual 303	java/nio/channels/FileLock:isValid	()Z
    //   62: ifeq +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 306	java/nio/channels/FileLock:release	()V
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_0
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_3
    //   75: astore_2
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   84: aload_2
    //   85: ifnull +14 -> 99
    //   88: aload_2
    //   89: invokevirtual 303	java/nio/channels/FileLock:isValid	()Z
    //   92: ifeq +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 306	java/nio/channels/FileLock:release	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_3
    //   102: aconst_null
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   114: aload_0
    //   115: ifnull +14 -> 129
    //   118: aload_0
    //   119: invokevirtual 303	java/nio/channels/FileLock:isValid	()Z
    //   122: ifeq +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 306	java/nio/channels/FileLock:release	()V
    //   129: aload_3
    //   130: athrow
    //   131: astore_0
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: goto -36 -> 99
    //   138: astore_0
    //   139: goto -10 -> 129
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_0
    //   145: goto -39 -> 106
    //   148: astore_3
    //   149: goto -43 -> 106
    //   152: astore_0
    //   153: aload_2
    //   154: astore_0
    //   155: aload_3
    //   156: astore_2
    //   157: goto -81 -> 76
    //   160: astore_3
    //   161: aload_2
    //   162: astore_3
    //   163: aload_0
    //   164: astore_2
    //   165: aload_3
    //   166: astore_0
    //   167: goto -91 -> 76
    //   170: aconst_null
    //   171: astore_0
    //   172: goto -146 -> 26
    //
    // Exception table:
    //   from	to	target	type
    //   2	14	71	java/lang/Throwable
    //   2	14	101	finally
    //   65	69	131	java/lang/Throwable
    //   95	99	134	java/lang/Throwable
    //   125	129	138	java/lang/Throwable
    //   18	26	142	finally
    //   26	46	148	finally
    //   18	26	152	java/lang/Throwable
    //   26	46	160	java/lang/Throwable
  }

  public static boolean b(String paramString)
  {
    return e(new File(paramString));
  }

  public static FileOutputStream c(File paramFile)
  {
    return a(paramFile, false);
  }

  public static String c(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    while (true)
    {
      int i = paramInputStream.read();
      if (i == -1)
        throw new EOFException();
      if ((i == 10) || (i == 0))
      {
        i = localStringBuilder.length();
        if ((i > 0) && (localStringBuilder.charAt(i - 1) == '\r'))
          localStringBuilder.setLength(i - 1);
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i);
    }
  }

  public static String c(String paramString)
  {
    return i(new File(paramString));
  }

  public static List<String> c(File paramFile, String paramString)
  {
    File localFile = null;
    try
    {
      paramFile = b(paramFile);
      localFile = paramFile;
      paramString = arf.a(paramFile, paramString);
      return paramString;
    }
    finally
    {
      arf.a(localFile);
    }
    throw paramFile;
  }

  public static boolean c(File paramFile1, File paramFile2)
  {
    return a(paramFile1, paramFile2, false);
  }

  public static String d(String paramString)
  {
    return j(new File(paramString));
  }

  public static void d(File paramFile)
  {
    if (!paramFile.exists());
    do
    {
      return;
      g(paramFile);
    }
    while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }

  public static boolean e(File paramFile)
  {
    if (paramFile == null)
      return false;
    File localFile = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
    paramFile.renameTo(localFile);
    try
    {
      if (localFile.isDirectory())
        g(localFile);
      try
      {
        label54: boolean bool = localFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        Log.w("Swipe.FileUtils", "Delete file failed: " + localFile, paramFile);
        return false;
      }
    }
    catch (Exception paramFile)
    {
      break label54;
    }
  }

  public static void f(File paramFile)
  {
    try
    {
      a(paramFile, null);
      return;
    }
    catch (Exception paramFile)
    {
    }
  }

  public static void g(File paramFile)
  {
    a(paramFile, null);
  }

  public static void h(File paramFile)
  {
    if (paramFile.isDirectory())
      d(paramFile);
    do
    {
      return;
      if (!paramFile.exists())
        throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    while (paramFile.delete());
    throw new IOException("Unable to delete file: " + paramFile);
  }

  public static String i(File paramFile)
  {
    return a(paramFile, 0, null);
  }

  // ERROR //
  public static String j(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 163	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: aload_1
    //   14: invokestatic 428	aqx:c	(Ljava/io/InputStream;)Ljava/lang/String;
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_1
    //   21: ifnull +9 -> 30
    //   24: aload_1
    //   25: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   28: aload_2
    //   29: astore_0
    //   30: aload_0
    //   31: areturn
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: ldc 133
    //   39: new 27	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 430
    //   49: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: invokevirtual 433	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   56: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 436	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: aload_3
    //   67: astore_0
    //   68: aload_1
    //   69: ifnull -39 -> 30
    //   72: aload_1
    //   73: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_0
    //   82: astore_1
    //   83: aload_2
    //   84: ifnull +7 -> 91
    //   87: aload_2
    //   88: invokestatic 182	arf:a	(Ljava/io/Closeable;)V
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: astore_2
    //   96: goto -13 -> 83
    //   99: astore_2
    //   100: goto -65 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	32	java/lang/Exception
    //   2	11	78	finally
    //   13	18	93	finally
    //   37	66	93	finally
    //   13	18	99	java/lang/Exception
  }

  public static long k(File paramFile)
  {
    try
    {
      Method localMethod = Class.forName("android.os.FileUtils").getDeclaredMethod("checksumCrc32", new Class[] { File.class });
      localMethod.setAccessible(true);
      long l = ((Long)localMethod.invoke(null, new Object[] { paramFile })).longValue();
      return l;
    }
    catch (Throwable localThrowable)
    {
    }
    return n(paramFile);
  }

  public static boolean l(File paramFile)
  {
    return b(paramFile, false);
  }

  public static List<String> m(File paramFile)
  {
    return c(paramFile, null);
  }

  private static long n(File paramFile)
  {
    try
    {
      CRC32 localCRC32 = new CRC32();
      a(paramFile, localCRC32);
      long l = localCRC32.getValue();
      return l;
    }
    catch (Throwable paramFile)
    {
    }
    return -1L;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqx
 * JD-Core Version:    0.6.2
 */