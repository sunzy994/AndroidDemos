package cmcm.com.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class ath extends Thread
{
  private final Context a;
  private final atg b;
  private final ata c;
  private final Handler d;
  private boolean e = false;

  public ath(Context paramContext, File paramFile, String paramString1, String paramString2, Handler paramHandler, atg paramatg)
  {
    this.a = paramContext;
    this.b = paramatg;
    this.d = paramHandler;
    this.c = new ata();
    this.c.f = paramFile;
    this.c.c = paramString1;
    this.c.h = paramString2;
  }

  private static String a(String paramString)
  {
    try
    {
      String str = paramString.trim().toLowerCase(Locale.ENGLISH);
      int i = str.indexOf(';');
      paramString = str;
      if (i != -1)
        paramString = str.substring(0, i);
      return paramString;
    }
    catch (NullPointerException paramString)
    {
    }
    return null;
  }

  private HttpResponse a(HttpClient paramHttpClient, HttpGet paramHttpGet)
  {
    paramHttpGet = b(paramHttpClient, paramHttpGet);
    int i = paramHttpGet.getStatusLine().getStatusCode();
    if (a(paramHttpGet))
      return paramHttpGet;
    if ((301 == i) || (302 == i))
    {
      a(paramHttpClient, paramHttpGet);
      return null;
    }
    if (416 == i)
    {
      if ((this.c.h != null) && (atj.a(this.c.f, this.c.h)))
      {
        this.c.d();
        return null;
      }
      Log.i("Swipe..DownloadManager", "debug operation：download new file");
      aqx.e(this.c.f);
      return null;
    }
    Log.e("Swipe..DownloadManager", "response statuc code:" + i);
    throw new ati(3, null);
  }

  private void a(int paramInt)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("errorNo", paramInt);
    localObject = asq.a(this.d, 4, (Bundle)localObject, null);
    this.d.sendMessage((Message)localObject);
  }

  private void a(HttpClient paramHttpClient, HttpResponse paramHttpResponse)
  {
    paramHttpClient = paramHttpResponse.getFirstHeader("Location");
    if (paramHttpClient == null)
      throw new ati(3, null);
    try
    {
      paramHttpResponse = new URI(this.b.a()).resolve(new URI(paramHttpClient.getValue()));
      this.c.d = paramHttpResponse.toString();
      throw new ati(4, null);
    }
    catch (URISyntaxException paramHttpResponse)
    {
      Log.e("Swipe..DownloadManager", "Couldn't resolve redirect URI " + paramHttpClient.getValue() + " for " + this.b.a());
    }
    throw new ati(4, paramHttpResponse);
  }

  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      this.c.a(paramArrayOfByte, 0, paramInt);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("Swipe..DownloadManager", "save to file error", paramArrayOfByte);
    }
    throw new ati(5, null);
  }

  private boolean a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null);
    int i;
    do
    {
      return false;
      i = paramHttpResponse.getStatusLine().getStatusCode();
    }
    while ((200 != i) && (206 != i));
    return true;
  }

  private HttpResponse b(HttpClient paramHttpClient, HttpGet paramHttpGet)
  {
    try
    {
      paramHttpClient = paramHttpClient.execute(paramHttpGet);
      return paramHttpClient;
    }
    catch (ClientProtocolException paramHttpClient)
    {
      throw new ati(2, paramHttpClient);
    }
    catch (Exception paramHttpClient)
    {
      Log.e("Swipe..DownloadManager", "connecting to " + paramHttpGet.getURI() + " failed! ", paramHttpClient);
    }
    throw new ati(3, paramHttpClient);
  }

  private void b(HttpResponse paramHttpResponse)
  {
    c(paramHttpResponse);
    e(paramHttpResponse);
  }

  private void c()
  {
    boolean bool = false;
    int i;
    if ((!TextUtils.isEmpty(this.c.k.c)) && (this.c.f.length() != this.c.g))
    {
      i = 1;
      if (i != 0)
        break label132;
      if ((this.c.h == null) || (atj.a(this.c.f, this.c.h)))
        break label186;
    }
    while (true)
    {
      if (bool)
      {
        return;
        i = 0;
        break;
      }
      Log.e("Swipe..DownloadManager", "file mismatch! check sum result:" + bool);
      while (true)
      {
        aqx.e(this.c.f);
        throw new ati(7, null);
        label132: Log.e("Swipe..DownloadManager", "file mismatch! excepted size:" + this.c.g + ", actual size:" + this.c.f.length());
      }
      label186: bool = true;
    }
  }

  private void c(HttpResponse paramHttpResponse)
  {
    Object localObject = paramHttpResponse.getFirstHeader("Content-Disposition");
    if (localObject != null)
      this.c.k.d = ((Header)localObject).getValue();
    localObject = paramHttpResponse.getFirstHeader("Content-Location");
    if (localObject != null)
      this.c.k.e = ((Header)localObject).getValue();
    if (this.c.k.b == null)
    {
      localObject = paramHttpResponse.getFirstHeader("Content-Type");
      if (localObject != null)
        this.c.k.b = a(((Header)localObject).getValue());
    }
    localObject = paramHttpResponse.getFirstHeader("ETag");
    if (localObject != null)
      this.c.k.a = ((Header)localObject).getValue();
    localObject = paramHttpResponse.getFirstHeader("Transfer-Encoding");
    if (localObject != null);
    for (localObject = ((Header)localObject).getValue(); ; localObject = null)
    {
      if (localObject == null)
        d(paramHttpResponse);
      if ((this.c.k.c == null) && ((localObject == null) || (!((String)localObject).equalsIgnoreCase("chunked"))));
      for (int i = 1; i != 0; i = 0)
        throw new ati(6, null);
      return;
    }
  }

  private void d()
  {
  }

  private void d(HttpResponse paramHttpResponse)
  {
    Header localHeader = paramHttpResponse.getFirstHeader("Content-Length");
    int i;
    if (localHeader != null)
    {
      this.c.k.c = localHeader.getValue();
      i = paramHttpResponse.getStatusLine().getStatusCode();
      if (i != 200)
        break label81;
      aqx.e(this.c.f);
      this.c.g = Long.parseLong(this.c.k.c);
    }
    label81: 
    while (i != 206)
      return;
    this.c.g = (Long.parseLong(this.c.k.c) + this.c.j);
  }

  // ERROR //
  private void e(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	ath:c	Lata;
    //   4: getfield 36	ata:f	Ljava/io/File;
    //   7: invokevirtual 305	java/io/File:exists	()Z
    //   10: ifne +44 -> 54
    //   13: aload_0
    //   14: getfield 32	ath:c	Lata;
    //   17: getfield 36	ata:f	Ljava/io/File;
    //   20: invokevirtual 309	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 305	java/io/File:exists	()Z
    //   26: ifne +17 -> 43
    //   29: aload_0
    //   30: getfield 32	ath:c	Lata;
    //   33: getfield 36	ata:f	Ljava/io/File;
    //   36: invokevirtual 309	java/io/File:getParentFile	()Ljava/io/File;
    //   39: invokevirtual 312	java/io/File:mkdirs	()Z
    //   42: pop
    //   43: aload_0
    //   44: getfield 32	ath:c	Lata;
    //   47: getfield 36	ata:f	Ljava/io/File;
    //   50: invokevirtual 315	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: aload_1
    //   55: invokeinterface 319 1 0
    //   60: invokeinterface 325 1 0
    //   65: astore_1
    //   66: sipush 2048
    //   69: newarray byte
    //   71: astore_2
    //   72: aload_0
    //   73: invokevirtual 327	ath:b	()Z
    //   76: ifeq +26 -> 102
    //   79: return
    //   80: astore_1
    //   81: new 132	ati
    //   84: dup
    //   85: iconst_1
    //   86: aload_1
    //   87: invokespecial 135	ati:<init>	(ILjava/lang/Throwable;)V
    //   90: athrow
    //   91: astore_1
    //   92: new 132	ati
    //   95: dup
    //   96: iconst_3
    //   97: aload_1
    //   98: invokespecial 135	ati:<init>	(ILjava/lang/Throwable;)V
    //   101: athrow
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual 333	java/io/InputStream:read	([B)I
    //   107: istore_3
    //   108: iload_3
    //   109: iconst_m1
    //   110: if_icmpne +40 -> 150
    //   113: aload_0
    //   114: getfield 32	ath:c	Lata;
    //   117: invokevirtual 98	ata:d	()V
    //   120: aload_0
    //   121: invokespecial 334	ath:d	()V
    //   124: aload_0
    //   125: invokespecial 336	ath:c	()V
    //   128: return
    //   129: astore_1
    //   130: ldc 100
    //   132: ldc_w 338
    //   135: aload_1
    //   136: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   139: pop
    //   140: new 132	ati
    //   143: dup
    //   144: iconst_3
    //   145: aload_1
    //   146: invokespecial 135	ati:<init>	(ILjava/lang/Throwable;)V
    //   149: athrow
    //   150: aload_0
    //   151: aload_2
    //   152: iload_3
    //   153: invokespecial 340	ath:a	([BI)V
    //   156: aload_0
    //   157: invokespecial 334	ath:d	()V
    //   160: goto -88 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   13	43	80	java/io/IOException
    //   43	54	80	java/io/IOException
    //   54	66	91	java/lang/Exception
    //   102	108	129	java/lang/Exception
  }

  public int a()
  {
    if ((this.c.f == null) || (!this.c.f.exists()));
    while (this.c.g == 0L)
      return 0;
    if (this.c.f.length() > this.c.g)
    {
      Log.i("Swipe..DownloadManager", "downloaded File is larger than given size");
      return 100;
    }
    return (int)(this.c.f.length() * 100L / this.c.g);
  }

  public boolean b()
  {
    return this.e;
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 23	ath:a	Landroid/content/Context;
    //   6: invokestatic 350	arl:i	(Landroid/content/Context;)Z
    //   9: ifne +9 -> 18
    //   12: aload_0
    //   13: iconst_3
    //   14: invokespecial 352	ath:a	(I)V
    //   17: return
    //   18: aload_0
    //   19: getfield 27	ath:d	Landroid/os/Handler;
    //   22: iconst_1
    //   23: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   26: pop
    //   27: aload_2
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 32	ath:c	Lata;
    //   33: getfield 36	ata:f	Ljava/io/File;
    //   36: invokevirtual 305	java/io/File:exists	()Z
    //   39: ifeq +108 -> 147
    //   42: aload_2
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 32	ath:c	Lata;
    //   48: getfield 42	ata:h	Ljava/lang/String;
    //   51: ifnull +96 -> 147
    //   54: aload_2
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 32	ath:c	Lata;
    //   60: getfield 36	ata:f	Ljava/io/File;
    //   63: aload_0
    //   64: getfield 32	ath:c	Lata;
    //   67: getfield 42	ata:h	Ljava/lang/String;
    //   70: invokestatic 96	atj:a	(Ljava/io/File;Ljava/lang/String;)Z
    //   73: ifeq +74 -> 147
    //   76: aload_2
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 32	ath:c	Lata;
    //   82: invokevirtual 98	ata:d	()V
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 27	ath:d	Landroid/os/Handler;
    //   91: iconst_3
    //   92: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   95: pop
    //   96: aload_0
    //   97: getfield 27	ath:d	Landroid/os/Handler;
    //   100: iconst_5
    //   101: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   104: pop
    //   105: iconst_0
    //   106: ifeq +11 -> 117
    //   109: new 46	java/lang/NullPointerException
    //   112: dup
    //   113: invokespecial 357	java/lang/NullPointerException:<init>	()V
    //   116: athrow
    //   117: aload_0
    //   118: getfield 32	ath:c	Lata;
    //   121: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   124: ifnull -107 -> 17
    //   127: aload_0
    //   128: getfield 32	ath:c	Lata;
    //   131: invokevirtual 362	ata:f	()V
    //   134: return
    //   135: astore_1
    //   136: ldc 100
    //   138: ldc_w 364
    //   141: aload_1
    //   142: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   145: pop
    //   146: return
    //   147: aload_2
    //   148: astore_1
    //   149: aload_0
    //   150: getfield 23	ath:a	Landroid/content/Context;
    //   153: ldc_w 366
    //   156: invokevirtual 372	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   159: checkcast 374	android/os/PowerManager
    //   162: iconst_1
    //   163: ldc 100
    //   165: invokevirtual 378	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   168: astore_3
    //   169: aload_3
    //   170: astore_1
    //   171: aload_3
    //   172: invokevirtual 383	android/os/PowerManager$WakeLock:acquire	()V
    //   175: aload_3
    //   176: astore_1
    //   177: invokestatic 388	aqg:a	()Lorg/apache/http/client/HttpClient;
    //   180: astore 4
    //   182: aload_3
    //   183: astore_1
    //   184: aload_0
    //   185: getfield 32	ath:c	Lata;
    //   188: invokevirtual 390	ata:e	()Z
    //   191: ifeq +61 -> 252
    //   194: aload_3
    //   195: astore_1
    //   196: aload_0
    //   197: getfield 27	ath:d	Landroid/os/Handler;
    //   200: iconst_3
    //   201: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   204: pop
    //   205: aload_0
    //   206: getfield 27	ath:d	Landroid/os/Handler;
    //   209: iconst_5
    //   210: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   213: pop
    //   214: aload_3
    //   215: ifnull +7 -> 222
    //   218: aload_3
    //   219: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   222: aload_0
    //   223: getfield 32	ath:c	Lata;
    //   226: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   229: ifnull -212 -> 17
    //   232: aload_0
    //   233: getfield 32	ath:c	Lata;
    //   236: invokevirtual 362	ata:f	()V
    //   239: return
    //   240: astore_1
    //   241: ldc 100
    //   243: ldc_w 364
    //   246: aload_1
    //   247: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   250: pop
    //   251: return
    //   252: aload_3
    //   253: astore_1
    //   254: aload_0
    //   255: getfield 32	ath:c	Lata;
    //   258: invokevirtual 394	ata:b	()Z
    //   261: ifeq +57 -> 318
    //   264: aload_3
    //   265: astore_1
    //   266: aload_0
    //   267: iconst_3
    //   268: invokespecial 352	ath:a	(I)V
    //   271: aload_0
    //   272: getfield 27	ath:d	Landroid/os/Handler;
    //   275: iconst_5
    //   276: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   279: pop
    //   280: aload_3
    //   281: ifnull +7 -> 288
    //   284: aload_3
    //   285: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   288: aload_0
    //   289: getfield 32	ath:c	Lata;
    //   292: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   295: ifnull -278 -> 17
    //   298: aload_0
    //   299: getfield 32	ath:c	Lata;
    //   302: invokevirtual 362	ata:f	()V
    //   305: return
    //   306: astore_1
    //   307: ldc 100
    //   309: ldc_w 364
    //   312: aload_1
    //   313: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   316: pop
    //   317: return
    //   318: aload_3
    //   319: astore_1
    //   320: aload_0
    //   321: getfield 32	ath:c	Lata;
    //   324: invokevirtual 396	ata:c	()Z
    //   327: ifeq +57 -> 384
    //   330: aload_3
    //   331: astore_1
    //   332: aload_0
    //   333: iconst_3
    //   334: invokespecial 352	ath:a	(I)V
    //   337: aload_0
    //   338: getfield 27	ath:d	Landroid/os/Handler;
    //   341: iconst_5
    //   342: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   345: pop
    //   346: aload_3
    //   347: ifnull +7 -> 354
    //   350: aload_3
    //   351: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   354: aload_0
    //   355: getfield 32	ath:c	Lata;
    //   358: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   361: ifnull -344 -> 17
    //   364: aload_0
    //   365: getfield 32	ath:c	Lata;
    //   368: invokevirtual 362	ata:f	()V
    //   371: return
    //   372: astore_1
    //   373: ldc 100
    //   375: ldc_w 364
    //   378: aload_1
    //   379: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   382: pop
    //   383: return
    //   384: aload_3
    //   385: astore_1
    //   386: aload_0
    //   387: invokevirtual 327	ath:b	()Z
    //   390: ifeq +62 -> 452
    //   393: aload_3
    //   394: astore_1
    //   395: aload_0
    //   396: getfield 27	ath:d	Landroid/os/Handler;
    //   399: bipush 6
    //   401: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   404: pop
    //   405: aload_0
    //   406: getfield 27	ath:d	Landroid/os/Handler;
    //   409: iconst_5
    //   410: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   413: pop
    //   414: aload_3
    //   415: ifnull +7 -> 422
    //   418: aload_3
    //   419: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   422: aload_0
    //   423: getfield 32	ath:c	Lata;
    //   426: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   429: ifnull -412 -> 17
    //   432: aload_0
    //   433: getfield 32	ath:c	Lata;
    //   436: invokevirtual 362	ata:f	()V
    //   439: return
    //   440: astore_1
    //   441: ldc 100
    //   443: ldc_w 364
    //   446: aload_1
    //   447: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   450: pop
    //   451: return
    //   452: aload_3
    //   453: astore_1
    //   454: aload_0
    //   455: getfield 32	ath:c	Lata;
    //   458: getfield 399	ata:e	I
    //   461: iconst_2
    //   462: if_icmpne +92 -> 554
    //   465: aload_3
    //   466: astore_1
    //   467: aload_0
    //   468: getfield 25	ath:b	Latg;
    //   471: aload_0
    //   472: getfield 23	ath:a	Landroid/content/Context;
    //   475: aload_0
    //   476: getfield 32	ath:c	Lata;
    //   479: aload_0
    //   480: getfield 32	ath:c	Lata;
    //   483: getfield 185	ata:d	Ljava/lang/String;
    //   486: invokeinterface 402 4 0
    //   491: astore_2
    //   492: aload_2
    //   493: ifnonnull +139 -> 632
    //   496: aload_3
    //   497: astore_1
    //   498: aload_0
    //   499: getfield 27	ath:d	Landroid/os/Handler;
    //   502: iconst_3
    //   503: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   506: pop
    //   507: aload_0
    //   508: getfield 27	ath:d	Landroid/os/Handler;
    //   511: iconst_5
    //   512: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   515: pop
    //   516: aload_3
    //   517: ifnull +7 -> 524
    //   520: aload_3
    //   521: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   524: aload_0
    //   525: getfield 32	ath:c	Lata;
    //   528: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   531: ifnull -514 -> 17
    //   534: aload_0
    //   535: getfield 32	ath:c	Lata;
    //   538: invokevirtual 362	ata:f	()V
    //   541: return
    //   542: astore_1
    //   543: ldc 100
    //   545: ldc_w 364
    //   548: aload_1
    //   549: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   552: pop
    //   553: return
    //   554: aload_3
    //   555: astore_1
    //   556: aload_0
    //   557: getfield 25	ath:b	Latg;
    //   560: aload_0
    //   561: getfield 23	ath:a	Landroid/content/Context;
    //   564: aload_0
    //   565: getfield 32	ath:c	Lata;
    //   568: invokeinterface 405 3 0
    //   573: astore_2
    //   574: goto -82 -> 492
    //   577: astore_1
    //   578: aload_3
    //   579: astore_1
    //   580: aload_0
    //   581: iconst_3
    //   582: invokespecial 352	ath:a	(I)V
    //   585: aload_0
    //   586: getfield 27	ath:d	Landroid/os/Handler;
    //   589: iconst_5
    //   590: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   593: pop
    //   594: aload_3
    //   595: ifnull +7 -> 602
    //   598: aload_3
    //   599: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   602: aload_0
    //   603: getfield 32	ath:c	Lata;
    //   606: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   609: ifnull -592 -> 17
    //   612: aload_0
    //   613: getfield 32	ath:c	Lata;
    //   616: invokevirtual 362	ata:f	()V
    //   619: return
    //   620: astore_1
    //   621: ldc 100
    //   623: ldc_w 364
    //   626: aload_1
    //   627: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   630: pop
    //   631: return
    //   632: aload_3
    //   633: astore_1
    //   634: aload_0
    //   635: aload 4
    //   637: aload_2
    //   638: invokespecial 407	ath:a	(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpGet;)Lorg/apache/http/HttpResponse;
    //   641: astore_2
    //   642: aload_2
    //   643: ifnull -461 -> 182
    //   646: aload_3
    //   647: astore_1
    //   648: aload_0
    //   649: aload_2
    //   650: invokespecial 409	ath:b	(Lorg/apache/http/HttpResponse;)V
    //   653: goto -471 -> 182
    //   656: astore_2
    //   657: aload_3
    //   658: astore_1
    //   659: ldc 100
    //   661: ldc_w 411
    //   664: aload_2
    //   665: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   668: pop
    //   669: aload_3
    //   670: astore_1
    //   671: aload_2
    //   672: invokevirtual 412	ati:c	()Z
    //   675: ifeq +60 -> 735
    //   678: aload_3
    //   679: astore_1
    //   680: aload_0
    //   681: aload_2
    //   682: invokevirtual 414	ati:a	()I
    //   685: invokespecial 352	ath:a	(I)V
    //   688: aload_0
    //   689: getfield 27	ath:d	Landroid/os/Handler;
    //   692: iconst_5
    //   693: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   696: pop
    //   697: aload_3
    //   698: ifnull +7 -> 705
    //   701: aload_3
    //   702: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   705: aload_0
    //   706: getfield 32	ath:c	Lata;
    //   709: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   712: ifnull -695 -> 17
    //   715: aload_0
    //   716: getfield 32	ath:c	Lata;
    //   719: invokevirtual 362	ata:f	()V
    //   722: return
    //   723: astore_1
    //   724: ldc 100
    //   726: ldc_w 364
    //   729: aload_1
    //   730: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   733: pop
    //   734: return
    //   735: aload_3
    //   736: astore_1
    //   737: aload_2
    //   738: invokevirtual 414	ati:a	()I
    //   741: iconst_3
    //   742: if_icmpne +53 -> 795
    //   745: aload_3
    //   746: astore_1
    //   747: aload_0
    //   748: getfield 32	ath:c	Lata;
    //   751: aload_2
    //   752: invokevirtual 417	ata:b	(Lati;)V
    //   755: goto -573 -> 182
    //   758: astore_2
    //   759: aload_0
    //   760: getfield 27	ath:d	Landroid/os/Handler;
    //   763: iconst_5
    //   764: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   767: pop
    //   768: aload_1
    //   769: ifnull +7 -> 776
    //   772: aload_1
    //   773: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   776: aload_0
    //   777: getfield 32	ath:c	Lata;
    //   780: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   783: ifnull +10 -> 793
    //   786: aload_0
    //   787: getfield 32	ath:c	Lata;
    //   790: invokevirtual 362	ata:f	()V
    //   793: aload_2
    //   794: athrow
    //   795: aload_3
    //   796: astore_1
    //   797: aload_2
    //   798: invokevirtual 414	ati:a	()I
    //   801: iconst_4
    //   802: if_icmpne -620 -> 182
    //   805: aload_3
    //   806: astore_1
    //   807: aload_0
    //   808: getfield 32	ath:c	Lata;
    //   811: aload_2
    //   812: invokevirtual 419	ata:a	(Lati;)V
    //   815: goto -633 -> 182
    //   818: astore_2
    //   819: aload_3
    //   820: astore_1
    //   821: ldc 100
    //   823: ldc_w 411
    //   826: aload_2
    //   827: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   830: pop
    //   831: aload_3
    //   832: astore_1
    //   833: aload_0
    //   834: iconst_3
    //   835: invokespecial 352	ath:a	(I)V
    //   838: aload_0
    //   839: getfield 27	ath:d	Landroid/os/Handler;
    //   842: iconst_5
    //   843: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   846: pop
    //   847: aload_3
    //   848: ifnull +7 -> 855
    //   851: aload_3
    //   852: invokevirtual 393	android/os/PowerManager$WakeLock:release	()V
    //   855: aload_0
    //   856: getfield 32	ath:c	Lata;
    //   859: getfield 360	ata:i	Ljava/io/FileOutputStream;
    //   862: ifnull -845 -> 17
    //   865: aload_0
    //   866: getfield 32	ath:c	Lata;
    //   869: invokevirtual 362	ata:f	()V
    //   872: return
    //   873: astore_1
    //   874: ldc 100
    //   876: ldc_w 364
    //   879: aload_1
    //   880: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   883: pop
    //   884: return
    //   885: astore_1
    //   886: ldc 100
    //   888: ldc_w 364
    //   891: aload_1
    //   892: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   895: pop
    //   896: goto -103 -> 793
    //
    // Exception table:
    //   from	to	target	type
    //   127	134	135	java/io/IOException
    //   232	239	240	java/io/IOException
    //   298	305	306	java/io/IOException
    //   364	371	372	java/io/IOException
    //   432	439	440	java/io/IOException
    //   534	541	542	java/io/IOException
    //   454	465	577	java/lang/Exception
    //   467	492	577	java/lang/Exception
    //   498	507	577	java/lang/Exception
    //   556	574	577	java/lang/Exception
    //   612	619	620	java/io/IOException
    //   634	642	656	ati
    //   648	653	656	ati
    //   715	722	723	java/io/IOException
    //   29	42	758	finally
    //   44	54	758	finally
    //   56	76	758	finally
    //   78	85	758	finally
    //   87	96	758	finally
    //   149	169	758	finally
    //   171	175	758	finally
    //   177	182	758	finally
    //   184	194	758	finally
    //   196	205	758	finally
    //   254	264	758	finally
    //   266	271	758	finally
    //   320	330	758	finally
    //   332	337	758	finally
    //   386	393	758	finally
    //   395	405	758	finally
    //   454	465	758	finally
    //   467	492	758	finally
    //   498	507	758	finally
    //   556	574	758	finally
    //   580	585	758	finally
    //   634	642	758	finally
    //   648	653	758	finally
    //   659	669	758	finally
    //   671	678	758	finally
    //   680	688	758	finally
    //   737	745	758	finally
    //   747	755	758	finally
    //   797	805	758	finally
    //   807	815	758	finally
    //   821	831	758	finally
    //   833	838	758	finally
    //   634	642	818	java/lang/Exception
    //   648	653	818	java/lang/Exception
    //   865	872	873	java/io/IOException
    //   786	793	885	java/io/IOException
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ath
 * JD-Core Version:    0.6.2
 */