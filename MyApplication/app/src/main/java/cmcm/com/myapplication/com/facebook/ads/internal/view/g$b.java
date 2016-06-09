package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.os.Handler;
import android.widget.VideoView;
import com.facebook.ads.internal.util.t;

final class g$b extends t<g>
{
  public g$b(g paramg)
  {
    super(paramg);
  }

  public void run()
  {
    g localg = (g)a();
    if (localg != null)
    {
      int i = g.a(localg).getCurrentPosition();
      if (i > g.b(localg))
        g.a(localg, i);
      g.c(localg).postDelayed(this, 250L);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.g.b
 * JD-Core Version:    0.6.2
 */