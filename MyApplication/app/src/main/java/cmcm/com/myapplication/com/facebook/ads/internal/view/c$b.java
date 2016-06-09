package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.facebook.ads.internal.adapters.d;
import com.facebook.ads.internal.util.a;
import com.facebook.ads.internal.util.g;

class c$b
{
  private final String b = b.class.getSimpleName();

  private c$b(c paramc)
  {
  }

  @JavascriptInterface
  public void alert(String paramString)
  {
    Log.e(this.b, paramString);
  }

  @JavascriptInterface
  public String getAnalogInfo()
  {
    return g.a(a.a());
  }

  @JavascriptInterface
  public void onPageInitialized()
  {
    if (this.a.b());
    do
    {
      return;
      c.c(this.a);
    }
    while (c.d(this.a) == null);
    c.d(this.a).a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.c.b
 * JD-Core Version:    0.6.2
 */