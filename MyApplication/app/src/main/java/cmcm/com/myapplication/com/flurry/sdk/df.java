package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.UUID;

public class df
{
  private static final String d = df.class.getSimpleName();
  String a = null;
  long b = -1L;
  int c = -1;
  private File e = null;

  public df()
  {
    this.a = UUID.randomUUID().toString();
    this.e = do.a().b().getFileStreamPath(".flurrydatasenderblock." + this.a);
  }

  public df(String paramString)
  {
    this.a = paramString;
    this.e = do.a().b().getFileStreamPath(".flurrydatasenderblock." + this.a);
  }

  public String a()
  {
    return this.a;
  }

  // ERROR //
  public boolean a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: invokestatic 80	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   9: invokestatic 83	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   12: if_acmpne +13 -> 25
    //   15: bipush 6
    //   17: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   20: ldc 85
    //   22: invokestatic 90	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   25: iconst_4
    //   26: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   29: new 56	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   36: ldc 92
    //   38: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   45: invokevirtual 97	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 90	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   61: invokestatic 102	com/flurry/sdk/fa:a	(Ljava/io/File;)Z
    //   64: istore 8
    //   66: iload 8
    //   68: ifne +9 -> 77
    //   71: aconst_null
    //   72: invokestatic 107	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   75: iconst_0
    //   76: ireturn
    //   77: new 109	java/io/DataOutputStream
    //   80: dup
    //   81: new 111	java/io/FileOutputStream
    //   84: dup
    //   85: aload_0
    //   86: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   89: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   92: invokespecial 117	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   95: astore_3
    //   96: aload_3
    //   97: astore_2
    //   98: iload 7
    //   100: istore 6
    //   102: aload_1
    //   103: arraylength
    //   104: istore 5
    //   106: aload_3
    //   107: astore_2
    //   108: iload 7
    //   110: istore 6
    //   112: aload_3
    //   113: iload 5
    //   115: invokevirtual 121	java/io/DataOutputStream:writeShort	(I)V
    //   118: aload_3
    //   119: astore_2
    //   120: iload 7
    //   122: istore 6
    //   124: aload_3
    //   125: aload_1
    //   126: invokevirtual 125	java/io/DataOutputStream:write	([B)V
    //   129: aload_3
    //   130: astore_2
    //   131: iload 7
    //   133: istore 6
    //   135: aload_3
    //   136: iconst_0
    //   137: invokevirtual 121	java/io/DataOutputStream:writeShort	(I)V
    //   140: iconst_1
    //   141: istore 7
    //   143: aload_3
    //   144: astore_2
    //   145: iload 7
    //   147: istore 6
    //   149: aload_0
    //   150: iload 5
    //   152: putfield 35	com/flurry/sdk/df:c	I
    //   155: aload_3
    //   156: astore_2
    //   157: iload 7
    //   159: istore 6
    //   161: aload_0
    //   162: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   165: putfield 33	com/flurry/sdk/df:b	J
    //   168: aload_3
    //   169: invokestatic 107	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   172: iconst_1
    //   173: ireturn
    //   174: astore 4
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_1
    //   179: astore_2
    //   180: bipush 6
    //   182: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   185: ldc 133
    //   187: aload 4
    //   189: invokestatic 136	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: aload_1
    //   193: invokestatic 107	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   196: iload 6
    //   198: ireturn
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_2
    //   202: aload_2
    //   203: invokestatic 107	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: goto -7 -> 202
    //   212: astore 4
    //   214: aload_3
    //   215: astore_1
    //   216: goto -38 -> 178
    //
    // Exception table:
    //   from	to	target	type
    //   57	66	174	java/lang/Throwable
    //   77	96	174	java/lang/Throwable
    //   57	66	199	finally
    //   77	96	199	finally
    //   102	106	208	finally
    //   112	118	208	finally
    //   124	129	208	finally
    //   135	140	208	finally
    //   149	155	208	finally
    //   161	168	208	finally
    //   180	192	208	finally
    //   102	106	212	java/lang/Throwable
    //   112	118	212	java/lang/Throwable
    //   124	129	212	java/lang/Throwable
    //   135	140	212	java/lang/Throwable
    //   149	155	212	java/lang/Throwable
    //   161	168	212	java/lang/Throwable
  }

  // ERROR //
  public byte[] b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: invokestatic 80	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   9: invokestatic 83	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   12: if_acmpne +13 -> 25
    //   15: bipush 6
    //   17: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   20: ldc 139
    //   22: invokestatic 90	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   29: invokevirtual 143	java/io/File:exists	()Z
    //   32: ifeq +157 -> 189
    //   35: iconst_4
    //   36: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   39: new 56	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   46: ldc 145
    //   48: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   55: invokevirtual 97	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 90	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   67: new 147	java/io/DataInputStream
    //   70: dup
    //   71: new 149	java/io/FileInputStream
    //   74: dup
    //   75: aload_0
    //   76: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   79: invokespecial 150	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: invokespecial 153	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore_3
    //   86: aload_3
    //   87: astore_1
    //   88: aload 5
    //   90: astore_2
    //   91: aload_3
    //   92: invokevirtual 157	java/io/DataInputStream:readUnsignedShort	()I
    //   95: istore 6
    //   97: iload 6
    //   99: ifne +9 -> 108
    //   102: aload_3
    //   103: invokestatic 107	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   106: aconst_null
    //   107: areturn
    //   108: aload_3
    //   109: astore_1
    //   110: aload 5
    //   112: astore_2
    //   113: iload 6
    //   115: newarray byte
    //   117: astore 4
    //   119: aload_3
    //   120: astore_1
    //   121: aload 4
    //   123: astore_2
    //   124: aload_3
    //   125: aload 4
    //   127: invokevirtual 160	java/io/DataInputStream:readFully	([B)V
    //   130: aload_3
    //   131: astore_1
    //   132: aload 4
    //   134: astore_2
    //   135: aload_3
    //   136: invokevirtual 157	java/io/DataInputStream:readUnsignedShort	()I
    //   139: istore 6
    //   141: iload 6
    //   143: ifne +3 -> 146
    //   146: aload_3
    //   147: invokestatic 107	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   150: aload 4
    //   152: areturn
    //   153: astore 5
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: astore_1
    //   159: bipush 6
    //   161: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   164: ldc 162
    //   166: aload 5
    //   168: invokestatic 136	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_2
    //   172: invokestatic 107	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   175: aload 4
    //   177: areturn
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_3
    //   181: aload_1
    //   182: astore_2
    //   183: aload_3
    //   184: invokestatic 107	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   187: aload_2
    //   188: athrow
    //   189: iconst_4
    //   190: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   193: ldc 164
    //   195: invokestatic 90	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_2
    //   201: aload_1
    //   202: astore_3
    //   203: goto -20 -> 183
    //   206: astore 5
    //   208: aload_2
    //   209: astore 4
    //   211: aload_3
    //   212: astore_2
    //   213: goto -56 -> 157
    //
    // Exception table:
    //   from	to	target	type
    //   67	86	153	java/lang/Throwable
    //   67	86	178	finally
    //   91	97	200	finally
    //   113	119	200	finally
    //   124	130	200	finally
    //   135	141	200	finally
    //   159	171	200	finally
    //   91	97	206	java/lang/Throwable
    //   113	119	206	java/lang/Throwable
    //   124	130	206	java/lang/Throwable
    //   135	141	206	java/lang/Throwable
  }

  public boolean c()
  {
    if (this.e.exists())
    {
      if (this.e.delete())
      {
        el.a(4, d, "Deleted persistence file");
        this.b = -1L;
        this.c = -1;
        return true;
      }
      el.a(6, d, "Cannot delete persistence file");
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.df
 * JD-Core Version:    0.6.2
 */