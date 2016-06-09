package cmcm.com.myapplication;

import android.os.AsyncTask;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

public final class asp
{
  public static String a;
  public static String b;
  private static final Vector<String> c = new Vector();
  private static final Date d = new Date();
  private static final DateFormat e = new SimpleDateFormat("MM-dd HH:mm:ss:SSS", Locale.US);
  private static String f;
  private static int g = -1;
  private static int h;
  private static boolean i;

  public static String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false);
  }

  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    String str = String.format("%s%tm%td_%tH%tM%tS_%03d.txt", new Object[] { paramString, Long.valueOf(l), Long.valueOf(l), Long.valueOf(l), Long.valueOf(l), Long.valueOf(l), Integer.valueOf(paramInt) });
    paramString = str;
    if (paramBoolean)
      paramString = a + "/" + str;
    return paramString;
  }

  // ERROR //
  public static void a()
  {
    // Byte code:
    //   0: getstatic 104	asp:i	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: iconst_1
    //   8: putstatic 104	asp:i	Z
    //   11: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   14: lstore_1
    //   15: ldc 106
    //   17: new 87	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   24: ldc 108
    //   26: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: getstatic 90	asp:a	Ljava/lang/String;
    //   32: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 113	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: new 115	java/io/File
    //   45: dup
    //   46: getstatic 90	asp:a	Ljava/lang/String;
    //   49: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: ldc2_w 119
    //   55: invokestatic 125	aqx:a	(Ljava/io/File;J)V
    //   58: iconst_0
    //   59: putstatic 104	asp:i	Z
    //   62: ldc 106
    //   64: new 87	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   71: ldc 127
    //   73: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   79: lload_1
    //   80: lsub
    //   81: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc 132
    //   86: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 113	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: return
    //   97: astore_0
    //   98: iconst_0
    //   99: putstatic 104	asp:i	Z
    //   102: ldc 106
    //   104: new 87	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   111: ldc 127
    //   113: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   119: lload_1
    //   120: lsub
    //   121: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   124: ldc 132
    //   126: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 113	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   135: pop
    //   136: return
    //   137: astore_0
    //   138: iconst_0
    //   139: putstatic 104	asp:i	Z
    //   142: ldc 106
    //   144: new 87	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   151: ldc 127
    //   153: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   159: lload_1
    //   160: lsub
    //   161: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: ldc 132
    //   166: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 113	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   175: pop
    //   176: aload_0
    //   177: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   42	58	97	java/lang/Throwable
    //   42	58	137	finally
  }

  private static void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, null);
  }

  private static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (((f != null) && (!f.equals(paramString1))) || ((-1 != g) && (g != paramInt)))
      return;
    d.setTime(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder(e.format(d));
    localStringBuilder.append(' ');
    switch (paramInt)
    {
    default:
      localStringBuilder.append('O');
    case 2:
    case 5:
    case 6:
    case 3:
    case 4:
    }
    while (true)
    {
      localStringBuilder.append('/').append(paramString1).append('(').append(Process.myPid()).append("): ");
      if (!TextUtils.isEmpty(paramString2))
        localStringBuilder.append(paramString2);
      if (paramThrowable != null)
        localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      localStringBuilder.append("\r\n");
      c.add(localStringBuilder.toString());
      if (c.size() < 50)
        break;
      c();
      return;
      localStringBuilder.append('V');
      continue;
      localStringBuilder.append('W');
      continue;
      localStringBuilder.append('E');
      continue;
      localStringBuilder.append('D');
      continue;
      localStringBuilder.append('I');
    }
  }

  public static void a(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
    if (a != null)
      a(4, paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
    if (a != null)
      a(5, paramString1, paramString2, paramThrowable);
  }

  public static void a(String paramString, boolean paramBoolean)
  {
    a = paramString;
    if (paramBoolean)
    {
      paramString = vg.h;
      if (paramString != null);
      for (int j = paramString.hashCode(); j > 0; j = 0)
      {
        b = String.valueOf(j) + "_";
        return;
      }
      if (j < 0)
      {
        b = String.valueOf(Math.abs(j)) + "__";
        return;
      }
      b = "";
      return;
    }
    b = "";
  }

  // ERROR //
  static void a(Vector<String> paramVector)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aload_3
    //   8: astore_1
    //   9: getstatic 90	asp:a	Ljava/lang/String;
    //   12: invokestatic 225	art:a	(Ljava/lang/String;)Z
    //   15: ifeq +11 -> 26
    //   18: aload_3
    //   19: astore_1
    //   20: invokestatic 228	art:b	()Z
    //   23: ifeq +208 -> 231
    //   26: aload_3
    //   27: astore_1
    //   28: new 115	java/io/File
    //   31: dup
    //   32: getstatic 90	asp:a	Ljava/lang/String;
    //   35: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 231	java/io/File:exists	()Z
    //   45: ifeq +169 -> 214
    //   48: aload_3
    //   49: astore_1
    //   50: aload_2
    //   51: invokevirtual 234	java/io/File:isDirectory	()Z
    //   54: ifne +17 -> 71
    //   57: aload_3
    //   58: astore_1
    //   59: aload_2
    //   60: invokevirtual 237	java/io/File:delete	()Z
    //   63: pop
    //   64: aload_3
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 240	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: aload_3
    //   72: astore_1
    //   73: getstatic 242	asp:h	I
    //   76: iconst_1
    //   77: iadd
    //   78: istore 5
    //   80: aload_3
    //   81: astore_1
    //   82: iload 5
    //   84: putstatic 242	asp:h	I
    //   87: iload 5
    //   89: sipush 1000
    //   92: if_icmplt +9 -> 101
    //   95: aload_3
    //   96: astore_1
    //   97: iconst_1
    //   98: putstatic 242	asp:h	I
    //   101: aload_3
    //   102: astore_1
    //   103: new 115	java/io/File
    //   106: dup
    //   107: aload_2
    //   108: getstatic 209	asp:b	Ljava/lang/String;
    //   111: getstatic 242	asp:h	I
    //   114: invokestatic 244	asp:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   117: invokespecial 247	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: invokevirtual 231	java/io/File:exists	()Z
    //   127: ifne +10 -> 137
    //   130: aload_3
    //   131: astore_1
    //   132: aload_2
    //   133: invokevirtual 250	java/io/File:createNewFile	()Z
    //   136: pop
    //   137: aload_3
    //   138: astore_1
    //   139: new 252	java/io/BufferedOutputStream
    //   142: dup
    //   143: new 254	java/io/FileOutputStream
    //   146: dup
    //   147: aload_2
    //   148: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   151: invokespecial 260	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   154: astore_2
    //   155: aload_0
    //   156: invokevirtual 264	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   159: astore_1
    //   160: aload_1
    //   161: invokeinterface 269 1 0
    //   166: ifeq +65 -> 231
    //   169: aload_2
    //   170: aload_1
    //   171: invokeinterface 273 1 0
    //   176: checkcast 81	java/lang/String
    //   179: invokevirtual 277	java/lang/String:getBytes	()[B
    //   182: invokevirtual 283	java/io/OutputStream:write	([B)V
    //   185: goto -25 -> 160
    //   188: astore_3
    //   189: aload_2
    //   190: astore_1
    //   191: ldc 106
    //   193: ldc_w 285
    //   196: aload_3
    //   197: invokestatic 194	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   200: pop
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokestatic 290	arf:a	(Ljava/io/Closeable;)V
    //   209: aload_0
    //   210: invokevirtual 293	java/util/Vector:clear	()V
    //   213: return
    //   214: aload_3
    //   215: astore_1
    //   216: aload_2
    //   217: invokevirtual 240	java/io/File:mkdirs	()Z
    //   220: pop
    //   221: goto -150 -> 71
    //   224: astore_3
    //   225: aload 4
    //   227: astore_2
    //   228: goto -39 -> 189
    //   231: aload_2
    //   232: ifnull -23 -> 209
    //   235: aload_2
    //   236: invokestatic 290	arf:a	(Ljava/io/Closeable;)V
    //   239: goto -30 -> 209
    //   242: astore_0
    //   243: aload_1
    //   244: ifnull +7 -> 251
    //   247: aload_1
    //   248: invokestatic 290	arf:a	(Ljava/io/Closeable;)V
    //   251: aload_0
    //   252: athrow
    //   253: astore_0
    //   254: aload_2
    //   255: astore_1
    //   256: goto -13 -> 243
    //
    // Exception table:
    //   from	to	target	type
    //   155	160	188	java/lang/Throwable
    //   160	185	188	java/lang/Throwable
    //   9	18	224	java/lang/Throwable
    //   20	26	224	java/lang/Throwable
    //   28	39	224	java/lang/Throwable
    //   41	48	224	java/lang/Throwable
    //   50	57	224	java/lang/Throwable
    //   59	64	224	java/lang/Throwable
    //   66	71	224	java/lang/Throwable
    //   73	80	224	java/lang/Throwable
    //   82	87	224	java/lang/Throwable
    //   97	101	224	java/lang/Throwable
    //   103	121	224	java/lang/Throwable
    //   123	130	224	java/lang/Throwable
    //   132	137	224	java/lang/Throwable
    //   139	155	224	java/lang/Throwable
    //   216	221	224	java/lang/Throwable
    //   9	18	242	finally
    //   20	26	242	finally
    //   28	39	242	finally
    //   41	48	242	finally
    //   50	57	242	finally
    //   59	64	242	finally
    //   66	71	242	finally
    //   73	80	242	finally
    //   82	87	242	finally
    //   97	101	242	finally
    //   103	121	242	finally
    //   123	130	242	finally
    //   132	137	242	finally
    //   139	155	242	finally
    //   191	201	242	finally
    //   216	221	242	finally
    //   155	160	253	finally
    //   160	185	253	finally
  }

  public static void b()
  {
    new AsyncTask()
    {
      public Void a(Void[] paramAnonymousArrayOfVoid)
      {
        asp.a();
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }

  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
    if (a != null)
      a(6, paramString1, paramString2, paramThrowable);
  }

  public static void c()
  {
    if (c.size() <= 0)
      return;
    Vector localVector = (Vector)c.clone();
    c.clear();
    new AsyncTask()
    {
      public Void a(Void[] paramAnonymousArrayOfVoid)
      {
        asp.a(asp.this);
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public static void c(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }

  public static void d()
  {
    a(c);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asp
 * JD-Core Version:    0.6.2
 */