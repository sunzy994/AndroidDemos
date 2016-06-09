package cmcm.com.myapplication;

import com.duapps.ad.a.a;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

final class lp
  implements Runnable
{
  lp(lo paramlo, String paramString)
  {
  }

  public final void run()
  {
    try
    {
      int i = mj.a(new URL(this.a), null, true).getStatusLine().getStatusCode();
      if (i != 200)
      {
        mv.c(lo.i(), "Impression to " + lo.a(this.b).j + " failed!");
        return;
      }
      if (i == 200)
      {
        mv.c(lo.i(), "Impression to " + lo.a(this.b).j + " success!");
        return;
      }
    }
    catch (Exception localException)
    {
      mv.c(lo.i(), "Impression to " + lo.a(this.b).j + " exception!");
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lp
 * JD-Core Version:    0.6.2
 */