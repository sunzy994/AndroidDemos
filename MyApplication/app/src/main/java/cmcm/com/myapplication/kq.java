package cmcm.com.myapplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

class kq
{
  public static String a(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    return b(paramString1, paramMap, "UTF-8", paramString2, false);
  }

  // ERROR //
  public static String a(String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: ldc 20
    //   6: aload_0
    //   7: invokevirtual 26	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: ldc 8
    //   17: invokestatic 29	kq:a	(Ljava/lang/String;)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   20: astore 4
    //   22: aload_0
    //   23: astore 5
    //   25: aload_1
    //   26: ifnull +70 -> 96
    //   29: aload_1
    //   30: invokestatic 32	kq:a	(Ljava/util/Map;)Ljava/util/List;
    //   33: astore_1
    //   34: aload_0
    //   35: astore 5
    //   37: aload_1
    //   38: ifnull +58 -> 96
    //   41: aload_0
    //   42: astore 5
    //   44: aload_1
    //   45: invokeinterface 38 1 0
    //   50: ifle +46 -> 96
    //   53: aload_1
    //   54: ldc 8
    //   56: invokestatic 44	org/apache/http/client/utils/URLEncodedUtils:format	(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: aload_0
    //   61: ldc 46
    //   63: invokevirtual 50	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   66: ifge +273 -> 339
    //   69: new 52	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   76: aload_0
    //   77: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 46
    //   82: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_0
    //   93: goto +371 -> 464
    //   96: new 66	org/apache/http/client/methods/HttpPost
    //   99: dup
    //   100: aload 5
    //   102: invokespecial 69	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   105: astore 7
    //   107: aload_2
    //   108: ifnull +24 -> 132
    //   111: aload 7
    //   113: astore 6
    //   115: aload 4
    //   117: astore 5
    //   119: aload 7
    //   121: new 71	org/apache/http/entity/ByteArrayEntity
    //   124: dup
    //   125: aload_2
    //   126: invokespecial 74	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   129: invokevirtual 78	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   132: aload 7
    //   134: astore 6
    //   136: aload 4
    //   138: astore 5
    //   140: aload_3
    //   141: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +19 -> 163
    //   147: aload 7
    //   149: astore 6
    //   151: aload 4
    //   153: astore 5
    //   155: aload 7
    //   157: ldc 86
    //   159: aload_3
    //   160: invokevirtual 90	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload 7
    //   165: astore 6
    //   167: aload 4
    //   169: astore 5
    //   171: aload 4
    //   173: aload 7
    //   175: invokeinterface 96 2 0
    //   180: astore_1
    //   181: aload 7
    //   183: astore 6
    //   185: aload 4
    //   187: astore 5
    //   189: aload_1
    //   190: invokeinterface 102 1 0
    //   195: invokeinterface 107 1 0
    //   200: sipush 200
    //   203: if_icmpeq +170 -> 373
    //   206: aload 7
    //   208: astore 6
    //   210: aload 4
    //   212: astore 5
    //   214: new 52	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   221: ldc 109
    //   223: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_1
    //   227: invokeinterface 102 1 0
    //   232: invokeinterface 107 1 0
    //   237: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: astore_0
    //   244: aload 7
    //   246: astore 6
    //   248: aload 4
    //   250: astore 5
    //   252: new 18	java/lang/Exception
    //   255: dup
    //   256: new 52	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   263: ldc 114
    //   265: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_1
    //   269: invokeinterface 102 1 0
    //   274: invokeinterface 107 1 0
    //   279: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokespecial 115	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   288: athrow
    //   289: astore_1
    //   290: aload 7
    //   292: astore_2
    //   293: aload_2
    //   294: astore 6
    //   296: aload 4
    //   298: astore 5
    //   300: getstatic 120	kn:a	Z
    //   303: ifeq +17 -> 320
    //   306: aload_2
    //   307: astore 6
    //   309: aload 4
    //   311: astore 5
    //   313: ldc 122
    //   315: aload_1
    //   316: invokestatic 128	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   319: pop
    //   320: aload_2
    //   321: astore 6
    //   323: aload 4
    //   325: astore 5
    //   327: aload_1
    //   328: invokevirtual 131	java/lang/Exception:printStackTrace	()V
    //   331: aload_2
    //   332: aload 4
    //   334: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   337: aload_0
    //   338: areturn
    //   339: new 52	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   346: aload_0
    //   347: iconst_0
    //   348: aload_0
    //   349: ldc 46
    //   351: invokevirtual 50	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   354: iconst_1
    //   355: iadd
    //   356: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   359: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_1
    //   363: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: astore_0
    //   370: goto +94 -> 464
    //   373: aload 7
    //   375: astore 6
    //   377: aload 4
    //   379: astore 5
    //   381: aload_1
    //   382: invokeinterface 142 1 0
    //   387: ldc 8
    //   389: invokestatic 147	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    //   392: astore_0
    //   393: aload 7
    //   395: aload 4
    //   397: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   400: aload_0
    //   401: areturn
    //   402: astore_0
    //   403: aconst_null
    //   404: astore 6
    //   406: aconst_null
    //   407: astore 4
    //   409: aload 6
    //   411: aload 4
    //   413: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   416: aload_0
    //   417: athrow
    //   418: astore_0
    //   419: aconst_null
    //   420: astore 6
    //   422: goto -13 -> 409
    //   425: astore_0
    //   426: aload 5
    //   428: astore 4
    //   430: goto -21 -> 409
    //   433: astore_1
    //   434: aconst_null
    //   435: astore_2
    //   436: aconst_null
    //   437: astore 4
    //   439: ldc 20
    //   441: astore_0
    //   442: goto -149 -> 293
    //   445: astore_1
    //   446: aconst_null
    //   447: astore_2
    //   448: ldc 20
    //   450: astore_0
    //   451: goto -158 -> 293
    //   454: astore_1
    //   455: ldc 20
    //   457: astore_0
    //   458: aload 7
    //   460: astore_2
    //   461: goto -168 -> 293
    //   464: aload_0
    //   465: astore 5
    //   467: goto -371 -> 96
    //
    // Exception table:
    //   from	to	target	type
    //   252	289	289	java/lang/Exception
    //   15	22	402	finally
    //   29	34	418	finally
    //   44	93	418	finally
    //   96	107	418	finally
    //   339	370	418	finally
    //   119	132	425	finally
    //   140	147	425	finally
    //   155	163	425	finally
    //   171	181	425	finally
    //   189	206	425	finally
    //   214	244	425	finally
    //   252	289	425	finally
    //   300	306	425	finally
    //   313	320	425	finally
    //   327	331	425	finally
    //   381	393	425	finally
    //   15	22	433	java/lang/Exception
    //   29	34	445	java/lang/Exception
    //   44	93	445	java/lang/Exception
    //   96	107	445	java/lang/Exception
    //   339	370	445	java/lang/Exception
    //   119	132	454	java/lang/Exception
    //   140	147	454	java/lang/Exception
    //   155	163	454	java/lang/Exception
    //   171	181	454	java/lang/Exception
    //   189	206	454	java/lang/Exception
    //   214	244	454	java/lang/Exception
    //   381	393	454	java/lang/Exception
  }

