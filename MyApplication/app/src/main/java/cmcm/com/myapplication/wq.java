package cmcm.com.myapplication;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.ui.EmptyActivity;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class wq extends BroadcastReceiver
  implements Runnable
{
  private static final String a = "Swipe." + wq.class.getSimpleName();
  private static volatile ExecutorService b;
  private static wq c;
  private static int d;
  private static boolean e;
  private static boolean f = true;
  private static String l;
  private static boolean q = false;
  private ActivityManager g;
  private Context h;
  private IntentFilter i;
  private final Set<WeakReference<wr>> j = Collections.synchronizedSet(new HashSet(1));
  private ComponentName k;
  private Future m;
  private volatile boolean n;
  private ComponentName o;
  private int p = 0;

  private wq(Context paramContext, wr paramwr)
  {
    if (paramwr == null)
      throw new IllegalArgumentException("Null callback");
    this.j.add(new WeakReference(paramwr));
    this.h = paramContext;
    this.g = ((ActivityManager)paramContext.getSystemService("activity"));
    e = vs.J(paramContext);
    asp.a(a, "Running in turbo mode? " + e);
    d = j();
    this.i = new IntentFilter();
    this.i.addAction("android.intent.action.SCREEN_ON");
    this.i.addAction("android.intent.action.SCREEN_OFF");
  }

  public static String a(String paramString)
  {
    if (l == null)
      return paramString;
    return l;
  }

  public static void a()
  {
    if (b == null)
      return;
    asp.a(a, "cleanup");
    c.l();
    b.shutdown();
    try
    {
      if (!b.awaitTermination(60L, TimeUnit.SECONDS))
      {
        b.shutdownNow();
        if (!b.awaitTermination(60L, TimeUnit.SECONDS))
          asp.b(a, "Thread pool did not terminate");
      }
      b = null;
      c = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        b.shutdownNow();
        Thread.currentThread().interrupt();
      }
    }
  }

  private void a(ComponentName paramComponentName, boolean paramBoolean)
  {
    while (true)
    {
      WeakReference localWeakReference;
      synchronized (this.j)
      {
        Iterator localIterator = this.j.iterator();
        if (!localIterator.hasNext())
          break label106;
        localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference == null) || (localWeakReference.get() == null))
          localIterator.remove();
      }
      if (paramBoolean);
      try
      {
        ((wr)localWeakReference.get()).b(paramComponentName);
        continue;
        ((wr)localWeakReference.get()).a(paramComponentName);
        continue;
        label106: return;
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  public static void a(Context paramContext, wr paramwr)
  {
    if (b != null)
      return;
    asp.a(a, "init");
    b = Executors.newSingleThreadExecutor(new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, wq.i());
      }
    });
    c = new wq(paramContext, paramwr);
    paramContext = alx.getInstance();
    if (paramContext != null)
      c.a(paramContext);
    paramContext = abd.g();
    if (paramContext != null)
      c.a((wr)paramContext);
    c.k();
  }

  public static void a(boolean paramBoolean)
  {
    q = paramBoolean;
  }

  public static wq b()
  {
    return c;
  }

  public static void b(boolean paramBoolean)
  {
    if (e != paramBoolean)
    {
      e = paramBoolean;
      d = j();
    }
  }

  private boolean b(ComponentName paramComponentName)
  {
    if ((paramComponentName == null) || (TextUtils.isEmpty(paramComponentName.getPackageName())) || ("DUMMY".equals(paramComponentName.getPackageName())));
    while ((asq.a(paramComponentName, this.k)) || ((EmptyActivity.a()) && ("com.lazyswipe".equals(paramComponentName.getPackageName()))))
      return false;
    a(paramComponentName);
    a(paramComponentName, false);
    return true;
  }

  public static boolean c()
  {
    return e;
  }

  public static void d()
  {
    d = j();
  }

  public static boolean e()
  {
    try
    {
      boolean bool = SwipeApplication.c().a().a.c(l);
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static String g()
  {
    return a(null);
  }

  private static int j()
  {
    if ((e) || (!aft.e()))
      return 2000;
    return 5000;
  }

  private void k()
  {
    m();
    o();
    f = false;
  }

  private void l()
  {
    p();
    n();
    f = true;
  }

  private void m()
  {
    if (this.m == null)
    {
      this.n = false;
      this.m = b.submit(this);
    }
  }

  private void n()
  {
    if (this.m != null)
    {
      this.n = true;
      this.m.cancel(true);
      this.m = null;
    }
  }

  private void o()
  {
    this.h.registerReceiver(this, this.i);
  }

  private void p()
  {
    this.h.unregisterReceiver(this);
  }

  private void q()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      List localList = this.g.getRecentTasks(1, 2);
      Object localObject;
      if ((localList == null) || (localList.size() <= 0))
      {
        localObject = null;
        if (localObject == null)
          break label73;
        localList.clear();
        if (!b(asq.a(this.h, (RecentTaskInfo)localObject)));
      }
      label166: 
      while (true)
      {
        return;
        localObject = (RecentTaskInfo)localList.get(0);
        break;
        label73: localList = this.g.getRunningTasks(1);
        if ((localList == null) || (localList.size() <= 0));
        for (localObject = null; ; localObject = (RunningTaskInfo)localList.get(0))
        {
          if (localObject == null)
            break label166;
          localList.clear();
          localObject = asq.b(this.h, ((RunningTaskInfo)localObject).baseActivity);
          if ((localObject == null) || ((this.k != null) && (((ComponentName)localObject).getPackageName().equals(this.k.getPackageName()))))
            break;
          b((ComponentName)localObject);
          return;
        }
      }
    }
    b(asq.c(this.h));
  }

  private void r()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject = this.g.getRunningTasks(1);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null)
          break label89;
        localObject = ((RunningTaskInfo)localObject).topActivity;
      }
    }
    while (true)
    {
      if ((localObject != null) && (!asq.a(this.o, localObject)))
      {
        this.p = 0;
        this.o = ((ComponentName)localObject);
        a((ComponentName)localObject, true);
      }
      return;
      localObject = (RunningTaskInfo)((List)localObject).get(0);
      break;
      localObject = asq.c(this.h);
      continue;
      label89: localObject = null;
    }
  }

  public void a(ComponentName paramComponentName)
  {
    this.k = paramComponentName;
    if (paramComponentName == null);
    for (paramComponentName = null; ; paramComponentName = paramComponentName.getPackageName())
    {
      l = paramComponentName;
      return;
    }
  }

  public void a(wr paramwr)
  {
    this.j.add(new ark(paramwr));
  }

  public void b(wr paramwr)
  {
    this.j.remove(new ark(paramwr));
  }

  public ComponentName c(boolean paramBoolean)
  {
    if (paramBoolean)
      q();
    return this.k;
  }

  public void f()
  {
    a(null);
  }

  public void h()
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject1 = this.g.getRunningTasks(1);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null)
          break label134;
        localObject1 = ((RunningTaskInfo)localObject1).topActivity;
      }
    }
    while (true)
    {
      if (localObject1 != null)
      {
        this.o = ((ComponentName)localObject1);
        Object localObject2 = localObject1;
        if (((ComponentName)localObject1).getPackageName().equals("com.whatsapp"))
        {
          localObject2 = localObject1;
          if (((ComponentName)localObject1).getClassName().equals("com.whatsapp.ContactPicker"))
            localObject2 = new ComponentName("FORCE", "FORCE_DISMISS");
        }
        a((ComponentName)localObject2, true);
      }
      if (!q)
      {
        this.p = 3;
        return;
        localObject1 = (RunningTaskInfo)((List)localObject1).get(0);
        break;
        localObject1 = asq.c(this.h);
        continue;
      }
      this.p = 0;
      return;
      label134: localObject1 = null;
    }
  }

  public void onReceive(Context arg1, Intent paramIntent)
  {
    ??? = paramIntent.getAction();
    boolean bool1;
    if ("android.intent.action.SCREEN_ON".equals(???))
    {
      m();
      bool1 = true;
    }
    while (true)
    {
      WeakReference localWeakReference;
      synchronized (this.j)
      {
        paramIntent = this.j.iterator();
        if (!paramIntent.hasNext())
          break;
        localWeakReference = (WeakReference)paramIntent.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null))
          break label104;
        paramIntent.remove();
      }
      if (!"android.intent.action.SCREEN_OFF".equals(???))
        return;
      n();
      yb.p();
      bool1 = false;
      continue;
      label104: boolean bool2 = localWeakReference.get() instanceof ws;
      if (bool2)
        try
        {
          ((ws)localWeakReference.get()).a(bool1);
        }
        catch (Throwable localThrowable)
        {
        }
    }
  }

  public void run()
  {
    asp.a(a, "Thread starts to run");
    Process.setThreadPriority(10);
    if (!this.n)
    {
      long l1;
      if (!q)
      {
        int i1 = this.p;
        this.p = (i1 - 1);
        if (i1 <= 0);
      }
      else
      {
        r();
        l1 = 1000L;
      }
      while (true)
      {
        try
        {
          Thread.sleep(l1);
        }
        catch (InterruptedException localInterruptedException)
        {
          asp.a(a, "Thread interrupted");
        }
        break;
        l1 = d;
        q();
      }
    }
    asp.a(a, "Thread ended");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wq
 * JD-Core Version:    0.6.2
 */