package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.facebook.ads.internal.adapters.d;
import com.facebook.ads.internal.util.g;

public class a$c
{
  private final String b = c.class.getSimpleName();

  public a$c(a parama)
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
    return g.a(com.facebook.ads.internal.util.a.a());
  }

  @JavascriptInterface
  public void onPageInitialized()
  {
    if (this.a.b());
    do
    {
      return;
      a.a(this.a).a();
    }
    while (a.b(this.a) == null);
    a.b(this.a).a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.a.c
 * JD-Core Version:    0.6.2
 */