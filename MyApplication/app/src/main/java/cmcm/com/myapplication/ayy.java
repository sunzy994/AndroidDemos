package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.lazyswipe.widget.recyclerview.RecyclerView;
import java.util.ArrayList;

public abstract class ayy
{
  private boolean a = false;
  ayb h;
  public RecyclerView i;
  azg j;

  public static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int m = 1073741824;
    int k = Math.max(0, paramInt1 - paramInt2);
    if (paramBoolean)
      if (paramInt3 >= 0)
      {
        paramInt1 = paramInt3;
        paramInt2 = m;
      }
    while (true)
    {
      return MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
      paramInt2 = 0;
      paramInt1 = 0;
      continue;
      paramInt2 = m;
      paramInt1 = paramInt3;
      if (paramInt3 < 0)
        if (paramInt3 == -1)
        {
          paramInt1 = k;
          paramInt2 = m;
        }
        else if (paramInt3 == -2)
        {
          paramInt2 = -2147483648;
          paramInt1 = k;
        }
        else
        {
          paramInt2 = 0;
          paramInt1 = 0;
        }
    }
  }

  private void a(int paramInt, View paramView)
  {
    this.h.d(paramInt);
  }

  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    azl localazl = RecyclerView.b(paramView);
    ayz localayz;
    if ((paramBoolean) || (localazl.o()))
    {
      RecyclerView.c(this.i, paramView);
      localayz = (ayz)paramView.getLayoutParams();
      if ((!localazl.i()) && (!localazl.g()))
        break label120;
      if (!localazl.g())
        break label112;
      localazl.h();
      label64: this.h.a(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    while (true)
    {
      if (localayz.d)
      {
        localazl.b.invalidate();
        localayz.d = false;
      }
      return;
      RecyclerView.d(this.i, paramView);
      break;
      label112: localazl.j();
      break label64;
      label120: if (paramView.getParent() == this.i)
      {
        int m = this.h.b(paramView);
        int k = paramInt;
        if (paramInt == -1)
          k = this.h.b();
        if (m == -1)
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.i.indexOfChild(paramView));
        if (m != k)
          RecyclerView.d(this.i).a(m, k);
      }
      else
      {
        this.h.a(paramView, paramInt, false);
        localayz.c = true;
        if ((this.j != null) && (this.j.h()))
          this.j.b(paramView);
      }
    }
  }

  private void a(azd paramazd, int paramInt, View paramView)
  {
    azl localazl = RecyclerView.b(paramView);
    if (localazl.c())
      return;
    if ((localazl.k()) && (!localazl.o()) && (!localazl.m()) && (!RecyclerView.f(this.i).b()))
    {
      e(paramInt);
      paramazd.b(localazl);
      return;
    }
    f(paramInt);
    paramazd.c(paramView);
  }

  private void b(azg paramazg)
  {
    if (this.j == paramazg)
      this.j = null;
  }

  public int a(int paramInt, azd paramazd, azi paramazi)
  {
    return 0;
  }

  public View a(View paramView, int paramInt, azd paramazd, azi paramazi)
  {
    return null;
  }

  public abstract ayz a();

  public ayz a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new ayz(paramContext, paramAttributeSet);
  }

  public ayz a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ayz))
      return new ayz((ayz)paramLayoutParams);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new ayz((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new ayz(paramLayoutParams);
  }

  public void a(int paramInt1, int paramInt2)
  {
    View localView = g(paramInt1);
    if (localView == null)
      throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1);
    f(paramInt1);
    c(localView, paramInt2);
  }

  public void a(int paramInt, azd paramazd)
  {
    View localView = g(paramInt);
    e(paramInt);
    paramazd.a(localView);
  }

  public void a(Parcelable paramParcelable)
  {
  }

  public void a(View paramView)
  {
    a(paramView, -1);
  }

  public void a(View paramView, int paramInt)
  {
    a(paramView, paramInt, true);
  }

  public void a(View paramView, int paramInt1, int paramInt2)
  {
    ayz localayz = (ayz)paramView.getLayoutParams();
    Rect localRect = this.i.f(paramView);
    int k = localRect.left;
    int m = localRect.right;
    int n = localRect.top;
    int i1 = localRect.bottom;
    paramView.measure(a(l(), k + m + paramInt1 + (n() + p() + localayz.leftMargin + localayz.rightMargin), localayz.width, c()), a(m(), i1 + n + paramInt2 + (o() + q() + localayz.topMargin + localayz.bottomMargin), localayz.height, d()));
  }

  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((ayz)paramView.getLayoutParams()).b;
    paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }

  public void a(View paramView, int paramInt, ayz paramayz)
  {
    azl localazl = RecyclerView.b(paramView);
    if (localazl.o())
      RecyclerView.c(this.i, paramView);
    while (true)
    {
      this.h.a(paramView, paramInt, paramayz, localazl.o());
      return;
      RecyclerView.d(this.i, paramView);
    }
  }

  public void a(View paramView, azd paramazd)
  {
    c(paramView);
    paramazd.a(paramView);
  }

  public void a(ayp paramayp1, ayp paramayp2)
  {
  }

  public void a(azd paramazd)
  {
    int k = k() - 1;
    while (k >= 0)
    {
      a(paramazd, k, g(k));
      k -= 1;
    }
  }

  public void a(azd paramazd, azi paramazi)
  {
    Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
  }

  public void a(azd paramazd, azi paramazi, int paramInt1, int paramInt2)
  {
    int m = MeasureSpec.getMode(paramInt1);
    int k = MeasureSpec.getMode(paramInt2);
    paramInt1 = MeasureSpec.getSize(paramInt1);
    paramInt2 = MeasureSpec.getSize(paramInt2);
    switch (m)
    {
    default:
      paramInt1 = s();
    case 1073741824:
    case -2147483648:
    }
    switch (k)
    {
    default:
      paramInt2 = t();
    case 1073741824:
    case -2147483648:
    }
    b(paramInt1, paramInt2);
  }

  public void a(azd paramazd, boolean paramBoolean)
  {
    int m = paramazd.d();
    int k = 0;
    if (k < m)
    {
      View localView = paramazd.d(k);
      if (RecyclerView.b(localView).c());
      while (true)
      {
        k += 1;
        break;
        if (paramBoolean)
          RecyclerView.c(this.i, localView, false);
        paramazd.b(localView);
      }
    }
    paramazd.e();
    if ((paramBoolean) && (m > 0))
      this.i.invalidate();
  }

  public void a(azg paramazg)
  {
    if ((this.j != null) && (paramazg != this.j) && (this.j.h()))
      this.j.f();
    this.j = paramazg;
    this.j.a(this.i, this);
  }

  public void a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      this.i = null;
      this.h = null;
      return;
    }
    this.i = paramRecyclerView;
    this.h = paramRecyclerView.d;
  }

  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
  }

  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void a(RecyclerView paramRecyclerView, azd paramazd)
  {
    c(paramRecyclerView);
  }

  public void a(RecyclerView paramRecyclerView, azi paramazi, int paramInt)
  {
    Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
  }

  public void a(String paramString)
  {
    if (this.i != null)
      this.i.a(paramString);
  }

  public boolean a(ayz paramayz)
  {
    return paramayz != null;
  }

  public boolean a(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
  {
    int m = n();
    int i1 = o();
    int n = l();
    int i5 = p();
    int k = m();
    int i2 = q();
    int i6 = paramView.getLeft() + paramRect.left;
    int i3 = paramView.getTop() + paramRect.top;
    int i7 = paramRect.right;
    int i4 = paramRect.bottom;
    m = Math.min(0, i6 - m);
    i1 = Math.min(0, i3 - i1);
    n = Math.max(0, i7 + i6 - (n - i5));
    i2 = Math.max(0, i4 + i3 - (k - i2));
    if (ez.h(paramRecyclerView) == 1)
      if (n != 0)
      {
        k = n;
        if (i1 == 0)
          break label200;
        m = i1;
        label152: if ((k == 0) && (m == 0))
          break label218;
        if (!paramBoolean)
          break label207;
        paramRecyclerView.scrollBy(k, m);
      }
    while (true)
    {
      return true;
      k = m;
      break;
      k = m;
      if (m != 0)
        break;
      k = n;
      break;
      label200: m = i2;
      break label152;
      label207: paramRecyclerView.b(k, m);
    }
    label218: return false;
  }

  @Deprecated
  public boolean a(RecyclerView paramRecyclerView, View paramView1, View paramView2)
  {
    return false;
  }

  public boolean a(RecyclerView paramRecyclerView, azi paramazi, View paramView1, View paramView2)
  {
    return a(paramRecyclerView, paramView1, paramView2);
  }

  public boolean a(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    return false;
  }

  public int b(int paramInt, azd paramazd, azi paramazi)
  {
    return 0;
  }

  public int b(azi paramazi)
  {
    return 0;
  }

  public Parcelable b()
  {
    return null;
  }

  public View b(int paramInt)
  {
    int m = k();
    int k = 0;
    if (k < m)
    {
      View localView = g(k);
      azl localazl = RecyclerView.b(localView);
      if (localazl == null);
      while ((localazl.d() != paramInt) || (localazl.c()) || ((!this.i.g.a()) && (localazl.o())))
      {
        k += 1;
        break;
      }
      return localView;
    }
    return null;
  }

  public void b(int paramInt1, int paramInt2)
  {
    RecyclerView.b(this.i, paramInt1, paramInt2);
  }

  public void b(View paramView)
  {
    b(paramView, -1);
  }

  public void b(View paramView, int paramInt)
  {
    a(paramView, paramInt, false);
  }

  public void b(azd paramazd)
  {
    int k = k() - 1;
    while (k >= 0)
    {
      if (!RecyclerView.b(g(k)).c())
        a(k, paramazd);
      k -= 1;
    }
  }

  public void b(RecyclerView paramRecyclerView)
  {
  }

  public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
  }

  public int c(azi paramazi)
  {
    return 0;
  }

  public void c(View paramView)
  {
    this.h.a(paramView);
  }

  public void c(View paramView, int paramInt)
  {
    a(paramView, paramInt, (ayz)paramView.getLayoutParams());
  }

  @Deprecated
  public void c(RecyclerView paramRecyclerView)
  {
  }

  public void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
  }

  public boolean c()
  {
    return false;
  }

  public int d(View paramView)
  {
    return ((ayz)paramView.getLayoutParams()).c();
  }

  public int d(azi paramazi)
  {
    return 0;
  }

  public View d(View paramView, int paramInt)
  {
    return null;
  }

  public void d(int paramInt)
  {
  }

  public void d(RecyclerView paramRecyclerView)
  {
  }

  public boolean d()
  {
    return false;
  }

  public int e(View paramView)
  {
    Rect localRect = ((ayz)paramView.getLayoutParams()).b;
    int k = paramView.getMeasuredWidth();
    int m = localRect.left;
    return localRect.right + (k + m);
  }

  public int e(azi paramazi)
  {
    return 0;
  }

  public void e(int paramInt)
  {
    if (g(paramInt) != null)
      this.h.a(paramInt);
  }

  public int f(View paramView)
  {
    Rect localRect = ((ayz)paramView.getLayoutParams()).b;
    int k = paramView.getMeasuredHeight();
    int m = localRect.top;
    return localRect.bottom + (k + m);
  }

  public int f(azi paramazi)
  {
    return 0;
  }

  public void f(int paramInt)
  {
    a(paramInt, g(paramInt));
  }

  public int g(View paramView)
  {
    return paramView.getLeft() - m(paramView);
  }

  public int g(azi paramazi)
  {
    return 0;
  }

  public View g(int paramInt)
  {
    if (this.h != null)
      return this.h.b(paramInt);
    return null;
  }

  public int h(View paramView)
  {
    return paramView.getTop() - k(paramView);
  }

  public void h(int paramInt)
  {
    if (this.i != null)
      this.i.d(paramInt);
  }

  public boolean h()
  {
    return false;
  }

  public int i(View paramView)
  {
    return paramView.getRight() + n(paramView);
  }

  public void i()
  {
    if (this.i != null)
      this.i.requestLayout();
  }

  public void i(int paramInt)
  {
    if (this.i != null)
      this.i.c(paramInt);
  }

  public int j()
  {
    return ez.h(this.i);
  }

  public int j(View paramView)
  {
    return paramView.getBottom() + l(paramView);
  }

  public void j(int paramInt)
  {
  }

  public int k()
  {
    if (this.h != null)
      return this.h.b();
    return 0;
  }

  public int k(View paramView)
  {
    return ((ayz)paramView.getLayoutParams()).b.top;
  }

  public int l()
  {
    if (this.i != null)
      return this.i.getWidth();
    return 0;
  }

  public int l(View paramView)
  {
    return ((ayz)paramView.getLayoutParams()).b.bottom;
  }

  public int m()
  {
    if (this.i != null)
      return this.i.getHeight();
    return 0;
  }

  public int m(View paramView)
  {
    return ((ayz)paramView.getLayoutParams()).b.left;
  }

  public int n()
  {
    if (this.i != null)
      return this.i.getPaddingLeft();
    return 0;
  }

  public int n(View paramView)
  {
    return ((ayz)paramView.getLayoutParams()).b.right;
  }

  public int o()
  {
    if (this.i != null)
      return this.i.getPaddingTop();
    return 0;
  }

  public int p()
  {
    if (this.i != null)
      return this.i.getPaddingRight();
    return 0;
  }

  public int q()
  {
    if (this.i != null)
      return this.i.getPaddingBottom();
    return 0;
  }

  public View r()
  {
    if (this.i == null);
    View localView;
    do
    {
      return null;
      localView = this.i.getFocusedChild();
    }
    while ((localView == null) || (this.h.c(localView)));
    return localView;
  }

  public int s()
  {
    return ez.k(this.i);
  }

  public int t()
  {
    return ez.l(this.i);
  }

  public void u()
  {
    if (this.j != null)
      this.j.f();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ayy
 * JD-Core Version:    0.6.2
 */