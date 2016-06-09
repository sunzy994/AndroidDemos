package cmcm.com.myapplication;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class azo extends WebView
{
  public azo(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    getSettings().setJavaScriptEnabled(true);
    getSettings().setSavePassword(false);
    setScrollBarStyle(0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azo
 * JD-Core Version:    0.6.2
 */