package cmcm.com.myapplication.com.facebook.ads.internal.view.video.support;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;

@TargetApi(14)
public class d extends TextureView
  implements OnBufferingUpdateListener, OnPreparedListener, SurfaceTextureListener, e
{
  private static final String i = d.class.getSimpleName();
  private View a;
  private Uri b;
  private b c;
  private Surface d;
  private MediaPlayer e;
  private boolean f;
  private boolean g;
  private int h;

  public d(Context paramContext)
  {
    super(paramContext);
  }

  public void a(View paramView, Uri paramUri)
  {
    this.a = paramView;
    this.b = paramUri;
    setSurfaceTextureListener(this);
  }

  public int getCurrentPosition()
  {
    int j = 0;
    if (this.e != null)
      j = this.e.getCurrentPosition();
    return j;
  }

  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.c != null)
      this.c.a(paramMediaPlayer);
    if (this.g)
    {
      paramMediaPlayer.start();
      this.g = false;
    }
    if (this.h > 0)
    {
      if (this.h >= this.e.getDuration())
        this.h = 0;
      this.e.seekTo(this.h);
      this.h = 0;
    }
    this.f = true;
  }

  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.d = new Surface(paramSurfaceTexture);
    if (this.e != null)
    {
      this.e.setSurface(this.d);
      return;
    }
    paramSurfaceTexture = new MediaPlayer();
    try
    {
      paramSurfaceTexture.setDataSource(getContext(), this.b);
      paramSurfaceTexture.setSurface(this.d);
      paramSurfaceTexture.setOnPreparedListener(this);
      paramSurfaceTexture.setOnInfoListener(new c(this.a));
      paramSurfaceTexture.setOnBufferingUpdateListener(this);
      paramSurfaceTexture.setLooping(false);
      paramSurfaceTexture.prepareAsync();
      this.e = paramSurfaceTexture;
      return;
    }
    catch (Exception localException)
    {
      paramSurfaceTexture.release();
      Log.e(i, "Cannot prepare media player with SurfaceTexture: " + localException);
    }
  }

  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    pause();
    return true;
  }

  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
  }

  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
  }

  public void pause()
  {
    if (this.e != null)
    {
      this.h = this.e.getCurrentPosition();
      this.e.stop();
      this.e.reset();
      this.e.release();
    }
    this.e = null;
    this.f = false;
    this.g = false;
  }

  public void setFrameVideoViewListener(b paramb)
  {
    this.c = paramb;
  }

  public void start()
  {
    if (this.f)
      this.e.start();
    while (true)
    {
      if (isAvailable())
        onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
      return;
      this.g = true;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.video.support.d
 * JD-Core Version:    0.6.2
 */