package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

class jn
  implements Runnable
{
  private WeakReference<Context> a = null;

  public jn(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }

  public void run()
  {
    if (jl.c());
    do
    {
      return;
      jl.a(System.currentTimeMillis());
    }
    while (this.a == null);
    jl.a(true);
    try
    {
      String str = jl.a("AppsFlyerKey");
      synchronized (this.a)
      {
        Iterator localIterator = jx.a().b((Context)this.a.get()).iterator();
        while (true)
          if (localIterator.hasNext())
          {
            jy localjy = (jy)localIterator.next();
            if (jl.f((Context)this.a.get()))
              Log.i("AppsFlyer_1.13", "resending request: " + localjy.c());
            try
            {
              jl.a(localjy.c() + "&isCachedRequest=true", localjy.b(), str, this.a, localjy.d(), "AppsFlyer_1.13", false);
            }
            catch (Exception localException2)
            {
            }
          }
      }
    }
    catch (Exception localException1)
    {
      Log.e("AppsFlyer_1.13", "failed to check cache.");
      jl.a(false);
      while (true)
      {
        jl.d().shutdown();
        return;
        jl.a(false);
      }
    }
    finally
    {
      jl.a(false);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jn
 * JD-Core Version:    0.6.2
 */