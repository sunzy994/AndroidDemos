package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.view.ViewParent;

public class anf extends ano
  implements avg
{
  public static boolean a;
  private static final int[] c = { 2130837829, 2130837826, 2130837828, 2130837827 };
  private static final String[] d = { "tile_music_volume_min", "tile_music_volume_low", "tile_music_volume_mid", "tile_music_volume_max" };
  private static final float[] m = { 0.0F, 0.22F, 0.66F, 1.0F };
  private final AudioManager b;
  private int n;
  private boolean o;
  private boolean p;

  public anf(Context paramContext)
  {
    this(paramContext, null);
  }

  public anf(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
    this.b = ((AudioManager)paramContext.getSystemService("audio"));
  }

  private void p()
  {
    int i = this.b.getStreamVolume(3);
    int j = this.b.getStreamMaxVolume(3);
    if (i == 0)
    {
      this.n = 0;
      return;
    }
    if (i > j * 0.66F)
    {
      this.n = 3;
      return;
    }
    if (i > j * 0.22F)
    {
      this.n = 2;
      return;
    }
    this.n = 1;
  }

  public int a(Context paramContext)
  {
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 0;
  }

  public void a(avf paramavf)
  {
    this.o = false;
    this.p = true;
    try
    {
      paramavf.getParent().requestDisallowInterceptTouchEvent(true);
      return;
    }
    catch (Throwable paramavf)
    {
    }
  }

  public void a(avf paramavf, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.p) && (!this.o))
        this.o = true;
      paramInt = (int)(this.b.getStreamMaxVolume(3) * paramInt / 100.0F);
      this.b.setStreamVolume(3, paramInt, 0);
      y_();
    }
  }

  public boolean a(int paramInt)
  {
    return e(this.e) != 2130837829;
  }

  public String b()
  {
    return "Music volume";
  }

  public String b(boolean paramBoolean)
  {
    p();
    return d[this.n];
  }

  public void b(avf paramavf)
  {
    Context localContext = this.e;
    int i;
    if (this.o)
      i = 2;
    while (true)
    {
      vy.b(localContext, "B40", i);
      this.o = false;
      this.p = false;
      try
      {
        paramavf.getParent().requestDisallowInterceptTouchEvent(false);
        return;
        i = 1;
      }
      catch (Throwable paramavf)
      {
      }
    }
  }

  public int c()
  {
    return 8;
  }

  public int d()
  {
    return 2131231122;
  }

  public boolean d(Context paramContext)
  {
    if (a)
      if (this.n >= c.length - 1)
      {
        a = false;
        this.n = (c.length - 2);
      }
    while (true)
    {
      int i = (int)(this.b.getStreamMaxVolume(3) * m[this.n]);
      this.b.setStreamVolume(3, i, 0);
      Bitmap localBitmap = atw.a(paramContext.getResources(), 2130837685);
      paramContext = atw.a(paramContext.getResources(), 2130837684);
      yb.a(true, this, (int)(m[this.n] * 100.0F), localBitmap, paramContext);
      return false;
      this.n += 1;
      continue;
      if (this.n <= 0)
      {
        a = true;
        this.n = 1;
      }
      else
      {
        this.n -= 1;
      }
    }
  }

  public int e(Context paramContext)
  {
    p();
    return c[this.n];
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anf
 * JD-Core Version:    0.6.2
 */