package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.lazyswipe.SwipeService;
import com.lazyswipe.features.boostplus.BoostActivity;
import com.lazyswipe.features.cleaner.CleaningView;
import com.lazyswipe.features.cleaner.MemoryTipDragGuide;
import com.lazyswipe.features.guide.NewSwipeGuideView;
import com.lazyswipe.features.search.SearchWebActivity;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class acw extends aux
  implements vo
{
  private static acw B;
  private static int J;
  private static int K;
  protected static final String a = "Swipe." + acw.class.getSimpleName();
  protected static final int b = asq.a(23.0F);
  protected static final int c = asq.a(31.6F);
  protected static final int d = asq.a(9.0F);
  protected static final int e = asq.a(5.0F);
  protected static final int f = asq.a(4.3F);
  public static final int g = asq.a(70.0F);
  public static boolean h = false;
  public static boolean i = false;
  private acx C;
  private Rect D;
  private Rect E;
  private boolean F;
  private boolean G;
  private CleaningView H;
  private final Handler I = new Handler();
  private WeakReference<acy> L;
  private Runnable M = new Runnable()
  {
    public void run()
    {
      if (acw.c(acw.this))
        acw.d(acw.this);
    }
  };
  private MemoryTipDragGuide N;
  private final Runnable O = new Runnable()
  {
    public void run()
    {
      if ((acw.c(acw.this)) && (acw.j(acw.this) != null))
        acw.j(acw.this).d();
    }
  };
  private boolean P;
  private final BroadcastReceiver Q = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      int i = -1;
      switch (paramAnonymousContext.hashCode())
      {
      default:
      case -1454123155:
      case -2128145023:
      case -985897571:
      }
      while (true)
        switch (i)
        {
        default:
          return;
          if (paramAnonymousContext.equals("android.intent.action.SCREEN_ON"))
          {
            i = 0;
            continue;
            if (paramAnonymousContext.equals("android.intent.action.SCREEN_OFF"))
            {
              i = 1;
              continue;
              if (paramAnonymousContext.equals("memory_refresh"))
                i = 2;
            }
          }
          break;
        case 0:
        case 1:
        case 2:
        }
      acw.n(acw.this);
      acw.f(acw.this);
      acw.g(acw.this);
      return;
      acw.o(acw.this);
      return;
      acw.f(acw.this);
    }
  };
  private boolean R;
  private final BroadcastReceiver S = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      int i = -1;
      switch (paramAnonymousContext.hashCode())
      {
      default:
      case -1513032534:
      }
      while (true)
        switch (i)
        {
        default:
          return;
          if (paramAnonymousContext.equals("android.intent.action.TIME_TICK"))
            i = 0;
          break;
        case 0:
        }
      acw.p(acw.this);
    }
  };
  private long T;
  private Bitmap U;
  private boolean V;
  private Bitmap W;
  private boolean aa;
  private int ab;
  private final Runnable ac = new Runnable()
  {
    public void run()
    {
      if ((acw.c(acw.this)) && (acw.j(acw.this) != null))
        acw.q(acw.this);
    }
  };

  public acw(Context paramContext)
  {
    super(paramContext);
    w();
    this.F = false;
    adb.b(paramContext);
  }

  private void A()
  {
    if (!acz.a())
      return;
    new acz(getContext(), this).b();
    E();
    this.I.removeCallbacks(this.O);
    this.M = null;
  }

  private void B()
  {
    try
    {
      if ((this.L != null) && (this.L.get() != null))
      {
        ((acy)this.L.get()).a(true);
        this.L.clear();
      }
      this.L = null;
      return;
    }
    catch (Exception localException)
    {
      Log.w(a, "failed in hidePop", localException);
    }
  }

  private void C()
  {
    if ((this.G) && (this.C != null))
    {
      if (asq.n())
      {
        this.C.a();
        N();
      }
    }
    else
      return;
    post(new Runnable()
    {
      public void run()
      {
        acw.f(acw.this);
      }
    });
  }

  private void D()
  {
    if (!this.V)
    {
      this.I.removeCallbacks(this.O);
      this.I.postDelayed(this.O, 4000L);
    }
  }

  private void E()
  {
    this.I.removeCallbacks(this.O);
    this.C.e();
  }

  private void F()
  {
    if (this.P)
      return;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("memory_refresh");
      getContext().registerReceiver(this.Q, localIntentFilter);
      this.P = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void G()
  {
    if (!this.P)
      return;
    try
    {
      getContext().unregisterReceiver(this.Q);
      this.P = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void H()
  {
    if (this.R)
      return;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.TIME_TICK");
      getContext().registerReceiver(this.S, localIntentFilter);
      this.R = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void I()
  {
    if (!this.R)
      return;
    try
    {
      getContext().unregisterReceiver(this.S);
      this.R = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void J()
  {
    if (Math.abs(System.currentTimeMillis() - this.T) > 60000L)
    {
      C();
      this.T = System.currentTimeMillis();
    }
  }

  private void K()
  {
    f(getContext());
    vs.b(getContext(), "mem_tip_twinkle_time", System.currentTimeMillis());
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, (int)(this.C.c() / 100.0F * (b - f)) });
    localValueAnimator.setDuration(2200L);
    localValueAnimator.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.25F)
          return 4.0F * paramAnonymousFloat;
        return 1.33F - 1.33F * paramAnonymousFloat;
      }
    });
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        acw.j(acw.this).a(i);
      }
    });
    localValueAnimator.start();
  }

  private void L()
  {
    if (this.V)
      return;
    if (!atw.b(this.U))
      this.U = atw.a(getResources(), 2130837554);
    this.V = true;
    this.C.a(this.U);
    D();
  }

  private void M()
  {
    if (!this.V)
      return;
    this.V = false;
    this.C.a(null);
    E();
  }

  private void N()
  {
    int j = this.C.c();
    if (this.V)
    {
      this.ab = j;
      this.I.removeCallbacks(this.ac);
      return;
    }
    if (j < 82)
    {
      if (this.aa)
        P();
      this.ab = j;
      this.I.removeCallbacks(this.ac);
      return;
    }
    if (!BoostActivity.g())
    {
      this.ab = j;
      this.I.removeCallbacks(this.ac);
      return;
    }
    if (!amk.a(getContext()))
    {
      this.ab = j;
      this.I.removeCallbacks(this.ac);
      return;
    }
    if ((!this.aa) && (j >= 82) && (this.ab < 82))
      O();
    this.ab = j;
  }

  private void O()
  {
    vy.b(getContext(), "B28");
    if (!atw.b(this.W))
      this.W = atw.a(getResources(), 2130837724);
    this.aa = true;
    this.C.a(this.W);
    this.C.b(true);
    this.I.removeCallbacks(this.ac);
    this.I.postDelayed(this.ac, 7000L);
  }

  private void P()
  {
    this.aa = false;
    this.C.a(null);
    this.C.b(false);
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    vs.b(paramContext, "key_memory_tip_on_launcher_only", paramBoolean);
  }

  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!vg.j)
    {
      localIntent = new Intent(paramContext, SwipeService.class);
      localIntent.putExtra("operation", 14);
      localIntent.putExtra("param_1", paramBoolean1);
      localIntent.putExtra("param_2", paramBoolean2);
      paramContext.startService(localIntent);
    }
    while (!f(paramContext, paramBoolean2))
    {
      Intent localIntent;
      return;
    }
    if (yb.a.m)
      acz.a = true;
    g(paramContext, paramBoolean1);
  }

  public static boolean a(Context paramContext)
  {
    return vs.c(paramContext, "key_memory_tip_on_launcher_only", false);
  }

  public static void b(Context paramContext, boolean paramBoolean)
  {
    vs.b(paramContext, "key_memory_tip_enable", paramBoolean);
  }

  private void b(String paramString)
  {
    if (wj.a().d(paramString))
    {
      L();
      return;
    }
    M();
  }

  public static boolean b(Context paramContext)
  {
    return vs.c(paramContext, "key_memory_tip_enable", true);
  }

  private static boolean b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = vs.c(paramContext, "clean_res_ok", false);
    long l1 = System.currentTimeMillis();
    long l2 = vs.b();
    if (paramBoolean1);
    do
    {
      do
        return true;
      while (l1 - l2 > 300000L);
      if (!bool)
        return false;
    }
    while (paramBoolean2);
    return false;
  }

  public static void c(Context paramContext)
  {
    boolean bool = true;
    if (act.a != null);
    do
    {
      return;
      if (!f(paramContext, false))
        break;
      g(paramContext, true);
      if (B != null)
        B.m();
    }
    while (adb.b() != null);
    if (!b(paramContext));
    while (true)
    {
      adb.a(paramContext, bool);
      return;
      e(paramContext, true);
      break;
      bool = false;
    }
  }

  public static void c(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, paramBoolean, false);
  }

  public static void d(Context paramContext)
  {
    if ((b(paramContext)) && (B != null) && (B.c()))
    {
      Log.i(a, "reappearIfNecessary() go!!!");
      e(paramContext, false);
      c(paramContext, false);
    }
  }

  public static void d(Context paramContext, boolean paramBoolean)
  {
    if (!vg.j)
    {
      localIntent = new Intent(paramContext, SwipeService.class);
      localIntent.putExtra("operation", 16);
      localIntent.putExtra("param_1", paramBoolean);
      paramContext.startService(localIntent);
    }
    while (f(paramContext, paramBoolean))
    {
      Intent localIntent;
      return;
    }
    e(paramContext, false);
  }

  private static int e(Context paramContext)
  {
    return vs.a(paramContext, "mem_tip_twinkle_percent", 80);
  }

  public static void e(Context paramContext, boolean paramBoolean)
  {
    if (!vg.j)
    {
      localIntent = new Intent(paramContext, SwipeService.class);
      localIntent.putExtra("operation", 15);
      localIntent.putExtra("param_1", paramBoolean);
      paramContext.startService(localIntent);
    }
    while (B == null)
    {
      Intent localIntent;
      return;
    }
    h = false;
    B.f(paramBoolean);
    B = null;
  }

  private static void f(Context paramContext)
  {
    long l = vs.a(paramContext, "mem_tip_twinkle_time", -1L);
    if (l < 0L);
    int j;
    int k;
    do
    {
      return;
      Calendar localCalendar = Calendar.getInstance();
      j = localCalendar.get(6);
      localCalendar.setTimeInMillis(l);
      k = Calendar.getInstance().get(6);
    }
    while (j == k);
    if ((k - j == 1) || (j > k))
    {
      vs.b(paramContext, "mem_tip_twinkle_percent", 80);
      return;
    }
    vs.b(paramContext, "mem_tip_twinkle_percent", 70);
  }

  private static boolean f(Context paramContext, boolean paramBoolean)
  {
    if (!b(paramContext));
    boolean bool1;
    boolean bool2;
    do
    {
      String str;
      do
      {
        return false;
        str = wq.g();
        bool1 = asq.a(paramContext, str);
      }
      while (((a(paramContext)) && (!bool1)) || (aly.a("key_memory_tip_black_list").b(str)) || (i));
      bool2 = vs.c(paramContext, "float_window_enabled", false);
    }
    while (((!paramBoolean) && (!bool2)) || (!b(paramContext, paramBoolean, bool1)) || (vj.n) || (yb.o()));
    return true;
  }

  private static void g(Context paramContext, boolean paramBoolean)
  {
    if (B == null)
      B = new acw(paramContext);
    B.e(paramBoolean);
    h = true;
  }

  private void v()
  {
    super.b(false);
  }

  private void w()
  {
    int j = aqs.ac();
    int k = aqs.ad();
    int m = asq.a(50.0F);
    this.D = new Rect(m, 0, j - m, k);
    this.E = new Rect(g, 0, j - g, k);
  }

  private void x()
  {
    if (this.aa)
      P();
    while (!this.V)
      return;
    M();
  }

  private void y()
  {
    vy.a(getContext(), "CH");
    this.L = new WeakReference(acy.a(this));
  }

  private void z()
  {
    if (!acz.a)
      return;
    acz.a = false;
    this.I.postDelayed(this.M, 300L);
  }

  protected View a()
  {
    this.C = new acx(getContext());
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(this.C);
    return localImageView;
  }

  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if ((!this.F) && (this.H != null))
    {
      this.H.c();
      this.H = null;
    }
  }

  protected void a(boolean paramBoolean)
  {
    super.a(false);
    if (this.A);
    for (float f1 = -b; ; f1 = b)
    {
      setTranslationX(f1);
      animate().translationX(0.0F).setDuration(250L).setInterpolator(new AccelerateDecelerateInterpolator());
      z();
      return;
    }
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      K = this.k.y;
      j = this.k.height + asq.a(6.0F);
      if (this.o - this.k.y - this.k.height - j <= paramInt)
      {
        this.k.y = (this.o - paramInt - this.k.height - j);
        ast.b(getContext(), this, this.k);
      }
    }
    while (K == this.k.y)
    {
      int j;
      return;
    }
    this.k.y = K;
    ast.b(getContext(), this, this.k);
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    if (acz.getInstance() != null)
      return false;
    vs.b(getContext(), "last_memory_tip_op_time", System.currentTimeMillis());
    NewSwipeGuideView.a();
    if (this.V)
    {
      SearchWebActivity.a(getContext(), "", 5);
      return true;
    }
    if (this.aa)
    {
      vy.b(getContext(), "B21");
      paramMotionEvent = new Intent(getContext(), BoostActivity.class);
      paramMotionEvent.addFlags(67108864);
      asq.d(getContext(), paramMotionEvent);
      return true;
    }
    this.C.e();
    paramMotionEvent = getCenterPoint();
    J = this.k.y;
    int j;
    if (aqs.a())
    {
      j = this.o - asq.a(30.0F);
      if (paramMotionEvent.y - aco.a >= 0)
        break label180;
      a(this.k.x, aco.a, 70, new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          acw.b(acw.this);
        }
      });
    }
    while (true)
    {
      return true;
      j = this.o;
      break;
      label180: if (paramMotionEvent.y + aco.a > j)
        a(this.k.x, j - aco.a * 2, 70, new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            acw.b(acw.this);
          }
        });
      else
        y();
    }
  }

  protected boolean a(String paramString)
  {
    boolean bool2 = true;
    Context localContext = getContext();
    boolean bool1;
    if (!asq.a(localContext, paramString))
      bool1 = false;
    long l1;
    long l2;
    long l3;
    do
    {
      return bool1;
      if (this.C.c() < e(localContext))
        return false;
      l1 = vs.a(localContext, "mem_tip_twinkle_time", -1L);
      l2 = vs.a(localContext, "mem_tip_clean_time", -1L);
      l3 = System.currentTimeMillis();
      bool1 = bool2;
    }
    while (l1 < 0L);
    if ((l2 - l1 > 0L) && (l2 - l1 < 5000L));
    for (int j = 1; ; j = 0)
    {
      l1 = l3 - l1;
      if (j == 0)
        break label133;
      bool1 = bool2;
      if (l1 > 3600000L)
        break;
      return false;
    }
    label133: if (l1 > 10800000L);
    for (j = 1; ; j = 0)
    {
      int k = ari.a(10);
      if (j != 0)
      {
        bool1 = bool2;
        if (k == 1)
          break;
      }
      return false;
    }
  }

  protected void b(int paramInt1, int paramInt2)
  {
    if ((this.D.contains(paramInt1, paramInt2)) && (this.H == null));
    for (int j = 1; ; j = 0)
    {
      if (j != 0)
      {
        this.H = CleaningView.a(getContext());
        this.H.b();
        this.j.setAlpha(0.0F);
      }
      if (this.H != null)
        this.H.a(paramInt1, paramInt2);
      boolean bool1 = this.E.contains(paramInt1, paramInt2);
      boolean bool2 = this.F;
      if ((!this.F) && (bool1) && (asq.p(getContext())))
        asq.a(getContext(), 30L);
      this.F = bool1;
      if (((bool2 ^ bool1)) && (this.H != null))
        this.H.a(this.F, paramInt1, paramInt2);
      if (this.N != null)
        this.N.a(paramInt1, paramInt2, this.F);
      return;
    }
  }

  protected void b(MotionEvent paramMotionEvent)
  {
    super.b(paramMotionEvent);
    x();
  }

  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      v();
      return;
    }
    if (this.A);
    for (int j = -b; ; j = b)
    {
      final ViewPropertyAnimator localViewPropertyAnimator = animate().translationX(j).setDuration(250L);
      localViewPropertyAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      asv.b(localViewPropertyAnimator, new Runnable() {
        public void run() {
          acw.a(acw.this);
          asv.b(localViewPropertyAnimator, null);
        }
      });
      return;
    }
  }

  protected boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.A) && ((this.aa) || (this.V)))
      x();
    return false;
  }

  protected void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (this.C != null)
      this.C.a(paramBoolean);
  }

  public boolean c()
  {
    String str = getPositionKey() + "_" + this.w;
    return Math.abs(vs.a(getContext(), str, 60)) > 75;
  }

  protected boolean c(int paramInt1, int paramInt2)
  {
    if (this.N != null)
    {
      this.N.b();
      this.N = null;
    }
    if ((this.H != null) && (this.F))
    {
      d(true);
      g();
      return true;
    }
    D();
    K = this.k.y;
    J = this.k.y;
    return super.c(paramInt1, paramInt2);
  }

  protected boolean c(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.A) && ((this.aa) || (this.V)))
      x();
    return false;
  }

  protected void c_()
  {
    super.c_();
    w();
  }

  protected void d(int paramInt1, int paramInt2)
  {
    super.d(paramInt1, paramInt2);
    if (!this.F)
    {
      this.j.animate().alpha(1.0F).setDuration(400L);
      if (this.H != null)
        this.H.b(paramInt1, paramInt2);
    }
  }

  public boolean d(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!super.d(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))
      x();
    return false;
  }

  void d_()
  {
    setLayerType(1, null);
    this.C.a(null);
  }

  protected void e(int paramInt1, int paramInt2)
  {
    super.e(paramInt1, paramInt2);
    if ((!this.F) && (this.H != null))
      this.H.c(getMeasuredWidth() / 2 + paramInt1, getMeasuredHeight() / 2 + paramInt2);
  }

  void e_()
  {
    this.C.b(null);
  }

  protected void f()
  {
    super.f();
    this.C.e();
    vv.a().a("清理悬浮窗", "拖动", "");
    if (acz.getInstance() != null)
      acz.getInstance().c();
    if (vs.a(getContext(), "last_memory_tip_clean_time", -1L) != -1L);
    while (true)
    {
      vs.b(getContext(), "last_memory_tip_op_time", System.currentTimeMillis());
      NewSwipeGuideView.a();
      return;
      this.N = MemoryTipDragGuide.a(getContext());
    }
  }

  void f_()
  {
    this.H = CleaningView.a(getContext());
    this.H.b();
    this.j.setAlpha(0.0F);
    postDelayed(new Runnable()
    {
      public void run()
      {
        if (acw.e(acw.this) == null)
          return;
        int i = acw.k(acw.this) / 2;
        int j = acw.l(acw.this) / 2;
        acw.e(acw.this).a(i, j);
        acw.e(acw.this).a(acw.m(acw.this), i, j);
        acw.a(acw.this, true);
        acw.this.g();
      }
    }
    , 50L);
  }

  void g()
  {
    Context localContext = getContext();
    vs.b(localContext, "last_memory_tip_clean_time", System.currentTimeMillis());
    vs.b(localContext, "mem_tip_clean_time", System.currentTimeMillis());
    vy.a(localContext, "CF");
    if (vj.g)
      vy.b(localContext, "B23");
    vy.b(localContext, "B19", this.C.c());
    aoa.a(localContext, 1, new aob() {
      public void run() {
        acw.e(acw.this).a(acw.this, this.b);
      }
    });
  }

  Point getCenterPoint()
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    if (u());
    for (int j = f; ; j = this.n - f)
      return new Point(j, arrayOfInt[1] + this.l / 2);
  }

  protected int getDefaultPosition()
  {
    return -40;
  }

  protected int getPaddingX()
  {
    return 0;
  }

  protected String getPositionKey()
  {
    return "key_memory_tip_pos";
  }

  protected int getWindowHeight()
  {
    return c + e + e;
  }

  protected int getWindowWidth()
  {
    return b + d;
  }

  public void h()
  {
    vv.a().a("清理悬浮窗", "完成清理", "");
    this.H = null;
    this.j.animate().alpha(1.0F).setDuration(200L);
    postDelayed(new Runnable()
    {
      public void run()
      {
        acw.f(acw.this);
        acw.g(acw.this);
      }
    }
    , 250L);
  }

  void k()
  {
    D();
    e_();
    post(new Runnable()
    {
      public void run()
      {
        acw.this.setLayerType(0, null);
        if (acw.h(acw.this).y != acw.n())
          acw.a(acw.this, acw.i(acw.this).x, acw.n(), 70, null);
      }
    });
  }

  protected void m()
  {
    if (this.N != null)
    {
      this.N.b();
      this.N = null;
    }
    String str = wq.g();
    b(str);
    if (a(str))
      K();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    F();
    H();
    b(wq.g());
    D();
    this.G = true;
    vm localvm = SwipeService.e();
    if (localvm != null)
      localvm.b(this);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    G();
    I();
    this.G = false;
    if (this.H != null)
    {
      this.H.c();
      this.H = null;
    }
    if (this.N != null)
    {
      this.N.b();
      this.N = null;
    }
    this.I.removeCallbacksAndMessages(null);
    vm localvm = SwipeService.e();
    if (localvm != null)
      localvm.a(this);
    atw.a(this.U);
    B();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acw
 * JD-Core Version:    0.6.2
 */