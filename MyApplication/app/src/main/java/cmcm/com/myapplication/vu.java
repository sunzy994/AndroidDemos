package cmcm.com.myapplication;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.notification.SwipeAccessibilityService;
import java.util.ArrayList;
import java.util.List;

public class vu
  implements OnSharedPreferenceChangeListener
{
  private final Vibrator A;
  private final SwipeService B;
  private final WindowManager C;
  private int D;
  private avb E;
  private boolean F;
  private final Runnable G = new Runnable()
  {
    public void run()
    {
      vu.this.f();
    }
  };
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public final int f;
  public final int g;
  public int h;
  public final int i;
  public final int j;
  public final int k;
  public final int l;
  public int m;
  public int n;
  public float o;
  public final int p;
  public final int q;
  public final int r;
  public final int s;
  public final int t;
  private avd u;
  private avd v;
  private avd w;
  private avd x;
  private avd y;
  private avd z;

  public vu(SwipeService paramSwipeService)
  {
    this.B = paramSwipeService;
    this.A = asq.o(paramSwipeService);
    this.C = ((WindowManager)paramSwipeService.getSystemService("window"));
    paramSwipeService = this.B.getResources();
    DisplayMetrics localDisplayMetrics = paramSwipeService.getDisplayMetrics();
    this.m = localDisplayMetrics.widthPixels;
    this.n = localDisplayMetrics.heightPixels;
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    try
    {
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(this.B);
      this.e = localViewConfiguration.getScaledTouchSlop();
      this.h = localViewConfiguration.getScaledMinimumFlingVelocity();
      this.f = asq.a(35.0F);
      this.g = (this.f * this.f);
      this.i = (this.h * this.h);
      this.j = (this.h << 5);
      this.k = (this.h << 4);
      this.l = ((int)(this.h * 5.5F));
      this.q = paramSwipeService.getDimensionPixelSize(2131296297);
      this.p = paramSwipeService.getDimensionPixelSize(2131296296);
      this.s = paramSwipeService.getDimensionPixelSize(2131296295);
      this.r = paramSwipeService.getDimensionPixelSize(2131296294);
      this.t = paramSwipeService.getDimensionPixelSize(2131296398);
      this.o = l();
      a(localDisplayMetrics);
      this.D = vs.d(localSwipeApplication);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.e = asq.a(8.0F);
        this.h = asq.a(50.0F);
      }
    }
  }

  private void a(DisplayMetrics paramDisplayMetrics)
  {
    this.a = ((int)(this.o * this.q));
    this.b = ((int)(this.o * this.r));
    this.c = ((int)(this.a / paramDisplayMetrics.density));
    this.d = ((int)(this.b / paramDisplayMetrics.density));
  }

  private float b(int paramInt)
  {
    if (48 != paramInt)
      return ((paramInt << 2) + 96) / 96.0F / 3.0F;
    return 1.0F;
  }

  private avd k()
  {
    if (vs.B(this.B))
    {
      if ((this.u != null) && (this.u.f()))
        return this.u;
    }
    else if ((this.v != null) && (this.v.f()))
      return this.v;
    return null;
  }

  private float l()
  {
    return b(vs.p(this.B));
  }

  public LayoutParams a()
  {
    LayoutParams localLayoutParams = new LayoutParams(0, 0, vs.b(this.B, true), 262184, -3);
    localLayoutParams.gravity = (vj.b | 0x50);
    return localLayoutParams;
  }

  public void a(int paramInt)
  {
    this.o = b(paramInt);
    a(this.B.getResources().getDisplayMetrics());
    if (this.u != null)
    {
      this.u.a(true);
      if (this.w != null)
        this.w.a(true);
      if (this.y != null)
        this.y.a(true);
    }
    if (this.v != null)
    {
      this.v.a(true);
      if (this.x != null)
        this.x.a(true);
      if (this.z != null)
        this.z.a(true);
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    int i1;
    int i2;
    label20: int i3;
    label30: int i4;
    label42: int i5;
    if (1 == (paramInt & 0x1))
    {
      i1 = 1;
      if (4 != (paramInt & 0x4))
        break label368;
      i2 = 1;
      if (2 != (paramInt & 0x2))
        break label374;
      i3 = 1;
      if (8 != (paramInt & 0x8))
        break label380;
      i4 = 1;
      i5 = paramInt & 0x1 | (paramInt & 0x4) >> 1;
      paramInt = (paramInt & 0x2) >> 1 | (paramInt & 0x8) >> 2;
      if (this.u == null)
        break label558;
      if ((i1 != 0) || (i2 != 0))
        break label386;
      this.u.h();
      this.u = null;
      if (this.w != null)
      {
        this.w.h();
        this.w = null;
      }
      if (this.y != null)
      {
        this.y.h();
        this.y = null;
      }
      label133: if (this.v == null)
        break label863;
      if ((i3 != 0) || (i4 != 0))
        break label692;
      this.v.h();
      this.v = null;
      if (this.x != null)
      {
        this.x.h();
        this.x = null;
      }
      if (this.z != null)
      {
        this.z.h();
        this.z = null;
      }
    }
    while (true)
    {
      if (SwipeAccessibilityService.a)
      {
        ArrayList localArrayList = new ArrayList();
        if (this.u != null)
        {
          localArrayList.add(this.u.getBoundsInScreen());
          if (this.w != null)
            localArrayList.add(this.w.getBoundsInScreen());
          if (this.y != null)
            localArrayList.add(this.y.getBoundsInScreen());
        }
        if (this.v != null)
        {
          localArrayList.add(this.v.getBoundsInScreen());
          if (this.x != null)
            localArrayList.add(this.x.getBoundsInScreen());
          if (this.z != null)
            localArrayList.add(this.z.getBoundsInScreen());
        }
        SwipeAccessibilityService.a((Rect[])localArrayList.toArray(new Rect[localArrayList.size()]));
      }
      return;
      i1 = 0;
      break;
      label368: i2 = 0;
      break label20;
      label374: i3 = 0;
      break label30;
      label380: i4 = 0;
      break label42;
      label386: if (i1 == 0)
      {
        if (this.w != null)
        {
          this.w.h();
          this.w = null;
        }
        if (this.y != null)
        {
          this.y.h();
          this.y = null;
        }
      }
      while (true)
      {
        this.u.setType(i5);
        break;
        if (this.w == null)
        {
          this.w = new avd(this.B, true, false, this);
          this.w.g();
          if (paramBoolean)
            this.w.d();
        }
        if (i2 == 0)
        {
          if (this.y == null)
          {
            this.y = new avd(this.B, true, true, 5, this);
            this.y.g();
            if (paramBoolean)
              this.y.d();
          }
        }
        else if (this.y != null)
        {
          this.y.h();
          this.y = null;
        }
      }
      label558: if ((i1 == 0) && (i2 == 0))
        break label133;
      if (i1 != 0)
      {
        this.w = new avd(this.B, true, false, this);
        this.w.g();
        if (paramBoolean)
          this.w.d();
        if (i2 == 0)
        {
          this.y = new avd(this.B, true, true, 5, this);
          this.y.g();
          if (paramBoolean)
            this.y.d();
        }
      }
      this.u = new avd(this.B, true, true, i5, this);
      this.u.g();
      if (!paramBoolean)
        break label133;
      this.u.d();
      break label133;
      label692: if (i3 == 0)
      {
        if (this.x != null)
        {
          this.x.h();
          this.x = null;
        }
        if (this.z != null)
        {
          this.z.h();
          this.z = null;
        }
      }
      while (true)
      {
        this.v.setType(paramInt);
        break;
        if (this.x == null)
        {
          this.x = new avd(this.B, false, false, this);
          this.x.g();
          if (paramBoolean)
            this.x.d();
        }
        if (i4 == 0)
        {
          if (this.z == null)
          {
            this.z = new avd(this.B, false, true, 5, this);
            this.z.g();
            if (paramBoolean)
              this.z.d();
          }
        }
        else if (this.z != null)
        {
          this.z.h();
          this.z = null;
        }
      }
      label863: if ((i3 != 0) || (i4 != 0))
      {
        if (i3 != 0)
        {
          this.x = new avd(this.B, false, false, this);
          this.x.g();
          if (paramBoolean)
            this.x.d();
          if (i4 == 0)
          {
            this.z = new avd(this.B, false, true, 5, this);
            this.z.g();
            if (paramBoolean)
              this.z.d();
          }
        }
        this.v = new avd(this.B, false, true, paramInt, this);
        this.v.g();
        if (paramBoolean)
          this.v.d();
      }
    }
  }

  public void a(Configuration paramConfiguration)
  {
    paramConfiguration = this.B.getResources().getDisplayMetrics();
    int i1 = paramConfiguration.widthPixels;
    if (i1 != this.m)
    {
      this.m = i1;
      this.n = paramConfiguration.heightPixels;
      if (this.D == 0)
      {
        if (this.u != null)
        {
          this.u.a();
          this.u.i();
          if (this.w != null)
          {
            this.w.a();
            this.w.i();
          }
          if (this.y != null)
          {
            this.y.a();
            this.y.i();
          }
        }
        if (this.v != null)
        {
          this.v.a();
          this.v.i();
          if (this.x != null)
          {
            this.x.a();
            this.x.i();
          }
          if (this.z != null)
          {
            this.z.a();
            this.z.i();
          }
        }
      }
    }
  }

  public void a(yc paramyc)
  {
    this.B.a(paramyc);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.u != null)
      {
        this.u.d();
        if (this.w != null)
          this.w.d();
        if (this.y != null)
          this.y.d();
      }
      if (this.v != null)
      {
        this.v.d();
        if (this.x != null)
          this.x.d();
        if (this.z != null)
          this.z.d();
      }
    }
    do
    {
      do
      {
        return;
        if (this.u != null)
        {
          this.u.e();
          if (this.w != null)
            this.w.e();
          if (this.y != null)
            this.y.e();
        }
      }
      while (this.v == null);
      this.v.e();
      if (this.x != null)
        this.x.e();
    }
    while (this.z == null);
    this.z.e();
  }

  public boolean a(avd paramavd)
  {
    try
    {
      this.C.removeView(paramavd);
      return true;
    }
    catch (Throwable paramavd)
    {
      asp.b("Swipe.ToucherManager", "Could not remove view from window", paramavd);
    }
    return false;
  }

  public boolean a(avd paramavd, LayoutParams paramLayoutParams)
  {
    try
    {
      this.C.addView(paramavd, paramLayoutParams);
      return true;
    }
    catch (Throwable paramavd)
    {
      asp.b("Swipe.ToucherManager", "Could not add view to window", paramavd);
    }
    return false;
  }

  public void b()
  {
    if ((vs.H(SwipeApplication.c())) || (asq.n()))
    {
      c();
      return;
    }
    this.B.b.post(new Runnable()
    {
      public void run()
      {
        vu.this.c();
      }
    });
  }

  public void b(avd paramavd)
  {
    a(paramavd);
    a(paramavd, (LayoutParams)paramavd.getLayoutParams());
  }

  public void b(avd paramavd, LayoutParams paramLayoutParams)
  {
    try
    {
      if (paramavd.f())
        this.C.updateViewLayout(paramavd, paramLayoutParams);
      return;
    }
    catch (Throwable paramavd)
    {
      asp.b("Swipe.ToucherManager", "Could not update view layout", paramavd);
    }
  }

  public void b(boolean paramBoolean)
  {
    if ((SwipeService.i() == null) || (SwipeService.a() == null));
    do
    {
      return;
      e();
    }
    while (!paramBoolean);
    SwipeService.a().removeCallbacks(this.G);
    SwipeService.a().postDelayed(this.G, 5000L);
  }

  public void c()
  {
    this.F = true;
    if (1 == this.D)
    {
      if (this.E == null)
        this.E = new avb(this.B, this);
      if (!anj.p())
        this.E.b();
    }
    while (true)
    {
      this.B.o();
      return;
      if ((this.u == null) && (this.v == null))
      {
        a(vs.A(this.B), false);
        ((SwipeApplication)this.B.getApplicationContext()).a().d();
      }
      if (this.u != null)
      {
        this.u.g();
        if (this.w != null)
          this.w.g();
        if (this.y != null)
          this.y.g();
      }
      if (this.v != null)
      {
        this.v.g();
        if (this.x != null)
          this.x.g();
        if (this.z != null)
          this.z.g();
      }
      acw.d(this.B);
    }
  }

  public void c(boolean paramBoolean)
  {
    if (this.E != null)
    {
      yb.a.a(this.E.u(), 100, 0, 0, asq.a(this.E.getPosYReversed()), 0, paramBoolean);
      yb.a.k = false;
      yb.a.m = true;
      a(yb.a);
      return;
    }
    h();
  }

  public void d()
  {
    this.F = false;
    if (1 == this.D)
      if (this.E != null)
        this.E.o();
    do
    {
      do
      {
        return;
        if (this.u != null)
        {
          this.u.h();
          if (this.w != null)
            this.w.h();
          if (this.y != null)
            this.y.h();
        }
      }
      while (this.v == null);
      this.v.h();
      if (this.x != null)
        this.x.h();
    }
    while (this.z == null);
    this.z.h();
  }

  public void e()
  {
    if (this.D == 0)
    {
      localavd = k();
      if (localavd != null)
        localavd.c();
    }
    while (this.E == null)
    {
      avd localavd;
      return;
    }
    this.E.c();
  }

  public void f()
  {
    if (this.D == 0)
    {
      localavd = k();
      if (localavd != null)
        localavd.b(true);
    }
    while (this.E == null)
    {
      avd localavd;
      return;
    }
    this.E.g(true);
  }

  public void g()
  {
    if (this.D == 0)
    {
      localavd = k();
      if (localavd != null)
      {
        if (!localavd.isShown())
          b();
        localavd.b();
      }
    }
    while (this.E == null)
    {
      avd localavd;
      return;
    }
    if (!this.E.isShown())
      this.E.b();
    this.E.g();
  }

  public void h()
  {
    yb.a.a(vs.B(this.B), false, true);
    yb.a.m = true;
    a(yb.a);
  }

  public boolean i()
  {
    return this.D == 1;
  }

  public boolean j()
  {
    if (this.D == 1)
      return (this.E == null) || (this.E.u());
    return vs.B(this.B);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ("key_toucher_type".equals(paramString))
    {
      if (!this.F)
        break label254;
      d();
    }
    label254: for (int i1 = 1; ; i1 = 0)
    {
      this.z = null;
      this.y = null;
      this.v = null;
      this.x = null;
      this.w = null;
      this.u = null;
      if (this.E != null)
        this.E = null;
      this.D = asi.a(paramSharedPreferences.getString(paramString, ""), 0);
      if (this.D == 1)
      {
        this.B.b.sendEmptyMessage(5);
        if (i1 != 0)
          b();
      }
      do
      {
        do
        {
          do
          {
            return;
            this.B.b.sendEmptyMessage(6);
            break;
          }
          while (!"key_show_over_lockscreen".equals(paramString));
          i1 = vs.b(this.B, true);
          if (this.E != null)
          {
            this.E.setWindowType(i1);
            return;
          }
          if (this.u != null)
          {
            this.u.setWindowType(i1);
            if (this.w != null)
              this.w.setWindowType(i1);
            if (this.y != null)
              this.y.setWindowType(i1);
          }
        }
        while (this.v == null);
        this.v.setWindowType(i1);
        if (this.x != null)
          this.x.setWindowType(i1);
      }
      while (this.z == null);
      this.z.setWindowType(i1);
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vu
 * JD-Core Version:    0.6.2
 */