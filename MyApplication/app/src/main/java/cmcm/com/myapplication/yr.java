package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.List;

public class yr
{
  final Handler a;
  volatile boolean b = false;
  private final Context c;
  private final ArrayList<yw> d = new ArrayList(1);
  private yw e;

  public yr(Context paramContext, Handler paramHandler)
  {
    this.c = paramContext;
    this.a = paramHandler;
  }

  private void c()
  {
    if (this.b)
      return;
    this.b = true;
    new Thread()
    {
      public void run()
      {
        int i = 0;
        while (true)
        {
          if ((i >= 60) || (yr.this.a()));
          while (!yb.o())
          {
            if (yr.this.a != null)
              yr.this.a.sendEmptyMessage(0);
            yr.this.b = false;
            return;
          }
          yr.this.b();
          try
          {
            Thread.sleep(500L);
            label68: i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            break label68;
          }
        }
      }
    }
    .start();
  }

  private yw d()
  {
    if (this.e == null)
      this.e = new ys(this.c.getString(2131230736), new ava(this.c));
    return this.e;
  }

  public List<yw> a(aao paramaao)
  {
    auu.a(System.currentTimeMillis() + ": AppInfoLoader starts");
    if ((paramaao.b_()) && (!a()))
    {
      this.d.clear();
      this.d.add(d());
      c();
      return this.d;
    }
    paramaao = paramaao.c(this.c);
    if ((paramaao == null) || (paramaao.size() == 0))
    {
      this.d.clear();
      return this.d;
    }
    auu.a(System.currentTimeMillis() + ": AppInfoLoader ends");
    return paramaao;
  }

  boolean a()
  {
    return ((SwipeApplication)this.c.getApplicationContext()).a().b;
  }

  void b()
  {
    SwipeApplication localSwipeApplication = (SwipeApplication)this.c.getApplicationContext();
    if (!localSwipeApplication.a().c)
      localSwipeApplication.a().d();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yr
 * JD-Core Version:    0.6.2
 */