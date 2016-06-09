package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class nw extends WebViewClient
{
  oa a;
  WebView b;
  private Runnable d = new nx(this);
  private Runnable e = new ny(this);
  private volatile boolean f = false;
  private volatile boolean g = false;
  private volatile boolean h = false;

  public nw(ns paramns, oa paramoa)
  {
    this.a = paramoa;
  }

  private void a(String paramString)
  {
    if (mv.a())
      mv.c("ToolClickHandler", "[WebView] handleError");
    this.c.a.removeCallbacks(this.e);
    this.c.a.removeCallbacks(this.d);
    if (this.h)
    {
      if (mv.a())
        mv.c("ToolClickHandler", "[WebView] already consumed");
      return;
    }
    if (mv.a())
      mv.c("ToolClickHandler", "[WebView] onReceivedError: " + paramString);
    this.h = true;
    this.c.e(this.a, this.a.h());
    this.c.c();
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (mv.a())
      mv.c("ToolClickHandler", "[WebView] Page finished");
    this.c.a.removeCallbacks(this.e);
    this.c.a.removeCallbacks(this.d);
    if (this.h)
      if (mv.a())
        mv.c("ToolClickHandler", "[WebView] already consumed");
    while (this.f)
      return;
    if (mv.a())
      mv.c("ToolClickHandler", "[WebView] start TIMEOUT_FINISH: " + paramString);
    this.c.a.postDelayed(this.d, 2000L);
  }

  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (mv.a())
      mv.c("ToolClickHandler", "[WebView] onPageStarted.");
    this.b = paramWebView;
    this.f = false;
    this.h = false;
    this.c.a.removeCallbacks(this.e);
    this.c.a.removeCallbacks(this.d);
    if (mv.a())
      mv.c("ToolClickHandler", "[WebView] start TIMEOUT_START: " + paramString);
    this.c.a.postDelayed(this.e, 30000L);
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    a("Error: " + paramInt);
  }

  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    a("SslError");
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (mv.a())
      mv.c("ToolClickHandler", "[WebView] shouldOverrideUrlLoading.");
    this.c.a.removeCallbacks(this.e);
    this.c.a.removeCallbacks(this.d);
    if ((this.h) || (this.f))
    {
      if (mv.a())
        mv.c("ToolClickHandler", "[WebView]Action canceled.");
      this.h = true;
      this.c.c();
      return true;
    }
    if (paramString == null)
    {
      if (mv.a())
        mv.c("ToolClickHandler", "[WebView] null URL.");
      this.c.e(this.a, this.a.h());
      this.c.c();
      this.h = true;
      return true;
    }
    if (nz.a(paramString))
    {
      if (mv.a())
        mv.c("ToolClickHandler", "[WebView] Market URL: " + paramString);
      this.c.a(this.a, paramString);
      this.c.f(this.a, paramString);
      this.c.c();
      this.h = true;
      return true;
    }
    if (mv.a())
      mv.c("ToolClickHandler", "[WebView] Decode URL: " + paramString);
    if (!this.f)
    {
      if (mv.a())
        mv.c("ToolClickHandler", "[WebView] start TIMEOUT_START: " + paramString);
      this.c.a.postDelayed(this.e, 30000L);
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nw
 * JD-Core Version:    0.6.2
 */