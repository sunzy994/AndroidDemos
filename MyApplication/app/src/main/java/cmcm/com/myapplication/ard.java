package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ard
{
  private static String a = "UA-QiiGame";

  public static arq a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, 0, 0, Collections.EMPTY_MAP);
  }

  public static arq a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramString, paramInt1, paramInt2, Collections.EMPTY_MAP);
  }

  public static arq a(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    paramContext = new arb(paramContext).a(paramString, null);
    if (!TextUtils.isEmpty(paramContext))
      return new arq(arr.a, paramContext, 200);
    return new arq(arr.b, "");
  }

  public static arq a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    return a(paramContext, paramString, paramMap, 0, 0);
  }

  public static arq a(Context paramContext, String paramString, Map<String, String> paramMap, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramString, paramMap, paramInt1, paramInt2, Collections.EMPTY_MAP);
  }

  // ERROR //
  public static arq a(Context paramContext, String paramString, Map<String, String> paramMap1, int paramInt1, int paramInt2, Map<String, String> paramMap2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_1
    //   10: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +17 -> 30
    //   16: aload_2
    //   17: ifnull +13 -> 30
    //   20: aload_2
    //   21: invokeinterface 78 1 0
    //   26: iconst_1
    //   27: if_icmpge +18 -> 45
    //   30: new 41	arq
    //   33: dup
    //   34: getstatic 52	arr:b	Larr;
    //   37: ldc 80
    //   39: invokespecial 57	arq:<init>	(Larr;Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload_1
    //   44: areturn
    //   45: aload_0
    //   46: aload_1
    //   47: iload_3
    //   48: iload 4
    //   50: aload 5
    //   52: invokestatic 83	ard:b	(Landroid/content/Context;Ljava/lang/String;IILjava/util/Map;)Ljava/net/URLConnection;
    //   55: checkcast 85	java/net/HttpURLConnection
    //   58: astore_0
    //   59: aload_0
    //   60: ldc 87
    //   62: invokevirtual 91	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: iconst_1
    //   67: invokevirtual 95	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   70: aload_0
    //   71: invokevirtual 99	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   74: aload_2
    //   75: invokestatic 102	ard:a	(Ljava/util/Map;)Ljava/lang/String;
    //   78: invokevirtual 108	java/lang/String:getBytes	()[B
    //   81: invokevirtual 114	java/io/OutputStream:write	([B)V
    //   84: aload_0
    //   85: invokevirtual 117	java/net/HttpURLConnection:getResponseCode	()I
    //   88: istore_3
    //   89: aload 8
    //   91: astore_2
    //   92: iload_3
    //   93: sipush 400
    //   96: if_icmplt +58 -> 154
    //   99: aload_0
    //   100: invokevirtual 121	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   103: astore 5
    //   105: aload 5
    //   107: astore_1
    //   108: aload 5
    //   110: astore_2
    //   111: ldc 123
    //   113: new 125	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   120: ldc 129
    //   122: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: invokestatic 138	aqx:b	(Ljava/io/InputStream;)Ljava/lang/String;
    //   130: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 148	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   139: pop
    //   140: aload 5
    //   142: astore_1
    //   143: aload 5
    //   145: astore_2
    //   146: aload 5
    //   148: invokestatic 153	arf:a	(Ljava/io/Closeable;)V
    //   151: aload 5
    //   153: astore_2
    //   154: aload_2
    //   155: astore_1
    //   156: aload_0
    //   157: invokevirtual 156	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   160: astore 5
    //   162: aload 5
    //   164: astore_1
    //   165: aload 5
    //   167: astore_2
    //   168: aload 5
    //   170: invokestatic 158	aqx:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   173: astore 6
    //   175: aload 5
    //   177: astore_1
    //   178: aload 5
    //   180: astore_2
    //   181: new 41	arq
    //   184: dup
    //   185: getstatic 46	arr:a	Larr;
    //   188: aload 6
    //   190: iload_3
    //   191: invokespecial 49	arq:<init>	(Larr;Ljava/lang/String;I)V
    //   194: astore 6
    //   196: aload 5
    //   198: ifnull +8 -> 206
    //   201: aload 5
    //   203: invokestatic 153	arf:a	(Ljava/io/Closeable;)V
    //   206: aload_0
    //   207: ifnull +7 -> 214
    //   210: aload_0
    //   211: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   214: aload 6
    //   216: areturn
    //   217: astore_1
    //   218: iconst_0
    //   219: istore_3
    //   220: goto -131 -> 89
    //   223: astore_2
    //   224: aconst_null
    //   225: astore_1
    //   226: aload 6
    //   228: astore_0
    //   229: new 41	arq
    //   232: dup
    //   233: getstatic 52	arr:b	Larr;
    //   236: new 125	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   243: aload_2
    //   244: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   247: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 166
    //   252: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: invokevirtual 169	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   259: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aload_0
    //   266: invokevirtual 117	java/net/HttpURLConnection:getResponseCode	()I
    //   269: invokespecial 49	arq:<init>	(Larr;Ljava/lang/String;I)V
    //   272: astore 5
    //   274: aload_1
    //   275: ifnull +7 -> 282
    //   278: aload_1
    //   279: invokestatic 153	arf:a	(Ljava/io/Closeable;)V
    //   282: aload 5
    //   284: astore_1
    //   285: aload_0
    //   286: ifnull -243 -> 43
    //   289: aload_0
    //   290: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   293: aload 5
    //   295: areturn
    //   296: astore 5
    //   298: new 41	arq
    //   301: dup
    //   302: getstatic 52	arr:b	Larr;
    //   305: aload_2
    //   306: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   309: invokespecial 57	arq:<init>	(Larr;Ljava/lang/String;)V
    //   312: astore_2
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokestatic 153	arf:a	(Ljava/io/Closeable;)V
    //   321: aload_2
    //   322: astore_1
    //   323: aload_0
    //   324: ifnull -281 -> 43
    //   327: aload_0
    //   328: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   331: aload_2
    //   332: areturn
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_1
    //   336: aload 7
    //   338: astore_0
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokestatic 153	arf:a	(Ljava/io/Closeable;)V
    //   347: aload_0
    //   348: ifnull +7 -> 355
    //   351: aload_0
    //   352: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   355: aload_2
    //   356: athrow
    //   357: astore_2
    //   358: aconst_null
    //   359: astore_1
    //   360: goto -21 -> 339
    //   363: astore_2
    //   364: goto -25 -> 339
    //   367: astore_2
    //   368: goto -29 -> 339
    //   371: astore_2
    //   372: aconst_null
    //   373: astore_1
    //   374: goto -145 -> 229
    //   377: astore 5
    //   379: aload_2
    //   380: astore_1
    //   381: aload 5
    //   383: astore_2
    //   384: goto -155 -> 229
    //
    // Exception table:
    //   from	to	target	type
    //   84	89	217	java/lang/Throwable
    //   45	59	223	java/lang/Exception
    //   229	274	296	java/lang/Exception
    //   45	59	333	finally
    //   59	84	357	finally
    //   84	89	357	finally
    //   99	105	357	finally
    //   111	140	363	finally
    //   146	151	363	finally
    //   156	162	363	finally
    //   168	175	363	finally
    //   181	196	363	finally
    //   229	274	367	finally
    //   298	313	367	finally
    //   59	84	371	java/lang/Exception
    //   84	89	371	java/lang/Exception
    //   99	105	371	java/lang/Exception
    //   111	140	377	java/lang/Exception
    //   146	151	377	java/lang/Exception
    //   156	162	377	java/lang/Exception
    //   168	175	377	java/lang/Exception
    //   181	196	377	java/lang/Exception
  }

  public static String a()
  {
    return "vLj";
  }

  private static String a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Entry localEntry = (Entry)paramMap.next();
      localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey())).append("=").append(URLEncoder.encode((String)localEntry.getValue()));
      if (paramMap.hasNext())
        localStringBuilder.append("&");
    }
    return localStringBuilder.toString();
  }

  public static URLConnection a(Context paramContext, URL paramURL, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (arl.a(arl.d(paramContext)))
    {
      paramContext = android.net.Proxy.getDefaultHost();
      int i = android.net.Proxy.getDefaultPort();
      localObject1 = localObject2;
      if (-1 != i)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramContext))
          localObject1 = paramURL.openConnection(new java.net.Proxy(Proxy.Type.valueOf(paramURL.getProtocol().toUpperCase()), new InetSocketAddress(paramContext, i)));
      }
    }
    paramContext = (Context)localObject1;
    if (localObject1 == null)
      paramContext = paramURL.openConnection();
    a(paramContext, paramInt1, paramInt2, paramMap);
    return paramContext;
  }

  // ERROR //
  @android.annotation.TargetApi(17)
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 273	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 17
    //   5: if_icmplt +67 -> 72
    //   8: aload_0
    //   9: invokestatic 279	android/webkit/WebSettings:getDefaultUserAgent	(Landroid/content/Context;)Ljava/lang/String;
    //   12: putstatic 12	ard:a	Ljava/lang/String;
    //   15: iconst_1
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +15 -> 33
    //   21: ldc_w 281
    //   24: getstatic 12	ard:a	Ljava/lang/String;
    //   27: invokestatic 287	java/lang/System:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: putstatic 12	ard:a	Ljava/lang/String;
    //   33: ldc 123
    //   35: new 125	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 289
    //   45: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 12	ard:a	Ljava/lang/String;
    //   51: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 294	asp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: return
    //   61: astore_0
    //   62: ldc 123
    //   64: ldc_w 296
    //   67: aload_0
    //   68: invokestatic 299	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   71: pop
    //   72: iconst_0
    //   73: istore_1
    //   74: goto -57 -> 17
    //   77: astore_0
    //   78: ldc 123
    //   80: ldc_w 301
    //   83: aload_0
    //   84: invokestatic 299	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   87: pop
    //   88: goto -55 -> 33
    //
    // Exception table:
    //   from	to	target	type
    //   8	15	61	java/lang/Throwable
    //   21	33	77	java/lang/Throwable
  }

  public static void a(URLConnection paramURLConnection, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    if (paramInt1 >= 0)
      paramURLConnection.setConnectTimeout(paramInt1);
    if (paramInt2 >= 0)
      paramURLConnection.setReadTimeout(paramInt2);
    if (!paramMap.containsKey("User-Agent"))
      paramURLConnection.setRequestProperty("User-Agent", a);
    if (paramMap.isEmpty());
    label217: 
    while (true)
    {
      return;
      Object localObject = (String)paramMap.remove("ChunkedStreamingMode");
      if (localObject != null)
        ((HttpURLConnection)paramURLConnection).setChunkedStreamingMode(Integer.parseInt((String)localObject));
      localObject = (String)paramMap.remove("UseCaches");
      if (localObject != null)
        paramURLConnection.setUseCaches(Boolean.parseBoolean((String)localObject));
      localObject = (String)paramMap.remove("InstanceFollowRedirects");
      if (localObject != null)
        ((HttpURLConnection)paramURLConnection).setInstanceFollowRedirects(Boolean.parseBoolean((String)localObject));
      while (true)
      {
        if (paramMap.isEmpty())
          break label217;
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Entry)paramMap.next();
          paramURLConnection.setRequestProperty((String)((Entry)localObject).getKey(), (String)((Entry)localObject).getValue());
        }
        break;
        ((HttpURLConnection)paramURLConnection).setInstanceFollowRedirects(true);
      }
    }
  }

  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramString1, paramString2, paramInt1, paramInt2, null);
  }

  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, are paramare)
  {
    return new arb(paramContext).a(paramString1, null, new File(paramString2));
  }

  public static String b(Context paramContext)
  {
    return a;
  }

  public static URLConnection b(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    return a(paramContext, new URL(paramString), paramInt1, paramInt2, paramMap);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ard
 * JD-Core Version:    0.6.2
 */