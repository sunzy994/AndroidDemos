package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.webkit.WebView;

public class d extends WebView
{
  private boolean a;

  public d(Context paramContext)
  {
    super(paramContext);
  }

  public boolean b()
  {
    return this.a;
  }

  public void destroy()
  {
    this.a = true;
    super.destroy();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.d
 * JD-Core Version:    0.6.2
 */