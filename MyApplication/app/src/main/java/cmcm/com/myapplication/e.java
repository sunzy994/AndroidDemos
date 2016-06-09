package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseArray<Lk;>;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public final class e extends y
  implements Runnable
{
  static final boolean a;
  final u b;
  public f c;
  f d;
  public int e;
  int f;
  int g;
  int h;
  int i;
  public int j;
  public int k;
  public boolean l;
  boolean m = true;
  public String n;
  boolean o;
  public int p = -1;
  public int q;
  public CharSequence r;
  public int s;
  public CharSequence t;
  public ArrayList<String> u;
  public ArrayList<String> v;

  static
  {
    if (Build.VERSION.SDK_INT >= 21);
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      return;
    }
  }

  public e(u paramu)
  {
    this.b = paramu;
  }

  private cq<String, View> a(g paramg, k paramk, boolean paramBoolean)
  {
    cq localcq2 = new cq();
    cq localcq1 = localcq2;
    if (this.u != null)
    {
      z.a(localcq2, paramk.i());
      if (!paramBoolean)
        break label82;
      localcq2.a(this.v);
    }
    label82: for (localcq1 = localcq2; paramBoolean; localcq1 = a(this.u, this.v, localcq2))
    {
      if (paramk.Y != null)
        paramk.Y.a(this.v, localcq1);
      a(paramg, localcq1, false);
      return localcq1;
    }
    if (paramk.Z != null)
      paramk.Z.a(this.v, localcq1);
    b(paramg, localcq1, false);
    return localcq1;
  }

  private cq<String, View> a(g paramg, boolean paramBoolean, k paramk)
  {
    cq localcq = b(paramg, paramk, paramBoolean);
    if (paramBoolean)
    {
      if (paramk.Z != null)
        paramk.Z.a(this.v, localcq);
      a(paramg, localcq, true);
      return localcq;
    }
    if (paramk.Y != null)
      paramk.Y.a(this.v, localcq);
    b(paramg, localcq, true);
    return localcq;
  }

  private static cq<String, View> a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, cq<String, View> paramcq)
  {
    if (paramcq.isEmpty())
      return paramcq;
    cq localcq = new cq();
    int i2 = paramArrayList1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = (View)paramcq.get(paramArrayList1.get(i1));
      if (localView != null)
        localcq.put(paramArrayList2.get(i1), localView);
      i1 += 1;
    }
    return localcq;
  }

  private g a(SparseArray<k> paramSparseArray1, SparseArray<k> paramSparseArray2, boolean paramBoolean)
  {
    int i5 = 0;
    g localg = new g(this);
    localg.d = new View(this.b.o.g());
    int i2 = 0;
    int i1 = 0;
    int i3 = i5;
    int i4 = i1;
    if (i2 < paramSparseArray1.size())
    {
      if (!a(paramSparseArray1.keyAt(i2), localg, paramBoolean, paramSparseArray1, paramSparseArray2))
        break label164;
      i1 = 1;
    }
    label164: 
    while (true)
    {
      i2 += 1;
      break;
      while (i3 < paramSparseArray2.size())
      {
        i2 = paramSparseArray2.keyAt(i3);
        i1 = i4;
        if (paramSparseArray1.get(i2) == null)
        {
          i1 = i4;
          if (a(i2, localg, paramBoolean, paramSparseArray1, paramSparseArray2))
            i1 = 1;
        }
        i3 += 1;
        i4 = i1;
      }
      paramSparseArray1 = localg;
      if (i4 == 0)
        paramSparseArray1 = null;
      return paramSparseArray1;
    }
  }

  private static Object a(Object paramObject, k paramk, ArrayList<View> paramArrayList, cq<String, View> paramcq, View paramView)
  {
    Object localObject = paramObject;
    if (paramObject != null)
      localObject = z.a(paramObject, paramk.i(), paramArrayList, paramcq, paramView);
    return localObject;
  }

  private static Object a(k paramk1, k paramk2, boolean paramBoolean)
  {
    if ((paramk1 == null) || (paramk2 == null))
      return null;
    if (paramBoolean);
    for (paramk1 = paramk2.x(); ; paramk1 = paramk1.w())
      return z.b(paramk1);
  }

  private static Object a(k paramk, boolean paramBoolean)
  {
    if (paramk == null)
      return null;
    if (paramBoolean);
    for (paramk = paramk.v(); ; paramk = paramk.s())
      return z.a(paramk);
  }

  private void a(int paramInt1, k paramk, String paramString, int paramInt2)
  {
    paramk.t = this.b;
    if (paramString != null)
    {
      if ((paramk.z != null) && (!paramString.equals(paramk.z)))
        throw new IllegalStateException("Can't change tag of fragment " + paramk + ": was " + paramk.z + " now " + paramString);
      paramk.z = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((paramk.x != 0) && (paramk.x != paramInt1))
        throw new IllegalStateException("Can't change container ID of fragment " + paramk + ": was " + paramk.x + " now " + paramInt1);
      paramk.x = paramInt1;
      paramk.y = paramInt1;
    }
    paramString = new f();
    paramString.c = paramInt2;
    paramString.d = paramk;
    a(paramString);
  }

  private static void a(SparseArray<k> paramSparseArray, k paramk)
  {
    if (paramk != null)
    {
      int i1 = paramk.y;
      if ((i1 != 0) && (!paramk.h()) && (paramk.g()) && (paramk.i() != null) && (paramSparseArray.get(i1) == null))
        paramSparseArray.put(i1, paramk);
    }
  }

  private void a(final View paramView, final g paramg, final int paramInt, final Object paramObject)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        paramView.getViewTreeObserver().removeOnPreDrawListener(this);
        e.a(e.this, paramg, paramInt, paramObject);
        return true;
      }
    });
  }

  private void a(cq<String, View> paramcq, g paramg)
  {
    if ((this.v != null) && (!paramcq.isEmpty()))
    {
      paramcq = (View)paramcq.get(this.v.get(0));
      if (paramcq != null)
        paramg.c.a = paramcq;
    }
  }

  private static void a(cq<String, String> paramcq, String paramString1, String paramString2)
  {
    int i1;
    if ((paramString1 != null) && (paramString2 != null))
      i1 = 0;
    while (i1 < paramcq.size())
    {
      if (paramString1.equals(paramcq.c(i1)))
      {
        paramcq.a(i1, paramString2);
        return;
      }
      i1 += 1;
    }
    paramcq.put(paramString1, paramString2);
  }

  private void a(g paramg, int paramInt, Object paramObject)
  {
    if (this.b.g != null)
    {
      int i1 = 0;
      if (i1 < this.b.g.size())
      {
        k localk = (k)this.b.g.get(i1);
        if ((localk.J != null) && (localk.I != null) && (localk.y == paramInt))
        {
          if (!localk.A)
            break label125;
          if (!paramg.b.contains(localk.J))
          {
            z.a(paramObject, localk.J, true);
            paramg.b.add(localk.J);
          }
        }
        while (true)
        {
          i1 += 1;
          break;
          label125: z.a(paramObject, localk.J, false);
          paramg.b.remove(localk.J);
        }
      }
    }
  }

  private void a(final g paramg, final View paramView, final Object paramObject, final k paramk1, final k paramk2, final boolean paramBoolean, final ArrayList<View> paramArrayList)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        paramView.getViewTreeObserver().removeOnPreDrawListener(this);
        if (paramObject != null)
        {
          z.a(paramObject, paramArrayList);
          paramArrayList.clear();
          cq localcq = e.a(e.this, paramg, paramBoolean, paramk1);
          z.a(paramObject, paramg.d, localcq, paramArrayList);
          e.a(e.this, localcq, paramg);
          e.a(e.this, paramg, paramk1, paramk2, paramBoolean, localcq);
        }
        return true;
      }
    });
  }

  private void a(g paramg, cq<String, View> paramcq, boolean paramBoolean)
  {
    int i1;
    int i2;
    label13: String str;
    Object localObject;
    if (this.v == null)
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1)
        return;
      str = (String)this.u.get(i2);
      localObject = (View)paramcq.get((String)this.v.get(i2));
      if (localObject != null)
      {
        localObject = z.a((View)localObject);
        if (!paramBoolean)
          break label103;
        a(paramg.a, str, (String)localObject);
      }
    }
    while (true)
    {
      i2 += 1;
      break label13;
      i1 = this.v.size();
      break;
      label103: a(paramg.a, (String)localObject, str);
    }
  }

  private static void a(g paramg, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      int i1 = 0;
      while (i1 < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i1);
        String str2 = (String)paramArrayList2.get(i1);
        a(paramg.a, str1, str2);
        i1 += 1;
      }
    }
  }

  private void a(g paramg, k paramk1, k paramk2, boolean paramBoolean, cq<String, View> paramcq)
  {
    if (paramBoolean);
    for (paramg = paramk2.Y; ; paramg = paramk1.Y)
    {
      if (paramg != null)
        paramg.b(new ArrayList(paramcq.keySet()), new ArrayList(paramcq.values()), null);
      return;
    }
  }

  private boolean a(int paramInt, g paramg, boolean paramBoolean, SparseArray<k> paramSparseArray1, SparseArray<k> paramSparseArray2)
  {
    ViewGroup localViewGroup = (ViewGroup)this.b.p.a(paramInt);
    if (localViewGroup == null)
      return false;
    Object localObject2 = (k)paramSparseArray2.get(paramInt);
    Object localObject4 = (k)paramSparseArray1.get(paramInt);
    Object localObject3 = a((k)localObject2, paramBoolean);
    paramSparseArray2 = a((k)localObject2, (k)localObject4, paramBoolean);
    Object localObject5 = b((k)localObject4, paramBoolean);
    paramSparseArray1 = null;
    ArrayList localArrayList1 = new ArrayList();
    if (paramSparseArray2 != null)
    {
      localObject1 = a(paramg, (k)localObject4, paramBoolean);
      if (((cq)localObject1).isEmpty())
      {
        paramSparseArray1 = null;
        paramSparseArray2 = null;
        if ((localObject3 != null) || (paramSparseArray2 != null) || (localObject5 != null))
          break label208;
        return false;
      }
      if (!paramBoolean)
        break label198;
    }
    label198: for (paramSparseArray1 = ((k)localObject4).Y; ; paramSparseArray1 = ((k)localObject2).Y)
    {
      if (paramSparseArray1 != null)
        paramSparseArray1.a(new ArrayList(((cq)localObject1).keySet()), new ArrayList(((cq)localObject1).values()), null);
      a(paramg, localViewGroup, paramSparseArray2, (k)localObject2, (k)localObject4, paramBoolean, localArrayList1);
      paramSparseArray1 = (SparseArray<k>)localObject1;
      break;
    }
    label208: Object localObject1 = new ArrayList();
    localObject4 = a(localObject5, (k)localObject4, (ArrayList)localObject1, paramSparseArray1, paramg.d);
    if ((this.v != null) && (paramSparseArray1 != null))
    {
      localObject5 = (View)paramSparseArray1.get(this.v.get(0));
      if (localObject5 != null)
      {
        if (localObject4 != null)
          z.a(localObject4, (View)localObject5);
        if (paramSparseArray2 != null)
          z.a(paramSparseArray2, (View)localObject5);
      }
    }
    localObject5 = new ab()
    {
      public View a()
      {
        return this.a.i();
      }
    };
    ArrayList localArrayList2 = new ArrayList();
    cq localcq = new cq();
    boolean bool = true;
    if (localObject2 != null)
      if (!paramBoolean)
        break label462;
    label462: for (bool = ((k)localObject2).z(); ; bool = ((k)localObject2).y())
    {
      localObject2 = z.a(localObject3, localObject4, paramSparseArray2, bool);
      if (localObject2 != null)
      {
        z.a(localObject3, paramSparseArray2, localViewGroup, (ab)localObject5, paramg.d, paramg.c, paramg.a, localArrayList2, paramSparseArray1, localcq, localArrayList1);
        a(localViewGroup, paramg, paramInt, localObject2);
        z.a(localObject2, paramg.d, true);
        a(paramg, paramInt, localObject2);
        z.a(localViewGroup, localObject2);
        z.a(localViewGroup, paramg.d, localObject3, localArrayList2, localObject4, (ArrayList)localObject1, paramSparseArray2, localArrayList1, localObject2, paramg.b, localcq);
      }
      if (localObject2 == null)
        break;
      return true;
    }
    return false;
  }

  private cq<String, View> b(g paramg, k paramk, boolean paramBoolean)
  {
    cq localcq = new cq();
    paramk = paramk.i();
    paramg = localcq;
    if (paramk != null)
    {
      paramg = localcq;
      if (this.u != null)
      {
        z.a(localcq, paramk);
        if (!paramBoolean)
          break label57;
        paramg = a(this.u, this.v, localcq);
      }
    }
    return paramg;
    label57: localcq.a(this.v);
    return localcq;
  }

  private static Object b(k paramk, boolean paramBoolean)
  {
    if (paramk == null)
      return null;
    if (paramBoolean);
    for (paramk = paramk.t(); ; paramk = paramk.u())
      return z.a(paramk);
  }

  private void b(SparseArray<k> paramSparseArray1, SparseArray<k> paramSparseArray2)
  {
    if (!this.b.p.a());
    f localf;
    do
    {
      return;
      localf = this.c;
    }
    while (localf == null);
    switch (localf.c)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      localf = localf.a;
      break;
      b(paramSparseArray2, localf.d);
      continue;
      Object localObject1 = localf.d;
      Object localObject2;
      if (this.b.g != null)
      {
        int i1 = 0;
        localObject2 = localObject1;
        if (i1 < this.b.g.size())
        {
          k localk = (k)this.b.g.get(i1);
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localk.y != ((k)localObject1).y);
          }
          else
          {
            if (localk != localObject1)
              break label189;
          }
          for (localObject2 = null; ; localObject2 = localObject1)
          {
            i1 += 1;
            localObject1 = localObject2;
            break;
            label189: a(paramSparseArray1, localk);
          }
        }
      }
      else
      {
        localObject2 = localObject1;
      }
      b(paramSparseArray2, localObject2);
      continue;
      a(paramSparseArray1, localf.d);
      continue;
      a(paramSparseArray1, localf.d);
      continue;
      b(paramSparseArray2, localf.d);
      continue;
      a(paramSparseArray1, localf.d);
      continue;
      b(paramSparseArray2, localf.d);
    }
  }

  private void b(SparseArray<k> paramSparseArray, k paramk)
  {
    if (paramk != null)
    {
      int i1 = paramk.y;
      if (i1 != 0)
        paramSparseArray.put(i1, paramk);
    }
  }

  private void b(g paramg, cq<String, View> paramcq, boolean paramBoolean)
  {
    int i2 = paramcq.size();
    int i1 = 0;
    if (i1 < i2)
    {
      String str1 = (String)paramcq.b(i1);
      String str2 = z.a((View)paramcq.c(i1));
      if (paramBoolean)
        a(paramg.a, str1, str2);
      while (true)
      {
        i1 += 1;
        break;
        a(paramg.a, str2, str1);
      }
    }
  }

  public int a()
  {
    return a(true);
  }

  int a(boolean paramBoolean)
  {
    if (this.o)
      throw new IllegalStateException("commit already called");
    if (u.a)
    {
      Log.v("FragmentManager", "Commit: " + this);
      a("  ", null, new PrintWriter(new ct("FragmentManager")), null);
    }
    this.o = true;
    if (this.l);
    for (this.p = this.b.a(this); ; this.p = -1)
    {
      this.b.a(this, paramBoolean);
      return this.p;
    }
  }

  public g a(boolean paramBoolean, g paramg, SparseArray<k> paramSparseArray1, SparseArray<k> paramSparseArray2)
  {
    if (u.a)
    {
      Log.v("FragmentManager", "popFromBackStack: " + this);
      a("  ", null, new PrintWriter(new ct("FragmentManager")), null);
    }
    g localg = paramg;
    if (a)
    {
      if (paramg != null)
        break label223;
      if (paramSparseArray1.size() == 0)
      {
        localg = paramg;
        if (paramSparseArray2.size() == 0);
      }
      else
      {
        localg = a(paramSparseArray1, paramSparseArray2, true);
      }
    }
    label100: a(-1);
    int i1;
    label113: int i2;
    label121: int i3;
    if (localg != null)
    {
      i1 = 0;
      if (localg == null)
        break label257;
      i2 = 0;
      paramg = this.d;
      if (paramg == null)
        break label546;
      if (localg == null)
        break label266;
      i3 = 0;
      label138: if (localg == null)
        break label275;
    }
    label257: label266: label275: for (int i4 = 0; ; i4 = paramg.h)
      switch (paramg.c)
      {
      default:
        throw new IllegalArgumentException("Unknown cmd: " + paramg.c);
        label223: localg = paramg;
        if (paramBoolean)
          break label100;
        a(paramg, this.v, this.u);
        localg = paramg;
        break label100;
        i1 = this.k;
        break label113;
        i2 = this.j;
        break label121;
        i3 = paramg.g;
        break label138;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    paramSparseArray1 = paramg.d;
    paramSparseArray1.H = i4;
    this.b.a(paramSparseArray1, u.c(i2), i1);
    while (true)
    {
      paramg = paramg.b;
      break;
      paramSparseArray1 = paramg.d;
      if (paramSparseArray1 != null)
      {
        paramSparseArray1.H = i4;
        this.b.a(paramSparseArray1, u.c(i2), i1);
      }
      if (paramg.i != null)
      {
        i4 = 0;
        while (i4 < paramg.i.size())
        {
          paramSparseArray1 = (k)paramg.i.get(i4);
          paramSparseArray1.H = i3;
          this.b.a(paramSparseArray1, false);
          i4 += 1;
        }
        paramSparseArray1 = paramg.d;
        paramSparseArray1.H = i3;
        this.b.a(paramSparseArray1, false);
        continue;
        paramSparseArray1 = paramg.d;
        paramSparseArray1.H = i3;
        this.b.c(paramSparseArray1, u.c(i2), i1);
        continue;
        paramSparseArray1 = paramg.d;
        paramSparseArray1.H = i4;
        this.b.b(paramSparseArray1, u.c(i2), i1);
        continue;
        paramSparseArray1 = paramg.d;
        paramSparseArray1.H = i3;
        this.b.e(paramSparseArray1, u.c(i2), i1);
        continue;
        paramSparseArray1 = paramg.d;
        paramSparseArray1.H = i3;
        this.b.d(paramSparseArray1, u.c(i2), i1);
      }
    }
    label546: if (paramBoolean)
    {
      this.b.a(this.b.n, u.c(i2), i1, true);
      localg = null;
    }
    if (this.p >= 0)
    {
      this.b.b(this.p);
      this.p = -1;
    }
    return localg;
  }

  public y a(int paramInt, k paramk, String paramString)
  {
    a(paramInt, paramk, paramString, 1);
    return this;
  }

  public y a(k paramk)
  {
    f localf = new f();
    localf.c = 6;
    localf.d = paramk;
    a(localf);
    return this;
  }

  public void a(int paramInt)
  {
    if (!this.l);
    while (true)
    {
      return;
      if (u.a)
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      for (f localf = this.c; localf != null; localf = localf.a)
      {
        k localk;
        if (localf.d != null)
        {
          localk = localf.d;
          localk.s += paramInt;
          if (u.a)
            Log.v("FragmentManager", "Bump nesting of " + localf.d + " to " + localf.d.s);
        }
        if (localf.i != null)
        {
          int i1 = localf.i.size() - 1;
          while (i1 >= 0)
          {
            localk = (k)localf.i.get(i1);
            localk.s += paramInt;
            if (u.a)
              Log.v("FragmentManager", "Bump nesting of " + localk + " to " + localk.s);
            i1 -= 1;
          }
        }
      }
    }
  }

  public void a(SparseArray<k> paramSparseArray1, SparseArray<k> paramSparseArray2)
  {
    if (!this.b.p.a());
    f localf;
    do
    {
      return;
      localf = this.c;
    }
    while (localf == null);
    switch (localf.c)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      localf = localf.a;
      break;
      a(paramSparseArray1, localf.d);
      continue;
      if (localf.i != null)
      {
        int i1 = localf.i.size() - 1;
        while (i1 >= 0)
        {
          b(paramSparseArray2, (k)localf.i.get(i1));
          i1 -= 1;
        }
      }
      a(paramSparseArray1, localf.d);
      continue;
      b(paramSparseArray2, localf.d);
      continue;
      b(paramSparseArray2, localf.d);
      continue;
      a(paramSparseArray1, localf.d);
      continue;
      b(paramSparseArray2, localf.d);
      continue;
      a(paramSparseArray1, localf.d);
    }
  }

  public void a(f paramf)
  {
    if (this.c == null)
    {
      this.d = paramf;
      this.c = paramf;
    }
    while (true)
    {
      paramf.e = this.f;
      paramf.f = this.g;
      paramf.g = this.h;
      paramf.h = this.i;
      this.e += 1;
      return;
      paramf.b = this.d;
      this.d.a = paramf;
      this.d = paramf;
    }
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    a(paramString, paramPrintWriter, true);
  }

  public void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.n);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.p);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.o);
      if (this.j != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.j));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.k));
      }
      if ((this.f != 0) || (this.g != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.f));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.g));
      }
      if ((this.h != 0) || (this.i != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.h));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.i));
      }
      if ((this.q != 0) || (this.r != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.q));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.r);
      }
      if ((this.s != 0) || (this.t != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.s));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.t);
      }
    }
    if (this.c != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      f localf = this.c;
      int i1 = 0;
      while (localf != null)
      {
        String str1;
        int i2;
        switch (localf.c)
        {
        default:
          str1 = "cmd=" + localf.c;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(localf.d);
          if (paramBoolean)
          {
            if ((localf.e != 0) || (localf.f != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localf.e));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localf.f));
            }
            if ((localf.g != 0) || (localf.h != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localf.g));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localf.h));
            }
          }
          if ((localf.i == null) || (localf.i.size() <= 0))
            break label807;
          i2 = 0;
          label641: if (i2 >= localf.i.size())
            break label807;
          paramPrintWriter.print(str2);
          if (localf.i.size() == 1)
            paramPrintWriter.print("Removed: ");
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        }
        while (true)
        {
          paramPrintWriter.println(localf.i.get(i2));
          i2 += 1;
          break label641;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (i2 == 0)
            paramPrintWriter.println("Removed:");
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i2);
          paramPrintWriter.print(": ");
        }
        label807: localf = localf.a;
        i1 += 1;
      }
    }
  }

  public String b()
  {
    return this.n;
  }

  public y b(k paramk)
  {
    f localf = new f();
    localf.c = 7;
    localf.d = paramk;
    a(localf);
    return this;
  }

  public void run()
  {
    if (u.a)
      Log.v("FragmentManager", "Run: " + this);
    if ((this.l) && (this.p < 0))
      throw new IllegalStateException("addToBackStack() called after commit()");
    a(1);
    Object localObject1;
    if (a)
    {
      localObject1 = new SparseArray();
      localObject2 = new SparseArray();
      b((SparseArray)localObject1, (SparseArray)localObject2);
    }
    for (Object localObject2 = a((SparseArray)localObject1, (SparseArray)localObject2, false); ; localObject2 = null)
    {
      int i1;
      label106: int i2;
      label113: f localf;
      int i3;
      if (localObject2 != null)
      {
        i1 = 0;
        if (localObject2 == null)
          break label224;
        i2 = 0;
        localf = this.c;
        if (localf == null)
          break label700;
        if (localObject2 == null)
          break label233;
        i3 = 0;
        label129: if (localObject2 == null)
          break label242;
      }
      label224: label233: label242: for (int i4 = 0; ; i4 = localf.f)
        switch (localf.c)
        {
        default:
          throw new IllegalArgumentException("Unknown cmd: " + localf.c);
          i1 = this.k;
          break label106;
          i2 = this.j;
          break label113;
          i3 = localf.e;
          break label129;
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        }
      localObject1 = localf.d;
      ((k)localObject1).H = i3;
      this.b.a((k)localObject1, false);
      while (true)
      {
        localf = localf.a;
        break;
        localObject1 = localf.d;
        int i6 = ((k)localObject1).y;
        Object localObject3;
        if (this.b.g != null)
        {
          int i5 = 0;
          localObject3 = localObject1;
          if (i5 < this.b.g.size())
          {
            k localk = (k)this.b.g.get(i5);
            if (u.a)
              Log.v("FragmentManager", "OP_REPLACE: adding=" + localObject1 + " old=" + localk);
            localObject3 = localObject1;
            if (localk.y == i6)
            {
              if (localk != localObject1)
                break label421;
              localObject3 = null;
              localf.d = null;
            }
            while (true)
            {
              i5 += 1;
              localObject1 = localObject3;
              break;
              label421: if (localf.i == null)
                localf.i = new ArrayList();
              localf.i.add(localk);
              localk.H = i4;
              if (this.l)
              {
                localk.s += 1;
                if (u.a)
                  Log.v("FragmentManager", "Bump nesting of " + localk + " to " + localk.s);
              }
              this.b.a(localk, i2, i1);
              localObject3 = localObject1;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
        }
        if (localObject3 != null)
        {
          localObject3.H = i3;
          this.b.a(localObject3, false);
          continue;
          localObject1 = localf.d;
          ((k)localObject1).H = i4;
          this.b.a((k)localObject1, i2, i1);
          continue;
          localObject1 = localf.d;
          ((k)localObject1).H = i4;
          this.b.b((k)localObject1, i2, i1);
          continue;
          localObject1 = localf.d;
          ((k)localObject1).H = i3;
          this.b.c((k)localObject1, i2, i1);
          continue;
          localObject1 = localf.d;
          ((k)localObject1).H = i4;
          this.b.d((k)localObject1, i2, i1);
          continue;
          localObject1 = localf.d;
          ((k)localObject1).H = i3;
          this.b.e((k)localObject1, i2, i1);
        }
      }
      label700: this.b.a(this.b.n, i2, i1, true);
      if (this.l)
        this.b.b(this);
      return;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.p >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.p);
    }
    if (this.n != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.n);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     e
 * JD-Core Version:    0.6.2
 */