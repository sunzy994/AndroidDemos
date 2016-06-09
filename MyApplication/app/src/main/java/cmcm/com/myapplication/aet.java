package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

public class aet
  implements abp, aek
{
  private final Context a;
  private final aew b;
  private long c;
  private final Handler d;
  private int e;
  private boolean f;

  public aet(Context paramContext, aew paramaew)
  {
    this.a = paramContext;
    this.b = paramaew;
    this.d = new Handler(Looper.getMainLooper());
  }

  private String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Lucky_");
    if (paramBoolean);
    for (String str = "AD"; ; str = "CT")
      return str;
  }

  private String d()
  {
    if (this.e == 0);
    for (boolean bool = true; ; bool = false)
      return a(bool);
  }

  private void e()
  {
    this.d.removeCallbacksAndMessages(null);
    if (this.b.b())
      return;
    vv.a().a(d(), "r", "failure");
    this.b.a(false, null);
  }

  private void f()
  {
    this.d.postDelayed(new Runnable()
    {
      public void run()
      {
        try
        {
          aet.b(aet.this);
          abd.i.a(null, 1);
          return;
        }
        catch (Throwable localThrowable)
        {
        }
      }
    }
    , Math.max(0L, 3000L - System.currentTimeMillis() + this.c));
  }

  public Object a()
  {
    return null;
  }

  public void a(abq paramabq)
  {
    abe.a();
    this.b.c();
    asq.t(this.a);
  }

  public void a(final abq paramabq, boolean paramBoolean)
  {
    this.d.removeCallbacksAndMessages(null);
    if (this.b.b());
    while ((1 != paramabq.a()) && (paramBoolean))
      return;
    this.d.postDelayed(new Runnable()
    {
      public void run()
      {
        aet.a(aet.this).a(true, null);
        ((abt)paramabq).p();
        abd.i.a(null, 1);
        vv.a().a(aet.a(aet.this, true), "r", "success");
      }
    }
    , Math.max(0L, 3000L - System.currentTimeMillis() + this.c));
  }

  public void a(abq paramabq, boolean paramBoolean, int paramInt, String paramString)
  {
    this.d.removeCallbacksAndMessages(null);
    f();
  }

  void a(aem paramaem)
  {
    try
    {
      this.b.getAdView().a(paramaem.a, paramaem.b);
      abd.i.a(paramaem);
      this.b.a(true, null);
      return;
    }
    catch (Throwable paramaem)
    {
      this.b.a(false, null);
    }
  }

  public void a(final Object paramObject)
  {
    this.d.removeCallbacksAndMessages(null);
    if (this.b.b());
    do
    {
      return;
      vv.a().a(a(false), "r", "success");
    }
    while (this.e != 1);
    this.d.postDelayed(new Runnable()
    {
      public void run()
      {
        if ((paramObject instanceof aem))
          aet.this.a((aem)paramObject);
      }
    }
    , Math.max(0L, 3000L - System.currentTimeMillis() + this.c));
  }

  public void a(Object paramObject, int paramInt, String paramString)
  {
    this.d.removeCallbacksAndMessages(null);
    if (this.b.b());
    do
    {
      return;
      vv.a().a(a(false), "r", "failure");
    }
    while (this.e != 1);
    this.d.postDelayed(new Runnable()
    {
      public void run()
      {
        aet.a(aet.this).a(false, null);
      }
    }
    , Math.max(0L, 3000L - System.currentTimeMillis() + this.c));
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f = paramBoolean2;
    if (!paramBoolean1)
      vy.b(this.a, "CC");
    int i;
    while (true)
    {
      this.d.removeCallbacksAndMessages(null);
      this.c = System.currentTimeMillis();
      if (!abd.i.a(1))
        break;
      this.e = 0;
      asp.a("Swipe.AdRunner", "Category: " + this.e);
      i = 1;
      if (i != 0)
        break label185;
      this.b.getAdView().a(false);
      abd.i.a(this);
      return;
      vy.b(this.a, "CD");
    }
    while (true)
    {
      try
      {
        this.e = abd.i.a();
        if (this.e != 0)
          break label179;
        i = 1;
        asp.a("Swipe.AdRunner", "Category: " + this.e);
      }
      catch (Throwable localThrowable)
      {
        asp.a("Swipe.AdRunner", "Could not get next category", localThrowable);
        i = 0;
      }
      break;
      label179: i = 0;
    }
    label185: this.b.getAdView().a(true);
    abd.i.a(this, 1);
  }

  public View b(abq paramabq)
  {
    return this.b.getAdView().a();
  }

  public void b()
  {
    if (!this.b.getAdView().e())
      vv.a().a(d(), "r", "cancelled");
    this.d.removeCallbacksAndMessages(null);
    abd.i.b();
  }

  public void c(abq paramabq)
  {
  }

  public abg getAdViewHolder()
  {
    return this.b.getAdView().j();
  }

  public boolean i_()
  {
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aet
 * JD-Core Version:    0.6.2
 */