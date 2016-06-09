package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.OverScroller;
import asq;
import avu;

public class MyScrollView extends ViewGroup
{
  private static final String a = MyScrollView.class.getSimpleName();
  private OverScroller b;
  private VelocityTracker c;
  private int d;
  private int e = 0;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n = 0;
  private boolean o = false;
  private int p;
  private int q;
  private int r = 0;
  private avu s;
  private boolean t;

  public MyScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MyScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a()
  {
    if (this.c != null)
    {
      this.c.recycle();
      this.c = null;
    }
    this.e = 0;
    this.o = false;
  }

  private void a(int paramInt)
  {
    if (this.s != null)
      this.s.a(paramInt);
  }

  private void a(Context paramContext)
  {
    this.b = new OverScroller(paramContext);
    paramContext = ViewConfiguration.get(paramContext);
    this.d = paramContext.getScaledTouchSlop();
    this.f = paramContext.getScaledMinimumFlingVelocity();
    this.g = paramContext.getScaledMaximumFlingVelocity();
    this.l = asq.a(16.0F);
    this.m = asq.a(16.0F);
    this.q = asq.a(0.0F);
    setOverScrollMode(0);
    setChildrenDrawingOrderEnabled(true);
  }

  private void a(boolean paramBoolean)
  {
    if (getParent() != null)
      getParent().requestDisallowInterceptTouchEvent(paramBoolean);
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 3;
  }

  private void b()
  {
    if ((!this.t) || (getChildCount() == 0));
    while (true)
    {
      return;
      if (this.r <= getMeasuredHeight());
      for (final int i1 = 0; i1 <= this.p; i1 = this.r - getMeasuredHeight() - this.q)
      {
        post(new Runnable()
        {
          public void run()
          {
            MyScrollView.a(MyScrollView.this, i1);
            MyScrollView.this.requestLayout();
            MyScrollView.this.invalidate();
          }
        });
        return;
      }
    }
  }

  private void b(boolean paramBoolean)
  {
    if (this.s != null)
      if (!paramBoolean)
        break label37;
    label37: for (int i1 = 1; ; i1 = 2)
    {
      this.s.a(i1, this.p, this.p + getHeight());
      return;
    }
  }

  private int getScrollRange()
  {
    return Math.max(this.r - getHeight(), 0);
  }

  public void computeScroll()
  {
    if (this.b.computeScrollOffset())
    {
      i1 = this.b.getCurrY();
      if (i1 != this.p)
      {
        if (i1 < this.p)
        {
          bool = true;
          b(bool);
        }
      }
      else
      {
        scrollTo(0, i1);
        awakenScrollBars();
        postInvalidate();
      }
    }
    while (this.e != 0)
      while (true)
      {
        int i1;
        return;
        boolean bool = false;
      }
    a(0);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (getVisibility() != 0);
    while (((paramMotionEvent.getAction() & 0xFF) != 0) && (this.o))
      return false;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 1:
    default:
      if (this.e == 0)
        break;
    case 0:
    case 2:
    case 3:
    }
    while (true)
    {
      return bool;
      this.i = ((int)paramMotionEvent.getX());
      this.h = ((int)paramMotionEvent.getY());
      this.k = this.i;
      this.j = this.h;
      this.o = false;
      if (this.b.isFinished())
      {
        this.e = 0;
        a(0);
        break;
      }
      this.b.abortAnimation();
      this.e = 1;
      a(1);
      a(true);
      break;
      int i1 = (int)Math.abs(paramMotionEvent.getY() - this.h);
      int i2 = (int)Math.abs(paramMotionEvent.getX() - this.i);
      if ((i1 <= this.d) || (!a(i2, i1)))
        break;
      this.e = 1;
      a(1);
      this.h = ((int)paramMotionEvent.getY());
      a(true);
      break;
      this.e = 0;
      a(0);
      break;
      bool = false;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(0);
      localViewGroup.layout(paramInt1, paramInt2, paramInt3, localViewGroup.getMeasuredHeight() + paramInt2);
      this.r = localViewGroup.getMeasuredHeight();
    }
    b();
    this.t = false;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() > 0)
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(0);
      paramInt2 = getMeasuredHeight();
      LayoutParams localLayoutParams = localViewGroup.getLayoutParams();
      localViewGroup.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 0));
    }
  }

  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.b.isFinished())
    {
      scrollTo(paramInt1, paramInt2);
      if (paramBoolean2)
        this.b.springBack(getScrollX(), this.p, 0, 0, 0, getScrollRange());
    }
    while (true)
    {
      awakenScrollBars();
      return;
      scrollTo(paramInt1, paramInt2);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getVisibility() != 0)
      return false;
    if (this.c == null)
      this.c = VelocityTracker.obtain();
    this.c.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      return true;
      this.i = ((int)paramMotionEvent.getX());
      this.h = ((int)paramMotionEvent.getY());
      this.k = this.i;
      this.j = this.h;
      if (!this.b.isFinished())
      {
        this.b.abortAnimation();
        continue;
        int i1 = (int)paramMotionEvent.getX();
        i1 = (int)paramMotionEvent.getY();
        int i2;
        int i3;
        if (this.e == 0)
        {
          i2 = Math.abs(i1 - this.h);
          i3 = (int)Math.abs(paramMotionEvent.getX() - this.i);
          if ((i2 > this.d) && (a(i3, i2)))
          {
            this.e = 1;
            a(1);
            this.h = i1;
            a(true);
          }
        }
        if (this.e == 1)
        {
          i2 = i1 - this.h;
          i3 = this.p;
          if (i2 > 0)
          {
            b(true);
            if (overScrollBy(0, -i2, 0, this.p, 0, getScrollRange(), 0, 0, true))
              this.c.clear();
          }
          while (true)
          {
            this.h = i1;
            break;
            if (i2 < 0)
            {
              b(false);
              if (overScrollBy(0, -i2, 0, this.p, 0, getScrollRange(), 0, 0, true))
                this.c.clear();
            }
          }
          if (this.e == 1)
          {
            paramMotionEvent = this.c;
            paramMotionEvent.computeCurrentVelocity(1000, this.g);
            float f1 = paramMotionEvent.getYVelocity();
            i1 = getScrollRange();
            if (Math.abs(f1) > this.f)
            {
              this.b.fling(0, this.p, 0, (int)-f1, 0, 0, 0, i1, 0, this.m);
              a(2);
              invalidate();
            }
          }
          while (true)
          {
            a();
            break;
            if (this.b.springBack(0, this.p, 0, 0, 0, i1))
              invalidate();
            a(0);
            continue;
            if (this.e != 0);
          }
          if (this.e == 1)
          {
            if (this.b.springBack(0, this.p, 0, 0, 0, getScrollRange()))
              invalidate();
            a(0);
          }
          a();
        }
      }
    }
  }

  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (this.p == paramInt2)
      return;
    super.scrollTo(paramInt1, paramInt2);
    this.p = paramInt2;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.MyScrollView
 * JD-Core Version:    0.6.2
 */