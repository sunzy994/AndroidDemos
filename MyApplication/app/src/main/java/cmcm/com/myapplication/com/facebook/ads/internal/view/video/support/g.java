package cmcm.com.myapplication.com.facebook.ads.internal.view.video.support;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.View;
import android.widget.VideoView;

public class g extends VideoView
  implements OnPreparedListener, e
{
  private View a;
  private Uri b;
  private b c;

  public g(Context paramContext)
  {
    super(paramContext);
  }

  public void a(View paramView, Uri paramUri)
  {
    this.a = paramView;
    this.b = paramUri;
    setOnPreparedListener(this);
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.setLooping(true);
    paramMediaPlayer.setOnInfoListener(new c(this.a));
    if (this.c != null)
      this.c.a(paramMediaPlayer);
  }

  public void pause()
  {
    this.a.setVisibility(0);
    stopPlayback();
  }

  public void setFrameVideoViewListener(b paramb)
  {
    this.c = paramb;
  }

  public void start()
  {
    setVideoURI(this.b);
    super.start();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.video.support.g
 * JD-Core Version:    0.6.2
 */