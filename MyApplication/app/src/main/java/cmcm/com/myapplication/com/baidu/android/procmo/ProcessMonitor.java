package cmcm.com.myapplication.com.baidu.android.procmo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;

public class ProcessMonitor
{
  private static boolean e = true;
  private Context a;
  private String b = "";
  private String c = "";
  private String d = "";

  static
  {
    try
    {
      System.loadLibrary("moi");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      e = false;
    }
  }

  public ProcessMonitor(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }

  // ERROR //
  private String a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 51	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: getfield 46	com/baidu/android/procmo/ProcessMonitor:a	Landroid/content/Context;
    //   11: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: ldc 59
    //   16: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_3
    //   20: new 51	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 46	com/baidu/android/procmo/ProcessMonitor:a	Landroid/content/Context;
    //   28: invokestatic 65	com/baidu/android/procmo/ProcessMonitor:a	(Landroid/content/Context;)Ljava/lang/String;
    //   31: ldc 59
    //   33: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_3
    //   38: invokevirtual 72	java/io/File:exists	()Z
    //   41: ifeq +20 -> 61
    //   44: aload_3
    //   45: invokevirtual 76	java/io/File:length	()J
    //   48: aload_1
    //   49: invokevirtual 76	java/io/File:length	()J
    //   52: lcmp
    //   53: ifne +8 -> 61
    //   56: aload_3
    //   57: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: areturn
    //   61: new 81	java/io/FileInputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 84	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore_1
    //   70: new 86	java/io/FileOutputStream
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   78: astore_2
    //   79: sipush 4096
    //   82: newarray byte
    //   84: astore 4
    //   86: iload 5
    //   88: iconst_m1
    //   89: if_icmpne +53 -> 142
    //   92: aload_3
    //   93: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: sipush 493
    //   99: iconst_m1
    //   100: iconst_m1
    //   101: invokestatic 91	com/baidu/android/procmo/ProcessMonitor:setPermissions	(Ljava/lang/String;III)I
    //   104: pop
    //   105: aload_3
    //   106: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: astore_3
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 94	java/io/FileInputStream:close	()V
    //   118: aload_2
    //   119: ifnull +116 -> 235
    //   122: aload_2
    //   123: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   126: aload_3
    //   127: areturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   133: aload_3
    //   134: areturn
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 31	java/lang/Throwable:printStackTrace	()V
    //   140: aconst_null
    //   141: areturn
    //   142: aload_1
    //   143: aload 4
    //   145: invokevirtual 100	java/io/FileInputStream:read	([B)I
    //   148: istore 6
    //   150: iload 6
    //   152: istore 5
    //   154: iload 6
    //   156: iconst_m1
    //   157: if_icmpeq -71 -> 86
    //   160: aload_2
    //   161: aload 4
    //   163: iconst_0
    //   164: iload 6
    //   166: invokevirtual 104	java/io/FileOutputStream:write	([BII)V
    //   169: iload 6
    //   171: istore 5
    //   173: goto -87 -> 86
    //   176: astore_3
    //   177: aload_3
    //   178: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 94	java/io/FileInputStream:close	()V
    //   189: aload_2
    //   190: ifnull -50 -> 140
    //   193: aload_2
    //   194: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   197: goto -57 -> 140
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   205: goto -65 -> 140
    //   208: astore_3
    //   209: aload_1
    //   210: ifnull +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 94	java/io/FileInputStream:close	()V
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   225: aload_3
    //   226: athrow
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   232: goto -7 -> 225
    //   235: aload_3
    //   236: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   114	118	128	java/io/IOException
    //   122	126	128	java/io/IOException
    //   3	61	135	java/lang/Throwable
    //   61	79	135	java/lang/Throwable
    //   114	118	135	java/lang/Throwable
    //   122	126	135	java/lang/Throwable
    //   129	133	135	java/lang/Throwable
    //   185	189	135	java/lang/Throwable
    //   193	197	135	java/lang/Throwable
    //   201	205	135	java/lang/Throwable
    //   213	217	135	java/lang/Throwable
    //   221	225	135	java/lang/Throwable
    //   225	227	135	java/lang/Throwable
    //   228	232	135	java/lang/Throwable
    //   79	86	176	java/io/IOException
    //   92	110	176	java/io/IOException
    //   142	150	176	java/io/IOException
    //   160	169	176	java/io/IOException
    //   185	189	200	java/io/IOException
    //   193	197	200	java/io/IOException
    //   79	86	208	finally
    //   92	110	208	finally
    //   142	150	208	finally
    //   160	169	208	finally
    //   177	181	208	finally
    //   213	217	227	java/io/IOException
    //   221	225	227	java/io/IOException
  }

  private static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (Build.VERSION.SDK_INT >= 9)
        return paramContext.applicationInfo.nativeLibraryDir;
      paramContext = new File(paramContext.applicationInfo.dataDir, "lib").getAbsolutePath();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }

  private void a(String paramString)
  {
    if (paramString == null)
      return;
    try
    {
      String str1 = a(this.a);
      String str2 = this.c;
      int i = 0;
      if (Build.VERSION.SDK_INT >= 17)
        i = 1;
      String str3 = this.a.getApplicationInfo().dataDir;
      paramString = paramString + " " + str3 + " " + str1 + " " + this.b + " " + str2 + " " + i + " " + this.d;
      Runtime.getRuntime().exec(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }

  private native void exitIfRunning(String paramString);

  private static native int setPermissions(String paramString, int paramInt1, int paramInt2, int paramInt3);

  public void a(final long paramLong)
  {
    if (!e)
      return;
    Thread localThread = new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(paramLong);
          try
          {
            label7: ProcessMonitor.a(ProcessMonitor.this, ProcessMonitor.a(ProcessMonitor.this));
            String str = ProcessMonitor.b(ProcessMonitor.this);
            ProcessMonitor.b(ProcessMonitor.this, str);
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label7;
        }
      }
    });
    localThread.setName("ProcessMonitor-init");
    localThread.start();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.baidu.android.procmo.ProcessMonitor
 * JD-Core Version:    0.6.2
 */