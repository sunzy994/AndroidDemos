package cmcm.com.myapplication.com.facebook.ads.internal;

import android.os.Handler;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.t;

final class i$b extends t<i>
{
  public i$b(i parami)
  {
    super(parami);
  }

  public void run()
  {
    i locali = (i)a();
    if (locali == null)
      return;
    if (g.a(i.a(locali)))
    {
      locali.a();
      return;
    }
    i.c(locali).postDelayed(i.b(locali), 5000L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.i.b
 * JD-Core Version:    0.6.2
 */