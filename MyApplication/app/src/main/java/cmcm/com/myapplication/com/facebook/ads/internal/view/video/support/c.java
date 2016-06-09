package cmcm.com.myapplication.com.facebook.ads.internal.view.video.support;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import android.view.View;

public class c
  implements OnInfoListener
{
  private View a;

  public c(View paramView)
  {
    this.a = paramView;
  }

  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      this.a.setVisibility(8);
      return true;
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.video.support.c
 * JD-Core Version:    0.6.2
 */