package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import com.lazyswipe.SwipeApplication;
import java.net.URI;

public abstract class azr extends aph
{
  private WebView i;
  private OnlineLoadingView j;
  private ViewGroup k;
  private ViewGroup l;
  private String m;
  private final WebViewClient n = new azp()
  {
    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      azr.this.i();
    }

    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if (super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString))
        return true;
      if (azr.this.a(paramAnonymousString))
      {
        asq.i(azr.this, paramAnonymousString);
        return true;
      }
      return azr.this.b(paramAnonymousString);
    }
  };
  private final WebChromeClient o = new azn()
  {
    public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
    {
      return super.onConsoleMessage(paramAnonymousConsoleMessage);
    }

    public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      aso.a(azr.this, paramAnonymousString2);
      paramAnonymousJsResult.confirm();
      return true;
    }

    public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
    {
      if (paramAnonymousInt >= 90)
        azr.d(azr.this).removeMessages(1);
      if ((paramAnonymousInt != 100) || ((paramAnonymousInt >= 100) && (!azr.e(azr.this).e())))
        azr.this.j();
      super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
    }
  };
  private final Handler p = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (azr.this.isFinishing());
      do
      {
        do
        {
          return;
          switch (paramAnonymousMessage.what)
          {
          default:
            return;
          case 0:
          case 1:
          }
        }
        while (azr.b(azr.this) == null);
        Log.e("Swipe.WebViewActivity", "Load page [" + azr.c(azr.this) + "] timeout on " + azr.b(azr.this).getProgress() + "%, force stop loading.");
        azr.this.i();
        azr.b(azr.this).stopLoading();
        return;
      }
      while ((azr.b(azr.this) == null) || (azr.b(azr.this).getProgress() >= 90));
      azr.d(azr.this).sendEmptyMessage(0);
    }
  };

  private void t()
  {
    if (w())
    {
      this.i.setVisibility(8);
      this.j.a();
      if (this.l != this.k)
        this.l.setVisibility(0);
      l();
      this.p.sendEmptyMessageDelayed(1, 120000L);
    }
    do
    {
      return;
      this.i.setVisibility(8);
      this.j.b();
    }
    while (this.l == this.k);
    this.l.setVisibility(0);
  }

  @SuppressLint({"JavascriptInterface"})
  private void u()
  {
    this.i = new azo(this);
    this.i.setWebChromeClient(this.o);
    this.i.setWebViewClient(this.n);
    azq localazq = s();
    String str = r();
    if ((str != null) && (localazq != null))
      this.i.addJavascriptInterface(localazq, str);
    this.k.addView(this.i, -1, -1);
    this.i.setBackgroundColor(o());
    this.i.setVisibility(8);
  }

  private void v()
  {
    this.j = ((OnlineLoadingView)LayoutInflater.from(this).inflate(2130968657, null));
    this.j.setActionClickListener(new sr()
    {
      public void b()
      {
        azr.a(azr.this);
      }
    });
    this.l.addView(this.j, -1, -1);
  }

  private boolean w()
  {
    return arl.i(this);
  }

  protected boolean a(String paramString)
  {
    return false;
  }

  protected boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = new URI(paramString);
      if ("mailto".equals(paramString.getScheme()))
      {
        paramString = asq.i(paramString.getSchemeSpecificPart());
        asq.d(SwipeApplication.c(), paramString);
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString)
    {
    }
    return false;
  }

  public abstract int g();

  public abstract int h();

  protected void i()
  {
    this.i.setVisibility(8);
    this.j.b();
  }

  protected void j()
  {
    this.i.setVisibility(0);
    this.j.f();
    if (this.l != this.k)
      this.l.setVisibility(8);
  }

  protected boolean k()
  {
    return false;
  }

  protected void l()
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        if (azr.b(azr.this) != null)
          azr.b(azr.this).loadUrl(azr.c(azr.this));
      }
    });
  }

  protected int m()
  {
    return h();
  }

  protected int o()
  {
    return -1118482;
  }

  public void onBackPressed()
  {
    if ((this.i != null) && (this.i.canGoBack()))
    {
      this.i.goBack();
      return;
    }
    q();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(g());
    this.m = p();
    this.k = ((ViewGroup)findViewById(h()));
    this.l = ((ViewGroup)findViewById(m()));
    u();
    v();
    if ((!TextUtils.isEmpty(this.m)) || (k()))
      t();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      CookieSyncManager.getInstance().sync();
      this.k.removeView(this.i);
      this.l.removeView(this.j);
      this.i.removeAllViews();
      this.i.destroy();
      this.i = null;
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected String p()
  {
    return getIntent().getStringExtra("extra_url");
  }

  public void q()
  {
    super.onBackPressed();
  }

  protected String r()
  {
    return null;
  }

  protected azq s()
  {
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azr
 * JD-Core Version:    0.6.2
 */