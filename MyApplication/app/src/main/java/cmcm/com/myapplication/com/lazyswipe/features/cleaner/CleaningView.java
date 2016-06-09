package cmcm.com.myapplication.com.lazyswipe.features.cleaner;

import acu;
import acw;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import aoc;
import aqs;
import ari;
import asj;
import aso;
import asq;
import ast;
import ci;
import com.lazyswipe.SwipeApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import wm;

public class CleaningView extends FrameLayout
{
  static final String a = "Swipe." + CleaningView.class.getSimpleName();
  private static boolean q;
  private final long b = 8000L;
  private final long c = 2500L;
  private WindowManager.LayoutParams d;
  private boolean e;
  private CleaningEngine f;
  private long g;
  private long h;
  private boolean i;
  private boolean j;
  private boolean k;
  private WeakReference<acw> l;
  private LinkedList<String> m;
  private int n;
  private final List<acu> o = new ArrayList();
  private Point p;
  private final BroadcastReceiver r = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent == null);
      long l;
      label176: 
      do
      {
        return;
        paramAnonymousContext = paramAnonymousIntent.getAction();
        int i = -1;
        switch (paramAnonymousContext.hashCode())
        {
        default:
        case -2121032551:
        case -2011903037:
        case -853573846:
        }
        while (true)
          switch (i)
          {
          default:
            return;
          case 0:
            CleaningView.b(CleaningView.this).removeMessages(0);
            l = System.currentTimeMillis() - CleaningView.c(CleaningView.this);
            if ((l >= 0L) && (l <= 2500L))
              break label176;
            CleaningView.b(CleaningView.this).sendEmptyMessage(0);
            return;
            if (paramAnonymousContext.equals("ACTION_BOOST_LOGIC_FINISH"))
            {
              i = 0;
              continue;
              if (paramAnonymousContext.equals("ACTION_BOOST_LOGIC_BEGIN"))
              {
                i = 1;
                continue;
                if (paramAnonymousContext.equals("BROADCAST_ACTION_HOME_KEY"))
                  i = 2;
              }
            }
            break;
          case 1:
          case 2:
          }
        CleaningView.b(CleaningView.this).sendEmptyMessageDelayed(0, 2500L - l);
        return;
        paramAnonymousContext = paramAnonymousIntent.getStringArrayExtra("EXTRA_TASK_KILL_PKG");
        l = paramAnonymousIntent.getLongExtra("token", -1L);
      }
      while ((CleaningView.d(CleaningView.this) != l) || (paramAnonymousContext == null) || (paramAnonymousContext.length == 0));
      CleaningView.a(CleaningView.this, CleaningView.a(CleaningView.this, paramAnonymousContext));
      return;
      CleaningView.e(CleaningView.this);
    }
  };
  private final Handler s = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 0:
      case 1:
      }
      do
      {
        return;
        CleaningView.this.d();
        return;
      }
      while (CleaningView.f(CleaningView.this));
      CleaningView.g(CleaningView.this);
    }
  };

  public CleaningView(Context paramContext)
  {
    super(paramContext);
  }

  public CleaningView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static CleaningView a(Context paramContext)
  {
    return (CleaningView)LayoutInflater.from(paramContext).inflate(2130968636, null);
  }

  private LinkedList<String> a(String[] paramArrayOfString)
  {
    wm localwm;
    Set localSet;
    try
    {
      localwm = SwipeApplication.c().a();
      localSet = asq.a(getContext(), 22);
      localObject1 = localSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localwm.a((String)localObject2) == null) || (asj.a(getContext(), (String)localObject2)))
          ((Iterator)localObject1).remove();
      }
    }
    catch (Exception paramArrayOfString)
    {
      return new LinkedList();
    }
    if (localSet.size() > 12)
      return new LinkedList(localSet);
    Object localObject1 = new LinkedList();
    Object localObject2 = new ArrayList(paramArrayOfString.length);
    ((List)localObject2).removeAll(localSet);
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (true)
    {
      if (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        if (localwm.a(str) != null)
          ((List)localObject2).add(str);
      }
      else
      {
        Collections.shuffle((List)localObject2);
        ((LinkedList)localObject1).addAll(localSet);
        ((LinkedList)localObject1).addAll((Collection)localObject2);
        return localObject1;
      }
      i1 += 1;
    }
  }

  public static boolean a()
  {
    return q;
  }

  private void f()
  {
    this.s.sendEmptyMessage(0);
    aso.a(getContext(), 2131230969, 1, -1, asq.a(70.0F), true);
  }

  private void g()
  {
    if ((this.j) && (!this.k))
    {
      acu localacu = getNextGarbage();
      localacu.a(this);
      this.o.add(localacu);
    }
    this.s.sendEmptyMessageDelayed(1, ari.c(350, 700));
  }

  private acu getNextGarbage()
  {
    this.n += 1;
    if (asq.a(this.m))
      return acu.a(getContext(), this.p);
    if (this.n <= 3)
      return acu.a(getContext(), this.p);
    if (this.n % 5 == 2)
      return acu.a(getContext(), this.p);
    try
    {
      Object localObject = (String)this.m.poll();
      localObject = acu.a(getContext(), (String)localObject, this.p);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return acu.a(getContext(), this.p);
  }

  private long getRequireTime()
  {
    Iterator localIterator = this.o.iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      long l2 = ((acu)localIterator.next()).getRequireTime();
      if (l2 <= l1)
        break label50;
      l1 = l2;
    }
    label50: 
    while (true)
    {
      break;
      return l1;
    }
  }

  private void h()
  {
    if (this.i)
      return;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("ACTION_BOOST_LOGIC_FINISH");
      localIntentFilter.addAction("ACTION_BOOST_LOGIC_BEGIN");
      localIntentFilter.addAction("BROADCAST_ACTION_HOME_KEY");
      ci.a(getContext()).a(this.r, localIntentFilter);
      this.i = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void i()
  {
    if (!this.i)
      return;
    try
    {
      ci.a(getContext()).a(this.r);
      this.i = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.f.a(paramInt1, paramInt2);
  }

  public void a(acw paramacw, long paramLong)
  {
    this.n = 0;
    this.f.e();
    this.o.clear();
    g();
    q = true;
    this.l = new WeakReference(paramacw);
    this.h = System.currentTimeMillis();
    this.g = paramLong;
    this.s.removeMessages(0);
    this.s.sendEmptyMessageDelayed(0, 8000L);
  }

  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.e = paramBoolean;
    this.f.a(paramBoolean);
  }

  public void b()
  {
    setLayerType(2, null);
    this.d = ast.a(getContext());
    ast.a(getContext(), this, this.d);
  }

  public void b(int paramInt1, int paramInt2)
  {
    if (!this.e)
      this.f.animate().alpha(0.0F).setDuration(300L);
  }

  public void c()
  {
    ast.a(getContext(), this);
  }

  public void c(int paramInt1, int paramInt2)
  {
    if (!this.e)
      a(paramInt1, paramInt2);
  }

  void d()
  {
    this.k = true;
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((acu)localIterator.next()).a();
    postDelayed(new Runnable()
    {
      public void run()
      {
        CleaningView.a(CleaningView.this).a(new Runnable()
        {
          public void run()
          {
            CleaningView.this.e();
          }
        });
      }
    }
    , getRequireTime());
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      f();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  void e()
  {
    if ((this.l != null) && (this.l.get() != null));
    try
    {
      ((acw)this.l.get()).h();
      label30: this.l.clear();
      this.l = null;
      q = false;
      aoc.a(this.g);
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    h();
    setFocusableInTouchMode(true);
    this.j = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    i();
    this.j = false;
    this.s.removeCallbacksAndMessages(null);
    q = false;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((CleaningEngine)findViewById(2131755242));
    this.p = new Point(aqs.ac() / 2, aqs.ad() / 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.cleaner.CleaningView
 * JD-Core Version:    0.6.2
 */