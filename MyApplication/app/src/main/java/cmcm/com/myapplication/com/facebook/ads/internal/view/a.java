package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.webkit.WebSettings;
import com.facebook.ads.internal.adapters.d.a;
import com.facebook.ads.internal.util.h;

public class a extends d
{
  private final a.a a;
  private com.facebook.ads.internal.adapters.d b;

  public a(Context paramContext, final a.a parama, int paramInt)
  {
    super(paramContext);
    this.a = parama;
    setWebViewClient(new a.b(this, null));
    getSettings().setJavaScriptEnabled(true);
    getSettings().setSupportZoom(false);
    h.b(this);
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(false);
    addJavascriptInterface(new a.c(this), "AdControl");
    this.b = new com.facebook.ads.internal.adapters.d(getContext(), this, paramInt, new d.a()
    {
      public void a()
      {
        parama.b();
      }
    });
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt1);
    this.b.b(paramInt2);
  }

  public void destroy()
  {
    if (this.b != null)
    {
      this.b.b();
      this.b = null;
    }
    h.a(this);
    super.destroy();
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (this.a != null)
      this.a.a(paramInt);
    if (paramInt == 0)
      if (this.b != null)
        this.b.a();
    while ((paramInt != 8) || (this.b == null))
      return;
    this.b.b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.a
 * JD-Core Version:    0.6.2
 */