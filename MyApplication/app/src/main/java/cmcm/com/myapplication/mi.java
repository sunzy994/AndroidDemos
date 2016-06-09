package cmcm.com.myapplication;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

public final class mi
{
  public WebView a;
  public int b;
  public boolean c = false;

  public mi(Context paramContext)
  {
    this.a = new WebView(paramContext);
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.getSettings().setCacheMode(2);
    this.a.getSettings().setLoadsImagesAutomatically(true);
    this.a.getSettings().setBlockNetworkImage(false);
    this.a.setVisibility(0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mi
 * JD-Core Version:    0.6.2
 */