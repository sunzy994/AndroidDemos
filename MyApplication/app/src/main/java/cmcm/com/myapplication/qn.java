package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class qn
{
  private static ExecutorService a;

  public static String a(File paramFile)
  {
    paramFile = new FileInputStream(paramFile);
    byte[] arrayOfByte = new byte[paramFile.available()];
    paramFile.read(arrayOfByte);
    paramFile.close();
    return new String(arrayOfByte, "UTF-8");
  }

  public static void a(Context paramContext, ComponentName paramComponentName, CharSequence paramCharSequence, Bitmap paramBitmap, Bundle paramBundle)
  {
    paramComponentName = new Intent("android.intent.action.MAIN").setComponent(paramComponentName).replaceExtras(paramBundle);
    paramContext.sendBroadcast(new Intent("com.android.launcher.action.INSTALL_SHORTCUT").putExtra("android.intent.extra.shortcut.NAME", paramCharSequence).putExtra("duplicate", false).putExtra("android.intent.extra.shortcut.INTENT", paramComponentName).putExtra("android.intent.extra.shortcut.ICON", paramBitmap));
  }

  public static void a(File paramFile, String paramString)
  {
    File localFile = paramFile.getParentFile();
    if (!localFile.exists())
      localFile.mkdirs();
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramString.getBytes());
    paramFile.close();
  }

  public static void a(FileLock paramFileLock, File paramFile)
  {
    if ((paramFileLock != null) && (paramFileLock.isValid()))
      paramFileLock.release();
    if (paramFile != null)
      paramFile.delete();
  }

  public static boolean a(Runnable paramRunnable)
  {
    return new Handler(Looper.getMainLooper()).post(paramRunnable);
  }

  public static String b(File paramFile)
  {
    int i = 0;
    char[] arrayOfChar = new char[16];
    char[] tmp9_8 = arrayOfChar;
    tmp9_8[0] = 48;
    char[] tmp14_9 = tmp9_8;
    tmp14_9[1] = 49;
    char[] tmp19_14 = tmp14_9;
    tmp19_14[2] = 50;
    char[] tmp24_19 = tmp19_14;
    tmp24_19[3] = 51;
    char[] tmp29_24 = tmp24_19;
    tmp29_24[4] = 52;
    char[] tmp34_29 = tmp29_24;
    tmp34_29[5] = 53;
    char[] tmp39_34 = tmp34_29;
    tmp39_34[6] = 54;
    char[] tmp45_39 = tmp39_34;
    tmp45_39[7] = 55;
    char[] tmp51_45 = tmp45_39;
    tmp51_45[8] = 56;
    char[] tmp57_51 = tmp51_45;
    tmp57_51[9] = 57;
    char[] tmp63_57 = tmp57_51;
    tmp63_57[10] = 65;
    char[] tmp69_63 = tmp63_57;
    tmp69_63[11] = 66;
    char[] tmp75_69 = tmp69_63;
    tmp75_69[12] = 67;
    char[] tmp81_75 = tmp75_69;
    tmp81_75[13] = 68;
    char[] tmp87_81 = tmp81_75;
    tmp87_81[14] = 69;
    char[] tmp93_87 = tmp87_81;
    tmp93_87[15] = 70;
    tmp93_87;
    Object localObject = MessageDigest.getInstance("MD5");
    paramFile = new FileInputStream(paramFile);
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      j = paramFile.read(arrayOfByte, 0, 1024);
      if (j == -1)
        break;
      ((MessageDigest)localObject).update(arrayOfByte, 0, j);
    }
    paramFile.close();
    paramFile = ((MessageDigest)localObject).digest();
    int k = paramFile.length;
    localObject = new char[k * 2];
    int j = 0;
    while (i < k)
    {
      int m = paramFile[i];
      int n = j + 1;
      localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
      j = n + 1;
      localObject[n] = arrayOfChar[(m & 0xF)];
      i += 1;
    }
    return new String((char[])localObject);
  }

  public static Thread b(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.start();
    return paramRunnable;
  }

  public static void b(File paramFile, String paramString)
  {
    paramFile = paramFile.getAbsolutePath().replace(" ", "\\ ");
    paramFile = Runtime.getRuntime().exec("chmod " + paramString + " " + paramFile);
    int i = paramFile.waitFor();
    StringWriter localStringWriter = new StringWriter();
    qp.a(paramFile.getErrorStream(), localStringWriter);
    paramFile = localStringWriter.toString();
    if (i != 0)
      throw new IOException("change file mode to " + paramString + " failed, code: " + i + ", error: " + paramFile);
  }

  public static String c(File paramFile)
  {
    File localFile = new File(paramFile.getAbsolutePath() + ".md5");
    try
    {
      String str = a(localFile);
      return str;
    }
    catch (Throwable localThrowable2)
    {
      paramFile = b(paramFile);
      try
      {
        a(localFile, paramFile);
        Runtime.getRuntime().exec("chmod 644 " + localFile.getAbsolutePath());
        return paramFile;
      }
      catch (Throwable localThrowable1)
      {
      }
    }
    return paramFile;
  }

  public static void c(Runnable paramRunnable)
  {
    if ((a == null) || (!(a instanceof ExecutorService)))
      a = Executors.newFixedThreadPool(2);
    a.execute(paramRunnable);
  }

  public static FileLock d(File paramFile)
  {
    File localFile = paramFile.getParentFile();
    if (!localFile.exists())
      localFile.mkdirs();
    if (!paramFile.exists())
      paramFile.createNewFile();
    paramFile = new FileOutputStream(paramFile).getChannel().lock();
    if (paramFile.isValid())
      return paramFile;
    throw new pi("file lock is not valid");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qn
 * JD-Core Version:    0.6.2
 */