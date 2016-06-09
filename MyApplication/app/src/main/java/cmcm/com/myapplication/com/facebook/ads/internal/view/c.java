package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.webkit.WebSettings;
import com.facebook.ads.internal.adapters.d.a;
import com.facebook.ads.internal.adapters.k;
import com.facebook.ads.internal.adapters.l;
import com.facebook.ads.internal.ssp.ANAdRenderer.Listener;
import com.facebook.ads.internal.util.b.a;
import com.facebook.ads.internal.util.h;

public class c extends d
{
  private static final String a = c.class.getSimpleName();
  private final k b;
  private final int c;
  private final ANAdRenderer.Listener d;
  private l e;
  private com.facebook.ads.internal.adapters.d f;
  private long g;
  private b.a h;

  public c(Context paramContext, k paramk, int paramInt, ANAdRenderer.Listener paramListener)
  {
    super(paramContext);
    if ((paramk == null) || (paramListener == null))
      throw new IllegalArgumentException();
    this.b = paramk;
    this.c = paramInt;
    this.d = paramListener;
    c();
  }

  private void c()
  {
    setWebViewClient(new c.a(this, null));
    getSettings().setJavaScriptEnabled(true);
    getSettings().setSupportZoom(false);
    h.b(this);
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(false);
    addJavascriptInterface(new c.b(this, null), "AdControl");
    this.e = new l(getContext(), this, new com.facebook.ads.internal.adapters.b()
    {
      public void d()
      {
        c.a(c.this).onAdImpression();
      }
    });
    this.e.a(this.b);
    this.f = new com.facebook.ads.internal.adapters.d(getContext(), this, this.c, new d.a()
    {
      public void a()
      {
        c.b(c.this).a();
      }
    });
    this.f.a(this.b.j());
    this.f.b(this.b.k());
    this.f.a();
    loadDataWithBaseURL(h.a(), this.b.d(), "text/html", "utf-8", null);
  }

  private void d()
  {
    this.e.c();
  }

  public void destroy()
  {
    if (this.f != null)
    {
      this.f.b();
      this.f = null;
    }
    h.a(this);
    super.destroy();
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
    {
      if ((this.g > 0L) && (this.h != null))
      {
        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(this.g, this.h, this.b.i()));
        this.g = 0L;
        this.h = null;
      }
      if (this.f != null)
        this.f.a();
    }
    while ((paramInt != 8) || (this.f == null))
      return;
    this.f.b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.c
 * JD-Core Version:    0.6.2
 */