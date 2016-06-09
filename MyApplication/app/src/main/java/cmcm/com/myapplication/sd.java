package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import com.hola.channel.sdk.game.graphics.ImageCache;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class sd extends se
{
  private static final String f = "GameSDK." + sd.class.getSimpleName();
  private final Object g = new Object();
  private rt h;
  private File i;
  private boolean j = true;
  private int k = 10485760;

  public sd(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3, float paramFloat)
  {
    super(paramContext, paramInt1, paramInt2);
    a(paramContext, paramString, paramInt3, paramFloat);
  }

  public sd(Context paramContext, int paramInt1, String paramString, int paramInt2, float paramFloat)
  {
    this(paramContext, paramInt1, paramInt1, paramString, paramInt2, paramFloat);
  }

  private Bitmap a(String paramString, Bundle paramBundle)
  {
    return a(paramString, paramBundle, true);
  }

  // ERROR //
  private Bitmap a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 78	com/hola/channel/sdk/game/graphics/ImageCache:c	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 50	sd:g	Ljava/lang/Object;
    //   10: astore 5
    //   12: aload 5
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 52	sd:j	Z
    //   19: istore 11
    //   21: iload 11
    //   23: ifeq +18 -> 41
    //   26: aload_0
    //   27: getfield 50	sd:g	Ljava/lang/Object;
    //   30: invokevirtual 81	java/lang/Object:wait	()V
    //   33: goto -18 -> 15
    //   36: astore 4
    //   38: goto -23 -> 15
    //   41: aload_0
    //   42: getfield 83	sd:h	Lrt;
    //   45: ifnull +270 -> 315
    //   48: aload_0
    //   49: aload 6
    //   51: invokespecial 86	sd:a	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   54: astore 4
    //   56: aload 5
    //   58: monitorexit
    //   59: aload 4
    //   61: ifnonnull +147 -> 208
    //   64: aload_0
    //   65: aload_1
    //   66: aload 6
    //   68: invokespecial 89	sd:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   71: astore 5
    //   73: iconst_0
    //   74: istore 8
    //   76: aload 5
    //   78: ifnull +235 -> 313
    //   81: aload_2
    //   82: ifnull +136 -> 218
    //   85: aload_2
    //   86: ldc 91
    //   88: aload_0
    //   89: getfield 93	sd:a	I
    //   92: invokevirtual 99	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   95: istore 9
    //   97: aload_2
    //   98: ldc 101
    //   100: aload_0
    //   101: getfield 104	sd:b	I
    //   104: invokevirtual 99	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   107: istore 10
    //   109: aload 5
    //   111: instanceof 106
    //   114: ifeq +119 -> 233
    //   117: aload 5
    //   119: checkcast 106	java/io/FileInputStream
    //   122: invokevirtual 110	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   125: iload 9
    //   127: iload 10
    //   129: aload_0
    //   130: getfield 113	sd:c	Lcom/hola/channel/sdk/game/graphics/ImageCache;
    //   133: aload_1
    //   134: invokestatic 118	sb:a	(Ljava/io/FileDescriptor;IILcom/hola/channel/sdk/game/graphics/ImageCache;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   137: astore 4
    //   139: aload 5
    //   141: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   144: iload 8
    //   146: ifeq +53 -> 199
    //   149: aload 4
    //   151: ifnonnull +48 -> 199
    //   154: iload_3
    //   155: ifeq +44 -> 199
    //   158: aload_0
    //   159: getfield 50	sd:g	Ljava/lang/Object;
    //   162: astore 5
    //   164: aload 5
    //   166: monitorenter
    //   167: aload_0
    //   168: getfield 83	sd:h	Lrt;
    //   171: astore 7
    //   173: aload 7
    //   175: ifnull +13 -> 188
    //   178: aload_0
    //   179: getfield 83	sd:h	Lrt;
    //   182: aload 6
    //   184: invokevirtual 128	rt:c	(Ljava/lang/String;)Z
    //   187: pop
    //   188: aload 5
    //   190: monitorexit
    //   191: aload_0
    //   192: aload_1
    //   193: aload_2
    //   194: iconst_0
    //   195: invokespecial 66	sd:a	(Ljava/lang/String;Landroid/os/Bundle;Z)Landroid/graphics/Bitmap;
    //   198: pop
    //   199: aload 4
    //   201: areturn
    //   202: astore_1
    //   203: aload 5
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    //   208: iconst_1
    //   209: istore 8
    //   211: aload 4
    //   213: astore 5
    //   215: goto -139 -> 76
    //   218: aload_0
    //   219: getfield 93	sd:a	I
    //   222: istore 9
    //   224: aload_0
    //   225: getfield 104	sd:b	I
    //   228: istore 10
    //   230: goto -121 -> 109
    //   233: aload 5
    //   235: iload 9
    //   237: iload 10
    //   239: aload_0
    //   240: getfield 113	sd:c	Lcom/hola/channel/sdk/game/graphics/ImageCache;
    //   243: aload_1
    //   244: invokestatic 131	sb:a	(Ljava/io/InputStream;IILcom/hola/channel/sdk/game/graphics/ImageCache;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   247: astore 4
    //   249: goto -110 -> 139
    //   252: astore 4
    //   254: getstatic 40	sd:f	Ljava/lang/String;
    //   257: new 20	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   264: ldc 133
    //   266: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 6
    //   271: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: aload 4
    //   279: invokestatic 139	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   282: pop
    //   283: aload 5
    //   285: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   288: aconst_null
    //   289: astore 4
    //   291: goto -147 -> 144
    //   294: astore_1
    //   295: aload 5
    //   297: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   300: aload_1
    //   301: athrow
    //   302: astore_1
    //   303: aload 5
    //   305: monitorexit
    //   306: aload_1
    //   307: athrow
    //   308: astore 6
    //   310: goto -122 -> 188
    //   313: aconst_null
    //   314: areturn
    //   315: aconst_null
    //   316: astore 4
    //   318: goto -262 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   26	33	36	java/lang/InterruptedException
    //   15	21	202	finally
    //   26	33	202	finally
    //   41	56	202	finally
    //   56	59	202	finally
    //   203	206	202	finally
    //   109	139	252	java/lang/Throwable
    //   233	249	252	java/lang/Throwable
    //   109	139	294	finally
    //   233	249	294	finally
    //   254	283	294	finally
    //   167	173	302	finally
    //   178	188	302	finally
    //   188	191	302	finally
    //   303	306	302	finally
    //   178	188	308	java/io/IOException
  }

  private FileInputStream a(String paramString)
  {
    try
    {
      paramString = this.h.a(paramString);
      if (paramString != null)
      {
        paramString = (FileInputStream)paramString.a(0);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      Log.w(f, "processBitmap - " + paramString);
    }
    return null;
  }

  // ERROR //
  private java.io.InputStream a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 159	sd:d	Landroid/content/Context;
    //   12: invokestatic 164	qr:c	(Landroid/content/Context;)Z
    //   15: ifne +7 -> 22
    //   18: aload_3
    //   19: astore_1
    //   20: aload_1
    //   21: areturn
    //   22: new 166	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: getfield 168	sd:i	Ljava/io/File;
    //   30: invokevirtual 172	java/io/File:getParentFile	()Ljava/io/File;
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: aload_2
    //   41: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 174
    //   46: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 177	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 7
    //   57: new 179	java/io/FileOutputStream
    //   60: dup
    //   61: aload 7
    //   63: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   66: astore_3
    //   67: aload_3
    //   68: astore 5
    //   70: aload_1
    //   71: aload_3
    //   72: invokestatic 185	sd:a	(Ljava/lang/String;Ljava/io/OutputStream;)Z
    //   75: ifeq +164 -> 239
    //   78: aload_3
    //   79: astore 5
    //   81: aload_0
    //   82: getfield 50	sd:g	Ljava/lang/Object;
    //   85: astore 8
    //   87: aload_3
    //   88: astore 5
    //   90: aload 8
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield 83	sd:h	Lrt;
    //   97: ifnull +366 -> 463
    //   100: aload_0
    //   101: getfield 83	sd:h	Lrt;
    //   104: aload_2
    //   105: invokevirtual 188	rt:b	(Ljava/lang/String;)Lru;
    //   108: astore 9
    //   110: aload 9
    //   112: ifnull +351 -> 463
    //   115: new 106	java/io/FileInputStream
    //   118: dup
    //   119: aload 7
    //   121: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   124: astore 4
    //   126: aload 9
    //   128: iconst_0
    //   129: invokevirtual 194	ru:a	(I)Ljava/io/OutputStream;
    //   132: astore_1
    //   133: aload_1
    //   134: astore 5
    //   136: aload 4
    //   138: astore 6
    //   140: aload 4
    //   142: aload_1
    //   143: invokestatic 197	qp:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   146: pop
    //   147: aload_1
    //   148: astore 5
    //   150: aload 4
    //   152: astore 6
    //   154: aload 9
    //   156: invokevirtual 199	ru:a	()V
    //   159: aload_1
    //   160: astore 5
    //   162: aload 4
    //   164: astore 6
    //   166: aload_0
    //   167: aload_2
    //   168: invokespecial 86	sd:a	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   171: astore_2
    //   172: aload 4
    //   174: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   177: aload_1
    //   178: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   181: aload_2
    //   182: astore_1
    //   183: aload_3
    //   184: astore 4
    //   186: aload_1
    //   187: astore 5
    //   189: aload 8
    //   191: monitorexit
    //   192: aload_1
    //   193: ifnonnull +264 -> 457
    //   196: aload_3
    //   197: astore 6
    //   199: aload_1
    //   200: astore 4
    //   202: aload_3
    //   203: astore 5
    //   205: aload_3
    //   206: instanceof 201
    //   209: ifeq +248 -> 457
    //   212: aload_3
    //   213: astore 6
    //   215: aload_1
    //   216: astore 4
    //   218: aload_3
    //   219: astore 5
    //   221: new 203	java/io/ByteArrayInputStream
    //   224: dup
    //   225: aload_3
    //   226: checkcast 201	java/io/ByteArrayOutputStream
    //   229: invokevirtual 207	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   232: invokespecial 210	java/io/ByteArrayInputStream:<init>	([B)V
    //   235: astore_1
    //   236: aload_1
    //   237: astore 4
    //   239: aload_3
    //   240: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   243: aload 4
    //   245: astore_2
    //   246: aload_2
    //   247: astore_1
    //   248: aload 7
    //   250: invokevirtual 214	java/io/File:exists	()Z
    //   253: ifeq -233 -> 20
    //   256: aload 7
    //   258: invokevirtual 217	java/io/File:delete	()Z
    //   261: pop
    //   262: aload_2
    //   263: areturn
    //   264: astore_3
    //   265: new 201	java/io/ByteArrayOutputStream
    //   268: dup
    //   269: invokespecial 218	java/io/ByteArrayOutputStream:<init>	()V
    //   272: astore_3
    //   273: goto -206 -> 67
    //   276: astore_3
    //   277: aconst_null
    //   278: astore_1
    //   279: aload 6
    //   281: astore_2
    //   282: getstatic 40	sd:f	Ljava/lang/String;
    //   285: ldc 220
    //   287: aload_3
    //   288: invokestatic 139	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   291: pop
    //   292: aload_1
    //   293: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   296: goto -50 -> 246
    //   299: astore_1
    //   300: aconst_null
    //   301: astore_1
    //   302: aconst_null
    //   303: astore 4
    //   305: aload_1
    //   306: astore 5
    //   308: aload 4
    //   310: astore 6
    //   312: aload 9
    //   314: invokevirtual 222	ru:b	()V
    //   317: aload 4
    //   319: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   322: aload_1
    //   323: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   326: aconst_null
    //   327: astore_1
    //   328: goto -145 -> 183
    //   331: aload 4
    //   333: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   336: aload_2
    //   337: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   340: aload_1
    //   341: athrow
    //   342: astore_2
    //   343: aconst_null
    //   344: astore_1
    //   345: aload_3
    //   346: astore 4
    //   348: aload_1
    //   349: astore 5
    //   351: aload 8
    //   353: monitorexit
    //   354: aload_3
    //   355: astore 6
    //   357: aload_1
    //   358: astore 4
    //   360: aload_3
    //   361: astore 5
    //   363: aload_2
    //   364: athrow
    //   365: astore_3
    //   366: aload 6
    //   368: astore_1
    //   369: aload 4
    //   371: astore_2
    //   372: goto -90 -> 282
    //   375: astore_1
    //   376: aconst_null
    //   377: astore 5
    //   379: aload 5
    //   381: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   384: aload_1
    //   385: athrow
    //   386: astore_1
    //   387: goto -8 -> 379
    //   390: astore_2
    //   391: aload_1
    //   392: astore 5
    //   394: aload_2
    //   395: astore_1
    //   396: goto -17 -> 379
    //   399: astore_2
    //   400: aload_3
    //   401: astore_1
    //   402: aload_2
    //   403: astore_3
    //   404: aload 6
    //   406: astore_2
    //   407: goto -125 -> 282
    //   410: astore 4
    //   412: aload_2
    //   413: astore_1
    //   414: aload 4
    //   416: astore_2
    //   417: goto -72 -> 345
    //   420: astore_2
    //   421: aload 4
    //   423: astore_3
    //   424: aload 5
    //   426: astore_1
    //   427: goto -82 -> 345
    //   430: astore_1
    //   431: aconst_null
    //   432: astore_2
    //   433: goto -102 -> 331
    //   436: astore_1
    //   437: aload 6
    //   439: astore 4
    //   441: aload 5
    //   443: astore_2
    //   444: goto -113 -> 331
    //   447: astore_1
    //   448: aconst_null
    //   449: astore_1
    //   450: goto -145 -> 305
    //   453: astore_2
    //   454: goto -149 -> 305
    //   457: aload_1
    //   458: astore 4
    //   460: goto -221 -> 239
    //   463: aconst_null
    //   464: astore_1
    //   465: goto -282 -> 183
    //   468: astore_1
    //   469: aconst_null
    //   470: astore_2
    //   471: aconst_null
    //   472: astore 4
    //   474: goto -143 -> 331
    //
    // Exception table:
    //   from	to	target	type
    //   57	67	264	java/lang/Throwable
    //   265	273	276	java/lang/Throwable
    //   115	126	299	java/lang/Throwable
    //   93	110	342	finally
    //   317	326	342	finally
    //   331	342	342	finally
    //   205	212	365	java/lang/Throwable
    //   221	236	365	java/lang/Throwable
    //   363	365	365	java/lang/Throwable
    //   57	67	375	finally
    //   265	273	375	finally
    //   70	78	386	finally
    //   81	87	386	finally
    //   90	93	386	finally
    //   205	212	386	finally
    //   221	236	386	finally
    //   363	365	386	finally
    //   282	292	390	finally
    //   70	78	399	java/lang/Throwable
    //   81	87	399	java/lang/Throwable
    //   90	93	399	java/lang/Throwable
    //   172	181	410	finally
    //   189	192	420	finally
    //   351	354	420	finally
    //   126	133	430	finally
    //   140	147	436	finally
    //   154	159	436	finally
    //   166	172	436	finally
    //   312	317	436	finally
    //   126	133	447	java/lang/Throwable
    //   140	147	453	java/lang/Throwable
    //   154	159	453	java/lang/Throwable
    //   166	172	453	java/lang/Throwable
    //   115	126	468	finally
  }

  private void a(Context paramContext, String paramString, int paramInt, float paramFloat)
  {
    i();
    this.k = paramInt;
    this.i = ImageCache.a(this.d, paramString);
    paramString = new sc(paramContext);
    if (paramFloat > 0.0F)
    {
      paramString.a(paramFloat);
      if (!(paramContext instanceof Activity))
        break label73;
    }
    label73: for (paramContext = ((Activity)paramContext).getFragmentManager(); ; paramContext = null)
    {
      a(paramContext, paramString);
      return;
      paramString.f = false;
      break;
    }
  }

  // ERROR //
  public static boolean a(String paramString, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 248	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 251	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 255	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 257	java/net/HttpURLConnection
    //   20: astore_0
    //   21: new 259	java/io/BufferedInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokevirtual 263	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   29: sipush 8192
    //   32: invokespecial 266	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   35: astore_2
    //   36: new 268	java/io/BufferedOutputStream
    //   39: dup
    //   40: aload_1
    //   41: sipush 8192
    //   44: invokespecial 271	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   47: astore_3
    //   48: aload_2
    //   49: invokevirtual 275	java/io/BufferedInputStream:read	()I
    //   52: istore 6
    //   54: iload 6
    //   56: iconst_m1
    //   57: if_icmpeq +72 -> 129
    //   60: aload_3
    //   61: iload 6
    //   63: invokevirtual 279	java/io/BufferedOutputStream:write	(I)V
    //   66: goto -18 -> 48
    //   69: astore 4
    //   71: aload_0
    //   72: astore_1
    //   73: aload 4
    //   75: astore_0
    //   76: aload_2
    //   77: astore 4
    //   79: aload_1
    //   80: astore_2
    //   81: aload 4
    //   83: astore_1
    //   84: getstatic 40	sd:f	Ljava/lang/String;
    //   87: new 20	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 281
    //   97: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_0
    //   101: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 155	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   110: pop
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 284	java/net/HttpURLConnection:disconnect	()V
    //   119: aload_1
    //   120: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   123: aload_3
    //   124: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   127: iconst_0
    //   128: ireturn
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 284	java/net/HttpURLConnection:disconnect	()V
    //   137: aload_2
    //   138: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   141: aload_3
    //   142: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   145: iconst_1
    //   146: ireturn
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_2
    //   152: aload 5
    //   154: astore_3
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 284	java/net/HttpURLConnection:disconnect	()V
    //   163: aload_1
    //   164: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   167: aload_3
    //   168: invokestatic 123	qp:a	(Ljava/io/Closeable;)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_1
    //   174: aload_0
    //   175: astore_2
    //   176: aload_1
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_1
    //   180: aload 5
    //   182: astore_3
    //   183: goto -28 -> 155
    //   186: astore_3
    //   187: aload_2
    //   188: astore_1
    //   189: aload_0
    //   190: astore_2
    //   191: aload_3
    //   192: astore_0
    //   193: aload 5
    //   195: astore_3
    //   196: goto -41 -> 155
    //   199: astore_1
    //   200: aload_0
    //   201: astore 4
    //   203: aload_1
    //   204: astore_0
    //   205: aload_2
    //   206: astore_1
    //   207: aload 4
    //   209: astore_2
    //   210: goto -55 -> 155
    //   213: astore_0
    //   214: goto -59 -> 155
    //   217: astore_0
    //   218: aconst_null
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_2
    //   222: aload 4
    //   224: astore_3
    //   225: goto -141 -> 84
    //   228: astore_1
    //   229: aload_0
    //   230: astore_2
    //   231: aload_1
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_1
    //   235: aload 4
    //   237: astore_3
    //   238: goto -154 -> 84
    //   241: astore_3
    //   242: aload_2
    //   243: astore_1
    //   244: aload_0
    //   245: astore_2
    //   246: aload_3
    //   247: astore_0
    //   248: aload 4
    //   250: astore_3
    //   251: goto -167 -> 84
    //
    // Exception table:
    //   from	to	target	type
    //   48	54	69	java/io/IOException
    //   60	66	69	java/io/IOException
    //   6	21	147	finally
    //   21	36	173	finally
    //   36	48	186	finally
    //   48	54	199	finally
    //   60	66	199	finally
    //   84	111	213	finally
    //   6	21	217	java/io/IOException
    //   21	36	228	java/io/IOException
    //   36	48	241	java/io/IOException
  }

  private void h()
  {
    if (!this.i.exists())
      this.i.mkdirs();
    synchronized (this.g)
    {
      long l = ImageCache.a(this.i);
      int m = this.k;
      if (l > m);
      try
      {
        this.h = rt.a(this.i, 1, 1, this.k);
        this.j = false;
        this.g.notifyAll();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          this.h = null;
      }
    }
  }

  private void i()
  {
    if (!qr.d(this.d))
      Log.w(f, "checkConnection - no connection found");
  }

  protected Bitmap a(Object paramObject, Bundle paramBundle)
  {
    return a(String.valueOf(paramObject), paramBundle);
  }

  void a()
  {
    super.a();
    synchronized (this.g)
    {
      if (this.h != null)
      {
        boolean bool = this.h.a();
        if (bool);
      }
      try
      {
        this.h.c();
        this.h = null;
        this.j = true;
        h();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.w(f, "clearCacheInternal - " + localIOException);
      }
    }
  }

  void b()
  {
    super.b();
    synchronized (this.g)
    {
      rt localrt = this.h;
      if (localrt != null);
      try
      {
        this.h.b();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.w(f, "flush - " + localIOException);
      }
    }
  }

  void c()
  {
    super.c();
    synchronized (this.g)
    {
      rt localrt = this.h;
      if (localrt != null);
      try
      {
        if (!this.h.a())
        {
          this.h.close();
          this.h = null;
        }
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.w(f, "closeCacheInternal - " + localIOException);
      }
    }
  }

  void d()
  {
    super.d();
    h();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sd
 * JD-Core Version:    0.6.2
 */