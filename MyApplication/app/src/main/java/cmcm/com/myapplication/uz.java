package cmcm.com.myapplication;

import android.os.Handler;
import com.holaverse.charging.view.WaveView;
import java.util.TimerTask;

public class uz extends TimerTask
{
  Handler a;

  public uz(WaveView paramWaveView, Handler paramHandler)
  {
    this.a = paramHandler;
  }

  public void run()
  {
    WaveView.a(this.b);
    this.a.sendEmptyMessage(0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uz
 * JD-Core Version:    0.6.2
 */