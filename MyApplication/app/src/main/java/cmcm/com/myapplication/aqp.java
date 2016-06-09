package cmcm.com.myapplication;

import android.net.http.AndroidHttpClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class aqp
{
  static final HashMap<String, ArrayList<String>> a = new HashMap();
  static final String[] b = { "220.181.141.113", "220.181.141.114", "119.188.2.235", "119.188.2.236" };
  static int c = -1;

  public static String a(String paramString, AndroidHttpClient arg1)
  {
    ArrayList localArrayList2 = (ArrayList)a.get(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null);
    try
    {
      ??? = a(b[((c + 1) % b.length)], paramString, ???);
      ??? = ???.substring(???.indexOf(":") + 1).split(",");
      localArrayList1 = new ArrayList();
      Collections.addAll(localArrayList1, ???);
      synchronized (a)
      {
        a.put(paramString, localArrayList1);
        paramString = (String)localArrayList1.get(new Random().nextInt(localArrayList1.size()));
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      c += 1;
    }
    return null;
  }

  // ERROR //
  private static String a(String paramString1, String paramString2, AndroidHttpClient paramAndroidHttpClient)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 90	org/apache/http/client/methods/HttpGet
    //   5: dup
    //   6: new 92	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   13: ldc 95
    //   15: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 101
    //   24: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 108	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 110
    //   39: aload_0
    //   40: invokevirtual 114	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 4
    //   45: ldc 116
    //   47: aload_1
    //   48: invokevirtual 114	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload 4
    //   53: ldc 118
    //   55: ldc 120
    //   57: invokevirtual 114	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload 4
    //   62: ldc 122
    //   64: ldc 124
    //   66: invokevirtual 114	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload 4
    //   71: ldc 126
    //   73: ldc 128
    //   75: invokevirtual 114	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: new 130	java/io/BufferedReader
    //   81: dup
    //   82: new 132	java/io/InputStreamReader
    //   85: dup
    //   86: aload_2
    //   87: aload 4
    //   89: invokevirtual 138	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   92: invokeinterface 144 1 0
    //   97: invokeinterface 150 1 0
    //   102: invokespecial 153	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   105: invokespecial 156	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   108: astore_0
    //   109: new 92	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   116: astore_1
    //   117: aload_0
    //   118: invokevirtual 159	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull +27 -> 150
    //   126: aload_1
    //   127: aload_2
    //   128: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: goto -15 -> 117
    //   135: astore_1
    //   136: aload_3
    //   137: astore_1
    //   138: aload_0
    //   139: ifnull +9 -> 148
    //   142: aload_0
    //   143: invokestatic 164	arf:a	(Ljava/io/Closeable;)V
    //   146: aload_3
    //   147: astore_1
    //   148: aload_1
    //   149: areturn
    //   150: aload_1
    //   151: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore_2
    //   155: aload_2
    //   156: astore_1
    //   157: aload_0
    //   158: ifnull -10 -> 148
    //   161: aload_0
    //   162: invokestatic 164	arf:a	(Ljava/io/Closeable;)V
    //   165: aload_2
    //   166: areturn
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_0
    //   171: astore_1
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokestatic 164	arf:a	(Ljava/io/Closeable;)V
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_0
    //   184: astore_2
    //   185: goto -13 -> 172
    //   188: astore_0
    //   189: aconst_null
    //   190: astore_0
    //   191: goto -55 -> 136
    //
    // Exception table:
    //   from	to	target	type
    //   109	117	135	java/lang/Exception
    //   117	122	135	java/lang/Exception
    //   126	132	135	java/lang/Exception
    //   150	155	135	java/lang/Exception
    //   2	109	167	finally
    //   109	117	182	finally
    //   117	122	182	finally
    //   126	132	182	finally
    //   150	155	182	finally
    //   2	109	188	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqp
 * JD-Core Version:    0.6.2
 */