package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class xq extends HandlerThread
  implements Callback
{
  public Handler a;
  private final ArrayList<xo> b = new ArrayList();
  private final ArrayList<ComponentName> c = new ArrayList();
  private final ArrayList<ComponentName> d = new ArrayList();
  private final ArrayList<xo> e = new ArrayList();
  private final ArrayList<xo> f = new ArrayList();
  private final Map<ComponentName, ArrayList<xo>> g = new HashMap();
  private final Object h = new Object();
  private final xr i;
  private boolean j;
  private boolean k;

  public xq(Context paramContext)
  {
    super("Swipe.cache.IconLoader");
    this.i = new xr(paramContext.getApplicationContext(), null);
  }

  private ArrayList<xo> a(ComponentName paramComponentName)
  {
    return (ArrayList)this.g.remove(paramComponentName);
  }

  public static xq a(Context paramContext)
  {
    paramContext = new xq(paramContext);
    paramContext.start();
    return paramContext;
  }

  private void a(int paramInt, xo paramxo)
  {
    Message localMessage = this.a.obtainMessage();
    localMessage.obj = paramxo;
    localMessage.what = paramInt;
    localMessage.sendToTarget();
  }

  private void a(ComponentName paramComponentName, xo paramxo)
  {
    ArrayList localArrayList2 = (ArrayList)this.g.get(paramComponentName);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.g.put(paramComponentName, localArrayList1);
    }
    localArrayList1.add(paramxo);
  }

  public static boolean a(xq paramxq)
  {
    if (paramxq == null)
      return false;
    paramxq.d();
    paramxq.interrupt();
    try
    {
      paramxq.i.a();
      label22: return paramxq.quit();
    }
    catch (Throwable localThrowable)
    {
      break label22;
    }
  }

  private xo b(xo paramxo)
  {
    try
    {
      Bitmap localBitmap = this.i.b(paramxo.b());
      apd localapd = null;
      if (atw.b(localBitmap))
        localapd = new apd(localBitmap);
      paramxo.a = localapd;
      return paramxo;
    }
    catch (Throwable localThrowable)
    {
    }
    return paramxo;
  }

  private void c(final xo paramxo)
  {
    if (this.f.size() >= 3)
    {
      if (!this.c.contains(paramxo.b()))
      {
        this.c.add(paramxo.b());
        this.e.add(paramxo);
        return;
      }
      a(paramxo.b(), paramxo);
      return;
    }
    this.d.add(paramxo.b());
    this.f.add(paramxo);
    new Thread(new Runnable()
    {
      public void run()
      {
        xq.a(xq.this, paramxo);
        xq.a(xq.this, 2, paramxo);
      }
    }).start();
  }

  private void d(xo paramxo)
  {
    try
    {
      this.f.remove(paramxo);
      if (this.e.size() > 0)
      {
        paramxo = (xo)this.e.remove(0);
        this.c.remove(paramxo.b());
        a(1, paramxo);
      }
      return;
    }
    catch (Throwable paramxo)
    {
      Log.w("Swipe.cache.IconLoader", "Exception in bitmapAsyncLoaded", paramxo);
    }
  }

  public xo a(xo paramxo)
  {
    if (this.i.a(paramxo.b()))
    {
      ??? = this.i.b(paramxo.b());
      if (atw.b((Bitmap)???))
      {
        paramxo.a = new apd((Bitmap)???);
        return paramxo;
      }
    }
    if (this.k)
    {
      this.j = true;
      return null;
    }
    if (this.a != null)
    {
      a(1, paramxo);
      return null;
    }
    while (true)
    {
      synchronized (this.h)
      {
        if (this.a == null)
          this.b.add(paramxo);
      }
      a(1, paramxo);
    }
  }

  public void a()
  {
    this.j = d();
    this.k = true;
  }

  public void b()
  {
    this.j = false;
    this.k = false;
  }

  public boolean c()
  {
    return this.j;
  }

  public boolean d()
  {
    boolean bool = false;
    if (this.a != null)
      if (!this.a.hasMessages(1))
      {
        m = 0;
        this.a.removeMessages(1);
        if ((this.g.isEmpty()) && (m == 0))
          break label184;
      }
    label184: for (int m = 1; ; m = 0)
    {
      ??? = this.g.entrySet().iterator();
      while (((Iterator)???).hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Entry)((Iterator)???).next()).getValue();
        if (localArrayList != null)
          localArrayList.clear();
      }
      m = 1;
      break;
      while (true)
      {
        synchronized (this.h)
        {
          if (this.a == null)
            break;
          if (!this.a.hasMessages(1))
          {
            m = 0;
            this.a.removeMessages(1);
          }
        }
        m = 1;
      }
      if (this.b.isEmpty());
      for (m = 0; ; m = 1)
      {
        this.b.clear();
        break;
      }
    }
    this.g.clear();
    if ((!this.c.isEmpty()) || (m != 0))
    {
      m = 1;
      this.c.clear();
      if ((this.d.isEmpty()) && (m == 0))
        break label299;
      m = 1;
      label237: this.d.clear();
      if ((this.e.isEmpty()) && (m == 0))
        break label304;
    }
    label299: label304: for (m = 1; ; m = 0)
    {
      this.e.clear();
      if ((!this.f.isEmpty()) || (m != 0))
        bool = true;
      this.f.clear();
      return bool;
      m = 0;
      break;
      m = 0;
      break label237;
    }
  }

  public Bitmap e()
  {
    return this.i.b();
  }

  public boolean handleMessage(Message paramMessage)
  {
    xo localxo1 = (xo)paramMessage.obj;
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return true;
      if (!this.d.contains(localxo1.b()))
      {
        c(localxo1);
      }
      else
      {
        a(localxo1.b(), localxo1);
        continue;
        paramMessage = a(localxo1.b());
        localxo1.a();
        if (paramMessage != null)
        {
          Iterator localIterator = paramMessage.iterator();
          while (localIterator.hasNext())
          {
            xo localxo2 = (xo)localIterator.next();
            localxo2.a = localxo1.a;
            localxo2.a();
          }
        }
        this.d.remove(localxo1.b());
        if (paramMessage != null)
          paramMessage.clear();
        d(localxo1);
      }
    }
  }

  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
    synchronized (this.h)
    {
      if (this.a != null)
        break label97;
      this.a = new Handler(getLooper(), this);
      if ((this.b == null) || (this.b.size() <= 0))
        break label97;
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext())
        a(1, (xo)localIterator.next());
    }
    this.b.clear();
    label97:
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xq
 * JD-Core Version:    0.6.2
 */