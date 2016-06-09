package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.os.Handler;
import android.widget.VideoView;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.t;

final class g$a extends t<g>
{
  public g$a(g paramg)
  {
    super(paramg);
  }

  public void run()
  {
    g localg = (g)a();
    if (localg != null)
    {
      if (g.a(localg).getCurrentPosition() > 3000)
        new o().execute(new String[] { localg.getVideoPlayReportURI() });
    }
    else
      return;
    g.d(localg).postDelayed(this, 250L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.g.a
 * JD-Core Version:    0.6.2
 */