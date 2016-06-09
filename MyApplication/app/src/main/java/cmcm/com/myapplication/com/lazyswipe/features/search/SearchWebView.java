package cmcm.com.myapplication.com.lazyswipe.features.search;

import agu;
import ahe;
import ahg;
import ahh;
import ahi;
import ahk;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import api;
import arb;
import arl;
import aso;
import asq;
import azn;
import azp;
import azq;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import sr;
import vy;
import yb;

public class SearchWebView extends FrameLayout
  implements OnClickListener, OnItemClickListener
{
  private long a;
  private ahg b;
  private OnlineLoadingView c;
  private ViewGroup d;
  private ViewGroup e;
  private String f;
  private boolean g = true;
  private boolean h;
  private String i;
  private int j;
  private agu k;
  private View l;
  private View m;
  private final WebViewClient n = new azp()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if (SearchWebView.a(SearchWebView.this, paramAnonymousString))
        paramAnonymousWebView.loadUrl("javascript: document.getElementById('q').addEventListener('click', function() {\nwindow.Android.onInput(document.getElementById('q').value); }, false);document.getElementById('q').addEventListener('focus',  function() {\nwindow.Android.onInput(document.getElementById('q').value); }, false);document.getElementById('q').addEventListener('input',  function() {\nwindow.Android.onInput(document.getElementById('q').value); }, false);document.getElementsByClassName('sclear')[0].addEventListener('click',  function() {\nwindow.Android.onInput(''); }, false);");
    }

    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      SearchWebView.this.a();
    }

    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if (super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString))
        return true;
      if (SearchWebView.this.a(paramAnonymousWebView, paramAnonymousString))
      {
        yb.p();
        asq.i(SearchWebView.this.getContext(), paramAnonymousString);
        return true;
      }
      SearchWebView.b(SearchWebView.this, paramAnonymousString);
      return true;
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
      aso.a(SearchWebView.this.getContext(), paramAnonymousString2);
      paramAnonymousJsResult.confirm();
      return true;
    }

    public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
    {
      if (paramAnonymousInt >= 90)
      {
        SearchWebView.i(SearchWebView.this).removeMessages(1);
        SearchWebView.a(SearchWebView.this, SearchWebView.c(SearchWebView.this), false, false);
      }
      if ((paramAnonymousInt != 100) || ((paramAnonymousInt <= 100) && (SearchWebView.j(SearchWebView.this).getVisibility() == 0)))
        ((api)SearchWebView.j(SearchWebView.this).getBackground()).a(paramAnonymousInt);
      if ((paramAnonymousInt >= 100) && (!SearchWebView.k(SearchWebView.this).e()))
        SearchWebView.this.b();
      super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
    }
  };
  private final Handler p = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (!SearchWebView.l(SearchWebView.this));
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
            SearchWebView.a(SearchWebView.this, SearchWebView.c(SearchWebView.this), true, false);
          case 1:
          }
        }
        while (SearchWebView.a(SearchWebView.this) == null);
        Log.e("Swipe.SearchWebView", "Load page [" + SearchWebView.c(SearchWebView.this) + "] timeout on " + SearchWebView.a(SearchWebView.this).getProgress() + "%, force stop loading.");
        SearchWebView.this.a();
        SearchWebView.a(SearchWebView.this).stopLoading();
        return;
      }
      while ((SearchWebView.a(SearchWebView.this) == null) || (SearchWebView.a(SearchWebView.this).getProgress() >= 90));
      SearchWebView.i(SearchWebView.this).sendEmptyMessage(0);
    }
  };
  private View q;
  private ahi r;
  private ListView s;
  private SuggestionAppsHolder t;
  private final Handler u = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 0:
        SearchWebView.n(SearchWebView.this);
        return;
      case 1:
      }
      SearchWebView.o(SearchWebView.this);
    }
  };
  private boolean v = false;

  public SearchWebView(Context paramContext)
  {
    super(paramContext);
  }

  public SearchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SearchWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a >= 0L))
    {
      System.currentTimeMillis();
      long l1 = this.a;
    }
    this.a = -1L;
  }

  private void a(boolean paramBoolean)
  {
    if (!c(this.f))
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    if ((!paramBoolean) && (!this.g) && (!c(this.f)))
    {
      this.g = false;
      c();
      this.m.setVisibility(0);
    }
    do
    {
      return;
      this.g = false;
      if (g())
      {
        this.b.setVisibility(8);
        this.c.a();
        if (this.e != this.d)
          this.e.setVisibility(0);
        c();
        this.m.setVisibility(8);
        this.p.sendEmptyMessageDelayed(1, 120000L);
        return;
      }
      this.b.setVisibility(8);
      this.c.b();
      this.m.setVisibility(8);
    }
    while (this.e == this.d);
    this.e.setVisibility(0);
  }

  private void b(String paramString)
  {
    this.f = paramString;
    a(false);
  }

  private boolean c(String paramString)
  {
    return (paramString != null) && ((paramString.equals(this.k.c())) || (paramString.equals("file:///android_asset/html/omni_search.html")));
  }

  @SuppressLint({"JavascriptInterface"})
  private void e()
  {
    this.b = new ahg(this, getContext());
    this.b.setWebChromeClient(this.o);
    this.b.setWebViewClient(this.n);
    azq localazq = getJsInterface();
    String str = getJsInterfaceName();
    if ((str != null) && (localazq != null))
      this.b.addJavascriptInterface(localazq, str);
    this.d.addView(this.b, -1, -1);
    this.b.setBackgroundColor(-1118482);
    this.b.setVisibility(8);
  }

  private void f()
  {
    this.c = ((OnlineLoadingView)LayoutInflater.from(getContext()).inflate(2130968657, null));
    this.c.setActionClickListener(new sr()
    {
      public void b()
      {
        SearchWebView.a(SearchWebView.this, true);
      }
    });
    this.e.addView(this.c, -1, -1);
  }

  private boolean g()
  {
    if (arl.i(getContext()));
    while ((this.f != null) && (this.f.startsWith("file:///android_asset/")))
      return true;
    return false;
  }

  private String getFocusJs()
  {
    return "function setCaretPosition(elemId, caretPos) {\n    var el = document.getElementById(elemId);\n\n    if (el != null) {\n        el.value = el.value;\n    }\n};";
  }

  private void h()
  {
    if (k());
    while (this.l.getVisibility() != 4)
      return;
    this.l.setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 2.0F, 1, 0.0F);
    localTranslateAnimation.setAnimationListener(new AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        SearchWebView.p(SearchWebView.this).clearAnimation();
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    localTranslateAnimation.setDuration(400L);
    this.l.startAnimation(localTranslateAnimation);
  }

  private void i()
  {
    if (k());
    while (this.l.getVisibility() == 4)
      return;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 2.0F);
    localTranslateAnimation.setAnimationListener(new AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (SearchWebView.p(SearchWebView.this).getVisibility() != 8)
          SearchWebView.p(SearchWebView.this).setVisibility(4);
        SearchWebView.p(SearchWebView.this).clearAnimation();
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    localTranslateAnimation.setDuration(400L);
    this.l.startAnimation(localTranslateAnimation);
  }

  private boolean j()
  {
    return this.l.getVisibility() != 8;
  }

  private boolean k()
  {
    return this.l.getAnimation() != null;
  }

  protected void a()
  {
    this.b.setVisibility(8);
    this.c.b();
    this.m.setVisibility(8);
    if (this.e != this.d)
      this.e.setVisibility(0);
  }

  public void a(agu paramagu, String paramString1, String paramString2, int paramInt)
  {
    this.k = paramagu;
    this.i = paramString2;
    this.j = paramInt;
    b(paramString1);
  }

  public void a(String paramString)
  {
    ahe.a(getContext(), paramString);
    vy.a(getContext(), "CK", String.valueOf(this.j));
    b(this.k.b(paramString));
  }

  protected boolean a(WebView paramWebView, String paramString)
  {
    boolean bool = true;
    if (paramString.contains(this.k.b()));
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
    if (c(this.f))
    {
      if (!TextUtils.isEmpty(this.i))
        this.b.post(new Runnable()
        {
          public void run()
          {
            if (SearchWebView.a(SearchWebView.this) != null)
              SearchWebView.a(SearchWebView.this).loadUrl("javascript:(function(){document.getElementById('q').placeholder='" + SearchWebView.b(SearchWebView.this) + "';})();");
          }
        });
      this.b.postDelayed(new Runnable()
      {
        public void run()
        {
          if (SearchWebView.a(SearchWebView.this) != null)
          {
            SearchWebView.a(SearchWebView.this).requestFocus();
            SearchWebView.a(SearchWebView.this).loadUrl("javascript:document.getElementById('q').focus()");
            ((InputMethodManager)SearchWebView.this.getContext().getSystemService("input_method")).toggleSoftInput(1, 0);
          }
        }
      }
      , 500L);
    }
    if (this.f != null)
      if (("http://www.mysearch.com".equals(arb.a(this.f))) || (c(this.f)))
        this.l.setVisibility(0);
    while (true)
    {
      this.b.setVisibility(0);
      this.b.a();
      this.c.f();
      this.m.setVisibility(8);
      if (this.e == this.d)
        break;
      this.e.setVisibility(8);
      return;
      this.l.setVisibility(8);
      continue;
      this.l.setVisibility(8);
    }
  }

  protected void c()
  {
    this.l.setVisibility(8);
    this.b.post(new Runnable()
    {
      public void run()
      {
        if ((SearchWebView.a(SearchWebView.this) == null) || ((SearchWebView.c(SearchWebView.this) != null) && (arb.a(SearchWebView.c(SearchWebView.this)).equals(arb.a(SearchWebView.d(SearchWebView.this).b("####"))))));
        try
        {
          Iterator localIterator = URLEncodedUtils.parse(new URI(SearchWebView.d(SearchWebView.this).b("####")), "utf-8").iterator();
          Object localObject2;
          String str;
          do
          {
            if (!localIterator.hasNext())
              break;
            localObject2 = (NameValuePair)localIterator.next();
            str = ((NameValuePair)localObject2).getName();
            localObject2 = ((NameValuePair)localObject2).getValue();
          }
          while ((localObject2 == null) || (!((String)localObject2).equals("####")));
          if (str != null)
          {
            localIterator = URLEncodedUtils.parse(new URI(SearchWebView.c(SearchWebView.this)), "utf-8").iterator();
            while (localIterator.hasNext())
            {
              Object localObject3 = (NameValuePair)localIterator.next();
              localObject2 = ((NameValuePair)localObject3).getName();
              localObject3 = ((NameValuePair)localObject3).getValue();
              if ((localObject2 != null) && (((String)localObject2).equals(str)))
              {
                ahe.a(SearchWebView.this.getContext(), (String)localObject3);
                vy.a(SearchWebView.this.getContext(), "CK", String.valueOf(SearchWebView.e(SearchWebView.this)));
              }
            }
          }
          SearchWebView.f(SearchWebView.this).setVisibility(8);
          SearchWebView.g(SearchWebView.this).a();
          SearchWebView.h(SearchWebView.this).b();
          SearchWebView.a(SearchWebView.this).loadUrl(SearchWebView.c(SearchWebView.this));
          SearchWebView.a(SearchWebView.this, System.currentTimeMillis());
          return;
        }
        catch (Throwable localThrowable)
        {
          while (true)
          {
            Log.e("Swipe.SearchWebView", "Failed", localThrowable);
            continue;
            Object localObject1 = null;
          }
        }
      }
    });
  }

  public boolean d()
  {
    a(this.f, false, true);
    if ((this.b != null) && (this.b.canGoBack()))
    {
      WebBackForwardList localWebBackForwardList = this.b.copyBackForwardList();
      this.f = localWebBackForwardList.getItemAtIndex(localWebBackForwardList.getCurrentIndex() - 1).getUrl();
      this.b.goBack();
      return true;
    }
    return false;
  }

  protected azq getJsInterface()
  {
    return new ahh(this, getContext());
  }

  protected String getJsInterfaceName()
  {
    return "Android";
  }

  protected int getLoadingContainerId()
  {
    return 2131755455;
  }

  public agu getSearchEngine()
  {
    return this.k;
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
    if (this.h)
      return;
    e();
    f();
    this.h = true;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.l)
      this.b.postDelayed(new Runnable()
      {
        public void run()
        {
          if (SearchWebView.a(SearchWebView.this) != null)
          {
            SearchWebView.a(SearchWebView.this).scrollTo(0, 0);
            SearchWebView.a(SearchWebView.this).requestFocus();
            SearchWebView.a(SearchWebView.this).loadUrl("javascript:document.getElementById('q').focus()");
            SearchWebView.a(SearchWebView.this).loadUrl("javascript:" + SearchWebView.m(SearchWebView.this) + "\nsetCaretPosition('q', 100)");
            ((InputMethodManager)SearchWebView.this.getContext().getSystemService("input_method")).toggleSoftInput(1, 0);
          }
        }
      }
      , 500L);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (!this.h)
      return;
    this.h = false;
    try
    {
      CookieSyncManager.getInstance().sync();
      this.d.removeView(this.b);
      this.e.removeView(this.c);
      this.b.removeAllViews();
      this.b.destroy();
      this.b = null;
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((ViewGroup)findViewById(getWebViewContainerId()));
    this.e = ((ViewGroup)findViewById(getLoadingContainerId()));
    this.q = findViewById(2131755472);
    this.l = findViewById(2131755456);
    this.l.setOnClickListener(this);
    this.r = new ahi(getContext(), this, new ArrayList());
    this.s = ((ListView)findViewById(2131755046));
    this.s.setAdapter(this.r);
    this.s.setOnItemClickListener(this);
    this.t = ((SuggestionAppsHolder)findViewById(2131755473));
    this.m = findViewById(2131755457);
    this.m.setBackgroundDrawable(new api(-16748320, -16748320));
    onAttachedToWindow();
    setOnClickListener(this);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ahk)this.r.getItem(paramInt);
    if (paramAdapterView != null)
      a(paramAdapterView.e());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.search.SearchWebView
 * JD-Core Version:    0.6.2
 */