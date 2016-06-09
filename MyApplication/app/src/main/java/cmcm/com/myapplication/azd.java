package cmcm.com.myapplication;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import com.lazyswipe.widget.recyclerview.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class azd
{
  final ArrayList<azl> a = new ArrayList();
  final ArrayList<azl> b = new ArrayList();
  private ArrayList<azl> d = null;
  private final List<azl> e = Collections.unmodifiableList(this.a);
  private int f = 2;
  private azc g;
  private azj h;

  public azd(RecyclerView paramRecyclerView)
  {
  }

  private void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
        a((ViewGroup)localView, true);
      i -= 1;
    }
    if (!paramBoolean)
      return;
    if (paramViewGroup.getVisibility() == 4)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setVisibility(4);
      return;
    }
    i = paramViewGroup.getVisibility();
    paramViewGroup.setVisibility(4);
    paramViewGroup.setVisibility(i);
  }

  private void d(View paramView)
  {
    if ((RecyclerView.k(this.c) != null) && (RecyclerView.k(this.c).isEnabled()))
    {
      if (ez.e(paramView) == 0)
        ez.c(paramView, 1);
      if (ez.b(paramView));
    }
  }

  private void e(azl paramazl)
  {
    if ((paramazl.b instanceof ViewGroup))
      a((ViewGroup)paramazl.b, false);
  }

  View a(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt >= this.c.g.e()))
      throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + this.c.g.e());
    Object localObject2;
    int i;
    if (this.c.g.a())
    {
      localObject2 = e(paramInt);
      if (localObject2 != null)
        i = 1;
    }
    while (true)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = a(paramInt, -1, paramBoolean);
        localObject1 = localObject2;
        if (localObject2 != null)
          if (!a((azl)localObject2))
            if (!paramBoolean)
            {
              ((azl)localObject2).a(4);
              if (((azl)localObject2).g())
              {
                RecyclerView.a(this.c, ((azl)localObject2).b, false);
                ((azl)localObject2).h();
                label173: b((azl)localObject2);
              }
            }
            else
            {
              localObject1 = null;
            }
      }
      while (true)
      {
        Object localObject3 = localObject1;
        int k = i;
        int j;
        if (localObject1 == null)
        {
          int m = this.c.c.a(paramInt);
          if ((m < 0) || (m >= RecyclerView.f(this.c).a()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + m + ")." + "state:" + this.c.g.e());
            i = 0;
            break;
            if (!((azl)localObject2).i())
              break label173;
            ((azl)localObject2).j();
            break label173;
            i = 1;
            localObject1 = localObject2;
            continue;
          }
          k = RecyclerView.f(this.c).a(m);
          localObject2 = localObject1;
          j = i;
          if (RecyclerView.f(this.c).b())
          {
            localObject1 = a(RecyclerView.f(this.c).b(m), k, paramBoolean);
            localObject2 = localObject1;
            j = i;
            if (localObject1 != null)
            {
              ((azl)localObject1).c = m;
              j = 1;
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (this.h != null)
            {
              localObject3 = this.h.a(this, paramInt, k);
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject2 = this.c.a((View)localObject3);
                if (localObject2 == null)
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                localObject1 = localObject2;
                if (((azl)localObject2).c())
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
              }
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = f().a(RecyclerView.f(this.c).a(m));
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              ((azl)localObject1).p();
              localObject2 = localObject1;
              if (RecyclerView.t())
              {
                e((azl)localObject1);
                localObject2 = localObject1;
              }
            }
          }
          localObject3 = localObject2;
          k = j;
          if (localObject2 == null)
          {
            localObject2 = RecyclerView.f(this.c).c(this.c, RecyclerView.f(this.c).a(m));
            i = j;
          }
        }
        while (true)
        {
          if ((this.c.g.a()) && (((azl)localObject2).n()))
          {
            ((azl)localObject2).g = paramInt;
            paramInt = 0;
          }
          while (true)
          {
            localObject1 = ((azl)localObject2).b.getLayoutParams();
            if (localObject1 == null)
            {
              localObject1 = (ayz)this.c.generateDefaultLayoutParams();
              ((azl)localObject2).b.setLayoutParams((LayoutParams)localObject1);
              label641: ((ayz)localObject1).a = ((azl)localObject2);
              if ((i == 0) || (paramInt == 0))
                break label797;
            }
            label797: for (paramBoolean = bool; ; paramBoolean = false)
            {
              ((ayz)localObject1).d = paramBoolean;
              return ((azl)localObject2).b;
              if ((((azl)localObject2).n()) && (!((azl)localObject2).l()) && (!((azl)localObject2).k()))
                break label802;
              j = this.c.c.a(paramInt);
              RecyclerView.f(this.c).b((azl)localObject2, j);
              d(((azl)localObject2).b);
              if (this.c.g.a())
                ((azl)localObject2).g = paramInt;
              paramInt = 1;
              break;
              if (!this.c.checkLayoutParams((LayoutParams)localObject1))
              {
                localObject1 = (ayz)this.c.generateLayoutParams((LayoutParams)localObject1);
                ((azl)localObject2).b.setLayoutParams((LayoutParams)localObject1);
                break label641;
              }
              localObject1 = (ayz)localObject1;
              break label641;
            }
            label802: paramInt = 0;
          }
          i = k;
          localObject2 = localObject3;
        }
      }
      localObject2 = null;
      i = 0;
    }
  }

  azl a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    int k = this.a.size();
    int i = 0;
    Object localObject;
    if (i < k)
    {
      localObject = (azl)this.a.get(i);
      if ((((azl)localObject).i()) || (((azl)localObject).d() != paramInt1) || (((azl)localObject).k()) || ((!azi.e(this.c.g)) && (((azl)localObject).o())))
        break label275;
      if ((paramInt2 != -1) && (((azl)localObject).f() != paramInt2))
        Log.e("RecyclerView", "Scrap view for position " + paramInt1 + " isn't dirty but has" + " wrong view type! (found " + ((azl)localObject).f() + " but expected " + paramInt2 + ")");
    }
    else
    {
      if (!paramBoolean)
      {
        localObject = this.c.d.a(paramInt1, paramInt2);
        if (localObject != null)
          this.c.f.c(this.c.a((View)localObject));
      }
      i = this.b.size();
      paramInt2 = j;
    }
    while (true)
    {
      if (paramInt2 >= i)
        break label291;
      localObject = (azl)this.b.get(paramInt2);
      if ((!((azl)localObject).k()) && (((azl)localObject).d() == paramInt1))
      {
        if (!paramBoolean)
          this.b.remove(paramInt2);
        return localObject;
        ((azl)localObject).a(32);
        return localObject;
        label275: i += 1;
        break;
      }
      paramInt2 += 1;
    }
    label291: return null;
  }

  azl a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i = this.a.size() - 1;
    azl localazl2;
    azl localazl1;
    while (i >= 0)
    {
      localazl2 = (azl)this.a.get(i);
      if ((localazl2.e() == paramLong) && (!localazl2.i()))
      {
        if (paramInt == localazl2.f())
        {
          localazl2.a(32);
          localazl1 = localazl2;
          if (localazl2.o())
          {
            localazl1 = localazl2;
            if (!this.c.g.a())
            {
              localazl2.a(2, 14);
              localazl1 = localazl2;
            }
          }
          return localazl1;
        }
        if (!paramBoolean)
        {
          this.a.remove(i);
          RecyclerView.b(this.c, localazl2.b, false);
          b(localazl2.b);
        }
      }
      i -= 1;
    }
    i = this.b.size() - 1;
    while (true)
    {
      if (i < 0)
        break label246;
      localazl2 = (azl)this.b.get(i);
      if (localazl2.e() == paramLong)
      {
        if (paramInt == localazl2.f())
        {
          localazl1 = localazl2;
          if (paramBoolean)
            break;
          this.b.remove(i);
          return localazl2;
        }
        if (!paramBoolean)
          c(i);
      }
      i -= 1;
    }
    label246: return null;
  }

  public void a()
  {
    this.a.clear();
    c();
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
    int i = this.b.size() - 1;
    while ((i >= 0) && (this.b.size() > paramInt))
    {
      c(i);
      i -= 1;
    }
    while (this.b.size() > paramInt)
      this.b.remove(this.b.size() - 1);
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    int m;
    label26: azl localazl;
    if (paramInt1 < paramInt2)
    {
      i = -1;
      j = paramInt2;
      k = paramInt1;
      int n = this.b.size();
      m = 0;
      if (m >= n)
        return;
      localazl = (azl)this.b.get(m);
      if ((localazl != null) && (localazl.c >= k) && (localazl.c <= j))
        break label89;
    }
    while (true)
    {
      m += 1;
      break label26;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label89: if (localazl.c == paramInt1)
        localazl.a(paramInt2 - paramInt1, false);
      else
        localazl.a(i, false);
    }
  }

  public void a(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    if (paramView.g())
      paramView.h();
    while (true)
    {
      b(paramView);
      return;
      if (paramView.i())
        paramView.j();
    }
  }

  public void a(ayp paramayp1, ayp paramayp2, boolean paramBoolean)
  {
    a();
    f().a(paramayp1, paramayp2, paramBoolean);
  }

  public void a(azc paramazc)
  {
    if (this.g != null)
      this.g.b();
    this.g = paramazc;
    if (paramazc != null)
      this.g.a(this.c.getAdapter());
  }

  public void a(azj paramazj)
  {
    this.h = paramazj;
  }

  boolean a(azl paramazl)
  {
    if (paramazl.o());
    do
    {
      return true;
      if ((paramazl.c < 0) || (paramazl.c >= RecyclerView.f(this.c).a()))
        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramazl);
      if ((!this.c.g.a()) && (RecyclerView.f(this.c).a(paramazl.c) != paramazl.f()))
        return false;
    }
    while ((!RecyclerView.f(this.c).b()) || (paramazl.e() == RecyclerView.f(this.c).b(paramazl.c)));
    return false;
  }

  public View b(int paramInt)
  {
    return a(paramInt, false);
  }

  public List<azl> b()
  {
    return this.e;
  }

  public void b(int paramInt1, int paramInt2)
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      azl localazl = (azl)this.b.get(i);
      if ((localazl != null) && (localazl.d() >= paramInt1))
        localazl.a(paramInt2, true);
      i += 1;
    }
  }

  public void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.b.size() - 1;
    if (i >= 0)
    {
      azl localazl = (azl)this.b.get(i);
      if (localazl != null)
      {
        if (localazl.d() < paramInt1 + paramInt2)
          break label63;
        localazl.a(-paramInt2, paramBoolean);
      }
      while (true)
      {
        i -= 1;
        break;
        label63: if ((localazl.d() >= paramInt1) && (!c(i)))
          localazl.a(4);
      }
    }
  }

  void b(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    azl.a(paramView, null);
    paramView.j();
    b(paramView);
  }

  public void b(azl paramazl)
  {
    boolean bool = true;
    int j = 0;
    if ((paramazl.g()) || (paramazl.b.getParent() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(paramazl.g()).append(" isAttached:");
      if (paramazl.b.getParent() != null);
      while (true)
      {
        throw new IllegalArgumentException(bool);
        bool = false;
      }
    }
    if (paramazl.c())
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
    int i;
    if (paramazl.q())
    {
      i = j;
      if (!paramazl.k())
        if (!azi.e(this.c.g))
        {
          i = j;
          if (paramazl.o());
        }
        else
        {
          i = j;
          if (!paramazl.m())
            if ((this.b.size() == this.f) && (!this.b.isEmpty()))
              i = 0;
        }
    }
    while (true)
    {
      if ((i >= this.b.size()) || (c(i)))
      {
        i = j;
        if (this.b.size() < this.f)
        {
          this.b.add(paramazl);
          i = 1;
        }
        if (i == 0)
        {
          f().a(paramazl);
          d(paramazl);
        }
        this.c.g.a(paramazl);
        return;
      }
      i += 1;
    }
  }

  void c()
  {
    int i = this.b.size() - 1;
    while (i >= 0)
    {
      c(i);
      i -= 1;
    }
    this.b.clear();
  }

  public void c(int paramInt1, int paramInt2)
  {
    int j = this.b.size();
    int i = 0;
    if (i < j)
    {
      azl localazl = (azl)this.b.get(i);
      if (localazl == null);
      while (true)
      {
        i += 1;
        break;
        int k = localazl.d();
        if ((k >= paramInt1) && (k < paramInt1 + paramInt2))
          localazl.a(2);
      }
    }
  }

  void c(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    paramView.a(this);
    if ((!paramView.m()) || (!RecyclerView.g(this.c)))
    {
      if ((paramView.k()) && (!paramView.o()) && (!RecyclerView.f(this.c).b()))
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
      this.a.add(paramView);
      return;
    }
    if (this.d == null)
      this.d = new ArrayList();
    this.d.add(paramView);
  }

  public void c(azl paramazl)
  {
    if ((!paramazl.m()) || (!RecyclerView.g(this.c)) || (this.d == null))
      this.a.remove(paramazl);
    while (true)
    {
      azl.a(paramazl, null);
      paramazl.j();
      return;
      this.d.remove(paramazl);
    }
  }

  boolean c(int paramInt)
  {
    azl localazl = (azl)this.b.get(paramInt);
    if (localazl.q())
    {
      f().a(localazl);
      d(localazl);
      this.b.remove(paramInt);
      return true;
    }
    return false;
  }

  int d()
  {
    return this.a.size();
  }

  View d(int paramInt)
  {
    return ((azl)this.a.get(paramInt)).b;
  }

  void d(azl paramazl)
  {
    if (RecyclerView.l(this.c) != null)
      RecyclerView.l(this.c).a(paramazl);
    if (RecyclerView.f(this.c) != null)
      RecyclerView.f(this.c).a(paramazl);
    if (this.c.g != null)
      this.c.g.a(paramazl);
  }

  azl e(int paramInt)
  {
    int j = 0;
    int k;
    if (this.d != null)
    {
      k = this.d.size();
      if (k != 0);
    }
    else
    {
      return null;
    }
    int i = 0;
    azl localazl;
    while (i < k)
    {
      localazl = (azl)this.d.get(i);
      if ((!localazl.i()) && (localazl.d() == paramInt))
      {
        localazl.a(32);
        return localazl;
      }
      i += 1;
    }
    if (RecyclerView.f(this.c).b())
    {
      paramInt = this.c.c.a(paramInt);
      if ((paramInt > 0) && (paramInt < RecyclerView.f(this.c).a()))
      {
        long l = RecyclerView.f(this.c).b(paramInt);
        paramInt = j;
        while (paramInt < k)
        {
          localazl = (azl)this.d.get(paramInt);
          if ((!localazl.i()) && (localazl.e() == l))
          {
            localazl.a(32);
            return localazl;
          }
          paramInt += 1;
        }
      }
    }
    return null;
  }

  void e()
  {
    this.a.clear();
  }

  public azc f()
  {
    if (this.g == null)
      this.g = new azc();
    return this.g;
  }

  public void g()
  {
    int j;
    int i;
    if ((RecyclerView.f(this.c) != null) && (RecyclerView.f(this.c).b()))
    {
      j = this.b.size();
      i = 0;
    }
    while (i < j)
    {
      azl localazl = (azl)this.b.get(i);
      if (localazl != null)
        localazl.a(6);
      i += 1;
      continue;
      i = this.b.size() - 1;
      while (i >= 0)
      {
        if (!c(i))
          ((azl)this.b.get(i)).a(6);
        i -= 1;
      }
    }
  }

  public void h()
  {
    int j = 0;
    int k = this.b.size();
    int i = 0;
    while (i < k)
    {
      ((azl)this.b.get(i)).a();
      i += 1;
    }
    k = this.a.size();
    i = 0;
    while (i < k)
    {
      ((azl)this.a.get(i)).a();
      i += 1;
    }
    if (this.d != null)
    {
      k = this.d.size();
      i = j;
      while (i < k)
      {
        ((azl)this.d.get(i)).a();
        i += 1;
      }
    }
  }

  public void i()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      ayz localayz = (ayz)((azl)this.b.get(i)).b.getLayoutParams();
      if (localayz != null)
        localayz.c = true;
      i += 1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azd
 * JD-Core Version:    0.6.2
 */