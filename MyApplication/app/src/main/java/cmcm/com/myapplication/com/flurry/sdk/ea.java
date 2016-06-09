package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class ea
{
  private static final String a = ea.class.getSimpleName();
  private static final Set<String> b = i();
  private static String c;

  public static String a()
  {
    try
    {
      if (Looper.getMainLooper().getThread() == Thread.currentThread())
        throw new IllegalStateException("Must be called from a background thread!");
    }
    finally
    {
    }
    if (TextUtils.isEmpty(c))
      c = g();
    String str = c;
    return str;
  }

  private static String a(DataInput paramDataInput)
  {
    if (1 != paramDataInput.readInt())
      return null;
    return paramDataInput.readUTF();
  }

  private static void a(String paramString, DataOutput paramDataOutput)
  {
    paramDataOutput.writeInt(1);
    paramDataOutput.writeUTF(paramString);
  }

  // ERROR //
  static void a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: new 90	java/io/DataOutputStream
    //   3: dup
    //   4: new 92	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 98	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: aload_2
    //   20: invokestatic 100	com/flurry/sdk/ea:a	(Ljava/lang/String;Ljava/io/DataOutput;)V
    //   23: aload_2
    //   24: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   27: return
    //   28: astore_3
    //   29: aconst_null
    //   30: astore_0
    //   31: aload_0
    //   32: astore_1
    //   33: bipush 6
    //   35: getstatic 22	com/flurry/sdk/ea:a	Ljava/lang/String;
    //   38: ldc 107
    //   40: aload_3
    //   41: invokestatic 112	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: aload_0
    //   45: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   48: return
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: goto -7 -> 52
    //   62: astore_3
    //   63: aload_2
    //   64: astore_0
    //   65: goto -34 -> 31
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	28	java/lang/Throwable
    //   0	16	49	finally
    //   18	23	58	finally
    //   33	44	58	finally
    //   18	23	62	java/lang/Throwable
  }

  static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (c(paramString.toLowerCase(Locale.US)))
      return false;
    return true;
  }

  static String b()
  {
    String str = Settings.Secure.getString(do.a().b().getContentResolver(), "android_id");
    if (!a(str))
      return null;
    return "AND" + str;
  }

  private static String b(DataInput paramDataInput)
  {
    if (46586 != paramDataInput.readUnsignedShort());
    while (2 != paramDataInput.readUnsignedShort())
      return null;
    paramDataInput.readUTF();
    return paramDataInput.readUTF();
  }

  static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    File localFile;
    do
    {
      return;
      localFile = do.a().b().getFileStreamPath(h());
    }
    while (!fa.a(localFile));
    a(paramString, localFile);
  }

  static String c()
  {
    String str2 = e();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = f();
      str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = d();
      b(str1);
    }
    return str1;
  }

  private static boolean c(String paramString)
  {
    return b.contains(paramString);
  }

  static String d()
  {
    long l1 = Double.doubleToLongBits(Math.random());
    long l2 = System.nanoTime();
    long l3 = dx.c(do.a().b()).hashCode() * 37;
    return "ID" + Long.toString(l1 + 37L * (l2 + l3), 16);
  }

  // ERROR //
  static String e()
  {
    // Byte code:
    //   0: invokestatic 132	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
    //   3: invokevirtual 135	com/flurry/sdk/do:b	()Landroid/content/Context;
    //   6: invokestatic 170	com/flurry/sdk/ea:h	()Ljava/lang/String;
    //   9: invokevirtual 174	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnull +10 -> 24
    //   17: aload_0
    //   18: invokevirtual 239	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 241	java/io/DataInputStream
    //   29: dup
    //   30: new 243	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 247	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore_1
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 249	com/flurry/sdk/ea:a	(Ljava/io/DataInput;)Ljava/lang/String;
    //   48: astore_2
    //   49: aload_1
    //   50: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   53: aload_2
    //   54: areturn
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: bipush 6
    //   62: getstatic 22	com/flurry/sdk/ea:a	Ljava/lang/String;
    //   65: ldc 251
    //   67: aload_2
    //   68: invokestatic 112	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_1
    //   72: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_0
    //   81: astore_1
    //   82: aload_2
    //   83: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: aload_0
    //   90: astore_2
    //   91: goto -9 -> 82
    //   94: astore_2
    //   95: goto -37 -> 58
    //
    // Exception table:
    //   from	to	target	type
    //   26	42	55	java/lang/Throwable
    //   26	42	77	finally
    //   44	49	88	finally
    //   60	71	88	finally
    //   44	49	94	java/lang/Throwable
  }

  // ERROR //
  static String f()
  {
    // Byte code:
    //   0: invokestatic 132	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
    //   3: invokevirtual 135	com/flurry/sdk/do:b	()Landroid/content/Context;
    //   6: invokevirtual 255	android/content/Context:getFilesDir	()Ljava/io/File;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: new 6	com/flurry/sdk/ea$1
    //   20: dup
    //   21: invokespecial 256	com/flurry/sdk/ea$1:<init>	()V
    //   24: invokevirtual 260	java/io/File:list	(Ljava/io/FilenameFilter;)[Ljava/lang/String;
    //   27: astore_0
    //   28: aload_0
    //   29: ifnull -15 -> 14
    //   32: aload_0
    //   33: arraylength
    //   34: ifeq -20 -> 14
    //   37: aload_0
    //   38: iconst_0
    //   39: aaload
    //   40: astore_0
    //   41: invokestatic 132	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
    //   44: invokevirtual 135	com/flurry/sdk/do:b	()Landroid/content/Context;
    //   47: aload_0
    //   48: invokevirtual 174	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   51: astore_0
    //   52: aload_0
    //   53: ifnull -39 -> 14
    //   56: aload_0
    //   57: invokevirtual 239	java/io/File:exists	()Z
    //   60: ifeq -46 -> 14
    //   63: new 241	java/io/DataInputStream
    //   66: dup
    //   67: new 243	java/io/FileInputStream
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: invokespecial 247	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: invokestatic 262	com/flurry/sdk/ea:b	(Ljava/io/DataInput;)Ljava/lang/String;
    //   85: astore_2
    //   86: aload_1
    //   87: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   90: aload_2
    //   91: areturn
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: astore_0
    //   97: bipush 6
    //   99: getstatic 22	com/flurry/sdk/ea:a	Ljava/lang/String;
    //   102: ldc 251
    //   104: aload_2
    //   105: invokestatic 112	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_1
    //   109: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_0
    //   118: astore_1
    //   119: aload_2
    //   120: invokestatic 105	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: astore_2
    //   128: goto -9 -> 119
    //   131: astore_2
    //   132: goto -37 -> 95
    //
    // Exception table:
    //   from	to	target	type
    //   63	79	92	java/lang/Throwable
    //   63	79	114	finally
    //   81	86	125	finally
    //   97	108	125	finally
    //   81	86	131	java/lang/Throwable
  }

  private static String g()
  {
    String str = b();
    if (!TextUtils.isEmpty(str))
      return str;
    return c();
  }

  private static String h()
  {
    return ".flurryb.";
  }

  private static Set<String> i()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("null");
    localHashSet.add("9774d56d682e549c");
    localHashSet.add("dead00beef");
    return Collections.unmodifiableSet(localHashSet);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ea
 * JD-Core Version:    0.6.2
 */