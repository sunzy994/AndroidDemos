package cmcm.com.myapplication;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.hola.channel.sdk.game.graphics.ImageCache;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

abstract class sf
{
  private static final String a = "GameSDK." + sf.class.getSimpleName();
  private static final ScaleType b = ScaleType.CENTER_INSIDE;
  protected ImageCache c;
  protected Context d;
  protected Resources e;
  private sc f;
  private Bitmap g;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private final Object k = new Object();
  private ExecutorService l;
  private final sj m = null;
  private final HashMap<Object, sh> n = new HashMap();

  protected sf(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.e = this.d.getResources();
    this.l = h();
  }

  private void a(ImageView paramImageView, Drawable paramDrawable, Bundle paramBundle, boolean paramBoolean)
  {
    ScaleType localScaleType = b;
    Object localObject2 = paramDrawable;
    Object localObject1;
    if (paramBundle != null)
    {
      int i1 = paramBundle.getInt("orrc", 0);
      localObject1 = paramDrawable;
      if (i1 != 0)
        localObject1 = new sm(((BitmapDrawable)paramDrawable).getBitmap(), i1, paramBundle.getFloat("orrr"));
      i1 = paramBundle.getInt("ost", -9999);
      localObject2 = localObject1;
      if (i1 != -9999)
        switch (i1)
        {
        default:
          paramDrawable = ScaleType.CENTER_INSIDE;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        }
    }
    while (true)
    {
      if (paramImageView.getScaleType() != paramDrawable)
        paramImageView.setScaleType(paramDrawable);
      if ((this.h) && (!paramBoolean))
      {
        paramDrawable = new TransitionDrawable(new Drawable[] { new ColorDrawable(0), localObject1 });
        if ((paramBundle != null) && (paramBundle.getBoolean("osb", false)))
          paramImageView.setBackgroundDrawable(new BitmapDrawable(this.e, this.g));
        paramImageView.setImageDrawable(paramDrawable);
        paramDrawable.startTransition(200);
        return;
        paramDrawable = ScaleType.MATRIX;
        continue;
        paramDrawable = ScaleType.FIT_XY;
        continue;
        paramDrawable = ScaleType.FIT_START;
        continue;
        paramDrawable = ScaleType.FIT_CENTER;
        continue;
        paramDrawable = ScaleType.FIT_END;
        continue;
        paramDrawable = ScaleType.CENTER;
        continue;
        paramDrawable = ScaleType.CENTER_CROP;
      }
      else
      {
        paramImageView.setImageDrawable((Drawable)localObject1);
        return;
        paramDrawable = localScaleType;
        localObject1 = localObject2;
      }
    }
  }

  public static boolean a(Object paramObject, ImageView paramImageView)
  {
    paramImageView = b(paramImageView);
    if ((paramImageView == null) || (paramImageView.isCancelled()) || (paramImageView.a()))
      return true;
    Object localObject = sh.b(paramImageView);
    if ((localObject == null) || (!localObject.equals(paramObject)))
    {
      paramImageView.cancel(true);
      return true;
    }
    return false;
  }

  private static sh b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof sg))
        return ((sg)paramImageView).a();
    }
    return null;
  }

  private ExecutorService h()
  {
    return Executors.newFixedThreadPool(2, new ThreadFactory()
    {
      private final AtomicInteger b = new AtomicInteger(1);

      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, "ImageWorkerThread #" + this.b.getAndIncrement());
      }
    });
  }

  protected abstract Bitmap a(Object paramObject, Bundle paramBundle);

  void a()
  {
    if (this.c != null)
      this.c.b();
  }

  public void a(int paramInt)
  {
    this.g = BitmapFactory.decodeResource(this.e, paramInt);
  }

  public void a(FragmentManager paramFragmentManager, sc paramsc)
  {
    this.f = paramsc;
    this.c = ImageCache.a(paramFragmentManager, this.f);
    new si(this).execute(new Object[] { Integer.valueOf(1) });
  }

  public void a(Object paramObject, ImageView paramImageView, Bundle paramBundle)
  {
    a(paramObject, paramImageView, paramBundle, null);
  }

  public void a(Object paramObject, ImageView arg2, Bundle paramBundle, sj paramsj)
  {
    if (paramObject == null);
    label71: 
    do
    {
      BitmapDrawable localBitmapDrawable;
      do
      {
        return;
        localBitmapDrawable = null;
        if (this.c != null)
          localBitmapDrawable = this.c.a(String.valueOf(paramObject));
        if (localBitmapDrawable == null)
          break label71;
        if (paramsj == null)
          break;
        paramsj.a(???, paramObject);
      }
      while (paramsj.a(???, paramObject, localBitmapDrawable));
      a(???, localBitmapDrawable, paramBundle, true);
      return;
    }
    while (!a(paramObject, ???));
    paramBundle = new sh(this, paramObject, ???, paramBundle, paramsj);
    paramsj = new sg(this.e, this.g, paramBundle);
    if (???.getScaleType() != b)
      ???.setScaleType(b);
    ???.setImageDrawable(paramsj);
    synchronized (this.n)
    {
      paramsj = (sh)this.n.get(paramObject);
      if (paramsj != null)
      {
        paramsj.a(paramBundle);
        return;
      }
    }
    this.n.put(paramObject, paramBundle);
    try
    {
      paramBundle.executeOnExecutor(this.l, new Void[0]);
      return;
    }
    catch (Throwable paramObject)
    {
    }
  }

  public void a(boolean paramBoolean)
  {
    synchronized (this.k)
    {
      this.j = paramBoolean;
      if (!this.j)
        this.k.notifyAll();
      return;
    }
  }

  void b()
  {
    if (this.c != null)
      this.c.c();
  }

  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
    a(false);
  }

  void c()
  {
    if (this.c != null)
    {
      this.c.d();
      this.c = null;
    }
  }

  void d()
  {
    if (this.c != null)
      this.c.a();
  }

  public void e()
  {
    this.l.shutdown();
  }

  public void f()
  {
    new si(this).execute(new Object[] { Integer.valueOf(3) });
  }

  public void g()
  {
    new si(this).execute(new Object[] { Integer.valueOf(2) });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sf
 * JD-Core Version:    0.6.2
 */