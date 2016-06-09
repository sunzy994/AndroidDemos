package cmcm.com.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;

public class ajd extends aiy<ahw>
{
  private HandlerThread c = new HandlerThread("theme");
  private Handler d;
  private Handler e;

  public ajd(Activity paramActivity)
  {
    super(paramActivity);
    this.c.start();
    this.d = new Handler(this.c.getLooper());
    this.e = new Handler();
  }

  private void a(final ahw paramahw, final Bitmap paramBitmap)
  {
    if (!(paramahw instanceof ahq))
      return;
    paramahw = (ahq)paramahw;
    this.d.post(new Runnable()
    {
      public void run()
      {
        paramahw.a(paramBitmap);
      }
    });
  }

  private void a(final aja paramaja, final Bitmap paramBitmap)
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        if (paramBitmap == null)
        {
          paramaja.a();
          return;
        }
        paramaja.a(paramBitmap);
      }
    });
  }

  public void a()
  {
    super.a();
    try
    {
      this.c.quit();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void a(final int paramInt, final aja paramaja, final ahw paramahw)
  {
    Bitmap localBitmap = a(paramahw.g);
    if (atw.b(localBitmap))
    {
      paramaja.a(localBitmap);
      return;
    }
    this.d.post(new Runnable()
    {
      public void run()
      {
        Object localObject = paramahw.c();
        if (atw.b((Bitmap) localObject))
        {
          ajd.this.a(paramahw.g, (Bitmap)localObject);
          ajd.a(ajd.this, paramaja, (Bitmap)localObject);
          ajd.a(ajd.this, paramahw, (Bitmap)localObject);
          return;
        }
        localObject = ajd.this.a.a(new aiz(paramInt, paramaja, paramahw));
        if (localObject != null)
        {
          ajd.a(ajd.this, paramaja, ((atr)localObject).e);
          ajd.a(ajd.this, (ahw)((aiz)localObject).c, ((atr)localObject).e);
          return;
        }
        ajd.a(ajd.this, paramaja, null);
      }
    });
  }

  protected void a(aiz paramaiz)
  {
    super.a(paramaiz);
    a((ahw)paramaiz.c, paramaiz.e);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajd
 * JD-Core Version:    0.6.2
 */