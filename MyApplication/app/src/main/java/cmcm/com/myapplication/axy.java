package cmcm.com.myapplication;

import java.util.ArrayList;
import java.util.List;

public class axy
  implements ayn
{
  final ArrayList<aya> a = new ArrayList();
  final ArrayList<aya> b = new ArrayList();
  final axz c;
  Runnable d;
  final boolean e;
  final aym f;
  private dd<aya> g = new de(30);

  public axy(axz paramaxz)
  {
    this(paramaxz, false);
  }

  axy(axz paramaxz, boolean paramBoolean)
  {
    this.c = paramaxz;
    this.e = paramBoolean;
    this.f = new aym(this);
  }

  private int b(int paramInt1, int paramInt2)
  {
    int j = this.b.size() - 1;
    aya localaya;
    if (j >= 0)
    {
      localaya = (aya)this.b.get(j);
      int k;
      int i;
      if (localaya.a == 3)
        if (localaya.b < localaya.c)
        {
          k = localaya.b;
          i = localaya.c;
          label60: if ((paramInt1 < k) || (paramInt1 > i))
            break label186;
          if (k != localaya.b)
            break label147;
          if (paramInt2 != 0)
            break label129;
          localaya.c += 1;
          label95: paramInt1 += 1;
          label99: i = paramInt1;
        }
      while (true)
      {
        j -= 1;
        paramInt1 = i;
        break;
        k = localaya.c;
        i = localaya.b;
        break label60;
        label129: if (paramInt2 != 1)
          break label95;
        localaya.c -= 1;
        break label95;
        label147: if (paramInt2 == 0)
          localaya.b += 1;
        while (true)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 1)
            localaya.b -= 1;
        }
        label186: if (paramInt1 < localaya.b)
        {
          if (paramInt2 == 0)
          {
            localaya.b += 1;
            localaya.c += 1;
            break label99;
          }
          if (paramInt2 == 1)
          {
            localaya.b -= 1;
            localaya.c -= 1;
          }
        }
        break label99;
        if (localaya.b <= paramInt1)
        {
          if (localaya.a == 0)
          {
            i = paramInt1 - localaya.c;
          }
          else
          {
            i = paramInt1;
            if (localaya.a == 1)
              i = paramInt1 + localaya.c;
          }
        }
        else if (paramInt2 == 0)
        {
          localaya.b += 1;
          i = paramInt1;
        }
        else
        {
          i = paramInt1;
          if (paramInt2 == 1)
          {
            localaya.b -= 1;
            i = paramInt1;
          }
        }
      }
    }
    paramInt2 = this.b.size() - 1;
    if (paramInt2 >= 0)
    {
      localaya = (aya)this.b.get(paramInt2);
      if (localaya.a == 3)
        if ((localaya.c == localaya.b) || (localaya.c < 0))
        {
          this.b.remove(paramInt2);
          a(localaya);
        }
      while (true)
      {
        paramInt2 -= 1;
        break;
        if (localaya.c <= 0)
        {
          this.b.remove(paramInt2);
          a(localaya);
        }
      }
    }
    return paramInt1;
  }

  private void b(aya paramaya)
  {
    g(paramaya);
  }

  private boolean b(int paramInt)
  {
    int k = this.b.size();
    int i = 0;
    while (i < k)
    {
      aya localaya = (aya)this.b.get(i);
      if (localaya.a == 3)
      {
        if (a(localaya.c, i + 1) == paramInt)
          return true;
      }
      else if (localaya.a == 0)
      {
        int m = localaya.b;
        int n = localaya.c;
        int j = localaya.b;
        while (j < m + n)
        {
          if (a(j, i + 1) == paramInt)
            return true;
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }

  private void c(aya paramaya)
  {
    int i2 = paramaya.b;
    int k = paramaya.b + paramaya.c;
    int j = -1;
    int i = paramaya.b;
    int n = 0;
    if (i < k)
      if ((this.c.a(i) != null) || (b(i)))
      {
        if (j != 0)
          break label218;
        e(a(1, i2, n));
      }
    label212: label218: for (int m = 1; ; m = 0)
    {
      j = 1;
      if (m != 0)
      {
        m = i - n;
        i = k - n;
        k = 1;
        label99: n = k;
        k = i;
        i = m + 1;
        break;
        if (j != 1)
          break label212;
        g(a(1, i2, n));
      }
      for (j = 1; ; j = 0)
      {
        int i1 = 0;
        m = j;
        j = i1;
        break;
        n += 1;
        m = i;
        i = k;
        k = n;
        break label99;
        aya localaya = paramaya;
        if (n != paramaya.c)
        {
          a(paramaya);
          localaya = a(1, i2, n);
        }
        if (j == 0)
        {
          e(localaya);
          return;
        }
        g(localaya);
        return;
      }
    }
  }

  private void d(aya paramaya)
  {
    int k = paramaya.b;
    int i2 = paramaya.b;
    int i3 = paramaya.c;
    int i = paramaya.b;
    int i1 = -1;
    int j = 0;
    if (i < i2 + i3)
    {
      int m;
      int n;
      if ((this.c.a(i) != null) || (b(i)))
      {
        m = j;
        n = k;
        if (i1 == 0)
        {
          e(a(2, k, j));
          m = 0;
          n = i;
        }
        k = n;
      }
      for (j = 1; ; j = 0)
      {
        i += 1;
        m += 1;
        i1 = j;
        j = m;
        break;
        m = j;
        n = k;
        if (i1 == 1)
        {
          g(a(2, k, j));
          m = 0;
          n = i;
        }
        k = n;
      }
    }
    aya localaya = paramaya;
    if (j != paramaya.c)
    {
      a(paramaya);
      localaya = a(2, k, j);
    }
    if (i1 == 0)
    {
      e(localaya);
      return;
    }
    g(localaya);
  }

  private void e(aya paramaya)
  {
    if ((paramaya.a == 0) || (paramaya.a == 3))
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    int i1 = b(paramaya.b, paramaya.a);
    int j = paramaya.b;
    int k;
    int n;
    int m;
    label108: int i2;
    switch (paramaya.a)
    {
    default:
      throw new IllegalArgumentException("op should be remove or update." + paramaya);
    case 2:
      k = 1;
      n = 1;
      m = 1;
      if (m >= paramaya.c)
        break label287;
      i2 = b(paramaya.b + k * m, paramaya.a);
      switch (paramaya.a)
      {
      default:
        i = 0;
        label166: if (i == 0);
        break;
      case 2:
      case 1:
      }
      break;
    case 1:
    }
    for (int i = n + 1; ; i = n)
    {
      m += 1;
      n = i;
      break label108;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label166;
      }
      i = 0;
      break label166;
      if (i2 == i1)
      {
        i = 1;
        break label166;
      }
      i = 0;
      break label166;
      aya localaya = a(paramaya.a, i1, n);
      a(localaya, j);
      a(localaya);
      i = j;
      if (paramaya.a == 2)
        i = j + n;
      n = 1;
      i1 = i2;
      j = i;
    }
    label287: a(paramaya);
    if (n > 0)
    {
      paramaya = a(paramaya.a, i1, n);
      a(paramaya, j);
      a(paramaya);
    }
  }

  private void f(aya paramaya)
  {
    g(paramaya);
  }

  private void g(aya paramaya)
  {
    this.b.add(paramaya);
    switch (paramaya.a)
    {
    default:
      throw new IllegalArgumentException("Unknown update op type for " + paramaya);
    case 0:
      this.c.d(paramaya.b, paramaya.c);
      return;
    case 3:
      this.c.e(paramaya.b, paramaya.c);
      return;
    case 1:
      this.c.b(paramaya.b, paramaya.c);
      return;
    case 2:
    }
    this.c.c(paramaya.b, paramaya.c);
  }

  int a(int paramInt)
  {
    return a(paramInt, 0);
  }

  int a(int paramInt1, int paramInt2)
  {
    int k = this.b.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    aya localaya;
    if (j < k)
    {
      localaya = (aya)this.b.get(j);
      if (localaya.a == 3)
        if (localaya.b == paramInt2)
          paramInt1 = localaya.c;
    }
    while (true)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localaya.b < paramInt2)
        i = paramInt2 - 1;
      paramInt1 = i;
      if (localaya.c <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localaya.b <= paramInt2)
          if (localaya.a == 1)
          {
            if (paramInt2 < localaya.b + localaya.c)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localaya.c;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localaya.a == 0)
              paramInt1 = paramInt2 + localaya.c;
          }
      }
    }
  }

  public aya a(int paramInt1, int paramInt2, int paramInt3)
  {
    aya localaya = (aya)this.g.a();
    if (localaya == null)
      return new aya(paramInt1, paramInt2, paramInt3);
    localaya.a = paramInt1;
    localaya.b = paramInt2;
    localaya.c = paramInt3;
    return localaya;
  }

  public void a()
  {
    a(this.a);
    a(this.b);
  }

  public void a(aya paramaya)
  {
    if (!this.e)
      this.g.a(paramaya);
  }

  void a(aya paramaya, int paramInt)
  {
    this.c.a(paramaya);
    switch (paramaya.a)
    {
    default:
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 1:
      this.c.a(paramInt, paramaya.c);
      return;
    case 2:
    }
    this.c.c(paramInt, paramaya.c);
  }

  void a(List<aya> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a((aya)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }

  public void b()
  {
    this.f.a(this.a);
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      aya localaya = (aya)this.a.get(i);
      switch (localaya.a)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        if (this.d != null)
          this.d.run();
        i += 1;
        break;
        f(localaya);
        continue;
        c(localaya);
        continue;
        d(localaya);
        continue;
        b(localaya);
      }
    }
    this.a.clear();
  }

  public void c()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      this.c.b((aya)this.b.get(i));
      i += 1;
    }
    a(this.b);
  }

  public boolean d()
  {
    return this.a.size() > 0;
  }

  public void e()
  {
    c();
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      aya localaya = (aya)this.a.get(i);
      switch (localaya.a)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        if (this.d != null)
          this.d.run();
        i += 1;
        break;
        this.c.b(localaya);
        this.c.d(localaya.b, localaya.c);
        continue;
        this.c.b(localaya);
        this.c.a(localaya.b, localaya.c);
        continue;
        this.c.b(localaya);
        this.c.c(localaya.b, localaya.c);
        continue;
        this.c.b(localaya);
        this.c.e(localaya.b, localaya.c);
      }
    }
    a(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axy
 * JD-Core Version:    0.6.2
 */