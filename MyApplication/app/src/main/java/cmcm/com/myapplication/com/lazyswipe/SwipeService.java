package cmcm.com.myapplication.com.lazyswipe;

import aao;
import aap;
import abe;
import act;
import acw;
import afs;
import aft;
import afu;
import ahw;
import ahx;
import aiw;
import alk;
import alo;
import alq;
import alw;
import alx;
import amk;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.PopupWindow.OnDismissListener;
import anj;
import aoc;
import aqr;
import asp;
import asq;
import auu;
import com.lazyswipe.features.guide.NewSwipeGuideView;
import com.lazyswipe.ui.EmptyActivity;
import com.lazyswipe.ui.MainActivity;
import com.lazyswipe.view.FixedTip;
import com.lazyswipe.view.FloatTip;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import vg;
import vh;
import vm;
import vn;
import vo;
import vp;
import vs;
import vt;
import vu;
import vv;
import vx;
import vy;
import vz;
import wj;
import wm;
import wq;
import wr;
import yb;
import yc;

public class SwipeService extends Service
  implements alq, OnPrimaryClipChangedListener, Callback, PopupWindow.OnDismissListener, vn, vo, wr
{
  public static long a;
  public static long f;
  private static final HashMap<String, HashSet<ComponentName>> g = new HashMap();
  private static Notification h;
  private static SwipeService i;
  public Handler b;
  boolean c = true;
  boolean d;
  public vu e;
  private vm j;
  private long k;
  private boolean l;
  private boolean m;
  private vt n;
  private aoc o;
  private boolean p;
  private boolean q;
  private boolean r = false;
  private ComponentName s;
  private vh t;
  private ClipboardManager u;
  private PopupWindow.OnDismissListener v;
  private final Runnable w = new Runnable()
  {
    public void run()
    {
      if (SwipeService.a(SwipeService.this))
      {
        acw.e(SwipeService.this, true);
        return;
      }
      acw.c(SwipeService.this, true);
    }
  };

  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(new ComponentName("com.textra", "com.mplus.lib.ui.convo.ConvoActivity"));
    localHashSet.add(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
    localHashSet.add(new ComponentName("com.vkontakte.android", "com.vkontakte.android.FragmentWrapperActivity"));
    localHashSet.add(new ComponentName("ch.threema.app", "ch.threema.app.activities.ComposeMessageActivity"));
    localHashSet.add(new ComponentName("org.telegram.messenger", "org.telegram.ui.LaunchActivity"));
    localHashSet.add(new ComponentName("com.bsb.hike", "com.bsb.hike.ui.ChatThread"));
    localHashSet.add(new ComponentName("com.minus.android", "com.minus.android.SubActivity"));
    g.put("com.lazyswipe", localHashSet);
    localHashSet = new HashSet();
    localHashSet.add(new ComponentName("com.android.mms", "com.android.mms.ui.ConversationComposer"));
    g.put("samsung", localHashSet);
  }

  public static Intent a(Context paramContext, boolean paramBoolean)
  {
    return d(paramContext).putExtra("param_2", paramBoolean);
  }

  public static Intent a(Context paramContext, boolean paramBoolean, String paramString)
  {
    return d(paramContext).putExtra("param_2", paramBoolean).putExtra("tab_id", paramString);
  }

  public static Handler a()
  {
    if (i != null)
      return i.b;
    return null;
  }

  public static void a(alw paramalw)
  {
    alw.a(paramalw);
  }

  public static void a(Context paramContext)
  {
    if ((vs.H(paramContext)) && (!b()))
    {
      Bundle localBundle = new Bundle(1);
      localBundle.putInt("operation", 1);
      a(paramContext, localBundle);
    }
  }

  public static void a(Context paramContext, Bundle paramBundle)
  {
    paramContext.startService(new Intent(paramContext, SwipeService.class).replaceExtras(paramBundle));
  }

  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext.startService(new Intent(paramContext, SwipeService.class).putExtra("param_1", paramString).putExtra("param_2", paramBoolean).putExtra("operation", 10));
  }

  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    paramContext.startService(new Intent(paramContext, SwipeService.class).putExtra("param_1", paramString1).putExtra("param_2", paramBoolean1).putExtra("param_3", paramString2).putExtra("param_4", paramString3).putExtra("param_5", paramBoolean2).putExtra("operation", 10));
  }

  public static void a(String paramString)
  {
    a(paramString, false);
  }

  public static void a(String paramString, boolean paramBoolean)
  {
    if ((i == null) || (amk.b(i)) || (yb.o()) || (asq.a(asq.a(i), paramString)));
    while ((!paramBoolean) && (alx.getInstance() != null))
      return;
    i.c = false;
    if (f <= 0L)
      f = System.currentTimeMillis();
    i.e(true);
  }

  private void a(wm paramwm, ComponentName paramComponentName)
  {
    if ((paramwm == null) || (paramComponentName == null));
    do
    {
      return;
      if (this.m)
      {
        this.p = paramwm.a.a(paramComponentName);
        if (!this.p)
        {
          this.e.d();
          return;
        }
      }
      if (!this.e.i())
      {
        if (aft.e(paramComponentName.getPackageName()))
        {
          this.e.d();
          return;
        }
        if (this.r)
        {
          this.e.d();
          return;
        }
      }
      if ((this.q) && ("2".equals(vs.I(this))))
      {
        this.e.d();
        return;
      }
    }
    while ((yb.o()) || (!vs.H(this)));
    this.e.b();
  }

  public static void b(Context paramContext)
  {
    paramContext.startService(new Intent(paramContext, SwipeService.class).putExtra("param_1", true).putExtra("operation", 17));
  }

  public static void b(String paramString)
  {
    b(paramString, vs.B(SwipeApplication.c()));
  }

  public static void b(String paramString, boolean paramBoolean)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (!vg.j)
      localSwipeApplication.startService(a(localSwipeApplication, paramBoolean, paramString));
    while (i == null)
      return;
    i.c(paramString, paramBoolean);
  }

  public static boolean b()
  {
    return i != null;
  }

  public static void c()
  {
    f = 0L;
    if (i == null);
    do
    {
      return;
      i.c = true;
    }
    while (yb.o());
    i.e.f();
  }

  public static void c(Context paramContext)
  {
    a(paramContext, null);
  }

  private boolean c(ComponentName paramComponentName)
  {
    if (((HashSet)g.get("com.lazyswipe")).contains(paramComponentName))
      return true;
    HashSet localHashSet = (HashSet)g.get(Build.MANUFACTURER);
    return (localHashSet != null) && (localHashSet.contains(paramComponentName));
  }

  private boolean c(String paramString)
  {
    Object localObject = ((HashSet)g.get("com.lazyswipe")).iterator();
    while (((Iterator)localObject).hasNext())
      if (((ComponentName)((Iterator)localObject).next()).getPackageName().equals(paramString))
        return true;
    localObject = (HashSet)g.get(Build.MANUFACTURER);
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
        if (((ComponentName)((Iterator)localObject).next()).getPackageName().equals(paramString))
          return true;
    }
    return false;
  }

  public static Intent d(Context paramContext)
  {
    return new Intent(paramContext, SwipeService.class).putExtra("param_1", true).putExtra("operation", 1);
  }

  public static void d()
  {
    if ((i == null) || (yb.o()))
      return;
    if (i.e != null)
      i.e.g();
    alx.g();
  }

  public static PendingIntent e(Context paramContext)
  {
    return PendingIntent.getService(paramContext, 1, d(paramContext), 0);
  }

  public static vm e()
  {
    if ((i != null) && (i.j != null))
      return i.j;
    return null;
  }

  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.j == null)
      {
        this.j = new vm(this);
        this.j.d();
      }
      this.j.setOnFullScreenChangedListener(this);
    }
    do
    {
      do
        return;
      while (this.j == null);
      this.j.setOnFullScreenChangedListener(null);
    }
    while (this.j.g());
    this.b.removeMessages(6);
    this.b.removeMessages(5);
    this.j.e();
    this.j = null;
  }

  public static boolean f()
  {
    return (i != null) && (i.d);
  }

  public static boolean f(Context paramContext)
  {
    return asq.m(paramContext, SwipeService.class.getName());
  }

  static Notification g(Context paramContext)
  {
    Object localObject;
    if (h == null)
    {
      localObject = new Intent(paramContext.getApplicationContext(), MainActivity.class).setFlags(268435456);
      localObject = PendingIntent.getActivity(paramContext.getApplicationContext(), 0, (Intent)localObject, 134217728);
      localObject = new Builder(paramContext).setContentIntent((PendingIntent)localObject);
      if (VERSION.SDK_INT >= 18)
        ((Builder)localObject).setSmallIcon(2130903040).setContentTitle(paramContext.getText(2131231001)).setContentText(paramContext.getText(2131231000));
      if (VERSION.SDK_INT < 16)
        break label118;
    }
    label118: for (paramContext = ((Builder)localObject).build(); ; paramContext = ((Builder)localObject).getNotification())
    {
      h = paramContext;
      h.flags = 64;
      return h;
    }
  }

  public static boolean g()
  {
    return (i != null) && (i.j != null) && (i.j.f());
  }

  public static void h()
  {
    if (i == null)
      return;
    asp.a("Swipe.Service", "Reset Flurry session");
    if (!vs.D(i))
    {
      vs.C(i);
      vz.a(i);
    }
    vx.d(i);
    i.b.sendEmptyMessageDelayed(1, 5500L);
  }

  public static SwipeService i()
  {
    return i;
  }

  public static void k()
  {
    if (i != null)
      i.l();
  }

  public static void m()
  {
    if ((i() != null) && (i().e != null))
      i().e.d();
  }

  private void p()
  {
    this.e.d();
  }

  private void q()
  {
    if ((this.e.i()) || (SwipeApplication.c().a() == null) || (this.s == null))
    {
      this.e.b();
      return;
    }
    a(SwipeApplication.c().a(), this.s);
  }

  private void r()
  {
    if (!this.l)
      c(getApplicationContext());
  }

  private void s()
  {
    a(((SwipeApplication)getApplication()).a(), this.s);
  }

  public void a(ComponentName paramComponentName)
  {
    int i3 = 1;
    this.s = paramComponentName;
    boolean bool = afs.a(this, paramComponentName);
    afs.a(this, paramComponentName.getPackageName());
    Object localObject2 = SwipeApplication.c().a();
    ((wm)localObject2).b(paramComponentName);
    int i1 = 0;
    int i2 = 0;
    Object localObject1 = paramComponentName.getPackageName();
    if (acw.b(this))
      this.b.obtainMessage(17).sendToTarget();
    if (!this.e.i())
    {
      if (!this.m)
      {
        i1 = i2;
        if (aft.d());
      }
      else
      {
        a((wm)localObject2, paramComponentName);
        i1 = i2;
        if (aft.e((String)localObject1))
        {
          localObject2 = this.b.obtainMessage(11, localObject1);
          this.b.sendMessageDelayed((Message)localObject2, 500L);
          i1 = 1;
        }
      }
      if (VERSION.SDK_INT >= 21)
        this.b.sendEmptyMessage(7);
      localObject2 = this.b;
      if (!aft.e((String)localObject1))
      {
        i2 = 6;
        ((Handler)localObject2).sendEmptyMessage(i2);
        FixedTip.b();
        FloatTip.c();
        label182: if ((i1 != 0) || (!alk.a((String)localObject1)))
          break label291;
        localObject2 = this.b.obtainMessage(16, localObject1);
        this.b.sendMessageDelayed((Message)localObject2, 500L);
        i1 = i3;
      }
    }
    label291: 
    while (true)
    {
      if ((i1 == 0) && (bool))
      {
        localObject1 = this.b.obtainMessage(18, localObject1);
        this.b.sendMessageDelayed((Message)localObject1, 500L);
      }
      if (VERSION.SDK_INT < 18)
        alo.d(this, paramComponentName.getPackageName());
      abe.a(this, paramComponentName);
      return;
      i2 = 5;
      break;
      a((wm)localObject2, paramComponentName);
      break label182;
    }
  }

  public void a(yc paramyc)
  {
    if ((paramyc.g == null) && (alo.d()) && (!this.c))
      paramyc.g = aap.b(SwipeApplication.c()).b();
    auu.a(System.currentTimeMillis() + ": SwipeService.openFan; " + paramyc);
    if (a() != null)
      a().removeMessages(15);
    if (!yb.v())
      this.e.d();
    NewSwipeGuideView.a();
    if ((yb.a(getApplicationContext(), this) != null) && (this.s != null) && (((SwipeApplication)getApplication()).a().a.a(this.s)))
      EmptyActivity.a(this, 0);
    this.c = true;
  }

  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    if ("2".equals(vs.I(this)))
    {
      if (!paramBoolean)
        break label63;
      this.e.d();
    }
    while (true)
    {
      if (acw.b(this))
      {
        this.b.removeCallbacks(this.w);
        this.b.postDelayed(this.w, 2000L);
      }
      return;
      label63: if (this.e.i())
        this.e.b();
      else
        q();
    }
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.e.i());
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean)
            break;
          this.e.d();
        }
        while (alo.b());
        localObject = wq.b();
      }
      while (localObject == null);
      if (VERSION.SDK_INT <= 19)
      {
        ((wq)localObject).h();
        return;
      }
      localObject = ((wq)localObject).c(true);
    }
    while ((localObject == null) || (!c(((ComponentName)localObject).getPackageName())));
    this.j.e();
    this.k = System.currentTimeMillis();
    return;
    q();
  }

  public void b(ComponentName paramComponentName)
  {
    if (((paramComponentName.getPackageName().equals("FORCE")) && (paramComponentName.getClassName().equals("FORCE_DISMISS"))) || ((c(paramComponentName)) && (this.j != null) && (this.j.f())))
    {
      wq.a(true);
      this.b.sendEmptyMessage(8);
    }
    do
    {
      return;
      wq.a(false);
    }
    while (this.j == null);
    this.b.sendEmptyMessage(7);
  }

  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (paramBoolean)
      if (amk.b(this))
        a(this, d(this).getExtras());
    do
    {
      while (true)
      {
        a = 0L;
        if (alo.b())
          d(false);
        return;
        if ((amk.c(this)) || ((System.currentTimeMillis() - a <= 120000L) && (vs.y(this))))
        {
          amk.c(this, true);
          vs.e(this, 102);
          a(this, d(this).getExtras());
        }
      }
      vs.b(this, System.currentTimeMillis());
    }
    while (!alo.b());
    d(true);
  }

  public void c(String paramString, boolean paramBoolean)
  {
    yb.a.g = paramString;
    yb.a.b = paramBoolean;
    a(yb.a);
  }

  public void c(boolean paramBoolean)
  {
    yb.a.a(paramBoolean, false, false);
    a(yb.a);
  }

  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.j == null)
      {
        this.j = new vm(this);
        this.j.d();
      }
      this.j.b(this);
    }
    do
    {
      do
        return;
      while (this.j == null);
      this.j.a(this);
    }
    while (this.j.g());
    this.b.removeMessages(6);
    this.b.removeMessages(5);
    this.j.e();
    this.j = null;
  }

  void e(boolean paramBoolean)
  {
    int i1;
    if (!amk.b(this))
    {
      if ((!paramBoolean) && (!alo.d()))
        break label51;
      i1 = 1;
    }
    while (true)
    {
      if ((i1 == 0) || (!this.c));
      try
      {
        vs.g(this, aap.b(SwipeApplication.c()).b());
        label43: this.e.e();
        label51: 
        do
        {
          return;
          i1 = 0;
          break;
        }
        while (!this.c);
        this.e.f();
        return;
      }
      catch (Exception localException)
      {
        break label43;
      }
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1:
        asp.a("Swipe.Service", "Start a new Flurry session");
        vv.a().a(i);
        vx.b = 0L;
        return true;
      case 6:
      case 5:
      case 7:
      case 8:
      case 9:
      case 11:
      case 16:
      case 18:
      case 15:
      case 17:
      case 2:
      case 3:
      case 4:
      case 10:
      case 12:
      case 13:
      case 14:
      }
    }
    catch (Throwable paramMessage)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Exception in handleMessage [Screen monitor is null? ");
      if (this.j == null);
      for (boolean bool = true; ; bool = false)
      {
        Log.w("Swipe.Service", bool + "]", paramMessage);
        return true;
        if (this.j == null)
        {
          d(true);
          return true;
        }
        this.j.c();
        return true;
        if (this.j == null)
          break;
        this.j.b();
        return true;
        if (((VERSION.SDK_INT >= 21) && (System.currentTimeMillis() - this.k <= 200L)) || (this.j == null))
          break;
        this.j.d();
        return true;
        this.j.e();
        return true;
        startService(new Intent(this, SwipeServicePhantom.class));
        return true;
        if (!(paramMessage.obj instanceof String))
          break;
        afu.a((String)paramMessage.obj);
        return true;
        if (!(paramMessage.obj instanceof String))
          break;
        alk.b((String)paramMessage.obj);
        return true;
        if (!(paramMessage.obj instanceof String))
          break;
        afs.b(this, (String)paramMessage.obj);
        return true;
        yb.b(this);
        return true;
        acw.c(this);
        return true;
      }
    }
    return true;
  }

  public boolean j()
  {
    return this.q;
  }

  public void l()
  {
    c(vs.B(this));
  }

  public void n()
  {
    if (vs.K(this))
      f(true);
    if ((!this.e.i()) && ((!alo.b()) || (!this.d)))
      d(true);
  }

  public void o()
  {
    e(false);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.e.a(paramConfiguration);
    alx localalx = alx.getInstance();
    if ((localalx != null) && (!localalx.isShown()))
      localalx.onConfigurationChanged(paramConfiguration);
  }

  public void onCreate()
  {
    super.onCreate();
    this.t = new vh(this);
    this.t.a();
    this.e = new vu(this);
    if (!vs.m(this))
      vy.d(this);
    i = this;
    this.b = new Handler(this);
    this.d = alo.a(this, this);
    asp.a("Swipe.Service", "SwipeService created");
    if (aqr.a);
    try
    {
      startForeground(1, g(this));
      label95: if (VERSION.SDK_INT >= 18)
        startService(new Intent(this, SwipeServicePhantom.class));
      wq.a(getApplicationContext(), this);
      if (vs.H(this))
      {
        this.e.b();
        n();
      }
      if (acw.b(this))
      {
        acw.c(this, false);
        vp.a(this).a();
      }
      this.u = ((ClipboardManager)getSystemService("clipboard"));
      this.u.addPrimaryClipChangedListener(this);
      this.m = wq.c();
      if (!this.m);
      for (boolean bool = true; ; bool = false)
      {
        this.p = bool;
        vv.a().a(this);
        this.n = new vt(this);
        this.n.a();
        this.o = new aoc();
        this.o.a();
        alo.a(this);
        afs.a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label95;
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.u.removePrimaryClipChangedListener(this);
    alo.a(this, null);
    asp.a("Swipe.Service", "SwipeService destroyed");
    if (aqr.a);
    try
    {
      stopForeground(true);
      label38: this.n.b();
      this.o.b();
      this.t.b();
      this.e.d();
      if ((this.j != null) && (this.j.a()))
        this.j.e();
      acw.e(this, false);
      vp.a(this).b();
      wq.a();
      this.b.removeCallbacksAndMessages(null);
      vv.a().b(this);
      r();
      i = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label38;
    }
  }

  public void onDismiss()
  {
    EmptyActivity.a(this);
    if (!anj.p())
      q();
    if (this.b != null)
      this.b.sendEmptyMessageDelayed(15, 2000L);
    alo.a();
  }

  public void onPrimaryClipChanged()
  {
    if ((!acw.b(this)) || (!acw.h));
    ClipData localClipData;
    do
    {
      return;
      if (this.v == null)
        this.v = new PopupWindow.OnDismissListener()
        {
          public void onDismiss()
          {
            acw.c(SwipeService.this, false);
          }
        };
      localClipData = this.u.getPrimaryClip();
    }
    while ((localClipData == null) || (localClipData.getItemAt(0) == null) || (localClipData.getItemAt(0).getText() == null));
    acw.e(this, false);
    act.a(localClipData.getItemAt(0).getText().toString(), this.v);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null);
    boolean bool1;
    boolean bool2;
    String str1;
    String str2;
    String str3;
    do
    {
      do
      {
        do
        {
          return 1;
          paramInt1 = paramIntent.getIntExtra("operation", 0);
          asp.a("Swipe.Service", "onStartCommand " + paramInt1);
          switch (paramInt1)
          {
          case 3:
          case 4:
          case 11:
          default:
            return 1;
          case 1:
          case 17:
            this.l = false;
            this.e.b();
            n();
          case 2:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10:
          case 12:
          case 13:
          case 14:
          case 15:
          case 16:
          }
        }
        while (!paramIntent.getBooleanExtra("param_1", false));
        if (paramIntent.hasExtra("param_2"));
        for (bool1 = paramIntent.getBooleanExtra("param_2", false); ; bool1 = vs.B(this))
        {
          bool2 = paramIntent.getBooleanExtra("suppress_notifications", false);
          paramIntent = paramIntent.getStringExtra("tab_id");
          yb.a.a(bool1, bool2, false);
          yb.a.g = paramIntent;
          yb.a.n = paramInt1;
          a(yb.a);
          return 1;
        }
        this.l = true;
        p();
        return 1;
        paramInt1 = paramIntent.getIntExtra("type", -1);
      }
      while (paramInt1 == -1);
      paramIntent = paramIntent.getStringExtra("param_1");
      bool1 = vs.f(this, paramIntent);
      if (paramInt1 == 0)
      {
        f(bool1);
        wq.b().f();
        wq.d();
      }
      while (true)
      {
        this.m = vs.a(paramIntent);
        wq.b(this.m);
        a(((SwipeApplication)getApplication()).a(), asq.c(this));
        return 1;
        if (paramInt1 == 1)
          d(bool1);
      }
      this.e.a(paramIntent.getIntExtra("param_1", 0), paramIntent.getBooleanExtra("param_2", false));
      return 1;
      bool1 = paramIntent.getBooleanExtra("param_1", false);
      this.e.a(bool1);
      return 1;
      this.e.a(paramIntent.getIntExtra("param_1", 1));
      return 1;
      s();
      return 1;
      str1 = paramIntent.getStringExtra("param_1");
      bool1 = paramIntent.getBooleanExtra("param_2", true);
      str2 = paramIntent.getStringExtra("param_3");
      str3 = paramIntent.getStringExtra("param_4");
      bool2 = paramIntent.getBooleanExtra("param_5", false);
    }
    while (TextUtils.isEmpty(str1));
    ahx.a(this, str1, str2, str3, bool2).a(bool1, new Runnable()
    {
      public void run()
      {
        ajb.a = true;
        Bundle localBundle = SwipeService.a(SwipeService.this, vs.B(SwipeService.this)).getExtras();
        localBundle.putBoolean("suppress_notifications", true);
        SwipeService.a(SwipeService.this, localBundle);
      }
    });
    return 1;
    MainActivity.a(2, true);
    return 1;
    aiw.e();
    return 1;
    acw.a(this, paramIntent.getBooleanExtra("param_1", false), paramIntent.getBooleanExtra("param_2", false));
    return 1;
    acw.e(this, paramIntent.getBooleanExtra("param_1", false));
    return 1;
    acw.d(this, paramIntent.getBooleanExtra("param_1", false));
    return 1;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.SwipeService
 * JD-Core Version:    0.6.2
 */