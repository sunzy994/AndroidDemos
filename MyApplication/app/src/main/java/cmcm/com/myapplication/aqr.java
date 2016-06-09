package cmcm.com.myapplication;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.lazyswipe.SwipeApplication;

public class aqr
{
  public static final boolean a;
  public static final int b;
  private static final byte[] c;
  private static long d;

  static
  {
    if (((!Build.MANUFACTURER.equalsIgnoreCase("OnePlus")) || ((!Build.MODEL.equals("A0001")) && (!Build.DEVICE.equals("A0001")))) && ((VERSION.SDK_INT < 19) || (!Build.MANUFACTURER.equalsIgnoreCase("samsung")) || ((!Build.MODEL.equals("m0")) && (!Build.DEVICE.equals("m0")))));
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      b = 2;
      c = new byte[1024];
      d = -1L;
      return;
    }
  }

  public static long a()
  {
    if (d < 0L)
      d = a("/proc/meminfo", new String[] { "MemTotal" });
    return d;
  }

  // ERROR //
  private static long a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_1
    //   4: arraylength
    //   5: newarray long
    //   7: astore 4
    //   9: new 72	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: getstatic 55	aqr:c	[B
    //   24: invokevirtual 80	java/io/FileInputStream:read	([B)I
    //   27: istore 11
    //   29: iconst_0
    //   30: istore 5
    //   32: iconst_0
    //   33: istore 7
    //   35: iload 5
    //   37: iload 11
    //   39: if_icmpge +143 -> 182
    //   42: aload_2
    //   43: astore_0
    //   44: iload 7
    //   46: aload_1
    //   47: arraylength
    //   48: if_icmpeq +134 -> 182
    //   51: iconst_0
    //   52: istore 9
    //   54: iload 5
    //   56: istore 6
    //   58: iload 7
    //   60: istore 8
    //   62: aload_2
    //   63: astore_0
    //   64: iload 9
    //   66: aload_1
    //   67: arraylength
    //   68: if_icmpge +59 -> 127
    //   71: aload_2
    //   72: astore_0
    //   73: getstatic 55	aqr:c	[B
    //   76: iload 11
    //   78: iload 5
    //   80: aload_1
    //   81: iload 9
    //   83: aaload
    //   84: invokestatic 83	aqr:a	([BIILjava/lang/String;)Z
    //   87: ifeq +73 -> 160
    //   90: aload_2
    //   91: astore_0
    //   92: iload 5
    //   94: aload_1
    //   95: iload 9
    //   97: aaload
    //   98: invokevirtual 87	java/lang/String:length	()I
    //   101: iadd
    //   102: istore 6
    //   104: aload_2
    //   105: astore_0
    //   106: aload 4
    //   108: iload 9
    //   110: getstatic 55	aqr:c	[B
    //   113: iload 11
    //   115: iload 6
    //   117: invokestatic 90	aqr:a	([BII)J
    //   120: lastore
    //   121: iload 7
    //   123: iconst_1
    //   124: iadd
    //   125: istore 8
    //   127: iload 6
    //   129: iload 11
    //   131: if_icmpge +38 -> 169
    //   134: aload_2
    //   135: astore_0
    //   136: getstatic 55	aqr:c	[B
    //   139: iload 6
    //   141: baload
    //   142: istore 5
    //   144: iload 5
    //   146: bipush 10
    //   148: if_icmpeq +21 -> 169
    //   151: iload 6
    //   153: iconst_1
    //   154: iadd
    //   155: istore 6
    //   157: goto -30 -> 127
    //   160: iload 9
    //   162: iconst_1
    //   163: iadd
    //   164: istore 9
    //   166: goto -112 -> 54
    //   169: iload 6
    //   171: iconst_1
    //   172: iadd
    //   173: istore 5
    //   175: iload 8
    //   177: istore 7
    //   179: goto -144 -> 35
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokestatic 95	arf:a	(Ljava/io/Closeable;)V
    //   190: lconst_0
    //   191: lstore 12
    //   193: iload 10
    //   195: istore 5
    //   197: iload 5
    //   199: aload_1
    //   200: arraylength
    //   201: if_icmpge +60 -> 261
    //   204: lload 12
    //   206: aload 4
    //   208: iload 5
    //   210: laload
    //   211: ladd
    //   212: lstore 12
    //   214: iload 5
    //   216: iconst_1
    //   217: iadd
    //   218: istore 5
    //   220: goto -23 -> 197
    //   223: astore_3
    //   224: aconst_null
    //   225: astore_2
    //   226: aload_2
    //   227: astore_0
    //   228: ldc 97
    //   230: ldc 99
    //   232: aload_3
    //   233: invokestatic 105	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   236: pop
    //   237: aload_2
    //   238: ifnull -48 -> 190
    //   241: aload_2
    //   242: invokestatic 95	arf:a	(Ljava/io/Closeable;)V
    //   245: goto -55 -> 190
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_0
    //   251: aload_0
    //   252: ifnull +7 -> 259
    //   255: aload_0
    //   256: invokestatic 95	arf:a	(Ljava/io/Closeable;)V
    //   259: aload_1
    //   260: athrow
    //   261: lload 12
    //   263: lreturn
    //   264: astore_1
    //   265: goto -14 -> 251
    //   268: astore_3
    //   269: goto -43 -> 226
    //
    // Exception table:
    //   from	to	target	type
    //   9	18	223	java/lang/Exception
    //   9	18	248	finally
    //   20	29	264	finally
    //   44	51	264	finally
    //   64	71	264	finally
    //   73	90	264	finally
    //   92	104	264	finally
    //   106	121	264	finally
    //   136	144	264	finally
    //   228	237	264	finally
    //   20	29	268	java/lang/Exception
    //   44	51	268	java/lang/Exception
    //   64	71	268	java/lang/Exception
    //   73	90	268	java/lang/Exception
    //   92	104	268	java/lang/Exception
    //   106	121	268	java/lang/Exception
    //   136	144	268	java/lang/Exception
  }

  private static long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt2 < paramInt1) && (paramArrayOfByte[paramInt2] != 10))
    {
      if ((paramArrayOfByte[paramInt2] >= 48) && (paramArrayOfByte[paramInt2] <= 57))
      {
        int i = paramInt2 + 1;
        while ((i < paramInt1) && (paramArrayOfByte[i] >= 48) && (paramArrayOfByte[i] <= 57))
          i += 1;
        return Long.parseLong(new String(paramArrayOfByte, 0, paramInt2, i - paramInt2)) * 1024L;
      }
      paramInt2 += 1;
    }
    return 0L;
  }

  public static String a(Context paramContext)
  {
    try
    {
      paramContext = Build.MODEL;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("Swipe.DeviceInfoUtils", "Failed to get the hw info.", paramContext);
    }
    return "";
  }

  private static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    int i = paramString.length();
    if (paramInt2 + i >= paramInt1)
      return false;
    paramInt1 = 0;
    while (true)
    {
      if (paramInt1 >= i)
        break label44;
      if (paramArrayOfByte[(paramInt2 + paramInt1)] != paramString.charAt(paramInt1))
        break;
      paramInt1 += 1;
    }
    label44: return true;
  }

  public static float b()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    float f = (float)a();
    f = 1.0F - (float)c(localSwipeApplication) / f;
    if (f < 0.0F)
      return 0.0F;
    if (f > 1.0F)
      return 1.0F;
    return f;
  }

  public static String b(Context paramContext)
  {
    try
    {
      paramContext = Build.MANUFACTURER;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("Swipe.DeviceInfoUtils", "Failed to get the hw info.", paramContext);
    }
    return "";
  }

  public static int c()
  {
    try
    {
      int i = VERSION.SDK_INT;
      return i;
    }
    catch (Exception localException)
    {
    }
    return -1;
  }

  public static long c(Context paramContext)
  {
    return a("/proc/meminfo", new String[] { "MemFree", "Cached", "Buffers" });
  }

  public static String d(Context paramContext)
  {
    try
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getMetrics(localDisplayMetrics);
      paramContext = Integer.toString(localDisplayMetrics.densityDpi);
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return "";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqr
 * JD-Core Version:    0.6.2
 */