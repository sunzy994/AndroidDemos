package cmcm.com.myapplication;

import android.view.View.OnLongClickListener;
import com.lazyswipe.fan.FanItem;

public class yh
  implements Runnable
{
  private yh(FanItem paramFanItem)
  {
  }

  public void run()
  {
    if (FanItem.b(this.a) != null)
    {
      FanItem.a(this.a, true);
      this.a.m = 0.0F;
      this.a.b(false);
      this.a.setTextColor(ahx.b(this.a.getContext()).k());
      this.a.invalidate();
      FanItem.b(this.a, true);
      FanItem.b(this.a).onLongClick(this.a);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yh
 * JD-Core Version:    0.6.2
 */