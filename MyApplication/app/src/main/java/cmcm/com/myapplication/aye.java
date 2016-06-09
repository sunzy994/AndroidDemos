package cmcm.com.myapplication;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aye extends ays
{
  private ArrayList<azl> a = new ArrayList();
  private ArrayList<azl> b = new ArrayList();
  private ArrayList<ayg> c = new ArrayList();
  private ArrayList<ayf> d = new ArrayList();
  private ArrayList<ArrayList<azl>> e = new ArrayList();
  private ArrayList<ArrayList<ayg>> f = new ArrayList();
  private ArrayList<ArrayList<ayf>> g = new ArrayList();
  private ArrayList<azl> h = new ArrayList();
  private ArrayList<azl> i = new ArrayList();
  private ArrayList<azl> j = new ArrayList();
  private ArrayList<azl> k = new ArrayList();

  private void a(final ayf paramayf)
  {
    Object localObject2 = paramayf.a.b;
    Object localObject1 = paramayf.b;
    if (localObject1 != null);
    for (localObject1 = ((azl)localObject1).b; ; localObject1 = null)
    {
      this.k.add(paramayf.a);
      localObject2 = ez.m((View) localObject2).a(g());
      ((gt)localObject2).b(paramayf.e - paramayf.c);
      ((gt)localObject2).c(paramayf.f - paramayf.d);
      ((gt)localObject2).a(0.0F).a(new ayh(paramayf)
      {
        public void a(View paramAnonymousView)
        {
          aye.this.b(paramayf.a, true);
        }

        public void b(View paramAnonymousView)
        {
          this.b.a(null);
          ez.c(paramAnonymousView, 1.0F);
          ez.a(paramAnonymousView, 0.0F);
          ez.b(paramAnonymousView, 0.0F);
          aye.this.a(paramayf.a, true);
          aye.h(aye.this).remove(paramayf.a);
          aye.e(aye.this);
        }
      }).b();
      if (localObject1 != null)
      {
        this.k.add(paramayf.b);
        localObject2 = ez.m((View) localObject1);
        ((gt)localObject2).b(0.0F).c(0.0F).a(g()).a(1.0F).a(new ayh(paramayf)
        {
          public void a(View paramAnonymousView)
          {
            aye.this.b(paramayf.b, false);
          }

          public void b(View paramAnonymousView)
          {
            this.b.a(null);
            ez.c(this.c, 1.0F);
            ez.a(this.c, 0.0F);
            ez.b(this.c, 0.0F);
            aye.this.a(paramayf.b, false);
            aye.h(aye.this).remove(paramayf.b);
            aye.e(aye.this);
          }
        }).b();
      }
      return;
    }
  }

  private void a(List<ayf> paramList, azl paramazl)
  {
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      ayf localayf = (ayf)paramList.get(m);
      if ((a(localayf, paramazl)) && (localayf.a == null) && (localayf.b == null))
        paramList.remove(localayf);
      m -= 1;
    }
  }

  private boolean a(ayf paramayf, azl paramazl)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramayf.b == paramazl)
      paramayf.b = null;
    while (true)
    {
      ez.c(paramazl.b, 1.0F);
      ez.a(paramazl.b, 0.0F);
      ez.b(paramazl.b, 0.0F);
      a(paramazl, bool1);
      bool1 = true;
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (paramayf.a != paramazl);
      paramayf.a = null;
      bool1 = true;
    }
  }

  private void b(ayf paramayf)
  {
    if (paramayf.a != null)
      a(paramayf, paramayf.a);
    if (paramayf.b != null)
      a(paramayf, paramayf.b);
  }

  private void b(final azl paramazl, final int paramInt1, final int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = paramazl.b;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0)
      ez.m((View) localObject).b(0.0F);
    if (paramInt2 != 0)
      ez.m((View) localObject).c(0.0F);
    this.i.add(paramazl);
    localObject = ez.m((View) localObject);
    ((gt)localObject).a(d()).a(new ayh(paramazl)
    {
      public void a(View paramAnonymousView)
      {
        aye.this.h(paramazl);
      }

      public void b(View paramAnonymousView)
      {
        this.d.a(null);
        aye.this.e(paramazl);
        aye.g(aye.this).remove(paramazl);
        aye.e(aye.this);
      }

      public void c(View paramAnonymousView)
      {
        if (paramInt1 != 0)
          ez.a(paramAnonymousView, 0.0F);
        if (paramInt2 != 0)
          ez.b(paramAnonymousView, 0.0F);
      }
    }).b();
  }

  private void j()
  {
    if (!b())
      i();
  }

  private void p(final azl paramazl)
  {
    final gt localgt = ez.m(paramazl.b);
    localgt.a(f()).a(0.0F).a(new ayh(paramazl)
    {
      public void a(View paramAnonymousView)
      {
        aye.this.g(paramazl);
      }

      public void b(View paramAnonymousView)
      {
        localgt.a(null);
        ez.c(paramAnonymousView, 1.0F);
        aye.this.d(paramazl);
        aye.d(aye.this).remove(paramazl);
        aye.e(aye.this);
      }
    }).b();
    this.j.add(paramazl);
  }

  private void q(final azl paramazl)
  {
    Object localObject = paramazl.b;
    this.h.add(paramazl);
    localObject = ez.m((View) localObject);
    ((gt)localObject).a(1.0F).a(e()).a(new ayh(paramazl)
    {
      public void a(View paramAnonymousView)
      {
        aye.this.i(paramazl);
      }

      public void b(View paramAnonymousView)
      {
        this.b.a(null);
        aye.this.f(paramazl);
        aye.f(aye.this).remove(paramazl);
        aye.e(aye.this);
      }

      public void c(View paramAnonymousView)
      {
        ez.c(paramAnonymousView, 1.0F);
      }
    }).b();
  }

  public void a()
  {
    int m;
    int n;
    label25: int i1;
    if (!this.a.isEmpty())
    {
      m = 1;
      if (this.c.isEmpty())
        break label76;
      n = 1;
      if (this.d.isEmpty())
        break label82;
      i1 = 1;
      label38: if (this.b.isEmpty())
        break label88;
    }
    label76: label82: label88: for (int i2 = 1; ; i2 = 0)
    {
      if ((m != 0) || (n != 0) || (i2 != 0) || (i1 != 0))
        break label94;
      return;
      m = 0;
      break;
      n = 0;
      break label25;
      i1 = 0;
      break label38;
    }
    label94: Object localObject1 = this.a.iterator();
    while (((Iterator)localObject1).hasNext())
      p((azl)((Iterator)localObject1).next());
    this.a.clear();
    Object localObject2;
    label208: long l1;
    label282: label354: long l2;
    if (n != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.c);
      this.f.add(localObject1);
      this.c.clear();
      localObject2 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            ayg localayg = (ayg)localIterator.next();
            aye.a(aye.this, localayg.a, localayg.b, localayg.c, localayg.d, localayg.e);
          }
          this.a.clear();
          aye.a(aye.this).remove(this.a);
        }
      };
      if (m != 0)
        ez.a(((ayg) ((ArrayList) localObject1).get(0)).a.b, (Runnable) localObject2, f());
    }
    else
    {
      if (i1 != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.d);
        this.g.add(localObject1);
        this.d.clear();
        localObject2 = new Runnable()
        {
          public void run()
          {
            Iterator localIterator = this.a.iterator();
            while (localIterator.hasNext())
            {
              ayf localayf = (ayf)localIterator.next();
              aye.a(aye.this, localayf);
            }
            this.a.clear();
            aye.b(aye.this).remove(this.a);
          }
        };
        if (m == 0)
          break label415;
        ez.a(((ayf) ((ArrayList) localObject1).get(0)).a.b, (Runnable) localObject2, f());
      }
      if (i2 == 0)
        break label422;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.b);
      this.e.add(localObject1);
      this.b.clear();
      localObject2 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            azl localazl = (azl)localIterator.next();
            aye.a(aye.this, localazl);
          }
          this.a.clear();
          aye.c(aye.this).remove(this.a);
        }
      };
      if ((m == 0) && (n == 0) && (i1 == 0))
        break label442;
      if (m == 0)
        break label424;
      l1 = f();
      if (n == 0)
        break label430;
      l2 = d();
      label365: if (i1 == 0)
        break label436;
    }
    label415: label422: label424: label430: label436: for (long l3 = g(); ; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      ez.a(((azl) ((ArrayList) localObject1).get(0)).b, (Runnable) localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label208;
      ((Runnable)localObject2).run();
      break label282;
      break;
      l1 = 0L;
      break label354;
      l2 = 0L;
      break label365;
    }
    label442: ((Runnable)localObject2).run();
  }

  void a(List<azl> paramList)
  {
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      ez.m(((azl) paramList.get(m)).b).a();
      m -= 1;
    }
  }

  public boolean a(azl paramazl)
  {
    c(paramazl);
    this.a.add(paramazl);
    return true;
  }

  public boolean a(azl paramazl, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramazl.b;
    paramInt1 = (int)(paramInt1 + ez.i(paramazl.b));
    paramInt2 = (int)(paramInt2 + ez.j(paramazl.b));
    c(paramazl);
    int m = paramInt3 - paramInt1;
    int n = paramInt4 - paramInt2;
    if ((m == 0) && (n == 0))
    {
      e(paramazl);
      return false;
    }
    if (m != 0)
      ez.a(localView, -m);
    if (n != 0)
      ez.b(localView, -n);
    this.c.add(new ayg(paramazl, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }

  public boolean a(azl paramazl1, azl paramazl2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = ez.i(paramazl1.b);
    float f2 = ez.j(paramazl1.b);
    float f3 = ez.f(paramazl1.b);
    c(paramazl1);
    int m = (int)(paramInt3 - paramInt1 - f1);
    int n = (int)(paramInt4 - paramInt2 - f2);
    ez.a(paramazl1.b, f1);
    ez.b(paramazl1.b, f2);
    ez.c(paramazl1.b, f3);
    if ((paramazl2 != null) && (paramazl2.b != null))
    {
      c(paramazl2);
      ez.a(paramazl2.b, -m);
      ez.b(paramazl2.b, -n);
      ez.c(paramazl2.b, 0.0F);
    }
    this.d.add(new ayf(paramazl1, paramazl2, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }

  public boolean b()
  {
    return (!this.b.isEmpty()) || (!this.d.isEmpty()) || (!this.c.isEmpty()) || (!this.a.isEmpty()) || (!this.i.isEmpty()) || (!this.j.isEmpty()) || (!this.h.isEmpty()) || (!this.k.isEmpty()) || (!this.f.isEmpty()) || (!this.e.isEmpty()) || (!this.g.isEmpty());
  }

  public boolean b(azl paramazl)
  {
    c(paramazl);
    ez.c(paramazl.b, 0.0F);
    this.b.add(paramazl);
    return true;
  }

  public void c()
  {
    int m = this.c.size() - 1;
    Object localObject1;
    Object localObject2;
    while (m >= 0)
    {
      localObject1 = (ayg)this.c.get(m);
      localObject2 = ((ayg)localObject1).a.b;
      ez.b((View) localObject2, 0.0F);
      ez.a((View) localObject2, 0.0F);
      e(((ayg)localObject1).a);
      this.c.remove(m);
      m -= 1;
    }
    m = this.a.size() - 1;
    while (m >= 0)
    {
      d((azl)this.a.get(m));
      this.a.remove(m);
      m -= 1;
    }
    m = this.b.size() - 1;
    while (m >= 0)
    {
      localObject1 = (azl)this.b.get(m);
      ez.c(((azl) localObject1).b, 1.0F);
      f((azl)localObject1);
      this.b.remove(m);
      m -= 1;
    }
    m = this.d.size() - 1;
    while (m >= 0)
    {
      b((ayf)this.d.get(m));
      m -= 1;
    }
    this.d.clear();
    if (!b())
      return;
    m = this.f.size() - 1;
    int n;
    while (m >= 0)
    {
      localObject1 = (ArrayList)this.f.get(m);
      n = ((ArrayList)localObject1).size() - 1;
      while (n >= 0)
      {
        localObject2 = (ayg)((ArrayList)localObject1).get(n);
        View localView = ((ayg)localObject2).a.b;
        ez.b(localView, 0.0F);
        ez.a(localView, 0.0F);
        e(((ayg)localObject2).a);
        ((ArrayList)localObject1).remove(n);
        if (((ArrayList)localObject1).isEmpty())
          this.f.remove(localObject1);
        n -= 1;
      }
      m -= 1;
    }
    m = this.e.size() - 1;
    while (m >= 0)
    {
      localObject1 = (ArrayList)this.e.get(m);
      n = ((ArrayList)localObject1).size() - 1;
      while (n >= 0)
      {
        localObject2 = (azl)((ArrayList)localObject1).get(n);
        ez.c(((azl) localObject2).b, 1.0F);
        f((azl)localObject2);
        ((ArrayList)localObject1).remove(n);
        if (((ArrayList)localObject1).isEmpty())
          this.e.remove(localObject1);
        n -= 1;
      }
      m -= 1;
    }
    m = this.g.size() - 1;
    while (m >= 0)
    {
      localObject1 = (ArrayList)this.g.get(m);
      n = ((ArrayList)localObject1).size() - 1;
      while (n >= 0)
      {
        b((ayf)((ArrayList)localObject1).get(n));
        if (((ArrayList)localObject1).isEmpty())
          this.g.remove(localObject1);
        n -= 1;
      }
      m -= 1;
    }
    a(this.j);
    a(this.i);
    a(this.h);
    a(this.k);
    i();
  }

  public void c(azl paramazl)
  {
    View localView = paramazl.b;
    ez.m(localView).a();
    int m = this.c.size() - 1;
    while (m >= 0)
    {
      if (((ayg)this.c.get(m)).a == paramazl)
      {
        ez.b(localView, 0.0F);
        ez.a(localView, 0.0F);
        e(paramazl);
        this.c.remove(paramazl);
      }
      m -= 1;
    }
    a(this.d, paramazl);
    if (this.a.remove(paramazl))
    {
      ez.c(localView, 1.0F);
      d(paramazl);
    }
    if (this.b.remove(paramazl))
    {
      ez.c(localView, 1.0F);
      f(paramazl);
    }
    m = this.g.size() - 1;
    ArrayList localArrayList;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.g.get(m);
      a(localArrayList, paramazl);
      if (localArrayList.isEmpty())
        this.g.remove(localArrayList);
      m -= 1;
    }
    m = this.f.size() - 1;
    if (m >= 0)
    {
      localArrayList = (ArrayList)this.f.get(m);
      int n = localArrayList.size() - 1;
      while (true)
      {
        if (n >= 0)
        {
          if (((ayg)localArrayList.get(n)).a != paramazl)
            break label296;
          ez.b(localView, 0.0F);
          ez.a(localView, 0.0F);
          e(paramazl);
          localArrayList.remove(n);
          if (localArrayList.isEmpty())
            this.f.remove(localArrayList);
        }
        m -= 1;
        break;
        label296: n -= 1;
      }
    }
    m = this.e.size() - 1;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.e.get(m);
      if (localArrayList.remove(paramazl))
      {
        ez.c(localView, 1.0F);
        f(paramazl);
        if (localArrayList.isEmpty())
          this.e.remove(localArrayList);
      }
      m -= 1;
    }
    if ((!this.j.remove(paramazl)) || ((!this.h.remove(paramazl)) || ((!this.k.remove(paramazl)) || (this.i.remove(paramazl)))));
    j();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aye
 * JD-Core Version:    0.6.2
 */