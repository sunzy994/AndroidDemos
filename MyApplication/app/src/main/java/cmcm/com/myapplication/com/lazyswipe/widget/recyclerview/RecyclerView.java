package cmcm.com.myapplication.com.lazyswipe.widget.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import axy;
import axz;
import aya;
import ayb;
import ayd;
import aye;
import ayp;
import ays;
import ayu;
import ayv;
import ayw;
import ayx;
import ayy;
import ayz;
import aza;
import azb;
import azc;
import azd;
import aze;
import azf;
import azi;
import azj;
import azk;
import azl;
import cq;
import eh;
import eu;
import ez;
import im;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup
{
  private static final boolean a;
  private static final Interpolator aa;
  private final boolean A;
  private final AccessibilityManager B;
  private boolean C = false;
  private boolean D = false;
  private im E;
  private im F;
  private im G;
  private im H;
  private int I = 0;
  private int J = -1;
  private VelocityTracker K;
  private int L;
  private int M;
  private int N;
  private int O;
  private final int P;
  private final int Q;
  private final int R;
  private final azk S = new azk(this);
  private azb T;
  private ayu U = new ayv(this, null);
  private boolean V = false;
  private Runnable W = new Runnable()
  {
    public void run()
    {
      if (RecyclerView.this.f != null)
        RecyclerView.this.f.a();
      RecyclerView.a(RecyclerView.this, false);
    }
  };
  public final azd b = new azd(this);
  public axy c;
  public ayb d;
  final List<View> e = new ArrayList();
  public ays f = new aye();
  public final azi g = new azi();
  boolean h = false;
  boolean i = false;
  private final azf j = new azf(this, null);
  private RecyclerView.SavedState k;
  private boolean l;
  private final Runnable m = new Runnable()
  {
    public void run()
    {
      if (!RecyclerView.this.c.d());
      while (!RecyclerView.a(RecyclerView.this))
        return;
      if (RecyclerView.b(RecyclerView.this))
      {
        RecyclerView.this.m();
        return;
      }
      RecyclerView.this.f();
      RecyclerView.this.c.b();
      if (!RecyclerView.c(RecyclerView.this))
        RecyclerView.this.q();
      RecyclerView.this.b(true);
    }
  };
  private final Rect n = new Rect();
  private ayp o;
  private ayy p;
  private aze q;
  private final ArrayList<ayw> r = new ArrayList();
  private final ArrayList<aza> s = new ArrayList();
  private aza t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;

  static
  {
    if ((Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20));
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      aa = new Interpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          paramAnonymousFloat -= 1.0F;
          return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
        }
      };
      return;
    }
  }

  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }

  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 16);
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.A = bool1;
      paramContext = ViewConfiguration.get(paramContext);
      this.P = paramContext.getScaledTouchSlop();
      this.Q = paramContext.getScaledMinimumFlingVelocity();
      this.R = paramContext.getScaledMaximumFlingVelocity();
      bool1 = bool2;
      if (ez.a(this) == 2)
        bool1 = true;
      setWillNotDraw(bool1);
      this.f.a(this.U);
      e();
      a();
      if (ez.e(this) == 0)
        ez.c(this, 1);
      this.B = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      return;
    }
  }

  private void a()
  {
    this.d = new ayb(new ayd()
    {
      public int a()
      {
        return RecyclerView.this.getChildCount();
      }

      public int a(View paramAnonymousView)
      {
        return RecyclerView.this.indexOfChild(paramAnonymousView);
      }

      public void a(int paramAnonymousInt)
      {
        View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
        if (localView != null)
          RecyclerView.b(RecyclerView.this, localView);
        RecyclerView.this.removeViewAt(paramAnonymousInt);
      }

      public void a(View paramAnonymousView, int paramAnonymousInt)
      {
        RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
        RecyclerView.a(RecyclerView.this, paramAnonymousView);
      }

      public void a(View paramAnonymousView, int paramAnonymousInt, LayoutParams paramAnonymousLayoutParams)
      {
        RecyclerView.a(RecyclerView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
      }

      public View b(int paramAnonymousInt)
      {
        return RecyclerView.this.getChildAt(paramAnonymousInt);
      }

      public azl b(View paramAnonymousView)
      {
        return RecyclerView.b(paramAnonymousView);
      }

      public void b()
      {
        int j = a();
        int i = 0;
        while (i < j)
        {
          RecyclerView.b(RecyclerView.this, b(i));
          i += 1;
        }
        RecyclerView.this.removeAllViews();
      }

      public void c(int paramAnonymousInt)
      {
        RecyclerView.a(RecyclerView.this, paramAnonymousInt);
      }
    });
  }

  private void a(ayp paramayp, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.o != null)
      this.o.b(this.j);
    if ((!paramBoolean1) || (paramBoolean2))
    {
      if (this.f != null)
        this.f.c();
      if (this.p != null)
      {
        this.p.b(this.b);
        this.p.a(this.b, true);
      }
    }
    this.c.a();
    ayp localayp = this.o;
    this.o = paramayp;
    if (paramayp != null)
      paramayp.a(this.j);
    if (this.p != null)
      this.p.a(localayp, this.o);
    this.b.a(localayp, this.o, paramBoolean1);
    azi.a(this.g, true);
    r();
  }

  private void a(ayx paramayx)
  {
    View localView = paramayx.a.b;
    g(localView);
    int i1 = paramayx.b;
    int i2 = paramayx.c;
    int i3 = localView.getLeft();
    int i4 = localView.getTop();
    if ((i1 != i3) || (i2 != i4))
    {
      paramayx.a.a(false);
      localView.layout(i3, i4, localView.getWidth() + i3, localView.getHeight() + i4);
      if (this.f.a(paramayx.a, i1, i2, i3, i4))
        w();
    }
    do
    {
      return;
      paramayx.a.a(false);
    }
    while (!this.f.a(paramayx.a));
    w();
  }

  private void a(azl paramazl, Rect paramRect, int paramInt1, int paramInt2)
  {
    View localView = paramazl.b;
    if ((paramRect != null) && ((paramRect.left != paramInt1) || (paramRect.top != paramInt2)))
    {
      paramazl.a(false);
      if (this.f.a(paramazl, paramRect.left, paramRect.top, paramInt1, paramInt2))
        w();
    }
    do
    {
      return;
      paramazl.a(false);
    }
    while (!this.f.b(paramazl));
    w();
  }

  private void a(azl paramazl1, azl paramazl2)
  {
    paramazl1.a(false);
    removeDetachedView(paramazl1.b, false);
    g(paramazl1.b);
    paramazl1.h = paramazl2;
    this.b.c(paramazl1);
    int i3 = paramazl1.b.getLeft();
    int i4 = paramazl1.b.getTop();
    int i2;
    int i1;
    if ((paramazl2 == null) || (paramazl2.c()))
    {
      i2 = i4;
      i1 = i3;
    }
    while (true)
    {
      if (this.f.a(paramazl1, paramazl2, i3, i4, i1, i2))
        w();
      return;
      i1 = paramazl2.b.getLeft();
      i2 = paramazl2.b.getTop();
      paramazl2.a(false);
      paramazl2.i = paramazl1;
    }
  }

  private void a(cq<View, Rect> paramcq)
  {
    int i2 = this.e.size();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = (View)this.e.get(i1);
      azl localazl = b(localView);
      ayx localayx = (ayx)this.g.a.remove(localazl);
      if (!this.g.a())
        this.g.b.remove(localazl);
      if (paramcq.remove(localView) != null)
        this.p.a(localView, this.b);
      while (true)
      {
        i1 += 1;
        break;
        if (localayx != null)
          a(localayx);
        else
          a(new ayx(localazl, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      }
    }
    this.e.clear();
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction();
    if ((i2 == 3) || (i2 == 0))
      this.t = null;
    int i3 = this.s.size();
    int i1 = 0;
    while (i1 < i3)
    {
      aza localaza = (aza)this.s.get(i1);
      if ((localaza.a(this, paramMotionEvent)) && (i2 != 3))
      {
        this.t = localaza;
        return true;
      }
      i1 += 1;
    }
    return false;
  }

  public static azl b(View paramView)
  {
    if (paramView == null)
      return null;
    return ((ayz)paramView.getLayoutParams()).a;
  }

  private void b()
  {
    if (this.c.d())
      this.m.run();
  }

  private boolean b(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    int i2;
    if (this.t != null)
    {
      if (i1 == 0)
        this.t = null;
    }
    else
    {
      if (i1 == 0)
        break label107;
      i2 = this.s.size();
      i1 = 0;
    }
    while (i1 < i2)
    {
      aza localaza = (aza)this.s.get(i1);
      if (localaza.a(this, paramMotionEvent))
      {
        this.t = localaza;
        return true;
        this.t.b(this, paramMotionEvent);
        if ((i1 == 3) || (i1 == 1))
          this.t = null;
        return true;
      }
      i1 += 1;
    }
    label107: return false;
  }

  private void c()
  {
    this.S.b();
    this.p.u();
  }

  private void c(MotionEvent paramMotionEvent)
  {
    int i1 = eh.b(paramMotionEvent);
    if (eh.b(paramMotionEvent, i1) == this.J)
      if (i1 != 0)
        break label75;
    label75: for (i1 = 1; ; i1 = 0)
    {
      this.J = eh.b(paramMotionEvent, i1);
      int i2 = (int)(eh.c(paramMotionEvent, i1) + 0.5F);
      this.N = i2;
      this.L = i2;
      i1 = (int)(eh.d(paramMotionEvent, i1) + 0.5F);
      this.O = i1;
      this.M = i1;
      return;
    }
  }

  private void d()
  {
    boolean bool2 = false;
    if (this.E != null)
      bool2 = this.E.c();
    boolean bool1 = bool2;
    if (this.F != null)
      bool1 = bool2 | this.F.c();
    bool2 = bool1;
    if (this.G != null)
      bool2 = bool1 | this.G.c();
    bool1 = bool2;
    if (this.H != null)
      bool1 = bool2 | this.H.c();
    if (bool1)
      ez.d(this);
  }

  private void g(View paramView)
  {
    if (paramView.getParent() == this);
    for (int i1 = 1; ; i1 = 0)
    {
      this.b.c(a(paramView));
      if (i1 != 0)
        break;
      this.d.a(paramView, true);
      return;
    }
    this.d.d(paramView);
  }

  private void h(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      h();
      this.E.a(-paramInt1 / getWidth());
      if (paramInt2 >= 0)
        break label90;
      j();
      this.F.a(-paramInt2 / getHeight());
    }
    while (true)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
        ez.d(this);
      return;
      if (paramInt1 <= 0)
        break;
      i();
      this.G.a(paramInt1 / getWidth());
      break;
      label90: if (paramInt2 > 0)
      {
        k();
        this.H.a(paramInt2 / getHeight());
      }
    }
  }

  private void h(View paramView)
  {
    f();
    if (this.d.e(paramView))
    {
      paramView = b(paramView);
      this.b.c(paramView);
      this.b.b(paramView);
    }
    b(false);
  }

  private void i(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.E != null)
    {
      bool1 = bool2;
      if (!this.E.a())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
          bool1 = this.E.c();
      }
    }
    bool2 = bool1;
    if (this.G != null)
    {
      bool2 = bool1;
      if (!this.G.a())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
          bool2 = bool1 | this.G.c();
      }
    }
    bool1 = bool2;
    if (this.F != null)
    {
      bool1 = bool2;
      if (!this.F.a())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
          bool1 = bool2 | this.F.c();
      }
    }
    bool2 = bool1;
    if (this.H != null)
    {
      bool2 = bool1;
      if (!this.H.a())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
          bool2 = bool1 | this.H.c();
      }
    }
    if (bool2)
      ez.d(this);
  }

  private void i(View paramView)
  {
    if (this.o != null)
      this.o.c(b(paramView));
    e(paramView);
  }

  private void j(View paramView)
  {
    if (this.o != null)
      this.o.b(b(paramView));
    d(paramView);
  }

  private void k(View paramView)
  {
    this.e.remove(paramView);
  }

  private void l(View paramView)
  {
    if (!this.e.contains(paramView))
      this.e.add(paramView);
  }

  private void setScrollState(int paramInt)
  {
    if (paramInt == this.I)
      return;
    this.I = paramInt;
    if (paramInt != 2)
      c();
    if (this.T != null)
      this.T.a(this, paramInt);
    this.p.j(paramInt);
  }

  private void u()
  {
    if (this.K != null)
      this.K.clear();
    d();
    setScrollState(0);
  }

  private boolean v()
  {
    return (this.f != null) && (this.f.h());
  }

  private void w()
  {
    if ((!this.V) && (this.u))
    {
      ez.a(this, this.W);
      this.V = true;
    }
  }

  private boolean x()
  {
    return (this.f != null) && (this.p.h());
  }

  private void y()
  {
    boolean bool2 = true;
    if (this.C)
    {
      this.c.a();
      r();
      this.p.d(this);
    }
    int i1;
    label90: azi localazi;
    if ((this.f != null) && (this.p.h()))
    {
      this.c.b();
      if (((!this.h) || (this.i)) && (!this.h) && ((!this.i) || (!v())))
        break label208;
      i1 = 1;
      localazi = this.g;
      if ((!this.w) || (this.f == null) || ((!this.C) && (i1 == 0) && (!ayy.a(this.p))) || ((this.C) && (!this.o.b())))
        break label213;
      bool1 = true;
      label149: azi.c(localazi, bool1);
      localazi = this.g;
      if ((!azi.c(this.g)) || (i1 == 0) || (this.C) || (!x()))
        break label218;
    }
    label208: label213: label218: for (boolean bool1 = bool2; ; bool1 = false)
    {
      azi.d(localazi, bool1);
      return;
      this.c.e();
      break;
      i1 = 0;
      break label90;
      bool1 = false;
      break label149;
    }
  }

  long a(azl paramazl)
  {
    if (this.o.b())
      return paramazl.e();
    return paramazl.c;
  }

  azl a(int paramInt, boolean paramBoolean)
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      azl localazl = b(this.d.c(i1));
      if ((localazl != null) && (!localazl.o()))
        if (paramBoolean)
        {
          if (localazl.c != paramInt);
        }
        else
          while (localazl.d() == paramInt)
            return localazl;
      i1 += 1;
    }
    return null;
  }

  public azl a(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this))
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    return b(paramView);
  }

  public void a(int paramInt)
  {
    g();
    this.p.d(paramInt);
    awakenScrollBars();
  }

  void a(int paramInt1, int paramInt2)
  {
    b();
    int i2;
    int i1;
    int i3;
    int i4;
    if (this.o != null)
    {
      f();
      this.D = true;
      if (paramInt1 != 0)
      {
        i2 = this.p.a(paramInt1, this.b, this.g);
        i1 = paramInt1 - i2;
        if (paramInt2 != 0)
        {
          i3 = this.p.b(paramInt2, this.b, this.g);
          i4 = paramInt2 - i3;
          label76: if (v())
          {
            i6 = this.d.b();
            i5 = 0;
            if (i5 < i6)
            {
              View localView = this.d.b(i5);
              Object localObject = a(localView);
              if ((localObject != null) && (((azl)localObject).i != null))
              {
                localObject = ((azl)localObject).i;
                if (localObject == null)
                  break label212;
              }
              label212: for (localObject = ((azl)localObject).b; ; localObject = null)
              {
                if (localObject != null)
                {
                  int i7 = localView.getLeft();
                  int i8 = localView.getTop();
                  if ((i7 != ((View)localObject).getLeft()) || (i8 != ((View)localObject).getTop()))
                    ((View)localObject).layout(i7, i8, ((View)localObject).getWidth() + i7, ((View)localObject).getHeight() + i8);
                }
                i5 += 1;
                break;
              }
            }
          }
          this.D = false;
          b(false);
          int i5 = i4;
          int i6 = i2;
          i4 = i1;
          i2 = i5;
          i1 = i6;
        }
      }
    }
    while (true)
    {
      if (!this.r.isEmpty())
        invalidate();
      if (ez.a(this) != 2)
      {
        i(paramInt1, paramInt2);
        h(i4, i2);
      }
      if ((i1 != 0) || (i3 != 0))
      {
        onScrollChanged(0, 0, 0, 0);
        if (this.T != null)
          this.T.a(this, i1, i3);
      }
      if (!awakenScrollBars())
        invalidate();
      return;
      i3 = 0;
      i4 = 0;
      break label76;
      i2 = 0;
      i1 = 0;
      break;
      i3 = 0;
      i1 = 0;
      i2 = 0;
      i4 = 0;
    }
  }

  void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = this.d.c();
    int i1 = 0;
    if (i1 < i2)
    {
      azl localazl = b(this.d.c(i1));
      if ((localazl != null) && (!localazl.c()))
      {
        if (localazl.c < paramInt1 + paramInt2)
          break label83;
        localazl.a(-paramInt2, paramBoolean);
        azi.a(this.g, true);
      }
      while (true)
      {
        i1 += 1;
        break;
        label83: if (localazl.c >= paramInt1)
        {
          localazl.a(paramInt1 - 1, -paramInt2, paramBoolean);
          azi.a(this.g, true);
        }
      }
    }
    this.b.b(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }

  public void a(ayw paramayw)
  {
    a(paramayw, -1);
  }

  public void a(ayw paramayw, int paramInt)
  {
    if (this.p != null)
      this.p.a("Cannot add item decoration during a scroll  or layout");
    if (this.r.isEmpty())
      setWillNotDraw(false);
    if (paramInt < 0)
      this.r.add(paramayw);
    while (true)
    {
      n();
      requestLayout();
      return;
      this.r.add(paramInt, paramayw);
    }
  }

  public void a(String paramString)
  {
    if (this.D)
    {
      if (paramString == null)
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
      throw new IllegalStateException(paramString);
    }
  }

  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (!this.p.a(this, paramArrayList, paramInt1, paramInt2))
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }

  public void b(int paramInt)
  {
    this.p.a(this, this.g, paramInt);
  }

  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
      this.S.b(paramInt1, paramInt2);
  }

  public void b(boolean paramBoolean)
  {
    if (this.x)
    {
      if ((paramBoolean) && (this.y) && (this.p != null) && (this.o != null))
        m();
      this.x = false;
      this.y = false;
    }
  }

  public int c(View paramView)
  {
    paramView = b(paramView);
    if (paramView != null)
      return paramView.d();
    return -1;
  }

  public void c(int paramInt)
  {
    int i2 = this.d.b();
    int i1 = 0;
    while (i1 < i2)
    {
      this.d.b(i1).offsetTopAndBottom(paramInt);
      i1 += 1;
    }
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    int i1 = paramInt1;
    if (Math.abs(paramInt1) < this.Q)
      i1 = 0;
    paramInt1 = paramInt2;
    if (Math.abs(paramInt2) < this.Q)
      paramInt1 = 0;
    paramInt2 = Math.max(-this.R, Math.min(i1, this.R));
    paramInt1 = Math.max(-this.R, Math.min(paramInt1, this.R));
    if ((paramInt2 != 0) || (paramInt1 != 0))
    {
      this.S.a(paramInt2, paramInt1);
      bool = true;
    }
    return bool;
  }

  public boolean checkLayoutParams(LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ayz)) && (this.p.a((ayz)paramLayoutParams));
  }

  protected int computeHorizontalScrollExtent()
  {
    if (this.p.c())
      return this.p.d(this.g);
    return 0;
  }

  protected int computeHorizontalScrollOffset()
  {
    if (this.p.c())
      return this.p.b(this.g);
    return 0;
  }

  protected int computeHorizontalScrollRange()
  {
    if (this.p.c())
      return this.p.f(this.g);
    return 0;
  }

  protected int computeVerticalScrollExtent()
  {
    if (this.p.d())
      return this.p.e(this.g);
    return 0;
  }

  protected int computeVerticalScrollOffset()
  {
    if (this.p.d())
      return this.p.c(this.g);
    return 0;
  }

  protected int computeVerticalScrollRange()
  {
    if (this.p.d())
      return this.p.g(this.g);
    return 0;
  }

  public void d(int paramInt)
  {
    int i2 = this.d.b();
    int i1 = 0;
    while (i1 < i2)
    {
      this.d.b(i1).offsetLeftAndRight(paramInt);
      i1 += 1;
    }
  }

  public void d(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      h();
      this.E.a(-paramInt1);
      if (paramInt2 >= 0)
        break label69;
      j();
      this.F.a(-paramInt2);
    }
    while (true)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
        ez.d(this);
      return;
      if (paramInt1 <= 0)
        break;
      i();
      this.G.a(paramInt1);
      break;
      label69: if (paramInt2 > 0)
      {
        k();
        this.H.a(paramInt2);
      }
    }
  }

  public void d(View paramView)
  {
  }

  public void draw(Canvas paramCanvas)
  {
    int i3 = 1;
    int i4 = 0;
    super.draw(paramCanvas);
    int i2 = this.r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((ayw)this.r.get(i1)).b(paramCanvas, this, this.g);
      i1 += 1;
    }
    int i5;
    if ((this.E != null) && (!this.E.a()))
    {
      i5 = paramCanvas.save();
      if (this.l)
      {
        i1 = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i1 + -getHeight(), 0.0F);
        if ((this.E == null) || (!this.E.a(paramCanvas)))
          break label456;
        i2 = 1;
        label128: paramCanvas.restoreToCount(i5);
      }
    }
    while (true)
    {
      i1 = i2;
      if (this.F != null)
      {
        i1 = i2;
        if (!this.F.a())
        {
          i5 = paramCanvas.save();
          if (this.l)
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          if ((this.F == null) || (!this.F.a(paramCanvas)))
            break label461;
          i1 = 1;
          label202: i1 = i2 | i1;
          paramCanvas.restoreToCount(i5);
        }
      }
      i2 = i1;
      if (this.G != null)
      {
        i2 = i1;
        if (!this.G.a())
        {
          i5 = paramCanvas.save();
          int i6 = getWidth();
          if (!this.l)
            break label466;
          i2 = getPaddingTop();
          label257: paramCanvas.rotate(90.0F);
          paramCanvas.translate(-i2, -i6);
          if ((this.G == null) || (!this.G.a(paramCanvas)))
            break label471;
          i2 = 1;
          label295: i2 = i1 | i2;
          paramCanvas.restoreToCount(i5);
        }
      }
      i1 = i2;
      if (this.H != null)
      {
        i1 = i2;
        if (!this.H.a())
        {
          i5 = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.l)
            break label476;
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label372: i1 = i4;
          if (this.H != null)
          {
            i1 = i4;
            if (this.H.a(paramCanvas))
              i1 = 1;
          }
          i1 = i2 | i1;
          paramCanvas.restoreToCount(i5);
        }
      }
      if ((i1 == 0) && (this.f != null) && (this.r.size() > 0) && (this.f.b()))
        i1 = i3;
      while (true)
      {
        if (i1 != 0)
          ez.d(this);
        return;
        i1 = 0;
        break;
        label456: i2 = 0;
        break label128;
        label461: i1 = 0;
        break label202;
        label466: i2 = 0;
        break label257;
        label471: i2 = 0;
        break label295;
        label476: paramCanvas.translate(-getWidth(), -getHeight());
        break label372;
      }
      i2 = 0;
    }
  }

  void e()
  {
    this.c = new axy(new axz()
    {
      public azl a(int paramAnonymousInt)
      {
        return RecyclerView.this.a(paramAnonymousInt, true);
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.a(paramAnonymousInt1, paramAnonymousInt2, true);
        RecyclerView.this.h = true;
        azi localazi = RecyclerView.this.g;
        azi.a(localazi, azi.a(localazi) + paramAnonymousInt2);
      }

      public void a(aya paramAnonymousaya)
      {
        c(paramAnonymousaya);
      }

      public void b(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.a(paramAnonymousInt1, paramAnonymousInt2, false);
        RecyclerView.this.h = true;
      }

      public void b(aya paramAnonymousaya)
      {
        c(paramAnonymousaya);
      }

      public void c(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.g(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.i = true;
      }

      void c(aya paramAnonymousaya)
      {
        switch (paramAnonymousaya.a)
        {
        default:
          return;
        case 0:
          RecyclerView.d(RecyclerView.this).a(RecyclerView.this, paramAnonymousaya.b, paramAnonymousaya.c);
          return;
        case 1:
          RecyclerView.d(RecyclerView.this).b(RecyclerView.this, paramAnonymousaya.b, paramAnonymousaya.c);
          return;
        case 2:
          RecyclerView.d(RecyclerView.this).c(RecyclerView.this, paramAnonymousaya.b, paramAnonymousaya.c);
          return;
        case 3:
        }
        RecyclerView.d(RecyclerView.this).a(RecyclerView.this, paramAnonymousaya.b, paramAnonymousaya.c, 1);
      }

      public void d(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.f(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.h = true;
      }

      public void e(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.e(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.h = true;
      }
    });
  }

  void e(int paramInt1, int paramInt2)
  {
    int i5 = this.d.c();
    int i1;
    int i2;
    if (paramInt1 < paramInt2)
    {
      i1 = -1;
      i2 = paramInt2;
    }
    azl localazl;
    for (int i3 = paramInt1; ; i3 = paramInt2)
    {
      int i4 = 0;
      while (true)
      {
        if (i4 >= i5)
          break label127;
        localazl = b(this.d.c(i4));
        if ((localazl != null) && (localazl.c >= i3) && (localazl.c <= i2))
          break;
        i4 += 1;
      }
      i1 = 1;
      i2 = paramInt1;
    }
    if (localazl.c == paramInt1)
      localazl.a(paramInt2 - paramInt1, false);
    while (true)
    {
      azi.a(this.g, true);
      break;
      localazl.a(i1, false);
    }
    label127: this.b.a(paramInt1, paramInt2);
    requestLayout();
  }

  public void e(View paramView)
  {
  }

  public Rect f(View paramView)
  {
    ayz localayz = (ayz)paramView.getLayoutParams();
    if (!localayz.c)
      return localayz.b;
    Rect localRect = localayz.b;
    localRect.set(0, 0, 0, 0);
    int i2 = this.r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      this.n.set(0, 0, 0, 0);
      ((ayw)this.r.get(i1)).a(this.n, paramView, this, this.g);
      localRect.left += this.n.left;
      localRect.top += this.n.top;
      localRect.right += this.n.right;
      localRect.bottom += this.n.bottom;
      i1 += 1;
    }
    localayz.c = false;
    return localRect;
  }

  public void f()
  {
    if (!this.x)
    {
      this.x = true;
      this.y = false;
    }
  }

  void f(int paramInt1, int paramInt2)
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      azl localazl = b(this.d.c(i1));
      if ((localazl != null) && (!localazl.c()) && (localazl.c >= paramInt1))
      {
        localazl.a(paramInt2, false);
        azi.a(this.g, true);
      }
      i1 += 1;
    }
    this.b.b(paramInt1, paramInt2);
    requestLayout();
  }

  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject2 = this.p.d(paramView, paramInt);
    if (localObject2 != null);
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.o != null)
        {
          f();
          localObject1 = this.p.a(paramView, paramInt, this.b, this.g);
          b(false);
        }
      }
      localObject2 = localObject1;
    }
    while (localObject1 != null);
    return super.focusSearch(paramView, paramInt);
  }

  public void g()
  {
    setScrollState(0);
    c();
  }

  void g(int paramInt1, int paramInt2)
  {
    int i2 = this.d.c();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.d.c(i1);
      azl localazl = b(localView);
      if ((localazl == null) || (localazl.c()));
      while (true)
      {
        i1 += 1;
        break;
        if ((localazl.c >= paramInt1) && (localazl.c < paramInt1 + paramInt2))
        {
          localazl.a(2);
          if (v())
            localazl.a(64);
          ((ayz)localView.getLayoutParams()).c = true;
        }
      }
    }
    this.b.c(paramInt1, paramInt2);
  }

  public LayoutParams generateDefaultLayoutParams()
  {
    if (this.p == null)
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    return this.p.a();
  }

  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.p == null)
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    return this.p.a(getContext(), paramAttributeSet);
  }

  public LayoutParams generateLayoutParams(LayoutParams paramLayoutParams)
  {
    if (this.p == null)
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    return this.p.a(paramLayoutParams);
  }

  public ayp getAdapter()
  {
    return this.o;
  }

  public ays getItemAnimator()
  {
    return this.f;
  }

  public ayy getLayoutManager()
  {
    return this.p;
  }

  public azc getRecycledViewPool()
  {
    return this.b.f();
  }

  public int getScrollState()
  {
    return this.I;
  }

  void h()
  {
    if (this.E != null)
      return;
    this.E = new im(getContext());
    if (this.l)
    {
      this.E.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.E.a(getMeasuredHeight(), getMeasuredWidth());
  }

  void i()
  {
    if (this.G != null)
      return;
    this.G = new im(getContext());
    if (this.l)
    {
      this.G.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.G.a(getMeasuredHeight(), getMeasuredWidth());
  }

  void j()
  {
    if (this.F != null)
      return;
    this.F = new im(getContext());
    if (this.l)
    {
      this.F.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.F.a(getMeasuredWidth(), getMeasuredHeight());
  }

  void k()
  {
    if (this.H != null)
      return;
    this.H = new im(getContext());
    if (this.l)
    {
      this.H.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.H.a(getMeasuredWidth(), getMeasuredHeight());
  }

  void l()
  {
    this.H = null;
    this.F = null;
    this.G = null;
    this.E = null;
  }

  void m()
  {
    boolean bool2 = true;
    if (this.o == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    this.e.clear();
    f();
    this.D = true;
    y();
    Object localObject2 = this.g;
    Object localObject1;
    int i2;
    int i1;
    if ((azi.c(this.g)) && (this.i) && (v()))
    {
      localObject1 = new cq();
      ((azi)localObject2).c = ((cq)localObject1);
      this.i = false;
      this.h = false;
      azi.b(this.g, azi.b(this.g));
      this.g.d = this.o.a();
      if (!azi.c(this.g))
        break label268;
      this.g.a.clear();
      this.g.b.clear();
      i2 = this.d.b();
      i1 = 0;
      label166: if (i1 >= i2)
        break label268;
      localObject1 = b(this.d.b(i1));
      if ((!((azl)localObject1).c()) && ((!((azl)localObject1).k()) || (this.o.b())))
        break label224;
    }
    while (true)
    {
      i1 += 1;
      break label166;
      localObject1 = null;
      break;
      label224: localObject2 = ((azl)localObject1).b;
      this.g.a.put(localObject1, new ayx((azl)localObject1, ((View)localObject2).getLeft(), ((View)localObject2).getTop(), ((View)localObject2).getRight(), ((View)localObject2).getBottom()));
    }
    label268: long l1;
    boolean bool1;
    if (azi.b(this.g))
    {
      o();
      if (this.g.c != null)
      {
        i2 = this.d.b();
        i1 = 0;
        while (i1 < i2)
        {
          localObject1 = b(this.d.b(i1));
          if ((((azl)localObject1).m()) && (!((azl)localObject1).o()) && (!((azl)localObject1).c()))
          {
            l1 = a((azl)localObject1);
            this.g.c.put(Long.valueOf(l1), localObject1);
            this.g.a.remove(localObject1);
          }
          i1 += 1;
        }
      }
      bool1 = azi.d(this.g);
      azi.a(this.g, false);
      this.p.a(this.b, this.g);
      azi.a(this.g, bool1);
      localObject2 = new cq();
      i1 = 0;
      if (i1 < this.d.b())
      {
        localObject1 = this.d.b(i1);
        if (!b((View)localObject1).c());
      }
    }
    label1540: label1672: 
    while (true)
    {
      i1 += 1;
      break;
      i2 = 0;
      label488: if (i2 < this.g.a.size())
        if (((azl)this.g.a.b(i2)).b != localObject1);
      for (i2 = 1; ; i2 = 0)
      {
        if (i2 != 0)
          break label1672;
        ((cq)localObject2).put(localObject1, new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()));
        break;
        i2 += 1;
        break label488;
        p();
        this.c.c();
        while (true)
        {
          this.g.d = this.o.a();
          azi.a(this.g, 0);
          azi.b(this.g, false);
          this.p.a(this.b, this.g);
          azi.a(this.g, false);
          this.k = null;
          localObject1 = this.g;
          label706: label718: Object localObject3;
          if ((azi.c(this.g)) && (this.f != null))
          {
            bool1 = true;
            azi.c((azi)localObject1, bool1);
            if (!azi.c(this.g))
              break label1540;
            if (this.g.c == null)
              break label879;
            localObject1 = new cq();
            i2 = this.d.b();
            i1 = 0;
            if (i1 >= i2)
              break label976;
            localObject3 = b(this.d.b(i1));
            if (!((azl)localObject3).c())
              break label884;
          }
          label879: label884: Object localObject4;
          while (true)
          {
            i1 += 1;
            break label718;
            p();
            this.c.e();
            if (this.g.c == null)
              break label1663;
            i2 = this.d.b();
            i1 = 0;
            while (i1 < i2)
            {
              localObject1 = b(this.d.b(i1));
              if ((((azl)localObject1).m()) && (!((azl)localObject1).o()) && (!((azl)localObject1).c()))
              {
                l1 = a((azl)localObject1);
                this.g.c.put(Long.valueOf(l1), localObject1);
                this.g.a.remove(localObject1);
              }
              i1 += 1;
            }
            bool1 = false;
            break;
            localObject1 = null;
            break label706;
            localObject4 = ((azl)localObject3).b;
            l1 = a((azl)localObject3);
            if ((localObject1 != null) && (this.g.c.get(Long.valueOf(l1)) != null))
              ((cq)localObject1).put(Long.valueOf(l1), localObject3);
            else
              this.g.b.put(localObject3, new ayx((azl)localObject3, ((View)localObject4).getLeft(), ((View)localObject4).getTop(), ((View)localObject4).getRight(), ((View)localObject4).getBottom()));
          }
          label976: a((cq)localObject2);
          i1 = this.g.a.size() - 1;
          while (i1 >= 0)
          {
            localObject3 = (azl)this.g.a.b(i1);
            if (!this.g.b.containsKey(localObject3))
            {
              localObject3 = (ayx)this.g.a.c(i1);
              this.g.a.d(i1);
              removeDetachedView(((ayx)localObject3).a.b, false);
              this.b.c(((ayx)localObject3).a);
              a((ayx)localObject3);
            }
            i1 -= 1;
          }
          i1 = this.g.b.size();
          if (i1 > 0)
          {
            i1 -= 1;
            if (i1 >= 0)
            {
              localObject4 = (azl)this.g.b.b(i1);
              ayx localayx = (ayx)this.g.b.c(i1);
              if ((this.g.a.isEmpty()) || (!this.g.a.containsKey(localObject4)))
              {
                this.g.b.d(i1);
                if (localObject2 == null)
                  break label1242;
              }
              label1242: for (localObject3 = (Rect)((cq)localObject2).get(((azl)localObject4).b); ; localObject3 = null)
              {
                a((azl)localObject4, (Rect)localObject3, localayx.b, localayx.c);
                i1 -= 1;
                break;
              }
            }
          }
          i2 = this.g.b.size();
          i1 = 0;
          while (i1 < i2)
          {
            localObject2 = (azl)this.g.b.b(i1);
            localObject3 = (ayx)this.g.b.c(i1);
            localObject4 = (ayx)this.g.a.get(localObject2);
            if ((localObject4 != null) && (localObject3 != null) && ((((ayx)localObject4).b != ((ayx)localObject3).b) || (((ayx)localObject4).c != ((ayx)localObject3).c)))
            {
              ((azl)localObject2).a(false);
              if (this.f.a((azl)localObject2, ((ayx)localObject4).b, ((ayx)localObject4).c, ((ayx)localObject3).b, ((ayx)localObject3).c))
                w();
            }
            i1 += 1;
          }
          if (this.g.c != null)
          {
            i1 = this.g.c.size();
            i1 -= 1;
            label1425: if (i1 < 0)
              break label1540;
            l1 = ((Long)this.g.c.b(i1)).longValue();
            localObject2 = (azl)this.g.c.get(Long.valueOf(l1));
            localObject3 = ((azl)localObject2).b;
            if (!((azl)localObject2).c())
              break label1496;
          }
          while (true)
          {
            i1 -= 1;
            break label1425;
            i1 = 0;
            break;
            label1496: if ((azd.a(this.b) != null) && (azd.a(this.b).contains(localObject2)))
              a((azl)localObject2, (azl)((cq)localObject1).get(Long.valueOf(l1)));
          }
          b(false);
          localObject1 = this.p;
          localObject2 = this.b;
          if (!azi.b(this.g));
          for (bool1 = bool2; ; bool1 = false)
          {
            ((ayy)localObject1).a((azd)localObject2, bool1);
            azi.b(this.g, this.g.d);
            this.C = false;
            azi.c(this.g, false);
            azi.d(this.g, false);
            this.D = false;
            ayy.a(this.p, false);
            if (azd.a(this.b) != null)
              azd.a(this.b).clear();
            this.g.c = null;
            return;
          }
          label1663: localObject2 = null;
        }
      }
    }
  }

  void n()
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      ((ayz)this.d.c(i1).getLayoutParams()).c = true;
      i1 += 1;
    }
    this.b.i();
  }

  void o()
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      azl localazl = b(this.d.c(i1));
      if (!localazl.c())
        localazl.b();
      i1 += 1;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.u = true;
    this.w = false;
    if (this.p != null)
      this.p.b(this);
    this.V = false;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.f != null)
      this.f.c();
    this.w = false;
    g();
    this.u = false;
    if (this.p != null)
      this.p.a(this, this.b);
    removeCallbacks(this.W);
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = this.r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((ayw)this.r.get(i1)).a(paramCanvas, this, this.g);
      i1 += 1;
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = -1;
    if (a(paramMotionEvent))
    {
      u();
      return true;
    }
    boolean bool1 = this.p.c();
    boolean bool2 = this.p.d();
    if (this.K == null)
      this.K = VelocityTracker.obtain();
    this.K.addMovement(paramMotionEvent);
    int i2 = eh.a(paramMotionEvent);
    int i1 = eh.b(paramMotionEvent);
    label112: int i4;
    int i5;
    switch (i2)
    {
    case 4:
    default:
    case 0:
    case 5:
    case 2:
      while (true)
        if (this.I != 1)
        {
          return false;
          this.J = eh.b(paramMotionEvent, 0);
          i1 = (int)(paramMotionEvent.getX() + 0.5F);
          this.N = i1;
          this.L = i1;
          i1 = (int)(paramMotionEvent.getY() + 0.5F);
          this.O = i1;
          this.M = i1;
          if (this.I == 2)
          {
            getParent().requestDisallowInterceptTouchEvent(true);
            setScrollState(1);
            continue;
            this.J = eh.b(paramMotionEvent, i1);
            i2 = (int)(eh.c(paramMotionEvent, i1) + 0.5F);
            this.N = i2;
            this.L = i2;
            i1 = (int)(eh.d(paramMotionEvent, i1) + 0.5F);
            this.O = i1;
            this.M = i1;
            continue;
            i2 = eh.a(paramMotionEvent, this.J);
            if (i2 < 0)
            {
              Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.J + " not found. Did any MotionEvents get skipped?");
              return false;
            }
            i1 = (int)(eh.c(paramMotionEvent, i2) + 0.5F);
            i2 = (int)(eh.d(paramMotionEvent, i2) + 0.5F);
            if (this.I != 1)
            {
              i1 -= this.L;
              i4 = i2 - this.M;
              if ((!bool1) || (Math.abs(i1) <= this.P))
                break label501;
              i2 = this.L;
              i5 = this.P;
              if (i1 < 0)
              {
                i1 = -1;
                label380: this.N = (i1 * i5 + i2);
              }
            }
          }
        }
    case 6:
    case 1:
    case 3:
    }
    label471: label501: for (i1 = 1; ; i1 = 0)
    {
      i2 = i1;
      if (bool2)
      {
        i2 = i1;
        if (Math.abs(i4) > this.P)
        {
          i2 = this.M;
          i5 = this.P;
          if (i4 >= 0)
            break label471;
        }
      }
      for (i1 = i3; ; i1 = 1)
      {
        this.O = (i2 + i1 * i5);
        i2 = 1;
        if (i2 == 0)
          break;
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        break;
        i1 = 1;
        break label380;
      }
      c(paramMotionEvent);
      break label112;
      this.K.clear();
      break label112;
      u();
      break label112;
      break;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f();
    m();
    b(false);
    this.w = true;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.z)
    {
      f();
      y();
      if (azi.b(this.g))
      {
        azi.b(this.g, true);
        this.z = false;
        b(false);
      }
    }
    else
    {
      if (this.o == null)
        break label111;
    }
    label111: for (this.g.d = this.o.a(); ; this.g.d = 0)
    {
      this.p.a(this.b, this.g, paramInt1, paramInt2);
      azi.b(this.g, false);
      return;
      this.c.e();
      azi.b(this.g, false);
      break;
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.k = ((RecyclerView.SavedState)paramParcelable);
    super.onRestoreInstanceState(this.k.getSuperState());
    if ((this.p != null) && (this.k.a != null))
      this.p.a(this.k.a);
  }

  protected Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (this.k != null)
    {
      RecyclerView.SavedState.a(localSavedState, this.k);
      return localSavedState;
    }
    if (this.p != null)
    {
      localSavedState.a = this.p.b();
      return localSavedState;
    }
    localSavedState.a = null;
    return localSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
      l();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = -1;
    if (b(paramMotionEvent))
    {
      u();
      return true;
    }
    boolean bool1 = this.p.c();
    boolean bool2 = this.p.d();
    if (this.K == null)
      this.K = VelocityTracker.obtain();
    this.K.addMovement(paramMotionEvent);
    int i2 = eh.a(paramMotionEvent);
    int i1 = eh.b(paramMotionEvent);
    int i4;
    int i5;
    int i6;
    int i7;
    switch (i2)
    {
    case 4:
    default:
      return true;
    case 0:
      this.J = eh.b(paramMotionEvent, 0);
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      this.N = i1;
      this.L = i1;
      i1 = (int)(paramMotionEvent.getY() + 0.5F);
      this.O = i1;
      this.M = i1;
      return true;
    case 5:
      this.J = eh.b(paramMotionEvent, i1);
      i2 = (int)(eh.c(paramMotionEvent, i1) + 0.5F);
      this.N = i2;
      this.L = i2;
      i1 = (int)(eh.d(paramMotionEvent, i1) + 0.5F);
      this.O = i1;
      this.M = i1;
      return true;
    case 2:
      i1 = eh.a(paramMotionEvent, this.J);
      if (i1 < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.J + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      i4 = (int)(eh.c(paramMotionEvent, i1) + 0.5F);
      i5 = (int)(eh.d(paramMotionEvent, i1) + 0.5F);
      if (this.I != 1)
      {
        i1 = i4 - this.L;
        i6 = i5 - this.M;
        if ((!bool1) || (Math.abs(i1) <= this.P))
          break label678;
        i2 = this.L;
        i7 = this.P;
        if (i1 >= 0)
          break label539;
        i1 = -1;
        this.N = (i1 * i7 + i2);
      }
      break;
    case 6:
    case 1:
    case 3:
    }
    label539: label545: label678: for (i1 = 1; ; i1 = 0)
    {
      i2 = i1;
      if (bool2)
      {
        i2 = i1;
        if (Math.abs(i6) > this.P)
        {
          i2 = this.M;
          i7 = this.P;
          if (i6 >= 0)
            break label545;
          i1 = i3;
          label436: this.O = (i2 + i1 * i7);
          i2 = 1;
        }
      }
      if (i2 != 0)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      if (this.I == 1)
      {
        i1 = this.N;
        i2 = this.O;
        if (!bool1)
          break label551;
        i1 = -(i4 - i1);
        label504: if (!bool2)
          break label557;
      }
      label551: label557: for (i2 = -(i5 - i2); ; i2 = 0)
      {
        a(i1, i2);
        this.N = i4;
        this.O = i5;
        return true;
        i1 = 1;
        break;
        i1 = 1;
        break label436;
        i1 = 0;
        break label504;
      }
      c(paramMotionEvent);
      return true;
      this.K.computeCurrentVelocity(1000, this.R);
      float f1;
      if (bool1)
      {
        f1 = -eu.a(this.K, this.J);
        if (!bool2)
          break label667;
      }
      for (float f2 = -eu.b(this.K, this.J); ; f2 = 0.0F)
      {
        if (((f1 == 0.0F) && (f2 == 0.0F)) || (!c((int)f1, (int)f2)))
          setScrollState(0);
        this.K.clear();
        d();
        return true;
        f1 = 0.0F;
        break;
      }
      u();
      return true;
    }
  }

  void p()
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      azl localazl = b(this.d.c(i1));
      if (!localazl.c())
        localazl.a();
      i1 += 1;
    }
    this.b.h();
  }

  void q()
  {
    int i2 = this.d.b();
    int i1 = 0;
    if (i1 < i2)
    {
      azl localazl = b(this.d.b(i1));
      if ((localazl == null) || (localazl.c()));
      while (true)
      {
        i1 += 1;
        break;
        if ((localazl.o()) || (localazl.k()))
        {
          requestLayout();
        }
        else if (localazl.l())
        {
          int i3 = this.o.a(localazl.c);
          if (localazl.f() == i3)
          {
            if ((!localazl.m()) || (!v()))
              this.o.b(localazl, localazl.c);
            else
              requestLayout();
          }
          else
          {
            localazl.a(4);
            requestLayout();
          }
        }
      }
    }
  }

  void r()
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      azl localazl = b(this.d.c(i1));
      if ((localazl != null) && (!localazl.c()))
        localazl.a(6);
      i1 += 1;
    }
    n();
    this.b.g();
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    boolean bool = false;
    if ((!this.p.a(this, this.g, paramView1, paramView2)) && (paramView2 != null))
    {
      this.n.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      offsetDescendantRectToMyCoords(paramView2, this.n);
      offsetRectIntoDescendantCoords(paramView1, this.n);
      Rect localRect = this.n;
      if (!this.w)
        bool = true;
      requestChildRectangleOnScreen(paramView1, localRect, bool);
    }
    super.requestChildFocus(paramView1, paramView2);
  }

  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.p.a(this, paramView, paramRect, paramBoolean);
  }

  public void requestLayout()
  {
    if (!this.x)
    {
      super.requestLayout();
      return;
    }
    this.y = true;
  }

  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.p == null)
      throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    boolean bool1 = this.p.c();
    boolean bool2 = this.p.d();
    if ((bool1) || (bool2))
    {
      if (!bool1)
        break label60;
      if (!bool2)
        break label65;
    }
    while (true)
    {
      a(paramInt1, paramInt2);
      return;
      label60: paramInt1 = 0;
      break;
      label65: paramInt2 = 0;
    }
  }

  public void scrollTo(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
  }

  public void setAdapter(ayp paramayp)
  {
    a(paramayp, false, true);
    requestLayout();
  }

  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.l)
      l();
    this.l = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.w)
      requestLayout();
  }

  public void setHasFixedSize(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  public void setItemAnimator(ays paramays)
  {
    if (this.f != null)
    {
      this.f.c();
      this.f.a(null);
    }
    this.f = paramays;
    if (this.f != null)
      this.f.a(this.U);
  }

  public void setItemViewCacheSize(int paramInt)
  {
    this.b.a(paramInt);
  }

  public void setLayoutManager(ayy paramayy)
  {
    if (paramayy == this.p)
      return;
    if (this.p != null)
    {
      if (this.u)
        this.p.a(this, this.b);
      this.p.a(null);
    }
    this.b.a();
    this.d.a();
    this.p = paramayy;
    if (paramayy != null)
    {
      if (paramayy.i != null)
        throw new IllegalArgumentException("LayoutManager " + paramayy + " is already attached to a RecyclerView: " + paramayy.i);
      this.p.a(this);
      if (this.u)
        this.p.b(this);
    }
    requestLayout();
  }

  public void setOnScrollListener(azb paramazb)
  {
    this.T = paramazb;
  }

  public void setRecycledViewPool(azc paramazc)
  {
    this.b.a(paramazc);
  }

  public void setRecyclerListener(aze paramaze)
  {
    this.q = paramaze;
  }

  public void setViewCacheExtension(azj paramazj)
  {
    this.b.a(paramazj);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.recyclerview.RecyclerView
 * JD-Core Version:    0.6.2
 */