package cmcm.com.myapplication.com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

public class dv
{
  private static dv b;
  private final dt<du> a = new dt();

  @TargetApi(14)
  private dv()
  {
    if (Build.VERSION.SDK_INT >= 14)
      ((Application)do.a().b()).registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks()
      {
        protected void a(Activity paramAnonymousActivity, du.a paramAnonymousa)
        {
          Iterator localIterator = dv.a(dv.this).iterator();
          while (localIterator.hasNext())
            ((du)localIterator.next()).a(paramAnonymousActivity, paramAnonymousa);
        }

        public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          a(paramAnonymousActivity, du.a.a);
        }

        public void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          a(paramAnonymousActivity, du.a.b);
        }

        public void onActivityPaused(Activity paramAnonymousActivity)
        {
          a(paramAnonymousActivity, du.a.c);
        }

        public void onActivityResumed(Activity paramAnonymousActivity)
        {
          a(paramAnonymousActivity, du.a.d);
        }

        public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          a(paramAnonymousActivity, du.a.g);
        }

        public void onActivityStarted(Activity paramAnonymousActivity)
        {
          a(paramAnonymousActivity, du.a.e);
        }

        public void onActivityStopped(Activity paramAnonymousActivity)
        {
          a(paramAnonymousActivity, du.a.f);
        }
      });
  }

  public static dv a()
  {
    try
    {
      if (b == null)
        b = new dv();
      dv localdv = b;
      return localdv;
    }
    finally
    {
    }
  }

  private List<du> c()
  {
    try
    {
      List localList = this.a.a();
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(du paramdu)
  {
    try
    {
      this.a.a(paramdu);
      return;
    }
    finally
    {
      paramdu = finally;
    }
    throw paramdu;
  }

  public boolean b()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dv
 * JD-Core Version:    0.6.2
 */