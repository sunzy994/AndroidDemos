package cmcm.com.myapplication;

import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.widget.ImageView;
import com.hola.channel.sdk.game.graphics.ImageCache;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class sh extends AsyncTask<Void, Void, BitmapDrawable>
{
  private Object b;
  private Bundle c;
  private final WeakReference<ImageView> d;
  private final WeakReference<sj> e;
  private Set<sh> f;
  private boolean g;

  public sh(sf paramsf, Object paramObject, ImageView paramImageView, Bundle paramBundle, sj paramsj)
  {
    this.c = paramBundle;
    this.b = paramObject;
    this.d = new WeakReference(paramImageView);
    if (paramsj == null);
    for (paramsf = null; ; paramsf = new WeakReference(paramsj))
    {
      this.e = paramsf;
      return;
    }
  }

  private ImageView b()
  {
    ImageView localImageView = (ImageView)this.d.get();
    if (this == sf.a(localImageView))
      return localImageView;
    return null;
  }

  protected BitmapDrawable a(Void[] arg1)
  {
    if ((this.e != null) && (this.e.get() != null));
    while (true)
    {
      try
      {
        ((sj)this.e.get()).a(b(), this.b);
        if (this.f != null)
        {
          ??? = this.f.iterator();
          if (???.hasNext())
          {
            localObject1 = ((sh)???.next()).e;
            if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
              continue;
            ((sj)((WeakReference)localObject1).get()).a(b(), this.b);
            continue;
          }
        }
        Object localObject1 = String.valueOf(this.b);
        synchronized (sf.a(this.a))
        {
          if (sf.b(this.a))
          {
            boolean bool = isCancelled();
            if (!bool)
            {
              try
              {
                sf.a(this.a).wait();
              }
              catch (InterruptedException localInterruptedException)
              {
              }
              continue;
            }
          }
          if ((this.a.c == null) || (isCancelled()) || ((b() == null) && ((this.f == null) || (this.f.isEmpty()))) || (sf.c(this.a)))
            break label357;
          ??? = this.a.c.b((String)localObject1);
          if ((??? != null) || (isCancelled()) || ((b() == null) && ((this.f == null) || (this.f.isEmpty()))) || (sf.c(this.a)))
            break label354;
          ??? = this.a.a(this.b, this.c);
          if (??? != null)
          {
            ??? = new BitmapDrawable(this.a.e, ???);
            if (this.a.c != null)
              this.a.c.a((String)localObject1, ???);
            return ???;
          }
        }
      }
      catch (Throwable )
      {
        continue;
      }
      return null;
      label354: continue;
      label357: ??? = null;
    }
  }

  protected void a(BitmapDrawable paramBitmapDrawable)
  {
    synchronized (sf.d(this.a))
    {
      if ((sh)sf.d(this.a).get(this.b) == this)
        sf.d(this.a).remove(this.b);
      if ((this.e == null) || (this.e.get() == null));
    }
    try
    {
      ((sj)this.e.get()).a(b(), this.b, paramBitmapDrawable);
      label90: if (this.f != null)
      {
        ??? = this.f.iterator();
        while (((Iterator)???).hasNext())
        {
          sh localsh = (sh)((Iterator)???).next();
          localsh.g = true;
          localsh.a(paramBitmapDrawable);
          continue;
          paramBitmapDrawable = finally;
          throw paramBitmapDrawable;
        }
      }
      if ((isCancelled()) || (sf.c(this.a)))
        paramBitmapDrawable = null;
      if (paramBitmapDrawable != null)
      {
        ??? = b();
        if (??? != null)
          sf.a(this.a, (ImageView)???, paramBitmapDrawable, this.c, false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
  }

  public void a(sh paramsh)
  {
    if (this.f == null)
      this.f = new qi();
    while (!this.f.contains(paramsh))
    {
      this.f.add(paramsh);
      return;
    }
  }

  public boolean a()
  {
    return (this.g) || (Status.FINISHED == getStatus());
  }

  protected void onCancelled()
  {
    Object localObject2 = null;
    int j = 0;
    while (true)
    {
      Object localObject5;
      int i;
      synchronized (sf.d(this.a))
      {
        localObject5 = (sh)sf.d(this.a).get(this.b);
        if (localObject5 == this)
        {
          sf.d(this.a).remove(this.b);
          i = 1;
          if ((this.e == null) || (this.e.get() == null));
        }
      }
      try
      {
        ((sj)this.e.get()).b(b(), this.b);
        label98: if (i == 0)
        {
          return;
          i = j;
          if (localObject5 == null)
            continue;
          i = j;
          if (((sh)localObject5).f == null)
            continue;
          ((sh)localObject5).f.remove(this);
          i = j;
          continue;
          localObject3 = finally;
          throw localObject3;
        }
        if (this.f != null)
        {
          localObject5 = this.f.iterator();
          while (true)
          {
            ??? = localObject3;
            if (((Iterator)localObject5).hasNext())
            {
              ??? = (sh)((Iterator)localObject5).next();
              Status localStatus = ((sh)???).getStatus();
              if (Status.PENDING != localStatus);
            }
            else
            {
              if (??? == null)
                break label264;
              while (((Iterator)localObject5).hasNext())
              {
                sh localsh = (sh)((Iterator)localObject5).next();
                if (Status.PENDING == localsh.getStatus())
                  ((sh)???).a(localsh);
              }
            }
            ((Iterator)localObject5).remove();
          }
        }
        try
        {
          ((sh)???).executeOnExecutor(sf.e(this.a), new Void[0]);
          label264: this.f.clear();
          synchronized (sf.a(this.a))
          {
            sf.a(this.a).notifyAll();
            return;
          }
        }
        catch (Throwable localThrowable1)
        {
          break label264;
        }
      }
      catch (Throwable localThrowable2)
      {
        break label98;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sh
 * JD-Core Version:    0.6.2
 */