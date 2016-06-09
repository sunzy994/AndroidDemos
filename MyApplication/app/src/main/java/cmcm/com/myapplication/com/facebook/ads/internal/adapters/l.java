package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.r;
import com.facebook.ads.internal.view.d;
import java.util.Collections;
import java.util.Map;

public class l extends a
{
  private static final String b = l.class.getSimpleName();
  private final d c;
  private k d;
  private boolean e;

  public l(Context paramContext, d paramd, b paramb)
  {
    super(paramContext, paramb);
    this.c = paramd;
  }

  private void a(Map<String, String> paramMap)
  {
    if (this.d == null);
    String str;
    do
    {
      return;
      str = this.d.f();
    }
    while (r.a(str));
    new o(paramMap).execute(new String[] { str });
  }

  public void a(k paramk)
  {
    this.d = paramk;
  }

  protected void b()
  {
    if (this.d == null)
      return;
    if ((this.c != null) && (!r.a(this.d.g())))
    {
      if (!this.c.b())
        break label59;
      Log.w(b, "Webview already destroyed, cannot send impression");
    }
    while (true)
    {
      a(Collections.singletonMap("evt", "native_imp"));
      return;
      label59: this.c.loadUrl("javascript:" + this.d.g());
    }
  }

  public void c()
  {
    try
    {
      if (!this.e)
      {
        k localk = this.d;
        if (localk != null)
          break label21;
      }
      while (true)
      {
        return;
        label21: this.e = true;
        if ((this.c != null) && (!r.a(this.d.e())))
          this.c.post(new Runnable()
          {
            public void run()
            {
              if (l.a(l.this).b())
              {
                Log.w(l.e(), "Webview already destroyed, cannot activate");
                return;
              }
              l.a(l.this).loadUrl("javascript:" + l.b(l.this).e());
            }
          });
      }
    }
    finally
    {
    }
  }

  public void d()
  {
    a(Collections.singletonMap("evt", "interstitial_displayed"));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.l
 * JD-Core Version:    0.6.2
 */