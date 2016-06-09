package cmcm.com.myapplication;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ky
{
  public static String a()
  {
    try
    {
      String str = Build.MODEL.replace(" ", "_");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }

  private static String a(int paramInt, long paramLong, String paramString)
  {
    return paramInt + "," + paramLong + "," + paramString + ";";
  }

  public static String a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
      return a(paramInt, paramLong, paramString1);
    return paramInt + "," + paramLong + "," + paramString1 + "," + paramString2 + ";";
  }

  public static String a(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }

  public static String a(String paramString, int paramInt)
  {
    paramString = paramString.trim();
    if ((paramInt == 1) || (paramInt == 4))
      return paramString.replace(" ", "_").replace(",", "_");
    return paramString.replace(" ", "_").replace("^", "_").replace("`", "_").replace("[", "_").replace("]", "_").replace(",", "_").replace(":", "_").replace(";", "_");
  }

  public static String a(String paramString1, String paramString2)
  {
    return "U:" + paramString1 + "~L:{" + paramString2 + "}";
  }

  public static String a(HashMap<String, String>[] paramArrayOfHashMap)
  {
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    while (true)
    {
      int i;
      StringBuilder localStringBuilder3;
      try
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder1.append("[");
        int j = paramArrayOfHashMap.length;
        i = 0;
        if (i >= j)
          break;
        Object localObject1 = paramArrayOfHashMap[i];
        localStringBuilder3 = new StringBuilder();
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = a((String)((Map.Entry)localObject2).getValue(), 2);
          localStringBuilder3.append(str).append(":").append((String)localObject2).append("`");
          continue;
        }
      }
      catch (Exception paramArrayOfHashMap)
      {
        paramArrayOfHashMap.printStackTrace();
        return "";
      }
      localStringBuilder2.append(localStringBuilder3.toString().substring(0, localStringBuilder3.length() - 1)).append("^");
      i += 1;
    }
    localStringBuilder2.append("]");
    localStringBuilder1.append(localStringBuilder2.toString().trim());
    paramArrayOfHashMap = localStringBuilder1.toString().trim();
    return paramArrayOfHashMap;
  }

  public static HashMap<String, String> a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("<html>")) || (paramString.startsWith("<!DOCTYPE")))
    {
      paramString = null;
      return paramString;
    }
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.replace("{", "").replace("}", "").replace(" ", "").replace("\"", "").split(",");
    int j = arrayOfString.length;
    int i = 0;
    while (true)
    {
      paramString = localHashMap;
      if (i >= j)
        break;
      paramString = arrayOfString[i].split(":");
      if ((paramString != null) && (paramString.length == 2))
        localHashMap.put(paramString[0], paramString[1]);
      i += 1;
    }
  }

  public static void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    CheckedOutputStream localCheckedOutputStream = new CheckedOutputStream(new FileOutputStream(paramString2), new CRC32());
    ZipOutputStream localZipOutputStream = new ZipOutputStream(localCheckedOutputStream);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localZipOutputStream);
    localZipOutputStream.setComment(paramString3);
    localZipOutputStream.setMethod(8);
    localZipOutputStream.setLevel(9);
    paramString3 = new File(paramString1);
    if ((!paramString3.exists()) || ((paramString3.isDirectory()) && (paramString3.list().length == 0)))
      throw new FileNotFoundException("File must exist and ZIP file must have at least one entry.");
    if (paramString3.isFile());
    for (paramString1 = paramString1.substring(0, paramString1.lastIndexOf("/") + 1); ; paramString1 = paramString1.replaceAll("/$", "") + "/")
    {
      paramString2 = paramString1;
      if (paramString3.isDirectory())
      {
        paramString2 = paramString1;
        if (paramString1.indexOf("/") != paramString1.length() - 1)
          paramString2 = paramString1.replaceAll("[^/]+/$", "");
      }
      a(localZipOutputStream, localBufferedOutputStream, paramString3, paramString2);
      localBufferedOutputStream.close();
      if (kn.a)
        Log.i("zipFile", "Checksum: " + localCheckedOutputStream.getChecksum().getValue());
      if (paramBoolean)
        paramString3.delete();
      return;
    }
  }

  private static void a(ZipOutputStream paramZipOutputStream, BufferedOutputStream paramBufferedOutputStream, File paramFile, String paramString)
  {
    String str2 = paramFile.getAbsolutePath();
    String str1 = str2;
    if (paramFile.isDirectory())
      str1 = str2.replaceAll("/$", "") + "/";
    str1 = str1.replace(paramString, "").replaceAll("/$", "");
    if (paramFile.isDirectory())
    {
      if (!"".equals(str1))
      {
        if (kn.a)
          Log.i("zipFile", "正在创建目录 - " + paramFile.getAbsolutePath() + " entryName=" + str1);
        paramZipOutputStream.putNextEntry(new ZipEntry(str1 + "/"));
      }
      paramFile = paramFile.listFiles();
      i = 0;
      while (i < paramFile.length)
      {
        a(paramZipOutputStream, paramBufferedOutputStream, paramFile[i], paramString);
        i += 1;
      }
    }
    if (kn.a)
      Log.i("zipFile", "正在写文件 - " + paramFile.getAbsolutePath() + " entryName=" + str1);
    paramFile = new BufferedInputStream(new FileInputStream(paramFile));
    paramZipOutputStream.putNextEntry(new ZipEntry(str1));
    paramZipOutputStream = new byte[1024];
    for (int i = paramFile.read(paramZipOutputStream); i != -1; i = paramFile.read(paramZipOutputStream))
      paramBufferedOutputStream.write(paramZipOutputStream, 0, i);
    paramBufferedOutputStream.flush();
    paramFile.close();
  }

  public static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = new Long(0xFF & paramLong).byteValue();
      paramLong >>= 8;
      i += 1;
    }
    return arrayOfByte;
  }

  public static byte[] a(File paramFile)
  {
    try
    {
      paramFile = new FileInputStream(paramFile);
      localByteArrayOutputStream = new ByteArrayOutputStream(1000);
      byte[] arrayOfByte = new byte[1000];
      while (true)
      {
        int i = paramFile.read(arrayOfByte);
        if (i == -1)
          break;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (FileNotFoundException paramFile)
    {
      ByteArrayOutputStream localByteArrayOutputStream;
      paramFile.printStackTrace();
      return null;
      paramFile.close();
      localByteArrayOutputStream.close();
      paramFile = localByteArrayOutputStream.toByteArray();
      return paramFile;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
  }

  public static byte[] a(short paramShort)
  {
    byte[] arrayOfByte = new byte[2];
    short s = 0;
    int i = paramShort;
    paramShort = s;
    while (paramShort < arrayOfByte.length)
    {
      arrayOfByte[paramShort] = new Integer(i & 0xFF).byteValue();
      i >>= 8;
      paramShort += 1;
    }
    return arrayOfByte;
  }

  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }

  public static int b()
  {
    try
    {
      int i = VERSION.SDK_INT;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }

  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return 0;
    return Integer.parseInt(paramString);
  }

  public static String b(Context paramContext)
  {
    try
    {
      Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      Object localObject2 = localObject1;
      if (localObject1 == null)
        localObject2 = "";
      Object localObject3 = c(paramContext);
      localObject1 = localObject3;
      if (localObject3 == null)
        localObject1 = "";
      localObject3 = localObject1;
      if (((String)localObject1).equals(localObject2))
        localObject3 = "";
      localObject1 = null;
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)))
        localObject1 = d(paramContext);
      paramContext = (Context)localObject1;
      if (localObject1 == null)
        paramContext = "";
      return (String)localObject2 + "_" + (String)localObject3 + "_" + paramContext;
    }
    catch (Exception localException)
    {
      while (true)
        String str = "";
    }
  }

  public static long c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return 0L;
    return Long.parseLong(paramString);
  }

  public static String c()
  {
    try
    {
      String str = VERSION.RELEASE;
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }

  public static String c(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }

  public static String d()
  {
    try
    {
      String str = Build.MANUFACTURER.replace(" ", "_");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }

  public static String d(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return "";
  }

  public static byte[] d(String paramString)
  {
    try
    {
      byte[] arrayOfByte = a((short)3);
      long l = paramString.getBytes().length;
      if (kn.a)
        Log.i("http", "size:" + l);
      paramString = a(arrayOfByte, a(l));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }

  public static long e()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      long l = localCalendar.getTimeInMillis();
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }

  public static NetworkInfo e(Context paramContext)
  {
    if (paramContext == null)
      return null;
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
      return null;
    return paramContext.getActiveNetworkInfo();
  }

  public static String e(String paramString)
  {
    try
    {
      paramString = InetAddress.getByName(paramString).getHostAddress();
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }

  public static boolean f(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.getType() == 1);
  }

  public static boolean g(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.getSubtype() == 13);
  }

  public static boolean h(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.getType() == 0);
  }

  public static boolean i(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && ((paramContext.getSubtype() == 2) || (paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 4));
  }

  public static String j(Context paramContext)
  {
    try
    {
      if (f(paramContext))
        return "1";
      if (i(paramContext))
        return "2";
      if (h(paramContext))
        return "3";
      if (g(paramContext))
        return "4";
      return "0";
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }

  public static String k(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      RunningAppProcessInfo localRunningAppProcessInfo = (RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i)
        return localRunningAppProcessInfo.processName;
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ky
 * JD-Core Version:    0.6.2
 */