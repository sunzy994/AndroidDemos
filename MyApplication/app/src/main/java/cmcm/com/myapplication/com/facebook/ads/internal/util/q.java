package cmcm.com.myapplication.com.facebook.ads.internal.util;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class q
{
  static final int a = Runtime.getRuntime().availableProcessors();
  static final ExecutorService b = Executors.newFixedThreadPool(a);
  private static volatile boolean c = true;
  private final Bitmap d;
  private Bitmap e;
  private final j f;

  public q(Bitmap paramBitmap)
  {
    this.d = paramBitmap;
    this.f = new n();
  }

  public Bitmap a()
  {
    return this.e;
  }

  public Bitmap a(int paramInt)
  {
    this.e = this.f.a(this.d, paramInt);
    return this.e;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.q
 * JD-Core Version:    0.6.2
 */