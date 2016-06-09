package cmcm.com.myapplication.com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;
import com.facebook.ads.internal.util.b.a;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.r;

public abstract class a
{
  public abstract b.a a();

  protected void a(Context paramContext, Uri paramUri)
  {
    paramUri = paramUri.getQueryParameter("native_click_report_url");
    if (r.a(paramUri))
      return;
    new o().execute(new String[] { paramUri });
    g.a(paramContext, "Click logged");
  }

  public abstract void b();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.action.a
 * JD-Core Version:    0.6.2
 */