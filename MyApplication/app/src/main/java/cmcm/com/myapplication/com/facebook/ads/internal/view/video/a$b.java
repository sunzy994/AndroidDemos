package cmcm.com.myapplication.com.facebook.ads.internal.view.video;

import android.os.Handler;
import com.facebook.ads.internal.util.t;

final class a$b extends t<a>
{
  public a$b(a parama)
  {
    super(parama);
  }

  public void run()
  {
    a locala = (a)a();
    if (locala == null);
    while (locala == null)
      return;
    int i = a.c(locala).getCurrentPosition();
    if (i > a.d(locala))
      a.a(locala, i);
    a.e(locala).postDelayed(this, 250L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.video.a.b
 * JD-Core Version:    0.6.2
 */