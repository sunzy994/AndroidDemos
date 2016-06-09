package cmcm.com.myapplication.com.lazyswipe.widget.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import asq;
import awy;
import awz;
import axb;
import axc;
import axd;
import axe;
import axf;
import axg;
import axh;
import axi;
import axj;
import axk;
import axl;
import axm;
import axn;
import axo;
import axp;
import axs;
import axt;
import axv;
import axw;
import eh;
import vl;

public class DragSortListView extends ListView
{
  private View[] A = new View[1];
  private axe B;
  private float C = 0.3333333F;
  private float D = 0.3333333F;
  private int E;
  private int F;
  private float G;
  private float H;
  private float I;
  private float J;
  private float K = 0.5F;
  private axd L = new axd()
  {
    public float a(float paramAnonymousFloat, long paramAnonymousLong)
    {
      return DragSortListView.a(DragSortListView.this) * paramAnonymousFloat;
    }
  };
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R = 0;
  private boolean S = false;
  private boolean T = false;
  private axj U = null;
  private MotionEvent V;
  private int W = 0;
  private View a;
  private Interpolator aA;
  private boolean aB = false;
  private boolean aC = false;
  private float aa = 0.25F;
  private float ab = 0.0F;
  private axb ac;
  private boolean ad = false;
  private axg ae;
  private boolean af = false;
  private boolean ag = false;
  private axk ah = new axk(this, 3);
  private axo ai;
  private axl aj;
  private axh ak;
  private boolean al;
  private float am = 0.0F;
  private int an = 1;
  private int ao = 5;
  private int ap = 3;
  private float aq;
  private float ar;
  private int as;
  private int at;
  private boolean au = false;
  private axv av;
  private axn aw;
  private axt ax;
  private axm ay;
  private Interpolator az;
  private Point b = new Point();
  private Point c = new Point();
  private int d;
  private boolean e = false;
  private DataSetObserver f;
  private float g = 1.0F;
  private float h = 1.0F;
  private int i;
  private int j;
  private int k;
  private boolean l = false;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private axc r;
  private axi s;
  private axp t;
  private boolean u = true;
  private int v = 0;
  private int w = 1;
  private int x;
  private int y;
  private int z = 0;

  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i2 = 150;
    boolean bool1;
    int i1;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, vl.DragSortListView, 0, 0);
      this.w = Math.max(1, paramContext.getDimensionPixelSize(0, 1));
      this.ad = paramContext.getBoolean(5, false);
      if (this.ad)
        this.ae = new axg(this);
      this.g = paramContext.getFloat(6, this.g);
      this.h = this.g;
      this.u = paramContext.getBoolean(10, this.u);
      this.aa = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(7, 0.75F)));
      if (this.aa > 0.0F)
      {
        bool1 = true;
        this.l = bool1;
        setDragScrollStart(paramContext.getFloat(1, this.C));
        this.K = paramContext.getFloat(2, this.K);
        i2 = paramContext.getInt(8, 150);
        i1 = paramContext.getInt(9, 150);
        if (paramContext.getBoolean(17, true))
        {
          bool1 = paramContext.getBoolean(12, false);
          int i3 = paramContext.getInt(4, 1);
          boolean bool2 = paramContext.getBoolean(11, true);
          int i4 = paramContext.getInt(13, 0);
          int i5 = paramContext.getResourceId(14, 0);
          int i6 = paramContext.getResourceId(15, 0);
          int i7 = paramContext.getResourceId(16, 0);
          int i8 = paramContext.getColor(3, -16777216);
          paramAttributeSet = new awy(this, i5, i4, i3, i7, i6);
          paramAttributeSet.b(bool1);
          paramAttributeSet.a(bool2);
          paramAttributeSet.e(i8);
          this.U = paramAttributeSet;
          setOnTouchListener(paramAttributeSet);
        }
        paramContext.recycle();
      }
    }
    while (true)
    {
      this.B = new axe(this);
      if (i2 > 0)
        this.ai = new axo(this, 0.5F, i2);
      if (i1 > 0)
        this.ak = new axh(this, 0.5F, i1);
      this.V = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.f = new DataSetObserver()
      {
        private void a()
        {
          if (DragSortListView.b(DragSortListView.this) == 4)
            DragSortListView.this.b();
        }

        public void onChanged()
        {
          a();
        }

        public void onInvalidated()
        {
          a();
        }
      };
      f();
      return;
      bool1 = false;
      break;
      i1 = 150;
    }
  }

  private int a(int paramInt1, int paramInt2)
  {
    int i1 = getHeaderViewsCount();
    int i2 = getFooterViewsCount();
    if ((paramInt1 <= i1) || (paramInt1 >= getCount() - i2))
      return paramInt2;
    i2 = getDividerHeight();
    int i4 = this.x - this.w;
    int i3 = d(paramInt1);
    int i5 = b(paramInt1);
    if (this.k <= this.m)
      if ((paramInt1 == this.k) && (this.j != this.k))
        if (paramInt1 == this.m)
          i1 = paramInt2 + i5 - this.x;
    while (paramInt1 <= this.m)
    {
      return (this.x - i2 - d(paramInt1 - 1)) / 2 + i1;
      i1 = i5 - i3 + paramInt2 - i4;
      continue;
      i1 = paramInt2;
      if (paramInt1 > this.k)
      {
        i1 = paramInt2;
        if (paramInt1 <= this.m)
        {
          i1 = paramInt2 - i4;
          continue;
          if ((paramInt1 > this.m) && (paramInt1 <= this.j))
          {
            i1 = paramInt2 + i4;
          }
          else
          {
            i1 = paramInt2;
            if (paramInt1 == this.k)
            {
              i1 = paramInt2;
              if (this.j != this.k)
                i1 = paramInt2 + (i5 - i3);
            }
          }
        }
      }
    }
    return (i3 - i2 - this.x) / 2 + i1;
  }

  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i1 = d(paramInt1);
    int i4 = paramView.getHeight();
    int i5 = c(paramInt1, i1);
    int i2;
    if (paramInt1 != this.m)
    {
      i2 = i4 - i1;
      i1 = i5 - i1;
    }
    while (true)
    {
      int i6 = this.x;
      int i3 = i6;
      if (this.m != this.j)
      {
        i3 = i6;
        if (this.m != this.k)
          i3 = i6 - this.w;
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 > this.j)
          return i3 - i1 + 0;
      }
      else
      {
        if (paramInt1 == paramInt3)
        {
          if (paramInt1 <= this.j)
            return i2 - i3 + 0;
          if (paramInt1 == this.k)
            return i4 - i5 + 0;
          return 0 + i2;
        }
        if (paramInt1 <= this.j)
          return 0 - i3;
        if (paramInt1 == this.k)
          return 0 - i1;
      }
      return 0;
      i1 = i5;
      i2 = i4;
    }
  }

  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = getDivider();
    int i4 = getDividerHeight();
    ViewGroup localViewGroup;
    int i2;
    int i3;
    int i1;
    if ((localDrawable != null) && (i4 != 0))
    {
      localViewGroup = (ViewGroup)getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        i2 = getPaddingLeft();
        i3 = getWidth() - getPaddingRight();
        i1 = localViewGroup.getChildAt(0).getHeight();
        if (paramInt <= this.m)
          break label130;
        i1 += localViewGroup.getTop();
        paramInt = i1 + i4;
      }
    }
    while (true)
    {
      paramCanvas.save();
      paramCanvas.clipRect(i2, i1, i3, paramInt);
      localDrawable.setBounds(i2, i1, i3, paramInt);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      label130: paramInt = localViewGroup.getBottom() - i1;
      i1 = paramInt - i4;
    }
  }

  private void a(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i1;
    if ((paramInt != this.m) && (paramInt != this.j) && (paramInt != this.k))
    {
      i1 = -2;
      if (i1 != localLayoutParams.height)
      {
        localLayoutParams.height = i1;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.j) || (paramInt == this.k))
      {
        if (paramInt >= this.m)
          break label151;
        ((awz)paramView).setGravity(80);
      }
    }
    while (true)
    {
      int i3 = paramView.getVisibility();
      int i2 = 0;
      i1 = i2;
      if (paramInt == this.m)
      {
        i1 = i2;
        if (this.a != null)
          i1 = 4;
      }
      if (i1 != i3)
        paramView.setVisibility(i1);
      return;
      i1 = c(paramInt, paramView, paramBoolean);
      break;
      label151: if (paramInt > this.m)
        ((awz)paramView).setGravity(48);
    }
  }

  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i2 = ViewGroup.getChildMeasureSpec(this.z, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0);
    for (int i1 = MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824); ; i1 = MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i2, i1);
      return;
    }
  }

  private int b(int paramInt)
  {
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
      return localView.getHeight();
    return c(paramInt, d(paramInt));
  }

  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramInt == this.m)
      paramInt = i1;
    View localView;
    label65: 
    do
    {
      return paramInt;
      localView = paramView;
      if (paramInt >= getHeaderViewsCount())
        if (paramInt < getCount() - getFooterViewsCount())
          break label65;
      for (localView = paramView; ; localView = ((ViewGroup)paramView).getChildAt(0))
      {
        paramView = localView.getLayoutParams();
        if ((paramView == null) || (paramView.height <= 0))
          break;
        return paramView.height;
      }
      paramInt = localView.getHeight();
    }
    while ((paramInt != 0) && (!paramBoolean));
    a(localView);
    return localView.getMeasuredHeight();
  }

  private void b(int paramInt1, int paramInt2)
  {
    this.b.x = (paramInt1 - this.n);
    this.b.y = (paramInt2 - this.o);
    b(true);
    paramInt1 = Math.min(paramInt2, this.d + this.y);
    paramInt2 = Math.max(paramInt2, this.d - this.y);
    int i1 = this.B.b();
    if ((paramInt1 > this.P) && (paramInt1 > this.F) && (i1 != 1))
    {
      if (i1 != -1)
        this.B.a(true);
      this.B.a(1);
    }
    do
    {
      return;
      if ((paramInt2 < this.P) && (paramInt2 < this.E) && (i1 != 0))
      {
        if (i1 != -1)
          this.B.a(true);
        this.B.a(0);
        return;
      }
    }
    while ((paramInt2 < this.E) || (paramInt1 > this.F) || (!this.B.a()));
    this.B.a(true);
  }

  private void b(boolean paramBoolean)
  {
    int i1 = getFirstVisiblePosition();
    int i2 = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null)
      return;
    d(i1 + i2, localView, paramBoolean);
  }

  private boolean b(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) && (this.av == null))
      return false;
    eh.a(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    do
      while (true)
      {
        return false;
        int i1 = this.at;
        this.aq = paramMotionEvent.getX();
        this.ar = paramMotionEvent.getY();
        this.as = 0;
        this.au = false;
        this.at = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if ((this.aw != null) && (!this.aw.a(this.at)))
          return false;
        if ((this.at == i1) && (this.av != null) && (this.av.a()))
        {
          this.as = 1;
          this.av.a(paramMotionEvent);
          return true;
        }
        View localView2 = getChildAt(this.at - getFirstVisiblePosition());
        View localView1 = localView2;
        if ((localView2 instanceof ViewGroup))
          localView1 = ((ViewGroup)localView2).getChildAt(0);
        if ((this.av != null) && (this.av.a()))
        {
          this.av.b();
          this.av = null;
          this.au = true;
          paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
          paramMotionEvent.setAction(3);
          onTouchEvent(paramMotionEvent);
          return true;
        }
        if ((localView1 instanceof axv))
        {
          this.av = ((axv)localView1);
          this.av.setSwipeDirection(this.an);
        }
        if (this.av != null)
        {
          this.av.a(paramMotionEvent);
          continue;
          float f1 = Math.abs(paramMotionEvent.getY() - this.ar);
          float f2 = Math.abs(paramMotionEvent.getX() - this.aq);
          if (this.as == 1)
          {
            if (this.av != null)
              this.av.a(paramMotionEvent);
            getSelector().setState(new int[] { 0 });
            paramMotionEvent.setAction(3);
            super.onTouchEvent(paramMotionEvent);
            return true;
          }
          if (this.as == 0)
            if (Math.abs(f1) > this.ao)
            {
              this.as = 2;
            }
            else if (f2 > this.ap)
            {
              this.as = 1;
              if (this.aw != null)
                this.aw.b(this.at);
            }
        }
      }
    while (this.as != 1);
    if (this.av != null)
    {
      this.av.a(paramMotionEvent);
      if (!this.av.a())
      {
        this.at = -1;
        this.av = null;
      }
    }
    if (this.aw != null)
      this.aw.c(this.at);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }

  private int c(int paramInt1, int paramInt2)
  {
    getDividerHeight();
    int i1;
    int i2;
    int i3;
    if ((this.l) && (this.j != this.k))
    {
      i1 = 1;
      i2 = this.x - this.w;
      i3 = (int)(this.ab * i2);
      if (paramInt1 != this.m)
        break label114;
      if (this.m != this.j)
        break label90;
      if (i1 == 0)
        break label85;
      i1 = i3 + this.w;
    }
    label85: label90: label114: 
    do
    {
      return i1;
      i1 = 0;
      break;
      return this.x;
      if (this.m == this.k)
        return this.x - i3;
      return this.w;
      if (paramInt1 == this.j)
      {
        if (i1 != 0)
          return paramInt2 + i3;
        return paramInt2 + i2;
      }
      i1 = paramInt2;
    }
    while (paramInt1 != this.k);
    return paramInt2 + i2 - i3;
  }

  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    return c(paramInt, b(paramInt, paramView, paramBoolean));
  }

  private void c(int paramInt)
  {
    this.v = 1;
    if (this.t != null)
      this.t.a(paramInt);
    p();
    j();
    g();
    if (this.T)
    {
      this.v = 3;
      return;
    }
    this.v = 0;
  }

  private void c(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      this.O = this.M;
      this.P = this.N;
    }
    this.M = ((int)paramMotionEvent.getX());
    this.N = ((int)paramMotionEvent.getY());
    if (i1 == 0)
    {
      this.O = this.M;
      this.P = this.N;
    }
    this.p = ((int)paramMotionEvent.getRawX() - this.M);
    this.q = ((int)paramMotionEvent.getRawY() - this.N);
  }

  private int d(int paramInt)
  {
    int i1 = 0;
    if (paramInt == this.m);
    do
    {
      return i1;
      localObject = getChildAt(paramInt - getFirstVisiblePosition());
      if (localObject != null)
        return b(paramInt, (View)localObject, false);
      i2 = this.ah.a(paramInt);
      i1 = i2;
    }
    while (i2 != -1);
    Object localObject = getAdapter();
    i1 = ((ListAdapter)localObject).getItemViewType(paramInt);
    int i2 = ((ListAdapter)localObject).getViewTypeCount();
    if (i2 != this.A.length)
      this.A = new View[i2];
    if (i1 >= 0)
      if (this.A[i1] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.A[i1] = localObject;
      }
    while (true)
    {
      i1 = b(paramInt, (View)localObject, true);
      this.ah.a(paramInt, i1);
      return i1;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.A[i1], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }

  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    this.af = true;
    o();
    int i1 = this.j;
    int i2 = this.k;
    boolean bool = e();
    if (bool)
    {
      m();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i1, i2) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean))
      invalidate();
    this.af = false;
  }

  private boolean e()
  {
    int i1 = getFirstVisiblePosition();
    int i2 = this.j;
    View localView2 = getChildAt(i2 - i1);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i2 = i1 + getChildCount() / 2;
      localView1 = getChildAt(i2 - i1);
    }
    int i6 = localView1.getTop();
    int i7 = localView1.getHeight();
    i1 = a(i2, i6);
    int i9 = getDividerHeight();
    int i3;
    int i4;
    int i5;
    label155: int i8;
    label210: float f2;
    if (this.d < i1)
    {
      i3 = i1;
      i4 = i1;
      i1 = i3;
      i5 = i2;
      i2 = i5;
      i3 = i4;
      if (i5 >= 0)
      {
        i5 -= 1;
        i1 = b(i5);
        if (i5 == 0)
        {
          i1 = i6 - i9 - i1;
          i3 = i4;
          i2 = i5;
        }
      }
      else
      {
        i5 = getHeaderViewsCount();
        i8 = getFooterViewsCount();
        i6 = this.j;
        i7 = this.k;
        float f1 = this.ab;
        if (!this.l)
          break label652;
        i9 = Math.abs(i1 - i3);
        if (this.d >= i1)
          break label574;
        f2 = this.aa;
        i4 = (int)(i9 * (f2 * 0.5F));
        f2 = i4;
        i3 += i4;
        if (this.d >= i3)
          break label589;
        this.j = (i2 - 1);
        this.k = i2;
        this.ab = ((i3 - this.d) * 0.5F / f2);
        label277: if (this.j >= i5)
          break label667;
        this.j = i5;
        this.k = i5;
        i2 = i5;
        label302: if ((this.j == i6) && (this.k == i7) && (this.ab == f1))
          break label710;
      }
    }
    label574: label710: for (boolean bool = true; ; bool = false)
    {
      if (i2 != this.i)
      {
        if (this.r != null)
          this.r.a(this.i - i5, i2 - i5);
        this.i = i2;
        return true;
        i7 = i6 - (i1 + i9);
        i6 = a(i5, i7);
        i2 = i5;
        i3 = i4;
        i1 = i6;
        if (this.d >= i6)
          break label155;
        i4 = i6;
        i1 = i6;
        i6 = i7;
        break;
        int i10 = getCount();
        i3 = i1;
        i5 = i1;
        i1 = i3;
        i4 = i2;
        while (true)
        {
          i2 = i4;
          i3 = i5;
          if (i4 >= i10)
            break;
          if (i4 == i10 - 1)
          {
            i1 = i6 + i9 + i7;
            i2 = i4;
            i3 = i5;
            break;
          }
          i8 = i6 + (i9 + i7);
          i7 = b(i4 + 1);
          i6 = a(i4 + 1, i8);
          i2 = i4;
          i3 = i5;
          i1 = i6;
          if (this.d < i6)
            break;
          i4 += 1;
          i5 = i6;
          i1 = i6;
          i6 = i8;
        }
        i4 = i3;
        i3 = i1;
        i1 = i4;
        break label210;
        label589: if (this.d < i1 - i4)
        {
          this.j = i2;
          this.k = i2;
          break label277;
        }
        this.j = i2;
        this.k = (i2 + 1);
        this.ab = ((1.0F + (i1 - this.d) / f2) * 0.5F);
        break label277;
        this.j = i2;
        this.k = i2;
        break label277;
        if (this.k < getCount() - i8)
          break label302;
        i2 = getCount() - i8 - 1;
        this.j = i2;
        this.k = i2;
        break label302;
      }
      return bool;
    }
  }

  private void f()
  {
    this.ap = asq.a(this.ap);
    this.ao = asq.a(this.ao);
    this.as = 0;
  }

  private void g()
  {
    this.m = -1;
    this.j = -1;
    this.k = -1;
    this.i = -1;
  }

  private void h()
  {
    this.v = 2;
    if ((this.s != null) && (this.i >= 0) && (this.i < getCount()))
    {
      int i1 = getHeaderViewsCount();
      this.s.a_(this.m - i1, this.i - i1);
    }
    p();
    j();
    g();
    m();
    if (this.T)
    {
      this.v = 3;
      return;
    }
    this.v = 0;
  }

  private void i()
  {
    c(this.m - getHeaderViewsCount());
  }

  private void j()
  {
    int i1 = 0;
    int i2 = getFirstVisiblePosition();
    if (this.m < i2)
    {
      View localView = getChildAt(0);
      if (localView != null)
        i1 = localView.getTop();
      setSelectionFromTop(i2 - 1, i1 - getPaddingTop());
    }
  }

  private void k()
  {
    this.W = 0;
    this.T = false;
    if (this.v == 3)
      this.v = 0;
    this.h = this.g;
    this.aB = false;
    this.ah.a();
  }

  private void l()
  {
    int i1 = getPaddingTop();
    int i2 = getHeight() - i1 - getPaddingBottom();
    float f1 = i2;
    this.H = (i1 + this.C * f1);
    float f2 = i1;
    this.G = (f1 * (1.0F - this.D) + f2);
    this.E = ((int)this.H);
    this.F = ((int)this.G);
    this.I = (this.H - i1);
    this.J = (i1 + i2 - this.G);
  }

  private void m()
  {
    int i2 = getFirstVisiblePosition();
    int i3 = getLastVisiblePosition();
    int i1 = Math.max(0, getHeaderViewsCount() - i2);
    i3 = Math.min(i3 - i2, getCount() - 1 - getFooterViewsCount() - i2);
    while (i1 <= i3)
    {
      View localView = getChildAt(i1);
      if (localView != null)
        a(i2 + i1, localView, false);
      i1 += 1;
    }
  }

  private void n()
  {
    if (this.a != null)
    {
      a(this.a);
      this.x = this.a.getMeasuredHeight();
      this.y = (this.x / 2);
    }
  }

  private void o()
  {
    if (this.U != null)
    {
      this.c.set(this.M, this.N);
      this.U.a(this.a, this.b, this.c);
    }
    int i1 = this.b.x;
    int i4 = this.b.y;
    int i2 = getPaddingLeft();
    int i3;
    if (((this.R & 0x1) == 0) && (i1 > i2))
    {
      this.b.x = i2;
      i2 = getHeaderViewsCount();
      i3 = getFooterViewsCount();
      int i5 = getFirstVisiblePosition();
      int i6 = getLastVisiblePosition();
      i1 = getPaddingTop();
      if (i5 < i2)
        i1 = getChildAt(i2 - i5 - 1).getBottom();
      i2 = i1;
      if ((this.R & 0x8) == 0)
      {
        i2 = i1;
        if (i5 <= this.m)
          i2 = Math.max(getChildAt(this.m - i5).getTop(), i1);
      }
      i1 = getHeight() - getPaddingBottom();
      if (i6 >= getCount() - i3 - 1)
        i1 = getChildAt(getCount() - i3 - 1 - i5).getBottom();
      i3 = i1;
      if ((this.R & 0x4) == 0)
      {
        i3 = i1;
        if (i6 >= this.m)
          i3 = Math.min(getChildAt(this.m - i5).getBottom(), i1);
      }
      if (i4 >= i2)
        break label315;
      this.b.y = i2;
    }
    while (true)
    {
      this.d = (this.b.y + this.y);
      return;
      if (((this.R & 0x2) != 0) || (i1 >= i2))
        break;
      this.b.x = i2;
      break;
      label315: if (this.x + i4 > i3)
        this.b.y = (i3 - this.x);
    }
  }

  private void p()
  {
    if (this.a != null)
    {
      this.a.setVisibility(8);
      if (this.U != null)
        this.U.a(this.a);
      this.a = null;
      invalidate();
    }
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F)
    {
      this.D = 0.5F;
      if (paramFloat1 <= 0.5F)
        break label46;
    }
    label46: for (this.C = 0.5F; ; this.C = paramFloat1)
    {
      if (getHeight() != 0)
        l();
      return;
      this.D = paramFloat2;
      break;
    }
  }

  public void a(int paramInt)
  {
    this.al = false;
    a(paramInt, 0.0F);
  }

  public void a(int paramInt, float paramFloat)
  {
    if ((this.v == 0) || (this.v == 4))
    {
      if (this.v == 0)
      {
        this.m = (getHeaderViewsCount() + paramInt);
        this.j = this.m;
        this.k = this.m;
        this.i = this.m;
        View localView = getChildAt(this.m - getFirstVisiblePosition());
        if (localView != null)
          localView.setVisibility(4);
      }
      this.v = 1;
      this.am = paramFloat;
      if (this.T)
        switch (this.W)
        {
        default:
        case 1:
        case 2:
        }
    }
    while (this.ai != null)
    {
      this.ai.c();
      return;
      super.onTouchEvent(this.V);
      continue;
      super.onInterceptTouchEvent(this.V);
    }
    c(paramInt);
  }

  public boolean a()
  {
    return (this.as == 1) || (this.au);
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!this.T) || (this.U == null));
    View localView;
    do
    {
      return false;
      localView = this.U.d(paramInt1);
    }
    while (localView == null);
    return a(paramInt1, localView, paramInt2, paramInt3, paramInt4);
  }

  public boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    if ((this.v != 0) || (!this.T) || (this.a != null) || (paramView == null) || (!this.u))
    {
      bool = false;
      return bool;
    }
    if (getParent() != null)
      getParent().requestDisallowInterceptTouchEvent(true);
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.j = paramInt1;
    this.k = paramInt1;
    this.m = paramInt1;
    this.i = paramInt1;
    this.v = 4;
    this.R = 0;
    this.R |= paramInt2;
    this.a = paramView;
    n();
    this.n = paramInt3;
    this.o = paramInt4;
    this.Q = this.N;
    this.b.x = (this.M - this.n);
    this.b.y = (this.N - this.o);
    paramView = getChildAt(this.m - getFirstVisiblePosition());
    if (paramView != null)
      paramView.setVisibility(4);
    if (this.ad)
      this.ae.a();
    switch (this.W)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      requestLayout();
      if (this.aj == null)
        break;
      this.aj.c();
      return true;
      super.onTouchEvent(this.V);
      continue;
      super.onInterceptTouchEvent(this.V);
    }
  }

  protected boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default:
    case 3:
    case 1:
    case 2:
    }
    while (true)
    {
      return true;
      if (this.v == 4)
        b();
      k();
      continue;
      if (this.v == 4)
        a(false);
      k();
      continue;
      b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }

  public boolean a(boolean paramBoolean)
  {
    this.al = false;
    return b(paramBoolean, 0.0F);
  }

  public boolean a(boolean paramBoolean, float paramFloat)
  {
    this.al = true;
    return b(paramBoolean, paramFloat);
  }

  public void b()
  {
    if (this.v == 4)
    {
      this.B.a(true);
      p();
      g();
      m();
      if (this.T)
        this.v = 3;
    }
    else
    {
      return;
    }
    this.v = 0;
  }

  public boolean b(boolean paramBoolean, float paramFloat)
  {
    if (this.a != null)
    {
      this.B.a(true);
      if (paramBoolean)
        a(this.m - getHeaderViewsCount(), paramFloat);
      while (true)
      {
        if (this.ad)
          this.ae.d();
        return true;
        if (this.ak != null)
          this.ak.c();
        else
          h();
      }
    }
    return false;
  }

  public boolean c()
  {
    return this.aB;
  }

  public boolean d()
  {
    return this.u;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.v != 0)
    {
      if (this.j != this.m)
        a(this.j, paramCanvas);
      if ((this.k != this.j) && (this.k != this.m))
        a(this.k, paramCanvas);
    }
    int i3;
    int i4;
    int i1;
    float f1;
    if (this.a != null)
    {
      i3 = this.a.getWidth();
      i4 = this.a.getHeight();
      int i2 = this.b.x;
      int i5 = getWidth();
      i1 = i2;
      if (i2 < 0)
        i1 = -i2;
      if (i1 >= i5)
        break label216;
      f1 = (i5 - i1) / i5;
    }
    label216: for (f1 *= f1; ; f1 = 0.0F)
    {
      i1 = (int)(f1 * (255.0F * this.h));
      paramCanvas.save();
      paramCanvas.translate(this.b.x, this.b.y);
      paramCanvas.clipRect(0, 0, i3, i4);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, i3, i4, i1, 31);
      this.a.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
    }
  }

  public Interpolator getCloseInterpolator()
  {
    return this.az;
  }

  public float getFloatAlpha()
  {
    return this.h;
  }

  public ListAdapter getInputAdapter()
  {
    if (this.ac == null)
      return null;
    return this.ac.a();
  }

  public Interpolator getOpenInterpolator()
  {
    return this.aA;
  }

  public void layoutChildren()
  {
    super.layoutChildren();
    if (this.a != null)
    {
      if ((this.a.isLayoutRequested()) && (!this.e))
        n();
      this.a.layout(0, 0, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
      this.e = false;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.ad)
      this.ae.b();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.u)
      return super.onInterceptTouchEvent(paramMotionEvent);
    c(paramMotionEvent);
    this.S = true;
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0)
    {
      if (this.v != 0)
      {
        this.ag = true;
        return true;
      }
      this.T = true;
    }
    if (this.a != null)
    {
      bool = true;
      if ((i1 == 1) || (i1 == 3))
        this.T = false;
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
      this.aB = true;
    for (boolean bool = true; ; bool = false)
      switch (i1)
      {
      case 2:
      default:
        if (bool)
          this.W = 1;
        break;
      case 1:
      case 3:
        k();
        break;
        this.W = 2;
        break;
      }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a != null)
    {
      if (this.a.isLayoutRequested())
        n();
      this.e = true;
    }
    this.z = paramInt1;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    l();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if ((this.v == 0) && (b(paramMotionEvent)))
      bool2 = true;
    while (true)
    {
      return bool2;
      if (this.ag)
      {
        this.ag = false;
        return false;
      }
      if (!this.u)
        return super.onTouchEvent(paramMotionEvent);
      boolean bool1 = this.S;
      this.S = false;
      if (!bool1)
        c(paramMotionEvent);
      if (this.v == 4)
      {
        a(paramMotionEvent);
        return true;
      }
      bool1 = bool2;
      if (this.v == 0);
      try
      {
        boolean bool3 = super.onTouchEvent(paramMotionEvent);
        bool1 = bool2;
        if (bool3)
          bool1 = true;
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        case 2:
        default:
          bool2 = bool1;
          if (!bool1)
            continue;
          this.W = 1;
          return bool1;
        case 1:
        case 3:
          k();
          return bool1;
        }
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        while (true)
          bool1 = bool2;
      }
    }
  }

  public void requestLayout()
  {
    if (!this.af)
      super.requestLayout();
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +80 -> 81
    //   4: aload_0
    //   5: new 10	com/lazyswipe/widget/listview/DragSortListView$3
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 828	com/lazyswipe/widget/listview/DragSortListView$3:<init>	(Lcom/lazyswipe/widget/listview/DragSortListView;Landroid/widget/ListAdapter;)V
    //   14: putfield 785	com/lazyswipe/widget/listview/DragSortListView:ac	Laxb;
    //   17: aload_1
    //   18: aload_0
    //   19: getfield 308	com/lazyswipe/widget/listview/DragSortListView:f	Landroid/database/DataSetObserver;
    //   22: invokeinterface 832 2 0
    //   27: aload_1
    //   28: instanceof 671
    //   31: ifeq +11 -> 42
    //   34: aload_0
    //   35: aload_1
    //   36: checkcast 671	axi
    //   39: invokevirtual 836	com/lazyswipe/widget/listview/DragSortListView:setDropListener	(Laxi;)V
    //   42: aload_1
    //   43: instanceof 660
    //   46: ifeq +11 -> 57
    //   49: aload_0
    //   50: aload_1
    //   51: checkcast 660	axc
    //   54: invokevirtual 840	com/lazyswipe/widget/listview/DragSortListView:setDragListener	(Laxc;)V
    //   57: aload_1
    //   58: instanceof 583
    //   61: ifeq +11 -> 72
    //   64: aload_0
    //   65: aload_1
    //   66: checkcast 583	axp
    //   69: invokevirtual 844	com/lazyswipe/widget/listview/DragSortListView:setRemoveListener	(Laxp;)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 785	com/lazyswipe/widget/listview/DragSortListView:ac	Laxb;
    //   77: invokespecial 845	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   80: return
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 785	com/lazyswipe/widget/listview/DragSortListView:ac	Laxb;
    //   86: goto -14 -> 72
  }

  public void setCloseInterpolator(Interpolator paramInterpolator)
  {
    this.az = paramInterpolator;
  }

  public void setDragEnabled(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  public void setDragListener(axc paramaxc)
  {
    this.r = paramaxc;
  }

  public void setDragScrollProfile(axd paramaxd)
  {
    if (paramaxd != null)
      this.L = paramaxd;
  }

  public void setDragScrollStart(float paramFloat)
  {
    a(paramFloat, paramFloat);
  }

  public void setDragSortListener(axf paramaxf)
  {
    setDropListener(paramaxf);
    setDragListener(paramaxf);
    setRemoveListener(paramaxf);
  }

  public void setDropListener(axi paramaxi)
  {
    this.s = paramaxi;
  }

  public void setFloatAlpha(float paramFloat)
  {
    this.h = paramFloat;
  }

  public void setFloatViewManager(axj paramaxj)
  {
    this.U = paramaxj;
  }

  public void setMaxScrollSpeed(float paramFloat)
  {
    this.K = paramFloat;
  }

  public void setMenuCreator(axt paramaxt)
  {
    this.ax = paramaxt;
  }

  public void setOnMenuItemClickListener(axm paramaxm)
  {
    this.ay = paramaxm;
  }

  public void setOnSwipeListener(axn paramaxn)
  {
    this.aw = paramaxn;
  }

  public void setOpenInterpolator(Interpolator paramInterpolator)
  {
    this.aA = paramInterpolator;
  }

  public void setRemoveListener(axp paramaxp)
  {
    this.t = paramaxp;
  }

  public void setSwipeDirection(int paramInt)
  {
    this.an = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.listview.DragSortListView
 * JD-Core Version:    0.6.2
 */