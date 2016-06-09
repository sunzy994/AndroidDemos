package cmcm.com.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.message.BasicHeader;

public class arb
{
  private static final Header a = new BasicHeader("Accept-Encoding", "gzip");
  private final Context b;

  public arb(Context paramContext)
  {
    this.b = paramContext;
  }

  public static String a()
  {
    return "NLFDN";
  }

  private static String a(InputStream paramInputStream)
  {
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        paramInputStream = new StringBuilder();
        while (true)
        {
          String str = localBufferedReader.readLine();
          if (str == null)
            break;
          if (paramInputStream.length() != 0)
            paramInputStream.append('\r');
          paramInputStream.append(str);
        }
      }
      finally
      {
      }
      if (localBufferedReader != null)
        localBufferedReader.close();
      throw paramInputStream;
      paramInputStream = paramInputStream.toString();
      if (localBufferedReader != null)
        localBufferedReader.close();
      return paramInputStream;
    }
    finally
    {
      while (true)
        BufferedReader localBufferedReader = null;
    }
  }

  public static String a(String paramString)
  {
    try
    {
      Object localObject = new URL(paramString);
      localObject = ((URL)localObject).getProtocol() + "://" + ((URL)localObject).getHost();
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }

  public static String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramMap != null);
    while (true)
    {
      Entry localEntry;
      try
      {
        paramMap = paramMap.entrySet().iterator();
        if (paramMap.hasNext())
        {
          localEntry = (Entry)paramMap.next();
          String str = (String)localEntry.getKey();
          if ((str == null) || (str.equals("")))
            continue;
          if ((!str.toLowerCase().equals("q")) && (!str.toLowerCase().equals("t")))
            break label138;
          localStringBuilder.append(";").append(str).append("=").append((String)localEntry.getValue());
          continue;
        }
      }
      catch (Exception paramMap)
      {
        Log.e("Swipe.Global", paramMap.getMessage(), paramMap);
      }
      return localStringBuilder.toString();
      label138: localStringBuilder.append(";").append((String)localEntry.getKey()).append("=").append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
    }
  }

  public static String a(HttpResponse paramHttpResponse)
  {
    return a(b(paramHttpResponse));
  }

  private static void a(HttpResponse paramHttpResponse, File paramFile)
  {
    HttpResponse localHttpResponse = null;
    try
    {
      paramHttpResponse = b(paramHttpResponse);
      localHttpResponse = paramHttpResponse;
      File localFile = paramFile.getParentFile();
      if (localFile != null)
      {
        localHttpResponse = paramHttpResponse;
        if (!localFile.exists())
        {
          localHttpResponse = paramHttpResponse;
          localFile.mkdirs();
        }
      }
      localHttpResponse = paramHttpResponse;
      if ((!aqx.a(paramHttpResponse, paramFile)) && (paramFile != null))
      {
        localHttpResponse = paramHttpResponse;
        if (paramFile.exists())
        {
          localHttpResponse = paramHttpResponse;
          paramFile.delete();
        }
      }
      return;
    }
    finally
    {
      if (localHttpResponse != null)
        localHttpResponse.close();
    }
    throw paramHttpResponse;
  }

  private void a(HttpUriRequest paramHttpUriRequest)
  {
    Object localObject = (ConnectivityManager)this.b.getSystemService("connectivity");
    if (localObject == null)
    {
      localObject = null;
      if ((localObject != null) && (((NetworkInfo)localObject).getType() != 1))
        break label40;
    }
    label40: int i;
    do
    {
      do
      {
        return;
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        break;
        localObject = Proxy.getHost(this.b);
      }
      while (localObject == null);
      i = Proxy.getPort(this.b);
    }
    while (i < 0);
    localObject = new HttpHost((String)localObject, i);
    ConnRouteParams.setDefaultProxy(paramHttpUriRequest.getParams(), (HttpHost)localObject);
  }

  private static boolean a(Header paramHeader, String paramString)
  {
    if ((paramHeader == null) || (paramString == null));
    while (true)
    {
      return false;
      paramHeader = paramHeader.getElements();
      int j = paramHeader.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramHeader[i].getName()))
          return true;
        i += 1;
      }
    }
  }

  private static InputStream b(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = paramHttpResponse.getEntity();
    if (a(paramHttpResponse.getContentEncoding(), "gzip"))
      return AndroidHttpClient.getUngzippedContent(paramHttpResponse);
    return paramHttpResponse.getContent();
  }

  // ERROR //
  public String a(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 284	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   6: invokestatic 288	ard:b	(Landroid/content/Context;)Ljava/lang/String;
    //   9: invokestatic 292	android/net/http/AndroidHttpClient:newInstance	(Ljava/lang/String;)Landroid/net/http/AndroidHttpClient;
    //   12: astore_3
    //   13: aload_3
    //   14: astore 4
    //   16: aload_3
    //   17: invokevirtual 293	android/net/http/AndroidHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   20: iconst_1
    //   21: invokestatic 299	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   24: aload_3
    //   25: astore 4
    //   27: new 301	org/apache/http/client/methods/HttpGet
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 302	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_3
    //   37: astore 4
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 166	arb:a	(Lorg/apache/http/client/methods/HttpUriRequest;)V
    //   44: aload_3
    //   45: astore 4
    //   47: aload_1
    //   48: getstatic 26	arb:a	Lorg/apache/http/Header;
    //   51: invokeinterface 306 2 0
    //   56: aload_2
    //   57: ifnull +19 -> 76
    //   60: aload_3
    //   61: astore 4
    //   63: aload_1
    //   64: ldc_w 308
    //   67: aload_2
    //   68: invokestatic 310	arb:a	(Ljava/util/Map;)Ljava/lang/String;
    //   71: invokeinterface 312 3 0
    //   76: aload_3
    //   77: astore 4
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 316	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   84: astore_1
    //   85: aload_3
    //   86: astore 4
    //   88: aload_1
    //   89: invokeinterface 320 1 0
    //   94: astore_2
    //   95: aload_2
    //   96: ifnonnull +31 -> 127
    //   99: aload_3
    //   100: astore 4
    //   102: ldc 137
    //   104: ldc_w 322
    //   107: invokestatic 325	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   110: pop
    //   111: aload 5
    //   113: astore_1
    //   114: aload_3
    //   115: ifnull +10 -> 125
    //   118: aload_3
    //   119: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   122: aload 5
    //   124: astore_1
    //   125: aload_1
    //   126: areturn
    //   127: aload_3
    //   128: astore 4
    //   130: aload_2
    //   131: invokeinterface 331 1 0
    //   136: istore 6
    //   138: iload 6
    //   140: sipush 200
    //   143: if_icmpeq +49 -> 192
    //   146: aload_3
    //   147: astore 4
    //   149: ldc 137
    //   151: new 48	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 333
    //   161: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: iload 6
    //   166: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 325	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   175: pop
    //   176: aload 5
    //   178: astore_1
    //   179: aload_3
    //   180: ifnull -55 -> 125
    //   183: aload_3
    //   184: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: areturn
    //   192: aload_3
    //   193: astore 4
    //   195: aload_1
    //   196: invokestatic 338	arb:a	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   199: astore_2
    //   200: aload_2
    //   201: astore_1
    //   202: aload_3
    //   203: ifnull -78 -> 125
    //   206: aload_3
    //   207: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   210: aload_2
    //   211: areturn
    //   212: astore_1
    //   213: aload_2
    //   214: areturn
    //   215: astore_1
    //   216: aconst_null
    //   217: astore_3
    //   218: aload_3
    //   219: astore 4
    //   221: ldc 137
    //   223: ldc_w 340
    //   226: aload_1
    //   227: invokestatic 146	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   230: pop
    //   231: aload 5
    //   233: astore_1
    //   234: aload_3
    //   235: ifnull -110 -> 125
    //   238: aload_3
    //   239: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore_1
    //   245: aconst_null
    //   246: areturn
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_3
    //   250: aload_3
    //   251: astore 4
    //   253: ldc 137
    //   255: ldc_w 342
    //   258: aload_1
    //   259: invokestatic 146	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   262: pop
    //   263: aload 5
    //   265: astore_1
    //   266: aload_3
    //   267: ifnull -142 -> 125
    //   270: aload_3
    //   271: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   274: aconst_null
    //   275: areturn
    //   276: astore_1
    //   277: aconst_null
    //   278: areturn
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_3
    //   282: aload_3
    //   283: astore 4
    //   285: ldc 137
    //   287: ldc_w 344
    //   290: aload_1
    //   291: invokestatic 146	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   294: pop
    //   295: aload 5
    //   297: astore_1
    //   298: aload_3
    //   299: ifnull -174 -> 125
    //   302: aload_3
    //   303: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   306: aconst_null
    //   307: areturn
    //   308: astore_1
    //   309: aconst_null
    //   310: areturn
    //   311: astore_1
    //   312: aconst_null
    //   313: astore 4
    //   315: aload 4
    //   317: ifnull +8 -> 325
    //   320: aload 4
    //   322: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   325: aload_1
    //   326: athrow
    //   327: astore_1
    //   328: aconst_null
    //   329: areturn
    //   330: astore_2
    //   331: goto -6 -> 325
    //   334: astore_1
    //   335: goto -20 -> 315
    //   338: astore_1
    //   339: goto -57 -> 282
    //   342: astore_1
    //   343: goto -93 -> 250
    //   346: astore_1
    //   347: goto -129 -> 218
    //
    // Exception table:
    //   from	to	target	type
    //   183	187	189	java/lang/Exception
    //   206	210	212	java/lang/Exception
    //   3	13	215	org/apache/http/client/ClientProtocolException
    //   238	242	244	java/lang/Exception
    //   3	13	247	java/io/IOException
    //   270	274	276	java/lang/Exception
    //   3	13	279	java/lang/Throwable
    //   302	306	308	java/lang/Exception
    //   3	13	311	finally
    //   118	122	327	java/lang/Exception
    //   320	325	330	java/lang/Exception
    //   16	24	334	finally
    //   27	36	334	finally
    //   39	44	334	finally
    //   47	56	334	finally
    //   63	76	334	finally
    //   79	85	334	finally
    //   88	95	334	finally
    //   102	111	334	finally
    //   130	138	334	finally
    //   149	176	334	finally
    //   195	200	334	finally
    //   221	231	334	finally
    //   253	263	334	finally
    //   285	295	334	finally
    //   16	24	338	java/lang/Throwable
    //   27	36	338	java/lang/Throwable
    //   39	44	338	java/lang/Throwable
    //   47	56	338	java/lang/Throwable
    //   63	76	338	java/lang/Throwable
    //   79	85	338	java/lang/Throwable
    //   88	95	338	java/lang/Throwable
    //   102	111	338	java/lang/Throwable
    //   130	138	338	java/lang/Throwable
    //   149	176	338	java/lang/Throwable
    //   195	200	338	java/lang/Throwable
    //   16	24	342	java/io/IOException
    //   27	36	342	java/io/IOException
    //   39	44	342	java/io/IOException
    //   47	56	342	java/io/IOException
    //   63	76	342	java/io/IOException
    //   79	85	342	java/io/IOException
    //   88	95	342	java/io/IOException
    //   102	111	342	java/io/IOException
    //   130	138	342	java/io/IOException
    //   149	176	342	java/io/IOException
    //   195	200	342	java/io/IOException
    //   16	24	346	org/apache/http/client/ClientProtocolException
    //   27	36	346	org/apache/http/client/ClientProtocolException
    //   39	44	346	org/apache/http/client/ClientProtocolException
    //   47	56	346	org/apache/http/client/ClientProtocolException
    //   63	76	346	org/apache/http/client/ClientProtocolException
    //   79	85	346	org/apache/http/client/ClientProtocolException
    //   88	95	346	org/apache/http/client/ClientProtocolException
    //   102	111	346	org/apache/http/client/ClientProtocolException
    //   130	138	346	org/apache/http/client/ClientProtocolException
    //   149	176	346	org/apache/http/client/ClientProtocolException
    //   195	200	346	org/apache/http/client/ClientProtocolException
  }

  public void a(final String paramString, final Map<String, String> paramMap, final arc<String> paramarc)
  {
    new Thread()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore 5
        //   6: aconst_null
        //   7: astore_1
        //   8: aconst_null
        //   9: astore_3
        //   10: ldc 45
        //   12: invokestatic 51	android/net/http/AndroidHttpClient:newInstance	(Ljava/lang/String;)Landroid/net/http/AndroidHttpClient;
        //   15: astore_2
        //   16: aload_2
        //   17: astore_3
        //   18: aload_2
        //   19: astore 4
        //   21: aload_2
        //   22: astore 5
        //   24: aload_2
        //   25: astore_1
        //   26: aload_2
        //   27: invokevirtual 55	android/net/http/AndroidHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
        //   30: iconst_1
        //   31: invokestatic 61	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
        //   34: aload_2
        //   35: astore_3
        //   36: aload_2
        //   37: astore 4
        //   39: aload_2
        //   40: astore 5
        //   42: aload_2
        //   43: astore_1
        //   44: new 63	org/apache/http/client/methods/HttpGet
        //   47: dup
        //   48: aload_0
        //   49: getfield 24	arb$2:a	Ljava/lang/String;
        //   52: invokespecial 66	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
        //   55: astore 6
        //   57: aload_2
        //   58: astore_3
        //   59: aload_2
        //   60: astore 4
        //   62: aload_2
        //   63: astore 5
        //   65: aload_2
        //   66: astore_1
        //   67: aload_0
        //   68: getfield 22	arb$2:e	Larb;
        //   71: aload 6
        //   73: invokestatic 69	arb:a	(Larb;Lorg/apache/http/client/methods/HttpUriRequest;)V
        //   76: aload_2
        //   77: astore_3
        //   78: aload_2
        //   79: astore 4
        //   81: aload_2
        //   82: astore 5
        //   84: aload_2
        //   85: astore_1
        //   86: aload 6
        //   88: invokestatic 72	arb:b	()Lorg/apache/http/Header;
        //   91: invokeinterface 78 2 0
        //   96: aload_2
        //   97: astore_3
        //   98: aload_2
        //   99: astore 4
        //   101: aload_2
        //   102: astore 5
        //   104: aload_2
        //   105: astore_1
        //   106: aload_0
        //   107: getfield 26	arb$2:b	Ljava/util/Map;
        //   110: ifnull +29 -> 139
        //   113: aload_2
        //   114: astore_3
        //   115: aload_2
        //   116: astore 4
        //   118: aload_2
        //   119: astore 5
        //   121: aload_2
        //   122: astore_1
        //   123: aload 6
        //   125: ldc 80
        //   127: aload_0
        //   128: getfield 26	arb$2:b	Ljava/util/Map;
        //   131: invokestatic 83	arb:a	(Ljava/util/Map;)Ljava/lang/String;
        //   134: invokeinterface 86 3 0
        //   139: aload_2
        //   140: astore_3
        //   141: aload_2
        //   142: astore 4
        //   144: aload_2
        //   145: astore 5
        //   147: aload_2
        //   148: astore_1
        //   149: aload_2
        //   150: aload 6
        //   152: aload_0
        //   153: getfield 28	arb$2:c	Lorg/apache/http/client/ResponseHandler;
        //   156: invokevirtual 90	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
        //   159: pop
        //   160: aload_2
        //   161: ifnull +7 -> 168
        //   164: aload_2
        //   165: invokevirtual 93	android/net/http/AndroidHttpClient:close	()V
        //   168: return
        //   169: astore_2
        //   170: aload_3
        //   171: astore_1
        //   172: ldc 95
        //   174: ldc 97
        //   176: aload_2
        //   177: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   180: pop
        //   181: aload_3
        //   182: astore_1
        //   183: aload_0
        //   184: getfield 30	arb$2:d	Larc;
        //   187: aload_2
        //   188: invokeinterface 107 2 0
        //   193: aload_3
        //   194: ifnull -26 -> 168
        //   197: aload_3
        //   198: invokevirtual 93	android/net/http/AndroidHttpClient:close	()V
        //   201: return
        //   202: astore_1
        //   203: return
        //   204: astore_2
        //   205: aload 4
        //   207: astore_1
        //   208: ldc 95
        //   210: ldc 109
        //   212: aload_2
        //   213: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   216: pop
        //   217: aload 4
        //   219: astore_1
        //   220: aload_0
        //   221: getfield 30	arb$2:d	Larc;
        //   224: aload_2
        //   225: invokeinterface 107 2 0
        //   230: aload 4
        //   232: ifnull -64 -> 168
        //   235: aload 4
        //   237: invokevirtual 93	android/net/http/AndroidHttpClient:close	()V
        //   240: return
        //   241: astore_1
        //   242: return
        //   243: astore_2
        //   244: aload 5
        //   246: astore_1
        //   247: ldc 95
        //   249: ldc 111
        //   251: aload_2
        //   252: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   255: pop
        //   256: aload 5
        //   258: astore_1
        //   259: aload_0
        //   260: getfield 30	arb$2:d	Larc;
        //   263: aload_2
        //   264: invokeinterface 107 2 0
        //   269: aload 5
        //   271: ifnull -103 -> 168
        //   274: aload 5
        //   276: invokevirtual 93	android/net/http/AndroidHttpClient:close	()V
        //   279: return
        //   280: astore_1
        //   281: return
        //   282: astore_2
        //   283: aload_1
        //   284: ifnull +7 -> 291
        //   287: aload_1
        //   288: invokevirtual 93	android/net/http/AndroidHttpClient:close	()V
        //   291: aload_2
        //   292: athrow
        //   293: astore_1
        //   294: return
        //   295: astore_1
        //   296: goto -5 -> 291
        //
        // Exception table:
        //   from	to	target	type
        //   10	16	169	org/apache/http/client/ClientProtocolException
        //   26	34	169	org/apache/http/client/ClientProtocolException
        //   44	57	169	org/apache/http/client/ClientProtocolException
        //   67	76	169	org/apache/http/client/ClientProtocolException
        //   86	96	169	org/apache/http/client/ClientProtocolException
        //   106	113	169	org/apache/http/client/ClientProtocolException
        //   123	139	169	org/apache/http/client/ClientProtocolException
        //   149	160	169	org/apache/http/client/ClientProtocolException
        //   197	201	202	java/lang/Exception
        //   10	16	204	java/io/IOException
        //   26	34	204	java/io/IOException
        //   44	57	204	java/io/IOException
        //   67	76	204	java/io/IOException
        //   86	96	204	java/io/IOException
        //   106	113	204	java/io/IOException
        //   123	139	204	java/io/IOException
        //   149	160	204	java/io/IOException
        //   235	240	241	java/lang/Exception
        //   10	16	243	java/lang/Throwable
        //   26	34	243	java/lang/Throwable
        //   44	57	243	java/lang/Throwable
        //   67	76	243	java/lang/Throwable
        //   86	96	243	java/lang/Throwable
        //   106	113	243	java/lang/Throwable
        //   123	139	243	java/lang/Throwable
        //   149	160	243	java/lang/Throwable
        //   274	279	280	java/lang/Exception
        //   10	16	282	finally
        //   26	34	282	finally
        //   44	57	282	finally
        //   67	76	282	finally
        //   86	96	282	finally
        //   106	113	282	finally
        //   123	139	282	finally
        //   149	160	282	finally
        //   172	181	282	finally
        //   183	193	282	finally
        //   208	217	282	finally
        //   220	230	282	finally
        //   247	256	282	finally
        //   259	269	282	finally
        //   164	168	293	java/lang/Exception
        //   287	291	295	java/lang/Exception
      }
    }
    .start();
  }

  // ERROR //
  public boolean a(String paramString, Map<String, String> paramMap, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: ldc_w 359
    //   15: invokestatic 292	android/net/http/AndroidHttpClient:newInstance	(Ljava/lang/String;)Landroid/net/http/AndroidHttpClient;
    //   18: astore 5
    //   20: aload 5
    //   22: astore 6
    //   24: aload 5
    //   26: astore 7
    //   28: aload 5
    //   30: astore 8
    //   32: aload 5
    //   34: astore 4
    //   36: aload 5
    //   38: invokevirtual 293	android/net/http/AndroidHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   41: iconst_1
    //   42: invokestatic 299	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   45: aload 5
    //   47: astore 6
    //   49: aload 5
    //   51: astore 7
    //   53: aload 5
    //   55: astore 8
    //   57: aload 5
    //   59: astore 4
    //   61: new 301	org/apache/http/client/methods/HttpGet
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 302	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   69: astore_1
    //   70: aload 5
    //   72: astore 6
    //   74: aload 5
    //   76: astore 7
    //   78: aload 5
    //   80: astore 8
    //   82: aload 5
    //   84: astore 4
    //   86: aload_0
    //   87: aload_1
    //   88: invokespecial 166	arb:a	(Lorg/apache/http/client/methods/HttpUriRequest;)V
    //   91: aload 5
    //   93: astore 6
    //   95: aload 5
    //   97: astore 7
    //   99: aload 5
    //   101: astore 8
    //   103: aload 5
    //   105: astore 4
    //   107: aload_1
    //   108: getstatic 26	arb:a	Lorg/apache/http/Header;
    //   111: invokeinterface 306 2 0
    //   116: aload_2
    //   117: ifnull +32 -> 149
    //   120: aload 5
    //   122: astore 6
    //   124: aload 5
    //   126: astore 7
    //   128: aload 5
    //   130: astore 8
    //   132: aload 5
    //   134: astore 4
    //   136: aload_1
    //   137: ldc_w 308
    //   140: aload_2
    //   141: invokestatic 310	arb:a	(Ljava/util/Map;)Ljava/lang/String;
    //   144: invokeinterface 312 3 0
    //   149: aload 5
    //   151: astore 6
    //   153: aload 5
    //   155: astore 7
    //   157: aload 5
    //   159: astore 8
    //   161: aload 5
    //   163: astore 4
    //   165: aload 5
    //   167: aload_1
    //   168: invokevirtual 316	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   171: astore_1
    //   172: aload 5
    //   174: astore 6
    //   176: aload 5
    //   178: astore 7
    //   180: aload 5
    //   182: astore 8
    //   184: aload 5
    //   186: astore 4
    //   188: aload_1
    //   189: invokeinterface 320 1 0
    //   194: astore_2
    //   195: aload_2
    //   196: ifnonnull +15 -> 211
    //   199: aload 5
    //   201: ifnull +8 -> 209
    //   204: aload 5
    //   206: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   209: iconst_0
    //   210: ireturn
    //   211: aload 5
    //   213: astore 6
    //   215: aload 5
    //   217: astore 7
    //   219: aload 5
    //   221: astore 8
    //   223: aload 5
    //   225: astore 4
    //   227: aload_2
    //   228: invokeinterface 331 1 0
    //   233: istore 9
    //   235: iload 9
    //   237: sipush 200
    //   240: if_icmpeq +18 -> 258
    //   243: aload 5
    //   245: ifnull -36 -> 209
    //   248: aload 5
    //   250: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_1
    //   256: iconst_0
    //   257: ireturn
    //   258: aload 5
    //   260: astore 6
    //   262: aload 5
    //   264: astore 8
    //   266: aload 5
    //   268: astore 4
    //   270: aload_1
    //   271: aload_3
    //   272: invokestatic 361	arb:a	(Lorg/apache/http/HttpResponse;Ljava/io/File;)V
    //   275: aload 5
    //   277: ifnull +8 -> 285
    //   280: aload 5
    //   282: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   285: iconst_1
    //   286: ireturn
    //   287: astore_1
    //   288: aload_3
    //   289: ifnull +47 -> 336
    //   292: aload 5
    //   294: astore 6
    //   296: aload 5
    //   298: astore 7
    //   300: aload 5
    //   302: astore 8
    //   304: aload 5
    //   306: astore 4
    //   308: aload_3
    //   309: invokevirtual 176	java/io/File:exists	()Z
    //   312: ifeq +24 -> 336
    //   315: aload 5
    //   317: astore 6
    //   319: aload 5
    //   321: astore 7
    //   323: aload 5
    //   325: astore 8
    //   327: aload 5
    //   329: astore 4
    //   331: aload_3
    //   332: invokevirtual 187	java/io/File:delete	()Z
    //   335: pop
    //   336: aload 5
    //   338: ifnull -129 -> 209
    //   341: aload 5
    //   343: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   346: iconst_0
    //   347: ireturn
    //   348: astore_1
    //   349: iconst_0
    //   350: ireturn
    //   351: astore_1
    //   352: aload 6
    //   354: astore 4
    //   356: ldc 137
    //   358: ldc_w 340
    //   361: aload_1
    //   362: invokestatic 146	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   365: pop
    //   366: aload 6
    //   368: ifnull -159 -> 209
    //   371: aload 6
    //   373: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   376: iconst_0
    //   377: ireturn
    //   378: astore_1
    //   379: iconst_0
    //   380: ireturn
    //   381: astore_1
    //   382: aload 7
    //   384: astore 4
    //   386: ldc 137
    //   388: ldc_w 342
    //   391: aload_1
    //   392: invokestatic 146	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   395: pop
    //   396: aload 7
    //   398: ifnull -189 -> 209
    //   401: aload 7
    //   403: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   406: iconst_0
    //   407: ireturn
    //   408: astore_1
    //   409: iconst_0
    //   410: ireturn
    //   411: astore_1
    //   412: aload 8
    //   414: astore 4
    //   416: ldc 137
    //   418: ldc_w 344
    //   421: aload_1
    //   422: invokestatic 146	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   425: pop
    //   426: aload 8
    //   428: ifnull -219 -> 209
    //   431: aload 8
    //   433: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   436: iconst_0
    //   437: ireturn
    //   438: astore_1
    //   439: iconst_0
    //   440: ireturn
    //   441: astore_1
    //   442: aload 4
    //   444: ifnull +8 -> 452
    //   447: aload 4
    //   449: invokevirtual 326	android/net/http/AndroidHttpClient:close	()V
    //   452: aload_1
    //   453: athrow
    //   454: astore_1
    //   455: iconst_0
    //   456: ireturn
    //   457: astore_1
    //   458: goto -173 -> 285
    //   461: astore_2
    //   462: goto -10 -> 452
    //
    // Exception table:
    //   from	to	target	type
    //   248	253	255	java/lang/Exception
    //   270	275	287	java/io/IOException
    //   341	346	348	java/lang/Exception
    //   12	20	351	org/apache/http/client/ClientProtocolException
    //   36	45	351	org/apache/http/client/ClientProtocolException
    //   61	70	351	org/apache/http/client/ClientProtocolException
    //   86	91	351	org/apache/http/client/ClientProtocolException
    //   107	116	351	org/apache/http/client/ClientProtocolException
    //   136	149	351	org/apache/http/client/ClientProtocolException
    //   165	172	351	org/apache/http/client/ClientProtocolException
    //   188	195	351	org/apache/http/client/ClientProtocolException
    //   227	235	351	org/apache/http/client/ClientProtocolException
    //   270	275	351	org/apache/http/client/ClientProtocolException
    //   308	315	351	org/apache/http/client/ClientProtocolException
    //   331	336	351	org/apache/http/client/ClientProtocolException
    //   371	376	378	java/lang/Exception
    //   12	20	381	java/io/IOException
    //   36	45	381	java/io/IOException
    //   61	70	381	java/io/IOException
    //   86	91	381	java/io/IOException
    //   107	116	381	java/io/IOException
    //   136	149	381	java/io/IOException
    //   165	172	381	java/io/IOException
    //   188	195	381	java/io/IOException
    //   227	235	381	java/io/IOException
    //   308	315	381	java/io/IOException
    //   331	336	381	java/io/IOException
    //   401	406	408	java/lang/Exception
    //   12	20	411	java/lang/Throwable
    //   36	45	411	java/lang/Throwable
    //   61	70	411	java/lang/Throwable
    //   86	91	411	java/lang/Throwable
    //   107	116	411	java/lang/Throwable
    //   136	149	411	java/lang/Throwable
    //   165	172	411	java/lang/Throwable
    //   188	195	411	java/lang/Throwable
    //   227	235	411	java/lang/Throwable
    //   270	275	411	java/lang/Throwable
    //   308	315	411	java/lang/Throwable
    //   331	336	411	java/lang/Throwable
    //   431	436	438	java/lang/Exception
    //   12	20	441	finally
    //   36	45	441	finally
    //   61	70	441	finally
    //   86	91	441	finally
    //   107	116	441	finally
    //   136	149	441	finally
    //   165	172	441	finally
    //   188	195	441	finally
    //   227	235	441	finally
    //   270	275	441	finally
    //   308	315	441	finally
    //   331	336	441	finally
    //   356	366	441	finally
    //   386	396	441	finally
    //   416	426	441	finally
    //   204	209	454	java/lang/Exception
    //   280	285	457	java/lang/Exception
    //   447	452	461	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arb
 * JD-Core Version:    0.6.2
 */