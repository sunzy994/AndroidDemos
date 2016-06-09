package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.UUID;

public class jw
{
  private static String a = null;

  public static String a(Context paramContext)
  {
    try
    {
      File localFile;
      if (a == null)
        localFile = new File(paramContext.getFilesDir(), "AF_INSTALLATION");
      try
      {
        if (!localFile.exists())
          a(localFile, paramContext);
        a = a(localFile);
        paramContext = a;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException(paramContext);
      }
    }
    finally
    {
    }
    throw paramContext;
  }

  private static String a(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    paramFile.readFully(arrayOfByte);
    paramFile.close();
    return new String(arrayOfByte);
  }

  private static void a(File paramFile, Context paramContext)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    paramFile = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
    if (Build.VERSION.SDK_INT >= 9);
    for (paramFile = paramFile.firstInstallTime + "-" + Math.abs(new Random().nextLong()); ; paramFile = UUID.randomUUID().toString())
    {
      localFileOutputStream.write(paramFile.getBytes());
      localFileOutputStream.close();
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jw
 * JD-Core Version:    0.6.2
 */