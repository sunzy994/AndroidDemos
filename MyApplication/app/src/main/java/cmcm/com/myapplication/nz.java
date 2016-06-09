package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.util.List;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public abstract class nz
  implements Callback
{
  private static DefaultHttpClient b;
  protected Handler a;
  private Context c;
  private boolean d;

  public nz(Context paramContext)
  {
    this.c = paramContext;
    if (Looper.getMainLooper() == Looper.myLooper())
      this.a = new Handler(this);
  }

  static DefaultHttpClient a()
  {
    try
    {
      Object localObject1;
      if (b != null)
        localObject1 = b;
      while (true)
      {
        return localObject1;
        localObject1 = new SchemeRegistry();
        ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        localObject1 = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject1), localBasicHttpParams);
        HttpConnectionParams.setConnectionTimeout(((DefaultHttpClient)localObject1).getParams(), 10000);
        HttpConnectionParams.setSoTimeout(((DefaultHttpClient)localObject1).getParams(), 20000);
        ((DefaultHttpClient)localObject1).getParams().setIntParameter("http.protocol.max-redirects", 10);
        HttpClientParams.setCookiePolicy(((DefaultHttpClient)localObject1).getParams(), "compatibility");
        HttpProtocolParams.setUserAgent(((DefaultHttpClient)localObject1).getParams(), mw.b);
        ((DefaultHttpClient)localObject1).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(3, true));
        b = (DefaultHttpClient)localObject1;
      }
    }
    finally
    {
    }
  }

  public static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0));
    while ((!paramString.startsWith("http://market.")) && (!paramString.startsWith("https://market.")) && (!paramString.startsWith("https://play.")) && (!paramString.startsWith("http://play.")) && (!paramString.startsWith("market:")))
      return false;
    return true;
  }

  public final void a(boolean paramBoolean)
  {
    try
    {
      this.d = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected final void b(oa paramoa)
  {
    if (mv.a())
      mv.c("BaseClickHandler", "Goto installed App: " + paramoa.a());
    nr.b(this.c, paramoa);
    Context localContext = this.c;
    paramoa = paramoa.a();
    try
    {
      paramoa = localContext.getPackageManager().getLaunchIntentForPackage(paramoa);
      if (paramoa != null)
      {
        paramoa.setFlags(270532608);
        localContext.startActivity(paramoa);
      }
      return;
    }
    catch (Exception paramoa)
    {
    }
  }

  public final boolean b()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void c()
  {
    try
    {
      this.d = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected final void d(oa paramoa, String paramString)
  {
    if (mv.a())
      mv.c("BaseClickHandler", "An apk link.");
    e(paramoa, paramString);
  }

  protected final void e(oa paramoa, String paramString)
  {
    if (paramoa.k())
      return;
    if (paramString == null)
    {
      if (mv.a())
        mv.c("BaseClickHandler", "startBrowser: url is null");
      nr.c(this.c, paramoa);
      mv.c("BaseClickHandler", "Please check you network and try again.");
      return;
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    PackageManager localPackageManager = this.c.getPackageManager();
    ResolveInfo localResolveInfo = localPackageManager.resolveActivity(paramString, 65536);
    if (localResolveInfo == null)
    {
      if (mv.a())
        mv.c("BaseClickHandler", "Goto browser failed.");
      mv.c("BaseClickHandler", "No browser or Google Play installed");
      nr.c(this.c, paramoa);
      return;
    }
    if ("android".equals(localResolveInfo.activityInfo.packageName))
      paramString.setPackage(((ResolveInfo)localPackageManager.queryIntentActivities(paramString, 65536).get(0)).activityInfo.packageName);
    if (mv.a())
      mv.c("BaseClickHandler", "Goto browser");
    this.c.startActivity(paramString);
    nr.d(this.c, paramoa);
    c();
  }

  protected final void f(oa paramoa, String paramString)
  {
    if (paramoa.k())
      return;
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    localIntent.setFlags(268435456);
    localIntent.setPackage("com.android.vending");
    try
    {
      if (mv.a())
        mv.c("BaseClickHandler", "Goto Play");
      this.c.startActivity(localIntent);
      nr.e(this.c, paramoa);
      return;
    }
    catch (Exception localException)
    {
      if (mv.a())
        mv.a("BaseClickHandler", "Goto Play failed:", localException);
      e(paramoa, paramString);
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nz
 * JD-Core Version:    0.6.2
 */