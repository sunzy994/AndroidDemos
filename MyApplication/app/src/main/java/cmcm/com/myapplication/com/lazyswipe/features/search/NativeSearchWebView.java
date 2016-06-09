package cmcm.com.myapplication.com.lazyswipe.features.search;

import ags;
import agu;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import api;
import arl;
import aso;
import asq;
import azn;
import azp;
import azq;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import sr;
import yb;

public class NativeSearchWebView extends FrameLayout
{
  private static final String a = "Swipe." + NativeSearchWebView.class.getSimpleName();
  private ags b;
  private OnlineLoadingView c;
  private ViewGroup d;
  private ViewGroup e;
  private String f;
  private boolean g;
  private agu h;
  private View i;
  private View j;
  private final WebViewClient k = new azp()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
    }

    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      NativeSearchWebView.this.a();
    }

    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if (super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString))
        return true;
      if (NativeSearchWebView.this.a(paramAnonymousWebView, paramAnonymousString))
      {
        yb.p();
        asq.i(NativeSearchWebView.this.getContext(), paramAnonymousString);
        return true;
      }
      NativeSearchWebView.a(NativeSearchWebView.this, paramAnonymousString);
      return true;
    }
  };
  private final WebChromeClient l = new azn()
  {
    public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
    {
      return super.onConsoleMessage(paramAnonymousConsoleMessage);
    }

    public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      aso.a(NativeSearchWebView.this.getContext(), paramAnonymousString2);
      paramAnonymousJsResult.confirm();
      return true;
    }

    public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
    {
      if (NativeSearchWebView.this.getWebView() != null)
      {
        if (NativeSearchWebView.c(NativeSearchWebView.this) == null)
          break label166;
        if (!TextUtils.isEmpty(NativeSearchWebView.c(NativeSearchWebView.this).f()))
          NativeSearchWebView.this.getWebView().loadUrl("javascript:" + NativeSearchWebView.c(NativeSearchWebView.this).f());
      }
      while (true)
      {
        if (paramAnonymousInt >= 90)
          NativeSearchWebView.d(NativeSearchWebView.this).removeMessages(1);
        if ((paramAnonymousInt != 100) || ((paramAnonymousInt <= 100) && (NativeSearchWebView.e(NativeSearchWebView.this).getVisibility() == 0)))
          ((api)NativeSearchWebView.e(NativeSearchWebView.this).getBackground()).a(paramAnonymousInt);
        if ((paramAnonymousInt >= 100) && (!NativeSearchWebView.f(NativeSearchWebView.this).e()))
          NativeSearchWebView.this.b();
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        return;
        label166: NativeSearchWebView.this.getWebView().loadUrl("javascript:document.getElementById('page_hd').style.display='none'");
      }
    }
  };
  private final Handler m = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (!NativeSearchWebView.g(NativeSearchWebView.this));
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
        while (NativeSearchWebView.a(NativeSearchWebView.this) == null);
        Log.e(NativeSearchWebView.f(), "Load page [" + NativeSearchWebView.b(NativeSearchWebView.this) + "] timeout on " + NativeSearchWebView.a(NativeSearchWebView.this).getProgress() + "%, force stop loading.");
        NativeSearchWebView.this.a();
        NativeSearchWebView.a(NativeSearchWebView.this).stopLoading();
        return;
      }
      while ((NativeSearchWebView.a(NativeSearchWebView.this) == null) || (NativeSearchWebView.a(NativeSearchWebView.this).getProgress() >= 90));
      NativeSearchWebView.d(NativeSearchWebView.this).sendEmptyMessage(0);
    }
  };
  private final Handler n = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 0:
        NativeSearchWebView.h(NativeSearchWebView.this);
        return;
      case 1:
      }
      NativeSearchWebView.i(NativeSearchWebView.this);
    }
  };
  private boolean o = false;

  public NativeSearchWebView(Context paramContext)
  {
    super(paramContext);
  }

  public NativeSearchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NativeSearchWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(String paramString)
  {
    this.f = paramString;
    a(false);
  }

  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.c.e())
        this.c.a();
      d();
      this.j.setVisibility(0);
    }
    do
    {
      return;
      if (i())
      {
        this.b.setVisibility(8);
        this.c.a();
        if (this.e != this.d)
          this.e.setVisibility(0);
        d();
        this.j.setVisibility(8);
        this.m.sendEmptyMessageDelayed(1, 120000L);
        return;
      }
      this.b.setVisibility(8);
      this.c.b();
      this.j.setVisibility(8);
    }
    while (this.e == this.d);
    this.e.setVisibility(0);
  }

  private void g()
  {
    this.b = new ags(this, getContext());
    this.b.setWebChromeClient(this.l);
    this.b.setWebViewClient(this.k);
    azq localazq = getJsInterface();
    String str = getJsInterfaceName();
    if ((str != null) && (localazq != null))
      this.b.addJavascriptInterface(localazq, str);
    this.d.addView(this.b, -1, -1);
    this.b.setBackgroundColor(-1118482);
    this.b.setVisibility(8);
  }

  private void h()
  {
    this.c = ((OnlineLoadingView)LayoutInflater.from(getContext()).inflate(2130968657, null));
    this.c.setActionClickListener(new sr()
    {
      public void b()
      {
        NativeSearchWebView.a(NativeSearchWebView.this, true);
      }
    });
    this.e.addView(this.c, -1, -1);
  }

  private boolean i()
  {
    return arl.i(getContext());
  }

  private void j()
  {
    if (m());
    while (this.i.getVisibility() == 0)
      return;
    this.i.setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 2.0F, 1, 0.0F);
    localTranslateAnimation.setAnimationListener(new AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        NativeSearchWebView.j(NativeSearchWebView.this).clearAnimation();
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    localTranslateAnimation.setDuration(400L);
    this.i.startAnimation(localTranslateAnimation);
  }

  private void k()
  {
    if (m());
    while (this.i.getVisibility() == 4)
      return;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 2.0F);
    localTranslateAnimation.setAnimationListener(new AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        NativeSearchWebView.j(NativeSearchWebView.this).setVisibility(4);
        NativeSearchWebView.j(NativeSearchWebView.this).clearAnimation();
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    localTranslateAnimation.setDuration(400L);
    this.i.startAnimation(localTranslateAnimation);
  }

  private boolean l()
  {
    return this.i.getVisibility() != 8;
  }

  private boolean m()
  {
    return this.i.getAnimation() != null;
  }

  protected void a()
  {
    this.b.setVisibility(8);
    this.c.b();
    this.j.setVisibility(8);
    if (this.e != this.d)
      this.e.setVisibility(0);
  }

  public void a(agu paramagu, String paramString)
  {
    this.h = paramagu;
    if (this.b == null)
      g();
    if (this.c == null)
      h();
    a(paramString);
  }

  protected boolean a(WebView paramWebView, String paramString)
  {
    boolean bool = true;
    if (paramString.contains(this.h.b()));
    do
    {
      return false;
      paramWebView = paramWebView.getHitTestResult();
    }
    while (paramWebView == null);
    int i1 = paramWebView.getType();
    if (i1 == 7)
      return true;
    if (i1 != 0);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  protected void b()
  {
    if (this.b == null)
      return;
    if (this.f != null)
      this.i.setVisibility(0);
    while (true)
    {
      this.b.setVisibility(0);
      this.b.a();
      this.c.f();
      this.j.setVisibility(8);
      if (this.e == this.d)
        break;
      this.e.setVisibility(8);
      return;
      this.i.setVisibility(8);
    }
  }

  protected void c()
  {
    if (this.b != null)
      this.b.stopLoading();
  }

  protected void d()
  {
    this.i.setVisibility(8);
    this.b.post(new Runnable()
    {
      public void run()
      {
        if (NativeSearchWebView.a(NativeSearchWebView.this) != null)
          NativeSearchWebView.a(NativeSearchWebView.this).loadUrl(NativeSearchWebView.b(NativeSearchWebView.this));
      }
    });
  }

  public boolean e()
  {
    if ((this.b != null) && (this.b.canGoBack()))
    {
      WebBackForwardList localWebBackForwardList = this.b.copyBackForwardList();
      this.f = localWebBackForwardList.getItemAtIndex(localWebBackForwardList.getCurrentIndex() - 1).getUrl();
      this.b.goBack();
      return true;
    }
    return false;
  }

  public View getGlobalSearchBtn()
  {
    return this.i;
  }

  protected azq getJsInterface()
  {
    return null;
  }

  protected String getJsInterfaceName()
  {
    return "Android";
  }

  protected int getLoadingContainerId()
  {
    return 2131755455;
  }

  protected WebView getWebView()
  {
    return this.b;
  }

  protected int getWebViewContainerId()
  {
    return 2131755454;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.g)
      return;
    this.g = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (!this.g);
    while (true)
    {
      return;
      this.g = false;
      try
      {
        CookieSyncManager.getInstance().sync();
        if (this.b != null)
        {
          this.d.removeView(this.b);
          this.b.removeAllViews();
          this.b.destroy();
          this.b = null;
        }
        if (this.c != null)
        {
          this.e.removeView(this.c);
          this.c = null;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((ViewGroup)findViewById(getWebViewContainerId()));
    this.e = ((ViewGroup)findViewById(getLoadingContainerId()));
    this.i = findViewById(2131755456);
    this.j = findViewById(2131755457);
    this.j.setBackgroundDrawable(new api(-16748320, -16748320));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.search.NativeSearchWebView
 * JD-Core Version:    0.6.2
 */