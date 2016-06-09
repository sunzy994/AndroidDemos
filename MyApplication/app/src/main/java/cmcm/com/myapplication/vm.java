package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class vm extends View
{
  private final WindowManager a;
  private final LayoutParams b;
  private boolean c = false;
  private int d;
  private int e;
  private boolean f;
  private boolean g;
  private boolean h;
  private vn i;
  private final Set<WeakReference<vo>> j = Collections.synchronizedSet(new HashSet(1));
  private final int k;
  private boolean l = true;

  public vm(Context paramContext)
  {
    super(paramContext);
    this.a = ((WindowManager)paramContext.getSystemService("window"));
    int m = 24;
    if (Build.VERSION.SDK_INT >= 11)
      m = 131096;
    this.b = new LayoutParams(0, -1, 2002, m, -2);
    this.b.x = 0;
    this.b.gravity = 51;
    this.k = asq.a(100.0F);
    a(paramContext);
    paramContext = alx.getInstance();
    if (paramContext != null)
      b(paramContext);
  }

  private void a(Context paramContext)
  {
    this.d = getContext().getResources().getDisplayMetrics().heightPixels;
  }

  private void a(boolean paramBoolean)
  {
    vj.n = paramBoolean;
    if (paramBoolean == this.g);
    do
    {
      return;
      this.g = paramBoolean;
    }
    while (this.i == null);
    this.i.a(paramBoolean);
  }

  private void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean == this.h)
      return;
    this.h = paramBoolean;
    while (true)
    {
      WeakReference localWeakReference;
      synchronized (this.j)
      {
        Iterator localIterator = this.j.iterator();
        if (!localIterator.hasNext())
          break;
        localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference == null) || (localWeakReference.get() == null))
          localIterator.remove();
      }
      try
      {
        ((vo)localWeakReference.get()).a(paramBoolean, paramInt);
      }
      catch (Throwable localThrowable)
      {
        localObject.remove();
      }
    }
  }

  private void h()
  {
    int m = this.b.flags;
    LayoutParams localLayoutParams;
    if (i())
    {
      localLayoutParams = this.b;
      localLayoutParams.flags |= 131072;
    }
    while (true)
    {
      if (m != this.b.flags);
      try
      {
        this.a.updateViewLayout(this, this.b);
        return;
        localLayoutParams = this.b;
        localLayoutParams.flags &= -131073;
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  private boolean i()
  {
    synchronized (this.j)
    {
      Iterator localIterator = this.j.iterator();
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null))
          return true;
        localIterator.remove();
      }
    }
    return false;
  }

  public void a(vo paramvo)
  {
    this.j.remove(new ark(paramvo));
    h();
  }

  public boolean a()
  {
    return this.c;
  }

  public void b()
  {
    if ((this.b.flags & 0x20000) == 0)
      return;
    LayoutParams localLayoutParams = this.b;
    localLayoutParams.flags &= -131073;
    try
    {
      this.a.updateViewLayout(this, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void b(vo paramvo)
  {
    this.j.add(new ark(paramvo));
    h();
  }

  public void c()
  {
    if ((this.b.flags & 0x20000) == 131072)
      return;
    LayoutParams localLayoutParams = this.b;
    localLayoutParams.flags |= 131072;
    try
    {
      this.a.updateViewLayout(this, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void d()
  {
    if (this.c)
      return;
    try
    {
      this.a.addView(this, this.b);
      this.c = true;
      return;
    }
    catch (Exception localException)
    {
      asp.b("Swipe.KeyboardMonitor", "failed to add view", localException);
    }
  }

  public void e()
  {
    if (!this.c)
      return;
    try
    {
      this.a.removeView(this);
      this.c = false;
      return;
    }
    catch (Exception localException)
    {
      asp.b("Swipe.KeyboardMonitor", "failed to remove view", localException);
    }
  }

  public boolean f()
  {
    return this.h;
  }

  public boolean g()
  {
    return (this.i != null) || (i());
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.e != paramConfiguration.orientation);
    for (boolean bool = true; ; bool = false)
    {
      this.f = bool;
      this.e = paramConfiguration.orientation;
      a(getContext());
      return;
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    boolean bool;
    if (paramInt2 == this.d)
    {
      bool = true;
      a(bool);
      if (this.l)
        break label80;
      if (!this.f)
        break label52;
      this.f = false;
    }
    while (true)
    {
      return;
      bool = false;
      break;
      label52: paramInt1 = Math.abs(paramInt2 - paramInt4);
      if (paramInt1 > this.k)
      {
        if (paramInt2 <= paramInt4)
          break label93;
        a(false, paramInt1);
      }
      label80: 
      while (this.l)
      {
        this.l = false;
        return;
        label93: a(true, paramInt1);
      }
    }
  }

  public void setOnFullScreenChangedListener(vn paramvn)
  {
    this.i = paramvn;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vm
 * JD-Core Version:    0.6.2
 */