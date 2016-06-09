package cmcm.com.myapplication.com.flurry.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

public class eg<T extends fd>
{
  private static final String a = eg.class.getSimpleName();
  private final ds<Object, T> b = new ds();
  private final HashMap<T, Object> c = new HashMap();
  private final HashMap<T, Future<?>> d = new HashMap();
  private final ThreadPoolExecutor e;

  public eg(String paramString, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    this.e = new ThreadPoolExecutor(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue)
    {
      protected void afterExecute(Runnable arg1, final Throwable paramAnonymousThrowable)
      {
        super.afterExecute(???, paramAnonymousThrowable);
        paramAnonymousThrowable = eg.a(eg.this, ???);
        if (paramAnonymousThrowable == null)
          return;
        synchronized (eg.a(eg.this))
        {
          eg.a(eg.this).remove(paramAnonymousThrowable);
          eg.a(eg.this, paramAnonymousThrowable);
          new fc()
          {
            public void a()
            {
              paramAnonymousThrowable.k();
            }
          }
          .run();
          return;
        }
      }

      protected void beforeExecute(final Thread paramAnonymousThread, Runnable paramAnonymousRunnable)
      {
        super.beforeExecute(paramAnonymousThread, paramAnonymousRunnable);
        paramAnonymousThread = eg.a(eg.this, paramAnonymousRunnable);
        if (paramAnonymousThread == null)
          return;
        new fc()
        {
          public void a()
          {
            paramAnonymousThread.j();
          }
        }
        .run();
      }

      protected <V> RunnableFuture<V> newTaskFor(Runnable paramAnonymousRunnable, V arg2)
      {
        ef localef = new ef(paramAnonymousRunnable, ???);
        synchronized (eg.a(eg.this))
        {
          eg.a(eg.this).put((fd)paramAnonymousRunnable, localef);
          return localef;
        }
      }

      protected <V> RunnableFuture<V> newTaskFor(Callable<V> paramAnonymousCallable)
      {
        throw new UnsupportedOperationException("Callable not supported");
      }
    };
    this.e.setRejectedExecutionHandler(new DiscardPolicy()
    {
      public void rejectedExecution(Runnable arg1, final ThreadPoolExecutor paramAnonymousThreadPoolExecutor)
      {
        super.rejectedExecution(???, paramAnonymousThreadPoolExecutor);
        paramAnonymousThreadPoolExecutor = eg.a(eg.this, ???);
        if (paramAnonymousThreadPoolExecutor == null)
          return;
        synchronized (eg.a(eg.this))
        {
          eg.a(eg.this).remove(paramAnonymousThreadPoolExecutor);
          eg.a(eg.this, paramAnonymousThreadPoolExecutor);
          new fc()
          {
            public void a()
            {
              paramAnonymousThreadPoolExecutor.l();
            }
          }
          .run();
          return;
        }
      }
    });
    paramString = new ew(paramString, 1);
    this.e.setThreadFactory(paramString);
  }

  private T a(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof ef))
      return (fd)((ef)paramRunnable).a();
    if ((paramRunnable instanceof fd))
      return (fd)paramRunnable;
    el.a(6, a, "Unknown runnable class: " + paramRunnable.getClass().getName());
    return null;
  }

  private void b(T paramT)
  {
    try
    {
      c(this.c.get(paramT), paramT);
      return;
    }
    finally
    {
      paramT = finally;
    }
    throw paramT;
  }

  private void b(Object paramObject, T paramT)
  {
    try
    {
      this.b.a(paramObject, paramT);
      this.c.put(paramT, paramObject);
      return;
    }
    finally
    {
      paramObject = finally;
    }
    throw paramObject;
  }

  private void c(Object paramObject, T paramT)
  {
    try
    {
      this.b.b(paramObject, paramT);
      this.c.remove(paramT);
      return;
    }
    finally
    {
      paramObject = finally;
    }
    throw paramObject;
  }

  // ERROR //
  public void a(final T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 56	com/flurry/sdk/eg:d	Ljava/util/HashMap;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 56	com/flurry/sdk/eg:d	Ljava/util/HashMap;
    //   20: aload_1
    //   21: invokevirtual 144	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 146	java/util/concurrent/Future
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 122	com/flurry/sdk/eg:b	(Lcom/flurry/sdk/fd;)V
    //   35: aload_3
    //   36: ifnull +11 -> 47
    //   39: aload_3
    //   40: iconst_1
    //   41: invokeinterface 150 2 0
    //   46: pop
    //   47: new 17	com/flurry/sdk/eg$3
    //   50: dup
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 152	com/flurry/sdk/eg$3:<init>	(Lcom/flurry/sdk/eg;Lcom/flurry/sdk/fd;)V
    //   56: invokevirtual 155	com/flurry/sdk/eg$3:run	()V
    //   59: goto -53 -> 6
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_2
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	16	62	finally
    //   30	35	62	finally
    //   39	47	62	finally
    //   47	59	62	finally
    //   70	72	62	finally
    //   16	30	67	finally
    //   68	70	67	finally
  }

  public void a(Object paramObject)
  {
    if (paramObject == null);
    while (true)
    {
      return;
      try
      {
        HashSet localHashSet = new HashSet();
        localHashSet.addAll(this.b.a(paramObject));
        paramObject = localHashSet.iterator();
        while (paramObject.hasNext())
          a((fd)paramObject.next());
      }
      finally
      {
      }
    }
    throw paramObject;
  }

  public void a(Object paramObject, T paramT)
  {
    if ((paramObject == null) || (paramT == null));
    while (true)
    {
      return;
      try
      {
        b(paramObject, paramT);
        this.e.submit(paramT);
      }
      finally
      {
      }
    }
  }

  public long b(Object paramObject)
  {
    long l;
    if (paramObject == null)
      l = 0L;
    while (true)
    {
      return l;
      try
      {
        int i = this.b.a(paramObject).size();
        l = i;
      }
      finally
      {
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.eg
 * JD-Core Version:    0.6.2
 */