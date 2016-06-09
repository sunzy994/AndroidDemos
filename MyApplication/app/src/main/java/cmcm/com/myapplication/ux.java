package cmcm.com.myapplication;

import android.database.ContentObserver;
import android.os.Handler;
import com.holaverse.charging.view.DigitalClock;

public class ux extends ContentObserver
{
  public ux(DigitalClock paramDigitalClock)
  {
    super(new Handler());
  }

  public void onChange(boolean paramBoolean)
  {
    DigitalClock.f(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ux
 * JD-Core Version:    0.6.2
 */