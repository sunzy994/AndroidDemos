package cmcm.com.myapplication;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class k
  implements ComponentCallbacks, OnCreateContextMenuListener
{
  static final Object a = new Object();
  private static final df<String, Class<?>> aa = new df();
  boolean A;
  public boolean B;
  public boolean C;
  boolean D;
  boolean E;
  boolean F = true;
  boolean G;
  int H;
  ViewGroup I;
  View J;
  View K;
  boolean L;
  boolean M = true;
  ae N;
  boolean O;
  boolean P;
  Object Q = null;
  Object R = a;
  Object S = null;
  Object T = a;
  Object U = null;
  Object V = a;
  Boolean W;
  Boolean X;
  cc Y = null;
  cc Z = null;
  int b = 0;
  View c;
  int d;
  public Bundle e;
  SparseArray<Parcelable> f;
  public int g = -1;
  String h;
  public Bundle i;
  k j;
  int k = -1;
  int l;
  boolean m;
  boolean n;
  boolean o;
  public boolean p;
  boolean q;
  public boolean r;
  int s;
  public u t;
  r u;
  u v;
  k w;
  public int x;
  public int y;
  public String z;

  public static k a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }

  public static k a(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass2 = (Class)aa.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        aa.put(paramString, localClass1);
      }
      paramContext = (k)localClass1.newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.i = paramBundle;
      }
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new l("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new l("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
    }
    throw new l("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", paramContext);
  }

  static boolean b(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)aa.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        aa.put(paramString, localClass1);
      }
      boolean bool = k.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
    }
    return false;
  }

  void A()
  {
    this.v = new u();
    this.v.a(this.u, new p()
    {
      public View a(int paramAnonymousInt)
      {
        if (k.this.J == null)
          throw new IllegalStateException("Fragment does not have a view");
        return k.this.J.findViewById(paramAnonymousInt);
      }

      public boolean a()
      {
        return k.this.J != null;
      }
    }
    , this);
  }

  void B()
  {
    if (this.v != null)
    {
      this.v.i();
      this.v.e();
    }
    this.G = false;
    j();
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onStart()");
    if (this.v != null)
      this.v.l();
    if (this.N != null)
      this.N.g();
  }

  void C()
  {
    if (this.v != null)
    {
      this.v.i();
      this.v.e();
    }
    this.G = false;
    k();
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onResume()");
    if (this.v != null)
    {
      this.v.m();
      this.v.e();
    }
  }

  void D()
  {
    onLowMemory();
    if (this.v != null)
      this.v.s();
  }

  void E()
  {
    if (this.v != null)
      this.v.n();
    this.G = false;
    l();
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onPause()");
  }

  void F()
  {
    if (this.v != null)
      this.v.o();
    this.G = false;
    m();
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onStop()");
  }

  void G()
  {
    if (this.v != null)
      this.v.p();
    if (this.O)
    {
      this.O = false;
      if (!this.P)
      {
        this.P = true;
        this.N = this.u.a(this.h, this.O, false);
      }
      if (this.N != null)
      {
        if (!this.u.j())
          break label83;
        this.N.d();
      }
    }
    return;
    label83: this.N.c();
  }

  void H()
  {
    if (this.v != null)
      this.v.q();
    this.G = false;
    n();
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onDestroyView()");
    if (this.N != null)
      this.N.f();
  }

  void I()
  {
    if (this.v != null)
      this.v.r();
    this.G = false;
    o();
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onDestroy()");
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }

  public Animation a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public final void a(int paramInt, k paramk)
  {
    this.g = paramInt;
    if (paramk != null)
    {
      this.h = (paramk.h + ":" + this.g);
      return;
    }
    this.h = ("android:fragment:" + this.g);
  }

  @Deprecated
  public void a(Activity paramActivity)
  {
    this.G = true;
  }

  @Deprecated
  public void a(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.G = true;
  }

  public void a(Context paramContext)
  {
    this.G = true;
    if (this.u == null);
    for (paramContext = null; ; paramContext = this.u.f())
    {
      if (paramContext != null)
      {
        this.G = false;
        a(paramContext);
      }
      return;
    }
  }

  public void a(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.G = true;
    if (this.u == null);
    for (paramContext = null; ; paramContext = this.u.f())
    {
      if (paramContext != null)
      {
        this.G = false;
        a(paramContext, paramAttributeSet, paramBundle);
      }
      return;
    }
  }

  void a(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.v != null)
      this.v.a(paramConfiguration);
  }

  final void a(Bundle paramBundle)
  {
    if (this.f != null)
    {
      this.K.restoreHierarchyState(this.f);
      this.f = null;
    }
    this.G = false;
    e(paramBundle);
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onViewStateRestored()");
  }

  public void a(Menu paramMenu)
  {
  }

  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
  }

  public void a(View paramView, Bundle paramBundle)
  {
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.x));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.y));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.z);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.b);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.g);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.h);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.s);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.m);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.n);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.p);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.q);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.A);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.B);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.F);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.E);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.C);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.D);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.M);
    if (this.t != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.t);
    }
    if (this.u != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.u);
    }
    if (this.w != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.w);
    }
    if (this.i != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.i);
    }
    if (this.e != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.e);
    }
    if (this.f != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.f);
    }
    if (this.j != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.j);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.l);
    }
    if (this.H != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(this.H);
    }
    if (this.I != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.I);
    }
    if (this.J != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.J);
    }
    if (this.K != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.J);
    }
    if (this.c != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(this.c);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(this.d);
    }
    if (this.N != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.N.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.v != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.v + ":");
      this.v.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }

  public void a(boolean paramBoolean)
  {
  }

  final boolean a()
  {
    return this.s > 0;
  }

  public boolean a(MenuItem paramMenuItem)
  {
    return false;
  }

  public final Bundle b()
  {
    return this.i;
  }

  public LayoutInflater b(Bundle paramBundle)
  {
    paramBundle = this.u.b();
    f();
    dw.a(paramBundle, this.v.t());
    return paramBundle;
  }

  View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.v != null)
      this.v.i();
    return a(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  public void b(Menu paramMenu)
  {
  }

  public void b(boolean paramBoolean)
  {
    if (this.F != paramBoolean)
    {
      this.F = paramBoolean;
      if ((this.E) && (g()) && (!h()))
        this.u.c();
    }
  }

  boolean b(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.A)
    {
      boolean bool1 = bool3;
      if (this.E)
      {
        bool1 = bool3;
        if (this.F)
        {
          bool1 = true;
          a(paramMenu, paramMenuInflater);
        }
      }
      bool2 = bool1;
      if (this.v != null)
        bool2 = bool1 | this.v.a(paramMenu, paramMenuInflater);
    }
    return bool2;
  }

  public boolean b(MenuItem paramMenuItem)
  {
    return false;
  }

  public Context c()
  {
    if (this.u == null)
      return null;
    return this.u.g();
  }

  public void c(Bundle paramBundle)
  {
    this.G = true;
  }

  public void c(boolean paramBoolean)
  {
    if ((!this.M) && (paramBoolean) && (this.b < 4))
      this.t.a(this);
    this.M = paramBoolean;
    if (!paramBoolean);
    for (paramBoolean = true; ; paramBoolean = false)
    {
      this.L = paramBoolean;
      return;
    }
  }

  boolean c(Menu paramMenu)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.A)
    {
      boolean bool1 = bool3;
      if (this.E)
      {
        bool1 = bool3;
        if (this.F)
        {
          bool1 = true;
          a(paramMenu);
        }
      }
      bool2 = bool1;
      if (this.v != null)
        bool2 = bool1 | this.v.a(paramMenu);
    }
    return bool2;
  }

  boolean c(MenuItem paramMenuItem)
  {
    if (!this.A)
    {
      if ((this.E) && (this.F) && (a(paramMenuItem)));
      while ((this.v != null) && (this.v.a(paramMenuItem)))
        return true;
    }
    return false;
  }

  public final m d()
  {
    if (this.u == null)
      return null;
    return (m)this.u.f();
  }

  public void d(Bundle paramBundle)
  {
    this.G = true;
  }

  void d(Menu paramMenu)
  {
    if (!this.A)
    {
      if ((this.E) && (this.F))
        b(paramMenu);
      if (this.v != null)
        this.v.b(paramMenu);
    }
  }

  boolean d(MenuItem paramMenuItem)
  {
    if (!this.A)
    {
      if (b(paramMenuItem));
      while ((this.v != null) && (this.v.b(paramMenuItem)))
        return true;
    }
    return false;
  }

  public final Resources e()
  {
    if (this.u == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    return this.u.g().getResources();
  }

  public void e(Bundle paramBundle)
  {
    this.G = true;
  }

  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }

  public final s f()
  {
    if (this.v == null)
    {
      A();
      if (this.b < 5)
        break label31;
      this.v.m();
    }
    while (true)
    {
      return this.v;
      label31: if (this.b >= 4)
        this.v.l();
      else if (this.b >= 2)
        this.v.k();
      else if (this.b >= 1)
        this.v.j();
    }
  }

  public void f(Bundle paramBundle)
  {
  }

  void g(Bundle paramBundle)
  {
    if (this.v != null)
      this.v.i();
    this.G = false;
    c(paramBundle);
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onCreate()");
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.v == null)
          A();
        this.v.a(paramBundle, null);
        this.v.j();
      }
    }
  }

  public final boolean g()
  {
    return (this.u != null) && (this.m);
  }

  void h(Bundle paramBundle)
  {
    if (this.v != null)
      this.v.i();
    this.G = false;
    d(paramBundle);
    if (!this.G)
      throw new cd("Fragment " + this + " did not call through to super.onActivityCreated()");
    if (this.v != null)
      this.v.k();
  }

  public final boolean h()
  {
    return this.A;
  }

  public final int hashCode()
  {
    return super.hashCode();
  }

  public View i()
  {
    return this.J;
  }

  void i(Bundle paramBundle)
  {
    f(paramBundle);
    if (this.v != null)
    {
      Parcelable localParcelable = this.v.h();
      if (localParcelable != null)
        paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }

  public void j()
  {
    this.G = true;
    if (!this.O)
    {
      this.O = true;
      if (!this.P)
      {
        this.P = true;
        this.N = this.u.a(this.h, this.O, false);
      }
      if (this.N != null)
        this.N.b();
    }
  }

  public void k()
  {
    this.G = true;
  }

  public void l()
  {
    this.G = true;
  }

  public void m()
  {
    this.G = true;
  }

  public void n()
  {
    this.G = true;
  }

  public void o()
  {
    this.G = true;
    if (!this.P)
    {
      this.P = true;
      this.N = this.u.a(this.h, this.O, false);
    }
    if (this.N != null)
      this.N.h();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.G = true;
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenuInfo paramContextMenuInfo)
  {
    d().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onLowMemory()
  {
    this.G = true;
  }

  void p()
  {
    this.g = -1;
    this.h = null;
    this.m = false;
    this.n = false;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = false;
    this.s = 0;
    this.t = null;
    this.v = null;
    this.u = null;
    this.x = 0;
    this.y = 0;
    this.z = null;
    this.A = false;
    this.B = false;
    this.D = false;
    this.N = null;
    this.O = false;
    this.P = false;
  }

  public void q()
  {
    this.G = true;
  }

  public void r()
  {
  }

  public Object s()
  {
    return this.Q;
  }

  public Object t()
  {
    if (this.R == a)
      return s();
    return this.R;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    cs.a(this, localStringBuilder);
    if (this.g >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.g);
    }
    if (this.x != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.x));
    }
    if (this.z != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.z);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  public Object u()
  {
    return this.S;
  }

  public Object v()
  {
    if (this.T == a)
      return u();
    return this.T;
  }

  public Object w()
  {
    return this.U;
  }

  public Object x()
  {
    if (this.V == a)
      return w();
    return this.V;
  }

  public boolean y()
  {
    if (this.X == null)
      return true;
    return this.X.booleanValue();
  }

  public boolean z()
  {
    if (this.W == null)
      return true;
    return this.W.booleanValue();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     k
 * JD-Core Version:    0.6.2
 */