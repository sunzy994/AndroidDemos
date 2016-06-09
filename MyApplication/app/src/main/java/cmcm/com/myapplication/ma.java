package cmcm.com.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;

final class ma extends Handler
{
  ma(lz paramlz, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      lz.a(this.a);
      mv.c("InMobiDataExecutor", "loading js:" + lz.b(this.a));
      if (this.a.c != null)
        this.a.c.a.loadData(lz.b(this.a), "text/html", "UTF-8");
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ma
 * JD-Core Version:    0.6.2
 */