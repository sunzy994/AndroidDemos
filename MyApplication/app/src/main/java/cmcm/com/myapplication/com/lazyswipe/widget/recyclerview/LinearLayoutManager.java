package cmcm.com.myapplication.com.lazyswipe.widget.recyclerview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import ayi;
import ayj;
import ayk;
import ayl;
import ayo;
import ayy;
import ayz;
import azd;
import azi;
import azl;
import azm;
import java.util.List;

public class LinearLayoutManager extends ayy
{
  int a;
  public ayo b;
  boolean c = false;
  int d = -1;
  int e = -2147483648;
  LinearLayoutManager.SavedState f = null;
  final ayi g = new ayi(this);
  private ayk k;
  private boolean l;
  private boolean m = false;
  private boolean n = false;
  private boolean o = true;
  private boolean p;

  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    a(paramInt);
    a(paramBoolean);
  }

  private int a(int paramInt, azd paramazd, azi paramazi, boolean paramBoolean)
  {
    int i = this.b.d() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramazd, paramazi);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.b.d() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.b.a(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }

  private View a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    int j = this.b.c();
    int i1 = this.b.d();
    int i;
    Object localObject1;
    label32: Object localObject3;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      if (paramInt1 == paramInt2)
        break label164;
      localObject3 = g(paramInt1);
      int i2 = d((View)localObject3);
      if ((i2 < 0) || (i2 >= paramInt3))
        break label183;
      if (!((ayz)((View)localObject3).getLayoutParams()).a())
        break label116;
      if (localObject1 != null)
        break label183;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    while (true)
    {
      paramInt1 += i;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label32;
      i = -1;
      break;
      label116: Object localObject4;
      if (this.b.a((View)localObject3) < i1)
      {
        localObject4 = localObject3;
        if (this.b.b((View)localObject3) >= j);
      }
      else
      {
        if (localObject2 != null)
          break label183;
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        label164: if (localObject2 == null)
          break label176;
      }
      while (true)
      {
        localObject4 = localObject2;
        return localObject4;
        label176: localObject2 = localObject1;
      }
      label183: localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }

  private void a(int paramInt1, int paramInt2, boolean paramBoolean, azi paramazi)
  {
    int i = -1;
    int j = 1;
    this.k.h = a(paramazi);
    this.k.f = paramInt1;
    if (paramInt1 == 1)
    {
      paramazi = this.k;
      paramazi.h += this.b.g();
      paramazi = x();
      localayk = this.k;
      if (this.c);
      for (paramInt1 = i; ; paramInt1 = 1)
      {
        localayk.e = paramInt1;
        this.k.d = (d(paramazi) + this.k.e);
        this.k.b = this.b.b(paramazi);
        paramInt1 = this.b.b(paramazi) - this.b.d();
        this.k.c = paramInt2;
        if (paramBoolean)
        {
          paramazi = this.k;
          paramazi.c -= paramInt1;
        }
        this.k.g = paramInt1;
        return;
      }
    }
    paramazi = w();
    ayk localayk = this.k;
    localayk.h += this.b.c();
    localayk = this.k;
    if (this.c);
    for (paramInt1 = j; ; paramInt1 = -1)
    {
      localayk.e = paramInt1;
      this.k.d = (d(paramazi) + this.k.e);
      this.k.b = this.b.a(paramazi);
      paramInt1 = -this.b.a(paramazi) + this.b.c();
      break;
    }
  }

  private void a(ayi paramayi)
  {
    c(paramayi.a, paramayi.b);
  }

  private void a(azd paramazd, int paramInt)
  {
    if (paramInt < 0);
    while (true)
    {
      return;
      int j = k();
      int i;
      View localView;
      if (this.c)
      {
        i = j - 1;
        while (i >= 0)
        {
          localView = g(i);
          if (this.b.b(localView) > paramInt)
          {
            a(paramazd, j - 1, i);
            return;
          }
          i -= 1;
        }
      }
      else
      {
        i = 0;
        while (i < j)
        {
          localView = g(i);
          if (this.b.b(localView) > paramInt)
          {
            a(paramazd, 0, i);
            return;
          }
          i += 1;
        }
      }
    }
  }

  private void a(azd paramazd, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2);
    while (true)
    {
      return;
      int i = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          a(paramInt2, paramazd);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i > paramInt2)
        {
          a(i, paramazd);
          i -= 1;
        }
      }
    }
  }

  private void a(azd paramazd, ayk paramayk)
  {
    if (!paramayk.a)
      return;
    if (paramayk.f == -1)
    {
      b(paramazd, paramayk.g);
      return;
    }
    a(paramazd, paramayk.g);
  }

  private int b(int paramInt, azd paramazd, azi paramazi, boolean paramBoolean)
  {
    int i = paramInt - this.b.c();
    if (i > 0)
    {
      int j = -c(i, paramazd, paramazi);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.b.c();
        i = j;
        if (paramInt > 0)
        {
          this.b.a(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }

  private void b(ayi paramayi)
  {
    d(paramayi.a, paramayi.b);
  }

  private void b(azd paramazd, int paramInt)
  {
    int i = k();
    if (paramInt < 0);
    while (true)
    {
      return;
      int j = this.b.e() - paramInt;
      View localView;
      if (this.c)
      {
        paramInt = 0;
        while (paramInt < i)
        {
          localView = g(paramInt);
          if (this.b.a(localView) < j)
          {
            a(paramazd, 0, paramInt);
            return;
          }
          paramInt += 1;
        }
      }
      else
      {
        paramInt = i - 1;
        while (paramInt >= 0)
        {
          localView = g(paramInt);
          if (this.b.a(localView) < j)
          {
            a(paramazd, i - 1, paramInt);
            return;
          }
          paramInt -= 1;
        }
      }
    }
  }

  private void b(azd paramazd, azi paramazi, int paramInt1, int paramInt2)
  {
    if ((!paramazi.b()) || (k() == 0) || (paramazi.a()) || (!h()))
      return;
    int j = 0;
    int i = 0;
    Object localObject = paramazd.b();
    int i3 = ((List)localObject).size();
    int i4 = d(g(0));
    int i1 = 0;
    if (i1 < i3)
    {
      azl localazl = (azl)((List)localObject).get(i1);
      int i5;
      label98: int i2;
      if (localazl.d() < i4)
      {
        i5 = 1;
        if (i5 == this.c)
          break label148;
        i2 = -1;
        label110: if (i2 != -1)
          break label154;
        j = this.b.c(localazl.b) + j;
      }
      while (true)
      {
        i1 += 1;
        break;
        i5 = 0;
        break label98;
        label148: i2 = 1;
        break label110;
        label154: i = this.b.c(localazl.b) + i;
      }
    }
    this.k.j = ((List)localObject);
    if (j > 0)
    {
      d(d(w()), paramInt1);
      this.k.h = j;
      this.k.c = 0;
      localObject = this.k;
      j = ((ayk)localObject).d;
      if (this.c)
      {
        paramInt1 = 1;
        ((ayk)localObject).d = (paramInt1 + j);
        a(paramazd, this.k, paramazi, false);
      }
    }
    else if (i > 0)
    {
      c(d(x()), paramInt2);
      this.k.h = i;
      this.k.c = 0;
      localObject = this.k;
      paramInt2 = ((ayk)localObject).d;
      if (!this.c)
        break label354;
    }
    label354: for (paramInt1 = -1; ; paramInt1 = 1)
    {
      ((ayk)localObject).d = (paramInt1 + paramInt2);
      a(paramazd, this.k, paramazi, false);
      this.k.j = null;
      return;
      paramInt1 = -1;
      break;
    }
  }

  private void b(azi paramazi, ayi paramayi)
  {
    if (d(paramazi, paramayi));
    while (c(paramazi, paramayi))
      return;
    paramayi.b();
    if (this.n);
    for (int i = paramazi.e() - 1; ; i = 0)
    {
      paramayi.a = i;
      return;
    }
  }

  private void c(int paramInt1, int paramInt2)
  {
    this.k.c = (this.b.d() - paramInt2);
    ayk localayk = this.k;
    if (this.c);
    for (int i = -1; ; i = 1)
    {
      localayk.e = i;
      this.k.d = paramInt1;
      this.k.f = 1;
      this.k.b = paramInt2;
      this.k.g = -2147483648;
      return;
    }
  }

  private boolean c(azi paramazi, ayi paramayi)
  {
    int i = 0;
    if (k() == 0);
    View localView;
    do
    {
      return false;
      localView = r();
      if ((localView != null) && (paramayi.a(localView, paramazi)))
        return true;
    }
    while (this.l != this.n);
    if (paramayi.c)
    {
      localView = k(paramazi);
      label56: if (localView == null)
        break label154;
      paramayi.a(localView);
      if ((!paramazi.a()) && (h()))
      {
        if ((this.b.a(localView) >= this.b.d()) || (this.b.b(localView) < this.b.c()))
          i = 1;
        if (i != 0)
          if (!paramayi.c)
            break label156;
      }
    }
    label154: label156: for (i = this.b.d(); ; i = this.b.c())
    {
      paramayi.b = i;
      return true;
      localView = l(paramazi);
      break label56;
      break;
    }
  }

  private void d(int paramInt1, int paramInt2)
  {
    this.k.c = (paramInt2 - this.b.c());
    this.k.d = paramInt1;
    ayk localayk = this.k;
    if (this.c);
    for (paramInt1 = 1; ; paramInt1 = -1)
    {
      localayk.e = paramInt1;
      this.k.f = -1;
      this.k.b = paramInt2;
      this.k.g = -2147483648;
      return;
    }
  }

  private boolean d(azi paramazi, ayi paramayi)
  {
    boolean bool = false;
    if ((paramazi.a()) || (this.d == -1))
      return false;
    if ((this.d < 0) || (this.d >= paramazi.e()))
    {
      this.d = -1;
      this.e = -2147483648;
      return false;
    }
    paramayi.a = this.d;
    if ((this.f != null) && (this.f.a()))
    {
      paramayi.c = this.f.c;
      if (paramayi.c)
      {
        paramayi.b = (this.b.d() - this.f.b);
        return true;
      }
      paramayi.b = (this.b.c() + this.f.b);
      return true;
    }
    if (this.e == -2147483648)
    {
      paramazi = b(this.d);
      int i;
      if (paramazi != null)
      {
        if (this.b.c(paramazi) > this.b.f())
        {
          paramayi.b();
          return true;
        }
        if (this.b.a(paramazi) - this.b.c() < 0)
        {
          paramayi.b = this.b.c();
          paramayi.c = false;
          return true;
        }
        if (this.b.d() - this.b.b(paramazi) < 0)
        {
          paramayi.b = this.b.d();
          paramayi.c = true;
          return true;
        }
        if (paramayi.c);
        for (i = this.b.b(paramazi) + this.b.b(); ; i = this.b.a(paramazi))
        {
          paramayi.b = i;
          return true;
        }
      }
      if (k() > 0)
      {
        i = d(g(0));
        if (this.d >= i)
          break label351;
      }
      label351: for (int j = 1; ; j = 0)
      {
        if (j == this.c)
          bool = true;
        paramayi.c = bool;
        paramayi.b();
        return true;
      }
    }
    paramayi.c = this.c;
    if (this.c)
    {
      paramayi.b = (this.b.d() - this.e);
      return true;
    }
    paramayi.b = (this.b.c() + this.e);
    return true;
  }

  private int h(azi paramazi)
  {
    if (k() == 0)
      return 0;
    return azm.a(paramazi, this.b, w(), x(), this, this.o, this.c);
  }

  private int i(azi paramazi)
  {
    if (k() == 0)
      return 0;
    return azm.a(paramazi, this.b, w(), x(), this, this.o);
  }

  private int j(azi paramazi)
  {
    if (k() == 0)
      return 0;
    return azm.b(paramazi, this.b, w(), x(), this, this.o);
  }

  private int k(int paramInt)
  {
    int j = -1;
    int i1 = 1;
    int i2 = -2147483648;
    int i = j;
    switch (paramInt)
    {
    default:
      i = -2147483648;
    case 1:
    case 2:
    case 33:
    case 130:
    case 17:
      do
      {
        do
        {
          return i;
          return 1;
          i = j;
        }
        while (this.a == 1);
        return -2147483648;
        paramInt = i2;
        if (this.a == 1)
          paramInt = 1;
        return paramInt;
        i = j;
      }
      while (this.a == 0);
      return -2147483648;
    case 66:
    }
    if (this.a == 0);
    for (paramInt = i1; ; paramInt = -2147483648)
      return paramInt;
  }

  private View k(azi paramazi)
  {
    if (this.c)
      return l(paramazi.e());
    return m(paramazi.e());
  }

  private View l(int paramInt)
  {
    return a(0, k(), paramInt);
  }

  private View l(azi paramazi)
  {
    if (this.c)
      return m(paramazi.e());
    return l(paramazi.e());
  }

  private View m(int paramInt)
  {
    return a(k() - 1, -1, paramInt);
  }

  private void v()
  {
    boolean bool = true;
    if ((this.a == 1) || (!e()))
    {
      this.c = this.m;
      return;
    }
    if (!this.m);
    while (true)
    {
      this.c = bool;
      return;
      bool = false;
    }
  }

  private View w()
  {
    if (this.c);
    for (int i = k() - 1; ; i = 0)
      return g(i);
  }

  private View x()
  {
    if (this.c);
    for (int i = 0; ; i = k() - 1)
      return g(i);
  }

  public int a(int paramInt, azd paramazd, azi paramazi)
  {
    if (this.a == 1)
      return 0;
    return c(paramInt, paramazd, paramazi);
  }

  int a(azd paramazd, ayk paramayk, azi paramazi, boolean paramBoolean)
  {
    int i1 = paramayk.c;
    if (paramayk.g != -2147483648)
    {
      if (paramayk.c < 0)
        paramayk.g += paramayk.c;
      a(paramazd, paramayk);
    }
    int i = paramayk.c + paramayk.h;
    ayj localayj = new ayj();
    if ((i > 0) && (paramayk.a(paramazi)))
    {
      localayj.a();
      a(paramazd, paramazi, paramayk, localayj);
      if (!localayj.b)
        break label104;
    }
    while (true)
    {
      return i1 - paramayk.c;
      label104: paramayk.b += localayj.a * paramayk.f;
      int j;
      if ((localayj.c) && (this.k.j == null))
      {
        j = i;
        if (paramazi.a());
      }
      else
      {
        paramayk.c -= localayj.a;
        j = i - localayj.a;
      }
      if (paramayk.g != -2147483648)
      {
        paramayk.g += localayj.a;
        if (paramayk.c < 0)
          paramayk.g += paramayk.c;
        a(paramazd, paramayk);
      }
      i = j;
      if (!paramBoolean)
        break;
      i = j;
      if (!localayj.d)
        break;
    }
  }

  protected int a(azi paramazi)
  {
    if (paramazi.d())
      return this.b.f();
    return 0;
  }

  View a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.b.c();
    int i1 = this.b.d();
    int i;
    if (paramInt2 > paramInt1)
      i = 1;
    while (paramInt1 != paramInt2)
    {
      View localView = g(paramInt1);
      int i2 = this.b.a(localView);
      int i3 = this.b.b(localView);
      if ((i2 < i1) && (i3 > j))
      {
        if (paramBoolean)
        {
          if ((i2 >= j) && (i3 <= i1))
          {
            return localView;
            i = -1;
          }
        }
        else
          return localView;
      }
      else
        paramInt1 += i;
    }
    return null;
  }

  public View a(View paramView, int paramInt, azd paramazd, azi paramazi)
  {
    v();
    if (k() == 0);
    label128: label130: label136: 
    while (true)
    {
      return null;
      paramInt = k(paramInt);
      if (paramInt != -2147483648)
      {
        if (paramInt == -1)
        {
          paramView = l(paramazi);
          label37: if (paramView == null)
            break label128;
          f();
          a(paramInt, (int)(0.33F * this.b.f()), false, paramazi);
          this.k.g = -2147483648;
          this.k.a = false;
          a(paramazd, this.k, paramazi, true);
          if (paramInt != -1)
            break label130;
        }
        for (paramazd = w(); ; paramazd = x())
        {
          if ((paramazd == paramView) || (!paramazd.isFocusable()))
            break label136;
          return paramazd;
          paramView = k(paramazi);
          break label37;
          break;
        }
      }
    }
  }

  public ayz a()
  {
    return new ayz(-2, -2);
  }

  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    a(null);
    if (paramInt == this.a)
      return;
    this.a = paramInt;
    this.b = null;
    i();
  }

  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      this.f = ((LinearLayoutManager.SavedState)paramParcelable);
      i();
    }
  }

  public void a(azd paramazd, azi paramazi)
  {
    if ((this.f != null) && (this.f.a()))
      this.d = this.f.a;
    f();
    this.k.a = false;
    v();
    this.g.a();
    this.g.c = (this.c ^ this.n);
    b(paramazi, this.g);
    int j = a(paramazi);
    int i4;
    int i;
    label116: int i2;
    Object localObject;
    if (paramazi.c() < this.g.a)
    {
      i4 = 1;
      if (i4 != this.c)
        break label545;
      i = j;
      j = 0;
      i1 = j + this.b.c();
      i2 = i + this.b.g();
      i = i2;
      j = i1;
      if (paramazi.a())
      {
        i = i2;
        j = i1;
        if (this.d != -1)
        {
          i = i2;
          j = i1;
          if (this.e != -2147483648)
          {
            localObject = b(this.d);
            i = i2;
            j = i1;
            if (localObject != null)
            {
              if (!this.c)
                break label551;
              i = this.b.d() - this.b.b((View)localObject) - this.e;
              label239: if (i <= 0)
                break label585;
              j = i1 + i;
              i = i2;
            }
          }
        }
      }
      label255: a(paramazi, this.g);
      a(paramazd);
      this.k.i = paramazi.a();
      if (!this.g.c)
        break label599;
      b(this.g);
      this.k.h = j;
      a(paramazd, this.k, paramazi, false);
      i1 = this.k.b;
      j = i;
      if (this.k.c > 0)
        j = i + this.k.c;
      a(this.g);
      this.k.h = j;
      localObject = this.k;
      ((ayk)localObject).d += this.k.e;
      a(paramazd, this.k, paramazi, false);
      i = this.k.b;
      j = i1;
      label417: i1 = i;
      i2 = j;
      if (k() > 0)
      {
        if (!(this.c ^ this.n))
          break label729;
        i1 = a(i, paramazd, paramazi, true);
        i2 = j + i1;
        j = b(i2, paramazd, paramazi, false);
        i2 += j;
      }
    }
    label545: label551: label585: label599: label729: int i3;
    for (int i1 = i + i1 + j; ; i1 = i + i3)
    {
      b(paramazd, paramazi, i2, i1);
      if (!paramazi.a())
      {
        this.d = -1;
        this.e = -2147483648;
        this.b.a();
      }
      this.l = this.n;
      this.f = null;
      return;
      i4 = 0;
      break;
      i = 0;
      break label116;
      i = this.b.a((View)localObject);
      j = this.b.c();
      i = this.e - (i - j);
      break label239;
      i = i2 - i;
      j = i1;
      break label255;
      a(this.g);
      this.k.h = i;
      a(paramazd, this.k, paramazi, false);
      i1 = this.k.b;
      i = j;
      if (this.k.c > 0)
        i = j + this.k.c;
      b(this.g);
      this.k.h = i;
      localObject = this.k;
      ((ayk)localObject).d += this.k.e;
      a(paramazd, this.k, paramazi, false);
      j = this.k.b;
      i = i1;
      break label417;
      i1 = b(j, paramazd, paramazi, true);
      i += i1;
      i3 = a(i, paramazd, paramazi, false);
      i2 = j + i1 + i3;
    }
  }

  void a(azd paramazd, azi paramazi, ayk paramayk, ayj paramayj)
  {
    paramazd = paramayk.a(paramazd);
    if (paramazd == null)
    {
      paramayj.b = true;
      return;
    }
    paramazi = (ayz)paramazd.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label61: int i;
    int j;
    label120: int i1;
    int i2;
    if (paramayk.j == null)
    {
      bool2 = this.c;
      if (paramayk.f == -1)
      {
        bool1 = true;
        if (bool2 != bool1)
          break label215;
        b(paramazd);
        a(paramazd, 0, 0);
        paramayj.a = this.b.c(paramazd);
        if (this.a != 1)
          break label322;
        if (!e())
          break label271;
        i = l() - p();
        j = i - this.b.d(paramazd);
        if (paramayk.f != -1)
          break label293;
        i1 = paramayk.b;
        i2 = paramayk.b - paramayj.a;
      }
    }
    while (true)
    {
      a(paramazd, j + paramazi.leftMargin, i2 + paramazi.topMargin, i - paramazi.rightMargin, i1 - paramazi.bottomMargin);
      if ((paramazi.a()) || (paramazi.b()))
        paramayj.c = true;
      paramayj.d = paramazd.isFocusable();
      return;
      bool1 = false;
      break;
      label215: b(paramazd, 0);
      break label61;
      bool2 = this.c;
      if (paramayk.f == -1);
      for (bool1 = true; ; bool1 = false)
      {
        if (bool2 != bool1)
          break label262;
        a(paramazd);
        break;
      }
      label262: a(paramazd, 0);
      break label61;
      label271: j = n();
      i = this.b.d(paramazd) + j;
      break label120;
      label293: i2 = paramayk.b;
      i1 = paramayk.b;
      int i3 = paramayj.a;
      i1 += i3;
      continue;
      label322: i2 = o();
      i1 = this.b.d(paramazd) + i2;
      if (paramayk.f == -1)
      {
        i = paramayk.b;
        j = paramayk.b - paramayj.a;
      }
      else
      {
        j = paramayk.b;
        i = paramayk.b;
        i3 = paramayj.a;
        i += i3;
      }
    }
  }

  void a(azi paramazi, ayi paramayi)
  {
  }

  public void a(RecyclerView paramRecyclerView, azd paramazd)
  {
    super.a(paramRecyclerView, paramazd);
    if (this.p)
    {
      b(paramazd);
      paramazd.a();
    }
  }

  public void a(RecyclerView paramRecyclerView, azi paramazi, int paramInt)
  {
    paramRecyclerView = new ayl(paramRecyclerView.getContext())
    {
      public PointF a(int paramAnonymousInt)
      {
        return LinearLayoutManager.this.c(paramAnonymousInt);
      }
    };
    paramRecyclerView.d(paramInt);
    a(paramRecyclerView);
  }

  public void a(String paramString)
  {
    if (this.f == null)
      super.a(paramString);
  }

  public void a(boolean paramBoolean)
  {
    a(null);
    if (paramBoolean == this.m)
      return;
    this.m = paramBoolean;
    i();
  }

  public int b(int paramInt, azd paramazd, azi paramazi)
  {
    if (this.a == 0)
      return 0;
    return c(paramInt, paramazd, paramazi);
  }

  public int b(azi paramazi)
  {
    return h(paramazi);
  }

  public Parcelable b()
  {
    if (this.f != null)
      return new LinearLayoutManager.SavedState(this.f);
    LinearLayoutManager.SavedState localSavedState = new LinearLayoutManager.SavedState();
    if (k() > 0)
    {
      boolean bool = this.l ^ this.c;
      localSavedState.c = bool;
      if (bool)
      {
        localView = x();
        localSavedState.b = (this.b.d() - this.b.b(localView));
        localSavedState.a = d(localView);
        return localSavedState;
      }
      View localView = w();
      localSavedState.a = d(localView);
      localSavedState.b = (this.b.a(localView) - this.b.c());
      return localSavedState;
    }
    localSavedState.b();
    return localSavedState;
  }

  public View b(int paramInt)
  {
    int i = k();
    if (i == 0);
    do
    {
      return null;
      paramInt -= d(g(0));
    }
    while ((paramInt < 0) || (paramInt >= i));
    return g(paramInt);
  }

  int c(int paramInt, azd paramazd, azi paramazi)
  {
    if ((k() == 0) || (paramInt == 0))
      return 0;
    this.k.a = true;
    f();
    if (paramInt > 0);
    int j;
    int i1;
    for (int i = 1; ; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, paramazi);
      i1 = this.k.g + a(paramazd, this.k, paramazi, false);
      if (i1 >= 0)
        break;
      return 0;
    }
    if (j > i1)
      paramInt = i * i1;
    this.b.a(-paramInt);
    return paramInt;
  }

  public int c(azi paramazi)
  {
    return h(paramazi);
  }

  public PointF c(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (k() == 0)
      return null;
    if (paramInt < d(g(0)))
      j = 1;
    paramInt = i;
    if (j != this.c)
      paramInt = -1;
    if (this.a == 0)
      return new PointF(paramInt, 0.0F);
    return new PointF(0.0F, paramInt);
  }

  public boolean c()
  {
    return this.a == 0;
  }

  public int d(azi paramazi)
  {
    return i(paramazi);
  }

  public void d(int paramInt)
  {
    this.d = paramInt;
    this.e = -2147483648;
    if (this.f != null)
      this.f.b();
    i();
  }

  public boolean d()
  {
    return this.a == 1;
  }

  public int e(azi paramazi)
  {
    return i(paramazi);
  }

  protected boolean e()
  {
    return j() == 1;
  }

  public int f(azi paramazi)
  {
    return j(paramazi);
  }

  void f()
  {
    if (this.k == null)
      this.k = new ayk();
    if (this.b == null)
      this.b = ayo.a(this, this.a);
  }

  public int g()
  {
    View localView = a(k() - 1, -1, false);
    if (localView == null)
      return -1;
    return d(localView);
  }

  public int g(azi paramazi)
  {
    return j(paramazi);
  }

  public boolean h()
  {
    return (this.f == null) && (this.l == this.n);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.recyclerview.LinearLayoutManager
 * JD-Core Version:    0.6.2
 */