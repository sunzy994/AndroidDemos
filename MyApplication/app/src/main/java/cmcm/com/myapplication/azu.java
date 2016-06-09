package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

public class azu extends ViewGroup
{
  public static boolean a = true;
  private static int d = 1;
  private static byte e = 1;
  private static byte f = 2;
  private static byte g = 4;
  private static byte h = 8;
  private static byte i = 3;
  private MotionEvent A;
  private baa B;
  private int C;
  private long D;
  private bag E;
  private boolean F;
  private boolean G;
  protected final String b;
  protected View c;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private boolean o;
  private View p;
  private azz q;
  private azx r;
  private azw s;
  private int t;
  private int u;
  private byte v;
  private boolean w;
  private int x;
  private boolean y;
  private boolean z;

  public azu(Context paramContext)
  {
    this(paramContext, null);
  }

  public azu(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public azu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    StringBuilder localStringBuilder = new StringBuilder().append("ptr-frame-");
    paramInt = d + 1;
    d = paramInt;
    this.b = paramInt;
    this.j = 0;
    this.k = 0;
    this.l = 200;
    this.m = 1000;
    this.n = true;
    this.o = false;
    this.q = azz.b();
    this.v = 1;
    this.w = false;
    this.x = 0;
    this.y = false;
    this.z = false;
    this.C = 500;
    this.D = 0L;
    this.F = false;
    this.G = false;
    this.E = new bag();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, baf.PtrFrameLayout, 0, 0);
    if (paramContext != null)
    {
      this.j = paramContext.getResourceId(baf.PtrFrameLayout_ptr_header, this.j);
      this.k = paramContext.getResourceId(baf.PtrFrameLayout_ptr_content, this.k);
      this.E.a(paramContext.getFloat(baf.PtrFrameLayout_ptr_resistance, this.E.b()));
      this.l = paramContext.getInt(baf.PtrFrameLayout_ptr_duration_to_close, this.l);
      this.m = paramContext.getInt(baf.PtrFrameLayout_ptr_duration_to_close_header, this.m);
      float f1 = this.E.f();
      f1 = paramContext.getFloat(baf.PtrFrameLayout_ptr_ratio_of_header_height_to_refresh, f1);
      this.E.b(f1);
      this.n = paramContext.getBoolean(baf.PtrFrameLayout_ptr_keep_header_when_refresh, this.n);
      this.o = paramContext.getBoolean(baf.PtrFrameLayout_ptr_pull_to_fresh, this.o);
      paramContext.recycle();
    }
    this.s = new azw(this);
    this.t = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }

  private void a(float paramFloat)
  {
    int i2 = 0;
    if ((paramFloat < 0.0F) && (this.E.t()))
    {
      if (a)
        bah.c(this.b, String.format("has reached the top", new Object[0]));
      return;
    }
    int i1 = this.E.k() + (int)paramFloat;
    if (this.E.f(i1))
    {
      i1 = i2;
      if (a)
      {
        bah.c(this.b, String.format("over top", new Object[0]));
        i1 = i2;
      }
    }
    while (true)
    {
      this.E.b(i1);
      a(i1 - this.E.j());
      return;
    }
  }

  private void a(int paramInt)
  {
    if (paramInt == 0)
      return;
    boolean bool = this.E.a();
    if ((bool) && (!this.F) && (this.E.s()))
    {
      this.F = true;
      t();
    }
    if (((this.E.p()) && (this.v == 1)) || ((this.E.e()) && (this.v == 4) && (f())))
    {
      this.v = 2;
      this.q.b(this);
      if (a)
        bah.c(this.b, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", new Object[]{Integer.valueOf(this.x)});
    }
    if (this.E.q())
    {
      p();
      if (bool)
        u();
    }
    if (this.v == 2)
    {
      if ((bool) && (!e()) && (this.o) && (this.E.u()))
        n();
      if ((s()) && (this.E.v()))
        n();
    }
    if (a)
      bah.a(this.b, "updatePos: change: %s, current: %s last: %s, top: %s, headerHeight: %s", new Object[]{Integer.valueOf(paramInt), Integer.valueOf(this.E.k()), Integer.valueOf(this.E.j()), Integer.valueOf(this.c.getTop()), Integer.valueOf(this.u)});
    this.p.offsetTopAndBottom(paramInt);
    if (!g())
      this.c.offsetTopAndBottom(paramInt);
    invalidate();
    if (this.q.a())
      this.q.a(this, bool, this.v, this.E);
    a(bool, this.v, this.E);
  }

  private void a(View paramView, int paramInt1, int paramInt2)
  {
    MarginLayoutParams localMarginLayoutParams = (MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin, localMarginLayoutParams.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin, localMarginLayoutParams.height));
  }

  private void b(boolean paramBoolean)
  {
    n();
    if (this.v == 3)
    {
      if (this.n)
      {
        if ((this.E.w()) && (!paramBoolean))
          this.s.a(this.E.x(), this.l);
        return;
      }
      k();
      return;
    }
    if (this.v == 4)
    {
      c(false);
      return;
    }
    m();
  }

  private void c(boolean paramBoolean)
  {
    if ((this.E.o()) && (!paramBoolean) && (this.B != null))
    {
      if (a)
        bah.a(this.b, "notifyUIRefreshComplete mRefreshCompleteHook run.");
      this.B.a();
      return;
    }
    if (this.q.a())
    {
      if (a)
        bah.b(this.b, "PtrUIHandler: onUIRefreshComplete");
      this.q.d(this);
    }
    this.E.d();
    l();
    p();
  }

  private void i()
  {
    int i1 = this.E.k();
    int i3 = getPaddingLeft();
    int i2 = getPaddingTop();
    MarginLayoutParams localMarginLayoutParams;
    int i4;
    if (this.p != null)
    {
      localMarginLayoutParams = (MarginLayoutParams)this.p.getLayoutParams();
      i4 = localMarginLayoutParams.leftMargin + i3;
      int i5 = localMarginLayoutParams.topMargin + i2 + i1 - this.u;
      int i6 = this.p.getMeasuredWidth() + i4;
      int i7 = this.p.getMeasuredHeight() + i5;
      this.p.layout(i4, i5, i6, i7);
      if (a)
        bah.b(this.b, "onLayout header: %s %s %s %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)});
    }
    if (this.c != null)
    {
      if (g())
        i1 = 0;
      localMarginLayoutParams = (MarginLayoutParams)this.c.getLayoutParams();
      i3 += localMarginLayoutParams.leftMargin;
      i1 = localMarginLayoutParams.topMargin + i2 + i1;
      i2 = this.c.getMeasuredWidth() + i3;
      i4 = this.c.getMeasuredHeight() + i1;
      if (a)
        bah.b(this.b, "onLayout content: %s %s %s %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i4)});
      this.c.layout(i3, i1, i2, i4);
    }
  }

  private void j()
  {
    if (!this.E.a())
      this.s.a(0, this.m);
  }

  private void k()
  {
    j();
  }

  private void l()
  {
    j();
  }

  private void m()
  {
    j();
  }

  private boolean n()
  {
    if (this.v != 2);
    while (((!this.E.w()) || (!e())) && (!this.E.r()))
      return false;
    this.v = 3;
    o();
    return false;
  }

  private void o()
  {
    this.D = System.currentTimeMillis();
    if (this.q.a())
    {
      this.q.c(this);
      if (a)
        bah.b(this.b, "PtrUIHandler: onUIRefreshBegin");
    }
    if (this.r != null)
      this.r.a(this);
  }

  private boolean p()
  {
    if (((this.v == 4) || (this.v == 2)) && (this.E.t()))
    {
      if (this.q.a())
      {
        this.q.a(this);
        if (a)
          bah.b(this.b, "PtrUIHandler: onUIReset");
      }
      this.v = 1;
      r();
      return true;
    }
    return false;
  }

  private void q()
  {
    this.v = 4;
    if ((azw.a(this.s)) && (e()))
    {
      if (a)
        bah.b(this.b, "performRefreshComplete do nothing, scrolling: %s, auto refresh: %s", new Object[]{Boolean.valueOf(azw.a(this.s)), Integer.valueOf(this.x)});
      return;
    }
    c(false);
  }

  private void r()
  {
    this.x &= (i ^ 0xFFFFFFFF);
  }

  private boolean s()
  {
    return (this.x & i) == f;
  }

  private void t()
  {
    if (a)
      bah.a(this.b, "send cancel event");
    if (this.A == null)
      return;
    MotionEvent localMotionEvent = this.A;
    a(MotionEvent.obtain(localMotionEvent.getDownTime(), localMotionEvent.getEventTime() + ViewConfiguration.getLongPressTimeout(), 3, localMotionEvent.getX(), localMotionEvent.getY(), localMotionEvent.getMetaState()));
  }

  private void u()
  {
    if (a)
      bah.a(this.b, "send down event");
    MotionEvent localMotionEvent = this.A;
    a(MotionEvent.obtain(localMotionEvent.getDownTime(), localMotionEvent.getEventTime(), 0, localMotionEvent.getX(), localMotionEvent.getY(), localMotionEvent.getMetaState()));
  }

  protected void a()
  {
    if ((this.E.o()) && (e()))
    {
      if (a)
        bah.a(this.b, "call onRelease after scroll abort");
      b(true);
    }
  }

  public void a(azy paramazy)
  {
    azz.a(this.q, paramazy);
  }

  public void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }

  protected void a(boolean paramBoolean, byte paramByte, bag parambag)
  {
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.v != 1)
      return;
    int i2 = this.x;
    if (paramBoolean);
    for (int i1 = e; ; i1 = f)
    {
      this.x = (i1 | i2);
      this.v = 2;
      if (this.q.a())
      {
        this.q.b(this);
        if (a)
          bah.c(this.b, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", new Object[]{Integer.valueOf(this.x)});
      }
      this.s.a(this.E.g(), paramInt);
      if (!paramBoolean)
        break;
      this.v = 3;
      o();
      return;
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  protected void b()
  {
    if ((this.E.o()) && (e()))
    {
      if (a)
        bah.a(this.b, "call onRelease after scroll finish");
      b(true);
    }
  }

  public final void c()
  {
    if (a)
      bah.b(this.b, "refreshComplete");
    if (this.B != null)
      this.B.b();
    int i1 = (int)(this.C - (System.currentTimeMillis() - this.D));
    if (i1 <= 0)
    {
      if (a)
        bah.a(this.b, "performRefreshComplete at once");
      q();
    }
    do
    {
      return;
      postDelayed(new Runnable()
      {
        public void run()
        {
          azu.a(azu.this);
        }
      }
      , i1);
    }
    while (!a);
    bah.b(this.b, "performRefreshComplete after delay: %s", new Object[]{Integer.valueOf(i1)});
  }

  protected boolean checkLayoutParams(LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof azv;
  }

  public void d()
  {
    a(true, this.m);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isEnabled()) || (this.c == null) || (this.p == null))
      return a(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 1:
    case 3:
    case 0:
    case 2:
    }
    float f1;
    boolean bool1;
    boolean bool2;
    label369: boolean bool4;
    label527: label533: label539: 
    do
    {
      return a(paramMotionEvent);
      this.E.c();
      if (this.E.o())
      {
        if (a)
          bah.a(this.b, "call onRelease when user release");
        b(false);
        if (this.E.s())
        {
          t();
          return true;
        }
        return a(paramMotionEvent);
      }
      return a(paramMotionEvent);
      this.F = false;
      this.E.a(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.s.a();
      this.y = false;
      this.z = false;
      this.G = false;
      a(paramMotionEvent);
      return true;
      this.A = paramMotionEvent;
      this.E.b(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.E.h();
      f1 = this.E.i();
      if (!this.z)
      {
        float f2 = this.E.l();
        float f3 = this.E.m();
        if ((Math.abs(f2) > this.t) || (Math.abs(f3) > this.t))
        {
          if ((this.w) && (Math.abs(f2) > this.t) && (Math.abs(f2) > Math.abs(f3)) && (this.E.t()))
            this.y = true;
          this.z = true;
        }
      }
      if ((this.y) || ((this.G) && (!this.E.o())))
        return a(paramMotionEvent);
      if (f1 > 0.0F)
      {
        bool1 = true;
        if (bool1)
          break label527;
        bool2 = true;
        bool4 = this.E.o();
        if (a)
          if ((this.r == null) || (!this.r.a(this, this.c, this.p)))
            break label533;
      }
      for (boolean bool3 = true; ; bool3 = false)
      {
        bah.a(this.b, "ACTION_MOVE: offsetY:%s, currentPos: %s, moveUp: %s, canMoveUp: %s, moveDown: %s: canMoveDown: %s", new Object[]{Float.valueOf(f1), Integer.valueOf(this.E.k()), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool3)});
        if ((!bool1) || (this.r == null) || (this.r.a(this, this.c, this.p)))
          break label539;
        return a(paramMotionEvent);
        bool1 = false;
        break;
        bool2 = false;
        break label369;
      }
    }
    while (((!bool2) || (!bool4)) && (!bool1));
    a(f1);
    return true;
  }

  public boolean e()
  {
    return (this.x & i) > 0;
  }

  public boolean f()
  {
    return (this.x & g) > 0;
  }

  public boolean g()
  {
    return (this.x & h) > 0;
  }

  protected LayoutParams generateDefaultLayoutParams()
  {
    return new azv(-1, -1);
  }

  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new azv(getContext(), paramAttributeSet);
  }

  protected LayoutParams generateLayoutParams(LayoutParams paramLayoutParams)
  {
    return new azv(paramLayoutParams);
  }

  public View getContentView()
  {
    return this.c;
  }

  public float getDurationToClose()
  {
    return this.l;
  }

  public long getDurationToCloseHeader()
  {
    return this.m;
  }

  public int getHeaderHeight()
  {
    return this.u;
  }

  public View getHeaderView()
  {
    return this.p;
  }

  public int getOffsetToKeepHeaderWhileLoading()
  {
    return this.E.x();
  }

  public int getOffsetToRefresh()
  {
    return this.E.g();
  }

  public float getRatioOfHeaderToHeightRefresh()
  {
    return this.E.f();
  }

  public float getResistance()
  {
    return this.E.b();
  }

  public boolean h()
  {
    return this.o;
  }

  protected void onFinishInflate()
  {
    int i1 = getChildCount();
    if (i1 > 2)
      throw new IllegalStateException("PtrFrameLayout only can host 2 elements");
    Object localObject1;
    Object localObject2;
    if (i1 == 2)
    {
      if ((this.j != 0) && (this.p == null))
        this.p = findViewById(this.j);
      if ((this.k != 0) && (this.c == null))
        this.c = findViewById(this.k);
      if ((this.c == null) || (this.p == null))
      {
        localObject1 = getChildAt(0);
        localObject2 = getChildAt(1);
        if (!(localObject1 instanceof azy))
          break label140;
        this.p = ((View)localObject1);
        this.c = ((View)localObject2);
      }
    }
    while (true)
    {
      if (this.p != null)
        this.p.bringToFront();
      super.onFinishInflate();
      return;
      label140: if ((localObject2 instanceof azy))
      {
        this.p = ((View)localObject2);
        this.c = ((View)localObject1);
      }
      else if ((this.c == null) && (this.p == null))
      {
        this.p = ((View)localObject1);
        this.c = ((View)localObject2);
      }
      else
      {
        if (this.p == null)
        {
          if (this.c == localObject1);
          while (true)
          {
            this.p = ((View)localObject2);
            break;
            localObject2 = localObject1;
          }
        }
        if (this.p == localObject1);
        while (true)
        {
          this.c = ((View)localObject2);
          break;
          localObject2 = localObject1;
        }
        if (i1 == 1)
        {
          this.c = getChildAt(0);
        }
        else
        {
          localObject1 = new TextView(getContext());
          ((TextView)localObject1).setClickable(true);
          ((TextView)localObject1).setTextColor(-39424);
          ((TextView)localObject1).setGravity(17);
          ((TextView)localObject1).setTextSize(20.0F);
          ((TextView)localObject1).setText("The content view in PtrFrameLayout is empty. Do you forget to specify its id in xml layout file?");
          this.c = ((View)localObject1);
          addView(this.c);
        }
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    i();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (a)
      bah.b(this.b, "onMeasure frame: width: %s, height: %s, padding: %s %s %s %s", new Object[]{Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingRight()), Integer.valueOf(getPaddingTop()), Integer.valueOf(getPaddingBottom())});
    MarginLayoutParams localMarginLayoutParams;
    if (this.p != null)
    {
      measureChildWithMargins(this.p, paramInt1, 0, paramInt2, 0);
      localMarginLayoutParams = (MarginLayoutParams)this.p.getLayoutParams();
      int i1 = this.p.getMeasuredHeight();
      int i2 = localMarginLayoutParams.topMargin;
      this.u = (localMarginLayoutParams.bottomMargin + (i1 + i2));
      this.E.c(this.u);
    }
    if (this.c != null)
    {
      a(this.c, paramInt1, paramInt2);
      if (a)
      {
        localMarginLayoutParams = (MarginLayoutParams)this.c.getLayoutParams();
        bah.b(this.b, "onMeasure content, width: %s, height: %s, margin: %s %s %s %s", new Object[]{Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()), Integer.valueOf(localMarginLayoutParams.leftMargin), Integer.valueOf(localMarginLayoutParams.topMargin), Integer.valueOf(localMarginLayoutParams.rightMargin), Integer.valueOf(localMarginLayoutParams.bottomMargin)});
        bah.b(this.b, "onMeasure, currentPos: %s, lastPos: %s, top: %s", new Object[]{Integer.valueOf(this.E.k()), Integer.valueOf(this.E.j()), Integer.valueOf(this.c.getTop())});
      }
    }
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.G = paramBoolean;
  }

  public void setDurationToClose(int paramInt)
  {
    this.l = paramInt;
  }

  public void setDurationToCloseHeader(int paramInt)
  {
    this.m = paramInt;
  }

  public void setEnabledNextPtrAtOnce(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.x |= g;
      return;
    }
    this.x &= (g ^ 0xFFFFFFFF);
  }

  public void setHeaderView(View paramView)
  {
    if ((this.p != null) && (paramView != null) && (this.p != paramView))
      removeView(this.p);
    if (paramView.getLayoutParams() == null)
      paramView.setLayoutParams(new azv(-1, -2));
    this.p = paramView;
    addView(paramView);
  }

  @Deprecated
  public void setInterceptEventWhileWorking(boolean paramBoolean)
  {
  }

  public void setKeepHeaderWhenRefresh(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  public void setLoadingMinTime(int paramInt)
  {
    this.C = paramInt;
  }

  public void setOffsetToKeepHeaderWhileLoading(int paramInt)
  {
    this.E.d(paramInt);
  }

  public void setOffsetToRefresh(int paramInt)
  {
    this.E.a(paramInt);
  }

  public void setPinContent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.x |= h;
      return;
    }
    this.x &= (h ^ 0xFFFFFFFF);
  }

  public void setPtrHandler(azx paramazx)
  {
    this.r = paramazx;
  }

  public void setPtrIndicator(bag parambag)
  {
    if ((this.E != null) && (this.E != parambag))
      parambag.a(this.E);
    this.E = parambag;
  }

  public void setPullToRefresh(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public void setRatioOfHeaderHeightToRefresh(float paramFloat)
  {
    this.E.b(paramFloat);
  }

  public void setRefreshCompleteHook(baa parambaa)
  {
    this.B = parambaa;
    parambaa.b(new Runnable()
    {
      public void run()
      {
        if (azu.a)
          bah.a(azu.this.b, "mRefreshCompleteHook resume.");
        azu.a(azu.this, true);
      }
    });
  }

  public void setResistance(float paramFloat)
  {
    this.E.a(paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azu
 * JD-Core Version:    0.6.2
 */