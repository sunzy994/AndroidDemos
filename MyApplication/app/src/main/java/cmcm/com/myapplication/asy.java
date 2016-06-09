package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import org.apache.http.client.methods.HttpGet;

public class asy
  implements atg
{
  protected String a = null;

  private boolean a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (!TextUtils.isEmpty(paramThrowable.getMessage())))
    {
      paramThrowable = paramThrowable.getMessage();
      if ((paramThrowable.contains("Timeout")) || (paramThrowable.contains("No route")) || (paramThrowable.contains("timed out")) || (paramThrowable.contains("UnknownHostException")))
        return true;
    }
    return false;
  }

  public String a()
  {
    return this.a;
  }

  public HttpGet a(Context paramContext, ata paramata)
  {
    if (paramata.e())
      return null;
    this.a = paramata.a();
    return a(paramContext, paramata, this.a);
  }

  // ERROR //
  public HttpGet a(Context paramContext, ata paramata, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: getfield 58	ata:e	I
    //   7: iconst_1
    //   8: if_icmpne +170 -> 178
    //   11: aload_2
    //   12: getfield 62	ata:l	Lati;
    //   15: ifnull +163 -> 178
    //   18: aload_0
    //   19: aload_2
    //   20: getfield 62	ata:l	Lati;
    //   23: invokevirtual 68	ati:b	()Ljava/lang/Throwable;
    //   26: invokespecial 70	asy:a	(Ljava/lang/Throwable;)Z
    //   29: ifeq +149 -> 178
    //   32: new 72	java/net/URI
    //   35: dup
    //   36: aload_3
    //   37: invokespecial 75	java/net/URI:<init>	(Ljava/lang/String;)V
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 78	java/net/URI:getHost	()Ljava/lang/String;
    //   45: astore 4
    //   47: aload 4
    //   49: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +126 -> 178
    //   55: aload_2
    //   56: invokevirtual 78	java/net/URI:getHost	()Ljava/lang/String;
    //   59: ldc 80
    //   61: invokestatic 86	android/net/http/AndroidHttpClient:newInstance	(Ljava/lang/String;)Landroid/net/http/AndroidHttpClient;
    //   64: invokestatic 91	aqp:a	(Ljava/lang/String;Landroid/net/http/AndroidHttpClient;)Ljava/lang/String;
    //   67: astore 4
    //   69: aload 4
    //   71: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifne +104 -> 178
    //   77: aload_1
    //   78: new 72	java/net/URI
    //   81: dup
    //   82: aload_2
    //   83: invokevirtual 94	java/net/URI:getScheme	()Ljava/lang/String;
    //   86: aload_2
    //   87: invokevirtual 97	java/net/URI:getUserInfo	()Ljava/lang/String;
    //   90: aload 4
    //   92: aload_2
    //   93: invokevirtual 101	java/net/URI:getPort	()I
    //   96: aload_2
    //   97: invokevirtual 104	java/net/URI:getPath	()Ljava/lang/String;
    //   100: aload_2
    //   101: invokevirtual 107	java/net/URI:getQuery	()Ljava/lang/String;
    //   104: aload_2
    //   105: invokevirtual 110	java/net/URI:getFragment	()Ljava/lang/String;
    //   108: invokespecial 113	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   111: invokevirtual 116	java/net/URI:toString	()Ljava/lang/String;
    //   114: iconst_1
    //   115: iconst_0
    //   116: invokestatic 121	aqg:a	(Landroid/content/Context;Ljava/lang/String;ZZ)Ljava/lang/Object;
    //   119: checkcast 123	org/apache/http/client/methods/HttpGet
    //   122: astore 4
    //   124: aload 4
    //   126: ldc 125
    //   128: aload_2
    //   129: invokevirtual 78	java/net/URI:getHost	()Ljava/lang/String;
    //   132: invokevirtual 129	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 4
    //   137: invokevirtual 133	org/apache/http/client/methods/HttpGet:getParams	()Lorg/apache/http/params/HttpParams;
    //   140: iconst_0
    //   141: invokestatic 139	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   144: aload 4
    //   146: areturn
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_2
    //   151: ldc 141
    //   153: ldc 143
    //   155: aload 4
    //   157: invokestatic 148	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   160: pop
    //   161: aload 5
    //   163: astore 4
    //   165: goto -118 -> 47
    //   168: astore_2
    //   169: ldc 141
    //   171: ldc 150
    //   173: aload_2
    //   174: invokestatic 148	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   177: pop
    //   178: aload_1
    //   179: aload_3
    //   180: iconst_1
    //   181: iconst_0
    //   182: invokestatic 121	aqg:a	(Landroid/content/Context;Ljava/lang/String;ZZ)Ljava/lang/Object;
    //   185: checkcast 123	org/apache/http/client/methods/HttpGet
    //   188: areturn
    //   189: astore 4
    //   191: goto -40 -> 151
    //
    // Exception table:
    //   from	to	target	type
    //   32	41	147	java/lang/Exception
    //   47	144	168	java/lang/Exception
    //   41	47	189	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asy
 * JD-Core Version:    0.6.2
 */