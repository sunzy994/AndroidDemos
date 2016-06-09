package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.lazyswipe.SwipeService;
import com.lazyswipe.notification.SwipeAccessibilityService;

@SuppressLint({"ViewConstructor"})
public class avd extends View
  implements Callback
{
  private final WindowManager.LayoutParams a;
  private boolean b;
  private VelocityTracker c;
  private float d;
  private float e;
  private boolean f = false;
  private final boolean g;
  private final boolean h;
  private final int[] i;
  private int j;
  private int k;
  private final Handler l;
  private final Rect m;
  private final vu n;
  private all o;
  private boolean p;
  private boolean q;
  private boolean r;

  public avd(SwipeService paramSwipeService, boolean paramBoolean1, boolean paramBoolean2, int paramInt, vu paramvu)
  {
    super(paramSwipeService);
    this.n = paramvu;
    this.m = new Rect();
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.j = paramInt;
    this.l = new Handler(this);
    this.a = this.n.a();
    a();
    this.i = new int[2];
  }

  public avd(SwipeService paramSwipeService, boolean paramBoolean1, boolean paramBoolean2, vu paramvu)
  {
    this(paramSwipeService, paramBoolean1, paramBoolean2, 0, paramvu);
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
    {
      bool2 = true;
      if (!bool2)
        break label72;
      if (paramFloat2 >= 0.0F)
        break label67;
    }
    while (true)
    {
      SwipeAccessibilityService.a(this.m.left + (int)this.d, this.m.top + (int)this.e, bool2, bool1);
      return;
      bool2 = false;
      break;
      label67: bool1 = false;
      continue;
      label72: if (paramFloat1 <= 0.0F)
        bool1 = false;
    }
  }

  private void a(MotionEvent paramMotionEvent)
  {
    if (this.c != null)
    {
      this.c.computeCurrentVelocity(1000);
      a(paramMotionEvent, Math.abs(this.c.getXVelocity()), Math.abs(this.c.getYVelocity()));
      return;
    }
    a(paramMotionEvent, 0.0F, 0.0F);
  }

  private void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    if (!this.b);
    int i1;
    int i2;
    int i3;
    label249: 
    do
    {
      float f1;
      float f2;
      do
      {
        return;
        i1 = getToucherId();
        f1 = paramMotionEvent.getX() - this.d;
        f2 = paramMotionEvent.getY() - this.e;
        i2 = b(f1, f2);
        i3 = k();
        paramFloat1 = Math.min(paramFloat1, paramFloat2);
        if ((this.h) && (SwipeAccessibilityService.a) && (SwipeAccessibilityService.a() != null))
        {
          if (((5 == this.j) || (i3 > 2)) && (((i2 > 75) && (i2 < 105)) || ((i2 > 255) && (i2 < 285))))
            break;
          if ((this.j == 3) || (this.j == 2));
        }
        if (!ahy.d(getContext()))
          break label249;
      }
      while (this.p);
      this.p = true;
      yb.a.a(this.g, i1, i2, this.n.c, this.n.d, i3);
      paramMotionEvent = yb.a;
      if (paramFloat1 < this.n.l);
      for (boolean bool = true; ; bool = false)
      {
        paramMotionEvent.k = bool;
        yb.a.m = true;
        this.n.a(yb.a);
        return;
        a(f1, f2);
        return;
      }
      if (!this.r)
      {
        this.r = true;
        yb.a.a(this.g, i1, i2, this.n.c, this.n.d, i3);
        paramMotionEvent = new Runnable()
        {
          public void run()
          {
            if (!avd.d(avd.this))
            {
              avd.a(avd.this, true);
              yb.a.k = avd.e(avd.this);
              yb.a.m = true;
              avd.f(avd.this).a(yb.a);
            }
          }
        };
        if (paramFloat1 < this.n.l);
        for (long l1 = 50L; ; l1 = 100L)
        {
          postDelayed(paramMotionEvent, l1);
          return;
        }
      }
    }
    while ((this.q) || (this.p));
    this.p = true;
    yb.a.a(this.g, i1, i2, this.n.c, this.n.d, i3);
    yb.a.k = false;
    yb.a.m = true;
    this.n.a(yb.a);
  }

  private int b(float paramFloat1, float paramFloat2)
  {
    return ((int)(asq.a(paramFloat1, paramFloat2) - 90.0D) + 360) % 360 >> 1 << 1;
  }

  private void j()
  {
    int i2 = this.k;
    if (this.h)
      this.a.width = ((int)(this.n.q * this.n.o));
    int i1;
    if (this.j == 1)
    {
      i1 = this.n.b * 4;
      this.a.height = i1;
      this.a.y = this.n.t;
      if (this.j != 2)
        break label193;
      localLayoutParams = this.a;
      localLayoutParams.y = (i1 + localLayoutParams.y);
    }
    label193: 
    while (this.j != 5)
    {
      return;
      if (this.j == 5)
      {
        i1 = i2 - this.n.b * 4;
        localLayoutParams = this.a;
        localLayoutParams.width = ((int)(localLayoutParams.width * 0.7F));
        break;
      }
      if (this.j == 3)
      {
        i1 = i2 + this.k;
        break;
      }
      i1 = i2;
      if (this.j != 7)
        break;
      WindowManager.LayoutParams localLayoutParams = this.a;
      localLayoutParams.width = ((int)(localLayoutParams.width * 1.6F));
      i1 = i2;
      break;
    }
    this.a.y = (this.n.b * 4);
  }

  private int k()
  {
    if (this.h)
      return (int)Math.ceil((this.a.height - this.e) / this.n.b);
    if (!this.g);
    for (float f1 = this.a.width - this.d; ; f1 = this.d)
      return (int)Math.ceil(f1 / this.n.a);
  }

  private boolean l()
  {
    return this.j == 7;
  }

  public void a()
  {
    a(false);
  }

  public void a(boolean paramBoolean)
  {
    int i1;
    int i2;
    if ((this.h) && (!l()))
    {
      i1 = this.n.q;
      if ((!this.h) && (!l()))
        break label285;
      i2 = this.n.p;
      label45: this.k = i2;
      i2 = this.n.q;
      float f1 = this.n.o;
      if (f1 == 1.0F)
        break label411;
      i1 = (int)(i1 * f1);
      this.k = ((int)(this.k * f1));
      i2 = (int)(i2 * f1);
    }
    label411: 
    while (true)
    {
      this.a.width = i1;
      j();
      if (!this.g)
        if (this.h)
        {
          this.a.x = 0;
          this.m.left = (this.n.m - this.a.width);
        }
      while (true)
      {
        this.m.right = (this.m.left + this.a.width);
        this.m.bottom = (this.n.n - this.a.y);
        this.m.top = (this.m.bottom - this.a.height);
        if (this.o != null)
          this.o.a(this.a.width, this.a.height);
        if ((paramBoolean) && (f()))
          this.n.b(this, this.a);
        return;
        i1 = this.n.s;
        break;
        label285: i2 = this.n.r;
        break label45;
        this.a.x = i2;
        this.m.left = (this.n.m - this.a.width - i2);
        continue;
        if (this.h)
        {
          this.a.x = (this.n.m - this.a.width);
          this.m.left = 0;
        }
        else
        {
          this.a.x = (this.n.m - this.a.width - i2);
          this.m.left = i2;
        }
      }
    }
  }

  public void b()
  {
    if (this.o != null)
      this.o.b();
  }

  public void b(boolean paramBoolean)
  {
    if (this.o != null)
      this.o.a(paramBoolean);
  }

  public void c()
  {
    this.l.post(new Runnable()
    {
      public void run()
      {
        if (avd.a(avd.this) == null)
          avd.a(avd.this, new all(avd.this, avd.b(avd.this)));
        avd.a(avd.this).a(avd.c(avd.this).width, avd.c(avd.this).height);
        avd.a(avd.this).a();
      }
    });
  }

  public void d()
  {
    setBackgroundResource(2131689554);
  }

  public void e()
  {
    setBackgroundResource(17170445);
  }

  public boolean f()
  {
    return this.b;
  }

  public void g()
  {
    if (this.b)
      return;
    if (!asq.n())
    {
      this.l.sendEmptyMessage(1);
      return;
    }
    if (this.o != null)
      this.o.d();
    this.b = this.n.a(this, this.a);
  }

  public Rect getBoundsInScreen()
  {
    return this.m;
  }

  int getToucherId()
  {
    if (!this.h);
    for (int i1 = 4; ; i1 = this.j)
    {
      int i2 = i1;
      if (!this.g)
        i2 = -i1;
      return i2;
    }
  }

  public int getType()
  {
    return this.j;
  }

  public void h()
  {
    boolean bool = false;
    if (!this.b)
      return;
    if (!asq.n())
    {
      this.l.sendEmptyMessage(4);
      return;
    }
    b(false);
    if (!this.n.a(this))
      bool = true;
    this.b = bool;
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2:
    case 3:
    default:
    case 1:
    case 4:
    }
    while (true)
    {
      return true;
      if ((alo.b()) || (!SwipeService.g()))
      {
        g();
        continue;
        h();
      }
    }
  }

  public void i()
  {
    this.n.b(this, this.a);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.o != null)
    {
      this.o.d();
      this.o = null;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.o != null)
      this.o.a(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }

  @SuppressLint({"NewApi"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.c == null)
      this.c = VelocityTracker.obtain();
    this.c.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 3:
    default:
    case 0:
      while (true)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.d = paramMotionEvent.getX();
        this.e = paramMotionEvent.getY();
        this.f = false;
        this.p = false;
        this.q = true;
        this.r = false;
      }
    case 1:
      this.q = false;
      if (this.f)
      {
        this.c.computeCurrentVelocity(1000);
        f1 = this.c.getXVelocity();
        f2 = this.c.getYVelocity();
        float f3 = Math.abs(f1);
        float f4 = Math.abs(f2);
        localStringBuilder = new StringBuilder().append("Swipe.Toucher UP Velocities: ").append(f3).append(", ").append(f4).append(", min velocity: ").append(this.n.h).append("; should evaluate? ? ");
        if (f3 * f3 + f4 * f4 > this.n.i)
        {
          label235: auu.a(bool1);
          if ((Math.max(f3, f4) > this.n.h) || (f3 * f3 + f4 * f4 > this.n.i))
            a(paramMotionEvent, f3, f4);
          if (yb.o())
            yb.getInstance().a(f1, f2);
        }
      }
      while (this.c != null)
      {
        this.c.recycle();
        this.c = null;
        break;
        bool1 = false;
        break label235;
        if ((this.o != null) && (this.o.c()))
        {
          b(true);
          auu.a(System.currentTimeMillis() + ": Toucher.onTouchEvent");
          this.n.h();
        }
        else
        {
          h();
          this.l.sendEmptyMessageDelayed(1, 2000L);
          if (SwipeAccessibilityService.a)
            SwipeAccessibilityService.a(this.m.left + (int)this.d, this.m.top + (int)this.e);
        }
      }
    case 2:
    }
    float f1 = Math.abs(paramMotionEvent.getX() - this.d);
    float f2 = Math.abs(paramMotionEvent.getY() - this.e);
    if ((!this.f) && ((f1 > this.n.e) || (f2 > this.n.e)))
      this.f = true;
    StringBuilder localStringBuilder = new StringBuilder().append("Swipe.Toucher MOVE deltaX: ").append(f1).append(", deltaY: ").append(f2).append(", is moved? ").append(this.f).append(", should evaluate? ");
    if (f1 * f1 + f2 * f2 > this.n.f * this.n.f);
    for (bool1 = bool2; ; bool1 = false)
    {
      auu.a(bool1);
      if ((this.f) && ((Math.max(f1, f2) > this.n.f) || (f1 * f1 + f2 * f2 > this.n.g)))
        a(paramMotionEvent);
      if (!yb.o())
        break;
      int i1 = (int)Math.hypot(paramMotionEvent.getX(), paramMotionEvent.getY() - getHeight());
      yb.getInstance().a(i1);
      break;
    }
  }

  public void setType(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      j();
      if (this.o != null)
        this.o.a(this.a.width, this.a.height);
      if (f())
        this.n.b(this, this.a);
    }
  }

  public void setWindowType(int paramInt)
  {
    if (paramInt != this.a.type)
    {
      this.a.type = paramInt;
      if (isShown())
        if ((this.o == null) || (!this.o.c()))
          break label62;
    }
    label62: for (paramInt = 1; ; paramInt = 0)
    {
      this.n.b(this);
      if (paramInt != 0)
        c();
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avd
 * JD-Core Version:    0.6.2
 */