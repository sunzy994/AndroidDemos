package cmcm.com.myapplication;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URLDecoder;

class xt extends WebViewClient
{
  private boolean b;

  private xt(xs paramxs)
  {
  }

  void a(WebView paramWebView)
  {
    try
    {
      vy.f(((xs)paramWebView).d);
      return;
    }
    catch (Throwable paramWebView)
    {
    }
  }

  void b(WebView paramWebView)
  {
    try
    {
      vy.g(((xs)paramWebView).d);
      return;
    }
    catch (Throwable paramWebView)
    {
    }
  }

  public void onPageFinished(final WebView paramWebView, String paramString)
  {
    if (this.b)
      return;
    paramWebView.setBackgroundColor(Color.argb(1, 0, 0, 0));
    try
    {
      paramWebView.setLayerType(1, null);
      label25: paramWebView.setAlpha(0.0F);
      paramWebView.setVisibility(0);
      paramString = paramWebView.animate().alpha(1.0F).setStartDelay(400L);
      if (Build.VERSION.SDK_INT >= 16)
        paramString.withEndAction(new Runnable()
        {
          public void run()
          {
            xt.this.a.b = true;
            xt.this.a.c = System.currentTimeMillis();
            xt.this.a(paramWebView);
          }
        }).withStartAction(new Runnable()
        {
          public void run()
          {
            xt.this.a.a.h.sendEmptyMessage(2);
          }
        });
      while (true)
      {
        paramString.start();
        return;
        paramString.setListener(new asx()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            xt.this.a.b = true;
            xt.this.a.c = System.currentTimeMillis();
            xt.this.a(paramWebView);
          }

          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
            xt.this.a.a.h.sendEmptyMessage(2);
          }
        });
      }
    }
    catch (Throwable paramString)
    {
      break label25;
    }
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    asp.b("Swipe.BannerView", "Error loading page " + paramString2 + ": " + paramInt + "/" + paramString1);
    this.b = true;
    xs.a(paramWebView);
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    xs.a(this.a).sendEmptyMessage(1);
    b(paramWebView);
    if (paramString.startsWith("https://play.google.com/store/apps/details?id="))
    {
      paramWebView = URLDecoder.decode(paramString).substring("https://play.google.com/store/apps/details?id=".length());
      return asq.a(this.a.getContext(), paramWebView, true, true);
    }
    try
    {
      this.a.getContext().startActivity(asq.c(paramString));
      return true;
    }
    catch (Throwable paramWebView)
    {
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xt
 * JD-Core Version:    0.6.2
 */