package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class auq extends aun
  implements aut
{
  private static final String b = "Swipe." + auq.class.getSimpleName();
  final Handler a;
  private Context c;
  private final RemoteCallbackList<auj> d;
  private Map<String, SoftReference<Bitmap>> e;
  private final Map<String, aur> f = new HashMap();
  private final Map<String, Integer> g = new HashMap(1);
  private ExecutorService h;

  public auq(Service paramService)
  {
    this.c = paramService;
    this.d = new RemoteCallbackList();
    this.h = e();
    paramService = new HandlerThread(b);
    paramService.setPriority(10);
    paramService.start();
    this.a = new Handler(paramService.getLooper());
  }

  private void d()
  {
    if (this.e != null)
      this.e.clear();
  }

  private ExecutorService e()
  {
    return Executors.newFixedThreadPool(2, new ThreadFactory()
    {
      private final AtomicInteger b = new AtomicInteger(1);

      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, "ImageDownloaderTask #" + this.b.getAndIncrement());
      }
    });
  }

  public Bitmap a(String paramString1, final String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 0;
    if (TextUtils.isEmpty(paramString2))
      paramString2 = aro.a(this.c) + arh.a(paramString1);
    while (this.e != null)
    {
      ??? = (SoftReference)this.e.get(paramString1);
      if ((??? == null) || (((SoftReference)???).get() == null))
        break;
      return (Bitmap)((SoftReference)???).get();
      if (paramString2.charAt(0) == '/');
      for (int i = 1; ; i = 0)
      {
        if (paramString2.charAt(paramString2.length() - 1) != '/')
          j = 1;
        if ((i == 0) || (j == 0))
          break label135;
        break;
      }
      label135: if (i != 0)
        paramString2 = paramString2 + arh.a(paramString1);
      else if (j != 0)
        paramString2 = aro.a(this.c) + paramString2;
      else
        paramString2 = aro.a(this.c) + arh.a(paramString1);
    }
    synchronized (this.f)
    {
      if (this.f.containsKey(paramString1))
      {
        paramString2 = (Integer)this.g.get(paramString1);
        Map localMap = this.g;
        if (paramString2 == null);
        for (paramInt1 = k; ; paramInt1 = Integer.valueOf(paramString2.intValue() + 1).intValue())
        {
          localMap.put(paramString1, Integer.valueOf(paramInt1));
          return null;
        }
      }
      paramString2 = new aur(this, new aus(this.c, paramString1, paramString2, paramBoolean1, paramInt1, paramInt2));
      this.f.put(paramString1, paramString2);
      arj.a(this.a, new Runnable()
      {
        public void run()
        {
          Bitmap[] arrayOfBitmap = new Bitmap[1];
          aus localaus = paramString2.a();
          if (localaus == null)
          {
            Log.w(auq.c(), "Request is NULL?!");
            return;
          }
          if (localaus.a(arrayOfBitmap))
          {
            auq.this.a(localaus.b, localaus.a, arrayOfBitmap[0]);
            return;
          }
          try
          {
            auq.a(auq.this).execute(paramString2);
            return;
          }
          catch (Throwable localThrowable)
          {
            auq.this.a(localaus.b, localaus.a, null);
          }
        }
      });
      return null;
    }
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    d();
  }

  @SuppressLint({"NewApi"})
  public void a(auj paramauj)
  {
    if (paramauj != null)
      this.d.register(paramauj);
  }

  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    synchronized (this.f)
    {
      this.f.remove(paramString1);
    }
    synchronized (this.d)
    {
      int j = this.d.beginBroadcast();
      int i = 0;
      while (true)
        if (i < j)
          try
          {
            ((auj)this.d.getBroadcastItem(i)).a(paramString1, paramString2, paramBitmap);
            i += 1;
            continue;
            paramString1 = finally;
            throw paramString1;
          }
          catch (Throwable localThrowable)
          {
            while (true)
              Log.w(b, "Could not notify callback", localThrowable);
          }
    }
    this.d.finishBroadcast();
  }

  public void a(String[] paramArrayOfString)
  {
    Map localMap = this.f;
    if (paramArrayOfString == null);
    while (true)
    {
      int i;
      Object localObject;
      Integer localInteger;
      try
      {
        this.h.shutdown();
        this.f.clear();
        this.h = e();
        return;
        if (paramArrayOfString.length <= 0)
          continue;
        int j = paramArrayOfString.length;
        i = 0;
        if (i >= j)
          continue;
        localObject = paramArrayOfString[i];
        localInteger = (Integer)this.g.get(localObject);
        if (localInteger == null)
        {
          localObject = (aur)this.f.remove(localObject);
          if (localObject != null)
            ((aur)localObject).cancel(true);
        }
        else if (1 == localInteger.intValue())
        {
          this.g.remove(localObject);
        }
      }
      finally
      {
      }
      this.g.put(localObject, Integer.valueOf(localInteger.intValue() - 1));
      i += 1;
    }
  }

  public void b()
  {
    this.d.kill();
    this.h.shutdownNow();
    d();
    this.c = null;
    try
    {
      this.a.getLooper().quit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @SuppressLint({"NewApi"})
  public void b(auj paramauj)
  {
    if (paramauj != null)
      this.d.unregister(paramauj);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auq
 * JD-Core Version:    0.6.2
 */