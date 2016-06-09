package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;

public class axv extends FrameLayout
{
  private int a;
  private View b;
  private axw c;
  private int d;
  private int e = 0;
  private GestureDetector f;
  private OnGestureListener g;
  private boolean h;
  private int i = b(15);
  private int j = -b(500);
  private Scroller k;
  private Scroller l;
  private int m;
  private int n;
  private Interpolator o;
  private Interpolator p;

  public axv(View paramView, axw paramaxw, Interpolator paramInterpolator1, Interpolator paramInterpolator2)
  {
    super(paramView.getContext());
    this.o = paramInterpolator1;
    this.p = paramInterpolator2;
    this.b = paramView;
    this.c = paramaxw;
    this.c.setLayout(this);
    e();
  }

  private void a(int paramInt)
  {
    int i1;
    if (Math.signum(paramInt) != this.a)
      i1 = 0;
    while (true)
    {
      this.b.layout(-i1, this.b.getTop(), this.b.getWidth() - i1, getMeasuredHeight());
      if (this.a != 1)
        break;
      this.c.layout(this.b.getWidth() - i1, this.c.getTop(), this.b.getWidth() + this.c.getWidth() - i1, this.c.getBottom());
      return;
      i1 = paramInt;
      if (Math.abs(paramInt) > this.c.getWidth())
        i1 = this.c.getWidth() * this.a;
    }
    this.c.layout(-this.c.getWidth() - i1, this.c.getTop(), -i1, this.c.getBottom());
  }

  private int b(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
  }

  private void e()
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.g = new SimpleOnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        axv.a(axv.this, false);
        return true;
      }

      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if ((Math.abs(paramAnonymousMotionEvent1.getX() - paramAnonymousMotionEvent2.getX()) > axv.a(axv.this)) && (paramAnonymousFloat1 < axv.b(axv.this)))
          axv.a(axv.this, true);
        return super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
      }
    };
    this.f = new GestureDetector(getContext(), this.g);
    if (this.o != null)
    {
      this.l = new Scroller(getContext(), this.o);
      if (this.p == null)
        break label196;
    }
    label196: for (this.k = new Scroller(getContext(), this.p); ; this.k = new Scroller(getContext()))
    {
      LayoutParams localLayoutParams = new LayoutParams(-1, -2);
      this.b.setLayoutParams(localLayoutParams);
      if (this.b.getId() < 1)
        this.b.setId(1);
      this.c.setId(2);
      this.c.setLayoutParams(new LayoutParams(-2, -2));
      addView(this.b);
      addView(this.c);
      return;
      this.l = new Scroller(getContext());
      break;
    }
  }

  public boolean a()
  {
    return this.e == 1;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    this.f.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    while (true)
    {
      return true;
      this.d = ((int)paramMotionEvent.getX());
      this.h = false;
      continue;
      int i2 = (int)(this.d - paramMotionEvent.getX());
      int i1 = i2;
      if (this.e == 1)
        i1 = i2 + this.c.getWidth() * this.a;
      a(i1);
      continue;
      if (((!this.h) && (Math.abs(this.d - paramMotionEvent.getX()) <= this.c.getWidth() / 2)) || (Math.signum(this.d - paramMotionEvent.getX()) != this.a))
        break;
      c();
    }
    b();
    return false;
  }

  public void b()
  {
    this.e = 0;
    if (this.a == 1)
    {
      this.m = (-this.b.getLeft());
      this.l.startScroll(0, 0, this.c.getWidth(), 0, 350);
    }
    while (true)
    {
      postInvalidate();
      return;
      this.m = this.c.getRight();
      this.l.startScroll(0, 0, this.c.getWidth(), 0, 350);
    }
  }

  public void c()
  {
    this.e = 1;
    if (this.a == 1)
      this.k.startScroll(-this.b.getLeft(), 0, this.c.getWidth(), 0, 350);
    while (true)
    {
      postInvalidate();
      return;
      this.k.startScroll(this.b.getLeft(), 0, this.c.getWidth(), 0, 350);
    }
  }

  public void computeScroll()
  {
    if (this.e == 1)
      if (this.k.computeScrollOffset())
      {
        a(this.k.getCurrX() * this.a);
        postInvalidate();
      }
    while (!this.l.computeScrollOffset())
      return;
    a((this.m - this.l.getCurrX()) * this.a);
    postInvalidate();
  }

  public void d()
  {
    if (this.l.computeScrollOffset())
      this.l.abortAnimation();
    if (this.e == 1)
    {
      this.e = 0;
      a(0);
    }
  }

  public View getContentView()
  {
    return this.b;
  }

  public axw getMenuView()
  {
    return this.c;
  }

  public int getPosition()
  {
    return this.n;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.layout(0, 0, getMeasuredWidth(), this.b.getMeasuredHeight());
    if (this.a == 1)
    {
      this.c.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.c.getMeasuredWidth(), this.b.getMeasuredHeight());
      return;
    }
    this.c.layout(-this.c.getMeasuredWidth(), 0, 0, this.b.getMeasuredHeight());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setMenuHeight(int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)this.c.getLayoutParams();
    if (localLayoutParams.height != paramInt)
    {
      localLayoutParams.height = paramInt;
      this.c.setLayoutParams(this.c.getLayoutParams());
    }
  }

  public void setPosition(int paramInt)
  {
    this.n = paramInt;
    this.c.setPosition(paramInt);
  }

  public void setSwipeDirection(int paramInt)
  {
    this.a = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axv
 * JD-Core Version:    0.6.2
 */