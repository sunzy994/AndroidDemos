package cmcm.com.myapplication;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public final class ns extends nz
{
  private Context b;
  private WebView c;

  public ns(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
  }

  private void g(oa paramoa, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11);
    for (int i = 1; i != 0; i = 0)
    {
      if (mv.a())
        mv.c("ToolClickHandler", "Newer OS, use WebView redirect.");
      if (this.c == null)
      {
        this.c = new WebView(this.b);
        WebSettings localWebSettings = this.c.getSettings();
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setUserAgentString(mw.b);
      }
      this.c.stopLoading();
      paramoa = new nw(this, paramoa);
      this.c.setWebViewClient(paramoa);
      if (mv.a())
        mv.c("ToolClickHandler", "[WebView] Decode URL: " + paramString);
      this.c.loadUrl(paramString);
      return;
    }
    if (mv.a())
      mv.c("ToolClickHandler", "Older OS, use Http redirect.");
    mm.b(new nt(this, paramoa, paramString));
  }

  public final void a(oa paramoa)
  {
    if (b());
    do
    {
      return;
      a(true);
      if (np.a(this.b, paramoa.a()))
      {
        b(paramoa);
        return;
      }
      nr.a(this.b, paramoa);
      if (paramoa.f())
      {
        d(paramoa, paramoa.h());
        return;
      }
      if (paramoa.g())
      {
        if (mv.a())
          mv.c("ToolClickHandler", "Clicked URL: " + paramoa.h());
        if (mn.d())
        {
          boolean bool = np.a(this.b, "com.android.vending");
          if (mv.a())
            mv.c("ToolClickHandler", "Click with Play installed? " + bool);
          if (bool)
          {
            String str = paramoa.h();
            if (a(str))
            {
              f(paramoa, str);
              c();
              return;
            }
            if (paramoa.d() > 0)
            {
              mz localmz = mw.a(this.b).a(str);
              paramoa.a(localmz);
              if (1 == localmz.c)
              {
                f(paramoa, localmz.d);
                c();
                return;
              }
              g(paramoa, str);
              return;
            }
            g(paramoa, str);
            return;
          }
          e(paramoa, paramoa.h());
          c();
          return;
        }
        if (mv.a())
          mv.c("ToolClickHandler", "CHINA Click to download:" + paramoa.a());
        e(paramoa, paramoa.h());
        c();
        return;
      }
    }
    while (!mv.a());
    mv.c("ToolClickHandler", "Unknown Open type: " + paramoa.c());
  }

  final void a(oa paramoa, String paramString)
  {
    if (paramoa.d() <= 0)
      return;
    mz localmz = new mz();
    localmz.a = paramoa.h();
    localmz.d = paramString;
    localmz.b = paramoa.a();
    localmz.c = 1;
    localmz.e = System.currentTimeMillis();
    oe.a(this.b).a(localmz);
  }

  protected final void b(oa paramoa, String paramString)
  {
    DefaultHttpClient localDefaultHttpClient = a();
    localDefaultHttpClient.setRedirectHandler(new nv(this, paramoa));
    if (mv.a())
      mv.c("ToolClickHandler", "[Http] Decode URL: " + paramString);
    try
    {
      HttpGet localHttpGet = new HttpGet(paramString);
      HttpConnectionParams.setConnectionTimeout(localHttpGet.getParams(), 10000);
      HttpConnectionParams.setSoTimeout(localHttpGet.getParams(), 20000);
      localDefaultHttpClient.execute(localHttpGet).getEntity();
      return;
    }
    catch (Exception localException)
    {
      mv.b("ToolClickHandler", "[Http] Others error: ", localException);
      e(paramoa, paramString);
      c();
    }
  }

  public final void c(oa paramoa, String paramString)
  {
    nr.i(this.b, paramoa);
    mm.b(new nu(this, paramoa, paramString));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ns
 * JD-Core Version:    0.6.2
 */