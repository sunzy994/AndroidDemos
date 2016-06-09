package cmcm.com.myapplication;

import android.os.AsyncTask;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public final class kx
{
  private static String a = kn.c + "/locker_test/Log1";
  private static Vector<String> b = new Vector();
  private static final Date c = new Date();
  private static final DateFormat d = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
  private static String e;
  private static int f = -1;
  private static long g;

  public static void a()
  {
    if (b.size() <= 0)
      return;
    Vector localVector = (Vector)b.clone();
    b.clear();
    AsyncTask.execute(new Runnable()
    {
      public void run()
      {
        kx.a(kx.this);
      }
    });
  }

  private static void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, null);
  }

  private static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (((e != null) && (!e.equals(paramString1))) || ((-1 != f) && (f != paramInt)))
      return;
    c.setTime(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder(d.format(c));
    localStringBuilder.append(' ');
    label108: int i;
    switch (paramInt)
    {
    default:
      localStringBuilder.append('O');
      localStringBuilder.append('/').append(paramString1).append('(').append(Process.myPid()).append("): ");
      if (!TextUtils.isEmpty(paramString2))
        localStringBuilder.append(paramString2);
      if (paramThrowable != null)
        localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      localStringBuilder.append("\r\n");
      b.add(localStringBuilder.toString());
      i = b.size();
      if (!kn.a)
        break;
    case 2:
    case 5:
    case 6:
    case 3:
    case 4:
    }
    for (paramInt = 150; i >= paramInt; paramInt = 50)
    {
      a();
      return;
      localStringBuilder.append('V');
      break label108;
      localStringBuilder.append('W');
      break label108;
      localStringBuilder.append('E');
      break label108;
      localStringBuilder.append('D');
      break label108;
      localStringBuilder.append('I');
      break label108;
    }
  }

  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.v(paramString1, paramString2, paramThrowable);
    a(2, paramString1, paramString2, paramThrowable);
  }

  // ERROR //
  static void a(Vector<String> paramVector)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_2
    //   6: astore_1
    //   7: new 161	java/io/File
    //   10: dup
    //   11: getstatic 43	kx:a	Ljava/lang/String;
    //   14: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: invokevirtual 166	java/io/File:exists	()Z
    //   24: ifeq +232 -> 256
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: invokevirtual 169	java/io/File:isDirectory	()Z
    //   33: ifne +17 -> 50
    //   36: aload_2
    //   37: astore_1
    //   38: aload_3
    //   39: invokevirtual 172	java/io/File:delete	()Z
    //   42: pop
    //   43: aload_2
    //   44: astore_1
    //   45: aload_3
    //   46: invokevirtual 175	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload_2
    //   51: astore_1
    //   52: getstatic 177	kx:g	J
    //   55: lconst_1
    //   56: ladd
    //   57: lstore 5
    //   59: aload_2
    //   60: astore_1
    //   61: lload 5
    //   63: putstatic 177	kx:g	J
    //   66: lload 5
    //   68: ldc2_w 178
    //   71: lcmp
    //   72: iflt +9 -> 81
    //   75: aload_2
    //   76: astore_1
    //   77: lconst_1
    //   78: putstatic 177	kx:g	J
    //   81: aload_2
    //   82: astore_1
    //   83: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   86: lstore 5
    //   88: aload_2
    //   89: astore_1
    //   90: new 161	java/io/File
    //   93: dup
    //   94: aload_3
    //   95: ldc 181
    //   97: bipush 7
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: ldc 183
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: lload 5
    //   111: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: aastore
    //   115: dup
    //   116: iconst_2
    //   117: lload 5
    //   119: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: aastore
    //   123: dup
    //   124: iconst_3
    //   125: lload 5
    //   127: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   130: aastore
    //   131: dup
    //   132: iconst_4
    //   133: lload 5
    //   135: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: aastore
    //   139: dup
    //   140: iconst_5
    //   141: lload 5
    //   143: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   146: aastore
    //   147: dup
    //   148: bipush 6
    //   150: getstatic 177	kx:g	J
    //   153: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   156: aastore
    //   157: invokestatic 192	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokespecial 195	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   163: astore_3
    //   164: aload_2
    //   165: astore_1
    //   166: aload_3
    //   167: invokevirtual 166	java/io/File:exists	()Z
    //   170: ifne +10 -> 180
    //   173: aload_2
    //   174: astore_1
    //   175: aload_3
    //   176: invokevirtual 198	java/io/File:createNewFile	()Z
    //   179: pop
    //   180: aload_2
    //   181: astore_1
    //   182: new 200	java/io/BufferedOutputStream
    //   185: dup
    //   186: new 202	java/io/FileOutputStream
    //   189: dup
    //   190: aload_3
    //   191: invokespecial 205	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   194: invokespecial 208	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   197: astore_2
    //   198: aload_0
    //   199: invokevirtual 212	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   202: astore_1
    //   203: aload_1
    //   204: invokeinterface 217 1 0
    //   209: ifeq +64 -> 273
    //   212: aload_2
    //   213: aload_1
    //   214: invokeinterface 220 1 0
    //   219: checkcast 93	java/lang/String
    //   222: invokevirtual 224	java/lang/String:getBytes	()[B
    //   225: invokevirtual 230	java/io/OutputStream:write	([B)V
    //   228: goto -25 -> 203
    //   231: astore_3
    //   232: aload_2
    //   233: astore_1
    //   234: ldc 232
    //   236: ldc 234
    //   238: aload_3
    //   239: invokestatic 237	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   242: pop
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokestatic 242	kp:a	(Ljava/io/Closeable;)V
    //   251: aload_0
    //   252: invokevirtual 76	java/util/Vector:clear	()V
    //   255: return
    //   256: aload_2
    //   257: astore_1
    //   258: aload_3
    //   259: invokevirtual 175	java/io/File:mkdirs	()Z
    //   262: pop
    //   263: goto -213 -> 50
    //   266: astore_3
    //   267: aload 4
    //   269: astore_2
    //   270: goto -38 -> 232
    //   273: aload_2
    //   274: ifnull -23 -> 251
    //   277: aload_2
    //   278: invokestatic 242	kp:a	(Ljava/io/Closeable;)V
    //   281: goto -30 -> 251
    //   284: astore_0
    //   285: aload_1
    //   286: ifnull +7 -> 293
    //   289: aload_1
    //   290: invokestatic 242	kp:a	(Ljava/io/Closeable;)V
    //   293: aload_0
    //   294: athrow
    //   295: astore_0
    //   296: aload_2
    //   297: astore_1
    //   298: goto -13 -> 285
    //
    // Exception table:
    //   from	to	target	type
    //   198	203	231	java/lang/Throwable
    //   203	228	231	java/lang/Throwable
    //   7	18	266	java/lang/Throwable
    //   20	27	266	java/lang/Throwable
    //   29	36	266	java/lang/Throwable
    //   38	43	266	java/lang/Throwable
    //   45	50	266	java/lang/Throwable
    //   52	59	266	java/lang/Throwable
    //   61	66	266	java/lang/Throwable
    //   77	81	266	java/lang/Throwable
    //   83	88	266	java/lang/Throwable
    //   90	164	266	java/lang/Throwable
    //   166	173	266	java/lang/Throwable
    //   175	180	266	java/lang/Throwable
    //   182	198	266	java/lang/Throwable
    //   258	263	266	java/lang/Throwable
    //   7	18	284	finally
    //   20	27	284	finally
    //   29	36	284	finally
    //   38	43	284	finally
    //   45	50	284	finally
    //   52	59	284	finally
    //   61	66	284	finally
    //   77	81	284	finally
    //   83	88	284	finally
    //   90	164	284	finally
    //   166	173	284	finally
    //   175	180	284	finally
    //   182	198	284	finally
    //   234	243	284	finally
    //   258	263	284	finally
    //   198	203	295	finally
    //   203	228	295	finally
  }

  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }

  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.d(paramString1, paramString2, paramThrowable);
    a(3, paramString1, paramString2, paramThrowable);
  }

  public static void c(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
    a(4, paramString1, paramString2);
  }

  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
    a(5, paramString1, paramString2, paramThrowable);
  }

  public static void d(String paramString1, String paramString2)
  {
    c(paramString1, paramString2, null);
  }

  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
    a(6, paramString1, paramString2, paramThrowable);
  }

  public static void e(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     kx
 * JD-Core Version:    0.6.2
 */