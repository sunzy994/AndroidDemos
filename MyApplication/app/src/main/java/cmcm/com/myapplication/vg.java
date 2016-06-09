package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;

@SuppressLint({"RtlHardcoded"})
public class vg
{
  public static final int a;
  public static final int b;
  public static float c;
  public static int d;
  public static int e;
  public static int f;
  public static boolean g;
  public static String h;
  public static boolean i;
  public static boolean j;
  public static boolean k;

  static
  {
    if (Build.VERSION.SDK_INT < 17)
    {
      m = 3;
      a = m;
      if (Build.VERSION.SDK_INT >= 17)
        break label35;
    }
    label35: for (int m = 5; ; m = 8388613)
    {
      b = m;
      return;
      m = 8388611;
      break;
    }
  }

  public static void a(Context paramContext)
  {
    if (paramContext == null)
      return;
    Object localObject = paramContext.getResources();
    if (localObject != null);
    for (localObject = ((Resources)localObject).getConfiguration(); ; localObject = null)
    {
      a(paramContext, (Configuration)localObject);
      apz.a(paramContext);
      add.a(paramContext);
      return;
    }
  }

  public static void a(Context paramContext, Configuration paramConfiguration)
  {
    boolean bool2 = false;
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    c = localDisplayMetrics.density;
    d = localDisplayMetrics.densityDpi;
    f = localDisplayMetrics.heightPixels;
    e = localDisplayMetrics.widthPixels;
    if ((paramConfiguration != null) && (paramConfiguration.orientation == 2));
    for (boolean bool1 = true; ; bool1 = false)
    {
      g = bool1;
      h = c(paramContext);
      if (h != null)
      {
        bool1 = bool2;
        if (!"com.lazyswipe".equals(h));
      }
      else
      {
        bool1 = true;
      }
      i = bool1;
      if (!i)
        j = h.endsWith(":core");
      return;
    }
  }

  public static void b(Context paramContext)
  {
  }

  public static void b(Context paramContext, Configuration paramConfiguration)
  {
    a(paramContext, paramConfiguration);
  }

  // ERROR //
  private static String c(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: sipush 256
    //   5: newarray byte
    //   7: astore_3
    //   8: new 121	java/io/BufferedInputStream
    //   11: dup
    //   12: new 123	java/io/FileInputStream
    //   15: dup
    //   16: ldc 125
    //   18: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 132	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_3
    //   27: iconst_0
    //   28: sipush 255
    //   31: invokevirtual 136	java/io/BufferedInputStream:read	([BII)I
    //   34: pop
    //   35: aload_1
    //   36: ifnull +7 -> 43
    //   39: aload_1
    //   40: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   43: iconst_0
    //   44: istore 4
    //   46: iload 4
    //   48: sipush 256
    //   51: if_icmpge +10 -> 61
    //   54: aload_3
    //   55: iload 4
    //   57: baload
    //   58: ifne +62 -> 120
    //   61: iload 4
    //   63: ifle +66 -> 129
    //   66: iload 4
    //   68: newarray byte
    //   70: astore_0
    //   71: aload_3
    //   72: iconst_0
    //   73: aload_0
    //   74: iconst_0
    //   75: iload 4
    //   77: invokestatic 145	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   80: new 101	java/lang/String
    //   83: dup
    //   84: aload_0
    //   85: invokespecial 148	java/lang/String:<init>	([B)V
    //   88: areturn
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull -50 -> 43
    //   96: aload_1
    //   97: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   100: goto -57 -> 43
    //   103: astore_1
    //   104: goto -61 -> 43
    //   107: astore_0
    //   108: aload_2
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: iload 4
    //   122: iconst_1
    //   123: iadd
    //   124: istore 4
    //   126: goto -80 -> 46
    //   129: aload_0
    //   130: ifnull +71 -> 201
    //   133: invokestatic 154	android/os/Process:myPid	()I
    //   136: istore 4
    //   138: aload_0
    //   139: ldc 156
    //   141: invokevirtual 160	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   144: checkcast 162	android/app/ActivityManager
    //   147: invokevirtual 166	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   150: invokeinterface 172 1 0
    //   155: astore_0
    //   156: aload_0
    //   157: invokeinterface 178 1 0
    //   162: ifeq +39 -> 201
    //   165: aload_0
    //   166: invokeinterface 182 1 0
    //   171: checkcast 184	android/app/ActivityManager$RunningAppProcessInfo
    //   174: astore_1
    //   175: aload_1
    //   176: getfield 187	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   179: iload 4
    //   181: if_icmpne -25 -> 156
    //   184: aload_1
    //   185: getfield 190	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   188: astore_0
    //   189: aload_0
    //   190: areturn
    //   191: astore_0
    //   192: ldc 192
    //   194: ldc 194
    //   196: aload_0
    //   197: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   200: pop
    //   201: aconst_null
    //   202: areturn
    //   203: astore_1
    //   204: goto -161 -> 43
    //   207: astore_1
    //   208: goto -90 -> 118
    //   211: astore_0
    //   212: goto -102 -> 110
    //   215: astore_2
    //   216: goto -124 -> 92
    //
    // Exception table:
    //   from	to	target	type
    //   8	25	89	java/lang/Exception
    //   96	100	103	java/lang/Exception
    //   8	25	107	finally
    //   138	156	191	java/lang/Throwable
    //   156	189	191	java/lang/Throwable
    //   39	43	203	java/lang/Exception
    //   114	118	207	java/lang/Exception
    //   25	35	211	finally
    //   25	35	215	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vg
 * JD-Core Version:    0.6.2
 */