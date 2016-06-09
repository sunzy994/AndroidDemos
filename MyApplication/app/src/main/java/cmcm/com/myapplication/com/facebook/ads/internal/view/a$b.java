package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.util.g;

class a$b extends WebViewClient
{
  private a$b(a parama)
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
    a.a(this.a).a(paramString);
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.a.b
 * JD-Core Version:    0.6.2
 */