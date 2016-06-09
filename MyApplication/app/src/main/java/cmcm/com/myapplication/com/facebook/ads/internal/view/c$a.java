package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.action.a;
import com.facebook.ads.internal.action.b;
import com.facebook.ads.internal.ssp.ANAdRenderer.Listener;
import com.facebook.ads.internal.util.g;

class c$a extends WebViewClient
{
  private c$a(c paramc)
  {
  }

  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (g.a())
    {
      paramSslErrorHandler.proceed();
      return;
    }
    paramSslErrorHandler.cancel();
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView = Uri.parse(paramString);
    if (("fbad".equals(paramWebView.getScheme())) && ("close".equals(paramWebView.getAuthority())))
      c.a(this.a).onAdClose();
    do
    {
      return true;
      c.a(this.a).onAdClick();
      paramWebView = b.a(this.a.getContext(), paramWebView);
    }
    while (paramWebView == null);
    try
    {
      c.a(this.a, paramWebView.a());
      c.a(this.a, System.currentTimeMillis());
      paramWebView.b();
      return true;
    }
    catch (Exception paramWebView)
    {
      Log.e(c.a(), "Error executing action", paramWebView);
    }
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.c.a
 * JD-Core Version:    0.6.2
 */