package cmcm.com.myapplication.com.lazyswipe.fan;

import aao;
import ahw;
import ahx;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aof;
import asp;
import asv;
import atw;
import auu;
import vy;
import yb;
import yd;
import yk;
import yl;

public class TabSector extends FrameLayout
  implements AnimationListener, aof
{
  boolean a;
  private View b;
  private ImageView c;
  private final TabIndicatorLabel[] d = new TabIndicatorLabel[3];
  private float[] e;
  private float[] f;
  private yb g;
  private SectorArea h;
  private boolean i = false;
  private int j = 1;
  private int k = -1;
  private boolean l = false;
  private final Rect m = new Rect();
  private int n;
  private int o;
  private int p;
  private int q = 0;
  private float r;
  private float s;
  private final int t;
  private boolean u;

  public TabSector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.t = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }

  private int a(yl paramyl)
  {
    float f1 = (paramyl.b + 0.1F) / Math.abs(paramyl.a);
    int i1 = 0;
    while (i1 < this.e.length)
    {
      if (f1 > this.e[i1])
        return i1;
      i1 += 1;
    }
    return this.e.length;
  }

  private void g()
  {
    LayoutParams localLayoutParams = (LayoutParams)this.b.getLayoutParams();
    yl localyl;
    if (localLayoutParams != null)
    {
      localyl = this.g.getStartPosition();
      localLayoutParams.bottomMargin = (localyl.b - this.b.getMeasuredHeight() / 2 - 3 + this.p);
      if (this.l)
        localLayoutParams.leftMargin = (localyl.a - this.b.getMeasuredWidth() / 2 - 3 + this.p);
    }
    else
    {
      return;
    }
    localLayoutParams.rightMargin = (-localyl.a - this.b.getMeasuredWidth() / 2 - 3 + this.p);
  }

  private void h()
  {
    LayoutParams localLayoutParams = (LayoutParams)this.c.getLayoutParams();
    int i1 = ahx.b(getContext()).a(this.g);
    if (localLayoutParams != null)
    {
      localLayoutParams.bottomMargin = (this.p + i1);
      if (this.l)
        localLayoutParams.leftMargin = (i1 + this.p);
    }
    else
    {
      return;
    }
    localLayoutParams.rightMargin = (i1 + this.p);
  }

  private void i()
  {
    int i3 = this.g.getTabCount();
    int i4 = (this.g.getTabSectorInnerSize() + this.g.getTabSectorOuterSize()) / 2;
    int i5 = this.p;
    float f2 = (float)(yk.a / 3.0D);
    int i6 = ahx.b(getContext()).a(this.g);
    TabIndicatorLabel[] arrayOfTabIndicatorLabel = this.d;
    int i7 = arrayOfTabIndicatorLabel.length;
    int i2 = 0;
    int i1 = 0;
    while (i2 < i7)
    {
      TabIndicatorLabel localTabIndicatorLabel = arrayOfTabIndicatorLabel[i2];
      if (localTabIndicatorLabel.getVisibility() == 8)
      {
        i2 += 1;
      }
      else
      {
        LayoutParams localLayoutParams = (LayoutParams)localTabIndicatorLabel.getLayoutParams();
        yl localyl;
        float f1;
        if (localLayoutParams != null)
        {
          localyl = yk.a(i1, i3, i4 - i5, this.l);
          localLayoutParams.bottomMargin = (localyl.b - localTabIndicatorLabel.getMeasuredHeight() / 2 + this.p + i6);
          if (!this.l)
            break label244;
          localLayoutParams.leftMargin = (localyl.a - localTabIndicatorLabel.getMeasuredWidth() / 2 + this.p + i6);
          if (i1 != 1)
            break label222;
          f1 = -45.0F;
        }
        while (true)
        {
          localTabIndicatorLabel.setDegree(f1);
          i1 += 1;
          break;
          label222: if (i1 == 2)
            f1 = -15.0F + f2;
          else
            f1 = -75.0F - f2;
        }
        label244: localLayoutParams.rightMargin = (-localyl.a - localTabIndicatorLabel.getMeasuredWidth() / 2 + this.p + i6);
        if (i1 == 1)
          f1 = 45.0F;
        while (true)
        {
          localTabIndicatorLabel.setDegree(f1);
          break;
          if (i1 == 2)
            f1 = 15.0F - f2;
          else
            f1 = 75.0F + f2;
        }
      }
    }
  }

  private void j()
  {
    yl localyl = new yl((int)this.r, (int)this.s, this, this.l);
    float f1 = localyl.a();
    if (f1 < this.g.getTabSectorInnerSize())
    {
      this.b.getHitRect(this.m);
      if ((this.s > this.m.top) && (((this.l) && (this.r < this.m.right)) || ((!this.l) && (this.r > this.m.left) && (!this.h.c()))))
      {
        vy.a(getContext(), "CQ", "1");
        this.g.c(true);
      }
    }
    do
    {
      do
        return;
      while (f1 > this.g.getTabSectorOuterSize());
      this.k = a(localyl);
    }
    while ((this.k == -1) || (this.k >= this.n) || (this.k == this.j));
    int i1 = this.j;
    this.h.a(i1, this.k);
    a(this.k, true, true);
  }

  private void setTabTextVisibility(int paramInt)
  {
    TabIndicatorLabel[] arrayOfTabIndicatorLabel = this.d;
    int i2 = arrayOfTabIndicatorLabel.length;
    int i1 = 0;
    if (i1 < i2)
    {
      TabIndicatorLabel localTabIndicatorLabel = arrayOfTabIndicatorLabel[i1];
      if (!localTabIndicatorLabel.isEnabled());
      while (true)
      {
        i1 += 1;
        break;
        localTabIndicatorLabel.setVisibility(paramInt);
      }
    }
  }

  void a()
  {
    a(-1);
  }

  void a(int paramInt)
  {
    if (paramInt >= 0)
      a(paramInt, true);
    this.i = true;
    if (yb.v())
    {
      setTabTextVisibility(0);
      a(this.j, false);
      e();
    }
    while (true)
    {
      ((TabSectorBg)this.g.getTabSectorBg()).a();
      return;
      Animation localAnimation = yd.b(this.l);
      localAnimation.setAnimationListener(this);
      startAnimation(localAnimation);
      auu.a("[Pop startAnimation]");
    }
  }

  void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }

  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    final float f2 = 0.0F;
    float f1 = 0.0F;
    Object localObject;
    ImageView localImageView;
    if (paramBoolean1)
    {
      f2 = b(paramInt);
      if (this.c.getVisibility() != 0)
      {
        localObject = this.c.getDrawable();
        if (localObject != null)
        {
          localImageView = this.c;
          if (this.l)
          {
            localImageView.setPivotX(f1);
            this.c.setPivotY(((Drawable)localObject).getIntrinsicHeight());
            this.c.setVisibility(0);
          }
        }
        else
        {
          setIndicatorDegree(f2);
          c();
        }
      }
      while (true)
      {
        this.j = paramInt;
        return;
        f1 = ((Drawable)localObject).getIntrinsicWidth();
        break;
        setIndicatorDegree(b(this.j));
        localObject = this.c.animate().rotation(f2);
        if (paramBoolean2)
          asv.b((ViewPropertyAnimator)localObject, new Runnable()
          {
            public void run()
            {
              TabSector.this.setIndicatorDegree(f2);
              TabSector.this.c();
            }
          });
        ((ViewPropertyAnimator)localObject).start();
      }
    }
    if (this.c.getVisibility() != 0)
    {
      localObject = this.c.getDrawable();
      if (localObject != null)
      {
        localImageView = this.c;
        if (!this.l)
          break label267;
        f1 = f2;
        label203: localImageView.setPivotX(f1);
        this.c.setPivotY(((Drawable)localObject).getIntrinsicHeight());
        this.c.setVisibility(0);
      }
    }
    while (true)
    {
      f1 = b(paramInt);
      if (Math.abs(f1 - this.c.getRotation()) <= 0.5F)
        break;
      setIndicatorDegree(f1);
      break;
      label267: f1 = ((Drawable)localObject).getIntrinsicWidth();
      break label203;
      if (this.d[0].getVisibility() == 0)
        this.d[0].invalidate();
      if (this.d[1].getVisibility() == 0)
        this.d[1].invalidate();
      if (this.d[2].getVisibility() == 0)
        this.d[2].invalidate();
    }
  }

  void a(Animator.AnimatorListener paramAnimatorListener)
  {
    this.b.animate().scaleX(1.0F).scaleY(1.0F).setDuration(75L).setListener(paramAnimatorListener).start();
  }

  void a(yb paramyb, SectorArea paramSectorArea)
  {
    this.g = paramyb;
    this.h = paramSectorArea;
    this.o = this.g.getTabSectorOuterSize();
  }

  public boolean a(Canvas paramCanvas)
  {
    try
    {
      draw(paramCanvas);
      return true;
    }
    catch (Exception paramCanvas)
    {
    }
    return false;
  }

  public float b(int paramInt)
  {
    if (yb.getInstance() == null)
      return 0.0F;
    if (this.f != null)
      return this.f[paramInt];
    this.f = new float[3];
    boolean bool = yb.getInstance().n();
    float f2 = (float)(yk.a / 3.0D);
    float[] arrayOfFloat = this.f;
    if (bool)
    {
      f1 = -(60.0F + f2);
      arrayOfFloat[0] = f1;
      arrayOfFloat = this.f;
      if (!bool)
        break label123;
      f1 = -30.0F;
      label84: arrayOfFloat[1] = f1;
      arrayOfFloat = this.f;
      if (!bool)
        break label130;
    }
    label130: for (float f1 = f2; ; f1 = -f2)
    {
      arrayOfFloat[2] = f1;
      return this.f[paramInt];
      f1 = 60.0F + f2;
      break;
      label123: f1 = 30.0F;
      break label84;
    }
  }

  void b()
  {
    this.i = false;
    this.c.animate().cancel();
    Animation localAnimation1 = yd.d(this.l);
    Animation localAnimation2 = yd.d();
    this.b.startAnimation(localAnimation2);
    localAnimation1.setAnimationListener(this);
    startAnimation(localAnimation1);
    ((TabSectorBg)this.g.getTabSectorBg()).b();
  }

  void b(Animator.AnimatorListener paramAnimatorListener)
  {
    this.b.animate().scaleX(0.0F).scaleY(0.0F).setDuration(75L).setListener(paramAnimatorListener).start();
  }

  public void c()
  {
    if (this.d[0].getVisibility() == 0)
      this.d[0].invalidate();
    if (this.d[1].getVisibility() == 0)
      this.d[1].invalidate();
    if (this.d[2].getVisibility() == 0)
      this.d[2].invalidate();
  }

  void d()
  {
    setTabTextVisibility(4);
    this.c.animate().cancel();
  }

  public void e()
  {
    float f1 = this.g.getHandTrackRatio();
    setScaleX(f1);
    setScaleY(f1);
    f1 = atw.a(f1);
    setAlpha(f1);
    this.b.setAlpha(f1);
  }

  public void f()
  {
    setScaleX(1.0F);
    setScaleY(1.0F);
    setAlpha(1.0F);
    this.b.setAlpha(1.0F);
  }

  int getCurrentTabIndex()
  {
    return this.j;
  }

  public float getIndicatorDegree()
  {
    return this.c.getRotation();
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    auu.a("[Pop onAnimationEnd] , pop? " + this.i);
    if (this.i)
    {
      post(new Runnable()
      {
        public void run()
        {
          TabSector.a(TabSector.this, 0);
          TabSector.this.a(TabSector.a(TabSector.this), true);
        }
      });
      return;
    }
    try
    {
      this.g.setVisibility(4);
      label55: post(new Runnable()
      {
        public void run()
        {
          TabSector.b(TabSector.this).c(false);
        }
      });
      return;
    }
    catch (Throwable paramAnimation)
    {
      break label55;
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.i)
    {
      auu.a("[Pop onAnimationStart]");
      this.b.startAnimation(yd.c());
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((ImageView)findViewById(2131755227));
    this.b = findViewById(2131755122);
    this.d[0] = ((TabIndicatorLabel)findViewById(2131755228));
    this.d[1] = ((TabIndicatorLabel)findViewById(2131755229));
    this.d[2] = ((TabIndicatorLabel)findViewById(2131755230));
    this.p = yb.getInstance().getCenterOffset();
    setLayerType(2, null);
    this.b.setLayerType(2, null);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 1:
    default:
      this.q = 0;
    case 0:
    case 2:
    }
    float f1;
    float f2;
    do
    {
      do
      {
        return true;
        this.r = paramMotionEvent.getX();
        this.s = paramMotionEvent.getY();
        this.h.q = true;
        return true;
      }
      while (1 == this.q);
      f1 = Math.abs(paramMotionEvent.getX() - this.r);
      f2 = Math.abs(paramMotionEvent.getY() - this.s);
    }
    while ((f1 <= this.t) && (f2 <= this.t));
    this.q = 1;
    this.u = true;
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(0);
    this.h.g.onTouchEvent(paramMotionEvent);
    return true;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.o, this.o);
    if (this.g != null)
    {
      setMeasuredDimension(getMeasuredWidth(), this.g.getTabSectorOuterSize());
      h();
      g();
      i();
    }
    if (this.l);
    for (float f1 = 0.0F; ; f1 = getMeasuredWidth())
    {
      setPivotX(f1);
      setPivotY(getMeasuredHeight());
      return;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent == null) || (this.g.g()));
    while (true)
    {
      return true;
      if (this.q != 0);
      int i1 = paramMotionEvent.getAction();
      switch (i1 & 0xFF)
      {
      case 3:
      default:
      case 0:
      case 2:
      case 1:
      }
      try
      {
        do
          while (true)
          {
            this.h.g.onTouchEvent(paramMotionEvent);
            if ((3 != i1) && (1 != i1))
              break;
            this.q = 0;
            this.a = false;
            this.h.j();
            return true;
            this.u = false;
            continue;
            float f1 = Math.abs(paramMotionEvent.getX() - this.r);
            float f2 = Math.abs(paramMotionEvent.getY() - this.s);
            if ((f1 > this.t) || (f2 > this.t))
              this.u = true;
          }
        while (this.u);
        j();
        return true;
      }
      catch (Throwable paramMotionEvent)
      {
        while (true)
          asp.b("Swipe.TabSector", "Exception in GestureDetector.onTouchEvent: " + paramMotionEvent.getMessage());
      }
    }
  }

  void setDirection(boolean paramBoolean)
  {
    this.l = paramBoolean;
    Object localObject = this.g.getTabs();
    this.n = localObject.length;
    int i1 = 0;
    if (i1 < this.d.length)
    {
      if (i1 < localObject.length)
        this.d[i1].setText(localObject[i1].a(getContext()));
      while (true)
      {
        i1 += 1;
        break;
        this.d[i1].setVisibility(8);
        this.d[i1].setEnabled(false);
      }
    }
    this.e = new float[localObject.length - 1];
    i1 = 0;
    while (i1 < this.e.length)
    {
      this.e[i1] = ((float)Math.tan(1.570796326794897D * (localObject.length - i1 - 1) / localObject.length));
      i1 += 1;
    }
    yb.a(this.b, paramBoolean);
    yb.a(this.d[0], paramBoolean);
    yb.a(this.d[1], paramBoolean);
    yb.a(this.d[2], paramBoolean);
    yb.a(this.c, paramBoolean);
    localObject = getContext().getResources();
    ((Resources)localObject).getDimension(2131296345);
    ((Resources)localObject).getDimension(2131296346);
    localObject = ahx.b(getContext()).c(getContext(), this.g);
    if (paramBoolean)
      this.c.setScaleType(ScaleType.FIT_START);
    setPadding(0, 0, 0, 0);
    if (this.g.getTabCount() > 1)
    {
      this.c.setImageDrawable((Drawable)localObject);
      return;
    }
    this.c.setVisibility(8);
  }

  public void setIndicatorDegree(float paramFloat)
  {
    int i1 = 0;
    if (this.c.getDrawable() != null)
      this.c.setRotation(paramFloat);
    if (!this.d[0].b())
      return;
    int i2 = this.g.getTabCount();
    float f1 = (float)(yk.b / i2) / 2.0F;
    label54: float f2;
    if (i1 < i2)
    {
      f2 = Math.abs(b(i1) - paramFloat);
      if (f2 <= f1)
        break label98;
      this.d[i1].a();
    }
    while (true)
    {
      i1 += 1;
      break label54;
      break;
      label98: f2 /= f1;
      this.d[i1].setHighLightRatio(1.0F - f2);
    }
  }

  void setTab(int paramInt)
  {
    a(paramInt, false);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.TabSector
 * JD-Core Version:    0.6.2
 */