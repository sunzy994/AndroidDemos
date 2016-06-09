package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import asp;
import asq;
import avj;
import avk;
import avl;
import avm;
import avn;
import avo;
import java.util.Iterator;
import java.util.LinkedList;
import vl;

public class GridGallery extends AdapterView<BaseAdapter>
{
  private boolean A = true;
  private boolean B = true;
  private int C = 0;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private VelocityTracker I;
  private int J;
  private boolean K = false;
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private final int[] d = { 1, 1, 1 };
  private BaseAdapter e;
  private avk f;
  private int g;
  private final LinkedList<View> h = new LinkedList();
  private final LinkedList<View> i = new LinkedList();
  private final boolean[] j = new boolean[1];
  private int k;
  private int l;
  private int m = 1;
  private int n = 0;
  private int o = 0;
  private int p = -1;
  private int q = 0;
  private int r = 0;
  private boolean s = false;
  private final avo t = new avo(this);
  private avl u;
  private avm v;
  private avn w;
  private int x = 0;
  private boolean y = false;
  private final int z;

  public GridGallery(Context paramContext)
  {
    this(paramContext, null);
  }

  public GridGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GridGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusableInTouchMode(true);
    setWillNotDraw(false);
    setAlwaysDrawnWithCacheEnabled(false);
    setHorizontalScrollBarEnabled(true);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, vl.GridGallery, paramInt, 0);
    this.m = paramAttributeSet.getInt(3, this.m);
    paramInt = paramAttributeSet.getInt(0, 1);
    int i1 = paramAttributeSet.getInt(1, 1);
    this.a = paramAttributeSet.getDimensionPixelSize(2, this.a);
    if (paramAttributeSet.getInt(4, 0) == 0);
    while (true)
    {
      this.A = bool;
      paramAttributeSet.recycle();
      a(i1, paramInt);
      this.b = this.a;
      a(paramContext);
      setClipToPadding(false);
      this.z = asq.a(20.0F);
      return;
      bool = false;
    }
  }

  private View a(int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    View localView1 = (View)this.i.poll();
    if (localView1 != null)
    {
      View localView2 = this.e.getView(paramInt, localView1, this);
      if (localView2 != localView1)
        this.i.add(localView1);
      while (true)
      {
        return localView2;
        paramArrayOfBoolean[0] = true;
      }
    }
    return this.e.getView(paramInt, null, this);
  }

  private void a(int paramInt)
  {
    if (paramInt == 0);
    label50: float f1;
    label148: label160: 
    do
    {
      do
      {
        return;
        int i1;
        int i2;
        if (paramInt > 0)
        {
          i1 = paramInt;
          if (this.c > 0)
          {
            i1 = paramInt;
            if (this.o == 0)
              i1 = paramInt / 2;
          }
          i2 = getChildCount();
          if (!awakenScrollBars())
            invalidate();
          paramInt = 0;
          if (paramInt >= i2)
            break label160;
          if (!this.A)
            break label148;
          getChildAt(paramInt).offsetLeftAndRight(i1);
        }
        while (true)
        {
          paramInt += 1;
          break label50;
          int i3 = -this.c;
          int i4 = this.o;
          if (this.A);
          for (i2 = getWidth(); ; i2 = getHeight())
          {
            i1 = paramInt;
            if (i3 <= i2 * i4)
              break;
            i1 = paramInt;
            if (this.o != this.n - 1)
              break;
            i1 = paramInt / 2;
            break;
          }
          getChildAt(paramInt).offsetTopAndBottom(i1);
        }
        this.c += i1;
      }
      while (this.v == null);
      if (this.A);
      for (f1 = getWidth(); ; f1 = getHeight())
      {
        f1 = -((this.c + this.o * f1) / f1);
        this.v.a(getCurrentScreen(), f1);
        if ((this.r != this.e.getCount() - 1) || (f1 <= 0.0F))
          break;
        this.v.b(true);
        return;
      }
    }
    while ((this.r != 0) || (f1 >= 0.0F));
    this.v.b(false);
  }

  private void a(int paramInt, float paramFloat)
  {
    paramInt = Math.max(0, Math.min(paramInt, this.n - 1));
    this.p = paramInt;
    int i1 = this.c;
    int i2 = -paramInt;
    if (this.A);
    for (paramInt = getWidth(); ; paramInt = getHeight())
    {
      int i3 = this.c;
      this.t.a(i1, paramInt * i2 - i3, paramFloat);
      e();
      return;
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (paramInt == -1)
      i1 = getChildCount() - 1;
    View localView = getChildAt(i1);
    if (localView == null)
      return;
    int i3 = localView.getMeasuredWidth();
    int i4 = localView.getMeasuredHeight();
    paramInt = i1 / this.d[2];
    int i2;
    if (this.A)
    {
      i2 = this.c + getPaddingLeft() + this.k / 2 + i1 % this.d[1] * (this.a + this.k) + paramInt * getWidth();
      if (this.d[0] == 1)
      {
        paramInt = (getMeasuredHeight() - this.l - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop() + i4 / 2;
        i1 = i2;
      }
    }
    while (true)
    {
      if ((paramBoolean) && (localView.isLayoutRequested()))
        localView.measure(MeasureSpec.makeMeasureSpec(i3, 1073741824), MeasureSpec.makeMeasureSpec(i4, 1073741824));
      localView.layout(i1 - i3 / 2, paramInt - i4 / 2, i1 + i3 / 2, paramInt + i4 / 2);
      return;
      paramInt = getPaddingTop() + this.l / 2 + i1 % this.d[2] / this.d[1] * (this.l + this.b);
      i1 = i2;
      continue;
      i2 = this.c;
      int i5 = getPaddingTop();
      int i6 = this.l / 2;
      int i7 = this.d[1];
      int i8 = this.b;
      int i9 = this.l;
      paramInt = paramInt * getHeight() + (i2 + i5 + i6 + i1 % i7 * (i8 + i9));
      if (this.d[1] == 1)
        i1 = (getMeasuredWidth() - this.k - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft() + i3 / 2;
      else
        i1 = getPaddingLeft() + this.k / 2 + i1 % this.d[2] / this.d[0] * (this.k + this.a);
    }
  }

  private void a(Context paramContext)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.D = paramContext.getScaledTouchSlop();
    this.F = paramContext.getScaledMinimumFlingVelocity();
    this.E = paramContext.getScaledMaximumFlingVelocity();
  }

  private void a(MotionEvent paramMotionEvent)
  {
    a(false);
    c(paramMotionEvent);
    this.G = ((int)paramMotionEvent.getX());
    this.H = ((int)paramMotionEvent.getY());
    if (this.t.b())
    {
      this.C = 0;
      return;
    }
    this.t.a();
    this.C = 1;
  }

  private void a(View paramView)
  {
    paramView = (avj)paramView.getLayoutParams();
    if (paramView != null)
      paramView.a = true;
  }

  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    avj localavj2 = (avj)paramView.getLayoutParams();
    avj localavj1 = localavj2;
    if (localavj2 == null)
      localavj1 = b();
    if (localavj1.a)
      attachViewToParent(paramView, paramInt, localavj1);
    while (true)
    {
      if ((!paramBoolean) || (paramView.isLayoutRequested()))
        paramView.measure(getChildMeasureSpec(MeasureSpec.makeMeasureSpec(this.k, 1073741824), 0, localavj1.width), getChildMeasureSpec(MeasureSpec.makeMeasureSpec(this.l, 1073741824), 0, localavj1.height));
      a(paramInt, false);
      return;
      addViewInLayout(paramView, paramInt, localavj1);
    }
  }

  private View b(int paramInt1, int paramInt2)
  {
    View localView = a(paramInt1, this.j);
    a(localView, paramInt2, this.j[0]);
    return localView;
  }

  private void b(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    d(paramMotionEvent);
    if (this.C != 1)
    {
      if (((this.A) && (Math.abs(i1 - this.G) > this.D)) || ((!this.A) && (Math.abs(i2 - this.H) > this.D)))
      {
        this.C = 1;
        this.G = i1;
        this.H = i2;
        c(true);
      }
      return;
    }
    if (!g())
    {
      if (!this.A)
        break label127;
      a(i1 - this.G);
    }
    while (true)
    {
      this.G = i1;
      this.H = i2;
      return;
      label127: a(i2 - this.H);
    }
  }

  private void b(boolean paramBoolean)
  {
    this.p = -1;
    if ((paramBoolean) && (this.u != null))
      this.u.b(this.r);
    a(true);
  }

  private void c()
  {
    VelocityTracker localVelocityTracker = this.I;
    this.I = null;
    f();
    localVelocityTracker.computeCurrentVelocity(1000, this.E);
    if (this.A);
    for (float f1 = localVelocityTracker.getXVelocity(); ; f1 = localVelocityTracker.getYVelocity())
    {
      localVelocityTracker.recycle();
      if (!g())
      {
        if (f1 <= this.F)
          break;
        a(this.o - 1, f1);
      }
      return;
    }
    if (f1 < -this.F)
    {
      a(this.o + 1, f1);
      return;
    }
    d();
  }

  private void c(MotionEvent paramMotionEvent)
  {
    if (!this.K)
      return;
    this.J = -1;
  }

  private void c(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
  }

  private void d()
  {
    if (this.A);
    for (int i1 = getWidth(); ; i1 = getHeight())
    {
      a((-this.c + i1 / 2) / i1, 0.0F);
      return;
    }
  }

  private void d(MotionEvent paramMotionEvent)
  {
    int i2 = 1;
    int i1 = 1;
    if (!this.K);
    do
    {
      do
      {
        int i3;
        int i4;
        do
        {
          return;
          if (this.J >= 0)
            break;
          i3 = (int)Math.abs(paramMotionEvent.getY() - this.H);
          i4 = (int)Math.abs(paramMotionEvent.getX() - this.G);
        }
        while ((i4 <= this.D) && (i3 <= this.D));
        if ((!this.A) && (i4 > this.D) && (i4 > i3))
        {
          if (this.G > paramMotionEvent.getX());
          while (true)
          {
            this.J = i1;
            return;
            i1 = 2;
          }
        }
        if ((this.A) && (i3 > this.D) && (i3 > i4))
        {
          if (this.H > paramMotionEvent.getY());
          for (i1 = i2; ; i1 = 2)
          {
            this.J = i1;
            return;
          }
        }
        this.J = 0;
        return;
      }
      while (this.J <= 0);
      if ((this.J == 1) && (((!this.A) && (paramMotionEvent.getX() > this.G)) || ((this.A) && (paramMotionEvent.getY() > this.H))))
      {
        this.J = 0;
        return;
      }
    }
    while ((this.J != 2) || (((this.A) || (paramMotionEvent.getX() >= this.G)) && ((!this.A) || (paramMotionEvent.getY() >= this.H))));
    this.J = 0;
  }

  private void e()
  {
    if (this.p == -1);
    for (int i1 = 0; ; i1 = this.p - this.o)
    {
      if ((i1 != 0) && (this.u != null))
        this.u.a(i1 + this.r);
      return;
    }
  }

  private void f()
  {
    if (!this.K);
  }

  private boolean g()
  {
    return (this.K) && (this.J > 0);
  }

  public avj a(AttributeSet paramAttributeSet)
  {
    return new avj(this, getContext(), paramAttributeSet);
  }

  protected avj a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new avj(this, paramLayoutParams);
  }

  public void a()
  {
    int i4 = 0;
    if (this.p == -1);
    for (int i2 = 0; i2 == 0; i2 = this.p - this.o)
    {
      b(false);
      return;
    }
    int i1 = this.d[2];
    if (this.A);
    int i6;
    for (int i3 = getWidth(); ; i3 = getHeight())
    {
      i6 = getChildCount();
      if (i2 >= 0)
        break label332;
      this.o -= 1;
      this.r -= 1;
      if (this.n - 1 - this.o <= this.m)
        break label193;
      i5 = (this.o + this.m + 1) * i1;
      i6 = Math.min(i1, i6 - i5);
      i2 = i6 - 1;
      while (i2 >= 0)
      {
        a((View)this.h.removeLast(), false);
        i2 -= 1;
      }
    }
    if (i6 > 0)
      detachViewsFromParent(i5, i6);
    this.n -= 1;
    label193: int i5 = this.r - this.o;
    Object localObject;
    if (i5 == 0)
    {
      localObject = this.i.iterator();
      while (true)
      {
        i3 = i1;
        if (!((Iterator)localObject).hasNext())
          break;
        removeDetachedView((View)((Iterator)localObject).next(), false);
      }
    }
    this.c -= i3;
    i2 = i4;
    while (i2 < i1)
    {
      localObject = b((i5 - 1) * i1 + i2, i2);
      this.h.addFirst(localObject);
      i2 += 1;
    }
    this.o += 1;
    i3 = i1;
    this.n = ((getChildCount() - 1) / i3 + 1);
    invalidate();
    b(true);
    return;
    label332: this.o += 1;
    this.r += 1;
    i2 = i1;
    if (this.o > this.m)
    {
      i2 = 0;
      while ((i2 < i1) && (this.h.size() > 0))
      {
        a((View)this.h.removeFirst(), false);
        i2 += 1;
      }
      if (i2 <= 0)
        break label576;
      detachViewsFromParent(0, i2);
      i1 = i2;
    }
    label576: 
    while (true)
    {
      this.o -= 1;
      this.n -= 1;
      this.c = (i3 + this.c);
      i2 = i1;
      if (this.q - this.r - (this.n - this.o) <= 0)
      {
        localObject = this.i.iterator();
        while (true)
        {
          i3 = i2;
          if (!((Iterator)localObject).hasNext())
            break;
          removeDetachedView((View)((Iterator)localObject).next(), false);
        }
      }
      i1 = (this.r + this.m) * i2;
      i5 = Math.min(this.e.getCount() - i1, i2);
      i4 = 0;
      while (true)
      {
        i3 = i2;
        if (i4 >= i5)
          break;
        localObject = b(i1, -1);
        this.h.addLast(localObject);
        i4 += 1;
        i1 += 1;
      }
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1))
      return;
    if (this.d[0] != paramInt1)
      this.d[0] = paramInt1;
    for (paramInt1 = 1; ; paramInt1 = 0)
    {
      if (this.d[1] != paramInt2)
      {
        this.d[1] = paramInt2;
        paramInt1 = 1;
      }
      if (paramInt1 == 0)
        break;
      this.d[2] = (this.d[0] * this.d[1]);
      while (true)
      {
        View localView = (View)this.h.poll();
        if (localView == null)
        {
          detachAllViewsFromParent();
          this.s = true;
          requestLayout();
          return;
        }
        a(localView, true);
      }
    }
  }

  public void a(View paramView, boolean paramBoolean)
  {
    a(paramView);
    if (paramBoolean)
      paramView.forceLayout();
    this.i.add(paramView);
    if (this.w != null)
      this.w.a(paramView);
  }

  protected void a(boolean paramBoolean)
  {
    if (this.B != paramBoolean)
    {
      this.B = paramBoolean;
      if (this.v != null)
        this.v.a(paramBoolean);
    }
  }

  protected avj b()
  {
    return new avj(this, -1, -1);
  }

  protected boolean canAnimate()
  {
    return (getLayoutAnimation() != null) && (this.g > 0);
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof avj;
  }

  protected int computeHorizontalScrollExtent()
  {
    return getWidth();
  }

  protected int computeHorizontalScrollOffset()
  {
    if (this.q == 1);
    int i1;
    do
    {
      return 0;
      i1 = this.r * getWidth() - this.o * getWidth() - this.c;
    }
    while (i1 < 0);
    return i1;
  }

  protected int computeHorizontalScrollRange()
  {
    int i1 = this.q * getWidth();
    if (this.q == 1);
    do
    {
      return i1;
      if ((this.r == 0) && (this.c > 0))
        return i1 + (this.c - this.o * getWidth());
    }
    while ((this.r != this.q - 1) || (this.c >= -this.o * getWidth()));
    return i1 + (-this.c - this.o * getWidth());
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  public BaseAdapter getAdapter()
  {
    return this.e;
  }

  public int getChildWidth()
  {
    return this.k;
  }

  public int getCount()
  {
    if (this.e == null)
      return 0;
    return this.e.getCount();
  }

  public int getCurrentScreen()
  {
    return this.r;
  }

  public int getScreenCount()
  {
    return this.q;
  }

  public View getSelectedView()
  {
    return null;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
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
      if (this.C != 0)
        bool = true;
      return bool;
      a(paramMotionEvent);
      continue;
      b(paramMotionEvent);
      continue;
      this.C = 0;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.s)
    {
      paramBoolean = true;
      if (!this.s)
        break label353;
      this.s = false;
      paramInt4 = this.g;
      this.q = ((paramInt4 - 1) / this.d[2] + 1);
      paramInt3 = this.r;
      this.r = Math.max(0, Math.min(this.r, this.q - 1));
      if (this.r <= this.m)
        break label230;
      paramInt1 = this.m;
      label101: i1 = -paramInt1;
      if (!this.A)
        break label238;
    }
    label230: label238: for (paramInt2 = getWidth(); ; paramInt2 = getHeight())
    {
      this.c = (paramInt2 * i1);
      paramInt2 = (this.r - paramInt1) * this.d[2];
      this.n = (Math.min(this.q - 1 - this.r, this.m) + paramInt1 + 1);
      this.o = paramInt1;
      paramInt4 = Math.min(this.d[2] * this.n, paramInt4 - paramInt2);
      paramInt1 = 0;
      while (paramInt1 < paramInt4)
      {
        localObject = b(paramInt2 + paramInt1, -1);
        this.h.add(localObject);
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      paramInt1 = this.r;
      break label101;
    }
    Object localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext())
      removeDetachedView((View)((Iterator)localObject).next(), false);
    paramInt1 = (this.m * 2 + 1) * this.d[2] - (this.i.size() - this.h.size());
    while (paramInt1 > 0)
    {
      this.i.poll();
      paramInt1 -= 1;
    }
    if (paramInt3 != this.r)
      b(true);
    invalidate();
    while (true)
    {
      return;
      label353: paramInt2 = getChildCount();
      if (paramInt2 != 0)
      {
        paramInt1 = i1;
        while (paramInt1 < paramInt2)
        {
          a(paramInt1, paramBoolean);
          paramInt1 += 1;
        }
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = this.g;
    int i5 = MeasureSpec.getMode(paramInt1);
    int i1 = MeasureSpec.getSize(paramInt1);
    int i4 = MeasureSpec.getMode(paramInt2);
    int i3 = MeasureSpec.getSize(paramInt2);
    if (this.x == 1)
    {
      if ((i5 != 1073741824) || (i4 != 1073741824))
        asp.b("Swipe.GridGallery", "Invalid measure mode for COMPUTE_SPACING: " + i5 + ", " + i4);
      if (this.d[1] != 1)
      {
        this.a = ((i1 - getPaddingLeft() - getPaddingRight() - this.d[1] * this.k) / (this.d[1] - 1));
        if (this.d[0] == 1)
          break label207;
        this.b = ((i3 - getPaddingTop() - getPaddingBottom() - this.d[0] * this.l) / (this.d[0] - 1));
        paramInt2 = i1;
        paramInt1 = i3;
      }
      while (true)
      {
        setMeasuredDimension(paramInt2, paramInt1);
        return;
        this.a = 0;
        break;
        label207: this.b = 0;
        paramInt1 = i3;
        paramInt2 = i1;
      }
    }
    int i2;
    if (this.x == 0)
    {
      if (i5 == 1073741824)
      {
        i2 = i1;
        if (i4 == 1073741824)
          break label732;
      }
      if (i6 == 0)
      {
        super.onMeasure(paramInt1, paramInt2);
        if (i5 != 1073741824)
          i1 = getMeasuredWidth();
        i2 = i1;
        if (i4 == 1073741824)
          break label732;
        paramInt1 = getMeasuredHeight();
        paramInt2 = i1;
      }
    }
    while (true)
    {
      this.k = ((int)((paramInt2 - getPaddingLeft() - getPaddingRight() - (this.d[1] - 1.0F) * this.a) / this.d[1]));
      this.l = ((int)((paramInt1 - getPaddingTop() - getPaddingBottom() - (this.d[0] - 1.0F) * this.b) / this.d[0]));
      break;
      View localView = a(0, this.j);
      avj localavj2 = (avj)localView.getLayoutParams();
      avj localavj1 = localavj2;
      if (localavj2 == null)
      {
        localavj1 = b();
        localView.setLayoutParams(localavj1);
      }
      i6 = getChildMeasureSpec(MeasureSpec.makeMeasureSpec(this.k, 1073741824), 0, localavj1.width);
      if (localavj1.height > 0);
      for (i2 = MeasureSpec.makeMeasureSpec(localavj1.height, 1073741824); ; i2 = MeasureSpec.makeMeasureSpec(0, 0))
      {
        localView.measure(i6, i2);
        if (i5 != 1073741824)
          i1 = resolveSize(localView.getMeasuredWidth() * this.d[1] + (this.d[1] - 1) * this.a + getPaddingLeft() + getPaddingRight(), paramInt1);
        i2 = i1;
        if (i4 == 1073741824)
          break label732;
        paramInt1 = resolveSize(localView.getMeasuredHeight() * this.d[0] + (this.d[0] - 1) * this.b + getPaddingTop() + getPaddingBottom(), paramInt2);
        paramInt2 = i1;
        break;
      }
      paramInt1 = i3;
      paramInt2 = i1;
      if (this.x != 2)
        break;
      if ((i5 != 1073741824) || (i4 != 1073741824))
        asp.b("Swipe.GridGallery", "Invalid measure mode for COMPUTE_PADDING: " + i5 + ", " + i4);
      paramInt1 = (i1 - this.d[1] * this.k - (this.d[1] - 1) * this.a) / 2;
      paramInt2 = (i3 - this.d[0] * this.l - (this.d[0] - 1) * this.b) / 2;
      setPadding(paramInt1, paramInt2, paramInt1, paramInt2);
      paramInt1 = i3;
      paramInt2 = i1;
      break;
      label732: paramInt1 = i3;
      paramInt2 = i2;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.I == null)
        this.I = VelocityTracker.obtain();
      this.I.addMovement(paramMotionEvent);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 0:
        a(paramMotionEvent);
        break;
      case 2:
        b(paramMotionEvent);
        break;
      case 1:
        c();
        break;
      }
      return true;
    }
    catch (Throwable paramMotionEvent)
    {
    }
    return false;
  }

  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    super.removeDetachedView(paramView, paramBoolean);
    paramView = (avj)paramView.getLayoutParams();
    if (paramView != null)
      paramView.a = false;
  }

  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    if (this.e != null)
      this.e.unregisterDataSetObserver(this.f);
    this.e = paramBaseAdapter;
    if (paramBaseAdapter != null)
    {
      if (this.f == null)
        this.f = new avk(this, null);
      paramBaseAdapter.registerDataSetObserver(this.f);
    }
    removeAllViewsInLayout();
    View localView = (View)this.h.poll();
    if (localView == null)
    {
      this.i.clear();
      this.c = 0;
      this.r = 0;
      this.o = 0;
      this.n = 0;
      if (paramBaseAdapter != null)
        break label149;
    }
    label149: for (int i1 = 0; ; i1 = paramBaseAdapter.getCount())
    {
      this.q = ((i1 - 1) / this.d[2] + 1);
      this.g = i1;
      this.s = true;
      requestLayout();
      return;
      this.i.addLast(localView);
      break;
    }
  }

  public void setOnScreenSwitchedListener(avl paramavl)
  {
    this.u = paramavl;
  }

  public void setOnScrollListener(avm paramavm)
  {
    this.v = paramavm;
  }

  public void setOnViewRecycleListener(avn paramavn)
  {
    this.w = paramavn;
  }

  public void setOrientation(boolean paramBoolean)
  {
    this.A = false;
  }

  public void setSelection(int paramInt)
  {
  }

  public void setSideBufferCount(int paramInt)
  {
    this.m = paramInt;
  }

  public void setVerticalPadding(int paramInt)
  {
    setPadding(getPaddingLeft(), paramInt, getPaddingRight(), paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.GridGallery
 * JD-Core Version:    0.6.2
 */