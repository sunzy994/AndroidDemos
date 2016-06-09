package cmcm.com.myapplication.com.facebook.ads.internal.thirdparty.http;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.ads.internal.util.h;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class a
{
  private static int[] g = new int[20];
  private static final String h = a.class.getSimpleName();
  protected final p a;
  protected final d b;
  protected String c = "";
  protected q d = new g();
  protected int e = 2000;
  protected int f = 8000;
  private int i = 3;
  private Map<String, String> j = new TreeMap();
  private boolean k;

  static
  {
    c();
    if (Build.VERSION.SDK_INT > 8)
      a();
  }

  public a()
  {
    this("");
  }

  public a(Context paramContext)
  {
    this(paramContext, null);
  }

  public a(Context paramContext, com.facebook.ads.internal.e parame)
  {
    this();
    a("user-agent", h.a(paramContext, parame) + " [" + "FBAN/AudienceNetworkForAndroid;" + "FBSN/" + "Android" + ";" + "FBSV/" + com.facebook.ads.internal.dto.f.a + ";" + "FBAB/" + com.facebook.ads.internal.dto.f.d + ";" + "FBAV/" + com.facebook.ads.internal.dto.f.f + ";" + "FBBV/" + com.facebook.ads.internal.dto.f.g + ";" + "FBLC/" + Locale.getDefault().toString() + "]");
    if (com.facebook.ads.internal.util.g.a())
      com.facebook.ads.internal.util.g.b();
  }

  public a(d paramd, String paramString)
  {
    this(paramd, paramString, new f()
    {
    });
  }

  public a(d paramd, String paramString, p paramp)
  {
    this.c = paramString;
    this.a = paramp;
    this.b = paramd;
  }

  public a(String paramString)
  {
    this(new e(), paramString);
  }

  public static void a()
  {
    if (CookieHandler.getDefault() == null)
      CookieHandler.setDefault(new CookieManager());
  }

  private static void c()
  {
    if (Build.VERSION.SDK_INT < 8)
      System.setProperty("http.keepAlive", "false");
  }

  private void c(HttpURLConnection paramHttpURLConnection)
  {
    Iterator localIterator = this.j.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpURLConnection.setRequestProperty(str, (String)this.j.get(str));
    }
  }

  protected int a(int paramInt)
  {
    return g[(paramInt + 2)] * 1000;
  }

  // ERROR //
  protected int a(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 155	com/facebook/ads/internal/thirdparty/http/a:a	Lcom/facebook/ads/internal/thirdparty/http/p;
    //   6: aload_1
    //   7: invokeinterface 227 2 0
    //   12: astore 4
    //   14: aload 4
    //   16: ifnull +18 -> 34
    //   19: aload 4
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 155	com/facebook/ads/internal/thirdparty/http/a:a	Lcom/facebook/ads/internal/thirdparty/http/p;
    //   26: aload 4
    //   28: aload_2
    //   29: invokeinterface 230 3 0
    //   34: aload 4
    //   36: astore_3
    //   37: aload_1
    //   38: invokevirtual 234	java/net/HttpURLConnection:getResponseCode	()I
    //   41: istore 5
    //   43: aload 4
    //   45: ifnull +8 -> 53
    //   48: aload 4
    //   50: invokevirtual 239	java/io/OutputStream:close	()V
    //   53: iload 5
    //   55: ireturn
    //   56: astore_1
    //   57: aload_3
    //   58: ifnull +7 -> 65
    //   61: aload_3
    //   62: invokevirtual 239	java/io/OutputStream:close	()V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: iload 5
    //   70: ireturn
    //   71: astore_2
    //   72: goto -7 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   2	14	56	finally
    //   22	34	56	finally
    //   37	43	56	finally
    //   48	53	67	java/lang/Exception
    //   61	65	71	java/lang/Exception
  }

  public a a(String paramString1, String paramString2)
  {
    this.j.put(paramString1, paramString2);
    return this;
  }

  public n a(l paraml)
  {
    int m = 0;
    long l2 = System.currentTimeMillis();
    while (m < this.i)
    {
      long l1 = l2;
      try
      {
        c(a(m));
        l1 = l2;
        if (this.d.a())
        {
          l1 = l2;
          this.d.a(m + 1 + "of" + this.i + ", trying " + paraml.a());
        }
        l1 = l2;
        l2 = System.currentTimeMillis();
        l1 = l2;
        n localn = a(paraml.a(), paraml.b(), paraml.c(), paraml.d());
        l1 = l2;
        if (localn != null)
          return localn;
      }
      catch (m localm)
      {
        if ((a(localm, l1)) && (m < this.i - 1));
        while (true)
        {
          m += 1;
          l2 = l1;
          break;
          if ((this.a.a(localm)) && (m < this.i - 1))
            try
            {
              Thread.sleep(this.e);
            }
            catch (InterruptedException paraml)
            {
              throw localm;
            }
        }
        throw localm;
      }
    }
    return null;
  }

  // ERROR //
  protected n a(String paramString1, j paramj, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: iconst_0
    //   5: putfield 295	com/facebook/ads/internal/thirdparty/http/a:k	Z
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 298	com/facebook/ads/internal/thirdparty/http/a:a	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   13: astore 5
    //   15: aload_0
    //   16: aload 5
    //   18: aload_2
    //   19: aload_3
    //   20: invokevirtual 301	com/facebook/ads/internal/thirdparty/http/a:a	(Ljava/net/HttpURLConnection;Lcom/facebook/ads/internal/thirdparty/http/j;Ljava/lang/String;)V
    //   23: aload_0
    //   24: aload 5
    //   26: invokespecial 303	com/facebook/ads/internal/thirdparty/http/a:c	(Ljava/net/HttpURLConnection;)V
    //   29: aload_0
    //   30: getfield 142	com/facebook/ads/internal/thirdparty/http/a:d	Lcom/facebook/ads/internal/thirdparty/http/q;
    //   33: invokeinterface 260 1 0
    //   38: ifeq +16 -> 54
    //   41: aload_0
    //   42: getfield 142	com/facebook/ads/internal/thirdparty/http/a:d	Lcom/facebook/ads/internal/thirdparty/http/q;
    //   45: aload 5
    //   47: aload 4
    //   49: invokeinterface 306 3 0
    //   54: aload 5
    //   56: invokevirtual 309	java/net/HttpURLConnection:connect	()V
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 295	com/facebook/ads/internal/thirdparty/http/a:k	Z
    //   64: aload 5
    //   66: invokevirtual 312	java/net/HttpURLConnection:getDoOutput	()Z
    //   69: ifeq +17 -> 86
    //   72: aload 4
    //   74: ifnull +12 -> 86
    //   77: aload_0
    //   78: aload 5
    //   80: aload 4
    //   82: invokevirtual 314	com/facebook/ads/internal/thirdparty/http/a:a	(Ljava/net/HttpURLConnection;[B)I
    //   85: pop
    //   86: aload 5
    //   88: invokevirtual 317	java/net/HttpURLConnection:getDoInput	()Z
    //   91: ifeq +48 -> 139
    //   94: aload_0
    //   95: aload 5
    //   97: invokevirtual 320	com/facebook/ads/internal/thirdparty/http/a:a	(Ljava/net/HttpURLConnection;)Lcom/facebook/ads/internal/thirdparty/http/n;
    //   100: astore_1
    //   101: aload_0
    //   102: getfield 142	com/facebook/ads/internal/thirdparty/http/a:d	Lcom/facebook/ads/internal/thirdparty/http/q;
    //   105: invokeinterface 260 1 0
    //   110: ifeq +13 -> 123
    //   113: aload_0
    //   114: getfield 142	com/facebook/ads/internal/thirdparty/http/a:d	Lcom/facebook/ads/internal/thirdparty/http/q;
    //   117: aload_1
    //   118: invokeinterface 323 2 0
    //   123: aload_1
    //   124: astore_3
    //   125: aload 5
    //   127: ifnull +10 -> 137
    //   130: aload 5
    //   132: invokevirtual 326	java/net/HttpURLConnection:disconnect	()V
    //   135: aload_1
    //   136: astore_3
    //   137: aload_3
    //   138: areturn
    //   139: new 328	com/facebook/ads/internal/thirdparty/http/n
    //   142: dup
    //   143: aload 5
    //   145: aconst_null
    //   146: invokespecial 331	com/facebook/ads/internal/thirdparty/http/n:<init>	(Ljava/net/HttpURLConnection;[B)V
    //   149: astore_1
    //   150: goto -49 -> 101
    //   153: astore_3
    //   154: aload 5
    //   156: astore_1
    //   157: aload_0
    //   158: aload_1
    //   159: invokevirtual 333	com/facebook/ads/internal/thirdparty/http/a:b	(Ljava/net/HttpURLConnection;)Lcom/facebook/ads/internal/thirdparty/http/n;
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +48 -> 212
    //   167: aload_2
    //   168: invokevirtual 335	com/facebook/ads/internal/thirdparty/http/n:a	()I
    //   171: istore 7
    //   173: iload 7
    //   175: ifle +37 -> 212
    //   178: aload_0
    //   179: getfield 142	com/facebook/ads/internal/thirdparty/http/a:d	Lcom/facebook/ads/internal/thirdparty/http/q;
    //   182: invokeinterface 260 1 0
    //   187: ifeq +13 -> 200
    //   190: aload_0
    //   191: getfield 142	com/facebook/ads/internal/thirdparty/http/a:d	Lcom/facebook/ads/internal/thirdparty/http/q;
    //   194: aload_2
    //   195: invokeinterface 323 2 0
    //   200: aload_2
    //   201: astore_3
    //   202: aload_1
    //   203: ifnull -66 -> 137
    //   206: aload_1
    //   207: invokevirtual 326	java/net/HttpURLConnection:disconnect	()V
    //   210: aload_2
    //   211: areturn
    //   212: new 246	com/facebook/ads/internal/thirdparty/http/m
    //   215: dup
    //   216: aload_3
    //   217: aload_2
    //   218: invokespecial 338	com/facebook/ads/internal/thirdparty/http/m:<init>	(Ljava/lang/Exception;Lcom/facebook/ads/internal/thirdparty/http/n;)V
    //   221: athrow
    //   222: astore 4
    //   224: aload_1
    //   225: astore_3
    //   226: aload 4
    //   228: astore_1
    //   229: aload_2
    //   230: astore 4
    //   232: aload_3
    //   233: astore_2
    //   234: aload 4
    //   236: astore_3
    //   237: aload_0
    //   238: getfield 142	com/facebook/ads/internal/thirdparty/http/a:d	Lcom/facebook/ads/internal/thirdparty/http/q;
    //   241: invokeinterface 260 1 0
    //   246: ifeq +13 -> 259
    //   249: aload_0
    //   250: getfield 142	com/facebook/ads/internal/thirdparty/http/a:d	Lcom/facebook/ads/internal/thirdparty/http/q;
    //   253: aload_3
    //   254: invokeinterface 323 2 0
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 326	java/net/HttpURLConnection:disconnect	()V
    //   267: aload_1
    //   268: athrow
    //   269: astore_2
    //   270: aload_3
    //   271: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   274: iconst_0
    //   275: ifeq +11 -> 286
    //   278: new 343	java/lang/NullPointerException
    //   281: dup
    //   282: invokespecial 344	java/lang/NullPointerException:<init>	()V
    //   285: athrow
    //   286: new 246	com/facebook/ads/internal/thirdparty/http/m
    //   289: dup
    //   290: aload_3
    //   291: aconst_null
    //   292: invokespecial 338	com/facebook/ads/internal/thirdparty/http/m:<init>	(Ljava/lang/Exception;Lcom/facebook/ads/internal/thirdparty/http/n;)V
    //   295: athrow
    //   296: astore_2
    //   297: iconst_0
    //   298: ifeq +11 -> 309
    //   301: new 343	java/lang/NullPointerException
    //   304: dup
    //   305: invokespecial 344	java/lang/NullPointerException:<init>	()V
    //   308: athrow
    //   309: new 246	com/facebook/ads/internal/thirdparty/http/m
    //   312: dup
    //   313: aload_3
    //   314: aconst_null
    //   315: invokespecial 338	com/facebook/ads/internal/thirdparty/http/m:<init>	(Ljava/lang/Exception;Lcom/facebook/ads/internal/thirdparty/http/n;)V
    //   318: athrow
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_2
    //   322: aload 6
    //   324: astore_3
    //   325: goto -88 -> 237
    //   328: astore_1
    //   329: aload 6
    //   331: astore_3
    //   332: aload 5
    //   334: astore_2
    //   335: goto -98 -> 237
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_1
    //   341: goto -184 -> 157
    //   344: astore_3
    //   345: aload_1
    //   346: astore_2
    //   347: aload_3
    //   348: astore_1
    //   349: aload 6
    //   351: astore_3
    //   352: goto -115 -> 237
    //
    // Exception table:
    //   from	to	target	type
    //   15	54	153	java/lang/Exception
    //   54	72	153	java/lang/Exception
    //   77	86	153	java/lang/Exception
    //   86	101	153	java/lang/Exception
    //   139	150	153	java/lang/Exception
    //   167	173	222	finally
    //   212	222	222	finally
    //   157	163	269	java/lang/Exception
    //   157	163	296	finally
    //   270	274	296	finally
    //   3	15	319	finally
    //   15	54	328	finally
    //   54	72	328	finally
    //   77	86	328	finally
    //   86	101	328	finally
    //   139	150	328	finally
    //   3	15	338	java/lang/Exception
    //   278	286	344	finally
    //   286	296	344	finally
    //   301	309	344	finally
    //   309	319	344	finally
  }

  public n a(String paramString, o paramo)
  {
    return b(new i(paramString, paramo));
  }

  // ERROR //
  protected n a(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 155	com/facebook/ads/internal/thirdparty/http/a:a	Lcom/facebook/ads/internal/thirdparty/http/p;
    //   6: aload_1
    //   7: invokeinterface 355 2 0
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +14 -> 28
    //   17: aload_0
    //   18: getfield 155	com/facebook/ads/internal/thirdparty/http/a:a	Lcom/facebook/ads/internal/thirdparty/http/p;
    //   21: aload_2
    //   22: invokeinterface 358 2 0
    //   27: astore_3
    //   28: new 328	com/facebook/ads/internal/thirdparty/http/n
    //   31: dup
    //   32: aload_1
    //   33: aload_3
    //   34: invokespecial 331	com/facebook/ads/internal/thirdparty/http/n:<init>	(Ljava/net/HttpURLConnection;[B)V
    //   37: astore_1
    //   38: aload_2
    //   39: ifnull +7 -> 46
    //   42: aload_2
    //   43: invokevirtual 361	java/io/InputStream:close	()V
    //   46: aload_1
    //   47: areturn
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +7 -> 59
    //   55: aload_2
    //   56: invokevirtual 361	java/io/InputStream:close	()V
    //   59: aload_1
    //   60: athrow
    //   61: astore_2
    //   62: aload_1
    //   63: areturn
    //   64: astore_2
    //   65: goto -6 -> 59
    //   68: astore_1
    //   69: goto -18 -> 51
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	48	finally
    //   42	46	61	java/lang/Exception
    //   55	59	64	java/lang/Exception
    //   17	28	68	finally
    //   28	38	68	finally
  }

  protected HttpURLConnection a(String paramString)
  {
    paramString = this.c + paramString;
    try
    {
      new URL(paramString);
      return this.a.a(paramString);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new IllegalArgumentException(paramString + " is not a valid URL", localMalformedURLException);
    }
  }

  protected void a(l paraml, b paramb)
  {
    this.b.a(this, paramb).a(paraml);
  }

  public void a(String paramString, o paramo, b paramb)
  {
    a(new k(paramString, paramo), paramb);
  }

  protected void a(HttpURLConnection paramHttpURLConnection, j paramj, String paramString)
  {
    paramHttpURLConnection.setConnectTimeout(this.e);
    paramHttpURLConnection.setReadTimeout(this.f);
    this.a.a(paramHttpURLConnection, paramj, paramString);
  }

  protected boolean a(Throwable paramThrowable, long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong + 10L;
    if (this.d.a())
      this.d.a("ELAPSED TIME = " + paramLong + ", CT = " + this.e + ", RT = " + this.f);
    if (this.k)
      if (paramLong < this.f);
    while (paramLong >= this.e)
    {
      return true;
      return false;
    }
    return false;
  }

  public n b(l paraml)
  {
    try
    {
      paraml = a(paraml.a(), paraml.b(), paraml.c(), paraml.d());
      return paraml;
    }
    catch (m paraml)
    {
      this.a.a(paraml);
      return null;
    }
    catch (Exception paraml)
    {
      this.a.a(new m(paraml, null));
    }
    return null;
  }

  public n b(String paramString, o paramo)
  {
    return b(new k(paramString, paramo));
  }

  // ERROR //
  protected n b(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokevirtual 413	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +14 -> 22
    //   11: aload_0
    //   12: getfield 155	com/facebook/ads/internal/thirdparty/http/a:a	Lcom/facebook/ads/internal/thirdparty/http/p;
    //   15: aload_2
    //   16: invokeinterface 358 2 0
    //   21: astore_3
    //   22: new 328	com/facebook/ads/internal/thirdparty/http/n
    //   25: dup
    //   26: aload_1
    //   27: aload_3
    //   28: invokespecial 331	com/facebook/ads/internal/thirdparty/http/n:<init>	(Ljava/net/HttpURLConnection;[B)V
    //   31: astore_1
    //   32: aload_2
    //   33: ifnull +7 -> 40
    //   36: aload_2
    //   37: invokevirtual 361	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: areturn
    //   42: astore_1
    //   43: aconst_null
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +7 -> 53
    //   49: aload_2
    //   50: invokevirtual 361	java/io/InputStream:close	()V
    //   53: aload_1
    //   54: athrow
    //   55: astore_2
    //   56: aload_1
    //   57: areturn
    //   58: astore_2
    //   59: goto -6 -> 53
    //   62: astore_1
    //   63: goto -18 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	42	finally
    //   36	40	55	java/lang/Exception
    //   49	53	58	java/lang/Exception
    //   11	22	62	finally
    //   22	32	62	finally
  }

  public o b()
  {
    return new o();
  }

  public void b(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 18))
      throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
    this.i = paramInt;
  }

  public void c(int paramInt)
  {
    this.e = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.thirdparty.http.a
 * JD-Core Version:    0.6.2
 */