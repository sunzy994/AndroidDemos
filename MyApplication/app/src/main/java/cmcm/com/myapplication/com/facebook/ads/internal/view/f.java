package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.adapters.k;
import com.facebook.ads.internal.adapters.l;
import com.facebook.ads.internal.util.b.a;
import com.facebook.ads.internal.util.c;

public class f
  implements h
{
  private static final String a = f.class.getSimpleName();
  private h.a b;
  private a c;
  private k d;
  private l e;
  private long f;
  private long g;
  private b.a h;

  public f(final InterstitialAdActivity paramInterstitialAdActivity, h.a parama)
  {
    this.b = parama;
    this.f = System.currentTimeMillis();
    this.c = new a(paramInterstitialAdActivity, new a.a()
    {
      public void a()
      {
        f.b(f.this).c();
      }

      public void a(int paramAnonymousInt)
      {
      }

      public void a(String paramAnonymousString)
      {
        paramAnonymousString = Uri.parse(paramAnonymousString);
        if (("fbad".equals(paramAnonymousString.getScheme())) && ("close".equals(paramAnonymousString.getAuthority())))
          paramInterstitialAdActivity.finish();
        do
        {
          return;
          f.a(f.this).a("com.facebook.ads.interstitial.clicked");
          paramAnonymousString = com.facebook.ads.internal.action.b.a(paramInterstitialAdActivity, paramAnonymousString);
        }
        while (paramAnonymousString == null);
        try
        {
          f.a(f.this, paramAnonymousString.a());
          f.a(f.this, System.currentTimeMillis());
          paramAnonymousString.b();
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(f.d(), "Error executing action", paramAnonymousString);
        }
      }

      public void b()
      {
        f.b(f.this).a();
      }
    }
    , 1);
    this.c.setId(100001);
    this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.e = new l(paramInterstitialAdActivity, this.c, new com.facebook.ads.internal.adapters.b()
    {
      public void d()
      {
        f.a(f.this).a("com.facebook.ads.interstitial.impression.logged");
      }
    });
    this.e.d();
    parama.a(this.c);
  }

  public void a()
  {
    if (this.c != null)
      this.c.onPause();
  }

  public void a(Intent paramIntent, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("dataModel")))
    {
      this.d = k.a(paramBundle.getBundle("dataModel"));
      if (this.d != null)
      {
        this.c.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), this.d.d(), "text/html", "utf-8", null);
        this.c.a(this.d.j(), this.d.k());
      }
    }
    do
    {
      return;
      this.d = k.b(paramIntent);
    }
    while (this.d == null);
    this.e.a(this.d);
    this.c.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), this.d.d(), "text/html", "utf-8", null);
    this.c.a(this.d.j(), this.d.k());
  }

  public void a(Bundle paramBundle)
  {
    if (this.d != null)
      paramBundle.putBundle("dataModel", this.d.l());
  }

  public void b()
  {
    if ((this.g > 0L) && (this.h != null) && (this.d != null))
      c.a(com.facebook.ads.internal.util.b.a(this.g, this.h, this.d.i()));
    if (this.c != null)
      this.c.onResume();
  }

  public void c()
  {
    if (this.d != null)
      c.a(com.facebook.ads.internal.util.b.a(this.f, b.a.c, this.d.i()));
    if (this.c != null)
    {
      com.facebook.ads.internal.util.h.a(this.c);
      this.c.destroy();
      this.c = null;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.f
 * JD-Core Version:    0.6.2
 */