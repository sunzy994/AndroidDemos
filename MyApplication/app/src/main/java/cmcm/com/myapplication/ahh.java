package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.lazyswipe.features.search.SearchWebView;
import com.lazyswipe.features.search.SuggestionAppsHolder;

public class ahh extends azq
{
  private final Handler b;

  public ahh(SearchWebView paramSearchWebView, Context paramContext)
  {
    this.b = new Handler(paramContext.getMainLooper());
  }

  @JavascriptInterface
  public void onInput(final String paramString)
  {
    if (!SearchWebView.a(this.a, SearchWebView.c(this.a)))
      return;
    this.b.post(new Runnable()
    {
      public void run()
      {
        SearchWebView.f(ahh.this.a).setVisibility(0);
        SearchWebView.g(ahh.this.a).b();
        SearchWebView.h(ahh.this.a).a();
        SearchWebView.g(ahh.this.a).a(paramString);
        SearchWebView.h(ahh.this.a).a(paramString, SearchWebView.e(ahh.this.a));
      }
    });
  }

  @JavascriptInterface
  public void search(final String paramString)
  {
    if (!SearchWebView.a(this.a, SearchWebView.c(this.a)))
      return;
    this.b.post(new Runnable()
    {
      public void run()
      {
        SearchWebView.b(ahh.this.a, paramString);
      }
    });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahh
 * JD-Core Version:    0.6.2
 */