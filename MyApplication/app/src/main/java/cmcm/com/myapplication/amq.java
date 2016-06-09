package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.tile.FlashlightActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class amq extends ans
  implements Callback
{
  protected static final String a = "Swipe." + amy.class.getSimpleName();
  private static aoi b;
  private static Boolean c = null;
  private static FrameLayout d;
  private static WakeLock m;
  private static Thread n;
  private final Handler o = new Handler(this);
  private final Runnable p = new Runnable()
  {
    public void run()
    {
      vy.a(amq.this.c());
      amq.this.i();
    }
  };

  public amq(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  private static void a(Context paramContext, int paramInt, amq paramamq)
  {
    if ((n == null) || (!n.isAlive()))
      b(paramContext, paramInt, paramamq);
  }

  private static void a(Context paramContext, amq paramamq)
  {
    Intent localIntent = new Intent(paramContext, FlashlightActivity.class);
    localIntent.setFlags(268435456);
    paramContext.startActivity(localIntent);
    if (paramamq != null)
      paramamq.a(paramContext, 0);
    yb.p();
  }

  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (b == null)
      b = m(paramContext);
    b.d();
    if (b.b())
    {
      o(paramContext);
      k();
      q();
      return;
    }
    throw new RuntimeException();
  }

  private static void b(Context paramContext, final int paramInt, final amq paramamq)
  {
    final HashMap localHashMap = new HashMap();
    localHashMap.put("resolver", paramamq);
    n = new Thread(new Runnable()
    {
      public void run()
      {
        boolean bool = false;
        if (amq.n() == null)
        {
          if (((aqs.r()) || (aqs.q()) || (aqs.s()) || (aqs.x()) || (aqs.i())) && (Looper.myLooper() == null))
            Looper.prepare();
          amq.a(amq.g(amq.this));
          if (amq.n() != null)
            amq.a(Boolean.valueOf(true));
        }
        while (true)
        {
          localHashMap.put("isTurningOn", Boolean.valueOf(bool));
          Message.obtain(paramamq.j(), paramInt, localHashMap).sendToTarget();
          if (Looper.myLooper() != null)
            Looper.myLooper().quit();
          return;
          amq.a(Boolean.valueOf(false));
          continue;
          amq.a(Boolean.valueOf(true));
          bool = true;
        }
      }
    });
    n.start();
  }

  private void l(final Context paramContext)
  {
    final aoi localaoi = b;
    b = null;
    if (localaoi != null)
      this.o.postDelayed(new Runnable()
      {
        public void run()
        {
          amq.f(paramContext);
          localaoi.c();
          amq.m();
          amq.this.t_();
        }
      }
      , 25L);
  }

  private static aoi m(Context paramContext)
  {
    if (b == null)
      b = aoi.a(paramContext.getApplicationContext());
    c = Boolean.valueOf(false);
    if (b != null)
    {
      LayoutParams localLayoutParams = new LayoutParams();
      localLayoutParams.type = 2002;
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.width = 0;
      localLayoutParams.height = 0;
      localLayoutParams.gravity = (vj.a | 0x30);
      if (d == null)
      {
        d = new FrameLayout(paramContext.getApplicationContext());
        d.setBackgroundColor(0);
        if (d.getParent() == null);
      }
      try
      {
        ((WindowManager)paramContext.getSystemService("window")).addView(d, localLayoutParams);
        b.a(d);
        c = Boolean.valueOf(true);
        return b;
      }
      catch (Throwable paramContext)
      {
        asp.a(a, "Failed to setup flashlight surface view", paramContext);
        return null;
      }
    }
    return null;
  }

  private static void n(Context paramContext)
  {
    if ((d != null) && (d.getParent() != null))
    {
      ((WindowManager)paramContext.getSystemService("window")).removeView(d);
      d = null;
    }
  }

  private static void o(Context paramContext)
  {
    if (m == null)
    {
      m = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(6, amy.class.getCanonicalName());
      m.acquire();
    }
  }

  private static void p()
  {
    if ((m != null) && (m.isHeld()))
    {
      m.release();
      m = null;
    }
  }

  private void q()
  {
    yb localyb = yb.getInstance();
    if (localyb == null);
    while (true)
    {
      return;
      Object localObject = localyb.getItemLayer();
      if (localObject != null)
      {
        Iterator localIterator = ((xu)localObject).getItems().iterator();
        do
        {
          if (!localIterator.hasNext())
            break;
          localObject = (FanItem)localIterator.next();
        }
        while ((localObject == null) || (!(((FanItem)localObject).getTag() instanceof zf)) || (((zf)((FanItem)localObject).getTag()).w() != this));
        while (localObject != null)
        {
          localObject = ((FanItem)localObject).getIconPosition();
          int i = localObject[2] / 2;
          localyb.a(localObject[0] + i, localObject[1] + i, i, this.p);
          return;
          localObject = null;
        }
      }
    }
  }

  public int a(Context paramContext)
  {
    if (b != null)
      return 1;
    return 0;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837822;
  }

  public boolean a_(Context paramContext)
  {
    return false;
  }

  public String b()
  {
    return "Flashlight";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_flashlight";
  }

  public void b_(Context paramContext)
  {
    if ((b == null) && ((c == null) || (!c.booleanValue())))
    {
      a(paramContext, 1, this);
      return;
    }
    try
    {
      if (b == null)
      {
        a(paramContext, false, true);
        return;
      }
    }
    catch (Exception localException)
    {
      asp.b(a, "toggleState ledlight error ", localException);
      a(paramContext, this);
      if (b != null)
        b.c();
      b = null;
      return;
    }
    l(paramContext);
  }

  public int c()
  {
    return 5;
  }

  public int d()
  {
    return 2131231118;
  }

  public boolean d(final Context paramContext)
  {
    if (a(paramContext) == 0)
    {
      Object localObject = (zf)this.f;
      if (localObject != null)
      {
        paramContext = ((zf)localObject).a(true);
        if (paramContext != null)
        {
          localObject = ((zf)localObject).j();
          if (localObject != null)
            this.o.postDelayed(new Runnable()
            {
              public void run()
              {
                this.a.setIconBackground(paramContext);
              }
            }
            , 50L);
        }
      }
    }
    b_(this.e);
    return false;
  }

  public boolean e()
  {
    return false;
  }

  public boolean handleMessage(Message paramMessage)
  {
    Map localMap = (Map)paramMessage.obj;
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    switch (paramMessage.what)
    {
    default:
    case 1:
    }
    while (true)
    {
      return super.handleMessage(paramMessage);
      amy localamy = (amy)localMap.get("resolver");
      boolean bool = ((Boolean)localMap.get("isTurningOn")).booleanValue();
      if ((c != null) && (c.booleanValue()))
      {
        if (!bool);
        while (true)
        {
          try
          {
            a(localSwipeApplication, false, true);
            if (localamy == null)
              break;
            localamy.y_();
          }
          catch (Exception localException)
          {
            asp.b(a, "toggleState ledlight error ", localException);
            a(localSwipeApplication, localamy);
            if (b != null)
              b.c();
            b = null;
          }
          break;
          l(localSwipeApplication);
        }
      }
      a(localSwipeApplication, localamy);
    }
  }

  Handler j()
  {
    return this.o;
  }

  protected void k()
  {
  }

  protected void t_()
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amq
 * JD-Core Version:    0.6.2
 */