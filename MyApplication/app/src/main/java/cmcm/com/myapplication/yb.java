package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.fan.FanImpl;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.ItemSectorBg;
import com.lazyswipe.fan.TutorialView;
import com.lazyswipe.fan.friend.FriendSector;
import com.lazyswipe.fan.notification.NotificationView;
import com.lazyswipe.features.guide.NewGuide;
import com.lazyswipe.features.theme.matched.LauncherThemeTip;
import com.lazyswipe.notification.SwipeAccessibilityService;
import com.lazyswipe.ui.RateView;
import com.lazyswipe.view.FloatTip;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONObject;

public class yb extends FrameLayout
  implements Callback, OnClickListener, OnDismissListener, avt
{
  public static final yc a = new yc();
  protected static yb q;
  private LauncherThemeTip A;
  private View B;
  private int C;
  private boolean D;
  private boolean E;
  private long F = -1L;
  private yi G;
  private float H = -1.0F;
  private Runnable I = new Runnable()
  {
    public void run()
    {
      if (amk.b(yb.this.getContext()))
      {
        yb.a(yb.this);
        yb.this.postDelayed(new Runnable()
        {
          public void run()
          {
            SwipeService.k();
          }
        }
        , 100L);
      }
    }
  };
  xv b;
  public aao[] c;
  boolean d;
  public int e;
  final yr f;
  protected avs g;
  public final Handler h;
  NotificationView i;
  xs j;
  boolean k;
  avf l;
  protected int m;
  protected int n;
  protected int o;
  protected int p = 0;
  public yj r;
  private final int s;
  private final int t;
  private final int u;
  private final int v;
  private int w;
  private boolean x;
  private yl y;
  private boolean z;

  public yb(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    q = this;
    paramAttributeSet = getResources();
    this.h = new Handler(this);
    this.f = new yr(paramContext, this.h);
    if (ahy.d(paramContext))
    {
      i1 = 0;
      this.w = i1;
      this.u = paramAttributeSet.getDimensionPixelSize(2131296281);
      this.v = paramAttributeSet.getDimensionPixelSize(2131296282);
      if (this.v + this.w > aqs.ac())
      {
        this.x = true;
        this.w = Math.max(0, aqs.ac() - this.v);
      }
      if (y())
        this.w = 0;
      this.s = (paramAttributeSet.getDimensionPixelSize(2131296284) + this.w);
      this.t = (paramAttributeSet.getDimensionPixelSize(2131296285) + this.w);
      setOnClickListener(this);
      if (!this.x)
        break label216;
    }
    label216: for (int i1 = i2; ; i1 = 5)
    {
      yk.a(i1);
      return;
      i1 = asq.a(15.3F);
      break;
    }
  }

  private static boolean A()
  {
    boolean bool = false;
    if (ajo.a)
    {
      Log.i("Swipe.Fan", "showNotificationIfNecessary(), sOpenDirectlyFromStatusBar");
      a(null, new ajo());
      ajo.a = false;
      bool = true;
    }
    return bool;
  }

  private String B()
  {
    return b(vs.L(getContext()));
  }

  private void C()
  {
    this.g.a(true);
    onDismiss();
  }

  private void D()
  {
    if (this.d)
      return;
    this.d = true;
    if (this.j != null)
    {
      xs.b(this.j);
      this.B.animate().alpha(0.0F).setDuration(yd.a() / 2).setStartDelay(yd.a() / 2);
    }
    while (true)
    {
      this.b.a();
      return;
      this.B.animate().alpha(0.0F).setDuration((int)(yd.a() * 2.7D)).setStartDelay((int)(yd.a() * 1.3D)).setInterpolator(new AccelerateInterpolator(2.0F));
    }
  }

  private boolean E()
  {
    int i1;
    int i3;
    int i4;
    if (ItemSectorBg.a)
    {
      i1 = this.v;
      i3 = getMeasuredHeight();
      i4 = this.n;
      if (!this.z)
        break label88;
    }
    label88: for (int i2 = this.m; ; i2 = getMeasuredWidth() - this.m)
    {
      double d1 = Math.pow(i2 - this.w, 2.0D);
      if ((int)Math.sqrt(Math.pow(i3 - i4 - this.w, 2.0D) + d1) >= i1)
        break label102;
      return true;
      i1 = this.u;
      break;
    }
    label102: return false;
  }

  private void F()
  {
    aao[] arrayOfaao = this.c;
    int i2 = arrayOfaao.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfaao[i1].g();
      i1 += 1;
    }
    this.b.b();
  }

  private void G()
  {
    this.h.removeCallbacks(this.I);
    if (!amk.b(getContext()))
      this.h.postDelayed(this.I, 450L);
  }

  public static yb a(Context paramContext, OnDismissListener paramOnDismissListener)
  {
    Object localObject;
    if (SwipeService.f > 0L)
    {
      localObject = vv.a();
      if (System.currentTimeMillis() - SwipeService.f < 4000L)
        break label53;
    }
    label53: for (int i1 = 2; ; i1 = 1)
    {
      ((vv)localObject).a("红点统计", "t", i1);
      SwipeService.f = 0L;
      if (!o())
        break;
      return null;
    }
    if (A())
      return null;
    afv.a();
    vj.l = false;
    aoe.c();
    asj.a();
    boolean bool2 = a.b;
    ajo.a = false;
    vs.h(paramContext, bool2);
    abe.b();
    acw.e(paramContext, true);
    if (ahy.d(paramContext))
      i1 = 2130968631;
    while (true)
    {
      localObject = (FanImpl)LayoutInflater.from(paramContext).inflate(i1, null);
      auu.a(System.currentTimeMillis() + ": Fan.open; view inflated");
      boolean bool1;
      avs localavs;
      Field localField;
      if (a.g != null)
      {
        bool1 = true;
        ((FanImpl)localObject).k = bool1;
        ((FanImpl)localObject).setDirection(bool2);
        localavs = new avs((View)localObject, -1, -1);
        localField = arp.c(PopupWindow.class, "mWindowLayoutType");
      }
      try
      {
        localField.setAccessible(true);
        localField.set(localavs, Integer.valueOf(vs.n(paramContext)));
        label222: localavs.setFocusable(true);
        localavs.setContentView((View)localObject);
        localavs.setOnDismissListener(paramOnDismissListener);
        ((FanImpl)localObject).g = localavs;
        localavs.showAtLocation((View)localObject, 112, 0, 0);
        if (!((FanImpl)localObject).isHardwareAccelerated());
        try
        {
          ara.a(localavs);
          ((FanImpl)localObject).a(a.g, true);
          auu.a(System.currentTimeMillis() + ": Fan.open; view pop up");
          vy.b(bool2);
          return localObject;
          i1 = 2130968628;
          continue;
          bool1 = false;
        }
        catch (Throwable paramContext)
        {
          while (true)
            asp.a("Swipe.Fan", "Failed to enable hardware acceleration", paramContext);
        }
      }
      catch (Throwable paramContext)
      {
        break label222;
      }
    }
  }

  public static void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.getLayoutParams();
    int i1;
    if (paramView != null)
    {
      if (!paramBoolean)
        break label38;
      i1 = vj.a;
      i1 |= 80;
      if (!(paramView instanceof LinearLayout.LayoutParams))
        break label45;
      ((LinearLayout.LayoutParams)paramView).gravity = i1;
    }
    label38: label45: 
    while (!(paramView instanceof LayoutParams))
    {
      return;
      i1 = vj.b;
      break;
    }
    ((LayoutParams)paramView).gravity = i1;
  }

  public static void a(FanItem paramFanItem, yw paramyw)
  {
    NotificationView localNotificationView;
    avs localavs;
    Field localField;
    if (paramFanItem == null)
    {
      paramFanItem = SwipeApplication.c();
      localNotificationView = (NotificationView)LayoutInflater.from(paramFanItem).inflate(2130968717, null, false);
      localavs = new avs(localNotificationView, -1, -1);
      localField = arp.c(PopupWindow.class, "mWindowLayoutType");
    }
    try
    {
      localField.setAccessible(true);
      localField.set(localavs, Integer.valueOf(vs.n(SwipeApplication.c())));
      label67: localavs.setFocusable(true);
      localavs.setContentView(localNotificationView);
      localavs.showAtLocation(localNotificationView, 112, 0, 0);
      localavs.setOnDismissListener(new OnDismissListener()
      {
        public void onDismiss()
        {
          try
          {
            SwipeService.i().e.b();
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
      });
      localNotificationView.setBackgroundColor(ahx.b(paramFanItem).s());
      localNotificationView.a(null, paramyw, localavs);
      do
        return;
      while (q == null);
      if (q.i == null)
      {
        q.i = ((NotificationView)LayoutInflater.from(q.getContext()).inflate(2130968717, null, false));
        q.addView(q.i);
      }
      q.i.a(paramFanItem, paramyw);
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }

  public static void a(boolean paramBoolean, avg paramavg, int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (q == null);
    do
    {
      return;
      if (paramBoolean)
      {
        if ((q.l == null) || (!q.l.isShown()))
          q.a(paramavg, paramInt);
        while (true)
        {
          q.l.a(paramBitmap1, paramBitmap2);
          q.l.setAutoDismiss(3000L);
          return;
          q.l.setOnSeekBarChangeListener(paramavg);
          q.l.setProgress(paramInt);
        }
      }
    }
    while ((q.l == null) || (!q.l.isShown()));
    q.l.a(null, null);
    q.r();
  }

  private boolean a(int paramInt, boolean paramBoolean)
  {
    return a(paramInt, paramBoolean, false);
  }

  private boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = a(this.c[paramInt]);
    if ((paramBoolean1) && (localList.size() == 1) && (((yw)localList.get(0)).b()))
    {
      localList.clear();
      return false;
    }
    if (paramBoolean2)
      return true;
    if (!NewGuide.j())
    {
      this.b.setTab(paramInt);
      this.b.a(paramInt, true);
      this.c[paramInt].a(getContext(), this);
    }
    return true;
  }

  private String b(String paramString)
  {
    return b(paramString, false);
  }

  public static void b(Context paramContext)
  {
    aty.a();
    ahx.b(paramContext).a(false);
    asq.b();
  }

  public static void e(boolean paramBoolean)
  {
    Handler localHandler;
    if ((o()) && (q != null))
    {
      localHandler = q.h;
      if (!paramBoolean)
        break label39;
    }
    label39: for (int i1 = 1; ; i1 = 0)
    {
      localHandler.obtainMessage(1, i1, 0).sendToTarget();
      abd.c();
      return;
    }
  }

  public static yb getInstance()
  {
    return q;
  }

  public static Point getLastDownAt()
  {
    if (q != null)
      return new Point(q.m, q.n);
    return null;
  }

  public static View getTopChild()
  {
    if (q == null)
      return null;
    return q.getChildAt(q.getChildCount() - 1);
  }

  public static void l()
  {
    if (q != null)
      q.o = 0;
  }

  public static boolean o()
  {
    return (q != null) && (q.isShown());
  }

  public static void p()
  {
    e(false);
  }

  public static void q()
  {
    if ((q != null) && (q.l != null))
    {
      q.getItemSector().removeView(q.l);
      q.l = null;
    }
  }

  public static boolean v()
  {
    return a.k;
  }

  public static boolean y()
  {
    return vj.d < 320;
  }

  private void z()
  {
    if (!yj.e())
    {
      this.B.setAlpha(1.0F);
      if (getLeapView() != null)
        getLeapView().setAlpha(1.0F);
    }
    while (true)
    {
      return;
      try
      {
        float f1 = Color.alpha(((ColorDrawable)this.B.getBackground()).getColor()) * 1.0F / Color.alpha(this.p);
        this.B.setBackgroundColor(this.p);
        this.B.setAlpha(f1);
        this.B.animate().alpha(1.0F).setDuration(()((1.0F - f1) * 240.0F));
        if (getLeapView() == null)
          continue;
        try
        {
          getLeapView().animate().alpha(1.0F).setDuration(()((1.0F - getLeapView().getAlpha()) * 240.0F));
          return;
        }
        catch (Throwable localThrowable1)
        {
          getLeapView().setAlpha(1.0F);
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          this.B.setAlpha(1.0F);
      }
    }
  }

  String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (b(paramString) != null));
    String str;
    do
    {
      return paramString;
      str = B();
      paramString = str;
    }
    while (str != null);
    if (a(0, true))
      return this.c[0].b();
    return null;
  }

  public List<yw> a(aao paramaao)
  {
    return this.f.a(paramaao);
  }

  public void a()
  {
    this.C |= 1;
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    getHandTracker().a(paramFloat1, paramFloat2);
  }

  public void a(int paramInt)
  {
    getHandTracker().a(paramInt);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    this.G = yi.a(this, paramInt1, paramInt2, paramInt3, paramRunnable);
  }

  public void a(Context paramContext, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
  }

  protected void a(avg paramavg, int paramInt)
  {
    ViewGroup localViewGroup;
    avf localavf;
    if (this.l == null)
    {
      this.l = new avf(getContext());
      localViewGroup = getItemSector();
      localavf = this.l;
      if (!this.z)
        break label136;
    }
    label136: for (int i1 = vj.a; ; i1 = vj.b)
    {
      localViewGroup.addView(localavf, 0, new LayoutParams(-2, -2, i1 | 0x50));
      this.l.setAlpha(0.0F);
      this.l.setOnSeekBarChangeListener(paramavg);
      i1 = getRealRadius();
      int i2 = getCenterOffset();
      int i3 = asq.a(14.0F);
      this.l.setRadius(i1 + i2 + i3);
      this.l.a();
      this.l.setProgress(paramInt);
      return;
    }
  }

  public void a(final boolean paramBoolean)
  {
    if (!this.D)
      return;
    this.D = false;
    postDelayed(new Runnable()
    {
      public void run()
      {
        if (yb.getInstance() != null)
          yb.this.b(paramBoolean);
      }
    }
    , 20L);
  }

  public boolean a(Context paramContext)
  {
    boolean bool = true;
    if (ajk.b)
      ajk.b = false;
    do
    {
      return false;
      if ((!amk.b(paramContext)) && (!amk.c(paramContext)))
        break;
      int i1 = vs.F(paramContext);
      if ((amk.c(paramContext)) && (200 == i1))
      {
        amk.c(paramContext, false);
        this.h.sendEmptyMessageDelayed(4, 1250L);
        return false;
      }
      if (((amk.c(paramContext)) && (i1 >= 100)) || ((amk.b(paramContext)) && (i1 < 100) && (i1 >= 4)))
      {
        c();
        return true;
      }
    }
    while (NewGuide.i());
    amk.c(paramContext, false);
    amk.b(paramContext, false);
    NewGuide.g();
    return false;
    JSONObject localJSONObject;
    if (SwipeApplication.a != null)
    {
      localJSONObject = SwipeApplication.a;
      if ((this.k) || (getResources().getConfiguration().orientation != 1))
      {
        auu.a("Banner exists, but we may have new messages or we are in landscape mode...");
        return false;
      }
      try
      {
        if (System.currentTimeMillis() - localJSONObject.getLong("endTime") > 0L)
        {
          SwipeApplication.a = wd.g(getContext().getApplicationContext());
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          String str = localJSONObject.getString("pkg");
          if ((!TextUtils.isEmpty(str)) && (!wc.a(paramContext, str, asi.a(localJSONObject.optString("appVer", ""), 0))))
          {
            wd.a(paramContext, localJSONObject.getString("code"));
            SwipeApplication.a = wd.g(getContext().getApplicationContext());
            return false;
          }
        }
        catch (Throwable paramContext)
        {
        }
      }
    }
    try
    {
      auu.a(System.currentTimeMillis() + ": Banner exists, showing banner " + localJSONObject.getString("code") + "; " + localJSONObject.getString("pkg"));
      this.j = xs.a(getContext(), this, localJSONObject);
      if (this.j != null)
      {
        addView(this.j, 0, new LayoutParams(-1, -1));
        d();
        return bool;
        SwipeApplication.a = wd.g(getContext().getApplicationContext());
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      while (true)
      {
        continue;
        bool = false;
      }
    }
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    G();
    Context localContext = getContext();
    if ((amk.c(localContext)) || (amk.b(localContext)));
    int i1;
    for (boolean bool = true; ; bool = false)
    {
      this.E = bool;
      auu.a(": Fan.popup");
      paramString = a(paramString);
      i1 = asq.a(this.c, paramString);
      auu.a("Current index: " + i1);
      if (!NewGuide.j())
        break;
      NewGuide.a(this);
      return false;
    }
    if (paramBoolean)
      this.D = true;
    this.b.a(i1);
    if (a.l)
    {
      Log.i("Swipe.Fan", "Notifications suppressed");
      return false;
    }
    return true;
  }

  String b(String paramString, boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.c.length)
    {
      if (paramString.equals(this.c[i1].b()))
      {
        if (!a(i1, false, paramBoolean))
          break;
        return paramString;
      }
      i1 += 1;
    }
    return null;
  }

  public void b()
  {
    this.C |= 2;
  }

  public void b(boolean paramBoolean)
  {
    this.b.i();
    ajb.a(getContext(), this);
    if (aie.b)
    {
      aie.b = false;
      this.A = aie.a(getContext()).b();
    }
    postDelayed(new Runnable()
    {
      public void run()
      {
        aib.a(yb.this.getContext());
      }
    }
    , 1000L);
  }

  public void c()
  {
    addView((TutorialView)LayoutInflater.from(getContext()).inflate(2130968758, this, false), new LayoutParams(-1, -1));
  }

  public void c(boolean paramBoolean)
  {
    this.h.removeCallbacksAndMessages(null);
    if (paramBoolean)
    {
      if ((this.l != null) && (this.l.isShown()))
        r();
      k();
      D();
      return;
    }
    C();
  }

  public void d()
  {
    LayoutParams localLayoutParams = (LayoutParams)this.b.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = (getResources().getDimensionPixelSize(2131296282) + this.w);
      if (ahx.b(getContext()).t() == 0)
        break label80;
    }
    label80: for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
        localLayoutParams.height += getResources().getDimensionPixelSize(2131296340);
      this.b.setLayoutParams(localLayoutParams);
      return;
    }
  }

  public void d(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.d)
      return;
    try
    {
      aao localaao = getCurrentTab();
      localaao.g();
      xv localxv = this.b;
      int i1 = this.b.a;
      if (!paramBoolean)
        bool = true;
      localxv.a(i1, bool, false);
      localaao.a(getContext(), this);
      return;
    }
    catch (Exception localException)
    {
      C();
    }
  }

  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    try
    {
      super.dispatchConfigurationChanged(paramConfiguration);
      if ((this.i != null) && (this.i.isShown()))
        this.i.a();
      this.i = null;
      return;
    }
    catch (Throwable paramConfiguration)
    {
    }
  }

  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    try
    {
      boolean bool = super.dispatchDragEvent(paramDragEvent);
      return bool;
    }
    catch (Throwable paramDragEvent)
    {
    }
    return false;
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      j();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
    }
    return false;
  }

  public boolean e()
  {
    return getHeight() == this.b.getHeight();
  }

  public boolean f()
  {
    return this.d;
  }

  public boolean g()
  {
    return amk.b(getContext());
  }

  public xv getBaseSectorArea()
  {
    return this.b;
  }

  public int getCenterOffset()
  {
    return this.w;
  }

  public aao getCurrentTab()
  {
    return this.c[this.b.a];
  }

  public float getHandTrackRatio()
  {
    return getHandTracker().b();
  }

  public yj getHandTracker()
  {
    if (this.r == null)
      this.r = new yj(this);
    return this.r;
  }

  public xu getItemLayer()
  {
    return this.b.getItemLayer();
  }

  public ViewGroup getItemSector()
  {
    return this.b.getItemSector();
  }

  public View getItemSectorBg()
  {
    return this.b.getItemSectorBg();
  }

  public int getItemSectorInnerSize()
  {
    return this.u;
  }

  public int getItemSectorOuterSize()
  {
    return this.v;
  }

  public View getLeapView()
  {
    return null;
  }

  public int getRealRadius()
  {
    if ((ItemSectorBg.a) || (ahy.d(getContext())))
      return this.v;
    return this.u;
  }

  public yl getStartPosition()
  {
    if (this.y == null)
      return yk.a(this.s, false);
    return this.y;
  }

  public int getTabCount()
  {
    return this.e;
  }

  public ViewGroup getTabSector()
  {
    return this.b.getTabSector();
  }

  public View getTabSectorBg()
  {
    return this.b.getTabSectorBg();
  }

  public int getTabSectorInnerSize()
  {
    return this.s;
  }

  public int getTabSectorOuterSize()
  {
    return this.t;
  }

  public aao[] getTabs()
  {
    return this.c;
  }

  public int getTextOffset()
  {
    return 0;
  }

  public boolean h()
  {
    return (this.i != null) && (this.i.isShown());
  }

  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    case 3:
    default:
    case 0:
      do
        return true;
      while ((this.d) || (NewGuide.j()));
      this.b.a(this.b.a, false);
      return true;
    case 1:
      if (paramMessage.arg1 != 0)
        bool = true;
      c(bool);
      return true;
    case 2:
      try
      {
        removeView(this.B);
        return true;
      }
      catch (Throwable paramMessage)
      {
        return true;
      }
    case 4:
    }
    vs.f(getContext(), true);
    RateView.a(this);
    return true;
  }

  public boolean i()
  {
    return this.x;
  }

  public boolean j()
  {
    if (FloatTip.d());
    do
    {
      View localView;
      do
      {
        return true;
        if (!NewGuide.i())
          break;
        localView = getChildAt(getChildCount() - 1);
      }
      while (!(localView instanceof NewGuide));
      ((NewGuide)localView).a(true);
      return true;
      if (this.A != null)
      {
        this.A.a();
        this.A = null;
        return true;
      }
      if (g())
      {
        if (System.currentTimeMillis() - this.F < 1000L)
        {
          amk.b(getContext(), false);
          if (vs.F(getContext()) < 4)
            vs.e(getContext(), 4);
          c(true);
        }
        this.F = System.currentTimeMillis();
        return true;
      }
    }
    while ((RateView.b()) || (this.b.c()) || (FriendSector.b()));
    if (h())
    {
      k();
      return true;
    }
    c(true);
    return true;
  }

  public void k()
  {
    if ((this.i != null) && (this.i.isShown()))
      this.i.a();
  }

  public void m()
  {
    if (this.G != null)
    {
      this.G.b();
      removeView(this.G);
      this.G = null;
    }
  }

  public boolean n()
  {
    return this.z;
  }

  public void onClick(View paramView)
  {
    if (g());
    int i1;
    do
    {
      do
      {
        return;
        paramView.getId();
      }
      while ((aoe.b()) || (this.b.c()));
      if (h())
      {
        k();
        return;
      }
      if (this.A != null)
      {
        this.A.a();
        this.A = null;
        return;
      }
      if (!E())
        break;
      i1 = this.o;
      this.o = (i1 + 1);
    }
    while (i1 < 1);
    D();
  }

  public void onDismiss()
  {
    this.E = false;
    this.h.removeCallbacks(this.I);
    if (amk.c(getContext()))
    {
      RateView.e();
      amk.c(getContext(), false);
      this.h.removeMessages(4);
    }
    F();
    if (this.j != null)
    {
      this.j.destroy();
      long l1 = this.j.getBannerShowedTime();
      if (l1 > 0L)
        wd.a(getContext().getApplicationContext(), l1);
      this.j = null;
    }
    afv.a(a);
    aoe.c();
    asj.a();
    aqe.a();
    aqe.b(getContext());
    a.k = false;
    vj.l = false;
    auu.a(getContext());
    acw.c(getContext(), true);
    q = null;
    if ((this.C & 0x1) != 0)
      amp.a(SwipeAccessibilityService.a(), getContext(), SwipeService.a());
    while ((this.C & 0x2) == 0)
      return;
    anj.g(SwipeApplication.c());
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((xv)findViewById(2131755220));
    this.b.setFan(this);
    List localList = aap.c(getContext());
    this.c = ((aao[])localList.toArray(new aao[localList.size()]));
    this.e = this.c.length;
    yd.a(this.e);
    this.B = findViewById(2131755219);
    this.p = ahx.b(getContext()).s();
    this.B.setBackgroundColor(this.p);
    if (!v())
      z();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0))
    {
      this.m = ((int)paramMotionEvent.getX());
      this.n = ((int)paramMotionEvent.getY());
    }
    return (aoe.b()) || (super.onInterceptTouchEvent(paramMotionEvent));
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) || (NewGuide.i()) || (avw.d()) || (avy.d()) || (FloatTip.b()))
      return;
    C();
  }

  protected void r()
  {
    this.l.b();
  }

  public View s()
  {
    return null;
  }

  void setDirection(boolean paramBoolean)
  {
    this.z = paramBoolean;
    this.y = yk.a(this.s, paramBoolean);
    a(this, paramBoolean);
    a(this.b, paramBoolean);
    this.b.setDirection(paramBoolean);
    Resources localResources = getContext().getResources();
    int i1 = localResources.getDimensionPixelSize(2131296342);
    int i2 = localResources.getDimensionPixelSize(2131296343);
    if (this.z)
    {
      this.b.setPadding(i2, 0, 0, i1);
      return;
    }
    this.b.setPadding(0, 0, i2, i1);
  }

  public View t()
  {
    return null;
  }

  public void u()
  {
    getHandTracker().a();
  }

  public void w()
  {
    try
    {
      if (!yj.e())
      {
        this.b.f();
        return;
      }
      float f1 = getHandTrackRatio();
      if (this.H < 0.0F)
      {
        this.H = f1;
        this.B.setAlpha(1.0F);
        if (getLeapView() != null)
          getLeapView().setLayerType(2, null);
      }
      this.b.f();
      f1 = atw.a((f1 - this.H) / (1.0F - this.H));
      int i1 = (int)((1.0F - (1.0F - f1) * (1.0F - f1)) * ((this.p & 0xFF000000) >>> 24));
      this.B.setBackgroundColor(i1 << 24 | this.p & 0xFFFFFF);
      if ((!this.r.c()) && (getLeapView() != null))
      {
        getLeapView().setAlpha(f1 * f1);
        return;
      }
    }
    catch (Exception localException)
    {
    }
  }

  public void x()
  {
    if (!v());
    do
    {
      return;
      this.b.g();
      z();
      a.k = false;
    }
    while (!o());
    SwipeService.m();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yb
 * JD-Core Version:    0.6.2
 */