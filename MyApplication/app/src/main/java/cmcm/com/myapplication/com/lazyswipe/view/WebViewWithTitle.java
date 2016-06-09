package cmcm.com.myapplication.com.lazyswipe.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aqs;
import arl;
import aso;
import asq;
import asr;
import atw;
import azn;
import azo;
import azp;
import azq;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import java.net.URI;
import sr;
import vs;

public class WebViewWithTitle extends FrameLayout
  implements OnClickListener
{
  ViewGroup a;
  WebView b;
  OnlineLoadingView c;
  String d;
  private View e;
  private final WebChromeClient f = new azn()
  {
    public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      aso.a(WebViewWithTitle.this.getContext(), paramAnonymousString2);
      paramAnonymousJsResult.confirm();
      return true;
    }

    public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
    {
      if ((paramAnonymousInt > 10) && (WebViewWithTitle.this.c.isShown()))
        WebViewWithTitle.this.c.f();
      super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
    }
  };
  private final WebViewClient g = new azp()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      WebViewWithTitle.this.d();
    }

    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      WebViewWithTitle.this.c();
    }

    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if (super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString))
        return true;
      if (WebViewWithTitle.this.a(paramAnonymousString))
      {
        asq.i(WebViewWithTitle.this.getContext(), paramAnonymousString);
        return true;
      }
      return WebViewWithTitle.this.b(paramAnonymousString);
    }
  };

  public WebViewWithTitle(Context paramContext)
  {
    this(paramContext, null);
  }

  public WebViewWithTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public WebViewWithTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }

  @TargetApi(21)
  public WebViewWithTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    e();
  }

  private void c(final String paramString)
  {
    if (this.b != null)
      this.b.post(new Runnable()
      {
        public void run()
        {
          try
          {
            WebViewWithTitle.this.b.loadUrl(paramString);
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
      });
  }

  private void e()
  {
    if ((Build.VERSION.SDK_INT < 16) || ((Build.VERSION.SDK_INT < 17) && (aqs.p())))
      setLayerType(1, null);
  }

  private void f()
  {
    c("about:blank");
  }

  private void g()
  {
    c(this.d);
  }

  public void a()
  {
    this.b.destroy();
  }

  public void a(CharSequence paramCharSequence, String paramString)
  {
    this.d = paramString;
    paramCharSequence = (LayoutParams)this.e.getLayoutParams();
    if (vs.B(getContext()));
    for (int i = 3; ; i = 5)
    {
      paramCharSequence.gravity = (i | 0x50);
      b();
      return;
    }
  }

  protected boolean a(String paramString)
  {
    return false;
  }

  void b()
  {
    if (arl.i(getContext()))
    {
      this.c.a();
      g();
      return;
    }
    this.c.b();
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
        asq.d(getContext(), paramString);
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString)
    {
    }
    return false;
  }

  protected void c()
  {
    this.c.b();
  }

  protected void d()
  {
    this.b.scrollTo(0, 0);
    if (this.c.isShown())
      this.c.f();
  }

  protected azq getJsInterface()
  {
    return null;
  }

  protected String getJsInterfaceName()
  {
    return null;
  }

  protected int getWebViewBgColor()
  {
    return -1;
  }

  public void onClick(View paramView)
  {
    ((ViewGroup)getParent()).removeView(this);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    f();
    setVisibility(4);
    this.b.removeAllViews();
  }

  @SuppressLint({"JavascriptInterface"})
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(this);
    this.e = asr.a(this, 2131755540);
    this.e.setOnClickListener(this);
    this.c = ((OnlineLoadingView)findViewById(2131755099));
    this.c.setActionClickListener(new sr()
    {
      public void b()
      {
        WebViewWithTitle.this.b();
      }
    });
    this.a = ((ViewGroup)findViewById(2131755543));
    this.b = new azo(getContext().getApplicationContext());
    this.a.addView(this.b, new ViewGroup.LayoutParams(-1, -1));
    this.b.setWebChromeClient(this.f);
    this.b.setWebViewClient(this.g);
    azq localazq = getJsInterface();
    String str = getJsInterfaceName();
    if ((str != null) && (localazq != null))
      this.b.addJavascriptInterface(localazq, str);
    int i = getWebViewBgColor();
    this.b.setBackgroundColor(i);
    this.a.setBackgroundDrawable(atw.a(asq.a(2.0F), i));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.view.WebViewWithTitle
 * JD-Core Version:    0.6.2
 */