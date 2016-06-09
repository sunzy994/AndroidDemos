package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import com.hola.channel.sdk.game.graphics.ImageCache;
import java.io.File;

public class sc
{
  public int a = 5120;
  public int b = 10485760;
  public File c;
  public Bitmap.CompressFormat d = ImageCache.f();
  public int e = 70;
  public boolean f = true;
  public boolean g = true;
  public boolean h = false;

  public sc(Context paramContext)
  {
    this(paramContext, null);
  }

  public sc(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      this.c = ImageCache.a(paramContext, paramString);
      return;
    }
    this.g = false;
  }

  public void a(float paramFloat)
  {
    if ((paramFloat < 0.01F) || (paramFloat > 0.8F))
      throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.01 and 0.8 (inclusive)");
    this.a = Math.round((float)(Runtime.getRuntime().maxMemory() / 1024L) * paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sc
 * JD-Core Version:    0.6.2
 */