  private static List<NameValuePair> a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
      return null;
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Entry localEntry = (Entry)paramMap.next();
      localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }

  // ERROR //
  public static HttpResponse a(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnull +21 -> 25
    //   7: ldc 20
    //   9: aload_0
    //   10: invokevirtual 26	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +12 -> 25
    //   16: aload_0
    //   17: ldc 193
    //   19: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   22: ifeq +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: aload_2
    //   28: iload 4
    //   30: invokestatic 200	kq:a	(Ljava/lang/String;Z)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   33: astore_2
    //   34: aload_0
    //   35: astore 5
    //   37: aload_1
    //   38: invokeinterface 151 1 0
    //   43: ifle +142 -> 185
    //   46: new 52	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   53: astore 5
    //   55: aload_1
    //   56: invokeinterface 158 1 0
    //   61: invokeinterface 164 1 0
    //   66: astore 7
    //   68: iconst_1
    //   69: istore 9
    //   71: aload 7
    //   73: invokeinterface 170 1 0
    //   78: ifeq +86 -> 164
    //   81: aload 7
    //   83: invokeinterface 174 1 0
    //   88: checkcast 176	java/util/Map$Entry
    //   91: astore 8
    //   93: iload 9
    //   95: ifeq +227 -> 322
    //   98: ldc 46
    //   100: astore_1
    //   101: aload 5
    //   103: aload_1
    //   104: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 5
    //   110: new 52	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   117: aload 8
    //   119: invokeinterface 181 1 0
    //   124: checkcast 22	java/lang/String
    //   127: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 202
    //   132: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 5
    //   144: aload 8
    //   146: invokeinterface 184 1 0
    //   151: checkcast 22	java/lang/String
    //   154: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: iconst_0
    //   159: istore 9
    //   161: goto -90 -> 71
    //   164: new 52	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   171: aload_0
    //   172: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 5
    //   177: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore 5
    //   185: new 207	org/apache/http/client/methods/HttpGet
    //   188: dup
    //   189: aload 5
    //   191: invokespecial 208	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   194: astore_0
    //   195: aload_0
    //   196: astore 5
    //   198: aload_2
    //   199: astore_1
    //   200: aload_3
    //   201: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifne +15 -> 219
    //   207: aload_0
    //   208: astore 5
    //   210: aload_2
    //   211: astore_1
    //   212: aload_0
    //   213: ldc 86
    //   215: aload_3
    //   216: invokevirtual 209	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: astore 5
    //   222: aload_2
    //   223: astore_1
    //   224: aload_2
    //   225: aload_0
    //   226: invokeinterface 96 2 0
    //   231: astore_3
    //   232: aload_0
    //   233: aload_2
    //   234: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   237: aload_3
    //   238: areturn
    //   239: astore_3
    //   240: aconst_null
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_2
    //   244: aload_0
    //   245: astore 5
    //   247: aload_2
    //   248: astore_1
    //   249: getstatic 120	kn:a	Z
    //   252: ifeq +15 -> 267
    //   255: aload_0
    //   256: astore 5
    //   258: aload_2
    //   259: astore_1
    //   260: ldc 122
    //   262: aload_3
    //   263: invokestatic 128	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   266: pop
    //   267: aload_0
    //   268: astore 5
    //   270: aload_2
    //   271: astore_1
    //   272: aload_3
    //   273: invokevirtual 131	java/lang/Exception:printStackTrace	()V
    //   276: aload_0
    //   277: aload_2
    //   278: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   281: aconst_null
    //   282: areturn
    //   283: astore_0
    //   284: aconst_null
    //   285: astore_1
    //   286: aload 6
    //   288: astore_3
    //   289: aload_3
    //   290: aload_1
    //   291: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   294: aload_0
    //   295: athrow
    //   296: astore_0
    //   297: aload 6
    //   299: astore_3
    //   300: aload_2
    //   301: astore_1
    //   302: goto -13 -> 289
    //   305: astore_0
    //   306: aload 5
    //   308: astore_3
    //   309: goto -20 -> 289
    //   312: astore_3
    //   313: aconst_null
    //   314: astore_0
    //   315: goto -71 -> 244
    //   318: astore_3
    //   319: goto -75 -> 244
    //   322: ldc 211
    //   324: astore_1
    //   325: goto -224 -> 101
    //
    // Exception table:
    //   from	to	target	type
    //   27	34	239	java/lang/Exception
    //   27	34	283	finally
    //   37	68	296	finally
    //   71	93	296	finally
    //   101	158	296	finally
    //   164	185	296	finally
    //   185	195	296	finally
    //   200	207	305	finally
    //   212	219	305	finally
    //   224	232	305	finally
    //   249	255	305	finally
    //   260	267	305	finally
    //   272	276	305	finally
    //   37	68	312	java/lang/Exception
    //   71	93	312	java/lang/Exception
    //   101	158	312	java/lang/Exception
    //   164	185	312	java/lang/Exception
    //   185	195	312	java/lang/Exception
    //   200	207	318	java/lang/Exception
    //   212	219	318	java/lang/Exception
    //   224	232	318	java/lang/Exception
  }

  private static DefaultHttpClient a(String paramString)
  {
    return a(paramString, false);
  }

  private static DefaultHttpClient a(String paramString, boolean paramBoolean)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 9216);
    HttpClientParams.setRedirecting(localBasicHttpParams, true);
    if (paramBoolean);
    for (paramString = "haloappsflyer"; ; paramString = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6")
    {
      HttpProtocolParams.setUserAgent(localBasicHttpParams, paramString);
      return new DefaultHttpClient(localBasicHttpParams);
    }
  }

  private static void a(HttpRequestBase paramHttpRequestBase, HttpClient paramHttpClient)
  {
    if (paramHttpRequestBase != null);
    try
    {
      paramHttpRequestBase.abort();
      if (paramHttpClient == null);
    }
    catch (Exception paramHttpRequestBase)
    {
      try
      {
        paramHttpClient.getConnectionManager().shutdown();
        return;
        paramHttpRequestBase = paramHttpRequestBase;
      }
      catch (Exception paramHttpRequestBase)
      {
      }
    }
  }

  // ERROR //
  public static String b(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 9
    //   9: aload_0
    //   10: ifnull +21 -> 31
    //   13: ldc 20
    //   15: aload_0
    //   16: invokevirtual 26	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifne +12 -> 31
    //   22: aload_0
    //   23: ldc 193
    //   25: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   28: ifeq +5 -> 33
    //   31: aconst_null
    //   32: areturn
    //   33: aload_2
    //   34: iload 4
    //   36: invokestatic 200	kq:a	(Ljava/lang/String;Z)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   39: astore 5
    //   41: aload_0
    //   42: astore 8
    //   44: aload 10
    //   46: astore 7
    //   48: aload 5
    //   50: astore 6
    //   52: aload_1
    //   53: invokeinterface 151 1 0
    //   58: ifle +172 -> 230
    //   61: aload 10
    //   63: astore 7
    //   65: aload 5
    //   67: astore 6
    //   69: new 52	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   76: astore 8
    //   78: aload 10
    //   80: astore 7
    //   82: aload 5
    //   84: astore 6
    //   86: aload_1
    //   87: monitorenter
    //   88: aload_1
    //   89: invokeinterface 158 1 0
    //   94: invokeinterface 164 1 0
    //   99: astore 7
    //   101: iconst_1
    //   102: istore 12
    //   104: aload 7
    //   106: invokeinterface 170 1 0
    //   111: ifeq +88 -> 199
    //   114: aload 7
    //   116: invokeinterface 174 1 0
    //   121: checkcast 176	java/util/Map$Entry
    //   124: astore 11
    //   126: iload 12
    //   128: ifeq +343 -> 471
    //   131: ldc 46
    //   133: astore 6
    //   135: aload 8
    //   137: aload 6
    //   139: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 8
    //   145: new 52	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   152: aload 11
    //   154: invokeinterface 181 1 0
    //   159: checkcast 22	java/lang/String
    //   162: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 202
    //   167: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 8
    //   179: aload 11
    //   181: invokeinterface 184 1 0
    //   186: checkcast 22	java/lang/String
    //   189: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: iconst_0
    //   194: istore 12
    //   196: goto -92 -> 104
    //   199: aload_1
    //   200: monitorexit
    //   201: aload 10
    //   203: astore 7
    //   205: aload 5
    //   207: astore 6
    //   209: new 52	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   216: aload_0
    //   217: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 8
    //   222: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore 8
    //   230: aload 10
    //   232: astore 7
    //   234: aload 5
    //   236: astore 6
    //   238: new 207	org/apache/http/client/methods/HttpGet
    //   241: dup
    //   242: aload 8
    //   244: invokespecial 208	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   247: astore_0
    //   248: aload_3
    //   249: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifne +10 -> 262
    //   255: aload_0
    //   256: ldc 86
    //   258: aload_3
    //   259: invokevirtual 209	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 5
    //   264: aload_0
    //   265: invokeinterface 96 2 0
    //   270: astore_3
    //   271: aload_3
    //   272: invokeinterface 102 1 0
    //   277: invokeinterface 107 1 0
    //   282: sipush 200
    //   285: if_icmpeq +180 -> 465
    //   288: new 52	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   295: ldc 109
    //   297: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_3
    //   301: invokeinterface 102 1 0
    //   306: invokeinterface 107 1 0
    //   311: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: astore_1
    //   318: aload_3
    //   319: invokeinterface 142 1 0
    //   324: aload_2
    //   325: invokestatic 147	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    //   328: astore_2
    //   329: aload_0
    //   330: aload 5
    //   332: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   335: aload_2
    //   336: areturn
    //   337: astore_0
    //   338: aload_1
    //   339: monitorexit
    //   340: aload 10
    //   342: astore 7
    //   344: aload 5
    //   346: astore 6
    //   348: aload_0
    //   349: athrow
    //   350: astore_1
    //   351: ldc 20
    //   353: astore_0
    //   354: aload 9
    //   356: astore_2
    //   357: aload_2
    //   358: astore 7
    //   360: aload 5
    //   362: astore 6
    //   364: getstatic 120	kn:a	Z
    //   367: ifeq +17 -> 384
    //   370: aload_2
    //   371: astore 7
    //   373: aload 5
    //   375: astore 6
    //   377: ldc 122
    //   379: aload_1
    //   380: invokestatic 128	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   383: pop
    //   384: aload_2
    //   385: astore 7
    //   387: aload 5
    //   389: astore 6
    //   391: aload_1
    //   392: invokevirtual 131	java/lang/Exception:printStackTrace	()V
    //   395: aload_2
    //   396: aload 5
    //   398: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   401: aload_0
    //   402: areturn
    //   403: astore_0
    //   404: aconst_null
    //   405: astore 5
    //   407: aload 7
    //   409: aload 5
    //   411: invokestatic 134	kq:a	(Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/client/HttpClient;)V
    //   414: aload_0
    //   415: athrow
    //   416: astore_0
    //   417: aload 6
    //   419: astore 5
    //   421: goto -14 -> 407
    //   424: astore_1
    //   425: aload_0
    //   426: astore 7
    //   428: aload_1
    //   429: astore_0
    //   430: goto -23 -> 407
    //   433: astore_1
    //   434: aconst_null
    //   435: astore 5
    //   437: ldc 20
    //   439: astore_0
    //   440: aload 9
    //   442: astore_2
    //   443: goto -86 -> 357
    //   446: astore_1
    //   447: aload_0
    //   448: astore_2
    //   449: ldc 20
    //   451: astore_0
    //   452: goto -95 -> 357
    //   455: astore_3
    //   456: aload_0
    //   457: astore_2
    //   458: aload_1
    //   459: astore_0
    //   460: aload_3
    //   461: astore_1
    //   462: goto -105 -> 357
    //   465: ldc 20
    //   467: astore_1
    //   468: goto -150 -> 318
    //   471: ldc 211
    //   473: astore 6
    //   475: goto -340 -> 135
    //
    // Exception table:
    //   from	to	target	type
    //   88	101	337	finally
    //   104	126	337	finally
    //   135	193	337	finally
    //   199	201	337	finally
    //   338	340	337	finally
    //   52	61	350	java/lang/Exception
    //   69	78	350	java/lang/Exception
    //   86	88	350	java/lang/Exception
    //   209	230	350	java/lang/Exception
    //   238	248	350	java/lang/Exception
    //   348	350	350	java/lang/Exception
    //   33	41	403	finally
    //   52	61	416	finally
    //   69	78	416	finally
    //   86	88	416	finally
    //   209	230	416	finally
    //   238	248	416	finally
    //   348	350	416	finally
    //   364	370	416	finally
    //   377	384	416	finally
    //   391	395	416	finally
    //   248	262	424	finally
    //   262	318	424	finally
    //   318	329	424	finally
    //   33	41	433	java/lang/Exception
    //   248	262	446	java/lang/Exception
    //   262	318	446	java/lang/Exception
    //   318	329	455	java/lang/Exception
  }

  public static HttpResponse b(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    return a(paramString1, paramMap, "UTF-8", paramString2, true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     kq
 * JD-Core Version:    0.6.2
 */