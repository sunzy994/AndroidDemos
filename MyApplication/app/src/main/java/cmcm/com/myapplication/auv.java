package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.lazyswipe.SwipeApplication;

public abstract class auv extends FrameLayout
  implements OnTouchListener
{
  private GestureDetector a;
  protected final View j;
  protected WindowManager.LayoutParams k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected final int q;
  protected final int r;
  protected float s;
  protected float t;
  protected boolean u;
  protected boolean v;
  protected int w;
  protected final boolean x = true;

  public auv(Context paramContext)
  {
    this(paramContext, 2003);
  }

  public auv(Context paramContext, int paramInt)
  {
    super(paramContext);
    Object localObject = ViewConfiguration.get(paramContext);
    this.q = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.r = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
    localObject = paramContext.getResources().getDisplayMetrics();
    this.o = ((DisplayMetrics)localObject).heightPixels;
    this.n = ((DisplayMetrics)localObject).widthPixels;
    this.p = (this.n >> 1);
    this.w = paramContext.getResources().getConfiguration().orientation;
    i();
    this.k.type = paramInt;
    this.j = a();
    j();
    if (this.j == null)
      throw new RuntimeException("You must set up Content view in setContentView()");
    if (!this.j.equals(this))
      addView(this.j, -1, -1);
    this.a = new GestureDetector(paramContext, new SimpleOnGestureListener()
    {
      public boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        return auv.this.g(paramAnonymousMotionEvent);
      }

      public boolean onDoubleTapEvent(MotionEvent paramAnonymousMotionEvent)
      {
        if (1 == paramAnonymousMotionEvent.getAction());
        return super.onDoubleTapEvent(paramAnonymousMotionEvent);
      }

      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return auv.this.c(paramAnonymousMotionEvent);
      }

      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        auv.this.u = true;
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
          return false;
        return auv.this.d(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
      }

      public void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        auv.this.f(paramAnonymousMotionEvent);
      }

      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return (auv.this.isShown()) && (auv.this.a(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2));
      }

      public void onShowPress(MotionEvent paramAnonymousMotionEvent)
      {
        auv.this.e(paramAnonymousMotionEvent);
      }

      public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        return auv.this.a(paramAnonymousMotionEvent);
      }

      public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        return super.onSingleTapUp(paramAnonymousMotionEvent);
      }
    });
    setOnTouchListener(this);
  }

  protected abstract View a();

  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.v = true;
    return false;
  }

  protected void b(MotionEvent paramMotionEvent)
  {
  }

  public boolean b()
  {
    if (isShown())
      return false;
    ast.a(SwipeApplication.c(), this, this.k);
    return true;
  }

  protected boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public boolean c(MotionEvent paramMotionEvent)
  {
    this.s = paramMotionEvent.getRawX();
    this.t = paramMotionEvent.getRawY();
    this.v = false;
    this.u = false;
    return true;
  }

  protected boolean c(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  protected void c_()
  {
    d(isShown());
  }

  public void d(MotionEvent paramMotionEvent)
  {
  }

  public boolean d(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    switch (asr.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))
    {
    case 3:
    case 5:
    case 6:
    case 7:
    default:
      return false;
    case 1:
      return c(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    case 2:
      return b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    case 8:
      return e(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    case 4:
    }
    return f(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }

  protected final boolean d(boolean paramBoolean)
  {
    if (g_())
    {
      if (paramBoolean)
        ast.b(getContext(), this, this.k);
      return true;
    }
    return false;
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((r()) && (paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      s();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public void e(MotionEvent paramMotionEvent)
  {
  }

  protected boolean e()
  {
    return false;
  }

  protected boolean e(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void f(MotionEvent paramMotionEvent)
  {
  }

  protected boolean f(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public boolean g(MotionEvent paramMotionEvent)
  {
    return false;
  }

  protected boolean g_()
  {
    j();
    return true;
  }

  protected boolean h_()
  {
    return false;
  }

  protected void i()
  {
    this.k = new WindowManager.LayoutParams();
    this.k.format = 1;
    this.k.flags = 40;
    this.k.width = -2;
    this.k.height = -2;
    this.k.gravity = 51;
    WindowManager.LayoutParams localLayoutParams;
    if (h_())
    {
      localLayoutParams = this.k;
      localLayoutParams.flags |= 262144;
    }
    if (r())
    {
      localLayoutParams = this.k;
      localLayoutParams.flags &= -9;
      setFocusable(true);
      setFocusableInTouchMode(true);
      requestFocus();
    }
  }

  protected abstract void j();

  protected void l()
  {
  }

  public boolean o()
  {
    if (!isShown())
      return false;
    ast.a(SwipeApplication.c(), this);
    return true;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation != this.w)
    {
      this.w = paramConfiguration.orientation;
      paramConfiguration = getResources().getDisplayMetrics();
      this.o = paramConfiguration.heightPixels;
      this.p = (this.o >> 1);
      this.n = paramConfiguration.widthPixels;
      this.p = (this.n >> 1);
      c_();
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.m == 0) && (this.l == 0))
    {
      this.m = (paramInt3 - paramInt2);
      this.l = (paramInt4 - paramInt2);
    }
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (4 == i)
      l();
    do
    {
      do
      {
        return false;
        if (this.a.onTouchEvent(paramMotionEvent))
          return true;
      }
      while ((1 != i) && (3 != i));
      if (!this.u)
        break;
    }
    while ((!this.v) || (e()));
    b(paramMotionEvent);
    return false;
    if (this.v)
    {
      b(paramMotionEvent);
      return false;
    }
    d(paramMotionEvent);
    return false;
  }

  public void p()
  {
    o();
    b();
  }

  protected void q()
  {
    ast.b(getContext(), this, this.k);
  }

  protected boolean r()
  {
    return false;
  }

  protected void s()
  {
  }

  public void setWindowType(int paramInt)
  {
    if (paramInt != this.k.type)
    {
      this.k.type = paramInt;
      if (isShown())
        p();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auv
 * JD-Core Version:    0.6.2
 */