package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.duapps.ad.b.a;

final class mb extends WebViewClient
{
  mb(lz paramlz)
  {
  }

  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    mv.c("InMobiDataExecutor", "resource load:");
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    int i = 0;
    lz.a(this.a, false);
    if (this.a.c != null)
      this.a.c.c = false;
    lz.c(this.a);
    mv.c("InMobiDataExecutor", "page finished:" + this.a.a.p);
    if (this.a.b == lv.a);
    while (true)
    {
      mv.c("InMobiDataExecutor", "AdOperationType==" + i);
      mv.c("InMobiDataExecutor", " completed");
      return;
      i = 1;
    }
  }

  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    mv.c("InMobiDataExecutor", "page started:");
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    mv.c("InMobiDataExecutor", "received error:" + paramInt + "\tdesc:" + paramString1 + "\n" + paramString2);
    lz.a(this.a, false);
    if (this.a.c != null)
      this.a.c.c = false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mb
 * JD-Core Version:    0.6.2
 */