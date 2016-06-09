package cmcm.com.myapplication.com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.b.a;
import com.facebook.ads.internal.util.g;

public class d extends a
{
  private static final String a = d.class.getSimpleName();
  private final Context b;
  private final Uri c;

  public d(Context paramContext, Uri paramUri)
  {
    this.b = paramContext;
    this.c = paramUri;
  }

  public b.a a()
  {
    return b.a.b;
  }

  public void b()
  {
    a(this.b, this.c);
    try
    {
      g.a(this.b, Uri.parse(this.c.getQueryParameter("link")));
      return;
    }
    catch (Exception localException)
    {
      Log.d(a, "Failed to open link url: " + this.c.toString(), localException);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.action.d
 * JD-Core Version:    0.6.2
 */