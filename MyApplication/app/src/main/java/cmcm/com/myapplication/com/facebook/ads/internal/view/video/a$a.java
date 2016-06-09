package cmcm.com.myapplication.com.facebook.ads.internal.view.video;

import android.os.Handler;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.t;

final class a$a extends t<a>
{
  public a$a(a parama)
  {
    super(parama);
  }

  public void run()
  {
    a locala = (a)a();
    if (locala == null)
      return;
    if (a.c(locala).getCurrentPosition() > 3000)
    {
      new o().execute(new String[] { locala.getVideoPlayReportURI() });
      return;
    }
    a.f(locala).postDelayed(this, 250L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.video.a.a
 * JD-Core Version:    0.6.2
 */