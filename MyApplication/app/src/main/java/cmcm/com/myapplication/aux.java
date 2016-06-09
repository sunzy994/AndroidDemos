package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class aux extends auv
{
  protected boolean A;
  private final Interpolator a = new AccelerateDecelerateInterpolator();
  private final boolean b = false;
  private int c;
  private int d;
  private final Handler e = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 3:
      case 4:
      default:
        return;
      case 2:
        aux.this.a(paramAnonymousMessage);
        return;
      case 5:
        aux.this.a(((Boolean)paramAnonymousMessage.obj).booleanValue());
        return;
      case 6:
      }
      aux.this.b(((Boolean)paramAnonymousMessage.obj).booleanValue());
    }
  };
  protected long y;
  protected boolean z;

  public aux(Context paramContext)
  {
    super(paramContext, vs.b(paramContext, true));
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = this.A;
    this.A = paramBoolean1;
    if (((bool ^ paramBoolean1)) || (paramBoolean2))
      c(this.A);
  }

  protected void a(int paramInt)
  {
    String str = getPositionKey() + "_" + this.w;
    vs.b(getContext(), str, paramInt);
  }

  protected void a(int paramInt1, int paramInt2)
  {
  }

  protected void a(int paramInt1, int paramInt2, int paramInt3, final AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.k.x, paramInt1 });
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        aux.this.k.x = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        ast.b(aux.this.getContext(), aux.this, aux.this.k);
      }
    });
    localValueAnimator.start();
    localValueAnimator = ValueAnimator.ofInt(new int[] { this.k.y, paramInt2 });
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        aux.this.k.y = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        ast.b(aux.this.getContext(), aux.this, aux.this.k);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (paramAnimatorListener != null)
          paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
      }
    });
    localValueAnimator.start();
  }

  void a(Message paramMessage)
  {
    if (!this.z);
    float f;
    do
    {
      return;
      f = (float)(System.currentTimeMillis() - this.y) / 400.0F;
      if (f > 1.0F)
      {
        this.z = false;
        this.k.x = this.c;
        ast.b(getContext(), this, this.k);
        a(this.k.x, this.k.y);
        return;
      }
      f = this.a.getInterpolation(f);
    }
    while (2 != paramMessage.what);
    if (this.c < this.d);
    int i;
    for (this.k.x = (this.d - (int)(f * this.d)); ; paramMessage.x = ((int)(f * (this.c - this.d)) + i))
    {
      ast.b(getContext(), this, this.k);
      e(this.k.x, this.k.y);
      this.e.sendEmptyMessageDelayed(2, 16L);
      return;
      paramMessage = this.k;
      i = this.d;
    }
  }

  protected void a(boolean paramBoolean)
  {
    super.b();
  }

  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!t())
      return false;
    if (!this.v)
      f();
    this.v = true;
    paramFloat1 = paramMotionEvent2.getRawX();
    paramFloat2 = this.s;
    float f1 = paramMotionEvent2.getRawY();
    float f2 = this.t;
    this.s = paramMotionEvent2.getRawX();
    this.t = paramMotionEvent2.getRawY();
    paramMotionEvent1 = this.k;
    int i = paramMotionEvent1.x;
    paramMotionEvent1.x = ((int)(paramFloat1 - paramFloat2) + i);
    paramMotionEvent1 = this.k;
    i = paramMotionEvent1.y;
    paramMotionEvent1.y = ((int)(f1 - f2) + i);
    ast.b(getContext(), this, this.k);
    if (this.s < this.p);
    for (boolean bool = true; ; bool = false)
    {
      a(bool, false);
      b((int)this.s, (int)this.t);
      return true;
    }
  }

  protected void b(int paramInt1, int paramInt2)
  {
  }

  protected void b(MotionEvent paramMotionEvent)
  {
    if (!t());
    while ((c(this.k.x, this.k.y)) || (this.b))
      return;
    d(this.k.x, this.k.y);
    this.d = this.k.x;
    boolean bool;
    int i;
    if (this.d - this.p <= 0)
    {
      bool = true;
      if (bool)
        break label217;
      i = this.n - this.m - getPaddingX();
      label100: this.c = i;
      a(bool, true);
      int j = (int)(this.k.y * 100.0F / this.o);
      i = j;
      if (j <= 0)
        i = 1;
      if (!bool)
        break label225;
    }
    while (true)
    {
      a(i);
      if (Math.abs(this.c - this.d) > this.m)
        break label231;
      this.k.x = this.c;
      ast.b(getContext(), this, this.k);
      a(this.k.x, this.k.y);
      return;
      bool = false;
      break;
      label217: i = getPaddingX();
      break label100;
      label225: i = -i;
    }
    label231: this.z = true;
    this.y = System.currentTimeMillis();
    this.e.removeMessages(2);
    this.e.sendEmptyMessageDelayed(2, 16L);
  }

  protected void b(boolean paramBoolean)
  {
    super.o();
    this.e.removeCallbacksAndMessages(null);
  }

  public boolean b()
  {
    return e(false);
  }

  protected void c(boolean paramBoolean)
  {
  }

  protected boolean c(int paramInt1, int paramInt2)
  {
    return false;
  }

  protected void d(int paramInt1, int paramInt2)
  {
  }

  public void d(MotionEvent paramMotionEvent)
  {
    super.d(paramMotionEvent);
  }

  protected void e(int paramInt1, int paramInt2)
  {
  }

  public boolean e(boolean paramBoolean)
  {
    if (isShown())
      return false;
    if (asq.n())
      a(paramBoolean);
    while (true)
    {
      return true;
      this.e.obtainMessage(5, Boolean.valueOf(paramBoolean)).sendToTarget();
    }
  }

  protected void f()
  {
  }

  public boolean f(boolean paramBoolean)
  {
    if (!isShown())
      return false;
    if (asq.n())
      b(paramBoolean);
    while (true)
    {
      return true;
      this.e.obtainMessage(6, Boolean.valueOf(paramBoolean)).sendToTarget();
    }
  }

  protected boolean g_()
  {
    Object localObject = getPositionKey() + "_" + this.w;
    int j = vs.a(getContext(), (String)localObject, getDefaultPosition());
    boolean bool;
    if (j > 0)
    {
      bool = true;
      a(bool, true);
      localObject = this.k;
      if (!bool)
        break label116;
    }
    label116: for (int i = getPaddingX(); ; i = this.n - this.m - getPaddingX())
    {
      ((WindowManager.LayoutParams)localObject).x = i;
      localObject = this.k;
      float f = this.o;
      ((WindowManager.LayoutParams)localObject).y = ((int)(Math.abs(j) * (f * 1.0F) / 100.0F));
      return true;
      bool = false;
      break;
    }
  }

  protected abstract int getDefaultPosition();

  protected abstract int getPaddingX();

  public int getPosY()
  {
    return this.k.y;
  }

  public int getPosYReversed()
  {
    return this.o - this.k.y;
  }

  protected abstract String getPositionKey();

  protected abstract int getWindowHeight();

  protected abstract int getWindowWidth();

  protected void j()
  {
    this.w = getResources().getConfiguration().orientation;
    this.k.width = getWindowWidth();
    this.k.height = getWindowHeight();
    d(false);
  }

  public boolean o()
  {
    return f(false);
  }

  protected boolean t()
  {
    return true;
  }

  public boolean u()
  {
    return this.k.x <= this.p;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aux
 * JD-Core Version:    0.6.2
 */