package cmcm.com.myapplication;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.Method;

public class aro
{
  public static File a()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19)
      localObject = new File(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + "com.lazyswipe" + "/files");
    while (true)
    {
      return localObject;
      try
      {
        File localFile = (File)Environment.class.getMethod("getExternalStorageAppFilesDirectory", new Class[] { String.class }).invoke(Environment.class, new Object[] { "com.lazyswipe" });
        localObject = localFile;
        if (!localFile.exists())
        {
          localFile.mkdirs();
          return localFile;
        }
      }
      catch (Exception localException)
      {
      }
    }
    return new File(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + "com.lazyswipe" + "/files");
  }

  public static String a(Context paramContext)
  {
    return b(paramContext).getAbsolutePath() + "/";
  }

  public static String a(String paramString)
  {
    return b() + paramString;
  }

  public static File b(Context paramContext)
  {
    File localFile2 = paramContext.getExternalCacheDir();
    File localFile1 = localFile2;
    if (localFile2 == null)
      localFile1 = paramContext.getCacheDir();
    return localFile1;
  }

  public static String b()
  {
    return a().getAbsolutePath() + "/";
  }

  public static File c()
  {
    if (Build.VERSION.SDK_INT >= 19);
    while (true)
    {
      try
      {
        File localFile1 = new File(((File[])(File[])Environment.class.getMethod("buildExternalStorageAppDataDirs", new Class[] { String.class }).invoke(Environment.class, new Object[] { "com.lazyswipe" }))[0], "cache");
        return localFile1;
      }
      catch (Exception localException1)
      {
        return new File(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + "com.lazyswipe" + "/cache");
      }
      try
      {
        File localFile2 = (File)Environment.class.getMethod("getExternalStorageAppCacheDirectory", new Class[] { String.class }).invoke(Environment.class, new Object[] { "com.lazyswipe" });
        Object localObject = localFile2;
        if (!localFile2.exists())
        {
          localFile2.mkdirs();
          return localFile2;
        }
      }
      catch (Exception localException2)
      {
      }
    }
    return new File(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + "com.lazyswipe" + "/cache");
  }

  public static File d()
  {
    return new File(Environment.getDataDirectory() + "/data/" + "com.lazyswipe");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aro
 * JD-Core Version:    0.6.2
 */