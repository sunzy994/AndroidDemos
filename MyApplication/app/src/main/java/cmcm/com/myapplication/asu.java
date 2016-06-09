package cmcm.com.myapplication;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class asu
{
  public static void a(InputStream paramInputStream, String paramString1, String paramString2)
  {
    paramInputStream = new ZipInputStream(paramInputStream);
    while (true)
    {
      Object localObject;
      try
      {
        ZipEntry localZipEntry = paramInputStream.getNextEntry();
        if (localZipEntry == null)
          break;
        localObject = localZipEntry.getName();
        if ((paramString1 != null) && (!((String)localObject).startsWith(paramString1)))
          continue;
        localObject = new File(paramString2, (String)localObject);
        if (localZipEntry.isDirectory())
        {
          ((File)localObject).mkdirs();
          continue;
        }
      }
      finally
      {
        arf.a(paramInputStream);
      }
      if (!((File)localObject).getParentFile().exists())
        ((File)localObject).getParentFile().mkdirs();
      aqx.a(paramInputStream, (File)localObject);
    }
    arf.a(paramInputStream);
  }

  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, null, paramString2);
  }

  // ERROR //
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 63	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: aload_1
    //   11: aload_2
    //   12: invokestatic 68	asu:a	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_3
    //   16: invokestatic 45	arf:a	(Ljava/io/Closeable;)V
    //   19: return
    //   20: astore_0
    //   21: aconst_null
    //   22: astore_1
    //   23: aload_1
    //   24: invokestatic 45	arf:a	(Ljava/io/Closeable;)V
    //   27: aload_0
    //   28: athrow
    //   29: astore_0
    //   30: aload_3
    //   31: astore_1
    //   32: goto -9 -> 23
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	20	finally
    //   9	15	29	finally
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asu
 * JD-Core Version:    0.6.2
 */