package cmcm.com.myapplication;

import android.app.Notification;
import android.os.Handler;
import android.widget.RemoteViews;

class atf
  implements Runnable
{
  private atf(atc paramatc)
  {
  }

  public void run()
  {
    if (!atc.c(this.a))
    {
      atc.e(this.a).contentView.setProgressBar(2131755234, 100, atc.d(this.a).a(), false);
      arm.a(atc.f(this.a), atc.g(this.a), atc.e(this.a));
    }
    atc.h(this.a).sendEmptyMessageDelayed(2, 1000L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atf
 * JD-Core Version:    0.6.2
 */