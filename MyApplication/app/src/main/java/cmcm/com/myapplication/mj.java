package cmcm.com.myapplication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.CharArrayBuffer;
import org.json.JSONObject;

public final class mj
{
  private static final Header a = new BasicHeader("Content-Encoding", "gzip");
  private static final Header b = new BasicHeader("Accept-Encoding", "gzip");
  private static DefaultHttpClient c;

  static
  {
    new mj();
  }

  private static int a(URL paramURL, List paramList, mk parammk, int paramInt)
  {
    int j = 1024;
    paramList = a(paramURL, paramList, true);
    label303: label323: label326: 
    while (true)
    {
      try
      {
        paramInt = paramList.getStatusLine().getStatusCode();
        if ((paramInt != 200) && (paramInt != 304))
          return paramInt;
        i = paramInt;
        if (paramInt != 200)
          break label303;
        localObject = paramList.getEntity();
        paramURL = ((HttpEntity)localObject).getContent();
        paramInt = (int)((HttpEntity)localObject).getContentLength();
        if (paramInt >= 0)
          break label326;
        paramInt = j;
        localObject = ((HttpEntity)localObject).getContentEncoding();
        if ((localObject == null) || (((Header)localObject).getValue().indexOf("gzip") == -1))
          break label323;
        paramURL = new GZIPInputStream(paramURL);
        paramURL = new InputStreamReader(paramURL, "UTF-8");
        localObject = new CharArrayBuffer(paramInt);
        char[] arrayOfChar = new char[1024];
        paramInt = paramURL.read(arrayOfChar);
        if (paramInt != -1)
        {
          ((CharArrayBuffer)localObject).append(arrayOfChar, 0, paramInt);
          continue;
        }
      }
      finally
      {
        a(paramList);
      }
      np.a(paramURL);
      paramURL = new JSONObject(((CharArrayBuffer)localObject).toString());
      Object localObject = paramURL.getJSONObject("responseHeader");
      parammk.b = ((JSONObject)localObject);
      int i = ((JSONObject)localObject).getInt("status");
      if (i == 200)
      {
        parammk.a = paramURL.getJSONObject("response");
        paramURL = paramList.getFirstHeader("Last-Modified");
        if (paramURL != null)
        {
          paramURL = paramURL.getValue();
          localObject = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
          ((DateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
        }
        for (long l = ((DateFormat)localObject).parse(paramURL).getTime(); ; l = 0L)
        {
          parammk.c = l;
          a(paramList);
          return i;
        }
      }
      a(paramList);
      return i;
    }
  }

  public static HttpResponse a(URI paramURI, String paramString, List paramList)
  {
    paramList = new HttpPost(paramURI.toString());
    paramList.addHeader(a);
    paramList.addHeader(b);
    if ((paramString == null) || (paramString.length() == 0))
      paramURI = new byte[0];
    while (true)
    {
      paramList.setEntity(new ByteArrayEntity(paramURI));
      if (mv.a())
        mv.c("ToolboxRequestHelper", "request uri:" + paramList.getURI() + ",body:" + paramString + ",headers:" + Arrays.asList(paramList.getAllHeaders()));
      paramList.getParams().setParameter("http.socket.timeout", Integer.valueOf(20000));
      paramURI = a();
      try
      {
        paramURI = paramURI.execute(paramList);
        return paramURI;
        paramURI = new ByteArrayOutputStream();
        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(paramURI);
        localGZIPOutputStream.write(paramString.getBytes("UTF-8"));
        localGZIPOutputStream.close();
        paramURI = paramURI.toByteArray();
      }
      catch (IOException paramURI)
      {
        paramList.abort();
      }
    }
    throw paramURI;
  }

  public static HttpResponse a(URL paramURL, List paramList, boolean paramBoolean)
  {
    paramURL = new HttpGet(paramURL.toString());
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
        paramURL.addHeader((Header)paramList.next());
    }
    paramURL.addHeader(b);
    if (mv.a())
      mv.c("ToolboxRequestHelper", "request uri: " + paramURL.getURI() + ", headers: " + Arrays.asList(paramURL.getAllHeaders()));
    paramURL.getParams().setParameter("http.socket.timeout", Integer.valueOf(20000));
    paramList = a();
    try
    {
      paramList = paramList.execute(paramURL);
      return paramList;
    }
    catch (IOException paramList)
    {
      paramURL.abort();
    }
    throw paramList;
  }

  private static DefaultHttpClient a()
  {
    try
    {
      if (c != null);
      for (Object localObject1 = c; ; localObject1 = c)
      {
        return localObject1;
        localObject1 = new SchemeRegistry();
        ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        localObject1 = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject1), localBasicHttpParams);
        c = (DefaultHttpClient)localObject1;
        HttpConnectionParams.setSoTimeout(((DefaultHttpClient)localObject1).getParams(), 30000);
        HttpConnectionParams.setConnectionTimeout(c.getParams(), 30000);
        c.getParams().setIntParameter("http.protocol.max-redirects", 10);
        HttpClientParams.setCookiePolicy(c.getParams(), "compatibility");
        HttpProtocolParams.setUserAgent(c.getParams(), "Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:1.9.2.18) Gecko/20110628 Ubuntu/10.04 (lucid) Firefox/3.6.18");
        c.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(3, true));
      }
    }
    finally
    {
    }
  }

  public static void a(URL paramURL, mq parammq, long paramLong)
  {
    while (true)
    {
      mk localmk;
      try
      {
        localmk = new mk();
        ArrayList localArrayList = new ArrayList();
        Date localDate = new Date(paramLong);
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        localArrayList.add(new BasicHeader("If-Modified-Since", localSimpleDateFormat.format(localDate)));
        int i = a(paramURL, localArrayList, localmk, 1);
        if ((200 == i) || (304 == i))
        {
          parammq.a(i, localmk);
          return;
        }
        if (localmk.b == null)
        {
          paramURL = "NETWORK_FAIL";
          parammq.a(i, paramURL);
          return;
        }
      }
      catch (Exception paramURL)
      {
        parammq.a(paramURL);
        mv.a("ToolboxRequestHelper", "failed to get project", paramURL);
        return;
      }
      paramURL = localmk.b.optString("msg");
    }
  }

  public static void a(HttpResponse paramHttpResponse)
  {
    if ((paramHttpResponse == null) || (paramHttpResponse.getEntity() == null))
      return;
    try
    {
      paramHttpResponse.getEntity().consumeContent();
      return;
    }
    catch (Exception paramHttpResponse)
    {
      mv.a("ToolboxRequestHelper", "failed to cosume entity", paramHttpResponse);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mj
 * JD-Core Version:    0.6.2
 */