package cmcm.com.myapplication.com.flurry.sdk;

import android.os.Build.VERSION;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.AbstractHttpEntity;

public class ek extends fd
{
  private static final String a = ek.class.getSimpleName();
  private String b;
  private ek.a c;
  private int d = 10000;
  private int e = 15000;
  private boolean f = true;
  private final ds<String, String> i = new ds();
  private ek.c j;
  private HttpURLConnection k;
  private HttpClient l;
  private boolean m;
  private boolean n;
  private Exception o;
  private int p = -1;
  private final ds<String, String> q = new ds();
  private final Object r = new Object();

  private void a(InputStream paramInputStream)
  {
    if (this.j == null);
    while ((b()) || (paramInputStream == null))
      return;
    this.j.a(this, paramInputStream);
  }

  private void a(OutputStream paramOutputStream)
  {
    if (this.j == null);
    while ((b()) || (paramOutputStream == null))
      return;
    this.j.a(this, paramOutputStream);
  }

  // ERROR //
  private void m()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 96	com/flurry/sdk/ek:n	Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: new 98	java/net/URL
    //   16: dup
    //   17: aload_0
    //   18: getfield 100	com/flurry/sdk/ek:b	Ljava/lang/String;
    //   21: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 107	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   30: checkcast 109	java/net/HttpURLConnection
    //   33: putfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   36: aload_0
    //   37: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   40: aload_0
    //   41: getfield 53	com/flurry/sdk/ek:d	I
    //   44: invokevirtual 113	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   47: aload_0
    //   48: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   51: aload_0
    //   52: getfield 55	com/flurry/sdk/ek:e	I
    //   55: invokevirtual 116	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   58: aload_0
    //   59: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   62: aload_0
    //   63: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   66: invokevirtual 123	com/flurry/sdk/ek$a:toString	()Ljava/lang/String;
    //   69: invokevirtual 126	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   76: aload_0
    //   77: getfield 57	com/flurry/sdk/ek:f	Z
    //   80: invokevirtual 130	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   83: aload_0
    //   84: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   87: getstatic 131	com/flurry/sdk/ek$a:c	Lcom/flurry/sdk/ek$a;
    //   90: aload_0
    //   91: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   94: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   97: invokevirtual 138	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   100: aload_0
    //   101: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   104: iconst_1
    //   105: invokevirtual 141	java/net/HttpURLConnection:setDoInput	(Z)V
    //   108: aload_0
    //   109: getfield 62	com/flurry/sdk/ek:i	Lcom/flurry/sdk/ds;
    //   112: invokevirtual 144	com/flurry/sdk/ds:b	()Ljava/util/Collection;
    //   115: invokeinterface 150 1 0
    //   120: astore_1
    //   121: aload_1
    //   122: invokeinterface 155 1 0
    //   127: ifeq +48 -> 175
    //   130: aload_1
    //   131: invokeinterface 159 1 0
    //   136: checkcast 161	java/util/Map$Entry
    //   139: astore_2
    //   140: aload_0
    //   141: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   144: aload_2
    //   145: invokeinterface 164 1 0
    //   150: checkcast 166	java/lang/String
    //   153: aload_2
    //   154: invokeinterface 169 1 0
    //   159: checkcast 166	java/lang/String
    //   162: invokevirtual 173	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: goto -44 -> 121
    //   168: astore_1
    //   169: aload_0
    //   170: invokespecial 175	com/flurry/sdk/ek:p	()V
    //   173: aload_1
    //   174: athrow
    //   175: getstatic 177	com/flurry/sdk/ek$a:b	Lcom/flurry/sdk/ek$a;
    //   178: aload_0
    //   179: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   182: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   185: ifne +27 -> 212
    //   188: getstatic 131	com/flurry/sdk/ek$a:c	Lcom/flurry/sdk/ek$a;
    //   191: aload_0
    //   192: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   195: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   198: ifne +14 -> 212
    //   201: aload_0
    //   202: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   205: ldc 179
    //   207: ldc 181
    //   209: invokevirtual 184	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload_0
    //   213: getfield 96	com/flurry/sdk/ek:n	Z
    //   216: istore 6
    //   218: iload 6
    //   220: ifeq +8 -> 228
    //   223: aload_0
    //   224: invokespecial 175	com/flurry/sdk/ek:p	()V
    //   227: return
    //   228: getstatic 131	com/flurry/sdk/ek$a:c	Lcom/flurry/sdk/ek$a;
    //   231: aload_0
    //   232: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   235: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   238: istore 6
    //   240: iload 6
    //   242: ifeq +33 -> 275
    //   245: aload_0
    //   246: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   249: invokevirtual 188	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   252: astore_1
    //   253: new 190	java/io/BufferedOutputStream
    //   256: dup
    //   257: aload_1
    //   258: invokespecial 192	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   261: astore_2
    //   262: aload_0
    //   263: aload_2
    //   264: invokespecial 78	com/flurry/sdk/ek:a	(Ljava/io/OutputStream;)V
    //   267: aload_2
    //   268: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   271: aload_1
    //   272: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   275: aload_0
    //   276: aload_0
    //   277: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   280: invokevirtual 201	java/net/HttpURLConnection:getResponseCode	()I
    //   283: putfield 64	com/flurry/sdk/ek:p	I
    //   286: aload_0
    //   287: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   290: invokevirtual 205	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   293: invokeinterface 211 1 0
    //   298: invokeinterface 150 1 0
    //   303: astore_1
    //   304: aload_1
    //   305: invokeinterface 155 1 0
    //   310: ifeq +79 -> 389
    //   313: aload_1
    //   314: invokeinterface 159 1 0
    //   319: checkcast 161	java/util/Map$Entry
    //   322: astore_2
    //   323: aload_2
    //   324: invokeinterface 169 1 0
    //   329: checkcast 213	java/util/List
    //   332: invokeinterface 214 1 0
    //   337: astore 4
    //   339: aload 4
    //   341: invokeinterface 155 1 0
    //   346: ifeq -42 -> 304
    //   349: aload 4
    //   351: invokeinterface 159 1 0
    //   356: checkcast 166	java/lang/String
    //   359: astore 5
    //   361: aload_0
    //   362: getfield 66	com/flurry/sdk/ek:q	Lcom/flurry/sdk/ds;
    //   365: aload_2
    //   366: invokeinterface 164 1 0
    //   371: aload 5
    //   373: invokevirtual 217	com/flurry/sdk/ds:a	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   376: goto -37 -> 339
    //   379: aload_2
    //   380: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   383: aload_3
    //   384: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   387: aload_1
    //   388: athrow
    //   389: getstatic 177	com/flurry/sdk/ek$a:b	Lcom/flurry/sdk/ek$a;
    //   392: aload_0
    //   393: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   396: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   399: ifne +25 -> 424
    //   402: getstatic 131	com/flurry/sdk/ek$a:c	Lcom/flurry/sdk/ek$a;
    //   405: aload_0
    //   406: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   409: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   412: istore 6
    //   414: iload 6
    //   416: ifne +8 -> 424
    //   419: aload_0
    //   420: invokespecial 175	com/flurry/sdk/ek:p	()V
    //   423: return
    //   424: aload_0
    //   425: getfield 96	com/flurry/sdk/ek:n	Z
    //   428: istore 6
    //   430: iload 6
    //   432: ifeq +8 -> 440
    //   435: aload_0
    //   436: invokespecial 175	com/flurry/sdk/ek:p	()V
    //   439: return
    //   440: aload_0
    //   441: getfield 74	com/flurry/sdk/ek:k	Ljava/net/HttpURLConnection;
    //   444: invokevirtual 221	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   447: astore_1
    //   448: new 223	java/io/BufferedInputStream
    //   451: dup
    //   452: aload_1
    //   453: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   456: astore_2
    //   457: aload_0
    //   458: aload_2
    //   459: invokespecial 227	com/flurry/sdk/ek:a	(Ljava/io/InputStream;)V
    //   462: aload_2
    //   463: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   466: aload_1
    //   467: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   470: aload_0
    //   471: invokespecial 175	com/flurry/sdk/ek:p	()V
    //   474: return
    //   475: astore_1
    //   476: aconst_null
    //   477: astore_2
    //   478: aload_3
    //   479: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   482: aload_2
    //   483: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   486: aload_1
    //   487: athrow
    //   488: astore 4
    //   490: aload_1
    //   491: astore_2
    //   492: aload 4
    //   494: astore_1
    //   495: goto -17 -> 478
    //   498: astore 4
    //   500: aload_2
    //   501: astore_3
    //   502: aload_1
    //   503: astore_2
    //   504: aload 4
    //   506: astore_1
    //   507: goto -29 -> 478
    //   510: astore 4
    //   512: aconst_null
    //   513: astore_2
    //   514: aload_1
    //   515: astore_3
    //   516: aload 4
    //   518: astore_1
    //   519: goto -140 -> 379
    //   522: astore 4
    //   524: aload_1
    //   525: astore_3
    //   526: aload 4
    //   528: astore_1
    //   529: goto -150 -> 379
    //   532: astore_1
    //   533: aconst_null
    //   534: astore_2
    //   535: aload 4
    //   537: astore_3
    //   538: goto -159 -> 379
    //
    // Exception table:
    //   from	to	target	type
    //   25	121	168	finally
    //   121	165	168	finally
    //   175	212	168	finally
    //   212	218	168	finally
    //   228	240	168	finally
    //   267	275	168	finally
    //   275	304	168	finally
    //   304	339	168	finally
    //   339	376	168	finally
    //   379	389	168	finally
    //   389	414	168	finally
    //   424	430	168	finally
    //   462	470	168	finally
    //   478	488	168	finally
    //   440	448	475	finally
    //   448	457	488	finally
    //   457	462	498	finally
    //   253	262	510	finally
    //   262	267	522	finally
    //   245	253	532	finally
  }

  // ERROR //
  private void n()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 96	com/flurry/sdk/ek:n	Z
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   14: aload_0
    //   15: getfield 100	com/flurry/sdk/ek:b	Ljava/lang/String;
    //   18: invokevirtual 230	com/flurry/sdk/ek$a:a	(Ljava/lang/String;)Lorg/apache/http/client/methods/HttpRequestBase;
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 62	com/flurry/sdk/ek:i	Lcom/flurry/sdk/ds;
    //   26: invokevirtual 144	com/flurry/sdk/ds:b	()Ljava/util/Collection;
    //   29: invokeinterface 150 1 0
    //   34: astore_2
    //   35: aload_2
    //   36: invokeinterface 155 1 0
    //   41: ifeq +41 -> 82
    //   44: aload_2
    //   45: invokeinterface 159 1 0
    //   50: checkcast 161	java/util/Map$Entry
    //   53: astore 4
    //   55: aload_1
    //   56: aload 4
    //   58: invokeinterface 164 1 0
    //   63: checkcast 166	java/lang/String
    //   66: aload 4
    //   68: invokeinterface 169 1 0
    //   73: checkcast 166	java/lang/String
    //   76: invokevirtual 235	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -44 -> 35
    //   82: getstatic 177	com/flurry/sdk/ek$a:b	Lcom/flurry/sdk/ek$a;
    //   85: aload_0
    //   86: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   89: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   92: ifne +22 -> 114
    //   95: getstatic 131	com/flurry/sdk/ek$a:c	Lcom/flurry/sdk/ek$a;
    //   98: aload_0
    //   99: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   102: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   105: ifne +9 -> 114
    //   108: aload_1
    //   109: ldc 179
    //   111: invokevirtual 238	org/apache/http/client/methods/HttpRequestBase:removeHeaders	(Ljava/lang/String;)V
    //   114: getstatic 131	com/flurry/sdk/ek$a:c	Lcom/flurry/sdk/ek$a;
    //   117: aload_0
    //   118: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   121: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   124: ifeq +18 -> 142
    //   127: aload_1
    //   128: checkcast 240	org/apache/http/client/methods/HttpPost
    //   131: new 6	com/flurry/sdk/ek$1
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 243	com/flurry/sdk/ek$1:<init>	(Lcom/flurry/sdk/ek;)V
    //   139: invokevirtual 247	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   142: new 249	org/apache/http/params/BasicHttpParams
    //   145: dup
    //   146: invokespecial 250	org/apache/http/params/BasicHttpParams:<init>	()V
    //   149: astore_2
    //   150: aload_2
    //   151: aload_0
    //   152: getfield 53	com/flurry/sdk/ek:d	I
    //   155: invokestatic 256	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   158: aload_2
    //   159: aload_0
    //   160: getfield 55	com/flurry/sdk/ek:e	I
    //   163: invokestatic 259	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   166: aload_2
    //   167: ldc_w 261
    //   170: aload_0
    //   171: getfield 57	com/flurry/sdk/ek:f	Z
    //   174: invokestatic 267	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   177: invokeinterface 273 3 0
    //   182: pop
    //   183: aload_0
    //   184: aload_2
    //   185: invokestatic 278	com/flurry/sdk/eh:a	(Lorg/apache/http/params/HttpParams;)Lorg/apache/http/client/HttpClient;
    //   188: putfield 94	com/flurry/sdk/ek:l	Lorg/apache/http/client/HttpClient;
    //   191: aload_0
    //   192: getfield 94	com/flurry/sdk/ek:l	Lorg/apache/http/client/HttpClient;
    //   195: aload_1
    //   196: invokeinterface 284 2 0
    //   201: astore_1
    //   202: aload_0
    //   203: getfield 96	com/flurry/sdk/ek:n	Z
    //   206: ifeq +21 -> 227
    //   209: new 286	java/lang/Exception
    //   212: dup
    //   213: ldc_w 288
    //   216: invokespecial 289	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: invokespecial 175	com/flurry/sdk/ek:p	()V
    //   225: aload_1
    //   226: athrow
    //   227: aload_1
    //   228: ifnull +199 -> 427
    //   231: aload_0
    //   232: aload_1
    //   233: invokeinterface 295 1 0
    //   238: invokeinterface 300 1 0
    //   243: putfield 64	com/flurry/sdk/ek:p	I
    //   246: aload_1
    //   247: invokeinterface 304 1 0
    //   252: astore_2
    //   253: aload_2
    //   254: ifnull +80 -> 334
    //   257: aload_2
    //   258: arraylength
    //   259: istore 8
    //   261: iconst_0
    //   262: istore 6
    //   264: iload 6
    //   266: iload 8
    //   268: if_icmpge +66 -> 334
    //   271: aload_2
    //   272: iload 6
    //   274: aaload
    //   275: invokeinterface 310 1 0
    //   280: astore 4
    //   282: aload 4
    //   284: arraylength
    //   285: istore 9
    //   287: iconst_0
    //   288: istore 7
    //   290: iload 7
    //   292: iload 9
    //   294: if_icmpge +173 -> 467
    //   297: aload 4
    //   299: iload 7
    //   301: aaload
    //   302: astore 5
    //   304: aload_0
    //   305: getfield 66	com/flurry/sdk/ek:q	Lcom/flurry/sdk/ds;
    //   308: aload 5
    //   310: invokeinterface 315 1 0
    //   315: aload 5
    //   317: invokeinterface 317 1 0
    //   322: invokevirtual 217	com/flurry/sdk/ds:a	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   325: iload 7
    //   327: iconst_1
    //   328: iadd
    //   329: istore 7
    //   331: goto -41 -> 290
    //   334: getstatic 177	com/flurry/sdk/ek$a:b	Lcom/flurry/sdk/ek$a;
    //   337: aload_0
    //   338: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   341: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   344: ifne +25 -> 369
    //   347: getstatic 131	com/flurry/sdk/ek$a:c	Lcom/flurry/sdk/ek$a;
    //   350: aload_0
    //   351: getfield 118	com/flurry/sdk/ek:c	Lcom/flurry/sdk/ek$a;
    //   354: invokevirtual 135	com/flurry/sdk/ek$a:equals	(Ljava/lang/Object;)Z
    //   357: istore 10
    //   359: iload 10
    //   361: ifne +8 -> 369
    //   364: aload_0
    //   365: invokespecial 175	com/flurry/sdk/ek:p	()V
    //   368: return
    //   369: aload_0
    //   370: getfield 96	com/flurry/sdk/ek:n	Z
    //   373: ifeq +14 -> 387
    //   376: new 286	java/lang/Exception
    //   379: dup
    //   380: ldc_w 288
    //   383: invokespecial 289	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   386: athrow
    //   387: aload_1
    //   388: invokeinterface 321 1 0
    //   393: astore_1
    //   394: aload_1
    //   395: ifnull +32 -> 427
    //   398: aload_1
    //   399: invokeinterface 326 1 0
    //   404: astore_1
    //   405: new 223	java/io/BufferedInputStream
    //   408: dup
    //   409: aload_1
    //   410: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   413: astore_2
    //   414: aload_0
    //   415: aload_2
    //   416: invokespecial 227	com/flurry/sdk/ek:a	(Ljava/io/InputStream;)V
    //   419: aload_2
    //   420: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   423: aload_1
    //   424: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   427: aload_0
    //   428: invokespecial 175	com/flurry/sdk/ek:p	()V
    //   431: return
    //   432: astore_1
    //   433: aconst_null
    //   434: astore_2
    //   435: aload_2
    //   436: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   439: aload_3
    //   440: invokestatic 197	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   443: aload_1
    //   444: athrow
    //   445: astore 4
    //   447: aconst_null
    //   448: astore_2
    //   449: aload_1
    //   450: astore_3
    //   451: aload 4
    //   453: astore_1
    //   454: goto -19 -> 435
    //   457: astore 4
    //   459: aload_1
    //   460: astore_3
    //   461: aload 4
    //   463: astore_1
    //   464: goto -29 -> 435
    //   467: iload 6
    //   469: iconst_1
    //   470: iadd
    //   471: istore 6
    //   473: goto -209 -> 264
    //
    // Exception table:
    //   from	to	target	type
    //   142	220	220	finally
    //   231	253	220	finally
    //   257	261	220	finally
    //   271	287	220	finally
    //   304	325	220	finally
    //   334	359	220	finally
    //   369	387	220	finally
    //   387	394	220	finally
    //   419	427	220	finally
    //   435	445	220	finally
    //   398	405	432	finally
    //   405	414	445	finally
    //   414	419	457	finally
  }

  private void o()
  {
    if (this.j == null);
    while (b())
      return;
    this.j.a(this);
  }

  private void p()
  {
    if (this.m);
    do
    {
      return;
      this.m = true;
      if (this.k != null)
        this.k.disconnect();
    }
    while (this.l == null);
    this.l.getConnectionManager().shutdown();
  }

  private void q()
  {
    if (this.m);
    do
    {
      return;
      this.m = true;
    }
    while ((this.k == null) && (this.l == null));
    new Thread()
    {
      public void run()
      {
        if (ek.a(ek.this) != null)
          ek.a(ek.this).disconnect();
        if (ek.b(ek.this) != null)
          ek.b(ek.this).getConnectionManager().shutdown();
      }
    }
    .start();
  }

  public void a()
  {
    try
    {
      String str = this.b;
      if (str == null)
        return;
      if (!es.a().c())
      {
        el.a(3, a, "Network not available, aborting http request: " + this.b);
        return;
      }
      if ((this.c == null) || (ek.a.a.equals(this.c)))
        this.c = ek.a.b;
      if (Build.VERSION.SDK_INT >= 9)
        m();
      while (true)
      {
        el.a(4, a, "HTTP status: " + this.p + " for url: " + this.b);
        return;
        n();
      }
    }
    catch (Exception localException)
    {
      el.a(4, a, "HTTP status: " + this.p + " for url: " + this.b);
      el.a(3, a, "Exception during http request: " + this.b, localException);
      this.o = localException;
      return;
    }
    finally
    {
      o();
    }
  }

  public void a(ek.a parama)
  {
    this.c = parama;
  }

  public void a(ek.c paramc)
  {
    this.j = paramc;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(String paramString1, String paramString2)
  {
    this.i.a(paramString1, paramString2);
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public List<String> b(String paramString)
  {
    if (paramString == null)
      return null;
    return this.q.a(paramString);
  }

  public boolean b()
  {
    synchronized (this.r)
    {
      boolean bool = this.n;
      return bool;
    }
  }

  public boolean c()
  {
    return (!f()) && (d());
  }

  public boolean d()
  {
    return (this.p >= 200) && (this.p < 400);
  }

  public int e()
  {
    return this.p;
  }

  public boolean f()
  {
    return this.o != null;
  }

  public void g()
  {
    synchronized (this.r)
    {
      this.n = true;
      q();
      return;
    }
  }

  public void h()
  {
    g();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ek
 * JD-Core Version:    0.6.2
 */