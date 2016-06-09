package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.lazyswipe.SwipeApplication;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class abt
  implements abc, abq, abr
{
  private static final String a = "Swipe." + abt.class.getSimpleName();
  private final int b;
  private abr c;
  private abq d;
  private long e;
  private volatile long f;
  private volatile long g;
  private long h;
  private boolean i;
  private Runnable j;

  public abt(int paramInt, abr paramabr)
  {
    this.b = paramInt;
    this.c = paramabr;
  }

  private void a(boolean paramBoolean, String paramString)
  {
    a(paramBoolean, paramString, 0);
  }

  private void a(final boolean paramBoolean, final String paramString, final int paramInt)
  {
    if (1 == vs.c(SwipeApplication.c(), 100))
      if (!paramBoolean)
        break label51;
    label51: for (long l1 = this.f; ; l1 = this.g)
    {
      long l2 = this.e;
      arj.a(abd.m, new Runnable() {
        public void run() {
          HashMap localHashMap = new HashMap(7);
          if (paramInt > 0)
            localHashMap.put("error_code", String.valueOf(paramInt));
          localHashMap.put("vendor", paramString);
          localHashMap.put("page", "b1");
          String str;
          if (paramBoolean) {
            str = "info";
            localHashMap.put("type", str);
            localHashMap.put("app", "300105");
            localHashMap.put("time_cost", String.valueOf(this.d));
            str = arl.a(SwipeApplication.c());
            if (str == null)
              break label142;
          }
          while (true) {
            localHashMap.put("network", str);
            ard.a(SwipeApplication.c(), "http://o.haloapps.com/v1/e.php?p=1", localHashMap);
            return;
            str = "image";
            break;
            label142:
            str = "";
          }
        }
      });
      return;
    }
  }

  private void b(boolean paramBoolean)
  {
    int k = 0;
    if (this.d == null);
    final String str3;
    final int i1;
    int i2;
    do
    {
      do
      {
        return;
        str3 = vs.u(SwipeApplication.c());
      }
      while (str3 == null);
      i1 = a();
      i2 = aav.b(i1);
    }
    while (i2 == 0);
    int i3 = Math.abs(str3.hashCode());
    int m = Calendar.getInstance().get(6);
    String str4 = String.format(Locale.US, "%03d", new Object[] { Integer.valueOf(m) });
    Object localObject = vs.a(SwipeApplication.c());
    final String str2 = ((SharedPreferences)localObject).getString("url_report_uid_mode", null);
    final String str1;
    if (str2 == null)
    {
      str1 = str4 + String.valueOf(1);
      k = 1;
      m = 1;
    }
    while (true)
    {
      if (k != 0)
        ((SharedPreferences)localObject).edit().putString("url_report_uid_mode", str1).apply();
      if ((m != i3 % 1000) || ((paramBoolean) && (2 != i2)) || ((!paramBoolean) && (1 != i2)))
        break;
      str1 = "b" + this.b;
      str2 = asi.b(this.d.d());
      localObject = asi.b(this.d.i());
      arj.a(abd.m, new Runnable() {
        public void run() {
          HashMap localHashMap = new HashMap(7);
          localHashMap.put("vendor", abd.a[i1]);
          localHashMap.put("app", "300105");
          localHashMap.put("page", str1);
          localHashMap.put("ad_title", str2);
          localHashMap.put("ad_cover", this.d);
          String str = arl.a(SwipeApplication.c());
          if (str != null) ;
          while (true) {
            localHashMap.put("network", str);
            localHashMap.put("locale", asq.j());
            localHashMap.put("uid", asi.b(str3));
            ard.a(SwipeApplication.c(), "http://o.haloapps.com/v1/e.php?p=2", localHashMap);
            return;
            str = "";
          }
        }
      });
      return;
      int n = asi.e(str2.substring(str4.length()));
      str1 = str2;
      m = n;
      if (!str2.startsWith(str4))
      {
        m = n + 1;
        k = m;
        if (m >= 1000)
          k = 1;
        str1 = str4 + String.valueOf(k);
        m = k;
        k = 1;
      }
    }
  }

  public int a()
  {
    if (this.d != null)
      return this.d.a();
    return 0;
  }

  public abt a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.h = 0L;
    this.f = 0L;
    switch (paramInt)
    {
    default:
      this.d = null;
      return null;
    case 2:
      this.d = new abk(paramContext, this.b, paramString, this);
    case 1:
    case 5:
    case 6:
    case 3:
    case 4:
    }
    while (true)
    {
      this.d.a(this);
      this.e = System.currentTimeMillis();
      this.d.a(false);
      return this;
      this.d = new abm(paramContext, this.b, paramString, this);
      continue;
      this.d = new abj(paramContext, this.b, this);
      continue;
      this.d = new abl(paramContext, this.b, this);
      continue;
      this.d = new abh(paramContext, this.b, paramInt, this);
    }
  }

  public void a(long paramLong)
  {
    this.h = paramLong;
  }

  public void a(abb paramabb, String paramString)
  {
    a(this, false, -2, "Could not download ad assets");
  }

  public void a(abb paramabb, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(this, false);
  }

  public void a(abq paramabq)
  {
    if (this.h <= 0L)
      this.h = System.currentTimeMillis();
    vy.b(abd.a[paramabq.a()], this.b);
    if (8 != this.b)
    {
      paramabq.b();
      paramabq.m();
    }
    if (this.c != null)
      this.c.a(this);
    if (this.j != null)
    {
      this.j.run();
      this.j = null;
    }
  }

  public void a(abq paramabq, boolean paramBoolean)
  {
    int k = paramabq.a();
    aav.a(SwipeApplication.c(), k);
    long l = System.currentTimeMillis();
    if (paramBoolean)
    {
      this.f = l;
      if (this.c != null)
        this.c.a(this, paramBoolean);
      if (!paramBoolean)
        break label108;
      b(false);
      if (!this.i)
        break label101;
    }
    while (true)
    {
      if ((1 == this.b) && ((k == 2) || (k == 1)))
        a(paramBoolean, abd.a[k]);
      return;
      this.g = l;
      break;
      label101: q();
      continue;
      label108: if (1 == a())
        b(false);
    }
  }

  public void a(abq paramabq, boolean paramBoolean, int paramInt, String paramString)
  {
    int k = paramabq.a();
    if ((1 == k) && (4 == paramInt));
    while (true)
    {
      paramabq.m();
      if (this.c != null)
        this.c.a(this, paramBoolean, 0, paramString);
      this.d = null;
      return;
      aav.b(SwipeApplication.c(), k);
      if ((1 == this.b) && ((k == 2) || (k == 1)))
        a(paramBoolean, abd.a[k], paramInt);
    }
  }

  public void a(abr paramabr)
  {
    this.c = paramabr;
  }

  public void a(View paramView)
  {
    a(paramView, false);
  }

  public void a(View paramView, Runnable paramRunnable)
  {
    a(paramView);
    this.j = paramRunnable;
  }

  public void a(View paramView, boolean paramBoolean)
  {
    if (this.d != null)
    {
      if (paramBoolean)
        break label31;
      p();
    }
    while (true)
    {
      this.d.a(paramView);
      b(true);
      return;
      label31: vy.a(abd.a[this.d.a()], this.b);
    }
  }

  public void a(View paramView, boolean paramBoolean, Runnable paramRunnable)
  {
    a(paramView, paramBoolean);
    this.j = paramRunnable;
  }

  public void a(boolean paramBoolean)
  {
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.d == null) || (1 == a()) || ((2 == this.b) && (arl.e(SwipeApplication.c()))))
      return;
    new abb(this, paramBoolean1, paramBoolean2).a(this.d);
  }

  public void b()
  {
    if (this.d != null);
    try
    {
      this.d.b();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public String c()
  {
    if (this.d == null)
      return null;
    return this.d.c();
  }

  public String d()
  {
    if (this.d == null)
      return null;
    return this.d.d();
  }

  public String e()
  {
    if (this.d == null)
      return null;
    return this.d.e();
  }

  public String f()
  {
    if (this.d == null)
      return null;
    return this.d.f();
  }

  public String g()
  {
    if (this.d == null)
      return null;
    return this.d.g();
  }

  public String h()
  {
    if (this.d == null)
      return null;
    return this.d.h();
  }

  public String i()
  {
    if (this.d == null)
      return null;
    return this.d.i();
  }

  public Drawable j()
  {
    if (this.d == null)
      return null;
    return this.d.j();
  }

  public Drawable k()
  {
    if (this.d == null)
      return null;
    return this.d.k();
  }

  public long l()
  {
    if (this.d != null)
      return this.d.l();
    return 0L;
  }

  public void m()
  {
    if (this.d != null)
      this.d.m();
  }

  public void n()
  {
    a(System.currentTimeMillis());
  }

  public long o()
  {
    return this.h;
  }

  public void p()
  {
    vy.a(abd.a[this.d.a()], this.b);
    this.h = System.currentTimeMillis();
  }

  public void q()
  {
    if ((9 != this.b) && (10 != this.b));
    for (boolean bool = true; ; bool = false)
    {
      a(bool, true);
      return;
    }
  }

  public boolean r()
  {
    return this.f > 0L;
  }

  public boolean s()
  {
    return this.g > 0L;
  }

  public boolean t()
  {
    return this.d == null;
  }

  public String toString()
  {
    if (this.d == null)
      return "NULL";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.getClass().getSimpleName()).append('@').append(Integer.toHexString(hashCode()));
    return localStringBuilder.toString();
  }

  public boolean u()
  {
    return (this.d != null) && (((this.f > 0L) && (System.currentTimeMillis() - this.f > this.d.l())) || ((this.f <= 0L) && (System.currentTimeMillis() - this.e > this.d.l())));
  }

  public boolean v()
  {
    return this.h > 0L;
  }

  public ImageView w()
  {
    if ((this.d == null) || (1 != this.d.a()))
      return null;
    return ((abm)this.d).n();
  }

  public int x()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abt
 * JD-Core Version:    0.6.2
 */