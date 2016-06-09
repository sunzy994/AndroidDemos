package cmcm.com.myapplication;

import com.duapps.ad.a.a;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

final class lr
  implements Runnable
{
  lr(lq paramlq, String paramString)
  {
  }

  public final void run()
  {
    try
    {
      int i = mj.a(new URL(this.a), null, true).getStatusLine().getStatusCode();
      if (i != 200)
      {
        mv.c(lo.i(), "click to " + lo.a(this.b.a).j + " failed!");
        return;
      }
      if (i == 200)
      {
        mv.c(lo.i(), "click to " + lo.a(this.b.a).j + " success!");
        return;
      }
    }
    catch (Exception localException)
    {
      mv.c(lo.i(), "click to " + lo.a(this.b.a).j + " exception!");
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lr
 * JD-Core Version:    0.6.2
 */