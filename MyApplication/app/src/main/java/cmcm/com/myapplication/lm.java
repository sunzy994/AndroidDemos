package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class lm extends lh
  implements Callback
{
  private final List g;
  private int h;
  private int i = 0;
  private final List j = Collections.synchronizedList(new LinkedList());
  private Handler k;
  private Context l = null;

  public lm(Context paramContext, int paramInt1, long paramLong, int paramInt2)
  {
    super(paramContext, paramInt1, paramLong);
    this.l = paramContext;
    np.a(this.e);
    paramContext = new HandlerThread("fbnative", 10);
    paramContext.start();
    this.k = new Handler(paramContext.getLooper(), this);
    this.g = nm.a(this.l).a(paramInt1);
    if ((this.g == null) || (this.g.size() <= 0))
    {
      mv.c("FbCache", "Refresh request failed: no available Placement Id");
      throw new IllegalArgumentException("Please setup fbids in DuAdNetwork init method");
    }
    if (paramInt2 > 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 5);
    }
    else
    {
      paramInt1 = 1;
    }
    this.h = paramInt1;
    this.k.sendEmptyMessageDelayed(1, 3300000L);
  }

  private String d()
  {
    synchronized (this.g)
    {
      String str = (String)this.g.get(this.i);
      this.i = ((this.i + 1) % this.g.size());
      return str;
    }
  }

  public final void a()
  {
    if (!np.b(this.l))
      return;
    if (!np.a(this.l, "com.facebook.katana"))
    {
      mv.c("FbCache", "facebook not installed");
      return;
    }
    mv.c("FbCache", "Refresh request...");
    if (this.h <= 0)
    {
      mv.c("FbCache", "Refresh request failed: no available Placement Id");
      return;
    }
    this.k.obtainMessage(0).sendToTarget();
  }

  public final li b()
  {
    Object localObject1 = null;
    synchronized (this.j)
    {
      while (this.j.size() > 0)
      {
        localObject2 = (ls)this.j.remove(0);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((ls)localObject2).i())
          {
            ((ls)localObject2).b();
            localObject1 = localObject2;
          }
        }
      }
    }
    ??? = this.l;
    if (localli == null);
    for (Object localObject2 = "FAIL"; ; localObject2 = "OK")
    {
      nr.a((Context) ???, (String)localObject2, this.e);
      return localli;
    }
  }

  public final int c()
  {
    int m;
    while (true)
    {
      ls localls;
      synchronized (this.j)
      {
        Iterator localIterator = this.j.iterator();
        m = 0;
        if (!localIterator.hasNext())
          break;
        localls = (ls)localIterator.next();
        if (localls == null)
          localIterator.remove();
      }
      if (localls.i())
      {
        m += 1;
      }
      else
      {
        localObject.remove();
        localls.b();
      }
    }
    return m;
  }

  public final boolean handleMessage(Message arg1)
  {
    int m = ???.what;
    if (m == 0)
    {
      this.k.removeMessages(0);
      if (this.b)
      {
        mv.c("FbCache", "Refresh request failed: already refreshing");
        return true;
      }
      this.b = true;
      while (true)
      {
        ls localls2;
        synchronized (this.j)
        {
          Iterator localIterator = this.j.iterator();
          m = 0;
          if (!localIterator.hasNext())
            break;
          localls2 = (ls)localIterator.next();
          if (localls2 == null)
            localIterator.remove();
        }
        if (localls2.i())
        {
          m += 1;
        }
        else
        {
          localObject.remove();
          localls2.b();
        }
      }
      if (m < this.h)
      {
        int n = this.h - m;
        if (mv.a())
          mv.c("FbCache", "Refresh request send: green = " + m + " ,need = " + n);
        this.k.obtainMessage(2, n, 0).sendToTarget();
      }
      while (true)
      {
        return true;
        mv.c("FbCache", "Refresh request OK: green is full");
        this.b = false;
      }
    }
    if (m == 2)
    {
      m = ???.arg1;
      if (m > 0)
      {
        ??? = d();
        ls localls1 = new ls(this.l, ???, this.e);
        localls1.a(new ln(this, ???, localls1, SystemClock.elapsedRealtime(), m));
        localls1.j();
      }
      while (true)
      {
        return true;
        this.b = false;
        mv.c("FbCache", "Refresh result: DONE for geeen count");
      }
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lm
 * JD-Core Version:    0.6.2
 */